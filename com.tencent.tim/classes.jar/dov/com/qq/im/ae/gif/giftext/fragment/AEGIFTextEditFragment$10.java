package dov.com.qq.im.ae.gif.giftext.fragment;

import axdn;
import axeu;

public class AEGIFTextEditFragment$10
  implements Runnable
{
  public AEGIFTextEditFragment$10(axeu paramaxeu, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    axeu.a(this.this$0).bG(this.val$text, this.val$color, this.cUa);
    axeu.a(this.this$0).adI(this.val$pos);
    if (this.val$color.equals("#ccffffff"))
    {
      axeu.a(this.this$0).cU(false, true);
      return;
    }
    axeu.a(this.this$0).cU(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.10
 * JD-Core Version:    0.7.0.1
 */