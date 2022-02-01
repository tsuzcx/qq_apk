package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.by;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.t;
import com.tencent.token.utils.m;

public class WtloginCaptchaDialog
  extends Dialog
{
  private static Handler g;
  by a;
  Handler b = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((WtloginCaptchaDialog.a(WtloginCaptchaDialog.this) == null) || (WtloginCaptchaDialog.a(WtloginCaptchaDialog.this).isFinishing()) || (WtloginCaptchaDialog.a() == null)) {
        return;
      }
      ((t)WtloginCaptchaDialog.a(WtloginCaptchaDialog.this)).dismissDialog();
      g.c("wtlogin : ret=" + paramAnonymousMessage.arg1 + ", what=" + paramAnonymousMessage.what);
      switch (paramAnonymousMessage.what)
      {
      case 4101: 
      case 4102: 
      case 4103: 
      default: 
        return;
      case 4099: 
        int i = paramAnonymousMessage.arg1;
        long l2 = 523005419L;
        long l1 = l2;
        if (paramAnonymousMessage.getData() != null)
        {
          l1 = l2;
          if (paramAnonymousMessage.getData().getLong("appid") != 0L) {
            l1 = paramAnonymousMessage.getData().getLong("appid");
          }
        }
        if (i == 0)
        {
          Message localMessage = WtloginCaptchaDialog.a().obtainMessage(1019);
          localMessage.obj = paramAnonymousMessage.obj;
          paramAnonymousMessage = new Bundle();
          paramAnonymousMessage.putLong("appid", l1);
          localMessage.setData(paramAnonymousMessage);
          WtloginCaptchaDialog.a().sendMessage(localMessage);
          WtloginCaptchaDialog.this.dismiss();
          WtloginCaptchaDialog.a(null);
          WtloginCaptchaDialog.a(WtloginCaptchaDialog.this, null);
          return;
        }
        if (i == -1000)
        {
          WtloginCaptchaDialog.this.a(2131230960);
          return;
        }
        if (i == 8192)
        {
          WtloginCaptchaDialog.this.a(2131231407);
          return;
        }
        if (i == 2)
        {
          WtloginCaptchaDialog.this.a(2131231410);
          WtloginCaptchaDialog.this.a.a(WtloginCaptchaDialog.b(WtloginCaptchaDialog.this), WtloginCaptchaDialog.this.b);
          WtloginCaptchaDialog.c(WtloginCaptchaDialog.this).setVisibility(0);
          WtloginCaptchaDialog.d(WtloginCaptchaDialog.this).setText("");
          return;
        }
        if (i == 1)
        {
          WtloginCaptchaDialog.this.a(2131231405);
          WtloginCaptchaDialog.this.dismiss();
          WtloginCaptchaDialog.a(null);
          WtloginCaptchaDialog.a(WtloginCaptchaDialog.this, null);
          return;
        }
        if ((i == 40) || (i == 42) || (i == 64))
        {
          WtloginCaptchaDialog.this.dismiss();
          ((BaseActivity)WtloginCaptchaDialog.a(WtloginCaptchaDialog.this)).goToRemoveProtectH5(WtloginCaptchaDialog.a(WtloginCaptchaDialog.this), paramAnonymousMessage, i);
          return;
        }
        if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("loginerror") != null))
        {
          WtloginCaptchaDialog.this.a(WtloginCaptchaDialog.a(WtloginCaptchaDialog.this).getResources().getString(2131231411) + ":" + paramAnonymousMessage.getData().getString("loginerror"));
          return;
        }
        WtloginCaptchaDialog.this.a(2131231411);
        return;
      case 4100: 
        g.b("K_MSGCODE_REFRESH_PICTURE ret=" + paramAnonymousMessage.arg1);
        WtloginCaptchaDialog.e(WtloginCaptchaDialog.this);
        return;
      }
      if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
      {
        WtloginCaptchaDialog.this.a(WtloginCaptchaDialog.a(WtloginCaptchaDialog.this).getResources().getString(2131231411) + ":" + paramAnonymousMessage.getData().getString("exception"));
        return;
      }
      WtloginCaptchaDialog.this.a(2131231411);
    }
  };
  private Activity c;
  private EditText d;
  private TextView e;
  private Button f;
  private ImageView h;
  private View i;
  private String j;
  private Toast k;
  
  public WtloginCaptchaDialog(Activity paramActivity, int paramInt, Handler paramHandler, String paramString)
  {
    super(paramActivity, paramInt);
    this.c = paramActivity;
    g = paramHandler;
    this.j = paramString;
  }
  
  private void b()
  {
    this.i.setVisibility(4);
    Object localObject = this.a.d(this.j);
    if (localObject == null) {
      return;
    }
    localObject = m.a((byte[])localObject);
    this.h.setImageBitmap((Bitmap)localObject);
  }
  
  public void a(int paramInt)
  {
    if (this.c.isFinishing()) {
      return;
    }
    a(this.c.getResources().getString(paramInt));
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (this.c.isFinishing())) {
      return;
    }
    if (this.k == null) {
      this.k = Toast.makeText(this.c, paramString, 0);
    }
    for (;;)
    {
      this.k.setGravity(48, 0, IndexActivity.S_TITLE_HEIGHT + 5);
      this.k.show();
      return;
      try
      {
        this.k.setText(paramString);
      }
      catch (Exception localException)
      {
        this.k = Toast.makeText(this.c, paramString, 0);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if ((this.c == null) || ((this.c != null) && (this.c.isFinishing())))
    {
      dismiss();
      return;
    }
    super.onCreate(paramBundle);
    this.a = by.a(RqdApplication.l());
    setContentView(2130968826);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837730);
    ((ViewGroup.MarginLayoutParams)findViewById(2131559509).getLayoutParams()).width = paramBundle.getWindowManager().getDefaultDisplay().getWidth();
    this.i = findViewById(2131559512);
    this.d = ((EditText)findViewById(2131559514));
    if (this.d != null) {
      this.d.clearFocus();
    }
    this.h = ((ImageView)findViewById(2131559511));
    this.f = ((Button)findViewById(2131559515));
    this.f.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (WtloginCaptchaDialog.a(WtloginCaptchaDialog.this) == null) {
          return;
        }
        if (WtloginCaptchaDialog.d(WtloginCaptchaDialog.this) != null) {
          WtloginCaptchaDialog.d(WtloginCaptchaDialog.this).clearFocus();
        }
        paramAnonymousView = WtloginCaptchaDialog.d(WtloginCaptchaDialog.this).getText().toString();
        if ((paramAnonymousView == null) || (paramAnonymousView.length() == 0))
        {
          WtloginCaptchaDialog.this.a(2131230889);
          return;
        }
        ((InputMethodManager)WtloginCaptchaDialog.a(WtloginCaptchaDialog.this).getSystemService("input_method")).hideSoftInputFromWindow(WtloginCaptchaDialog.this.getWindow().peekDecorView().getWindowToken(), 0);
        paramAnonymousView = paramAnonymousView.trim();
        ((t)WtloginCaptchaDialog.a(WtloginCaptchaDialog.this)).showProDialog(WtloginCaptchaDialog.a(WtloginCaptchaDialog.this), 2131230843, null);
        WtloginCaptchaDialog.this.a.a(WtloginCaptchaDialog.b(WtloginCaptchaDialog.this), paramAnonymousView.getBytes(), WtloginCaptchaDialog.this.b);
      }
    });
    this.e = ((TextView)findViewById(2131559513));
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WtloginCaptchaDialog.this.a.a(WtloginCaptchaDialog.b(WtloginCaptchaDialog.this), WtloginCaptchaDialog.this.b);
        WtloginCaptchaDialog.c(WtloginCaptchaDialog.this).setVisibility(0);
      }
    });
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.WtloginCaptchaDialog
 * JD-Core Version:    0.7.0.1
 */