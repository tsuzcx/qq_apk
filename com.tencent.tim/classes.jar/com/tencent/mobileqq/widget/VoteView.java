package com.tencent.mobileqq.widget;

import afcy;
import ahyp;
import alek;
import alen;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import arjq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.a;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;

public class VoteView
  extends RelativeLayout
  implements PraiseManager.a
{
  public ImageView FM;
  public SingleLineTextView I;
  private boolean SA;
  public TextView Vt;
  ahyp jdField_a_of_type_Ahyp;
  alek jdField_a_of_type_Alek = new alek();
  HeartLayout b;
  public FrameLayout bN;
  public int cQn;
  private boolean crp;
  private double cx;
  public boolean dbR;
  private boolean dbS;
  public int dmk;
  public QQAppInterface mApp;
  public RelativeLayout my;
  
  public VoteView(Context paramContext)
  {
    super(paramContext);
    initViews();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViews();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initViews();
  }
  
  private void initViews()
  {
    this.crp = false;
    this.SA = false;
    this.cQn = 0;
    this.dmk = 0;
    Object localObject1 = getResources();
    this.cx = ((Resources)localObject1).getDisplayMetrics().density;
    this.my = new RelativeLayout(getContext());
    this.my.setId(2131369959);
    this.my.setBackgroundResource(2130846798);
    this.my.setPadding((int)(this.cx * 8.0D), (int)(this.cx * 3.0D), (int)(this.cx * 8.0D), (int)(this.cx * 3.0D));
    Object localObject2 = new RelativeLayout.LayoutParams(-2, (int)(this.cx * 24.0D));
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(this.cx * 6.0D));
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2131561624, null);
    localViewGroup.setId(2131370147);
    addView(localViewGroup, new RelativeLayout.LayoutParams(-2, -2));
    addView(localRelativeLayout, new RelativeLayout.LayoutParams(-2, -2));
    localRelativeLayout.addView(this.my, (ViewGroup.LayoutParams)localObject2);
    arjq.reset();
    this.FM = new ImageView(getContext());
    this.FM.setId(2131373542);
    localObject2 = ((Resources)localObject1).getDrawable(2130851031);
    this.FM.setImageDrawable((Drawable)localObject2);
    int i;
    if (localObject2 == null)
    {
      i = (int)(this.cx * 18.0D);
      if (localObject2 != null) {
        break label637;
      }
    }
    label637:
    for (int j = (int)(this.cx * 18.0D);; j = ((Drawable)localObject2).getIntrinsicHeight())
    {
      localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(this.cx * 3.0D));
      this.my.addView(this.FM, (ViewGroup.LayoutParams)localObject2);
      this.I = new SingleLineTextView(getContext());
      this.I.setId(2131370437);
      this.I.setTextColor(-1);
      this.I.setTextSize(13.0F);
      localObject2 = new RelativeLayout.LayoutParams(-2, (int)(this.cx * 24.0D));
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131373542);
      this.my.addView(this.I, (ViewGroup.LayoutParams)localObject2);
      this.bN = new FrameLayout(getContext());
      this.bN.setId(2131369877);
      this.bN.setBackgroundResource(2130851411);
      this.bN.setMinimumHeight((int)(this.cx * 6.0D));
      this.bN.setMinimumWidth((int)(this.cx * 6.0D));
      this.bN.setContentDescription(((Resources)localObject1).getString(2131692155));
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131369959);
      localRelativeLayout.addView(this.bN, (ViewGroup.LayoutParams)localObject1);
      this.Vt = new TextView(getContext());
      this.Vt.setId(2131372329);
      this.Vt.setTextSize(1, 11.0F);
      this.Vt.setTextColor(-1);
      this.bN.addView(this.Vt, -2, -2);
      return;
      i = ((Drawable)localObject2).getIntrinsicWidth();
      break;
    }
  }
  
  public void MH(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.setCanDoAnim(paramBoolean);
    }
  }
  
  public void TT(boolean paramBoolean)
  {
    this.dbR = paramBoolean;
    if (this.bN.getVisibility() == 0) {
      return;
    }
    if (paramBoolean)
    {
      localObject = (RelativeLayout.LayoutParams)this.my.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bN.getLayoutParams();
      if (localObject != null) {
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      }
      if (localLayoutParams != null)
      {
        localLayoutParams.width = ((int)(this.cx * 6.0D + 0.5D));
        localLayoutParams.height = ((int)(this.cx * 6.0D + 0.5D));
        localLayoutParams.rightMargin = ((int)(3.0D % this.cx + 0.5D));
      }
      this.bN.setBackgroundResource(2130851401);
      this.bN.setLayoutParams(localLayoutParams);
    }
    Object localObject = this.bN;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((FrameLayout)localObject).setVisibility(i);
      return;
    }
  }
  
  public void a(int paramInt1, alen paramalen, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 != PraiseManager.f(this.mApp)) || (paramalen == null) || (this.SA));
      a(paramalen);
      paramalen = (Pair)this.jdField_a_of_type_Alek.dj.get(paramInt1);
    } while (paramalen == null);
    this.jdField_a_of_type_Alek.a(this.mApp, this.b, this.jdField_a_of_type_Ahyp.ay(), this, paramInt1, false, 0, ((Point)paramalen.first).x, ((Point)paramalen.first).y);
    this.jdField_a_of_type_Alek.dj.remove(paramInt1);
  }
  
  public void a(alen paramalen)
  {
    if (anlm.ayn()) {
      QLog.i("PraiseManager", 1, "startPraiseAnim, SimpleUIMode is open now");
    }
    while ((this.SA) || (paramalen == null) || (this.jdField_a_of_type_Alek.mStarted)) {
      return;
    }
    this.jdField_a_of_type_Alek.mView = this.FM;
    this.jdField_a_of_type_Alek.fl = new BitmapDrawable(getResources(), paramalen.fQ);
    this.jdField_a_of_type_Alek.a(this.crp, false, this.FM.getDrawable(), getResources());
    this.FM.startAnimation(alek.a(this.jdField_a_of_type_Alek, 1.0F, 0.3F));
    this.jdField_a_of_type_Alek.mStarted = true;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, afcy paramafcy, boolean paramBoolean3)
  {
    this.SA = paramBoolean1;
    this.crp = paramBoolean2;
    label39:
    Object localObject;
    if (paramInt1 > 0)
    {
      this.cQn = paramInt1;
      if (paramInt2 <= this.cQn) {
        break label345;
      }
      this.dmk = (this.cQn % 20);
      if ((this.SA) || (!this.crp)) {
        break label367;
      }
      localObject = super.getResources().getDrawable(2130851034);
      label65:
      if (!this.jdField_a_of_type_Alek.mStarted) {
        break label381;
      }
      this.jdField_a_of_type_Alek.a(this.crp, false, (Drawable)localObject, getResources());
    }
    float f1;
    float f2;
    for (;;)
    {
      if ((!paramBoolean1) && (!this.jdField_a_of_type_Alek.mStarted) && (!paramBoolean3) && (!this.dbS))
      {
        paramInt1 = PraiseManager.f(this.mApp);
        if (paramInt1 > 0)
        {
          localObject = (PraiseManager)this.mApp.getManager(209);
          ((PraiseManager)localObject).a(this);
          a(((PraiseManager)localObject).a(paramInt1, true, "from_profile_card"));
        }
      }
      setContentDescription(String.format(getContext().getString(2131692171), new Object[] { String.valueOf(this.cQn) }));
      if (this.SA) {
        break label412;
      }
      bu(false, 4);
      if ((paramBoolean3) && (this.b != null))
      {
        paramafcy = new int[2];
        this.my.getLocationInWindow(paramafcy);
        if (this.jdField_a_of_type_Ahyp == null) {
          this.jdField_a_of_type_Ahyp = new ahyp(getContext(), 2130846797);
        }
        f1 = (float)(paramafcy[0] + (this.FM.getWidth() + this.my.getPaddingLeft()) * 0.5D);
        f2 = paramafcy[1];
        paramInt1 = PraiseManager.f(this.mApp);
        if (paramInt1 <= 0) {
          break label393;
        }
        this.jdField_a_of_type_Alek.a(this.mApp, this.b, this.jdField_a_of_type_Ahyp.ay(), this, paramInt1, true, 0, f1, f2);
      }
      return;
      paramInt1 = 0;
      break;
      label345:
      if (paramInt2 < 0)
      {
        this.dmk = 0;
        break label39;
      }
      this.dmk = paramInt2;
      break label39;
      label367:
      localObject = super.getResources().getDrawable(2130851031);
      break label65;
      label381:
      this.FM.setImageDrawable((Drawable)localObject);
    }
    label393:
    this.b.a(this.jdField_a_of_type_Ahyp.ay(), f1, f2);
    return;
    label412:
    if (paramafcy != null)
    {
      paramafcy.a(this.cQn, this.dmk, this.bN, this.Vt, this.I, this.my, this.b);
      TT(this.dbR);
      return;
    }
    bu(true, 0);
  }
  
  public void bu(boolean paramBoolean, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.my.getLayoutParams();
    Object localObject3;
    int j;
    Object localObject2;
    Object localObject1;
    int i;
    if ((this.SA) && (this.dmk > 0))
    {
      localObject3 = (RelativeLayout.LayoutParams)this.bN.getLayoutParams();
      if (paramBoolean)
      {
        j = 2130851401;
        if (localLayoutParams != null) {
          localLayoutParams.topMargin = 0;
        }
        localObject2 = String.valueOf(this.cQn);
        localObject1 = localObject2;
        i = j;
        if (localObject3 != null)
        {
          ((RelativeLayout.LayoutParams)localObject3).width = ((int)(this.cx * 6.0D + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).height = ((int)(this.cx * 6.0D + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(3.0D % this.cx + 0.5D));
          i = j;
          localObject1 = localObject2;
        }
        this.bN.setBackgroundResource(i);
        if (localObject3 != null) {
          this.bN.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        this.bN.setVisibility(paramInt);
        localObject3 = this.Vt;
        if (!paramBoolean) {
          break label313;
        }
        localObject2 = "";
        label185:
        ((TextView)localObject3).setText((CharSequence)localObject2);
        localObject2 = this.Vt;
        if (!paramBoolean) {
          break label341;
        }
        paramInt = 4;
        label204:
        ((TextView)localObject2).setVisibility(paramInt);
      }
    }
    for (;;)
    {
      this.I.setText(localObject1);
      this.my.setLayoutParams(localLayoutParams);
      return;
      j = 2130851404;
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = ((int)(15.0D * this.cx + 0.5D));
      }
      localObject2 = String.valueOf(this.cQn - this.dmk);
      localObject1 = localObject2;
      i = j;
      if (localObject3 == null) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject3).width = -2;
      ((RelativeLayout.LayoutParams)localObject3).height = -2;
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = 0;
      localObject1 = localObject2;
      i = j;
      break;
      label313:
      localObject2 = "+" + this.dmk;
      break label185;
      label341:
      paramInt = 0;
      break label204;
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = 0;
      }
      localObject2 = String.valueOf(this.cQn);
      if (this.SA)
      {
        localObject1 = localObject2;
        if (this.dbR) {}
      }
      else
      {
        this.bN.setVisibility(4);
        localObject1 = localObject2;
      }
    }
  }
  
  public void ejk()
  {
    if (anlm.ayn())
    {
      QLog.i("PraiseManager", 1, "showPatternVote, SimpleUIMode is open now");
      return;
    }
    this.jdField_a_of_type_Alek.mStarted = false;
    if (!this.dbS)
    {
      arjq.reset();
      VasWebviewUtil.reportCommercialDrainage(null, "thumbup", "others_pageview", null, 1, 0, 0, null, "1", null);
    }
    this.dbS = true;
    postDelayed(new VoteView.1(this), 3000L);
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mApp != null) {
      ((PraiseManager)this.mApp.getManager(209)).b(this);
    }
    this.dbS = false;
    super.onDetachedFromWindow();
  }
  
  public void setHeartLayout(QQAppInterface paramQQAppInterface, HeartLayout paramHeartLayout)
  {
    this.mApp = paramQQAppInterface;
    this.b = paramHeartLayout;
    ahyp.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteView
 * JD-Core Version:    0.7.0.1
 */