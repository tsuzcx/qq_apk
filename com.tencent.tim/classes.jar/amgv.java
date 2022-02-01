import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.StatusServlet;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.NewIntent;

public class amgv
  implements DialogInterface.OnClickListener
{
  public amgv(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new ArrayList();
    Object localObject = SignatureHistoryFragment.a(this.this$0).iterator();
    int i;
    for (paramInt = 0; ((Iterator)localObject).hasNext(); paramInt = i)
    {
      String str = (String)((Iterator)localObject).next();
      i = paramInt;
      if (str != null)
      {
        i = paramInt;
        if (SignatureHistoryFragment.b(this.this$0) != null)
        {
          i = paramInt;
          if (SignatureHistoryFragment.b(this.this$0).get(0) != null)
          {
            i = paramInt;
            if (((HistorySignItem)SignatureHistoryFragment.b(this.this$0).get(0)).richStatus != null)
            {
              i = paramInt;
              if (((HistorySignItem)SignatureHistoryFragment.b(this.this$0).get(0)).richStatus.feedsId != null)
              {
                if (str.equals(new String(((HistorySignItem)SignatureHistoryFragment.b(this.this$0).get(0)).richStatus.feedsId))) {
                  paramInt = 1;
                }
                paramDialogInterface.add(str);
                i = paramInt;
              }
            }
          }
        }
      }
    }
    if (SignatureHistoryFragment.a(this.this$0) == null) {
      SignatureHistoryFragment.a(this.this$0, new arhz(this.this$0.getActivity(), this.this$0.getActivity().getTitleBarHeight()));
    }
    SignatureHistoryFragment.a(this.this$0).setMessage(acfp.m(2131714560));
    SignatureHistoryFragment.a(this.this$0).show();
    if ((SignatureHistoryFragment.a(this.this$0)) && (SignatureHistoryFragment.b(this.this$0).size() == 1))
    {
      paramDialogInterface = new NewIntent(this.this$0.getActivity().app.getApp(), StatusServlet.class);
      paramDialogInterface.putExtra("k_cmd", 8);
      this.this$0.getActivity().app.startServlet(paramDialogInterface);
    }
    while (paramDialogInterface.isEmpty())
    {
      anot.a(null, "dc00898", "", "", "0X800A98D", "0X800A98D", 1, 0, "0", "0", "", "");
      VasWebviewUtil.reportCommercialDrainage(this.this$0.getActivity().app.getCurrentUin(), "signature", "signature_10", "", 1, 0, 0, "", "", "");
      return;
    }
    localObject = new NewIntent(this.this$0.getActivity().app.getApp(), StatusServlet.class);
    ((NewIntent)localObject).putExtra("k_cmd", 5);
    ((NewIntent)localObject).putStringArrayListExtra("k_status_key", paramDialogInterface);
    if (paramInt != 0) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((NewIntent)localObject).putExtra("k_status_flag", paramInt);
      this.this$0.getActivity().app.startServlet((NewIntent)localObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amgv
 * JD-Core Version:    0.7.0.1
 */