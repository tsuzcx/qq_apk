import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SelectedAndSearchBar.b;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class uxm
  implements SelectedAndSearchBar.b
{
  public uxm(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {}
    for (;;)
    {
      return;
      ForwardRecentActivity.a(this.this$0, paramResultRecord.uin, paramResultRecord.lk());
      int j = ForwardRecentActivity.a(this.this$0).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = ForwardRecentActivity.a(this.this$0).getChildAt(i);
        if ((localObject instanceof ForwardRecentItemView))
        {
          localObject = (ForwardRecentItemView)localObject;
          if ((((ForwardRecentItemView)localObject).b.uinType == paramResultRecord.uinType) && (((ForwardRecentItemView)localObject).b.uin.equals(paramResultRecord.uin))) {
            ((ForwardRecentItemView)localObject).Du(false);
          }
        }
        i += 1;
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.this$0.aS.setVisibility(8);
    }
    for (;;)
    {
      if (ForwardRecentActivity.a(this.this$0) != null) {
        ForwardRecentActivity.a(this.this$0).Id(paramEditable);
      }
      return;
      this.this$0.aS.setVisibility(0);
    }
  }
  
  public void xf(boolean paramBoolean)
  {
    if ((paramBoolean) && (ForwardRecentActivity.a(this.this$0) == null))
    {
      ForwardRecentActivity.a(this.this$0, ContactSearchFragment.a(7, 2097177, null, null, ForwardRecentActivity.a(this.this$0)));
      Object localObject = new ArrayList();
      Iterator localIterator = ForwardRecentActivity.a(this.this$0).values().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((ResultRecord)localIterator.next()).uin);
      }
      ForwardRecentActivity.a(this.this$0).N((List)localObject, (List)localObject);
      localObject = this.this$0.getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131377207, ForwardRecentActivity.a(this.this$0));
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxm
 * JD-Core Version:    0.7.0.1
 */