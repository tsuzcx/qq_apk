import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.5.1;
import com.tencent.mobileqq.app.ThreadManager;

public class ttr
  implements DialogInterface.OnClickListener
{
  public ttr(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      ThreadManager.post(new ReadInJoyNewSearchActivity.5.1(this), 10, null, true);
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ttr
 * JD-Core Version:    0.7.0.1
 */