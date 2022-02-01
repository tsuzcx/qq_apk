import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.List;

public class abeo<T>
  extends afie<T>
  implements View.OnClickListener
{
  private DragSortListView a;
  
  public abeo(Context paramContext, List<T> paramList, DragSortListView paramDragSortListView)
  {
    super(paramContext, paramList);
    this.a = paramDragSortListView;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (View localView = View.inflate(this.mContext, 2131561370, null);; localView = paramView)
    {
      localView.setVisibility(0);
      localView.findViewById(2131378161).setVisibility(8);
      TextView localTextView = (TextView)localView.findViewById(2131368179);
      Groups localGroups = (Groups)this.mData.get(paramInt);
      localTextView.setText(localGroups.group_name);
      ViewCompat.setImportantForAccessibility(localView.findViewById(2131368184), 1);
      localView.setContentDescription(localGroups.group_name + acfp.m(2131707029));
      if ((VersionUtils.isOreo()) && (AppSetting.enableTalkBack)) {
        localView.setOnClickListener(this);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
  }
  
  public void onClick(View paramView)
  {
    if (AppSetting.enableTalkBack) {
      this.a.cZM();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abeo
 * JD-Core Version:    0.7.0.1
 */