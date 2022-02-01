package com.tencent.av.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import iiv;
import iwu;
import jkn;
import jqi;
import mqq.util.WeakReference;

class TraeHelper$5$1
  implements Runnable
{
  TraeHelper$5$1(TraeHelper.5 param5) {}
  
  public void run()
  {
    Object localObject3;
    iiv localiiv;
    try
    {
      if (this.a.this$0.a == null) {
        return;
      }
      localObject3 = this.a.bB.getResources();
      localiiv = this.a.this$0.a.b();
      if ((localiiv.amI == 2) || ((localiiv.amI == 4) && (localiiv.Qw) && (jqi.isNetworkAvailable(this.a.val$context))) || (this.a.this$0.a.sx()) || (this.a.this$0.a.sw())) {
        break label931;
      }
      if (!TraeHelper.c(this.a.this$0)) {
        break label549;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      QLog.e("TraeSessionHelper", 1, "onUpdateButtonHandFree ui task fail.", localException);
      return;
    }
    int i = 8;
    localObject1 = ((Resources)localObject3).getString(2131697635);
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((TraeHelper.b(this.a.this$0)) && (jkn.xE())) {
      if ("DEVICE_BLUETOOTHHEADSET".equals(localiiv.deviceName))
      {
        i = 5;
        localObject3 = ((Resources)localObject3).getString(2131697633);
        iwu.a(localVideoAppInterface, 3012);
        if (!TraeHelper.d(this.a.this$0))
        {
          localObject1 = localObject3;
          if (!TraeHelper.e(this.a.this$0)) {
            break label928;
          }
        }
        TraeHelper.a(this.a.this$0, false);
        TraeHelper.b(this.a.this$0, false);
        iwu.a(localVideoAppInterface, 5, 3000L);
        i = 5;
        localObject1 = localObject3;
      }
    }
    label272:
    label463:
    int j;
    label549:
    Object localObject2;
    for (;;)
    {
      localObject3 = TraeHelper.a(this.a.this$0, this.a.val$context.getResources(), i, TraeHelper.f(this.a.this$0));
      this.a.bB.setCompoundDrawables(null, (Drawable)localObject3, null, null);
      this.a.bB.setText((CharSequence)localObject1);
      if (this.a.this$0.o != null)
      {
        localObject3 = (TraeHelper.d)this.a.this$0.o.get();
        if (localObject3 != null) {
          ((TraeHelper.d)localObject3).H(localiiv.QB, this.a.this$0.aBj);
        }
      }
      if (((TraeHelper.g(this.a.this$0)) || (TraeHelper.e(this.a.this$0))) && (!TraeHelper.b(this.a.this$0)))
      {
        TraeHelper.c(this.a.this$0, false);
        TraeHelper.b(this.a.this$0, false);
        if (localiiv.QB)
        {
          i = 2;
          iwu.a(localVideoAppInterface, i, 3000L);
        }
      }
      else
      {
        QLog.w("TraeSessionHelper", 1, "onUpdateButtonHandFree, btnText[" + (String)localObject1 + "], deviceName[" + localiiv.deviceName + "], mCurrentAudioLevel[" + this.a.this$0.aBj + "]");
        return;
        j = 0;
        break;
        if ("DEVICE_WIREDHEADSET".equals(localiiv.deviceName))
        {
          i = 6;
          localObject3 = ((Resources)localObject3).getString(2131697636);
          if (!TraeHelper.d(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!TraeHelper.e(this.a.this$0)) {
              break label928;
            }
          }
          TraeHelper.a(this.a.this$0, false);
          TraeHelper.b(this.a.this$0, false);
          iwu.a(localVideoAppInterface, 6, 3000L);
          i = 6;
          localObject2 = localObject3;
          continue;
        }
        if ("DEVICE_EARPHONE".equals(localiiv.deviceName))
        {
          i = 7;
          localObject3 = ((Resources)localObject3).getString(2131697634);
          if (!TraeHelper.d(this.a.this$0))
          {
            localObject2 = localObject3;
            if (!TraeHelper.e(this.a.this$0)) {
              break label928;
            }
          }
          TraeHelper.a(this.a.this$0, false);
          TraeHelper.b(this.a.this$0, false);
          iwu.a(localVideoAppInterface, 7, 3000L);
          i = 7;
          localObject2 = localObject3;
          continue;
        }
        if (!"DEVICE_SPEAKERPHONE".equals(localiiv.deviceName)) {
          break label928;
        }
        i = 8;
        localObject3 = ((Resources)localObject3).getString(2131697635);
        if (!TraeHelper.d(this.a.this$0))
        {
          localObject2 = localObject3;
          if (!TraeHelper.e(this.a.this$0)) {
            break label928;
          }
        }
        TraeHelper.a(this.a.this$0, false);
        TraeHelper.b(this.a.this$0, false);
        iwu.a(localVideoAppInterface, 2, 3000L);
        i = 8;
        localObject2 = localObject3;
        continue;
        iwu.a(localVideoAppInterface, 3012);
        if (this.a.this$0.aBj == 1)
        {
          if (j == 0) {
            break label936;
          }
          i = 3;
        }
      }
    }
    for (;;)
    {
      localObject2 = ((Resources)localObject3).getString(2131697635);
      break label272;
      int k = this.a.this$0.aBj;
      if (k == 2) {
        if (j != 0)
        {
          i = 4;
        }
        else
        {
          i = 2;
          continue;
          i = 3;
          break label463;
          label928:
          break label272;
          label931:
          j = 1;
          break;
          label936:
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.5.1
 * JD-Core Version:    0.7.0.1
 */