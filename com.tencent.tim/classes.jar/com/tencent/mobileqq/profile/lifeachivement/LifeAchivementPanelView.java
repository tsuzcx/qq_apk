package com.tencent.mobileqq.profile.lifeachivement;

import alcn;
import alea;
import alea.a;
import alea.c;
import aled;
import alef;
import aleg;
import aleh;
import alei;
import alej;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import wja;

public class LifeAchivementPanelView
  extends ProfileCardFavorShowView
{
  RecyclerView B;
  alea.c a;
  public CardHandler a;
  public alea b;
  private boolean bE;
  public String bVZ;
  Button gX;
  private boolean isFriend;
  RelativeLayout lx;
  public long userUin;
  
  public LifeAchivementPanelView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LifeAchivementPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LifeAchivementPanelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(aled paramaled, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      paramaled.hasPraised = true;
      paramaled.dsC += 1;
    }
    for (;;)
    {
      this.b.notifyItemChanged(paramInt1);
      return;
      if (paramInt2 == 2)
      {
        paramaled.hasPraised = false;
        paramaled.dsC -= 1;
      }
    }
  }
  
  private void dFs()
  {
    this.B = new RecyclerView(getContext());
    this.B.addOnItemTouchListener(new aleh(this));
    this.B.addOnScrollListener(new alei(this));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
    localLinearLayoutManager.setOrientation(0);
    this.B.setLayoutManager(localLinearLayoutManager);
    int i = wja.dp2px(5.0F, getResources());
    int j = wja.dp2px(0.0F, getResources());
    this.B.addItemDecoration(new alea.a(i, j));
    this.jdField_a_of_type_Alea$c = new alej(this);
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "init ");
    }
    this.b = new alea(getContext(), null, this.jdField_a_of_type_Alea$c);
    this.B.setAdapter(this.b);
  }
  
  public void E(ArrayList<aled> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "showAchivementList dataArrayList.size() = " + paramArrayList.size() + ",totalCount = " + paramInt);
    }
    removeAllViews();
    addView(this.B);
    boolean bool = this.bE;
    this.b.f(paramArrayList, paramInt, bool);
  }
  
  public void a(Card paramCard, alcn paramalcn)
  {
    bool1 = true;
    String str = "";
    if (!TextUtils.isEmpty(paramCard.lifeAchievementOpenId)) {
      str = paramCard.lifeAchievementOpenId;
    }
    boolean bool2 = ProfileActivity.AllInOne.b(paramalcn.e);
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(paramCard.uin).longValue();
      l1 = l2;
    }
    catch (NumberFormatException paramCard)
    {
      for (;;)
      {
        QLog.d("LifeAchivementPanelView", 1, "updateUserInfo exception ", paramCard);
        continue;
        bool1 = false;
      }
    }
    if (paramalcn.e.pa == 0)
    {
      this.isFriend = bool2;
      this.bVZ = str;
      this.bE = bool1;
      this.userUin = l1;
      return;
    }
  }
  
  public void init()
  {
    super.init();
    this.lx = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561581, this, false));
    this.gX = ((Button)this.lx.findViewById(2131370109));
    this.gX.setOnClickListener(new alef(this));
    URLImageView localURLImageView = (URLImageView)this.lx.findViewById(2131370108);
    if (localURLImageView != null)
    {
      localURLImageView.setImageURL("https://downv6.qq.com/qq_relation/life_achivement/lifeachivement_empty_bg.png");
      localURLImageView.setVisibility(0);
    }
    dFs();
    this.mTitleBar.setOnClickListener(new aleg(this));
    this.mTitleBar.setContentDescription(getResources().getString(2131692189));
  }
  
  public void setCardHandler(CardHandler paramCardHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = paramCardHandler;
  }
  
  public void showEmptyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "showEmptyView");
    }
    removeAllViews();
    addView(this.lx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView
 * JD-Core Version:    0.7.0.1
 */