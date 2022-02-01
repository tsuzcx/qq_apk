package com.tencent.qqmail.utilities.screenshot;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.util.Pair;

public class ScreenshotMediaWatcher
  implements Handler.Callback, ScreenshotWatcher
{
  private static final Uri EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
  private static final String[] PROJECTION = { "_id", "_data" };
  private static final String SELECTION = "_display_name like 'Screenshot%'";
  private static final String SORT_ORDER = "date_added desc limit 1";
  protected static final String TAG = ScreenshotMediaWatcher.class.getSimpleName();
  private static final int WHAT_CHANGED = 1;
  private static final int WHAT_INIT = 0;
  private static final int WHAT_NOTIFY = 2;
  private ContentObserver mContentObserver;
  private Context mContext;
  private HandlerThread mHandlerThread;
  private boolean mIsWatching;
  private volatile long mLatestScreenshotId;
  private Handler mMainHandler;
  private Handler mQueryHandler;
  private ScreenshotWatcher.ScreenshotCallback mScreenshotCallback;
  
  public ScreenshotMediaWatcher(Context paramContext, ScreenshotWatcher.ScreenshotCallback paramScreenshotCallback)
  {
    Log.i(TAG, "New a ScreenshotMediaWatcher");
    this.mContext = paramContext;
    this.mScreenshotCallback = paramScreenshotCallback;
    this.mMainHandler = new Handler(Looper.getMainLooper(), this);
    this.mContentObserver = new MediaObserver(this.mMainHandler);
    this.mHandlerThread = new HandlerThread("ScreenshotMediaWatcher", 10);
    this.mHandlerThread.start();
    this.mQueryHandler = new Handler(this.mHandlerThread.getLooper(), this);
    this.mQueryHandler.sendEmptyMessage(0);
    Log.i(TAG, "sendEmptyMessage(WHAT_INIT)");
  }
  
  /* Error */
  private Pair<Long, String> queryLatestScreenshot()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/tencent/qqmail/utilities/screenshot/ScreenshotMediaWatcher:mContext	Landroid/content/Context;
    //   4: invokevirtual 138	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: getstatic 52	com/tencent/qqmail/utilities/screenshot/ScreenshotMediaWatcher:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   10: getstatic 60	com/tencent/qqmail/utilities/screenshot/ScreenshotMediaWatcher:PROJECTION	[Ljava/lang/String;
    //   13: ldc 19
    //   15: aconst_null
    //   16: ldc 22
    //   18: invokestatic 144	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +112 -> 135
    //   26: aload_1
    //   27: astore_2
    //   28: aload_1
    //   29: invokeinterface 150 1 0
    //   34: ifeq +101 -> 135
    //   37: aload_1
    //   38: astore_2
    //   39: new 152	android/util/Pair
    //   42: dup
    //   43: aload_1
    //   44: iconst_0
    //   45: invokeinterface 156 2 0
    //   50: invokestatic 162	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   53: aload_1
    //   54: iconst_1
    //   55: invokeinterface 166 2 0
    //   60: invokespecial 169	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   63: astore_3
    //   64: aload_3
    //   65: astore_2
    //   66: aload_1
    //   67: ifnull +9 -> 76
    //   70: aload_1
    //   71: invokeinterface 172 1 0
    //   76: aload_2
    //   77: areturn
    //   78: astore_3
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: astore_2
    //   83: aload_3
    //   84: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   87: aload_1
    //   88: astore_2
    //   89: getstatic 68	com/tencent/qqmail/utilities/screenshot/ScreenshotMediaWatcher:TAG	Ljava/lang/String;
    //   92: ldc 177
    //   94: invokestatic 180	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   97: pop
    //   98: aload_1
    //   99: ifnull +34 -> 133
    //   102: aload_1
    //   103: invokeinterface 172 1 0
    //   108: aconst_null
    //   109: areturn
    //   110: astore_1
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_2
    //   114: ifnull +9 -> 123
    //   117: aload_2
    //   118: invokeinterface 172 1 0
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: goto -13 -> 113
    //   129: astore_3
    //   130: goto -49 -> 81
    //   133: aconst_null
    //   134: areturn
    //   135: aconst_null
    //   136: astore_2
    //   137: goto -71 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	ScreenshotMediaWatcher
    //   21	82	1	localCursor	android.database.Cursor
    //   110	14	1	localObject1	Object
    //   125	1	1	localObject2	Object
    //   27	110	2	localObject3	Object
    //   63	2	3	localPair	Pair
    //   78	6	3	localException1	java.lang.Exception
    //   129	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	78	java/lang/Exception
    //   0	22	110	finally
    //   28	37	125	finally
    //   39	64	125	finally
    //   83	87	125	finally
    //   89	98	125	finally
    //   28	37	129	java/lang/Exception
    //   39	64	129	java/lang/Exception
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Log.d(TAG, "handleMessage E, what: " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      paramMessage = queryLatestScreenshot();
      if (paramMessage != null) {
        this.mLatestScreenshotId = ((Long)paramMessage.first).longValue();
      }
      return true;
    case 1: 
      paramMessage = queryLatestScreenshot();
      if ((paramMessage != null) && (((Long)paramMessage.first).longValue() > this.mLatestScreenshotId))
      {
        this.mLatestScreenshotId = ((Long)paramMessage.first).longValue();
        this.mMainHandler.obtainMessage(2, paramMessage.second).sendToTarget();
      }
      return true;
    }
    paramMessage = (String)paramMessage.obj;
    try
    {
      this.mScreenshotCallback.onScreenshot();
      return true;
    }
    catch (RemoteException paramMessage)
    {
      for (;;)
      {
        paramMessage.printStackTrace();
      }
    }
  }
  
  public boolean isWatching()
  {
    return this.mIsWatching;
  }
  
  public void release()
  {
    if (this.mHandlerThread != null)
    {
      Log.i(TAG, "Release a ScreenshotMediaWatcher");
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
  }
  
  public void startWatching()
  {
    if (this.mScreenshotCallback != null)
    {
      this.mContext.getContentResolver().registerContentObserver(EXTERNAL_CONTENT_URI, true, this.mContentObserver);
      this.mIsWatching = true;
    }
  }
  
  public void stopWatching()
  {
    this.mContext.getContentResolver().unregisterContentObserver(this.mContentObserver);
    this.mIsWatching = false;
  }
  
  class MediaObserver
    extends ContentObserver
  {
    public MediaObserver(Handler paramHandler)
    {
      super();
    }
    
    public void onChange(boolean paramBoolean)
    {
      super.onChange(paramBoolean);
      Log.i(ScreenshotMediaWatcher.TAG, "==onChange ");
      ScreenshotMediaWatcher.this.mQueryHandler.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.screenshot.ScreenshotMediaWatcher
 * JD-Core Version:    0.7.0.1
 */