import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.a;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew;

class nyv
  implements sgs.b
{
  nyv(nyu paramnyu) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FolderRecommendTabFragment.a.a(this.a.a).bxB();
      this.a.a.ur(false);
      this.a.a.a.bcE();
      sqn.b("", "auth_discover", "fold", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyv
 * JD-Core Version:    0.7.0.1
 */