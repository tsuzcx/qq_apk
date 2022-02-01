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
import com.tencent.token.rb;
import com.tencent.token.rb.a;
import com.tencent.token.rb.b;
import com.tencent.token.rb.c;
import com.tencent.token.rm;
import com.tencent.token.ro;
import com.tencent.token.ui.IndexActivity;
import com.tmsdk.TMSDKContext;
import com.tmsdk.Unit;
import java.io.File;

public class UpdateDownloadDialog
  extends Dialog
{
  Context a;
  rb.a b;
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
  rb.c g = new rb.c()
  {
    public final void a(rb.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public final void b(rb.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public final void c(rb.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public final void d(rb.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
  };
  
  public UpdateDownloadDialog(Context paramContext, rb.a parama)
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
  
  final void a(rb.a parama)
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
            rb.b.a().d(paramAnonymousView.b);
            return;
          case 6: 
            rb.a(paramAnonymousView.a, new File(rb.a(), paramAnonymousView.b.d));
            return;
          case 4: 
          case 5: 
            rb.b.a().b(paramAnonymousView.b);
            return;
          }
          ro localro = ro.a();
          localro.k(2);
          localro.c(true);
          rb.b.a().c(paramAnonymousView.b);
          TMSDKContext.saveActionData(1150107);
          return;
        }
      }
    });
    a();
    localObject = ro.a();
    paramBundle = String.format("新版本V%1$d.%2$d.%3$d", new Object[] { Integer.valueOf(((ro)localObject).d()), Integer.valueOf(((ro)localObject).e()), Integer.valueOf(((ro)localObject).f()) });
    if (!TextUtils.isEmpty(((ro)localObject).j())) {
      paramBundle = ((ro)localObject).j();
    }
    this.d.setText(paramBundle);
    paramBundle = new StringBuffer();
    paramBundle.append(((ro)localObject).a.a("meri_lastest_featrue", ""));
    if (((ro)localObject).h() > 0)
    {
      paramBundle.append('\n');
      paramBundle.append("更新包：");
      paramBundle.append(Unit.transformShortType(((ro)localObject).h(), true));
    }
    this.e.setText(paramBundle.toString());
  }
  
  protected void onStart()
  {
    rb.b.a().a(this.g);
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
    rb.b.a().b(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.UpdateDownloadDialog
 * JD-Core Version:    0.7.0.1
 */