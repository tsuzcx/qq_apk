package com.tencent.mobileqq.search.util;

import amol;
import amom;
import ampt;
import amxk;
import android.text.TextUtils;
import android.view.View;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class SearchUtils$2
  implements Runnable
{
  public SearchUtils$2(View paramView, ampt paramampt) {}
  
  public void run()
  {
    int j = -1;
    HashMap localHashMap = new HashMap();
    Object localObject = (Integer)this.val$view.getTag(2131381961);
    int i;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      localHashMap.put("itemLinePosition", String.valueOf(i + 1));
      localHashMap.put("matchDegree", String.valueOf(this.a.gN()));
      localHashMap.put("className", this.a.getClass().getSimpleName());
      localHashMap.put("keyword", this.a.getKeyword());
      if (this.a.mV != null) {
        localHashMap.putAll(this.a.mV);
      }
      if (!(this.a instanceof amom)) {
        break label339;
      }
      localObject = ((amom)this.a).mTroopUin;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.a.app != null))
      {
        int k = this.a.app.cs((String)localObject);
        localHashMap.put("troopMask", String.valueOf(this.a.app.cs((String)localObject)));
        TroopManager localTroopManager = (TroopManager)this.a.app.getManager(52);
        i = j;
        if (localTroopManager != null)
        {
          localObject = localTroopManager.c((String)localObject);
          i = j;
          if (localObject != null) {
            i = ((TroopInfo)localObject).wMemberNum;
          }
        }
        localHashMap.put("troopMask", String.valueOf(k));
        localHashMap.put("troopMemberNum", String.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.d("searchUtils", 2, "Report troop member click, troopMask:" + k + " troopMemberNum:" + i);
        }
      }
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "ContactSearchMatchDegree", true, 0L, 0L, amxk.f(localHashMap), "", false);
      return;
      i = -1;
      break;
      label339:
      if ((this.a instanceof amol)) {
        localObject = ((amol)this.a).mTroopUin;
      } else {
        localObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchUtils.2
 * JD-Core Version:    0.7.0.1
 */