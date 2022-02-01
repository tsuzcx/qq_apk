public class nnf
{
  public String amu;
  public String amv;
  public String amw;
  public String amx;
  public String amy;
  
  public String bF(int paramInt)
  {
    if (paramInt == 72) {
      return this.amx;
    }
    if (paramInt == 73) {
      return this.amx;
    }
    if (paramInt == 2) {
      return this.amx;
    }
    if (paramInt == 3) {
      return this.amy;
    }
    if (paramInt == 12) {
      return this.amu;
    }
    if (paramInt == 9) {
      return this.amw;
    }
    if (paramInt == 10) {
      return this.amv;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("weibo : ").append(this.amu).append("\n");
    localStringBuilder.append("qq : ").append(this.amx).append("\n");
    localStringBuilder.append("wx : ").append(this.amw).append("\n");
    localStringBuilder.append("pyq : ").append(this.amv).append("\n");
    localStringBuilder.append("qzone : ").append(this.amy).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnf
 * JD-Core Version:    0.7.0.1
 */