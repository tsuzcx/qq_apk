import android.os.Bundle;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import mqq.observer.BusinessObserver;

class wht
  implements BusinessObserver
{
  wht(whs paramwhs, long paramLong, whu paramwhu, String paramString, whv paramwhv) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject;
    whv localwhv;
    String str;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (localObject.length > 0))
      {
        localwhv = this.jdField_a_of_type_Whu.a((byte[])localObject);
        if (localwhv != null)
        {
          paramInt = localwhv.jdField_a_of_type_Int;
          str = localwhv.jdField_a_of_type_JavaLangString;
          if (paramInt == 0)
          {
            localwhv.a();
            ykq.a("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s success take time:%d data length=%d", this.jdField_a_of_type_JavaLangString, Long.valueOf(l), Integer.valueOf(localObject.length));
            ykv.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { str, String.valueOf(l), ykv.a(BaseApplication.getContext()) });
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Whv.a(paramBoolean, paramBundle);
      return;
      localwhv.a(paramInt, str);
      ykq.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt), str, Long.valueOf(l), Integer.valueOf(localObject.length) });
      break;
      ykq.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error. response is null", new Object[] { this.jdField_a_of_type_JavaLangString });
      ykv.b("story_net", this.jdField_a_of_type_JavaLangString, 0, 940002, new String[] { "response is null", String.valueOf(l), ykv.a(BaseApplication.getContext()) });
      continue;
      this.jdField_a_of_type_Whv.a(-2, paramBundle);
      ykq.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_Whu.a() + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      ykv.b("story_net", this.jdField_a_of_type_Whu.a(), 0, 940002, new String[] { "rsp data error", String.valueOf(l), ykv.a(BaseApplication.getContext()) });
      continue;
      paramInt = paramBundle.getInt("data_error_code");
      localObject = paramBundle.getString("data_error_msg");
      this.jdField_a_of_type_Whv.a(paramInt, paramBundle);
      ykq.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_JavaLangString + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      ykv.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { localObject, String.valueOf(l), ykv.a(BaseApplication.getContext()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wht
 * JD-Core Version:    0.7.0.1
 */