public class anir
{
  private int dHv;
  private int mFrameIndex;
  public int mWriteFrameCount;
  
  public int JF()
  {
    int i = this.mFrameIndex;
    this.mFrameIndex = (i + 1);
    return i;
  }
  
  public int JG()
  {
    int i = this.dHv;
    this.dHv = (i + 1);
    return i;
  }
  
  public int JH()
  {
    return this.dHv;
  }
  
  public void cza()
  {
    this.mFrameIndex = 0;
    this.mWriteFrameCount = 0;
    this.dHv = 0;
  }
  
  public void dQw()
  {
    this.mFrameIndex = 0;
    this.mWriteFrameCount = 0;
    this.dHv = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anir
 * JD-Core Version:    0.7.0.1
 */