import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.message.BaseMessageProcessorForTroopAndDisc;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import java.util.Map;
import tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef.RspBody;

public class zso
  extends ProtoUtils.TroopProtocolObserver
{
  public zso(BaseMessageProcessorForTroopAndDisc paramBaseMessageProcessorForTroopAndDisc, boolean paramBoolean, MessageInfo paramMessageInfo, long paramLong1, long paramLong2, RecentUser paramRecentUser, String paramString, MessageRecord paramMessageRecord, Map paramMap)
  {
    super(paramBoolean);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null)) {}
    for (;;)
    {
      return;
      try
      {
        paramBundle = new oidb_cmd0x6ef.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((paramBundle.is_create.get() == 1) || (paramBundle.is_join.get() == 1))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageInfo.j.a(this.jdField_a_of_type_Long, this.b);
          if (18 >= this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msgType)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msgType = 18;
            this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg = MessageInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageProcessorForTroopAndDisc.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageInfo, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, true);
            this.jdField_a_of_type_JavaUtilMap.put(MsgProxyUtils.a(this.jdField_a_of_type_JavaLangString, 1), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zso
 * JD-Core Version:    0.7.0.1
 */