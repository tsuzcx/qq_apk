import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.widget.QQToast;

class akai
  implements DialogInterface.OnClickListener
{
  akai(akah paramakah) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!aqiw.isNetworkAvailable(this.a.this$0.app.getApp()))
    {
      QQToast.a(this.a.this$0.Fb.getContext(), 1, acfp.m(2131709736), 0).show();
      return;
    }
    ((akio)this.a.this$0.app.getManager(263)).a(this.a.this$0.b.id, this.a.this$0.b.time, this.a.this$0.b.feedType, new akaj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akai
 * JD-Core Version:    0.7.0.1
 */