import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.qphone.base.util.QLog;

public class nii
  implements DialogInterface.OnClickListener
{
  public nii(ReadinjoyTabFrame paramReadinjoyTabFrame, SelectPositionModule.PositionData paramPositionData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyTabFrame", 2, "showLocationChangedDialog change confirm");
    }
    paramDialogInterface = lbz.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.d(this.f);
    }
    paramDialogInterface = lbz.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.re(41695);
    }
    lbz.a().aq(41695, this.f.city);
    lcc.a().oC(41695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nii
 * JD-Core Version:    0.7.0.1
 */