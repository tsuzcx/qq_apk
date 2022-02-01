package com.dataline.activities;

import acbn;
import acfp;
import acxw;
import ahaf;
import ahao;
import ahav;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import anpb;
import ausj;
import auss;
import bv;
import bw;
import bx;
import by;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cu;
import mqq.app.MobileQQ;
import ujs;
import wja;

public class LiteAdvanceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private TextView C;
  private Switch a;
  private boolean aY;
  private Switch b;
  protected String bB = acbn.bkw;
  private boolean bd;
  private boolean be;
  private Switch c;
  public int cM = 0;
  public Handler mHandler = new Handler();
  private View p;
  private View y;
  private View z;
  
  private boolean K()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = this.app.a().a();
    String str = this.bB;
    if ((str == null) || (str.length() == 0) || (localObject == null))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("IphoneTitleBarActivity", 2, "isChatAtTop params error, return false.");
        bool2 = bool1;
      }
    }
    do
    {
      do
      {
        return bool2;
        localObject = ((acxw)localObject).b(str, 6000);
        if (localObject != null) {
          break;
        }
        bool2 = bool1;
      } while (!QLog.isColorLevel());
      QLog.d("IphoneTitleBarActivity", 2, "isChatAtTop ru == null, return false.");
      return false;
      bool1 = bool2;
      if (((RecentUser)localObject).showUpTime > 0L) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("IphoneTitleBarActivity", 2, "isChatAtTop result is: " + bool1);
    return bool1;
  }
  
  private boolean L()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    if (this.cM == 0) {
      bool = localSharedPreferences.getBoolean("dl_pc_online_notify", true);
    }
    while (this.cM != 1) {
      return bool;
    }
    return localSharedPreferences.getBoolean("dl_ipad_online_notify", true);
  }
  
  private void O(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    if (this.cM == 0) {
      localSharedPreferences.edit().putBoolean("dl_pc_online_notify", paramBoolean).commit();
    }
    while (this.cM != 1) {
      return;
    }
    localSharedPreferences.edit().putBoolean("dl_ipad_online_notify", paramBoolean).commit();
  }
  
  private void bP()
  {
    String str = getString(2131695389);
    ausj localausj = (ausj)auss.a(this, null);
    localausj.setMainTitle(str);
    localausj.addButton(getResources().getString(2131695394), 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new by(this, localausj));
    localausj.show();
  }
  
  private void bQ()
  {
    Intent localIntent = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localIntent = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
    }
    while (localIntent == null)
    {
      return;
      ahao.OS(2131721201);
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("category", 6);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("localSdCardfile", 0);
      localIntent.putExtra("open_with_qq_images", true);
      startActivityForResult(localIntent, 103);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bR()
  {
    bP();
  }
  
  private void bS()
  {
    acfp.m(2131707827);
    if (ahav.S(this, getString(2131695446)))
    {
      String str = this.app.getApp().getString(2131693296);
      QQToast.a(getApplicationContext(), str, 0).show();
    }
    do
    {
      return;
      if (this.cM == 0)
      {
        ahav.b(this.app, this, "jump_shortcut_dataline", getString(2131695446), 2130845074);
        cu.q(this.app);
        return;
      }
    } while (this.cM != 1);
    ahav.b(this.app, this, "jump_shortcut_dataline", getString(2131695446), 2130845074);
    cu.q(this.app);
  }
  
  private boolean c(boolean paramBoolean)
  {
    acxw localacxw = this.app.a().a();
    String str = this.bB;
    if ((str == null) || (str.length() == 0) || (localacxw == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "setChatAtTop params error, return false.");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "setChatAtTop top: " + paramBoolean + " uin: " + str + " userType: " + 6000);
    }
    RecentUser localRecentUser2 = localacxw.b(str, 6000);
    RecentUser localRecentUser1 = localRecentUser2;
    if (localRecentUser2 == null) {
      localRecentUser1 = new RecentUser(str, 6000);
    }
    if (paramBoolean) {}
    for (localRecentUser1.showUpTime = (System.currentTimeMillis() / 1000L);; localRecentUser1.showUpTime = 0L)
    {
      localacxw.e(localRecentUser1);
      return true;
    }
  }
  
  private boolean getAutoDownload()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    if (this.cM == 0) {
      bool = localSharedPreferences.getBoolean("auto_receive_files", false);
    }
    while (this.cM != 1) {
      return bool;
    }
    return localSharedPreferences.getBoolean("auto_receive_files_ipad", false);
  }
  
  private void initView()
  {
    setContentView(2131559177);
    Object localObject1 = (ImageView)findViewById(2131368698);
    Object localObject2 = (TextView)findViewById(2131369154);
    TextView localTextView1 = (TextView)findViewById(2131365360);
    TextView localTextView2 = (TextView)findViewById(2131372644);
    TextView localTextView3 = (TextView)findViewById(2131372645);
    if (this.cM == 0)
    {
      ((ImageView)localObject1).setBackgroundResource(2130845074);
      ((TextView)localObject2).setText(2131695446);
      localTextView1.setText(2131695409);
      localTextView2.setText(2131695428);
      localTextView3.setText(2131695429);
    }
    for (;;)
    {
      setTitle(2131697399);
      this.p = findViewById(2131381938);
      this.p.setOnClickListener(this);
      this.y = findViewById(2131362236);
      this.y.setOnClickListener(this);
      this.z = findViewById(2131364654);
      this.z.setOnClickListener(this);
      this.C = ((TextView)findViewById(2131376992));
      this.C.setText(ahaf.a().vZ());
      this.c = ((Switch)findViewById(2131378713));
      this.c.setChecked(this.be);
      this.c.setOnCheckedChangeListener(new bv(this));
      this.a = ((Switch)findViewById(2131378710));
      this.a.setChecked(this.aY);
      this.a.setOnCheckedChangeListener(new bw(this));
      this.b = ((Switch)findViewById(2131372950));
      this.b.setChecked(this.bd);
      this.b.setOnCheckedChangeListener(new bx(this));
      if (ujs.aTl)
      {
        localObject2 = this.leftView.getText().toString();
        localObject1 = localObject2;
        if (!getString(2131690700).equals(localObject2)) {
          localObject1 = acfp.m(2131707828) + (String)localObject2 + acfp.m(2131707829);
        }
        this.leftView.setContentDescription((CharSequence)localObject1);
      }
      return;
      if (this.cM == 1)
      {
        ((ImageView)localObject1).setBackgroundResource(2130845071);
        ((TextView)localObject2).setText(2131695447);
        localTextView1.setText(2131695410);
        localTextView2.setText(2131695411);
        localTextView3.setText(2131695412);
      }
    }
  }
  
  private void setAutoDownload(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    if (this.cM == 0) {
      localSharedPreferences.edit().putBoolean("auto_receive_files", paramBoolean).commit();
    }
    while (this.cM != 1) {
      return;
    }
    localSharedPreferences.edit().putBoolean("auto_receive_files_ipad", paramBoolean).commit();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      Intent localIntent = wja.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.bB = getIntent().getStringExtra("targetUin");
    if ((this.bB != null) && (this.bB.length() != 0)) {
      if (this.bB.equals(acbn.bkx)) {
        this.cM = 1;
      }
    }
    for (;;)
    {
      this.aY = getAutoDownload();
      this.bd = L();
      this.be = K();
      initView();
      return true;
      this.cM = 0;
      continue;
      this.cM = 0;
      this.bB = acbn.bkw;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckviewrecvfile");
      bQ();
      continue;
      bS();
      continue;
      bR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity
 * JD-Core Version:    0.7.0.1
 */