import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class zhe
  implements ausj.a
{
  public zhe(ChatHistoryTroopMediaFragment paramChatHistoryTroopMediaFragment, ausj paramausj, ArrayList paramArrayList) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.val$actionSheet.getContent(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(this.a.getActivity().getResources().getString(2131690171))) {
          break label92;
        }
        if ((this.rC != null) && (this.rC.size() > 0) && (this.a.a != null)) {
          this.a.a.bBS();
        }
      }
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      label92:
      if (paramView.equals(this.a.getActivity().getResources().getString(2131694753))) {
        this.a.dj(this.rC);
      } else if (paramView.equals(this.a.getActivity().getResources().getString(2131694765))) {
        if (this.rC.size() > 20) {
          QQToast.a(this.a.getActivity(), 2131694002, 0).show();
        } else {
          this.a.dk(this.rC);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zhe
 * JD-Core Version:    0.7.0.1
 */