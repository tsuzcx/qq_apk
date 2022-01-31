import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class zvx
  extends ajmm
{
  public zvx(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, axau paramaxau)
  {
    if (this.a.isFinishing()) {}
    axam localaxam;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.a, false);
        localaxam = (axam)this.a.app.getManager(62);
        if (paramaxau.a != 1) {
          break;
        }
        if ((this.a.isResume()) && (axam.a(this.a.app, "sub.uin.all")))
        {
          paramString = localaxam.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            paramaxau = (Pair)paramString.get(i);
            localaxam.a(this.a.app, this.a, paramaxau, new zvy(this, localaxam, paramaxau));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localaxam.a(paramString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zvx
 * JD-Core Version:    0.7.0.1
 */