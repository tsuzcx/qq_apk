package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class ThemeNoviceGuideActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private void d()
  {
    a(2131561842, null);
    ((Button)findViewById(2131234583)).setOnClickListener(this);
  }
  
  protected String a_()
  {
    return getString(2131561692);
  }
  
  protected boolean b()
  {
    finish();
    AlbumUtil.a(this, false, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131234583)
    {
      if (Utils.e())
      {
        finish();
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("FromWhere", "FromThemeNoviceGuide");
        VasWebviewUtil.a(this, "http://imgcache.qq.com/club/themes/mobile/theme/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&density=[density]&adTag=mvip.gongneng.android.theme.index_dynamic_tab&updateFlag=[updateFlag]&_bid=123&_wv=1027", 32L, paramView, false, -1);
        BusinessInfoCheckUpdateItem.a(this.b, "100005.100002", false);
      }
    }
    else {
      return;
    }
    Toast.makeText(this, getString(2131562496), 0).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904010);
    d();
    setTitle(getResources().getString(2131559134));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ThemeNoviceGuideActivity
 * JD-Core Version:    0.7.0.1
 */