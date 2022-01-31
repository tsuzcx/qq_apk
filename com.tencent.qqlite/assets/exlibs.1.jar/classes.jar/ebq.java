import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.widget.ClickableImageSpan;
import com.tencent.mobileqq.widget.ClickableImageSpan.ClickableImageSpanListener;

public class ebq
  implements ClickableImageSpan.ClickableImageSpanListener
{
  public ebq(EditActivity paramEditActivity) {}
  
  public void a(ClickableImageSpan paramClickableImageSpan)
  {
    if ((EditActivity.a(this.a) == paramClickableImageSpan) && (System.currentTimeMillis() - this.a.a > 1300L)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebq
 * JD-Core Version:    0.7.0.1
 */