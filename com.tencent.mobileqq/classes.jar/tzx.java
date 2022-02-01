public class tzx
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public tzx(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public tzx(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public tzx(tzx paramtzx)
  {
    this.a = paramtzx.a;
    this.b = paramtzx.b;
  }
  
  public void a(tzx paramtzx)
  {
    float f = this.a;
    this.a = paramtzx.a;
    paramtzx.a = f;
    f = this.b;
    this.b = paramtzx.b;
    paramtzx.b = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tzx
 * JD-Core Version:    0.7.0.1
 */