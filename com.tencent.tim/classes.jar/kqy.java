import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.a;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class kqy
{
  public static SubCommentData a(ktm paramktm, int paramInt)
  {
    if ((paramktm != null) && ((paramktm.a instanceof SubCommentData)))
    {
      paramktm = (CommentData)paramktm.a;
      if ((paramktm.subCommentList != null) && (paramktm.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramktm.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  public static TemplateBean a(VafContext paramVafContext, ktm paramktm, int paramInt, boolean paramBoolean, kte paramkte)
  {
    auvk.traceBegin("CommentProteusUtil.getTemplateBean");
    npi localnpi1;
    if (paramVafContext == null)
    {
      npi localnpi2 = npi.a("comment_feeds", true);
      localnpi1 = localnpi2;
      if (localnpi2 == null) {
        return null;
      }
    }
    else
    {
      localnpi1 = (npi)paramVafContext.getTemplateFactory();
    }
    if (localnpi1 != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = localnpi1.getTemplateBean(a(paramkte, paramVafContext, paramktm, paramInt, paramBoolean));
        try
        {
          auvk.traceEnd();
          return paramVafContext;
        }
        catch (JSONException paramktm) {}
      }
      catch (JSONException paramktm)
      {
        paramVafContext = null;
        continue;
      }
      paramktm.printStackTrace();
      return paramVafContext;
      paramVafContext = null;
    }
  }
  
  private static List<String> a(ktm paramktm)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramktm == null) || (paramktm.a == null) || (paramktm.a.mediaDataList == null)) {
      return localArrayList;
    }
    paramktm = paramktm.a.mediaDataList;
    if (paramktm.size() > 0)
    {
      paramktm = paramktm.iterator();
      while (paramktm.hasNext())
      {
        BaseCommentData.a locala = (BaseCommentData.a)paramktm.next();
        if ((locala.medalType == 1) || (locala.medalType == 2)) {
          localArrayList.add(locala.picUrl);
        } else if (locala.medalType == 3) {
          localArrayList.add(locala.videoUrl);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "getPicUrlList | pathsize " + localArrayList.size());
    return localArrayList;
  }
  
  public static JSONObject a(kte paramkte, VafContext paramVafContext, ktm paramktm, int paramInt, boolean paramBoolean)
    throws JSONException
  {
    JSONObject localJSONObject2 = new JSONObject();
    if (paramktm == null) {
      return localJSONObject2;
    }
    JSONObject localJSONObject1 = localJSONObject2;
    switch (paramInt)
    {
    default: 
      localJSONObject1 = localJSONObject2;
    }
    for (;;)
    {
      a(paramktm, localJSONObject1);
      return localJSONObject1;
      localJSONObject1 = b(paramVafContext, paramktm, paramBoolean);
      continue;
      localJSONObject1 = b(paramktm);
      continue;
      localJSONObject1 = a(paramktm);
      continue;
      localJSONObject1 = a(paramktm, paramkte);
      continue;
      localJSONObject1 = kmt.a(paramVafContext, paramktm, paramBoolean);
    }
  }
  
  private static JSONObject a(ktm paramktm)
    throws JSONException
  {
    if (paramktm == null) {}
    do
    {
      return null;
      paramktm = paramktm.a;
    } while (paramktm == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_banner");
    localJSONObject.put("operation_banner_icon", "rij_icon_notify");
    localJSONObject.put("operation_banner_title", paramktm.commentContent);
    QLog.d("CommentProteusUtil", 2, "comment banner data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(ktm paramktm, kte paramkte)
    throws JSONException
  {
    Object localObject = ktr.a(paramktm.articleInfo);
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    int i;
    long l1;
    if ((localObject != null) && (paramkte != null))
    {
      long l2 = ((ktr)localObject).r(paramkte.nI());
      i = j;
      l1 = l2;
      if (paramkte != null)
      {
        i = j;
        l1 = l2;
        if (paramkte.nI() == 6)
        {
          i = 0;
          l1 = l2;
        }
      }
    }
    for (;;)
    {
      if (paramktm.type == 2) {
        paramkte = "rij_new_comment_title_icon";
      }
      for (paramktm = "rij_comment_menu_new_icon";; paramktm = "rij_comment_menu_hot_icon")
      {
        if (l1 > 0L) {}
        for (localObject = "（" + l1 + "）";; localObject = "")
        {
          localJSONObject.put("style_ID", "ReadInJoy_comment_title");
          localJSONObject.put("comment_title", "");
          localJSONObject.put("comment_count", localObject);
          localJSONObject.put("comment_title_icon_url", paramkte);
          if (i != 0)
          {
            paramkte = new JSONObject();
            paramkte.put("commnet_menu_icon_url", paramktm);
            paramkte.put("rij_comment_type_choose_highlight", paramktm);
            localJSONObject.put("id_comment_type_choose_icon", paramkte);
          }
          QLog.d("CommentProteusUtil", 2, "getCommentTitleJsonNew | comment title json str : " + localJSONObject.toString());
          return localJSONObject;
        }
        paramkte = "rij_hot_comment_title_icon";
      }
      l1 = 0L;
      i = j;
    }
  }
  
  private static JSONObject a(ktm paramktm, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramktm == null) || (paramktm.a == null) || (paramJSONObject == null)) {}
    while (!(paramktm.a instanceof CommentData)) {
      return paramJSONObject;
    }
    List localList = paramktm.gy;
    if ((localList != null) && (localList.size() > 0))
    {
      int i = localList.size();
      if (localList.size() > 2) {
        i = 2;
      }
      int j = 0;
      if (j < i)
      {
        if (j == 0) {
          paramJSONObject.put("subcomment_one", paramktm);
        }
        for (;;)
        {
          j += 1;
          break;
          paramJSONObject.put("subcomment_two", paramktm);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "bindExposeSubCommentData : " + paramJSONObject.toString());
    return paramJSONObject;
  }
  
  public static void a(Container paramContainer, kte paramkte, ktm paramktm)
  {
    if ((paramContainer == null) || (paramktm == null) || (paramkte == null)) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new kqz(paramktm, paramkte, paramContainer));
  }
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, kte paramkte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramkte == null)) {
      return;
    }
    try
    {
      auvk.traceBegin("CommentProteusUtil.bindData");
      kvx.bindDynamicValueWithoutRecursion(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = a(paramkte, paramVafContext, (ktm)paramkte.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramTemplateBean.bindData(paramVafContext);
          a(paramContainer, paramkte, (ktm)paramkte.getItem(paramInt1));
        }
      }
      auvk.traceEnd();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("CommentProteusUtil", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  private static void a(kte paramkte, ktm paramktm)
  {
    if (paramkte == null) {
      return;
    }
    aqju localaqju = aqha.a(paramkte.a(), 230);
    paramkte = new krw(paramkte, paramktm);
    localaqju.setMessage(ksj.iG());
    localaqju.setNegativeButton("取消", paramkte);
    localaqju.setPositiveButton("确定", paramkte);
    localaqju.setOnCancelListener(null);
    localaqju.show();
  }
  
  private static void a(ktm paramktm, JSONObject paramJSONObject)
  {
    if ((paramktm == null) || (paramktm.a == null) || (paramJSONObject == null)) {
      return;
    }
    paramktm = paramktm.a.styleData;
    QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData : " + paramktm + " dataJson : " + paramJSONObject.toString());
    if (TextUtils.isEmpty(paramktm))
    {
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData is null");
      return;
    }
    try
    {
      paramktm = new JSONObject(paramktm);
      if (paramktm != null)
      {
        Iterator localIterator = paramktm.keys();
        while ((localIterator != null) && (localIterator.hasNext()))
        {
          String str = (String)localIterator.next();
          paramJSONObject.put(str, paramktm.get(str));
        }
      }
      return;
    }
    catch (JSONException paramktm)
    {
      paramktm.printStackTrace();
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | commentDataJson " + paramJSONObject.toString());
    }
  }
  
  private static JSONObject b(VafContext paramVafContext, ktm paramktm, boolean paramBoolean)
    throws JSONException
  {
    float f2 = 89.0F;
    BaseCommentData localBaseCommentData = paramktm.a;
    if ((localBaseCommentData == null) || (localBaseCommentData.commentContent == null) || (paramktm.p == null)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_cell");
    if (TextUtils.isEmpty(localBaseCommentData.avatar))
    {
      localJSONObject.put("avator_url", "default_comment_avatar");
      QLog.d("CommentProteusUtil", 2, "getCommentDataJson | isStar " + localBaseCommentData.isStar() + " isApproved " + localBaseCommentData.isApproved());
      if (localBaseCommentData.isStar()) {
        localJSONObject.put("rij_comment_avatar_borders", "rij_comment_avatar_borders");
      }
      if (localBaseCommentData.isApproved()) {
        localJSONObject.put("rij_comment_v", "rij_comment_v");
      }
      if ((!localBaseCommentData.isAuthorReply()) || (!TextUtils.isEmpty(localBaseCommentData.userTitle))) {
        localJSONObject.put("comment_describe", localBaseCommentData.userTitle);
      }
      String str = ksz.B(localBaseCommentData.nickName, 10);
      localObject = str;
      if (str == null) {
        localObject = acfp.m(2131710705);
      }
      localJSONObject.put("nickname", localObject);
      localJSONObject.put("commentModel", paramktm);
      if (((localBaseCommentData instanceof CommentData)) && (localBaseCommentData.isAwesome())) {
        localJSONObject.put("awsome_postmark_img", "awsome_postmark");
      }
      if ((paramktm.AA()) && (paramBoolean)) {
        localJSONObject.put("comment_model", paramktm);
      }
      long l2 = localBaseCommentData.commentTime;
      long l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis();
      }
      localJSONObject.put("time", kxl.c(l1, true));
      if (localBaseCommentData.medalInfo != null) {
        kxm.a(localJSONObject, localBaseCommentData.medalInfo);
      }
      if (!paramBoolean) {
        break label1005;
      }
    }
    label426:
    label964:
    label994:
    label1005:
    for (Object localObject = a(paramktm, localJSONObject);; localObject = localException) {
      for (;;)
      {
        if ((localBaseCommentData instanceof CommentData)) {
          if (paramBoolean) {
            if (((CommentData)localBaseCommentData).subCommentNum > 0)
            {
              ((JSONObject)localObject).put("id_comment_tail_3_dot", new JSONObject());
              ((JSONObject)localObject).put("reply_count_none", "");
              ((JSONObject)localObject).put("id_comment_tail_center_dot", new JSONObject());
              if (TextUtils.isEmpty(localBaseCommentData.flowGuidePtsData)) {}
            }
          }
        }
        try
        {
          localJSONObject = new JSONObject(localBaseCommentData.flowGuidePtsData);
          ((JSONObject)localObject).put("diversion_view_color", localJSONObject.optString("diversion_view_color"));
          ((JSONObject)localObject).put("diversion_app_icon", localJSONObject.optString("diversion_app_icon"));
          ((JSONObject)localObject).put("app_wording", localJSONObject.optString("app_wording"));
          ((JSONObject)localObject).put("diversion_font_color", localJSONObject.optString("diversion_font_color"));
          ((JSONObject)localObject).put("jump_schema", em(localJSONObject.optString("app_schema")));
          int i;
          float f1;
          if ((paramVafContext != null) && (paramVafContext.getContext() != null) && (paramVafContext.getContext().getResources() != null) && (localBaseCommentData.mediaDataList != null) && (localBaseCommentData.mediaDataList.size() > 0))
          {
            paramVafContext = (BaseCommentData.a)localBaseCommentData.mediaDataList.get(0);
            i = paramVafContext.medalType;
            QLog.d("CommentProteusUtil", 2, "mediaData type is " + i);
            f1 = paramVafContext.picWidth;
            f1 = paramVafContext.aLN;
            if (paramVafContext.picWidth >= paramVafContext.aLN) {
              break label964;
            }
            f1 = 113.0F;
            paramktm = a(paramktm);
            ((JSONObject)localObject).put("thumHeight", "" + f1);
            ((JSONObject)localObject).put("thumWidth", "" + f2);
            ((JSONObject)localObject).put("media_thumimg_url", paramVafContext.thumbUrl);
            if ((paramktm == null) || (paramktm.size() <= 0)) {
              break label994;
            }
          }
          for (paramVafContext = (String)paramktm.get(0);; paramVafContext = "")
          {
            ((JSONObject)localObject).put("pic_url", paramVafContext);
            switch (i)
            {
            }
            if (!TextUtils.isEmpty("")) {
              ((JSONObject)localObject).put("media_type_str", "");
            }
            QLog.d("CommentProteusUtil", 2, "comment data json str : " + ((JSONObject)localObject).toString());
            return localObject;
            localJSONObject.put("avator_url", localBaseCommentData.avatar);
            break;
            ((JSONObject)localObject).put("id_comment_tail_center_dot", new JSONObject());
            ((JSONObject)localObject).put("id_comment_tail_3_dot", new JSONObject());
            ((JSONObject)localObject).remove("reply_count");
            break label426;
            ((JSONObject)localObject).put("id_comment_tail_3_dot", new JSONObject());
            break label426;
            ((JSONObject)localObject).put("id_comment_tail_center_dot", new JSONObject());
            ((JSONObject)localObject).put("id_comment_tail_3_dot", new JSONObject());
            ((JSONObject)localObject).remove("reply_count");
            break label426;
            if (paramVafContext.picWidth > paramVafContext.aLN)
            {
              f1 = 89.0F;
              f2 = 113.0F;
              break label656;
            }
            f1 = 89.0F;
            break label656;
          }
        }
        catch (Exception localException)
        {
          break label539;
        }
      }
    }
  }
  
  private static JSONObject b(ktm paramktm)
    throws JSONException
  {
    if (paramktm == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return null;
      localBaseCommentData = paramktm.a;
    } while (localBaseCommentData == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_cell");
    localJSONObject.put("avator_url", localBaseCommentData.avatar);
    localJSONObject.put("nickname", localBaseCommentData.nickName);
    localJSONObject.put("commentModel", paramktm);
    localJSONObject.put("operation_img_url", localBaseCommentData.activityPicUrl);
    QLog.d("CommentProteusUtil", 2, "comment activity data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static String em(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString1;
    do
    {
      return paramString;
      arrayOfString1 = paramString.split("\\?");
    } while (arrayOfString1.length != 2);
    String[] arrayOfString2 = arrayOfString1[1].split("&");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < arrayOfString2.length)
    {
      String[] arrayOfString3 = arrayOfString2[i].split("=");
      if (arrayOfString3.length == 2) {
        if (i == arrayOfString2.length - 1) {
          break label162;
        }
      }
      label162:
      for (paramString = "&";; paramString = "")
      {
        if ("appSchema".equalsIgnoreCase(arrayOfString3[0])) {
          arrayOfString2[i] = (arrayOfString3[0] + "=" + en(arrayOfString3[1]));
        }
        localStringBuilder.append(arrayOfString2[i] + paramString);
        i += 1;
        break;
      }
    }
    paramString = arrayOfString1[0] + "?" + localStringBuilder.toString();
    QLog.d("CommentProteusUtil", 2, "checkJumpAppSchema | jumpSchema : " + paramString);
    return paramString;
  }
  
  private static String en(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "utf-8");
      StringBuilder localStringBuilder = new StringBuilder(str);
      if (!str.contains("title")) {
        localStringBuilder.append("&title=");
      }
      if (!str.contains("videoId")) {
        localStringBuilder.append("&videoId=");
      }
      if (!str.contains("coverPath")) {
        localStringBuilder.append("&coverPath=");
      }
      if (!str.contains("width")) {
        localStringBuilder.append("&width=");
      }
      if (!str.contains("height")) {
        localStringBuilder.append("&height=");
      }
      str = URLEncoder.encode(localStringBuilder.toString(), "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqy
 * JD-Core Version:    0.7.0.1
 */