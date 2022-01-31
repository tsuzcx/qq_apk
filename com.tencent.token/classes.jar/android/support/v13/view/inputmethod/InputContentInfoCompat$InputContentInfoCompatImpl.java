package android.support.v13.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

abstract interface InputContentInfoCompat$InputContentInfoCompatImpl
{
  @NonNull
  public abstract Uri getContentUri();
  
  @NonNull
  public abstract ClipDescription getDescription();
  
  @Nullable
  public abstract Object getInputContentInfo();
  
  @Nullable
  public abstract Uri getLinkUri();
  
  public abstract void releasePermission();
  
  public abstract void requestPermission();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v13.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
 * JD-Core Version:    0.7.0.1
 */