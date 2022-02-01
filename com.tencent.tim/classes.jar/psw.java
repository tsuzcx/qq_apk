import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class psw
  implements ppv.b<pzw, pzw.a>
{
  psw(psv parampsv) {}
  
  public void a(@NonNull pzw parampzw, @Nullable pzw.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if (parama == null) {
      ram.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { parama });
    }
    do
    {
      return;
      if (paramErrorMessage.errorCode == 15000)
      {
        ram.b("StoryPromoteTaskManager", "onCmdRespond() no change of the request %s", parama);
        this.b.mExpireTime = parama.a.uint64_expire_time.get();
        return;
      }
      if (paramErrorMessage.isFail())
      {
        ram.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { parama });
        return;
      }
    } while (this.b.isDestroy);
    this.b.mCookie = parama.a.bytes_cookie.get().toStringUtf8();
    this.b.mExpireTime = parama.a.uint64_expire_time.get();
    this.b.IT();
    this.b.a(parama.a);
    parampzw = parama.a.bytes_global_promote_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(parampzw))
    {
      ((psr)psx.a(10)).n("key_story_player_promote_url", parampzw);
      this.b.mUrl = parampzw;
    }
    this.b.ro("onCmdRespond()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psw
 * JD-Core Version:    0.7.0.1
 */