import com.tencent.mobileqq.adapter.MayKnowAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class yek
  extends FriendListObserver
{
  public yek(MayKnowAdapter paramMayKnowAdapter) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.b();
      MayKnowAdapter.a(this.a, this.a.a.a());
      this.a.notifyDataSetChanged();
      if ((MayKnowAdapter.a(this.a) == null) || (MayKnowAdapter.a(this.a).size() == 0)) {
        MayKnowAdapter.a(this.a).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    MayKnowAdapter.a(this.a).setVisibility(0);
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.b();
      MayKnowAdapter.a(this.a, this.a.a.a());
      this.a.notifyDataSetChanged();
      if ((MayKnowAdapter.a(this.a) == null) || (MayKnowAdapter.a(this.a).size() == 0)) {
        MayKnowAdapter.a(this.a).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    MayKnowAdapter.a(this.a).setVisibility(0);
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onStatesChanged ");
    }
    MayKnowAdapter.a(this.a, this.a.a.a());
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yek
 * JD-Core Version:    0.7.0.1
 */