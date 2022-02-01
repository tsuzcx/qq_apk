public class ifi
  extends ifb
{
  private String LG = "qqi_android";
  private byte[] aK = { -124, -103, -119, 53, -84, -31, 44, -41, 18, 66, -17, 11, -91, -20, 57, -47, 11, -75, -75, 104, 32, 86, -43, -40, -17, 110, -103, -69, -10, -60, 125, 94, 113, -10, -57, -17, 56, 34, 69, -69, -13, -5, -102, -37, 9, -125, 124, -87, -89, -122, 103, 57, 119, -111, 83, -38 };
  
  public String getClientId()
  {
    return this.LG;
  }
  
  public String getClientSecret()
  {
    return b(this.aK, u());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifi
 * JD-Core Version:    0.7.0.1
 */