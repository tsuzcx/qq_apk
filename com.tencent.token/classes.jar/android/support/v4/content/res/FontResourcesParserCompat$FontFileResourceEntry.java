package android.support.v4.content.res;

import android.support.annotation.NonNull;

public final class FontResourcesParserCompat$FontFileResourceEntry
{
  @NonNull
  private final String mFileName;
  private boolean mItalic;
  private int mResourceId;
  private int mWeight;
  
  public FontResourcesParserCompat$FontFileResourceEntry(@NonNull String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.mFileName = paramString;
    this.mWeight = paramInt1;
    this.mItalic = paramBoolean;
    this.mResourceId = paramInt2;
  }
  
  @NonNull
  public String getFileName()
  {
    return this.mFileName;
  }
  
  public int getResourceId()
  {
    return this.mResourceId;
  }
  
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
 * Qualified Name:     android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry
 * JD-Core Version:    0.7.0.1
 */