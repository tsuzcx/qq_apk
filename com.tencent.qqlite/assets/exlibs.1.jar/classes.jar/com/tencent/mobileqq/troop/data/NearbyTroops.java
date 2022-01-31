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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.widget.AbsListView.LayoutParams;
import env;
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
    paramContext = LayoutInflater.from(paramContext).inflate(2130903325, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_Int = 1;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903657, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.CustomViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131297600));
    paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297602));
    paramViewGroup.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297604));
    paramViewGroup.h = ((TextView)paramContext.findViewById(2131297605));
    paramViewGroup.c = ((ImageView)paramContext.findViewById(2131298509));
    paramViewGroup.d = ((ImageView)paramContext.findViewById(2131298852));
    paramViewGroup.e = ((ImageView)paramContext.findViewById(2131298853));
    paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131298854));
    paramViewGroup.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131296505));
    if (paramBoolean) {
      paramViewGroup.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
      paramContext.setTag(paramViewGroup);
      return paramContext;
      paramViewGroup.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
    }
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
        break label127;
      }
      str2 = "";
    }
    ImageSpan localImageSpan;
    label127:
    for (String str1 = "当前人数：" + paramGroupInfo.iMemberCnt + "人  ";; str1 = "[icon]" + " " + paramGroupInfo.iMemberCnt + "人  ")
    {
      SpannableString localSpannableString = new SpannableString(str1);
      localImageSpan = new ImageSpan(paramContext, 2130839504, 1);
      localSpannableString.setSpan(localImageSpan, 0, str2.length(), 17);
      if ((paramGroupInfo.strLocation != null) && (paramGroupInfo.strLocation.length() != 0) && (paramBoolean.booleanValue())) {
        break label164;
      }
      return localSpannableString;
      i1 = 0;
      break;
    }
    label164:
    paramGroupInfo = "[icon]" + " " + paramGroupInfo.strLocation;
    paramGroupInfo = new SpannableString(str1 + paramGroupInfo);
    paramContext = new ImageSpan(paramContext, 2130839505, 1);
    paramGroupInfo.setSpan(localImageSpan, 0, str2.length(), 17);
    paramGroupInfo.setSpan(paramContext, str1.length(), str1.length() + "[icon]".length(), 17);
    return paramGroupInfo;
  }
  
  public static void a(View paramView)
  {
    paramView.setBackgroundResource(2130837660);
    paramView = (NearbyTroops.MoreBtnViewHolder)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131363208);
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
    for (paramInt1 = 2131362842;; paramInt1 = 2131362841)
    {
      ((NearbyTroops.OccupyViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramInt1);
      ((NearbyTroops.OccupyViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8814455);
      paramView.setContentDescription(paramContext.getResources().getString(paramInt1));
      return;
    }
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean, long paramLong)
  {
    NearbyTroops.CustomViewHolder localCustomViewHolder = (NearbyTroops.CustomViewHolder)paramView.getTag();
    localCustomViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramGroupInfo.lCode);
    localCustomViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(paramGroupInfo.strName);
    label114:
    Object localObject;
    label141:
    label178:
    label209:
    int i1;
    if (TextUtils.isEmpty(paramGroupInfo.strIntro))
    {
      localCustomViewHolder.h.setVisibility(8);
      localCustomViewHolder.jdField_g_of_type_AndroidWidgetTextView.setText(a(paramGroupInfo, paramContext, Boolean.valueOf(paramBoolean)));
      if ((paramGroupInfo.dwGroupFlagExt & 0x800) == 0L) {
        break label508;
      }
      if (paramGroupInfo.dwCertType != 2L) {
        break label463;
      }
      localCustomViewHolder.c.setVisibility(0);
      localCustomViewHolder.c.setBackgroundResource(2130838196);
      if (!paramGroupInfo.bIsNew) {
        break label521;
      }
      localCustomViewHolder.e.setBackgroundResource(2130838327);
      localCustomViewHolder.e.setVisibility(0);
      if ((paramGroupInfo.lCreator != paramLong) || (paramLong == 0L)) {
        break label534;
      }
      localCustomViewHolder.d.setBackgroundResource(2130838329);
      localCustomViewHolder.d.setVisibility(0);
      if ((paramGroupInfo.dwExtFlag & 1L) == 0L) {
        break label547;
      }
      localCustomViewHolder.jdField_f_of_type_AndroidWidgetImageView.setBackgroundResource(2130838319);
      localCustomViewHolder.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      if ((paramGroupInfo.dwGroupFlagExt & 0x100000) == 0L) {
        break label560;
      }
      localObject = paramContext.getResources().getDrawable(2130838328);
      ((Drawable)localObject).setBounds(AIOUtils.a(5.0F, paramContext.getResources()), AIOUtils.a(1.0F, paramContext.getResources()), AIOUtils.a(37.5F, paramContext.getResources()), AIOUtils.a(13.5F, paramContext.getResources()));
      localCustomViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      localCustomViewHolder.jdField_f_of_type_AndroidWidgetTextView.setPadding(0, 0, AIOUtils.a(6.0F, paramContext.getResources()), 0);
      label311:
      localObject = "" + paramGroupInfo.strName;
      if ((paramGroupInfo.dwGroupFlagExt & 0x100000) == 0L) {
        break label775;
      }
      i1 = 1;
      label351:
      if (i1 == 0) {
        break label781;
      }
    }
    label521:
    label781:
    for (paramContext = "当前人数：" + paramGroupInfo.iMemberCnt + "人  ";; paramContext = paramGroupInfo.iMemberCnt + "人  ")
    {
      localCustomViewHolder.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(paramContext);
      paramContext = (String)localObject + paramContext;
      paramView.setContentDescription(paramContext + paramGroupInfo.strIntro);
      return;
      localCustomViewHolder.h.setVisibility(0);
      localCustomViewHolder.h.setText(paramGroupInfo.strIntro);
      break;
      label463:
      if (paramGroupInfo.dwCertType == 1L)
      {
        localCustomViewHolder.c.setVisibility(0);
        localCustomViewHolder.c.setBackgroundResource(2130838257);
        break label114;
      }
      localCustomViewHolder.c.setVisibility(8);
      break label114;
      label508:
      localCustomViewHolder.c.setVisibility(8);
      break label114;
      localCustomViewHolder.e.setVisibility(8);
      break label141;
      label534:
      localCustomViewHolder.d.setVisibility(8);
      break label178;
      label547:
      localCustomViewHolder.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      break label209;
      label560:
      if ((paramGroupInfo.dwGroupFlagExt & 0x800000) == 8388608L)
      {
        int i2 = (int)paramGroupInfo.dwGroupActiveGrade;
        if ((i2 <= 0) || (i2 >= 6)) {
          break label311;
        }
        i1 = 2130838387;
        switch (i2)
        {
        }
        for (;;)
        {
          localObject = paramContext.getResources().getDrawable(i1);
          ((Drawable)localObject).setBounds(AIOUtils.a(5.0F, paramContext.getResources()), 0, AIOUtils.a(32.5F, paramContext.getResources()), AIOUtils.a(16.5F, paramContext.getResources()));
          localCustomViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
          localCustomViewHolder.jdField_f_of_type_AndroidWidgetTextView.setPadding(0, 0, AIOUtils.a(6.0F, paramContext.getResources()), 0);
          break;
          i1 = 2130838388;
          continue;
          i1 = 2130838389;
          continue;
          i1 = 2130838390;
          continue;
          i1 = 2130838391;
          continue;
          i1 = 2130838392;
        }
      }
      localCustomViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label311;
      i1 = 0;
      break label351;
    }
  }
  
  public static void a(View paramView, XiaoQuInfo paramXiaoQuInfo, Context paramContext)
  {
    paramView = (NearbyTroops.CustomViewHolder)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838330);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setText(paramXiaoQuInfo.strName);
    paramView.c.setVisibility(8);
    paramView.h.setText(paramXiaoQuInfo.strIntro);
    Object localObject = paramContext.getResources().getDrawable(2130838331);
    ((Drawable)localObject).setBounds(AIOUtils.a(5.0F, paramContext.getResources()), AIOUtils.a(1.0F, paramContext.getResources()), AIOUtils.a(47.5F, paramContext.getResources()), AIOUtils.a(13.5F, paramContext.getResources()));
    paramView.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setPadding(0, 0, AIOUtils.a(6.0F, paramContext.getResources()), 0);
    localObject = paramXiaoQuInfo.iMemberCnt + "人";
    paramXiaoQuInfo = "[icon]" + " " + paramXiaoQuInfo.strLocation;
    paramXiaoQuInfo = new SpannableString((String)localObject + paramXiaoQuInfo);
    paramXiaoQuInfo.setSpan(new ImageSpan(paramContext, 2130839505, 1), ((String)localObject).length(), ((String)localObject).length() + "[icon]".length(), 17);
    paramView.jdField_g_of_type_AndroidWidgetTextView.setText(paramXiaoQuInfo);
  }
  
  public static void a(View paramView, env paramenv)
  {
    paramView = (NearbyTroops.CustomViewHolder)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramenv.jdField_c_of_type_Int);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setText(paramenv.jdField_a_of_type_JavaLangString);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    paramView.jdField_g_of_type_AndroidWidgetTextView.setText(paramenv.b);
    paramView.h.setText(paramenv.jdField_c_of_type_JavaLangString);
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
    paramView.setBackgroundResource(2130837917);
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
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131363208);
      return;
      i1 = 8;
      break;
      i1 = 8;
      break label49;
    }
    label131:
    paramView.b.setText("查看更多(" + paramInt + ")");
  }
  
  public static View b(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903324, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297709));
    paramViewGroup.b = ((TextView)paramContext.findViewById(2131297710));
    paramViewGroup.jdField_a_of_type_Int = 3;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View c(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903326, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_Int = 2;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View d(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903329, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.OccupyViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131296934));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View e(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903328, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.MoreBtnViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131296561));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131297310));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297311));
    paramViewGroup.b = ((TextView)paramContext.findViewById(2131296953));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.NearbyTroops
 * JD-Core Version:    0.7.0.1
 */