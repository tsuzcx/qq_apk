public class ahfx
{
  public boolean cgF;
  public boolean cgG;
  public int errorCode;
  public boolean isDebugMode;
  
  public ahfx(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.errorCode = paramInt;
    this.cgF = paramBoolean1;
    this.isDebugMode = paramBoolean2;
    this.cgG = paramBoolean3;
  }
  
  public boolean isSuccess()
  {
    return this.errorCode == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfx
 * JD-Core Version:    0.7.0.1
 */