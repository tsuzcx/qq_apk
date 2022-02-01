import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ueg
  extends ashx
{
  public ueg(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void c(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if (AddFriendVerifyActivity.a(this.this$0).equals(paramHashMap.uin)) {
        if (AddFriendVerifyActivity.a(this.this$0) != null)
        {
          str = AddFriendVerifyActivity.a(this.this$0).getText().toString();
          if ((TextUtils.isEmpty(str)) || (str.equals(AddFriendVerifyActivity.a(this.this$0)))) {
            AddFriendVerifyActivity.a(this.this$0).setText(paramHashMap.nickname);
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("AddFriendVerifyActivity", 2, "onGetQidianMasterInfo not current uin");
      return;
    }
    QLog.d("AddFriendVerifyActivity", 2, "onGetQidianMasterInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ueg
 * JD-Core Version:    0.7.0.1
 */