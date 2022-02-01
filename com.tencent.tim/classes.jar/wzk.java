import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

class wzk
  implements ArkViewImplement.LoadCallback
{
  wzk(wzj paramwzj, MessageForArkApp paramMessageForArkApp, wzb.a parama) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    Object localObject = this.b.arkContainer.getContainerRect();
    float f = adqr.getDensity();
    int i = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
    int j = (int)((((Rect)localObject).bottom - ((Rect)localObject).top) * f);
    localObject = this.jdField_a_of_type_Wzb$a.d.getLayoutParams();
    StringBuilder localStringBuilder = new StringBuilder("ArkFold.onLoadFinish arkContainer rect(");
    localStringBuilder.append(i).append(",").append(j).append(")").append(", arkView layout rect(").append(((ViewGroup.LayoutParams)localObject).width).append(",").append(((ViewGroup.LayoutParams)localObject).height).append(")").append(", init mArkWidth=").append(wzj.a(this.jdField_a_of_type_Wzj)).append(", load state=").append(paramInt).append(", app=").append(this.b.ark_app_message.appName);
    QLog.i("ArkAppItemBuilder", 1, localStringBuilder.toString());
    if ((adqr.bQr) && (paramInt == 1) && (Math.abs(((ViewGroup.LayoutParams)localObject).width - wzj.a(this.jdField_a_of_type_Wzj)) > 5))
    {
      QLog.d("ArkAppItemBuilder", 1, new Object[] { "ArkFold.onLoadFinish setViewRect(", Integer.valueOf(wzj.a(this.jdField_a_of_type_Wzj)), ",", Integer.valueOf(j), ")" });
      this.jdField_a_of_type_Wzb$a.d.setFixSize(wzj.a(this.jdField_a_of_type_Wzj), -1);
      this.jdField_a_of_type_Wzb$a.d.setMaxSize(wzj.a(this.jdField_a_of_type_Wzj), -1);
      this.jdField_a_of_type_Wzb$a.d.setMinSize(wzj.a(this.jdField_a_of_type_Wzj), -1);
      this.jdField_a_of_type_Wzb$a.d.setViewRect(wzj.a(this.jdField_a_of_type_Wzj), j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzk
 * JD-Core Version:    0.7.0.1
 */