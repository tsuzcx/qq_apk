import android.util.Property;

class ayso
  extends Property<aysn, Integer>
{
  ayso(aysn paramaysn, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(aysn paramaysn)
  {
    if (paramaysn != null) {
      return Integer.valueOf(aysn.a(paramaysn));
    }
    return Integer.valueOf(0);
  }
  
  public void a(aysn paramaysn, Integer paramInteger)
  {
    if (paramaysn != null) {
      aysn.a(paramaysn, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayso
 * JD-Core Version:    0.7.0.1
 */