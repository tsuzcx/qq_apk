import com.tencent.mobileqq.filemanager.settings.FMSettings.4;

public class ahag
  implements ahae.a
{
  public ahag(FMSettings.4 param4) {}
  
  public void NW(int paramInt)
  {
    synchronized (this.a.this$0)
    {
      ahaf localahaf2 = this.a.this$0;
      localahaf2.cYV += 1;
      ahaf.cu(1, "onMoveFail,count[" + this.a.this$0.cYV + "],total[" + this.a.val$count + "]");
      if (this.a.this$0.cYV == this.a.val$count)
      {
        ahaf.cu(1, "moveFileToDefaultPath,move over!");
        this.a.a.NW(16);
      }
      return;
    }
  }
  
  public void at(long paramLong1, long paramLong2)
  {
    ahaf localahaf = this.a.this$0;
    localahaf.aaj += paramLong1;
    this.a.a.at(this.a.this$0.aaj, this.a.this$0.totalSize);
  }
  
  public void dhx()
  {
    synchronized (this.a.this$0)
    {
      ahaf localahaf2 = this.a.this$0;
      localahaf2.cYV += 1;
      ahaf.cu(1, "onMovedOver,count[" + this.a.this$0.cYV + "],total[" + this.a.val$count + "]");
      if (this.a.this$0.cYV == this.a.val$count)
      {
        ahaf.cu(1, "moveFileToDefaultPath,move over!");
        this.a.a.dhx();
      }
      return;
    }
  }
  
  public void fG(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ahag
 * JD-Core Version:    0.7.0.1
 */