import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.c;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class albu
  extends RecyclerView.OnScrollListener
{
  public albu(PersonalityLabelGalleryActivity.c paramc, PersonalityLabelInfo paramPersonalityLabelInfo) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "onScrollStateChanged newState:" + paramInt);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "onScrolled dx:" + paramInt1 + " dy:" + paramInt2);
    }
    int i;
    int j;
    if (paramInt1 > 0)
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      paramInt2 = paramRecyclerView.getChildCount();
      i = paramRecyclerView.getItemCount();
      j = paramRecyclerView.findLastVisibleItemPositions(null)[0];
      paramRecyclerView = PersonalityLabelGalleryActivity.c(this.b.this$0).get(Long.valueOf(this.a.id));
      if (paramRecyclerView == null) {
        break label271;
      }
      if (((Integer)paramRecyclerView).intValue() != 1) {
        break label252;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      albz localalbz;
      if ((!PersonalityLabelGalleryActivity.b(this.b.this$0)) && (paramInt1 == 0) && (paramInt2 > 0) && (j >= i - 1))
      {
        PersonalityLabelGalleryActivity.a(this.b.this$0, true);
        QLog.i("PersonalityLabelGalleryActivity", 2, "load more photos");
        localalbz = (albz)this.b.this$0.app.getBusinessHandler(112);
        if (!PersonalityLabelGalleryActivity.a(this.b.this$0)) {
          break label257;
        }
      }
      label257:
      for (paramRecyclerView = this.b.this$0.app.getCurrentAccountUin();; paramRecyclerView = PersonalityLabelGalleryActivity.a(this.b.this$0))
      {
        localalbz.a(paramRecyclerView, this.a.id, 20, (byte[])PersonalityLabelGalleryActivity.b(this.b.this$0).get(Long.valueOf(this.a.id)));
        return;
        label252:
        paramInt1 = 0;
        break;
      }
      label271:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albu
 * JD-Core Version:    0.7.0.1
 */