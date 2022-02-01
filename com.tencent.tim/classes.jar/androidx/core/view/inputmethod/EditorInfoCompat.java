package androidx.core.view.inputmethod;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class EditorInfoCompat
{
  private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
  private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
  private static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final int IME_FLAG_FORCE_ASCII = -2147483648;
  public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
  
  @NonNull
  public static String[] getContentMimeTypes(EditorInfo paramEditorInfo)
  {
    if (Build.VERSION.SDK_INT >= 25)
    {
      paramEditorInfo = paramEditorInfo.contentMimeTypes;
      if (paramEditorInfo == null) {}
    }
    String[] arrayOfString1;
    do
    {
      return paramEditorInfo;
      return EMPTY_STRING_ARRAY;
      if (paramEditorInfo.extras == null) {
        return EMPTY_STRING_ARRAY;
      }
      String[] arrayOfString2 = paramEditorInfo.extras.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
      arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = paramEditorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
      }
      paramEditorInfo = arrayOfString1;
    } while (arrayOfString1 != null);
    return EMPTY_STRING_ARRAY;
  }
  
  static int getProtocol(EditorInfo paramEditorInfo)
  {
    int j = 0;
    int i;
    if (Build.VERSION.SDK_INT >= 25) {
      i = 1;
    }
    boolean bool2;
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramEditorInfo.extras == null);
      boolean bool1 = paramEditorInfo.extras.containsKey("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
      bool2 = paramEditorInfo.extras.containsKey("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
      if ((bool1) && (bool2)) {
        return 4;
      }
      if (bool1) {
        return 3;
      }
      i = j;
    } while (!bool2);
    return 2;
  }
  
  public static void setContentMimeTypes(@NonNull EditorInfo paramEditorInfo, @Nullable String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 25)
    {
      paramEditorInfo.contentMimeTypes = paramArrayOfString;
      return;
    }
    if (paramEditorInfo.extras == null) {
      paramEditorInfo.extras = new Bundle();
    }
    paramEditorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", paramArrayOfString);
    paramEditorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.view.inputmethod.EditorInfoCompat
 * JD-Core Version:    0.7.0.1
 */