public class tth
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public tth(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public tth(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public tth(tth paramtth)
  {
    this.a = paramtth.a;
    this.b = paramtth.b;
  }
  
  public void a(tth paramtth)
  {
    float f = this.a;
    this.a = paramtth.a;
    paramtth.a = f;
    f = this.b;
    this.b = paramtth.b;
    paramtth.b = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tth
 * JD-Core Version:    0.7.0.1
 */