package com.tencent.biz.pubaccount.readinjoy.ad.materialdownload;

import android.text.TextUtils;
import aqmj;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kma;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMaterialResManager$3
  implements Runnable
{
  public AdMaterialResManager$3(kma paramkma, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.val$json))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "preload receive json is empty!");
      }
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if ((kma.a(this.this$0) == null) || (kma.b(this.this$0).getApp() == null) || (kma.c(this.this$0).getCurrentAccountUin() == null)) {
          break;
        }
        aqmj.cR(kma.d(this.this$0).getApp(), kma.e(this.this$0).getCurrentAccountUin());
        ArrayList localArrayList = new ArrayList();
        Object localObject = new JSONObject(this.val$json);
        aqmj.az(kma.f(this.this$0).getApp(), kma.g(this.this$0).getCurrentAccountUin(), ((JSONObject)localObject).optInt("is_preview"));
        klx.su = ((JSONObject)localObject).optLong("req_interval");
        localObject = ((JSONObject)localObject).optJSONArray("res_list");
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break label307;
        }
        MaterialData localMaterialData = new MaterialData(((JSONArray)localObject).getJSONObject(i));
        if (((localMaterialData.ad_type == 1) || (localMaterialData.ad_type == 2)) && (!TextUtils.isEmpty(localMaterialData.res_md5)) && (localMaterialData.url != null) && (localMaterialData.url.startsWith("http"))) {
          localArrayList.add(localMaterialData);
        } else if (QLog.isColorLevel()) {
          QLog.d("AdMaterialResManager", 2, "preload ad_material went wrong id = " + localMaterialData.id);
        }
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AdMaterialResManager", 2, "resolve json error" + QLog.getStackTraceString(localException));
      return;
      label307:
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "preload ad_material result size" + localException.size());
      }
      kma.a(this.this$0, localException);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.AdMaterialResManager.3
 * JD-Core Version:    0.7.0.1
 */