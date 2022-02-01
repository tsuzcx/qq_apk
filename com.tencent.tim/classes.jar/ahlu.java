import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ahlu
  extends acdv
{
  ahlu(ahlr paramahlr) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onGetFlyTicket: " + paramBoolean + " sigUrl=" + paramString1);
    }
    if (!paramBoolean)
    {
      this.this$0.hideProgressDialog();
      switch (paramInt)
      {
      default: 
        paramString1 = acfp.m(2131706532);
        ahlr.c(this.this$0, null);
        ahlr.a(this.this$0, false);
        QQToast.a(this.this$0.mActivity, 1, paramString1, 0).show(((BaseActivity)this.this$0.mActivity).getTitleBarHeight());
      }
    }
    while ((ahlr.c(this.this$0) == null) || (Long.parseLong(ahlr.c(this.this$0)) != paramLong2)) {
      for (;;)
      {
        return;
        paramString1 = acfp.m(2131706539);
        continue;
        paramString1 = acfp.m(2131706538);
      }
    }
    if (ahlr.a(this.this$0))
    {
      ahlr.c(this.this$0, paramString1);
      ahlr.a(this.this$0, ahlr.c(this.this$0), true);
    }
    ahlr.a(this.this$0, false);
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardShareCardOption", 2, "onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramString + "]");
    }
    if ((ahlr.c(this.this$0) != null) && (ahlr.c(this.this$0).equals(paramString))) {
      ahlr.a(this.this$0, ahlr.c(this.this$0), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlu
 * JD-Core Version:    0.7.0.1
 */