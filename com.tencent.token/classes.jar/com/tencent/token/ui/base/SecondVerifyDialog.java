package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.ci;
import com.tencent.token.cv;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.encrypt.c;

public class SecondVerifyDialog
  extends Dialog
{
  ProDialog a = null;
  private TextView b;
  private TextView c;
  private Activity d;
  private EditText e;
  private Button f;
  private Button g;
  private Handler h;
  private boolean i = false;
  private int j;
  
  public SecondVerifyDialog(Activity paramActivity, int paramInt1, Handler paramHandler, int paramInt2)
  {
    super(paramActivity, paramInt1);
    this.d = paramActivity;
    this.h = paramHandler;
    this.j = paramInt2;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if ((this.d == null) || ((this.d != null) && (this.d.isFinishing())))
    {
      dismiss();
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2130968750);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837730);
    ((ViewGroup.MarginLayoutParams)findViewById(2131559221).getLayoutParams()).width = paramBundle.getWindowManager().getDefaultDisplay().getWidth();
    paramBundle = cv.a();
    this.b = ((TextView)findViewById(2131559223));
    if ((paramBundle.b() != null) && (paramBundle.b().length() > 0)) {
      this.b.setText(paramBundle.b());
    }
    for (;;)
    {
      this.c = ((TextView)findViewById(2131559224));
      if ((paramBundle.c() != null) && (paramBundle.c().length() > 0)) {
        this.c.setText(paramBundle.c());
      }
      this.e = ((EditText)findViewById(2131559225));
      this.e.clearFocus();
      this.f = ((Button)findViewById(2131559227));
      this.f.setText(paramBundle.e());
      this.f.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (SecondVerifyDialog.a(SecondVerifyDialog.this)) {
            return;
          }
          if (SecondVerifyDialog.b(SecondVerifyDialog.this) != null) {
            SecondVerifyDialog.b(SecondVerifyDialog.this).clearFocus();
          }
          SecondVerifyDialog.a(SecondVerifyDialog.this, true);
          if (SecondVerifyDialog.this.a != null)
          {
            SecondVerifyDialog.this.a.dismiss();
            SecondVerifyDialog.this.a = null;
          }
          SecondVerifyDialog.this.a = new ProDialog(SecondVerifyDialog.c(SecondVerifyDialog.this), 2131362182, SecondVerifyDialog.c(SecondVerifyDialog.this).getResources().getString(2131231392));
          SecondVerifyDialog.this.a.show();
          new UserTask()
          {
            public e a(String... paramAnonymous2VarArgs)
            {
              paramAnonymous2VarArgs = ci.a(c.b(SecondVerifyDialog.b(SecondVerifyDialog.this).getText().toString().trim().getBytes()));
              return cv.a().a(paramAnonymous2VarArgs, SecondVerifyDialog.d(SecondVerifyDialog.this));
            }
            
            public void a(e paramAnonymous2e)
            {
              SecondVerifyDialog.a(SecondVerifyDialog.this, false);
              SecondVerifyDialog.this.a.dismiss();
              SecondVerifyDialog.this.a = null;
              if (paramAnonymous2e.b())
              {
                g.a("perform2ndVerify success");
                SecondVerifyDialog.this.dismiss();
                if (SecondVerifyDialog.e(SecondVerifyDialog.this) != null)
                {
                  paramAnonymous2e = new Message();
                  paramAnonymous2e.what = 1012;
                  paramAnonymous2e.arg1 = SecondVerifyDialog.d(SecondVerifyDialog.this);
                  SecondVerifyDialog.e(SecondVerifyDialog.this).sendMessage(paramAnonymous2e);
                }
                return;
              }
              e.a(SecondVerifyDialog.c(SecondVerifyDialog.this).getResources(), paramAnonymous2e);
              g.c("perform2ndVerify failed:" + paramAnonymous2e.a + "-" + paramAnonymous2e.b);
              Toast localToast = new Toast(SecondVerifyDialog.c(SecondVerifyDialog.this));
              View localView = SecondVerifyDialog.c(SecondVerifyDialog.this).getLayoutInflater().inflate(2130968780, null);
              localToast.setView(localView);
              localToast.setDuration(0);
              localToast.setGravity(17, 0, (int)(40.0F * IndexActivity.S_DENSITY));
              ((TextView)localView.findViewById(2131558988)).setText(paramAnonymous2e.c);
              localToast.show();
            }
          }.c(new String[] { "" });
        }
      });
      this.g = ((Button)findViewById(2131559226));
      this.g.setText(paramBundle.d());
      this.g.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          SecondVerifyDialog.this.dismiss();
          if (SecondVerifyDialog.e(SecondVerifyDialog.this) != null)
          {
            paramAnonymousView = new Message();
            paramAnonymousView.what = 1013;
            paramAnonymousView.arg1 = SecondVerifyDialog.d(SecondVerifyDialog.this);
            SecondVerifyDialog.e(SecondVerifyDialog.this).sendMessage(paramAnonymousView);
          }
        }
      });
      return;
      this.b.setText(this.d.getResources().getString(2131230843));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.SecondVerifyDialog
 * JD-Core Version:    0.7.0.1
 */