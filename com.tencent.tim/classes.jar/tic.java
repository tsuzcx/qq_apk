import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingViewModel.report.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "autoCountAfter5Second", "Lrx/Subscription;", "countDownTime", "", "hasCountDown", "", "leftSecond", "leftSecondSubscription", "motiveBrowsingData", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/gdtad/api/motivebrowsing/MotiveBrowsingData;", "getMotiveBrowsingData", "()Landroid/arch/lifecycle/MutableLiveData;", "msgPathPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "autoCountCheck", "", "callbackJs", "url", "", "onCleared", "onCountDown", "onHandleUrl", "model", "Lcom/tencent/gdtad/api/motivevideo/GdtMotiveVideoModel;", "pauseCountDown", "report", "type", "reportUrl", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "resumeCountDown", "unSubscribe", "subscription", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tic
  extends ViewModel
{
  public static final tic.a a;
  @NotNull
  private final MutableLiveData<tif> A = new MutableLiveData();
  private final Pattern P = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");
  private Subscription a;
  private Subscription b;
  private int bBv;
  private int bBx;
  private boolean hasCountDown;
  
  static
  {
    jdField_a_of_type_Tic$a = new tic.a(null);
  }
  
  private final void a(int paramInt, String paramString, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "report reportUrl : " + paramString);
    }
    tlb.a(paramInt, 0, paramAdInfo);
    ThreadManager.excute((Runnable)new GdtMotiveBrowsingViewModel.report.1(paramString), 128, null, true);
  }
  
  private final void a(Subscription paramSubscription)
  {
    if ((paramSubscription != null) && (!paramSubscription.isUnsubscribed())) {
      paramSubscription.unsubscribe();
    }
  }
  
  private final void bDe()
  {
    a(this.b);
    this.b = ((Subscription)null);
    if (!this.hasCountDown)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GdtMotiveBrowsingViewModel", 2, "onCountDown");
      }
      this.hasCountDown = true;
      this.bBx = this.bBv;
      aTG();
    }
  }
  
  private final void callbackJs(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "callbackJs url : " + paramString);
    }
    Object localObject2 = Uri.parse(paramString);
    Object localObject1;
    Object localObject3;
    if (localObject2 != null)
    {
      paramString = ((Uri)localObject2).getPath();
      localObject1 = this.P.matcher((CharSequence)paramString);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "msgPathPattern.matcher(path)");
      if (((Matcher)localObject1).matches())
      {
        paramString = ((Matcher)localObject1).group(2);
        localObject1 = ((Matcher)localObject1).group(3);
        localObject3 = ((Uri)localObject2).getQueryParameter("q");
      }
    }
    try
    {
      localObject2 = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("action", paramString);
      ((JSONObject)localObject2).put("data", localJSONObject);
      ((JSONObject)localObject2).put("code", 0);
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        paramString = new JSONObject((String)localObject3).optString("bridgeName");
        if (!TextUtils.isEmpty((CharSequence)paramString))
        {
          Intrinsics.checkExpressionValueIsNotNull(paramString, "paramBridgeName");
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("callbackid", localObject1);
          ((JSONObject)localObject3).put("status", 0);
          ((JSONObject)localObject3).put("data", ((JSONObject)localObject2).toString());
          ((JSONObject)localObject3).put("keep", 0);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString).append("(").append(((JSONObject)localObject3).toString()).append(");");
          if (QLog.isColorLevel()) {
            QLog.d("GdtMotiveBrowsingViewModel", 2, "callbackJs script: " + localObject1);
          }
          paramString = this.A;
          localObject1 = ((StringBuilder)localObject1).toString();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "sb.toString()");
          paramString.setValue(new tif(0, (String)localObject1, 0, 4, null));
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.d("GdtMotiveBrowsingViewModel", 2, paramString, new Object[0]);
        continue;
        paramString = "bridge.callback";
      }
    }
  }
  
  public final boolean a(@NotNull String paramString, @Nullable tir paramtir)
  {
    GdtAd localGdtAd1 = null;
    Object localObject = null;
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "onHandleUrl url: " + paramString);
    }
    if (paramtir != null)
    {
      if (!StringsKt.startsWith$default(paramString, "gdtmsg://e.qq.com/reportExposureRewardAd/rewardAD", false, 2, null)) {
        break label116;
      }
      localGdtAd1 = paramtir.a();
      if (localGdtAd1 != null) {
        localObject = localGdtAd1.getUrlForImpression();
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return false;
      }
      paramtir = paramtir.b();
      Intrinsics.checkExpressionValueIsNotNull(paramtir, "model.adInfo");
      a(0, (String)localObject, paramtir);
      callbackJs(paramString);
    }
    for (;;)
    {
      return true;
      label116:
      if (StringsKt.startsWith$default(paramString, "gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/", false, 2, null))
      {
        GdtAd localGdtAd2 = paramtir.a();
        localObject = localGdtAd1;
        if (localGdtAd2 != null) {
          localObject = localGdtAd2.getUrlForClick();
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return false;
        }
        paramtir = paramtir.b();
        Intrinsics.checkExpressionValueIsNotNull(paramtir, "model.adInfo");
        a(1, (String)localObject, paramtir);
        callbackJs(paramString);
      }
      else
      {
        if (!StringsKt.startsWith$default(paramString, "gdtmsg://e.qq.com/startCountDown/rewardAD/", false, 2, null)) {
          break;
        }
        bDe();
      }
    }
    return false;
  }
  
  public final void aTG()
  {
    if ((this.jdField_a_of_type_RxSubscription == null) && (this.bBx > 0))
    {
      this.A.setValue(new tif(1, null, this.bBx, 2, null));
      this.jdField_a_of_type_RxSubscription = Observable.interval(1L, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe((Action1)new tie(this));
    }
  }
  
  public final void aTH()
  {
    a(this.jdField_a_of_type_RxSubscription);
    this.jdField_a_of_type_RxSubscription = ((Subscription)null);
  }
  
  public void onCleared()
  {
    super.onCleared();
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "onCleared");
    }
    a(this.jdField_a_of_type_RxSubscription);
    this.jdField_a_of_type_RxSubscription = ((Subscription)null);
    a(this.b);
    this.b = ((Subscription)null);
  }
  
  @NotNull
  public final MutableLiveData<tif> t()
  {
    return this.A;
  }
  
  public final void zt(int paramInt)
  {
    this.bBv = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "autoCountCheck");
    }
    this.b = Observable.timer(5L, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe((Action1)new tid(this));
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingViewModel$Companion;", "", "()V", "COUNT_DOWN_AUTO_START_SECOND", "", "TAG", "", "WEB_CLICK_REPORT_URL", "WEB_COUNT_DOWN_REPORT_URL", "WEB_EXPOSURE_REPORT_URL", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tic
 * JD-Core Version:    0.7.0.1
 */