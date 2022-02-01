package com.tencent.mobileqq.profile.view;

import acff;
import acfp;
import albb;
import alcn;
import alcs;
import alde;
import amhj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqep;
import argi;
import arjh;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;

public class ProfileShoppingView
  extends ProfileHeaderView
{
  public ImageView CG;
  public View Gc;
  public View Gd;
  public TextView Xl;
  public TextView Xq;
  public TextView Xr;
  public TextView Xs;
  public TextView Xt;
  public PhotoViewForShopping a;
  public VoteView b;
  public boolean bvA;
  public int cVk = -1;
  public int dto = -1;
  public int dtp = -1;
  public int dtq = -1;
  public LinearLayout fr;
  public AvatarLayout g;
  public RelativeLayout lA;
  public RelativeLayout lB;
  View mContentView;
  public int mStatusBarHeight = -1;
  public TextView nameText;
  public View nq;
  public ImageView qa;
  
  public ProfileShoppingView(BaseActivity paramBaseActivity, alcn paramalcn)
    throws ProfileTemplateException
  {
    super(paramBaseActivity, paramalcn);
    this.mActivity = paramBaseActivity;
    this.app = paramBaseActivity.app;
    this.jdField_a_of_type_Alcn = paramalcn;
    k(paramalcn);
    e(paramalcn);
  }
  
  public void b(alcn paramalcn, boolean paramBoolean)
  {
    super.i(paramalcn);
    super.j(paramalcn);
    s(paramalcn);
    super.g(paramalcn);
    super.c(paramalcn, false);
    m(paramalcn);
  }
  
  public boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.bvA) {
      return true;
    }
    return super.d(paramView, paramMotionEvent);
  }
  
  public void e(alcn paramalcn)
  {
    Object localObject2 = getContext();
    this.mContentView = LayoutInflater.from((Context)localObject2).inflate(2131562231, this, true);
    this.lA = ((RelativeLayout)this.mContentView.findViewById(2131375574));
    this.lB = ((RelativeLayout)this.mContentView.findViewById(2131375575));
    Object localObject1 = (acff)this.app.getManager(51);
    if (localObject1 != null) {}
    for (localObject1 = ((acff)localObject1).a(paramalcn.e.uin);; localObject1 = null)
    {
      if ((localObject1 != null) && (((ExtensionInfo)localObject1).isPendantValid()))
      {
        this.lA.setVisibility(0);
        this.lB.setVisibility(8);
        this.g = ((AvatarLayout)this.mContentView.findViewById(2131369165));
        this.g.c(0, this.g.findViewById(2131363324), false);
        this.CG = ((ImageView)this.mContentView.findViewById(2131369166));
        this.qa = ((ImageView)this.mContentView.findViewById(2131368987));
        this.g.setVisibility(0);
        alcs.a(this.CG, "src", paramalcn.jdField_b_of_type_Alcs, "commonFaceBackground");
        Object localObject3 = new albb(1, null);
        this.g.setTag(localObject3);
        this.g.setOnClickListener(paramalcn.mOnClickListener);
        if (paramalcn.e.pa != 0) {
          break label1387;
        }
        localObject1 = ((Context)localObject2).getString(2131692201);
        label256:
        this.g.setContentDescription((CharSequence)localObject1);
        this.mt.put("map_key_face", this.g);
        this.mt.put("map_key_face_stoke", this.mContentView.findViewById(2131369166));
        super.a(paramalcn.e);
        this.qa.setVisibility(4);
        this.qa.setOnClickListener(paramalcn.mOnClickListener);
        this.qa.setTag(localObject3);
        this.mt.put("map_key_avatar_pendant", this.qa);
        super.c(paramalcn, true);
        this.Xr = ((TextView)this.mContentView.findViewById(2131375582));
        this.Xq = ((TextView)this.mContentView.findViewById(2131375579));
        this.mt.put("map_key_sign", this.Xq);
        alcs.a(this.Xq, "color", paramalcn.jdField_b_of_type_Alcs, "commonItemContentColor");
        m(paramalcn);
        localObject1 = (RelativeLayout)this.mContentView.findViewById(2131375580);
        alcs.a((View)localObject1, "background", paramalcn.jdField_b_of_type_Alcs, "shoppingInfoMaskBackground");
        this.mt.put("map_key_space_sign", localObject1);
        alcs.a((RelativeLayout)this.mContentView.findViewById(2131375570), "background", paramalcn.jdField_b_of_type_Alcs, "shoppingUserInfoBackground");
        alcs.a(this.Xr, "color", paramalcn.jdField_b_of_type_Alcs, "shoppingShopnameText");
        alcs.a(this.Xq, "color", paramalcn.jdField_b_of_type_Alcs, "shoppingSignColor");
        this.cVk = getResources().getDimensionPixelSize(2131297318);
        this.mStatusBarHeight = aqep.e(getResources());
        this.dtp = getResources().getDimensionPixelSize(2131297523);
        this.dto = getResources().getDimensionPixelSize(2131297509);
        this.dtq = getResources().getDimensionPixelSize(2131297524);
        this.nq = this.mContentView.findViewById(2131369163);
        int i = (int)((int)(this.of / 1.35F) / 1.6F);
        localObject2 = (RelativeLayout.LayoutParams)this.nq.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).height = ((int)this.jG - this.dto - aqep.v(this.mActivity, 28) - this.dtp - this.dtq - this.cVk - this.mStatusBarHeight - i);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          ((RelativeLayout.LayoutParams)localObject2).height += ImmersiveUtils.getStatusBarHeight(getContext());
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + ((RelativeLayout.LayoutParams)localObject2).height);
        }
        if (((RelativeLayout.LayoutParams)localObject2).height <= aqep.v(this.mActivity, 110))
        {
          int j = aqep.v(this.mActivity, 110);
          int k = ((RelativeLayout.LayoutParams)localObject2).height;
          j = aqep.v(this.mActivity, 10) + (j - k);
          localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).topMargin -= j;
          ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((RelativeLayout.LayoutParams)localObject2).height += j;
        }
        this.nq.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.nq.setFocusable(true);
        this.nq.setFocusableInTouchMode(true);
        this.mt.put("map_key_space_view", this.nq);
        this.nameText = ((TextView)this.mContentView.findViewById(2131369183));
        alcs.a(this.nameText, "color", paramalcn.jdField_b_of_type_Alcs, "shoppingSignColor");
        this.nameText.setVisibility(0);
        this.nameText.setClickable(true);
        this.mt.put("map_key_profile_nick_name", this.nameText);
        super.j(paramalcn);
        this.Xl = ((TextView)this.mContentView.findViewById(2131369177));
        this.Xt = ((TextView)this.mContentView.findViewById(2131369175));
        this.Xs = ((TextView)this.mContentView.findViewById(2131369176));
        this.Gd = this.mContentView.findViewById(2131381921);
        this.Gc = this.mContentView.findViewById(2131381920);
        s(paramalcn);
        alcs.a(this.Xl, "color", paramalcn.jdField_b_of_type_Alcs, "shoppingSignColor");
        alcs.a(this.Xt, "color", paramalcn.jdField_b_of_type_Alcs, "shoppingSignColor");
        alcs.a(this.Xs, "color", paramalcn.jdField_b_of_type_Alcs, "shoppingSignColor");
        alcs.a(this.Gd, "color", paramalcn.jdField_b_of_type_Alcs, "shoppingSignColor");
        alcs.a(this.Gc, "color", paramalcn.jdField_b_of_type_Alcs, "shoppingSignColor");
        this.b = ((VoteView)this.mContentView.findViewById(2131382077));
        localObject1 = (HeartLayout)this.mContentView.findViewById(2131368498);
        ((HeartLayout)localObject1).setEnabled(false);
        this.b.setHeartLayout(this.app, (HeartLayout)localObject1);
        this.mt.put("map_key_like", this.b);
        super.i(paramalcn);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping = ((PhotoViewForShopping)this.mContentView.findViewById(2131375578));
        this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a(this.mActivity, paramalcn, i, this);
        this.fr = ((LinearLayout)this.mContentView.findViewById(2131369231));
        this.mt.put("map_key_tips", this.fr);
        if (paramalcn.e.uin.equals(this.app.getCurrentAccountUin())) {
          break label1400;
        }
        anot.a(this.app, "P_CliOper", "ProfileShopping", "", "Shop_Ftemplate", "0X8005B9A", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        super.e(paramalcn);
        this.bvA = true;
        return;
        this.lA.setVisibility(8);
        this.lB.setVisibility(0);
        this.g = ((AvatarLayout)this.mContentView.findViewById(2131369168));
        this.g.c(0, this.g.findViewById(2131363326), false);
        this.CG = ((ImageView)this.mContentView.findViewById(2131369167));
        break;
        label1387:
        localObject1 = ((Context)localObject2).getString(2131692200);
        break label256;
        label1400:
        anot.a(this.app, "P_CliOper", "ProfileShopping", "", "Shop_Mtemplate", "0X8005B96", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void fA(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileShoppingView", 2, "shop name:" + paramString);
    }
    if ((this.Xr != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.Xr.setText(paramString);
      if (paramInt == 0) {
        break label89;
      }
      paramString = getContext().getResources().getDrawable(2130848292);
      if (paramString != null) {
        this.Xr.setCompoundDrawablesWithIntrinsicBounds(null, null, paramString, null);
      }
    }
    return;
    label89:
    this.Xr.setCompoundDrawables(null, null, null, null);
  }
  
  public void i(String paramString, int paramInt, List<alde> paramList)
  {
    if ((paramString == null) || (paramList == null)) {
      return;
    }
    fA(paramString, paramInt);
    lQ(paramList);
  }
  
  public void k(alcn paramalcn)
    throws ProfileTemplateException
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("shoppingUserInfoBackground", "color");
    localHashMap.put("shoppingInfoMaskBackground", "color");
    localHashMap.put("shoppingShopnameText", "color");
    localHashMap.put("shoppingSignColor", "color");
    super.a(paramalcn, localHashMap);
  }
  
  public void lQ(List<alde> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.g(true, this.jdField_a_of_type_Alcn.e.uin, paramList);
  }
  
  public void m(alcn paramalcn)
  {
    Object localObject1 = (View)this.mt.get("map_key_sign");
    TextView localTextView;
    if ((localObject1 instanceof TextView))
    {
      localTextView = (TextView)localObject1;
      if ((paramalcn != null) && (paramalcn.d != null) && (paramalcn.e != null)) {
        break label52;
      }
      localTextView.setVisibility(4);
    }
    label52:
    SpannableString localSpannableString;
    SpannableStringBuilder localSpannableStringBuilder;
    do
    {
      return;
      localObject1 = paramalcn.d.getRichStatus();
      if ((!ProfileActivity.AllInOne.g(paramalcn.e)) || (localObject1 == null))
      {
        localTextView.setVisibility(4);
        return;
      }
      localSpannableString = ((RichStatus)localObject1).toSpannableString("");
      if (TextUtils.isEmpty(((RichStatus)localObject1).actionText)) {
        break;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString);
    } while (TextUtils.isEmpty(localSpannableStringBuilder));
    localSpannableStringBuilder.insert(0, "[S] ");
    amhj localamhj = (amhj)this.app.getManager(15);
    if (localamhj != null)
    {
      localObject1 = localamhj.i(((RichStatus)localObject1).actionId, 200);
      localObject1 = new arjh(getResources(), (Bitmap)localObject1, false, false);
      int i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
      ((BitmapDrawable)localObject1).setBounds(0, 0, i, i);
      localObject1 = new argi((Drawable)localObject1, 0);
      ((argi)localObject1).a(-0.1F);
      localSpannableStringBuilder.setSpan(localObject1, 0, "[S]".length(), 17);
      if (paramalcn.d.backgroundColor != 1L) {
        break label535;
      }
      localObject1 = "#686c6f";
      label248:
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor((String)localObject1)), "[S]".length(), localSpannableStringBuilder.toString().indexOf(" ", "[S]".length() + 1), 33);
      localTextView.setText(localSpannableStringBuilder);
      localTextView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "sign ssb= " + localSpannableStringBuilder + ",textColor = " + localTextView.getCurrentTextColor() + ",indexof=" + localSpannableStringBuilder.toString().indexOf(" ", "[S]".length() + 1));
      }
      label380:
      if ((paramalcn.e.pa == 0) || (ProfileActivity.AllInOne.b(paramalcn.e))) {
        localTextView.setOnClickListener(paramalcn.mOnClickListener);
      }
      if (TextUtils.isEmpty(localSpannableString)) {
        break label558;
      }
      localObject1 = localSpannableString.toString();
      label423:
      localTextView.setTag(new albb(3, localObject1));
      localTextView.setOnLongClickListener(paramalcn.jdField_b_of_type_AndroidViewView$OnLongClickListener);
      localObject1 = new StringBuilder().append(this.mActivity.getString(2131692237)).append(":");
      if (TextUtils.isEmpty(localSpannableString)) {
        break label565;
      }
    }
    label535:
    label558:
    label565:
    for (paramalcn = localSpannableString.toString();; paramalcn = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramalcn);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130850435);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          Object localObject2 = null;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          str = null;
        }
      }
      break;
      String str = "#ffffff";
      break label248;
      localTextView.setText(localSpannableString);
      localTextView.setVisibility(0);
      break label380;
      str = "";
      break label423;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Alcn != null) {
      super.c(this.jdField_a_of_type_Alcn, false);
    }
  }
  
  public void s(alcn paramalcn)
  {
    int j = -1;
    if (paramalcn.e.pa == 33)
    {
      paramalcn = this.mActivity.getString(2131701525);
      this.Xt.setVisibility(0);
      this.Xl.setVisibility(8);
      this.Xs.setVisibility(8);
      this.Xt.setPadding(0, 10, 0, 0);
      this.Xt.setText(paramalcn);
      this.Xt.setContentDescription(paramalcn);
      return;
    }
    Object localObject = "";
    Card localCard = paramalcn.d;
    ContactCard localContactCard = paramalcn.a;
    int i;
    if ((paramalcn.e.gender == 0) || (paramalcn.e.gender == 1)) {
      i = paramalcn.e.gender;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramalcn = this.mActivity.getString(2131695654);
        label141:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + paramalcn);
        }
        if (TextUtils.isEmpty(paramalcn)) {
          break label696;
        }
        this.Gc.setVisibility(0);
        this.Xl.setVisibility(0);
        this.Xl.setText(paramalcn);
        this.Xl.setContentDescription(paramalcn);
        label213:
        localObject = "";
        if (localCard == null) {
          break label724;
        }
        i = localCard.age;
        label229:
        paramalcn = (alcn)localObject;
        if (i > 0)
        {
          paramalcn = (alcn)localObject;
          if (!aqep.aBZ()) {
            paramalcn = i + this.mActivity.getString(2131720665);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + paramalcn);
        }
        if (TextUtils.isEmpty(paramalcn)) {
          break label740;
        }
        this.Xt.setVisibility(0);
        this.Xt.setText(paramalcn);
        this.Xt.setContentDescription(paramalcn);
        label337:
        localObject = "";
        if (localCard == null) {
          break label768;
        }
        paramalcn = (alcn)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramalcn = (alcn)localObject;
          if (!acfp.m(2131709964).equals(localCard.strCountry)) {
            paramalcn = "" + localCard.strCountry;
          }
        }
        localObject = paramalcn;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramalcn;
          if (!TextUtils.isEmpty(paramalcn)) {
            localObject = paramalcn + "，";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramalcn = (alcn)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramalcn = (alcn)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramalcn = (String)localObject + "，";
          }
          paramalcn = paramalcn + localCard.strCity;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + paramalcn);
        }
        if (TextUtils.isEmpty(paramalcn)) {
          break label979;
        }
        this.Xs.setVisibility(0);
        this.Xs.setText(paramalcn);
        this.Xs.setContentDescription(paramalcn);
        return;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label1005;
        }
        i = localContactCard.bSex;
        break;
        paramalcn = (alcn)localObject;
        if (i != 1) {
          break label141;
        }
        paramalcn = this.mActivity.getString(2131693477);
        break label141;
        label696:
        this.Xl.setVisibility(8);
        if (this.Gc == null) {
          break label213;
        }
        this.Gc.setVisibility(8);
        break label213;
        label724:
        i = j;
        if (localContactCard == null) {
          break label229;
        }
        i = localContactCard.bAge;
        break label229;
        label740:
        this.Xt.setVisibility(8);
        if (this.Gc == null) {
          break label337;
        }
        this.Gc.setVisibility(8);
        break label337;
        label768:
        paramalcn = (alcn)localObject;
        if (localContactCard != null)
        {
          paramalcn = (alcn)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramalcn = (alcn)localObject;
            if (!acfp.m(2131709963).equals(localContactCard.strCountry)) {
              paramalcn = "" + localContactCard.strCountry;
            }
          }
          localObject = paramalcn;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramalcn;
            if (!TextUtils.isEmpty(paramalcn)) {
              localObject = paramalcn + "，";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramalcn = (alcn)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramalcn = (alcn)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramalcn = (String)localObject + "，";
            }
            paramalcn = paramalcn + localContactCard.strCity;
          }
        }
      }
      label979:
      this.Xs.setVisibility(8);
      if (this.Gd == null) {
        break;
      }
      this.Gd.setVisibility(8);
      return;
      label1005:
      i = -1;
    }
  }
  
  public void setShoppingBgBlur(boolean paramBoolean)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = (FrameLayout)this.mActivity.findViewById(16908290);
      if ((localObject != null) && (((FrameLayout)localObject).getChildCount() > 0))
      {
        localObject = ((FrameLayout)localObject).getChildAt(0);
        if (localObject != null)
        {
          localObject = ((View)localObject).getBackground();
          if (!paramBoolean) {
            break label66;
          }
        }
      }
    }
    label66:
    for (int i = 255;; i = 0)
    {
      if (localObject != null) {
        ((Drawable)localObject).setAlpha(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileShoppingView
 * JD-Core Version:    0.7.0.1
 */