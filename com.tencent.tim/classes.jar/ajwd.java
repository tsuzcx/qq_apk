import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.DelCommentResp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class ajwd
  extends jnm.c
{
  ajwd(ajwa paramajwa, ajvz.a parama, Comments.Comment paramComment) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("CommentsDataSource", 1, "errorCode:" + paramInt);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xada.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        QLog.i("CommentsDataSource", 1, "err_msg:" + paramBundle.err_msg.get());
        if (paramBundle.busi_buf.has())
        {
          paramArrayOfByte = new NowNearbyVideoCommentProto.DelCommentResp();
          paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.i("CommentsDataSource", 1, "ret:" + paramArrayOfByte.result.get());
          }
          this.jdField_a_of_type_Ajvz$a.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, (int)paramArrayOfByte.result.get());
          paramArrayOfByte = (AppInterface)this.n.get();
          if (paramArrayOfByte == null) {
            return;
          }
          ((akio)paramArrayOfByte.getManager(263)).av(ajwa.a(this.jdField_a_of_type_Ajwa).id, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment.id);
          return;
        }
        QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
        this.jdField_a_of_type_Ajvz$a.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.i("CommentsDataSource", 1, "merge delete resp data error");
        this.jdField_a_of_type_Ajvz$a.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1);
        return;
      }
    }
    else
    {
      this.jdField_a_of_type_Ajvz$a.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwd
 * JD-Core Version:    0.7.0.1
 */