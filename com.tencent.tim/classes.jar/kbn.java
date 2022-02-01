import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountMenuBar;
import java.util.List;

public class kbn
  implements ausj.a
{
  public kbn(PublicAccountMenuBar paramPublicAccountMenuBar, List paramList, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (PublicAccountMenuBar.a(this.b)) {
      return;
    }
    PublicAccountMenuBar.a(this.b, true);
    paramView = (soo)this.fU.get(paramInt);
    PublicAccountMenuBar.a(this.b, paramView);
    this.val$actionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbn
 * JD-Core Version:    0.7.0.1
 */