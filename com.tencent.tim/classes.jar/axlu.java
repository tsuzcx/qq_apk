import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.exporter.ImageExporter.ImageExportCallback;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.11.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.11.2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class axlu
  implements ImageExporter.ImageExportCallback
{
  public axlu(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onCancelled() {}
  
  public void onExportComplete()
  {
    axiy.i(AEEditorImageEditFragment.access$100(), "images export complete");
    AEEditorImageEditFragment.a(this.this$0, System.currentTimeMillis());
    axiy.i(AEEditorImageEditFragment.access$100(), "perf: image export cost = " + (AEEditorImageEditFragment.a(this.this$0) - AEEditorImageEditFragment.b(this.this$0)) + "ms");
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.11.2(this));
  }
  
  public void onFailed(Collection<String> paramCollection)
  {
    axiy.e(AEEditorImageEditFragment.access$100(), "images export failed");
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.11.1(this, paramCollection));
  }
  
  public void onImageExport(String paramString)
  {
    axiy.i(AEEditorImageEditFragment.access$100(), "image export, path = " + paramString);
    List localList = AEEditorImageEditFragment.a(this.this$0).getMediaModels();
    if ((localList.get(AEEditorImageEditFragment.a(this.this$0).size()) != null) && (((MediaModel)localList.get(AEEditorImageEditFragment.a(this.this$0).size())).getMediaEffectModel().getStickerModelList().size() > 0) && (((MediaModel)localList.get(AEEditorImageEditFragment.a(this.this$0).size())).getMediaEffectModel().getStickerModelList().get(0) != null) && (((StickerModel)((MediaModel)localList.get(AEEditorImageEditFragment.a(this.this$0).size())).getMediaEffectModel().getStickerModelList().get(0)).getTextItems() != null)) {
      axip.a().a().rf.put(Integer.valueOf(AEEditorImageEditFragment.a(this.this$0).size()), Integer.valueOf(((StickerModel)((MediaModel)AEEditorImageEditFragment.a(this.this$0).getMediaModels().get(AEEditorImageEditFragment.a(this.this$0).size())).getMediaEffectModel().getStickerModelList().get(0)).getTextItems().size()));
    }
    axim.a().adW(AEEditorImageEditFragment.a(this.this$0).size());
    AEEditorImageEditFragment.a(this.this$0).add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axlu
 * JD-Core Version:    0.7.0.1
 */