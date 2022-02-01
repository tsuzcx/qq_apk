import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$requestAndCompareAdCode$1", "Lcom/tencent/mobileqq/app/soso/LbsManagerService$OnLocationChangeListener;", "onLocationFinish", "", "errCode", "", "info", "Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class abdg
  extends aczc.b
{
  abdg(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramBoolean, bool);
  }
  
  public void onLocationFinish(int paramInt, @Nullable SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {}
    for (;;)
    {
      try
      {
        paramSosoLbsInfo = paramSosoLbsInfo.a.cityCode;
        Intrinsics.checkExpressionValueIsNotNull(paramSosoLbsInfo, "info.mLocation.cityCode");
        if ((!TextUtils.isEmpty((CharSequence)paramSosoLbsInfo)) && (!TextUtils.equals((CharSequence)paramSosoLbsInfo, (CharSequence)this.bfp)))
        {
          Object localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("type", 2);
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("adcode", paramSosoLbsInfo);
          ((JSONObject)localObject1).put("data", localObject2);
          localObject2 = this.b.v();
          localObject1 = ((JSONObject)localObject1).toString();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "params.toString()");
          ((MutableLiveData)localObject2).postValue(new abdl(0, "receive_ark_msg", (String)localObject1, null, 0, 0, 56, null));
        }
        if (QLog.isColorLevel()) {
          QLog.d("WeatherWebArkViewModel", 2, "errCode ：" + paramInt + ", curAdCode: " + paramSosoLbsInfo + ", originAdCode: " + this.bfp);
        }
        return;
      }
      catch (Throwable paramSosoLbsInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WeatherWebArkViewModel", 2, paramSosoLbsInfo, new Object[0]);
        }
      }
      paramSosoLbsInfo = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdg
 * JD-Core Version:    0.7.0.1
 */