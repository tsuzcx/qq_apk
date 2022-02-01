import android.os.Handler;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class zpw
  extends akwl
{
  public zpw(BindNumberActivity paramBindNumberActivity) {}
  
  protected void xM(boolean paramBoolean)
  {
    super.xM(paramBoolean);
    if (paramBoolean) {
      BindNumberActivity.a(this.this$0).sendEmptyMessage(3);
    }
    for (;;)
    {
      this.this$0.app.unRegistObserver(this.this$0.d);
      this.this$0.d = null;
      return;
      this.this$0.VI();
      this.this$0.showToast(2131718828);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpw
 * JD-Core Version:    0.7.0.1
 */