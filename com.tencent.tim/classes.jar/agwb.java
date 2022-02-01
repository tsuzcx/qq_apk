import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.3.1;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveUtils;

public class agwb
  implements agrd.a
{
  agwb(agvz paramagvz) {}
  
  public void Jy(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.this$0.b != null)) {
      this.this$0.b.iw();
    }
    if (paramBoolean)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.this$0.jdField_a_of_type_Aguk.getFilePath(), this);
      this.this$0.cfm = false;
      QQToast.a(this.this$0.mContext, 2, 2131693525, 1).show();
      ThreadManagerV2.getUIHandlerV2().postDelayed(new DocExportFilePresenter.3.1(this), 800L);
    }
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void as(boolean paramBoolean)
  {
    if (this.this$0.b != null) {
      this.this$0.b.as(paramBoolean);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.amE()) && (paramBoolean)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.dkv();
    }
    while ((this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.cb() == null) || (paramBoolean)) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.this$0.jdField_a_of_type_Aguk.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwb
 * JD-Core Version:    0.7.0.1
 */