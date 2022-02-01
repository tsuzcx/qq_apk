import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.1;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.2;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.3;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;
import mqq.os.MqqHandler;

public class axpc
  implements PtvTemplateManager.b
{
  axpc(axpa paramaxpa) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    if (paramPtvTemplateInfo.usable)
    {
      axxj.a(paramPtvTemplateInfo).ePh();
      if ((!(axpa.a(this.this$0) instanceof axoo)) || (((axoo)axpa.a(this.this$0)).aPo())) {
        break label54;
      }
    }
    label54:
    do
    {
      return;
      axxj.a(paramPtvTemplateInfo).ePi();
      break;
      ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.1(this, paramPtvTemplateInfo, paramBoolean));
    } while (paramBoolean);
    aytq.h("", "0X80075BB", "", "", "", "");
    ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.2(this));
  }
  
  public void b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.3(this, paramPtvTemplateInfo, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axpc
 * JD-Core Version:    0.7.0.1
 */