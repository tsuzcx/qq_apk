package com.tencent.token.ui.base;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.global.e;
import com.tencent.token.gv;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.utils.t;
import java.util.Random;

public class CaptchaDialog
  extends Dialog
{
  ProDialog a = null;
  public Handler b = new a(this);
  private BaseActivity c;
  private EditText d;
  private TextView e;
  private Button f;
  private Handler g;
  private ImageView h;
  private View i;
  private boolean j = false;
  private QueryCaptchaResult k;
  private final int l = -100;
  private final int m = -101;
  private Bitmap n;
  
  public CaptchaDialog(BaseActivity paramBaseActivity, Handler paramHandler, QueryCaptchaResult paramQueryCaptchaResult)
  {
    super(paramBaseActivity, 2131427400);
    this.c = paramBaseActivity;
    this.g = paramHandler;
    this.k = paramQueryCaptchaResult;
  }
  
  public final void a()
  {
    this.i.setVisibility(0);
    this.h.setVisibility(4);
    new Thread(new d(this)).start();
  }
  
  public final void b()
  {
    if ((this.k.mCaptchaUrl == null) || (this.k.mCaptchaUrl.length() == 0))
    {
      this.b.sendEmptyMessage(-101);
      return;
    }
    if (System.currentTimeMillis() / 1000L - this.k.mLastGetUrlTime >= this.k.mUrlValidTimeSecs) {}
    for (int i1 = 0; i1 == 0; i1 = 1)
    {
      af.a().f(this.k.mRealUin, this.k.mSceneId, this.b);
      this.b.sendEmptyMessage(-101);
      return;
    }
    long l2 = new Random(System.currentTimeMillis()).nextLong();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = Math.abs(l2);
    }
    String str = this.k.mCaptchaUrl + ".jpg?r=" + l1;
    byte[] arrayOfByte = new gv().a(str);
    if (arrayOfByte == null)
    {
      this.b.sendEmptyMessage(-101);
      return;
    }
    this.n = t.a(arrayOfByte);
    e.a("getCaptchaImage url: " + str + ", bmp" + this.n);
    this.b.sendEmptyMessage(-100);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((com.tencent.token.global.b.d()) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      if (this.g != null)
      {
        paramKeyEvent = new Message();
        paramKeyEvent.what = 1017;
        this.g.sendMessage(paramKeyEvent);
        dismiss();
        return true;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if ((this.c == null) || ((this.c != null) && (this.c.isFinishing()))) {
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2130903063);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837639);
    ((ViewGroup.MarginLayoutParams)findViewById(2131296461).getLayoutParams()).width = paramBundle.getWindowManager().getDefaultDisplay().getWidth();
    this.i = findViewById(2131296464);
    this.d = ((EditText)findViewById(2131296466));
    this.d.clearFocus();
    this.h = ((ImageView)findViewById(2131296463));
    this.f = ((Button)findViewById(2131296467));
    this.f.setOnClickListener(new b(this));
    this.e = ((TextView)findViewById(2131296465));
    this.e.setOnClickListener(new c(this));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.CaptchaDialog
 * JD-Core Version:    0.7.0.1
 */