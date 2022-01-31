import android.app.Activity;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;

public class buy
  extends ClickableSpan
{
  public buy(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ((Activity)GrayTipsItemBuilder.d(this.a)).showDialog(230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     buy
 * JD-Core Version:    0.7.0.1
 */