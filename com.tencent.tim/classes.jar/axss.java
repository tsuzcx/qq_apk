import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;

class axss
  implements PtvTemplateManager.b
{
  axss(axsr paramaxsr) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (axsr.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(axsr.a(this.a).id))
      {
        axsr.a(this.a).downloading = false;
        axsr.a(this.a).usable = paramBoolean;
      }
      if (paramBoolean)
      {
        if (axsr.a(this.a).id.equals(paramPtvTemplateInfo.id))
        {
          axsr.a(this.a, 3);
          axsr.a(this.a, 1.0F);
          this.a.eNJ();
        }
        return;
      }
      this.a.aeD(4);
      axsr.a(this.a, 2);
    }
  }
  
  public void b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (axsr.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(axsr.a(this.a).id))
      {
        axsr.a(this.a).downloading = true;
        axsr.a(this.a, 1.0F * paramInt / 100.0F);
        axsr.a(this.a, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axss
 * JD-Core Version:    0.7.0.1
 */