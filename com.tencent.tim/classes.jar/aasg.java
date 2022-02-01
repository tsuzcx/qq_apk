import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.5.1;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.5.2;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;
import com.tencent.widget.HorizontalListView;

public class aasg
  implements PtvTemplateManager.b
{
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    this.b.mListView.post(new PtvTemplateAdapter.5.2(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    this.b.mListView.post(new PtvTemplateAdapter.5.1(this, paramPtvTemplateInfo, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aasg
 * JD-Core Version:    0.7.0.1
 */