import android.view.View;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerGalleryAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class dtw
  implements AdapterView.OnItemSelectedListener
{
  public dtw(PhotoFileViewBase paramPhotoFileViewBase) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    PhotoFileViewBase.a(this.a, paramInt);
    if (PhotoFileViewBase.a(this.a) != null) {
      PhotoFileViewBase.b(this.a).a(paramInt);
    }
    paramAdapterView = (IFileViewerAdapter)PhotoFileViewBase.a(this.a).getItem(paramInt);
    this.a.a().a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtw
 * JD-Core Version:    0.7.0.1
 */