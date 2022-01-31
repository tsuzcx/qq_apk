package com.tencent.mobileqq.activity;

import android.content.Context;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;

public class LebaIconDownloader$DownloadListenerAdapter
  implements HttpDownloadUtil.HttpDownloadListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LebaIconDownloader.IDownloadListener jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener;
  private Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  
  public LebaIconDownloader$DownloadListenerAdapter(Context paramContext, LebaIconDownloader.IDownloadListener paramIDownloadListener, Object... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener = paramIDownloadListener;
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaListViewAdapter", 2, "--onHttpStart");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener.a(0, paramString, null, this.jdField_a_of_type_ArrayOfJavaLangObject);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaListViewAdapter", 2, "--onHttpProgress");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener.a(1, paramString, null, this.jdField_a_of_type_ArrayOfJavaLangObject);
    }
  }
  
  /* Error */
  public void b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +28 -> 34
    //   9: ldc 37
    //   11: iconst_2
    //   12: new 56	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   19: ldc 59
    //   21: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 43	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: iload_2
    //   35: ifne +286 -> 321
    //   38: new 72	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: getfield 27	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   46: invokevirtual 76	android/content/Context:getFilesDir	()Ljava/io/File;
    //   49: aload_1
    //   50: invokespecial 79	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   53: astore_3
    //   54: aload_3
    //   55: ifnull +105 -> 160
    //   58: aload_3
    //   59: invokevirtual 82	java/io/File:exists	()Z
    //   62: ifne +98 -> 160
    //   65: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +33 -> 101
    //   71: ldc 37
    //   73: iconst_2
    //   74: new 56	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   81: ldc 84
    //   83: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 86
    //   92: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 43	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload_0
    //   102: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   105: ifnull +19 -> 124
    //   108: aload_0
    //   109: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   112: iconst_2
    //   113: aload_1
    //   114: aconst_null
    //   115: aload_0
    //   116: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   119: invokeinterface 48 5 0
    //   124: aload_0
    //   125: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   128: ifnull +19 -> 147
    //   131: aload_0
    //   132: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   135: iconst_2
    //   136: aload_1
    //   137: aconst_null
    //   138: aload_0
    //   139: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   142: invokeinterface 48 5 0
    //   147: iconst_0
    //   148: ifeq +11 -> 159
    //   151: new 88	java/lang/NullPointerException
    //   154: dup
    //   155: invokespecial 89	java/lang/NullPointerException:<init>	()V
    //   158: athrow
    //   159: return
    //   160: new 91	java/io/FileInputStream
    //   163: dup
    //   164: aload_3
    //   165: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   168: astore 4
    //   170: new 96	android/graphics/drawable/BitmapDrawable
    //   173: dup
    //   174: aload 4
    //   176: invokespecial 99	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   179: astore_3
    //   180: aload_1
    //   181: aload_3
    //   182: invokestatic 104	com/tencent/mobileqq/activity/LebaIconDownloader:a	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   185: aload_0
    //   186: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   189: ifnull +19 -> 208
    //   192: aload_0
    //   193: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   196: iconst_2
    //   197: aload_1
    //   198: aload_3
    //   199: aload_0
    //   200: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   203: invokeinterface 48 5 0
    //   208: aload 4
    //   210: ifnull -51 -> 159
    //   213: aload 4
    //   215: invokevirtual 107	java/io/FileInputStream:close	()V
    //   218: return
    //   219: astore_1
    //   220: return
    //   221: astore 5
    //   223: aconst_null
    //   224: astore_3
    //   225: aconst_null
    //   226: astore 4
    //   228: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +14 -> 245
    //   234: ldc 37
    //   236: iconst_2
    //   237: aload 5
    //   239: invokevirtual 108	java/lang/Exception:toString	()Ljava/lang/String;
    //   242: invokestatic 43	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload_0
    //   246: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   249: ifnull +19 -> 268
    //   252: aload_0
    //   253: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   256: iconst_2
    //   257: aload_1
    //   258: aconst_null
    //   259: aload_0
    //   260: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   263: invokeinterface 48 5 0
    //   268: aload 4
    //   270: ifnull -111 -> 159
    //   273: aload 4
    //   275: invokevirtual 107	java/io/FileInputStream:close	()V
    //   278: return
    //   279: astore_1
    //   280: return
    //   281: astore 4
    //   283: aconst_null
    //   284: astore_3
    //   285: aload_0
    //   286: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   289: ifnull +19 -> 308
    //   292: aload_0
    //   293: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   296: iconst_2
    //   297: aload_1
    //   298: aload_3
    //   299: aload_0
    //   300: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   303: invokeinterface 48 5 0
    //   308: aload 5
    //   310: ifnull +8 -> 318
    //   313: aload 5
    //   315: invokevirtual 107	java/io/FileInputStream:close	()V
    //   318: aload 4
    //   320: athrow
    //   321: aload_0
    //   322: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   325: ifnull -166 -> 159
    //   328: aload_0
    //   329: getfield 17	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ComTencentMobileqqActivityLebaIconDownloader$IDownloadListener	Lcom/tencent/mobileqq/activity/LebaIconDownloader$IDownloadListener;
    //   332: iconst_2
    //   333: aload_1
    //   334: aconst_null
    //   335: aload_0
    //   336: getfield 19	com/tencent/mobileqq/activity/LebaIconDownloader$DownloadListenerAdapter:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   339: invokeinterface 48 5 0
    //   344: return
    //   345: astore_1
    //   346: return
    //   347: astore_1
    //   348: goto -30 -> 318
    //   351: astore 5
    //   353: aconst_null
    //   354: astore_3
    //   355: aload 4
    //   357: astore 6
    //   359: aload 5
    //   361: astore 4
    //   363: aload 6
    //   365: astore 5
    //   367: goto -82 -> 285
    //   370: astore 6
    //   372: aload 4
    //   374: astore 5
    //   376: aload 6
    //   378: astore 4
    //   380: goto -95 -> 285
    //   383: astore 6
    //   385: aload 4
    //   387: astore 5
    //   389: aload 6
    //   391: astore 4
    //   393: goto -108 -> 285
    //   396: astore 5
    //   398: aconst_null
    //   399: astore_3
    //   400: goto -172 -> 228
    //   403: astore 5
    //   405: goto -177 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	DownloadListenerAdapter
    //   0	408	1	paramString	String
    //   0	408	2	paramInt	int
    //   53	347	3	localObject1	Object
    //   168	106	4	localFileInputStream	java.io.FileInputStream
    //   281	75	4	localObject2	Object
    //   361	31	4	localObject3	Object
    //   1	1	5	localObject4	Object
    //   221	93	5	localException1	java.lang.Exception
    //   351	9	5	localObject5	Object
    //   365	23	5	localObject6	Object
    //   396	1	5	localException2	java.lang.Exception
    //   403	1	5	localException3	java.lang.Exception
    //   357	7	6	localObject7	Object
    //   370	7	6	localObject8	Object
    //   383	7	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   213	218	219	java/lang/Exception
    //   38	54	221	java/lang/Exception
    //   58	101	221	java/lang/Exception
    //   101	124	221	java/lang/Exception
    //   160	170	221	java/lang/Exception
    //   273	278	279	java/lang/Exception
    //   38	54	281	finally
    //   58	101	281	finally
    //   101	124	281	finally
    //   160	170	281	finally
    //   151	159	345	java/lang/Exception
    //   313	318	347	java/lang/Exception
    //   170	180	351	finally
    //   180	185	370	finally
    //   228	245	383	finally
    //   170	180	396	java/lang/Exception
    //   180	185	403	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaIconDownloader.DownloadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */