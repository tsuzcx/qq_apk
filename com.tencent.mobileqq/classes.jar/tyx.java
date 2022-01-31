import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import java.util.HashMap;
import java.util.Map;

public class tyx
{
  public static final String a;
  private static tyx jdField_a_of_type_Tyx;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = tyx.class.getSimpleName();
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1))
    {
      localStringBuilder.append(paramString1);
      if (TextUtils.isEmpty(paramString2)) {
        break label78;
      }
      localStringBuilder.append("&&").append(paramString2);
      label42:
      if (TextUtils.isEmpty(paramString3)) {
        break label94;
      }
      localStringBuilder.append("&&").append(paramString3);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("0");
      break;
      label78:
      localStringBuilder.append("&&").append("0");
      break label42;
      label94:
      localStringBuilder.append("&&").append("0");
    }
  }
  
  public static tyx a()
  {
    if (jdField_a_of_type_Tyx == null) {}
    try
    {
      if (jdField_a_of_type_Tyx == null) {
        jdField_a_of_type_Tyx = new tyx();
      }
      return jdField_a_of_type_Tyx;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "storeComment storeKey: " + paramString1 + " comment: " + paramString2);
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
  
  private String b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStFeed != null)
    {
      paramStFeed = paramStFeed.id.get();
      if (paramStComment == null) {
        break label50;
      }
      paramStComment = paramStComment.id.get();
      label24:
      if (paramStReply == null) {
        break label56;
      }
    }
    label50:
    label56:
    for (paramStReply = paramStReply.id.get();; paramStReply = "")
    {
      return a(paramStFeed, paramStComment, paramStReply);
      paramStFeed = "";
      break;
      paramStComment = "";
      break label24;
    }
  }
  
  public String a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    paramStFeed = b(paramStFeed, paramStComment, paramStReply);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramStFeed))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "getComment storeKey: " + paramStFeed + " preCommentText: " + (String)this.jdField_a_of_type_JavaUtilMap.get(paramStFeed));
      return (String)this.jdField_a_of_type_JavaUtilMap.get(paramStFeed);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "getComment storeKey: " + paramStFeed + " preCommentText doesn't exit");
    return "";
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, String paramString)
  {
    a(b(paramStFeed, paramStComment, paramStReply), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyx
 * JD-Core Version:    0.7.0.1
 */