import android.app.Activity;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.1;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.2;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.3;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.4;
import mqq.os.MqqHandler;

public class akmw
  extends aobz
{
  public akmw(OCRResultFragmentNew paramOCRResultFragmentNew, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void RZ(int paramInt)
  {
    OCRResultFragmentNew.a(this.a).post(new OCRResultFragmentNew.7.4(this, paramInt));
  }
  
  public void aI(boolean paramBoolean, String paramString)
  {
    OCRResultFragmentNew.a(this.a).post(new OCRResultFragmentNew.7.2(this, paramString));
  }
  
  public void dCc()
  {
    OCRResultFragmentNew.a(this.a).post(new OCRResultFragmentNew.7.1(this));
  }
  
  public void gQ(String paramString1, String paramString2)
  {
    OCRResultFragmentNew.a(this.a).post(new OCRResultFragmentNew.7.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmw
 * JD-Core Version:    0.7.0.1
 */