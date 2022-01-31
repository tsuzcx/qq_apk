import OnlinePushPack.MsgInfo;
import android.util.Pair;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import java.util.ArrayList;
import java.util.TimerTask;

public class fjl
  extends TimerTask
{
  public fjl(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, long paramLong1, long paramLong2, Pair paramPair1, MsgInfo paramMsgInfo, long paramLong3, long paramLong4, byte paramByte, long paramLong5, Pair paramPair2, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Long != this.jdField_b_of_type_Long)
    {
      OnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOnLinePushMessageProcessor, this.jdField_a_of_type_AndroidUtilPair, this.jdField_a_of_type_OnlinePushPackMsgInfo, this.jdField_b_of_type_Long, this.c, this.d, this.jdField_a_of_type_Byte, this.e, this.jdField_b_of_type_AndroidUtilPair);
      return;
    }
    OnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOnLinePushMessageProcessor, this.jdField_a_of_type_AndroidUtilPair, this.jdField_a_of_type_OnlinePushPackMsgInfo, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_Long, String.valueOf(this.c), this.jdField_a_of_type_Byte, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fjl
 * JD-Core Version:    0.7.0.1
 */