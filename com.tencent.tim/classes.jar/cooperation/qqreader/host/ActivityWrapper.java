package cooperation.qqreader.host;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Window;
import avod;

public class ActivityWrapper
{
  private Activity mActivity;
  
  public ActivityWrapper(Context paramContext)
  {
    this.mActivity = avod.getActivity(paramContext);
  }
  
  public void finish()
  {
    if (this.mActivity != null) {
      this.mActivity.finish();
    }
  }
  
  public Context getContext()
  {
    return this.mActivity;
  }
  
  public Window getWindow()
  {
    if (this.mActivity != null) {
      return this.mActivity.getWindow();
    }
    return null;
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (this.mActivity != null) {
      this.mActivity.startActivity(paramIntent);
    }
  }
  
  @RequiresApi(api=16)
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    if (this.mActivity != null) {
      this.mActivity.startActivity(paramIntent, paramBundle);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.mActivity != null) {
      this.mActivity.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  @RequiresApi(api=16)
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (this.mActivity != null) {
      this.mActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.ActivityWrapper
 * JD-Core Version:    0.7.0.1
 */