package com.tencent.mobileqq.nearby.profilecard;

import SummaryCard.TPraiseInfo;
import acfp;
import afcy;
import ahyo;
import ahyp;
import ahyq;
import ajqh;
import akcc;
import akcd;
import alek;
import alem;
import alen;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NearbyCardVoteView
  extends RelativeLayout
  implements PraiseManager.a
{
  public static int dml = 11;
  public static int dmm = 12;
  View Ff;
  private boolean SA;
  public TextView Vt;
  TextView Vu;
  ahyq jdField_a_of_type_Ahyq;
  alek jdField_a_of_type_Alek = new alek();
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  HeartLayout b;
  public FrameLayout bN;
  public int cQn;
  private boolean crp;
  public boolean crq = true;
  public boolean crr;
  private boolean crs;
  private double cx;
  public int dmk;
  View fP;
  public QQAppInterface mApp;
  public Handler mHandler = new akcc(this);
  
  public NearbyCardVoteView(Context paramContext)
  {
    super(paramContext);
    initViews();
  }
  
  public NearbyCardVoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViews();
  }
  
  public NearbyCardVoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    this.jdField_a_of_type_Ahyq = new ahyq(getContext());
    this.jdField_a_of_type_Alek.b = this.jdField_a_of_type_Ahyq;
    Object localObject = getResources();
    this.cx = ((Resources)localObject).getDisplayMetrics().density;
    this.fP = new View(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.cx * 50.0D), (int)(this.cx * 50.0D));
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    this.fP.setBackgroundResource(2130846425);
    addView(this.fP, localLayoutParams);
    this.Ff = new SingleLineTextView(getContext());
    this.Ff.setBackgroundResource(2130846793);
    this.Ff.setId(2131370437);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.cx * 25.0D), (int)(this.cx * 25.0D));
    localLayoutParams.topMargin = ((int)(15.0D * this.cx));
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(10);
    addView(this.Ff, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = ((int)(2.0D * this.cx));
    this.Vu = new TextView(getContext());
    this.Vu.setTextSize(1, 12.0F);
    this.Vu.setTextColor(-15550475);
    addView(this.Vu, localLayoutParams);
    this.bN = new FrameLayout(getContext());
    this.bN.setId(2131369877);
    this.bN.setBackgroundResource(2130851411);
    this.bN.setMinimumHeight((int)(this.cx * 6.0D));
    this.bN.setMinimumWidth((int)(this.cx * 6.0D));
    this.bN.setContentDescription(((Resources)localObject).getString(2131692155));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    addView(this.bN, (ViewGroup.LayoutParams)localObject);
    this.Vt = new TextView(getContext());
    this.Vt.setId(2131372329);
    this.Vt.setTextSize(1, 11.0F);
    this.Vt.setTextColor(-1);
    this.bN.addView(this.Vt, -2, -2);
  }
  
  public void MH(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.setCanDoAnim(paramBoolean);
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
      } while (paramalen == null);
      if ((!this.SA) && (paramInt1 == PraiseManager.f(this.mApp))) {
        a(paramalen);
      }
      paramalen = (Pair)this.jdField_a_of_type_Alek.dj.get(paramInt1);
    } while (paramalen == null);
    float f1 = ((Point)paramalen.first).x;
    float f2 = ((Point)paramalen.first).y;
    paramInt2 = ((Integer)paramalen.second).intValue();
    this.jdField_a_of_type_Alek.a(this.mApp, this.b, this.jdField_a_of_type_Ahyq.a(paramInt2, this.b.b).ax(), this, paramInt1, false, paramInt2, f1, f2);
    this.jdField_a_of_type_Alek.dj.remove(paramInt1);
  }
  
  public void a(alen paramalen)
  {
    if ((!this.SA) && (paramalen != null) && (!this.jdField_a_of_type_Alek.mStarted))
    {
      this.jdField_a_of_type_Alek.mView = this.Ff;
      this.jdField_a_of_type_Alek.fl = new BitmapDrawable(getResources(), paramalen.fQ);
      paramalen = (ajqh)this.mApp.getManager(207);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (!paramalen.ct(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue()))) {
        break label147;
      }
    }
    label147:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Alek.a(this.crp, bool, this.Ff.getBackground(), getResources());
      this.Ff.startAnimation(alek.a(this.jdField_a_of_type_Alek, 1.0F, 0.3F));
      this.jdField_a_of_type_Alek.mStarted = true;
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, afcy paramafcy, boolean paramBoolean3, boolean paramBoolean4, List<TPraiseInfo> paramList)
  {
    this.SA = paramBoolean1;
    this.crp = paramBoolean2;
    int i;
    if (paramInt1 > 0)
    {
      i = paramInt1;
      this.cQn = i;
      if (paramInt2 <= this.cQn) {
        break label371;
      }
      this.dmk = (this.cQn % 20);
      label43:
      this.cQn -= paramInt2;
      localObject = (ajqh)this.mApp.getManager(207);
      if ((this.SA) || (!this.crp)) {
        break label493;
      }
    }
    label371:
    int j;
    label493:
    do
    {
      for (;;)
      {
        try
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (((ajqh)localObject).ct(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue())))
          {
            paramafcy = getResources().getDrawable(2130843441);
            this.Vu.setTextColor(-13291);
            if (!this.jdField_a_of_type_Alek.mStarted) {
              break label568;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (!((ajqh)localObject).ct(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue()))) {
              break label563;
            }
            paramBoolean1 = true;
            this.jdField_a_of_type_Alek.a(this.crp, paramBoolean1, paramafcy, getResources());
            if ((!this.SA) && (!this.jdField_a_of_type_Alek.mStarted) && (!paramBoolean3))
            {
              i = PraiseManager.f(this.mApp);
              if (i > 0)
              {
                paramafcy = (PraiseManager)this.mApp.getManager(209);
                paramafcy.a(this);
                a(paramafcy.a(i, true, "from_profile_card"));
              }
            }
            setContentDescription(this.cQn + acfp.m(2131708662));
            if (this.SA) {
              break label671;
            }
            bu(false, 4);
            if (paramBoolean3)
            {
              paramInt2 = PraiseManager.f(this.mApp);
              if (!paramBoolean4) {
                break label666;
              }
              paramInt1 = 0;
              iU(paramInt2, paramInt1);
            }
            this.Vu.setText(this.cQn + "");
            return;
            i = 0;
            break;
            if (paramInt2 < 0)
            {
              this.dmk = 0;
              break label43;
            }
            this.dmk = paramInt2;
            break label43;
          }
          if (!this.crq)
          {
            paramafcy = getResources().getDrawable(2130846444);
            this.Vu.setTextColor(-52924);
            continue;
          }
        }
        catch (NumberFormatException paramafcy)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VoteView", 2, paramafcy.toString(), paramafcy);
          }
          paramafcy = getResources().getDrawable(2130846793);
          this.Vu.setTextColor(-15550475);
          continue;
          paramafcy = getResources().getDrawable(2130846793);
          this.Vu.setTextColor(-15550475);
          continue;
        }
        if (this.crq)
        {
          paramafcy = getResources().getDrawable(2130843443);
          this.Vu.setTextColor(-1);
        }
        else
        {
          paramafcy = getResources().getDrawable(2130846446);
          this.Vu.setTextColor(-8947849);
          this.fP.setBackgroundDrawable(new ColorDrawable(0));
          continue;
          paramBoolean1 = false;
          continue;
          this.Ff.setBackgroundDrawable(paramafcy);
          if (!this.crq)
          {
            this.fP.setBackgroundDrawable(new ColorDrawable(0));
            paramafcy = new RelativeLayout.LayoutParams((int)(this.cx * 32.0D), (int)(this.cx * 32.0D));
            paramafcy.topMargin = ((int)(15.0D * this.cx));
            paramafcy.addRule(14);
            paramafcy.addRule(10);
            this.Ff.setLayoutParams(paramafcy);
            continue;
            paramInt1 = 2;
          }
        }
      }
      if ((this.crr) || (paramInt2 <= 0) || (this.crs)) {
        break label953;
      }
      this.crs = true;
      this.Vt.setText("" + paramInt2);
      bu(false, 0);
      i = getContext().getSharedPreferences("nearby_card_reddot_num", 0).getInt("voteNum", -1);
      j = getContext().getSharedPreferences("nearby_card_reddot_num", 0).getInt("increaseNum", -1);
    } while ((i == paramInt1) && (j == paramInt2));
    label563:
    label568:
    paramafcy = this.mHandler.obtainMessage(dmm, paramInt1, paramInt2, paramList);
    label666:
    label671:
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramafcy.sendToTarget();
      return;
    }
    Object localObject = (PraiseManager)this.mApp.getManager(209);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TPraiseInfo localTPraiseInfo = (TPraiseInfo)localIterator.next();
      if (localTPraiseInfo.uCustomId > 0L) {
        localHashSet.add(Integer.valueOf((int)localTPraiseInfo.uCustomId));
      }
    }
    if (((PraiseManager)localObject).a(localHashSet, new akcd(this, paramInt1, paramInt2, paramList)))
    {
      paramafcy.sendToTarget();
      return;
    }
    this.mHandler.sendMessageDelayed(paramafcy, alem.dsE);
    return;
    label953:
    bu(false, 0);
  }
  
  public void bu(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    int j;
    int i;
    if ((this.SA) && (this.dmk > 0))
    {
      localObject = (RelativeLayout.LayoutParams)this.bN.getLayoutParams();
      if (paramBoolean)
      {
        j = 2130851401;
        i = this.cQn;
        i = j;
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).width = -2;
          ((RelativeLayout.LayoutParams)localObject).height = -2;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(3.0D % this.cx + 0.5D));
          i = j;
        }
        this.bN.setBackgroundResource(i);
        if (localObject == null) {
          break label215;
        }
        this.bN.setLayoutParams((ViewGroup.LayoutParams)localObject);
        label105:
        this.bN.setVisibility(paramInt);
        TextView localTextView = this.Vt;
        if (!paramBoolean) {
          break label228;
        }
        localObject = "";
        label128:
        localTextView.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      this.Vu.setText(this.cQn + "");
      return;
      j = 2130851404;
      i = this.cQn;
      i = this.dmk;
      i = j;
      if (localObject == null) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      i = j;
      break;
      label215:
      QLog.e("VoteView", 1, "mRedDotView.setLayoutParams(pa) pa == null");
      break label105;
      label228:
      localObject = "+" + this.dmk;
      break label128;
      paramInt = this.cQn;
      this.bN.setVisibility(4);
    }
  }
  
  public void iU(int paramInt1, int paramInt2)
  {
    Object localObject = new int[2];
    this.Ff.getLocationInWindow((int[])localObject);
    float f1 = localObject[0] + this.Ff.getWidth() / 2;
    float f2 = localObject[1] - this.Ff.getHeight() / 2;
    localObject = this.jdField_a_of_type_Ahyq.a(paramInt2, this.b.b);
    if (paramInt1 > 0)
    {
      this.jdField_a_of_type_Alek.a(this.mApp, this.b, ((ahyo)localObject).ax(), this, paramInt1, true, paramInt2, f1, f2);
      return;
    }
    if (paramInt2 == 2)
    {
      this.b.a(((ahyo)localObject).ax(), this.mApp, (ahyo)localObject, f1 - aqcx.dip2px(getContext(), 20.0F), f2 - aqcx.dip2px(getContext(), 120.0F), aqcx.dip2px(getContext(), 75.0F), aqcx.dip2px(getContext(), 65.0F));
      return;
    }
    this.b.a(((ahyo)localObject).ax(), f1, f2);
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mApp != null)
    {
      PraiseManager localPraiseManager = (PraiseManager)this.mApp.getManager(209);
      if (localPraiseManager != null) {
        localPraiseManager.b(this);
      }
    }
    super.onDetachedFromWindow();
  }
  
  public void setAppInterface(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public void setHeartLayout(HeartLayout paramHeartLayout)
  {
    this.b = paramHeartLayout;
    ahyp.a(this.b);
  }
  
  public void setIsTribe(boolean paramBoolean)
  {
    this.crq = paramBoolean;
  }
  
  public void setNearbyPeopleCard(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView
 * JD-Core Version:    0.7.0.1
 */