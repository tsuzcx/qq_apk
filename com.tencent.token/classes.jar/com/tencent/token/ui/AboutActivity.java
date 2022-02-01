package com.tencent.token.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.token.bu;
import com.tencent.token.global.g;
import com.tencent.token.utils.j;
import com.tencent.token.utils.l;

public class AboutActivity
  extends BaseActivity
{
  private TextView aboutInfoWithEnvir;
  private TextView versionText;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968605);
    this.versionText = ((TextView)findViewById(2131558544));
    paramBundle = j.b;
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
        g.c(localNameNotFoundException.getMessage());
      }
    }
    this.versionText.setText("V" + paramBundle);
    this.aboutInfoWithEnvir = ((TextView)findViewById(2131558543));
    str = getResources().getString(2131230753);
    paramBundle = str;
    if (j.c == 2) {
      paramBundle = str + "RDM(201)";
    }
    this.aboutInfoWithEnvir.setText(paramBundle);
    findViewById(2131558548).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        bu.a().a(System.currentTimeMillis(), 44);
        paramAnonymousView = new Intent(AboutActivity.this, HelpActivity.class);
        AboutActivity.this.startActivity(paramAnonymousView);
      }
    });
    findViewById(2131558548).setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(AboutActivity.this, ShowLogActivity.class);
        AboutActivity.this.startActivity(paramAnonymousView);
        return true;
      }
    });
    findViewById(2131558550).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(AboutActivity.this, SerialNumberActivity.class);
        AboutActivity.this.startActivity(paramAnonymousView);
      }
    });
    findViewById(2131558552).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        l.a(AboutActivity.this, AboutActivity.this.getString(2131231300));
      }
    });
    findViewById(2131558545).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        l.a(AboutActivity.this, AboutActivity.this.getString(2131231204));
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AboutActivity
 * JD-Core Version:    0.7.0.1
 */