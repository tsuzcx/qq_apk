package com.tencent.mobileqq.ocr.view;

import ahqx;
import ahqx.a;
import aklz;
import akoq;
import android.graphics.Bitmap;
import android.graphics.Point;
import anpc;
import aqoy;
import aqoy.a;
import aqoy.c;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class OcrImageTextView$1
  implements Runnable
{
  OcrImageTextView$1(OcrImageTextView paramOcrImageTextView, List paramList, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Iterator localIterator = this.sN.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (ahqx)localIterator.next();
      akoq localakoq = new akoq((ahqx)localObject2);
      int i = ((ahqx)localObject2).getWidth();
      int j = ((ahqx)localObject2).getHeigh();
      localakoq.showWidth = ((int)Math.ceil(i * OcrImageTextView.a(this.this$0)));
      localakoq.showHeight = ((int)Math.ceil(j * OcrImageTextView.b(this.this$0)));
      if (localakoq.bRE) {}
      for (Object localObject1 = aklz.a(OcrImageTextView.a(this.this$0), ((ahqx.a)((ahqx)localObject2).wY.get(3)).x, ((ahqx.a)((ahqx)localObject2).wY.get(3)).y, i, j, localakoq.dod, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));; localObject1 = aklz.a(OcrImageTextView.a(this.this$0), ((ahqx.a)((ahqx)localObject2).wY.get(0)).x, ((ahqx.a)((ahqx)localObject2).wY.get(0)).y, i, j, localakoq.dod, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0)))
      {
        if (localObject1 != null) {
          break label295;
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_succ_flag", "0");
        ((HashMap)localObject1).put("param_md5", this.val$md5);
        ((HashMap)localObject1).put("param_text", localakoq.text);
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject1, null);
        break;
      }
      label295:
      Object localObject3 = new HashMap();
      ((HashMap)localObject3).put("param_succ_flag", "1");
      ((HashMap)localObject3).put("param_md5", this.val$md5);
      ((HashMap)localObject3).put("param_text", localakoq.text);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject3, null);
      aklz.a(localakoq, 64, (Bitmap)localObject1);
      localObject3 = aqoy.a(localakoq.fB).a();
      if ((localObject3 != null) && (((aqoy)localObject3).b() != null))
      {
        localObject3 = ((aqoy)localObject3).b();
        localakoq.dog = (0xFF000000 | ((aqoy.c)localObject3).Mo());
        localakoq.textColor = (((aqoy.c)localObject3).Mr() | 0xFF000000);
        localakoq.ctq = true;
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.access$300(), 2, "ocrText.backRGB=" + localakoq.dog + " ocrText.textColor =" + localakoq.textColor + " text=" + localakoq.text);
        }
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "1");
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      for (;;)
      {
        if ((((Bitmap)localObject1).getHeight() != this.doh) || (((Bitmap)localObject1).getWidth() != this.doi)) {
          ((Bitmap)localObject1).recycle();
        }
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.access$300(), 2, "setOcrResult srcBitmapWidth=" + i + " srcBitmapHeight=" + j + " showWidth=" + localakoq.showWidth + " showHeight=" + localakoq.showHeight + " isDarkColor=" + localakoq.ctp + "arc=" + localakoq.dod + "text=" + localakoq.text);
        }
        localObject1 = ((ahqx)localObject2).wY.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ahqx.a)((Iterator)localObject1).next();
          localObject2 = new Point((int)(((ahqx.a)localObject2).x * OcrImageTextView.a(this.this$0)), (int)(((ahqx.a)localObject2).y * OcrImageTextView.b(this.this$0)));
          localakoq.Ei.add(localObject2);
          localakoq.doe = Math.max(localakoq.doe, ((Point)localObject2).x);
          localakoq.cbW = Math.max(localakoq.cbW, ((Point)localObject2).y);
          localakoq.dof = Math.min(localakoq.dof, ((Point)localObject2).x);
          localakoq.aLL = Math.min(localakoq.aLL, ((Point)localObject2).y);
        }
        localakoq.ctp = aklz.c(localakoq.fB);
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "0");
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      if (OcrImageTextView.a(this.this$0) != null) {
        OcrImageTextView.a(this.this$0).add(localakoq);
      }
    }
    if (OcrImageTextView.a(this.this$0) != null)
    {
      ThreadManager.getUIHandler().post(new OcrImageTextView.1.1(this));
      ThreadManager.getUIHandler().postDelayed(this.this$0.hi, 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView.1
 * JD-Core Version:    0.7.0.1
 */