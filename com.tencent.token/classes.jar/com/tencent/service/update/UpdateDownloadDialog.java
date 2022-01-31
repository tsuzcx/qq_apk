package com.tencent.service.update;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.service.a;
import com.tencent.service.d;
import com.tencent.token.ui.IndexActivity;
import com.tmsdk.TMSDKContext;
import com.tmsdk.Unit;
import java.io.File;

public class UpdateDownloadDialog
  extends Dialog
{
  d a;
  Button b;
  TextView c;
  TextView d;
  Handler e = new f(this);
  com.tencent.service.f f = new i(this);
  private Context g;
  
  public UpdateDownloadDialog(Context paramContext, int paramInt, d paramd)
  {
    super(paramContext, paramInt);
    this.g = paramContext;
    this.a = paramd;
  }
  
  void a()
  {
    if (this.a == null) {
      return;
    }
    switch (j.a[this.a.f.ordinal()])
    {
    default: 
      return;
    case 1: 
    case 2: 
    case 3: 
      e locale = e.a();
      locale.k(2);
      locale.e(true);
      a.a().c(this.a);
      TMSDKContext.saveActionData(1150107);
      return;
    case 4: 
    case 5: 
      a.a().b(this.a);
      return;
    case 6: 
      a.a(this.g, new File(a.b(), this.a.d));
      return;
    }
    a.a().d(this.a);
  }
  
  void a(d paramd)
  {
    if (paramd == this.a)
    {
      this.e.removeMessages(99);
      this.e.sendEmptyMessage(99);
    }
  }
  
  void b()
  {
    if (this.a == null) {
      return;
    }
    switch (j.a[this.a.f.ordinal()])
    {
    case 3: 
    default: 
      return;
    case 1: 
      this.b.setText("重试");
      return;
    case 2: 
      this.b.setText("立即体验");
      return;
    case 4: 
    case 5: 
      this.b.setText("下载中...(" + this.a.e + "%)");
      return;
    case 6: 
      this.b.setText("安装");
      return;
    }
    this.b.setText("继续");
  }
  
  void c()
  {
    try
    {
      dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968786);
    paramBundle = getWindow();
    Object localObject = paramBundle.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = ((int)(((Activity)this.g).getWindowManager().getDefaultDisplay().getWidth() - 46.0F * IndexActivity.S_DENSITY));
    paramBundle.setAttributes((WindowManager.LayoutParams)localObject);
    this.b = ((Button)findViewById(2131558680));
    this.c = ((TextView)findViewById(2131558419));
    this.d = ((TextView)findViewById(2131558795));
    findViewById(2131558948).setOnClickListener(new g(this));
    this.b.setOnClickListener(new h(this));
    b();
    localObject = e.a();
    paramBundle = String.format("新版本V%1$d.%2$d.%3$d", new Object[] { Integer.valueOf(((e)localObject).e()), Integer.valueOf(((e)localObject).f()), Integer.valueOf(((e)localObject).g()) });
    if (!TextUtils.isEmpty(((e)localObject).q())) {
      paramBundle = ((e)localObject).q();
    }
    this.c.setText(paramBundle);
    paramBundle = new StringBuffer();
    paramBundle.append(((e)localObject).i());
    if (((e)localObject).j() > 0)
    {
      paramBundle.append('\n');
      paramBundle.append("更新包：");
      paramBundle.append(Unit.transformShortType(((e)localObject).j(), true));
    }
    this.d.setText(paramBundle.toString());
  }
  
  protected void onStart()
  {
    a.a().a(this.f);
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
    a.a().b(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.UpdateDownloadDialog
 * JD-Core Version:    0.7.0.1
 */