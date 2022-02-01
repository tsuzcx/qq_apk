import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class rnf
  implements rnh
{
  public static final String[] bZ = { "vivo X20A" };
  public boolean aIV;
  public boolean aIW;
  private AppInterface mApp;
  
  public rnf(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mApp = paramAppInterface;
    this.aIV = paramBoolean1;
    this.aIW = paramBoolean2;
  }
  
  public void b(@NonNull ArrayList<rni> paramArrayList, @NonNull Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke");
    }
    if (this.aIV) {
      paramArrayList.add(new rni(paramContext.getResources().getDrawable(2130847656), 1, 0));
    }
    Iterator localIterator;
    Object localObject1;
    Object localObject9;
    rni localrni2;
    Object localObject10;
    Object localObject3;
    Object localObject11;
    Object localObject2;
    Object localObject12;
    rni localrni1;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    int i;
    if (this.aIW)
    {
      localIterator = null;
      localObject1 = null;
      localObject9 = null;
      localrni2 = null;
      localObject10 = null;
      localObject3 = null;
      localObject11 = null;
      localObject2 = null;
      localObject12 = null;
      localrni1 = null;
      boolean bool = ankq.aya();
      localObject4 = localObject12;
      localObject5 = localObject11;
      localObject6 = localObject10;
      localObject7 = localObject9;
      localObject8 = localIterator;
      if (this.mApp != null)
      {
        localObject4 = localObject12;
        localObject5 = localObject11;
        localObject6 = localObject10;
        localObject7 = localObject9;
        localObject8 = localIterator;
        if (bool)
        {
          localObject4 = PtvTemplateManager.a(this.mApp).dH();
          if ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty()))
          {
            localIterator = ((ArrayList)localObject4).iterator();
            do
            {
              localObject4 = localrni1;
              localObject5 = localObject2;
              localObject6 = localObject3;
              localObject7 = localrni2;
              localObject8 = localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject4 = (PtvTemplateManager.DoodleInfo)localIterator.next();
            } while (("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName)) && (Build.VERSION.SDK_INT < 18));
            i = Integer.valueOf(((PtvTemplateManager.DoodleInfo)localObject4).doodleId).intValue();
            if ("doodle_image_family".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
            {
              localObject4 = new rni(paramContext.getResources().getDrawable(2130845964), 2, i);
              localObject2 = localObject3;
              localObject3 = localObject1;
              localObject1 = localObject4;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      break;
      if ("doodle_image_mouth".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localrni1 = new rni(paramContext.getResources().getDrawable(2130845965), 2, i);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_image_xin".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new rni(paramContext.getResources().getDrawable(2130845966), 2, i);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if ("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new rni(paramContext.getResources().getDrawable(2130845963), 2, i);
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_fireworks".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localrni2 = new rni(paramContext.getResources().getDrawable(2130845962), 2, i);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        continue;
        localObject4 = localObject12;
        localObject5 = localObject11;
        localObject6 = localObject10;
        localObject7 = localObject9;
        localObject8 = localIterator;
        if (QLog.isColorLevel())
        {
          QLog.d("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke doodleInfo is NUll !");
          localObject8 = localIterator;
          localObject7 = localObject9;
          localObject6 = localObject10;
          localObject5 = localObject11;
          localObject4 = localObject12;
        }
        i = 0;
        while (i < 4)
        {
          paramArrayList.add(new rni(paramContext.getResources().getDrawable(rni.el[i]), 0, rni.ek[i]));
          i += 1;
        }
        paramArrayList.add(new rni(paramContext.getResources().getDrawable(2130847648), 0, -1));
        int k = 0;
        paramContext = bZ;
        int m = paramContext.length;
        i = 0;
        int j = k;
        if (i < m)
        {
          if (paramContext[i].equals(Build.MODEL)) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break label714;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke black model " + Build.MODEL);
          }
        }
        for (;;)
        {
          return;
          i += 1;
          break;
          label714:
          if (localObject8 != null) {
            paramArrayList.add(localObject8);
          }
          if (localObject7 != null) {
            paramArrayList.add(localObject7);
          }
          if (localObject6 != null) {
            paramArrayList.add(localObject6);
          }
          if (localObject5 != null) {
            paramArrayList.add(localObject5);
          }
          if (localObject4 != null)
          {
            paramArrayList.add(localObject4);
            return;
            i = 0;
            while (i < rni.ek.length)
            {
              if (rni.ek[i] != -9576193) {
                paramArrayList.add(new rni(paramContext.getResources().getDrawable(rni.el[i]), 0, rni.ek[i]));
              }
              i += 1;
            }
          }
        }
      }
      else
      {
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rnf
 * JD-Core Version:    0.7.0.1
 */