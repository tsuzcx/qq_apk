import android.content.Intent;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView.a;

public class akma
  implements ParticipleBottomMenuView.a
{
  public akma(OCRResultActivity paramOCRResultActivity) {}
  
  public void AX(String paramString)
  {
    aofz.hG(paramString, "OCR_Participle_copy");
  }
  
  public void AY(String paramString)
  {
    OCRResultActivity.a(this.a, paramString);
  }
  
  public void AZ(String paramString)
  {
    aofz.c(this.a, this.a.app, paramString);
  }
  
  public void Ba(String paramString)
  {
    Intent localIntent = new Intent(this.a, TextPreviewTranslateActivity.class);
    localIntent.putExtra("TranslateText", paramString);
    localIntent.putExtra("WhereAreYouFrom", "OCR_RESULT");
    this.a.startActivityForResult(localIntent, 1);
    OCRResultActivity.a(this.a, true);
  }
  
  public void auC()
  {
    if (OCRResultActivity.a(this.a) == 0) {
      OCRResultActivity.a(this.a);
    }
    while (OCRResultActivity.a(this.a) != 1) {
      return;
    }
    OCRResultActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akma
 * JD-Core Version:    0.7.0.1
 */