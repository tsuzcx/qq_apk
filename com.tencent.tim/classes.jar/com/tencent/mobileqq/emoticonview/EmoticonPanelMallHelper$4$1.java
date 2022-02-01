package com.tencent.mobileqq.emoticonview;

import afnh;
import afnk;
import afoo;
import android.content.Context;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelMallHelper$4$1
  implements Runnable
{
  public EmoticonPanelMallHelper$4$1(afnk paramafnk, EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.a.this$0.a.a;
    if (localObject != null) {
      ((EmotionPanelViewPagerAdapter)localObject).If(this.c.epId);
    }
    if (((this.c.extraFlags & 0x2) > 0) && (this.val$resultCode == 0))
    {
      this.a.this$0.a.b().bZe = false;
      this.c.extraFlags &= 0xFFFFFFFD;
      this.a.this$0.a.MC(EmoticonPanelController.cSe);
    }
    label98:
    do
    {
      do
      {
        break label98;
        do
        {
          return;
        } while ((this.c.jobType == 3) || (this.c.jobType == 5));
        if (this.val$resultCode != 0) {
          break;
        }
        if (this.a.this$0.a.zY.contains(this.c))
        {
          this.a.this$0.a.zY.remove(this.c);
          return;
        }
        this.a.this$0.a.bZi = false;
        this.a.this$0.a.b().bZe = false;
        this.a.this$0.a.bZj = false;
      } while ((this.a.this$0.a.b().getVisibility() != 0) || (this.a.this$0.a.app == null));
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelMallHelper", 2, "Emoticon pkg downloaded in panel, refresh");
      }
      localObject = this.a.this$0.a.zZ;
    } while (localObject == null);
    int i = 0;
    label291:
    if (i < ((List)localObject).size())
    {
      EmoticonPackage localEmoticonPackage = ((afoo)((List)localObject).get(i)).d;
      if ((localEmoticonPackage == null) || (!this.c.epId.equals(localEmoticonPackage.epId))) {}
    }
    for (;;)
    {
      int j = i;
      if (this.a.this$0.a.bZo)
      {
        j = i;
        if (EmoticonPanelController.cSe >= 0) {
          j = EmoticonPanelController.cSe;
        }
      }
      this.a.this$0.a.MC(j);
      this.a.this$0.a.bwe = false;
      return;
      i += 1;
      break label291;
      if (this.val$resultCode == 11000)
      {
        QQToast.a(this.a.this$0.a.context, this.a.this$0.a.context.getString(2131690183), 1).show(this.a.this$0.a.cSg);
        return;
      }
      if (this.val$resultCode != 11001) {
        break;
      }
      QQToast.a(this.a.this$0.a.context, this.a.this$0.a.context.getString(2131690184), 1).show(this.a.this$0.a.cSg);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.4.1
 * JD-Core Version:    0.7.0.1
 */