import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class dgs
  implements SlideDetectListView.OnScrollToTopListener
{
  public dgs(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, LocalFileBrowserActivity.c + ",onScrollStateChanged() is called,scrollState is:" + paramInt + ",time is:" + System.currentTimeMillis());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dgs
 * JD-Core Version:    0.7.0.1
 */