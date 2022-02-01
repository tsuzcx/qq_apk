import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment;
import com.tencent.mobileqq.widget.QQToast;

public class ubl
  implements DialogInterface.OnClickListener
{
  public ubl(TestAppFragment paramTestAppFragment, EditText paramEditText1, EditText paramEditText2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.am.getText().toString();
    String str = this.ao.getText().toString();
    if ((TextUtils.isEmpty(paramDialogInterface)) || (TextUtils.isEmpty(str)))
    {
      QQToast.a(this.a.getActivity(), acfp.m(2131715245), 1).show();
      return;
    }
    this.a.aKv = paramDialogInterface;
    this.a.bDr = Integer.parseInt(str);
    this.a.c = tzk.a(this.a.getActivity(), this.a.bDr, paramDialogInterface);
    QQToast.a(this.a.getActivity(), "appid切换为:" + paramDialogInterface, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubl
 * JD-Core Version:    0.7.0.1
 */