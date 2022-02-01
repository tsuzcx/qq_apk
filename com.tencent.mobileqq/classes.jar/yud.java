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

public class yud
  implements yub
{
  int jdField_a_of_type_Int = -1;
  public Bitmap a;
  CopyOnWriteArrayList<yuc> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  yth jdField_a_of_type_Yth;
  yuc jdField_a_of_type_Yuc = null;
  yue jdField_a_of_type_Yue;
  yuh jdField_a_of_type_Yuh = new yuh(this);
  yum jdField_a_of_type_Yum = new yum(this);
  yup jdField_a_of_type_Yup = new yup(this);
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  CopyOnWriteArrayList<yuc> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  int c = -1;
  int d = -1;
  int e = -1;
  int f = 0;
  
  private boolean a(int paramInt)
  {
    return (paramInt == 103) || (paramInt == 104) || (paramInt == 105);
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Yuc);
    String str;
    if (this.jdField_a_of_type_Yuc.jdField_a_of_type_Int == 102)
    {
      str = ((yul)this.jdField_a_of_type_Yuc).jdField_a_of_type_JavaLangString;
      if (!DoodleLayout.jdField_a_of_type_Boolean) {
        break label73;
      }
      ykw.b(a(str, 0));
    }
    for (;;)
    {
      if (this.e != -1) {
        ((yul)this.jdField_a_of_type_Yuc).jdField_b_of_type_Int = this.e;
      }
      return;
      label73:
      ykw.a(a(str, 0));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
  }
  
  String a(String paramString, int paramInt)
  {
    String str2 = "";
    String str1;
    if ("doodle_fireworks".equals(paramString)) {
      if (paramInt == 0) {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
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
              if (DoodleLayout.jdField_a_of_type_Boolean) {
                return "0X80079F1";
              }
              return "0X80079EF";
              if (!"doodle_image_xin".equals(paramString)) {
                break;
              }
              if (paramInt == 0)
              {
                if (DoodleLayout.jdField_a_of_type_Boolean) {
                  return "0X80079EB";
                }
                return "0X80079E9";
              }
              str1 = str2;
            } while (paramInt != 1);
            if (DoodleLayout.jdField_a_of_type_Boolean) {
              return "0X80079EC";
            }
            return "0X80079EA";
            if (!"doodle_image_mouth".equals(paramString)) {
              break;
            }
            if (paramInt == 0)
            {
              if (DoodleLayout.jdField_a_of_type_Boolean) {
                return "0X80079E7";
              }
              return "0X80079E5";
            }
            str1 = str2;
          } while (paramInt != 1);
          if (DoodleLayout.jdField_a_of_type_Boolean) {
            return "0X80079E8";
          }
          return "0X80079E6";
          if (!"doodle_highlighter".equals(paramString)) {
            break;
          }
          if (paramInt == 0)
          {
            if (DoodleLayout.jdField_a_of_type_Boolean) {
              return "0X80079E3";
            }
            return "0X8007C0A";
          }
          str1 = str2;
        } while (paramInt != 1);
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X80079E4";
        }
        return "0X8007C0B";
        str1 = str2;
      } while (!"doodle_image_family".equals(paramString));
      if (paramInt == 0)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X8007C06";
        }
        return "0X8007C08";
      }
      str1 = str2;
    } while (paramInt != 1);
    if (DoodleLayout.jdField_a_of_type_Boolean) {
      return "0X8007C07";
    }
    return "0X8007C09";
  }
  
  public List<String> a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    label130:
    for (;;)
    {
      Object localObject;
      if (localIterator1.hasNext())
      {
        localObject = (yuc)localIterator1.next();
        if (((yuc)localObject).jdField_a_of_type_Int == 102)
        {
          localObject = (yul)localObject;
          Iterator localIterator2 = localArrayList.iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
          } while (!TextUtils.equals((String)localIterator2.next(), ((yul)localObject).jdField_a_of_type_JavaLangString));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label130;
          }
          localArrayList.add(((yul)localObject).jdField_a_of_type_JavaLangString);
          break;
          return localArrayList;
        }
      }
    }
  }
  
  public yuf a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 101: 
      return this.jdField_a_of_type_Yup;
    case 102: 
      return this.jdField_a_of_type_Yum;
    }
    return this.jdField_a_of_type_Yuh;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Yth != null) {
      this.jdField_a_of_type_Yth.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "preSavePersonality");
    }
    this.jdField_a_of_type_Yum.a(paramInt);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Yue != null) {
      this.jdField_a_of_type_Yue.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "saveStillBitmap end bitmap:" + paramBitmap);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      yuc localyuc = (yuc)localIterator.next();
      if (localyuc.jdField_a_of_type_Int == 104) {
        this.jdField_a_of_type_Yuh.a(paramCanvas, (yug)localyuc, 0.0F);
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) && (Build.MODEL.contains("vivo X5"))) {
      paramCanvas.drawColor(0);
    }
    Object localObject1 = null;
    Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (yuc)((Iterator)localObject3).next();
      if (((yuc)localObject2).jdField_a_of_type_Int != 105) {
        break label196;
      }
      localObject1 = localObject2;
    }
    label196:
    for (;;)
    {
      break;
      localObject2 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (yuc)((Iterator)localObject2).next();
        if (((yuc)localObject3).jdField_a_of_type_Int == 101)
        {
          this.jdField_a_of_type_Yup.a(paramCanvas, (yuc)localObject3, this.jdField_a_of_type_Yup.b());
        }
        else if (((yuc)localObject3).jdField_a_of_type_Int == 105)
        {
          this.jdField_a_of_type_Yuh.a(paramCanvas, (yug)localObject3, paramFloat);
          if (localObject3 == localObject1) {
            this.jdField_a_of_type_Yuh.c();
          }
        }
      }
      if (localObject1 == null) {
        this.jdField_a_of_type_Yuh.a(true);
      }
      this.jdField_a_of_type_Yup.a();
      return;
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt)
  {
    this.e = -1;
    if (this.jdField_a_of_type_Int == paramInt) {}
    do
    {
      return;
      paramAppInterface = PtvTemplateManager.a(paramAppInterface).a(paramInt);
      if (paramAppInterface != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("DoodleOpController", 2, "changeStroke error ");
    return;
    paramAppInterface = QQTemplateParser.parseVideoMaterial(paramAppInterface, "params");
    VideoMemoryManager.getInstance().loadAllImages(paramAppInterface);
    this.jdField_a_of_type_Yum.a(paramAppInterface);
    this.jdField_a_of_type_Int = paramInt;
    ykq.b("DoodleOpController", "change stroke" + paramInt);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Yth != null) {
      this.jdField_a_of_type_Yth.a(paramRunnable);
    }
  }
  
  public void a(yth paramyth)
  {
    this.jdField_a_of_type_Yth = paramyth;
  }
  
  public void a(yuc paramyuc)
  {
    this.jdField_a_of_type_Yuc = paramyuc;
  }
  
  public void a(yue paramyue)
  {
    this.jdField_a_of_type_Yue = paramyue;
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((yuc)localIterator.next()).jdField_a_of_type_Int == 102) {
        return true;
      }
    }
    return false;
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
      yuf localyuf = a(paramInt);
      if (localyuf != null) {
        bool = localyuf.a(paramMotionEvent);
      }
      return bool;
      this.c = Math.round(paramMotionEvent.getX());
      this.d = Math.round(paramMotionEvent.getY());
      continue;
      if ((Math.abs(j - this.c) < 3) && (Math.abs(i - this.d) < 3) && (this.jdField_a_of_type_Yuc != null))
      {
        if (a(paramInt)) {
          k();
        }
        this.jdField_a_of_type_Yuc = null;
        continue;
        if (((Math.abs(j - this.c) >= 3) || (Math.abs(i - this.d) >= 3)) && (this.jdField_a_of_type_Yuc != null))
        {
          k();
          this.jdField_a_of_type_Yuc = null;
        }
      }
    }
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) {
      return arrayOfInt;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      yuc localyuc = (yuc)localIterator.next();
      if ((localyuc.jdField_a_of_type_Int == 103) || (localyuc.jdField_a_of_type_Int == 104)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public void b()
  {
    c();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "savePersonality start");
    }
    this.jdField_a_of_type_Yum.a(paramInt);
    try
    {
      this.f = 0;
      this.jdField_a_of_type_Boolean = true;
      while ((this.f < 25) && (this.jdField_a_of_type_Boolean))
      {
        Thread.sleep(200L);
        this.f += 1;
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
  
  public void b(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (yuc)localIterator.next();
      if (((yuc)localObject).jdField_a_of_type_Int == 101)
      {
        localObject = new yuo((yuc)localObject, 1.0F);
        this.jdField_a_of_type_Yup.a(paramCanvas, (yuc)localObject, this.jdField_a_of_type_Yup.a());
      }
    }
    paramCanvas.restore();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Yum.d;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt != this.jdField_b_of_type_Int)
    {
      if (paramInt != 0) {
        break label55;
      }
      h();
      this.jdField_a_of_type_Yum.a(false);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt;
      ykq.b("DoodleOpController", "refresh visibility:" + paramInt);
      return;
      label55:
      this.jdField_a_of_type_Yum.h();
    }
  }
  
  public void c(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (yuc)localIterator.next();
      if (((yuc)localObject).jdField_a_of_type_Int == 104)
      {
        localObject = new yug((yuc)localObject, 1.0F);
        this.jdField_a_of_type_Yuh.a(paramCanvas, (yug)localObject, 0.0F);
      }
    }
    paramCanvas.restore();
  }
  
  public boolean c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      yuc localyuc = (yuc)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() - 1);
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localyuc);
      ykw.a("0X80076BF");
      ykw.b("0X80075CC");
      if ((localyuc.jdField_a_of_type_Int == 103) || (localyuc.jdField_a_of_type_Int == 104) || (localyuc.jdField_a_of_type_Int == 105)) {
        this.jdField_a_of_type_Yuh.a((yug)localyuc);
      }
      for (;;)
      {
        return true;
        if (localyuc.jdField_a_of_type_Int == 102)
        {
          h();
          this.jdField_a_of_type_Yum.f();
        }
      }
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Yum.a();
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 101) {
      this.jdField_a_of_type_Yup.a();
    }
    do
    {
      return;
      if (paramInt == 104)
      {
        this.jdField_a_of_type_Yuh.a();
        return;
      }
    } while (paramInt != 105);
    this.jdField_a_of_type_Yuh.a();
  }
  
  public boolean d()
  {
    if (a()) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((yuc)localIterator.next()).jdField_a_of_type_Int != 103) {
        return false;
      }
    }
    return true;
  }
  
  public void e()
  {
    System.currentTimeMillis();
    this.jdField_a_of_type_Yum.d();
    System.currentTimeMillis();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      Object localObject = (yuc)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if (((yuc)localObject).jdField_a_of_type_Int == 102)
      {
        localObject = (yul)localObject;
        this.jdField_a_of_type_Yum.a((yul)localObject);
      }
      i += 1;
    }
    System.currentTimeMillis();
    this.jdField_a_of_type_Yum.e();
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {}
  }
  
  public void f()
  {
    if (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((yuc)localIterator.next()).a();
      }
    }
  }
  
  public void g()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        ((yuc)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).a();
        i += 1;
      }
    }
    if (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((yuc)localIterator.next()).a();
      }
    }
    ykq.b("Personality", "releaseAllPaths");
  }
  
  public void h()
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (((yuc)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).jdField_a_of_type_Int == 102)
        {
          yul localyul = (yul)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          localyul.jdField_a_of_type_Boolean = false;
          if (!localyul.c) {}
        }
      }
      else {
        return;
      }
      i -= 1;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Yup.b();
    this.jdField_a_of_type_Yuh.d();
    this.jdField_a_of_type_Yum.g();
  }
  
  public void j()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (yuc)((Iterator)localObject2).next();
      if (((yuc)localObject3).jdField_a_of_type_Int == 102)
      {
        localObject3 = a(((yul)localObject3).jdField_a_of_type_JavaLangString, 1);
        if (!((HashSet)localObject1).contains(localObject3)) {
          ((HashSet)localObject1).add(localObject3);
        }
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (DoodleLayout.jdField_a_of_type_Boolean) {
        ykw.b((String)localObject2);
      } else {
        ykw.a((String)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yud
 * JD-Core Version:    0.7.0.1
 */