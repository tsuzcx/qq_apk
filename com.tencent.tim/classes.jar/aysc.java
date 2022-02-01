import android.util.Property;

class aysc
  extends Property<ayrx, Integer>
{
  aysc(ayrx paramayrx, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(ayrx paramayrx)
  {
    if (paramayrx != null) {
      return Integer.valueOf(ayrx.c(paramayrx));
    }
    return Integer.valueOf(0);
  }
  
  public void a(ayrx paramayrx, Integer paramInteger)
  {
    if (paramayrx != null) {
      ayrx.c(paramayrx, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysc
 * JD-Core Version:    0.7.0.1
 */