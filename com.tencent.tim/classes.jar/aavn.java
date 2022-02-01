import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.ArrayList;

public class aavn
  extends Animation
{
  private aavn.a a;
  private int curColor;
  private ArrayList<Integer> mColors;
  
  public aavn(ArrayList<Integer> paramArrayList)
  {
    bv(paramArrayList);
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if ((this.mColors == null) || (this.mColors.size() < 2)) {
      return;
    }
    float f = 1.0F / (this.mColors.size() - 1);
    int i = (int)(paramFloat / f);
    f = (paramFloat - i * f) / f;
    if (i == this.mColors.size() - 1) {
      i = this.mColors.size() - 2;
    }
    for (;;)
    {
      int k = ((Integer)this.mColors.get(i)).intValue();
      int j = ((Integer)this.mColors.get(i + 1)).intValue();
      i = j;
      if (paramFloat < 1.0F)
      {
        i = (int)(Color.alpha(k) + (Color.alpha(j) - Color.alpha(k)) * f);
        int m = (int)(Color.red(k) + (Color.red(j) - Color.red(k)) * f);
        int n = (int)(Color.green(k) + (Color.green(j) - Color.green(k)) * f);
        paramFloat = Color.blue(k);
        i = Color.argb(i, m, n, (int)((Color.blue(j) - Color.blue(k)) * f + paramFloat));
      }
      this.curColor = i;
      if (this.a == null) {
        break;
      }
      this.a.onUpdate(i);
      return;
    }
  }
  
  public void bv(ArrayList<Integer> paramArrayList)
  {
    this.mColors = paramArrayList;
  }
  
  public int jm()
  {
    return this.curColor;
  }
  
  public static abstract interface a
  {
    public abstract void onUpdate(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavn
 * JD-Core Version:    0.7.0.1
 */