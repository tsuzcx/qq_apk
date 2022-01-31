package com.tencent.kingkong;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.HashMap;

public class UpdateThread
  extends Thread
{
  public static final String LOG_TAG = "KingKongUpdateThread";
  private Handler mHandler = null;
  private Looper mLooper = null;
  private HashMap<String, Integer> patchMap = new HashMap();
  private Runnable task = new Runnable()
  {
    public void run()
    {
      if (!Common.mInterProcessLock.lock()) {
        return;
      }
      Common.Log.d("KingKongUpdateThread", "update task begin");
      if (SelfUpdateInterface.ShouldDoUpdate()) {
        SelfUpdateInterface.DoUpdate();
      }
      if (UpdateManager.ShouldContinueUpdate()) {
        UpdateManager.ContinueUpdate();
      }
      if (UpdateManager.ShouldInstallUpdates()) {
        UpdateManager.InstallUpdates();
      }
      PatchManager.DoPatches(UpdateThread.this.patchMap);
      long l = Common.getMaxUpdateInterval();
      Common.Log.d("KingKongUpdateThread", "update task interval = " + l);
      if (UpdateThread.this.mHandler != null) {
        UpdateThread.this.mHandler.postDelayed(this, l);
      }
      Common.Log.d("KingKongUpdateThread", "update task end");
      Common.mInterProcessLock.unlock();
    }
  };
  
  public void run()
  {
    Looper.prepare();
    this.mHandler = new Handler();
    this.mLooper = Looper.myLooper();
    Common.Log.d("KingKongUpdateThread", "ReportThread " + Process.myTid() + " priority : " + Process.getThreadPriority(Process.myTid()));
    this.mHandler.post(this.task);
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.UpdateThread
 * JD-Core Version:    0.7.0.1
 */