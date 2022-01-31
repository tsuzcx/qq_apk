import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class vun
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  private final int b;
  private final int c;
  
  public vun(String paramString, MqqHandler paramMqqHandler, int paramInt)
  {
    this(paramString, paramMqqHandler, paramInt, 2, 0);
  }
  
  public vun(String paramString, MqqHandler paramMqqHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramMqqHandler);
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  /* Error */
  private Bitmap a(String paramString, Resources paramResources)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 6
    //   11: aload 6
    //   13: astore_3
    //   14: aload 7
    //   16: astore 4
    //   18: aload 8
    //   20: astore 5
    //   22: new 45	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   29: getstatic 51	com/tencent/mobileqq/app/AppConstants:aX	Ljava/lang/String;
    //   32: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 61	java/lang/String:getBytes	()[B
    //   39: invokestatic 67	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   42: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 10
    //   50: aload 6
    //   52: astore_3
    //   53: aload 7
    //   55: astore 4
    //   57: aload 8
    //   59: astore 5
    //   61: invokestatic 77	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   64: ifeq +40 -> 104
    //   67: aload 6
    //   69: astore_3
    //   70: aload 7
    //   72: astore 4
    //   74: aload 8
    //   76: astore 5
    //   78: ldc 79
    //   80: iconst_4
    //   81: new 45	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   88: ldc 81
    //   90: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 10
    //   95: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 85	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: aload 6
    //   106: astore_3
    //   107: aload 7
    //   109: astore 4
    //   111: aload 8
    //   113: astore 5
    //   115: new 87	java/io/File
    //   118: dup
    //   119: aload 10
    //   121: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: astore 9
    //   126: aload 6
    //   128: astore_3
    //   129: aload 7
    //   131: astore 4
    //   133: aload 8
    //   135: astore 5
    //   137: aload 9
    //   139: invokevirtual 93	java/io/File:exists	()Z
    //   142: ifne +80 -> 222
    //   145: aload 6
    //   147: astore_3
    //   148: aload 7
    //   150: astore 4
    //   152: aload 8
    //   154: astore 5
    //   156: aload_1
    //   157: aload_2
    //   158: aload_0
    //   159: getfield 25	vun:jdField_a_of_type_Int	I
    //   162: iconst_0
    //   163: iconst_1
    //   164: invokestatic 98	com/tencent/mobileqq/troopshare/TroopShareUtility:a	(Ljava/lang/String;Landroid/content/res/Resources;IIZ)Landroid/graphics/Bitmap;
    //   167: astore_2
    //   168: aload_2
    //   169: astore_3
    //   170: aload_2
    //   171: astore 4
    //   173: aload_2
    //   174: astore 5
    //   176: aload_2
    //   177: aload 9
    //   179: invokestatic 103	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Z
    //   182: pop
    //   183: aload_2
    //   184: astore_1
    //   185: aload_2
    //   186: astore_3
    //   187: aload_2
    //   188: astore 4
    //   190: aload_2
    //   191: astore 5
    //   193: aload_0
    //   194: getfield 34	vun:b	I
    //   197: iconst_1
    //   198: if_icmpne +20 -> 218
    //   201: aload_2
    //   202: astore_3
    //   203: aload_2
    //   204: astore 4
    //   206: aload_2
    //   207: astore 5
    //   209: aload_2
    //   210: aload_0
    //   211: getfield 36	vun:c	I
    //   214: invokestatic 106	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   217: astore_1
    //   218: aload_0
    //   219: monitorexit
    //   220: aload_1
    //   221: areturn
    //   222: aload 6
    //   224: astore_3
    //   225: aload 7
    //   227: astore 4
    //   229: aload 8
    //   231: astore 5
    //   233: aload 10
    //   235: invokestatic 112	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   238: astore_2
    //   239: aload_2
    //   240: astore_1
    //   241: aload_2
    //   242: astore_3
    //   243: aload_2
    //   244: astore 4
    //   246: aload_2
    //   247: astore 5
    //   249: aload_0
    //   250: getfield 34	vun:b	I
    //   253: iconst_1
    //   254: if_icmpne -36 -> 218
    //   257: aload_2
    //   258: astore_3
    //   259: aload_2
    //   260: astore 4
    //   262: aload_2
    //   263: astore 5
    //   265: aload_2
    //   266: aload_0
    //   267: getfield 36	vun:c	I
    //   270: invokestatic 106	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   273: astore_1
    //   274: goto -56 -> 218
    //   277: astore_2
    //   278: aload_3
    //   279: astore_1
    //   280: invokestatic 77	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   283: ifeq -65 -> 218
    //   286: aload_2
    //   287: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   290: aload_3
    //   291: astore_1
    //   292: goto -74 -> 218
    //   295: astore_1
    //   296: aload_0
    //   297: monitorexit
    //   298: aload_1
    //   299: athrow
    //   300: astore_2
    //   301: aload 4
    //   303: astore_1
    //   304: invokestatic 77	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   307: ifeq -89 -> 218
    //   310: aload_2
    //   311: invokevirtual 116	java/lang/Error:printStackTrace	()V
    //   314: aload 4
    //   316: astore_1
    //   317: goto -99 -> 218
    //   320: astore_1
    //   321: aload 5
    //   323: astore_1
    //   324: goto -106 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	vun
    //   0	327	1	paramString	String
    //   0	327	2	paramResources	Resources
    //   13	278	3	localObject1	Object
    //   16	299	4	localObject2	Object
    //   20	302	5	localObject3	Object
    //   9	214	6	localObject4	Object
    //   3	223	7	localObject5	Object
    //   6	224	8	localObject6	Object
    //   124	54	9	localFile	java.io.File
    //   48	186	10	str	String
    // Exception table:
    //   from	to	target	type
    //   22	50	277	java/lang/Exception
    //   61	67	277	java/lang/Exception
    //   78	104	277	java/lang/Exception
    //   115	126	277	java/lang/Exception
    //   137	145	277	java/lang/Exception
    //   156	168	277	java/lang/Exception
    //   176	183	277	java/lang/Exception
    //   193	201	277	java/lang/Exception
    //   209	218	277	java/lang/Exception
    //   233	239	277	java/lang/Exception
    //   249	257	277	java/lang/Exception
    //   265	274	277	java/lang/Exception
    //   22	50	295	finally
    //   61	67	295	finally
    //   78	104	295	finally
    //   115	126	295	finally
    //   137	145	295	finally
    //   156	168	295	finally
    //   176	183	295	finally
    //   193	201	295	finally
    //   209	218	295	finally
    //   233	239	295	finally
    //   249	257	295	finally
    //   265	274	295	finally
    //   280	290	295	finally
    //   304	314	295	finally
    //   22	50	300	java/lang/Error
    //   61	67	300	java/lang/Error
    //   78	104	300	java/lang/Error
    //   115	126	300	java/lang/Error
    //   137	145	300	java/lang/Error
    //   156	168	300	java/lang/Error
    //   176	183	300	java/lang/Error
    //   193	201	300	java/lang/Error
    //   209	218	300	java/lang/Error
    //   233	239	300	java/lang/Error
    //   249	257	300	java/lang/Error
    //   265	274	300	java/lang/Error
    //   22	50	320	java/lang/OutOfMemoryError
    //   61	67	320	java/lang/OutOfMemoryError
    //   78	104	320	java/lang/OutOfMemoryError
    //   115	126	320	java/lang/OutOfMemoryError
    //   137	145	320	java/lang/OutOfMemoryError
    //   156	168	320	java/lang/OutOfMemoryError
    //   176	183	320	java/lang/OutOfMemoryError
    //   193	201	320	java/lang/OutOfMemoryError
    //   209	218	320	java/lang/OutOfMemoryError
    //   233	239	320	java/lang/OutOfMemoryError
    //   249	257	320	java/lang/OutOfMemoryError
    //   265	274	320	java/lang/OutOfMemoryError
  }
  
  public void run()
  {
    Object localObject1 = BaseApplicationImpl.getContext().getResources();
    Object localObject2 = a(this.jdField_a_of_type_JavaLangString, (Resources)localObject1);
    if (localObject2 != null) {}
    for (localObject1 = new BitmapDrawable((Resources)localObject1, (Bitmap)localObject2);; localObject1 = null)
    {
      localObject2 = (MqqHandler)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localObject2 != null) {
        ((MqqHandler)localObject2).obtainMessage(34, this.b, 0, localObject1).sendToTarget();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vun
 * JD-Core Version:    0.7.0.1
 */