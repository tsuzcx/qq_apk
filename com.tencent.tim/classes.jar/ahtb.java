import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ahtb
  extends ahtk
{
  ahtb(ahta paramahta) {}
  
  protected void aI(Object paramObject)
  {
    super.aI(paramObject);
    if ((paramObject instanceof ArrayList))
    {
      paramObject = (ArrayList)paramObject;
      int j = paramObject.size();
      int i = 0;
      if (i < j)
      {
        Object localObject;
        GameCenterSessionInfo localGameCenterSessionInfo;
        if ((paramObject.get(i) instanceof ahsz))
        {
          localObject = (ahsz)paramObject.get(i);
          localGameCenterSessionInfo = this.this$0.b(((ahsz)localObject).mRoleId);
          if (localGameCenterSessionInfo != null)
          {
            localGameCenterSessionInfo.Ky(((ahsz)localObject).mAppId);
            localGameCenterSessionInfo.setGameName(((ahsz)localObject).mName);
            localGameCenterSessionInfo.setNickName(((ahsz)localObject).mNickInGame);
            localGameCenterSessionInfo.Pp(((ahsz)localObject).mOnlineType);
            localGameCenterSessionInfo.Kw(((ahsz)localObject).mOnLineDesc);
            localGameCenterSessionInfo.Kz(((ahsz)localObject).mFaceUrl);
            localGameCenterSessionInfo.Kv(((ahsz)localObject).mIconUrl);
            if (j <= 30) {
              break label178;
            }
            if (i == j - 1) {
              this.this$0.a("action_qgame_messgae_change", localGameCenterSessionInfo, 3, this.this$0.getUnreadCnt());
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label178:
          if (localGameCenterSessionInfo.getSessionType() == 0)
          {
            localObject = this.this$0.c(localGameCenterSessionInfo.wx());
            if (QLog.isColorLevel()) {
              QLog.d(ahta.access$000(), 2, "[onGameUserInfoChangedNotify] folder session:" + localObject);
            }
            if ((localObject != null) && (((GameCenterSessionInfo)localObject).getSessionId().equals(localGameCenterSessionInfo.getSessionId()))) {
              this.this$0.a("action_qgame_messgae_change", (GameCenterSessionInfo)localObject, 2, this.this$0.getUnreadCnt());
            }
          }
          else
          {
            this.this$0.a("action_qgame_messgae_change", localGameCenterSessionInfo, 2, this.this$0.getUnreadCnt());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtb
 * JD-Core Version:    0.7.0.1
 */