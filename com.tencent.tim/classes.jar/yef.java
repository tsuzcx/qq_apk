import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class yef
  extends ashx
{
  yef(ydz paramydz) {}
  
  protected void e(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Wki.notifyDataSetChanged();
      QQToast.a(this.a.mActivity, this.a.a().getString(2131700355), 0).show(this.a.mActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.mActivity, this.a.a().getString(2131700354), 0).show(this.a.mActivity.getTitleBarHeight());
  }
  
  protected void f(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (((this.a.sessionInfo.cZ == 1025) || (this.a.sessionInfo.cZ == 1024)) && (paramBoolean) && (paramHashMap != null) && (this.a.sessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.sessionInfo.aTl != null) && (paramHashMap != null) && (this.a.sessionInfo.aTl.equals(paramHashMap.uin)))
      {
        if (this.a.sessionInfo.cZ == 1024) {
          this.a.sessionInfo.cZ = 1025;
        }
        paramHashMap = this.a.jdField_a_of_type_Asgx.as(this.a.mContext, this.a.sessionInfo.aTl);
        if (paramHashMap != null)
        {
          ydz.a(this.a, true);
          this.a.Cu.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          ydz.a(this.a).setOnClickListener(null);
          ydz.b(this.a).setOnClickListener(null);
          this.a.Cu.setText(paramHashMap);
          if (ujs.aTl) {
            this.a.Cu.setContentDescription(paramHashMap);
          }
          ydz.a(this.a, true);
          this.a.bGP();
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          return;
          ydz.b(this.a, false);
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.a.TAG, 2, "onGetQidianUserDetailInfo not current curFriendUin");
      return;
    }
    QLog.d(this.a.TAG, 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yef
 * JD-Core Version:    0.7.0.1
 */