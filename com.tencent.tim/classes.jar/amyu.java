import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;

public class amyu
  extends amyf
{
  public ImageView Dy;
  public TextView Zj;
  public TextView Zk;
  public TextView Zl;
  public URLImageView bM;
  
  public amyu(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void aDR()
  {
    View localView = P(this.acL);
    this.bM = ((URLImageView)localView.findViewById(2131379813));
    this.Zj = ((TextView)localView.findViewById(2131367133));
    this.Zk = ((TextView)localView.findViewById(2131371970));
    this.Dy = ((ImageView)localView.findViewById(2131371943));
    this.Zl = ((TextView)localView.findViewById(2131377902));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyu
 * JD-Core Version:    0.7.0.1
 */