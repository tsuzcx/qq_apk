package com.tencent.mobileqq.apollo.process.chanel;

import abmt;
import abnq;
import abvq;
import abxi;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$14
  implements Runnable
{
  public CmGameAvHandler$14(abnq paramabnq, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + abxi.bjs + ", ApolloConstant.sGameAVSoMd5=" + abxi.bjt);
    abvq.a().a(this.this$0.a);
    abvq.a().B(0, abxi.bjs, abxi.bjt);
    abvq.a().j(BaseApplicationImpl.getContext(), abmt.getAppInterface().getCurrentAccountUin(), "" + this.cqk, "" + this.cql);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14
 * JD-Core Version:    0.7.0.1
 */