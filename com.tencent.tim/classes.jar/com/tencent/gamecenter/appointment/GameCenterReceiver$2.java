package com.tencent.gamecenter.appointment;

import ahty;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import asbw;
import awnz;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.wadl.WadlProvider;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;
import tba;

class GameCenterReceiver$2
  implements Runnable
{
  GameCenterReceiver$2(GameCenterReceiver paramGameCenterReceiver, Intent paramIntent) {}
  
  public void run()
  {
    switch (this.val$intent.getIntExtra("key_event_id", -1))
    {
    }
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
              do
              {
                do
                {
                  do
                  {
                    return;
                    asbw.a().loadConfig();
                    return;
                    synchronized (this.this$0.listeners)
                    {
                      Object localObject2 = this.val$intent.getStringExtra("key_appid");
                      Object localObject4 = this.val$intent.getStringExtra("key_pkg_name");
                      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
                      {
                        localObject2 = new WadlResult(new WadlParams((String)localObject2, (String)localObject4));
                        ((WadlResult)localObject2).bBa = 12;
                        localObject4 = this.this$0.listeners.iterator();
                        if (((Iterator)localObject4).hasNext()) {
                          ((tba)((Iterator)localObject4).next()).c((WadlResult)localObject2);
                        }
                      }
                    }
                    return;
                  } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.dqY));
                  ??? = awnz.cx(this.val$intent.getStringExtra("appId"), WadlProvider.cRN);
                } while (TextUtils.isEmpty((CharSequence)???));
                Bundle localBundle = this.val$intent.getExtras();
                localBundle.putString("via", "provider");
                localBundle.putInt("flags", 39);
                ahty.a(localBundle, (String)???, false, 0);
                return;
              } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.dqY));
              ??? = awnz.cx(this.val$intent.getStringExtra("appId"), WadlProvider.cRN);
            } while (TextUtils.isEmpty((CharSequence)???));
            ahty.cB(0, (String)???);
            return;
          } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.dqY));
          ??? = awnz.cx(this.val$intent.getStringExtra("appId"), WadlProvider.cRN);
        } while (TextUtils.isEmpty((CharSequence)???));
        ??? = new WadlParams((String)???, this.val$intent.getStringExtra("pkgName"));
        ((WadlParams)???).sourceId = "biz_src_zf_games";
        ahty.d((WadlParams)???);
        return;
      } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.dqY));
      ??? = awnz.cx(this.val$intent.getStringExtra("appId"), WadlProvider.cRN);
    } while (TextUtils.isEmpty((CharSequence)???));
    ahty.cC(0, (String)???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver.2
 * JD-Core Version:    0.7.0.1
 */