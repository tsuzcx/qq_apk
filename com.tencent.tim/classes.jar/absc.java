import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.a;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteAioScript.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class absc
  implements ApolloCmdChannel.a
{
  protected abrk a;
  protected absa a;
  public abse a;
  protected boolean bEO;
  protected String bhr;
  protected String bhs;
  protected int bka;
  
  public absc(int paramInt, abse paramabse, absa paramabsa)
  {
    this.bka = paramInt;
    this.bhs = ("cmshow_script_" + paramInt + ".js");
    this.jdField_a_of_type_Abse = paramabse;
    this.jdField_a_of_type_Absa = paramabsa;
    QLog.i("CmShow_SpriteAioScript", 1, "[create script object], bid:" + paramInt + ",scriptName:" + this.bhs);
  }
  
  public absc(int paramInt, String paramString, abse paramabse, absa paramabsa)
  {
    this.bka = paramInt;
    this.bhs = paramString;
    this.jdField_a_of_type_Abse = paramabse;
    this.jdField_a_of_type_Absa = paramabsa;
    QLog.i("CmShow_SpriteAioScript", 1, "[create script object], bid:" + paramInt + ",scriptName:" + this.bhs);
  }
  
  public void CN(String paramString)
  {
    j(paramString, 0, false);
  }
  
  public boolean YY()
  {
    if (this.bEO)
    {
      QLog.i("CmShow_SpriteAioScript", 1, "script is already read, scriptName:" + this.bhs);
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
        QLog.i("CmShow_SpriteAioScript", 1, "Succeed to read script 0 from cache");
        return true;
      }
      String str = rh();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      localFile = new File(str);
      if (!localFile.exists())
      {
        QLog.w("CmShow_SpriteAioScript", 1, "Fail to read script file. " + localFile.getAbsolutePath());
        cEu();
        if (TextUtils.isEmpty(abxi.bjH)) {
          abwh.a(this.jdField_a_of_type_Abse.zM(), 300, 202, new Object[] { "Fail to read script file:", str });
        } else {
          abwh.a(this.jdField_a_of_type_Abse.zM(), 300, 200, new Object[] { "Fail to read script file:", str });
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      File localFile;
      QLog.e("CmShow_SpriteAioScript", 1, "[loadScript],OOM:", localOutOfMemoryError);
      abwh.a(this.jdField_a_of_type_Abse.zM(), 300, 150, new Object[] { "loadScript:", localOutOfMemoryError });
      return false;
      if (!jx(localOutOfMemoryError))
      {
        abwh.a(this.jdField_a_of_type_Abse.zM(), 300, 201, new Object[] { "Fail to verify script file:", localOutOfMemoryError });
        return false;
      }
      this.bhr = aqhq.readFileToString(localFile);
      QLog.i("CmShow_SpriteAioScript", 1, "Succeed to read script file, bid:" + this.bka);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmShow_SpriteAioScript", 1, "[loadScript]:", localThrowable);
      abwh.a(this.jdField_a_of_type_Abse.zM(), 300, 30, new Object[] { "loadScript:", localThrowable });
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
    if (this.jdField_a_of_type_Abse == null) {
      return null;
    }
    return this.jdField_a_of_type_Abse.a();
  }
  
  public abjp a(long paramLong, String paramString1, String paramString2)
  {
    return null;
  }
  
  public void a(abrk paramabrk)
  {
    this.jdField_a_of_type_Abrk = paramabrk;
  }
  
  public void bv(String paramString, boolean paramBoolean)
  {
    if (!this.bEO) {
      QLog.w("CmShow_SpriteAioScript", 2, "[checkDressRsc], script is NOT ready.");
    }
    while ((TextUtils.isEmpty(paramString)) || (!"0".equals(paramString))) {
      return;
    }
  }
  
  public void cEr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteAioScript", 2, new Object[] { "[loadScript], mIsLoaded:", Boolean.valueOf(this.bEO) });
    }
    for (;;)
    {
      try
      {
        if (!this.bEO) {
          break;
        }
        if (100 == this.bka)
        {
          QLog.d("CmShow_SpriteAioScript", 1, "sava TraceReport CmShowStatUtil commitJS:(cmshow_0)");
          j(this.bhr, 5, false);
          onLoadFinish();
          return;
        }
        if (this.bka == 0)
        {
          QLog.d("CmShow_SpriteAioScript", 1, "sava TraceReport CmShowStatUtil commitJS:(cmshow_0)");
          j(this.bhr, 3, false);
          continue;
        }
        localStringBuilder = new StringBuilder();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("CmShow_SpriteAioScript", 1, localThrowable, new Object[0]);
        return;
      }
      StringBuilder localStringBuilder;
      localStringBuilder.append("(function(){").append(this.bhr).append(";registerFunction(\"playAction_bid_").append(this.bka).append("\", playSpriteAction);").append("registerFunction(\"sendMsg_bid_").append(this.bka).append("\", sendSpriteMsg);").append("registerFunction(\"stopAction_bid_").append(this.bka).append("\", stopSpriteAction);").append("})();");
      CN(localStringBuilder.toString());
    }
  }
  
  public void cEs()
  {
    ApolloCmdChannel.getChannelFromOtherProcess(ApolloUtil.b()).addCmdHandler(this);
  }
  
  public void cEt()
  {
    QLog.w("CmShow_SpriteAioScript", 1, "[onVerifyFailure], check base.zip");
    QQAppInterface localQQAppInterface = ApolloUtil.a();
    if (localQQAppInterface != null)
    {
      aczo.cC(localQQAppInterface);
      return;
    }
    QLog.e("CmShow_SpriteAioScript", 1, "onVerifyFailure app is null");
  }
  
  public void cEu()
  {
    QLog.w("CmShow_SpriteAioScript", 1, "[onScriptNotExists], redownload base.zip");
    QQAppInterface localQQAppInterface = ApolloUtil.a();
    if (localQQAppInterface != null)
    {
      aczo.cC(localQQAppInterface);
      return;
    }
    QLog.e("CmShow_SpriteAioScript", 1, "onVerifyFailure app is null");
  }
  
  public void destroyHandler() {}
  
  public void j(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Abse == null)) {
      QLog.w("CmShow_SpriteAioScript", 1, "[execScriptInRenderThread], script is null.");
    }
    abix localabix;
    do
    {
      return;
      localabix = this.jdField_a_of_type_Abse.a();
    } while (localabix == null);
    localabix.runRenderTask(new CmShowSpriteAioScript.1(this, paramString, localabix, paramInt, paramBoolean));
  }
  
  protected boolean jx(String paramString)
  {
    boolean bool = true;
    if (!new abzb(paramString + ".sig", paramString).il(1))
    {
      QLog.w("CmShow_SpriteAioScript", 1, "verify fails, path:" + paramString);
      cEt();
      bool = false;
    }
    return bool;
  }
  
  public void onDestroy()
  {
    ApolloCmdChannel localApolloCmdChannel = ApolloCmdChannel.getChannelFromOtherProcess(ApolloUtil.b());
    if (localApolloCmdChannel != null) {
      localApolloCmdChannel.removeCmdHandler(this);
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
 * Qualified Name:     absc
 * JD-Core Version:    0.7.0.1
 */