import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedFeature;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class ptp
{
  public boolean aBB;
  public boolean aBC;
  public int bkl;
  public int bkm;
  public String feedId;
  public int totalLikeCount;
  
  public void a(qqstory_struct.FeedFeature paramFeedFeature)
  {
    boolean bool2 = true;
    this.feedId = paramFeedFeature.feed_id.get().toStringUtf8();
    this.totalLikeCount = paramFeedFeature.total_like_num.get();
    this.bkl = paramFeedFeature.total_comment_num.get();
    this.bkm = paramFeedFeature.total_viewing_num.get();
    if (paramFeedFeature.deny_comment.get() == 1)
    {
      bool1 = true;
      this.aBB = bool1;
      if (paramFeedFeature.has_like.get() != 1) {
        break label91;
      }
    }
    label91:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aBC = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ptp)paramObject;
      if (this.feedId != null) {
        return this.feedId.equals(paramObject.feedId);
      }
    } while (paramObject.feedId == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.feedId != null) {
      return this.feedId.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return "FeedFeatureItem{feedId='" + this.feedId + '\'' + ", totalLikeCount=" + this.totalLikeCount + ", totalCommentCount=" + this.bkl + ", totalViewCount=" + this.bkm + ", isDenyComment=" + this.aBB + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptp
 * JD-Core Version:    0.7.0.1
 */