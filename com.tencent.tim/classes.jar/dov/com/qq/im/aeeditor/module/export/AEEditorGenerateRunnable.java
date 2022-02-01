package dov.com.qq.im.aeeditor.module.export;

import axiy;
import axjo;
import axmo;
import axnl;
import axnn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.VideoExportConfig;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.weseevideo.model.MediaModel;

public class AEEditorGenerateRunnable
  implements Runnable
{
  private final String TAG = "AEEditorGenerateRunnable";
  private axjo jdField_a_of_type_Axjo;
  private VideoExporter jdField_a_of_type_ComTencentTavcutExporterVideoExporter;
  private String ajc;
  private String cVu;
  private String cVv;
  private MediaModel mMediaModel;
  
  public AEEditorGenerateRunnable(String paramString1, String paramString2, String paramString3, MediaModel paramMediaModel, axjo paramaxjo)
  {
    axiy.i("AEEditorGenerateRunnable", "[AEEditorGenerateRunnable] new :" + paramString1);
    this.cVu = paramString1;
    this.ajc = paramString2;
    this.cVv = paramString3;
    this.mMediaModel = paramMediaModel;
    this.jdField_a_of_type_Axjo = paramaxjo;
  }
  
  public VideoExporter a()
  {
    return this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter;
  }
  
  public void run()
  {
    try
    {
      TAVCutVideoSession localTAVCutVideoSession = new TAVCutVideoSession();
      axnn localaxnn = axnl.a();
      Size localSize = localaxnn.a(VideoUtil.getVideoSize(this.ajc));
      localTAVCutVideoSession.setMediaModel(this.mMediaModel);
      localTAVCutVideoSession.init(BaseApplicationImpl.getContext());
      VideoExportConfig localVideoExportConfig = new VideoExportConfig();
      localVideoExportConfig.setOutputPath(this.cVv);
      localVideoExportConfig.setSize(localSize.getWidth(), localSize.getHeight());
      localVideoExportConfig.setBitRate(localaxnn.Ro());
      localVideoExportConfig.setFrameRate(localaxnn.Rp());
      localTAVCutVideoSession.applyCurrentSticker();
      this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter = localTAVCutVideoSession.getExporter(localVideoExportConfig);
      this.jdField_a_of_type_ComTencentTavcutExporterVideoExporter.export(new axmo(this, localTAVCutVideoSession));
      return;
    }
    catch (Exception localException)
    {
      do
      {
        axiy.e("AEEditorGenerateRunnable", "[ERROR!!!!] generate error" + localException.getMessage());
      } while (this.jdField_a_of_type_Axjo == null);
      this.jdField_a_of_type_Axjo.onAETavSessionExportError(this.cVu, -3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable
 * JD-Core Version:    0.7.0.1
 */