import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class tsx
  implements rwn
{
  private WeakReference<ReadInJoyArticleBottomVideoView> a;
  
  public tsx(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView)
  {
    this.a = new WeakReference(paramReadInJoyArticleBottomVideoView);
  }
  
  public List<rwo> a(int paramInt, boolean paramBoolean)
  {
    ReadInJoyArticleBottomVideoView localReadInJoyArticleBottomVideoView = (ReadInJoyArticleBottomVideoView)this.a.get();
    ArrayList localArrayList = new ArrayList();
    if (localReadInJoyArticleBottomVideoView != null) {
      localArrayList.add(new rwo(ReadInJoyArticleBottomVideoView.a(localReadInJoyArticleBottomVideoView).d, "", 5, (int)ReadInJoyArticleBottomVideoView.a(localReadInJoyArticleBottomVideoView).a));
    }
    return localArrayList;
  }
  
  public boolean b()
  {
    ReadInJoyArticleBottomVideoView localReadInJoyArticleBottomVideoView = (ReadInJoyArticleBottomVideoView)this.a.get();
    if (localReadInJoyArticleBottomVideoView == null) {
      return false;
    }
    return bhnv.h(ReadInJoyArticleBottomVideoView.a(localReadInJoyArticleBottomVideoView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsx
 * JD-Core Version:    0.7.0.1
 */