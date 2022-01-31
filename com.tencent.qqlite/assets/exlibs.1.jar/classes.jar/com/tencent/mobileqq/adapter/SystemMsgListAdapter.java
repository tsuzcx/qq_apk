package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.newfriend.BaseSystemMsgInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class SystemMsgListAdapter
  extends XBaseAdapter
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private BaseSystemMsgInterface jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseSystemMsgInterface;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public SystemMsgListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, BaseSystemMsgInterface paramBaseSystemMsgInterface, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseSystemMsgInterface = paramBaseSystemMsgInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = this.jdField_a_of_type_JavaUtilList.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(getCount() - paramInt - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageRecord localMessageRecord;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903543, paramViewGroup, false);
      paramViewGroup = new SystemMsgListAdapter.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297670));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297671));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298484));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296532));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298486));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131298487));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131298488));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298485));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298490));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131298489));
      paramViewGroup.jdField_c_of_type_Int = paramInt;
      paramView.setTag(paramViewGroup);
      paramView.setBackgroundResource(2130837757);
      if (paramInt < this.jdField_a_of_type_Int) {
        paramView.setBackgroundResource(2130837758);
      }
      localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(getCount() - paramInt - 1);
      if (localMessageRecord == null) {
        break label253;
      }
      if ((localMessageRecord instanceof MessageForSystemMsg)) {
        break label232;
      }
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (SystemMsgListAdapter.ViewHolder)paramView.getTag();
      break;
      label232:
      paramViewGroup.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
      paramViewGroup.jdField_c_of_type_Long = localMessageRecord.uniseq;
      label253:
      if (localMessageRecord != null) {}
      for (int i = ((MessageForSystemMsg)localMessageRecord).getSystemMsg().msg_type.get(); (i != 2) && (i == 1); i = 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseSystemMsgInterface.a(paramViewGroup, paramInt);
        return paramView;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SystemMsgListAdapter
 * JD-Core Version:    0.7.0.1
 */