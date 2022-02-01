package com.tencent.biz.pubaccount.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqmk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import obt;

public final class PublicAccountConfigUtil$4
  implements Runnable
{
  public PublicAccountConfigUtil$4(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.val$app.getCurrentAccountUin();
    Object localObject = this.val$app.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + str, 0);
    if (localObject != null) {}
    try
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_name", obt.Ye);
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_icon", obt.Yf);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_delete", obt.adT);
      ((SharedPreferences.Editor)localObject).putBoolean("service_folder_redclean_after_enter", obt.adU);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_redspots", obt.adS);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload", obt.adV);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_wifi", obt.adW);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_4G", obt.adX);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_3G", obt.adY);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_2G", obt.adZ);
      ((SharedPreferences.Editor)localObject).putBoolean("public_account_bottom_bar", obt.aea);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_image_preload", obt.aeb);
      ((SharedPreferences.Editor)localObject).putString("kandian_feeds_fling_LToR_host", obt.Yg);
      ((SharedPreferences.Editor)localObject).putLong("kandian_ad_background_showtime", obt.rL);
      ((SharedPreferences.Editor)localObject).putBoolean("readInJoy_ip_connect", obt.aec);
      ((SharedPreferences.Editor)localObject).putInt("readInJoy_ip_connect_full_report", obt.aHM);
      ((SharedPreferences.Editor)localObject).putString("readInJoy_ip_connect_report_tail", obt.Yh);
      ((SharedPreferences.Editor)localObject).putBoolean("readInJoy_loading_img", obt.aed);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_redspots_delete", obt.aee);
      ((SharedPreferences.Editor)localObject).putBoolean("big_data_share_channel", obt.aef);
      aqmk.a((SharedPreferences.Editor)localObject, "big_data_share_channel_urls", obt.jZ.toArray());
      ((SharedPreferences.Editor)localObject).putInt("album_predown_enable", obt.aHN);
      ((SharedPreferences.Editor)localObject).putInt("album_predown_photo_rule", obt.aHO);
      ((SharedPreferences.Editor)localObject).putInt("album_predown_slide_photocounts", obt.aHP);
      ((SharedPreferences.Editor)localObject).putBoolean("ad_preload_tool_process", obt.aeg);
      ((SharedPreferences.Editor)localObject).putString("key_read_in_joy_preload_tool_config", obt.Yi);
      ((SharedPreferences.Editor)localObject).putString("key_read_in_joy_release_service_config", obt.Yj);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "updateServiceAccountFolderConfigData success, uin:" + str + ", delete:" + obt.adT + ", clean:" + obt.adU + ", redspot:" + obt.adS);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "updateServiceAccountFolderConfigData error, uin:" + str, localException);
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.4
 * JD-Core Version:    0.7.0.1
 */