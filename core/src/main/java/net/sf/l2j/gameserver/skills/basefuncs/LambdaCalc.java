package net.sf.l2j.gameserver.skills.basefuncs;

import net.sf.l2j.gameserver.skills.Env;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mkizub
 */
public final class LambdaCalc extends Lambda
{
	private final List<Func> _funcs;
	
	public LambdaCalc()
	{
		_funcs = new ArrayList<>();
	}
	
	@Override
	public double calc(Env env)
	{
		double saveValue = env.getValue();
		try
		{
			env.setValue(0);
			for (Func f : _funcs)
				f.calc(env);
			
			return env.getValue();
		}
		finally
		{
			env.setValue(saveValue);
		}
	}
	
	public void addFunc(Func f)
	{
		_funcs.add(f);
	}
	
	public List<Func> getFuncs()
	{
		return _funcs;
	}
}