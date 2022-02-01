package com.tencent.mqq.shared_file_accessor.test;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessRecorder
{
  private static final int BUF_LEN = 32768;
  private static final String FILE_LOCATED_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/sp";
  private static final String WRITE_FILE_NAME_BASE = "sp_rw_";
  private static volatile AccessRecorder mInstance = null;
  private Handler mHandler = null;
  private StringBuilder mStringBuilder = new StringBuilder(32768);
  private FileWriter mWriter = null;
  private String mWritingFileName = null;
  private HandlerThread mWritingThread = null;
  
  @SuppressLint({"SimpleDateFormat"})
  private AccessRecorder()
  {
    this.mWritingThread.start();
    this.mHandler = new PrivateHandler(this.mWritingThread.getLooper());
    Object localObject = new Date();
    localObject = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format((Date)localObject);
    this.mWritingFileName = ("sp_rw_" + (String)localObject);
    try
    {
      localObject = new File(FILE_LOCATED_DIR);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      this.mWriter = new FileWriter(FILE_LOCATED_DIR + "/" + this.mWritingFileName + ".csv");
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static AccessRecorder getInstance()
  {
    if (mInstance != null) {
      return mInstance;
    }
    try
    {
      if (mInstance == null) {
        mInstance = new AccessRecorder();
      }
      AccessRecorder localAccessRecorder = mInstance;
      return localAccessRecorder;
    }
    finally {}
  }
  
  /* Error */
  public void log(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: arraylength
    //   6: istore_3
    //   7: iload_2
    //   8: iload_3
    //   9: iconst_1
    //   10: isub
    //   11: if_icmpge +26 -> 37
    //   14: aload_0
    //   15: getfield 70	com/tencent/mqq/shared_file_accessor/test/AccessRecorder:mStringBuilder	Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: iload_2
    //   20: aaload
    //   21: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: bipush 9
    //   26: invokevirtual 140	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: iload_2
    //   31: iconst_1
    //   32: iadd
    //   33: istore_2
    //   34: goto -27 -> 7
    //   37: aload_0
    //   38: getfield 70	com/tencent/mqq/shared_file_accessor/test/AccessRecorder:mStringBuilder	Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: aload_1
    //   43: arraylength
    //   44: iconst_1
    //   45: isub
    //   46: aaload
    //   47: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: bipush 10
    //   52: invokevirtual 140	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_0
    //   57: getfield 70	com/tencent/mqq/shared_file_accessor/test/AccessRecorder:mStringBuilder	Ljava/lang/StringBuilder;
    //   60: invokevirtual 144	java/lang/StringBuilder:length	()I
    //   63: ldc 10
    //   65: if_icmple +58 -> 123
    //   68: aload_0
    //   69: getfield 70	com/tencent/mqq/shared_file_accessor/test/AccessRecorder:mStringBuilder	Ljava/lang/StringBuilder;
    //   72: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 74	com/tencent/mqq/shared_file_accessor/test/AccessRecorder:mHandler	Landroid/os/Handler;
    //   80: iconst_1
    //   81: invokevirtual 150	android/os/Handler:hasMessages	(I)Z
    //   84: ifeq +11 -> 95
    //   87: aload_0
    //   88: getfield 74	com/tencent/mqq/shared_file_accessor/test/AccessRecorder:mHandler	Landroid/os/Handler;
    //   91: iconst_1
    //   92: invokevirtual 153	android/os/Handler:removeMessages	(I)V
    //   95: aload_0
    //   96: getfield 74	com/tencent/mqq/shared_file_accessor/test/AccessRecorder:mHandler	Landroid/os/Handler;
    //   99: aload_0
    //   100: getfield 74	com/tencent/mqq/shared_file_accessor/test/AccessRecorder:mHandler	Landroid/os/Handler;
    //   103: iconst_0
    //   104: aload_1
    //   105: invokestatic 159	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   108: invokevirtual 163	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   111: pop
    //   112: aload_0
    //   113: getfield 70	com/tencent/mqq/shared_file_accessor/test/AccessRecorder:mStringBuilder	Ljava/lang/StringBuilder;
    //   116: iconst_0
    //   117: invokevirtual 166	java/lang/StringBuilder:setLength	(I)V
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: aload_0
    //   124: getfield 74	com/tencent/mqq/shared_file_accessor/test/AccessRecorder:mHandler	Landroid/os/Handler;
    //   127: iconst_1
    //   128: invokevirtual 150	android/os/Handler:hasMessages	(I)Z
    //   131: ifne -11 -> 120
    //   134: aload_0
    //   135: getfield 74	com/tencent/mqq/shared_file_accessor/test/AccessRecorder:mHandler	Landroid/os/Handler;
    //   138: iconst_1
    //   139: ldc2_w 167
    //   142: invokevirtual 172	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   145: pop
    //   146: goto -26 -> 120
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	AccessRecorder
    //   0	154	1	paramArrayOfString	String[]
    //   1	33	2	i	int
    //   6	5	3	j	int
    // Exception table:
    //   from	to	target	type
    //   4	7	149	finally
    //   14	30	149	finally
    //   37	95	149	finally
    //   95	120	149	finally
    //   123	146	149	finally
  }
  
  class PrivateHandler
    extends Handler
  {
    public static final int MSG_FLUSH_AFTER_LONG_TIME = 1;
    public static final int MSG_WRITE = 0;
    
    public PrivateHandler(Looper paramLooper)
    {
      super();
    }
    
    private void write(String paramString)
    {
      if (AccessRecorder.this.mWriter == null) {
        return;
      }
      try
      {
        AccessRecorder.this.mWriter.write(paramString);
        AccessRecorder.this.mWriter.flush();
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    public void handleMessage(Message arg1)
    {
      switch (???.what)
      {
      default: 
        return;
      case 0: 
        write((String)???.obj);
        return;
      }
      synchronized (AccessRecorder.this)
      {
        sendMessage(Message.obtain(this, 0, AccessRecorder.this.mStringBuilder.toString()));
        AccessRecorder.this.mStringBuilder.setLength(0);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.test.AccessRecorder
 * JD-Core Version:    0.7.0.1
 */