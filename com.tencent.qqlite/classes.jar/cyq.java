import OnlinePushPack.MsgInfo;
import android.util.Pair;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import java.util.ArrayList;
import java.util.TimerTask;

public class cyq
  extends TimerTask
{
  public cyq(DiscMessageProcessor paramDiscMessageProcessor, long paramLong1, long paramLong2, Pair paramPair1, MsgInfo paramMsgInfo, long paramLong3, long paramLong4, byte paramByte, long paramLong5, Pair paramPair2, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Long != this.jdField_b_of_type_Long)
    {
      DiscMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageDiscMessageProcessor, this.jdField_a_of_type_AndroidUtilPair, this.jdField_a_of_type_OnlinePushPackMsgInfo, this.jdField_b_of_type_Long, this.c, this.d, this.jdField_a_of_type_Byte, this.e, this.jdField_b_of_type_AndroidUtilPair);
      return;
    }
    DiscMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageDiscMessageProcessor, this.jdField_a_of_type_AndroidUtilPair, this.jdField_a_of_type_OnlinePushPackMsgInfo, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_Long, String.valueOf(this.c), this.jdField_a_of_type_Byte, this.e, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cyq
 * JD-Core Version:    0.7.0.1
 */