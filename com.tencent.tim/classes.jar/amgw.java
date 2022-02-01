import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class amgw
  implements ausj.a
{
  public amgw(SignatureHistoryFragment paramSignatureHistoryFragment, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      VasWebviewUtil.reportCommercialDrainage("signature_history", "sheet", "", 0, 0, 0, "", "", "" + this.dBO, "", "", "", "", 0, 0, 0, 0);
      aqnl.a(this.this$0.getActivity(), this.this$0.getActivity().app, 0, "signature_history", -1, this.dBP, this.cTN, null);
    }
    SignatureHistoryFragment.a(this.this$0).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amgw
 * JD-Core Version:    0.7.0.1
 */