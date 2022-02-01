import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;

public class kst
  implements kqd.a
{
  public kst(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void b(kqf paramkqf)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onBiuAndCommentSend fragment");
    if (paramkqf == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramkqf.getResultCode()))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, localObject);
      if ((paramkqf != null) && (paramkqf.getResultCode() == 0)) {
        kqd.a(paramkqf.ii(), paramkqf.getCommentId(), paramkqf.getCommentType(), paramkqf.getFeedsType(), paramkqf.isIsSecondReply(), paramkqf.getReplyCommentId(), paramkqf.getReplyUin(), paramkqf.a());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kst
 * JD-Core Version:    0.7.0.1
 */