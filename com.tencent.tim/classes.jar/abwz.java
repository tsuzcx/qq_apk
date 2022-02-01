public class abwz
{
  public int amq;
  public int cth;
  public int cti;
  public int ctj;
  public int ctk;
  public int errCode;
  public int netType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{").append("errCode:").append(this.errCode).append(",cost:").append(this.amq);
    if (this.cth > 0) {
      localStringBuilder.append(",mem:").append(this.cth);
    }
    if (this.cti > 0) {
      localStringBuilder.append(",cpu:").append(this.cti);
    }
    if (this.ctj != 0) {
      localStringBuilder.append(",javaHeap:").append(this.ctj);
    }
    if (this.ctk != 0) {
      localStringBuilder.append(",nativeHeap:").append(this.ctk);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abwz
 * JD-Core Version:    0.7.0.1
 */