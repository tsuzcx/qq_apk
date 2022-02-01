public class abkc
{
  public int bkg;
  public int height;
  public int width;
  public int x;
  public int y;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof abkc))) {}
    do
    {
      return false;
      paramObject = (abkc)paramObject;
    } while ((this.x != paramObject.x) || (this.y != paramObject.y) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bkg != paramObject.bkg));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    localStringBuilder.append("positionX:").append(this.x);
    localStringBuilder.append(", positionY:").append(this.y);
    localStringBuilder.append(", width:").append(this.width);
    localStringBuilder.append(", height:").append(this.height);
    localStringBuilder.append(", align:").append(this.bkg);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkc
 * JD-Core Version:    0.7.0.1
 */