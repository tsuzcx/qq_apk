package com.tencent.mobileqq.text;

import afke;
import afkp;
import afnu;
import ajdg;
import aofk;
import aofk.c;
import aqhq;
import aquz;
import aqva;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

public class QQText$SmallEmojiSpan$1
  implements Runnable
{
  public QQText$SmallEmojiSpan$1(aofk.c paramc) {}
  
  public void run()
  {
    Object localObject2 = afnu.bEu.replace("[epId]", Integer.toString(this.this$0.dOt));
    boolean bool = aqhq.fileExists((String)localObject2);
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(aofk.access$000());
        if (localQQAppInterface1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQText", 2, "appInterface is null. return");
          }
          return;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        localClassCastException.printStackTrace();
        QQAppInterface localQQAppInterface2 = null;
        continue;
        if (bool)
        {
          localObject3 = afnu.a();
          if (localObject3 == null) {
            break label385;
          }
          localObject1 = ((ajdg)localObject3).a(Integer.toString(this.this$0.dOt), Integer.toString(this.this$0.dOu));
          if (localObject1 != null)
          {
            localObject1 = ((ajdg)localObject3).b(Integer.toString(this.this$0.dOt));
            if ((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 0))
            {
              localObject3 = new ArrayList();
              localObject2 = aqhq.fileToBytes(new File((String)localObject2));
              afkp.a(localQQAppInterface2, (EmoticonPackage)localObject1, afke.cRu, (byte[])localObject2, (ArrayList)localObject3);
            }
            this.this$0.n((EmoticonPackage)localObject1);
            return;
          }
        }
        Object localObject3 = afnu.bEf.replace("[epId]", Integer.toString(this.this$0.dOt));
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("QQText", 2, "small emoji json not exist. epId:" + this.this$0.dOt + ",downloadUrl:" + (String)localObject3);
        }
        localObject2 = new aquz((String)localObject3, (File)localObject1);
        ((aquz)localObject2).cWs = true;
        int i = aqva.a((aquz)localObject2, localQQAppInterface2);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).epId = Integer.toString(this.this$0.dOt);
        ((EmoticonPackage)localObject2).jobType = 4;
        if (i != 0) {
          continue;
        }
        if (((File)localObject1).exists())
        {
          localObject1 = aqhq.fileToBytes((File)localObject1);
          localObject3 = new ArrayList();
          afkp.a(localQQAppInterface2, (EmoticonPackage)localObject2, afke.cRu, (byte[])localObject1, (ArrayList)localObject3);
          this.this$0.n((EmoticonPackage)localObject2);
          return;
        }
        localObject1 = null;
        continue;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        return;
      }
      label385:
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.SmallEmojiSpan.1
 * JD-Core Version:    0.7.0.1
 */