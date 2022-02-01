public class abtz
  implements Comparable
{
  public boolean bFB;
  public int crW;
  public int crX;
  public int crY;
  public int crZ;
  public int csa;
  public int csb;
  public int csc;
  public String mDescription;
  public int mDirection;
  public int mPriority;
  public int mTag;
  
  public int compareTo(Object paramObject)
  {
    paramObject = (abtz)paramObject;
    if (this.crY < paramObject.crY) {
      return 1;
    }
    if (this.crY > paramObject.crY) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtz
 * JD-Core Version:    0.7.0.1
 */