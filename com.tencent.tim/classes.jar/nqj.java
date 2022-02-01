import android.view.View;

public class nqj
  extends lsz
{
  private final String url;
  
  public nqj(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super(paramInt1, paramInt2, paramInt3);
    this.url = paramString;
  }
  
  public nqj(String paramString, int paramInt)
  {
    super(-15504151, paramInt, 860716207);
    this.url = paramString;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    kxm.aJ(paramView.getContext(), this.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nqj
 * JD-Core Version:    0.7.0.1
 */