import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class rhy
  implements rhw
{
  rhn jdField_a_of_type_Rhn;
  rhx jdField_a_of_type_Rhx = null;
  rhy.a jdField_a_of_type_Rhy$a;
  rib jdField_a_of_type_Rib = new rib(this);
  rig jdField_a_of_type_Rig = new rig(this);
  rij jdField_a_of_type_Rij = new rij(this);
  boolean aHP = false;
  int brA = -1;
  int brB = -1;
  int brC = 0;
  int brz = -1;
  public Bitmap cG;
  int mDownX = -1;
  int mDownY = -1;
  CopyOnWriteArrayList<rhx> u = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<rhx> v = new CopyOnWriteArrayList();
  
  private void buv()
  {
    this.u.add(this.jdField_a_of_type_Rhx);
    String str;
    if (this.jdField_a_of_type_Rhx.mode == 102)
    {
      str = ((rif)this.jdField_a_of_type_Rhx).mId;
      if (!DoodleLayout.aHL) {
        break label73;
      }
      ras.sp(K(str, 0));
    }
    for (;;)
    {
      if (this.brB != -1) {
        ((rif)this.jdField_a_of_type_Rhx).brB = this.brB;
      }
      return;
      label73:
      ras.so(K(str, 0));
    }
  }
  
  private boolean eT(int paramInt)
  {
    return (paramInt == 103) || (paramInt == 104) || (paramInt == 105);
  }
  
  public int[] A()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    if (this.u.isEmpty()) {
      return arrayOfInt;
    }
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      rhx localrhx = (rhx)localIterator.next();
      if ((localrhx.mode == 103) || (localrhx.mode == 104)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  String K(String paramString, int paramInt)
  {
    String str2 = "";
    String str1;
    if ("doodle_fireworks".equals(paramString)) {
      if (paramInt == 0) {
        if (DoodleLayout.aHL) {
          str1 = "0X80079F0";
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return str1;
                return "0X80079EE";
                str1 = str2;
              } while (paramInt != 1);
              if (DoodleLayout.aHL) {
                return "0X80079F1";
              }
              return "0X80079EF";
              if (!"doodle_image_xin".equals(paramString)) {
                break;
              }
              if (paramInt == 0)
              {
                if (DoodleLayout.aHL) {
                  return "0X80079EB";
                }
                return "0X80079E9";
              }
              str1 = str2;
            } while (paramInt != 1);
            if (DoodleLayout.aHL) {
              return "0X80079EC";
            }
            return "0X80079EA";
            if (!"doodle_image_mouth".equals(paramString)) {
              break;
            }
            if (paramInt == 0)
            {
              if (DoodleLayout.aHL) {
                return "0X80079E7";
              }
              return "0X80079E5";
            }
            str1 = str2;
          } while (paramInt != 1);
          if (DoodleLayout.aHL) {
            return "0X80079E8";
          }
          return "0X80079E6";
          if (!"doodle_highlighter".equals(paramString)) {
            break;
          }
          if (paramInt == 0)
          {
            if (DoodleLayout.aHL) {
              return "0X80079E3";
            }
            return "0X8007C0A";
          }
          str1 = str2;
        } while (paramInt != 1);
        if (DoodleLayout.aHL) {
          return "0X80079E4";
        }
        return "0X8007C0B";
        str1 = str2;
      } while (!"doodle_image_family".equals(paramString));
      if (paramInt == 0)
      {
        if (DoodleLayout.aHL) {
          return "0X8007C06";
        }
        return "0X8007C08";
      }
      str1 = str2;
    } while (paramInt != 1);
    if (DoodleLayout.aHL) {
      return "0X8007C07";
    }
    return "0X8007C09";
  }
  
  public boolean Lt()
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext()) {
      if (((rhx)localIterator.next()).mode == 102) {
        return true;
      }
    }
    return false;
  }
  
  public boolean Lu()
  {
    return this.jdField_a_of_type_Rig.aIc;
  }
  
  public boolean Lv()
  {
    if (!this.u.isEmpty())
    {
      rhx localrhx = (rhx)this.u.remove(this.u.size() - 1);
      this.v.add(localrhx);
      ras.so("0X80076BF");
      ras.sp("0X80075CC");
      if ((localrhx.mode == 103) || (localrhx.mode == 104) || (localrhx.mode == 105)) {
        this.jdField_a_of_type_Rib.a((ria)localrhx);
      }
      for (;;)
      {
        return true;
        if (localrhx.mode == 102)
        {
          buu();
          this.jdField_a_of_type_Rig.bum();
        }
      }
    }
    return false;
  }
  
  public void N(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Rhn != null) {
      this.jdField_a_of_type_Rhn.M(paramRunnable);
    }
  }
  
  public void a(rhn paramrhn)
  {
    this.jdField_a_of_type_Rhn = paramrhn;
  }
  
  public void a(rhx paramrhx)
  {
    this.jdField_a_of_type_Rhx = paramrhx;
  }
  
  public void a(rhy.a parama)
  {
    this.jdField_a_of_type_Rhy$a = parama;
  }
  
  public boolean a(int paramInt, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = Math.round(paramMotionEvent.getY());
    int j = Math.round(paramMotionEvent.getX());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      rhz localrhz = b(paramInt);
      if (localrhz != null) {
        bool = localrhz.onTouchEvent(paramMotionEvent);
      }
      return bool;
      this.mDownX = Math.round(paramMotionEvent.getX());
      this.mDownY = Math.round(paramMotionEvent.getY());
      continue;
      if ((Math.abs(j - this.mDownX) < 3) && (Math.abs(i - this.mDownY) < 3) && (this.jdField_a_of_type_Rhx != null))
      {
        if (eT(paramInt)) {
          buv();
        }
        this.jdField_a_of_type_Rhx = null;
        continue;
        if (((Math.abs(j - this.mDownX) >= 3) || (Math.abs(i - this.mDownY) >= 3)) && (this.jdField_a_of_type_Rhx != null))
        {
          buv();
          this.jdField_a_of_type_Rhx = null;
        }
      }
    }
  }
  
  public void apk()
  {
    this.u.clear();
    this.jdField_a_of_type_Rij.apk();
    this.jdField_a_of_type_Rib.clear();
    this.jdField_a_of_type_Rig.apk();
  }
  
  public void aq(Canvas paramCanvas)
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      rhx localrhx = (rhx)localIterator.next();
      if (localrhx.mode == 104) {
        this.jdField_a_of_type_Rib.a(paramCanvas, (ria)localrhx, 0.0F);
      }
    }
  }
  
  public rhz b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 101: 
      return this.jdField_a_of_type_Rij;
    case 102: 
      return this.jdField_a_of_type_Rig;
    }
    return this.jdField_a_of_type_Rib;
  }
  
  public void b(AppInterface paramAppInterface, int paramInt)
  {
    this.brB = -1;
    if (this.brz == paramInt) {}
    do
    {
      return;
      paramAppInterface = PtvTemplateManager.a(paramAppInterface).fd(paramInt);
      if (paramAppInterface != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("DoodleOpController", 2, "changeStroke error ");
    return;
    paramAppInterface = QQTemplateParser.parseVideoMaterial(paramAppInterface, "params");
    VideoMemoryManager.getInstance().loadAllImages(paramAppInterface);
    this.jdField_a_of_type_Rig.setVideoFilter(paramAppInterface);
    this.brz = paramInt;
    ram.d("DoodleOpController", "change stroke" + paramInt);
  }
  
  public void buo()
  {
    if (this.jdField_a_of_type_Rhn != null) {
      this.jdField_a_of_type_Rhn.buf();
    }
  }
  
  public void bup()
  {
    if ((this.cG != null) && (!this.cG.isRecycled()))
    {
      this.cG.recycle();
      this.cG = null;
    }
  }
  
  public void buq()
  {
    this.jdField_a_of_type_Rig.onInit();
  }
  
  public void bur()
  {
    System.currentTimeMillis();
    this.jdField_a_of_type_Rig.buJ();
    System.currentTimeMillis();
    int i = 0;
    while (i < this.u.size())
    {
      Object localObject = (rhx)this.u.get(i);
      if (((rhx)localObject).mode == 102)
      {
        localObject = (rif)localObject;
        this.jdField_a_of_type_Rig.a((rif)localObject);
      }
      i += 1;
    }
    System.currentTimeMillis();
    this.jdField_a_of_type_Rig.buK();
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {}
  }
  
  public void bus()
  {
    if (!this.v.isEmpty())
    {
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext()) {
        ((rhx)localIterator.next()).onDestroy();
      }
    }
  }
  
  public void but()
  {
    if (!this.u.isEmpty())
    {
      int i = 0;
      while (i < this.u.size())
      {
        ((rhx)this.u.get(i)).onDestroy();
        i += 1;
      }
    }
    if (!this.v.isEmpty())
    {
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext()) {
        ((rhx)localIterator.next()).onDestroy();
      }
    }
    ram.d("Personality", "releaseAllPaths");
  }
  
  public void buu()
  {
    int i = this.u.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (((rhx)this.u.get(i)).mode == 102)
        {
          rif localrif = (rif)this.u.get(i);
          localrif.aHV = false;
          if (!localrif.aHW) {}
        }
      }
      else {
        return;
      }
      i -= 1;
    }
  }
  
  public void buw()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.u.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (rhx)((Iterator)localObject2).next();
      if (((rhx)localObject3).mode == 102)
      {
        localObject3 = K(((rif)localObject3).mId, 1);
        if (!((HashSet)localObject1).contains(localObject3)) {
          ((HashSet)localObject1).add(localObject3);
        }
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (DoodleLayout.aHL) {
        ras.sp((String)localObject2);
      } else {
        ras.so((String)localObject2);
      }
    }
  }
  
  public void c(Canvas paramCanvas, float paramFloat)
  {
    if ((this.u.isEmpty()) && (Build.MODEL.contains("vivo X5"))) {
      paramCanvas.drawColor(0);
    }
    Object localObject1 = null;
    Object localObject3 = this.u.iterator();
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (rhx)((Iterator)localObject3).next();
      if (((rhx)localObject2).mode != 105) {
        break label197;
      }
      localObject1 = localObject2;
    }
    label197:
    for (;;)
    {
      break;
      localObject2 = this.u.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (rhx)((Iterator)localObject2).next();
        if (((rhx)localObject3).mode == 101)
        {
          this.jdField_a_of_type_Rij.a(paramCanvas, (rhx)localObject3, this.jdField_a_of_type_Rij.i());
        }
        else if (((rhx)localObject3).mode == 105)
        {
          this.jdField_a_of_type_Rib.a(paramCanvas, (ria)localObject3, paramFloat);
          if (localObject3 == localObject1) {
            this.jdField_a_of_type_Rib.buD();
          }
        }
      }
      if (localObject1 == null) {
        this.jdField_a_of_type_Rib.tN(true);
      }
      this.jdField_a_of_type_Rij.btP();
      return;
    }
  }
  
  public List<String> ce()
  {
    if (this.u.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.u.iterator();
    label130:
    for (;;)
    {
      Object localObject;
      if (localIterator1.hasNext())
      {
        localObject = (rhx)localIterator1.next();
        if (((rhx)localObject).mode == 102)
        {
          localObject = (rif)localObject;
          Iterator localIterator2 = localArrayList.iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
          } while (!TextUtils.equals((String)localIterator2.next(), ((rif)localObject).mId));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label130;
          }
          localArrayList.add(((rif)localObject).mId);
          break;
          return localArrayList;
        }
      }
    }
  }
  
  public void d(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (rhx)localIterator.next();
      if (((rhx)localObject).mode == 101)
      {
        localObject = new rii((rhx)localObject, 1.0F);
        this.jdField_a_of_type_Rij.a(paramCanvas, (rhx)localObject, this.jdField_a_of_type_Rij.h());
      }
    }
    paramCanvas.restore();
  }
  
  public void e(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (rhx)localIterator.next();
      if (((rhx)localObject).mode == 104)
      {
        localObject = new ria((rhx)localObject, 1.0F);
        this.jdField_a_of_type_Rib.a(paramCanvas, (ria)localObject, 0.0F);
      }
    }
    paramCanvas.restore();
  }
  
  public boolean isEmpty()
  {
    if (Lt()) {
      return false;
    }
    if (this.u.isEmpty()) {
      return true;
    }
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext()) {
      if (((rhx)localIterator.next()).mode != 103) {
        return false;
      }
    }
    return true;
  }
  
  public void onDestroy()
  {
    bup();
  }
  
  public int tt()
  {
    return this.u.size();
  }
  
  public void v(Bitmap paramBitmap)
  {
    this.cG = paramBitmap;
    this.aHP = false;
    if (this.jdField_a_of_type_Rhy$a != null) {
      this.jdField_a_of_type_Rhy$a.bsE();
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "saveStillBitmap end bitmap:" + paramBitmap);
    }
  }
  
  public void xt(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "preSavePersonality");
    }
    this.jdField_a_of_type_Rig.xt(paramInt);
  }
  
  public void xu(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "savePersonality start");
    }
    this.jdField_a_of_type_Rig.xt(paramInt);
    try
    {
      this.brC = 0;
      this.aHP = true;
      while ((this.brC < 25) && (this.aHP))
      {
        Thread.sleep(200L);
        this.brC += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoodleOpController", 2, "savePersonality error " + localException.toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoodleOpController", 2, "savePersonality end");
      }
    }
  }
  
  public void xv(int paramInt)
  {
    if (paramInt != this.brA)
    {
      if (paramInt != 0) {
        break label56;
      }
      buu();
      this.jdField_a_of_type_Rig.tO(false);
    }
    for (;;)
    {
      this.brA = paramInt;
      ram.d("DoodleOpController", "refresh visibility:" + paramInt);
      return;
      label56:
      this.jdField_a_of_type_Rig.buL();
    }
  }
  
  public void xw(int paramInt)
  {
    if (paramInt == 101) {
      this.jdField_a_of_type_Rij.btP();
    }
    do
    {
      return;
      if (paramInt == 104)
      {
        this.jdField_a_of_type_Rib.btP();
        return;
      }
    } while (paramInt != 105);
    this.jdField_a_of_type_Rib.btP();
  }
  
  public static abstract interface a
  {
    public abstract void bsE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rhy
 * JD-Core Version:    0.7.0.1
 */