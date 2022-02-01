import android.content.res.TypedArray;

public class aixc
{
  public int cVH;
  public boolean cml;
  public boolean cmm;
  public boolean cmn;
  public int dfC;
  public int dfD;
  public int dfE;
  public int dfF;
  public int dfG;
  public int dfH;
  public int dfI;
  public int dfJ;
  public int dfK;
  public int dfL;
  public int dfM;
  
  public void h(TypedArray paramTypedArray)
  {
    this.dfC = paramTypedArray.getDimensionPixelSize(19, 16);
    this.dfD = paramTypedArray.getInt(18, 255);
    this.dfE = paramTypedArray.getInt(20, 255);
    this.dfF = paramTypedArray.getDimensionPixelSize(8, 20);
    this.cVH = paramTypedArray.getDimensionPixelSize(9, 20);
    this.dfK = paramTypedArray.getDimensionPixelSize(0, 15);
    this.dfG = paramTypedArray.getDimensionPixelSize(4, 20);
    this.dfH = paramTypedArray.getInt(2, 255);
    this.dfI = paramTypedArray.getInt(5, 255);
    this.dfJ = paramTypedArray.getDimensionPixelSize(3, 20);
    this.dfL = paramTypedArray.getDimensionPixelSize(12, 20);
    this.cml = paramTypedArray.getBoolean(11, false);
    this.dfM = paramTypedArray.getDimensionPixelSize(7, 10);
    this.cmn = paramTypedArray.getBoolean(6, false);
    this.cmm = paramTypedArray.getBoolean(1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixc
 * JD-Core Version:    0.7.0.1
 */