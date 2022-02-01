import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hiboom.FontBubble;
import com.tencent.mobileqq.hiboom.FontBubblePanelView;
import com.tencent.mobileqq.hiboom.FontBubblePanelView.a;
import com.tencent.mobileqq.model.QueryTask.a;
import java.util.List;

public class ahxk
  implements QueryTask.a<T, List<FontBubble>>
{
  public ahxk(FontBubblePanelView paramFontBubblePanelView) {}
  
  public List<FontBubble> a(T paramT)
  {
    paramT = FontBubblePanelView.a(this.a).a(FontBubblePanelView.a(this.a).app, paramT);
    FontBubble localFontBubble = new FontBubble();
    localFontBubble.viewType = 0;
    paramT.add(localFontBubble);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxk
 * JD-Core Version:    0.7.0.1
 */