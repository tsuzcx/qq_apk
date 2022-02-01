import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.TAVCutSession;

class axnx
  implements axnr.a
{
  axnx(axnw paramaxnw, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession) {}
  
  public void a(axob paramaxob)
  {
    if ((paramaxob instanceof axoa))
    {
      paramaxob = (axoa)paramaxob;
      this.val$textEditorData.setContent(paramaxob.getContent());
      this.val$textEditorData.setTextColor(paramaxob.getColor());
      this.a.updateTextSticker(this.val$textEditorData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnx
 * JD-Core Version:    0.7.0.1
 */