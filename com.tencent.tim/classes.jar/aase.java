import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.3.1;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.3.2;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;
import com.tencent.widget.HorizontalListView;

public class aase
  implements PtvTemplateManager.b
{
  aase(aasb paramaasb) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    this.b.mListView.post(new PtvTemplateAdapter.3.2(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    this.b.mListView.post(new PtvTemplateAdapter.3.1(this, paramPtvTemplateInfo, paramBoolean));
    if (!paramBoolean) {
      aaqi.h("", "0X80075BB", "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aase
 * JD-Core Version:    0.7.0.1
 */