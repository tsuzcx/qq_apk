package com.tencent.av.redpacket.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.VideoLayerUI;
import izm;

class RedPacketGameView$2$1
  implements Runnable
{
  RedPacketGameView$2$1(RedPacketGameView.2 param2, VideoLayerUI paramVideoLayerUI, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a[0].K();
      int i = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a[0].a().lv();
      localBitmap1 = RedPacketGameView.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView$2.this$0, localBitmap1, i * 90);
      i = localBitmap1.getHeight();
      int j = this.bn.getWidth() * i / this.bn.getHeight();
      Bitmap localBitmap2 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      Rect localRect1 = new Rect(0, 0, localBitmap1.getWidth(), localBitmap1.getHeight());
      int k = localBitmap1.getWidth() * i / localBitmap1.getHeight();
      int m = i * -200 / 1334;
      Rect localRect2 = new Rect((j - k) / 2, m, (k + j) / 2, i + m);
      localCanvas.save();
      localCanvas.scale(-1.0F, 1.0F, j / 2, 0.0F);
      localCanvas.drawBitmap(localBitmap1, localRect1, localRect2, null);
      localCanvas.restore();
      localRect1.set(0, 0, this.bn.getWidth(), this.bn.getHeight());
      localRect2.set(0, 0, j, i);
      localCanvas.drawBitmap(this.bn, localRect1, localRect2, null);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView$2.this$0.setDrawingCacheEnabled(false);
      localBitmap1.recycle();
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView$2.d.h(localBitmap2);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameView.2.1
 * JD-Core Version:    0.7.0.1
 */