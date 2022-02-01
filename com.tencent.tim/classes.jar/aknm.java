import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.TranslateFragment;
import java.util.List;

public class aknm
  implements PopupWindow.OnDismissListener
{
  public aknm(TranslateFragment paramTranslateFragment, aklz.b paramb) {}
  
  public void onDismiss()
  {
    TranslateFragment.b(this.a, null);
    if ((this.b.Ed != null) && (this.b.Ed.size() > 1))
    {
      Drawable localDrawable = this.a.getResources().getDrawable(2130847054);
      TranslateFragment.b(this.a).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknm
 * JD-Core Version:    0.7.0.1
 */