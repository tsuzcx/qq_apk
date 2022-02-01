import android.util.Property;

class aysg
  extends Property<ayrx, Integer>
{
  aysg(ayrx paramayrx, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(ayrx paramayrx)
  {
    if (paramayrx != null) {
      return Integer.valueOf(ayrx.d(paramayrx));
    }
    return Integer.valueOf(0);
  }
  
  public void a(ayrx paramayrx, Integer paramInteger)
  {
    if (paramayrx != null) {
      ayrx.d(paramayrx, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysg
 * JD-Core Version:    0.7.0.1
 */