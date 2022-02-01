import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class don
  extends FriendListObserver
{
  public don(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void a()
  {
    this.a.h();
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if ((this.a.b.a() != null) && (this.a.b.a().equals(paramString)))
    {
      new Thread(new dop(this, paramString)).start();
      return;
    }
    this.a.h();
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("head", 2, "ContactsActivity.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.a.sendEmptyMessage(1);
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    do
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      if (paramMap.hasNext())
      {
        String str = (String)((Map.Entry)paramMap.next()).getKey();
        int i = this.a.b.b(str);
        if ((i == 1) || (i == 4)) {
          TroopAssistantManager.a().c(str, this.a.b);
        }
        for (;;)
        {
          this.a.h();
          break;
          if (i == 3) {
            TroopAssistantManager.a().b(str, this.a.b);
          }
        }
      }
    } while (!this.a.isResume());
    if (paramBoolean)
    {
      QQToast.a(this.a.b.a(), 2130837960, this.a.getString(2131562193), 0).b(this.a.d());
      return;
    }
    QQToast.a(this.a.b.a(), 2130837949, this.a.getString(2131562192), 0).b(this.a.d());
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (paramBoolean) {
      new Thread(new doq(this)).start();
    }
  }
  
  void b(String paramString)
  {
    if (!paramString.equals(this.a.b.getAccount())) {
      return;
    }
    this.a.a.obtainMessage(1).sendToTarget();
    this.a.runOnUiThread(new doo(this));
  }
  
  protected void c(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     don
 * JD-Core Version:    0.7.0.1
 */