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
import com.tencent.token.ck;
import com.tencent.token.cx;
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
    Activity localActivity = this.d;
    if ((localActivity != null) && ((localActivity == null) || (!localActivity.isFinishing())))
    {
      super.onCreate(paramBundle);
      setContentView(2131296431);
      paramBundle = getWindow();
      paramBundle.setBackgroundDrawableResource(2131099876);
      ((ViewGroup.MarginLayoutParams)findViewById(2131165962).getLayoutParams()).width = paramBundle.getWindowManager().getDefaultDisplay().getWidth();
      paramBundle = cx.a();
      this.b = ((TextView)findViewById(2131165966));
      if ((paramBundle.b() != null) && (paramBundle.b().length() > 0)) {
        this.b.setText(paramBundle.b());
      } else {
        this.b.setText(this.d.getResources().getString(2131492986));
      }
      this.c = ((TextView)findViewById(2131165964));
      if ((paramBundle.c() != null) && (paramBundle.c().length() > 0)) {
        this.c.setText(paramBundle.c());
      }
      this.e = ((EditText)findViewById(2131165963));
      this.e.clearFocus();
      this.f = ((Button)findViewById(2131165961));
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
          paramAnonymousView = SecondVerifyDialog.this;
          paramAnonymousView.a = new ProDialog(SecondVerifyDialog.c(paramAnonymousView), 2131558791, SecondVerifyDialog.c(SecondVerifyDialog.this).getResources().getString(2131493535));
          SecondVerifyDialog.this.a.show();
          new UserTask()
          {
            public e a(String... paramAnonymous2VarArgs)
            {
              paramAnonymous2VarArgs = ck.a(c.b(SecondVerifyDialog.b(SecondVerifyDialog.this).getText().toString().trim().getBytes()));
              return cx.a().a(paramAnonymous2VarArgs, SecondVerifyDialog.d(SecondVerifyDialog.this));
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
              }
              else
              {
                e.a(SecondVerifyDialog.c(SecondVerifyDialog.this).getResources(), paramAnonymous2e);
                Object localObject = new StringBuilder();
                ((StringBuilder)localObject).append("perform2ndVerify failed:");
                ((StringBuilder)localObject).append(paramAnonymous2e.a);
                ((StringBuilder)localObject).append("-");
                ((StringBuilder)localObject).append(paramAnonymous2e.b);
                g.c(((StringBuilder)localObject).toString());
                localObject = new Toast(SecondVerifyDialog.c(SecondVerifyDialog.this));
                View localView = SecondVerifyDialog.c(SecondVerifyDialog.this).getLayoutInflater().inflate(2131296461, null);
                ((Toast)localObject).setView(localView);
                ((Toast)localObject).setDuration(0);
                ((Toast)localObject).setGravity(17, 0, (int)(IndexActivity.S_DENSITY * 40.0F));
                ((TextView)localView.findViewById(2131166120)).setText(paramAnonymous2e.c);
                ((Toast)localObject).show();
              }
            }
          }.c(new String[] { "" });
        }
      });
      this.g = ((Button)findViewById(2131165960));
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
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.SecondVerifyDialog
 * JD-Core Version:    0.7.0.1
 */