import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.a;
import com.tencent.mobileqq.apollo.script.SpriteAioScript.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

public class abqu
  implements ApolloCmdChannel.a
{
  public abrc a;
  protected abrk a;
  protected abrg b;
  protected boolean bEO;
  protected String bhr;
  protected String bhs;
  protected int bka;
  
  public abqu(int paramInt, abrc paramabrc)
  {
    this.bka = paramInt;
    this.bhs = ("cmshow_script_" + paramInt + ".js");
    this.jdField_a_of_type_Abrc = paramabrc;
    if ((paramabrc != null) && (paramabrc.getApp() != null)) {
      this.b = ((abrg)paramabrc.getApp().getManager(249));
    }
    QLog.i("cmshow_scripted_SpriteAioScript", 1, "[create script object], bid:" + paramInt + ",scriptName:" + this.bhs);
  }
  
  private void b(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    String str = abvg.c(paramString, paramQQAppInterface);
    if (TextUtils.isEmpty(str))
    {
      if (paramBoolean) {
        a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "checkThreeFaceDress faceData:", str });
    }
    abrd.a(paramQQAppInterface, str, new abqx(this, paramBoolean, paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2));
  }
  
  public void CN(String paramString)
  {
    j(paramString, 0, false);
  }
  
  public boolean YY()
  {
    if (this.bEO)
    {
      QLog.i("cmshow_scripted_SpriteAioScript", 1, "script is already read, scriptName:" + this.bhs);
      return true;
    }
    this.bEO = YZ();
    return this.bEO;
  }
  
  public boolean YZ()
  {
    try
    {
      if ((this.bka == 0) && (!TextUtils.isEmpty(abhh.bfU)))
      {
        this.bhr = abhh.bfU;
        QLog.i("cmshow_scripted_SpriteAioScript", 1, "Succeed to read script 0 from cache");
        return true;
      }
      String str = rh();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      localFile = new File(str);
      if (!localFile.exists())
      {
        QLog.w("cmshow_scripted_SpriteAioScript", 1, "Fail to read script file. " + localFile.getAbsolutePath());
        cEu();
        if (TextUtils.isEmpty(abxi.bjH)) {
          abwh.a(this.jdField_a_of_type_Abrc.zM(), 300, 202, new Object[] { "Fail to read script file:", str });
        } else {
          abwh.a(this.jdField_a_of_type_Abrc.zM(), 300, 200, new Object[] { "Fail to read script file:", str });
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      File localFile;
      QLog.e("cmshow_scripted_SpriteAioScript", 1, "[loadScript],OOM:", localOutOfMemoryError);
      abwh.a(this.jdField_a_of_type_Abrc.zM(), 300, 150, new Object[] { "loadScript:", localOutOfMemoryError });
      return false;
      if (!jx(localOutOfMemoryError))
      {
        abwh.a(this.jdField_a_of_type_Abrc.zM(), 300, 201, new Object[] { "Fail to verify script file:", localOutOfMemoryError });
        return false;
      }
      this.bhr = aqhq.readFileToString(localFile);
      QLog.i("cmshow_scripted_SpriteAioScript", 1, "Succeed to read script file, bid:" + this.bka);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteAioScript", 1, "[loadScript]:", localThrowable);
      abwh.a(this.jdField_a_of_type_Abrc.zM(), 300, 30, new Object[] { "loadScript:", localThrowable });
      return false;
    }
    return false;
  }
  
  public boolean Za()
  {
    if (TextUtils.isEmpty(abxi.bjH)) {}
    while (new File(abxi.bjI + "cm3d.js").exists()) {
      return true;
    }
    return false;
  }
  
  public abix a()
  {
    if (this.jdField_a_of_type_Abrc == null) {
      return null;
    }
    return this.jdField_a_of_type_Abrc.a();
  }
  
  public abjp a(long paramLong, String paramString1, String paramString2)
  {
    return null;
  }
  
  public void a(abrk paramabrk)
  {
    this.jdField_a_of_type_Abrk = paramabrk;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2) {}
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i = abhh.h(getApp(), paramString);
    if (i != 2)
    {
      if (paramBoolean) {
        a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      return;
    }
    Object localObject = abvg.a(paramString, i, getApp(), false);
    i = ((Integer)localObject[0]).intValue();
    if (localObject[1] == null) {}
    for (localObject = null;; localObject = (int[])localObject[1])
    {
      if ((i > 0) && (localObject != null) && (localObject.length != 0)) {
        break label116;
      }
      if (!paramBoolean) {
        break;
      }
      a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
      return;
    }
    label116:
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "checkThreeDress roleId:", Integer.valueOf(paramInt1), ", dressIds:", Arrays.toString((int[])localObject) });
    }
    abrd.b(paramQQAppInterface, paramString, i, (int[])localObject, new abqw(this, paramBoolean, paramInt1, paramArrayOfInt));
  }
  
  public void bv(String paramString, boolean paramBoolean)
  {
    if (!this.bEO) {
      QLog.w("cmshow_scripted_SpriteAioScript", 2, "[checkDressRsc], script is NOT ready.");
    }
    label15:
    QQAppInterface localQQAppInterface;
    Object localObject;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            break label15;
            break label15;
            do
            {
              return;
            } while ((TextUtils.isEmpty(paramString)) || ("0".equals(paramString)));
            localQQAppInterface = getApp();
          } while (localQQAppInterface == null);
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "[checkDressRsc], uin:", paramString, ",notifyIfExist:", Boolean.valueOf(paramBoolean) });
          }
          localObject = abvg.a(paramString, getApp(), false);
        } while ((localObject == null) || (localObject.length != 2));
        i = ((Integer)localObject[0]).intValue();
        localObject = (int[])localObject[1];
      } while ((localObject == null) || (localObject.length == 0));
      if (2 != ((abhh)localQQAppInterface.getManager(153)).cd(paramString)) {
        break;
      }
    } while (!paramBoolean);
    a(localQQAppInterface, paramString, i, (int[])localObject, 0);
    return;
    abrd.a(localQQAppInterface, paramString, i, (int[])localObject, new abqv(this, paramBoolean));
  }
  
  public void cEr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "[loadScript], mIsLoaded:", Boolean.valueOf(this.bEO) });
    }
    try
    {
      if (this.bEO)
      {
        if (this.bka == 0)
        {
          QLog.d("cmshow_scripted_SpriteAioScript", 1, "sava TraceReport CmShowStatUtil commitJS:(cmshow_0)");
          j(this.bhr, 3, false);
        }
        for (;;)
        {
          onLoadFinish();
          return;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("(function(){").append(this.bhr).append(";registerFunction(\"playAction_bid_").append(this.bka).append("\", playSpriteAction);").append("registerFunction(\"sendMsg_bid_").append(this.bka).append("\", sendSpriteMsg);").append("registerFunction(\"stopAction_bid_").append(this.bka).append("\", stopSpriteAction);").append("})();");
          CN(localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteAioScript", 1, localThrowable, new Object[0]);
    }
  }
  
  public void cEs()
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return;
    }
    ApolloCmdChannel.getChannel(localQQAppInterface).addCmdHandler(this);
  }
  
  public void cEt()
  {
    QLog.w("cmshow_scripted_SpriteAioScript", 1, "[onVerifyFailure], check base.zip");
    aczo.cC(getApp());
  }
  
  public void cEu()
  {
    QLog.w("cmshow_scripted_SpriteAioScript", 1, "[onScriptNotExists], redownload base.zip");
    aczo.cC(getApp());
  }
  
  public void destroyHandler() {}
  
  public QQAppInterface getApp()
  {
    if (this.jdField_a_of_type_Abrc == null) {
      return null;
    }
    return this.jdField_a_of_type_Abrc.getApp();
  }
  
  public void j(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Abrc == null)) {
      QLog.w("cmshow_scripted_SpriteAioScript", 1, "[execScriptInRenderThread], script is null.");
    }
    abix localabix;
    do
    {
      return;
      localabix = this.jdField_a_of_type_Abrc.a();
    } while (localabix == null);
    localabix.runRenderTask(new SpriteAioScript.1(this, paramString, localabix, paramInt, paramBoolean));
  }
  
  protected boolean jx(String paramString)
  {
    boolean bool = true;
    if (!new abzb(paramString + ".sig", paramString).il(1))
    {
      QLog.w("cmshow_scripted_SpriteAioScript", 1, "verify fails, path:" + paramString);
      cEt();
      bool = false;
    }
    return bool;
  }
  
  public void onDestroy()
  {
    Object localObject = getApp();
    if (localObject == null) {
      return;
    }
    localObject = ApolloCmdChannel.getChannel((QQAppInterface)localObject);
    if (localObject != null) {
      ((ApolloCmdChannel)localObject).removeCmdHandler(this);
    }
    this.jdField_a_of_type_Abrk = null;
    this.bEO = false;
  }
  
  public void onLoadFinish() {}
  
  public boolean q(Activity paramActivity)
  {
    return false;
  }
  
  public String rh()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(abxi.bjI).append(this.bhs);
    return localStringBuilder.toString();
  }
  
  public int zL()
  {
    return this.bka;
  }
  
  public int zz()
  {
    return 300;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqu
 * JD-Core Version:    0.7.0.1
 */