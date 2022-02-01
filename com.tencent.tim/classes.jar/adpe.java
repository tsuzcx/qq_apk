import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;

class adpe
  implements ArkViewImplement.LoadCallback
{
  adpe(adpd paramadpd, adrd.a parama, adrd paramadrd, int paramInt, wyv paramwyv) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Adrd$a.o.setVisibility(0);
      adpd.a(this.jdField_a_of_type_Adpd, this.jdField_a_of_type_Adrd, this.jdField_a_of_type_Adrd$a);
      this.jdField_a_of_type_Adrd$a.he.setVisibility(0);
      this.jdField_a_of_type_Adrd.a(this.jdField_a_of_type_Adrd$a, this.jdField_a_of_type_Adpd);
    }
    for (;;)
    {
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView.appName:", this.jdField_a_of_type_Adpd.a.appName, ", position=", Integer.valueOf(this.val$position), ",state=", Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Adrd.a(this.jdField_a_of_type_Wyv, this.val$position);
      return;
      this.jdField_a_of_type_Adrd$a.o.setVisibility(8);
      this.jdField_a_of_type_Adrd$a.he.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpe
 * JD-Core Version:    0.7.0.1
 */