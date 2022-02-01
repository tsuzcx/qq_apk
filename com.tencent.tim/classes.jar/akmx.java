import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.ocr.TranslateFragment;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView.a;
import mqq.util.WeakReference;

public class akmx
  implements ParticipleBottomMenuView.a
{
  public akmx(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public void AX(String paramString)
  {
    aofz.hG(paramString, "OCR_Participle_copy");
  }
  
  public void AY(String paramString)
  {
    aklz.H(OCRResultFragmentNew.a(this.a), paramString);
  }
  
  public void AZ(String paramString)
  {
    aofz.c(OCRResultFragmentNew.a(this.a), (QQAppInterface)OCRResultFragmentNew.a(this.a).get(), paramString);
  }
  
  public void Ba(String paramString)
  {
    TranslateFragment.d(OCRResultFragmentNew.a(this.a), paramString);
  }
  
  public void auC()
  {
    OCRResultFragmentNew.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmx
 * JD-Core Version:    0.7.0.1
 */