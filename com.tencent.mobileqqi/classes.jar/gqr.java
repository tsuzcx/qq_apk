import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.OnGetLocalLogListener;
import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

public class gqr
  implements ShareAppLogHelper.OnGetLocalLogListener
{
  public gqr(ShareAppLogActivity paramShareAppLogActivity) {}
  
  public void a(int paramInt)
  {
    ShareAppLogActivity.a(this.a);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230).setTitle("警告").setMessage(ShareAppLogActivity.a(this.a).a(paramInt));
    localQQCustomDialog.setPositiveButton("继续", new gqs(this));
    localQQCustomDialog.setNegativeButton("取消", new gqt(this));
    localQQCustomDialog.show();
  }
  
  public void a(String paramString)
  {
    try
    {
      ShareAppLogActivity.a(this.a, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QQToast.a(this.a.getApplicationContext(), "发送失败!", 0).a();
      return;
    }
    finally
    {
      ShareAppLogActivity.a(this.a);
    }
  }
  
  public void b(int paramInt)
  {
    ShareAppLogActivity.a(this.a);
    QQToast.a(this.a.getApplicationContext(), ShareAppLogActivity.a(this.a).a(paramInt), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gqr
 * JD-Core Version:    0.7.0.1
 */