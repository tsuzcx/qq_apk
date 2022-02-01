import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

public class aezm
  implements ArkViewImplement.LoadCallback
{
  public aezm(MessageForArkApp paramMessageForArkApp, adrd.a parama, wyv paramwyv, adrd paramadrd, int paramInt) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean) {}
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForArkApp", 2, new Object[] { "ArkFold.attachArkView onLoadFinish MessageForArkApp state=", Integer.valueOf(paramInt), ",app=", this.e.ark_app_message.appName });
    }
    this.jdField_a_of_type_Adrd$a.he.setVisibility(8);
    if (paramInt == 1)
    {
      Object localObject = this.jdField_a_of_type_Wyv.getContainerRect();
      float f = adqr.getDensity();
      paramInt = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
      int i = (int)((((Rect)localObject).bottom - ((Rect)localObject).top) * f);
      this.jdField_a_of_type_Adrd.a(this.jdField_a_of_type_Adrd$a, this.e);
      if (adqr.bQr)
      {
        localObject = this.jdField_a_of_type_Adrd$a.f.getLayoutParams();
        QLog.d("MessageForArkApp", 2, new Object[] { "ArkFold.attachArkView.onLoadFinish arkContainer rect(", Integer.valueOf(paramInt), ",", Integer.valueOf(i), "), arkView rect(", Integer.valueOf(((ViewGroup.LayoutParams)localObject).width), ",", Integer.valueOf(((ViewGroup.LayoutParams)localObject).height), "),app=", this.e.ark_app_message.appName });
      }
    }
    this.jdField_a_of_type_Adrd.a(this.jdField_a_of_type_Wyv, this.val$position);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aezm
 * JD-Core Version:    0.7.0.1
 */