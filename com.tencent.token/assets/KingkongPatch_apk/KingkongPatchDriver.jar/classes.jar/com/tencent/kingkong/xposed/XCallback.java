package com.tencent.kingkong.xposed;

import android.os.Bundle;
import java.io.Serializable;

public abstract class XCallback
  implements Comparable<XCallback>
{
  public static final int PRIORITY_DEFAULT = 50;
  public static final int PRIORITY_HIGHEST = 10000;
  public static final int PRIORITY_LOWEST = -10000;
  public final int priority;
  
  public XCallback()
  {
    this.priority = 50;
  }
  
  public XCallback(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public static final void callAll(Param paramParam)
  {
    if (paramParam.callbacks == null) {
      throw new IllegalStateException("This object was not created for use with callAll");
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramParam.callbacks.length) {
        return;
      }
      try
      {
        ((XCallback)paramParam.callbacks[i]).call(paramParam);
        i += 1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          XposedBridge.log(localThrowable);
        }
      }
    }
  }
  
  protected void call(Param paramParam)
    throws Throwable
  {}
  
  public int compareTo(XCallback paramXCallback)
  {
    if (this == paramXCallback) {
      return 0;
    }
    if (paramXCallback.priority != this.priority) {
      return paramXCallback.priority - this.priority;
    }
    if (System.identityHashCode(this) < System.identityHashCode(paramXCallback)) {
      return -1;
    }
    return 1;
  }
  
  public static class Param
  {
    public final Object[] callbacks;
    private Bundle extra;
    
    protected Param()
    {
      this.callbacks = null;
    }
    
    protected Param(XposedBridge.CopyOnWriteSortedSet<? extends XCallback> paramCopyOnWriteSortedSet)
    {
      this.callbacks = paramCopyOnWriteSortedSet.getSnapshot();
    }
    
    public Bundle getExtra()
    {
      try
      {
        if (this.extra == null) {
          this.extra = new Bundle();
        }
        Bundle localBundle = this.extra;
        return localBundle;
      }
      finally {}
    }
    
    public Object getObjectExtra(String paramString)
    {
      paramString = getExtra().getSerializable(paramString);
      if ((paramString instanceof SerializeWrapper)) {
        return ((SerializeWrapper)paramString).object;
      }
      return null;
    }
    
    public void setObjectExtra(String paramString, Object paramObject)
    {
      getExtra().putSerializable(paramString, new SerializeWrapper(paramObject));
    }
    
    private static class SerializeWrapper
      implements Serializable
    {
      private static final long serialVersionUID = 1L;
      private Object object;
      
      public SerializeWrapper(Object paramObject)
      {
        this.object = paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.xposed.XCallback
 * JD-Core Version:    0.7.0.1
 */