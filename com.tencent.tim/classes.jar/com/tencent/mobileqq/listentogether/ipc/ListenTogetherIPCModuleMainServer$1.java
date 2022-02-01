package com.tencent.mobileqq.listentogether.ipc;

import aiov;
import alep;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.music.SongInfo;

public class ListenTogetherIPCModuleMainServer$1
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$1(aiov paramaiov, String paramString1, String paramString2) {}
  
  public void run()
  {
    alep localalep = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localalep != null)
    {
      localalep.Od(this.val$uin);
      if ((!localalep.atv()) && (!TextUtils.isEmpty(this.vf)))
      {
        SongInfo localSongInfo = new SongInfo();
        localSongInfo.coverUrl = this.vf;
        localalep.h(localSongInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.1
 * JD-Core Version:    0.7.0.1
 */