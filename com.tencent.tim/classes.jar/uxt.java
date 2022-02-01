import android.content.Intent;
import android.database.DataSetObserver;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class uxt
  extends DataSetObserver
{
  public uxt(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onChanged()
  {
    super.onChanged();
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onChanged() called " + System.identityHashCode(this.this$0));
    }
    if (this.this$0.ZO == ForwardRecentActivity.bGT)
    {
      localObject1 = ForwardRecentActivity.a(this.this$0);
      this.this$0.getIntent().putParcelableArrayListExtra("result_set", (ArrayList)localObject1);
      this.this$0.setResult(-1);
      this.this$0.finish();
    }
    while (this.this$0.ZO != ForwardRecentActivity.bGS) {
      return;
    }
    Object localObject1 = ForwardRecentActivity.a(this.this$0).getAdapter();
    int j = ((ListAdapter)localObject1).getCount();
    String str = this.this$0.getIntent().getStringExtra("key_direct_show_uin");
    int k = this.this$0.getIntent().getIntExtra("key_direct_show_uin_type", 0);
    if ((6000 == k) && (TextUtils.equals(acbn.bkw, str)) && (ForwardRecentActivity.a(this.this$0) != null))
    {
      ForwardRecentActivity.a(this.this$0).callOnClick();
      return;
    }
    int i = 0;
    label197:
    Object localObject2;
    if (i < j)
    {
      localObject2 = ((ListAdapter)localObject1).getItem(i);
      if ((localObject2 instanceof abej.a)) {
        break label227;
      }
    }
    label227:
    do
    {
      i += 1;
      break label197;
      break;
      localObject2 = (abej.a)localObject2;
    } while ((((abej.a)localObject2).b == null) || (!TextUtils.equals(((abej.a)localObject2).b.uin, str)) || (k != ((abej.a)localObject2).b.getType()));
    localObject1 = ((ListAdapter)localObject1).getView(i, null, ForwardRecentActivity.a(this.this$0));
    this.this$0.eL((View)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxt
 * JD-Core Version:    0.7.0.1
 */