import com.tencent.tavcut.TAVCut.Callback;
import dov.com.qq.im.aeeditor.AEEditorActivity;
import dov.com.qq.im.aeeditor.AEEditorActivity.a;
import java.util.List;

public class axjg
  implements TAVCut.Callback
{
  public axjg(AEEditorActivity paramAEEditorActivity) {}
  
  public void onDone(int paramInt)
  {
    axiy.i(AEEditorActivity.access$000(), "TAVCut init ret code = " + paramInt);
    if (paramInt != 0) {
      AEEditorActivity.a(this.a).add(new AEEditorActivity.a(this.a, -8));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjg
 * JD-Core Version:    0.7.0.1
 */