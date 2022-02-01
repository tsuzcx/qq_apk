import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMBeautyItem;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ayzr
{
  public static String TAG = "QIMBeautyManager";
  private static ayzr a;
  private List<QIMBeautyItem> NG = new CopyOnWriteArrayList();
  
  private ayzr()
  {
    anq();
  }
  
  public static ayzr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ayzr();
      }
      return a;
    }
    finally {}
  }
  
  private String zD()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_beauty_config", 0).getString("short_video_beauty_content", "");
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "take  config content= " + str);
    }
    return str;
  }
  
  public void anq()
  {
    this.NG.clear();
    try
    {
      Object localObject = zD();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("category"))
      {
        localObject = ((JSONObject)localObject).getJSONArray("category");
        if (localObject != null)
        {
          int k = ((JSONArray)localObject).length();
          if (k > 0)
          {
            int i = 0;
            while (i < k)
            {
              JSONObject localJSONObject1 = ((JSONArray)localObject).getJSONObject(i);
              if (localJSONObject1.has("content"))
              {
                JSONArray localJSONArray = localJSONObject1.getJSONArray("content");
                if (localJSONArray == null) {
                  break;
                }
                int m = localJSONArray.length();
                if (m <= 0) {
                  break;
                }
                int j = 0;
                while (j < m)
                {
                  QIMBeautyItem localQIMBeautyItem = new QIMBeautyItem();
                  JSONObject localJSONObject2 = localJSONArray.getJSONObject(j);
                  if (localJSONObject2.has("iconUrl")) {
                    localQIMBeautyItem.iconUrl = localJSONObject2.getString("iconUrl");
                  }
                  if (localJSONObject2.has("id")) {
                    localQIMBeautyItem.id = localJSONObject2.getString("id");
                  }
                  if (localJSONObject2.has("name")) {
                    localQIMBeautyItem.name = localJSONObject2.getString("name");
                  }
                  if (localJSONObject2.has("jump_app")) {
                    localQIMBeautyItem.aBF = localJSONObject2.getString("jump_app");
                  }
                  this.NG.add(localQIMBeautyItem);
                  j += 1;
                }
              }
              if (localJSONObject1.has("downloadInfo"))
              {
                rpw.aBz = localJSONObject1.getString("downloadInfo");
                if (QLog.isColorLevel()) {
                  QLog.e(TAG, 2, "QIMBeautyManager WeishiGuideUtils.DOWNLOAD_JSON=  " + rpw.aBz);
                }
              }
              i += 1;
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "parse sv config error, stacktrace :  " + QLog.getStackTraceString(localException));
      }
    }
  }
  
  public int bK(Context paramContext)
  {
    return paramContext.getSharedPreferences("short_video_beauty_config", 0).getInt("short_video_beauty_version", 0);
  }
  
  public boolean c(String paramString, int paramInt, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "savebeautyConfig :  " + paramString);
    }
    paramContext = paramContext.getSharedPreferences("short_video_beauty_config", 0).edit();
    paramContext.putString("short_video_beauty_content", paramString);
    paramContext.putInt("short_video_beauty_version", paramInt);
    paramContext.commit();
    return true;
  }
  
  public List<QIMBeautyItem> ic()
  {
    if (this.NG.size() == 0) {
      anq();
    }
    return this.NG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzr
 * JD-Core Version:    0.7.0.1
 */