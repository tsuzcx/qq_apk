package com.tencent.mobileqq.forward;

import afke;
import afkp;
import afnu;
import ahjc;
import aqhq;
import aquz;
import aqva;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;
import java.util.ArrayList;

public class ForwardPluginShareStructMsgOption$2
  implements Runnable
{
  public ForwardPluginShareStructMsgOption$2(ahjc paramahjc, String paramString) {}
  
  public void run()
  {
    Object localObject1 = afnu.bEu.replace("[epId]", this.aMY);
    boolean bool = aqhq.fileExists((String)localObject1);
    Object localObject2 = afnu.bEf.replace("[epId]", this.aMY);
    localObject1 = new File((String)localObject1);
    if (!bool)
    {
      localObject2 = new aquz((String)localObject2, (File)localObject1);
      ((aquz)localObject2).cWs = true;
      if (aqva.a((aquz)localObject2, this.this$0.app) != 0) {
        return;
      }
    }
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).epId = this.aMY;
    ((EmoticonPackage)localObject2).jobType = 4;
    localObject1 = aqhq.fileToBytes((File)localObject1);
    ArrayList localArrayList = new ArrayList();
    afkp.a(this.this$0.app, (EmoticonPackage)localObject2, afke.cRu, (byte[])localObject1, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2
 * JD-Core Version:    0.7.0.1
 */