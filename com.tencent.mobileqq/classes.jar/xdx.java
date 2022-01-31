import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class xdx
  extends Handler
{
  boolean jdField_a_of_type_Boolean;
  
  xdx(xdt paramxdt) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while ((!(paramMessage.obj instanceof Bitmap)) || (this.jdField_a_of_type_Boolean));
            paramMessage = (Bitmap)paramMessage.obj;
          } while (paramMessage.isRecycled());
          paramMessage = mpo.a(paramMessage, (int)(34.0F * this.jdField_a_of_type_Xdt.jdField_a_of_type_Float));
        } while (this.jdField_a_of_type_Xdt.jdField_a_of_type_JavaLangRefWeakReference == null);
        localObject = (bazo)this.jdField_a_of_type_Xdt.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject != null) && ((localObject instanceof bbev))) {
          ((bbev)localObject).b();
        }
        this.jdField_a_of_type_Xdt.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Xdt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramMessage);
        if ((this.jdField_a_of_type_Xdt.jdField_a_of_type_AndroidAppActivity instanceof bazk))
        {
          paramMessage = ((bazk)this.jdField_a_of_type_Xdt.jdField_a_of_type_AndroidAppActivity).b();
          if ((paramMessage != null) && (paramMessage.a.jdField_a_of_type_AndroidViewView != null))
          {
            paramMessage.a.jdField_a_of_type_AndroidViewView.findViewById(2131300323).setVisibility(8);
            paramMessage.a.jdField_a_of_type_AndroidViewView.findViewById(2131300324).setVisibility(0);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d(xdt.jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity VISIBLE -----------------------");
      return;
    } while ((!(paramMessage.obj instanceof Bitmap)) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Xdt.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse == null) || (this.jdField_a_of_type_Xdt.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Xdt.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo.packName.get())));
    Object localObject = this.jdField_a_of_type_Xdt.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
    if (bady.a(this.jdField_a_of_type_Xdt.jdField_a_of_type_AndroidContentContext, ((GetAppInfoProto.AndroidInfo)localObject).packName.get())) {
      this.jdField_a_of_type_Xdt.b.setText(this.jdField_a_of_type_Xdt.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624588));
    }
    for (;;)
    {
      this.jdField_a_of_type_Xdt.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_Xdt.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624589), new Object[] { ((GetAppInfoProto.AndroidInfo)localObject).messagetail.get() }));
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage.isRecycled()) {
        break;
      }
      paramMessage = mpo.a(paramMessage, (int)(30.0F * this.jdField_a_of_type_Xdt.jdField_a_of_type_Float));
      this.jdField_a_of_type_Xdt.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Xdt.c.setImageBitmap(paramMessage);
      bcfn.a().a(this.jdField_a_of_type_Xdt.n, String.valueOf(baak.b(this.jdField_a_of_type_Xdt.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "100", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(xdt.jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity APP_FLOATING_BAR VISIBLE -----------------------");
      return;
      this.jdField_a_of_type_Xdt.b.setText(this.jdField_a_of_type_Xdt.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624587));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xdx
 * JD-Core Version:    0.7.0.1
 */