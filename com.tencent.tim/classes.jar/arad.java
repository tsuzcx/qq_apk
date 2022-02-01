import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.opengroup.AppUrlOpenGroup.RspBody;

public class arad
  implements BusinessObserver
{
  public arad(WebViewFragment paramWebViewFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, " checkAppUrl,onReceive:isSuccess=" + paramBoolean);
    }
    if ((this.this$0.getActivity() == null) || (this.this$0.getActivity().isFinishing())) {}
    while (!paramBoolean) {
      return;
    }
    this.this$0.jdField_a_of_type_Arbz.cXS = true;
    paramBundle = paramBundle.getByteArray("data");
    Object localObject = new AppUrlOpenGroup.RspBody();
    try
    {
      ((AppUrlOpenGroup.RspBody)localObject).mergeFrom(paramBundle);
      this.this$0.cyO = ((AppUrlOpenGroup.RspBody)localObject).bytes_app_name.get().toStringUtf8();
      this.this$0.cyP = ((AppUrlOpenGroup.RspBody)localObject).bytes_company.get().toStringUtf8();
      this.this$0.cyR = ((AppUrlOpenGroup.RspBody)localObject).bytes_info_url.get().toStringUtf8();
      this.this$0.cyQ = ((AppUrlOpenGroup.RspBody)localObject).bytes_share_url.get().toStringUtf8();
      if (this.this$0.jdField_a_of_type_Aqzl.centerView.getVisibility() != 8) {
        this.this$0.jdField_a_of_type_Aqzl.centerView.setVisibility(8);
      }
      if (this.this$0.jdField_a_of_type_Aqzl.eM.getVisibility() != 0) {
        this.this$0.jdField_a_of_type_Aqzl.eM.setVisibility(0);
      }
      paramBundle = (TextView)this.this$0.jdField_a_of_type_Aqzl.eM.findViewById(2131379865);
      localObject = (TextView)this.this$0.jdField_a_of_type_Aqzl.eM.findViewById(2131379802);
      paramBundle.setText(this.this$0.jdField_a_of_type_Aqzl.centerView.getText());
      ((TextView)localObject).setText(2131721290);
      this.this$0.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(0);
      this.this$0.jdField_a_of_type_Aqzl.rightViewImg.setImageResource(2130840663);
      return;
    }
    catch (Exception paramBundle) {}catch (InvalidProtocolBufferMicroException paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arad
 * JD-Core Version:    0.7.0.1
 */