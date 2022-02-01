import android.view.View;
import com.tencent.mobileqq.ocr.OCRPerformFragment;

public class aklw
  implements ausj.a
{
  public aklw(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      aklz.H(OCRPerformFragment.a(this.this$0), String.valueOf(OCRPerformFragment.a(this.this$0)));
      aklz.cN("0X800AAE9", 0);
    }
    if (paramInt == 1)
    {
      amiw.bP(OCRPerformFragment.a(this.this$0), OCRPerformFragment.a(this.this$0));
      aklz.cN("0X800AAEA", 0);
    }
    if ((OCRPerformFragment.a(this.this$0) != null) && (OCRPerformFragment.a(this.this$0).isShowing())) {
      OCRPerformFragment.a(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aklw
 * JD-Core Version:    0.7.0.1
 */