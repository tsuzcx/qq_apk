import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class ajwv
  extends jnm.c
{
  ajwv(ajwu paramajwu) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      oidb_0xada.RspBody localRspBody = new oidb_0xada.RspBody();
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        QLog.i("QQ_NOW_TASK", 2, "err_msg:   " + localRspBody.err_msg.get());
        if (!localRspBody.busi_buf.has()) {
          break label202;
        }
        if ((this.a.jdField_a_of_type_Ajwu$a != null) && (paramInt == 0))
        {
          this.a.jdField_a_of_type_Ajwu$a.b(paramInt, localRspBody.busi_buf.get().toByteArray(), paramBundle);
          return;
        }
        QLog.i("QQ_NOW_TASK", 1, "err_msg1:   " + localRspBody.err_msg.get());
        if (this.a.jdField_a_of_type_Ajwu$b == null) {
          return;
        }
        this.a.jdField_a_of_type_Ajwu$b.m(paramInt, paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        QLog.i("QQ_NOW_TASK", 1, "err_msg3:   ");
        if (this.a.jdField_a_of_type_Ajwu$b == null) {
          return;
        }
      }
      this.a.jdField_a_of_type_Ajwu$b.m(paramInt, null);
      return;
      label202:
      QLog.i("QQ_NOW_TASK", 1, "err_msg2:   ");
      if (this.a.jdField_a_of_type_Ajwu$b != null) {
        this.a.jdField_a_of_type_Ajwu$b.m(paramInt, null);
      }
    }
    else
    {
      QLog.i("QQ_NOW_TASK", 1, "err_msg4:   ");
      if (this.a.jdField_a_of_type_Ajwu$b != null) {
        this.a.jdField_a_of_type_Ajwu$b.m(paramInt, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwv
 * JD-Core Version:    0.7.0.1
 */