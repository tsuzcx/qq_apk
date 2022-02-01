public class agnj
  implements Cloneable
{
  public long Zo = -1L;
  public short aj;
  public short ak;
  public boolean cex;
  public boolean cey;
  public byte[] ea = new byte[16];
  public String name;
  public long sessionid;
  public long size;
  
  public agnj a()
  {
    try
    {
      agnj localagnj = (agnj)super.clone();
      return localagnj;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agnj
 * JD-Core Version:    0.7.0.1
 */