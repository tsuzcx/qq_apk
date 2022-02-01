import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class kuu
{
  private static final AtomicLong f = new AtomicLong(0L);
  private ksw a;
  private String acw = "";
  private QQAppInterface mApp;
  
  public kuu()
  {
    if (BaseActivity.sTopActivity != null)
    {
      this.mApp = ((QQAppInterface)BaseActivity.sTopActivity.getAppInterface());
      return;
    }
    this.mApp = kxm.a();
  }
  
  private void e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (ksz.E(BaseApplicationImpl.getContext(), paramString1))
    {
      QLog.d("ReadInJoyCommentSSOModule", 1, "the comment copy  is start request");
      paramString1 = kxm.a();
      if (paramString1 != null)
      {
        paramString1 = (lcd)paramString1.getManager(163);
        if (paramString1 != null)
        {
          paramString1 = paramString1.b().a();
          if (paramString1 != null) {
            paramString1.i(paramString2, paramString3, paramString4, paramString5);
          }
        }
      }
    }
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3)
  {
    return a(paramString1, paramString2, paramInt1, paramInt2, paramString3, false, paramString4, paramInt3);
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean, String paramString4, int paramInt3)
  {
    if ((this.mApp == null) || (this.a == null)) {
      return -1L;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      String str1 = new String(aqgo.decode(localJSONObject.getString("comment"), 0));
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("article_id", paramString2);
      ((JSONObject)localObject1).put("comment_val", str1);
      ((JSONObject)localObject1).put("type", paramInt2);
      ((JSONObject)localObject1).put("native_version", aqgz.bd(BaseApplicationImpl.getContext()));
      ((JSONObject)localObject1).put("os", 1);
      if (paramInt2 == 2)
      {
        ((JSONObject)localObject1).put("comment_id", paramString3);
        localObject2 = localJSONObject.optString("commentUin");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).put("to_uin", Long.parseLong((String)localObject2));
        }
        if (localJSONObject.optBoolean("isSecondReply", false))
        {
          localObject2 = localJSONObject.optString("replyUin");
          String str2 = localJSONObject.optString("commentId");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((JSONObject)localObject1).put("to", localObject2);
          }
          if (!TextUtils.isEmpty(str2)) {
            ((JSONObject)localObject1).put("to_sub_id", str2);
          }
        }
      }
      ((JSONObject)localObject1).put("src", 20);
      ((JSONObject)localObject1).put("uuid", this.acw);
      ((JSONObject)localObject1).put("content_src", paramInt1);
      Object localObject2 = ((JSONObject)localObject1).toString();
      long l = f.getAndIncrement();
      QLog.d("ReadInJoyCommentSSOModule", 2, "createComment cmd:MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_create seq : " + l + " info:" + (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new WebSsoBody.WebSsoRequestBody();
        ((WebSsoBody.WebSsoRequestBody)localObject1).data.set((String)localObject2);
        localObject2 = new NewIntent(this.mApp.getApplication(), kbs.class);
        ((NewIntent)localObject2).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_create");
        ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
        ((NewIntent)localObject2).setObserver(new kux(this, paramBoolean, l, paramInt2, paramString1, paramInt3, System.currentTimeMillis(), str1, paramString4, paramString2, paramString3, localJSONObject.optString("commentId")));
        this.mApp.startServlet((NewIntent)localObject2);
        return l;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      return -1L;
    }
    return -1L;
  }
  
  public void a(BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramBaseCommentData == null) || (this.mApp == null) || (this.a == null)) {
      return;
    }
    label401:
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = new JSONObject();
        if (!(paramBaseCommentData instanceof CommentData)) {
          break label354;
        }
        ((JSONObject)localObject).put("type", 1);
        ((JSONObject)localObject).put("comment_id", paramBaseCommentData.commentId);
        ((JSONObject)localObject).put("article_id", paramString);
        ((JSONObject)localObject).put("like", paramInt2);
        ((JSONObject)localObject).put("oper_type", paramInt1);
        ((JSONObject)localObject).put("native_version", aqgz.bd(BaseApplicationImpl.getContext()));
        if (!paramBaseCommentData.isActivity()) {
          break label401;
        }
        i = 400;
        ((JSONObject)localObject).put("src", i);
        ((JSONObject)localObject).put("uuid", this.acw);
        ((JSONObject)localObject).put("to_uin", Long.parseLong(paramBaseCommentData.uin));
        ((JSONObject)localObject).put("content_src", paramInt3);
        localObject = ((JSONObject)localObject).toString();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "commentLike cmd:MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like info:" + (String)localObject);
        }
        paramString = new WebSsoBody.WebSsoRequestBody();
        paramString.data.set((String)localObject);
        localObject = new NewIntent(this.mApp.getApplication(), kbs.class);
        ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like");
        ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
        ((NewIntent)localObject).setObserver(new kuw(this, paramBaseCommentData, paramInt1, paramInt2));
        this.mApp.startServlet((NewIntent)localObject);
        return;
      }
      catch (Exception paramString)
      {
        if (this.a != null) {
          this.a.a(false, paramBaseCommentData.commentId, paramInt1, paramInt2);
        }
        paramString.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyCommentSSOModule", 2, "commentLike error info:" + paramString.getLocalizedMessage());
      return;
      label354:
      if ((paramBaseCommentData instanceof SubCommentData))
      {
        ((JSONObject)localObject).put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
        ((JSONObject)localObject).put("sub_id", paramBaseCommentData.commentId);
        ((JSONObject)localObject).put("type", 2);
        continue;
        i = 20;
      }
    }
  }
  
  public void a(ksw paramksw)
  {
    this.a = paramksw;
  }
  
  public void b(BaseCommentData paramBaseCommentData, String paramString, int paramInt)
  {
    try
    {
      if (this.mApp == null) {
        return;
      }
      if (this.a == null) {
        return;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", paramBaseCommentData.getCommentLevel());
      if (!(paramBaseCommentData instanceof CommentData)) {
        break label299;
      }
      ((JSONObject)localObject).put("comment_id", paramBaseCommentData.commentId);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        if (this.a != null) {
          this.a.a(false, paramBaseCommentData);
        }
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyCommentSSOModule", 2, "createComment error info:" + paramString.getLocalizedMessage());
        return;
        label299:
        if ((paramBaseCommentData instanceof SubCommentData))
        {
          ((JSONObject)localObject).put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
          ((JSONObject)localObject).put("sub_id", paramBaseCommentData.commentId);
        }
      }
    }
    ((JSONObject)localObject).put("article_id", paramString);
    ((JSONObject)localObject).put("native_version", aqgz.bd(BaseApplicationImpl.getContext()));
    ((JSONObject)localObject).put("src", 20);
    ((JSONObject)localObject).put("uuid", this.acw);
    ((JSONObject)localObject).put("content_src", paramInt);
    localObject = ((JSONObject)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentSSOModule", 2, "deleteComment cmd:MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete info:" + (String)localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString = new WebSsoBody.WebSsoRequestBody();
      paramString.data.set((String)localObject);
      localObject = new NewIntent(this.mApp.getApplication(), kbs.class);
      ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete");
      ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
      ((NewIntent)localObject).setObserver(new kuv(this, paramBaseCommentData));
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
  }
  
  public void destroy()
  {
    this.a = null;
    this.mApp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kuu
 * JD-Core Version:    0.7.0.1
 */