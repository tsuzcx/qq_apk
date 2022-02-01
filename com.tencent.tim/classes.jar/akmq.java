import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew.10.1;

public class akmq
  extends ahqw
{
  public akmq(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  protected void a(boolean paramBoolean, ahqy paramahqy)
  {
    if (!OCRResultFragmentNew.a(this.a)) {
      return;
    }
    OCRResultFragmentNew.b(this.a, false);
    OCRResultFragmentNew.a(this.a).runOnUiThread(new OCRResultFragmentNew.10.1(this, paramBoolean, paramahqy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmq
 * JD-Core Version:    0.7.0.1
 */