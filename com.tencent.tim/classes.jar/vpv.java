import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QQSettingMe.32.1;
import com.tencent.mobileqq.activity.QQSettingMe.32.2;
import com.tencent.mobileqq.activity.QQSettingMe.32.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashSet;

public class vpv
  extends acfd
{
  public vpv(QQSettingMe paramQQSettingMe) {}
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    if ((paramBoolean) && (this.this$0.isResume) && (this.this$0.app != null) && (paramHashSet.contains(this.this$0.app.getCurrentAccountUin()))) {
      this.this$0.wd(this.this$0.app.getCurrentAccountUin());
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.this$0.isResume) && (this.this$0.app != null) && (aqft.equalsWithNullCheck(paramString, this.this$0.app.getCurrentAccountUin()))) {
      this.this$0.wd(paramString);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.this$0.isResume) && (this.this$0.app != null) && (aqft.equalsWithNullCheck(paramString, this.this$0.app.getCurrentAccountUin()))) {
      this.this$0.c.runOnUiThread(new QQSettingMe.32.1(this));
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1) && (this.this$0.isResume)) {
      this.this$0.c.runOnUiThread(new QQSettingMe.32.2(this));
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    int k = 0;
    String str;
    int i;
    if ((paramBoolean) && (this.this$0.isResume) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      str = this.this$0.app.getCurrentAccountUin();
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (str != null)
      {
        j = k;
        if (i < paramArrayOfString.length)
        {
          if (!str.equals(paramArrayOfString[i])) {
            break label97;
          }
          j = 1;
        }
      }
      if (j != 0) {
        this.this$0.c.runOnUiThread(new QQSettingMe.32.3(this));
      }
      return;
      label97:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vpv
 * JD-Core Version:    0.7.0.1
 */