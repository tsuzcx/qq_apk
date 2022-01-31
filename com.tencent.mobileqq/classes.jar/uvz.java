import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class uvz
  implements urr<vgt, vgu>
{
  uvz(uvy paramuvy) {}
  
  public void a(@NonNull vgt paramvgt, @Nullable vgu paramvgu, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramvgu == null) {
      wxe.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramvgu });
    }
    do
    {
      return;
      if (paramErrorMessage.errorCode == 15000)
      {
        wxe.a("StoryPromoteTaskManager", "onCmdRespond() no change of the request %s", paramvgu);
        this.a.jdField_a_of_type_Long = paramvgu.a.uint64_expire_time.get();
        return;
      }
      if (paramErrorMessage.isFail())
      {
        wxe.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramvgu });
        return;
      }
    } while (this.a.jdField_a_of_type_Boolean);
    this.a.jdField_a_of_type_JavaLangString = paramvgu.a.bytes_cookie.get().toStringUtf8();
    this.a.jdField_a_of_type_Long = paramvgu.a.uint64_expire_time.get();
    this.a.a();
    this.a.a(paramvgu.a);
    paramvgt = paramvgu.a.bytes_global_promote_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramvgt))
    {
      ((uvt)uwa.a(10)).b("key_story_player_promote_url", paramvgt);
      this.a.b = paramvgt;
    }
    this.a.a("onCmdRespond()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvz
 * JD-Core Version:    0.7.0.1
 */