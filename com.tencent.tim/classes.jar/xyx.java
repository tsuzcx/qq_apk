import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class xyx
  extends acfd
{
  xyx(xys paramxys) {}
  
  protected void onReqRecheckInHotReactive(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    this.this$0.a.e(paramBoolean, paramString1, paramString2, paramInt);
  }
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if (!paramBoolean) {
      QQToast.a(this.this$0.mActivity, this.this$0.mActivity.getResources().getString(2131719591), 0).show(this.this$0.mActivity.getTitleBarHeight());
    }
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    super.onUpdateFriendInfo(paramString, paramBoolean);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.contains(this.this$0.sessionInfo.aTl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onUpdateHotFriendLevel");
      }
      this.this$0.Te();
    }
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.contains(this.this$0.sessionInfo.aTl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onUpdateHotFriendLevel");
      }
      this.this$0.Te();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyx
 * JD-Core Version:    0.7.0.1
 */