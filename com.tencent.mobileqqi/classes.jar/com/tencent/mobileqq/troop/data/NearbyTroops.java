package com.tencent.mobileqq.troop.data;

import NearbyGroup.GroupInfo;
import NearbyGroup.XiaoQuInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.widget.AbsListView.LayoutParams;
import gzf;
import java.text.DecimalFormat;

public class NearbyTroops
{
  public static final double a = 6378137.0D;
  public static final int a = 1;
  public static final boolean a = true;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 150;
  public static final int i = 55;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 3;
  public static final int r = 4;
  public static final int s = 1;
  public static final int t = 2;
  public static final int u = 3;
  
  public static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    double d1 = paramGeoPoint1.getLatitudeE6() / 1000000.0D;
    double d3 = paramGeoPoint2.getLatitudeE6() / 1000000.0D;
    double d4 = paramGeoPoint1.getLongitudeE6() / 1000000.0D;
    double d2 = paramGeoPoint2.getLongitudeE6() / 1000000.0D;
    d1 = a(d1);
    d3 = a(d3);
    d4 = a(d4);
    d2 = a(d2);
    double d5 = Math.pow(Math.sin((d1 - d3) / 2.0D), 2.0D);
    return Math.round(Math.asin(Math.sqrt(Math.cos(d1) * Math.cos(d3) * Math.pow(Math.sin((d4 - d2) / 2.0D), 2.0D) + d5)) * 2.0D * 6378137.0D * 10000.0D) / 10000L;
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903386, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_Int = 1;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static CharSequence a(GroupInfo paramGroupInfo, Context paramContext, Boolean paramBoolean)
  {
    int i1;
    String str2;
    if ((paramGroupInfo.dwGroupFlagExt & 0x100000) != 0L)
    {
      i1 = 1;
      str2 = "[icon]";
      if (i1 == 0) {
        break label122;
      }
      str2 = "";
    }
    ImageSpan localImageSpan;
    label122:
    for (String str1 = BaseApplicationImpl.getContext().getString(2131559308, new Object[] { Integer.valueOf(paramGroupInfo.iMemberCnt) });; str1 = "[icon]" + " " + BaseApplicationImpl.getContext().getString(2131559309, new Object[] { Integer.valueOf(paramGroupInfo.iMemberCnt) }))
    {
      SpannableString localSpannableString = new SpannableString(str1);
      localImageSpan = new ImageSpan(paramContext, 2130840354, 1);
      localSpannableString.setSpan(localImageSpan, 0, str2.length(), 17);
      if ((paramGroupInfo.strLocation != null) && (paramGroupInfo.strLocation.length() != 0) && (paramBoolean.booleanValue())) {
        break label172;
      }
      return localSpannableString;
      i1 = 0;
      break;
    }
    label172:
    paramGroupInfo = "[icon]" + " " + paramGroupInfo.strLocation;
    paramGroupInfo = new SpannableString(str1 + paramGroupInfo);
    paramContext = new ImageSpan(paramContext, 2130840355, 1);
    paramGroupInfo.setSpan(localImageSpan, 0, str2.length(), 17);
    paramGroupInfo.setSpan(paramContext, str1.length(), str1.length() + "[icon]".length(), 17);
    return paramGroupInfo;
  }
  
