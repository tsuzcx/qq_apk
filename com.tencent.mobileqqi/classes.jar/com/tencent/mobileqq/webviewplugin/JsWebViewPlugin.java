package com.tencent.mobileqq.webviewplugin;

import java.lang.reflect.Method;

@Deprecated
public abstract class JsWebViewPlugin
  extends WebViewPlugin
{
  protected abstract String a();
  
  protected Method a(String paramString1, String paramString2, int paramInt)
  {
    if (!a().equals(paramString1)) {}
    for (;;)
    {
      return null;
      paramString1 = getClass().getDeclaredMethods();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = paramString1[i];
        if ((localMethod.getName().equals(paramString2)) && (localMethod.getParameterTypes().length == paramInt)) {
          return localMethod;
        }
        i += 1;
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    paramString2 = a(paramString2, paramString3, paramVarArgs.length);
    if (paramString2 != null)
    {
      try
      {
        if (paramVarArgs.length == 0) {}
        for (paramString1 = paramString2.invoke(this, new Object[0]);; paramString1 = paramString2.invoke(this, paramVarArgs))
        {
          paramString2 = paramString2.getReturnType();
          if ((paramString2 != Void.TYPE) && (paramString2 != Void.class)) {
            break;
          }
          if (paramJsBridgeListener == null) {
            break label90;
          }
          paramJsBridgeListener.a(null);
          break label90;
        }
        if (paramJsBridgeListener != null) {
          paramJsBridgeListener.a(paramString1);
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        return false;
      }
      label90:
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.JsWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */