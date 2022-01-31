import android.app.Activity;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;

public class bvw
  extends ClickableSpan
{
  public bvw(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ((Activity)GrayTipsItemBuilder.d(this.a)).showDialog(230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bvw
 * JD-Core Version:    0.7.0.1
 */