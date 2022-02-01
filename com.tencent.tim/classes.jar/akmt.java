import android.graphics.Rect;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.qphone.base.util.QLog;

public class akmt
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public akmt(OCRResultFragmentNew paramOCRResultFragmentNew, EditText paramEditText) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    OCRResultFragmentNew.a(this.a).findViewById(2131367554).setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new Rect();
    this.a.mRoot.getWindowVisibleDisplayFrame((Rect)localObject);
    int j = this.a.mRoot.getRootView().getHeight();
    int k = j - ((Rect)localObject).bottom;
    StringBuilder localStringBuilder;
    if (k != OCRResultFragmentNew.a(this.a))
    {
      OCRResultFragmentNew.a(this.a, k);
      if (k <= j * 0.15D) {
        break label269;
      }
      this.a.em.setVisibility(8);
      try
      {
        localObject = this.val$editText.getText();
        aofk.b[] arrayOfb = (aofk.b[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), aofk.b.class);
        if ((arrayOfb != null) && (arrayOfb.length > 0))
        {
          int m = arrayOfb.length;
          int i = 0;
          while (i < m)
          {
            ((Spannable)localObject).removeSpan(arrayOfb[i]);
            i += 1;
          }
        }
        if (!QLog.isColorLevel()) {
          break label268;
        }
      }
      catch (Exception localException)
      {
        this.val$editText.setText(OCRResultFragmentNew.a(this.a, this.val$editText.getText(), true));
        localException.printStackTrace();
      }
      localStringBuilder = new StringBuilder().append("OnGlobalLayoutListener showKeyboard:");
      if (k <= j * 0.15D) {
        break label341;
      }
    }
    label268:
    label269:
    label341:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("OCRResultFragmentNew", 2, bool);
      return;
      this.a.em.setVisibility(0);
      adld.a(OCRResultFragmentNew.a(this.a), this.a.em, false, 0);
      if (this.val$editText.hasSelection()) {
        this.val$editText.clearFocus();
      }
      this.val$editText.setText(OCRResultFragmentNew.a(this.a, this.val$editText.getText(), true));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmt
 * JD-Core Version:    0.7.0.1
 */