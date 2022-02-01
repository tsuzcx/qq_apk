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
import com.tencent.token.ca;
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
  ca a;
  Handler b = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((WtloginCaptchaDialog.a(WtloginCaptchaDialog.this) != null) && (!WtloginCaptchaDialog.a(WtloginCaptchaDialog.this).isFinishing()))
      {
        if (WtloginCaptchaDialog.a() == null) {
          return;
        }
        ((t)WtloginCaptchaDialog.a(WtloginCaptchaDialog.this)).dismissDialog();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("wtlogin : ret=");
        ((StringBuilder)localObject).append(paramAnonymousMessage.arg1);
        ((StringBuilder)localObject).append(", what=");
        ((StringBuilder)localObject).append(paramAnonymousMessage.what);
        g.c(((StringBuilder)localObject).toString());
        int i = paramAnonymousMessage.what;
        StringBuilder localStringBuilder;
        if (i != 4104)
        {
          switch (i)
          {
          default: 
            return;
          case 4100: 
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("K_MSGCODE_REFRESH_PICTURE ret=");
            ((StringBuilder)localObject).append(paramAnonymousMessage.arg1);
            g.b(((StringBuilder)localObject).toString());
            WtloginCaptchaDialog.e(WtloginCaptchaDialog.this);
            return;
          }
          i = paramAnonymousMessage.arg1;
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
            localObject = WtloginCaptchaDialog.a().obtainMessage(1019);
            ((Message)localObject).obj = paramAnonymousMessage.obj;
            paramAnonymousMessage = new Bundle();
            paramAnonymousMessage.putLong("appid", l1);
            ((Message)localObject).setData(paramAnonymousMessage);
            WtloginCaptchaDialog.a().sendMessage((Message)localObject);
            WtloginCaptchaDialog.this.dismiss();
            WtloginCaptchaDialog.a(null);
            WtloginCaptchaDialog.a(WtloginCaptchaDialog.this, null);
            return;
          }
          if (i == -1000)
          {
            WtloginCaptchaDialog.this.a(2131493103);
            return;
          }
          if (i == 8192)
          {
            WtloginCaptchaDialog.this.a(2131493550);
            return;
          }
          if (i == 2)
          {
            WtloginCaptchaDialog.this.a(2131493553);
            WtloginCaptchaDialog.this.a.a(WtloginCaptchaDialog.b(WtloginCaptchaDialog.this), WtloginCaptchaDialog.this.b);
            WtloginCaptchaDialog.c(WtloginCaptchaDialog.this).setVisibility(0);
            WtloginCaptchaDialog.d(WtloginCaptchaDialog.this).setText("");
            return;
          }
          if (i == 1)
          {
            WtloginCaptchaDialog.this.a(2131493548);
            WtloginCaptchaDialog.this.dismiss();
            WtloginCaptchaDialog.a(null);
            WtloginCaptchaDialog.a(WtloginCaptchaDialog.this, null);
            return;
          }
          if ((i != 40) && (i != 42) && (i != 64))
          {
            if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("loginerror") != null))
            {
              localObject = WtloginCaptchaDialog.this;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(WtloginCaptchaDialog.a(WtloginCaptchaDialog.this).getResources().getString(2131493554));
              localStringBuilder.append(":");
              localStringBuilder.append(paramAnonymousMessage.getData().getString("loginerror"));
              ((WtloginCaptchaDialog)localObject).a(localStringBuilder.toString());
              return;
            }
            WtloginCaptchaDialog.this.a(2131493554);
            return;
          }
          WtloginCaptchaDialog.this.dismiss();
          ((BaseActivity)WtloginCaptchaDialog.a(WtloginCaptchaDialog.this)).goToRemoveProtectH5(WtloginCaptchaDialog.a(WtloginCaptchaDialog.this), paramAnonymousMessage, i);
          return;
        }
        if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
        {
          localObject = WtloginCaptchaDialog.this;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(WtloginCaptchaDialog.a(WtloginCaptchaDialog.this).getResources().getString(2131493554));
          localStringBuilder.append(":");
          localStringBuilder.append(paramAnonymousMessage.getData().getString("exception"));
          ((WtloginCaptchaDialog)localObject).a(localStringBuilder.toString());
          return;
        }
        WtloginCaptchaDialog.this.a(2131493554);
        return;
      }
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
    Toast localToast;
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (this.c.isFinishing()) {
        return;
      }
      localToast = this.k;
      if (localToast == null) {
        this.k = Toast.makeText(this.c, paramString, 0);
      }
    }
    try
    {
      localToast.setText(paramString);
    }
    catch (Exception localException)
    {
      label55:
      break label55;
    }
    this.k = Toast.makeText(this.c, paramString, 0);
    this.k.setGravity(48, 0, IndexActivity.S_TITLE_HEIGHT + 5);
    this.k.show();
    return;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Activity localActivity = this.c;
    if ((localActivity != null) && ((localActivity == null) || (!localActivity.isFinishing())))
    {
      super.onCreate(paramBundle);
      this.a = ca.a(RqdApplication.n());
      setContentView(2131296507);
      paramBundle = getWindow();
      paramBundle.setBackgroundDrawableResource(2131099876);
      ((ViewGroup.MarginLayoutParams)findViewById(2131165358).getLayoutParams()).width = paramBundle.getWindowManager().getDefaultDisplay().getWidth();
      this.i = findViewById(2131165826);
      this.d = ((EditText)findViewById(2131165360));
      paramBundle = this.d;
      if (paramBundle != null) {
        paramBundle.clearFocus();
      }
      this.h = ((ImageView)findViewById(2131165359));
      this.f = ((Button)findViewById(2131165362));
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
          if ((paramAnonymousView != null) && (paramAnonymousView.length() != 0))
          {
            ((InputMethodManager)WtloginCaptchaDialog.a(WtloginCaptchaDialog.this).getSystemService("input_method")).hideSoftInputFromWindow(WtloginCaptchaDialog.this.getWindow().peekDecorView().getWindowToken(), 0);
            paramAnonymousView = paramAnonymousView.trim();
            ((t)WtloginCaptchaDialog.a(WtloginCaptchaDialog.this)).showProDialog(WtloginCaptchaDialog.a(WtloginCaptchaDialog.this), 2131492986, null);
            WtloginCaptchaDialog.this.a.a(WtloginCaptchaDialog.b(WtloginCaptchaDialog.this), paramAnonymousView.getBytes(), WtloginCaptchaDialog.this.b);
            return;
          }
          WtloginCaptchaDialog.this.a(2131493032);
        }
      });
      this.e = ((TextView)findViewById(2131165357));
      this.e.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          WtloginCaptchaDialog.this.a.a(WtloginCaptchaDialog.b(WtloginCaptchaDialog.this), WtloginCaptchaDialog.this.b);
          WtloginCaptchaDialog.c(WtloginCaptchaDialog.this).setVisibility(0);
        }
      });
      b();
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.WtloginCaptchaDialog
 * JD-Core Version:    0.7.0.1
 */