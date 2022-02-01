package com.tencent.mobileqq.emoticonview;

import afhs;
import afhu;
import afna;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelFavHelper$2
  implements Runnable
{
  public EmoticonPanelFavHelper$2(afna paramafna, QQAppInterface paramQQAppInterface, boolean paramBoolean, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    if (this.val$app == null) {
      return;
    }
    if (!this.bZu)
    {
      afhu localafhu = (afhu)this.val$app.getManager(149);
      List localList1 = localafhu.ez();
      if ((localList1 != null) && (localList1.size() > afhs.cQV))
      {
        List localList2 = localList1.subList(0, localList1.size() - afhs.cQV);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "delListOverflow=" + localList2.toString() + "emolist.size=" + localList1.size());
        }
        localafhu.kf(localList2);
        this.this$0.dak();
      }
      this.val$sp.edit().putBoolean("local_overflow" + this.val$uin, true).apply();
      this.this$0.daD();
      return;
    }
    this.this$0.daD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.2
 * JD-Core Version:    0.7.0.1
 */