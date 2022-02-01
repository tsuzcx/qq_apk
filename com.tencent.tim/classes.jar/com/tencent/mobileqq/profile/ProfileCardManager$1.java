package com.tencent.mobileqq.profile;

import alco;
import alco.a;
import android.os.Handler;
import android.text.TextUtils;
import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileCardManager$1
  implements Runnable
{
  public ProfileCardManager$1(alco paramalco, File paramFile, int paramInt) {}
  
  public void run()
  {
    Object localObject = aqhq.b(this.aF, -1);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = new JSONObject((String)localObject).optJSONArray("baseInfo");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        JSONObject localJSONObject1 = ((JSONArray)localObject).getJSONObject(0);
        localObject = new alco.a(this.this$0, this.val$id);
        ((alco.a)localObject).name = localJSONObject1.optString("name");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("previewImage");
        if (localJSONObject2 != null) {
          ((alco.a)localObject).previewUrl = (alco.bVn + localJSONObject2.optString("src"));
        }
        localJSONObject2 = localJSONObject1.optJSONObject("coverImg");
        if (localJSONObject2 != null) {
          ((alco.a)localObject).coverUrl = (alco.bVn + localJSONObject2.optString("src"));
        }
        localJSONObject1 = localJSONObject1.optJSONObject("detailImage");
        if (localJSONObject1 != null) {
          ((alco.a)localObject).bVo = (alco.bVn + localJSONObject1.optString("src"));
        }
        ((alco.a)localObject).isInited = true;
        alco.a(this.this$0).put(Integer.valueOf(this.val$id), localObject);
        if (this.this$0.dj != null)
        {
          this.this$0.dj.removeMessages(101);
          this.this$0.dj.sendEmptyMessageDelayed(101, 100L);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileCardManager", 2, "getDefaultCardItem: ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardManager.1
 * JD-Core Version:    0.7.0.1
 */