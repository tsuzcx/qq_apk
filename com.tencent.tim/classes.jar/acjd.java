import android.text.TextUtils;
import com.tencent.jungle.weather.WeatherReportInfo.GetWeatherMessageReq;
import com.tencent.jungle.weather.WeatherReportInfo.PbReqMsgHead;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class acjd
  extends aczc.b
{
  public acjd(PublicAccountHandler paramPublicAccountHandler, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("errCode ：").append(paramInt).append(" info is null ---> ");
      if (paramSosoLbsInfo == null)
      {
        bool = true;
        QLog.d("PublicAccountHandler", 2, bool);
      }
    }
    else
    {
      if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
        break label696;
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.parseInt(paramSosoLbsInfo.a.cityCode);
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountHandler", 2, "LocalInfo" + paramInt);
        }
        localObject1 = "3.4.4".replaceAll("\\.", "");
        paramSosoLbsInfo = new WeatherReportInfo.PbReqMsgHead();
        paramSosoLbsInfo.uint32_platform_type.set(1);
        paramSosoLbsInfo.uint32_version.set(Integer.parseInt((String)localObject1));
        localGetWeatherMessageReq = new WeatherReportInfo.GetWeatherMessageReq();
        localGetWeatherMessageReq.pbReqMsgHead.set(paramSosoLbsInfo);
        localGetWeatherMessageReq.uin.set(Long.valueOf(this.this$0.app.getCurrentAccountUin()).longValue());
        localGetWeatherMessageReq.lat.set(this.aCc);
        localGetWeatherMessageReq.lng.set(this.cxi);
        localGetWeatherMessageReq.fore_flag.set(0);
        localGetWeatherMessageReq.area_id.set(this.bYF);
        localGetWeatherMessageReq.adcode_from_mapsdk.set(paramInt);
      }
      catch (Throwable paramSosoLbsInfo)
      {
        try
        {
          for (;;)
          {
            paramSosoLbsInfo = new JSONObject();
            if (this.val$type != 0) {
              break label445;
            }
            localGetWeatherMessageReq.source.set(2);
            paramSosoLbsInfo.put("platform", 109);
            paramSosoLbsInfo.put("version", "3.4.4");
            localObject1 = paramSosoLbsInfo.toString();
            localObject2 = localGetWeatherMessageReq.extra;
            paramSosoLbsInfo = (SosoInterface.SosoLbsInfo)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramSosoLbsInfo = "";
            }
            ((PBStringField)localObject2).set(paramSosoLbsInfo);
            paramSosoLbsInfo = PublicAccountHandler.bov;
            localObject1 = paramSosoLbsInfo;
            if (!TextUtils.isEmpty(paramSosoLbsInfo)) {
              break label505;
            }
            try
            {
              localObject2 = alkz.getNetworkInterfaces();
              for (;;)
              {
                localObject1 = paramSosoLbsInfo;
                if (!((Enumeration)localObject2).hasMoreElements()) {
                  break;
                }
                localObject1 = ((NetworkInterface)((Enumeration)localObject2).nextElement()).getInetAddresses();
                InetAddress localInetAddress;
                do
                {
                  if (!((Enumeration)localObject1).hasMoreElements()) {
                    break;
                  }
                  localInetAddress = (InetAddress)((Enumeration)localObject1).nextElement();
                } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
                paramSosoLbsInfo = localInetAddress.getHostAddress().toString();
              }
              bool = false;
            }
            catch (Exception paramSosoLbsInfo)
            {
              label445:
              localObject1 = "";
              paramSosoLbsInfo.printStackTrace();
            }
          }
          paramSosoLbsInfo = paramSosoLbsInfo;
          if (QLog.isColorLevel()) {
            QLog.e("PublicAccountHandler", 2, paramSosoLbsInfo, new Object[0]);
          }
          paramInt = 0;
          continue;
          if (this.val$type == -1)
          {
            localGetWeatherMessageReq.source.set(1);
            continue;
          }
        }
        catch (JSONException paramSosoLbsInfo)
        {
          WeatherReportInfo.GetWeatherMessageReq localGetWeatherMessageReq;
          Object localObject2;
          paramSosoLbsInfo.printStackTrace();
          continue;
          paramSosoLbsInfo.put("cmd", this.val$type);
          localGetWeatherMessageReq.source.set(0);
          continue;
          label505:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            try
            {
              paramSosoLbsInfo = ((String)localObject1).split(Pattern.quote("."));
              k = paramSosoLbsInfo.length;
              j = 0;
              paramInt = 0;
            }
            catch (Exception paramSosoLbsInfo)
            {
              try
              {
                int k;
                int j;
                paramInt = Integer.parseInt((String)localObject2);
                j += 1;
                paramInt = i | paramInt;
              }
              catch (Exception paramSosoLbsInfo)
              {
                continue;
              }
              paramSosoLbsInfo = paramSosoLbsInfo;
              i = 0;
            }
            i = paramInt;
            if (j < k)
            {
              localObject2 = paramSosoLbsInfo[j];
              i = paramInt << 8;
              paramSosoLbsInfo.printStackTrace();
            }
            PublicAccountHandler.bov = (String)localObject1;
            localGetWeatherMessageReq.ip.set(i);
            paramSosoLbsInfo = this.this$0.createToServiceMsg("QQWeatherReport.getWeatherInfo");
            paramSosoLbsInfo.putWupBuffer(localGetWeatherMessageReq.toByteArray());
            this.this$0.sendPbReq(paramSosoLbsInfo);
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountHandler", 2, String.format("send tianqi lat=%d, lng=%d, type=%d, areaid = %d", new Object[] { Integer.valueOf(this.aCc), Integer.valueOf(this.cxi), Integer.valueOf(this.val$type), Integer.valueOf(this.bYF) }));
            }
            return;
          }
          int i = 0;
          continue;
          continue;
        }
      }
      label696:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acjd
 * JD-Core Version:    0.7.0.1
 */