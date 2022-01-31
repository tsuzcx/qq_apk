package com.tencent.open.base.http;

import android.graphics.Bitmap;
import android.os.Bundle;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class HttpImageDownloadAsyncTask
  extends HttpAsyncTask
{
  protected Bundle a;
  protected HttpImageDownloadAsyncTask.TaskCompleteCallback a;
  protected String a;
  
  public HttpImageDownloadAsyncTask(String paramString1, String paramString2, Bundle paramBundle, String paramString3, HttpImageDownloadAsyncTask.TaskCompleteCallback paramTaskCompleteCallback)
  {
    super(paramString2, paramString3);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentOpenBaseHttpHttpImageDownloadAsyncTask$TaskCompleteCallback = null;
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentOpenBaseHttpHttpImageDownloadAsyncTask$TaskCompleteCallback = paramTaskCompleteCallback;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  /* Error */
  protected Bitmap a(java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 27	org/apache/http/impl/client/DefaultHttpClient
    //   5: dup
    //   6: invokespecial 30	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   9: astore_1
    //   10: new 32	org/apache/http/client/methods/HttpGet
    //   13: dup
    //   14: aload_0
    //   15: getfield 35	com/tencent/open/base/http/HttpImageDownloadAsyncTask:h	Ljava/lang/String;
    //   18: invokespecial 38	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 19	com/tencent/open/base/http/HttpImageDownloadAsyncTask:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   26: ifnull +93 -> 119
    //   29: aload_0
    //   30: getfield 19	com/tencent/open/base/http/HttpImageDownloadAsyncTask:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   33: invokevirtual 44	android/os/Bundle:keySet	()Ljava/util/Set;
    //   36: invokeinterface 50 1 0
    //   41: astore 4
    //   43: aload 4
    //   45: invokeinterface 56 1 0
    //   50: ifeq +69 -> 119
    //   53: aload 4
    //   55: invokeinterface 60 1 0
    //   60: checkcast 62	java/lang/String
    //   63: astore 5
    //   65: aload_0
    //   66: getfield 19	com/tencent/open/base/http/HttpImageDownloadAsyncTask:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   69: aload 5
    //   71: invokevirtual 66	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   74: astore 6
    //   76: aload 6
    //   78: instanceof 62
    //   81: ifeq -38 -> 43
    //   84: aload_3
    //   85: aload 5
    //   87: aload 6
    //   89: checkcast 62	java/lang/String
    //   92: invokevirtual 69	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: goto -52 -> 43
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   107: aload_1
    //   108: ifnull +98 -> 206
    //   111: aload_1
    //   112: invokevirtual 77	java/io/InputStream:close	()V
    //   115: aconst_null
    //   116: astore_3
    //   117: aload_3
    //   118: areturn
    //   119: aload_1
    //   120: aload_3
    //   121: invokeinterface 83 2 0
    //   126: invokeinterface 89 1 0
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +75 -> 208
    //   136: aload_1
    //   137: invokeinterface 95 1 0
    //   142: astore_1
    //   143: aload_1
    //   144: astore_2
    //   145: aload_0
    //   146: aload_1
    //   147: invokevirtual 98	com/tencent/open/base/http/HttpImageDownloadAsyncTask:a	(Ljava/io/InputStream;)[B
    //   150: astore_3
    //   151: aload_1
    //   152: astore_2
    //   153: aload_3
    //   154: iconst_0
    //   155: aload_3
    //   156: arraylength
    //   157: invokestatic 104	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   160: astore_3
    //   161: aload_1
    //   162: astore_2
    //   163: aload_3
    //   164: astore_1
    //   165: aload_1
    //   166: astore_3
    //   167: aload_2
    //   168: ifnull -51 -> 117
    //   171: aload_2
    //   172: invokevirtual 77	java/io/InputStream:close	()V
    //   175: aload_1
    //   176: areturn
    //   177: astore_2
    //   178: aload_1
    //   179: areturn
    //   180: astore_1
    //   181: aconst_null
    //   182: areturn
    //   183: astore_1
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 77	java/io/InputStream:close	()V
    //   192: aload_1
    //   193: athrow
    //   194: astore_2
    //   195: goto -3 -> 192
    //   198: astore_1
    //   199: goto -15 -> 184
    //   202: astore_3
    //   203: goto -102 -> 101
    //   206: aconst_null
    //   207: areturn
    //   208: aconst_null
    //   209: astore_2
    //   210: aconst_null
    //   211: astore_1
    //   212: goto -47 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	HttpImageDownloadAsyncTask
    //   0	215	1	paramVarArgs	java.lang.Void[]
    //   1	171	2	arrayOfVoid	java.lang.Void[]
    //   177	12	2	localIOException1	java.io.IOException
    //   194	1	2	localIOException2	java.io.IOException
    //   209	1	2	localObject1	java.lang.Object
    //   21	64	3	localHttpGet	org.apache.http.client.methods.HttpGet
    //   98	6	3	localException1	java.lang.Exception
    //   116	51	3	localObject2	java.lang.Object
    //   202	1	3	localException2	java.lang.Exception
    //   41	13	4	localIterator	java.util.Iterator
    //   63	23	5	str	String
    //   74	14	6	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   10	43	98	java/lang/Exception
    //   43	95	98	java/lang/Exception
    //   119	132	98	java/lang/Exception
    //   136	143	98	java/lang/Exception
    //   171	175	177	java/io/IOException
    //   111	115	180	java/io/IOException
    //   10	43	183	finally
    //   43	95	183	finally
    //   119	132	183	finally
    //   136	143	183	finally
    //   188	192	194	java/io/IOException
    //   103	107	198	finally
    //   145	151	198	finally
    //   153	161	198	finally
    //   145	151	202	java/lang/Exception
    //   153	161	202	java/lang/Exception
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentOpenBaseHttpHttpImageDownloadAsyncTask$TaskCompleteCallback != null) {
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpImageDownloadAsyncTask$TaskCompleteCallback.a(this.jdField_a_of_type_JavaLangString, paramBitmap);
    }
  }
  
  protected byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
      localByteArrayOutputStream.flush();
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.http.HttpImageDownloadAsyncTask
 * JD-Core Version:    0.7.0.1
 */