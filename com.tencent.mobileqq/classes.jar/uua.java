import android.os.Bundle;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import mqq.observer.BusinessObserver;

class uua
  implements BusinessObserver
{
  uua(utz paramutz, long paramLong, uub paramuub, String paramString, uuc paramuuc) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject;
    uuc localuuc;
    String str;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (localObject.length > 0))
      {
        localuuc = this.jdField_a_of_type_Uub.a((byte[])localObject);
        if (localuuc != null)
        {
          paramInt = localuuc.jdField_a_of_type_Int;
          str = localuuc.jdField_a_of_type_JavaLangString;
          if (paramInt == 0)
          {
            localuuc.a();
            wxe.a("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s success take time:%d data length=%d", this.jdField_a_of_type_JavaLangString, Long.valueOf(l), Integer.valueOf(localObject.length));
            wxj.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { str, String.valueOf(l), wxj.a(BaseApplication.getContext()) });
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Uuc.a(paramBoolean, paramBundle);
      return;
      localuuc.a(paramInt, str);
      wxe.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt), str, Long.valueOf(l), Integer.valueOf(localObject.length) });
      break;
      wxe.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error. response is null", new Object[] { this.jdField_a_of_type_JavaLangString });
      wxj.b("story_net", this.jdField_a_of_type_JavaLangString, 0, 940002, new String[] { "response is null", String.valueOf(l), wxj.a(BaseApplication.getContext()) });
      continue;
      this.jdField_a_of_type_Uuc.a(-2, paramBundle);
      wxe.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_Uub.a() + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      wxj.b("story_net", this.jdField_a_of_type_Uub.a(), 0, 940002, new String[] { "rsp data error", String.valueOf(l), wxj.a(BaseApplication.getContext()) });
      continue;
      paramInt = paramBundle.getInt("data_error_code");
      localObject = paramBundle.getString("data_error_msg");
      this.jdField_a_of_type_Uuc.a(paramInt, paramBundle);
      wxe.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_JavaLangString + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      wxj.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { localObject, String.valueOf(l), wxj.a(BaseApplication.getContext()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uua
 * JD-Core Version:    0.7.0.1
 */