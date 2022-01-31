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
import org.json.JSONObject;

public class lp
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AsyncCallBack jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  lp(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack)
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
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "transThread callback mode:" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack != null) {
      this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack.a(paramInt, paramString);
    }
  }
  
  private boolean a()
  {
    String str = HtmlOffline.b(this.b);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, "html5/" + this.b + "/" + this.b + ".zip", str + this.b + ".zip");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "doTransUrl start:" + this.b);
    }
    long l3 = System.currentTimeMillis();
    Object localObject1 = HtmlOffline.a(this.b);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      a(this.jdField_a_of_type_JavaLangString, 0);
      HtmlOffline.a(this.b, 2, 0L, -1, "lixian_cover", "0");
      return;
    }
    String str1 = (String)localObject1 + this.b;
    Object localObject3 = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b);
    localObject1 = HtmlOffline.a(this.b);
    int j;
    long l1;
    if (localObject1 != null)
    {
      j = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b);
      i = j;
      if (j != 1)
      {
        l1 = ((JSONObject)localObject1).optLong("expired", 0L);
        i = j;
        if (l1 > 0L)
        {
          i = j;
          if (l3 > l1) {
            i = 1;
          }
        }
      }
      if (i == 1)
      {
        Util.a(str1);
        HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b, 0);
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "offline expire =1");
        }
      }
    }
    Object localObject2;
    if (HtmlOffline.c(this.b))
    {
      localObject2 = HtmlOffline.a(this.b);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        l1 = ((JSONObject)localObject2).optLong("expired", 0L);
        localObject1 = localObject2;
        if (l1 > 0L)
        {
          localObject1 = localObject2;
          if (l3 > l1)
          {
            Util.a(HtmlOffline.l + this.b);
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.i("HtmlCheckUpdate", 2, "zip expire =1");
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    int i = 0;
    int m = 0;
    int k;
    if (localObject3 != null)
    {
      j = ((JSONObject)localObject3).optInt("version", 0);
      l1 = ((JSONObject)localObject3).optLong("expired", 0L);
      i = j;
      if (l1 > 0L)
      {
        i = j;
        if (l3 > l1)
        {
          i = 1;
          k = j;
        }
      }
    }
    for (;;)
    {
      j = m;
      if (localObject1 != null) {
        j = ((JSONObject)localObject1).optInt("version", 0);
      }
      if ((k == 0) && (j == 0))
      {
        a(this.jdField_a_of_type_JavaLangString, 0);
        HtmlOffline.a(this.b, 5, 0L, OfflineDownloader.a(this.jdField_a_of_type_AndroidContentContext), "lixian_cover", "0");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQBrowserOffline", 2, "getVersion :" + String.valueOf(k) + "," + String.valueOf(j));
      }
      m = 6;
      if ((j < k) && (i == 0)) {
        if (a()) {
          if (HtmlOffline.c(this.b))
          {
            localObject1 = HtmlOffline.a(this.b);
            if (localObject1 != null)
            {
              j = ((JSONObject)localObject1).optInt("version", 0);
              localObject2 = localObject1;
              i = m;
            }
          }
        }
      }
      for (;;)
      {
        if (j < k)
        {
          a(this.jdField_a_of_type_JavaLangString, 0);
          HtmlOffline.a(this.b, i, j, OfflineDownloader.a(this.jdField_a_of_type_AndroidContentContext), "lixian_cover", "0");
          return;
          i = 10;
          localObject2 = localObject1;
          continue;
          i = 9;
          localObject2 = localObject1;
          continue;
          i = 8;
          localObject2 = localObject1;
        }
        else
        {
          i = 1;
          if (localObject2 != null) {
            i = ((JSONObject)localObject2).optInt("loadmode", 1);
          }
          localObject3 = this.jdField_a_of_type_JavaLangString;
          String str2 = HtmlOffline.f(this.jdField_a_of_type_JavaLangString);
          if (i == 2)
          {
            localObject1 = localObject3;
            if (!((String)localObject3).contains("_lv=")) {
              localObject1 = HtmlOffline.a((String)localObject3, "_lv=" + j);
            }
          }
          label683:
          label1203:
          for (;;)
          {
            k = 0;
            if (localObject2 != null) {
              k = ((JSONObject)localObject2).optInt("verifyType", 0);
            }
            boolean bool;
            label752:
            long l2;
            if (new File(str1).exists())
            {
              l1 = System.currentTimeMillis();
              if ((i == 2) && (k == 1))
              {
                if (TextUtils.isEmpty(str2)) {
                  break label1188;
                }
                bool = OfflineSecurity.b(str2, str1, this.b);
                i = 3;
                l2 = System.currentTimeMillis() - l1;
                l1 = 0L;
                label763:
                if (bool) {
                  break label1185;
                }
                Util.a(str1);
                localObject1 = this.jdField_a_of_type_JavaLangString;
                if (QLog.isColorLevel()) {
                  QLog.i("HtmlCheckUpdate", 2, "trans VerifyFile fail :" + this.b);
                }
                i = 0;
                j = 0;
              }
            }
            for (;;)
            {
              a((String)localObject1, i);
              if (j > 0)
              {
                long l4 = System.currentTimeMillis();
                HtmlOffline.a(this.b, 0, j, -1, "lixian_cover", "" + (l4 - l3));
                if (QLog.isColorLevel()) {
                  QLog.i("OfflineCheckFile", 2, "trans time:" + (l4 - l3));
                }
                if (l2 > 0L)
                {
                  HtmlOffline.a(this.b, Long.valueOf(l2).intValue(), 1L, -1, "lixian_cover_sec", "");
                  return;
                  k = this.jdField_a_of_type_JavaLangString.indexOf(":");
                  localObject1 = this.jdField_a_of_type_JavaLangString.substring(k + 3);
                  localObject3 = "file://" + HtmlOffline.l + this.b + "/" + (String)localObject1;
                  localObject1 = localObject3;
                  if (!((String)localObject3).contains("_lv=")) {
                    localObject1 = HtmlOffline.a((String)localObject3, "_lv=" + j + "&_t=" + System.currentTimeMillis());
                  }
                  if (new File(HtmlOffline.l + this.b + "/" + str2).exists()) {
                    break label1203;
                  }
                  localObject1 = this.jdField_a_of_type_JavaLangString;
                  break label683;
                  bool = OfflineSecurity.a(str1, this.b);
                  l4 = System.currentTimeMillis();
                  l2 = 0L;
                  l1 = l4 - l1;
                  break label763;
                }
                if (l1 <= 0L) {
                  break;
                }
                HtmlOffline.a(this.b, Long.valueOf(l1).intValue(), 2L, -1, "lixian_cover_sec", "");
                return;
              }
              HtmlOffline.a(this.b, 7, j, OfflineDownloader.a(this.jdField_a_of_type_AndroidContentContext), "lixian_cover", "0");
              return;
              continue;
              bool = false;
              break label752;
              l2 = 0L;
              l1 = 0L;
            }
          }
          label1185:
          label1188:
          i = m;
          localObject2 = localObject1;
        }
      }
      k = i;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     lp
 * JD-Core Version:    0.7.0.1
 */