import android.content.Context;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.b;

public class afqw
  extends afqx
{
  private int cTu = 4;
  private int cTv = 27;
  
  public afqw(Context paramContext, afmf paramafmf, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramafmf, paramInt);
    Ig(paramBoolean);
  }
  
  private void Ig(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.cTu = 5;
      this.cTv = 34;
      return;
    }
    this.cTu = 4;
    this.cTv = 27;
  }
  
  private int d(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt.length + this.cTv - 1) / this.cTv;
  }
  
  public int Ad()
  {
    return d(this.kW);
  }
  
  protected void dbB()
  {
    if (this.a != null) {
      this.a.hN(this.cTu, 7);
    }
  }
  
  public void destroy()
  {
    super.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqw
 * JD-Core Version:    0.7.0.1
 */