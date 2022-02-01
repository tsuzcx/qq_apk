import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;

public class avim
{
  /* Error */
  public static com.tencent.common.app.AppInterface c(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    // Byte code:
    //   0: ldc 22
    //   2: iconst_1
    //   3: new 24	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   10: ldc 30
    //   12: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 44	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: ifnull +7 -> 33
    //   29: aload_1
    //   30: ifnonnull +13 -> 43
    //   33: ldc 22
    //   35: iconst_1
    //   36: ldc 46
    //   38: invokestatic 49	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aconst_null
    //   42: areturn
    //   43: ldc 51
    //   45: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnonnull +41 -> 91
    //   53: ldc 22
    //   55: iconst_1
    //   56: ldc 59
    //   58: invokestatic 49	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aconst_null
    //   62: areturn
    //   63: astore_3
    //   64: aload_0
    //   65: invokestatic 63	avim:getClassLoader	(Landroid/content/Context;)Ljava/lang/ClassLoader;
    //   68: astore 4
    //   70: aload 4
    //   72: ldc 51
    //   74: invokevirtual 68	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   77: astore_2
    //   78: iconst_1
    //   79: aload 4
    //   81: invokestatic 74	com/qq/jce/wup/BasicClassTypeUtil:setClassLoader	(ZLjava/lang/ClassLoader;)V
    //   84: aload_3
    //   85: invokevirtual 77	java/lang/ClassNotFoundException:printStackTrace	()V
    //   88: goto -39 -> 49
    //   91: aload_2
    //   92: iconst_2
    //   93: anewarray 53	java/lang/Class
    //   96: dup
    //   97: iconst_0
    //   98: aload_0
    //   99: invokevirtual 81	java/lang/Object:getClass	()Ljava/lang/Class;
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload_1
    //   106: invokevirtual 81	java/lang/Object:getClass	()Ljava/lang/Class;
    //   109: aastore
    //   110: invokevirtual 85	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   113: iconst_2
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_0
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_1
    //   124: aastore
    //   125: invokevirtual 91	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   128: astore_0
    //   129: aload_0
    //   130: ifnull +15 -> 145
    //   133: aload_0
    //   134: instanceof 93
    //   137: ifeq +8 -> 145
    //   140: aload_0
    //   141: checkcast 93	com/tencent/common/app/AppInterface
    //   144: areturn
    //   145: ldc 22
    //   147: iconst_1
    //   148: ldc 95
    //   150: invokestatic 49	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 77	java/lang/ClassNotFoundException:printStackTrace	()V
    //   160: goto -7 -> 153
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 96	java/lang/IllegalArgumentException:printStackTrace	()V
    //   168: goto -15 -> 153
    //   171: astore_0
    //   172: aload_0
    //   173: invokevirtual 97	java/lang/IllegalAccessException:printStackTrace	()V
    //   176: goto -23 -> 153
    //   179: astore_0
    //   180: aload_0
    //   181: invokevirtual 98	java/lang/InstantiationException:printStackTrace	()V
    //   184: goto -31 -> 153
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 99	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   192: goto -39 -> 153
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 100	java/lang/NoSuchMethodException:printStackTrace	()V
    //   200: goto -47 -> 153
    //   203: astore_0
    //   204: aload_0
    //   205: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   208: goto -55 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramBaseApplicationImpl	BaseApplicationImpl
    //   0	211	1	paramString	String
    //   48	44	2	localClass	java.lang.Class
    //   63	22	3	localClassNotFoundException	java.lang.ClassNotFoundException
    //   68	12	4	localClassLoader	ClassLoader
    // Exception table:
    //   from	to	target	type
    //   43	49	63	java/lang/ClassNotFoundException
    //   53	61	155	java/lang/ClassNotFoundException
    //   64	88	155	java/lang/ClassNotFoundException
    //   91	129	155	java/lang/ClassNotFoundException
    //   133	145	155	java/lang/ClassNotFoundException
    //   145	153	155	java/lang/ClassNotFoundException
    //   43	49	163	java/lang/IllegalArgumentException
    //   53	61	163	java/lang/IllegalArgumentException
    //   64	88	163	java/lang/IllegalArgumentException
    //   91	129	163	java/lang/IllegalArgumentException
    //   133	145	163	java/lang/IllegalArgumentException
    //   145	153	163	java/lang/IllegalArgumentException
    //   43	49	171	java/lang/IllegalAccessException
    //   53	61	171	java/lang/IllegalAccessException
    //   64	88	171	java/lang/IllegalAccessException
    //   91	129	171	java/lang/IllegalAccessException
    //   133	145	171	java/lang/IllegalAccessException
    //   145	153	171	java/lang/IllegalAccessException
    //   43	49	179	java/lang/InstantiationException
    //   53	61	179	java/lang/InstantiationException
    //   64	88	179	java/lang/InstantiationException
    //   91	129	179	java/lang/InstantiationException
    //   133	145	179	java/lang/InstantiationException
    //   145	153	179	java/lang/InstantiationException
    //   43	49	187	java/lang/reflect/InvocationTargetException
    //   53	61	187	java/lang/reflect/InvocationTargetException
    //   64	88	187	java/lang/reflect/InvocationTargetException
    //   91	129	187	java/lang/reflect/InvocationTargetException
    //   133	145	187	java/lang/reflect/InvocationTargetException
    //   145	153	187	java/lang/reflect/InvocationTargetException
    //   43	49	195	java/lang/NoSuchMethodException
    //   53	61	195	java/lang/NoSuchMethodException
    //   64	88	195	java/lang/NoSuchMethodException
    //   91	129	195	java/lang/NoSuchMethodException
    //   133	145	195	java/lang/NoSuchMethodException
    //   145	153	195	java/lang/NoSuchMethodException
    //   43	49	203	java/lang/Exception
    //   53	61	203	java/lang/Exception
    //   64	88	203	java/lang/Exception
    //   91	129	203	java/lang/Exception
    //   133	145	203	java/lang/Exception
    //   145	153	203	java/lang/Exception
  }
  
  public static void f(String paramString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label48;
      }
    }
    label48:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      anot.b((QQAppInterface)localObject, "CliOper", "", "", "DatalineClickReport", paramString, 0, paramInt, 0, "", "", "", "");
      return;
    }
  }
  
  public static ClassLoader getClassLoader(Context paramContext)
    throws Exception
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qqdataline.apk");
  }
  
  public static void uu(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("DATALINE_LOG", 4, "bigTValue:" + paramString);
    }
    f(paramString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avim
 * JD-Core Version:    0.7.0.1
 */