import android.util.Property;

class aysp
  extends Property<aysn, Integer>
{
  aysp(aysn paramaysn, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(aysn paramaysn)
  {
    if (paramaysn != null) {
      return Integer.valueOf(aysn.b(paramaysn));
    }
    return Integer.valueOf(255);
  }
  
  public void a(aysn paramaysn, Integer paramInteger)
  {
    if (paramaysn != null) {
      aysn.b(paramaysn, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysp
 * JD-Core Version:    0.7.0.1
 */