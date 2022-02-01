package com.tencent.luan.ioc.reflect;

import com.tencent.luan.ioc.AbstractProvideMethod;
import com.tencent.luan.ioc.InjectChecker;
import com.tencent.luan.ioc.InjectParam;
import java.lang.reflect.Method;

class ReflectProvideMethod<T>
  extends AbstractProvideMethod<T>
{
  private final InjectParam argParam;
  private final Method method;
  
  ReflectProvideMethod(Class<?> paramClass, Method paramMethod, InjectParam paramInjectParam1, InjectParam paramInjectParam2)
  {
    super(paramClass, paramInjectParam1, InjectChecker.checkAndGetScope(paramMethod));
    paramMethod.setAccessible(true);
    this.method = paramMethod;
    this.argParam = paramInjectParam2;
  }
  
  /* Error */
  public T newInstance(com.tencent.luan.ioc.Injector paramInjector)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/luan/ioc/reflect/ReflectProvideMethod:argParam	Lcom/tencent/luan/ioc/InjectParam;
    //   4: ifnonnull +16 -> 20
    //   7: aload_0
    //   8: getfield 28	com/tencent/luan/ioc/reflect/ReflectProvideMethod:method	Ljava/lang/reflect/Method;
    //   11: aconst_null
    //   12: iconst_0
    //   13: anewarray 39	java/lang/Object
    //   16: invokevirtual 43	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   19: areturn
    //   20: aload_0
    //   21: getfield 30	com/tencent/luan/ioc/reflect/ReflectProvideMethod:argParam	Lcom/tencent/luan/ioc/InjectParam;
    //   24: getfield 49	com/tencent/luan/ioc/InjectParam:name	Ljava/lang/String;
    //   27: invokevirtual 55	java/lang/String:isEmpty	()Z
    //   30: ifeq +34 -> 64
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 30	com/tencent/luan/ioc/reflect/ReflectProvideMethod:argParam	Lcom/tencent/luan/ioc/InjectParam;
    //   38: getfield 59	com/tencent/luan/ioc/InjectParam:type	Ljava/lang/Class;
    //   41: invokeinterface 65 2 0
    //   46: astore_1
    //   47: aload_0
    //   48: getfield 28	com/tencent/luan/ioc/reflect/ReflectProvideMethod:method	Ljava/lang/reflect/Method;
    //   51: aconst_null
    //   52: iconst_1
    //   53: anewarray 39	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload_1
    //   59: aastore
    //   60: invokevirtual 43	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   63: areturn
    //   64: aload_1
    //   65: aload_0
    //   66: getfield 30	com/tencent/luan/ioc/reflect/ReflectProvideMethod:argParam	Lcom/tencent/luan/ioc/InjectParam;
    //   69: getfield 49	com/tencent/luan/ioc/InjectParam:name	Ljava/lang/String;
    //   72: invokeinterface 68 2 0
    //   77: astore_1
    //   78: goto -31 -> 47
    //   81: astore_1
    //   82: new 70	com/tencent/luan/ioc/InjectException
    //   85: dup
    //   86: new 72	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   93: ldc 77
    //   95: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: getfield 28	com/tencent/luan/ioc/reflect/ReflectProvideMethod:method	Ljava/lang/reflect/Method;
    //   102: invokevirtual 85	java/lang/reflect/Method:getDeclaringClass	()Ljava/lang/Class;
    //   105: invokevirtual 91	java/lang/Class:getName	()Ljava/lang/String;
    //   108: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 93
    //   113: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: getfield 28	com/tencent/luan/ioc/reflect/ReflectProvideMethod:method	Ljava/lang/reflect/Method;
    //   120: invokevirtual 94	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   123: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: aload_1
    //   130: invokespecial 100	com/tencent/luan/ioc/InjectException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	ReflectProvideMethod
    //   0	134	1	paramInjector	com.tencent.luan.ioc.Injector
    // Exception table:
    //   from	to	target	type
    //   0	20	81	java/lang/Exception
    //   20	47	81	java/lang/Exception
    //   47	64	81	java/lang/Exception
    //   64	78	81	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.luan.ioc.reflect.ReflectProvideMethod
 * JD-Core Version:    0.7.0.1
 */