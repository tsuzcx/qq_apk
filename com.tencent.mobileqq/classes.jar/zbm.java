import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;

public class zbm
  implements View.OnClickListener
{
  public zbm(GdtVideoCeilingTitleBar paramGdtVideoCeilingTitleBar) {}
  
  public void onClick(View paramView)
  {
    if (GdtVideoCeilingTitleBar.a(this.a) != null) {
      GdtVideoCeilingTitleBar.a(this.a).a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zbm
 * JD-Core Version:    0.7.0.1
 */