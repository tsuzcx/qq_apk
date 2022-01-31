import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import java.lang.ref.WeakReference;

public class dwl
  extends ClickableSpan
{
  private WeakReference a;
  
  public dwl(FileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    this.a = new WeakReference(paramTipsClickedInterface);
  }
  
  public void onClick(View paramView)
  {
    FileManagerUtil.TipsClickedInterface localTipsClickedInterface = (FileManagerUtil.TipsClickedInterface)this.a.get();
    if (localTipsClickedInterface != null) {
      localTipsClickedInterface.a(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dwl
 * JD-Core Version:    0.7.0.1
 */