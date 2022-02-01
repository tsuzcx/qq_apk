import android.app.Activity;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.ocr.OCRResultActivity.10.1;
import com.tencent.mobileqq.ocr.OCRResultActivity.10.2;
import com.tencent.mobileqq.ocr.OCRResultActivity.10.3;
import com.tencent.mobileqq.ocr.OCRResultActivity.10.4;
import mqq.os.MqqHandler;

public class akmb
  extends aobz
{
  public akmb(OCRResultActivity paramOCRResultActivity, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void RZ(int paramInt)
  {
    OCRResultActivity.a(this.a).post(new OCRResultActivity.10.4(this, paramInt));
  }
  
  public void aI(boolean paramBoolean, String paramString)
  {
    OCRResultActivity.a(this.a).post(new OCRResultActivity.10.2(this, paramString));
  }
  
  public void dCc()
  {
    OCRResultActivity.a(this.a).post(new OCRResultActivity.10.1(this));
  }
  
  public void gQ(String paramString1, String paramString2)
  {
    OCRResultActivity.a(this.a).post(new OCRResultActivity.10.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmb
 * JD-Core Version:    0.7.0.1
 */