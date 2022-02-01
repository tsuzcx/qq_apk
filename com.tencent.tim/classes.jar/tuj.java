import org.json.JSONArray;

public class tuj
{
  private final float scaleX;
  private final float scaleY;
  
  public tuj()
  {
    this(1.0F, 1.0F);
  }
  
  public tuj(float paramFloat1, float paramFloat2)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
  }
  
  public float getScaleX()
  {
    return this.scaleX;
  }
  
  public float getScaleY()
  {
    return this.scaleY;
  }
  
  public String toString()
  {
    return getScaleX() + "x" + getScaleY();
  }
  
  public static class a
    implements tve.a<tuj>
  {
    public static final a a = new a();
    
    public tuj a(Object paramObject, float paramFloat)
    {
      paramObject = (JSONArray)paramObject;
      return new tuj((float)paramObject.optDouble(0, 1.0D) / 100.0F * paramFloat, (float)paramObject.optDouble(1, 1.0D) / 100.0F * paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tuj
 * JD-Core Version:    0.7.0.1
 */