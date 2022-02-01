public class akpr
{
  public String RU;
  public int cEa = 0;
  public int cEb = 3;
  public int cEc = 1000;
  public int cEd = 1;
  public int cEe = 1;
  public boolean ctU;
  public boolean ctV;
  public boolean ctW;
  public boolean ctX;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("allUseInSimple_2=").append(this.ctV).append(", bgUseInSimple_2=").append(this.ctW).append(", cfgUse_argb8888=").append(this.ctX).append(", networkControl=").append(this.cEa).append(", dailyRetryTimes=").append(this.cEb).append(", countRetryTimes=").append(this.cEc).append(", entranceControl=").append(this.cEd).append(", autoPreDownload=").append(this.cEe);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpr
 * JD-Core Version:    0.7.0.1
 */