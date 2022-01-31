import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;

class wax
  implements Runnable
{
  wax(waw paramwaw, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.sendFailCode == 41)
    {
      QQToast.a(this.jdField_a_of_type_Waw.a.a.getApp(), 2131436086, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Waw.a.a.getApp(), 2131438846, 0).a();
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Waw.a.a.c(), "Stick", "Send", "2", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wax
 * JD-Core Version:    0.7.0.1
 */