package com.tencent.qbardemo;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.tencent.imageboost.ImgProcessScan;
import com.tencent.qbar.QbarNative;

public class ProcessThread
  extends Thread
{
  public int[] Pixels;
  public Bundle bundle;
  public byte[] bytes;
  public Context context;
  public byte[] data;
  private int height;
  public byte[] inImg;
  public byte[] outImg;
  private String path;
  public byte[] raw_data;
  public int real_width;
  private boolean save = true;
  public int[] sizeArr;
  public byte[] type;
  public Handler uiHandler;
  private int width;
  
  public ProcessThread(Handler paramHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, String paramString)
  {
    this.uiHandler = paramHandler;
    this.width = paramInt1;
    this.height = paramInt2;
    this.raw_data = paramArrayOfByte1;
    this.outImg = paramArrayOfByte2;
    this.inImg = paramArrayOfByte3;
    this.bundle = new Bundle();
    this.path = paramString;
    this.real_width = ((int)(paramInt2 * 0.6D));
    this.type = new byte[3000];
    this.data = new byte[3000];
    this.sizeArr = new int[2];
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public void run()
  {
    try
    {
      Process.setThreadPriority(-20);
      label5:
      Log.v("TAG", "detect start");
      long l = System.currentTimeMillis();
      Object localObject = new int[2];
      ImgProcessScan.a(this.outImg, (int[])localObject, this.raw_data, this.width, this.height, (this.width - this.real_width) / 2, (this.height - this.real_width) / 2, this.real_width, this.real_width);
      System.arraycopy(this.outImg, 0, this.inImg, 0, this.inImg.length);
      int j = QbarNative.ScanImage(this.inImg, this.real_width, this.real_width, 0);
      double d1 = (System.currentTimeMillis() - l + 0.0D) / 2.0D;
      Log.v("TAG", "average detect time:" + d1);
      double d2;
      if (j == 1) {
        d2 = 0.0D;
      }
      for (;;)
      {
        Log.v("TAG", "average target time:" + d1);
        Log.v("TAG", "average no target time:" + d2);
        if (j != 1) {
          break label331;
        }
        localObject = new Point[10];
        int i = 0;
        while (i < localObject.length)
        {
          localObject[i] = new Point();
          i += 1;
        }
        d2 = d1;
        d1 = 0.0D;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      QbarNative.GetOneResult(localStringBuilder1, localStringBuilder2, (Point[])localObject);
      this.bundle.putString("dataType", localStringBuilder1.toString());
      this.bundle.putString("dataInfo", localStringBuilder2.toString());
      System.currentTimeMillis();
      sendMsg(j, this.bundle);
      return;
      label331:
      System.currentTimeMillis();
      sendMsg(j);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      break label5;
    }
  }
  
  public void sendMsg(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.arg1 = paramInt;
    this.uiHandler.sendMessage(localMessage);
  }
  
  public void sendMsg(int paramInt, Bundle paramBundle)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.arg1 = paramInt;
    localMessage.setData(paramBundle);
    this.uiHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qbardemo.ProcessThread
 * JD-Core Version:    0.7.0.1
 */