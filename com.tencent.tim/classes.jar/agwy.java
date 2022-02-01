import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.widget.immersive.ImmersiveUtils;

class agwy
  implements agrj.a
{
  agwy(agwv paramagwv) {}
  
  public void Jy(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.this$0.jdField_b_of_type_Agsb != null)) {
      this.this$0.jdField_b_of_type_Agsb.iw();
    }
    if (paramBoolean)
    {
      if (this.this$0.jdField_a_of_type_Aguk.getFileType() == 10) {
        agsg.jK(this.this$0.jdField_a_of_type_Aguk.getFileSize());
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.this$0.jdField_a_of_type_Aguk.getFilePath(), this);
      agwv.c(this.this$0, true);
      this.this$0.mContext.setRequestedOrientation(4);
      agwv.a(this.this$0);
      return;
    }
    if (agwv.b(this.this$0))
    {
      agwv.c(this.this$0, false);
      if (this.this$0.cfm) {
        this.this$0.mContext.setRequestedOrientation(1);
      }
      agwv.d(this.this$0, true);
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.dkw();
      if (this.this$0.jdField_b_of_type_Agsa != null) {
        this.this$0.jdField_b_of_type_Agsa.ir();
      }
    }
    agrd.a().a(this.this$0.mContext, this.this$0.jdField_a_of_type_Aguk.getFilePath(), agwv.a(this.this$0), true);
  }
  
  public void bY(boolean paramBoolean1, boolean paramBoolean2)
  {
    agwv.b(this.this$0, paramBoolean2);
    agwv.a(this.this$0, paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwy
 * JD-Core Version:    0.7.0.1
 */