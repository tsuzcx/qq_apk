import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

public abstract interface qwf
{
  public abstract void a(Bundle paramBundle1, Bundle paramBundle2);
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onAttach(@NonNull Activity paramActivity);
  
  public abstract void onDestroy();
  
  public abstract void onDetach();
  
  public abstract void onPause();
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwf
 * JD-Core Version:    0.7.0.1
 */