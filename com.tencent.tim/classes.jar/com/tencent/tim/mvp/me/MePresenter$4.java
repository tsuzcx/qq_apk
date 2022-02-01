package com.tencent.tim.mvp.me;

import android.content.Intent;
import android.text.TextUtils;
import aneo;
import aqhv;
import aqmj;
import aujf;
import aunr;
import avpw;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MePresenter$4
  implements Runnable
{
  public MePresenter$4(aujf paramaujf, BaseActivity paramBaseActivity, aqhv paramaqhv, aunr paramaunr) {}
  
  public void run()
  {
    Object localObject = null;
    if (aujf.f(this.this$0) != null) {
      localObject = aujf.g(this.this$0).getCurrentUin();
    }
    String str = aqmj.n(this.val$activity, (String)localObject, "jumpToQzonePlugin");
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "MePresenter qzoneJumpConfig = " + str);
    }
    if ("0".equals(str))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        try
        {
          l = Long.parseLong((String)localObject);
          if ((l <= 0L) || (!avpw.a(this.val$activity, 84, l, "com.qzonex.app.tab.QZoneTabActivity")))
          {
            localObject = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", "https://h5.qzone.qq.com/qzone/activeFeeds?_wv=1027&_proxy=1".toString());
            ((Intent)localObject).addFlags(268435456);
            this.val$activity.startActivity((Intent)localObject);
          }
          return;
        }
        catch (Exception localException)
        {
          QLog.e("MePresenter", 1, "forward to qzone fail, uin(null) ", localException);
        }
        long l = 0L;
      }
    }
    aneo localaneo = (aneo)aujf.h(this.this$0).getManager(10);
    if ((localaneo != null) && ((localaneo.jn(2) > 0) || (localaneo.jn(1) > 0))) {
      this.jdField_c_of_type_Aqhv.SC(true);
    }
    this.jdField_c_of_type_Aqhv.fj("from_leba", "fromleba");
    this.jdField_c_of_type_Aqhv.fj("config_res_plugin_item_name", this.jdField_c_of_type_Aunr.c.strResName);
    this.jdField_c_of_type_Aqhv.fj("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
    this.jdField_c_of_type_Aqhv.setPkgName(this.jdField_c_of_type_Aunr.c.strPkgName);
    this.jdField_c_of_type_Aqhv.ace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.me.MePresenter.4
 * JD-Core Version:    0.7.0.1
 */