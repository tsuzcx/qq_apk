import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;

public class ker
  implements arkn
{
  public ker(EcshopNewPageFragment paramEcshopNewPageFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if ((paramInt == 5) || (paramInt == 4))
    {
      paramView = new Intent(this.a.getActivity(), AccountDetailActivity.class);
      paramView.putExtra("uin", "3046055438");
      paramView.putExtra("from_tab", true);
      this.a.startActivity(paramView);
    }
    while (paramInt != 1) {
      return;
    }
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ker
 * JD-Core Version:    0.7.0.1
 */