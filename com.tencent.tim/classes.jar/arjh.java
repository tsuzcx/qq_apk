import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.util.StateSet;
import java.util.ArrayList;

public class arjh
  extends BitmapDrawable
{
  private static final float[] aS;
  private static final ColorMatrixColorFilter b;
  private static final ColorMatrixColorFilter c;
  private static final ColorMatrixColorFilter d = new ColorMatrixColorFilter(dN);
  private static final float[] dM;
  private static final float[] dN;
  private static final int[] pi = { 16842919 };
  private ArrayList<int[]> Dq;
  private ArrayList<ColorFilter> Dr;
  private float alphaValue = 1.0F;
  private float[] dO = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, this.alphaValue, 0.0F };
  private ColorFilter g;
  
  static
  {
    dM = new float[] { 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F };
    b = new ColorMatrixColorFilter(dM);
    aS = new float[] { 0.3F, 0.59F, 0.11F, 0.0F, 0.0F, 0.3F, 0.59F, 0.11F, 0.0F, 0.0F, 0.3F, 0.59F, 0.11F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    c = new ColorMatrixColorFilter(aS);
    dN = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.8F, 0.0F };
  }
  
  public arjh(Resources paramResources, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramResources, paramBitmap);
    if (paramBoolean2) {
      a(pi, b);
    }
    if (paramBoolean1) {
      a(StateSet.WILD_CARD, c);
    }
  }
  
  private ColorFilter a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = this.Dq;
    if (localArrayList == null) {
      return null;
    }
    int j = this.Dr.size();
    int i = 0;
    while (i < j)
    {
      if (StateSet.stateSetMatches((int[])localArrayList.get(i), paramArrayOfInt)) {
        return (ColorFilter)this.Dr.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public int a(int[] paramArrayOfInt, ColorFilter paramColorFilter)
  {
    if (this.Dq == null)
    {
      this.Dq = new ArrayList();
      this.Dr = new ArrayList();
    }
    this.Dq.add(paramArrayOfInt);
    this.Dr.add(paramColorFilter);
    return this.Dr.size();
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    paramArrayOfInt = a(paramArrayOfInt);
    if (this.g != paramArrayOfInt)
    {
      this.g = paramArrayOfInt;
      setColorFilter(this.g);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjh
 * JD-Core Version:    0.7.0.1
 */