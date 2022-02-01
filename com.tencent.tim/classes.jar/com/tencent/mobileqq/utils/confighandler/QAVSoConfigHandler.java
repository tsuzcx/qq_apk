package com.tencent.mobileqq.utils.confighandler;

import acfp;
import com.tencent.av.so.DownloadInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import iwe;

public class QAVSoConfigHandler
  extends ConfigHandler<DownloadInfo>
{
  public QAVSoConfigHandler()
  {
    super("QavSo", null);
  }
  
  public int getConfigVer()
  {
    if (AudioHelper.isDev()) {
      throw new IllegalArgumentException(this.TAG + acfp.m(2131710359));
    }
    return 0;
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, DownloadInfo paramDownloadInfo)
  {
    iwe.a(paramQQAppInterface, paramString, paramDownloadInfo);
  }
  
  public void saveConfig(String paramString, int paramInt)
  {
    if (AudioHelper.isDev()) {
      throw new IllegalArgumentException(this.TAG + acfp.m(2131710358));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVSoConfigHandler
 * JD-Core Version:    0.7.0.1
 */