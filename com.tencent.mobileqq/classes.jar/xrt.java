import android.view.View;

public class xrt
  extends xrx
{
  public int a;
  
  public xrt(xsc paramxsc, View paramView, int paramInt)
  {
    super(paramxsc, paramView);
    this.a = paramInt;
  }
  
  public int a()
  {
    wxe.e("NullOptionElement", "getOptionIndex() on %d", new Object[] { Integer.valueOf(this.a) });
    return this.a;
  }
  
  public CharSequence a()
  {
    wxe.e("NullOptionElement", "getText() on %d", new Object[] { Integer.valueOf(this.a) });
    return "";
  }
  
  public void a(CharSequence paramCharSequence)
  {
    wxe.e("NullOptionElement", "setText() on %d", new Object[] { Integer.valueOf(this.a) });
  }
  
  public void a(boolean paramBoolean) {}
  
  public CharSequence b()
  {
    wxe.e("NullOptionElement", "getHint() on %d", new Object[] { Integer.valueOf(this.a) });
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xrt
 * JD-Core Version:    0.7.0.1
 */