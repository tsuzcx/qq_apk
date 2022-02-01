import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity.10.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class zpt
  extends acfd
{
  public zpt(BindNumberActivity paramBindNumberActivity) {}
  
  public void onGetFriendsHasBindPhone(boolean paramBoolean, int paramInt, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      if (paramList != null) {
        break label95;
      }
    }
    label95:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.i("BindNumberActivity", 2, String.format("onGetFriendsHasBindPhone [%s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), localObject }));
      if (paramBoolean) {
        this.this$0.runOnUiThread(new BindNumberActivity.10.1(this, paramInt, paramList));
      }
      this.this$0.app.removeObserver(this.this$0.c);
      this.this$0.c = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpt
 * JD-Core Version:    0.7.0.1
 */