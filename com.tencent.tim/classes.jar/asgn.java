import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qg.qq.QGameApp.1;
import com.tencent.qg.qq.QGameApp.3;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.io.File;
import org.json.JSONObject;

public class asgn
  extends ajck
  implements IEventReceiver
{
  public static volatile boolean sLibLoaded;
  private asgn.a a;
  
  public asgn(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
  {
    super(paramMiniAppActivity, paramString, paramInt);
  }
  
  private String[] S()
  {
    String str3 = this.d.extras.getString("unzipped_path");
    String str2 = s(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs", "ejecta.js");
    String str1 = null;
    if (!TextUtils.isEmpty(str3)) {
      str1 = getFilePath(str3, this.d.cacheKey, "index.js");
    }
    return new String[] { str2, str1 };
  }
  
  private void Zr(int paramInt)
  {
    QLog.e("QGameApp", 1, new Object[] { "dispatchAppInitFailed. errorCode=", Integer.valueOf(paramInt) });
    ajcm localajcm = new ajcm();
    localajcm.type = 4;
    localajcm.d = this.d;
    pmi.a().dispatch("MiniAppManager", localajcm);
  }
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private boolean aHN()
  {
    int i = 0;
    if (!sLibLoaded)
    {
      Object localObject = new File(ar(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs"));
      if (!((File)localObject).isDirectory()) {}
      do
      {
        return false;
        localObject = ((File)localObject).listFiles(new asgo(this));
      } while ((localObject == null) || (localObject.length == 0));
      int j = localObject.length;
      while (i < j)
      {
        System.load(localObject[i].getAbsolutePath());
        i += 1;
      }
      sLibLoaded = true;
    }
    return true;
  }
  
  private void aV(boolean paramBoolean, String paramString)
  {
    ThreadManagerV2.excute(new QGameApp.3(this, paramBoolean, paramString), 64, null, true);
  }
  
  public static String ar(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramContext.getCacheDir().getAbsolutePath();
    }
    return paramContext.getCacheDir().getAbsolutePath() + File.separator + paramString;
  }
  
  private boolean g(boolean paramBoolean, String paramString)
  {
    boolean bool = false;
    String str1;
    String str2;
    if (!paramBoolean)
    {
      str1 = qU(s(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs", "libsconfig.json"));
      str2 = qU(getFilePath(paramString, "", "libsconfig.json"));
      if ((!TextUtils.isEmpty(str2)) && (str2.equals(str1))) {
        paramBoolean = true;
      }
    }
    do
    {
      return paramBoolean;
      str1 = getFilePath(paramString, "qgamelibs", "");
      str2 = ar(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs") + File.separator;
      aqhq.cm(str2);
      paramBoolean = bool;
    } while (aqhq.c(str1, str2, false) < 0);
    return aqhq.copyFile(getFilePath(paramString, "", "libsconfig.json"), s(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs", "libsconfig.json"));
  }
  
  public static String getFilePath(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString1 + File.separator + paramString2;
    }
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = str + File.separator + paramString3;
    }
    return paramString1;
  }
  
  private String qU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return "";
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    try
    {
      paramString = new JSONObject(aqhq.readFileToString(paramString)).optString("version");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void realStart()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QGameApp.1(this), 1000L);
  }
  
  public static String s(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return ar(paramContext, paramString1);
    }
    return ar(paramContext, paramString1) + File.separator + paramString2;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity != null;
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Asgn$a != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Asgn$a);
    }
  }
  
  public void start()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity != null)
    {
      this.jdField_a_of_type_Asgn$a = new asgn.a(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Asgn$a);
      ajcl localajcl = ajcr.a().a("ak:3214");
      if (localajcl != null) {
        localajcl.f("ak:3214", "QGameApp", this.d.cacheKey);
      }
    }
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity.finish();
    }
  }
  
  public static class a
    extends QQUIEventReceiver<asgn, ajcm>
  {
    public a(@NonNull asgn paramasgn)
    {
      super();
    }
    
    public void a(@NonNull asgn paramasgn, @NonNull ajcm paramajcm)
    {
      if (!TextUtils.equals(paramajcm.src, "QGameApp")) {}
      String str;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QGameApp", 2, "receive event:" + paramajcm.toString());
        }
        str = (String)paramajcm.s[0];
        switch (paramajcm.type)
        {
        default: 
          return;
        }
      } while (!TextUtils.equals(str, "ak:3214"));
      if (paramajcm.isSuccess)
      {
        str = (String)paramajcm.s[3];
        if (TextUtils.isEmpty(str))
        {
          asgn.a(paramasgn, 1002);
          return;
        }
        switch (((Integer)paramajcm.s[2]).intValue())
        {
        default: 
          return;
        case 1: 
          asgn.a(paramasgn, true, str);
          return;
        case 2: 
          asgn.sLibLoaded = false;
          return;
        }
        asgn.a(paramasgn, false, str);
        return;
      }
      asgn.a(paramasgn, 1002);
    }
    
    public Class acceptEventClass()
    {
      return ajcm.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgn
 * JD-Core Version:    0.7.0.1
 */