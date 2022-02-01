import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.callback.FrameExtractCallback;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class axmn
  implements FrameExtractCallback
{
  public axmn(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, String paramString1, String paramString2, String paramString3) {}
  
  public void onFrameExtracted(Bitmap paramBitmap)
  {
    aqhq.c(paramBitmap, this.cVr);
    axjk.a().a(this.cVs, AEEditorVideoEditFragment.a(this.this$0), this.cVt, this.cVr, AEEditorVideoEditFragment.a(this.this$0).getMediaModel());
    this.this$0.bpm();
    if (this.this$0.getActivity() == null)
    {
      axoe.a(BaseApplicationImpl.getContext(), this.cVt, this.cVr, this.cVs, AEEditorVideoEditFragment.a(this.this$0), AEEditorVideoEditFragment.a(this.this$0), AEEditorVideoEditFragment.a(this.this$0));
      return;
    }
    AEEditorVideoEditFragment.a(this.this$0, this.cVt, this.cVr, this.cVs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmn
 * JD-Core Version:    0.7.0.1
 */