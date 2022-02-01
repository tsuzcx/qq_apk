import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import friendlist.GetOnlineInfoResp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class uiu
  extends acfd
{
  public uiu(BaseChatPie paramBaseChatPie) {}
  
  protected void onAddFriend(String paramString)
  {
    BaseChatPie.c(this.this$0, paramString);
  }
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    BaseChatPie.b(this.this$0, paramBoolean, paramString1, paramString2);
  }
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.c(this.this$0, paramBoolean, paramObject);
  }
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (TextUtils.equals(paramString, this.this$0.sessionInfo.aTl)) {
      this.this$0.bFq();
    }
  }
  
  protected void onGetSigZanInfo(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.a(this.this$0, paramObject);
  }
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    AvatarLayout.a(this.this$0.app, this.this$0.b, paramHashSet);
  }
  
  protected void onGetStrangerInfo(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.b(this.this$0, paramBoolean, paramObject);
  }
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    BaseChatPie.a(this.this$0, paramBoolean, paramLong, paramInt1, paramInt2);
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    BaseChatPie.a(this.this$0, paramBoolean, paramString1, paramString2);
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    BaseChatPie.b(this.this$0, paramBoolean);
  }
  
  protected void onUpdateC2ChatStatus(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    BaseChatPie.a(this.this$0, paramHashMap);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramString == null) {
      return;
    }
    AvatarLayout.a(this.this$0.app, this.this$0.b, Arrays.asList(new String[] { paramString }));
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.a(this.this$0, paramBoolean, paramObject);
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    BaseChatPie.a(this.this$0, paramString, paramBoolean);
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.this$0.bFq();
  }
  
  protected void onUpdateRecentList() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uiu
 * JD-Core Version:    0.7.0.1
 */