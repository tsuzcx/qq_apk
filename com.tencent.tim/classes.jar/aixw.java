import java.math.BigDecimal;

public class aixw
{
  public String bQa;
  public String text;
  public String type;
  
  public String a(int paramInt, float paramFloat)
  {
    String str = null;
    if (this.text != null)
    {
      str = this.text.replaceFirst("%param%", "" + paramInt);
      paramFloat = new BigDecimal(paramFloat).setScale(1, 4).floatValue();
      str = str.replaceFirst("%param%", "" + paramFloat);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixw
 * JD-Core Version:    0.7.0.1
 */