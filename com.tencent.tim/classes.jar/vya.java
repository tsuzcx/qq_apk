import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity.11.1;
import com.tencent.mobileqq.activity.TroopAssistantActivity.11.2;
import com.tencent.mobileqq.activity.TroopAssistantActivity.11.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class vya
  extends acfd
{
  public vya(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.this$0.b.sendEmptyMessage(1);
    }
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    label129:
    do
    {
      return;
      int i;
      if (("batch_setting".equals(this.this$0.aQs)) && (this.this$0.rk != null) && (this.this$0.rk.size() > 0) && (this.this$0.a != null))
      {
        i = 0;
        for (;;)
        {
          if (i >= this.this$0.rk.size()) {
            break label129;
          }
          paramMap = String.valueOf(this.this$0.rk.get(i));
          if (((Boolean)this.this$0.a.jb.get(paramMap)).booleanValue()) {
            break;
          }
          i += 1;
        }
        QQToast.a(this.this$0.app.getApp(), 2, acfp.m(2131715562), 0).show(this.this$0.getTitleBarHeight());
        TroopAssistantActivity.a(this.this$0);
        return;
      }
      paramMap = paramMap.entrySet().iterator();
      if (paramMap.hasNext())
      {
        String str = (String)((Map.Entry)paramMap.next()).getKey();
        i = this.this$0.app.cs(str);
        if ((i == 1) || (i == 4)) {
          aizp.a().l(str, this.this$0.app);
        }
        for (;;)
        {
          this.this$0.bOm();
          break;
          if (i == 3) {
            aizp.a().k(str, this.this$0.app);
          }
        }
      }
    } while (!this.this$0.isResume());
    if (paramBoolean)
    {
      QQToast.a(this.this$0.app.getApp(), 2, this.this$0.getString(2131721436), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    QQToast.a(this.this$0.app.getApp(), 1, this.this$0.getString(2131721435), 0).show(this.this$0.getTitleBarHeight());
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("head", 2, "ContactsActivity.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if ((this.this$0.app.getCurrentAccountUin() != null) && (this.this$0.app.getCurrentAccountUin().equals(paramString)))
    {
      ThreadManager.post(new TroopAssistantActivity.11.2(this, paramString), 8, null, true);
      return;
    }
    this.this$0.bOm();
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (paramBoolean) {
      ThreadManager.post(new TroopAssistantActivity.11.3(this), 5, null, true);
    }
  }
  
  protected void onUpdateRecentList()
  {
    this.this$0.bOm();
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString) {}
  
  public void wJ(String paramString)
  {
    if (!paramString.equals(this.this$0.app.getAccount())) {
      return;
    }
    this.this$0.b.obtainMessage(1).sendToTarget();
    this.this$0.runOnUiThread(new TroopAssistantActivity.11.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vya
 * JD-Core Version:    0.7.0.1
 */