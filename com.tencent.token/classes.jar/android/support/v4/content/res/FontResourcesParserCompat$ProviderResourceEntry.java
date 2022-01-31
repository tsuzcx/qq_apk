package android.support.v4.content.res;

import android.support.annotation.NonNull;
import android.support.v4.provider.FontRequest;

public final class FontResourcesParserCompat$ProviderResourceEntry
  implements FontResourcesParserCompat.FamilyResourceEntry
{
  @NonNull
  private final FontRequest mRequest;
  private final int mStrategy;
  private final int mTimeoutMs;
  
  public FontResourcesParserCompat$ProviderResourceEntry(@NonNull FontRequest paramFontRequest, int paramInt1, int paramInt2)
  {
    this.mRequest = paramFontRequest;
    this.mStrategy = paramInt1;
    this.mTimeoutMs = paramInt2;
  }
  
  public int getFetchStrategy()
  {
    return this.mStrategy;
  }
  
  @NonNull
  public FontRequest getRequest()
  {
    return this.mRequest;
  }
  
  public int getTimeout()
  {
    return this.mTimeoutMs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.res.FontResourcesParserCompat.ProviderResourceEntry
 * JD-Core Version:    0.7.0.1
 */