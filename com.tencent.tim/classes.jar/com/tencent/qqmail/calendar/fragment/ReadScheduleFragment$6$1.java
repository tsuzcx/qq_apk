package com.tencent.qqmail.calendar.fragment;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.qqmail.calendar.data.CreditCardBill;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;

class ReadScheduleFragment$6$1
  implements Runnable
{
  ReadScheduleFragment$6$1(ReadScheduleFragment.6 param6) {}
  
  public void run()
  {
    Bitmap localBitmap = QMPrivateProtocolManager.getPhotoBitmapByEmail(ReadScheduleFragment.access$800(this.this$1.this$0).from, 3);
    Log.i("ReadScheduleFragment", "avatarBitmap " + localBitmap);
    this.this$1.val$avatarImg.setImageBitmap(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.6.1
 * JD-Core Version:    0.7.0.1
 */