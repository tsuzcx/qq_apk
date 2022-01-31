package com.tencent.token.ui;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;
import com.tencent.token.utils.q;

public class AboutActivity
  extends BaseActivity
{
  private final boolean IS_SAMSUNG_MARKET = true;
  private TextView aboutInfoWithEnvir;
  protected String mErr;
  public ImageView mNewIcon;
  public TextView mNoUpdate;
  UserTask mTask;
  public ImageView mUpdateAction;
  private TextView versionText;
  
  private void showUpdateInfo()
  {
    com.tencent.token.core.bean.h localh = com.tencent.token.core.bean.h.b();
    if ((2 == localh.a) || (3 == localh.a))
    {
      showUserDialog(1);
      return;
    }
    showUserDialog(3);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
    this.versionText = ((TextView)findViewById(2131296285));
    paramBundle = q.b;
    try
    {
      str = getPackageManager().getPackageInfo(getPackageName(), 16384).versionName;
      paramBundle = str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        String str;
        com.tencent.token.global.e.c(localNameNotFoundException.getMessage());
      }
    }
    this.versionText.setText("V" + paramBundle);
    this.aboutInfoWithEnvir = ((TextView)findViewById(2131296284));
    str = getResources().getString(2131361885);
    paramBundle = str;
    if (q.c == 2) {
      paramBundle = str + "RDM(201)";
    }
    this.aboutInfoWithEnvir.setText(paramBundle);
    findViewById(2131296294).setOnClickListener(new c(this));
    findViewById(2131296294).setOnLongClickListener(new d(this));
    findViewById(2131296296).setOnClickListener(new e(this));
    findViewById(2131296300).setOnClickListener(new f(this));
    findViewById(2131296298).setOnClickListener(new g(this));
    findViewById(2131296292).setOnClickListener(new h(this));
  }
  
  protected void onStop()
  {
    super.onStop();
    if ((this.mTask != null) && (this.mTask.c() != UserTask.Status.FINISHED))
    {
      this.mTask.d();
      this.mTask = null;
    }
  }
  
  public void queryUpdateInfo()
  {
    this.mTask = new i(this);
    this.mTask.a(new String[] { "" });
    showUserDialog(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AboutActivity
 * JD-Core Version:    0.7.0.1
 */