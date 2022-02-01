package com.tencent.mobileqq.activity.contact.troop;

import android.graphics.Bitmap;
import aqmp;
import com.tencent.mobileqq.app.QQAppInterface;

class ShowExternalTroopListActivity$2
  implements Runnable
{
  ShowExternalTroopListActivity$2(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.s(this.this$0.app.a(this.this$0.aZM, (byte)1, true));
    if (localBitmap != null) {}
    try
    {
      aqmp.fastblur(localBitmap, 10);
      this.this$0.runOnUiThread(new ShowExternalTroopListActivity.2.1(this, localBitmap));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.2
 * JD-Core Version:    0.7.0.1
 */