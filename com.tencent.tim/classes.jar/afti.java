import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.extendfriend.wiget.TabLayout.a;
import java.util.ArrayList;

class afti
  implements TabLayout.a
{
  afti(afth paramafth, ArrayList paramArrayList, int paramInt1, int paramInt2) {}
  
  public int DC()
  {
    return 2;
  }
  
  public int DD()
  {
    return this.cUl;
  }
  
  public View L(int paramInt)
  {
    int j = getCount();
    if (j <= DC()) {}
    for (int i = 2131561324;; i = 2131561325)
    {
      View localView = View.inflate(this.a.itemView.getContext(), i, null);
      afth.a(this.a, localView, (aftg)this.wv.get(paramInt), paramInt, j);
      afth.a(this.a, (aftg)this.wv.get(paramInt), paramInt, "0X800A9B0");
      return localView;
    }
  }
  
  public Rect c(int paramInt)
  {
    Rect localRect = new Rect(0, 0, 0, 0);
    int i = getCount();
    if (i > 1) {
      if (paramInt == 0)
      {
        localRect.right = this.cUm;
        localRect.left = (this.cUm * 2);
      }
    }
    while (i != 1)
    {
      return localRect;
      if (paramInt == i - 1)
      {
        localRect.left = this.cUm;
        localRect.right = (this.cUm * 2);
        return localRect;
      }
      paramInt = this.cUm;
      localRect.right = paramInt;
      localRect.left = paramInt;
      return localRect;
    }
    paramInt = this.cUm * 2;
    localRect.right = paramInt;
    localRect.left = paramInt;
    return localRect;
  }
  
  public int getCount()
  {
    return this.wv.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afti
 * JD-Core Version:    0.7.0.1
 */