import com.tencent.mobileqq.activity.BookShareAdviceEditActivity;
import com.tencent.mobileqq.activity.book.ResizeLayout;
import com.tencent.mobileqq.activity.book.ResizeLayout.OnResizeListener;

public class abh
  implements ResizeLayout.OnResizeListener
{
  public abh(BookShareAdviceEditActivity paramBookShareAdviceEditActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Math.abs(paramInt2 - paramInt4) < BookShareAdviceEditActivity.a(this.a, this.a, 100.0F)) {}
    do
    {
      return;
      if (paramInt2 - paramInt4 < 0)
      {
        this.a.a(true);
        return;
      }
    } while (paramInt2 - paramInt4 <= 0);
    this.a.a(false);
    this.a.a.post(new abi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     abh
 * JD-Core Version:    0.7.0.1
 */