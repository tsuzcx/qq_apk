import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bed
  extends FriendListObserver
{
  public bed(QQSetting paramQQSetting) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.a != null) && (paramString != null) && (paramString.equals(this.a.a.a()))) {
      this.a.b(new bef(this));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingActivity", 2, "onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
    if ((paramBoolean) && (paramString != null) && (this.a.a != null) && (paramString.equals(this.a.a.a()))) {
      this.a.b(new bee(this, paramString));
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      this.a.b();
    }
  }
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
  {
    String str;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      str = this.a.a.a();
      i = 0;
    }
    for (;;)
    {
      if ((str != null) && (i < paramArrayOfString.length))
      {
        if (str.equals(paramArrayOfString[i])) {
          this.a.n();
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bed
 * JD-Core Version:    0.7.0.1
 */