import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class apdx
{
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, apdx.a parama, String paramString)
  {
    if ((paramItem == null) || (parama == null)) {}
    do
    {
      return;
      localObject = apef.getApp();
    } while (localObject == null);
    Object localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    String str = apef.getNetWorkTypeName();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_group_code", String.valueOf(paramLong));
    localHashMap.put("param_self_uin", localObject);
    localHashMap.put("param_file_name", paramItem.FileName);
    localHashMap.put("param_suffix", ahbj.getExtension(paramItem.FileName));
    localHashMap.put("param_file_size", String.valueOf(paramItem.ProgressTotal));
    localHashMap.put("param_uuid", paramItem.FilePath);
    localHashMap.put("param_store_type", String.valueOf(paramItem.BusId));
    localHashMap.put("param_result", String.valueOf(0));
    localHashMap.put("param_sub_reason", String.valueOf(0));
    localHashMap.put("param_http_status_code", String.valueOf(parama.dTJ));
    localHashMap.put("param_err_msg", "");
    localHashMap.put("param_flash_transfer", String.valueOf(parama.cQb));
    localHashMap.put("param_retry_count", String.valueOf(paramItem.retryTimes));
    localHashMap.put("param_proxy_type", String.valueOf(parama.proxyType));
    localHashMap.put("param_net_type", str);
    localHashMap.put("param_security_time", String.valueOf(parama.arg));
    localHashMap.put("param_check_time", String.valueOf(parama.arh));
    localHashMap.put("param_server_ip", String.valueOf(parama.serverIp));
    localHashMap.put("param_server_port", String.valueOf(parama.port));
    localHashMap.put("param_file_url", parama.url);
    localHashMap.put("param_start_size", String.valueOf(parama.arf));
    localHashMap.put("param_transfer_size", String.valueOf(parama.transferedSize));
    localHashMap.put("param_transfer_time", String.valueOf(parama.transferTime));
    localHashMap.put("param_transfer_speed", String.valueOf(parama.speed));
    localHashMap.put("param_fromType", String.valueOf(parama.fromType));
    localHashMap.put("param_V6SelectType", String.valueOf(parama.dTL));
    localHashMap.put("param_ipAddrType", String.valueOf(parama.dTM));
    localHashMap.put("param_stackType", String.valueOf(ahbr.EL()));
    localHashMap.put("param_loginType", String.valueOf(ahbr.EM()));
    localHashMap.put("param_ishttps", String.valueOf(parama.afE));
    paramLong = parama.startTime;
    long l = System.currentTimeMillis();
    if (parama.startTime == 0L) {
      paramLong = l;
    }
    if (paramLong < 1L) {}
    for (paramLong = 0L;; paramLong = l - paramLong)
    {
      l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      apef.b.i("TroopFileDataReporter", apef.b.USR, "[GroupSend]reportUploadSucInfo. reportType:" + paramString + " params:" + localHashMap.toString());
      anpc.a(BaseApplication.getContext()).collectPerformance((String)localObject, paramString, true, l, 1, localHashMap, "");
      return;
    }
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, String paramString, apdx.a parama)
  {
    if ((paramItem == null) || (parama == null)) {}
    do
    {
      return;
      localObject = apef.getApp();
    } while (localObject == null);
    Object localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    String str = apef.getNetWorkTypeName();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_group_code", String.valueOf(paramLong));
    localHashMap.put("param_self_uin", localObject);
    localHashMap.put("param_file_name", paramItem.FileName);
    localHashMap.put("param_suffix", ahbj.getExtension(paramItem.FileName));
    localHashMap.put("param_file_size", String.valueOf(paramItem.ProgressTotal));
    localHashMap.put("param_uuid", paramItem.FilePath);
    localHashMap.put("param_store_type", String.valueOf(paramItem.BusId));
    localHashMap.put("param_result", String.valueOf(parama.resultCode));
    localHashMap.put("param_sub_reason", String.valueOf(parama.dTI));
    localHashMap.put("param_http_status_code", String.valueOf(parama.dTJ));
    localHashMap.put("param_server_return_code", String.valueOf(parama.dTK));
    localHashMap.put("param_err_msg", parama.errMsg);
    localHashMap.put("param_retry_count", String.valueOf(paramItem.retryTimes));
    localHashMap.put("param_proxy_type", String.valueOf(parama.proxyType));
    localHashMap.put("param_net_type", str);
    localHashMap.put("param_security_time", String.valueOf(parama.arg));
    localHashMap.put("param_check_time", String.valueOf(parama.arh));
    localHashMap.put("param_server_ip", String.valueOf(parama.serverIp));
    localHashMap.put("param_server_port", String.valueOf(parama.port));
    localHashMap.put("param_file_url", parama.url);
    localHashMap.put("param_start_size", String.valueOf(parama.arf));
    localHashMap.put("param_transfer_size", String.valueOf(parama.transferedSize));
    localHashMap.put("param_transfer_time", String.valueOf(parama.transferTime));
    localHashMap.put("param_transfer_speed", String.valueOf(parama.speed));
    localHashMap.put("param_fromType", String.valueOf(parama.fromType));
    localHashMap.put("param_V6SelectType", String.valueOf(parama.dTL));
    localHashMap.put("param_ipAddrType", String.valueOf(parama.dTM));
    localHashMap.put("param_stackType", String.valueOf(ahbr.EL()));
    localHashMap.put("param_loginType", String.valueOf(ahbr.EM()));
    localHashMap.put("param_ishttps", String.valueOf(parama.afE));
    paramLong = parama.startTime;
    long l = System.currentTimeMillis();
    if (parama.startTime == 0L) {
      paramLong = l;
    }
    if (paramLong < 1L) {}
    for (paramLong = 0L;; paramLong = l - paramLong)
    {
      l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      apef.b.i("TroopFileDataReporter", apef.b.USR, "[GroupSend]reportUploadFailInfo. reportType:" + paramString + " params:" + localHashMap.toString());
      anpc.a(BaseApplication.getContext()).collectPerformance((String)localObject, paramString, false, l, 1, localHashMap, "");
      return;
    }
  }
  
  public static int aQ(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 404) {
      paramInt2 = 303;
    }
    do
    {
      return paramInt2;
      if ((paramInt2 - 400 >= 0) && (paramInt2 - 400 < 100)) {
        return 304;
      }
      if ((paramInt2 - 500 >= 0) && (paramInt2 - 500 < 100)) {
        return 305;
      }
      if (paramInt1 == 9024) {
        return 303;
      }
      if (paramInt1 == 9060) {
        return 304;
      }
      if (paramInt1 == 9061) {
        return 305;
      }
      if ((paramInt1 == 9052) || (paramInt1 == 9055) || (paramInt1 == 9053)) {
        break;
      }
      paramInt2 = paramInt1;
    } while (paramInt1 != 9054);
    return 307;
  }
  
  @Deprecated
  public static void b(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    if (paramItem == null) {
      return;
    }
    QQAppInterface localQQAppInterface = apef.getApp();
    switch (paramInt1)
    {
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
    case 6: 
      apsv.a(localQQAppInterface, "upload", true, paramItem.transferBeginTime, paramItem.UploadIp, paramLong + "", ahbj.getExtension(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    case 10: 
      apsv.a(localQQAppInterface, "download", false, paramItem.transferBeginTime, paramItem.DownloadIp, paramLong + "", ahbj.getExtension(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    case 9: 
    case 11: 
      apsv.a(localQQAppInterface, "download", true, paramItem.transferBeginTime, paramItem.DownloadIp, paramLong + "", ahbj.getExtension(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    }
    apsv.a(localQQAppInterface, "upload", false, paramItem.transferBeginTime, paramItem.UploadIp, paramLong + "", ahbj.getExtension(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
  }
  
  public static void b(long paramLong, TroopFileTransferManager.Item paramItem, apdx.a parama, String paramString)
  {
    if ((paramItem == null) || (parama == null)) {}
    do
    {
      return;
      localObject = apef.getApp();
    } while (localObject == null);
    Object localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    String str = apef.getNetWorkTypeName();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_group_code", String.valueOf(paramLong));
    localHashMap.put("param_self_uin", localObject);
    localHashMap.put("param_file_name", paramItem.FileName);
    localHashMap.put("param_suffix", ahbj.getExtension(paramItem.FileName));
    localHashMap.put("param_file_size", String.valueOf(paramItem.ProgressTotal));
    localHashMap.put("param_uuid", paramItem.FilePath);
    localHashMap.put("param_store_type", String.valueOf(paramItem.BusId));
    localHashMap.put("param_life_left_second", String.valueOf(parama.ari));
    localHashMap.put("param_result", String.valueOf(0));
    localHashMap.put("param_sub_reason", String.valueOf(0));
    localHashMap.put("param_http_status_code", String.valueOf(parama.dTJ));
    localHashMap.put("param_err_msg", "");
    localHashMap.put("param_retry_count", String.valueOf(paramItem.retryTimes));
    localHashMap.put("param_proxy_type", String.valueOf(parama.proxyType));
    localHashMap.put("param_net_type", str);
    localHashMap.put("param_security_time", String.valueOf(parama.arg));
    localHashMap.put("param_server_ip", String.valueOf(parama.serverIp));
    localHashMap.put("param_server_port", String.valueOf(parama.port));
    localHashMap.put("param_file_url", parama.url);
    localHashMap.put("param_start_size", String.valueOf(parama.arf));
    localHashMap.put("param_transfer_size", String.valueOf(parama.transferedSize));
    localHashMap.put("param_transfer_time", String.valueOf(parama.transferTime));
    localHashMap.put("param_transfer_speed", String.valueOf(parama.speed));
    localHashMap.put("param_fromType", String.valueOf(parama.fromType));
    localHashMap.put("param_V6SelectType", String.valueOf(parama.dTL));
    localHashMap.put("param_ipAddrType", String.valueOf(parama.dTM));
    localHashMap.put("param_stackType", String.valueOf(ahbr.EL()));
    localHashMap.put("param_loginType", String.valueOf(ahbr.EM()));
    localHashMap.put("param_ishttps", String.valueOf(parama.afE));
    paramLong = parama.startTime;
    long l = System.currentTimeMillis();
    if (parama.startTime == 0L) {
      paramLong = l;
    }
    if (paramLong < 1L) {}
    for (paramLong = 0L;; paramLong = l - paramLong)
    {
      l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      apef.b.i("TroopFileDataReporter", apef.b.USR, "[GroupDownload]reportDownloadSucInfo. reportType:" + paramString + " params:" + localHashMap.toString());
      anpc.a(BaseApplication.getContext()).collectPerformance((String)localObject, paramString, true, l, 1, localHashMap, "");
      return;
    }
  }
  
  public static void b(long paramLong, TroopFileTransferManager.Item paramItem, String paramString, apdx.a parama)
  {
    if ((paramItem == null) || (parama == null)) {}
    do
    {
      return;
      localObject = apef.getApp();
    } while (localObject == null);
    Object localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    String str = apef.getNetWorkTypeName();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_group_code", String.valueOf(paramLong));
    localHashMap.put("param_self_uin", localObject);
    localHashMap.put("param_file_name", paramItem.FileName);
    localHashMap.put("param_suffix", ahbj.getExtension(paramItem.FileName));
    localHashMap.put("param_file_size", String.valueOf(paramItem.ProgressTotal));
    localHashMap.put("param_uuid", paramItem.FilePath);
    localHashMap.put("param_store_type", String.valueOf(paramItem.BusId));
    localHashMap.put("param_life_left_second", String.valueOf(parama.ari));
    localHashMap.put("param_result", String.valueOf(parama.resultCode));
    localHashMap.put("param_sub_reason", String.valueOf(parama.dTI));
    localHashMap.put("param_http_status_code", String.valueOf(parama.dTJ));
    localHashMap.put("param_server_return_code", String.valueOf(parama.dTK));
    localHashMap.put("param_err_msg", parama.errMsg);
    localHashMap.put("param_retry_count", String.valueOf(paramItem.retryTimes));
    localHashMap.put("param_proxy_type", String.valueOf(parama.proxyType));
    localHashMap.put("param_net_type", str);
    localHashMap.put("param_security_time", String.valueOf(parama.arg));
    localHashMap.put("param_server_ip", String.valueOf(parama.serverIp));
    localHashMap.put("param_server_port", String.valueOf(parama.port));
    localHashMap.put("param_file_url", parama.url);
    localHashMap.put("param_start_size", String.valueOf(parama.arf));
    localHashMap.put("param_transfer_size", String.valueOf(parama.transferedSize));
    localHashMap.put("param_transfer_time", String.valueOf(parama.transferTime));
    localHashMap.put("param_transfer_speed", String.valueOf(parama.speed));
    localHashMap.put("param_fromType", String.valueOf(parama.fromType));
    localHashMap.put("param_V6SelectType", String.valueOf(parama.dTL));
    localHashMap.put("param_ipAddrType", String.valueOf(parama.dTM));
    localHashMap.put("param_stackType", String.valueOf(ahbr.EL()));
    localHashMap.put("param_loginType", String.valueOf(ahbr.EM()));
    localHashMap.put("param_ishttps", String.valueOf(parama.afE));
    paramLong = parama.startTime;
    long l = System.currentTimeMillis();
    if (parama.startTime == 0L) {
      paramLong = l;
    }
    if (paramLong < 1L) {}
    for (paramLong = 0L;; paramLong = l - paramLong)
    {
      l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      apef.b.i("TroopFileDataReporter", apef.b.USR, "[GroupDownload]reportDownloadFailInfo. reportType:" + paramString + " params:" + localHashMap.toString());
      anpc.a(BaseApplication.getContext()).collectPerformance((String)localObject, paramString, false, l, 1, localHashMap, "");
      return;
    }
  }
  
  public static class a
  {
    public int afE;
    public long arf;
    public long arg;
    public long arh;
    public long ari;
    public boolean cQb;
    public String cow;
    public int dTI;
    public int dTJ;
    public int dTK;
    public int dTL = 0;
    public int dTM = 0;
    public String errMsg;
    public int fromType;
    public int port;
    public int proxyType;
    public int resultCode;
    public String serverIp;
    public long speed;
    public long startTime;
    public long transferTime;
    public long transferedSize;
    public String url;
    
    public a()
    {
      reset();
    }
    
    public void reset()
    {
      this.port = 0;
      this.proxyType = 0;
      this.arf = 0L;
      this.transferedSize = 0L;
      this.transferTime = 0L;
      this.startTime = 0L;
      this.speed = 0L;
      this.cQb = false;
      this.resultCode = -1;
      this.dTI = 0;
      this.dTJ = 0;
      this.dTK = 0;
      this.arg = 0L;
      this.arh = 0L;
      this.url = "";
      this.serverIp = "";
      this.errMsg = "";
      this.cow = "";
      this.ari = 0L;
      this.fromType = 0;
      this.dTL = 0;
      this.dTM = 0;
      this.afE = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdx
 * JD-Core Version:    0.7.0.1
 */