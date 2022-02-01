import android.text.TextUtils;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.ocr.OCRResultActivity.11.1;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;

public class akmc
  implements akne.a
{
  public akmc(OCRResultActivity paramOCRResultActivity) {}
  
  public void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(OCRResultActivity.a(this.a)))) {
      return;
    }
    this.a.runOnUiThread(new OCRResultActivity.11.1(this, paramInt, paramOcrRecogResult));
  }
  
  public void dCd() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmc
 * JD-Core Version:    0.7.0.1
 */