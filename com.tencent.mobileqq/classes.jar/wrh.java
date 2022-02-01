import android.os.Bundle;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import mqq.observer.BusinessObserver;

class wrh
  implements BusinessObserver
{
  wrh(wrg paramwrg, long paramLong, wri paramwri, String paramString, wrj paramwrj) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject;
    wrj localwrj;
    String str;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (localObject.length > 0))
      {
        localwrj = this.jdField_a_of_type_Wri.a((byte[])localObject);
        if (localwrj != null)
        {
          paramInt = localwrj.jdField_a_of_type_Int;
          str = localwrj.jdField_a_of_type_JavaLangString;
          if (paramInt == 0)
          {
            localwrj.a();
            yuk.a("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s success take time:%d data length=%d", this.jdField_a_of_type_JavaLangString, Long.valueOf(l), Integer.valueOf(localObject.length));
            yup.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { str, String.valueOf(l), yup.a(BaseApplication.getContext()) });
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Wrj.a(paramBoolean, paramBundle);
      return;
      localwrj.a(paramInt, str);
      yuk.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt), str, Long.valueOf(l), Integer.valueOf(localObject.length) });
      break;
      yuk.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error. response is null", new Object[] { this.jdField_a_of_type_JavaLangString });
      yup.b("story_net", this.jdField_a_of_type_JavaLangString, 0, 940002, new String[] { "response is null", String.valueOf(l), yup.a(BaseApplication.getContext()) });
      continue;
      this.jdField_a_of_type_Wrj.a(-2, paramBundle);
      yuk.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_Wri.a() + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      yup.b("story_net", this.jdField_a_of_type_Wri.a(), 0, 940002, new String[] { "rsp data error", String.valueOf(l), yup.a(BaseApplication.getContext()) });
      continue;
      paramInt = paramBundle.getInt("data_error_code");
      localObject = paramBundle.getString("data_error_msg");
      this.jdField_a_of_type_Wrj.a(paramInt, paramBundle);
      yuk.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_JavaLangString + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      yup.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { localObject, String.valueOf(l), yup.a(BaseApplication.getContext()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrh
 * JD-Core Version:    0.7.0.1
 */