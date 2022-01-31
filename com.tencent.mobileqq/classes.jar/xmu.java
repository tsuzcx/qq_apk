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

class xmu
  extends Handler
{
  boolean jdField_a_of_type_Boolean;
  
  xmu(xmq paramxmq) {}
  
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
          paramMessage = nam.a(paramMessage, (int)(34.0F * this.jdField_a_of_type_Xmq.jdField_a_of_type_Float));
        } while (this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaLangRefWeakReference == null);
        localObject = (bccw)this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject != null) && ((localObject instanceof bcij))) {
          ((bcij)localObject).b();
        }
        this.jdField_a_of_type_Xmq.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Xmq.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramMessage);
        if ((this.jdField_a_of_type_Xmq.jdField_a_of_type_AndroidAppActivity instanceof bccs))
        {
          paramMessage = ((bccs)this.jdField_a_of_type_Xmq.jdField_a_of_type_AndroidAppActivity).b();
          if ((paramMessage != null) && (paramMessage.a.jdField_a_of_type_AndroidViewView != null))
          {
            paramMessage.a.jdField_a_of_type_AndroidViewView.findViewById(2131365923).setVisibility(8);
            paramMessage.a.jdField_a_of_type_AndroidViewView.findViewById(2131365924).setVisibility(0);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d(xmq.jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity VISIBLE -----------------------");
      return;
    } while ((!(paramMessage.obj instanceof Bitmap)) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Xmq.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse == null) || (this.jdField_a_of_type_Xmq.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Xmq.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo.packName.get())));
    Object localObject = this.jdField_a_of_type_Xmq.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
    if (bbfr.a(this.jdField_a_of_type_Xmq.jdField_a_of_type_AndroidContentContext, ((GetAppInfoProto.AndroidInfo)localObject).packName.get())) {
      this.jdField_a_of_type_Xmq.b.setText(this.jdField_a_of_type_Xmq.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690142));
    }
    for (;;)
    {
      this.jdField_a_of_type_Xmq.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_Xmq.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690143), new Object[] { ((GetAppInfoProto.AndroidInfo)localObject).messagetail.get() }));
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage.isRecycled()) {
        break;
      }
      paramMessage = nam.a(paramMessage, (int)(30.0F * this.jdField_a_of_type_Xmq.jdField_a_of_type_Float));
      this.jdField_a_of_type_Xmq.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Xmq.c.setImageBitmap(paramMessage);
      bdkd.a().a(this.jdField_a_of_type_Xmq.n, String.valueOf(bbcc.b(this.jdField_a_of_type_Xmq.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "100", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(xmq.jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity APP_FLOATING_BAR VISIBLE -----------------------");
      return;
      this.jdField_a_of_type_Xmq.b.setText(this.jdField_a_of_type_Xmq.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690141));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xmu
 * JD-Core Version:    0.7.0.1
 */