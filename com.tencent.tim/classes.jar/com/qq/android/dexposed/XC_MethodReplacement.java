package com.qq.android.dexposed;

public abstract class XC_MethodReplacement
  extends XC_MethodHook
{
  public static final XC_MethodReplacement DO_NOTHING = new XC_MethodReplacement.1(20000);
  
  public XC_MethodReplacement() {}
  
  public XC_MethodReplacement(int paramInt)
  {
    super(paramInt);
  }
  
  public static XC_MethodReplacement returnConstant(int paramInt, Object paramObject)
  {
    return new XC_MethodReplacement.2(paramInt, paramObject);
  }
  
  public static XC_MethodReplacement returnConstant(Object paramObject)
  {
    return returnConstant(50, paramObject);
  }
  
  protected final void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
    throws Throwable
  {}
  
  protected final void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
    throws Throwable
  {
    try
    {
      paramMethodHookParam.setResult(replaceHookedMethod(paramMethodHookParam));
      return;
    }
    catch (Throwable localThrowable)
    {
      paramMethodHookParam.setThrowable(localThrowable);
    }
  }
  
  protected abstract Object replaceHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
    throws Throwable;
  
  public abstract class XC_MethodKeepReplacement
    extends XC_MethodReplacement
  {
    public XC_MethodKeepReplacement() {}
    
    public XC_MethodKeepReplacement(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.android.dexposed.XC_MethodReplacement
 * JD-Core Version:    0.7.0.1
 */