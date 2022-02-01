import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

class xxd
  extends aclp
{
  xxd(xwq paramxwq) {}
  
  protected void t(boolean paramBoolean, List<Long> paramList)
  {
    if (this.a.sessionInfo == null) {}
    do
    {
      int k;
      do
      {
        return;
        String str = this.a.sessionInfo.aTl;
        if (paramList == null) {}
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
      } while (k == 0);
      ChatActivityUtils.b(this.a.mActivity, paramBoolean, false);
    } while (!paramBoolean);
    this.a.cfz();
  }
  
  protected void u(boolean paramBoolean, List<Long> paramList)
  {
    int k = 0;
    if (this.a.sessionInfo == null) {}
    do
    {
      do
      {
        return;
        String str = this.a.sessionInfo.aTl;
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
      } while (k == 0);
      ChatActivityUtils.b(this.a.mActivity, paramBoolean, true);
    } while (!paramBoolean);
    this.a.cfz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxd
 * JD-Core Version:    0.7.0.1
 */