import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.view.EyeButton.a;
import com.tencent.mobileqq.ocr.view.OcrImageTextView;

public class aklv
  implements EyeButton.a
{
  public aklv(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void dBP()
  {
    aklz.cN("0X800AAE1", 0);
    if (OCRPerformFragment.a(this.this$0).ase()) {
      OCRPerformFragment.a(this.this$0).setShowTextMask(false);
    }
  }
  
  public void dBQ()
  {
    if (!OCRPerformFragment.a(this.this$0).ase()) {
      OCRPerformFragment.a(this.this$0).setShowTextMask(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aklv
 * JD-Core Version:    0.7.0.1
 */