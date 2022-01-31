package com.tencent.token.ui.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.WtloginFinishNoMibaoActivity;

public final class bh
  extends LinearLayout
{
  public Handler a = new bi(this);
  private BaseActivity b;
  private LayoutInflater c;
  private View d;
  private Button e;
  private final long f = 523005425L;
  private final int g = 2;
  private UpgradeDeterminResult h;
  private boolean i = false;
  private byte[] j;
  private long k;
  private View.OnClickListener l = new bk(this);
  private View.OnClickListener m = new bo(this);
  
  public bh(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
    this.b = paramBaseActivity;
    this.c = ((LayoutInflater)this.b.getSystemService("layout_inflater"));
    this.d = this.c.inflate(2130903111, null);
    removeAllViews();
    addView(this.d, new LinearLayout.LayoutParams(-1, -1));
    this.e = ((Button)findViewById(2131296725));
    ((TextView)findViewById(2131296724)).setText(getResources().getString(2131362190) + getResources().getString(2131362455) + getResources().getString(2131362231));
    this.e.setOnClickListener(this.l);
    paramBaseActivity = ax.a().e();
    if (paramBaseActivity != null) {
      this.k = paramBaseActivity.mRealUin;
    }
  }
  
  private void a()
  {
    Intent localIntent = new Intent(this.b, WtloginFinishNoMibaoActivity.class);
    localIntent.putExtra("uin", ax.a().e().mRealUin);
    this.b.startActivity(localIntent);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.i) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          bool = super.dispatchKeyEvent(paramKeyEvent);
          return bool;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bh
 * JD-Core Version:    0.7.0.1
 */