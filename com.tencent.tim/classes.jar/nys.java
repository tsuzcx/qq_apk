import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;

public class nys
  implements sao.a
{
  public nys(FolderFollowTabFragment paramFolderFollowTabFragment) {}
  
  public void onError()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()) && (FolderFollowTabFragment.a(this.this$0) != null)) {
      FolderFollowTabFragment.a(this.this$0).uN(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nys
 * JD-Core Version:    0.7.0.1
 */