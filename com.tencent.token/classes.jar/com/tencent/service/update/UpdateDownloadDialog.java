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
import com.tencent.token.rc;
import com.tencent.token.rc.a;
import com.tencent.token.rc.b;
import com.tencent.token.rc.c;
import com.tencent.token.rn;
import com.tencent.token.rp;
import com.tencent.token.ui.IndexActivity;
import com.tmsdk.TMSDKContext;
import com.tmsdk.Unit;
import java.io.File;

public class UpdateDownloadDialog
  extends Dialog
{
  Context a;
  rc.a b;
  Button c;
  TextView d;
  TextView e;
  Handler f = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 99) {
        UpdateDownloadDialog.this.a();
      }
    }
  };
  rc.c g = new rc.c()
  {
    public final void a(rc.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public final void b(rc.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public final void c(rc.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public final void d(rc.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
  };
  
  public UpdateDownloadDialog(Context paramContext, rc.a parama)
  {
    super(paramContext, 2131558791);
    this.a = paramContext;
    this.b = parama;
  }
  
  final void a()
  {
    if (this.b == null) {
      return;
    }
    switch (5.a[this.b.f.ordinal()])
    {
    case 3: 
    default: 
      return;
    case 7: 
      this.c.setText("继续");
      return;
    case 6: 
      this.c.setText("安装");
      return;
    case 4: 
    case 5: 
      Button localButton = this.c;
      StringBuilder localStringBuilder = new StringBuilder("下载中...(");
      localStringBuilder.append(this.b.e);
      localStringBuilder.append("%)");
      localButton.setText(localStringBuilder.toString());
      return;
    case 2: 
      this.c.setText("立即体验");
      return;
    }
    this.c.setText("重试");
  }
  
  final void a(rc.a parama)
  {
    if (parama == this.b)
    {
      this.f.removeMessages(99);
      this.f.sendEmptyMessage(99);
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296468);
    paramBundle = getWindow();
    Object localObject = paramBundle.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = ((int)(((Activity)this.a).getWindowManager().getDefaultDisplay().getWidth() - IndexActivity.S_DENSITY * 46.0F));
    paramBundle.setAttributes((WindowManager.LayoutParams)localObject);
    this.c = ((Button)findViewById(2131165826));
    this.d = ((TextView)findViewById(2131166112));
    this.e = ((TextView)findViewById(2131165746));
    findViewById(2131165382).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = UpdateDownloadDialog.this;
        try
        {
          paramAnonymousView.dismiss();
          return;
        }
        catch (Exception paramAnonymousView)
        {
          paramAnonymousView.printStackTrace();
        }
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = UpdateDownloadDialog.this;
        if (paramAnonymousView.b != null)
        {
          switch (UpdateDownloadDialog.5.a[paramAnonymousView.b.f.ordinal()])
          {
          default: 
            return;
          case 7: 
            rc.b.a().d(paramAnonymousView.b);
            return;
          case 6: 
            rc.a(paramAnonymousView.a, new File(rc.a(), paramAnonymousView.b.d));
            return;
          case 4: 
          case 5: 
            rc.b.a().b(paramAnonymousView.b);
            return;
          }
          rp localrp = rp.a();
          localrp.k(2);
          localrp.c(true);
          rc.b.a().c(paramAnonymousView.b);
          TMSDKContext.saveActionData(1150107);
          return;
        }
      }
    });
    a();
    localObject = rp.a();
    paramBundle = String.format("新版本V%1$d.%2$d.%3$d", new Object[] { Integer.valueOf(((rp)localObject).d()), Integer.valueOf(((rp)localObject).e()), Integer.valueOf(((rp)localObject).f()) });
    if (!TextUtils.isEmpty(((rp)localObject).j())) {
      paramBundle = ((rp)localObject).j();
    }
    this.d.setText(paramBundle);
    paramBundle = new StringBuffer();
    paramBundle.append(((rp)localObject).a.a("meri_lastest_featrue", ""));
    if (((rp)localObject).h() > 0)
    {
      paramBundle.append('\n');
      paramBundle.append("更新包：");
      paramBundle.append(Unit.transformShortType(((rp)localObject).h(), true));
    }
    this.e.setText(paramBundle.toString());
  }
  
  protected void onStart()
  {
    rc.b.a().a(this.g);
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
    rc.b.a().b(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.UpdateDownloadDialog
 * JD-Core Version:    0.7.0.1
 */