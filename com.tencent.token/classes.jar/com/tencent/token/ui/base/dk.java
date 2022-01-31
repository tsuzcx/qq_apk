package com.tencent.token.ui.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.e;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.UtilsActivity;
import com.tencent.token.ui.WtloginFinishNoMibaoActivity;

public final class dk
  extends LinearLayout
{
  public Handler a = new dl(this);
  private BaseActivity b;
  private LayoutInflater c;
  private View d;
  private int e;
  private ImageView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private Button j;
  private final long k = 523005425L;
  private final int l = 2;
  private UpgradeDeterminResult m;
  private boolean n = false;
  private byte[] o;
  private long p;
  private int[] q = { 2131362194, 2131362196, 2131362454, 2131362188, 2131362252, 2131362197, 2131362201, 2131362198, 2131362517 };
  private View.OnClickListener r = new dn(this);
  private View.OnClickListener s = new dr(this);
  
  public dk(BaseActivity paramBaseActivity, int paramInt)
  {
    super(paramBaseActivity);
    this.b = paramBaseActivity;
    this.e = paramInt;
    this.c = ((LayoutInflater)this.b.getSystemService("layout_inflater"));
    this.d = this.c.inflate(2130903249, null);
    removeAllViews();
    addView(this.d, new LinearLayout.LayoutParams(-1, -1));
    this.f = ((ImageView)findViewById(2131297229));
    this.g = ((TextView)findViewById(2131297230));
    this.h = ((TextView)findViewById(2131297231));
    this.i = ((TextView)findViewById(2131297232));
    this.j = ((Button)findViewById(2131297297));
    paramBaseActivity = getResources().getString(2131362231);
    e.a("flag show scene id: " + this.e);
    String str;
    if ((this.e >= 0) && (this.e < UtilsActivity.mIcons.length))
    {
      this.f.setImageDrawable(getResources().getDrawable(UtilsActivity.mIcons[this.e]));
      this.g.setText(this.q[this.e]);
      str = getResources().getString(2131362189) + getResources().getString(UtilsActivity.mTexts[this.e]) + "?";
      paramBaseActivity = getResources().getString(2131362190) + getResources().getString(UtilsActivity.mTexts[this.e]) + paramBaseActivity;
      this.h.setText(str);
      this.i.setText(paramBaseActivity);
    }
    for (;;)
    {
      this.j.setOnClickListener(this.r);
      paramBaseActivity = ax.a().e();
      if (paramBaseActivity != null) {
        this.p = paramBaseActivity.mRealUin;
      }
      return;
      if (this.e == -1)
      {
        this.f.setImageDrawable(getResources().getDrawable(2130837680));
        this.g.setText(2131362199);
        str = getResources().getString(2131362189) + getResources().getString(2131362179) + "?";
        paramBaseActivity = getResources().getString(2131362190) + getResources().getString(2131362179) + paramBaseActivity;
        this.h.setText(str);
        this.i.setText(paramBaseActivity);
      }
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
        if ((this.n) && (paramKeyEvent.getAction() == 0)) {}
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
 * Qualified Name:     com.tencent.token.ui.base.dk
 * JD-Core Version:    0.7.0.1
 */