package com.qq.android.dexposed;

import com.qq.android.dexposed.callbacks.IXUnhook;
import com.qq.android.dexposed.callbacks.XCallback;
import com.qq.android.dexposed.callbacks.XCallback.Param;
import java.lang.reflect.Member;

public abstract class XC_MethodHook
  extends XCallback
{
  public XC_MethodHook() {}
  
  public XC_MethodHook(int paramInt)
  {
    super(paramInt);
  }
  
  protected void afterHookedMethod(MethodHookParam paramMethodHookParam)
    throws Throwable
  {}
  
  protected void beforeHookedMethod(MethodHookParam paramMethodHookParam)
    throws Throwable
  {}
  
  public static class MethodHookParam
    extends XCallback.Param
  {
    public Object[] args;
    public Member method;
    private Object result = null;
    boolean returnEarly = false;
    public Object thisObject;
    private Throwable throwable = null;
    
    public Object getResult()
    {
      return this.result;
    }
    
    public Object getResultOrThrowable()
      throws Throwable
    {
      if (this.throwable != null) {
        throw this.throwable;
      }
      return this.result;
    }
    
    public Throwable getThrowable()
    {
      return this.throwable;
    }
    
    public boolean hasThrowable()
    {
      return this.throwable != null;
    }
    
    public void setResult(Object paramObject)
    {
      this.result = paramObject;
      this.throwable = null;
      this.returnEarly = true;
    }
    
    public void setThrowable(Throwable paramThrowable)
    {
      this.throwable = paramThrowable;
      this.result = null;
      this.returnEarly = true;
    }
  }
  
  public class Unhook
    implements IXUnhook
  {
    private final Member hookMethod;
    
    public Unhook(Member paramMember)
    {
      this.hookMethod = paramMember;
    }
    
    public XC_MethodHook getCallback()
    {
      return XC_MethodHook.this;
    }
    
    public Member getHookedMethod()
    {
      return this.hookMethod;
    }
    
    public void unhook()
    {
      DexposedBridge.unhookMethod(this.hookMethod, XC_MethodHook.this);
    }
  }
  
  public abstract class XC_MethodKeepHook
    extends XC_MethodHook
  {
    public XC_MethodKeepHook() {}
    
    public XC_MethodKeepHook(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.android.dexposed.XC_MethodHook
 * JD-Core Version:    0.7.0.1
 */