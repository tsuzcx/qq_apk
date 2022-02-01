import android.content.Intent;

public class atyq
{
  private String bGi;
  private String bGj;
  private int cWq;
  private int cWr;
  private int cWt;
  private boolean ccy;
  
  public atyq a(Intent paramIntent)
  {
    this.bGi = paramIntent.getStringExtra("targetUin");
    this.bGj = paramIntent.getStringExtra("srcDiscGroup");
    this.cWq = paramIntent.getIntExtra("peerType", 0);
    this.ccy = paramIntent.getBooleanExtra("rootEntrace", true);
    this.cWr = paramIntent.getIntExtra("busiType", 0);
    this.cWt = paramIntent.getIntExtra("enterfrom", 0);
    return this;
  }
  
  public boolean ams()
  {
    return this.ccy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atyq
 * JD-Core Version:    0.7.0.1
 */