package com.tencent.mobileqq.ark.API;

import adnq.c;
import adqa;
import adqr;
import adqu;
import adrl;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import aqha;
import aqjn.a;
import aqju;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import wyw;

public class ArkAppModuleReg$ModuleQQ$10
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$10(adnq.c paramc, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public void run()
  {
    Object localObject1;
    if (this.val$type.equals("fullscreen"))
    {
      adqu.a(null, this.this$0.mAppName, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
      if ((BaseActivity.sTopActivity instanceof FragmentActivity))
      {
        localObject1 = (FragmentActivity)BaseActivity.sTopActivity;
        adqu.a(null, this.this$0.mAppName, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        ArkFullScreenAppActivity.a((Context)localObject1, this.this$0.mAppID, this.val$view, "0.0.0.1", this.aWN, adqr.getDensity(), null, 0);
      }
    }
    do
    {
      do
      {
        do
        {
          Object localObject3;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!this.val$type.equals("input")) {
                    break;
                  }
                } while (!(BaseActivity.sTopActivity instanceof FragmentActivity));
                localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
              } while (localObject1 == null);
              localObject1 = ((ChatFragment)localObject1).a();
            } while ((localObject1 == null) || (((BaseChatPie)localObject1).a == null));
            localObject2 = new ArrayList();
            localObject3 = new adqa();
            ((adqa)localObject3).appName = this.this$0.mAppID;
            ((adqa)localObject3).appPath = this.this$0.mAppPath;
            ((adqa)localObject3).meta = this.aWN;
            ((adqa)localObject3).appView = this.val$view;
            ((List)localObject2).add(localObject3);
            ((BaseChatPie)localObject1).a.R((List)localObject2, 0);
            return;
            if (!this.val$type.equals("popup")) {
              break;
            }
            localObject1 = BaseActivity.sTopActivity;
          } while (!(localObject1 instanceof FragmentActivity));
          Object localObject2 = aqjn.a.a(this.this$0.mAppID, this.val$view, "0.0.0.1", this.aWN, adqr.getDensity(), null, null);
          if (adnq.c.a(this.this$0) != null)
          {
            localObject3 = (aqju)adnq.c.a(this.this$0).get();
            if ((localObject3 != null) && (((aqju)localObject3).isShowing())) {
              ((aqju)localObject3).dismiss();
            }
          }
          localObject2 = aqha.a((Context)localObject1, null, (Bundle)localObject2);
          ((aqju)localObject2).setNegativeButton(2131721058, null);
          ((aqju)localObject2).setPositiveButton(2131721079, null);
          adnq.c.a(this.this$0, new WeakReference(localObject2));
          ((aqju)localObject2).show();
          adqu.b(((BaseActivity)localObject1).app, "ShowView", this.this$0.mAppName, null, adqu.cJq, 0, 0);
          return;
          if (!this.val$type.equals("card")) {
            break;
          }
          localObject1 = ark.arkGetContainer(this.Vo);
          QLog.d("ArkOpenView", 1, "OpenView card container=" + localObject1);
        } while (localObject1 == null);
        localObject1 = (wyw)wyw.a((ark.Container)localObject1).get();
      } while (localObject1 == null);
      ((wyw)localObject1).dC(this.val$view, this.aWN);
      return;
    } while ((!this.val$type.equals("bottom_card")) || (!(BaseActivity.sTopActivity instanceof FragmentActivity)));
    ArkFullScreenAppActivity.c((FragmentActivity)BaseActivity.sTopActivity, "com.tencent.cmgame.intent", "GameCard", this.aWN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.10
 * JD-Core Version:    0.7.0.1
 */