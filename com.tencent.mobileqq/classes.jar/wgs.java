import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;

public class wgs
  implements Runnable
{
  public wgs(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.b(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgs
 * JD-Core Version:    0.7.0.1
 */