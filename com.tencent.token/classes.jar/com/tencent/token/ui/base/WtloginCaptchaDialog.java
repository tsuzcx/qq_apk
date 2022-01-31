package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.cp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.x;

public class WtloginCaptchaDialog
  extends Dialog
{
  private static Handler g;
  cp a;
  Handler b = new do(this);
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
    localObject = x.a((byte[])localObject);
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
    this.a = cp.a(RqdApplication.l());
    setContentView(2130968826);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837730);
    ((ViewGroup.MarginLayoutParams)findViewById(2131559508).getLayoutParams()).width = paramBundle.getWindowManager().getDefaultDisplay().getWidth();
    this.i = findViewById(2131559511);
    this.d = ((EditText)findViewById(2131559513));
    if (this.d != null) {
      this.d.clearFocus();
    }
    this.h = ((ImageView)findViewById(2131559510));
    this.f = ((Button)findViewById(2131559514));
    this.f.setOnClickListener(new dp(this));
    this.e = ((TextView)findViewById(2131559512));
    this.e.setOnClickListener(new dq(this));
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.WtloginCaptchaDialog
 * JD-Core Version:    0.7.0.1
 */