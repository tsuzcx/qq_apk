import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class shf
{
  public static final String TAG = shf.class.getSimpleName();
  private static shf a;
  private Map<String, String> fw = new HashMap();
  
  public static shf a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new shf();
      }
      return a;
    }
    finally {}
  }
  
  private String b(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
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
      return q(paramStFeed, paramStComment, paramStReply);
      paramStFeed = "";
      break;
      paramStComment = "";
      break label24;
    }
  }
  
  private void ci(String paramString1, String paramString2)
  {
    QLog.d(TAG, 1, "storeComment storeKey: " + paramString1 + " comment: " + paramString2);
    this.fw.put(paramString1, paramString2);
  }
  
  private String q(String paramString1, String paramString2, String paramString3)
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
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, String paramString)
  {
    ci(b(paramStFeed, paramStComment, paramStReply), paramString);
  }
  
  public String c(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    paramStFeed = b(paramStFeed, paramStComment, paramStReply);
    if (this.fw.containsKey(paramStFeed))
    {
      QLog.d(TAG, 1, "getComment storeKey: " + paramStFeed + " preCommentText: " + (String)this.fw.get(paramStFeed));
      return (String)this.fw.get(paramStFeed);
    }
    QLog.d(TAG, 1, "getComment storeKey: " + paramStFeed + " preCommentText doesn't exit");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     shf
 * JD-Core Version:    0.7.0.1
 */