package com.tencent.mobileqq.util;

import QQService.CARDSETTYPE;
import SummaryCardTaf.SSummaryCardSetReq;
import SummaryCardTaf.cardDiyComplicatedInfo;
import SummaryCardTaf.cardDiyTextInfo;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ProfileCardUtil$3
  implements Runnable
{
  public ProfileCardUtil$3(int paramInt, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, String paramString3, long paramLong4, String paramString4, String paramString5) {}
  
  public void run()
  {
    UniPacket localUniPacket = null;
    Object localObject = localUniPacket;
    if (this.dYU > 0)
    {
      localObject = localUniPacket;
      if (!TextUtils.isEmpty(this.csx)) {
        localObject = new cardDiyTextInfo(this.dYU, this.csx, this.csy, this.AB, this.AC, this.AD);
      }
    }
    localObject = new SSummaryCardSetReq(2, Long.parseLong(this.val$app.getCurrentAccountUin()), this.asC, "3.4.4", 109L, this.agv, this.rf, this.val$url, this.asD, (cardDiyTextInfo)localObject, this.csz, new cardDiyComplicatedInfo(this.csA));
    localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setFuncName("set");
    localUniPacket.setServantName("MCardSvc");
    localUniPacket.put("req", localObject);
    localObject = localUniPacket.encode();
    ((CardHandler)this.val$app.getBusinessHandler(2)).a(this.val$app.getCurrentAccountUin(), CARDSETTYPE.TYPE_SET_TEMPLATE.value(), (byte)0, null, null, null, null, (byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.3
 * JD-Core Version:    0.7.0.1
 */