package com.tencent.mobileqq.ar.ARRenderModel;

import acfp;
import adbn;
import adch;
import adda;
import addg;
import addi;
import aqiw;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$14
  implements Runnable
{
  public ARTransferPromotionRenderable$14(addg paramaddg, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int i = 1;
    if (this.cCO == 1)
    {
      if (this.Is != 0) {
        break label204;
      }
      i = this.this$0.cCI;
      this.this$0.cCI = 0;
      switch (i)
      {
      case 5: 
      case 6: 
      default: 
        addg.e(this.this$0);
      }
    }
    label204:
    int j;
    label342:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (addg.a(this.this$0) != null)
              {
                QLog.d("ARTransferPromotionRenderable", 2, "native_switchGameStatusWithVideoId status " + this.Is);
                addg.a(this.this$0).native_switchGameStatusWithVideoId(i, this.val$result);
              }
              if (i == 7)
              {
                ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.14.1(this));
                QLog.d("ARTransferPromotionRenderable", 2, "GameStatus_USER_DETERMINE_STATUS real start here");
                return;
              }
              if (i != 3) {
                break;
              }
              QLog.d("ARTransferPromotionRenderable", 2, "GameStatus_TRAVERSING_DOOR");
              addg.b(this.this$0, true);
              ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.14.2(this));
              break;
            } while (this.Is != 1);
            addg.e(this.this$0);
            j = this.this$0.cCJ;
            QLog.d("ARTransferPromotionRenderable", 2, "ARPromotionMediaPlayerWrapper.PLAYER_STATUS_END status " + this.this$0.cCJ);
            switch (j)
            {
            case 3: 
            case 6: 
            default: 
              return;
            case 2: 
            case 4: 
            case 7: 
              if ((this.val$result == 0) || (j != 7)) {
                break label342;
              }
            }
          } while (addg.a(this.this$0) == null);
          addg.a(this.this$0).hg(2, this.val$result);
          return;
          addg.a(this.this$0);
          if ((this.val$result == 0) && (j == 7) && (!aqiw.isNetworkAvailable(BaseApplication.getContext())))
          {
            adch.bU(acfp.m(2131702889), false);
            QLog.d("ARTransferPromotionRenderable", 2, "net work is so terrible ,we have to stop it");
            return;
          }
          if ((this.this$0.cCJ != 4) || (addg.a(this.this$0).cBI != 2)) {
            break label439;
          }
        } while (addg.a(this.this$0) == null);
        addg.a(this.this$0).hg(2, 0);
        return;
        if ((this.this$0.cCJ == 4) && (addg.a(this.this$0).cBI == 1)) {
          addg.a(this.this$0).cBI = 0;
        }
        if ((this.this$0.cCJ != 4) || (addg.a(this.this$0).cBI != 0)) {
          break label683;
        }
        if (!addg.a(this.this$0).ud.isEmpty()) {
          break label540;
        }
      } while (addg.a(this.this$0) == null);
      addg.a(this.this$0).hg(2, 0);
      return;
      if (addg.a(this.this$0).iM(1))
      {
        addg.a(this.this$0).FT(true);
        return;
      }
      if (addg.a(this.this$0).iM(2)) {
        addg.a(this.this$0, addg.a(this.this$0).b());
      }
      while (addg.a(this.this$0) == null)
      {
        QLog.d("ARTransferPromotionRenderable", 1, "onMediaPlayerStatusChange deal GameStatus_INSIDE_WORLD_360 error hapen mFixFullScreenVideoUrl is null");
        return;
        if (addg.a(this.this$0).iM(3)) {
          addg.a(this.this$0, addg.a(this.this$0).a());
        }
      }
      QLog.d("ARTransferPromotionRenderable", 1, "onMediaPlayerStatusChange deal GameStatus_INSIDE_WORLD_360 with auto play:" + addg.a(this.this$0));
    } while (this.this$0.cCJ == 5);
    label439:
    if (this.this$0.cCJ == 4) {
      label705:
      if (i == 0) {
        break label738;
      }
    }
    label540:
    label683:
    label738:
    for (i = j + 2; (i > 0) && (i < 14); i = j + 1)
    {
      this.this$0.gN(i);
      return;
      i = 0;
      break label705;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "GameStatus_OUTSIDE_WORLD_360 error happen, not have this status");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14
 * JD-Core Version:    0.7.0.1
 */