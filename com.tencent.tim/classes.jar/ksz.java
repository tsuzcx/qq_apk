import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.1;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.a;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ksz
{
  public static String B(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!TextUtils.isEmpty(paramString)) && (paramString.length() <= paramInt))) {
      return paramString;
    }
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.substring(0, paramInt) + "...";
    }
    return "";
  }
  
  public static boolean E(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramContext == null)) {
      return false;
    }
    paramContext = (ClipboardManager)paramContext.getSystemService("clipboard");
    alkw.a(paramContext);
    if (paramContext.hasPrimaryClip())
    {
      alkw.a(paramContext);
      ClipData localClipData = paramContext.getPrimaryClip();
      if ((localClipData != null) && (localClipData.getItemCount() > 0))
      {
        alkw.a(paramContext);
        paramContext = paramContext.getPrimaryClip().getItemAt(0);
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.getText())))
        {
          paramContext = String.valueOf(paramContext.getText());
          paramString = new aofk(anbk.nn(paramString), 7, 18).toString();
          if (!TextUtils.isEmpty(paramContext)) {
            return paramContext.contains(paramString);
          }
        }
      }
    }
    return false;
  }
  
  public static String a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return "";
    }
    if (((ndi.ak(paramArticleInfo)) || (ndi.S(paramArticleInfo))) && (paramArticleInfo.mSocialFeedInfo != null)) {
      return String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
    }
    return paramArticleInfo.mSubscribeID;
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, BaseCommentData paramBaseCommentData, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, ksz.a parama, int paramInt2)
  {
    a(paramActivity, paramArticleInfo, paramBaseCommentData, paramInt1, paramString1, paramString2, paramBoolean, parama, paramInt2, true);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, BaseCommentData paramBaseCommentData, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, ksz.a parama, int paramInt2, boolean paramBoolean2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("arg_comment_enable_anonymous", false);
    localIntent.putExtra("arg_comment_placeholder", paramString1);
    localIntent.putExtra("arg_comment_default_txt", paramString2);
    localIntent.putExtra("arg_comment_max_length", -1);
    localIntent.putExtra("arg_comment_open_at", false);
    localIntent.putExtra("arg_comment_gif_switch", false);
    localIntent.putExtra("arg_comment_zhitu_switch", false);
    localIntent.putExtra("arg_comment_transparent_bg", paramBoolean1);
    localIntent.putExtra("comment_native", true);
    localIntent.putExtra("comment_reply_second", paramBaseCommentData instanceof SubCommentData);
    localIntent.putExtra("click_comment_edit_src", paramInt2);
    localIntent.putExtra("comment_articleid", paramArticleInfo);
    localIntent.putExtra("biu_src", paramInt1);
    QLog.d("ReadInJoyCommentUtils", 2, "openCommentComponent | comment_placeholder after decode: " + paramString1);
    if (paramBaseCommentData != null)
    {
      localIntent.putExtra("comment_id", paramBaseCommentData.commentId);
      localIntent.putExtra("first_comment_uin", paramBaseCommentData.uin);
      paramString1 = paramBaseCommentData.commentContent;
      paramString2 = paramBaseCommentData.uin;
      localIntent.putExtra("comment_val", paramString1);
      localIntent.putExtra("comment_author_uin", paramString2);
      if ((paramBaseCommentData != null) && (paramBaseCommentData.mediaDataList != null) && (paramBaseCommentData.mediaDataList.size() > 0) && (((BaseCommentData.a)paramBaseCommentData.mediaDataList.get(0)).medalType != 0)) {
        localIntent.putExtra("comment_can_biu", false);
      }
    }
    if (paramArticleInfo != null) {
      localIntent.putExtra("feedsType", paramArticleInfo.mFeedType);
    }
    if ((paramBaseCommentData instanceof SubCommentData)) {
      localIntent.putExtra("comment_reply_second_uin", paramBaseCommentData.uin);
    }
    if (paramInt1 == 2) {
      localIntent.putExtra("comment_is_show_pic", kyq.Bi());
    }
    localIntent.putExtra("arg_ad_show_biu", paramBoolean2);
    PublicFragmentActivity.b.startForResult(paramActivity, localIntent, PublicTransFragmentActivity.class, ReadInJoyCommentComponentFragment.class, 117);
    if (parama != null) {
      parama.aGM();
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, CommentInfo paramCommentInfo, boolean paramBoolean)
  {
    if ((paramArticleInfo == null) || (paramCommentInfo == null)) {
      QLog.d("ReadInJoyCommentUtils", 2, "localUpdateCommentData: articleInfo or commentInfo is null");
    }
    do
    {
      return;
      long l = paramArticleInfo.mRecommendSeq;
      paramArticleInfo = lbz.a().a((int)paramArticleInfo.mChannelID, l);
    } while (paramArticleInfo == null);
    if (!paramBoolean)
    {
      paramCommentInfo = paramArticleInfo.mSocialFeedInfo;
      paramCommentInfo.mCommentCount += 1;
    }
    paramArticleInfo.invalidateProteusTemplateBean();
    ThreadManager.getUIHandler().post(new ReadInJoyCommentUtils.1());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt)
  {
    if (paramIntent == null) {
      QLog.d("ReadInJoyCommentUtils", 2, "comment result intent data is null");
    }
    ArticleInfo localArticleInfo;
    boolean bool;
    do
    {
      return;
      paramQQAppInterface = paramIntent.getStringExtra("arg_result_json");
      localArticleInfo = (ArticleInfo)paramIntent.getParcelableExtra("comment_articleid");
      bool = paramIntent.getBooleanExtra("comment_gallery_channel", false);
    } while ((paramInt != -1) && (paramInt != 1699));
    if ((localArticleInfo != null) && (bool))
    {
      ktr.a(localArticleInfo, 0).my(paramQQAppInterface);
      ktr.c(localArticleInfo);
      return;
    }
    lbz.a().a(localArticleInfo, paramQQAppInterface);
  }
  
  public static void a(String paramString, ArticleInfo paramArticleInfo, kxm.b paramb)
  {
    kbp.a(null, a(paramArticleInfo), paramString, paramString, 0, 0, String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), paramArticleInfo.innerUniqueID, paramb.build(), false);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, String paramString)
  {
    if (paramArticleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentUtils", 2, " marticleinfo=null");
      }
      return false;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = new SocializeFeedsInfo();
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c = new SocializeFeedsInfo.c();
    ArrayList localArrayList = new ArrayList();
    int j;
    int k;
    int i;
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("biu_info");
      j = paramString.optInt("biuSrc");
      k = paramString.optInt("feedtype");
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c != null))
      {
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z;
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.y = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.y;
      }
      paramString = paramString.optJSONArray("biuinfo");
      i = 0;
      if (i < paramString.length())
      {
        paramString.getJSONObject(i);
        localObject = paramString.getJSONObject(i).optString("biu_uin");
        if ((paramString.getJSONObject(i).opt("biu_feedid") instanceof Integer)) {}
        for (long l = ((Integer)paramString.getJSONObject(i).opt("biu_feedid")).intValue();; l = ((Long)paramString.getJSONObject(i).opt("biu_feedid")).longValue())
        {
          localObject = new ksz.h((String)localObject, l, paramString.getJSONObject(i).optString("biu_info_comment"));
          ((ksz.h)localObject).opType = paramString.getJSONObject(i).optInt("biu_optype");
          ((ksz.h)localObject).n = paramString.getJSONObject(i).optString("biu_nickname");
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      if (!QLog.isColorLevel()) {
        break label377;
      }
    }
    catch (Exception paramArticleInfo)
    {
      return false;
    }
    paramString = new StringBuilder("onDeliver deliverList:\n");
    Object localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.append(((ksz.h)((Iterator)localObject).next()).toString()).append("\n");
    }
    QLog.d("ReadInJoyCommentUtils", 2, paramString.toString());
    label377:
    if ((paramArticleInfo != null) && (localArrayList.size() > 0))
    {
      i = 1;
      for (;;)
      {
        if (i < localArrayList.size())
        {
          localObject = (ksz.h)localArrayList.get(i);
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
          try
          {
            localBiuCommentInfo.i = Long.valueOf(((ksz.h)localObject).uin);
            if (((ksz.h)localObject).o == null)
            {
              paramString = "";
              localBiuCommentInfo.ahj = paramString;
              localBiuCommentInfo.aSO = ((ksz.h)localObject).opType;
              localBiuCommentInfo.x = Long.valueOf(((ksz.h)localObject).sI);
              localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.add(localBiuCommentInfo);
              i += 1;
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              localBiuCommentInfo.i = Long.valueOf(0L);
              continue;
              paramString = ((ksz.h)localObject).o.toString();
            }
          }
        }
      }
      lbz.a().a(kxm.getLongAccountUin(), paramArticleInfo.mFeedId, localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c, 0L, ((ksz.h)localArrayList.get(0)).o.toString(), paramArticleInfo.mArticleID, paramArticleInfo.mRecommendSeq, j, paramArticleInfo.innerUniqueID, k, paramArticleInfo);
    }
    return true;
  }
  
  public static void f(String paramString, Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramString = kwt.acF + aqgo.encodeToString(paramString.getBytes(), 2);
      kxm.aJ(paramContext, paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyCommentUtils", 2, "personal url =" + paramString);
  }
  
  public static void g(String paramString, Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramString.startsWith("http")) && (!paramString.startsWith("https")));
      kxm.aJ(paramContext, paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyCommentUtils", 2, "personal url =" + paramString);
  }
  
  public static abstract interface a
  {
    public abstract void aGM();
  }
  
  public static abstract interface b
  {
    public abstract void g(boolean paramBoolean, String paramString1, String paramString2);
    
    public abstract void pC(int paramInt);
  }
  
  public static class c
  {
    private JSONObject al = new JSONObject();
    private ArticleInfo articleInfo;
    private CommentInfo d;
    
    public c(ArticleInfo paramArticleInfo, CommentInfo paramCommentInfo)
    {
      this.articleInfo = paramArticleInfo;
      this.d = paramCommentInfo;
    }
    
    private c a(int paramInt)
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
    
    public c a()
    {
      int i = 1;
      try
      {
        if (this.d != null)
        {
          if (this.d.author_selection == 1) {}
          while (i > 0)
          {
            this.al.put("comment_type", i);
            return this;
            i = this.d.awesome;
            if (i == 1) {
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
    
    public c a(String paramString)
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
    
    public c b(int paramInt)
    {
      try
      {
        this.al.put("entry", paramInt);
        return a(paramInt);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
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
            this.al.put("mp_article_id", this.articleInfo.mArticleID);
          }
          if (this.d != null)
          {
            if (this.d.level != 1) {
              continue;
            }
            this.al.put("comment_id", this.d.commentId);
          }
          this.al.put("source", kxm.nQ());
          this.al.put("kandian_mode", kxm.nR());
          this.al.put("comment_platform", 3);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          continue;
        }
        return this.al.toString();
        if (this.d.level == 2) {
          this.al.put("sub_comment_id", this.d.commentId);
        }
      }
    }
    
    public c c(int paramInt)
    {
      try
      {
        this.al.put("area", paramInt);
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return this;
    }
    
    public c d(int paramInt)
    {
      try
      {
        this.al.put("comment_level", paramInt);
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return this;
    }
    
    public c e(int paramInt)
    {
      try
      {
        this.al.put("comment_icon_choose", paramInt);
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return this;
    }
  }
  
  public static abstract interface d
    extends View.OnClickListener, ksz.a
  {
    public abstract void mI(boolean paramBoolean);
    
    public abstract void onClick(View paramView);
    
    public abstract void pM(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void cl(View paramView);
  }
  
  public static abstract class f {}
  
  public static abstract interface g
    extends View.OnClickListener, ksz.a
  {}
  
  public static class h
  {
    public CharSequence n;
    public CharSequence o;
    public int opType;
    public long sI;
    public String uin;
    
    public h(String paramString, long paramLong, CharSequence paramCharSequence)
    {
      this(paramString, paramLong, paramCharSequence, 0);
    }
    
    public h(String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
    {
      this.uin = paramString;
      this.sI = paramLong;
      paramString = paramCharSequence;
      if (paramCharSequence == null) {
        paramString = "";
      }
      this.o = paramString;
      this.opType = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksz
 * JD-Core Version:    0.7.0.1
 */