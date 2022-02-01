package dov.com.qq.im.ae.gif.video;

import axdm;
import axfu;

public class PngsTextDrawer$1
  implements Runnable
{
  public PngsTextDrawer$1(axfu paramaxfu, float paramFloat1, float paramFloat2, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    axfu.a(this.this$0, new axdm((int)(axfu.a(this.this$0) * this.eQ), (int)(axfu.b(this.this$0) * this.eR)));
    axfu.a(this.this$0).setText(this.val$text);
    axfu.a(this.this$0).setTextSize(this.dXP);
    axfu.a(this.this$0).setTextColor(this.ccu);
    axfu.a(this.this$0).setOutlineColor(this.cUa);
    axfu.a(this.this$0).setOutlineWidth(this.eEM);
    axfu.a(this.this$0, (int)(axfu.a(this.this$0) * this.val$x));
    axfu.b(this.this$0, (int)(axfu.b(this.this$0) * this.val$y));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsTextDrawer.1
 * JD-Core Version:    0.7.0.1
 */