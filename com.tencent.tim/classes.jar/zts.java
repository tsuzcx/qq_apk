import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class zts
  implements AbsListView.e
{
  public zts(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      txn.a().stopMonitorScene("list_photo", false);
      return;
    }
    txn.a().startMonitorScene("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zts
 * JD-Core Version:    0.7.0.1
 */