import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aubv
  extends auby
{
  private audx.c a;
  
  public aubv(atzy paramatzy, Activity paramActivity)
  {
    super(paramatzy, paramActivity);
    this.jdField_a_of_type_Audx$c = new aubw(this);
  }
  
  public void init()
  {
    super.init();
    QLog.w("SimpleFilePresenter", 4, "FileBrowserPresenter init: type = canpreview_simple");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Atzy.aC())) || (16 == this.jdField_a_of_type_Atzy.bF()))
    {
      this.jdField_a_of_type_Aucs.JR(false);
      if (this.jdField_a_of_type_Atzy.bF() != 16) {
        break label156;
      }
      this.jdField_a_of_type_Aucs.Jt(this.mContext.getString(2131693595));
      euF();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aucs.showTip(true);
      if (this.jdField_a_of_type_Atzy.cn()) {
        this.jdField_a_of_type_Aucs.showTip(false);
      }
      return;
      this.jdField_a_of_type_Aucs.Js(this.jdField_a_of_type_Atzy.aC());
      if (TextUtils.isEmpty(this.jdField_a_of_type_Atzy.Fa())) {
        break;
      }
      this.jdField_a_of_type_Aucs.VH(true);
      this.jdField_a_of_type_Aucs.Zm(this.jdField_a_of_type_Atzy.Fa());
      break;
      label156:
      if (this.jdField_a_of_type_Atzy.isFromProcessingForward2c2cOrDiscItem())
      {
        this.jdField_a_of_type_Aucs.Jt(this.mContext.getString(2131693824));
      }
      else
      {
        if ((audx.b(this.mContext.getBaseContext(), this.jdField_a_of_type_Atzy.getFileName(), this.jdField_a_of_type_Atzy.getFileSize())) && (!this.jdField_a_of_type_Atzy.cj())) {
          break label295;
        }
        int i = this.jdField_a_of_type_Atzy.getFileType();
        if (i == 1) {
          this.jdField_a_of_type_Aucs.Jt(BaseApplicationImpl.getContext().getString(2131694107));
        } else if (i == 2) {
          this.jdField_a_of_type_Aucs.Jt(BaseApplicationImpl.getContext().getString(2131694111));
        } else {
          this.jdField_a_of_type_Aucs.Jt(this.mContext.getString(2131694108));
        }
      }
    }
    label295:
    Object localObject;
    if (aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
      if (aqiw.isWifiConnected(BaseApplication.getContext())) {
        localObject = BaseApplicationImpl.getContext().getString(2131694130);
      }
    }
    for (;;)
    {
      localObject = audx.a((String)localObject, "在线预览", this.jdField_a_of_type_Audx$c);
      this.jdField_a_of_type_Aucs.a((SpannableString)localObject);
      break;
      localObject = BaseApplicationImpl.getContext().getString(2131694132);
      continue;
      localObject = this.mContext.getString(2131694108);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubv
 * JD-Core Version:    0.7.0.1
 */