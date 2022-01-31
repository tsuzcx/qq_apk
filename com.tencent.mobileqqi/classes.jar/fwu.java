import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.activity.LocalFileCategoryBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class fwu
  implements AbsListView.OnScrollListener
{
  public fwu(LocalFileCategoryBrowserActivity paramLocalFileCategoryBrowserActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, LocalFileCategoryBrowserActivity.b + ",onScrollStateChanged() is called,scrollState is:" + paramInt + ",time is:" + System.currentTimeMillis());
    }
    if (paramInt == 0)
    {
      URLDrawable.resume();
      return;
    }
    URLDrawable.pause();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 0) || (paramInt1 + paramInt2 >= paramInt3 - 1)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        URLDrawable.resume();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fwu
 * JD-Core Version:    0.7.0.1
 */