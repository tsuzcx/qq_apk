import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.EditColumnFragment;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.mobileqq.widget.QQToast;

public class mnc
  implements DialogInterface.OnClickListener
{
  public mnc(EditColumnFragment paramEditColumnFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.nU(true);
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.ra() > 0)
    {
      this.a.jdField_a_of_type_Mnf$b.a(EditColumnFragment.a(this.a), this.a.a());
      return;
    }
    QQToast.a(this.a.getActivity(), 0, 2131718374, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mnc
 * JD-Core Version:    0.7.0.1
 */