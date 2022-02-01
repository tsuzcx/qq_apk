package com.tencent.mobileqq.ark.API;

import adnq;
import adnq.c;
import adrm;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForArkApp;
import java.lang.ref.WeakReference;
import wyw;

public class ArkAppModuleReg$ModuleQQ$13
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$13(adnq.c paramc, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject3 = ark.arkGetContainer(this.Vo);
    if (localObject3 == null) {}
    label12:
    Object localObject1;
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
              break label12;
              break label12;
              break label12;
              do
              {
                return;
              } while (!(BaseActivity.sTopActivity instanceof FragmentActivity));
              localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
            } while (localObject1 == null);
            localObject2 = ((ChatFragment)localObject1).a();
            if (localObject2 == null) {
              break;
            }
            localObject1 = ((BaseChatPie)localObject2).a();
          } while (localObject1 == null);
          localObject3 = wyw.a((ark.Container)localObject3);
        } while (localObject3 == null);
        localObject3 = (wyw)((WeakReference)localObject3).get();
        Object localObject2 = ((BaseChatPie)localObject2).a((wyw)localObject3);
        if (localObject2 != null)
        {
          adrm.a().a(((MessageForArkApp)localObject2).arkContainer, (SessionInfo)localObject1, (MessageForArkApp)localObject2, this.buJ, adnq.getAppInterface());
          return;
        }
      } while ((!adrm.a().isShowing()) || (localObject3 == null));
      adrm.a().a((wyw)localObject3, (SessionInfo)localObject1, this.buJ);
      return;
      localObject1 = wyw.a((ark.Container)localObject3);
    } while (localObject1 == null);
    adrm.a().a((wyw)((WeakReference)localObject1).get(), null, this.buJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.13
 * JD-Core Version:    0.7.0.1
 */