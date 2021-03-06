package net.sf.l2j.gameserver.taskmanager;

import net.sf.l2j.Config;
import net.sf.l2j.commons.concurrent.ThreadPool;
import net.sf.l2j.gameserver.idfactory.IdFactory;
import net.sf.l2j.gameserver.model.WorldObject;
import net.sf.l2j.gameserver.model.actor.Playable;
import net.sf.l2j.gameserver.model.item.instance.ItemInstance;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A task used to delete objects generated by the Config DEBUG_MOVEMENT.
 */
public final class DebugMovementTaskManager implements Runnable
{
	private final Map<ItemInstance, Long> _items = new ConcurrentHashMap<>();
	
	protected DebugMovementTaskManager()
	{
		ThreadPool.scheduleAtFixedRate(this, 1000, 1000);
	}
	
	@Override
	public final void run()
	{
		final long time = System.currentTimeMillis();
		
		for (Entry<ItemInstance, Long> entry : _items.entrySet())
		{
			if (time < entry.getValue())
				continue;
			
			final ItemInstance item = entry.getKey();
			
			item.decayMe();
			
			_items.remove(item);
		}
	}
	
	public final void addItem(WorldObject character, int x, int y, int z)
	{
		final int itemId = (character instanceof Playable) ? 57 : 1831;
		
		final ItemInstance item = new ItemInstance(IdFactory.getInstance().getNextId(), itemId);
		item.setCount(1);
		item.spawnMe(x, y, z + 5);
		
		_items.put(item, System.currentTimeMillis() + Config.DEBUG_MOVEMENT);
	}
	
	public static final DebugMovementTaskManager getInstance()
	{
		return SingletonHolder.INSTANCE;
	}
	
	private static class SingletonHolder
	{
		protected static final DebugMovementTaskManager INSTANCE = new DebugMovementTaskManager();
	}
}