import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.widget.PinnedHeaderExpandableListView.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public abstract class atpo
  extends PinnedHeaderExpandableListView.a
{
  LinkedHashMap<String, List<Object>> P = new LinkedHashMap();
  Object dG;
  private Context mContext;
  
  public atpo(Context paramContext, Object paramObject)
  {
    if (paramObject != null) {
      this.P = ((LinkedHashMap)paramObject);
    }
    this.mContext = paramContext;
  }
  
  protected List<Object> aa(int paramInt)
  {
    Iterator localIterator = this.P.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i != paramInt) {
        i += 1;
      } else {
        return (List)this.P.get(str);
      }
    }
    return null;
  }
  
  public void bk(Object paramObject)
  {
    this.dG = paramObject;
  }
  
  String ef(int paramInt)
  {
    Iterator localIterator = this.P.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (i == paramInt) {
        return str;
      }
      i += 1;
    }
    String str = null;
    return str;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    List localList = aa(paramInt1);
    if ((localList != null) && (localList.size() > 0) && (paramInt2 < localList.size())) {
      return localList.get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = aa(paramInt);
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return ef(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.P.keySet().size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (atpo.a)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = (String)getGroup(paramInt);
      paramView.aTO = paramInt;
      paramView.qZ.setText((CharSequence)localObject);
      if (AppSetting.enableTalkBack)
      {
        if (!paramBoolean) {
          break label155;
        }
        paramViewGroup.setContentDescription((String)localObject + "分组已展开");
      }
    }
    for (;;)
    {
      paramViewGroup.setFocusable(true);
      paramViewGroup.setFocusableInTouchMode(true);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131559067, paramViewGroup, false);
      paramView = new atpo.a();
      paramView.qZ = ((TextView)paramViewGroup.findViewById(2131368187));
      paramView.afh = ((TextView)paramViewGroup.findViewById(2131365243));
      paramViewGroup.setTag(paramView);
      break;
      label155:
      paramViewGroup.setContentDescription((String)localObject + "分组已折叠");
    }
  }
  
  public int gj()
  {
    return 2131559067;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void j(View paramView, int paramInt)
  {
    Object localObject = (atpo.a)paramView.getTag();
    if (localObject == null)
    {
      localObject = new atpo.a();
      paramView.findViewById(2131369742).setVisibility(0);
      ((atpo.a)localObject).qZ = ((TextView)paramView.findViewById(2131368187));
      ((atpo.a)localObject).afh = ((TextView)paramView.findViewById(2131365243));
      paramView.setTag(localObject);
    }
    for (paramView = (View)localObject;; paramView = (View)localObject)
    {
      localObject = (String)getGroup(paramInt);
      paramView.qZ.setText((CharSequence)localObject);
      return;
    }
  }
  
  static class a
  {
    public int aTO;
    public TextView afh;
    public TextView qZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpo
 * JD-Core Version:    0.7.0.1
 */