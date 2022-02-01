import android.util.Property;

class aysq
  extends Property<aysn, Float>
{
  aysq(aysn paramaysn, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(aysn paramaysn)
  {
    if (paramaysn != null) {
      return Float.valueOf(aysn.a(paramaysn));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(aysn paramaysn, Float paramFloat)
  {
    if (paramaysn != null) {
      aysn.a(paramaysn, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysq
 * JD-Core Version:    0.7.0.1
 */