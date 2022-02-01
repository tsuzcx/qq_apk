import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.identification.IdentificationIpcServer.1;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class aiaq
  extends QIPCModule
{
  private static final List<String> Cq = Arrays.asList(new String[] { "setFaceData", "identify", "deleteFace", "changeSecureMobile" });
  private static volatile aiaq jdField_a_of_type_Aiaq;
  private aomj jdField_a_of_type_Aomj;
  private ConfigManager jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager;
  private int callbackId;
  private boolean cjF;
  private boolean cjG;
  private boolean cjH = true;
  private int dcS;
  private AtomicBoolean dg = new AtomicBoolean();
  private String method;
  
  private aiaq(String paramString)
  {
    super(paramString);
  }
  
  public static aiaq a()
  {
    if (jdField_a_of_type_Aiaq == null) {}
    try
    {
      if (jdField_a_of_type_Aiaq == null) {
        jdField_a_of_type_Aiaq = new aiaq("IdentificationIpcServer_Model");
      }
      return jdField_a_of_type_Aiaq;
    }
    finally {}
  }
  
  private ITransactionCallback a(File paramFile, EIPCResult paramEIPCResult, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    return new aias(this, paramFile, paramEIPCResult, paramQQAppInterface, paramInt2, paramInt3, paramInt1);
  }
  
  private void bC(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        this.cjH &= paramBoolean;
        if (paramInt == 2)
        {
          this.cjG = true;
          if ((this.cjG) && (this.cjF))
          {
            EIPCResult localEIPCResult = new EIPCResult();
            if (!this.cjH) {
              break label147;
            }
            paramInt = i;
            localEIPCResult.code = paramInt;
            callbackResult(this.dcS, localEIPCResult);
            this.dg.set(false);
            QLog.d("qqidentification_server", 1, "downloadFinish download result = " + this.cjH);
          }
          return;
        }
        if (paramInt == 1)
        {
          this.cjF = true;
          continue;
        }
        this.cjH = false;
      }
      finally {}
      QLog.d("qqidentification_server", 1, "unknown download type");
      continue;
      label147:
      paramInt = 1;
    }
  }
  
  private void c(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null)
    {
      QLog.d("qqidentification_server", 1, " params = null");
      return;
    }
    int i = paramBundle.getInt("srcAppId", 0);
    String str1 = paramBundle.getString("key", "");
    String str2 = paramBundle.getString("lightInfo", null);
    String str3 = paramBundle.getString("method", null);
    String str4 = paramBundle.getString("uin", null);
    long l = paramBundle.getLong("nonce", -1L);
    if ((i == 0) || (TextUtils.isEmpty(str1)))
    {
      QLog.d("qqidentification_server", 1, " KEY_APP_ID not exist or temKey is empty");
      return;
    }
    if (("loginVerify".equals(str3)) && (TextUtils.isEmpty(str4)))
    {
      QLog.d("qqidentification_server", 1, "method is loginVerify but uin is empty");
      return;
    }
    paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FaceDetectForThirdPartyManager localFaceDetectForThirdPartyManager = (FaceDetectForThirdPartyManager)paramBundle.getManager(301);
    aijc.a(paramBundle, str3, str4, i, AppSetting.nT(), str2, str1, l, new aiar(this, localFaceDetectForThirdPartyManager, paramInt, paramBundle));
  }
  
  private void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    String str = paramString3 + "identification.zip";
    paramString2 = new aiat(this, paramString2, paramString3, paramString1, paramInt);
    if (this.jdField_a_of_type_Aomj == null)
    {
      paramQQAppInterface = new HttpCommunicator(paramQQAppInterface, 4);
      paramQQAppInterface.start();
      this.jdField_a_of_type_Aomj = new aomj(paramQQAppInterface, false);
    }
    paramQQAppInterface = new aoll();
    paramQQAppInterface.f = paramString2;
    paramQQAppInterface.mHttpMethod = 0;
    paramQQAppInterface.bZ = paramString1;
    paramQQAppInterface.atY = str;
    paramQQAppInterface.dPo = 0;
    this.jdField_a_of_type_Aomj.a(paramQQAppInterface);
  }
  
  private void cJ(Bundle paramBundle)
  {
    QLog.d("qqidentification_server", 1, "start upload file");
    EIPCResult localEIPCResult = new EIPCResult();
    Bundle localBundle = new Bundle();
    localEIPCResult.data = localBundle;
    Object localObject1 = paramBundle.getString("filePath", null);
    File localFile;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localFile = new File((String)localObject1);
      if (localFile.exists()) {}
    }
    else
    {
      QLog.e("qqidentification_server", 1, "invalid path");
      localEIPCResult.code = -102;
      localBundle.putString("subError", "no file");
      localBundle.putBoolean("reset_null", true);
      callbackResult(this.callbackId, localEIPCResult);
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("md5");
    if (arrayOfByte == null)
    {
      QLog.e("qqidentification_server", 1, "md5 is null");
      localEIPCResult.code = -102;
      localBundle.putString("subError", "no md5");
      localBundle.putBoolean("reset_null", true);
      callbackResult(this.callbackId, localEIPCResult);
      return;
    }
    int i = paramBundle.getInt("serviceType", -1);
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramBundle.getInt("srcAppId", 0);
    int k = paramBundle.getInt("key_identification_type", 2);
    this.method = paramBundle.getString("method", null);
    anot.a((QQAppInterface)localObject2, "dc00898", "", "", "0X80097EB", "0X80097EB", 0, 0, i + "", "" + k, j + "", "");
    if ((this.method == null) || (Cq.contains(this.method))) {}
    String str1;
    String str2;
    for (localObject1 = new Transaction(((QQAppInterface)localObject2).getCurrentAccountUin(), 61, (String)localObject1, 0, arrayOfByte, a(localFile, localEIPCResult, (QQAppInterface)localObject2, j, i, k), null, false);; localObject1 = new Transaction(str1, 61, (String)localObject1, 0, Base64.decode(str2, 11), arrayOfByte, a(localFile, localEIPCResult, (QQAppInterface)localObject2, j, i, k)))
    {
      localObject2 = ((QQAppInterface)localObject2).getHwEngine();
      if ("loginVerify".equals(this.method))
      {
        ((HwEngine)localObject2).currentUin = paramBundle.getString("uin", "");
        this.jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager = ConfigManager.getInstance(BaseApplicationImpl.getContext(), (HwEngine)localObject2);
      }
      i = ((HwEngine)localObject2).submitTransactionTask((Transaction)localObject1);
      if (i == 0) {
        break;
      }
      QLog.e("qqidentification_server", 1, "submit error: " + i);
      localEIPCResult.code = -102;
      localBundle.putBoolean("reset_null", true);
      localBundle.putString("subError", "UPLOAD submitTransaction retCode=" + i);
      callbackResult(this.callbackId, localEIPCResult);
      return;
      str1 = paramBundle.getString("uin", "");
      str2 = paramBundle.getString("ticket", "");
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
        QLog.i("qqidentification_server", 1, "uin or ticket is null");
      }
    }
  }
  
  private void da(QQAppInterface paramQQAppInterface)
  {
    axce localaxce = axce.a();
    localaxce.Ya(true);
    aiau localaiau = new aiau(this);
    if (paramQQAppInterface.isLogin())
    {
      localaxce.a(axcd.c, localaiau, false);
      return;
    }
    localaxce.a(axcd.c, localaiau);
  }
  
  private void drN()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager.onDestroy();
    }
  }
  
  public boolean aoI()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = ShortVideoResourceManager.zD();
    QLog.d("qqidentification_server", 1, "config content....." + (String)localObject1);
    this.cjG = false;
    this.cjF = false;
    this.cjH = true;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = new ArrayList();
      QLog.d("qqidentification_server", 1, new Object[] { "configContent is not empty, parseConfig result is ", Integer.valueOf(ShortVideoResourceManager.a((String)localObject1, (List)localObject2)) });
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (ShortVideoResourceManager.SVConfigItem)((Iterator)localObject2).next();
          if (((ShortVideoResourceManager.SVConfigItem)localObject1).name.startsWith("new_qq_android_native_short_new_other_"))
          {
            localObject2 = localQQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/YT_identify_new/";
            String str1 = ((ShortVideoResourceManager.SVConfigItem)localObject1).armv7a_url;
            String str2 = ((ShortVideoResourceManager.SVConfigItem)localObject1).armv7a_md5;
            int i = ((ShortVideoResourceManager.SVConfigItem)localObject1).versionCode;
            QLog.d("qqidentification_server", 1, new Object[] { "no res,start download, localpath is", localObject2, " version is : ", Integer.valueOf(i), " app so bits is : ", Integer.valueOf(aiao.Fy()) });
            b(localQQAppInterface, str1, str2, (String)localObject2, i);
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        if (!localQQAppInterface.isLogin())
        {
          QLog.d("qqidentification_server", 1, "startDownloadResourceNoLogin");
          angj.bC(localQQAppInterface);
        }
      }
      else {
        return bool;
      }
      QLog.d("qqidentification_server", 1, "startDownloadResource");
      angj.bB(localQQAppInterface);
      return bool;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.dg.get())
    {
      QLog.d("qqidentification_server", 1, "identification res downloading,repeat request... ");
      return;
    }
    this.dg.set(true);
    this.cjH = true;
    aqhq.cm(paramString3);
    da(paramQQAppInterface);
    c(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    this.callbackId = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("qqidentification_server", 2, "onCall, params=" + paramBundle + ", action=" + paramString + ", callBackId=" + paramInt);
    }
    if ("action_upload".equals(paramString))
    {
      if (paramBundle == null)
      {
        QLog.d("qqidentification_server", 1, "onCall, param is null, action=" + paramString + ", callBackId=" + paramInt);
        paramString = new Bundle();
        paramString.putString("subError", "no params");
        paramString.putBoolean("reset_null", true);
        callbackResult(paramInt, EIPCResult.createResult(-102, paramString));
        return null;
      }
      ThreadManager.excute(new IdentificationIpcServer.1(this, paramBundle), 128, null, false);
    }
    for (;;)
    {
      return null;
      if ("action_is_video_chatting".equals(paramString))
      {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        paramBundle = new EIPCResult();
        if (paramString.abk()) {}
        for (paramInt = 1;; paramInt = 2)
        {
          paramBundle.code = paramInt;
          return paramBundle;
        }
      }
      if ("action_res_download".equals(paramString))
      {
        this.dcS = paramInt;
        aoI();
        return null;
      }
      if ("action_app_conf".equals(paramString))
      {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        c(paramBundle, paramInt);
        if (!"loginVerify".equals(paramBundle.getString("method", null))) {
          angj.bB(paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiaq
 * JD-Core Version:    0.7.0.1
 */