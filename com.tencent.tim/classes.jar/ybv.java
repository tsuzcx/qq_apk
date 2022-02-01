import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class ybv
  extends aclp
{
  ybv(ybt paramybt) {}
  
  protected void t(boolean paramBoolean, List<Long> paramList)
  {
    ChatActivityUtils.bJs();
    Object localObject = this.this$0.mContext;
    Context localContext = this.this$0.mContext;
    int i;
    if (paramBoolean)
    {
      i = 2131720219;
      QQToast.a((Context)localObject, 2, localContext.getString(i), 0).show(this.this$0.getTitleBarHeight());
      if (this.this$0.sessionInfo != null) {
        break label69;
      }
    }
    label69:
    do
    {
      int k;
      do
      {
        return;
        i = 2131720207;
        break;
        localObject = this.this$0.sessionInfo.aTl;
        if (paramList == null) {}
        for (i = 0;; i = paramList.size())
        {
          int j = 0;
          k = 0;
          while ((k == 0) && (j < i))
          {
            if (aqft.equalsWithNullCheck(String.valueOf(paramList.get(j)), localObject)) {
              k = 1;
            }
            j += 1;
          }
        }
      } while (k == 0);
      ChatActivityUtils.b(this.this$0.mActivity, paramBoolean, false);
    } while (!paramBoolean);
    this.this$0.bGP();
  }
  
  protected void u(boolean paramBoolean, List<Long> paramList)
  {
    int k = 0;
    ChatActivityUtils.bJs();
    if (this.this$0.sessionInfo == null) {}
    do
    {
      do
      {
        return;
        String str = this.this$0.sessionInfo.aTl;
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
      ChatActivityUtils.bJs();
    } while (!paramBoolean);
    this.this$0.bGP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybv
 * JD-Core Version:    0.7.0.1
 */