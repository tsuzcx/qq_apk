package com.tencent.biz.pubaccount.readinjoy.featurecompute;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.Task;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskException;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;

public class JSContext
{
  private String TAG;
  private Map<String, Callback> callbackMap;
  private long ctx;
  private long jsGroup;
  public Task task;
  public Map<Integer, Timer> timerTasks;
  
  /* Error */
  public JSContext()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc 29
    //   7: putfield 31	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:TAG	Ljava/lang/String;
    //   10: aload_0
    //   11: new 33	java/util/HashMap
    //   14: dup
    //   15: invokespecial 34	java/util/HashMap:<init>	()V
    //   18: putfield 36	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:timerTasks	Ljava/util/Map;
    //   21: aload_0
    //   22: new 33	java/util/HashMap
    //   25: dup
    //   26: invokespecial 34	java/util/HashMap:<init>	()V
    //   29: putfield 38	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:callbackMap	Ljava/util/Map;
    //   32: ldc 2
    //   34: monitorenter
    //   35: aload_0
    //   36: aload_0
    //   37: invokespecial 42	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:createGroup	()J
    //   40: putfield 44	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:jsGroup	J
    //   43: aload_0
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 44	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:jsGroup	J
    //   49: invokespecial 48	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:create	(J)J
    //   52: putfield 50	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:ctx	J
    //   55: ldc 2
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: getfield 31	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:TAG	Ljava/lang/String;
    //   64: iconst_2
    //   65: new 52	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   72: ldc 55
    //   74: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: invokevirtual 63	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   81: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: new 52	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   97: ldc 55
    //   99: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 63	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   106: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 78	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:reportException	(Ljava/lang/String;)V
    //   115: goto -60 -> 55
    //   118: astore_1
    //   119: ldc 2
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: aload_0
    //   126: getfield 31	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:TAG	Ljava/lang/String;
    //   129: iconst_2
    //   130: new 52	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   137: ldc 80
    //   139: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 81	java/lang/Error:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: new 52	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   162: ldc 80
    //   164: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_1
    //   168: invokevirtual 81	java/lang/Error:getMessage	()Ljava/lang/String;
    //   171: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 78	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:reportException	(Ljava/lang/String;)V
    //   180: goto -125 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	JSContext
    //   59	44	1	localException	java.lang.Exception
    //   118	5	1	localObject	Object
    //   124	44	1	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   35	55	59	java/lang/Exception
    //   35	55	118	finally
    //   55	58	118	finally
    //   60	115	118	finally
    //   119	122	118	finally
    //   125	180	118	finally
    //   35	55	124	java/lang/Error
  }
  
  private native long create(long paramLong);
  
  private native long createGroup();
  
  private native Object evaluteStringWithException(long paramLong, String paramString, StringBuffer paramStringBuffer);
  
  private native void initRIJStrorage(long paramLong);
  
  private native void registerFunction(long paramLong, String paramString);
  
  private native void release(long paramLong1, long paramLong2);
  
  public Object evaluteStringWithException(String paramString, StringBuffer paramStringBuffer)
  {
    return evaluteStringWithException(this.ctx, paramString, paramStringBuffer);
  }
  
  public Object functionCallback(String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    Iterator localIterator = this.callbackMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(((Map.Entry)localObject).getKey()))) {
        try
        {
          localObject = ((Callback)((Map.Entry)localObject).getValue()).invoke(this, paramInt, paramArrayOfObject);
          return localObject;
        }
        catch (Throwable localThrowable)
        {
          QLog.d(this.TAG, 2, localThrowable.getMessage());
          TaskException.reportException(this.task.id, "functionCallback " + paramString + localThrowable.getMessage());
        }
      }
    }
    return null;
  }
  
  public void initRIJStorage()
  {
    initRIJStrorage(this.ctx);
  }
  
  public void registerFunction(String paramString, Callback paramCallback)
  {
    this.callbackMap.put(paramString, paramCallback);
    registerFunction(this.ctx, paramString);
  }
  
  public void release()
  {
    Iterator localIterator = this.timerTasks.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((Timer)this.timerTasks.get(localInteger)).cancel();
    }
    this.timerTasks.clear();
    release(this.jsGroup, this.ctx);
  }
  
  public static abstract interface Callback
  {
    public abstract Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
      throws Throwable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext
 * JD-Core Version:    0.7.0.1
 */