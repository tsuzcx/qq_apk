import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class zvn
  implements AbsListView.e
{
  zvn(zvm paramzvm) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((zvm.a(this.this$0)) && (paramInt == 0) && (((NewPhotoListActivity)this.this$0.mActivity).mGridView != null) && (((NewPhotoListActivity)this.this$0.mActivity).photoListAdapter != null) && (zvm.a(this.this$0).selectedMediaInfoHashMap != null)) {
      zvm.a(this.this$0);
    }
    if (paramInt == 0)
    {
      txn.a().stopMonitorScene("list_photo", false);
      return;
    }
    txn.a().startMonitorScene("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zvn
 * JD-Core Version:    0.7.0.1
 */