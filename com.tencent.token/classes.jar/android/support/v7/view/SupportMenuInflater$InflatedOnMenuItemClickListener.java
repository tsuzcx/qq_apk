package android.support.v7.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

class SupportMenuInflater$InflatedOnMenuItemClickListener
  implements MenuItem.OnMenuItemClickListener
{
  private static final Class[] PARAM_TYPES = { MenuItem.class };
  private Method mMethod;
  private Object mRealOwner;
  
  public SupportMenuInflater$InflatedOnMenuItemClickListener(Object paramObject, String paramString)
  {
    this.mRealOwner = paramObject;
    Class localClass = paramObject.getClass();
    try
    {
      this.mMethod = localClass.getMethod(paramString, PARAM_TYPES);
      return;
    }
    catch (Exception paramObject)
    {
      paramString = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
      paramString.initCause(paramObject);
      throw paramString;
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    try
    {
      if (this.mMethod.getReturnType() == Boolean.TYPE) {
        return ((Boolean)this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem })).booleanValue();
      }
      this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem });
      return true;
    }
    catch (Exception paramMenuItem)
    {
      throw new RuntimeException(paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.SupportMenuInflater.InflatedOnMenuItemClickListener
 * JD-Core Version:    0.7.0.1
 */