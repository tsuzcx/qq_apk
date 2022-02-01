import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

class yed
  extends aclp
{
  yed(ydz paramydz) {}
  
  protected void t(boolean paramBoolean, List<Long> paramList)
  {
    
    if (this.a.sessionInfo == null) {
      return;
    }
    String str = this.a.sessionInfo.aTl;
    if (this.a.sessionInfo.cZ == 1006) {
      str = this.a.sessionInfo.aTo;
    }
    for (;;)
    {
      if (paramList == null) {}
      int k;
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        k = 0;
        while ((k == 0) && (j < i))
        {
          if (aqft.equalsWithNullCheck(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k == 0) {
        break;
      }
      ChatActivityUtils.b(this.a.mActivity, paramBoolean, false);
      if (!paramBoolean) {
        break;
      }
      this.a.bGP();
      return;
    }
  }
  
  protected void u(boolean paramBoolean, List<Long> paramList)
  {
    int k = 0;
    ChatActivityUtils.bJs();
    if (this.a.sessionInfo == null) {
      return;
    }
    String str = this.a.sessionInfo.aTl;
    if (this.a.sessionInfo.cZ == 1006) {
      str = this.a.sessionInfo.aTo;
    }
    for (;;)
    {
      if (paramList == null) {}
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        while ((k == 0) && (j < i))
        {
          if (aqft.equalsWithNullCheck(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k == 0) {
        break;
      }
      ChatActivityUtils.bJs();
      if (!paramBoolean) {
        break;
      }
      this.a.bGP();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yed
 * JD-Core Version:    0.7.0.1
 */