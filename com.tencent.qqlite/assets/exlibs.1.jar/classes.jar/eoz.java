import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.troop.data.TroopFilePreviewController;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.PreviewInfo;

public class eoz
  extends BizTroopObserver
{
  public eoz(TroopFilePreviewController paramTroopFilePreviewController) {}
  
  protected void c(Object paramObject)
  {
    TroopFileTransferManager.PreviewInfo localPreviewInfo = (TroopFileTransferManager.PreviewInfo)paramObject;
    this.a.a.a(localPreviewInfo.jdField_a_of_type_Boolean, localPreviewInfo.jdField_a_of_type_JavaLangString, localPreviewInfo.b, localPreviewInfo.jdField_a_of_type_Int, localPreviewInfo.c, localPreviewInfo.d, localPreviewInfo.e);
    super.c(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eoz
 * JD-Core Version:    0.7.0.1
 */