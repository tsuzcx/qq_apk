import android.util.Property;

class ayru
  extends Property<ayrt, Integer>
{
  ayru(ayrt paramayrt, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(ayrt paramayrt)
  {
    if (paramayrt != null) {
      return Integer.valueOf(ayrt.a(paramayrt));
    }
    return Integer.valueOf(0);
  }
  
  public void a(ayrt paramayrt, Integer paramInteger)
  {
    if (paramayrt != null) {
      ayrt.a(paramayrt, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayru
 * JD-Core Version:    0.7.0.1
 */