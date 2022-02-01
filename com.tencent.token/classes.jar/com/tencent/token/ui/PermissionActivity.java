package com.tencent.token.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.token.ace;
import com.tencent.token.aib.a;
import com.tencent.token.dj;
import com.tencent.token.yt;
import java.util.ArrayList;
import java.util.List;

public class PermissionActivity
  extends BaseActivity
{
  private static String[] PERMISSIONS_DYNAMIC = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" };
  Button storagePermBtn;
  
  boolean need2RequestPermission()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = PERMISSIONS_DYNAMIC;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      String str;
      if (i < j) {
        str = arrayOfString[i];
      }
      try
      {
        if (dj.a(this, str) != 0) {
          localArrayList.add(str);
        }
        label48:
        i += 1;
        continue;
        return localArrayList.size() > 0;
      }
      catch (Exception localException)
      {
        break label48;
      }
    }
  }
  
  @SuppressLint({"ApplySharedPref"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296406);
    paramBundle = (ImageView)findViewById(2131166082);
    Drawable localDrawable = getResources().getDrawable(2131099928);
    localDrawable.setColorFilter(Color.parseColor("#FF4D4D4D"), PorterDuff.Mode.SRC_IN);
    paramBundle.setImageDrawable(localDrawable);
    this.storagePermBtn = ((Button)findViewById(2131165833));
    this.storagePermBtn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if ("未授权".equals(PermissionActivity.this.storagePermBtn.getText().toString()))
        {
          ace.a(PermissionActivity.this, "为确保服务正常运行，保障帐号安全，向您提供应用文件下载、存储服务，我们需要访问您的SD卡权限。如您此前曾拒绝或关闭此权限，您需前往系统进行开启。", new aib.a()
          {
            public final void a(boolean paramAnonymous2Boolean)
            {
              if (paramAnonymous2Boolean) {
                PermissionActivity.this.requestRuntimePermissions(PermissionActivity.PERMISSIONS_DYNAMIC, new yt()
                {
                  public final void a()
                  {
                    PermissionActivity.this.refreshPermission();
                  }
                  
                  public final void b() {}
                });
              }
            }
          });
          return;
        }
        PermissionActivity.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:com.tencent.token")));
      }
    });
    refreshPermission();
  }
  
  protected void onResume()
  {
    super.onResume();
    refreshPermission();
  }
  
  void refreshPermission()
  {
    if (need2RequestPermission())
    {
      this.storagePermBtn.setText("未授权");
      this.storagePermBtn.setBackgroundDrawable(getResources().getDrawable(2131099777));
      return;
    }
    this.storagePermBtn.setText("已授权");
    this.storagePermBtn.setBackgroundDrawable(getResources().getDrawable(2131100079));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.PermissionActivity
 * JD-Core Version:    0.7.0.1
 */