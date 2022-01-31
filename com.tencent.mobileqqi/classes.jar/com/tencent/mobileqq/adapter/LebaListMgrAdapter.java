package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LebaListMgrAdapter
  extends BaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  protected int a;
  protected Drawable a;
  protected LayoutInflater a;
  protected QQAppInterface a;
  protected String a;
  protected HashMap a;
  protected List a;
  
  public LebaListMgrAdapter(QQAppInterface paramQQAppInterface, Context paramContext, List paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130838960);
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131427607);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public void a() {}
  
  public void a(LebaListMgrAdapter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null))
    {
      Object localObject1 = null;
      Object localObject2 = null;
      if (!TextUtils.isEmpty(paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName))
      {
        localObject1 = localObject2;
        if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          localObject1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName, localObject1);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setLeftIcon((Drawable)localObject2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
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
    LebaViewItem localLebaViewItem = (LebaViewItem)getItem(paramInt);
    if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
      return paramView;
    }
    LebaListMgrAdapter.ViewHolder localViewHolder;
    View localView;
    if (paramView == null)
    {
      localViewHolder = new LebaListMgrAdapter.ViewHolder(this);
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903585, null);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView.findViewById(2131232992));
      localView.setTag(localViewHolder);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
      if (localLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label309;
      }
      String str = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName;
      if (TextUtils.isEmpty(str)) {
        break label369;
      }
      paramViewGroup = (Drawable)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      paramView = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = localLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
        this.jdField_a_of_type_JavaUtilHashMap.put(str, paramView);
      }
    }
    for (;;)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      label175:
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setLeftIcon(paramViewGroup, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      paramView = localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (paramView != null)
      {
        paramView.setTag(Integer.valueOf(paramInt));
        paramView.setOnCheckedChangeListener(null);
        if (localLebaViewItem.jdField_a_of_type_Byte != 0) {
          break label317;
        }
        this.jdField_a_of_type_JavaLangString = ",开";
        localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      }
      for (;;)
      {
        paramView.setOnCheckedChangeListener(this);
        paramView.setContentDescription(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName + this.jdField_a_of_type_JavaLangString);
        if (paramInt != 0) {
          break label335;
        }
        localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(1);
        return localView;
        localViewHolder = (LebaListMgrAdapter.ViewHolder)paramView.getTag();
        localView = paramView;
        break;
        label309:
        paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        break label175;
        label317:
        this.jdField_a_of_type_JavaLangString = ",关";
        localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      }
      label335:
      if (paramInt == getCount() - 1)
      {
        localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
        return localView;
      }
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
      return localView;
      label369:
      paramView = null;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = paramCompoundButton.getTag();
      } while ((!(localObject instanceof Integer)) || (!(paramCompoundButton instanceof Switch)));
      int i = ((Integer)localObject).intValue();
      paramCompoundButton = (Switch)paramCompoundButton;
      localObject = (LebaViewItem)getItem(i);
    } while (localObject == null);
    long l1 = ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
    if (((LebaViewItem)localObject).jdField_a_of_type_Byte == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramBoolean != bool) {
        break label105;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("Q.lebatab.mgr", 4, "onCheckedChanged, same");
      return;
    }
    label105:
    byte b;
    label111:
    label127:
    long l2;
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      b = 0;
      ((LebaViewItem)localObject).jdField_a_of_type_Byte = b;
      if (paramBoolean) {
        break label376;
      }
      this.jdField_a_of_type_JavaLangString = ",关";
      paramCompoundButton.setContentDescription(((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName + this.jdField_a_of_type_JavaLangString);
      l2 = NetConnInfoCenter.getServerTimeMillis();
      LebaShowListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      ((RedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(34)).a(String.valueOf(l1), paramBoolean, l2);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      long l3 = ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
      if (!paramBoolean) {
        break label385;
      }
      paramCompoundButton = "1";
      label230:
      ReportController.b(localQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, String.valueOf(l3), paramCompoundButton, "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!paramBoolean) {
        break label392;
      }
    }
    label385:
    label392:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, paramCompoundButton, String.valueOf(((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), "", "");
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("Q.lebatab.mgr", 4, "onCheckedChanged, [" + l1 + "," + paramBoolean + "," + l2 + "]");
      return;
      b = 1;
      break label111;
      label376:
      this.jdField_a_of_type_JavaLangString = ",开";
      break label127;
      paramCompoundButton = "0";
      break label230;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.LebaListMgrAdapter
 * JD-Core Version:    0.7.0.1
 */