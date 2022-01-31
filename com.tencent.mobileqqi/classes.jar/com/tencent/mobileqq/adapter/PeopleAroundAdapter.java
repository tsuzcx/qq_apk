package com.tencent.mobileqq.adapter;

import EncounterSvc.RespEncounterInfo;
import QQService.VipBaseInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;

public class PeopleAroundAdapter
  extends BaseAdapter
{
  static final int jdField_a_of_type_Int = 0;
  static final int b = 1;
  static final int jdField_c_of_type_Int = 2;
  static final int d = 3;
  Context jdField_a_of_type_AndroidContentContext;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public View a;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public boolean b;
  private int e = 0;
  
  static
  {
    if (!PeopleAroundAdapter.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      return;
    }
  }
  
  public PeopleAroundAdapter(Context paramContext, FaceDecoder paramFaceDecoder, StatusManager paramStatusManager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = paramStatusManager;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
  }
  
  private int a()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, ImageView paramImageView)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramString1);
    if (localBitmap == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString1, paramInt, false, (byte)1, paramString2);
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
      }
      paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, int paramInt)
  {
    paramImageView.setVisibility(8);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.e == 0) {
      this.e = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localStatableBitmapDrawable.setBounds(0, 0, this.e, this.e);
    paramTextView.setCompoundDrawables(localStatableBitmapDrawable, null, null, null);
  }
  
  private void a(PeopleAroundAdapter.ViewHolder paramViewHolder, RespEncounterInfo paramRespEncounterInfo)
  {
    TextView localTextView = paramViewHolder.jdField_c_of_type_AndroidWidgetTextView;
    paramRespEncounterInfo = paramRespEncounterInfo.getRichStatus();
    if ((paramRespEncounterInfo != null) && (!paramRespEncounterInfo.a()))
    {
      if (!TextUtils.isEmpty(paramRespEncounterInfo.c)) {
        a(localTextView, paramRespEncounterInfo.b);
      }
      for (;;)
      {
        paramViewHolder.jdField_a_of_type_Int = paramRespEncounterInfo.b;
        localTextView.setText(paramRespEncounterInfo.a(null));
        localTextView.setVisibility(0);
        return;
        localTextView.setCompoundDrawables(null, null, null, null);
      }
    }
    paramViewHolder.jdField_a_of_type_Int = 0;
    localTextView.setVisibility(8);
  }
  
  void a(RespEncounterInfo paramRespEncounterInfo, int paramInt, View paramView)
  {
    int j = 0;
    PeopleAroundAdapter.ViewHolder localViewHolder = (PeopleAroundAdapter.ViewHolder)paramView.getTag();
    localViewHolder.jdField_a_of_type_JavaLangString = paramRespEncounterInfo.uid;
    if (!"".equals(paramRespEncounterInfo.strCertification)) {}
    for (int i = 1;; i = 0) {
      switch (paramInt)
      {
      default: 
        if (paramRespEncounterInfo.lEctID <= 0L) {
          break label455;
        }
        a(1, String.valueOf(paramRespEncounterInfo.lEctID), null, localViewHolder.jdField_a_of_type_AndroidWidgetImageView);
        return;
      }
    }
    paramView = localViewHolder.jdField_b_of_type_AndroidWidgetImageView;
    if (i != 0)
    {
      paramInt = 0;
      label103:
      paramView.setVisibility(paramInt);
      a(paramRespEncounterInfo.vipBaseInfo, localViewHolder.jdField_c_of_type_AndroidWidgetImageView, 1);
      String str = paramRespEncounterInfo.strNick;
      paramView = str;
      if (TextUtils.isEmpty(str)) {
        paramView = String.valueOf(paramRespEncounterInfo.lEctID);
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      paramView = new StringBuilder();
      if (i != 0) {
        break label475;
      }
      switch (paramRespEncounterInfo.cSex)
      {
      default: 
        paramInt = 0;
        label198:
        i = paramInt;
        if (paramRespEncounterInfo.cAge != 0) {
          paramView.append(Integer.toString(paramRespEncounterInfo.cAge & 0xFF)).append(this.jdField_a_of_type_AndroidContentContext.getString(2131561415)).append("  ");
        }
        break;
      }
    }
    label299:
    label443:
    label449:
    label455:
    label475:
    for (i = paramInt;; i = 0)
    {
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if ((paramRespEncounterInfo.strCompanyName != null) && (!paramRespEncounterInfo.strCompanyName.trim().equals("")))
      {
        paramView.append(this.jdField_a_of_type_AndroidContentContext.getString(2131562258)).append("  ");
        paramView.append(LocaleString.m(this.jdField_a_of_type_AndroidContentContext, paramRespEncounterInfo.strDescription));
        localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramView.toString());
        a(localViewHolder, paramRespEncounterInfo);
        paramView = localViewHolder.jdField_a_of_type_AndroidViewView;
        if (paramRespEncounterInfo.nFaceNum <= 0) {
          break label443;
        }
        paramInt = 0;
        label349:
        paramView.setVisibility(paramInt);
        paramView = localViewHolder.jdField_d_of_type_AndroidWidgetImageView;
        if (paramRespEncounterInfo.is_trav == 0) {
          break label449;
        }
      }
      for (paramInt = j;; paramInt = 8)
      {
        paramView.setVisibility(paramInt);
        break;
        paramInt = 8;
        break label103;
        paramInt = 2130838069;
        break label198;
        paramInt = 2130838068;
        break label198;
        if ((paramRespEncounterInfo.strSchoolName == null) || (paramRespEncounterInfo.strSchoolName.trim().equals(""))) {
          break label299;
        }
        paramView.append(this.jdField_a_of_type_AndroidContentContext.getString(2131562259)).append("  ");
        break label299;
        paramInt = 8;
        break label349;
      }
      a(100, paramRespEncounterInfo.uid, paramRespEncounterInfo.enc_id, localViewHolder.jdField_a_of_type_AndroidWidgetImageView);
      return;
    }
  }
  
  public void a(List paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
  }
  
  public int getCount()
  {
    int j = a();
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        i = 1;
      }
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((a() == 0) && (this.jdField_a_of_type_AndroidViewView != null)) {
      return 0;
    }
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 8;
    if ((a() == 0) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      return paramViewGroup;
    }
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 1: 
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903291, paramViewGroup, false);
        if ((!c) && (paramView == null)) {
          throw new AssertionError();
        }
        paramViewGroup = new PeopleAroundAdapter.ViewHolder();
        paramView.setTag(paramViewGroup);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(16908294));
        paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131231880);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231090));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231982));
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231983));
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231984));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231985));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231884));
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = getItem(paramInt);
        paramViewGroup = paramView;
        if (!(localObject instanceof RespEncounterInfo)) {
          break;
        }
        a((RespEncounterInfo)localObject, 1, paramView);
        return paramView;
        paramViewGroup = (PeopleAroundAdapter.ViewHolder)paramView.getTag();
      }
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903283, null);
      if ((!c) && (paramView == null)) {
        throw new AssertionError();
      }
      paramViewGroup = new PeopleAroundAdapter.ViewHolder();
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231869));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131231066));
      paramViewGroup.e = ((ImageView)paramView.findViewById(2131231868));
      ((LinearLayout)paramView).setOrientation(0);
      localObject = paramViewGroup.jdField_d_of_type_AndroidWidgetTextView;
      if (!this.b) {
        break label437;
      }
      paramInt = 2131562334;
      label377:
      ((TextView)localObject).setText(paramInt);
      localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.b) {
        break label444;
      }
      paramInt = 0;
      label398:
      ((ProgressBar)localObject).setVisibility(paramInt);
      paramViewGroup = paramViewGroup.e;
      if (!this.b) {
        break label450;
      }
    }
    label437:
    label444:
    label450:
    for (paramInt = i;; paramInt = 0)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramView;
      paramViewGroup = (PeopleAroundAdapter.ViewHolder)paramView.getTag();
      break;
      paramInt = 2131562926;
      break label377;
      paramInt = 8;
      break label398;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if ((a() == 0) && (this.jdField_a_of_type_AndroidViewView != null)) {}
    do
    {
      return false;
      if (paramInt <= this.jdField_a_of_type_JavaUtilList.size() - 1) {
        break;
      }
    } while (this.b);
    return true;
    return super.isEnabled(paramInt);
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.PeopleAroundAdapter
 * JD-Core Version:    0.7.0.1
 */