import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class zat
  implements AbsListView.e
{
  zat(zas paramzas) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.RecommendsAdapter", 2, "onScrollStateChanged firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    if ((paramInt1 >= 1) && (paramInt1 - 1 >= 0) && (paramInt1 - 1 < this.this$0.getCount()))
    {
      paramAbsListView = (MayKnowRecommend)this.this$0.getItem(paramInt1 - 1);
      if (paramAbsListView != null) {
        this.this$0.a.b(paramAbsListView, 20, 0, 1);
      }
    }
    if ((paramInt1 + paramInt2 < paramInt3) && (paramInt1 + paramInt2 >= 0) && (paramInt1 + paramInt2 < this.this$0.getCount()))
    {
      paramAbsListView = (MayKnowRecommend)this.this$0.getItem(paramInt1 + paramInt2);
      if (paramAbsListView != null) {
        this.this$0.a.b(paramAbsListView, 20, 0, 1);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    this.this$0.ckZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zat
 * JD-Core Version:    0.7.0.1
 */