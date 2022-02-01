import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.richmedia.subtitles.WordingItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aatx
  extends aatn
{
  private int Lk = 270;
  private int MARGIN_LEFT = 40;
  private int ckg = 522;
  private int ckh = 350;
  private int cki = 44;
  private int ckj = 30;
  private int ckk = -1;
  private int ckl = -136515;
  private int ckm = 4;
  private int ckn = 3;
  private int cko = 3000;
  private Typeface mTypeface;
  private List<aatw> vv = new ArrayList();
  
  private void a(aatw paramaatw)
  {
    if (paramaatw == null) {}
    label60:
    for (;;)
    {
      return;
      Iterator localIterator = this.vv.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label60;
        }
        aatw localaatw = (aatw)localIterator.next();
        if (localaatw == paramaatw) {
          break;
        }
        localIterator.remove();
        localaatw.a.unInit();
        localaatw.b.unInit();
      }
    }
  }
  
  public boolean Xk()
  {
    Iterator localIterator = this.vv.iterator();
    while (localIterator.hasNext())
    {
      aatw localaatw = (aatw)localIterator.next();
      if (localaatw.b != null) {
        localaatw.b.cyx();
      }
      if (localaatw.a != null) {
        localaatw.a.cyx();
      }
    }
    return true;
  }
  
  public boolean Xl()
  {
    apk();
    return true;
  }
  
  public void a(WordingItem paramWordingItem)
  {
    if (paramWordingItem == null) {}
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BaseAnimDrawer", 2, "setText ：" + paramWordingItem.beq + " ID:" + paramWordingItem.mID + " baseIndex:" + L(paramWordingItem.qB) + " time:" + paramWordingItem.qB + "-" + paramWordingItem.MH);
      }
      l = paramWordingItem.mID;
    } while ((this.vv.size() > 0) && (((aatw)this.vv.get(0)).mID > l));
    Iterator localIterator = this.vv.iterator();
    aatw localaatw;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localaatw = (aatw)localIterator.next();
    } while (localaatw.mID != paramWordingItem.mID);
    for (;;)
    {
      if (localaatw != null)
      {
        if (localaatw.a != null)
        {
          localaatw.a.setText(paramWordingItem.beq);
          if (localaatw.b == null) {
            break label314;
          }
          localaatw.b.setText(paramWordingItem.ber);
        }
        for (;;)
        {
          localaatw.zn = (paramWordingItem.MH - paramWordingItem.qB);
          return;
          localaatw.a = new aaty(l, L(paramWordingItem.qB), Xm(), paramWordingItem.beq, this.cki, this.ckk, this.ckm, this.MARGIN_LEFT, this.Lk, a(true) - this.MARGIN_LEFT - this.MARGIN_LEFT, -1.0F, this.mTypeface);
          break;
          label314:
          localaatw.b = new aaty(l, L(paramWordingItem.qB), Xm(), paramWordingItem.ber, this.ckj, this.ckl, this.ckn, this.MARGIN_LEFT, this.Lk, a(true) - this.MARGIN_LEFT - this.MARGIN_LEFT, -1.0F, this.mTypeface);
        }
      }
      localaatw = new aatw();
      localaatw.mID = paramWordingItem.mID;
      localaatw.a = new aaty(l, L(paramWordingItem.qB), Xm(), paramWordingItem.beq, this.cki, this.ckk, this.ckm, this.MARGIN_LEFT, this.Lk, a(true) - this.MARGIN_LEFT - this.MARGIN_LEFT, -1.0F, this.mTypeface);
      localaatw.b = new aaty(l, L(paramWordingItem.qB), Xm(), paramWordingItem.ber, this.ckj, this.ckl, this.ckn, this.MARGIN_LEFT, this.Lk, a(true) - this.MARGIN_LEFT - this.MARGIN_LEFT, -1.0F, this.mTypeface);
      localaatw.zn = (paramWordingItem.MH - paramWordingItem.qB);
      this.vv.add(localaatw);
      return;
      localaatw = null;
    }
  }
  
  public boolean a(Canvas paramCanvas, RenderBuffer paramRenderBuffer, long paramLong1, long paramLong2)
  {
    if (this.vv.size() == 0) {
      return false;
    }
    Iterator localIterator = this.vv.iterator();
    Object localObject = null;
    aatw localaatw;
    long l;
    if (localIterator.hasNext())
    {
      localaatw = (aatw)localIterator.next();
      l = localaatw.a.z(2);
      if ((!QLog.isColorLevel()) || ((l <= paramLong1) && ((paramLong1 - l) * paramLong2 < this.cko + localaatw.zn)))
      {
        localObject = localaatw;
        if (!QLog.isColorLevel()) {}
      }
    }
    for (;;)
    {
      break;
      if (l <= paramLong1)
      {
        localIterator.remove();
        localaatw.a.unInit();
        localaatw.b.unInit();
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "removed");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {}
        a(localObject);
        if (localObject != null)
        {
          float f1 = localObject.a.q(4);
          float f2 = localObject.b.q(4);
          if ((getState() == 1) || (getState() == 0))
          {
            localObject.a.p(7, b(true) - (f1 + f2 + this.ckg));
            localObject.b.p(7, b(true) - (f2 + this.ckg));
            if (paramCanvas == null) {
              break label401;
            }
            localObject.a.draw(paramCanvas);
            localObject.b.draw(paramCanvas);
          }
          for (;;)
          {
            return true;
            if (getState() == 2)
            {
              localObject.a.p(7, b(true) - (f1 + f2 + this.ckh));
              localObject.b.p(7, b(true) - (f2 + this.ckh));
              break;
            }
            localObject.a.p(7, b(true) - (f1 + f2 + this.Lk));
            localObject.b.p(7, b(true) - (f2 + this.Lk));
            break;
            label401:
            localObject.a.a(paramRenderBuffer);
            localObject.b.a(paramRenderBuffer);
          }
        }
        return false;
      }
    }
  }
  
  public void apk()
  {
    this.vv.clear();
  }
  
  public void bn(Context paramContext, String paramString)
  {
    float f = 1.0F;
    if (paramContext != null) {
      f = paramContext.getResources().getDisplayMetrics().density;
    }
    f = f / 2.0F * aP();
    this.ckg = ((int)(this.ckg * f));
    this.ckh = ((int)(this.ckh * f));
    this.Lk = ((int)(this.Lk * f));
    this.MARGIN_LEFT = ((int)(this.MARGIN_LEFT * f));
    this.cki = ((int)(this.cki * f));
    this.ckj = ((int)(this.ckj * f));
    this.ckm = ((int)(this.ckm * f));
    this.ckn = ((int)(f * this.ckn));
    this.mTypeface = b(paramString);
  }
  
  public void cbt()
  {
    Iterator localIterator = this.vv.iterator();
    while (localIterator.hasNext())
    {
      aatw localaatw = (aatw)localIterator.next();
      if (localaatw != null)
      {
        localaatw.a.unInit();
        localaatw.b.unInit();
      }
    }
    this.vv.clear();
  }
  
  public int za()
  {
    return this.vv.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aatx
 * JD-Core Version:    0.7.0.1
 */