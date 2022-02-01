package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.AppInterface;
import mfk;
import mfn;
import mfo;
import mfq;
import mfs;
import mgf;
import mgh;

public class ReadInjoySkinAndRefreshFacade$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$1(mgf parammgf) {}
  
  public void run()
  {
    Object localObject = (mfo)this.this$0.mApp.getManager(270);
    int i = mgf.a(this.this$0);
    RefreshData localRefreshData = ((mfo)localObject).a(this.this$0.mApp.getApp(), i);
    int j = (int)(System.currentTimeMillis() / 1000L);
    boolean bool;
    mfs localmfs;
    SkinData localSkinData;
    if ((localRefreshData != null) && (localRefreshData.isShowInSource(mgf.a(this.this$0))) && (j >= localRefreshData.beginTime) && (j <= localRefreshData.endTime)) {
      if (mgh.dU(localRefreshData.id)) {
        if (localRefreshData.isShown)
        {
          ((mfo)localObject).b(1, localRefreshData.id, localRefreshData.seq, i);
          ((mfo)localObject).nQ(true);
          bool = true;
          localObject = (GuideData)((mfn)this.this$0.mApp.getManager(271)).a("operation_guide");
          localmfs = (mfs)this.this$0.mApp.getManager(261);
          localSkinData = localmfs.a(this.this$0.mApp.getApp());
          if ((localSkinData == null) || (j < localSkinData.beginTime) || (j > localSkinData.endTime)) {
            break label361;
          }
          if (!mfk.dS(localSkinData.id)) {
            break label341;
          }
          localmfs.e(1, localSkinData.id, bool);
        }
      }
    }
    for (;;)
    {
      ((mfq)this.this$0.mApp.getBusinessHandler(121)).a(localSkinData, null, localRefreshData, (GuideData)localObject, mgf.a(this.this$0));
      return;
      ((mfo)localObject).b(0, "", -1L, i);
      bool = false;
      break;
      ((mfo)localObject).b(0, "", -1L, i);
      ((mfo)localObject).a(localRefreshData, mgf.a(this.this$0));
      bool = false;
      break;
      ((mfo)localObject).b(0, "", -1L, i);
      bool = false;
      break;
      label341:
      localmfs.e(0, "", bool);
      localmfs.a(localSkinData);
      continue;
      label361:
      localmfs.e(0, "", bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1
 * JD-Core Version:    0.7.0.1
 */