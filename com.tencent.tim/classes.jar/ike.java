import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import java.util.Iterator;
import java.util.List;

public class ike
{
  public static boolean tA()
  {
    boolean bool3 = true;
    Object localObject1 = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
    Object localObject2 = SdkContext.getInstance().getResources().getPtuFilterResource().getPortraitPathDir();
    boolean bool1;
    label132:
    long l;
    if ((!ankq.isSupportPortarit()) || (AIManager.installDetector(PTHumanSegmenter.class, (String)localObject2, (String)localObject1)))
    {
      bool1 = true;
      bool2 = ikg.a().tC();
      boolean bool4 = ikf.tB();
      if (QLog.isColorLevel()) {
        QLog.d("PanoramaAccessManager", 2, "checkPanoramaAccessEnable portraitSo = " + bool1 + "| sensorEnable = " + bool2 + " |DPCEntry = " + bool4);
      }
      if ((!bool1) || (!bool2) || (!bool4)) {
        break label279;
      }
      bool2 = true;
      if (!bool2) {
        return bool2;
      }
      localObject1 = ikf.aj();
      if (localObject1 == null) {
        break label337;
      }
      l = ikf.kV();
      localObject1 = ((List)localObject1).iterator();
      bool1 = false;
    }
    label163:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ikf.a)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PanoramaAccessManager", 2, "checkPanoramaAccessEnable CPUinfo = " + ((ikf.a)localObject2).aoc + "|" + ((ikf.a)localObject2).aob);
        }
        if ((bool1) || (iow.a(((ikf.a)localObject2).aoc, ((ikf.a)localObject2).aob * 10000, l * 100000000L))) {}
        for (bool1 = true;; bool1 = false)
        {
          break label163;
          bool1 = false;
          break;
          bool2 = false;
          break label132;
        }
      }
    }
    label279:
    if ((bool2) && (bool1)) {}
    for (boolean bool2 = bool3;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanoramaAccessManager", 2, "checkPanoramaAccessEnable isDeviceSupport = " + bool1);
      }
      return bool2;
    }
    label337:
    return false;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ike
 * JD-Core Version:    0.7.0.1
 */