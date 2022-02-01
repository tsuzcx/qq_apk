import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;

public class ayqs
  extends ayqr<ayqb, ayqb>
{
  public final String aBe;
  private boolean aIL;
  private Bitmap ia;
  
  public ayqs(String paramString)
  {
    this(true, paramString);
  }
  
  public ayqs(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    this(paramBoolean, paramString);
    this.ia = paramBitmap;
  }
  
  public ayqs(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public ayqs(boolean paramBoolean, String paramString)
  {
    this.aIL = paramBoolean;
    this.aBe = paramString;
  }
  
  private Bitmap ae(Bitmap paramBitmap)
  {
    int i = rpq.getWindowScreenWidth(BaseApplication.getContext());
    int j = rpq.getWindowScreenHeight(BaseApplication.getContext()) * 720 / i;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    return rop.b(paramBitmap, 720, i, false, false);
  }
  
  private static Bitmap g(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap2 == null) {}
    do
    {
      for (;;)
      {
        return paramBitmap1;
        try
        {
          Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
          localCanvas.drawBitmap(paramBitmap2, 20.0F, paramBitmap1.getHeight() - 20 - paramBitmap2.getHeight(), null);
          return localBitmap;
        }
        catch (OutOfMemoryError paramBitmap2)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("Q.qqstory.publish.edit.MergePicSegment", 2, paramBitmap2, new Object[0]);
            return paramBitmap1;
          }
        }
        catch (Exception paramBitmap2) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.qqstory.publish.edit.MergePicSegment", 2, paramBitmap2, new Object[0]);
    return paramBitmap1;
  }
  
  protected void a(JobContext paramJobContext, ayqb paramayqb)
  {
    int i = 0;
    Object localObject = this.aBe;
    paramJobContext = (JobContext)localObject;
    if (localObject == null) {
      paramJobContext = ayqu.f(paramayqb.businessId, paramayqb.aAU, ".jpg");
    }
    int j = aqhu.getExifOrientation(paramayqb.a.aAY);
    if ((this.aIL) && (paramayqb.aIA)) {
      ram.d("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    label527:
    for (;;)
    {
      boolean bool;
      try
      {
        localObject = paramayqb.a.cK;
        Bitmap localBitmap2 = paramayqb.a.doodleBitmap;
        if ((paramayqb.businessId == 2) || (paramayqb.businessId == 5) || (paramayqb.businessId == 6)) {
          break label527;
        }
        float f1 = ((Bitmap)localObject).getHeight() * 1.0F / ((Bitmap)localObject).getWidth();
        float f2 = localBitmap2.getHeight() * 1.0F / localBitmap2.getWidth();
        if (((((Bitmap)localObject).getWidth() <= ((Bitmap)localObject).getHeight()) || (localBitmap2.getWidth() >= localBitmap2.getHeight())) && (Math.abs(f1 - f2) <= 0.1D)) {
          break label527;
        }
        Bitmap localBitmap1 = ae((Bitmap)localObject);
        if (localBitmap1 == null) {
          break label527;
        }
        localObject = localBitmap1;
        localObject = g(rop.d((Bitmap)localObject, localBitmap2), this.ia);
        if (localObject == null) {
          continue;
        }
        bool = rop.d((Bitmap)localObject, paramJobContext);
      }
      catch (Throwable paramJobContext)
      {
        ram.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext + paramJobContext.getStackTrace());
        paramJobContext = null;
        bool = false;
        continue;
      }
      if ((i == 0) && (!bool))
      {
        ram.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, acfp.m(2131708130)));
        return;
        paramJobContext = null;
        bool = false;
        continue;
        if (paramayqb.a.bsR > 0)
        {
          ram.d("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
          localObject = g(paramayqb.a.cK, this.ia);
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
          {
            bool = rop.d((Bitmap)localObject, paramJobContext);
          }
          else
          {
            if (localObject == null) {
              ram.e("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is null");
            }
            for (;;)
            {
              paramJobContext = null;
              bool = false;
              break;
              if (((Bitmap)localObject).isRecycled()) {
                ram.e("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is recycled");
              }
            }
          }
        }
        else if (paramayqb.a.dAr)
        {
          bool = rop.d(paramayqb.a.cK, paramJobContext);
        }
        else if ((j != 0) && (j % 90 == 0))
        {
          ram.d("Q.qqstory.publish.edit.MergePicSegment", "save rotate bitmap");
          bool = rop.d(paramayqb.a.cK, paramJobContext);
        }
        else
        {
          ram.d("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
          paramJobContext = paramayqb.a.aAY;
          ras.sp("0X80075C9");
          paramayqb.a.aIF = true;
          bool = false;
          i = 1;
        }
      }
      else
      {
        paramayqb.a.aAZ = paramJobContext;
        paramayqb.a.result = bool;
        super.notifyResult(paramayqb);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqs
 * JD-Core Version:    0.7.0.1
 */