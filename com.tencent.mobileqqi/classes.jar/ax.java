import com.dataline.activities.LiteActivity;
import com.tencent.widget.XListView;

public class ax
  implements Runnable
{
  public ax(LiteActivity paramLiteActivity) {}
  
  public void run()
  {
    if (LiteActivity.a(this.a).a() > 2) {
      LiteActivity.a(this.a, LiteActivity.a(this.a).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ax
 * JD-Core Version:    0.7.0.1
 */