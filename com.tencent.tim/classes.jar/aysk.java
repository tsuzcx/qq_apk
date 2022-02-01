import android.util.Property;

class aysk
  extends Property<aysi, Integer>
{
  aysk(aysi paramaysi, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(aysi paramaysi)
  {
    if (paramaysi != null) {
      return Integer.valueOf(aysi.a(paramaysi));
    }
    return Integer.valueOf(0);
  }
  
  public void a(aysi paramaysi, Integer paramInteger)
  {
    if (paramaysi != null) {
      aysi.a(paramaysi, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysk
 * JD-Core Version:    0.7.0.1
 */