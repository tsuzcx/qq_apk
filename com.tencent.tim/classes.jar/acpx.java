public class acpx
{
  public int cyZ;
  public int cza;
  public int czb;
  public int czc;
  public long totalTime;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("M_size=");
    localStringBuilder.append(this.cyZ);
    localStringBuilder.append(",C_size=");
    localStringBuilder.append(this.cza);
    localStringBuilder.append(",R_size=");
    localStringBuilder.append(this.czb);
    localStringBuilder.append(",K_len=");
    localStringBuilder.append(this.czc);
    localStringBuilder.append(",time=");
    localStringBuilder.append(this.totalTime);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acpx
 * JD-Core Version:    0.7.0.1
 */