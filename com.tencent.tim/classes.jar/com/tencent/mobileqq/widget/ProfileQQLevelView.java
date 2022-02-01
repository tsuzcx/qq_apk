package com.tencent.mobileqq.widget;

import QQService.EVIPSPEC;
import acfp;
import alcn;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import anot;
import aqep;
import aqrt;
import arhr;
import auvj;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.b;
import com.tencent.mobileqq.utils.VipUtils.b.a;
import com.tencent.mobileqq.utils.VipUtils.b.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;

public class ProfileQQLevelView
  extends LinearLayout
{
  public ImageView FL;
  private final StringBuilder Y = new StringBuilder(200);
  public TextView aco;
  public URLImageView bZ;
  public FrameLayout cm;
  private double cx;
  public AnimationTextView f;
  public ThemeImageView k;
  private Context mContext;
  private LayoutInflater mInflater;
  public ImageView qP;
  
  public ProfileQQLevelView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileQQLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileQQLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.cx = getResources().getDisplayMetrics().density;
    initViews();
  }
  
  private String a(StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Card paramCard)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean1)
    {
      localStringBuilder.append("P");
      i = 1;
    }
    int j;
    if (paramBoolean2)
    {
      j = paramCard.getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
      i = j;
      if (j < 1) {
        i = 1;
      }
      if (paramCard.iQQVipType == 1) {
        paramStringBuilder.append("年费超级会员").append(i).append("级");
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      paramStringBuilder.append("超级会员").append(i).append("级");
      continue;
      if (!paramBoolean3) {
        break;
      }
      j = paramCard.getVipLevel(EVIPSPEC.E_SP_QQVIP);
      i = j;
      if (j < 1) {
        i = 1;
      }
      if (paramCard.iQQVipType == 1) {
        paramStringBuilder.append("年费QQ会员").append(i).append("级");
      } else {
        paramStringBuilder.append("QQ会员").append(i).append("级");
      }
    }
    if (i == 0) {}
    for (paramStringBuilder = "N";; paramStringBuilder = "BN")
    {
      localStringBuilder.append(paramStringBuilder);
      break;
    }
  }
  
  private void initViews()
  {
    this.mInflater.inflate(2131561605, this);
    this.FL = ((ImageView)findViewById(2131375279));
    this.aco = ((TextView)findViewById(2131369257));
    this.qP = ((ImageView)findViewById(2131382021));
    this.bZ = ((URLImageView)findViewById(2131369235));
    this.f = ((AnimationTextView)findViewById(2131369179));
    this.cm = ((FrameLayout)findViewById(2131371204));
    this.k = ((ThemeImageView)findViewById(2131370881));
    this.k.setMaskShape(auvj.euL);
    setVisibility(8);
  }
  
  private void o(TextView paramTextView, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    String str1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str1 = "";
    }
    Resources localResources = getResources();
    SpannableString localSpannableString = new SpannableString(str1);
    int j = str1.lastIndexOf(")");
    int i = j;
    if (j == -1) {
      i = 0;
    }
    if (i < str1.length())
    {
      paramString = null;
      String str2 = str1.substring(i, i + 1);
      if ("N".equals(str2))
      {
        paramString = localResources.getDrawable(2130846738);
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(str2)) && (paramString != null)) {
          localSpannableString.setSpan(new VerticalCenterImageSpan(paramString, 1), i, i + 1, 33);
        }
        if ((paramString != null) && ((paramString instanceof URLDrawable))) {
          ((URLDrawable)paramString).setURLDrawableListener(new arhr(paramTextView));
        }
        i += 1;
        break;
        if ("B".equals(str2))
        {
          paramString = localResources.getDrawable(2130846778);
          paramString.setBounds(0, 0, (int)(10.0D * this.cx), paramString.getIntrinsicHeight());
        }
        else if ("P".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130846750);
          j = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), j);
        }
        else if ("G".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130846749);
          j = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), j);
        }
      }
    }
    paramTextView.setText(localSpannableString);
  }
  
  public void d(alcn paramalcn, boolean paramBoolean)
  {
    Card localCard;
    boolean bool6;
    boolean bool5;
    boolean bool4;
    boolean bool2;
    label57:
    boolean bool3;
    label76:
    boolean bool1;
    label89:
    long l;
    Object localObject1;
    if (paramalcn == null)
    {
      localCard = null;
      if (localCard == null) {
        break label1659;
      }
      bool6 = localCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
      bool5 = localCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      bool4 = localCard.isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
      if ((localCard.lUserFlag & 1L) != 1L) {
        break label154;
      }
      bool2 = true;
      if ((localCard.lUserFlag & 0x400) != 1024L) {
        break label160;
      }
      bool3 = true;
      if (!ProfileActivity.AllInOne.a(paramalcn.e)) {
        break label166;
      }
      bool1 = true;
      if (paramBoolean) {
        bool1 = false;
      }
      paramBoolean = i(localCard);
      l = localCard.uCurMulType;
      localObject1 = localCard.uin;
    }
    for (;;)
    {
      if (!bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "update not show account info");
        }
        setVisibility(8);
        return;
        localCard = paramalcn.d;
        break;
        label154:
        bool2 = false;
        break label57;
        label160:
        bool3 = false;
        break label76;
        label166:
        if ((!bool5) && (!bool6) && (localCard.iQQLevel < 0)) {
          break label1653;
        }
        bool1 = true;
        break label89;
      }
      this.Y.setLength(0);
      setVisibility(0);
      label225:
      QQAppInterface localQQAppInterface;
      label336:
      boolean bool7;
      Object localObject2;
      int j;
      int i;
      int m;
      if ((localCard == null) || (localCard.isHidePrettyGroutIdentity))
      {
        this.FL.setVisibility(8);
        paramalcn = a(this.Y, bool3, bool5, bool6, localCard);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.qP);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.bZ);
        QLog.e("ProfileQQLevelView", 1, "update level view :" + paramalcn + " , " + l);
        if (TextUtils.isEmpty(paramalcn)) {
          break label1075;
        }
        o(this.aco, paramalcn);
        this.aco.setVisibility(0);
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        int[] arrayOfInt = VipUtils.b.a(localQQAppInterface, localCard.uin);
        bool7 = VipUtils.b.my(arrayOfInt[0]);
        localObject2 = null;
        j = 0;
        i = j;
        paramalcn = (alcn)localObject2;
        if (bool7) {
          if (!localCard.uin.equals(localQQAppInterface.getCurrentAccountUin()))
          {
            i = j;
            paramalcn = (alcn)localObject2;
            if (VipUtils.b.mz(arrayOfInt[1])) {}
          }
          else
          {
            paramalcn = VipUtils.b.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, VipUtils.b.a.a(arrayOfInt[0]), VipUtils.b.mz(arrayOfInt[1]));
            i = VipUtils.b.a(VipUtils.b.a.a(arrayOfInt[0]));
          }
        }
        m = 0;
        localObject2 = null;
        if (bool7) {
          break label1643;
        }
        if ((l != 1L) && (l != 2L)) {
          break label1122;
        }
        if (!bool6) {
          break label1087;
        }
        i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
        paramalcn = VipUtils.b.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
        if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
          QLog.d("ProfileQQLevelView", 1, "vip member icon show :" + paramalcn);
        }
        i = 2130847937;
        j = 1;
        localObject1 = localObject2;
      }
      for (;;)
      {
        label579:
        m = i;
        localObject2 = paramalcn;
        if (!bool7)
        {
          m = i;
          localObject2 = paramalcn;
          if (j == 0)
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1507;
            }
            QLog.e("ProfileQQLevelView", 1, (String)localObject1);
            label618:
            if (!bool5) {
              break label1538;
            }
            i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
            localObject2 = VipUtils.b.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
            m = 2130847936;
          }
        }
        label673:
        if ((localObject2 != null) && (m != 0))
        {
          VipUtils.b(getResources(), this.qP, (String)localObject2, getResources().getDrawable(m));
          this.qP.setVisibility(0);
          this.qP.setContentDescription(acfp.m(2131716834));
          this.qP.setFocusableInTouchMode(true);
          paramalcn = VipUtils.b.b.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, "VIA_PROFILECARD");
          paramalcn.KR();
          this.qP.setOnTouchListener(paramalcn);
          if ((this.aco.getVisibility() == 0) && (this.aco.getText() != null) && ("N".equals(this.aco.getText().toString()))) {
            this.aco.setVisibility(8);
          }
          label816:
          aqrt.a().a(this.bZ, bool5, localCard.namePlateOfKingLoginTime, localCard.namePlateOfKingGameId, localCard.namePlateOfKingDan, localCard.namePlateOfKingDanDisplatSwitch, localCard.uin);
          if (localCard.iQQLevel < 0) {
            break label1618;
          }
          i = localCard.mQQLevelType;
          paramalcn = aqep.a(getContext(), 10, i, localCard.iQQLevel, true);
          this.f.setText(paramalcn, TextView.BufferType.SPANNABLE);
          this.Y.append(" 等级 ").append(localCard.iQQLevel).append("级 ");
          this.f.setVisibility(0);
          if (paramBoolean) {
            break label1630;
          }
          this.k.setBackgroundResource(2130851855);
        }
        for (;;)
        {
          label928:
          setContentDescription(this.Y.toString());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("showQQLevelInfo bQQVipOpen=%s, bSuperVipOpen=%s, bEnterprise=%s, bPrettyNumber=%s, bShowAccountInfo=%s", new Object[] { Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
          return;
          if (localCard.isPrettyGroupOwner)
          {
            this.FL.setVisibility(0);
            anot.a(null, "dc00898", "", "", "qq_vip", "0X800A580", 0, 0, "", "", "", "");
            break label225;
          }
          this.FL.setVisibility(8);
          break label225;
          label1075:
          this.aco.setVisibility(8);
          break label336;
          label1087:
          localObject1 = "occur error: curMulType=" + l + " but bQQVipOpen is false";
          j = 0;
          break label579;
          label1122:
          if ((l == 3L) || (l == 4L))
          {
            if (bool5)
            {
              i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
              paramalcn = VipUtils.b.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
              if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
                QLog.d("ProfileQQLevelView", 1, "svip member icon show :" + paramalcn);
              }
              i = 2130847936;
              j = 1;
              localObject1 = localObject2;
              break label579;
            }
            localObject1 = "occur error: curMulType=" + l + " but bSuperVipOpen is false";
            j = 0;
            break label579;
          }
          if (l != 6L) {
            break label1643;
          }
          if (bool4)
          {
            j = VipUtils.a(localQQAppInterface, (String)localObject1, false);
            if (j >> 8 == 3) {
              if ((j & 0xF) == 1)
              {
                i = VipUtils.a(localQQAppInterface, (String)localObject1, EVIPSPEC.E_SP_BIGCLUB);
                paramalcn = VipUtils.b.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
                i = 2130847938;
                label1360:
                localObject1 = null;
                m = 1;
                j = i;
              }
            }
            for (i = m;; i = m)
            {
              m = i;
              i = j;
              j = m;
              break;
              i = VipUtils.a(localQQAppInterface, (String)localObject1, EVIPSPEC.E_SP_BIGCLUB);
              paramalcn = VipUtils.b.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
              i = 2130847936;
              break label1360;
              localObject1 = "occur error: curMulType=" + l + " but bBigClubVipOpen userStatus=" + j;
              j = i;
            }
          }
          localObject1 = "occur error: curMulType=" + l + " but bBigClubVipOpen is false";
          j = 0;
          break label579;
          label1507:
          QLog.e("ProfileQQLevelView", 1, "it have not handle curMulType=" + l);
          break label618;
          label1538:
          m = i;
          localObject2 = paramalcn;
          if (!bool6) {
            break label673;
          }
          i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
          localObject2 = VipUtils.b.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
          m = 2130847937;
          break label673;
          this.qP.setVisibility(8);
          this.qP.setOnTouchListener(null);
          break label816;
          label1618:
          this.f.setVisibility(8);
          break label928;
          label1630:
          this.k.setBackgroundResource(2130851856);
        }
        label1643:
        j = 0;
        localObject1 = localObject2;
      }
      label1653:
      bool1 = false;
      break label89;
      label1659:
      localObject1 = "";
      paramBoolean = true;
      l = 0L;
      bool1 = false;
      bool3 = false;
      bool2 = false;
      bool4 = false;
      bool5 = false;
      bool6 = false;
    }
  }
  
  public boolean i(Card paramCard)
  {
    QLog.i("ProfileQQLevelView", 1, "getDarenIconIsLight");
    if (paramCard == null) {}
    for (;;)
    {
      return false;
      if (paramCard.lQQMasterLogindays > 0L) {}
      for (FriendProfileCardActivity.lQQMasterLogindays = paramCard.lQQMasterLogindays; paramCard.lLoginDays >= FriendProfileCardActivity.lQQMasterLogindays; FriendProfileCardActivity.lQQMasterLogindays = 30L) {
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileQQLevelView
 * JD-Core Version:    0.7.0.1
 */