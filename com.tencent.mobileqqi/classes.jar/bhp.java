import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.Util;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class bhp
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AsyncCallBack jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  bhp(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAsyncCallBack == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "new TransUrl error");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack = paramAsyncCallBack;
    this.b = Uri.parse(paramString).getQueryParameter("_bid");
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HtmlCheckUpdate", 4, "transThread callback:" + paramString + ", mode:" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack != null) {
      this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack.a(paramString, String.valueOf(paramInt));
    }
  }
  
  private boolean a()
  {
    return HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, "html5/" + this.b + "/" + this.b + ".zip", HtmlOffline.i + this.b + ".zip");
  }
  
  public void a()
  {
    int k = 1;
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "doTransUrl start:" + this.b);
    }
    JSONObject localJSONObject = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b);
    Object localObject1 = HtmlOffline.a(this.b);
    if ((localObject1 != null) && (HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b) == 1))
    {
      Util.a(HtmlOffline.h + this.b);
      HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b, 0);
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "updateExpire 0");
      }
    }
    if (HtmlOffline.a(this.b)) {
      localObject1 = HtmlOffline.a(this.b);
    }
    if (localJSONObject != null) {}
    for (;;)
    {
      int j;
      try
      {
        i = Integer.parseInt(localJSONObject.getString("version"));
        j = i;
      }
      catch (Exception localException1)
      {
        try
        {
          i = Integer.parseInt(((JSONObject)localObject1).getString("version"));
          if ((j != 0) || (i != 0)) {
            continue;
          }
          a(this.jdField_a_of_type_JavaLangString, 1);
          HtmlOffline.a(this.b, 5, 0L, OfflineDownloader.a(this.jdField_a_of_type_AndroidContentContext), "lixian_cover");
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("HtmlCheckUpdate", 2, "error: get iVer2");
        }
        localException1 = localException1;
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "error: get iVer1");
        }
        j = 0;
        continue;
        i = 0;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("QQBrowserOffline", 2, "getVersion :" + String.valueOf(j) + "," + String.valueOf(i));
        }
        if (i >= j) {
          break label886;
        }
      }
      if ((localObject1 == null) || ((a()) && (HtmlOffline.a(this.b))))
      {
        localObject1 = HtmlOffline.a(this.b);
        if (localObject1 == null) {}
      }
      label874:
      label886:
      for (;;)
      {
        try
        {
          int m = Integer.parseInt(((JSONObject)localObject1).getString("version"));
          i = m;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("HtmlCheckUpdate", 2, "error: get iVer2");
          continue;
          if (localObject1 == null) {
            continue;
          }
          try
          {
            j = ((JSONObject)localObject1).getInt("loadmode");
            localObject3 = this.jdField_a_of_type_JavaLangString;
            if (j != 2) {
              continue;
            }
            localObject1 = localObject3;
            if (!((String)localObject3).contains("_lv=")) {
              localObject1 = HtmlOffline.a((String)localObject3, "_lv=" + i);
            }
            localObject3 = HtmlOffline.h + this.b;
            if ((!new File((String)localObject3).exists()) || (OfflineSecurity.a((String)localObject3, this.b))) {
              break label874;
            }
            Util.a(HtmlOffline.h + this.b);
            localObject1 = this.jdField_a_of_type_JavaLangString;
            if (QLog.isColorLevel()) {
              QLog.i("HtmlCheckUpdate", 2, "trans VerifyFile fail :" + this.b);
            }
            j = 0;
            i = k;
            a((String)localObject1, i);
            if (j <= 0) {
              continue;
            }
            HtmlOffline.a(this.b, 0, j, OfflineDownloader.a(this.jdField_a_of_type_AndroidContentContext), "lixian_cover");
            return;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          j = 1;
          continue;
          Object localObject4 = HtmlOffline.h + this.b + "/" + this.jdField_a_of_type_JavaLangString.replace("http://", "");
          Object localObject3 = "file://" + (String)localObject4;
          Object localObject2 = localObject3;
          if (((String)localObject3).contains("_lv=")) {
            continue;
          }
          localObject2 = HtmlOffline.a((String)localObject3, "_lv=" + i + "&_t=" + System.currentTimeMillis());
          localObject4 = ((String)localObject4).split("\\?");
          localObject3 = localObject4;
          if (!localObject4[0].contains("#")) {
            continue;
          }
          localObject3 = localObject4[0].split("\\#");
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("HtmlCheckUpdate", 4, localObject3[0]);
          if (new File(localObject3[0]).exists()) {
            continue;
          }
          localObject2 = this.jdField_a_of_type_JavaLangString;
          continue;
          HtmlOffline.a(this.b, 7, j, OfflineDownloader.a(this.jdField_a_of_type_AndroidContentContext), "lixian_cover");
          return;
        }
        if (i < j)
        {
          a(this.jdField_a_of_type_JavaLangString, 1);
          HtmlOffline.a(this.b, 6, i, OfflineDownloader.a(this.jdField_a_of_type_AndroidContentContext), "lixian_cover");
          return;
        }
        k = i;
        i = j;
        j = k;
        continue;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhp
 * JD-Core Version:    0.7.0.1
 */