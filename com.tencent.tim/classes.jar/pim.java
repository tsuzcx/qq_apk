import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;

public class pim
  extends pii
{
  private QCircleFollowView e;
  
  public pim(int paramInt)
  {
    super(paramInt);
  }
  
  void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if (paramStNotice.operation.opUser.get() != null) {
      this.e.setUserData((FeedCloudMeta.StUser)paramStNotice.operation.opUser.get());
    }
  }
  
  void h(Context paramContext, View paramView)
  {
    this.e = ((QCircleFollowView)paramView.findViewById(2131374518));
  }
  
  void kJ()
  {
    if (this.cG != null)
    {
      if (this.mContainer != null) {
        this.mContainer.setOnClickListener(this.cG);
      }
      if (this.wT != null) {
        this.wT.setOnClickListener(this.cG);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pim
 * JD-Core Version:    0.7.0.1
 */