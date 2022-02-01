import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedFeature;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wqp
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  
  public void a(qqstory_struct.FeedFeature paramFeedFeature)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_JavaLangString = paramFeedFeature.feed_id.get().toStringUtf8();
    this.jdField_a_of_type_Int = paramFeedFeature.total_like_num.get();
    this.jdField_b_of_type_Int = paramFeedFeature.total_comment_num.get();
    this.c = paramFeedFeature.total_viewing_num.get();
    if (paramFeedFeature.deny_comment.get() == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramFeedFeature.has_like.get() != 1) {
        break label91;
      }
    }
    label91:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
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
      paramObject = (wqp)paramObject;
      if (this.jdField_a_of_type_JavaLangString != null) {
        return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
      }
    } while (paramObject.jdField_a_of_type_JavaLangString == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_JavaLangString.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return "FeedFeatureItem{feedId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", totalLikeCount=" + this.jdField_a_of_type_Int + ", totalCommentCount=" + this.jdField_b_of_type_Int + ", totalViewCount=" + this.c + ", isDenyComment=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqp
 * JD-Core Version:    0.7.0.1
 */