package com.tencent.token.ui;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.global.h;
import com.tencent.token.utils.u;

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
    paramBundle = u.b;
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
        h.c(localNameNotFoundException.getMessage());
      }
    }
    this.versionText.setText("V" + paramBundle);
    this.aboutInfoWithEnvir = ((TextView)findViewById(2131558543));
    str = getResources().getString(2131230753);
    paramBundle = str;
    if (u.c == 2) {
      paramBundle = str + "RDM(201)";
    }
    this.aboutInfoWithEnvir.setText(paramBundle);
    findViewById(2131558548).setOnClickListener(new c(this));
    findViewById(2131558548).setOnLongClickListener(new d(this));
    findViewById(2131558550).setOnClickListener(new e(this));
    findViewById(2131558552).setOnClickListener(new f(this));
    findViewById(2131558545).setOnClickListener(new g(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AboutActivity
 * JD-Core Version:    0.7.0.1
 */