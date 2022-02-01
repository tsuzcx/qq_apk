public class aylk
{
  public float rotate;
  public float scale;
  public float x;
  public float y;
  
  public aylk(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.scale = paramFloat3;
    this.rotate = paramFloat4;
  }
  
  public static boolean a(aylk paramaylk1, aylk paramaylk2)
  {
    return Float.compare(paramaylk1.rotate, paramaylk2.rotate) != 0;
  }
  
  public void b(aylk paramaylk)
  {
    this.scale *= paramaylk.scale;
    this.x -= paramaylk.x;
    this.y -= paramaylk.y;
  }
  
  public void set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.scale = paramFloat3;
    this.rotate = paramFloat4;
  }
  
  public String toString()
  {
    return "CropHomeing{x=" + this.x + ", y=" + this.y + ", scale=" + this.scale + ", rotate=" + this.rotate + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylk
 * JD-Core Version:    0.7.0.1
 */