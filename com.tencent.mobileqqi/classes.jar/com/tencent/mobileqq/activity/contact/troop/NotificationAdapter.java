package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.newfriend.BaseSystemMsgInterface;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.XBaseAdapter;
import efp;
import java.util.ArrayList;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class NotificationAdapter
  extends XBaseAdapter
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new efp(this);
  private BaseSystemMsgInterface jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseSystemMsgInterface;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public SlideDetectListView a;
  public List a;
  private List b = new ArrayList();
  
  public NotificationAdapter(Context paramContext, QQAppInterface paramQQAppInterface, BaseSystemMsgInterface paramBaseSystemMsgInterface, int paramInt, SlideDetectListView paramSlideDetectListView)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseSystemMsgInterface = paramBaseSystemMsgInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = paramSlideDetectListView;
  }
  
  private boolean a(structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    if (paramStructMsg != null)
    {
      int i = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int j = paramStructMsg.msg.sub_type.get();
      int k = paramStructMsg.msg.src_id.get();
      int m = paramStructMsg.msg.sub_src_id.get();
      int n = paramStructMsg.msg.group_msg_type.get();
      structmsg.SystemMsgActionInfo localSystemMsgActionInfo = new structmsg.SystemMsgActionInfo();
      localSystemMsgActionInfo.group_code.set(paramStructMsg.msg.group_code.get());
      localSystemMsgActionInfo.sig.set(ByteStringMicro.EMPTY);
      localSystemMsgActionInfo.type.set(15);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localSystemMsgActionInfo.get(), 3);
      bool = true;
    }
    return bool;
  }
  
  public void a()
  {
    if (this.b != null) {
      this.b.clear();
    }
  }
  
  public void a(List paramList)
  {
    this.b = paramList;
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.b != null) {
      i = this.b.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.b == null) || (paramInt > this.b.size())) {
      return null;
    }
    return this.b.get(getCount() - paramInt - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label190:
    MessageRecord localMessageRecord;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903400, paramViewGroup, false);
      paramViewGroup = new NotificationAdapter.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131232459));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232460));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131232461));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232462));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232463));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232464));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232465));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131232466));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131232467));
      ((Button)paramView.findViewById(2131232468)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_b_of_type_Int = paramInt;
      if (paramInt >= this.jdField_a_of_type_Int) {
        break label226;
      }
      paramView.setBackgroundResource(2130837851);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837851);
      localMessageRecord = (MessageRecord)getItem(paramInt);
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForSystemMsg))) {
        break label246;
      }
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (NotificationAdapter.ViewHolder)paramView.getTag();
      break;
      label226:
      paramView.setBackgroundResource(2130837850);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837850);
      break label190;
      label246:
      paramViewGroup.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
      paramViewGroup.jdField_c_of_type_Long = localMessageRecord.uniseq;
      if (localMessageRecord != null) {}
      for (int i = ((MessageForSystemMsg)localMessageRecord).getSystemMsg().msg_type.get(); i == 2; i = 2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotificationAdapter
 * JD-Core Version:    0.7.0.1
 */