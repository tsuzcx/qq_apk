import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

class wzc
  implements ArkViewImplement.LoadCallback
{
  wzc(wzb paramwzb, MessageForArkApp paramMessageForArkApp, wzb.a parama) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppItemBubbleBuilder", 2, new Object[] { "onLoadFinish state=", Integer.valueOf(paramInt), ",app=", this.b.ark_app_message.appName });
    }
    if (paramInt == 1)
    {
      if (!aprg.V(this.jdField_a_of_type_Wzb.app, this.b.senderuin)) {
        this.jdField_a_of_type_Wzb$a.a(this.jdField_a_of_type_Wzb$a, this.b);
      }
      Object localObject = this.b.arkContainer.getContainerRect();
      float f = adqr.getDensity();
      paramInt = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
      int i = (int)((((Rect)localObject).bottom - ((Rect)localObject).top) * f);
      localObject = this.jdField_a_of_type_Wzb$a.d.getLayoutParams();
      StringBuilder localStringBuilder = new StringBuilder("ArkFold.onLoadFinish arkContainer rect(");
      localStringBuilder.append(paramInt).append(",").append(i).append(")").append(", arkView layout rect(").append(((ViewGroup.LayoutParams)localObject).width).append(",").append(((ViewGroup.LayoutParams)localObject).height).append(")").append(", init mArkWidth=").append(wzb.b(this.jdField_a_of_type_Wzb)).append(",mArkHeight=").append(wzb.a(this.jdField_a_of_type_Wzb)).append(",app=").append(this.b.ark_app_message.appName);
      QLog.i("ArkAppItemBubbleBuilder", 1, localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_Wzb$a.he.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzc
 * JD-Core Version:    0.7.0.1
 */