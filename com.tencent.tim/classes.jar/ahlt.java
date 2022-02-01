import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ahlt
  extends ashx
{
  ahlt(ahlr paramahlr) {}
  
  protected void b(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.this$0.hideProgressDialog();
    if (ahlr.a(this.this$0) != -1)
    {
      if ((!paramBoolean) || (paramHashMap == null)) {
        break label151;
      }
      String str = (String)paramHashMap.get("uin");
      paramHashMap = (String)paramHashMap.get("url");
      ahlr.a(this.this$0, paramHashMap);
      ahlr.b(this.this$0, paramHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + ahlr.a(this.this$0) + " mTroopNotNeedVefifyLink=" + ahlr.b(this.this$0));
      }
      if ((str != null) && (str.equals(ahlr.c(this.this$0)))) {
        ahlr.a(this.this$0);
      }
    }
    for (;;)
    {
      ahlr.a(this.this$0, -1);
      return;
      label151:
      QQToast.a(this.this$0.mActivity, 1, this.this$0.mActivity.getString(2131694334), 0).show(((BaseActivity)this.this$0.mActivity).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlt
 * JD-Core Version:    0.7.0.1
 */