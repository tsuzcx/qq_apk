import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aymk
  implements aymi
{
  aylt jdField_a_of_type_Aylt;
  aymj jdField_a_of_type_Aymj = null;
  aymk.a jdField_a_of_type_Aymk$a;
  aymp jdField_a_of_type_Aymp = new aymp(this);
  public aymu a;
  aymy jdField_a_of_type_Aymy = new aymy(this);
  boolean aHP = false;
  int brA = -1;
  int brB = -1;
  int brC = 0;
  int brz = -1;
  public Bitmap cG;
  private boolean dzW;
  int mDownX = -1;
  int mDownY = -1;
  public CopyOnWriteArrayList<aymj> u = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<aymj> v = new CopyOnWriteArrayList();
  
  public aymk()
  {
    this.jdField_a_of_type_Aymu = new aymu(this);
  }
  
  private void buv()
  {
    this.u.add(this.jdField_a_of_type_Aymj);
    String str;
    if (this.jdField_a_of_type_Aymj.mode == 102)
    {
      str = ((aymt)this.jdField_a_of_type_Aymj).mId;
      if (!DoodleLayout.aHL) {
        break label73;
      }
      ras.sp(K(str, 0));
    }
    for (;;)
    {
      if (this.brB != -1) {
        ((aymt)this.jdField_a_of_type_Aymj).brB = this.brB;
      }
      return;
      label73:
      ras.so(K(str, 0));
    }
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
      aymj localaymj = (aymj)localIterator.next();
      if ((localaymj.mode == 103) || (localaymj.mode == 104)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public boolean E(JSONObject paramJSONObject)
  {
    if ((this.u == null) || (this.u.isEmpty())) {
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((CopyOnWriteArrayList)this.u.clone()).iterator();
      while (localIterator.hasNext())
      {
        aymj localaymj = (aymj)localIterator.next();
        JSONObject localJSONObject = localaymj.am();
        if ((localJSONObject != null) && ((localaymj instanceof aymo)))
        {
          localJSONObject.put("mosaicBitmapW", this.jdField_a_of_type_Aymp.brG);
          localJSONObject.put("mosaicBitmapH", this.jdField_a_of_type_Aymp.brH);
        }
        localJSONArray.put(localJSONObject);
      }
      paramJSONObject.put(ayju.cWP, localJSONArray);
      return true;
    }
    catch (Exception paramJSONObject) {}
    return false;
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
      if (((aymj)localIterator.next()).mode == 102) {
        return true;
      }
    }
    return false;
  }
  
  public boolean Lu()
  {
    return this.jdField_a_of_type_Aymu.aIc;
  }
  
  public boolean Lv()
  {
    if (!this.u.isEmpty())
    {
      aymj localaymj = (aymj)this.u.remove(this.u.size() - 1);
      this.v.add(localaymj);
      ras.so("0X80076BF");
      ras.sp("0X80075CC");
      if ((localaymj.mode == 103) || (localaymj.mode == 104) || (localaymj.mode == 105)) {
        this.jdField_a_of_type_Aymp.a((aymo)localaymj);
      }
      for (;;)
      {
        return true;
        if (localaymj.mode == 102)
        {
          buu();
          this.jdField_a_of_type_Aymu.bum();
        }
      }
    }
    return false;
  }
  
  public void N(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Aylt != null) {
      this.jdField_a_of_type_Aylt.M(paramRunnable);
    }
  }
  
  public int RY()
  {
    return this.brz;
  }
  
  public void a(aylt paramaylt)
  {
    this.jdField_a_of_type_Aylt = paramaylt;
  }
  
  public void a(aymj paramaymj)
  {
    this.jdField_a_of_type_Aymj = paramaymj;
  }
  
  public void a(aymk.a parama)
  {
    this.jdField_a_of_type_Aymk$a = parama;
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
      ayml localayml = b(paramInt);
      if (localayml != null) {
        bool = localayml.onTouchEvent(paramMotionEvent);
      }
      return bool;
      this.mDownX = Math.round(paramMotionEvent.getX());
      this.mDownY = Math.round(paramMotionEvent.getY());
      continue;
      if ((Math.abs(j - this.mDownX) < 3) && (Math.abs(i - this.mDownY) < 3) && (this.jdField_a_of_type_Aymj != null))
      {
        this.jdField_a_of_type_Aymj = null;
        continue;
        if (((Math.abs(j - this.mDownX) >= 3) || (Math.abs(i - this.mDownY) >= 3)) && (this.jdField_a_of_type_Aymj != null))
        {
          buv();
          this.jdField_a_of_type_Aymj = null;
        }
      }
    }
  }
  
  public void apk()
  {
    this.u.clear();
    this.jdField_a_of_type_Aymy.apk();
    this.jdField_a_of_type_Aymp.clear();
    this.jdField_a_of_type_Aymu.apk();
  }
  
  public void aq(Canvas paramCanvas)
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      aymj localaymj = (aymj)localIterator.next();
      if (localaymj.mode == 104) {
        this.jdField_a_of_type_Aymp.a(paramCanvas, (aymo)localaymj, 0.0F);
      }
    }
  }
  
  public ayml b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 101: 
      return this.jdField_a_of_type_Aymy;
    case 102: 
      return this.jdField_a_of_type_Aymu;
    }
    return this.jdField_a_of_type_Aymp;
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
    this.jdField_a_of_type_Aymu.setVideoFilter(paramAppInterface);
    this.brz = paramInt;
    ram.d("DoodleOpController", "change stroke" + paramInt);
  }
  
  public void buo()
  {
    if (this.jdField_a_of_type_Aylt != null) {
      this.jdField_a_of_type_Aylt.buf();
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
    this.jdField_a_of_type_Aymu.onInit();
  }
  
  public void bur()
  {
    System.currentTimeMillis();
    this.jdField_a_of_type_Aymu.buJ();
    System.currentTimeMillis();
    int i = 0;
    while (i < this.u.size())
    {
      Object localObject = (aymj)this.u.get(i);
      if (((aymj)localObject).mode == 102)
      {
        localObject = (aymt)localObject;
        this.jdField_a_of_type_Aymu.a((aymt)localObject);
      }
      i += 1;
    }
    System.currentTimeMillis();
    this.jdField_a_of_type_Aymu.buK();
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {}
  }
  
  public void bus()
  {
    if (!this.v.isEmpty())
    {
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext()) {
        ((aymj)localIterator.next()).onDestroy();
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
        ((aymj)this.u.get(i)).onDestroy();
        i += 1;
      }
    }
    if (!this.v.isEmpty())
    {
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext()) {
        ((aymj)localIterator.next()).onDestroy();
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
        if (((aymj)this.u.get(i)).mode == 102)
        {
          aymt localaymt = (aymt)this.u.get(i);
          localaymt.aHV = false;
          if (!localaymt.aHW) {}
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
      Object localObject3 = (aymj)((Iterator)localObject2).next();
      if (((aymj)localObject3).mode == 102)
      {
        localObject3 = K(((aymt)localObject3).mId, 1);
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
    if ((this.u.isEmpty()) && (this.dzW))
    {
      paramCanvas.drawColor(0);
      this.dzW = false;
    }
    Object localObject1 = null;
    Object localObject3 = this.u.iterator();
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (aymj)((Iterator)localObject3).next();
      if (((aymj)localObject2).mode != 105) {
        break label214;
      }
      localObject1 = localObject2;
    }
    label214:
    for (;;)
    {
      break;
      localObject2 = this.u.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (aymj)((Iterator)localObject2).next();
        if (((aymj)localObject3).mode == 101)
        {
          this.dzW = true;
          this.jdField_a_of_type_Aymy.a(paramCanvas, (aymj)localObject3, this.jdField_a_of_type_Aymy.i());
        }
        else if (((aymj)localObject3).mode == 105)
        {
          this.dzW = true;
          this.jdField_a_of_type_Aymp.a(paramCanvas, (aymo)localObject3, paramFloat);
          if (localObject3 == localObject1) {
            this.jdField_a_of_type_Aymp.buD();
          }
        }
      }
      if ((localObject1 == null) && (this.dzW)) {
        this.jdField_a_of_type_Aymp.tN(true);
      }
      this.jdField_a_of_type_Aymy.btP();
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
        localObject = (aymj)localIterator1.next();
        if (((aymj)localObject).mode == 102)
        {
          localObject = (aymt)localObject;
          Iterator localIterator2 = localArrayList.iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
          } while (!TextUtils.equals((String)localIterator2.next(), ((aymt)localObject).mId));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label130;
          }
          localArrayList.add(((aymt)localObject).mId);
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
      Object localObject = (aymj)localIterator.next();
      if (((aymj)localObject).mode == 101)
      {
        localObject = new aymx((aymj)localObject, 1.0F);
        this.jdField_a_of_type_Aymy.a(paramCanvas, (aymj)localObject, this.jdField_a_of_type_Aymy.h());
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
      Object localObject = (aymj)localIterator.next();
      if (((aymj)localObject).mode == 104)
      {
        localObject = new aymo((aymj)localObject, 1.0F);
        this.jdField_a_of_type_Aymp.a(paramCanvas, (aymo)localObject, 0.0F);
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
      if (((aymj)localIterator.next()).mode != 103) {
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
    if (this.jdField_a_of_type_Aymk$a != null) {
      this.jdField_a_of_type_Aymk$a.bsE();
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
    this.jdField_a_of_type_Aymu.xt(paramInt);
  }
  
  public void xu(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "savePersonality start");
    }
    this.jdField_a_of_type_Aymu.xt(paramInt);
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
      this.jdField_a_of_type_Aymu.tO(false);
    }
    for (;;)
    {
      this.brA = paramInt;
      ram.d("DoodleOpController", "refresh visibility:" + paramInt);
      return;
      label56:
      this.jdField_a_of_type_Aymu.buL();
    }
  }
  
  public void xw(int paramInt)
  {
    if (paramInt == 101) {
      this.jdField_a_of_type_Aymy.btP();
    }
    do
    {
      return;
      if (paramInt == 104)
      {
        this.jdField_a_of_type_Aymp.btP();
        return;
      }
    } while (paramInt != 105);
    this.jdField_a_of_type_Aymp.btP();
  }
  
  public static abstract interface a
  {
    public abstract void bsE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymk
 * JD-Core Version:    0.7.0.1
 */