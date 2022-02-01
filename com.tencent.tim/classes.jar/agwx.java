import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.widget.immersive.ImmersiveUtils;

class agwx
  implements agrd.a
{
  agwx(agwv paramagwv) {}
  
  public void Jy(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.this$0.b != null)) {
      this.this$0.b.iw();
    }
    if (paramBoolean)
    {
      if (this.this$0.jdField_a_of_type_Aguk.getFileType() == 10) {
        agsg.jK(this.this$0.jdField_a_of_type_Aguk.getFileSize());
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.this$0.jdField_a_of_type_Aguk.getFilePath(), this);
      agwv.a(this.this$0, true);
      agwv.a(this.this$0);
      this.this$0.cfm = false;
    }
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void as(boolean paramBoolean)
  {
    agwv.a(this.this$0, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwx
 * JD-Core Version:    0.7.0.1
 */