import android.text.SpannableStringBuilder;
import java.util.ArrayList;

public class upk
  extends SpannableStringBuilder
{
  private ArrayList<upm> a;
  private ArrayList<upl> b;
  
  upk(CharSequence paramCharSequence)
  {
    super(paramCharSequence);
  }
  
  public ArrayList<upm> a()
  {
    return this.a;
  }
  
  public void a(ArrayList<upm> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<upl> b()
  {
    return this.b;
  }
  
  public void b(ArrayList<upl> paramArrayList)
  {
    this.b = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upk
 * JD-Core Version:    0.7.0.1
 */