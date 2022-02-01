import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public abstract interface aycc
{
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean);
  
  public abstract void finish();
  
  public abstract void lp(int paramInt1, int paramInt2);
  
  public abstract void onActivityPause();
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onActivityResume();
  
  public abstract void onActivityStart();
  
  public abstract void onActivityStop();
  
  public abstract boolean onBackPressed();
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract View onCreateView();
  
  public abstract void onDestroy();
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycc
 * JD-Core Version:    0.7.0.1
 */