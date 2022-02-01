import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.Comment;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsg;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsgBody;
import com.tencent.pb.now.NowNearbyVideoCommentProto.GetCommentListResp;
import com.tencent.pb.now.NowNearbyVideoCommentProto.UserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class ajwb
  extends jnm.c
{
  ajwb(ajwa paramajwa, ajvz.b paramb) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool = false;
    QLog.i("CommentsDataSource", 1, "errorCode:" + paramInt);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xada.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        QLog.i("CommentsDataSource", 1, "err_msg:" + paramBundle.err_msg.get());
        if (!paramBundle.busi_buf.has())
        {
          QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
          this.jdField_a_of_type_Ajvz$b.dzN();
          return;
        }
        paramArrayOfByte = new NowNearbyVideoCommentProto.GetCommentListResp();
        paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
        if (paramArrayOfByte.result.get() != 0L)
        {
          QLog.i("CommentsDataSource", 1, "error code :" + paramArrayOfByte.result.get());
          this.jdField_a_of_type_Ajvz$b.dzN();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.i("CommentsDataSource", 1, "merge data error " + paramArrayOfByte);
        this.jdField_a_of_type_Ajvz$b.dzN();
        return;
      }
      paramBundle = new Comments();
      paramBundle.adn = paramArrayOfByte.total_num.get();
      QLog.i("CommentsDataSource", 1, "all comments count is: " + paramBundle.adn);
      if (paramArrayOfByte.end_flag.get() == 1L) {
        bool = true;
      }
      paramBundle.isEnd = bool;
      paramBundle.commentList = new ArrayList();
      if (paramArrayOfByte.lists.has())
      {
        Iterator localIterator = paramArrayOfByte.lists.get().iterator();
        while (localIterator.hasNext())
        {
          NowNearbyVideoCommentProto.Comment localComment = (NowNearbyVideoCommentProto.Comment)localIterator.next();
          Comments.Comment localComment1 = new Comments.Comment();
          localComment1.id = localComment.comment_id.get();
          localComment1.timestamp = localComment.create_time.get();
          localComment1.type = localComment.type.get();
          if (localComment.publish_info.has())
          {
            localComment1.uid = localComment.publish_info.uid.get();
            localComment1.name = localComment.publish_info.anchor_name.get().toStringUtf8();
            localComment1.headUrl = localComment.publish_info.head_img_url.get().toStringUtf8();
            localComment1.nowUserType = localComment.publish_info.user_type.get();
            localComment1.nowId = localComment.publish_info.now_id.get();
            if (localComment.reply_info.has())
            {
              localComment1.ado = localComment.reply_info.uid.get();
              localComment1.bSx = localComment.reply_info.anchor_name.get().toStringUtf8();
              localComment1.bSy = localComment.reply_info.head_img_url.get().toStringUtf8();
              localComment1.dll = localComment.reply_info.user_type.get();
              localComment1.adp = localComment.reply_info.now_id.get();
            }
          }
          if ((localComment.content.has()) && (localComment.content.msgs.has())) {
            localComment1.content = ((NowNearbyVideoCommentProto.CommentMsg)localComment.content.msgs.get(0)).msg.get().toStringUtf8();
          }
          if (!ajwa.a(this.jdField_a_of_type_Ajwa).contains(Long.valueOf(localComment.comment_id.get()))) {
            ajwa.a(this.jdField_a_of_type_Ajwa).add(Long.valueOf(localComment.comment_id.get()));
          }
          if (localComment1.type == 2) {
            paramBundle.DG.add(localComment1);
          }
          paramBundle.commentList.add(localComment1);
        }
      }
      QLog.i("CommentsDataSource", 1, "total:" + paramArrayOfByte.total_num.get() + ", ret:" + paramArrayOfByte.result.get());
      this.jdField_a_of_type_Ajvz$b.a(paramBundle);
      return;
    }
    QLog.i("CommentsDataSource", 1, "getComments failed");
    this.jdField_a_of_type_Ajvz$b.dzN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwb
 * JD-Core Version:    0.7.0.1
 */