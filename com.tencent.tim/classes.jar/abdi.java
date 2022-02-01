import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt.hasFollowWeather.1;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt.startNewWeatherWebPageActivityByFollowState.1;
import com.tencent.mobileqq.activity.weather.webpage.WebViewFragmentWithArk;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessManager.a;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"BASE_URL", "", "DAY", "", "TAG", "WEATHER_ARK_DEFAULT_HEIGHT", "WEATHER_WEB_PREFIX", "clearUnRead", "", "accountUin", "getAdCodeFromArkAppMessage", "ark", "Lcom/tencent/mobileqq/activity/weather/webpage/WaterfallArk;", "getLastUnreadWaterfallArk", "Lcom/tencent/mobileqq/data/MessageRecord;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getWaterFallArkFromChatMessage", "message", "getWeatherWebUrl", "adCode", "height", "hasFollowWeather", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isFollow", "hasUnreadArkMsg", "isNewWeatherPushMsg", "mr", "isSameDayWithLastPreload", "isWeatherArkPageUrl", "url", "preloadWebProcess", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "startNewWeatherWebPageActivity", "context", "Landroid/content/Context;", "startNewWeatherWebPageActivityByFollowState", "from", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class abdi
{
  private static final void Br(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = BaseApplicationImpl.getApplication().getAppRuntime(paramString);
      if ((paramString instanceof QQAppInterface))
      {
        anod.T(1, 0, 1008, ((QQAppInterface)paramString).a().A("2658655094", 1008));
        ((QQAppInterface)paramString).b().a("2658655094", 1008, true, true);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("WeatherWebPageHelper", 1, paramString, new Object[0]);
    }
  }
  
  private static final boolean P(QQAppInterface paramQQAppInterface)
  {
    int j = paramQQAppInterface.a().A("2658655094", 1008);
    if (j > 0)
    {
      paramQQAppInterface = paramQQAppInterface.b().f("2658655094", 1008);
      int i = paramQQAppInterface.size() - 1;
      j = Math.max(0, paramQQAppInterface.size() - j);
      if (i >= j) {
        for (;;)
        {
          if (T((MessageRecord)paramQQAppInterface.get(i))) {
            return true;
          }
          if (i == j) {
            break;
          }
          i -= 1;
        }
      }
    }
    return false;
  }
  
  private static final boolean Q(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (String)aqmj.b((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), "key_last_preload_web_process", "");
    if (!TextUtils.isEmpty((CharSequence)paramQQAppInterface))
    {
      Object localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse(paramQQAppInterface);
      paramQQAppInterface = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "calendarLast");
      paramQQAppInterface.setTime((Date)localObject);
      localObject = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "calendarNow");
      ((Calendar)localObject).setTime(new Date());
      if ((paramQQAppInterface.get(0) == ((Calendar)localObject).get(0)) && (paramQQAppInterface.get(1) == ((Calendar)localObject).get(1)) && (paramQQAppInterface.get(6) == ((Calendar)localObject).get(6))) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean T(@Nullable MessageRecord paramMessageRecord)
  {
    paramMessageRecord = a(paramMessageRecord);
    if (paramMessageRecord != null) {
      return (!TextUtils.isEmpty((CharSequence)paramMessageRecord.getAppName())) && (!TextUtils.isEmpty((CharSequence)paramMessageRecord.qQ())) && (!TextUtils.isEmpty((CharSequence)paramMessageRecord.getAppVersion())) && (!TextUtils.isEmpty((CharSequence)paramMessageRecord.qP()));
    }
    return false;
  }
  
  private static final abdb a(MessageRecord paramMessageRecord)
  {
    try
    {
      if ((paramMessageRecord instanceof QQMessageFacade.Message)) {
        paramMessageRecord = ((QQMessageFacade.Message)paramMessageRecord).lastMsg;
      }
      while (((paramMessageRecord instanceof MessageForArkApp)) && (((MessageForArkApp)paramMessageRecord).ark_app_message != null) && (!TextUtils.isEmpty((CharSequence)((MessageForArkApp)paramMessageRecord).ark_app_message.metaList)))
      {
        Object localObject = new JSONObject(((MessageForArkApp)paramMessageRecord).ark_app_message.metaList).optJSONObject("weather").optJSONObject("waterfall_ark");
        paramMessageRecord = ((JSONObject)localObject).optString("app");
        String str1 = ((JSONObject)localObject).optString("meta");
        String str2 = ((JSONObject)localObject).optString("view");
        localObject = ((JSONObject)localObject).optString("ver");
        Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "app");
        Intrinsics.checkExpressionValueIsNotNull(str1, "meta");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "ver");
        Intrinsics.checkExpressionValueIsNotNull(str2, "view");
        paramMessageRecord = new abdb(paramMessageRecord, str1, (String)localObject, str2);
        return paramMessageRecord;
      }
      return null;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.d("WeatherWebPageHelper", 1, paramMessageRecord, new Object[0]);
    }
  }
  
  private static final MessageRecord a(QQAppInterface paramQQAppInterface)
  {
    List localList = paramQQAppInterface.b().f("2658655094", 1008);
    int i = localList.size() - 1;
    while (i >= 0)
    {
      paramQQAppInterface = (ChatMessage)localList.get(i);
      if ((paramQQAppInterface instanceof QQMessageFacade.Message)) {}
      for (paramQQAppInterface = ((QQMessageFacade.Message)paramQQAppInterface).lastMsg; (paramQQAppInterface instanceof MessageForArkApp); paramQQAppInterface = (MessageRecord)paramQQAppInterface) {
        return paramQQAppInterface;
      }
      i -= 1;
    }
    return null;
  }
  
  private static final String a(abdb paramabdb)
  {
    try
    {
      paramabdb = new JSONObject(paramabdb.qP()).optJSONObject("qq_weather").optString("adcode", "");
      Intrinsics.checkExpressionValueIsNotNull(paramabdb, "weather.optString(\"adcode\", \"\")");
      return paramabdb;
    }
    catch (Throwable paramabdb)
    {
      QLog.d("WeatherWebPageHelper", 1, paramabdb, new Object[0]);
    }
    return "";
  }
  
  public static final void a(@NotNull Context paramContext, @NotNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    a(paramQQAppInterface, (Function1)new WeatherWebPageHelperKt.startNewWeatherWebPageActivityByFollowState.1(paramContext, paramQQAppInterface, paramInt));
  }
  
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    paramQQAppInterface = paramQQAppInterface.getManager(56);
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.PublicAccountDataManager");
    }
    paramQQAppInterface = (acja)paramQQAppInterface;
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = paramQQAppInterface.b("2658655094");
    if ((AccountDetail)localObjectRef.element == null)
    {
      ThreadManager.excute((Runnable)new WeatherWebPageHelperKt.hasFollowWeather.1(localObjectRef, paramQQAppInterface, paramFunction1), 32, null, true);
      return;
    }
    if (((AccountDetail)localObjectRef.element).followType == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramFunction1.invoke(Boolean.valueOf(bool));
      return;
    }
  }
  
  @NotNull
  public static final String aa(@Nullable String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("https://weather.mp.qq.com/pages/aio?_wv=16782343&_wwv=4&not_short=1").append("&height=").append(paramInt);
    if (!TextUtils.isEmpty((CharSequence)paramString)) {}
    for (paramString = "&adcode=" + paramString;; paramString = "")
    {
      paramString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d("WeatherWebPageHelper", 2, "getWeatherWebUrl -> url: " + paramString);
      }
      return paramString;
    }
  }
  
  public static final boolean b(@NotNull Context paramContext, @NotNull QQAppInterface paramQQAppInterface)
  {
    String str1 = null;
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    if (!abdh.a.XS()) {
      return false;
    }
    MessageRecord localMessageRecord = a(paramQQAppInterface);
    abdb localabdb = a(localMessageRecord);
    if (localabdb != null)
    {
      boolean bool = WebProcessManager.aFS();
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      String str2 = a(localabdb);
      localIntent.putExtra("url", a(str2, 0, 2, null));
      localIntent.putExtra("isTransparentTitle", true);
      localIntent.putExtra("fragment_class", WebViewFragmentWithArk.class.getCanonicalName());
      localIntent.putExtra("appName", localabdb.getAppName());
      localIntent.putExtra("appView", localabdb.qQ());
      localIntent.putExtra("appVersion", localabdb.getAppVersion());
      localIntent.putExtra("appMeta", localabdb.qP());
      localIntent.putExtra("adCode", str2);
      localIntent.putExtra("startClickTime", System.currentTimeMillis());
      localIntent.putExtra("webProcessExist", bool);
      paramContext.startActivity(localIntent);
      if (localMessageRecord != null) {
        str1 = localMessageRecord.selfuin;
      }
      Br(str1);
      aqmj.a(paramContext, paramQQAppInterface.getCurrentAccountUin(), true, "key_last_open_weather_page", Long.valueOf(System.currentTimeMillis()));
      if (bool) {}
      for (paramContext = "new_folder_prestart_open";; paramContext = "new_folder_noprestart_open")
      {
        abcx.a().E(paramQQAppInterface, paramContext);
        long l1 = NetConnInfoCenter.getServerTime();
        if (localMessageRecord == null) {
          Intrinsics.throwNpe();
        }
        long l2 = localMessageRecord.time;
        abcx.a().a(paramQQAppInterface, "new_folder_push_open_timegap", Long.valueOf(l1 - l2));
        return true;
      }
    }
    return false;
  }
  
  public static final boolean ji(@Nullable String paramString)
  {
    return (paramString != null) && (StringsKt.startsWith$default(paramString, "https://weather.mp.qq.com/pages/aio", false, 2, null) == true);
  }
  
  public static final void n(@NotNull BaseActivity paramBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "activity");
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebPageHelper", 2, "preloadWebProcess");
    }
    if (!abde.a.XQ()) {
      if (QLog.isColorLevel()) {
        QLog.d("WeatherWebPageHelper", 2, "WeatherPreloadWebPageConfigProcessor unable");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (abdh.a.XS()) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("WeatherWebPageHelper", 2, "WeatherWebPageConfigProcessor unable");
              return;
              localObject1 = (Context)paramBaseActivity;
              localObject2 = paramBaseActivity.app;
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity.app");
              localObject1 = (Long)aqmj.b((Context)localObject1, ((QQAppInterface)localObject2).getCurrentAccountUin(), "key_last_open_weather_page", Long.valueOf(0L));
              long l = System.currentTimeMillis();
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "lastOpenTime");
              if (l - ((Long)localObject1).longValue() <= 259200000) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("WeatherWebPageHelper", 2, "lastOpenTime unable lastOpenTime ：" + localObject1);
            return;
            localObject1 = paramBaseActivity.app;
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.app");
            if (!Q((QQAppInterface)localObject1)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("WeatherWebPageHelper", 2, "isSameDayWithLastPreload unable");
          return;
          if (!aqgz.aCI()) {
            break;
          }
          abcx.a().E(paramBaseActivity.app, "new_folder_noprestart_lowsystem");
        } while (!QLog.isColorLevel());
        QLog.d("WeatherWebPageHelper", 2, "DeviceInfoUtil unable");
        return;
        localObject1 = paramBaseActivity.app;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.app");
        if (P((QQAppInterface)localObject1)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("WeatherWebPageHelper", 2, "hasUnreadArkMsg unable");
      return;
      localObject1 = paramBaseActivity.app.getManager(13);
    } while (!(localObject1 instanceof WebProcessManager));
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebPageHelper", 2, "do preload Web Process");
    }
    ((WebProcessManager)localObject1).a(-1, (WebProcessManager.a)new abdj(paramBaseActivity));
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
    Object localObject2 = (Context)BaseApplicationImpl.context;
    paramBaseActivity = paramBaseActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "activity.app");
    aqmj.a((Context)localObject2, paramBaseActivity.getCurrentAccountUin(), true, "key_last_preload_web_process", ((SimpleDateFormat)localObject1).format(new Date()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdi
 * JD-Core Version:    0.7.0.1
 */