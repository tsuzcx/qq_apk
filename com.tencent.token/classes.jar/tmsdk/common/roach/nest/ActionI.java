package tmsdk.common.roach.nest;

import android.os.Bundle;
import btmsdkobf.bq;

public abstract class ActionI
{
  public static final String privDirKey = "privDirKey";
  
  public abstract void clean();
  
  public void finish()
  {
    onStop();
    bq.Q().a(this);
  }
  
  public abstract void onStart(Bundle paramBundle);
  
  public abstract void onStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.roach.nest.ActionI
 * JD-Core Version:    0.7.0.1
 */