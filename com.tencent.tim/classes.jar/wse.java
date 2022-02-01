public class wse
{
  public long mTime = 0L;
  public float mWidth = 0.0F;
  public float mX = 0.0F;
  public float mY = 0.0F;
  
  void a(wse paramwse)
  {
    this.mX = paramwse.mX;
    this.mY = paramwse.mY;
    this.mWidth = paramwse.mWidth;
    this.mTime = paramwse.mTime;
  }
  
  void c(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
    this.mWidth = paramFloat3;
    this.mTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wse
 * JD-Core Version:    0.7.0.1
 */