import android.text.TextUtils;
import com.tencent.mobileqq.ocr.OCRResultActivity;

public class akml
  implements akoz.a
{
  public akml(OCRResultActivity paramOCRResultActivity) {}
  
  public void a(int paramInt, akoz.b paramb)
  {
    if ((paramb != null) && (!TextUtils.isEmpty(OCRResultActivity.c(this.a))) && (!OCRResultActivity.c(this.a).equals(paramb.languageCode)))
    {
      OCRResultActivity.c(this.a, paramb.languageCode);
      OCRResultActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akml
 * JD-Core Version:    0.7.0.1
 */