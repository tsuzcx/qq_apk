import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class zte
  implements Runnable
{
  public zte(DiscMessageProcessor paramDiscMessageProcessor, ArrayList paramArrayList, long paramLong1, long paramLong2, String paramString, MsgInfo paramMsgInfo, long paramLong3) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(this.jdField_a_of_type_Long)))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(this.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "陌生人uin包括自己,移出");
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaUtilArrayList.size() * 8);
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        String str2 = (String)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i)).second;
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 9 server showName empty");
          }
          str1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageDiscMessageProcessor.a, String.valueOf(this.b), String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.get(i)));
        }
        if (i == 0) {
          localStringBuilder.append(str1);
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append("、" + str1);
        }
      }
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "show yinsi tips" + localStringBuilder.toString());
      }
      DiscMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageDiscMessageProcessor, this.jdField_a_of_type_OnlinePushPackMsgInfo, this.jdField_a_of_type_Long, this.b, this.c, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zte
 * JD-Core Version:    0.7.0.1
 */