import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.EPRecommendTask.1;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class afkb
{
  public WeakReference<QQAppInterface> K;
  public String bDH;
  public String bDI;
  public VasQuickUpdateManager.CallBacker g = new afkc(this);
  Runnable runnable = new EPRecommendTask.1(this);
  
  public afkb(QQAppInterface paramQQAppInterface)
  {
    this.K = new WeakReference(paramQQAppInterface);
  }
  
  public static aiya a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = null;
    try
    {
      Object localObject = paramJSONObject.optJSONArray("emojiAioConfig");
      if (localObject != null)
      {
        if (((JSONArray)localObject).length() == 0) {
          return null;
        }
        paramJSONObject = new aiya();
      }
      label116:
      return null;
    }
    catch (Exception localException1)
    {
      try
      {
        localObject = (JSONObject)((JSONArray)localObject).get(0);
        paramJSONObject.hide = ((JSONObject)localObject).optInt("hide");
        paramJSONObject.version = ((JSONObject)localObject).optInt("version");
        paramJSONObject.jumpUrl = ((JSONObject)localObject).optString("url");
        localJSONObject = ((JSONObject)localObject).optJSONObject("gifUrl");
        if (localJSONObject != null) {
          paramJSONObject.Gx = localJSONObject.optString("src");
        }
        localObject = ((JSONObject)localObject).optJSONObject("imgUrl");
        if (localObject != null) {
          paramJSONObject.imgUrl = ((JSONObject)localObject).optString("src");
        }
        return paramJSONObject;
      }
      catch (Exception localException2)
      {
        break label116;
      }
      localException1 = localException1;
      paramJSONObject = localJSONObject;
      localException1.printStackTrace();
      return paramJSONObject;
    }
  }
  
  public void PD()
  {
    ThreadManager.post(this.runnable, 5, null, true);
  }
  
  public afkb a(String paramString1, String paramString2)
  {
    this.bDI = paramString2;
    this.bDH = paramString1;
    return this;
  }
  
  public void bd(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramJSONObject = a(paramJSONObject);
          if (paramJSONObject != null)
          {
            localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 0);
            localSharedPreferences.edit().putInt("magic_promotion_hide", paramJSONObject.hide).commit();
            if (QLog.isColorLevel()) {
              QLog.d("EPRecommendTask", 2, "promotionInfo:[hide]:" + paramJSONObject.hide + ",[ver]:" + paramJSONObject.version);
            }
            if (1 != paramJSONObject.hide) {
              if ((TextUtils.isEmpty(paramJSONObject.imgUrl)) || (TextUtils.isEmpty(paramJSONObject.Gx)) || (TextUtils.isEmpty(paramJSONObject.jumpUrl)))
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("EPRecommendTask", 2, "promotionInfo: imgUrl = " + paramJSONObject.imgUrl + " gifUrl = " + paramJSONObject.Gx + " jumpUrl = " + paramJSONObject.jumpUrl);
              }
            }
          }
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          return;
        }
      }
      localSharedPreferences.edit().putString("magic_promotion_jump_url", paramJSONObject.jumpUrl).commit();
      localSharedPreferences.edit().putString("magic_promotion_imgUrl", "https://gxh.vip.qq.com/xydata/" + paramJSONObject.imgUrl).commit();
      localSharedPreferences.edit().putString("magic_promotion_gifUrl", "https://gxh.vip.qq.com/xydata/" + paramJSONObject.Gx).commit();
    } while (localSharedPreferences.getInt("magic_promotion_old_ver_" + afem.getCurrentUin(), -1) >= paramJSONObject.version);
    localSharedPreferences.edit().putBoolean("magic_promotion_is_new_content_" + afem.getCurrentUin(), true).commit();
    localSharedPreferences.edit().putInt("magic_promotion_old_ver_" + afem.getCurrentUin(), paramJSONObject.version).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkb
 * JD-Core Version:    0.7.0.1
 */