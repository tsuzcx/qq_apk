import android.os.Bundle;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import mqq.observer.BusinessObserver;

class prj
  implements BusinessObserver
{
  prj(pri parampri, long paramLong, prk paramprk, String paramString, prl paramprl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.val$startTime;
    Object localObject;
    prl localprl;
    String str;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (localObject.length > 0))
      {
        localprl = this.jdField_a_of_type_Prk.a((byte[])localObject);
        if (localprl != null)
        {
          paramInt = localprl.errorCode;
          str = localprl.errorMsg;
          if (paramInt == 0)
          {
            localprl.onSuccess();
            ram.a("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s success take time:%d data length=%d", this.auA, Long.valueOf(l), Integer.valueOf(localObject.length));
            rar.b("story_net", this.auA, 0, paramInt, new String[] { str, String.valueOf(l), rar.getNetworkType(BaseApplication.getContext()) });
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Prl.q(paramBoolean, paramBundle);
      return;
      localprl.aJ(paramInt, str);
      ram.w("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { this.auA, Integer.valueOf(paramInt), str, Long.valueOf(l), Integer.valueOf(localObject.length) });
      break;
      ram.w("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error. response is null", new Object[] { this.auA });
      rar.b("story_net", this.auA, 0, 940002, new String[] { "response is null", String.valueOf(l), rar.getNetworkType(BaseApplication.getContext()) });
      continue;
      this.jdField_a_of_type_Prl.h(-2, paramBundle);
      ram.w("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_Prk.mg() + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      rar.b("story_net", this.jdField_a_of_type_Prk.mg(), 0, 940002, new String[] { "rsp data error", String.valueOf(l), rar.getNetworkType(BaseApplication.getContext()) });
      continue;
      paramInt = paramBundle.getInt("data_error_code");
      localObject = paramBundle.getString("data_error_msg");
      this.jdField_a_of_type_Prl.h(paramInt, paramBundle);
      ram.w("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.auA + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      rar.b("story_net", this.auA, 0, paramInt, new String[] { localObject, String.valueOf(l), rar.getNetworkType(BaseApplication.getContext()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prj
 * JD-Core Version:    0.7.0.1
 */