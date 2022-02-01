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
import com.tencent.token.bv;
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
    setContentView(2131296285);
    this.versionText = ((TextView)findViewById(2131165202));
    paramBundle = j.b;
    try
    {
      String str = getPackageManager().getPackageInfo(getPackageName(), 16384).versionName;
      paramBundle = str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      g.c(localNameNotFoundException.getMessage());
    }
    Object localObject = this.versionText;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V");
    localStringBuilder.append(paramBundle);
    ((TextView)localObject).setText(localStringBuilder.toString());
    this.aboutInfoWithEnvir = ((TextView)findViewById(2131165201));
    localObject = getResources().getString(2131492895);
    paramBundle = (Bundle)localObject;
    if (j.c == 2)
    {
      paramBundle = new StringBuilder();
      paramBundle.append((String)localObject);
      paramBundle.append("RDM(201)");
      paramBundle = paramBundle.toString();
    }
    this.aboutInfoWithEnvir.setText(paramBundle);
    findViewById(2131165203).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        bv.a().a(System.currentTimeMillis(), 44);
        paramAnonymousView = new Intent(AboutActivity.this, HelpActivity.class);
        AboutActivity.this.startActivity(paramAnonymousView);
      }
    });
    findViewById(2131165203).setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(AboutActivity.this, ShowLogActivity.class);
        AboutActivity.this.startActivity(paramAnonymousView);
        return true;
      }
    });
    findViewById(2131165205).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(AboutActivity.this, SerialNumberActivity.class);
        AboutActivity.this.startActivity(paramAnonymousView);
      }
    });
    findViewById(2131165194).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = AboutActivity.this;
        l.a(paramAnonymousView, paramAnonymousView.getString(2131493443));
      }
    });
    findViewById(2131165200).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = AboutActivity.this;
        l.a(paramAnonymousView, paramAnonymousView.getString(2131493347));
      }
    });
    findViewById(2131165204).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        l.a(AboutActivity.this, "http://tools.3g.qq.com/j/qqsafety", "隐私协议");
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AboutActivity
 * JD-Core Version:    0.7.0.1
 */