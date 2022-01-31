import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.mobileqq.app.DataLineHandler;
import java.util.List;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;

public class csq
  implements Runnable
{
  public csq(DataLineHandler paramDataLineHandler, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.onFileComing0x211_0x2_0xa(this.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0x7SubMsgType0x7$MsgBody$MsgHeader, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     csq
 * JD-Core Version:    0.7.0.1
 */