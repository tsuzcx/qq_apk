import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

public class ahsv
  extends RecyclerView.OnScrollListener
{
  public ahsv(QQGamePubAccountFragment paramQQGamePubAccountFragment, LinearLayoutManager paramLinearLayoutManager) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 1) {}
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      if ((this.val$layoutManager.findFirstVisibleItemPosition() < 1) || ((QQGamePubAccountFragment.a(this.this$0) != null) && (this.this$0.a != null) && (this.this$0.a.getCurrentItem() < QQGamePubAccountFragment.a(this.this$0).size())))
      {
        paramInt = this.val$layoutManager.findFirstVisibleItemPosition();
        QQGamePubAccountFragment.d(this.this$0).put(Long.valueOf(((MessageRecord)QQGamePubAccountFragment.a(this.this$0).get(this.this$0.a.getCurrentItem())).uniseq), Integer.valueOf(paramInt));
      }
      if (QQGamePubAccountFragment.a(this.this$0))
      {
        tbb.a(abmt.getAppInterface(), "769", "205029", "", "76902", "1", "160", new String[] { this.this$0.wC(), "", "20" });
        this.this$0.KB(true);
      }
      paramInt = this.val$layoutManager.findFirstVisibleItemPosition();
      int i = this.val$layoutManager.findLastVisibleItemPosition();
      while (paramInt <= i)
      {
        paramRecyclerView = QQGamePubAccountFragment.a(this.this$0).getChildViewHolder(this.val$layoutManager.findViewByPosition(paramInt));
        if (((paramRecyclerView instanceof ahrb.b)) && (QQGamePubAccountFragment.a(this.this$0).a(paramInt) != null) && (QQGamePubAccountFragment.a(this.this$0).a(paramInt).type != 3)) {
          ((ahrb.b)paramRecyclerView).a.dpO();
        }
        paramInt += 1;
      }
      paramInt = ahua.c(QQGamePubAccountFragment.a(this.this$0));
      QLog.d("wenTest", 1, "distance = " + paramInt);
    } while ((paramInt >= 500) || (paramInt < 0) || (!this.this$0.isAdded()) || (QQGamePubAccountFragment.a(this.this$0) == null));
    QQGamePubAccountFragment.a(this.this$0).KC(false);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    QLog.d("QQGamePubAccountFragment", 1, "onScrolled y=" + paramInt2 + "the last:" + QQGamePubAccountFragment.a(this.this$0).getItemCount() + "," + this.val$layoutManager.findLastCompletelyVisibleItemPosition());
    if ((paramInt2 > 0) && (this.val$layoutManager.findLastCompletelyVisibleItemPosition() == QQGamePubAccountFragment.a(this.this$0).getItemCount() - 1))
    {
      QQGamePubAccountFragment.b(this.this$0, true);
      return;
    }
    QQGamePubAccountFragment.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsv
 * JD-Core Version:    0.7.0.1
 */