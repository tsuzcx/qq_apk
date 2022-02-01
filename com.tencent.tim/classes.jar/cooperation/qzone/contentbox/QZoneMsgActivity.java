package cooperation.qzone.contentbox;

import acfp;
import acym;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import arkn;
import avcb;
import avsm;
import avsn;
import avzf;
import avzh;
import avzi;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.provider.LocalPhotoGroupData;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import ocp;

public class QZoneMsgActivity
  extends IphoneTitleBarActivity
  implements arkn, avzi
{
  acym a;
  PlusMenuContainer b;
  private Fragment d;
  
  public static boolean e(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (avcb.cy(paramQQAppInterface))
    {
      long l = avcb.iK();
      if (l != 0L) {
        h(l, paramContext);
      }
      for (;;)
      {
        return true;
        paramQQAppInterface = new Intent(paramContext, QZoneMsgActivity.class);
        paramQQAppInterface.addFlags(67108864);
        paramContext.startActivity(paramQQAppInterface);
      }
    }
    return false;
  }
  
  public static void h(long paramLong, Context paramContext)
  {
    if (TextUtils.isEmpty(String.valueOf(paramLong)))
    {
      QZLog.e("QZoneMsgActivity", "empty mini prog appid");
      return;
    }
    MiniAppLauncher.launchMiniAppById(paramContext, String.valueOf(paramLong), null, null, null, null, 2009);
  }
  
  private void showMoreOperation()
  {
    if (this.b != null) {
      this.b.show();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((this.d instanceof QZoneMsgFragment))
      {
        avsm localavsm = ((QZoneMsgFragment)this.d).a();
        if (localavsm != null) {
          localavsm.h(paramInt1, paramInt2, paramIntent);
        }
      }
      return;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.getExtras() != null) {
          bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
        }
      }
      if (bool1) {
        finish();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int i = 2130851145;
    super.doOnCreate(paramBundle);
    setContentView(2131562590);
    setTitle(avsn.bN(this));
    NavBarCommon localNavBarCommon = (NavBarCommon)findViewById(2131377361);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        i = 2130851146;
      }
      paramBundle = getDrawable(i);
      localNavBarCommon.setRightImage(paramBundle);
      localNavBarCommon.setRightImageDesc(getString(2131698657));
      localNavBarCommon.setOnItemSelectListener(this);
      this.d = getSupportFragmentManager().findFragmentByTag("QZoneMsgFragment");
      if (this.d != null) {
        break label230;
      }
      this.d = new QZoneMsgFragment();
      getSupportFragmentManager().beginTransaction().add(2131367564, this.d, "QZoneMsgFragment").commit();
    }
    for (;;)
    {
      avzf.a().a(this);
      long l = LocalMultiProcConfig.getLong("SP_LAST_UPDATE_TIME_READ", 0L);
      QLog.d("[PhotoAlbum]QZoneMsgActivity", 1, new Object[] { "getTravelGroup SP_LAST_UPDATE_TIME_READ lastUpdateTime:", Long.valueOf(l) });
      avzf.a().a().nO(l);
      this.a = new acym();
      getWindow().setFlags(16777216, 16777216);
      return true;
      paramBundle = getResources();
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        i = 2130851146;
      }
      paramBundle = paramBundle.getDrawable(i);
      break;
      label230:
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgActivity", 2, "QZoneMsgFragment added");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    avzf.a().b(this);
    this.a.onDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.a.onPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.a.onResume();
  }
  
  public void hideMoreOperation()
  {
    if (this.b != null) {
      this.b.hide();
    }
  }
  
  public void initMoreOperation()
  {
    if (this.b == null)
    {
      LayoutInflater.from(this);
      ViewGroup localViewGroup = (ViewGroup)findViewById(16908290);
      this.b = new PlusMenuContainer(this);
      localViewGroup.addView(this.b);
      this.b.setActivity(this);
      this.b.setOnClickListener(null);
      this.b.initView();
    }
  }
  
  public void onItemSelect(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 5: 
      paramView = new Intent();
      paramView.putExtra("need_finish", true);
      paramView.putExtra("uin", "2290230341");
      paramView.putExtra("uinname", acfp.m(2131720732));
      paramView.putExtra("uintype", 1008);
      ocp.a(paramView, this.app, this, "2290230341", -1, 2000, 1, false);
      return;
    case 4: 
      initMoreOperation();
      togglePlus();
      return;
    }
    onBackEvent();
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {
      QLog.e("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent data == null || !data.containsKey(\"data\")");
    }
    for (;;)
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        QLog.e("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent getTravelGroup bundle is empty");
        return;
      }
      if ("cmd.getTravelGroup".equals(paramString))
      {
        QLog.i("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent CMD_GET_TRAVEL_GROUP");
        paramString = (LocalPhotoGroupData)paramBundle.getSerializable("groupData");
        if (paramString == null) {
          QLog.i("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent localPhotoGroupData == null");
        }
        while ((this.d instanceof QZoneMsgFragment))
        {
          ((QZoneMsgFragment)this.d).a(paramString);
          return;
          QLog.i("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent localPhotoGroupData:" + paramString.toString());
          LocalMultiProcConfig.putLong("SP_LAST_UPDATE_TIME_READ", paramString.startTime);
        }
      }
    }
  }
  
  public void togglePlus()
  {
    if ((this.b != null) && (!this.b.isShown()))
    {
      showMoreOperation();
      LpReportInfo_pf00064.report(133, 1);
      return;
    }
    hideMoreOperation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgActivity
 * JD-Core Version:    0.7.0.1
 */