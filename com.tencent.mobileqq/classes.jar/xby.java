import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public abstract interface xby
{
  @NonNull
  public abstract Context a();
  
  public abstract Intent a(xlb paramxlb);
  
  @NonNull
  public abstract View a();
  
  public abstract void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3);
  
  public abstract void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong);
  
  public abstract void b();
  
  @Nullable
  public abstract Activity getActivity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xby
 * JD-Core Version:    0.7.0.1
 */