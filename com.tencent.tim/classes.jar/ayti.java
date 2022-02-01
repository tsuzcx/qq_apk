import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class ayti
  implements aytk
{
  public boolean aIV;
  public boolean aIW;
  public boolean dAF;
  private AppInterface mApp;
  
  public ayti(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mApp = paramAppInterface;
    this.aIV = paramBoolean1;
    this.aIW = paramBoolean2;
    this.dAF = paramBoolean3;
  }
  
  public void b(@NonNull ArrayList<aytl> paramArrayList, @NonNull Context paramContext)
  {
    Object localObject7 = null;
    aytl localaytl1 = null;
    if (QLog.isColorLevel()) {
      QLog.e("CfgLineLayerStrokeStrategy", 2, new Object[] { "createHorizontalStroke, mNeedMosaic:", Boolean.valueOf(this.aIV), " mNeedPersonality:", Boolean.valueOf(this.aIW), " mIsEditPic:", Boolean.valueOf(this.dAF) });
    }
    Object localObject1;
    if (this.aIV)
    {
      localObject1 = new aytl(paramContext.getResources().getDrawable(2130847656), 1, 0);
      ((aytl)localObject1).contentDescription = acfp.m(2131704335);
      paramArrayList.add(localObject1);
    }
    Object localObject2;
    Object localObject3;
    aytl localaytl2;
    Object localObject6;
    Object localObject5;
    aytl localaytl3;
    Object localObject4;
    int i;
    if (this.aIW)
    {
      boolean bool = ankq.aya();
      if ((this.mApp != null) && (bool))
      {
        localObject1 = PtvTemplateManager.a(this.mApp).dH();
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
        {
          Iterator localIterator = ((ArrayList)localObject1).iterator();
          localObject2 = null;
          localObject3 = null;
          localaytl2 = null;
          localObject1 = null;
          do
          {
            localObject7 = localaytl1;
            localObject6 = localObject2;
            localObject5 = localObject3;
            localaytl3 = localaytl2;
            localObject4 = localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject4 = (PtvTemplateManager.DoodleInfo)localIterator.next();
          } while (("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName)) && (Build.VERSION.SDK_INT < 18));
          i = Integer.valueOf(((PtvTemplateManager.DoodleInfo)localObject4).doodleId).intValue();
          if ("doodle_image_family".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
          {
            localObject4 = new aytl(paramContext.getResources().getDrawable(2130845964), 2, i);
            ((aytl)localObject4).contentDescription = acfp.m(2131704334);
            localObject2 = localObject3;
            localObject3 = localObject1;
            localObject1 = localObject4;
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
        localaytl1 = new aytl(paramContext.getResources().getDrawable(2130845965), 2, i);
        localaytl1.contentDescription = acfp.m(2131704333);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_image_xin".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new aytl(paramContext.getResources().getDrawable(2130845966), 2, i);
        ((aytl)localObject4).contentDescription = acfp.m(2131704336);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if ("doodle_highlighter".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localObject4 = new aytl(paramContext.getResources().getDrawable(2130845963), 2, i);
        ((aytl)localObject4).contentDescription = acfp.m(2131704331);
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      else if ("doodle_fireworks".equals(((PtvTemplateManager.DoodleInfo)localObject4).doodleName))
      {
        localaytl2 = new aytl(paramContext.getResources().getDrawable(2130845962), 2, i);
        localaytl2.contentDescription = acfp.m(2131704332);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Doodle_Strokes_CfgLineLayerStrokeStrategy", 2, "createHorizontalStroke doodleInfo is NUll !");
        }
        localObject6 = null;
        localObject5 = null;
        localaytl3 = null;
        localObject4 = null;
        i(paramContext, paramArrayList);
        if (localObject4 != null) {
          paramArrayList.add(localObject4);
        }
        if (localaytl3 != null) {
          paramArrayList.add(localaytl3);
        }
        if (localObject5 != null) {
          paramArrayList.add(localObject5);
        }
        if (localObject6 != null) {
          paramArrayList.add(localObject6);
        }
        if (localObject7 != null) {
          paramArrayList.add(localObject7);
        }
        return;
        i(paramContext, paramArrayList);
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
  
  public void i(Context paramContext, ArrayList<aytl> paramArrayList)
  {
    int[] arrayOfInt1;
    if (this.dAF)
    {
      arrayOfInt1 = aytl.up;
      if (!this.dAF) {
        break label76;
      }
    }
    label76:
    for (int[] arrayOfInt2 = aytl.uo;; arrayOfInt2 = aytl.ek)
    {
      int i = 0;
      while (i < arrayOfInt1.length)
      {
        paramArrayList.add(new aytl(paramContext.getResources().getDrawable(arrayOfInt1[i]), 0, arrayOfInt2[i]));
        i += 1;
      }
      arrayOfInt1 = aytl.el;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayti
 * JD-Core Version:    0.7.0.1
 */