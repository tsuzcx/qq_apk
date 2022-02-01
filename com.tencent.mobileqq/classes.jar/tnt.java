import android.view.View;

public class tnt
  extends qvo
{
  private final String a;
  
  public tnt(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super(paramInt1, paramInt2, paramInt3);
    this.a = paramString;
  }
  
  public tnt(String paramString, int paramInt)
  {
    super(-15504151, paramInt, 860716207);
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    pkh.a(paramView.getContext(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tnt
 * JD-Core Version:    0.7.0.1
 */