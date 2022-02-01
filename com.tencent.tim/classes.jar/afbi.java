import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.a;
import com.tencent.mobileqq.widget.QQToast;

class afbi
  implements DialogInterface.OnClickListener
{
  afbi(afbh paramafbh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = (EditText)((aqju)paramDialogInterface).findViewById(2131372197);
    paramDialogInterface = (EditText)((aqju)paramDialogInterface).findViewById(2131361982);
    if ((TextUtils.isEmpty(localEditText.getText().toString())) || (TextUtils.isEmpty(paramDialogInterface.getText().toString())))
    {
      QQToast.a(this.a.a.getActivity(), 1, acfp.m(2131704645), 0).show();
      return;
    }
    afbz localafbz = new afbz();
    localafbz.name = localEditText.getText().toString();
    localafbz.action = paramDialogInterface.getText().toString();
    localafbz.bXe = true;
    afbx.a().a(localafbz);
    this.a.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbi
 * JD-Core Version:    0.7.0.1
 */