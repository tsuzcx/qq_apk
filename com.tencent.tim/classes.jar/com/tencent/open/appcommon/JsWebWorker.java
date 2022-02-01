package com.tencent.open.appcommon;

import android.content.Context;
import android.os.Handler;
import arwt;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JsWebWorker
{
  protected static Map<String, a> oI = new HashMap();
  protected static ExecutorService t = ;
  protected Context ctx;
  protected Handler mHandler;
  protected WebView webView;
  
  protected a a(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      int i;
      try
      {
        arwt.d("JsWebWorker", "initClass " + paramString1 + " | " + paramString2 + " | " + paramString3);
        Object localObject1 = new File(paramString2);
        if (!((File)localObject1).exists())
        {
          arwt.d("JsWebWorker", "cant find file " + paramString2);
          return null;
        }
        paramString1 = new DexClassLoader(((File)localObject1).toString(), paramString1, null, this.ctx.getClassLoader());
        arwt.d("JsWebWorker", "classLoader start ");
        paramString1 = paramString1.loadClass(paramString3);
        arwt.d("JsWebWorker", "classLoader successed ");
        paramString2 = new a();
        localObject1 = paramString1.getDeclaredMethods();
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (Modifier.isPublic(localObject2.getModifiers())) {
            paramString2.oK.put(localObject2.getName(), localObject2);
          }
        }
        else
        {
          paramString2.className = paramString3;
          paramString2.clazz = paramString1;
          oI.put(paramString3, paramString2);
          return paramString2;
        }
      }
      catch (Exception paramString1)
      {
        arwt.e("JsWebWorker", "initClass error", paramString1);
        return null;
      }
      i += 1;
    }
  }
  
  protected Object a(a parama, Context paramContext, WebView paramWebView)
  {
    if (paramWebView != null) {}
    for (;;)
    {
      try
      {
        i = paramWebView.hashCode();
        Object localObject2 = parama.oJ.get(Integer.valueOf(i));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          Constructor localConstructor = parama.clazz.getConstructor(new Class[] { Context.class, WebView.class, Handler.class });
          localObject1 = localObject2;
          if (localConstructor != null)
          {
            localObject1 = localConstructor.newInstance(new Object[] { paramContext, paramWebView, this.mHandler });
            parama.oJ.put(Integer.valueOf(i), localObject1);
          }
        }
        return localObject1;
      }
      catch (Exception parama)
      {
        return null;
      }
      int i = -1000;
    }
  }
  
  protected String a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        arwt.d("JsWebWorker", "invoke>>" + paramString1 + ">>>" + paramString2 + ">>>" + paramString3);
        a locala = (a)oI.get(paramString2);
        if (locala == null)
        {
          locala = a(this.ctx.getFilesDir().getAbsolutePath(), paramString1, paramString2);
          if (locala == null)
          {
            arwt.d("JsWebWorker", "refC == NULL return");
            return null;
          }
          arwt.d("JsWebWorker", "got refC");
          if ((Method)locala.oK.get(paramString3) == null)
          {
            locala.destroy();
            if (a(this.ctx.getFilesDir().getAbsolutePath(), paramString1, paramString2) != null) {
              break;
            }
            arwt.d("JsWebWorker", "cant find method and refC == NULL return");
            break;
          }
          arwt.d("JsWebWorker", "get method");
          paramString1 = (Method)locala.oK.get(paramString3);
          if (paramString1 == null) {
            return null;
          }
          arwt.d("JsWebWorker", "got method");
          paramString2 = a(locala, this.ctx, this.webView);
          if (paramString2 == null) {
            return null;
          }
          arwt.d("JsWebWorker", "method invoke");
          paramString1 = (String)paramString1.invoke(paramString2, new Object[] { paramArrayOfString });
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        arwt.e("JsWebWorker", "invoke error", paramString1);
        return null;
      }
    }
    return null;
  }
  
  public class AsyncThread
    implements Runnable
  {
    protected String cCs;
    protected String className;
    protected String[] ir;
    protected String method;
    
    public void run()
    {
      try
      {
        this.this$0.a(this.cCs, this.className, this.method, this.ir);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public class a
  {
    public String className;
    public Class clazz;
    public Map<Integer, Object> oJ = new HashMap();
    public Map<String, Method> oK = new HashMap();
    
    protected a() {}
    
    public void destroy()
    {
      Iterator localIterator = this.oJ.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.oJ = null;
      this.oK = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.JsWebWorker
 * JD-Core Version:    0.7.0.1
 */