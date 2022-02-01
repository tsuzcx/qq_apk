package com.tencent.mobileqq.richstatus;

import acbn;
import amhd;
import android.os.Bundle;
import android.text.TextUtils;
import aqhq;
import aqqr;
import aqqs;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import ld;

public class SignatureManagerForTool$1
  implements Runnable
{
  public SignatureManagerForTool$1(amhd paramamhd, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Signature.TOOL", 2, "in getTemplateInfo info" + this.val$id);
    }
    Object localObject1 = (aqqs)amhd.a(this.this$0).get(Integer.valueOf(this.val$id));
    Object localObject2;
    boolean bool;
    if ((localObject1 == null) || (!((aqqs)localObject1).er.get())) {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("getTemplateInfo info == null: ");
        if (localObject1 != null) {
          break label109;
        }
        bool = true;
        QLog.e("Signature.TOOL", 2, bool);
      }
    }
    label109:
    do
    {
      return;
      bool = false;
      break;
      localObject2 = new File(acbn.bmQ + this.val$id + File.separator + "config.json");
      if (!((File)localObject2).exists()) {
        break label208;
      }
      localObject2 = aqhq.b((File)localObject2, -1);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    aqqr.a((String)localObject2, (aqqs)localObject1);
    ((aqqs)localObject1).er.set(false);
    amhd.a(this.this$0);
    this.this$0.notifyObservers(Integer.valueOf(3));
    return;
    label208:
    this.this$0.notifyObservers(Integer.valueOf(9));
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("id", this.val$id);
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", ld.eu, (Bundle)localObject1, amhd.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureManagerForTool.1
 * JD-Core Version:    0.7.0.1
 */