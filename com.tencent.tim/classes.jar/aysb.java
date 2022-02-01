import android.util.Property;

class aysb
  extends Property<ayrx, Integer>
{
  aysb(ayrx paramayrx, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(ayrx paramayrx)
  {
    if (paramayrx != null) {
      return Integer.valueOf(ayrx.b(paramayrx));
    }
    return Integer.valueOf(0);
  }
  
  public void a(ayrx paramayrx, Integer paramInteger)
  {
    if (paramayrx != null) {
      ayrx.b(paramayrx, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysb
 * JD-Core Version:    0.7.0.1
 */