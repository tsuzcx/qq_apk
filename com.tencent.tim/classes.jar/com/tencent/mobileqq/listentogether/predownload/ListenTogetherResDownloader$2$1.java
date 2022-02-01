package com.tencent.mobileqq.listentogether.predownload;

import aipz;
import aiqb;
import anpc;
import aomh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import java.util.HashMap;

public class ListenTogetherResDownloader$2$1
  implements Runnable
{
  public ListenTogetherResDownloader$2$1(aiqb paramaiqb, aomh paramaomh, boolean paramBoolean, MusicInfo paramMusicInfo) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", String.valueOf(this.b.mErrCode));
    localHashMap.put("result", String.valueOf(this.b.mResult));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "listen_together_download_quality", this.val$success, 0L, 0L, localHashMap, "", false);
    ((ListenTogetherManager)aipz.a(this.jdField_a_of_type_Aiqb.a).getManager(331)).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataMusicInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1
 * JD-Core Version:    0.7.0.1
 */