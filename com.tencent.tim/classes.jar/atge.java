public class atge
  extends attt
{
  private byte[] cloudId;
  private byte[] pDirKey;
  
  public atge(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.pDirKey = paramArrayOfByte1;
    this.cloudId = paramArrayOfByte2;
  }
  
  public int Em()
  {
    return 4;
  }
  
  public boolean alr()
  {
    atgi.a().checkPreviewFile(this.pDirKey, this.cloudId, new atgf(this));
    return true;
  }
  
  public void clear() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atge
 * JD-Core Version:    0.7.0.1
 */