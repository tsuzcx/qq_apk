import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqAddFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class wlt
  extends wnn
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  String jdField_a_of_type_JavaLangString;
  wnp jdField_a_of_type_Wnp;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  
  public wlt(CommentEntry paramCommentEntry, wnp paramwnp)
  {
    this(paramCommentEntry.feedId, paramCommentEntry.replierUnionId, paramCommentEntry.content, paramCommentEntry.fakeId, paramCommentEntry.pbType, paramCommentEntry.extras, paramCommentEntry.commentType, paramwnp);
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
  }
  
  public wlt(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, wnp paramwnp)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.d = paramString4;
    this.jdField_a_of_type_Wnp = paramwnp;
    paramString1 = yqu.a("home_page-comment_suc-d1");
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramInt1 = 0;; paramInt1 = Integer.parseInt(paramString1))
    {
      this.jdField_a_of_type_Int = paramInt1;
      return;
    }
  }
  
  public String a()
  {
    return wlr.jdField_a_of_type_JavaLangString;
  }
  
  public wno a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspAddFeedComment localRspAddFeedComment = new qqstory_service.RspAddFeedComment();
    try
    {
      localRspAddFeedComment.mergeFrom(paramArrayOfByte);
      return new wlu(localRspAddFeedComment, this.jdField_a_of_type_Wnp);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      yqp.d("Q.qqstory:FeedCommentDataProvider", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqAddFeedComment localReqAddFeedComment = new qqstory_service.ReqAddFeedComment();
    localReqAddFeedComment.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqAddFeedComment.content.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    localReqAddFeedComment.fake_id.set(this.jdField_a_of_type_Long);
    localReqAddFeedComment.source.set(this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localReqAddFeedComment.reply_union_id.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    if (this.jdField_b_of_type_Int == 1) {
      localReqAddFeedComment.type.set(1);
    }
    for (;;)
    {
      localReqAddFeedComment.comment_type.set(this.jdField_c_of_type_Int);
      if (!TextUtils.isEmpty(this.d)) {
        localReqAddFeedComment.extras.set(ByteStringMicro.copyFromUtf8(this.d));
      }
      return localReqAddFeedComment.toByteArray();
      localReqAddFeedComment.type.set(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlt
 * JD-Core Version:    0.7.0.1
 */