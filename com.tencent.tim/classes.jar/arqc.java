import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.BindGroupFragment;

public class arqc
  implements DialogInterface.OnClickListener
{
  public arqc(BindGroupFragment paramBindGroupFragment, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      BindGroupFragment.a(this.a, acfp.m(2131703201));
      ((acms)BindGroupFragment.a(this.a).getBusinessHandler(20)).a(Integer.valueOf(BindGroupFragment.a(this.a)).intValue(), Integer.valueOf(BindGroupFragment.b(this.a)).intValue(), Long.valueOf(this.Uf).longValue(), BindGroupFragment.c(this.a));
    }
    while (paramInt != 0) {
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqc
 * JD-Core Version:    0.7.0.1
 */