package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import aqds;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;
import zxt;

public class HbThemeConfigManager$1
  implements Runnable
{
  public HbThemeConfigManager$1(aqds paramaqds, Context paramContext, JSONObject paramJSONObject, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = this.I.getSharedPreferences("qb_tenpay_share_face", 0).edit();
    ((SharedPreferences.Editor)localObject).putString("hb_face", aqds.a(this.this$0, this.aG).toString());
    ((SharedPreferences.Editor)localObject).commit();
    localObject = aqds.a(this.this$0).optString("hb_face_imgurl");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HbThemeConfigManager", 2, "start downloading img...");
    }
    HashSet localHashSet = new HashSet(2);
    localHashSet.add(localObject);
    zxt.a().a(this.val$app, localHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.HbThemeConfigManager.1
 * JD-Core Version:    0.7.0.1
 */