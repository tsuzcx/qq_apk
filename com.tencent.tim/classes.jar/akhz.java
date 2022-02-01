import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class akhz
  implements DialogInterface.OnClickListener
{
  akhz(akhv paramakhv, akjj paramakjj, akhv.a parama) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!aqiw.isNetworkAvailable(this.jdField_a_of_type_Akhv.mContext))
    {
      QQToast.a(this.jdField_a_of_type_Akhv.mContext, 1, acfp.m(2131703129), 0).show();
      return;
    }
    ((akio)this.jdField_a_of_type_Akhv.mApp.getManager(263)).a(this.jdField_a_of_type_Akjj.feedId, this.jdField_a_of_type_Akjj.adT, this.jdField_a_of_type_Akjj.feedType, new akia(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhz
 * JD-Core Version:    0.7.0.1
 */