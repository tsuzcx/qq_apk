package com.tencent.open.adapter;

import asab;
import asad;
import com.tencent.open.downloadnew.common.NoticeParam;

final class OpenAppClient$1
  implements Runnable
{
  OpenAppClient$1(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt) {}
  
  public void run()
  {
    NoticeParam localNoticeParam = new NoticeParam();
    localNoticeParam.appId = this.val$appid;
    localNoticeParam.title = this.bvj;
    localNoticeParam.packName = this.val$packageName;
    localNoticeParam.nKey = this.cBi;
    localNoticeParam.content = "";
    localNoticeParam.cDW = this.val$downloadUrl;
    localNoticeParam.noticeType = 4;
    localNoticeParam.as = asad.a(this.cBj, this.SO, this.bET);
    asab.a().a(localNoticeParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient.1
 * JD-Core Version:    0.7.0.1
 */