import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.mobileqq.app.DataLineHandler;
import java.util.List;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;

public class fbb
  implements Runnable
{
  public fbb(DataLineHandler paramDataLineHandler, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.onFileOperate0x211(this.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0x7SubMsgType0x7$MsgBody$MsgHeader, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fbb
 * JD-Core Version:    0.7.0.1
 */