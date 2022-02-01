import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ncb
{
  private static SparseArray<ncb.a> mCallbackMap = new SparseArray();
  
  private static Map<String, String> a(myi parammyi)
  {
    HashMap localHashMap = new HashMap();
    if (parammyi != null)
    {
      localHashMap.put("param_url", parammyi.kz());
      localHashMap.put("param_bitrate", String.valueOf(parammyi.vF));
      localHashMap.put("param_duration", String.valueOf(parammyi.getDuration()));
      localHashMap.put("param_file", String.valueOf(parammyi.getFileSize()));
      localHashMap.put("param_is265", String.valueOf(parammyi.aVZ));
    }
    return localHashMap;
  }
  
  public static void a(Activity paramActivity, BaseArticleInfo paramBaseArticleInfo, myi parammyi, int paramInt1, int paramInt2)
  {
    paramBaseArticleInfo = new ncc(paramBaseArticleInfo, paramInt1, paramInt2, a(parammyi));
    paramInt1 = paramBaseArticleInfo.hashCode();
    a(paramBaseArticleInfo);
    i(paramActivity, paramInt1);
  }
  
  public static void a(ncb.a parama)
  {
    mCallbackMap.put(parama.hashCode(), parama);
  }
  
  private static void a(ncb.a parama, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlayFeedbackHelper", 2, "feedbackCallback jsonObject:" + paramJSONObject);
    }
    Object localObject = paramJSONObject.optJSONArray("feedback_type_list");
    String str = "";
    if (localObject != null) {
      str = ((JSONArray)localObject).toString();
    }
    localObject = paramJSONObject.optString("feedback_text");
    HashMap localHashMap = parama.et;
    localHashMap.put("param_video_scene", String.valueOf(parama.aXk));
    localHashMap.put("param_feedback_entry", String.valueOf(parama.aXl));
    localHashMap.put("param_feedback_type_list", str);
    localHashMap.put("param_feedbackText", localObject);
    localHashMap.put("param_busiType", String.valueOf(parama.d.busiType));
    localHashMap.put("param_rowkey", String.valueOf(parama.d.getInnerUniqueID()));
    localHashMap.put("param_title", parama.d.mTitle);
    localHashMap.put("param_vid", parama.d.getVideoVid());
    localHashMap.put("param_uin", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin());
    localHashMap.put("param_platform", String.valueOf(1));
    localHashMap.put("param_sdk_version", SuperPlayerSDKMgr.getSDKVersion());
    localHashMap.put("param_version", "3.4.4.3058");
    localHashMap.put("param_subversion", "3.4.4");
    m(localHashMap);
    if (paramJSONObject.optInt("close_type") > 0)
    {
      t(parama.d.getInnerUniqueID(), parama.aXk, parama.aXl);
      return;
    }
    u(parama.d.getInnerUniqueID(), parama.aXk, parama.aXl);
  }
  
  public static void aP(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
      kbp.a(null, "", "0X800AA74", "0X800AA74", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  public static void aQ(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
      kbp.a(null, "", "0X800AA76", "0X800AA76", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  public static void ad(JSONObject paramJSONObject)
  {
    try
    {
      int i = new JSONObject(paramJSONObject.optString("extral")).optInt("callAddress", -1);
      ncb.a locala = (ncb.a)mCallbackMap.get(i);
      if (locala != null) {
        locala.ae(paramJSONObject);
      }
      tk(i);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static void i(Activity paramActivity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("callAddress", paramInt);
      localBundle.putString("param", localJSONObject.toString());
      ntp.a(paramActivity, null, "https://viola.qq.com/js/RIJVideoFeedback.js?_rij_violaUrl=1&v_tid=15&v_bundleName=RIJVideoFeedback&_rij_violaUrl=1&v_present=2&hideNav=1&v_bid=3811&v_nav_immer=1&statusColor=1&v_present_bar=0&v_present_radius=6&v_present_top=" + (riw.px2dip(BaseApplicationImpl.context, riw.getWindowScreenHeight(BaseApplicationImpl.context)) - 385), localBundle, true);
      return;
    }
    catch (JSONException paramActivity)
    {
      QLog.e("PlayFeedbackHelper", 2, "PlayFeedbackHelper start failed", paramActivity);
    }
  }
  
  private static void m(HashMap<String, String> paramHashMap)
  {
    ThreadManager.post(new PlayFeedbackHelper.2(paramHashMap), 5, null, true);
  }
  
  public static void s(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      kbp.a(null, "", "0X800AA75", "0X800AA75", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  public static void t(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      kbp.a(null, "", "0X800AA77", "0X800AA77", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  public static void tk(int paramInt)
  {
    mCallbackMap.remove(paramInt);
  }
  
  public static void u(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      kbp.a(null, "", "0X800AA78", "0X800AA78", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  public static abstract class a
  {
    public int aXk;
    public int aXl;
    public BaseArticleInfo d;
    public HashMap<String, String> et = new HashMap();
    
    public a(BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2, Map<String, String> paramMap)
    {
      this.d = paramBaseArticleInfo;
      this.aXk = paramInt1;
      this.aXl = paramInt2;
      this.et.putAll(paramMap);
    }
    
    public abstract void ae(JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ncb
 * JD-Core Version:    0.7.0.1
 */