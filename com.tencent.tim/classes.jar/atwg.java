public class atwg
  implements Cloneable
{
  public long Zo = -1L;
  public short aj;
  public short ak;
  public boolean cex;
  public byte[] ea = new byte[16];
  public String name;
  public long sessionid;
  public long size;
  
  public atwg a()
  {
    try
    {
      atwg localatwg = (atwg)super.clone();
      return localatwg;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwg
 * JD-Core Version:    0.7.0.1
 */