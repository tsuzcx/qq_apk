import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ammo
  implements View.OnClickListener
{
  public ammo(AssociateSearchWordsFragment paramAssociateSearchWordsFragment) {}
  
  public void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity;
    Object localObject1;
    Object localObject2;
    if (paramView.getTag() != null)
    {
      localFragmentActivity = this.b.getActivity();
      localObject1 = (Integer)paramView.getTag(2131381961);
      localObject2 = (AssociateSearchWordsFragment.AssociateItem)paramView.getTag(2131381960);
      switch (((AssociateSearchWordsFragment.AssociateItem)localObject2).businessType)
      {
      }
    }
    label224:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localFragmentActivity instanceof AssociateSearchWordsFragment.a))
      {
        Intent localIntent = new Intent(localFragmentActivity, QQBrowserActivity.class);
        localObject2 = ((AssociateSearchWordsFragment.AssociateItem)localObject2).summary;
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("http")) {
          localObject1 = "http://" + (String)localObject2;
        }
        localIntent.putExtra("url", (String)localObject1);
        localFragmentActivity.startActivity(localIntent);
        localFragmentActivity.finish();
        continue;
        if ((localFragmentActivity instanceof AssociateSearchWordsFragment.a)) {
          localObject1 = (AssociateSearchWordsFragment.a)localFragmentActivity;
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label224;
          }
          ((AssociateSearchWordsFragment.a)localObject1).fM(((AssociateSearchWordsFragment.AssociateItem)localObject2).title, ((AssociateSearchWordsFragment.AssociateItem)localObject2).index);
          break;
          if (AssociateSearchWordsFragment.a(this.b) != null) {
            localObject1 = AssociateSearchWordsFragment.a(this.b);
          } else {
            localObject1 = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ammo
 * JD-Core Version:    0.7.0.1
 */