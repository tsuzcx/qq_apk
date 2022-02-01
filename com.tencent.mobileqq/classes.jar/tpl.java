import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class tpl
  implements blih
{
  tpl(ReadInJoyCommentListView paramReadInJoyCommentListView, sph paramsph) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Sph != null) {
      this.jdField_a_of_type_Sph.a(paramAbsListView);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((tpk.a() == null) || (tpk.a().size() == 0)) {}
    for (;;)
    {
      return;
      paramInt = tpk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      int i = paramAbsListView.getFirstVisiblePosition();
      int j = paramAbsListView.getLastVisiblePosition();
      paramAbsListView = tpk.a().iterator();
      while (paramAbsListView.hasNext())
      {
        Object localObject = (tpm)paramAbsListView.next();
        int k = ((tpm)localObject).jdField_a_of_type_Int;
        localObject = (ReadInJoyArticleBottomVideoView)((tpm)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((k >= i - paramInt) && (k <= j - paramInt))
        {
          if (localObject != null) {
            ((ReadInJoyArticleBottomVideoView)localObject).n();
          }
        }
        else if (localObject != null) {
          ((ReadInJoyArticleBottomVideoView)localObject).q();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpl
 * JD-Core Version:    0.7.0.1
 */