import android.os.AsyncTask;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.RegionView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class erg
  extends AsyncTask
{
  private erg(PhotoCropActivity paramPhotoCropActivity) {}
  
  /* Error */
  private String a(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnonnull +8 -> 12
    //   7: aload 5
    //   9: astore_2
    //   10: aload_2
    //   11: areturn
    //   12: new 22	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: getfield 10	erg:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   20: getfield 27	com/tencent/mobileqq/activity/photo/PhotoCropActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 34	java/io/File:exists	()Z
    //   31: ifne +14 -> 45
    //   34: aload_0
    //   35: getfield 10	erg:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   38: getfield 27	com/tencent/mobileqq/activity/photo/PhotoCropActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: invokestatic 39	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   44: pop
    //   45: new 41	java/io/FileOutputStream
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 44	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   53: astore_3
    //   54: aload_3
    //   55: astore_2
    //   56: aload_1
    //   57: getstatic 50	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   60: aload_0
    //   61: getfield 10	erg:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   64: getfield 53	com/tencent/mobileqq/activity/photo/PhotoCropActivity:jdField_a_of_type_Int	I
    //   67: aload_3
    //   68: invokevirtual 59	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   71: pop
    //   72: aload_3
    //   73: astore_2
    //   74: aload_0
    //   75: getfield 10	erg:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   78: getfield 27	com/tencent/mobileqq/activity/photo/PhotoCropActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   81: astore_1
    //   82: aload_1
    //   83: astore_2
    //   84: aload_3
    //   85: ifnull -75 -> 10
    //   88: aload_3
    //   89: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   92: aload_1
    //   93: areturn
    //   94: astore_3
    //   95: aload_1
    //   96: astore_2
    //   97: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq -90 -> 10
    //   103: ldc 69
    //   105: iconst_2
    //   106: ldc 71
    //   108: aload_3
    //   109: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_1
    //   113: areturn
    //   114: astore 4
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: astore_2
    //   120: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +15 -> 138
    //   126: aload_1
    //   127: astore_2
    //   128: ldc 69
    //   130: iconst_2
    //   131: ldc 71
    //   133: aload 4
    //   135: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   138: aload 5
    //   140: astore_2
    //   141: aload_1
    //   142: ifnull -132 -> 10
    //   145: aload_1
    //   146: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_1
    //   152: aload 5
    //   154: astore_2
    //   155: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq -148 -> 10
    //   161: ldc 69
    //   163: iconst_2
    //   164: ldc 71
    //   166: aload_1
    //   167: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_2
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   183: aload_1
    //   184: athrow
    //   185: astore_2
    //   186: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -6 -> 183
    //   192: ldc 69
    //   194: iconst_2
    //   195: ldc 71
    //   197: aload_2
    //   198: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: goto -18 -> 183
    //   204: astore_1
    //   205: goto -30 -> 175
    //   208: astore 4
    //   210: aload_3
    //   211: astore_1
    //   212: goto -94 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	erg
    //   0	215	1	paramBitmap	android.graphics.Bitmap
    //   9	171	2	localObject1	java.lang.Object
    //   185	13	2	localIOException1	java.io.IOException
    //   53	36	3	localFileOutputStream	java.io.FileOutputStream
    //   94	117	3	localIOException2	java.io.IOException
    //   114	20	4	localIOException3	java.io.IOException
    //   208	1	4	localIOException4	java.io.IOException
    //   1	152	5	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   88	92	94	java/io/IOException
    //   27	45	114	java/io/IOException
    //   45	54	114	java/io/IOException
    //   145	149	151	java/io/IOException
    //   27	45	172	finally
    //   45	54	172	finally
    //   179	183	185	java/io/IOException
    //   56	72	204	finally
    //   74	82	204	finally
    //   120	126	204	finally
    //   128	138	204	finally
    //   56	72	208	java/io/IOException
    //   74	82	208	java/io/IOException
  }
  
  protected String a(Void... paramVarArgs)
  {
    if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) {
      return "sdcardfull";
    }
    try
    {
      paramVarArgs = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView.a();
      return a(paramVarArgs);
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoCropActivity", 2, paramVarArgs.getMessage());
      }
    }
    return "oom";
  }
  
  protected void a(String paramString)
  {
    if (("oom".equals(paramString)) || (paramString == null))
    {
      QQToast.a(this.a, 2131562242, 0).a();
      return;
    }
    if ("sdcardfull".equals(paramString))
    {
      QQToast.a(this.a, 2131562821, 0).a();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    PhotoUtils.a(this.a, this.a.getIntent(), localArrayList, 0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     erg
 * JD-Core Version:    0.7.0.1
 */