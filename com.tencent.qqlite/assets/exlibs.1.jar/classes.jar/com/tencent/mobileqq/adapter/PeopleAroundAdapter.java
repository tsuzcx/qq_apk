package com.tencent.mobileqq.adapter;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RishState;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import cqm;
import cqn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleAroundAdapter
  extends BaseAdapter
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public View.OnClickListener a;
  public View a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public FaceDecoder a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List a;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public boolean b;
  private boolean c = false;
  
  public PeopleAroundAdapter(BaseActivity paramBaseActivity, FaceDecoder paramFaceDecoder, StatusManager paramStatusManager, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramBaseActivity.getSystemService("layout_inflater"));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = paramStatusManager;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(RespEncounterInfo paramRespEncounterInfo, ImageView paramImageView)
  {
    String str;
    Boolean localBoolean;
    try
    {
      if (paramRespEncounterInfo.tiny_id > 0L)
      {
        str = String.valueOf(paramRespEncounterInfo.tiny_id);
        if (this.c)
        {
          localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramRespEncounterInfo.tiny_id));
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramRespEncounterInfo.tiny_id), Boolean.valueOf(true));
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqm(this, str, paramRespEncounterInfo));
          }
        }
        paramRespEncounterInfo = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, str, 3001);
        if (paramRespEncounterInfo == null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 3001, true, false);
          }
          if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
          }
          paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          return;
        }
        paramImageView.setImageBitmap(paramRespEncounterInfo);
        return;
      }
    }
    catch (Throwable paramRespEncounterInfo)
    {
      paramRespEncounterInfo.printStackTrace();
      return;
    }
    if (paramRespEncounterInfo.lEctID > 0L)
    {
      str = String.valueOf(paramRespEncounterInfo.lEctID);
      if (this.c)
      {
        localBoolean = (Boolean)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramRespEncounterInfo.lEctID));
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
        {
          this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramRespEncounterInfo.lEctID), Boolean.valueOf(true));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqn(this, str, paramRespEncounterInfo));
        }
      }
      paramRespEncounterInfo = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, str, 3000);
      if (paramRespEncounterInfo == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 3000, true, false);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
        }
        paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        return;
      }
      paramImageView.setImageBitmap(paramRespEncounterInfo);
    }
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, TextView paramTextView)
  {
    paramImageView.setVisibility(8);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131427492));
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo == null) || (!localVipOpenInfo.bOpen)) {
        break label83;
      }
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130839436);
      paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131427518));
    }
    label83:
    do
    {
      return;
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    } while ((paramVipBaseInfo == null) || (!paramVipBaseInfo.bOpen));
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130839513);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131427518));
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localStatableBitmapDrawable.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    paramTextView.setCompoundDrawables(localStatableBitmapDrawable, null, null, null);
  }
  
  private void a(PeopleAroundAdapter.ViewHolder paramViewHolder, RespEncounterInfo paramRespEncounterInfo)
  {
    TextView localTextView = paramViewHolder.jdField_b_of_type_AndroidWidgetTextView;
    RichStatus localRichStatus;
    if (paramRespEncounterInfo.richState != null)
    {
      localRichStatus = RichStatus.a(paramRespEncounterInfo.richState.vState);
      localRichStatus.a = paramRespEncounterInfo.richState.uModifyTime;
    }
    for (paramRespEncounterInfo = localRichStatus;; paramRespEncounterInfo = null)
    {
      if ((paramRespEncounterInfo != null) && (!paramRespEncounterInfo.a()))
      {
        if (!TextUtils.isEmpty(paramRespEncounterInfo.c)) {
          a(localTextView, paramRespEncounterInfo.jdField_b_of_type_Int);
        }
        for (;;)
        {
          paramViewHolder.jdField_b_of_type_Int = paramRespEncounterInfo.jdField_b_of_type_Int;
          localTextView.setText(paramRespEncounterInfo.a(null));
          localTextView.setVisibility(0);
          return;
          localTextView.setCompoundDrawables(null, null, null, null);
        }
      }
      paramViewHolder.jdField_b_of_type_Int = 0;
      localTextView.setVisibility(8);
      return;
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.c = paramBoolean;
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        i = j + 1;
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    if ((this.jdField_a_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_AndroidViewView != null)) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    Object localObject1;
    if (paramView != null)
    {
      localObject1 = (PeopleAroundAdapter.ViewHolder)paramView.getTag();
      if (localObject1 != null) {
        break label1150;
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903245, paramViewGroup, false);
      paramViewGroup = new PeopleAroundAdapter.ViewHolder();
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(16908294));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296848));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297350));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297351));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131297352));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297353));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131297252));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131297354));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297355));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131296275));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297250));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297253));
    }
    label290:
    label328:
    label345:
    label622:
    label1135:
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      RespEncounterInfo localRespEncounterInfo = (RespEncounterInfo)getItem(paramInt);
      Object localObject2;
      if (localRespEncounterInfo.tiny_id > 0L)
      {
        paramViewGroup.jdField_a_of_type_JavaLangString = String.valueOf(localRespEncounterInfo.tiny_id);
        paramViewGroup.jdField_a_of_type_Int = 32;
        paramViewGroup.jdField_a_of_type_EncounterSvcRespEncounterInfo = localRespEncounterInfo;
        if (TextUtils.isEmpty(localRespEncounterInfo.strNick)) {
          break label743;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localRespEncounterInfo.strNick.trim());
        if (localRespEncounterInfo.authFlag != 1) {
          break label756;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localRespEncounterInfo.strDescription);
        paramInt = this.jdField_a_of_type_Int - (int)(189.0F * this.jdField_a_of_type_Float);
        localObject1 = (VipOpenInfo)localRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
        localObject2 = (VipOpenInfo)localRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
        if ((localObject1 == null) || (!((VipOpenInfo)localObject1).bOpen)) {
          break label768;
        }
        paramInt -= (int)(this.jdField_a_of_type_Float * 5.0F) + 57;
      }
      label503:
      label1147:
      for (;;)
      {
        int i = paramInt;
        if (localRespEncounterInfo.authFlag == 1) {
          i = paramInt - (int)(20.0F * this.jdField_a_of_type_Float);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i);
        if (localRespEncounterInfo.cAge != 0)
        {
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(localRespEncounterInfo.cAge));
          paramInt = 1;
          switch (localRespEncounterInfo.cSex)
          {
          default: 
            paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130838761);
            int k = 0;
            i = paramInt;
            paramInt = k;
            paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
            if (i != 0)
            {
              paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
              paramInt = j;
              if (localRespEncounterInfo.constellation != 0) {
                break label1024;
              }
              paramViewGroup.e.setVisibility(8);
              if ((localRespEncounterInfo.profession_id > 0) && (localRespEncounterInfo.profession_id < 14)) {
                break label1064;
              }
              paramViewGroup.f.setVisibility(8);
              if (localRespEncounterInfo.nFaceNum < 6) {
                break label1111;
              }
              paramInt += 1;
              paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
              if (localRespEncounterInfo.marriage != 2) {
                break label1123;
              }
              paramInt += 1;
              paramViewGroup.g.setVisibility(0);
              if (paramInt <= 0) {
                break label1135;
              }
              paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            }
            break;
          }
        }
        for (;;)
        {
          a(localRespEncounterInfo.vipBaseInfo, paramViewGroup.jdField_c_of_type_AndroidWidgetImageView, paramViewGroup.jdField_a_of_type_AndroidWidgetTextView);
          a(paramViewGroup, localRespEncounterInfo);
          a(localRespEncounterInfo, paramViewGroup.jdField_a_of_type_AndroidWidgetImageView);
          return paramView;
          localObject1 = null;
          break;
          if (localRespEncounterInfo.lEctID <= 0L) {
            break label290;
          }
          paramViewGroup.jdField_a_of_type_JavaLangString = String.valueOf(localRespEncounterInfo.lEctID);
          break label290;
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
          break label328;
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label345;
          if ((localObject2 == null) || (!((VipOpenInfo)localObject2).bOpen)) {
            break label1147;
          }
          paramInt -= (int)(this.jdField_a_of_type_Float * 5.0F) + 47;
          break label444;
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText("");
          paramInt = 0;
          break label503;
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130838761);
          localObject2 = paramViewGroup.jdField_d_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder().append("男");
          if (localRespEncounterInfo.cAge > 0) {}
          for (localObject1 = localRespEncounterInfo.cAge + "岁";; localObject1 = "")
          {
            ((TextView)localObject2).setContentDescription((String)localObject1);
            paramInt = 2130838102;
            i = 1;
            break;
          }
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130838760);
          localObject2 = paramViewGroup.jdField_d_of_type_AndroidWidgetTextView;
          localStringBuilder = new StringBuilder().append("女");
          if (localRespEncounterInfo.cAge > 0) {}
          for (localObject1 = localRespEncounterInfo.cAge + "岁";; localObject1 = "")
          {
            ((TextView)localObject2).setContentDescription((String)localObject1);
            paramInt = 2130838097;
            i = 1;
            break;
          }
          paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          paramInt = 0;
          break label578;
          paramInt += 1;
          paramViewGroup.e.setText(ProfileCardUtil.a(localRespEncounterInfo.constellation));
          paramViewGroup.e.setBackgroundResource(2130838763);
          paramViewGroup.e.setVisibility(0);
          break label595;
          paramInt += 1;
          paramViewGroup.f.setText(com.tencent.mobileqq.util.NearbyProfileUtil.e[localRespEncounterInfo.profession_id]);
          paramViewGroup.f.setBackgroundResource(com.tencent.mobileqq.util.NearbyProfileUtil.a[localRespEncounterInfo.profession_id]);
          paramViewGroup.f.setVisibility(0);
          break label622;
          paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          break label644;
          paramViewGroup.g.setVisibility(8);
          break label665;
          paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label756:
      label1150:
      paramViewGroup = (ViewGroup)localObject1;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.PeopleAroundAdapter
 * JD-Core Version:    0.7.0.1
 */