package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import aqmn;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;
import zof;

public class MiniPie$4
  implements Runnable
{
  public MiniPie$4(zof paramzof) {}
  
  public void run()
  {
    int j = 300;
    int k = this.this$0.b.getHeight();
    int i = k;
    if (k <= 0)
    {
      QLog.e(this.this$0.TAG, 1, "emoHeight <=0 reset to 196dp");
      i = aqmn.ki(0);
    }
    k = zof.a(this.this$0, this.this$0.cL);
    int m = this.this$0.cL.getHeight();
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "dialogHeight" + m + " emoh " + i + " dY " + k);
    }
    if (m + k + i > MiniChatConstants.SCREEN_HEIGHT)
    {
      i = MiniChatConstants.SCREEN_HEIGHT - k - i - 2;
      if (i >= 300) {
        break label231;
      }
      i = j;
    }
    label231:
    for (;;)
    {
      WindowManager.LayoutParams localLayoutParams = ((Activity)this.this$0.mContext).getWindow().getAttributes();
      localLayoutParams.height = i;
      ((Activity)this.this$0.mContext).getWindow().setAttributes(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "new dialogHeight" + i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.4
 * JD-Core Version:    0.7.0.1
 */