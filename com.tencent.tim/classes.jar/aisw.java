import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;

public class aisw
  implements View.OnKeyListener
{
  public aisw(LocationPickFragment paramLocationPickFragment, EditText paramEditText) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (LocationPickFragment.a(this.this$0).aQZ()))
    {
      LocationPickFragment.a(this.this$0).hide();
      return true;
    }
    if ((paramInt == 84) || (paramInt == 66))
    {
      LocationPickFragment.a(this.this$0).Iq(this.bi.getText().toString().trim());
      LocationPickFragment.b(this.this$0);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisw
 * JD-Core Version:    0.7.0.1
 */