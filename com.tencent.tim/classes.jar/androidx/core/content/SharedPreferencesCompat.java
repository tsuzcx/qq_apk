package androidx.core.content;

import android.content.SharedPreferences.Editor;
import androidx.annotation.NonNull;

@Deprecated
public final class SharedPreferencesCompat
{
  @Deprecated
  public static final class EditorCompat
  {
    private static EditorCompat sInstance;
    private final Helper mHelper = new Helper();
    
    @Deprecated
    public static EditorCompat getInstance()
    {
      if (sInstance == null) {
        sInstance = new EditorCompat();
      }
      return sInstance;
    }
    
    @Deprecated
    public void apply(@NonNull SharedPreferences.Editor paramEditor)
    {
      this.mHelper.apply(paramEditor);
    }
    
    static class Helper
    {
      public void apply(@NonNull SharedPreferences.Editor paramEditor)
      {
        try
        {
          paramEditor.apply();
          return;
        }
        catch (AbstractMethodError localAbstractMethodError)
        {
          paramEditor.commit();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.content.SharedPreferencesCompat
 * JD-Core Version:    0.7.0.1
 */