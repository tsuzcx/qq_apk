package com.tencent.mobileqq.magicface.drawable;

import afnu;
import afpu;
import aixk;
import aixk.c;
import aixn;
import ajdg;
import aquz;
import aqvc;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PngFrameManager$4
  implements Runnable
{
  public PngFrameManager$4(aixk paramaixk, aixk.c paramc) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func showPngFrame, zip NOT exist, download from Server.");
    }
    Object localObject3 = (ajdg)this.this$0.mApp.getManager(14);
    Object localObject2 = ((ajdg)localObject3).b(this.a.epId);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = this.a.epId;
      ((EmoticonPackage)localObject1).aio = true;
    }
    ((EmoticonPackage)localObject1).rscType = 1;
    ((ajdg)localObject3).m((EmoticonPackage)localObject1);
    String str = this.a.c.c.e.eId;
    localObject2 = afnu.bEi.replace("[eIdSub]", str.substring(0, 2)).replace("[eId]", str);
    localObject1 = afnu.bEv.replace("[epId]", this.a.epId).replace("[eId]", str);
    localObject3 = afnu.bEm.replace("[eIdSub]", str.substring(0, 2)).replace("[eId]", str).replace("[width]", "200").replace("[height]", "200");
    str = afnu.bEt.replace("[epId]", this.a.epId).replace("[eId]", str);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    localArrayList.add(localObject2);
    localHashMap.put(localObject2, new File((String)localObject1));
    localArrayList.add(localObject3);
    localHashMap.put(localObject3, new File(str));
    localObject2 = new aquz(localArrayList, localHashMap, "random_magicface_" + this.a.epId);
    ((aquz)localObject2).cWw = true;
    this.this$0.c.a((aquz)localObject2, new aixn(this, (String)localObject1), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.4
 * JD-Core Version:    0.7.0.1
 */