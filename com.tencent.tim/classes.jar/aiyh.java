import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.model.RecordVolume;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.2;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class aiyh
  implements aixt.a, MagicfaceContainerView.a
{
  static final float[] cB = { 1.4F, 1.5F, 1.6F, 1.7F, 1.8F, 1.9F, 2.0F, 2.1F, 2.2F, 2.3F };
  static final int[] value = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
  public List<aixr> CL;
  public aixt a;
  public aixv a;
  public aiyf a;
  aiyh.a jdField_a_of_type_Aiyh$a;
  aiyh.b jdField_a_of_type_Aiyh$b;
  aiyh.c jdField_a_of_type_Aiyh$c = new aiyi(this);
  aiyh.d jdField_a_of_type_Aiyh$d;
  aiym jdField_a_of_type_Aiym;
  public RecordVolume a;
  long abX;
  long abY;
  public aixr b;
  public aiyl b;
  aiyr b;
  int dgR = 0;
  int dgS = 0;
  Emoticon e;
  public volatile boolean isRelease = false;
  public volatile boolean isShutDown = false;
  volatile boolean isStart = false;
  String senderuin;
  public acln shakeListener = new aiyj(this);
  public int type = 0;
  
  public aiyh(aiyr paramaiyr)
  {
    this.jdField_a_of_type_Aixt = null;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume = new RecordVolume(new aiyk(this));
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager begins");
    }
    this.jdField_b_of_type_Aiyr = paramaiyr;
    this.jdField_a_of_type_Aixv = new aixv();
    this.jdField_a_of_type_Aiym = new aiym();
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager ends");
    }
  }
  
  public static int a(Emoticon paramEmoticon, int paramInt)
  {
    aiyf localaiyf = new aiyf(afnu.bEq.replace("[epId]", paramEmoticon.epId));
    paramEmoticon = null;
    if (paramInt == 0) {
      paramEmoticon = localaiyf.lH("send.xml");
    }
    for (;;)
    {
      return new aixv().dt(paramEmoticon);
      if (paramInt == 1) {
        paramEmoticon = localaiyf.lH("receive.xml");
      }
    }
  }
  
  public static aixt a(Emoticon paramEmoticon, int paramInt)
  {
    return a(paramEmoticon, paramInt, 1);
  }
  
  public static aixt a(Emoticon paramEmoticon, int paramInt1, int paramInt2)
  {
    return a(paramEmoticon, paramInt1, paramInt2, 0);
  }
  
  public static aixt a(Emoticon paramEmoticon, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 1)
    {
      paramEmoticon = new aiyf(afnu.bEq.replace("[epId]", paramEmoticon.epId));
      if (paramInt1 != 0) {
        break label161;
      }
      paramEmoticon = paramEmoticon.lH("send.xml");
    }
    for (;;)
    {
      if (paramEmoticon == null)
      {
        return null;
        if (paramInt2 == 2)
        {
          if (paramInt3 == 1) {}
          for (paramEmoticon = afnu.bEp.replace("[epId]", paramEmoticon.epId + "_V");; paramEmoticon = afnu.bEp.replace("[epId]", paramEmoticon.epId + "_HD"))
          {
            paramEmoticon = new aiyf(paramEmoticon, 2);
            break;
          }
        }
        if (paramInt2 == 3)
        {
          paramEmoticon = new aiyf(afnu.bEq.replace("[epId]", paramEmoticon.epId), 3);
          break;
        }
        return null;
        label161:
        if (paramInt1 != 1) {
          break label188;
        }
        paramEmoticon = paramEmoticon.lH("receive.xml");
        continue;
      }
      return new aixv().a(paramEmoticon);
      label188:
      paramEmoticon = null;
    }
  }
  
  public int Gd()
  {
    if ((this.jdField_a_of_type_Aixt != null) && (this.jdField_a_of_type_Aixt.a != null)) {
      return this.dgR;
    }
    return 0;
  }
  
  public void LE(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putBoolean("sendSound", paramBoolean).commit();
  }
  
  public void LF(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putBoolean("receiveSound", paramBoolean).commit();
  }
  
  public void LG(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aixt != null) {
      this.jdField_a_of_type_Aixt.cmC = true;
    }
  }
  
  public void Qt(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func initActionData begins.");
    }
    this.isStart = true;
    this.isShutDown = false;
    this.jdField_b_of_type_Aiyl.init();
    if (paramInt == 1) {
      this.jdField_a_of_type_Aiyf = new aiyf(afnu.bEq.replace("[epId]", this.e.epId));
    }
    for (;;)
    {
      this.jdField_b_of_type_Aiyl.a(this.jdField_a_of_type_Aiyf);
      this.jdField_b_of_type_Aiyl.a(this.jdField_a_of_type_Aiym);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func initActionData ends.");
      }
      return;
      if (paramInt == 2) {
        this.jdField_a_of_type_Aiyf = new aiyf(afnu.bEp.replace("[epId]", this.e.epId), 2);
      } else if (paramInt == 3) {
        this.jdField_a_of_type_Aiyf = new aiyf(afnu.bEq.replace("[epId]", this.e.epId), 3);
      }
    }
  }
  
  public void a(aixt paramaixt)
  {
    if (paramaixt == null) {
      QLog.e("MagicfaceActionManager", 1, "onStartMagicface error : actionGlobalData = null");
    }
    for (;;)
    {
      return;
      c(paramaixt);
      if (this.jdField_a_of_type_Aiyh$a != null) {
        this.jdField_a_of_type_Aiyh$a.e(paramaixt);
      }
      if (this.jdField_a_of_type_Aiyh$d != null)
      {
        this.jdField_a_of_type_Aiyh$d.updateTitle(paramaixt.title);
        if (this.type == 1)
        {
          if (paramaixt.subTitle == null) {
            break label130;
          }
          this.jdField_a_of_type_Aiyh$d.Mc(paramaixt.subTitle.replace("%param%", "" + paramaixt.value));
        }
      }
      while (paramaixt.a != null)
      {
        paramaixt.a(this);
        paramaixt.dvo();
        return;
        label130:
        this.jdField_a_of_type_Aiyh$d.Mc("");
      }
    }
  }
  
  public void a(aiyh.a parama)
  {
    this.jdField_a_of_type_Aiyh$a = parama;
  }
  
  public void a(aiyh.b paramb)
  {
    if (paramb != null) {
      this.jdField_a_of_type_Aiyh$b = paramb;
    }
    this.isShutDown = true;
    if (this.jdField_b_of_type_Aixr != null) {
      this.jdField_b_of_type_Aixr.stop();
    }
    if (this.jdField_a_of_type_Aixt != null) {
      this.jdField_a_of_type_Aixt.a(null);
    }
  }
  
  public void a(aiyh.d paramd)
  {
    this.jdField_a_of_type_Aiyh$d = paramd;
  }
  
  public void a(aiyl paramaiyl)
  {
    this.jdField_b_of_type_Aiyl = paramaiyl;
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    a(paramEmoticon, paramInt, paramString, 1);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func doAction begins. isStart:" + this.isStart + ",isRelease:" + this.isRelease);
    }
    if (this.isStart) {
      return;
    }
    this.e = paramEmoticon;
    this.type = paramInt1;
    this.senderuin = paramString;
    ThreadManager.post(new MagicfaceActionManager.2(this, paramInt2, paramInt1), 8, null, true);
  }
  
  public boolean apR()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("sendSound", false);
  }
  
  public boolean apS()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("receiveSound", false);
  }
  
  public void b(aixt paramaixt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func onEndMagicface, 【magic end】");
    }
    if (this.jdField_a_of_type_Aiyh$b != null) {
      this.jdField_a_of_type_Aiyh$b.dvw();
    }
    this.isStart = false;
    if (paramaixt != null) {
      d(paramaixt);
    }
    if (this.jdField_a_of_type_Aiyh$a != null) {
      this.jdField_a_of_type_Aiyh$a.f(paramaixt);
    }
  }
  
  public void c(aixt paramaixt)
  {
    if ("mic".equalsIgnoreCase(paramaixt.bPV)) {
      ThreadManager.executeOnNetWorkThread(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume);
    }
    do
    {
      return;
      if ("gravity".equalsIgnoreCase(paramaixt.bPV))
      {
        paramaixt = (SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor");
        paramaixt.registerListener(this.shakeListener, paramaixt.getDefaultSensor(1), 0);
        return;
      }
    } while (!"touch".equalsIgnoreCase(paramaixt.bPV));
  }
  
  public void cHe()
  {
    if (this.jdField_b_of_type_Aixr == null) {}
    do
    {
      do
      {
        aixu localaixu;
        do
        {
          return;
          localaixu = this.jdField_b_of_type_Aixr.a;
        } while ((localaixu == null) || (!"gravity".equalsIgnoreCase(localaixu.bPV)));
        if (!"record".equalsIgnoreCase(localaixu.type)) {
          break;
        }
      } while (this.jdField_a_of_type_Aiyh$d == null);
      this.dgR = this.jdField_a_of_type_Aixt.value;
      this.jdField_a_of_type_Aiyh$d.Md(this.jdField_a_of_type_Aixt.bPW);
      return;
    } while (this.jdField_a_of_type_Aiyh$d == null);
    this.jdField_a_of_type_Aiyh$d.Md(this.jdField_a_of_type_Aixt.a.a(1, this.jdField_a_of_type_Aixt.xb));
  }
  
  public void close()
  {
    a(null);
  }
  
  public void d(aixt paramaixt)
  {
    if ("mic".equalsIgnoreCase(paramaixt.bPV)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume.stop();
    }
    while (!"gravity".equalsIgnoreCase(paramaixt.bPV)) {
      return;
    }
    ((SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor")).unregisterListener(this.shakeListener);
  }
  
  public void dvp()
  {
    this.isShutDown = true;
    if (this.jdField_b_of_type_Aixr != null)
    {
      this.jdField_b_of_type_Aixr.dvl();
      this.jdField_b_of_type_Aixr.stop();
    }
    this.abY = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Aixt != null) && (this.jdField_a_of_type_Aiyh$d != null) && (this.jdField_a_of_type_Aixt.bPW != null))
    {
      this.dgR = this.jdField_a_of_type_Aixt.value;
      this.jdField_a_of_type_Aiyh$d.Md(this.jdField_a_of_type_Aixt.a.a(this.dgR, this.jdField_a_of_type_Aixt.xb));
    }
  }
  
  public void dvt()
  {
    if ((this.jdField_b_of_type_Aiyr != null) && (this.type == 0) && (this.jdField_b_of_type_Aixr != null) && (this.jdField_b_of_type_Aixr.cmA)) {
      this.jdField_b_of_type_Aiyr.dvB();
    }
  }
  
  public void dvu()
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_Aixt == null) || ("non-ver".equals(this.jdField_a_of_type_Aixt.bPU)))
    {
      this.CL = u(false);
      return;
    }
    int[] arrayOfInt1 = l("3.4.4");
    int[] arrayOfInt2 = l(this.jdField_a_of_type_Aixt.bPU);
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func filterAction, qqver:" + arrayOfInt1 + ",magicVer:" + arrayOfInt2);
    }
    int i;
    boolean bool1;
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null) && (arrayOfInt1.length == arrayOfInt2.length))
    {
      i = 0;
      if (i < arrayOfInt2.length) {
        if (arrayOfInt1[i] > arrayOfInt2[i]) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      label142:
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func filterAction, isQQSupport:" + bool1);
      }
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.CL = u(bool1);
        return;
        if (arrayOfInt1[i] < arrayOfInt2[i])
        {
          bool1 = false;
          break label142;
        }
        i += 1;
        break;
      }
      bool1 = true;
    }
  }
  
  public void dvv()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func parseReceiveValue, magicValue:" + this.e.magicValue);
    }
    if (this.e.magicValue != null)
    {
      String[] arrayOfString = this.e.magicValue.split("&");
      if ((arrayOfString.length >= 0) && (arrayOfString[0].contains("value")))
      {
        arrayOfString = arrayOfString[0].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          this.jdField_a_of_type_Aixt.value = Integer.parseInt(arrayOfString[1]);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func parseReceiveValue, value:" + this.jdField_a_of_type_Aixt.value);
    }
  }
  
  public boolean isStart()
  {
    return this.isStart;
  }
  
  public boolean kl(int paramInt)
  {
    if (this.jdField_b_of_type_Aixr != null) {
      this.jdField_b_of_type_Aixr.b(paramInt, this.jdField_a_of_type_Aiyh$c);
    }
    return false;
  }
  
  public int[] l(String paramString)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func splitVersion begins, version:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    int[] arrayOfInt;
    do
    {
      return paramString;
      arrayOfInt = new int[3];
      int i = 0;
      while (i < 3)
      {
        arrayOfInt[i] = 0;
        i += 1;
      }
      paramString = paramString.split("\\.");
      if ((paramString != null) && (paramString.length > 1))
      {
        i = j;
        try
        {
          while (i < arrayOfInt.length)
          {
            arrayOfInt[i] = Integer.valueOf(paramString[i]).intValue();
            if (QLog.isColorLevel()) {
              QLog.d("MagicfaceActionManager", 2, "func splitVersion, intVers[" + i + "],=" + arrayOfInt[i]);
            }
            i += 1;
          }
          paramString = arrayOfInt;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MagicfaceActionManager", 2, "func splitVersion ends");
    return arrayOfInt;
  }
  
  public void refresh()
  {
    close();
    a(this.e, this.type, this.senderuin);
  }
  
  public void release()
  {
    this.isRelease = true;
    if (this.jdField_a_of_type_Aixt != null) {
      this.jdField_a_of_type_Aixt.a(null);
    }
    if (this.jdField_b_of_type_Aiyl != null)
    {
      this.jdField_b_of_type_Aiyl.a(null);
      this.jdField_b_of_type_Aiyl.release();
    }
    if (this.jdField_a_of_type_Aiym != null)
    {
      this.jdField_a_of_type_Aiym.release();
      this.jdField_a_of_type_Aiym = null;
    }
    if ((this.type == 0) && (this.abY - this.abX > 0L))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        anot.a((QQAppInterface)localAppRuntime, "CliOper", "", "", "MbFasong", "MbZhizuoShichang", 0, 0, String.valueOf(this.abY - this.abX), "", "", "");
      }
    }
    this.jdField_b_of_type_Aiyr = null;
  }
  
  public List<aixr> u(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.CL.iterator();
    for (;;)
    {
      aixr localaixr;
      if (localIterator.hasNext())
      {
        localaixr = (aixr)localIterator.next();
        if (localaixr == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localaixr.name)) {
            continue;
          }
          localArrayList.add(localaixr);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localaixr.name)) {
        localArrayList.add(localaixr);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void e(aixt paramaixt);
    
    public abstract void f(aixt paramaixt);
  }
  
  public static abstract interface b
  {
    public abstract void dvw();
  }
  
  public static abstract interface c
  {
    public abstract void stop();
  }
  
  public static abstract interface d
  {
    public abstract void Mc(String paramString);
    
    public abstract void Md(String paramString);
    
    public abstract void updateTitle(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyh
 * JD-Core Version:    0.7.0.1
 */