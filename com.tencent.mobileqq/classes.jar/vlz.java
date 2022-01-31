import android.view.View;

public class vlz
  extends vmd
{
  public int a;
  
  public vlz(vmi paramvmi, View paramView, int paramInt)
  {
    super(paramvmi, paramView);
    this.a = paramInt;
  }
  
  public int a()
  {
    urk.e("NullOptionElement", "getOptionIndex() on %d", new Object[] { Integer.valueOf(this.a) });
    return this.a;
  }
  
  public CharSequence a()
  {
    urk.e("NullOptionElement", "getText() on %d", new Object[] { Integer.valueOf(this.a) });
    return "";
  }
  
  public void a(CharSequence paramCharSequence)
  {
    urk.e("NullOptionElement", "setText() on %d", new Object[] { Integer.valueOf(this.a) });
  }
  
  public void a(boolean paramBoolean) {}
  
  public CharSequence b()
  {
    urk.e("NullOptionElement", "getHint() on %d", new Object[] { Integer.valueOf(this.a) });
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vlz
 * JD-Core Version:    0.7.0.1
 */