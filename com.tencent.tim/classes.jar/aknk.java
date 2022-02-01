import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.TranslateFragment;
import java.util.List;

public class aknk
  implements PopupWindow.OnDismissListener
{
  public aknk(TranslateFragment paramTranslateFragment, aklz.b paramb) {}
  
  public void onDismiss()
  {
    TranslateFragment.a(this.a, null);
    if ((this.b.Ec != null) && (this.b.Ec.size() > 1))
    {
      Drawable localDrawable = this.a.getResources().getDrawable(2130847054);
      TranslateFragment.a(this.a).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknk
 * JD-Core Version:    0.7.0.1
 */