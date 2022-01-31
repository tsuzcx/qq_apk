package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageForPic;
import java.util.HashMap;

public class PreDownloadStrategyAlpha
  extends BaseStrategy
{
  public static final String h = "PreDownStragecy";
  public static long m = 1364283891L;
  
  public HashMap a()
  {
    return null;
  }
  
  public void a()
  {
    super.a();
    m = PicPreDownloadUtils.a(this.a, "PreDownPolicy", 1364283891L);
    Logger.a("PIC_TAG_PRELOAD", "", "getServerConfigValue", "maxPreDownPolicy:" + m);
  }
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(MessageForPic paramMessageForPic) {}
  
  public void a(MessageForPic paramMessageForPic, long paramLong) {}
  
  public boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    return super.a(paramLong, paramInt1, paramInt2);
  }
  
  public boolean[] a(int paramInt1, int paramInt2)
  {
    int i = PicPreDownloadUtils.a(paramInt2, paramInt1, 0);
    int j = PicPreDownloadUtils.a(paramInt2, paramInt1, 1);
    boolean bool1;
    if ((m >> i & 1L) == 1L)
    {
      bool1 = true;
      if ((m >> j & 1L) != 1L) {
        break label121;
      }
    }
    label121:
    for (boolean bool2 = true;; bool2 = false)
    {
      Logger.a("PIC_TAG_PRELOAD", "isPreDownload", "netWokrType:" + paramInt2 + ",uinType:" + paramInt1 + ",preDownThumb:" + bool1 + ",preDownBig:" + bool2);
      return new boolean[] { bool1, bool2 };
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PreDownloadStrategyAlpha
 * JD-Core Version:    0.7.0.1
 */