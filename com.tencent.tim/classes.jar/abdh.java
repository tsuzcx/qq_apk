import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebPageConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebPageConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebPageConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class abdh
  extends aehv<abdh.b>
{
  public static final abdh.a a = new abdh.a(null);
  
  @NotNull
  public abdh.b a(int paramInt)
  {
    return new abdh.b();
  }
  
  @Nullable
  public abdh.b a(@Nullable aeic[] paramArrayOfaeic)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("WeatherConfigProcessor", 2, "onParsed");
    }
    abdh.b localb = new abdh.b();
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
  
  public void a(@Nullable abdh.b paramb) {}
  
  @NotNull
  public Class<abdh.b> clazz()
  {
    return abdh.b.class;
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
    return 624;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebPageConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "enableNewWebWeatherPage", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a
  {
    public final boolean XS()
    {
      Object localObject = aeif.a().o(624);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "QConfigManager.getSingle…n().loadConObj(CONFIG_ID)");
      return ((abdh.b)localObject).XT();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebPageConfigProcessor$Config;", "", "()V", "newWebWeatherPage", "", "getNewWebWeatherPage", "()Z", "setNewWebWeatherPage", "(Z)V", "parse", "", "configText", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class b
  {
    private boolean bBU;
    
    public final boolean XT()
    {
      return this.bBU;
    }
    
    public final void parse(@NotNull String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "configText");
      if (QLog.isColorLevel()) {
        QLog.d("WeatherConfigProcessor", 2, paramString);
      }
      if (!TextUtils.isEmpty((CharSequence)paramString)) {}
      try
      {
        if (new JSONObject(paramString).optInt("ConfigEnableNewWebWeatherPage", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          this.bBU = bool;
          return;
        }
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("WeatherConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdh
 * JD-Core Version:    0.7.0.1
 */