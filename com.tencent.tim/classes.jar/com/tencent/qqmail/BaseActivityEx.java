package com.tencent.qqmail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.Date;

public abstract class BaseActivityEx
  extends BaseActivity
{
  private String TAG = "BaseActivityEx";
  private boolean hasFetchCursor = false;
  private boolean hasRelease = true;
  protected long renderBeginTime;
  
  protected boolean canEnter()
  {
    return true;
  }
  
  public void finish()
  {
    Object localObject = null;
    if (QMActivityManager.shareInstance().getActivitySize() <= 1)
    {
      Intent localIntent = onLastFinish();
      localObject = localIntent;
      if (localIntent != null)
      {
        startActivity(localIntent);
        localObject = localIntent;
      }
    }
    super.finish();
    onOverridePendingTransitionInFinish(localObject);
  }
  
  protected abstract void initDataSource();
  
  protected abstract void initDom();
  
  protected abstract void initUI();
  
  protected boolean isReleased()
  {
    return this.hasRelease;
  }
  
  protected void onBackground() {}
  
  protected abstract void onBindEvent(boolean paramBoolean);
  
  public final void onCreate(Bundle paramBundle)
  {
    long l = new Date().getTime();
    super.onCreate(paramBundle);
    if (!canEnter())
    {
      finish();
      return;
    }
    this.renderBeginTime = System.currentTimeMillis();
    Log.d("performance", "BaseActivityEx:" + getClass().getSimpleName() + ":canEnter:finish:" + (new Date().getTime() - l) + "ms");
    initUI();
    Log.d("performance", "BaseActivityEx:" + getClass().getSimpleName() + ":initUI:" + (new Date().getTime() - l) + "ms");
    initDataSource();
    Log.d("performance", "BaseActivityEx:" + getClass().getSimpleName() + ":initDataSource:" + (new Date().getTime() - l) + "ms");
    initDom();
    Log.d("performance", "BaseActivityEx:" + getClass().getSimpleName() + ":initDom:" + (new Date().getTime() - l) + "ms");
    this.hasRelease = false;
    Log.d("performance", "BaseActivityEx:" + getClass().getSimpleName() + ":onCreate:" + (new Date().getTime() - l) + "ms");
  }
  
  public void onDestroy()
  {
    if (!this.hasRelease)
    {
      onRelease();
      this.hasRelease = true;
    }
    super.onDestroy();
  }
  
  protected void onFetchCursor() {}
  
  protected void onJustDestroy()
  {
    super.onJustDestroy();
  }
  
  protected Intent onLastFinish()
  {
    return null;
  }
  
  protected void onOverridePendingTransition() {}
  
  protected void onOverridePendingTransitionInFinish(Intent paramIntent) {}
  
  public void onPause()
  {
    onBindEvent(false);
    onBackground();
    super.onPause();
  }
  
  protected abstract void onRelease();
  
  public void onResume()
  {
    long l = new Date().getTime();
    super.onResume();
    onOverridePendingTransition();
    onBindEvent(true);
    if (!this.hasFetchCursor)
    {
      onFetchCursor();
      this.hasFetchCursor = true;
    }
    refreshData();
    Log.d("performance", "BaseActivityEx:" + getClass().getSimpleName() + ":refreshData:" + (new Date().getTime() - l) + "ms");
    render();
    Log.d("performance", "BaseActivityEx:" + getClass().getSimpleName() + ":onResume:" + (new Date().getTime() - l) + "ms");
  }
  
  public final void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  protected abstract void refreshData();
  
  protected abstract void render();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityEx
 * JD-Core Version:    0.7.0.1
 */