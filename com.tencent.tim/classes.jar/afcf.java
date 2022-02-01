import android.text.TextUtils;
import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.Elem;
import appoint.define.appoint_define.Face;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.RichText;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.notColumn;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afcf
{
  public afcj a;
  public afcj b;
  @notColumn
  public String bCT;
  public String commentId;
  public String content;
  public String datingId;
  public int flag;
  public String replyId;
  public String strTime;
  public long time;
  
  public static afcf a(appoint_define.DateComment paramDateComment)
  {
    if ((paramDateComment == null) || (TextUtils.isEmpty(paramDateComment.str_comment_id.get()))) {
      return null;
    }
    afcf localafcf = new afcf();
    localafcf.commentId = paramDateComment.str_comment_id.get();
    localafcf.datingId = afck.a((appoint_define.AppointID)paramDateComment.msg_appoint_id.get());
    localafcf.time = paramDateComment.uint32_time.get();
    appoint_define.RichText localRichText;
    int i;
    if (paramDateComment.msg_content.has())
    {
      localRichText = (appoint_define.RichText)paramDateComment.msg_content.get();
      localafcf.content = a(localRichText);
      localafcf.a = afcj.a((appoint_define.StrangerInfo)paramDateComment.msg_publisher_info.get());
      if (!paramDateComment.uint32_flag.has()) {
        break label220;
      }
      i = paramDateComment.uint32_flag.get();
      label131:
      localafcf.flag = i;
      if (!paramDateComment.msg_reply_info.has()) {
        break label225;
      }
    }
    label220:
    label225:
    for (paramDateComment = (appoint_define.ReplyInfo)paramDateComment.msg_reply_info.get();; paramDateComment = null)
    {
      if (paramDateComment != null)
      {
        localafcf.replyId = paramDateComment.str_comment_id.get();
        localafcf.b = afcj.a((appoint_define.StrangerInfo)paramDateComment.msg_stranger_info.get());
      }
      localafcf.bCT = afck.h(localafcf.time, true);
      localafcf.strTime = afck.h(localafcf.time, false);
      return localafcf;
      localRichText = null;
      break;
      i = 0;
      break label131;
    }
  }
  
  public static afcf a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    afcf localafcf = new afcf();
    try
    {
      localafcf.commentId = paramJSONObject.getString("commentId");
      localafcf.datingId = paramJSONObject.getString("datingId");
      localafcf.content = paramJSONObject.getString("content");
      localafcf.time = paramJSONObject.getLong("time");
      localafcf.a = afcj.a(paramJSONObject.getJSONObject("puber"));
      localafcf.flag = paramJSONObject.getInt("flag");
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        for (;;)
        {
          localafcf.replyId = paramJSONObject.getString("replyId");
          try
          {
            localafcf.b = afcj.a(paramJSONObject.getJSONObject("replyer"));
            return localafcf;
          }
          catch (JSONException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return localafcf;
          }
          localJSONException1 = localJSONException1;
          localJSONException1.printStackTrace();
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  public static String a(appoint_define.RichText paramRichText)
  {
    if (paramRichText == null) {
      return "";
    }
    if (paramRichText.rpt_msg_elems.has()) {}
    for (paramRichText = paramRichText.rpt_msg_elems.get(); (paramRichText == null) || (paramRichText.isEmpty()); paramRichText = null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramRichText.iterator();
    label135:
    label187:
    label190:
    label192:
    label195:
    while (localIterator.hasNext())
    {
      appoint_define.Elem localElem = (appoint_define.Elem)localIterator.next();
      if (localElem != null)
      {
        if (localElem.str_content.has())
        {
          paramRichText = localElem.str_content.get();
          label106:
          localStringBuilder.append(paramRichText);
          if (!localElem.msg_face_info.has()) {
            break label187;
          }
          paramRichText = (appoint_define.Face)localElem.msg_face_info.get();
          if (paramRichText == null) {
            break label190;
          }
          if (!paramRichText.uint32_index.has()) {
            break label192;
          }
        }
        for (int i = paramRichText.uint32_index.get();; i = -1)
        {
          if (i < 0) {
            break label195;
          }
          localStringBuilder.append('\024');
          localStringBuilder.append((char)afky.hm(i));
          break;
          paramRichText = "";
          break label106;
          paramRichText = null;
          break label135;
          break;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static JSONObject a(afcf paramafcf)
  {
    if (paramafcf == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("commentId", paramafcf.commentId);
      localJSONObject.put("datingId", paramafcf.datingId);
      localJSONObject.put("content", paramafcf.content);
      localJSONObject.put("time", paramafcf.time);
      localJSONObject.put("replyId", paramafcf.replyId);
      localJSONObject.put("puber", afcj.a(paramafcf.a));
      localJSONObject.put("replyer", afcj.a(paramafcf.b));
      localJSONObject.put("flag", paramafcf.flag);
      return localJSONObject;
    }
    catch (JSONException paramafcf)
    {
      paramafcf.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static String pack(List<afcf> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((afcf)paramList.next());
      if (localJSONObject == null) {
        break label83;
      }
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    label83:
    for (;;)
    {
      if (i >= 20) {
        return localJSONArray.toString();
      }
      break;
    }
  }
  
  public static void x(List<afcf> paramList, String paramString)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          afcf localafcf = a(paramString.getJSONObject(i));
          if (localafcf != null) {
            paramList.add(localafcf);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (paramObject.getClass() != getClass());
      paramObject = (afcf)paramObject;
    } while (((this.commentId != null) || (paramObject.commentId != null)) && ((this.commentId == null) || (!this.commentId.equals(paramObject.commentId))));
    return true;
  }
  
  public int hashCode()
  {
    if (TextUtils.isEmpty(this.commentId)) {
      return "".hashCode();
    }
    return this.commentId.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.commentId).append(",").append(this.datingId).append(",").append(this.content).append(",").append(this.time).append(",").append(this.replyId).append(",").append(this.a).append(",").append(this.b).append(",").append(this.flag).append(",").append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcf
 * JD-Core Version:    0.7.0.1
 */