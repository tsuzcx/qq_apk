package com.tencent.biz.pubaccount.assistant;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import bkw;
import bkx;
import bky;
import bkz;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.List;
import mqq.app.NewIntent;

public class PubAccountAssistantSettingAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  
  PubAccountAssistantSettingAdapter(QQAppInterface paramQQAppInterface, Context paramContext, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMessageSettingAdapter", 2, "setItemBackground() childPos = " + paramInt1 + ", listSize = " + paramInt2);
    }
    if (paramInt2 <= 1)
    {
      paramView.setBackgroundResource(2130837877);
      return;
    }
    if (paramInt1 == 0)
    {
      paramView.setBackgroundResource(2130837882);
      return;
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramView.setBackgroundResource(2130837879);
      return;
    }
    paramView.setBackgroundResource(2130837881);
  }
  
  private void a(PublicAccountInfo paramPublicAccountInfo, int paramInt1, int paramInt2)
  {
    int i = 2;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidContentContext, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.luin.set(paramPublicAccountInfo.uin);
    localSetFunctionFlagRequset.type.set(paramInt1);
    localSetFunctionFlagRequset.value.set(paramInt2);
    PBUInt32Field localPBUInt32Field = localSetFunctionFlagRequset.account_type;
    if (paramPublicAccountInfo.extendType == 2) {}
    for (paramInt1 = i;; paramInt1 = 1)
    {
      localPBUInt32Field.set(paramInt1);
      localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
      localNewIntent.setObserver(new bky(this, paramPublicAccountInfo));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    label111:
    boolean bool;
    label149:
    String str;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903427, null);
      paramViewGroup = new bkz();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131230940));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131230941));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131232569));
      paramView.setTag(paramViewGroup);
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localPublicAccountInfo.getUin(), true);
      if (localObject == null) {
        break label257;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localPublicAccountInfo.name);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
      localObject = paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch;
      if (localPublicAccountInfo.mShowMsgFlag != 1) {
        break label301;
      }
      bool = true;
      ((Switch)localObject).setChecked(bool);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new bkx(this, localPublicAccountInfo, paramView));
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131560566);
      str = localPublicAccountInfo.name;
      if (localPublicAccountInfo.mShowMsgFlag != 1) {
        break label307;
      }
    }
    label257:
    label301:
    label307:
    for (paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131562562);; paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131561841))
    {
      paramView.setContentDescription(String.format((String)localObject, new Object[] { str, paramViewGroup }));
      a(paramView, paramInt, getCount());
      return paramView;
      paramViewGroup = (bkz)paramView.getTag();
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
      if (this.jdField_a_of_type_Boolean) {
        break label111;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new bkw(this), 1000L);
      break label111;
      bool = false;
      break label149;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingAdapter
 * JD-Core Version:    0.7.0.1
 */