import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;

public final class fyk
  extends ClickableSpan
{
  public fyk(FileManagerUtil.TipsClickedInterface paramTipsClickedInterface) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fyk
 * JD-Core Version:    0.7.0.1
 */