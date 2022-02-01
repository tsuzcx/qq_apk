import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

public class axjd
{
  public static final axjd a;
  public static final axjd[] a;
  public static final axjd b;
  public static final axjd c;
  public static final axjd d;
  @NonNull
  public final float[] dY;
  public final boolean duY;
  @DrawableRes
  public final int eFA;
  @DrawableRes
  public final int eFB;
  @DrawableRes
  public final int eFC;
  @ColorInt
  public final int eFD;
  @ColorInt
  public final int eFE;
  @DrawableRes
  public final int eFo;
  @DrawableRes
  public final int eFp;
  @DrawableRes
  public final int eFq;
  @ColorInt
  public final int eFr;
  @DrawableRes
  public final int eFs;
  @ColorInt
  public final int eFt;
  @DrawableRes
  public final int eFu;
  @DrawableRes
  public final int eFv;
  @DrawableRes
  public final int eFw;
  @DrawableRes
  public final int eFx;
  @DrawableRes
  public final int eFy;
  @DrawableRes
  public final int eFz;
  @NonNull
  public final String name;
  
  static
  {
    int i = Color.parseColor("#9095A8");
    int j = Color.parseColor("#7C878E");
    jdField_a_of_type_Axjd = new axjd("1to1_light", 2130837727, 2130837728, 2130837726, new float[] { 0.0F, 1.0F }, i, 2130837732, -16777216, false, 2130837753, 2130837734, 2130837738, 2130837725, 2130837741, 2130837715, 2130837757, 2130837718, 2130837758, -16777216, j);
    b = new axjd("full_light", 2130837730, 2130837731, 2130837729, new float[] { 1.0F, 1.0F }, -1, 2130837733, -1, true, 2130837754, 2130837734, 2130837738, 2130837725, 2130837741, 2130837715, 2130837757, 2130837719, 2130837758, -1, -1);
    c = jdField_a_of_type_Axjd;
    d = b;
    jdField_a_of_type_ArrayOfAxjd = new axjd[] { jdField_a_of_type_Axjd, b, c, d };
  }
  
  private axjd(@NonNull String paramString, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @NonNull float[] paramArrayOfFloat, @ColorInt int paramInt4, @DrawableRes int paramInt5, @ColorInt int paramInt6, boolean paramBoolean, @DrawableRes int paramInt7, @DrawableRes int paramInt8, @DrawableRes int paramInt9, @DrawableRes int paramInt10, @DrawableRes int paramInt11, @DrawableRes int paramInt12, @DrawableRes int paramInt13, @DrawableRes int paramInt14, @DrawableRes int paramInt15, @ColorInt int paramInt16, @ColorInt int paramInt17)
  {
    this.name = paramString;
    this.eFo = paramInt1;
    this.eFp = paramInt2;
    this.eFq = paramInt3;
    this.dY = paramArrayOfFloat;
    this.eFr = paramInt4;
    this.eFs = paramInt5;
    this.eFt = paramInt6;
    this.duY = paramBoolean;
    this.eFu = paramInt7;
    this.eFv = paramInt8;
    this.eFw = paramInt9;
    this.eFx = paramInt10;
    this.eFy = paramInt11;
    this.eFz = paramInt12;
    this.eFA = paramInt13;
    this.eFB = paramInt14;
    this.eFC = paramInt15;
    this.eFD = paramInt16;
    this.eFE = paramInt17;
  }
  
  public static float K(float paramFloat)
  {
    paramFloat = (paramFloat - 1.0F) / 0.3333334F;
    if (paramFloat < 0.0F) {
      return 0.0F;
    }
    if (paramFloat > 1.0F) {
      return 1.0F;
    }
    return paramFloat;
  }
  
  public static float L(float paramFloat)
  {
    paramFloat = (paramFloat - 0.6F) / 0.4F;
    if (paramFloat < 0.0F) {
      return 0.0F;
    }
    if (paramFloat > 1.0F) {
      return 1.0F;
    }
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjd
 * JD-Core Version:    0.7.0.1
 */