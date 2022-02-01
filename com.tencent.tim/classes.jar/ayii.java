import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public abstract interface ayii
{
  public abstract Intent a(ayqb paramayqb);
  
  public abstract void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3);
  
  public abstract void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong);
  
  public abstract void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener);
  
  public abstract void bpm();
  
  @Nullable
  public abstract Activity getActivity();
  
  @NonNull
  public abstract Context getContext();
  
  @NonNull
  public abstract View getRootView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayii
 * JD-Core Version:    0.7.0.1
 */