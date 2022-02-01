import android.content.Context;
import android.util.Log;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import dov.com.qq.im.aeeditor.module.aifilter.VideoAIFilterProxy.1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Laxkm;>;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class axkt
  extends axkj
{
  private static final String TAG = axkt.class.getSimpleName();
  private TAVCutVideoSession a;
  private final int eFR = 250;
  
  public axkt(TAVCutVideoSession paramTAVCutVideoSession)
  {
    this.a = paramTAVCutVideoSession;
  }
  
  private List<Long> hR()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.a != null) && (this.a.getDuration() != null))
    {
      long l1 = this.a.getDuration().getTimeUs() / 1000L;
      int i = 3000;
      if (l1 > 30000L) {
        i = 6000;
      }
      int j = 0;
      while ((j <= l1 / i) && (j < 10))
      {
        long l2 = j * i;
        if (l2 < l1) {
          localArrayList.add(Long.valueOf(l2));
        }
        j += 1;
      }
    }
    return localArrayList;
  }
  
  protected axkn a(List<axkm> paramList)
  {
    axku localaxku = new axku();
    if (aB(this.mPickUpBitmapList)) {}
    try
    {
      localaxku.a = PhotoAIFilter.preprocessImages(this.mPickUpBitmapList);
      localaxku.dZ = axjp.a(localaxku.a);
      localaxku.adjustParam = axjp.a(localaxku.a);
      localObject2 = new ArrayList();
      if ((paramList == null) || (paramList.size() == 0))
      {
        String str = NewEnhanceCategories.COMMON.serverLabel;
        paramList = (List<axkm>)localObject2;
        axiy.i(TAG, "sceneLabel: " + str);
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (YoutuResultItem)((Iterator)localObject2).next();
          axiy.i(TAG, "label: " + ((YoutuResultItem)localObject3).Label + ", confidence: " + ((YoutuResultItem)localObject3).Confidence);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      for (;;)
      {
        Object localObject2;
        axiy.e(TAG, Log.getStackTraceString(localException));
        continue;
        Object localObject3 = voteLable(paramList);
        Iterator localIterator = paramList.iterator();
        do
        {
          paramList = (List<axkm>)localObject2;
          localObject1 = localObject3;
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = (axkm)localIterator.next();
        } while (!paramList.cVl.equals(localObject3));
        paramList = paramList.MP;
        localObject1 = localObject3;
      }
      localaxku.sceneLabel = localObject1;
      localaxku.MT = paramList;
      localaxku.lutPath = sH(localaxku.sceneLabel);
    }
    return localaxku;
  }
  
  protected void a(Context paramContext, axkj.a parama)
  {
    List localList = hR();
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    localExecutorService.submit(new VideoAIFilterProxy.1(this, localList, paramContext, parama));
    localExecutorService.shutdown();
  }
  
  public boolean aOO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axkt
 * JD-Core Version:    0.7.0.1
 */