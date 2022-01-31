package android.support.v4.provider;

import android.net.Uri;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v4.util.Preconditions;

public class FontsContractCompat$FontInfo
{
  private final boolean mItalic;
  private final int mResultCode;
  private final int mTtcIndex;
  private final Uri mUri;
  private final int mWeight;
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public FontsContractCompat$FontInfo(@NonNull Uri paramUri, @IntRange(from=0L) int paramInt1, @IntRange(from=1L, to=1000L) int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.mUri = ((Uri)Preconditions.checkNotNull(paramUri));
    this.mTtcIndex = paramInt1;
    this.mWeight = paramInt2;
    this.mItalic = paramBoolean;
    this.mResultCode = paramInt3;
  }
  
  public int getResultCode()
  {
    return this.mResultCode;
  }
  
  @IntRange(from=0L)
  public int getTtcIndex()
  {
    return this.mTtcIndex;
  }
  
  @NonNull
  public Uri getUri()
  {
    return this.mUri;
  }
  
  @IntRange(from=1L, to=1000L)
  public int getWeight()
  {
    return this.mWeight;
  }
  
  public boolean isItalic()
  {
    return this.mItalic;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.FontsContractCompat.FontInfo
 * JD-Core Version:    0.7.0.1
 */