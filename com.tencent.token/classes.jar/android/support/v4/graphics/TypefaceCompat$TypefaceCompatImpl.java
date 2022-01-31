package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.provider.FontsContractCompat.FontInfo;

abstract interface TypefaceCompat$TypefaceCompatImpl
{
  public abstract Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt);
  
  public abstract Typeface createFromFontInfo(Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt);
  
  public abstract Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
 * JD-Core Version:    0.7.0.1
 */