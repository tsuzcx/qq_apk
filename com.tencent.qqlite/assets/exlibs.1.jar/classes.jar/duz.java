import android.view.View;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class duz
  implements AdapterView.OnItemClickListener
{
  public duz(PhotoFileViewBase paramPhotoFileViewBase) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    if (!PhotoFileViewBase.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      PhotoFileViewBase.a(paramAdapterView, bool);
      if (PhotoFileViewBase.c(this.a) != null) {
        PhotoFileViewBase.d(this.a).c(PhotoFileViewBase.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     duz
 * JD-Core Version:    0.7.0.1
 */