import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.LoadedBack;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ln
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LoadedBack jdField_a_of_type_ComTencentBizCommonUtilLoadedBack;
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  private String b;
  
  ln(Context paramContext, String paramString1, String paramString2, LoadedBack paramLoadedBack, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    if ((TextUtils.isEmpty(paramString1)) || (paramLoadedBack == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack = paramLoadedBack;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack.a(paramInt, null);
    HtmlOffline.b(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "checkUpFinished code:" + paramInt);
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {}
    do
    {
      JSONArray localJSONArray;
      do
      {
        return;
        int j = paramJSONObject.optInt("expire", 0);
        if (1 == j) {
          HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, j);
        }
        localJSONArray = paramJSONObject.optJSONArray("expirelist");
      } while (localJSONArray == null);
      while (i < localJSONArray.length())
      {
        Object localObject = localJSONArray.optJSONObject(i);
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optString("bid");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, 1);
          }
        }
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.i("HtmlCheckUpdate", 2, "expire list :" + paramJSONObject.toString());
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HtmlCheckUpdate", 4, "downUpdateZip:" + paramString);
    }
    String str = HtmlOffline.b(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    str = str + this.jdField_a_of_type_JavaLangString + ".zip";
    long l = System.currentTimeMillis();
    paramString = MsfSdkUtils.insertMtype("qb_offline", paramString);
    OfflineDownloader.a(this.jdField_a_of_type_AndroidContentContext, paramString, paramInt, this.jdField_a_of_type_JavaLangString, str, new lo(this, l));
    return true;
  }
  
  public void a()
  {
    Object localObject = HtmlOffline.a(this.jdField_a_of_type_JavaLangString);
    if (localObject != null) {}
    for (int i = ((JSONObject)localObject).optInt("version", 0);; i = 0)
    {
      localObject = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, i + "", this.jdField_a_of_type_JavaLangString, this.b);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "getUpdateConfig: null");
        }
        a(2);
        return;
      }
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject((String)localObject);
        j = localJSONObject.optInt("r", -1);
        if (j != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HtmlCheckUpdate", 2, "doCheckUp get config fail: r=：" + j);
          }
          a(2);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "get config fail:JSONException");
        }
        a(2);
        return;
      }
      int j = localJSONObject.optInt("type", -1);
      this.jdField_a_of_type_Int = j;
      String str;
      if (j > 0)
      {
        str = localJSONObject.optString("url");
        if (!TextUtils.isEmpty(str)) {
          if ((localJSONObject.optInt("updateNotification") == 1) && (i != 0)) {
            this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack.a(9, localJSONException);
          }
        }
      }
      for (;;)
      {
        a(localJSONObject);
        return;
        a(str, localJSONObject.optInt("filesize", 0));
        continue;
        a(2);
        continue;
        a(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ln
 * JD-Core Version:    0.7.0.1
 */