import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.manager.Manager;

public class abyu
  implements Manager
{
  public QQAppInterface mApp;
  public List<ApolloActionRecentData> vC = Collections.synchronizedList(new ArrayList());
  public List<ApolloActionRecentData> wT = Collections.synchronizedList(new ArrayList());
  
  public abyu(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    cl(paramQQAppInterface);
  }
  
  private void cl(QQAppInterface paramQQAppInterface)
  {
    this.vC = abxk.c(paramQQAppInterface, "recent_c2c");
    this.wT = abxk.c(paramQQAppInterface, "recent_troop");
    if (this.vC == null) {
      this.vC = Collections.synchronizedList(new ArrayList());
    }
    if (this.wT == null) {
      this.wT = Collections.synchronizedList(new ArrayList());
    }
    int i;
    if (this.vC.size() > 8)
    {
      i = this.vC.size();
      this.vC = this.vC.subList(i - 8, this.vC.size());
    }
    if (this.wT.size() > 8)
    {
      i = this.wT.size();
      this.wT = this.wT.subList(i - 8, this.wT.size());
    }
  }
  
  public void onDestroy()
  {
    this.mApp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abyu
 * JD-Core Version:    0.7.0.1
 */