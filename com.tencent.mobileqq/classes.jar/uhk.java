import android.content.Context;
import android.view.View;
import feedcloud.FeedCloudMeta.StNotice;

public class uhk
  extends uhb
{
  public uhk(int paramInt)
  {
    super(paramInt);
  }
  
  public void b(Context paramContext, View paramView)
  {
    super.b(paramContext, paramView);
    paramView.setOnClickListener(new uhl(this, paramContext));
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    super.b(paramStNotice, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhk
 * JD-Core Version:    0.7.0.1
 */