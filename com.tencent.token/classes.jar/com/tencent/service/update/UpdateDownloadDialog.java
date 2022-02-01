package com.tencent.service.update;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.service.a;
import com.tencent.service.a.a;
import com.tencent.service.a.c;
import com.tencent.token.ui.IndexActivity;
import com.tmsdk.TMSDKContext;
import com.tmsdk.Unit;
import java.io.File;

public class UpdateDownloadDialog
  extends Dialog
{
  a.a a;
  Button b;
  TextView c;
  TextView d;
  Handler e = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 99) {
        UpdateDownloadDialog.this.b();
      }
    }
  };
  a.c f = new a.c()
  {
    public void a(a.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public void b(a.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public void c(a.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public void d(a.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
  };
  private Context g;
  
  public UpdateDownloadDialog(Context paramContext, int paramInt, a.a parama)
  {
    super(paramContext, paramInt);
    this.g = paramContext;
    this.a = parama;
  }
  
  void a()
  {
    if (this.a == null) {
      return;
    }
    switch (5.a[this.a.f.ordinal()])
    {
    default: 
      return;
    case 7: 
      a.a().d(this.a);
      return;
    case 6: 
      a.a(this.g, new File(a.b(), this.a.d));
      return;
    case 4: 
    case 5: 
      a.a().b(this.a);
      return;
    }
    e locale = e.a();
    locale.k(2);
    locale.f(true);
    a.a().c(this.a);
    TMSDKContext.saveActionData(1150107);
  }
  
  void a(a.a parama)
  {
    if (parama == this.a)
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
    switch (5.a[this.a.f.ordinal()])
    {
    case 3: 
    default: 
      return;
    case 7: 
      this.b.setText("继续");
      return;
    case 6: 
      this.b.setText("安装");
      return;
    case 4: 
    case 5: 
      Button localButton = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("下载中...(");
      localStringBuilder.append(this.a.e);
      localStringBuilder.append("%)");
      localButton.setText(localStringBuilder.toString());
      return;
    case 2: 
      this.b.setText("立即体验");
      return;
    }
    this.b.setText("重试");
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
    setContentView(2131296467);
    paramBundle = getWindow();
    Object localObject = paramBundle.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = ((int)(((Activity)this.g).getWindowManager().getDefaultDisplay().getWidth() - IndexActivity.S_DENSITY * 46.0F));
    paramBundle.setAttributes((WindowManager.LayoutParams)localObject);
    this.b = ((Button)findViewById(2131165822));
    this.c = ((TextView)findViewById(2131166106));
    this.d = ((TextView)findViewById(2131165742));
    findViewById(2131165380).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UpdateDownloadDialog.this.c();
      }
    });
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UpdateDownloadDialog.this.a();
      }
    });
    b();
    localObject = e.a();
    paramBundle = String.format("新版本V%1$d.%2$d.%3$d", new Object[] { Integer.valueOf(((e)localObject).f()), Integer.valueOf(((e)localObject).g()), Integer.valueOf(((e)localObject).h()) });
    if (!TextUtils.isEmpty(((e)localObject).r())) {
      paramBundle = ((e)localObject).r();
    }
    this.c.setText(paramBundle);
    paramBundle = new StringBuffer();
    paramBundle.append(((e)localObject).j());
    if (((e)localObject).k() > 0)
    {
      paramBundle.append('\n');
      paramBundle.append("更新包：");
      paramBundle.append(Unit.transformShortType(((e)localObject).k(), true));
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