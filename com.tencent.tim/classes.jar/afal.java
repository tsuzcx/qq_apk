import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import java.util.Map;
import mqq.app.AppRuntime;

public class afal
  implements IDTParamProvider
{
  public String getAdCode()
  {
    return null;
  }
  
  public String getAppVersion()
  {
    return AppSetting.getVersion();
  }
  
  public String getCallFrom()
  {
    return null;
  }
  
  public String getCallScheme()
  {
    return null;
  }
  
  public String getChannelId()
  {
    return null;
  }
  
  public String getFactoryChannelId()
  {
    return null;
  }
  
  public String getGuid()
  {
    return null;
  }
  
  public String getMainLogin()
  {
    return null;
  }
  
  public String getModifyChannelId()
  {
    return null;
  }
  
  public String getOaid()
  {
    return null;
  }
  
  public String getOmgId()
  {
    return null;
  }
  
  public String getOmgbzid()
  {
    return null;
  }
  
  public String getQQ()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    if (localObject2 != null) {
      localObject1 = ((BaseApplicationImpl)localObject2).getRuntime();
    }
    if (localObject1 == null) {
      localObject1 = "0";
    }
    do
    {
      return localObject1;
      localObject2 = ((AppRuntime)localObject1).getAccount();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return "0";
  }
  
  public String getQQOpenID()
  {
    return null;
  }
  
  public String getSIMType()
  {
    if (aqux.Mv() == 1) {
      return "1";
    }
    return "3";
  }
  
  public int getStartType()
  {
    return 0;
  }
  
  public String getTid()
  {
    return null;
  }
  
  public String getWbOpenID()
  {
    return null;
  }
  
  public String getWxOpenID()
  {
    return null;
  }
  
  public String getWxUnionID()
  {
    return null;
  }
  
  public void setEventDynamicParams(String paramString, Map<String, Object> paramMap) {}
  
  public void setNonRealtimePublicDynamicParams(Map<String, Object> paramMap) {}
  
  public void setRealtimePublicDynamicParams(Map<String, Object> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afal
 * JD-Core Version:    0.7.0.1
 */