import android.app.Activity;
import android.view.View;

public class awnl
{
  public static void a(Activity paramActivity, View paramView, awnl.a parama, awnm paramawnm)
  {
    if ((paramActivity == null) || (paramView == null) || (parama == null) || (paramawnm == null)) {}
    int i;
    int j;
    int m;
    int i1;
    int i2;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramawnm.isShowing());
        paramActivity = new int[2];
        paramView.getLocationOnScreen(paramActivity);
        i = paramActivity[0] + parama.getLeft() + parama.getWidth() / 2;
        j = paramActivity[1] + parama.getTop() + parama.getHeight() / 2;
        int k = aqnm.getScreenHeight();
        m = paramawnm.kb();
        int n = parama.getWidth() / 4;
        i1 = parama.getWidth() / 4;
        i2 = paramawnm.ka();
        if (k - j - n < m) {
          break;
        }
      } while (!paramawnm.J(i, j + parama.getWidth() / 4));
      paramawnm.ajJ();
      return;
    } while ((j - i1 - i2 < m) || (!paramawnm.J(i, j - m - parama.getWidth() / 4)));
    paramawnm.ajI();
  }
  
  public static class a
  {
    public int bottom;
    public int left;
    public int marginLeft;
    public int marginTop;
    public int right;
    public int top;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.marginLeft = paramInt1;
      this.marginTop = paramInt2;
      this.left = paramInt3;
      this.top = paramInt4;
      this.right = paramInt5;
      this.bottom = paramInt6;
    }
    
    public int getHeight()
    {
      return this.bottom - this.top;
    }
    
    public int getLeft()
    {
      return this.marginLeft;
    }
    
    public int getTop()
    {
      return this.marginTop;
    }
    
    public int getWidth()
    {
      return this.right - this.left;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnl
 * JD-Core Version:    0.7.0.1
 */