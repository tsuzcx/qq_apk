package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aaeh;
import android.widget.TextView;

class DrawRedpacketPannelPreviewFragment$5
  implements Runnable
{
  DrawRedpacketPannelPreviewFragment$5(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, String paramString) {}
  
  public void run()
  {
    if (this.this$0.NW != null)
    {
      if (this.this$0.NW.getVisibility() != 0) {
        this.this$0.NW.setVisibility(0);
      }
      this.this$0.NW.setText("当前识别结果：---- 当前识别成功阈值：" + aaeh.a().threshold + "\n" + this.bcF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.5
 * JD-Core Version:    0.7.0.1
 */