public class adeo
{
  public int cEa = 3;
  public int cEb = 3;
  public int cEc = 1000;
  public int cEd = 1;
  public int cEe = 1;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ArDownloadDPC{");
    localStringBuilder.append("networkControl=").append(this.cEa);
    localStringBuilder.append(", dailyRetryTimes=").append(this.cEb);
    localStringBuilder.append(", countRetryTimes=").append(this.cEc);
    localStringBuilder.append(", entranceControl=").append(this.cEd);
    localStringBuilder.append(", autoPreDownload=").append(this.cEe);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adeo
 * JD-Core Version:    0.7.0.1
 */