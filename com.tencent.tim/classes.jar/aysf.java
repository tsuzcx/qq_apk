import android.util.Property;

class aysf
  extends Property<ayrx, Float>
{
  aysf(ayrx paramayrx, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(ayrx paramayrx)
  {
    if (paramayrx != null) {
      return Float.valueOf(ayrx.d(paramayrx));
    }
    return Float.valueOf(0.0F);
  }
  
  public void b(ayrx paramayrx, Float paramFloat)
  {
    if (paramayrx != null) {
      ayrx.c(paramayrx, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysf
 * JD-Core Version:    0.7.0.1
 */