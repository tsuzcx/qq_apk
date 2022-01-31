import android.content.Intent;
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

public class wwv
  extends AsyncTask
{
  private wwv(PhotoCropActivity paramPhotoCropActivity) {}
  
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
    //   17: getfield 10	wwv:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   20: getfield 27	com/tencent/mobileqq/activity/photo/PhotoCropActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 34	java/io/File:exists	()Z
    //   31: ifne +14 -> 45
    //   34: aload_0
    //   35: getfield 10	wwv:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   38: getfield 27	com/tencent/mobileqq/activity/photo/PhotoCropActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: invokestatic 39	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   44: pop
    //   45: new 41	java/io/BufferedOutputStream
    //   48: dup
    //   49: new 43	java/io/FileOutputStream
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 49	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_3
    //   61: aload_3
    //   62: astore_2
    //   63: aload_1
    //   64: getstatic 55	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   67: aload_0
    //   68: getfield 10	wwv:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   71: getfield 59	com/tencent/mobileqq/activity/photo/PhotoCropActivity:jdField_b_of_type_Int	I
    //   74: aload_3
    //   75: invokevirtual 65	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   78: pop
    //   79: aload_3
    //   80: astore_2
    //   81: aload_0
    //   82: getfield 10	wwv:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   85: getfield 27	com/tencent/mobileqq/activity/photo/PhotoCropActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   88: astore_1
    //   89: aload_1
    //   90: astore_2
    //   91: aload_3
    //   92: ifnull -82 -> 10
    //   95: aload_3
    //   96: invokevirtual 68	java/io/BufferedOutputStream:close	()V
    //   99: aload_1
    //   100: areturn
    //   101: astore_3
    //   102: aload_1
    //   103: astore_2
    //   104: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -97 -> 10
    //   110: ldc 75
    //   112: iconst_2
    //   113: ldc 77
    //   115: aload_3
    //   116: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   119: aload_1
    //   120: areturn
    //   121: astore 4
    //   123: aconst_null
    //   124: astore_1
    //   125: aload_1
    //   126: astore_2
    //   127: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +15 -> 145
    //   133: aload_1
    //   134: astore_2
    //   135: ldc 75
    //   137: iconst_2
    //   138: ldc 77
    //   140: aload 4
    //   142: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload 5
    //   147: astore_2
    //   148: aload_1
    //   149: ifnull -139 -> 10
    //   152: aload_1
    //   153: invokevirtual 68	java/io/BufferedOutputStream:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_1
    //   159: aload 5
    //   161: astore_2
    //   162: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq -155 -> 10
    //   168: ldc 75
    //   170: iconst_2
    //   171: ldc 77
    //   173: aload_1
    //   174: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   177: aconst_null
    //   178: areturn
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_2
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 68	java/io/BufferedOutputStream:close	()V
    //   190: aload_1
    //   191: athrow
    //   192: astore_2
    //   193: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq -6 -> 190
    //   199: ldc 75
    //   201: iconst_2
    //   202: ldc 77
    //   204: aload_2
    //   205: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   208: goto -18 -> 190
    //   211: astore_1
    //   212: goto -30 -> 182
    //   215: astore 4
    //   217: aload_3
    //   218: astore_1
    //   219: goto -94 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	wwv
    //   0	222	1	paramBitmap	android.graphics.Bitmap
    //   9	178	2	localObject1	java.lang.Object
    //   192	13	2	localIOException1	java.io.IOException
    //   60	36	3	localBufferedOutputStream	java.io.BufferedOutputStream
    //   101	117	3	localIOException2	java.io.IOException
    //   121	20	4	localIOException3	java.io.IOException
    //   215	1	4	localIOException4	java.io.IOException
    //   1	159	5	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   95	99	101	java/io/IOException
    //   27	45	121	java/io/IOException
    //   45	61	121	java/io/IOException
    //   152	156	158	java/io/IOException
    //   27	45	179	finally
    //   45	61	179	finally
    //   186	190	192	java/io/IOException
    //   63	79	211	finally
    //   81	89	211	finally
    //   127	133	211	finally
    //   135	145	211	finally
    //   63	79	215	java/io/IOException
    //   81	89	215	java/io/IOException
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
      QQToast.a(this.a, 2131435909, 0).a();
      return;
    }
    if ("sdcardfull".equals(paramString))
    {
      QQToast.a(this.a, 2131435910, 0).a();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    if ("FROM_TROOP_ORG_PROFILE".equals(this.a.jdField_b_of_type_JavaLangString))
    {
      paramString = this.a.getIntent();
      paramString.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      this.a.setResult(-1, paramString);
      this.a.finish();
      return;
    }
    if (100 == this.a.jdField_a_of_type_Int)
    {
      this.a.getIntent().putExtra("PhotoConst.SYNCQZONE", this.a.c);
      this.a.getIntent().putExtra("PhotoConst.SYNCQZONE_CHECKSTATE", this.a.h);
    }
    PhotoUtils.a(this.a, this.a.getIntent(), localArrayList, 0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wwv
 * JD-Core Version:    0.7.0.1
 */