package com.tencent.open.agent;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import aqcx;
import artp;
import artp.a;
import artr;
import arws;
import arwt;
import arxt;
import asch;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ChallengeActivity
  extends ChallengeBragBase
  implements View.OnClickListener, artp.a, asch
{
  protected ImageView Gi;
  protected ImageView Gj;
  protected KeyboardDetectorRelativeLayout a;
  protected InputFilter[] b;
  protected String cBB;
  protected String cBC;
  protected ScrollView p;
  protected ScrollView q;
  
  public void Zk(int paramInt)
  {
    int i = aqcx.px2dip(this, paramInt) - 10 - 10;
    if ((this.p != null) && (i < 255))
    {
      paramInt = i - 20 - 30 - 5 - 145;
      i = i - 20 - 5 - 145;
      if ((paramInt > 0) && (paramInt < 55))
      {
        this.p.setVisibility(0);
        this.p.getLayoutParams().height = aqcx.dip2px(this, paramInt);
        this.p.setVerticalFadingEdgeEnabled(true);
        this.q.getLayoutParams().height = aqcx.dip2px(this, 30.0F);
        this.q.setVerticalFadingEdgeEnabled(false);
        this.q.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    if ((paramInt <= 0) && (i > 0) && (i < 30))
    {
      this.p.getLayoutParams().height = 0;
      this.p.setVisibility(8);
      this.mTitle.getLayoutParams().height = aqcx.dip2px(this, i);
      this.q.setVerticalFadingEdgeEnabled(true);
      return;
    }
    this.p.getLayoutParams().height = 0;
    this.p.setVisibility(8);
    this.q.getLayoutParams().height = 0;
    this.q.setVisibility(8);
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (this.cBB.equals(paramString1)) {
      this.Gi.setImageBitmap(paramBitmap);
    }
    while (!this.cBC.equals(paramString1)) {
      return;
    }
    this.Gj.setImageBitmap(paramBitmap);
  }
  
  public void elc()
  {
    if (this.p != null)
    {
      this.p.getLayoutParams().height = aqcx.dip2px(this, 55.0F);
      this.p.setVerticalFadingEdgeEnabled(false);
      this.p.setVisibility(0);
      this.q.getLayoutParams().height = aqcx.dip2px(this, 30.0F);
      this.q.setVerticalFadingEdgeEnabled(false);
      this.q.setVisibility(0);
    }
  }
  
  @TargetApi(14)
  protected void initUI()
  {
    this.a = ((KeyboardDetectorRelativeLayout)super.findViewById(2131377458));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.a.setFitsSystemWindows(true);
      this.a.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.q = ((ScrollView)super.findViewById(2131379032));
    this.mTitle = ((TextView)super.findViewById(2131380842));
    this.bD = ((EditText)super.findViewById(2131366527));
    this.p = ((ScrollView)super.findViewById(2131379031));
    this.acN = ((TextView)super.findViewById(2131363741));
    this.acO = ((TextView)super.findViewById(2131363736));
    this.Gi = ((ImageView)super.findViewById(2131363206));
    this.Gj = ((ImageView)super.findViewById(2131363207));
    this.a.a(this);
    this.q.setVerticalFadingEdgeEnabled(false);
    this.b = new InputFilter[] { new arws(this.bD, 100) };
    this.bD.setFilters(this.b);
    this.bD.setText(this.cBF);
    if (this.p != null) {
      this.p.setVerticalFadingEdgeEnabled(false);
    }
    this.acN.setOnClickListener(this);
    this.acO.setOnClickListener(this);
    for (;;)
    {
      try
      {
        WS(this.cBE);
        this.cBB = artr.cg(this.mAppId, this.cBD);
        this.cBC = artr.cg(this.mAppId, this.cBE);
        Bitmap localBitmap1 = artp.a().Q(this.cBB);
        Bitmap localBitmap2 = artp.a().Q(this.cBC);
        if (localBitmap1 != null)
        {
          this.Gi.setImageBitmap(localBitmap1);
          if (localBitmap2 == null) {
            break;
          }
          this.Gj.setImageBitmap(localBitmap2);
          return;
        }
      }
      catch (Exception localException)
      {
        arwt.e("ChallengeActivity", "getNickName error. " + localException.getMessage(), localException);
        ele();
        return;
      }
      this.Gi.setImageResource(2130840645);
      artp.a().a(this.cBB, this);
    }
    this.Gj.setImageResource(2130840645);
    artp.a().a(this.cBC, this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().requestFeature(1);
    super.onCreate(paramBundle);
    super.setContentView(2131559875);
    super.QP();
    initUI();
    arxt.m("100", "ANDROIDQQ.PK.FS", this.mAppId, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeActivity
 * JD-Core Version:    0.7.0.1
 */