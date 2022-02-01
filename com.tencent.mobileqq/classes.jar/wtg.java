import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class wtg
  implements woy<xea, xeb>
{
  wtg(wtf paramwtf) {}
  
  public void a(@NonNull xea paramxea, @Nullable xeb paramxeb, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramxeb == null) {
      yuk.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramxeb });
    }
    do
    {
      return;
      if (paramErrorMessage.errorCode == 15000)
      {
        yuk.a("StoryPromoteTaskManager", "onCmdRespond() no change of the request %s", paramxeb);
        this.a.jdField_a_of_type_Long = paramxeb.a.uint64_expire_time.get();
        return;
      }
      if (paramErrorMessage.isFail())
      {
        yuk.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramxeb });
        return;
      }
    } while (this.a.jdField_a_of_type_Boolean);
    this.a.jdField_a_of_type_JavaLangString = paramxeb.a.bytes_cookie.get().toStringUtf8();
    this.a.jdField_a_of_type_Long = paramxeb.a.uint64_expire_time.get();
    this.a.a();
    this.a.a(paramxeb.a);
    paramxea = paramxeb.a.bytes_global_promote_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramxea))
    {
      ((wta)wth.a(10)).b("key_story_player_promote_url", paramxea);
      this.a.b = paramxea;
    }
    this.a.a("onCmdRespond()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtg
 * JD-Core Version:    0.7.0.1
 */