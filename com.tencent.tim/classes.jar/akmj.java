import android.text.TextUtils;
import com.tencent.mobileqq.ocr.OCRResultActivity;

public class akmj
  implements akoz.a
{
  public akmj(OCRResultActivity paramOCRResultActivity) {}
  
  public void a(int paramInt, akoz.b paramb)
  {
    if ((!TextUtils.isEmpty(OCRResultActivity.b(this.a))) && (!OCRResultActivity.b(this.a).equals(paramb.languageCode)))
    {
      OCRResultActivity.b(this.a, paramb.languageCode);
      OCRResultActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmj
 * JD-Core Version:    0.7.0.1
 */