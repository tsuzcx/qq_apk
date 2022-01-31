import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;

class vsv
  implements Runnable
{
  vsv(vsu paramvsu, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.sendFailCode == 41)
    {
      QQToast.a(this.jdField_a_of_type_Vsu.a.a.getApp(), 2131436086, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Vsu.a.a.getApp(), 2131438846, 0).a();
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Vsu.a.a.c(), "Stick", "Send", "1", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsv
 * JD-Core Version:    0.7.0.1
 */