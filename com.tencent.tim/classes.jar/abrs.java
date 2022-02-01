import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class abrs
{
  private abrc jdField_a_of_type_Abrc;
  private abrf jdField_a_of_type_Abrf;
  private abrr jdField_a_of_type_Abrr;
  private abrt jdField_a_of_type_Abrt;
  private abqt b;
  private abrd c;
  private WeakReference<QQAppInterface> mAppRef;
  private boolean mIsInit;
  
  public abrs(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Abrc = new abrc(paramQQAppInterface);
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Abrt = new abrt(this.jdField_a_of_type_Abrc);
    this.jdField_a_of_type_Abrf = new abrf(this.jdField_a_of_type_Abrc, this.jdField_a_of_type_Abrt);
    this.c = new abrd(this.jdField_a_of_type_Abrc);
    this.jdField_a_of_type_Abrr = new abrr(this.jdField_a_of_type_Abrc, this.jdField_a_of_type_Abrt, this.c, this.jdField_a_of_type_Abrf);
    this.jdField_a_of_type_Abrc.a(this.c);
    paramQQAppInterface = abrj.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this);
    }
  }
  
  public void HW(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Abrc == null) || (this.jdField_a_of_type_Abrr == null) || (this.jdField_a_of_type_Abrf == null)) {
      return;
    }
    this.jdField_a_of_type_Abrc.Ec(true);
    int i = abrj.gf(this.jdField_a_of_type_Abrc.cqU);
    this.jdField_a_of_type_Abrc.HT(i);
    abwh.a(i, 100, 0, new Object[] { "onSurfaceReady" });
    this.jdField_a_of_type_Abrc.gJ(-2, paramInt);
    abwh.gN(i, 200);
    this.jdField_a_of_type_Abrf.cED();
    abwh.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Abrc.Eb(true);
    abwh.gN(i, 300);
    this.jdField_a_of_type_Abrr.a(this.jdField_a_of_type_Abrc);
    abwh.a(i, 300, 0, new Object[] { "initSprite done" });
    abwh.a(i, 1, 0, new Object[] { "terminal all done" });
    this.mIsInit = true;
    this.b = ((abqt)this.jdField_a_of_type_Abrf.a(0));
  }
  
  public void HX(int paramInt)
  {
    if (this.jdField_a_of_type_Abrc != null) {
      this.jdField_a_of_type_Abrc.gJ(-2, paramInt);
    }
  }
  
  public abqt a()
  {
    return this.b;
  }
  
  public abrc a()
  {
    return this.jdField_a_of_type_Abrc;
  }
  
  public abrr a()
  {
    return this.jdField_a_of_type_Abrr;
  }
  
  public void a(abrm paramabrm)
  {
    if (paramabrm != null) {
      this.jdField_a_of_type_Abrc.a(paramabrm);
    }
  }
  
  public void b(abix paramabix)
  {
    if (paramabix == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Abrc.a(paramabix);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Abrc.getApp());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramabix);
  }
  
  public void cEA()
  {
    if (this.jdField_a_of_type_Abrr != null) {
      this.jdField_a_of_type_Abrr.cEA();
    }
  }
  
  public void doOnPause()
  {
    if (!abrj.V(getApp())) {
      return;
    }
    if (this.b != null) {
      this.b.HP(1);
    }
    this.jdField_a_of_type_Abrc.setBubbleType(-1);
  }
  
  public void doOnResume()
  {
    if (!abrj.V(getApp())) {}
    while (this.b == null) {
      return;
    }
    this.b.HP(2);
  }
  
  public void g(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    abkg localabkg = new abkg(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_Abrc.a(localabkg);
  }
  
  public QQAppInterface getApp()
  {
    if (this.mAppRef == null) {
      return null;
    }
    return (QQAppInterface)this.mAppRef.get();
  }
  
  public void i(int paramInt, ArrayList<String> paramArrayList)
  {
    abqt localabqt = a();
    if ((localabqt != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.jdField_a_of_type_Abrc.mSelfUin)) {
          localabqt.i(paramInt, paramArrayList);
        }
      }
    }
  }
  
  public void i(int paramInt, Object... paramVarArgs)
  {
    if (!this.mIsInit) {
      abwh.a(abrj.gf(this.jdField_a_of_type_Abrc.cqU), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void kc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_Abrc.setUin(paramString);
    this.jdField_a_of_type_Abrc.cqS = abhh.h(getApp(), paramString);
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c.reset();
    }
    Object localObject = this.jdField_a_of_type_Abrc.a();
    if (localObject != null)
    {
      localObject = ((abix)localObject).getRenderImpl();
      if (localObject != null) {
        ((abii)localObject).onDestroy();
      }
    }
    abwh.bl(this.jdField_a_of_type_Abrc.zM(), true);
    this.jdField_a_of_type_Abrt.clear();
    this.jdField_a_of_type_Abrf.clear();
    this.jdField_a_of_type_Abrc.clear();
    this.jdField_a_of_type_Abrr.clear();
    this.mIsInit = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrs
 * JD-Core Version:    0.7.0.1
 */