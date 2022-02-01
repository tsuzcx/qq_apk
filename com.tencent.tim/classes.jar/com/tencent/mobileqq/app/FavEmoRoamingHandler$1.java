package com.tencent.mobileqq.app;

import acbn;
import acef;
import afhs;
import afhu;
import ajdg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import aqhq;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspUserInfo;

public class FavEmoRoamingHandler$1
  implements Runnable
{
  public FavEmoRoamingHandler$1(acef paramacef, faceroam_sso.RspUserInfo paramRspUserInfo, long paramLong) {}
  
  public void run()
  {
    int j = -1;
    for (;;)
    {
      List localList2;
      try
      {
        aqhq.UD(acbn.bmd + ".nomedia");
        localList1 = this.a.filename.get();
        localList2 = this.a.delete_file.get();
        localList3 = this.a.uint32_emoji_type.get();
        localObject = this.a.bid.get();
        k = this.a.max_roam_size.get();
        afhs.cQV = k;
        String str = this.this$0.app.getCurrentAccountUin();
        if (!TextUtils.isEmpty(str)) {
          BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("fav_roaming_max" + str, k).apply();
        }
        if (localList1 == null) {
          continue;
        }
        i = localList1.size();
        if (i <= afhs.cQV) {
          continue;
        }
        afhs.cQW = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        if (localList1 != null) {
          continue;
        }
        i = -1;
      }
      catch (Exception localException)
      {
        List localList1;
        List localList3;
        Object localObject;
        int k;
        QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet error", localException);
        return;
        int i = localList1.size();
        break label492;
        j = localList2.size();
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet oom2");
        return;
      }
      QLog.d("FavEmoRoamingHandler", 2, "local max size:" + afhs.cQV + ",server max size:" + afhs.cQW + ",delListSize=" + j + ",fileListSize=" + i);
      if ((QLog.isColorLevel()) && (localList1 != null) && (localList2 != null)) {
        QLog.d("FavEmoRoamingHandler", 2, "ret = " + this.Pt + " userlist= " + localList1.toString() + " delList=" + localList2.toString() + " bid=" + (String)localObject + " local_max =" + k);
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = "qq_expression";
        acef.a(this.this$0, localList2, localList1);
        localList1 = ((afhu)this.this$0.app.getManager(149)).a(localList2, localList1, (String)localObject, localList3);
        localObject = localList1;
        if (localList1 == null) {
          localObject = new ArrayList();
        }
        this.this$0.notifyUI(1, true, localObject);
        ajdg.fe("0", 1);
        return;
        i = afhs.cQV;
        continue;
        afhs.cQW = afhs.cQV;
      }
      else
      {
        continue;
        label492:
        if (localList2 != null) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FavEmoRoamingHandler.1
 * JD-Core Version:    0.7.0.1
 */