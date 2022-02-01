import android.text.SpannableStringBuilder;
import java.util.ArrayList;

public class vlu
  extends SpannableStringBuilder
{
  private ArrayList<vlw> a;
  private ArrayList<vlv> b;
  
  vlu(CharSequence paramCharSequence)
  {
    super(paramCharSequence);
  }
  
  public ArrayList<vlw> a()
  {
    return this.a;
  }
  
  public void a(ArrayList<vlw> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<vlv> b()
  {
    return this.b;
  }
  
  public void b(ArrayList<vlv> paramArrayList)
  {
    this.b = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlu
 * JD-Core Version:    0.7.0.1
 */