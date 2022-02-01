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
import btmsdkobf.bw;
import com.tencent.token.aaw;
import com.tencent.token.aay;
import com.tencent.token.ace;
import com.tencent.token.aib.a;
import com.tencent.token.so;
import com.tencent.token.xv;

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
    paramBundle = aaw.b;
    try
    {
      String str1 = getPackageManager().getPackageInfo(getPackageName(), 16384).versionName;
      paramBundle = str1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      xv.c(localNameNotFoundException.getMessage());
    }
    this.versionText.setText("V".concat(String.valueOf(paramBundle)));
    this.versionText.setOnClickListener(new View.OnClickListener()
    {
      int a = 0;
      
      public final void onClick(View paramAnonymousView)
      {
        this.a += 1;
        if (this.a >= 5)
        {
          paramAnonymousView = AboutActivity.this.versionText;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(bw.ah().aj());
          paramAnonymousView.setText(localStringBuilder.toString());
        }
      }
    });
    this.aboutInfoWithEnvir = ((TextView)findViewById(2131165201));
    String str2 = getResources().getString(2131492895);
    paramBundle = str2;
    if (aaw.c == 2)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(str2);
      paramBundle.append("RDM(201)");
      paramBundle = paramBundle.toString();
    }
    this.aboutInfoWithEnvir.setText(paramBundle);
    findViewById(2131165203).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        so.a().a(System.currentTimeMillis(), 44);
        ace.a(AboutActivity.this, "即将离开QQ安全中心，前往腾讯客服", new aib.a()
        {
          public final void a(boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Boolean)
            {
              Intent localIntent = new Intent(AboutActivity.this, HelpActivity.class);
              AboutActivity.this.startActivity(localIntent);
            }
          }
        });
      }
    });
    findViewById(2131165203).setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(AboutActivity.this, ShowLogActivity.class);
        AboutActivity.this.startActivity(paramAnonymousView);
        return true;
      }
    });
    findViewById(2131165205).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(AboutActivity.this, SerialNumberActivity.class);
        AboutActivity.this.startActivity(paramAnonymousView);
      }
    });
    findViewById(2131165194).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = AboutActivity.this;
        aay.a(paramAnonymousView, paramAnonymousView.getString(2131493451));
      }
    });
    findViewById(2131165200).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = AboutActivity.this;
        aay.a(paramAnonymousView, paramAnonymousView.getString(2131493350));
      }
    });
    findViewById(2131165204).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        aay.b(AboutActivity.this, "http://tools.3g.qq.com/j/qqsafety", "隐私协议");
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AboutActivity
 * JD-Core Version:    0.7.0.1
 */