import android.text.TextUtils;
import com.tencent.biz.qqstory.settings.QQStoryShieldListActivity;
import com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class qov
  extends pmd
{
  private List<QQStoryUserInfo> nX = new ArrayList();
  
  public qov(QQStoryShieldListActivity paramQQStoryShieldListActivity) {}
  
  private void et(List<QQStoryUserInfo> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new QQStoryShieldListActivity.1.1(this, paramList));
  }
  
  public void a(boolean paramBoolean1, List<QQStoryUserInfo> paramList, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString)
  {
    if (!TextUtils.equals(QQStoryShieldListActivity.a(this.a), paramString)) {
      return;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        this.nX.addAll(paramList);
        paramList = this.a.b;
        if (this.a.bnq == 2) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          paramList.a(paramArrayOfByte, 10, paramBoolean1, QQStoryShieldListActivity.a(this.a));
          return;
        }
      }
      this.nX.addAll(paramList);
      this.a.es(this.nX);
      paramList = new ArrayList(this.nX);
      if (this.a.bnq == 2) {
        this.a.c.mj = paramList;
      }
      for (;;)
      {
        this.a.c.bR.clear();
        paramArrayOfByte = paramList.iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramString = (QQStoryUserInfo)paramArrayOfByte.next();
          this.a.c.bR.put(paramString.uin, paramString);
        }
        this.a.c.mi = paramList;
      }
      et(paramList);
      QQStoryShieldListActivity.a(this.a);
      this.nX.clear();
      return;
    }
    QQStoryShieldListActivity.b(this.a);
    this.nX.clear();
  }
  
  public void m(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a.a.dismiss();
    if (paramBoolean1)
    {
      List localList = this.a.c.e(paramBoolean3);
      this.a.es(localList);
      return;
    }
    QQToast.a(this.a, 2131696746, 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qov
 * JD-Core Version:    0.7.0.1
 */