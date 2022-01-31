package com.tencent.kingkong.xposed;

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
      XposedBridge.unhookMethod(this.hookMethod, XC_MethodHook.this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.xposed.XC_MethodHook
 * JD-Core Version:    0.7.0.1
 */