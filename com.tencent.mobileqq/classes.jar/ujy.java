public class ujy
  extends ujw
{
  public int d = -1;
  public int e = -1;
  
  public ujy() {}
  
  public ujy(uij paramuij)
  {
    super(paramuij);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujy
 * JD-Core Version:    0.7.0.1
 */