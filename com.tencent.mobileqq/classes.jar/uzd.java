import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import java.util.List;

public class uzd
{
  public FeedCloudMeta.StComment a;
  public List<uzm> a;
  
  public uzd(FeedCloudMeta.StComment paramStComment)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, null, paramInt2);
  }
  
  public void a(int paramInt, FeedCloudMeta.StReply paramStReply)
  {
    a(paramInt, paramStReply, 0);
  }
  
  public void a(int paramInt1, FeedCloudMeta.StReply paramStReply, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    paramStReply = new uzm(paramInt1, paramStReply, paramInt2);
    this.jdField_a_of_type_JavaUtilList.add(paramStReply);
  }
  
  public void a(String paramString, int paramInt)
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int i = 0;
    label13:
    int j = k;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if ((((uzm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null) && (paramString.equals(((uzm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get())))
      {
        this.jdField_a_of_type_JavaUtilList.remove(i);
        j = k;
      }
    }
    else {
      label93:
      if (j < this.jdField_a_of_type_JavaUtilList.size()) {
        if ((((uzm)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Int == 2) && (j < paramInt) && (((uzm)this.jdField_a_of_type_JavaUtilList.get(j)).b > 0))
        {
          this.jdField_a_of_type_JavaUtilList.add(j, new uzm(1, (FeedCloudMeta.StReply)((FeedCloudMeta.StReply)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.get(j)).get()));
          if (((uzm)this.jdField_a_of_type_JavaUtilList.get(j + 1)).b - 1 != 0) {
            break label248;
          }
          this.jdField_a_of_type_JavaUtilList.remove(j + 1);
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label93;
      break;
      i += 1;
      break label13;
      label248:
      paramString = (uzm)this.jdField_a_of_type_JavaUtilList.get(j + 1);
      paramString.b -= 1;
    }
  }
  
  public void a(String paramString, FeedCloudMeta.StReply paramStReply)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        if ((((uzm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null) && (paramString.equals(((uzm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get())))
        {
          ((uzm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
          return;
        }
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzd
 * JD-Core Version:    0.7.0.1
 */