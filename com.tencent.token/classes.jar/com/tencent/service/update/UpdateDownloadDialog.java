package com.tencent.service.update;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ace;
import com.tencent.token.aib.a;
import com.tencent.token.cl;
import com.tencent.token.dj;
import com.tencent.token.dy;
import com.tencent.token.hi;
import com.tencent.token.rw;
import com.tencent.token.rw.a;
import com.tencent.token.rw.b;
import com.tencent.token.rw.c;
import com.tencent.token.sh;
import com.tencent.token.sj;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.yt;
import com.tmsdk.TMSDKContext;
import com.tmsdk.Unit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UpdateDownloadDialog
  extends Dialog
{
  private static String[] i = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" };
  Activity a;
  rw.a b;
  Button c;
  TextView d;
  TextView e;
  Handler f = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 99) {
        UpdateDownloadDialog.this.b();
      }
    }
  };
  rw.c g = new rw.c()
  {
    public final void a(rw.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public final void b(rw.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public final void c(rw.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
    
    public final void d(rw.a paramAnonymousa)
    {
      UpdateDownloadDialog.this.a(paramAnonymousa);
    }
  };
  yt h;
  
  public UpdateDownloadDialog(Activity paramActivity, rw.a parama)
  {
    super(paramActivity, 2131558791);
    this.a = paramActivity;
    this.b = parama;
  }
  
  private boolean d()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = i;
    int k = arrayOfString.length;
    int j = 0;
    for (;;)
    {
      String str;
      if (j < k) {
        str = arrayOfString[j];
      }
      try
      {
        if (dj.a(this.a, str) != 0) {
          localArrayList.add(str);
        }
        label51:
        j += 1;
        continue;
        return localArrayList.size() > 0;
      }
      catch (Exception localException)
      {
        break label51;
      }
    }
  }
  
  final void a()
  {
    if (d())
    {
      ace.a(this.a, "为确保服务正常运行，保障帐号安全，向您提供应用文件下载、存储服务，我们需要访问您的SD卡权限。如您此前曾拒绝或关闭此权限，您需前往系统进行开启。", new aib.a()
      {
        public final void a(boolean paramAnonymousBoolean)
        {
          UpdateDownloadDialog localUpdateDownloadDialog;
          String[] arrayOfString;
          Object localObject;
          if (paramAnonymousBoolean)
          {
            localUpdateDownloadDialog = UpdateDownloadDialog.this;
            arrayOfString = UpdateDownloadDialog.c();
            localObject = new yt()
            {
              public final void a()
              {
                new Handler(Looper.myLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    UpdateDownloadDialog.this.a();
                  }
                });
              }
              
              public final void b() {}
            };
            if (Build.VERSION.SDK_INT < 23)
            {
              ((yt)localObject).a();
              return;
            }
          }
          for (;;)
          {
            int i;
            try
            {
              localUpdateDownloadDialog.h = ((yt)localObject);
              localObject = new ArrayList();
              int j = arrayOfString.length;
              i = 0;
              if (i < j)
              {
                String str = arrayOfString[i];
                if (dj.a(localUpdateDownloadDialog.a, str) == 0) {
                  break label167;
                }
                ((List)localObject).add(str);
                break label167;
              }
              if (!((List)localObject).isEmpty())
              {
                cl.a(localUpdateDownloadDialog.a, (String[])((List)localObject).toArray(new String[((List)localObject).size()]), 1);
                return;
              }
              if (localUpdateDownloadDialog.h != null) {
                localUpdateDownloadDialog.h.a();
              }
              return;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            return;
            label167:
            i += 1;
          }
        }
      });
      return;
    }
    if (this.b == null) {
      return;
    }
    switch (6.a[this.b.f.ordinal()])
    {
    default: 
      return;
    case 7: 
      rw.b.a().d(this.b);
      return;
    case 6: 
      rw.a(this.a, new File(rw.a(), this.b.d));
      return;
    case 4: 
    case 5: 
      rw.b.a().b(this.b);
      return;
    }
    sj localsj = sj.a();
    localsj.k(2);
    localsj.c(true);
    rw.b.a().c(this.b);
    TMSDKContext.saveActionData(1150107);
  }
  
  final void a(rw.a parama)
  {
    if (parama == this.b)
    {
      this.f.removeMessages(99);
      this.f.sendEmptyMessage(99);
    }
  }
  
  final void b()
  {
    if (this.b == null) {
      return;
    }
    switch (6.a[this.b.f.ordinal()])
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
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296481);
    paramBundle = getWindow();
    Object localObject = paramBundle.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = ((int)(this.a.getWindowManager().getDefaultDisplay().getWidth() - IndexActivity.S_DENSITY * 46.0F));
    paramBundle.setAttributes((WindowManager.LayoutParams)localObject);
    this.c = ((Button)findViewById(2131165860));
    this.d = ((TextView)findViewById(2131166154));
    this.e = ((TextView)findViewById(2131165764));
    paramBundle = (ImageView)findViewById(2131165392);
    localObject = dy.d(hi.b(this.a, 2131099745));
    dy.a((Drawable)localObject, -16777216);
    paramBundle.setImageDrawable((Drawable)localObject);
    paramBundle.setOnClickListener(new View.OnClickListener()
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
        UpdateDownloadDialog.this.a();
      }
    });
    b();
    localObject = sj.a();
    paramBundle = String.format("新版本V%1$d.%2$d.%3$d", new Object[] { Integer.valueOf(((sj)localObject).d()), Integer.valueOf(((sj)localObject).e()), Integer.valueOf(((sj)localObject).f()) });
    if (!TextUtils.isEmpty(((sj)localObject).j())) {
      paramBundle = ((sj)localObject).j();
    }
    this.d.setText(paramBundle);
    paramBundle = new StringBuffer();
    paramBundle.append(((sj)localObject).a.a("meri_lastest_featrue", ""));
    if (((sj)localObject).h() > 0)
    {
      paramBundle.append('\n');
      paramBundle.append("更新包：");
      paramBundle.append(Unit.transformShortType(((sj)localObject).h(), true));
    }
    this.e.setText(paramBundle.toString());
  }
  
  protected void onStart()
  {
    rw.b.a().a(this.g);
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
    rw.b.a().b(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.UpdateDownloadDialog
 * JD-Core Version:    0.7.0.1
 */