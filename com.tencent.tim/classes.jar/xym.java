import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class xym
  extends accd
{
  xym(xyi paramxyi) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1)
  {
    if (paramBoolean)
    {
      if ((this.this$0.mActivity != null) && (this.this$0.mActivity.isResume())) {
        xyi.b(this.this$0);
      }
      do
      {
        do
        {
          return;
        } while (paramBoolean1.booleanValue());
        paramString1 = BaseActivity.sTopActivity;
      } while (paramString1 == null);
      aqha.a(paramString1, 230, paramString1.getString(2131690192), null, null, paramString1.getString(2131720227), new xyn(this, paramString1), null).show();
      return;
    }
    QQToast.a(this.this$0.mContext, paramInt, 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xym
 * JD-Core Version:    0.7.0.1
 */