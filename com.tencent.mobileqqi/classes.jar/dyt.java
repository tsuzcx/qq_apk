import android.app.Activity;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;

public class dyt
  extends ClickableSpan
{
  public dyt(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ((Activity)GrayTipsItemBuilder.c(this.a)).showDialog(230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dyt
 * JD-Core Version:    0.7.0.1
 */