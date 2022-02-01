import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter.2.1;
import com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter.2.2;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;

public class alvz
  implements PtvTemplateManager.b
{
  alvz(alvx paramalvx) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (this.a.mApp != null) {
      this.a.mApp.runOnUiThread(new PtvTemplateAdapter.2.2(this, paramPtvTemplateInfo, paramInt));
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    if (this.a.mApp != null) {
      this.a.mApp.runOnUiThread(new PtvTemplateAdapter.2.1(this, paramPtvTemplateInfo, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvz
 * JD-Core Version:    0.7.0.1
 */