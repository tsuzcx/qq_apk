import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.1.1;
import java.util.List;

public class axed
  implements axfr.a
{
  axed(axec paramaxec) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      axec.a(this.a, paramString);
    }
    ((axdj)axec.a(this.a).get(paramInt)).cTP = paramString;
    ((axdj)axec.a(this.a).get(paramInt)).state = 13;
    axec.a(this.a).runOnUiThread(new AEGIFChunkPreviewFragment.1.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axed
 * JD-Core Version:    0.7.0.1
 */