  public static void a(View paramView)
  {
    paramView.setBackgroundResource(2130837729);
    paramView = (NearbyTroops.MoreBtnViewHolder)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131562334);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramView.b.setVisibility(8);
    paramView.jdField_a_of_type_Boolean = true;
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, Context paramContext)
  {
    Object localObject = new AbsListView.LayoutParams(-1, -1);
    ((AbsListView.LayoutParams)localObject).height = paramInt1;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (NearbyTroops.OccupyViewHolder)paramView.getTag();
    if (paramInt2 == 2) {}
    for (paramInt1 = 2131562450;; paramInt1 = 2131562480)
    {
      ((NearbyTroops.OccupyViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramInt1);
      ((NearbyTroops.OccupyViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8814455);
      paramView.setContentDescription(paramContext.getResources().getString(paramInt1));
      return;
    }
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean, long paramLong)
  {
    paramView = (NearbyTroops.CustomViewHolder)paramView.getTag();
    paramView.a = String.valueOf(paramGroupInfo.lCode);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setText(paramGroupInfo.strName);
    if (TextUtils.isEmpty(paramGroupInfo.strIntro))
    {
      paramView.h.setVisibility(8);
      paramView.g.setText(a(paramGroupInfo, paramContext, Boolean.valueOf(paramBoolean)));
      if ((paramGroupInfo.dwGroupFlagExt & 0x800) == 0L) {
        break label243;
      }
      if (paramGroupInfo.dwCertType != 2L) {
        break label201;
      }
      paramView.b.setVisibility(0);
      paramView.b.setBackgroundResource(2130838179);
      label108:
      if (!paramGroupInfo.bIsNew) {
        break label255;
      }
      paramView.e.setVisibility(0);
      label123:
      if ((paramGroupInfo.lCreator != paramLong) || (paramLong == 0L)) {
        break label267;
      }
      paramView.d.setVisibility(0);
      label148:
      if ((paramGroupInfo.dwExtFlag & 1L) == 0L) {
        break label279;
      }
      paramView.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramView.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      return;
      paramView.h.setVisibility(0);
      paramView.h.setText(paramGroupInfo.strIntro);
      break;
      label201:
      if (paramGroupInfo.dwCertType == 1L)
      {
        paramView.b.setVisibility(0);
        paramView.b.setBackgroundResource(2130838355);
        break label108;
      }
      paramView.b.setVisibility(8);
      break label108;
      label243:
      paramView.b.setVisibility(8);
      break label108;
      label255:
      paramView.e.setVisibility(8);
      break label123;
      label267:
      paramView.d.setVisibility(8);
      break label148;
      label279:
      paramView.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public static void a(View paramView, XiaoQuInfo paramXiaoQuInfo, Context paramContext)
  {
    paramView = (NearbyTroops.CustomViewHolder)paramView.getTag();
    paramView.c.setBackgroundResource(2130838449);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setText(paramXiaoQuInfo.strName);
    paramView.b.setVisibility(8);
    paramView.h.setText(paramXiaoQuInfo.strIntro);
    Object localObject = paramContext.getResources().getDrawable(2130838450);
    ((Drawable)localObject).setBounds(AIOUtils.a(5.0F, paramContext.getResources()), AIOUtils.a(1.0F, paramContext.getResources()), AIOUtils.a(47.5F, paramContext.getResources()), AIOUtils.a(13.5F, paramContext.getResources()));
    paramView.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setPadding(0, 0, AIOUtils.a(6.0F, paramContext.getResources()), 0);
    localObject = paramContext.getString(2131559306, new Object[] { Integer.valueOf(paramXiaoQuInfo.iMemberCnt) });
    paramXiaoQuInfo = "[icon]" + " " + paramXiaoQuInfo.strLocation;
    paramXiaoQuInfo = new SpannableString((String)localObject + paramXiaoQuInfo);
    paramXiaoQuInfo.setSpan(new ImageSpan(paramContext, 2130840355, 1), ((String)localObject).length(), ((String)localObject).length() + "[icon]".length(), 17);
    paramView.g.setText(paramXiaoQuInfo);
  }
  
  public static void a(View paramView, gzf paramgzf)
  {
    paramView = (NearbyTroops.CustomViewHolder)paramView.getTag();
    paramView.c.setBackgroundResource(paramgzf.jdField_c_of_type_Int);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setText(paramgzf.a);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    paramView.g.setText(paramgzf.b);
    paramView.h.setText(paramgzf.jdField_c_of_type_JavaLangString);
  }
  
  public static void a(View paramView, String paramString, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    NearbyTroops.GroupViewHolder localGroupViewHolder = (NearbyTroops.GroupViewHolder)paramView.getTag();
    localGroupViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString + "(" + (int)paramFloat1 + ")");
    if (paramFloat2 < 1000.0F) {
      if (paramFloat2 <= 50.0F) {
        paramView = "50m";
      }
    }
    for (;;)
    {
      localGroupViewHolder.b.setText(paramView);
      return;
      paramView = (int)(Math.floor(paramFloat2 / 50.0F) * 50.0D) + "m";
      continue;
      paramView = new DecimalFormat("#.##");
      paramView = paramView.format(Math.ceil(paramFloat2 / 50.0F) * 0.05D) + "km";
    }
  }
  
  public static void a(View paramView, boolean paramBoolean, int paramInt)
  {
    int i2 = 8;
    paramView.setBackgroundResource(2130837848);
    paramView = (NearbyTroops.MoreBtnViewHolder)paramView.getTag();
    Object localObject = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
    if (paramBoolean)
    {
      i1 = 0;
      ((ProgressBar)localObject).setVisibility(i1);
      localObject = paramView.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label119;
      }
      i1 = 0;
      label49:
      ((TextView)localObject).setVisibility(i1);
      localObject = paramView.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        break label125;
      }
    }
    label119:
    label125:
    for (int i1 = 0;; i1 = 8)
    {
      ((ImageView)localObject).setVisibility(i1);
      localObject = paramView.b;
      i1 = i2;
      if (!paramBoolean) {
        i1 = 0;
      }
      ((TextView)localObject).setVisibility(i1);
      paramView.jdField_a_of_type_Boolean = false;
      if (!paramBoolean) {
        break label131;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131562334);
      return;
      i1 = 8;
      break;
      i1 = 8;
      break label49;
    }
    label131:
    paramView.b.setText(BaseApplicationImpl.getContext().getString(2131559307, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public static View b(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903385, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131232405));
    paramViewGroup.b = ((TextView)paramContext.findViewById(2131232406));
    paramViewGroup.jdField_a_of_type_Int = 3;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View c(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903387, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_Int = 2;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View d(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903991, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.CustomViewHolder();
    paramViewGroup.c = ((ImageView)paramContext.findViewById(2131232313));
    paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131232315));
    paramViewGroup.g = ((TextView)paramContext.findViewById(2131232317));
    paramViewGroup.h = ((TextView)paramContext.findViewById(2131232318));
    paramViewGroup.b = ((ImageView)paramContext.findViewById(2131231399));
    paramViewGroup.d = ((ImageView)paramContext.findViewById(2131234539));
    paramViewGroup.e = ((ImageView)paramContext.findViewById(2131234540));
    paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131234541));
    paramViewGroup.c.setImageBitmap(null);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View e(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903390, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.OccupyViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131230941));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View f(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903389, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.MoreBtnViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131231066));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131231866));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131231867));
    paramViewGroup.b = ((TextView)paramContext.findViewById(2131231506));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.NearbyTroops
 * JD-Core Version:    0.7.0.1
 */