import android.util.Property;

class aysj
  extends Property<aysi, Float>
{
  aysj(aysi paramaysi, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(aysi paramaysi)
  {
    if (paramaysi != null) {
      return Float.valueOf(aysi.a(paramaysi));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(aysi paramaysi, Float paramFloat)
  {
    if (paramaysi != null) {
      aysi.a(paramaysi, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysj
 * JD-Core Version:    0.7.0.1
 */