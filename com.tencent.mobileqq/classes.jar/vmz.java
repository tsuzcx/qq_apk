import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import feedcloud.FeedCloudMeta.StNotice;

public class vmz
  extends vmk
{
  public vmz(int paramInt)
  {
    super(paramInt);
  }
  
  protected View.OnClickListener a()
  {
    return this.c;
  }
  
  public void b(Context paramContext, View paramView)
  {
    super.b(paramContext, paramView);
    this.c = new vna(this, paramContext);
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    super.b(paramStNotice, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmz
 * JD-Core Version:    0.7.0.1
 */