import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

class tkb
{
  int a;
  private int b;
  private int c;
  
  public static tkb a(int paramInt, Object... paramVarArgs)
  {
    tkb localtkb = new tkb();
    localtkb.a = paramInt;
    switch (paramInt)
    {
    case 3: 
    default: 
      return localtkb;
    case 1: 
    case 2: 
      localtkb.b = ((Integer)paramVarArgs[0]).intValue();
      return localtkb;
    }
    localtkb.c = ((Integer)paramVarArgs[0]).intValue();
    return localtkb;
  }
  
  public Object a()
  {
    switch (this.a)
    {
    default: 
      return null;
    case 1: 
      return new tka(this.b);
    case 2: 
      return new ForegroundColorSpan(this.b);
    case 5: 
      return new StrikethroughSpan();
    case 4: 
      return new StyleSpan(this.c);
    }
    return new UnderlineSpan();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tkb
 * JD-Core Version:    0.7.0.1
 */