import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView.BorderStyle;
import java.util.List;

public class pwx
  extends prp<puh>
{
  protected RotateCircleImageView a = (RotateCircleImageView)getView(2131364615);
  protected ImageView mA = (ImageView)getView(2131368383);
  protected ImageView mB = (ImageView)getView(2131379072);
  protected ImageView mC = (ImageView)getView(2131376951);
  protected TextView titleTextView = (TextView)getView(2131379769);
  protected TextView xd = (TextView)getView(2131376952);
  
  public pwx(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void dS(int paramInt1, int paramInt2)
  {
    this.a.setBorderStyle(RotateCircleImageView.BorderStyle.STILL);
    int[] arrayOfInt = new int[paramInt1];
    int i = 0;
    if (i < paramInt1)
    {
      if (i < paramInt1 - paramInt2) {
        arrayOfInt[i] = Color.parseColor("#DEDFE0");
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfInt[i] = Color.parseColor("#19D7FD");
      }
    }
    this.a.setBorderColors(arrayOfInt);
  }
  
  public void r(puh parampuh)
  {
    if ((parampuh.iO != null) && (!parampuh.iO.isEmpty())) {
      dS(parampuh.iO.size(), parampuh.unreadCount);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwx
 * JD-Core Version:    0.7.0.1
 */