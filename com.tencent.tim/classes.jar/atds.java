import android.content.pm.ResolveInfo;
import android.view.View;
import com.tencent.util.Pair;
import java.util.List;

class atds
  implements ausj.a
{
  atds(atdr paramatdr, List paramList) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = (Pair)this.hT.get(paramInt);
    if (atdr.a(this.a) != null) {
      atdr.a(this.a).a(((Integer)paramView.first).intValue(), (ResolveInfo)paramView.second);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atds
 * JD-Core Version:    0.7.0.1
 */