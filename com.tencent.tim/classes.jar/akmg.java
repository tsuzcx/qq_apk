import android.graphics.Rect;
import android.text.Spannable;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;

public class akmg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public akmg(OCRResultActivity paramOCRResultActivity) {}
  
  public void onGlobalLayout()
  {
    int i = 0;
    if (OCRResultActivity.d(this.a) != 0) {
      return;
    }
    Object localObject = new Rect();
    this.a.mRootView.getWindowVisibleDisplayFrame((Rect)localObject);
    int j = this.a.mRootView.getRootView().getHeight();
    if (j - ((Rect)localObject).bottom > j * 0.15D) {
      try
      {
        localObject = this.a.bv.getText();
        aofk.b[] arrayOfb = (aofk.b[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), aofk.b.class);
        if ((arrayOfb != null) && (arrayOfb.length > 0))
        {
          j = arrayOfb.length;
          while (i < j)
          {
            ((Spannable)localObject).removeSpan(arrayOfb[i]);
            i += 1;
          }
        }
        adld.a(this.a, this.a.em, false, 0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.a.bv.setText(OCRResultActivity.a(this.a).ocrContent);
        return;
      }
    }
    if (OCRResultActivity.a(this.a) != null)
    {
      this.a.bv.setText(new aofk(this.a.bv.getText(), 8, 16));
      this.a.bv.clearFocus();
    }
    adld.a(this.a, this.a.em, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmg
 * JD-Core Version:    0.7.0.1
 */