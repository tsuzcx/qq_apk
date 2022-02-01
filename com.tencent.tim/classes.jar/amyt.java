import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class amyt
  extends amyf
{
  public TextView MZ;
  public TextView Zi;
  public LinearLayout contentContainer;
  public RelativeLayout lX;
  
  public amyt(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void aDR()
  {
    this.contentContainer = ((LinearLayout)this.view.findViewById(2131377855));
    this.Zi = ((TextView)this.view.findViewById(2131370387));
    this.MZ = ((TextView)this.view.findViewById(2131377328));
    this.lX = ((RelativeLayout)this.view.findViewById(2131369423));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyt
 * JD-Core Version:    0.7.0.1
 */