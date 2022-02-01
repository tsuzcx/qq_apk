package oicq.wlogin_sdk.quicklogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import oicq.wlogin_sdk.tools.util;

public class QuickLoginWebViewActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QuickLoginWebViewLoader.load(this, getIntent());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      util.LOGI("device back button clicked", "");
      finish();
      if ((QuickLoginWebViewLoader.finishAnimEnter != 0) || (QuickLoginWebViewLoader.finishAnimExit != 0)) {
        overridePendingTransition(QuickLoginWebViewLoader.finishAnimEnter, QuickLoginWebViewLoader.finishAnimExit);
      }
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() != 16908332) {
      return super.onOptionsItemSelected(paramMenuItem);
    }
    util.LOGI("onOptionsItemSelected clicked", "");
    finish();
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.quicklogin.QuickLoginWebViewActivity
 * JD-Core Version:    0.7.0.1
 */