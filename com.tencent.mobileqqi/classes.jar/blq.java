import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoLayerUI;

public class blq
  implements View.OnClickListener
{
  public blq(VideoLayerUI paramVideoLayerUI) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131232190: 
    case 2131232274: 
      do
      {
        return;
      } while (this.a.j);
      if (this.a.l) {
        this.a.k();
      }
      this.a.a.a(new Object[] { Integer.valueOf(110) });
      return;
    }
    if ((this.a.d != 0) || (this.a.c != 0))
    {
      this.a.a.a(new Object[] { Integer.valueOf(110) });
      return;
    }
    if (this.a.l) {
      this.a.k();
    }
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blq
 * JD-Core Version:    0.7.0.1
 */