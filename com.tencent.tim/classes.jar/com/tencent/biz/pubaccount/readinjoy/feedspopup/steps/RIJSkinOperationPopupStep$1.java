package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import lcz;
import mfk;
import mfn;
import mfo;
import mfq;
import mfs;
import mgh;

public class RIJSkinOperationPopupStep$1
  implements Runnable
{
  public RIJSkinOperationPopupStep$1(lcz paramlcz) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    mfq localmfq = (mfq)((QQAppInterface)localObject1).getBusinessHandler(121);
    mfs localmfs = (mfs)((QQAppInterface)localObject1).getManager(261);
    Object localObject2 = (mfn)((QQAppInterface)localObject1).getManager(271);
    Object localObject3 = (mfo)((QQAppInterface)localObject1).getManager(270);
    localObject1 = ((mfo)localObject3).a(lcz.a(this.this$0), 0);
    boolean bool1;
    label139:
    boolean bool2;
    label164:
    boolean bool3;
    if (QLog.isColorLevel())
    {
      if (localObject1 == null) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh refreshData = " + localObject1);
      }
    }
    else
    {
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ((localObject1 == null) || (!((RefreshData)localObject1).isShowInSource(0))) {
        break label370;
      }
      bool1 = true;
      if ((localObject1 == null) || (i < ((RefreshData)localObject1).beginTime) || (i > ((RefreshData)localObject1).endTime)) {
        break label375;
      }
      bool2 = true;
      bool3 = false;
      if ((!bool1) || (!bool2)) {
        break label423;
      }
      bool1 = mgh.dU(((RefreshData)localObject1).id);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch = true, timeMatch = true, resValid =" + bool1);
      }
      if (!bool1) {
        break label397;
      }
      if (!((RefreshData)localObject1).isShown) {
        break label380;
      }
      ((mfo)localObject3).b(1, ((RefreshData)localObject1).id, ((RefreshData)localObject1).seq, 0);
      ((mfo)localObject3).nQ(true);
      bool1 = true;
      label252:
      localObject2 = (GuideData)((mfn)localObject2).a("operation_guide");
      localObject3 = localmfs.a(lcz.a(this.this$0));
      if ((localObject3 == null) || (i < ((SkinData)localObject3).beginTime) || (i > ((SkinData)localObject3).endTime)) {
        break label501;
      }
      if (!mfk.dS(((SkinData)localObject3).id)) {
        break label481;
      }
      localmfs.e(1, ((SkinData)localObject3).id, bool1);
    }
    for (;;)
    {
      localmfq.a((SkinData)localObject3, null, (RefreshData)localObject1, (GuideData)localObject2, 0);
      return;
      QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh refreshData = " + ((RefreshData)localObject1).toString());
      break;
      label370:
      bool1 = false;
      break label139;
      label375:
      bool2 = false;
      break label164;
      label380:
      ((mfo)localObject3).b(0, "", -1L, 0);
      bool1 = false;
      break label252;
      label397:
      ((mfo)localObject3).b(0, "", -1L, 0);
      ((mfo)localObject3).a((RefreshData)localObject1, 0);
      bool1 = false;
      break label252;
      label423:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch =" + bool1 + ",timeMatch = " + bool2);
      }
      ((mfo)localObject3).b(0, "", -1L, 0);
      bool1 = bool3;
      break label252;
      label481:
      localmfs.e(0, "", bool1);
      localmfs.a((SkinData)localObject3);
      continue;
      label501:
      localmfs.e(0, "", bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.1
 * JD-Core Version:    0.7.0.1
 */