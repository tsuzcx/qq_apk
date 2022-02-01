package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import apsw;
import com.tencent.mobileqq.widget.QQToast;

public class TroopGagMgr$2
  implements Runnable
{
  public TroopGagMgr$2(apsw paramapsw, boolean paramBoolean, Context paramContext, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.cnk)
    {
      QQToast.a(this.val$context, 2, this.val$text, 0).show(this.afg);
      return;
    }
    QQToast.a(this.val$context, 2130840117, this.val$text, 0).show(this.afg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGagMgr.2
 * JD-Core Version:    0.7.0.1
 */