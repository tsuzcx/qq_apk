import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgAnimatorCtr;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public final class xbj
  implements Runnable
{
  public xbj(int paramInt, SessionInfo paramSessionInfo, String paramString1, ListView paramListView, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean, GoldMsgAnimatorCtr paramGoldMsgAnimatorCtr) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      BaseBubbleBuilder.ViewHolder localViewHolder = GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("GoldMsgChatHelper", 2, "handleGrapSelf findAIOMessageByListId viewHolder=" + localViewHolder);
      }
      long l2 = 0L;
      long l1 = l2;
      if (localViewHolder != null)
      {
        l1 = l2;
        if (localViewHolder.a != null)
        {
          GoldMsgChatHelper.a(localViewHolder, 1, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_Boolean);
          l1 = localViewHolder.a.uniseq;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.a(new Object[] { Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), Long.valueOf(l1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbj
 * JD-Core Version:    0.7.0.1
 */