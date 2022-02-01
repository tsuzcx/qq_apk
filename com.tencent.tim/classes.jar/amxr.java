import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.ThemeImageView;

public class amxr
  extends amxs
{
  public Button er;
  
  public amxr(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void aDR()
  {
    this.titleView = ((TextView)this.view.findViewById(2131372384));
    this.imageView = ((ImageView)this.view.findViewById(2131361802));
    this.tD = ((TextView)this.view.findViewById(2131377214));
    this.Zu = ((TextView)this.view.findViewById(2131378586));
    this.er = ((Button)this.view.findViewById(2131377201));
    this.er.setText(acfp.m(2131721053));
    this.Bj = ((TextView)this.view.findViewById(2131377211));
    if ((this.imageView instanceof ThemeImageView)) {
      ((ThemeImageView)this.imageView).setSupportMaskView(true);
    }
  }
  
  public Button d()
  {
    return this.er;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amxr
 * JD-Core Version:    0.7.0.1
 */