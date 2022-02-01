package com.tencent.mobileqq.troop.homework.logic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import apio;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;

public class DocsEntranceHelper$3
  implements Runnable
{
  public DocsEntranceHelper$3(apio paramapio, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.this$0.a.getActivity());
    int i = ((SharedPreferences)localObject).getInt(apio.a(this.this$0), 0);
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, String.format("onShow guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (this.cQR) {
      ((SharedPreferences.Editor)localObject).putInt(apio.a(this.this$0), i + this.val$count).commit();
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).apply();
      return;
      ((SharedPreferences.Editor)localObject).putInt(apio.a(this.this$0), this.val$count).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper.3
 * JD-Core Version:    0.7.0.1
 */