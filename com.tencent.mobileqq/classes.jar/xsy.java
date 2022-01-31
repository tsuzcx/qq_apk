import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;

public class xsy
  implements PtvTemplateManager.IPtvTemplateDownloadListener
{
  public xsy(PtvTemplateAdapter paramPtvTemplateAdapter) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    this.a.a.post(new xta(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    this.a.a.post(new xsz(this, paramPtvTemplateInfo, paramBoolean));
    if (!paramBoolean) {
      FlowCameraMqqAction.a("", "0X80075BB", "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsy
 * JD-Core Version:    0.7.0.1
 */