import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class krx
{
  private BaseCommentData a;
  private JSONObject al = new JSONObject();
  private int area = 0;
  private ArticleInfo articleInfo;
  
  public krx(ArticleInfo paramArticleInfo, BaseCommentData paramBaseCommentData)
  {
    this.articleInfo = paramArticleInfo;
    this.a = paramBaseCommentData;
  }
  
  public krx(ktm paramktm)
  {
    if (paramktm == null) {
      return;
    }
    this.articleInfo = paramktm.articleInfo;
    this.a = paramktm.a;
    this.area = paramktm.area;
  }
  
  private krx a(int paramInt)
  {
    int j = 1;
    int i = 1;
    if (paramInt == 1) {}
    try
    {
      this.al.put("puin_type", 1);
      return this;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject1;
      localJSONException.printStackTrace();
      return this;
    }
    if ((paramInt == 2) && (this.articleInfo != null))
    {
      localJSONObject1 = this.al;
      if (this.articleInfo.mAccountLess == 0) {}
      for (paramInt = i;; paramInt = 2)
      {
        localJSONObject1.put("puin_type", paramInt);
        return this;
      }
    }
    if ((paramInt == 3) && (this.articleInfo != null))
    {
      JSONObject localJSONObject2 = this.al;
      if (this.articleInfo.mAccountLess == 0) {}
      for (paramInt = j;; paramInt = 2)
      {
        localJSONObject2.put("puin_type", paramInt);
        return this;
      }
    }
    return this;
  }
  
  private krx d()
  {
    ktr localktr;
    String str;
    if (this.area == 0)
    {
      localktr = ktr.a(this.articleInfo);
      if (localktr != null)
      {
        str = "";
        if (!(this.a instanceof CommentData)) {
          break label65;
        }
        str = this.a.commentId;
      }
    }
    for (;;)
    {
      this.area = localktr.aK(str);
      try
      {
        this.al.put("area", this.area);
        return this;
      }
      catch (JSONException localJSONException)
      {
        label65:
        localJSONException.printStackTrace();
      }
      if ((this.a instanceof SubCommentData)) {
        str = ((SubCommentData)this.a).parentCommentId;
      }
    }
    return this;
  }
  
  private int nC()
  {
    if (this.a == null) {
      return 0;
    }
    switch (this.a.contentSrc)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 2;
  }
  
  public krx a()
  {
    d();
    c();
    e();
    f();
    i();
    return this;
  }
  
  public krx a(String paramString)
  {
    try
    {
      this.al.put("comment_id", paramString);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public krx b()
  {
    try
    {
      if ((this.a != null) && ((this.a instanceof SubCommentData)))
      {
        this.al.put("comment_id", ((SubCommentData)this.a).parentCommentId);
        this.al.put("sub_comment_id", this.a.commentId);
      }
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public krx b(int paramInt)
  {
    try
    {
      this.al.put("amount", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public krx b(String paramString)
  {
    try
    {
      this.al.put("to_uin", paramString);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public String build()
  {
    for (;;)
    {
      try
      {
        if (this.articleInfo != null)
        {
          this.al.put("algorithm_id", this.articleInfo.mAlgorithmID);
          if (this.articleInfo.mArticleID != -1L) {
            this.al.put("mp_article_id", this.articleInfo.mArticleID);
          }
        }
        if (this.a != null)
        {
          if (!(this.a instanceof CommentData)) {
            continue;
          }
          this.al.put("comment_id", this.a.commentId);
        }
        this.al.put("kandian_mode", kxm.nR());
        this.al.put("comment_platform", 3);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      return this.al.toString();
      if ((this.a instanceof SubCommentData)) {
        this.al.put("sub_comment_id", this.a.commentId);
      }
    }
  }
  
  public krx c()
  {
    int i = nC();
    try
    {
      this.al.put("entry", i);
      return a(i);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public krx c(int paramInt)
  {
    try
    {
      this.al.put("actionsheet_choose", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public krx d(int paramInt)
  {
    try
    {
      this.al.put("comment_number", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public krx e()
  {
    int i = 1;
    int j;
    if (this.a != null)
    {
      j = this.a.getCommentLevel();
      if (j != 1) {
        break label42;
      }
      i = 0;
    }
    for (;;)
    {
      try
      {
        this.al.put("comment_level", i);
        return this;
      }
      catch (JSONException localJSONException)
      {
        label42:
        localJSONException.printStackTrace();
      }
      j = 2;
      break;
      if (j != 2) {
        i = 2;
      }
    }
    return this;
  }
  
  public krx e(int paramInt)
  {
    try
    {
      this.al.put("change_into", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public krx f()
  {
    try
    {
      if (this.a != null)
      {
        int i;
        if (this.a.isAuthorSelection()) {
          i = 1;
        }
        while (i > 0)
        {
          this.al.put("comment_type", i);
          return this;
          boolean bool = this.a.isAwesome();
          if (bool) {
            i = 2;
          } else {
            i = 3;
          }
        }
      }
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public krx g()
  {
    if (this.a == null) {
      return this;
    }
    int i = 0;
    if (this.a.isBanner()) {
      i = 1;
    }
    for (;;)
    {
      try
      {
        this.al.put("type", i);
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return this;
      }
      if (this.a.isActivity()) {
        i = 2;
      } else if (this.a.isFamilyTopEntry()) {
        i = 3;
      }
    }
  }
  
  public krx h()
  {
    if (this.a == null) {
      return this;
    }
    String str1 = "";
    if (this.a.isActivity()) {
      str1 = String.valueOf(this.a.activityCfgID);
    }
    for (;;)
    {
      try
      {
        this.al.put("h5_id", str1);
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return this;
      }
      if (this.a.isBanner()) {
        String str2 = this.a.commentId;
      }
    }
  }
  
  public krx i()
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.a.styleData))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.a.styleData).optJSONObject("reportJson");
        if (localJSONObject != null)
        {
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = localJSONObject.getString(str1);
            this.al.put(str1, str2);
          }
        }
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    QLog.d("CommentReportR5Builder", 2, "addFamilyReportData r5 " + this.al.toString());
    return this;
  }
  
  public krx j()
  {
    try
    {
      JSONObject localJSONObject = this.al;
      if (this.a != null) {}
      for (int i = this.a.createSrc;; i = 0)
      {
        localJSONObject.put("into_app", i);
        return this;
      }
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     krx
 * JD-Core Version:    0.7.0.1
 */