import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.TopRecommendBannerAdapter.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class sad
  extends rzq
{
  private boolean fV;
  private RecyclerView mRecyclerView;
  private List<sam> pr = new ArrayList();
  
  public sad(@NotNull RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
  }
  
  private void bim()
  {
    if (this.mRecyclerView != null)
    {
      if (this.mRecyclerView.isComputingLayout()) {
        ThreadManager.getUIHandler().postDelayed(new TopRecommendBannerAdapter.1(this), 500L);
      }
    }
    else {
      return;
    }
    notifyDataSetChanged();
  }
  
  private void bxE()
  {
    this.pr.clear();
    this.pr.addAll(this.mDatas.subList(0, 10));
    this.mDatas = this.mDatas.subList(10, this.mDatas.size());
  }
  
  public boolean Mr()
  {
    if ((this.mDatas != null) && (this.mDatas.size() >= 10))
    {
      bxE();
      bim();
      return true;
    }
    return false;
  }
  
  public boolean Ms()
  {
    return (this.fV) && (this.mDatas != null) && (this.mDatas.size() < 10);
  }
  
  public boolean Mt()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mDatas != null)
    {
      bool1 = bool2;
      if (this.mDatas.size() > 0)
      {
        this.pr.add(this.mDatas.remove(0));
        notifyItemInserted(this.pr.size());
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<sam> paramList)
  {
    this.a = paramStEntry;
    if (this.mDatas != null) {
      this.mDatas.addAll(paramList);
    }
    for (;;)
    {
      if (this.mDatas != null)
      {
        if (this.mDatas.size() < 10) {
          break;
        }
        bxE();
        bim();
      }
      return;
      this.mDatas = paramList;
    }
    this.pr.addAll(paramList);
    this.mDatas.clear();
    bim();
  }
  
  public List<sam> getDatas()
  {
    return this.pr;
  }
  
  public int getItemCount()
  {
    if (this.pr != null) {
      return this.pr.size() + uh();
    }
    return uh();
  }
  
  public void remove(int paramInt)
  {
    if (paramInt < this.pr.size())
    {
      this.pr.remove(paramInt);
      notifyItemRemoved(uh() + paramInt);
      notifyItemRangeChanged(uh() + paramInt, this.pr.size() - paramInt);
    }
  }
  
  public void setIsFinish(boolean paramBoolean)
  {
    this.fV = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sad
 * JD-Core Version:    0.7.0.1
 */