import com.tencent.tim.filemanager.settings.FMSettings.4;

public class audo
  implements audm.a
{
  public audo(FMSettings.4 param4) {}
  
  public void NW(int paramInt)
  {
    synchronized (this.a.this$0)
    {
      audn localaudn2 = this.a.this$0;
      localaudn2.cYV += 1;
      audn.cu(1, "onMoveFail,count[" + this.a.this$0.cYV + "],total[" + this.a.val$count + "]");
      if (this.a.this$0.cYV == this.a.val$count)
      {
        audn.cu(1, "moveFileToDefaultPath,move over!");
        this.a.a.NW(16);
      }
      return;
    }
  }
  
  public void at(long paramLong1, long paramLong2)
  {
    audn localaudn = this.a.this$0;
    localaudn.aaj += paramLong1;
    this.a.a.at(this.a.this$0.aaj, this.a.this$0.totalSize);
  }
  
  public void dhx()
  {
    synchronized (this.a.this$0)
    {
      audn localaudn2 = this.a.this$0;
      localaudn2.cYV += 1;
      audn.cu(1, "onMovedOver,count[" + this.a.this$0.cYV + "],total[" + this.a.val$count + "]");
      if (this.a.this$0.cYV == this.a.val$count)
      {
        audn.cu(1, "moveFileToDefaultPath,move over!");
        this.a.a.dhx();
      }
      return;
    }
  }
  
  public void fG(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     audo
 * JD-Core Version:    0.7.0.1
 */