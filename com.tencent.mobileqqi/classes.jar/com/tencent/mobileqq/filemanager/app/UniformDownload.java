package com.tencent.mobileqq.filemanager.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;

public class UniformDownload
{
  public static final String a = "UniformDownloadMgr<FileAssistant>";
  public static boolean a = false;
  public static final String b = "_filesize";
  public static final String c = "_filetype";
  public static final String d = "_buttontype";
  public static final String e = "param_user_agent";
  public static final String f = "param_content_des";
  public static final String g = "param_mime_type";
  public static final String h = "param_refer_url";
  public static final String i = "param_source_id";
  Activity a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private UniformDownload(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. >>>gotoDownload. url:" + paramString);
    if ((paramActivity == null) || (paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. gotoDownload. param error:");
      return;
    }
    new UniformDownload(paramActivity).a(paramString, paramBundle);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("_filesize");
    long l2 = paramBundle.getLong("_buttontype", 0L);
    Object localObject = UniformDownloadUtil.a(paramString);
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "nofilename";
    }
    localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, UniformDownloadActivity.class);
    ((Intent)localObject).putExtra(UniformDownloadActivity.b, paramString);
    ((Intent)localObject).putExtra(UniformDownloadActivity.d, paramBundle);
    ((Intent)localObject).putExtra(UniformDownloadActivity.e, l1);
    if (l2 == 1L) {
      ((Intent)localObject).putExtra(UniformDownloadActivity.c, l2);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.UniformDownload
 * JD-Core Version:    0.7.0.1
 */