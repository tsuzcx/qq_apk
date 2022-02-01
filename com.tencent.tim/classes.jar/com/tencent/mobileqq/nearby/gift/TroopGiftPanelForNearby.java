package com.tencent.mobileqq.nearby.gift;

import ajpd;
import ajua;
import android.content.Context;
import apsz;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.f;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import java.lang.ref.WeakReference;
import sne;

public class TroopGiftPanelForNearby
  extends TroopGiftPanel
{
  protected boolean cqh;
  protected boolean cqi;
  protected WeakReference<QQAppInterface> mAppRef;
  
  public TroopGiftPanelForNearby(QQAppInterface paramQQAppInterface, Context paramContext, TroopGiftPanel.f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramf, false);
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.aFd = "OidbSvc.0x7f8";
    this.byp = 2040;
    this.cqh = paramBoolean1;
    this.cqi = paramBoolean3;
    this.aMi = true;
    this.dq = new WeakReference(paramBaseChatPie);
    if (paramBoolean3) {
      this.asi = 8;
    }
    for (;;)
    {
      setBackgroundColor(-1);
      return;
      if (this.cqh) {
        this.asi = 6;
      } else if (paramBoolean2) {
        this.asi = 5;
      } else {
        this.asi = 4;
      }
    }
  }
  
  public void bzE()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.mAppRef.get();
    if (localQQAppInterface == null) {}
    label78:
    label90:
    for (;;)
    {
      return;
      Object localObject = (HotChatManager)localQQAppInterface.getManager(60);
      if (localObject != null)
      {
        localObject = ((HotChatManager)localObject).a(this.sessionInfo.aTl);
        if (localObject == null) {
          break label78;
        }
        ajpd.a((HotChatInfo)localObject, localQQAppInterface, getActivity(), 0);
      }
      for (;;)
      {
        if (this.a == null) {
          break label90;
        }
        this.a.onHide();
        return;
        localObject = null;
        break;
        tv(this.sessionInfo.aTl);
      }
    }
  }
  
  public void setIsPttRoom(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.asi = 5;
      return;
    }
    this.asi = 4;
  }
  
  public void tv(String paramString)
  {
    Object localObject = (AppInterface)this.n.get();
    if (localObject == null) {
      return;
    }
    localObject = (apsz)((AppInterface)localObject).getManager(113);
    sne localsne = this.c;
    int j = localsne.bxX;
    if (localsne.bxX == 0) {
      j = un();
    }
    int i;
    if (this.cqh)
    {
      i = 4;
      if (!this.cqi) {
        break label176;
      }
      i = 5;
    }
    label176:
    for (;;)
    {
      int m = this.asi;
      String str = nD();
      long l = Long.parseLong(paramString);
      int n = localsne.bxY;
      if (localsne.bxX == 0) {}
      for (int k = 1;; k = 0)
      {
        ((apsz)localObject).a("OidbSvc.0x7f6", 2038, i, m, str, 2, j, l, n, k, localsne.bxW, 0, new ajua(this), localsne.giftId);
        this.c.mSelected = false;
        this.c = null;
        return;
        i = 2;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby
 * JD-Core Version:    0.7.0.1
 */