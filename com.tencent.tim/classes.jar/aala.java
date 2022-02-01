import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class aala
{
  public QQAppInterface app;
  private BaseActivity c;
  
  public aala(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.c = paramBaseActivity;
    this.app = paramQQAppInterface;
  }
  
  public void a(RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    aizp.a().f(this.app, paramBoolean);
    QQAppInterface localQQAppInterface = this.app;
    String str = paramRecentBaseData.qx();
    if (paramBoolean) {}
    for (paramRecentBaseData = "1";; paramRecentBaseData = "0")
    {
      anot.a(localQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_top_right", 0, 0, str, "4", paramRecentBaseData, "");
      return;
    }
  }
  
  public void bK(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aala
 * JD-Core Version:    0.7.0.1
 */