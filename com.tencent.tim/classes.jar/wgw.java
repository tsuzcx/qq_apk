import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;

public class wgw
  extends ClickableSpan
{
  public wgw(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.Qq();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(0, 165, 224));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgw
 * JD-Core Version:    0.7.0.1
 */