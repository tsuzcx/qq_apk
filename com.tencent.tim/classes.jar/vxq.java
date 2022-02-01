import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.TranslucentTRansferFragment;

public class vxq
  implements DialogInterface.OnClickListener
{
  public vxq(TranslucentTRansferFragment paramTranslucentTRansferFragment, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.L.dismiss();
    paramDialogInterface = new Intent(this.a.getActivity(), RegisterPhoneNumActivity.class);
    paramDialogInterface.putExtra("invite_code", this.a.getActivity().getIntent().getStringExtra("invite_code"));
    this.a.startActivity(paramDialogInterface);
    anot.a(null, "dc00898", "", "", "0X800970C", "0X800970C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxq
 * JD-Core Version:    0.7.0.1
 */