import android.graphics.PointF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.b;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class ild
{
  private static ild.b a;
  protected ild.a a;
  protected ild.c a;
  protected ilg a;
  protected final List<ilc> fj = new ArrayList();
  protected VideoAppInterface mApp;
  protected Typeface mTypeface;
  
  public ild(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.jdField_a_of_type_Ilg = ((ilg)this.mApp.a(0));
    paramVideoAppInterface = getID();
    this.jdField_a_of_type_Ilg.d(paramLong, paramVideoAppInterface);
  }
  
  public static PointF a(PointF paramPointF)
  {
    if (jdField_a_of_type_Ild$b == null) {
      jdField_a_of_type_Ild$b = new ild.b();
    }
    jb("static getSmallPointInBigScreen: " + paramPointF.x + "|" + paramPointF.y);
    return jdField_a_of_type_Ild$b.a(paramPointF);
  }
  
  private void a(ijn paramijn, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator = this.fj.iterator();
    int i = 0;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (ilc)localIterator.next();
      localObject2 = localObject1;
      int j = i;
      if (!((ilc)localObject3).a.isEnd())
      {
        localObject2 = localObject1;
        j = i;
        if (((ilc)localObject3).a.uin.equals(paramijn.uin))
        {
          j = 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
          ((ilc)localObject3).a(paramijn);
          igd.aJ("ARZimuTask", "updateTextInner " + paramijn.uin + " onTextChanged info:" + paramijn.l);
        }
      }
      i = j;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (i == 0)
    {
      localObject3 = a(paramijn, paramBoolean);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (((List)localObject3).size() > 0) {
            localObject2 = (ilc)((List)localObject3).get(0);
          }
        }
        this.fj.addAll((Collection)localObject3);
        igd.aJ("ARZimuTask", "updateTextInner " + paramijn.uin + " addinfo:" + paramijn.l);
      }
    }
    a((ilc)localObject2);
  }
  
  public static void aU(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_Ild$b == null) {
      jdField_a_of_type_Ild$b = new ild.b();
    }
    jdField_a_of_type_Ild$b.aV(paramString1, paramString2);
  }
  
  public static void bx(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Ild$b == null) {
      jdField_a_of_type_Ild$b = new ild.b();
    }
    jb("UpdateSmallScreenPosition: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Ild$b.bA(paramInt1, paramInt2);
  }
  
  public static void by(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Ild$b == null) {
      jdField_a_of_type_Ild$b = new ild.b();
    }
    jb("setSmallScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Ild$b.by(paramInt1, paramInt2);
  }
  
  public static void bz(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Ild$b == null) {
      jdField_a_of_type_Ild$b = new ild.b();
    }
    jb("setBigScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_Ild$b.bz(paramInt1, paramInt2);
  }
  
  public static String gR()
  {
    if (jdField_a_of_type_Ild$b == null) {
      jdField_a_of_type_Ild$b = new ild.b();
    }
    return jdField_a_of_type_Ild$b.gR();
  }
  
  public static String gS()
  {
    if (jdField_a_of_type_Ild$b == null) {
      jdField_a_of_type_Ild$b = new ild.b();
    }
    return jdField_a_of_type_Ild$b.gS();
  }
  
  private void handlerObserver(Observable paramObservable, Object paramObject)
  {
    ((Integer)((Object[])(Object[])paramObject)[0]).intValue();
    b(paramObservable, paramObject);
  }
  
  public static void ij(boolean paramBoolean)
  {
    if (jdField_a_of_type_Ild$b == null) {
      jdField_a_of_type_Ild$b = new ild.b();
    }
    jdField_a_of_type_Ild$b.ik(paramBoolean);
  }
  
  public static void jb(String paramString)
  {
    if (paramString == null) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ARZimuTask", 2, paramString);
  }
  
  public static void kV(int paramInt)
  {
    if (jdField_a_of_type_Ild$b == null) {
      jdField_a_of_type_Ild$b = new ild.b();
    }
    jb("getSmallScreenPositionType: " + paramInt);
    jdField_a_of_type_Ild$b.kV(paramInt);
  }
  
  public ild.c a()
  {
    return this.jdField_a_of_type_Ild$c;
  }
  
  protected abstract List<ilc> a(ijn paramijn, boolean paramBoolean);
  
  abstract void a(ilc paramilc);
  
  public void a(ild.c paramc)
  {
    this.jdField_a_of_type_Ild$c = paramc;
  }
  
  protected void anO()
  {
    String str;
    Object localObject;
    if ((this.mTypeface == null) && (this.jdField_a_of_type_Ilg != null))
    {
      str = getID();
      localObject = (ZimuItem)this.jdField_a_of_type_Ilg.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_Ilg.b((EffectConfigBase.b)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new File((String)localObject + "font.ttf");
          if (!((File)localObject).exists()) {
            break label136;
          }
        }
      }
    }
    label136:
    while (!AudioHelper.aCz()) {
      try
      {
        this.mTypeface = Typeface.createFromFile((File)localObject);
        return;
      }
      catch (Exception localException)
      {
        while (!AudioHelper.aCz()) {}
        QLog.w("ARZimuTask", 1, "createTypeface, Exception, id[" + str + "]", localException);
        return;
      }
    }
    QLog.w("ARZimuTask", 1, "createTypeface, 不存在, file[" + localException.getAbsolutePath() + "], id[" + str + "]");
  }
  
  public void b(ijn paramijn)
  {
    if ((paramijn == null) || (TextUtils.isEmpty(paramijn.l)) || (TextUtils.isEmpty(paramijn.uin)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramijn == null) {}
      for (paramijn = null;; paramijn = paramijn.toString())
      {
        igd.aL("ARZimuTask", paramijn);
        return;
      }
    }
    igd.aJ("ARZimuTask", "updateText :" + paramijn.toString());
    if (!this.jdField_a_of_type_Ilg.tP()) {
      this.jdField_a_of_type_Ilg.X("updateText1", true);
    }
    a(paramijn, false);
  }
  
  protected void b(Observable paramObservable, Object paramObject) {}
  
  public String gT()
  {
    Object localObject = getID();
    localObject = (ZimuItem)this.jdField_a_of_type_Ilg.a((String)localObject);
    if (localObject != null) {}
    for (localObject = this.jdField_a_of_type_Ilg.b((EffectConfigBase.b)localObject);; localObject = "")
    {
      igd.aJ("ARZimuTask", "getGamePlayResoucePath path = " + (String)localObject);
      return localObject;
    }
  }
  
  public abstract String getID();
  
  public void init()
  {
    this.jdField_a_of_type_Ild$a = new ild.a(this);
    this.mApp.addObserver(this.jdField_a_of_type_Ild$a);
  }
  
  public abstract int kX();
  
  public void stop()
  {
    if (this.jdField_a_of_type_Ild$a != null) {
      this.mApp.deleteObserver(this.jdField_a_of_type_Ild$a);
    }
  }
  
  static class a
    implements Observer
  {
    private WeakReference<ild> bk;
    
    public a(ild paramild)
    {
      this.bk = new WeakReference(paramild);
    }
    
    public void update(Observable paramObservable, Object paramObject)
    {
      ild localild = (ild)this.bk.get();
      if (localild == null) {
        return;
      }
      ild.a(localild, paramObservable, paramObject);
    }
  }
  
  public static class b
  {
    String NF = null;
    String NG = null;
    volatile boolean Sb = false;
    int aos = 0;
    int aot = 0;
    int aou = 0;
    int aov = 0;
    int aow = 0;
    int aox = 0;
    int aoy = 0;
    
    public PointF a(PointF paramPointF)
    {
      if ((!tN()) || (paramPointF == null)) {
        return null;
      }
      float f1 = paramPointF.x * this.aov;
      float f2 = paramPointF.y * this.aou;
      float f4 = this.aos;
      float f3 = this.aot;
      f4 = (f4 + f1) / this.aox;
      f3 = (f3 + f2) / this.aow;
      ild.jb("getSmallPointInBigScreen: " + f1 + "|" + f2 + "|" + f4 + "|" + f3 + "|" + this.aos + "|" + this.aot);
      return new PointF(f4, f3);
    }
    
    public void aV(String paramString1, String paramString2)
    {
      this.NF = paramString1;
      this.NG = paramString2;
    }
    
    public void bA(int paramInt1, int paramInt2)
    {
      this.aos = paramInt1;
      this.aot = paramInt2;
    }
    
    public void by(int paramInt1, int paramInt2)
    {
      this.aou = paramInt1;
      this.aov = paramInt2;
    }
    
    public void bz(int paramInt1, int paramInt2)
    {
      this.aow = paramInt1;
      this.aox = paramInt2;
    }
    
    public String gR()
    {
      return this.NF;
    }
    
    public String gS()
    {
      return this.NG;
    }
    
    public void ik(boolean paramBoolean)
    {
      this.Sb = paramBoolean;
    }
    
    public void kV(int paramInt)
    {
      this.aoy = paramInt;
    }
    
    public boolean tN()
    {
      int i;
      int j;
      if (this.NG != null)
      {
        i = 1;
        if ((this.aow <= 0) || (this.aox <= 0)) {
          break label60;
        }
        j = 1;
        label25:
        if ((this.aou <= 0) || (this.aov <= 0)) {
          break label65;
        }
      }
      label60:
      label65:
      for (int k = 1;; k = 0)
      {
        if ((i == 0) || (j == 0) || (k == 0)) {
          break label70;
        }
        return true;
        i = 0;
        break;
        j = 0;
        break label25;
      }
      label70:
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void doOnPause();
    
    public abstract void doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ild
 * JD-Core Version:    0.7.0.1
 */