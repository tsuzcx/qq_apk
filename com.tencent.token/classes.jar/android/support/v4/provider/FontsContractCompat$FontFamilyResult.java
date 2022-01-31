package android.support.v4.provider;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;

public class FontsContractCompat$FontFamilyResult
{
  public static final int STATUS_OK = 0;
  public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
  public static final int STATUS_WRONG_CERTIFICATES = 1;
  private final FontsContractCompat.FontInfo[] mFonts;
  private final int mStatusCode;
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public FontsContractCompat$FontFamilyResult(int paramInt, @Nullable FontsContractCompat.FontInfo[] paramArrayOfFontInfo)
  {
    this.mStatusCode = paramInt;
    this.mFonts = paramArrayOfFontInfo;
  }
  
  public FontsContractCompat.FontInfo[] getFonts()
  {
    return this.mFonts;
  }
  
  public int getStatusCode()
  {
    return this.mStatusCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.FontsContractCompat.FontFamilyResult
 * JD-Core Version:    0.7.0.1
 */