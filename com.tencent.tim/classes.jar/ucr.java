import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class ucr
  extends achq
{
  public ucr(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, anxs paramanxs)
  {
    if (this.this$0.isFinishing()) {}
    anxk localanxk;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.this$0, false);
        localanxk = (anxk)this.this$0.app.getManager(62);
        if (paramanxs.errorType != 1) {
          break;
        }
        if ((this.this$0.isResume()) && (anxk.S(this.this$0.app, "sub.uin.all")))
        {
          paramString = localanxk.W("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            paramanxs = (Pair)paramString.get(i);
            localanxk.a(this.this$0.app, this.this$0, paramanxs, new ucs(this, localanxk, paramanxs));
            i += 1;
          }
        }
      }
    } while (!this.this$0.isResume());
    localanxk.v(paramString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucr
 * JD-Core Version:    0.7.0.1
 */