import android.view.View;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import java.util.List;

public class akmi
  implements ausj.a
{
  public akmi(OCRResultActivity paramOCRResultActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((OCRResultActivity.a(this.a) != null) && (paramInt < OCRResultActivity.a(this.a).size()))
    {
      paramView = (String)OCRResultActivity.a(this.a).get(paramInt);
      OCRResultActivity.a(this.a, OCRResultActivity.a(this.a), paramView, false, true);
    }
    if ((OCRResultActivity.a(this.a) != null) && (OCRResultActivity.a(this.a).isShowing())) {
      OCRResultActivity.a(this.a).dismiss();
    }
    OCRResultActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmi
 * JD-Core Version:    0.7.0.1
 */