package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.ty;
import com.tencent.token.utils.UserTask;
import com.tencent.token.xt;

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
  
  public SecondVerifyDialog(Activity paramActivity, Handler paramHandler, int paramInt)
  {
    super(paramActivity, 2131558791);
    this.d = paramActivity;
    this.h = paramHandler;
    this.j = paramInt;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Activity localActivity = this.d;
    if ((localActivity != null) && ((localActivity == null) || (!localActivity.isFinishing())))
    {
      super.onCreate(paramBundle);
      setContentView(2131296445);
      paramBundle = getWindow();
      paramBundle.setBackgroundDrawableResource(2131099877);
      ((ViewGroup.MarginLayoutParams)findViewById(2131166004).getLayoutParams()).width = paramBundle.getWindowManager().getDefaultDisplay().getWidth();
      paramBundle = ty.a();
      this.b = ((TextView)findViewById(2131166008));
      if ((paramBundle.c != null) && (paramBundle.c.length() > 0)) {
        this.b.setText(paramBundle.c);
      } else {
        this.b.setText(this.d.getResources().getString(2131492987));
      }
      this.c = ((TextView)findViewById(2131166006));
      if ((paramBundle.b != null) && (paramBundle.b.length() > 0)) {
        this.c.setText(paramBundle.b);
      }
      this.e = ((EditText)findViewById(2131166005));
      this.e.clearFocus();
      this.f = ((Button)findViewById(2131166003));
      this.f.setText(paramBundle.e);
      this.f.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
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
          paramAnonymousView.a = new ProDialog(SecondVerifyDialog.c(paramAnonymousView), SecondVerifyDialog.c(SecondVerifyDialog.this).getResources().getString(2131493544));
          SecondVerifyDialog.this.a.show();
          new UserTask() {}.a(new String[] { "" });
        }
      });
      this.g = ((Button)findViewById(2131166002));
      this.g.setText(paramBundle.d);
      this.g.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
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