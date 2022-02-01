package androidx.activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

public abstract interface OnBackPressedDispatcherOwner
  extends LifecycleOwner
{
  @NonNull
  public abstract OnBackPressedDispatcher getOnBackPressedDispatcher();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.activity.OnBackPressedDispatcherOwner
 * JD-Core Version:    0.7.0.1
 */