public class vyf
  extends vyd
{
  public int d = -1;
  public int e = -1;
  
  public vyf() {}
  
  public vyf(vwr paramvwr)
  {
    super(paramvwr);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TreeGatherConfig =[");
    localStringBuilder.append(" mStartGatherLevel=").append(this.d);
    localStringBuilder.append(" mEndGatherLevel=").append(this.e);
    localStringBuilder.append("] ");
    return localStringBuilder.toString() + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyf
 * JD-Core Version:    0.7.0.1
 */