package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import aqcx;
import arqe;
import artp;
import arws;
import arwt;
import arxt;
import asch;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;

public class BragActivity
  extends ChallengeBragBase
  implements asch
{
  public ImageView Ge;
  protected KeyboardDetectorRelativeLayout a;
  protected InputFilter[] b;
  protected ScrollView n;
  
  public void Zk(int paramInt)
  {
    paramInt = aqcx.px2dip(this, paramInt) - 10 - 10;
    if ((this.n != null) && (paramInt < 255))
    {
      paramInt = paramInt - 20 - 145;
      if ((paramInt <= 0) || (paramInt >= 90)) {
        break label79;
      }
      this.n.setVisibility(0);
      this.n.getLayoutParams().height = aqcx.dip2px(this, paramInt);
      this.n.setVerticalFadingEdgeEnabled(true);
    }
    label79:
    while (paramInt > 0) {
      return;
    }
    this.n.getLayoutParams().height = 0;
    this.n.setVisibility(8);
  }
  
  public void elc()
  {
    if (this.Ge != null)
    {
      this.Ge.getLayoutParams().height = aqcx.dip2px(this, 90.0F);
      this.Ge.setVerticalFadingEdgeEnabled(false);
      this.Ge.setVisibility(0);
    }
  }
  
  protected void initUI()
  {
    this.n = ((ScrollView)super.findViewById(2131363716));
    this.a = ((KeyboardDetectorRelativeLayout)super.findViewById(2131377399));
    this.a.a(this);
    this.Ge = ((ImageView)super.findViewById(2131363715));
    this.bD = ((EditText)super.findViewById(2131366527));
    this.acN = ((TextView)super.findViewById(2131365858));
    this.acO = ((TextView)super.findViewById(2131365852));
    this.mTitle = ((TextView)super.findViewById(2131380583));
    this.b = new InputFilter[] { new arws(this.bD, 100) };
    this.bD.setFilters(this.b);
    this.bD.setText(this.cBF);
    this.acN.setOnClickListener(this);
    this.acO.setOnClickListener(this);
    try
    {
      WS(this.cBE);
      Bitmap localBitmap = artp.a().Q(this.mImageUrl);
      if (localBitmap != null)
      {
        this.Ge.setImageBitmap(localBitmap);
        return;
      }
    }
    catch (Exception localException)
    {
      arwt.e("BragActivity", "getNickName error. " + localException.getMessage(), localException);
      ele();
      return;
    }
    this.Ge.setImageResource(2130840645);
    artp.a().a(this.mImageUrl, new arqe(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().requestFeature(1);
    super.onCreate(paramBundle);
    super.setContentView(2131559874);
    super.QP();
    initUI();
    arxt.m("100", "ANDROIDQQ.BRAG.FS", this.mAppId, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BragActivity
 * JD-Core Version:    0.7.0.1
 */