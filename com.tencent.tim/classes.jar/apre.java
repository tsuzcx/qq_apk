import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apre
  implements Manager
{
  @NonNull
  List<String> Ij = new ArrayList(5);
  apre.a jdField_a_of_type_Apre$a;
  apre.b jdField_a_of_type_Apre$b;
  AppInterface app;
  String auB = "";
  boolean cSb = false;
  String cqA;
  public String cqB = acfp.m(2131708948);
  public String cqC = acfp.m(2131708942);
  String cqD;
  String cqE;
  public String cqw = "banner_config";
  public String cqx = "dialog_config";
  public String cqy = "banner_show_num";
  public String cqz = "dialog_show_num";
  int dVs;
  int dVt;
  String mTitle;
  
  public apre(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    this.cqw += paramAppInterface;
    this.cqy += paramAppInterface;
    this.cqx += paramAppInterface;
    this.cqz += paramAppInterface;
    paramAppInterface = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
    this.auB = paramAppInterface.getString("config", "");
    if (!TextUtils.isEmpty(this.auB)) {
      aD(this.auB);
    }
    this.cSb = paramAppInterface.getBoolean("enter_guide", true);
    String str = paramAppInterface.getString(this.cqw, "");
    if (!TextUtils.isEmpty(str))
    {
      df(str, true);
      if ((this.jdField_a_of_type_Apre$a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Apre$a.uniqueKey)))
      {
        this.dVt = ac(paramAppInterface.getString(this.cqy, ""), this.jdField_a_of_type_Apre$a.uniqueKey);
        this.cqE = this.jdField_a_of_type_Apre$a.uniqueKey;
      }
    }
    str = paramAppInterface.getString(this.cqx, "");
    if (!TextUtils.isEmpty(str))
    {
      dg(str, true);
      if ((this.jdField_a_of_type_Apre$b != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Apre$b.uniqueKey)))
      {
        this.dVs = ac(paramAppInterface.getString(this.cqz, ""), this.jdField_a_of_type_Apre$b.uniqueKey);
        this.cqD = this.jdField_a_of_type_Apre$b.uniqueKey;
      }
    }
  }
  
  private void df(String paramString, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("Q.nearby.video_chat", 2, "parseBannerJson json is null");
        return;
      }
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Apre$a = new apre.a();
      this.jdField_a_of_type_Apre$a.uniqueKey = paramString.optString("unique_key");
      this.jdField_a_of_type_Apre$a.dVu = paramString.optInt("display_times");
      this.jdField_a_of_type_Apre$a.startTimeStamp = paramString.optLong("start_timestamp", 0L);
      this.jdField_a_of_type_Apre$a.arT = paramString.optLong("end_timestamp", 0L);
      this.jdField_a_of_type_Apre$a.dVv = paramString.optInt("target_group");
      Object localObject = paramString.optJSONObject("content");
      if (localObject != null)
      {
        this.jdField_a_of_type_Apre$a.imageUrl = ((JSONObject)localObject).optString("image_url");
        this.jdField_a_of_type_Apre$a.jumpUrl = ((JSONObject)localObject).optString("jump_url");
      }
      if (!paramBoolean)
      {
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
        ((SharedPreferences)localObject).edit().putString(this.cqw, paramString.toString()).commit();
        if ((this.jdField_a_of_type_Apre$a.uniqueKey != null) && (!this.jdField_a_of_type_Apre$a.uniqueKey.equals(this.cqE)))
        {
          this.cqE = this.jdField_a_of_type_Apre$a.uniqueKey;
          paramString = new JSONObject();
          paramString.put(this.cqE, 0);
          ((SharedPreferences)localObject).edit().putString(this.cqy, paramString.toString()).commit();
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseBannerJson JSONException", paramString);
      }
    }
  }
  
  private void dg(String paramString, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("Q.nearby.video_chat", 2, "parseDialogJson json is null");
        return;
      }
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Apre$b = new apre.b();
      this.jdField_a_of_type_Apre$b.uniqueKey = paramString.optString("unique_key");
      this.jdField_a_of_type_Apre$b.dVu = paramString.optInt("display_times");
      this.jdField_a_of_type_Apre$b.startTimeStamp = paramString.optLong("start_timestamp", 0L);
      this.jdField_a_of_type_Apre$b.arT = paramString.optLong("end_timestamp", 0L);
      this.jdField_a_of_type_Apre$b.dVv = paramString.optInt("target_group");
      Object localObject = paramString.optJSONObject("content");
      if (localObject != null)
      {
        this.jdField_a_of_type_Apre$b.headUrl = ((JSONObject)localObject).optString("header_url");
        this.jdField_a_of_type_Apre$b.title = ((JSONObject)localObject).optString("title");
        this.jdField_a_of_type_Apre$b.content = ((JSONObject)localObject).optString("content");
        this.jdField_a_of_type_Apre$b.buttonText = ((JSONObject)localObject).optString("button_text");
        this.jdField_a_of_type_Apre$b.jumpUrl = ((JSONObject)localObject).optString("jump_url");
        this.jdField_a_of_type_Apre$b.cqF = ((JSONObject)localObject).optString("button_text_color");
        this.jdField_a_of_type_Apre$b.cqG = ((JSONObject)localObject).optString("button_background_color");
      }
      if (!paramBoolean)
      {
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
        ((SharedPreferences)localObject).edit().putString(this.cqx, paramString.toString()).commit();
        if ((this.jdField_a_of_type_Apre$b.uniqueKey != null) && (!this.jdField_a_of_type_Apre$b.uniqueKey.equals(this.cqD)))
        {
          this.cqD = this.jdField_a_of_type_Apre$b.uniqueKey;
          paramString = new JSONObject();
          paramString.put(this.cqD, 0);
          ((SharedPreferences)localObject).edit().putString(this.cqz, paramString.toString()).commit();
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseDialogJson JSONException", paramString);
      }
    }
  }
  
  public String By()
  {
    return this.auB;
  }
  
  public void TA(String paramString)
  {
    df(paramString, false);
  }
  
  public void TB(String paramString)
  {
    dg(paramString, false);
  }
  
  public void aD(String paramString)
  {
    try
    {
      this.Ij.clear();
      if (TextUtils.isEmpty(paramString))
      {
        this.cqA = null;
        this.mTitle = null;
        BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 4).edit().putString("config", paramString).commit();
        return;
      }
      this.auB = paramString;
      Object localObject = new JSONObject(paramString);
      this.cqB = ((JSONObject)localObject).optString("detail_default");
      this.cqC = ((JSONObject)localObject).optString("detail_num");
      this.cqA = ((JSONObject)localObject).optString("guide");
      this.mTitle = ((JSONObject)localObject).optString("title");
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 4);
      localSharedPreferences.edit().putString("detail_default", this.cqB).commit();
      localSharedPreferences.edit().putString("detail_num", this.cqC).commit();
      if (TextUtils.isEmpty(this.mTitle)) {
        localSharedPreferences.edit().putString("title", acfp.m(2131708947)).commit();
      }
      for (;;)
      {
        localObject = ((JSONObject)localObject).optJSONArray("tips");
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          this.Ij.add(((JSONArray)localObject).optString(i));
          i += 1;
        }
        break;
        localSharedPreferences.edit().putString("title", this.mTitle).commit();
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseJson JSONException", paramString);
      }
    }
  }
  
  public int ac(String paramString1, String paramString2)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return 0;
      }
      int i = new JSONObject(paramString1).optInt(paramString2);
      return i;
    }
    catch (JSONException paramString2)
    {
      QLog.e("Q.nearby.video_chat", 2, "getNumFromJson json:" + paramString1);
    }
    return 0;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public void onDestroy() {}
  
  public static class a
  {
    public long arT;
    public int dVu;
    public int dVv;
    public String imageUrl;
    public String jumpUrl;
    public long startTimeStamp;
    public String uniqueKey;
  }
  
  public static class b
  {
    public long arT;
    public String buttonText;
    public String content;
    public String cqF;
    public String cqG;
    public int dVu;
    public int dVv;
    public String headUrl;
    public String jumpUrl;
    public long startTimeStamp;
    public String title;
    public String uniqueKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apre
 * JD-Core Version:    0.7.0.1
 */