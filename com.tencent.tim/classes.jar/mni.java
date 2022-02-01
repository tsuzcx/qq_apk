import android.os.Bundle;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.RspBody;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.TopicInfoSetRsp;

class mni
  extends jnm.d
{
  mni(mnh parammnh, mne parammne, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new oidb_0xe33.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if (paramBundle.topic_info_set_rsp.has())
        {
          paramArrayOfByte = paramBundle.topic_info_set_rsp;
          this.jdField_a_of_type_Mne.d(paramInt, paramArrayOfByte.err_msg.get(), Integer.toString(paramArrayOfByte.ret_code.get()), paramArrayOfByte.topic_id.get());
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          if (this.val$actionType != 1) {
            break label131;
          }
          QLog.d("RIJUGC.ManagerColumnModel", 1, "ManageColumnModel createColumn failed." + paramArrayOfByte.toString());
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Mne.d(paramInt, "", "", 0);
      return;
      label131:
      if (this.val$actionType == 2) {
        QLog.d("RIJUGC.ManagerColumnModel", 1, "ManageColumnModel editColumn failed." + paramArrayOfByte.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mni
 * JD-Core Version:    0.7.0.1
 */