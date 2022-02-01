package com.tencent.mobileqq.widget;

import albb;
import alcn;
import aldj;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anov;
import aofe;
import aofj.b;
import apdg;
import apmb;
import aptl;
import aqae;
import aqaf;
import aqft;
import aqnm;
import aqpm;
import arhp;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileNameView
  extends RelativeLayout
{
  String Gz = "";
  aofj.b jdField_a_of_type_Aofj$b;
  ETTextViewPlus jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus;
  ColorNickTextView d;
  protected boolean daX;
  ColorNickTextView e;
  private int ehA;
  private int ehB;
  LinearLayout lB;
  private Context mContext;
  private float mDensity;
  private LayoutInflater mInflater;
  int mMaxWidth = 0;
  protected ImageView mRedDot;
  protected int mTextColor;
  
  public ProfileNameView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileNameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileNameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    paramContext = getResources().getDisplayMetrics();
    this.mDensity = paramContext.density;
    if (this.mDensity == 0.0F) {
      this.mDensity = 0.1F;
    }
    this.mMaxWidth = (Math.min(paramContext.widthPixels, paramContext.heightPixels) - ankt.dip2px(188.0F));
    this.mTextColor = getResources().getColor(2131167461);
    this.ehA = 24;
    this.ehB = 20;
    initViews();
  }
  
  private void a(QQAppInterface paramQQAppInterface, alcn paramalcn, ViewGroup paramViewGroup, TextView paramTextView)
  {
    if ((!paramalcn.cwc) || (paramViewGroup == null) || (paramTextView == null)) {
      return;
    }
    if (aldj.a(((TroopManager)paramQQAppInterface.getManager(52)).b(paramalcn.troopUin), paramalcn.c, paramTextView))
    {
      paramViewGroup.setVisibility(0);
      paramTextView.setPadding(10, 2, 10, 2);
      if (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramalcn.troopUin)) {
        apdg.a().U(paramalcn.troopUin, paramalcn.e.uin, false);
      }
      label276:
      while (!this.daX)
      {
        apdg.report("grp_data", "exp_medal");
        this.daX = true;
        return;
        switch (paramalcn.c.memberRole)
        {
        }
        for (;;)
        {
          if ((!apdg.a().bN(paramalcn.troopUin, paramalcn.e.uin)) || (this.mRedDot != null)) {
            break label276;
          }
          this.mRedDot = new ImageView(this.mContext);
          paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
          paramQQAppInterface.addRule(7, paramTextView.getId());
          paramQQAppInterface.setMargins(0, 0, 0, 0);
          this.mRedDot.setId(2131377002);
          this.mRedDot.setLayoutParams(paramQQAppInterface);
          this.mRedDot.setVisibility(0);
          this.mRedDot.setImageResource(2130851401);
          paramViewGroup.addView(this.mRedDot);
          break;
          paramViewGroup.setOnClickListener(new a(paramQQAppInterface, paramalcn));
        }
      }
    }
    paramViewGroup.setVisibility(8);
    paramTextView.setText(null);
    paramTextView.setBackgroundDrawable(null);
  }
  
  private void a(QQAppInterface paramQQAppInterface, alcn paramalcn, TroopHonorView paramTroopHonorView)
  {
    if ((paramalcn != null) && (paramalcn.c != null))
    {
      paramQQAppInterface = (apmb)paramQQAppInterface.getManager(346);
      if (!paramQQAppInterface.qD(paramalcn.troopUin))
      {
        paramTroopHonorView.setHonorList(null);
        paramTroopHonorView.setVisibility(8);
      }
      for (;;)
      {
        return;
        paramQQAppInterface = paramQQAppInterface.aX(paramalcn.c.honorList);
        paramTroopHonorView.setHonorList(paramQQAppInterface);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
        {
          paramTroopHonorView.setVisibility(0);
          paramTroopHonorView.setOnClickListener(new arhp(this, paramalcn));
        }
        while (QLog.isColorLevel())
        {
          QLog.d("TroopHonor.card", 2, String.format("updateTroopHonorView, honorList: %s", new Object[] { paramQQAppInterface }));
          return;
          paramTroopHonorView.setVisibility(8);
        }
      }
    }
    paramTroopHonorView.setHonorList(null);
    paramTroopHonorView.setVisibility(8);
  }
  
  private void initViews()
  {
    this.mInflater.inflate(2131561609, this);
    this.d = ((ColorNickTextView)findViewById(2131369184));
    this.e = ((ColorNickTextView)findViewById(2131369185));
    this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus = ((ETTextViewPlus)findViewById(2131369186));
    this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.setVisibility(8);
    this.lB = ((LinearLayout)findViewById(2131377334));
    this.e.setVisibility(8);
    this.lB.setVisibility(8);
    this.d.setVisibility(0);
    this.d.setTextColor(this.mTextColor);
    this.e.setTextColor(this.mTextColor);
    this.d.setTextSize(1, this.ehA);
    this.e.setTextSize(1, this.ehB);
  }
  
  public int MJ()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaddingLeft();
    int j = (int)this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaint().measureText(this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getText().toString());
    j = this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaddingRight() + (i + j);
    Object localObject = (TextView)findViewById(2131364325);
    i = j;
    if (((TextView)localObject).getVisibility() == 0)
    {
      i = j;
      if (!TextUtils.isEmpty(((TextView)localObject).getText()))
      {
        float f1 = j;
        float f2 = aqnm.dpToPx(4.0F) + ((TextView)localObject).getPaddingLeft();
        float f3 = ((TextView)localObject).getPaint().measureText(((TextView)localObject).getText().toString());
        i = (int)(((TextView)localObject).getPaddingRight() + (f2 + f3) + f1);
      }
    }
    localObject = (TroopHonorView)this.lB.findViewById(2131364328);
    j = i;
    if (((TroopHonorView)localObject).getVisibility() == 0)
    {
      j = ((TroopHonorView)localObject).getPaddingLeft();
      int k = ((TroopHonorView)localObject).Lw();
      j = i + (((TroopHonorView)localObject).getPaddingRight() + (j + k));
    }
    return j;
  }
  
  public void a(@NonNull QQAppInterface paramQQAppInterface, @Nullable TextView paramTextView, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileNameView", 2, "applyNickSpanText: " + paramString);
    }
    if ((paramTextView != null) && (paramString != null))
    {
      paramTextView.setTextColor(this.mTextColor);
      paramString = new aofe(paramString, (int)(paramTextView.getTextSize() / this.mDensity)).k();
      paramTextView.setText(paramString);
      aqpm.a(paramQQAppInterface, paramTextView, paramString);
    }
  }
  
  public ETTextViewPlus b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus != null)
    {
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.setVisibility(0);
      return this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus;
    }
    return null;
  }
  
  public void b(QQAppInterface paramQQAppInterface, alcn paramalcn)
  {
    if ((paramQQAppInterface == null) || (paramalcn == null) || (paramalcn.e == null) || (paramalcn.a == null))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    this.d.setTextSize(1, this.ehA);
    this.e.setTextSize(1, this.ehB);
    int i = getMeasuredWidth();
    if (i > this.mMaxWidth) {
      this.mMaxWidth = i;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = paramalcn.a.a.value;
      localObject1 = localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject2;
      label100:
      aofj.b localb;
      String str;
      Resources localResources;
      float f1;
      ViewGroup localViewGroup;
      TextView localTextView;
      float f2;
      int j;
      break label100;
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      if (!ProfileActivity.AllInOne.a(paramalcn.e)) {
        break label927;
      }
      localObject2 = String.valueOf(paramalcn.e.uin);
    }
    label139:
    if ((paramalcn.d != null) && (!paramalcn.d.isNoCover()))
    {
      this.d.setShadowLayer(ankt.dip2px(1.0F), 0.0F, 0.0F, -16777216);
      this.e.setShadowLayer(ankt.dip2px(1.0F), 0.0F, 0.0F, -16777216);
      label190:
      this.jdField_a_of_type_Aofj$b = new aofj.b((String)localObject2, (int)(this.d.getTextSize() / this.mDensity));
      localb = this.jdField_a_of_type_Aofj$b.b(4);
      this.jdField_a_of_type_Aofj$b.a(4);
      str = String.format("%s:%s", new Object[] { this.mContext.getString(2131692177), this.jdField_a_of_type_Aofj$b });
      if ((!aqft.rj(paramalcn.e.uin)) && (!paramalcn.cwc)) {
        break label1557;
      }
      localResources = this.mContext.getResources();
      this.lB.setVisibility(0);
      localObject1 = this.lB.findViewById(2131363111);
      if (!aqft.rj(paramalcn.e.uin)) {
        break label972;
      }
      ((View)localObject1).setVisibility(0);
      f1 = localResources.getDimensionPixelSize(2131297961) + 0.0F;
      label347:
      localViewGroup = (ViewGroup)this.lB.findViewById(2131364326);
      if (!paramalcn.cwc) {
        break label984;
      }
      localTextView = (TextView)localViewGroup.findViewById(2131364325);
      a(paramQQAppInterface, paramalcn, localViewGroup, localTextView);
      localObject2 = localTextView.getPaint();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.mDensity;
      }
      f2 = f1;
      if (localViewGroup.getVisibility() == 0) {
        f2 = ((TextPaint)localObject1).measureText(localTextView.getText().toString()) + f1 + localTextView.getPaddingLeft() + localTextView.getPaddingRight();
      }
      localObject1 = (TroopHonorView)this.lB.findViewById(2131364328);
      a(paramQQAppInterface, paramalcn, (TroopHonorView)localObject1);
      f1 = f2;
      if (((TroopHonorView)localObject1).getVisibility() == 0) {
        f1 = f2 + ((TroopHonorView)localObject1).Lw();
      }
      j = localResources.getDimensionPixelSize(2131297962);
      f1 += j;
      this.d.setSingleLine();
      localObject2 = this.d.getPaint();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.mDensity;
        ((TextPaint)localObject1).setTextSize(this.d.getTextSize());
      }
      f2 = localb.a((Paint)localObject1);
      if (f2 + f1 >= this.mMaxWidth) {
        break label994;
      }
      a(paramQQAppInterface, this.d, this.jdField_a_of_type_Aofj$b.AD());
      this.e.setVisibility(8);
      paramQQAppInterface = this.d;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileNameView", 2, String.format("update 1 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(this.mMaxWidth) }));
      }
      i = 1;
      label690:
      localObject2 = (RelativeLayout.LayoutParams)this.lB.getLayoutParams();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      if (paramQQAppInterface.getVisibility() != 0) {
        break label1407;
      }
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, paramQQAppInterface.getId());
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, paramQQAppInterface.getId());
      ((RelativeLayout.LayoutParams)localObject1).addRule(6, paramQQAppInterface.getId());
      ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = j;
      this.lB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    label515:
    label1557:
    for (;;)
    {
      setContentDescription(str);
      paramQQAppInterface = new albb(88, this.jdField_a_of_type_Aofj$b.toString());
      if ((i == 1) && (f1 > 0.0F))
      {
        localObject1 = new HashMap(1);
        ((Map)localObject1).put("xoff", Integer.valueOf(-(int)(f1 / 2.0F)));
        paramQQAppInterface.data = localObject1;
      }
      setTag(paramQQAppInterface);
      setOnClickListener(paramalcn.mOnClickListener);
      setOnLongClickListener(paramalcn.b);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ProfileNameView", 2, String.format("update 6 [max: %s, title: %s]", new Object[] { Integer.valueOf(this.mMaxWidth), this.jdField_a_of_type_Aofj$b.toString() }));
      return;
      label927:
      localObject2 = " ";
      break label139;
      this.d.setShadowLayer(0.0F, 0.0F, 0.0F, this.e.getCurrentTextColor());
      this.e.setShadowLayer(0.0F, 0.0F, 0.0F, this.e.getCurrentTextColor());
      break label190;
      label972:
      ((View)localObject1).setVisibility(8);
      f1 = 0.0F;
      break label347;
      label984:
      localViewGroup.setVisibility(8);
      break label515;
      label994:
      ((TextPaint)localObject1).setTextSize(ankt.dip2px(this.ehB));
      float f3 = localb.a((Paint)localObject1);
      if ((f3 <= f2) || (f3 + f1 < this.mMaxWidth))
      {
        this.d.setTextSize(1, this.ehB);
        a(paramQQAppInterface, this.d, this.jdField_a_of_type_Aofj$b.AD());
        this.e.setVisibility(8);
        paramQQAppInterface = this.d;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 2 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f1), Integer.valueOf(this.mMaxWidth) }));
        }
        i = 1;
        break label690;
      }
      if (f2 < this.mMaxWidth)
      {
        a(paramQQAppInterface, this.d, this.jdField_a_of_type_Aofj$b.AD());
        this.e.setVisibility(8);
        paramQQAppInterface = this.e;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 3 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(this.mMaxWidth) }));
        }
        i = 2;
        break label690;
      }
      if (f3 < this.mMaxWidth)
      {
        this.d.setTextSize(1, this.ehB);
        a(paramQQAppInterface, this.d, this.jdField_a_of_type_Aofj$b.AD());
        this.e.setVisibility(8);
        paramQQAppInterface = this.e;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 4 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f1), Integer.valueOf(this.mMaxWidth) }));
        }
        i = 2;
        break label690;
      }
      this.d.setTextSize(1, this.ehB);
      this.d.setEllipsize(TextUtils.TruncateAt.END);
      this.d.setWidth((int)(this.mMaxWidth - f1));
      localObject1 = this.d;
      a(paramQQAppInterface, this.d, this.jdField_a_of_type_Aofj$b.AD());
      paramQQAppInterface = (QQAppInterface)localObject1;
      i = 2;
      break label690;
      label1407:
      if (paramQQAppInterface == this.e)
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.d.getId());
        ((RelativeLayout.LayoutParams)localObject1).addRule(8, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, 0);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = j;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
        this.lB.setMinimumHeight(0);
        this.lB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = j;
        this.lB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        continue;
        i = 3;
        localObject2 = this.jdField_a_of_type_Aofj$b.toString();
        this.d.setText((CharSequence)localObject2);
        this.d.setSingleLine(true);
        this.d.setMaxLines(1);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setVisibility(0);
        this.e.setVisibility(8);
        this.lB.setVisibility(8);
        localObject1 = this.d.getPaint();
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (localObject1 == null)
        {
          paramQQAppInterface = new TextPaint(1);
          paramQQAppInterface.density = this.mDensity;
          paramQQAppInterface.setTextSize(this.d.getTextSize());
        }
        if (paramQQAppInterface.measureText((String)localObject2) >= this.mMaxWidth) {
          this.d.setTextSize(1, this.ehB);
        }
        f1 = 0.0F;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof View))
    {
      paramInt1 = ((View)localViewParent).getMeasuredWidth();
      if (this.mMaxWidth < paramInt1) {
        this.mMaxWidth = paramInt1;
      }
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.mTextColor != paramInt)
    {
      this.mTextColor = paramInt;
      this.d.setTextColor(this.mTextColor);
      this.e.setTextColor(this.mTextColor);
    }
  }
  
  static class a
    implements View.OnClickListener
  {
    final WeakReference<alcn> iH;
    final WeakReference<QQAppInterface> mAppRef;
    
    public a(QQAppInterface paramQQAppInterface, alcn paramalcn)
    {
      this.mAppRef = new WeakReference(paramQQAppInterface);
      this.iH = new WeakReference(paramalcn);
    }
    
    public void onClick(View paramView)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.mAppRef.get();
      alcn localalcn = (alcn)this.iH.get();
      if ((localQQAppInterface == null) || (localalcn == null) || (localalcn.e == null))
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      if (((apmb)localQQAppInterface.getManager(346)).qD(localalcn.troopUin)) {}
      for (Object localObject = aptl.a().bQ(localalcn.troopUin, localalcn.e.uin);; localObject = aptl.a().d(localalcn.troopUin, localalcn.e.uin, aldj.a(localQQAppInterface, localalcn.troopUin, localalcn.e.uin, localalcn.d), "3", "aio"))
      {
        Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        paramView.getContext().startActivity(localIntent);
        if (apdg.a().bN(localalcn.troopUin, localalcn.e.uin))
        {
          localObject = paramView.findViewById(2131377002);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          apdg.a().U(localalcn.troopUin, localalcn.e.uin, false);
        }
        apdg.report("grp_data", "clk_medal");
        new anov(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { localalcn.troopUin }).report();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileNameView
 * JD-Core Version:    0.7.0.1
 */