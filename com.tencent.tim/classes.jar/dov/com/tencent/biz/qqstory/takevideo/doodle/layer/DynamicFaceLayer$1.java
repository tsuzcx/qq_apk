package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import aoop;
import aqqx;
import ayjl;
import ayjn;
import ayjn.a;
import ayjn.b;
import ayjn.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import ram;

public class DynamicFaceLayer$1
  implements Runnable
{
  public DynamicFaceLayer$1(ayjl paramayjl, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.Gn.size())
    {
      Object localObject2 = (PasterParcelData)this.Gn.get(i);
      if (TextUtils.isEmpty(((PasterParcelData)localObject2).path)) {}
      Object localObject1;
      label136:
      int j;
      int k;
      int m;
      int n;
      do
      {
        i += 1;
        break;
        if ((ayjl.a(this.this$0).a == null) || (!ayjl.b(this.this$0).a.Lb())) {
          break label458;
        }
        localObject1 = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), ((PasterParcelData)localObject2).path, "-Dynamic-", aoop.TRANSPARENT, new int[] { 13 }, "-Dynamic-", null);
        if (localObject1 == null) {
          break label437;
        }
        if (((URLDrawable)localObject1).getStatus() != 1) {
          ((URLDrawable)localObject1).restartDownload();
        }
        ((Drawable)localObject1).setCallback(ayjl.c(this.this$0));
        j = (int)((PasterParcelData)localObject2).X.left;
        k = (int)((PasterParcelData)localObject2).X.right;
        m = (int)((PasterParcelData)localObject2).X.top;
        n = (int)((PasterParcelData)localObject2).X.bottom;
      } while (localObject1 == null);
      ((Drawable)localObject1).setBounds(j, m, k, n);
      Object localObject3;
      if (TextUtils.isEmpty(((PasterParcelData)localObject2).text))
      {
        ram.d("DynamicFaceLayer", "Create Normal FaceItem.");
        localObject3 = new ayjn.d(((PasterParcelData)localObject2).centerP.x, ((PasterParcelData)localObject2).centerP.y, ((PasterParcelData)localObject2).scaleValue, ((PasterParcelData)localObject2).nI, ((PasterParcelData)localObject2).translateXValue, ((PasterParcelData)localObject2).translateYValue, (int)((PasterParcelData)localObject2).width, (int)((PasterParcelData)localObject2).height);
        localObject1 = new ayjn.b(this.this$0, (Drawable)localObject1, (ayjn.d)localObject3, ((PasterParcelData)localObject2).category, ((PasterParcelData)localObject2).name, ((PasterParcelData)localObject2).path, ((PasterParcelData)localObject2).eGY);
        ((ayjn.b)localObject1).mSegmentKeeper.set(((PasterParcelData)localObject2).mSegmentKeeper);
        ((ayjn.b)localObject1).aVB = 0;
        if (((ayjn.b)localObject1).eGY == 1) {
          break label675;
        }
        localObject2 = (ayjn)ayjl.d(this.this$0).a(ayjn.TAG);
        if (localObject2 == null) {}
      }
      for (;;)
      {
        try
        {
          localObject3 = ayjn.b.class.getDeclaredField("this$0");
          ((Field)localObject3).setAccessible(true);
          ((Field)localObject3).set(localObject1, localObject2);
          ((ayjn)localObject2).oJ.add(localObject1);
          ((ayjn)localObject2).notifyChange();
          if ((ayjl.e(this.this$0).a == null) || (!ayjl.f(this.this$0).a.Lb())) {
            break;
          }
          ((ayjn.b)localObject1).Zx(true);
          break;
          label437:
          if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "apng error");
          }
          localObject1 = null;
          break label136;
          label458:
          localObject1 = ayjl.sP(((PasterParcelData)localObject2).path);
          ((PasterParcelData)localObject2).path = ((String)localObject1);
          ((PasterParcelData)localObject2).eGY = 0;
          localObject1 = ayjl.w((String)localObject1);
          break label136;
          ram.d("DynamicFaceLayer", "Create FaceAndTextItem with text:" + ((PasterParcelData)localObject2).text);
          localObject3 = new ayjn.d(((PasterParcelData)localObject2).centerP.x, ((PasterParcelData)localObject2).centerP.y, ((PasterParcelData)localObject2).scaleValue, ((PasterParcelData)localObject2).nI, ((PasterParcelData)localObject2).translateXValue, ((PasterParcelData)localObject2).translateYValue, (int)((PasterParcelData)localObject2).width, (int)((PasterParcelData)localObject2).height, ((PasterParcelData)localObject2).text, ((PasterParcelData)localObject2).textColor, ((PasterParcelData)localObject2).textSize);
          localObject1 = new ayjn.a(this.this$0, (Drawable)localObject1, (ayjn.d)localObject3, ((PasterParcelData)localObject2).category, ((PasterParcelData)localObject2).name, ((PasterParcelData)localObject2).path, ((PasterParcelData)localObject2).eGY);
          ((ayjn.a)localObject1).btN();
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DynamicFaceLayer", 2, new Object[] { "reflect faceLayer Item error : ", localException.getMessage() });
          continue;
        }
        label675:
        this.this$0.oJ.add(localObject1);
        this.this$0.notifyChange();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer.1
 * JD-Core Version:    0.7.0.1
 */