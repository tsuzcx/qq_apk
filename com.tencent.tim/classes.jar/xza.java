import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class xza
  extends ashx
{
  xza(xys paramxys) {}
  
  protected void e(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      this.this$0.jdField_a_of_type_Wki.notifyDataSetChanged();
      QQToast.a(this.this$0.mActivity, this.this$0.a().getString(2131700355), 0).show(this.this$0.mActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.this$0.mActivity, this.this$0.a().getString(2131700354), 0).show(this.this$0.mActivity.getTitleBarHeight());
  }
  
  protected void f(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (this.this$0.sessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.this$0.sessionInfo.aTl != null) && (paramHashMap != null) && (this.this$0.sessionInfo.aTl.equals(paramHashMap.uin)))
      {
        paramHashMap = this.this$0.jdField_a_of_type_Asgx.as(this.this$0.mContext, this.this$0.sessionInfo.aTl);
        if (paramHashMap != null)
        {
          xys.a(this.this$0, true);
          this.this$0.Cu.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          xys.a(this.this$0).setOnClickListener(null);
          xys.b(this.this$0).setOnClickListener(null);
          this.this$0.aWW = paramHashMap;
          this.this$0.vc(paramHashMap);
          if (ujs.aTl) {
            this.this$0.Cu.setContentDescription(paramHashMap);
          }
          xys.a(this.this$0, true);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        xys.b(this.this$0, false);
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.this$0.TAG, 2, "onGetQidianUserDetailInfo not current curFriendUin");
      return;
    }
    QLog.d(this.this$0.TAG, 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xza
 * JD-Core Version:    0.7.0.1
 */