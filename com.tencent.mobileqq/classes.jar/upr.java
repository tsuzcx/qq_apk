import android.os.Bundle;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import mqq.observer.BusinessObserver;

class upr
  implements BusinessObserver
{
  upr(upq paramupq, long paramLong, ups paramups, String paramString, upt paramupt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject;
    upt localupt;
    String str;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (localObject.length > 0))
      {
        localupt = this.jdField_a_of_type_Ups.a((byte[])localObject);
        if (localupt != null)
        {
          paramInt = localupt.jdField_a_of_type_Int;
          str = localupt.jdField_a_of_type_JavaLangString;
          if (paramInt == 0)
          {
            localupt.a();
            wsv.a("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s success take time:%d data length=%d", this.jdField_a_of_type_JavaLangString, Long.valueOf(l), Integer.valueOf(localObject.length));
            wta.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { str, String.valueOf(l), wta.a(BaseApplication.getContext()) });
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Upt.a(paramBoolean, paramBundle);
      return;
      localupt.a(paramInt, str);
      wsv.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt), str, Long.valueOf(l), Integer.valueOf(localObject.length) });
      break;
      wsv.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error. response is null", new Object[] { this.jdField_a_of_type_JavaLangString });
      wta.b("story_net", this.jdField_a_of_type_JavaLangString, 0, 940002, new String[] { "response is null", String.valueOf(l), wta.a(BaseApplication.getContext()) });
      continue;
      this.jdField_a_of_type_Upt.a(-2, paramBundle);
      wsv.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_Ups.a() + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      wta.b("story_net", this.jdField_a_of_type_Ups.a(), 0, 940002, new String[] { "rsp data error", String.valueOf(l), wta.a(BaseApplication.getContext()) });
      continue;
      paramInt = paramBundle.getInt("data_error_code");
      localObject = paramBundle.getString("data_error_msg");
      this.jdField_a_of_type_Upt.a(paramInt, paramBundle);
      wsv.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_JavaLangString + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      wta.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { localObject, String.valueOf(l), wta.a(BaseApplication.getContext()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upr
 * JD-Core Version:    0.7.0.1
 */