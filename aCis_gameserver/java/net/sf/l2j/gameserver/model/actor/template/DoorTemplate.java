/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.l2j.gameserver.model.actor.template;

import net.sf.l2j.gameserver.templates.StatsSet;

/**
 * @author Hasha
 */
public class DoorTemplate extends CharTemplate
{
	public enum DoorType
	{
		DOOR,
		WALL
	}
	
	public enum OpenType
	{
		CLICK,
		TIME,
		SKILL,
		NPC
	}
	
	private final String _name;
	private final int _id;
	private final DoorType _type;
	private final int _level;
	
	// coordinates can be part of template, since we spawn 1 instance of door at fixed position
	private final int _x;
	private final int _y;
	private final int _z;
	
	// geodata description of the door
	private final int _geoX;
	private final int _geoY;
	private final int _geoZ;
	private final byte[][] _geoData;
	
	private final int _castle;
	private final int _triggeredId;
	private final boolean _opened;
	
	private final OpenType _openType;
	private final int _openTime;
	private final int _randomTime;
	private final int _closeTime;
	
	public DoorTemplate(StatsSet stats)
	{
		super(stats);
		
		_name = stats.getString("name");
		_id = stats.getInteger("id");
		_type = stats.getEnum("type", DoorType.class);
		_level = stats.getInteger("level");
		
		_x = stats.getInteger("posX");
		_y = stats.getInteger("posY");
		_z = stats.getInteger("posZ");
		
		_geoX = stats.getInteger("geoX");
		_geoY = stats.getInteger("geoY");
		_geoZ = stats.getInteger("geoZ");
		_geoData = stats.getObject("geoData", byte[][].class);
		
		_castle = stats.getInteger("castle", 0);
		_triggeredId = stats.getInteger("triggeredId", 0);
		_opened = stats.getBool("opened", false);
		
		_openType = stats.getEnum("openType", OpenType.class, OpenType.NPC);
		_openTime = stats.getInteger("openTime", 0);
		_randomTime = stats.getInteger("randomTime", 0);
		_closeTime = stats.getInteger("closeTime", 0);
	}
	
	public final String getName()
	{
		return _name;
	}
	
	public final int getId()
	{
		return _id;
	}
	
	public final DoorType getType()
	{
		return _type;
	}
	
	public final int getLevel()
	{
		return _level;
	}
	
	public final int getPosX()
	{
		return _x;
	}
	
	public final int getPosY()
	{
		return _y;
	}
	
	public final int getPosZ()
	{
		return _z;
	}
	
	public final int getGeoX()
	{
		return _geoX;
	}
	
	public final int getGeoY()
	{
		return _geoY;
	}
	
	public final int getGeoZ()
	{
		return _geoZ;
	}
	
	public final byte[][] getGeoData()
	{
		return _geoData;
	}
	
	public final int getCastle()
	{
		return _castle;
	}
	
	public final int getTriggerId()
	{
		return _triggeredId;
	}
	
	public final boolean isOpened()
	{
		return _opened;
	}
	
	public final OpenType getOpenType()
	{
		return _openType;
	}
	
	public final int getOpenTime()
	{
		return _openTime;
	}
	
	public final int getRandomTime()
	{
		return _randomTime;
	}
	
	public final int getCloseTime()
	{
		return _closeTime;
	}
}