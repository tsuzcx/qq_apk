package com.facebook.stetho.inspector.runtime;

import android.content.Context;
import android.support.annotation.Nullable;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.console.RuntimeRepl;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RhinoDetectingRuntimeReplFactory
  implements RuntimeReplFactory
{
  private final Context mContext;
  private RuntimeException mRhinoJsUnexpectedError;
  private RuntimeReplFactory mRhinoReplFactory;
  private boolean mSearchedForRhinoJs;
  
  public RhinoDetectingRuntimeReplFactory(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @Nullable
  private static RuntimeReplFactory findRhinoReplFactory(Context paramContext)
    throws RuntimeException
  {
    try
    {
      paramContext = (RuntimeReplFactory)Class.forName("com.facebook.stetho.rhino.JsRuntimeReplFactoryBuilder").getDeclaredMethod("defaultFactory", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      LogUtil.i("Error finding stetho-js-rhino, cannot enable console evaluation!");
      return null;
    }
    catch (NoSuchMethodException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
  }
  
  public RuntimeRepl newInstance()
  {
    if (!this.mSearchedForRhinoJs) {
      this.mSearchedForRhinoJs = true;
    }
    try
    {
      this.mRhinoReplFactory = findRhinoReplFactory(this.mContext);
      if (this.mRhinoReplFactory != null) {
        return this.mRhinoReplFactory.newInstance();
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        this.mRhinoJsUnexpectedError = localRuntimeException;
      }
    }
    return new RhinoDetectingRuntimeReplFactory.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.runtime.RhinoDetectingRuntimeReplFactory
 * JD-Core Version:    0.7.0.1
 */