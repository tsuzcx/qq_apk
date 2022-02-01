import android.view.View;

public class zle
  extends zli
{
  public int a;
  
  public zle(zln paramzln, View paramView, int paramInt)
  {
    super(paramzln, paramView);
    this.a = paramInt;
  }
  
  public int a()
  {
    yqp.e("NullOptionElement", "getOptionIndex() on %d", new Object[] { Integer.valueOf(this.a) });
    return this.a;
  }
  
  public CharSequence a()
  {
    yqp.e("NullOptionElement", "getText() on %d", new Object[] { Integer.valueOf(this.a) });
    return "";
  }
  
  public void a(CharSequence paramCharSequence)
  {
    yqp.e("NullOptionElement", "setText() on %d", new Object[] { Integer.valueOf(this.a) });
  }
  
  public void a(boolean paramBoolean) {}
  
  public CharSequence b()
  {
    yqp.e("NullOptionElement", "getHint() on %d", new Object[] { Integer.valueOf(this.a) });
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zle
 * JD-Core Version:    0.7.0.1
 */