package com.tencent.tim.cloudfile.wps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.util.BinderWarpper;

public class WPSFilePreviewActivity
  extends QQBrowserActivity
{
  public static String cHv = "key_share_title";
  public static String cHw = "key_is_show_share_title";
  
  public WPSFilePreviewActivity()
  {
    this.s = WpsFilePreviewFragment.class;
  }
  
  public static void a(BinderWarpper paramBinderWarpper, Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    Intent localIntent = new Intent(paramContext, WPSFilePreviewActivity.class);
    localIntent.putExtra("_file_name_", paramString2);
    localIntent.putExtra("_file_id_", paramString3);
    localIntent.putExtra("_file_url_", paramString4);
    localIntent.putExtra("_file_size_", paramLong);
    localIntent.putExtra("_file_sha_", paramString1);
    localIntent.putExtra("url", paramString4);
    localIntent.putExtra(cHv, "此网页由drive.wps.cn提供");
    localIntent.putExtra(cHw, true);
    if (!(paramContext instanceof Activity)) {
      localIntent.setFlags(268435456);
    }
    if (paramBinderWarpper != null)
    {
      paramString1 = new Bundle();
      paramString1.putParcelable("file_manager_provider", paramBinderWarpper);
      localIntent.putExtras(paramString1);
    }
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.wps.WPSFilePreviewActivity
 * JD-Core Version:    0.7.0.1
 */