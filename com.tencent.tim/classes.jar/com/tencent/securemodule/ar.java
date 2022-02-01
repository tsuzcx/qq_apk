package com.tencent.securemodule;

import android.os.Handler;
import android.os.Message;
import com.tencent.securemodule.service.ICallback;
import com.tencent.securemodule.ui.TransparentActivity;
import com.tencent.securemodule.ui.TransparentActivity.a;

public class ar
  implements ICallback
{
  public ar(TransparentActivity.a parama) {}
  
  public void onTaskFinished(int paramInt)
  {
    if (paramInt == 0)
    {
      Message localMessage = TransparentActivity.c(this.a.a).obtainMessage(2);
      localMessage.arg1 = 1;
      TransparentActivity.c(this.a.a).sendMessage(localMessage);
      return;
    }
    TransparentActivity.a.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.securemodule.ar
 * JD-Core Version:    0.7.0.1
 */