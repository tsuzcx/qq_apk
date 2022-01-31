package android.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
abstract class BaseFragmentActivityApi16
  extends BaseFragmentActivityApi14
{
  boolean mStartedActivityFromFragment;
  
  @RequiresApi(16)
  public void startActivityForResult(Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if ((!this.mStartedActivityFromFragment) && (paramInt != -1)) {
      checkForValidRequestCode(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  @RequiresApi(16)
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if ((!this.mStartedIntentSenderFromFragment) && (paramInt1 != -1)) {
      checkForValidRequestCode(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.BaseFragmentActivityApi16
 * JD-Core Version:    0.7.0.1
 */