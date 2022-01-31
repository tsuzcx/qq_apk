package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.dw;

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
    ((ViewGroup.MarginLayoutParams)findViewById(2131559220).getLayoutParams()).width = paramBundle.getWindowManager().getDefaultDisplay().getWidth();
    paramBundle = dw.a();
    this.b = ((TextView)findViewById(2131559222));
    if ((paramBundle.b() != null) && (paramBundle.b().length() > 0)) {
      this.b.setText(paramBundle.b());
    }
    for (;;)
    {
      this.c = ((TextView)findViewById(2131559223));
      if ((paramBundle.c() != null) && (paramBundle.c().length() > 0)) {
        this.c.setText(paramBundle.c());
      }
      this.e = ((EditText)findViewById(2131559224));
      this.e.clearFocus();
      this.f = ((Button)findViewById(2131559226));
      this.f.setText(paramBundle.e());
      this.f.setOnClickListener(new cp(this));
      this.g = ((Button)findViewById(2131559225));
      this.g.setText(paramBundle.d());
      this.g.setOnClickListener(new cr(this));
      return;
      this.b.setText(this.d.getResources().getString(2131230843));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.SecondVerifyDialog
 * JD-Core Version:    0.7.0.1
 */