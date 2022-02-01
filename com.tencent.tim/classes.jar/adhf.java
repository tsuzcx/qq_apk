public class adhf
{
  public adhf.a b = null;
  public String imageId = "";
  public int retCode = -1;
  
  public String toString()
  {
    return "ARCloudLBSLocationCheckResult{retCode = " + this.retCode + ", imageId = " + this.imageId + ", nearestPOIInfo = " + this.b + '}';
  }
  
  public static class a
  {
    public String Tr = "";
    public int cFQ = 0;
    public int latitude = 0;
    public int longitude = 0;
    public String name = "";
    
    public String toString()
    {
      return "POIInfo{latitude = " + this.latitude + ", longitude = " + this.longitude + ", name = " + this.name + ", addr = " + this.Tr + ", dist = " + this.cFQ + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhf
 * JD-Core Version:    0.7.0.1
 */