import android.view.View;

public class vys
  extends vyw
{
  public int a;
  
  public vys(vzb paramvzb, View paramView, int paramInt)
  {
    super(paramvzb, paramView);
    this.a = paramInt;
  }
  
  public int a()
  {
    ved.e("NullOptionElement", "getOptionIndex() on %d", new Object[] { Integer.valueOf(this.a) });
    return this.a;
  }
  
  public CharSequence a()
  {
    ved.e("NullOptionElement", "getText() on %d", new Object[] { Integer.valueOf(this.a) });
    return "";
  }
  
  public void a(CharSequence paramCharSequence)
  {
    ved.e("NullOptionElement", "setText() on %d", new Object[] { Integer.valueOf(this.a) });
  }
  
  public void a(boolean paramBoolean) {}
  
  public CharSequence b()
  {
    ved.e("NullOptionElement", "getHint() on %d", new Object[] { Integer.valueOf(this.a) });
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vys
 * JD-Core Version:    0.7.0.1
 */