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
    double d = paramInt2;
    Double.isNaN(d);
    this.real_width = ((int)(d * 0.6D));
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
      long l1 = System.currentTimeMillis();
      Object localObject1 = new int[2];
      Object localObject2 = this.outImg;
      Object localObject3 = this.raw_data;
      int i = this.width;
      int j = this.height;
      int k = this.real_width;
      ImgProcessScan.a((byte[])localObject2, (int[])localObject1, (byte[])localObject3, i, j, (i - k) / 2, (j - k) / 2, k, k, 0, 0);
      localObject1 = this.outImg;
      localObject2 = this.inImg;
      j = localObject2.length;
      i = 0;
      System.arraycopy(localObject1, 0, localObject2, 0, j);
      localObject1 = this.inImg;
      j = this.real_width;
      j = QbarNative.ScanImage((byte[])localObject1, j, j, 0);
      long l2 = System.currentTimeMillis();
      double d1 = 1L;
      double d2 = 0.0D;
      Double.isNaN(d1);
      double d3 = l2 - l1;
      Double.isNaN(d3);
      double d4 = 2L;
      Double.isNaN(d4);
      d1 = (d1 * 0.0D + d3) / d4;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("average detect time:");
      ((StringBuilder)localObject1).append(d1);
      Log.v("TAG", ((StringBuilder)localObject1).toString());
      if (j != 1)
      {
        d3 = 0.0D;
        d2 = d1;
        d1 = d3;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("average target time:");
      ((StringBuilder)localObject1).append(d1);
      Log.v("TAG", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("average no target time:");
      ((StringBuilder)localObject1).append(d2);
      Log.v("TAG", ((StringBuilder)localObject1).toString());
      if (j == 1)
      {
        localObject1 = new Point[10];
        while (i < localObject1.length)
        {
          localObject1[i] = new Point();
          i += 1;
        }
        localObject2 = new StringBuilder();
        localObject3 = new StringBuilder();
        QbarNative.GetOneResult((StringBuilder)localObject2, (StringBuilder)localObject3, (Point[])localObject1);
        this.bundle.putString("dataType", ((StringBuilder)localObject2).toString());
        this.bundle.putString("dataInfo", ((StringBuilder)localObject3).toString());
        sendMsg(j, this.bundle);
        return;
      }
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