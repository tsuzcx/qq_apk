import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class nap
{
  public static final String TAG = nap.class.getSimpleName();
  
  private static JSONObject K()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("uint32_youngster_status", awit.f("key_sp_is_readinjoy_youngster", Integer.valueOf(0)));
    localJSONObject.put("uint32_req_recommend_flag", kcr.getRecommendFlag());
    return localJSONObject;
  }
  
  public static int a(Activity paramActivity, VideoInfo paramVideoInfo)
  {
    int i = muj.c(paramActivity)[0];
    int j = (int)(paramVideoInfo.getHeight() / paramVideoInfo.getWidth() * i);
    if (j > i) {
      return i;
    }
    return j;
  }
  
  public static Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = a(paramIntent);
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("stickySpeed", kzc.ob());
      localJSONObject3.put("maskLighteness", kzc.ag());
      localJSONObject3.put("topBarTitle", kzc.jb());
      localJSONObject3.put("autoPlayForLockScreen", Aladdin.getConfig(271).getIntegerFromString("auto_play", 1));
      JSONObject localJSONObject4 = new JSONObject();
      localJSONObject4.put("from", paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1));
      localJSONObject4.put("kandian_mode_new", kct.nd());
      localJSONObject4.put("kandian_mode", kxm.nR());
      localJSONObject4.put("source", paramIntent.getIntExtra("key_source", -1));
      localJSONObject4.put("senceType", paramIntent.getIntExtra("RETURN_SCENE", 0));
      paramIntent = K();
      localJSONObject1.put("configModel", localJSONObject2);
      localJSONObject1.put("aladingConfig", localJSONObject3);
      localJSONObject1.put("reportConfig", localJSONObject4);
      localJSONObject1.put("dynamicAladdinConfig", kzl.B());
      localJSONObject1.put("xgAladdinConfig", kzl.A());
      localJSONObject1.put("protocolExtralParam", paramIntent);
      localJSONObject1.put("autoPlayDisable", awit.Ql());
      localBundle.putString("param", localJSONObject1.toString());
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "generateParamsForViola: " + localJSONObject1.toString());
      }
      return localBundle;
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "generateParamsForViola: json error ", paramIntent);
        }
      }
    }
  }
  
  private static String a(Intent paramIntent, VideoInfo paramVideoInfo)
  {
    String str = paramIntent.getStringExtra("VIDEO_COVER");
    int i = paramIntent.getIntExtra("item_width", 0);
    int j = paramIntent.getIntExtra("item_height", 0);
    if ((!TextUtils.isEmpty(str)) && (i != 0) && (j != 0)) {
      return e(str, i, j);
    }
    paramIntent = paramVideoInfo.d();
    if (paramIntent != null) {
      return paramIntent.toString();
    }
    return null;
  }
  
  private static JSONObject a(Intent paramIntent)
    throws JSONException
  {
    VideoInfo localVideoInfo = b(paramIntent.getExtras());
    boolean bool = paramIntent.getBooleanExtra("VIDEO_SHOW_COMMENT", false);
    int k = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
    int i;
    Object localObject2;
    Object localObject1;
    label122:
    JSONObject localJSONObject1;
    int j;
    if (k == 11)
    {
      i = 1;
      int m = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      int n = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      int i1 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", -1);
      localObject2 = paramIntent.getStringExtra("ARGS_SESSION_ID");
      String str = paramIntent.getStringExtra("ARGS_VIDEO_CHANNEL_SESSION_ID");
      long l = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", 0L);
      localObject1 = paramIntent.getStringExtra("VIDEO_H5_URL");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label655;
      }
      localObject1 = Uri.parse((String)localObject1).getQueryParameter("redpackid");
      localJSONObject1 = new JSONObject();
      if (!bool) {
        break label663;
      }
      j = 1;
      label138:
      JSONObject localJSONObject2 = localJSONObject1.put("autoShowComment", j);
      if (i == 0) {
        break label668;
      }
      i = 1;
      label155:
      localObject2 = localJSONObject2.put("circleEntrance", i).put("entranceChannel", m).put("feedsType", n).put("reportSource", i1).put("sessionID", localObject2).put("sourceType", k).put("videoFromType", k).put("videoSessionID", str);
      if (k < 100) {
        break label673;
      }
      i = k;
      label228:
      ((JSONObject)localObject2).put("webVideoFromType", i).put("startPlayTime", l / 1000L).put("redPackedId", localObject1);
      label390:
      label420:
      if (localVideoInfo != null)
      {
        localJSONObject1.put("videoType", kzc.h(localVideoInfo.width, localVideoInfo.height, localVideoInfo.duration));
        if ((TextUtils.isEmpty(localVideoInfo.vid)) || (localVideoInfo.getHeight() == 0) || (localVideoInfo.getWidth() == 0)) {
          break label678;
        }
        i = 1;
        label319:
        if (i != 0)
        {
          localObject1 = new JSONObject();
          paramIntent = ((JSONObject)localObject1).put("article_title", localVideoInfo.title).put("busiType", localVideoInfo.busiType).put("first_page_url", a(paramIntent, localVideoInfo)).put("innerUniqueID", localVideoInfo.Wz);
          if (!localVideoInfo.adB) {
            break label683;
          }
          i = 1;
          paramIntent = paramIntent.put("is_ugc", i).put("like_count", localVideoInfo.likeCount);
          if (!localVideoInfo.adM) {
            break label688;
          }
          i = 1;
          localObject2 = paramIntent.put("myself_like_status", i).put("thirdIcon", localVideoInfo.WC).put("thirdName", localVideoInfo.thirdUinName).put("third_uin", localVideoInfo.hH).put("third_uin_name", localVideoInfo.accountName);
          if (localVideoInfo.a == null) {
            break label693;
          }
        }
      }
    }
    label655:
    label663:
    label668:
    label673:
    label678:
    label683:
    label688:
    label693:
    for (paramIntent = Integer.valueOf(localVideoInfo.a.aHc);; paramIntent = null)
    {
      ((JSONObject)localObject2).put("topic_id", paramIntent).put("videoInfo_duration", localVideoInfo.getDuration()).put("videoInfo_fileSize", localVideoInfo.ry).put("videoInfo_height", localVideoInfo.getHeight()).put("videoInfo_vid", localVideoInfo.vid).put("videoInfo_width", localVideoInfo.getWidth()).put("video_comment_count", localVideoInfo.commentCount).put("video_json", localVideoInfo.WB).put("video_logo_url", localVideoInfo.WE).put("video_play_count", localVideoInfo.playCount).put("algorithm_id", localVideoInfo.algorithmID).put("strategy_id", localVideoInfo.strategyID).put("video_report_info", localVideoInfo.videoReportInfo);
      localJSONObject1.put("videoArticleModel", localObject1);
      return localJSONObject1;
      i = 0;
      break;
      localObject1 = "";
      break label122;
      j = 0;
      break label138;
      i = 0;
      break label155;
      i = 0;
      break label228;
      i = 0;
      break label319;
      i = 0;
      break label390;
      i = 0;
      break label420;
    }
  }
  
  public static void a(Activity paramActivity, View paramView)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (ayxa.isLiuHaiUseValid()) {
        paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop() + ayxa.getNotchInScreenHeight(paramActivity), paramView.getPaddingRight(), paramView.getPaddingBottom());
      }
    }
    else {
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop() + ImmersiveUtils.getStatusBarHeight(paramActivity), paramView.getPaddingRight(), paramView.getPaddingBottom());
  }
  
  public static void a(RecyclerView paramRecyclerView, nap.a<RecyclerView.ViewHolder> parama)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramRecyclerView.getChildAt(i);
      if (localObject != null)
      {
        localObject = paramRecyclerView.getChildViewHolder((View)localObject);
        if (localObject != null) {
          parama.run(localObject);
        }
      }
      i += 1;
    }
  }
  
  public static int[] a(Activity paramActivity, VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    int n = muj.c(paramActivity)[0];
    int k;
    if (!paramBoolean)
    {
      int m = wja.dp2px(10.0F, paramActivity.getResources());
      k = wja.dp2px(10.0F, paramActivity.getResources());
      i = m;
      j = k;
      if (paramVideoInfo.getWidth() < paramVideoInfo.getHeight())
      {
        i = m + (n - (int)(paramVideoInfo.getWidth() / paramVideoInfo.getHeight() * n)) / 2;
        j = k;
      }
      return new int[] { j, i };
    }
    if (paramVideoInfo.getWidth() > paramVideoInfo.getHeight())
    {
      i = muj.c(paramActivity)[1];
      j = muj.c(paramActivity)[0];
      f = paramVideoInfo.getWidth() / paramVideoInfo.getHeight();
      j = (int)(j * f);
      if (j <= i) {}
      for (i = (i - j) / 2 + wja.dp2px(16.0F, paramActivity.getResources());; i = wja.dp2px(16.0F, paramActivity.getResources()))
      {
        j = wja.dp2px(16.0F, paramActivity.getResources());
        break;
      }
    }
    int j = muj.c(paramActivity)[0];
    int i = muj.c(paramActivity)[1];
    float f = paramVideoInfo.getHeight() / paramVideoInfo.getWidth();
    j = (int)(j * f);
    if (j < i) {}
    for (i = (i - j) / 2 + wja.dp2px(32.0F, paramActivity.getResources());; i = wja.dp2px(32.0F, paramActivity.getResources()))
    {
      k = wja.dp2px(10.0F, paramActivity.getResources());
      j = i;
      i = k;
      break;
    }
  }
  
  public static VideoInfo b(Bundle paramBundle)
  {
    VideoInfo localVideoInfo;
    if (paramBundle.getParcelable("VIDEO_OBJ") != null)
    {
      localVideoInfo = (VideoInfo)paramBundle.getParcelable("VIDEO_OBJ");
      muj.x(localVideoInfo);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "generateRequestVideoInfo: 外部传进来的VideoInfo=" + localVideoInfo.toLogString());
      }
      paramBundle.putString("VIDEO_ARTICLE_ID", localVideoInfo.Wz);
      paramBundle = localVideoInfo;
    }
    do
    {
      return paramBundle;
      localVideoInfo = muj.a(paramBundle);
      muj.x(localVideoInfo);
      paramBundle = localVideoInfo;
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "innerGenerateRequestVideoInfo: 外部传进来的VideoInfo=" + localVideoInfo.toLogString());
    return localVideoInfo;
  }
  
  public static void b(Activity paramActivity, View paramView)
  {
    paramView.setPadding(paramView.getPaddingLeft() + ayxa.getNotchInScreenHeight(paramActivity), paramView.getPaddingTop(), paramView.getPaddingRight() + ayxa.getNotchInScreenHeight(paramActivity), paramView.getPaddingBottom());
  }
  
  public static String bu(int paramInt)
  {
    if (paramInt > 0) {
      return muj.bw(paramInt) + "播放";
    }
    return "";
  }
  
  private static String e(String paramString, int paramInt1, int paramInt2)
  {
    String str = "?";
    if (!paramString.contains("?")) {}
    for (;;)
    {
      return paramString + str + "item_width" + "=" + paramInt1 + "&" + "item_height" + "=" + paramInt2;
      str = "&";
    }
  }
  
  public static void t(Activity paramActivity, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramActivity == null)) {
      return;
    }
    kxm.aJ(paramActivity, kwt.acJ + aqgo.encodeToString(String.valueOf(paramString).getBytes(), 2));
  }
  
  public static abstract interface a<V>
  {
    public abstract void run(V paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nap
 * JD-Core Version:    0.7.0.1
 */