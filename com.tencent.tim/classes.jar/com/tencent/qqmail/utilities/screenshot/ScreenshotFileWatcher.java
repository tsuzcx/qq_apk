package com.tencent.qqmail.utilities.screenshot;

import android.os.Environment;
import android.os.FileObserver;
import android.util.Log;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.util.ArrayList;

public class ScreenshotFileWatcher
  implements ScreenshotWatcher
{
  public static final String NORMAL;
  private static final String TAG = ScreenshotFileWatcher.class.getSimpleName();
  public static final String VIVO = Environment.getExternalStorageDirectory() + File.separator + "截屏";
  public static final String XIAOMI;
  private boolean isWatching = false;
  private ScreenshotWatcher.ScreenshotCallback mListener;
  private MFileObserver observer;
  private ArrayList<MFileObserver> observerList = new ArrayList();
  
  static
  {
    NORMAL = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator;
    XIAOMI = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Screenshots" + File.separator;
  }
  
  public ScreenshotFileWatcher(ScreenshotWatcher.ScreenshotCallback paramScreenshotCallback)
  {
    this.mListener = paramScreenshotCallback;
    this.observerList.add(new MFileObserver(ScreenShotPathHelper.getScreenShotPath(), this.mListener));
  }
  
  public boolean isWatching()
  {
    return this.isWatching;
  }
  
  public void release() {}
  
  public void startWatching()
  {
    int i = 0;
    while (i < this.observerList.size())
    {
      ((MFileObserver)this.observerList.get(i)).startWatching();
      i += 1;
    }
    this.isWatching = true;
  }
  
  public void stopWatching()
  {
    int i = 0;
    while (i < this.observerList.size())
    {
      ((MFileObserver)this.observerList.get(i)).stopWatching();
      i += 1;
    }
    this.isWatching = false;
  }
  
  static final class MFileObserver
    extends FileObserver
  {
    private final String TAG = MFileObserver.class.getSimpleName();
    private String lastObservePath;
    private ScreenshotWatcher.ScreenshotCallback mObserver;
    private String observeDir;
    
    public MFileObserver(String paramString, ScreenshotWatcher.ScreenshotCallback paramScreenshotCallback)
    {
      super(256);
      this.observeDir = paramString;
      this.mObserver = paramScreenshotCallback;
    }
    
    public void onEvent(int paramInt, String paramString)
    {
      Log.i(this.TAG, "screenshot happens:" + paramInt + "\t" + paramString);
      Log.i(this.TAG, "onEvent Thread" + Thread.currentThread().getName());
      if ((paramString == null) || (paramInt != 256))
      {
        Log.i(this.TAG, "Don't care.");
        return;
      }
      if ((this.lastObservePath != null) && (paramString.equalsIgnoreCase(this.lastObservePath)))
      {
        Log.i(this.TAG, "This event has been observed before.");
        return;
      }
      this.lastObservePath = paramString;
      new File(this.observeDir + paramString);
      Threads.runOnMainThread(new ScreenshotFileWatcher.MFileObserver.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.screenshot.ScreenshotFileWatcher
 * JD-Core Version:    0.7.0.1
 */