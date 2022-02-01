import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherPreloadWebPageConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherPreloadWebPageConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/activity/weather/webpage/WeatherPreloadWebPageConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class abde
  extends aehv<abde.b>
{
  public static final abde.a a = new abde.a(null);
  
  @NotNull
  public abde.b a(int paramInt)
  {
    return new abde.b();
  }
  
  @Nullable
  public abde.b a(@Nullable aeic[] paramArrayOfaeic)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("WeatherPreloadWebPageConfigProcessor", 2, "onParsed");
    }
    abde.b localb = new abde.b();
    if (paramArrayOfaeic != null)
    {
      if (paramArrayOfaeic.length != 0) {
        break label68;
      }
      i = 1;
      if (i != 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        paramArrayOfaeic = paramArrayOfaeic[0].content;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfaeic, "confFiles[0].content");
        localb.parse(paramArrayOfaeic);
      }
      return localb;
      i = 0;
      break;
    }
  }
  
  public void a(@Nullable abde.b paramb) {}
  
  @NotNull
  public Class<abde.b> clazz()
  {
    return abde.b.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 638;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherPreloadWebPageConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "enablePreloadWebProcess", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a
  {
    public final boolean XQ()
    {
      Object localObject = aeif.a().o(638);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "QConfigManager.getSingle…n().loadConObj(CONFIG_ID)");
      return ((abde.b)localObject).XR();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherPreloadWebPageConfigProcessor$Config;", "", "()V", "preloadWebProcess", "", "getPreloadWebProcess", "()Z", "setPreloadWebProcess", "(Z)V", "parse", "", "configText", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class b
  {
    private boolean bBT = true;
    
    public final boolean XR()
    {
      return this.bBT;
    }
    
    public final void parse(@NotNull String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "configText");
      if (QLog.isColorLevel()) {
        QLog.d("WeatherPreloadWebPageConfigProcessor", 2, paramString);
      }
      if (!TextUtils.isEmpty((CharSequence)paramString)) {}
      try
      {
        if (new JSONObject(paramString).optInt("ConfigEnablePreloadWebProcess", 1) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          this.bBT = bool;
          return;
        }
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("WeatherPreloadWebPageConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abde
 * JD-Core Version:    0.7.0.1
 */