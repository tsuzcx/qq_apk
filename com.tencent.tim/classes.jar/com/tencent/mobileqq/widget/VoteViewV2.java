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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import anlm;
import aqhu;
import arjp;
import arjq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.a;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class VoteViewV2
  extends FrameLayout
  implements PraiseManager.a
{
  protected ImageView FN;
  private boolean SA;
  private ahyp jdField_a_of_type_Ahyp;
  alek jdField_a_of_type_Alek = new alek();
  protected TextView acq;
  private TextView acr;
  protected TextView acs;
  private HeartLayout b;
  public int cQn;
  private boolean crp;
  private double cx;
  private boolean dbR;
  private boolean dbS;
  public int dmk;
  private ViewGroup eS;
  QQAppInterface mApp;
  private Context mContext;
  private LayoutInflater mInflater;
  protected int mStyle = 0;
  
  public VoteViewV2(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VoteViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VoteViewV2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.cx = getResources().getDisplayMetrics().density;
    initViews();
  }
  
  private void initViews()
  {
    this.mInflater.inflate(getLayout(), this);
    this.acq = ((TextView)findViewById(2131382082));
    this.eS = ((ViewGroup)findViewById(2131377004));
    this.acr = ((TextView)findViewById(2131377005));
    this.acs = ((TextView)findViewById(2131372907));
    arjp.reset();
    this.FN = ((ImageView)findViewById(2131382087));
    tA(1);
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
    if (this.eS.getVisibility() == 0) {
      return;
    }
    this.eS.setBackgroundResource(2130851401);
    ViewGroup localViewGroup = this.eS;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localViewGroup.setVisibility(i);
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
    while ((this.SA) || (paramalen == null) || (this.jdField_a_of_type_Alek.mStarted) || (this.dbS)) {
      return;
    }
    this.jdField_a_of_type_Alek.mView = this.FN;
    this.jdField_a_of_type_Alek.fl = new BitmapDrawable(getResources(), paramalen.fQ);
    if (this.mStyle == 1) {
      this.jdField_a_of_type_Alek.fl = aqhu.d(this.jdField_a_of_type_Alek.fl, -7894119);
    }
    this.jdField_a_of_type_Alek.a(false, false, this.FN.getDrawable(), getResources());
    this.FN.startAnimation(alek.a(this.jdField_a_of_type_Alek, 1.0F, 0.3F));
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
        break label334;
      }
      this.dmk = (this.cQn % 20);
      if ((this.SA) || (!this.crp)) {
        break label356;
      }
      localObject = getResources().getDrawable(2130846785);
      label65:
      setContentDescription(String.format(getContext().getString(2131692171), new Object[] { String.valueOf(this.cQn) }));
      if (!this.jdField_a_of_type_Alek.mStarted) {
        break label394;
      }
      this.jdField_a_of_type_Alek.a(false, false, (Drawable)localObject, getResources());
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
      if (this.SA) {
        break label425;
      }
      bu(false, 4);
      if ((paramBoolean3) && (this.b != null))
      {
        paramafcy = new int[2];
        this.acq.getLocationInWindow(paramafcy);
        if (this.jdField_a_of_type_Ahyp == null) {
          this.jdField_a_of_type_Ahyp = new ahyp(getContext(), 2130846797);
        }
        f1 = (float)(paramafcy[0] + this.acq.getCompoundPaddingLeft() * 0.5D);
        f2 = paramafcy[1];
        paramInt1 = PraiseManager.f(this.mApp);
        if (paramInt1 <= 0) {
          break label406;
        }
        this.jdField_a_of_type_Alek.a(this.mApp, this.b, this.jdField_a_of_type_Ahyp.ay(), this, paramInt1, true, 0, f1, f2);
      }
      return;
      paramInt1 = 0;
      break;
      label334:
      if (paramInt2 < 0)
      {
        this.dmk = 0;
        break label39;
      }
      this.dmk = paramInt2;
      break label39;
      label356:
      if (this.mStyle == 1)
      {
        localObject = getResources().getDrawable(2130846786);
        break label65;
      }
      localObject = getResources().getDrawable(2130846787);
      break label65;
      label394:
      this.FN.setImageDrawable((Drawable)localObject);
    }
    label406:
    this.b.a(this.jdField_a_of_type_Ahyp.ay(), f1, f2);
    return;
    label425:
    if (paramafcy != null)
    {
      paramafcy.a(this.cQn, this.dmk, this.eS, this.acr, this.acq, null, this.b);
      TT(this.dbR);
      return;
    }
    bu(true, 0);
  }
  
  public void bu(boolean paramBoolean, int paramInt)
  {
    int j;
    int i;
    Object localObject;
    if ((this.SA) && (this.dmk > 0)) {
      if (paramBoolean)
      {
        j = 2130851401;
        i = this.cQn;
        this.eS.setBackgroundResource(j);
        this.eS.setVisibility(paramInt);
        TextView localTextView = this.acr;
        if (!paramBoolean) {
          break label114;
        }
        localObject = "";
        label59:
        localTextView.setText((CharSequence)localObject);
        localObject = this.acr;
        if (!paramBoolean) {
          break label142;
        }
        paramInt = 4;
        label78:
        ((TextView)localObject).setVisibility(paramInt);
      }
    }
    for (;;)
    {
      this.acq.setText(String.valueOf(i));
      return;
      j = 2130851411;
      i = this.cQn - this.dmk;
      break;
      label114:
      localObject = "+" + this.dmk;
      break label59;
      label142:
      paramInt = 0;
      break label78;
      paramInt = this.cQn;
      if (this.SA)
      {
        i = paramInt;
        if (this.dbR) {}
      }
      else
      {
        this.eS.setVisibility(4);
        i = paramInt;
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
    postDelayed(new VoteViewV2.1(this), 3000L);
  }
  
  protected int getLayout()
  {
    return 2131561625;
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
  
  public void tA(int paramInt)
  {
    this.mStyle = paramInt;
    if (this.mStyle == 1)
    {
      if ((!this.SA) && (this.crp)) {
        this.FN.setImageResource(2130846785);
      }
      for (;;)
      {
        this.acq.setTextColor(this.mContext.getResources().getColor(2131167379));
        this.acs.setTextColor(this.mContext.getResources().getColor(2131167379));
        if (this.jdField_a_of_type_Alek.fl != null) {
          this.jdField_a_of_type_Alek.fl = aqhu.d(this.jdField_a_of_type_Alek.fl, -7894119);
        }
        return;
        this.FN.setImageResource(2130846786);
      }
    }
    if ((!this.SA) && (this.crp)) {
      this.FN.setImageResource(2130846785);
    }
    for (;;)
    {
      this.acq.setTextColor(this.mContext.getResources().getColor(2131167461));
      this.acs.setTextColor(this.mContext.getResources().getColor(2131167461));
      if (this.jdField_a_of_type_Alek.fl != null) {
        this.jdField_a_of_type_Alek.fl = aqhu.d(this.jdField_a_of_type_Alek.fl, -1);
      }
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break;
      }
      this.FN.setColorFilter(1996488704);
      this.acq.setTextColor(getResources().getColor(2131167304));
      return;
      this.FN.setImageResource(2130846787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteViewV2
 * JD-Core Version:    0.7.0.1
 */