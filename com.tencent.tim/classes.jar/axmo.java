import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.ExportListener;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable;

public class axmo
  implements MovieExporter.ExportListener
{
  private long aCm;
  private long aCn;
  
  public axmo(AEEditorGenerateRunnable paramAEEditorGenerateRunnable, TAVCutVideoSession paramTAVCutVideoSession) {}
  
  public void onExportCancel()
  {
    axiy.i("AEEditorGenerateRunnable", "onExportCancel:" + AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    this.jdField_b_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportCompleted(String paramString)
  {
    this.aCn = System.currentTimeMillis();
    axiy.i("AEEditorGenerateRunnable", "perf: video export cost = " + (this.aCn - this.aCm) + "ms");
    axiy.i("AEEditorGenerateRunnable", "onExportCompleted : " + AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    if (AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).jP(AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable), paramString);
    }
    this.jdField_b_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportError(AssetExportSession paramAssetExportSession)
  {
    int i = -1;
    if (paramAssetExportSession != null)
    {
      i = paramAssetExportSession.getErrCode();
      axiy.e("AEEditorGenerateRunnable", "[onExportError] errorcode " + i);
    }
    axiy.i("AEEditorGenerateRunnable", "onExportError:" + AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    if (AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).onAETavSessionExportError(AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable), i);
    }
    this.jdField_b_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportStart()
  {
    this.aCm = System.currentTimeMillis();
    axiy.i("AEEditorGenerateRunnable", "onExportStart :" + AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    if (AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).adc(AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    }
  }
  
  public void onExporting(float paramFloat)
  {
    if (AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).onAETavSessionExporting(AEEditorGenerateRunnable.a(this.jdField_b_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable), paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmo
 * JD-Core Version:    0.7.0.1
 */