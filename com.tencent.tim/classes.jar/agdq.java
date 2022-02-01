import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.a;
import com.tencent.widget.SingleLineTextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public abstract class agdq
  extends PinnedHeaderExpandableListView.a
{
  LinkedHashMap<String, List<Object>> P = new LinkedHashMap();
  protected agdq.a a;
  private ExpandableListView c;
  Object dG;
  protected Context mContext;
  
  public agdq(Context paramContext, Object paramObject)
  {
    if (paramObject != null) {
      this.P = ((LinkedHashMap)paramObject);
    }
    this.mContext = paramContext;
  }
  
  public void a(agdq.a parama)
  {
    this.a = parama;
  }
  
  public void a(ExpandableListView paramExpandableListView)
  {
    this.c = paramExpandableListView;
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
      localObject = (agdq.b)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(new agdr(this, paramInt));
      if (AppSetting.enableTalkBack) {
        paramViewGroup.setAccessibilityDelegate(new rts(paramViewGroup, new agds(this, paramInt)));
      }
      paramView.mCheckBox.setVisibility(0);
      paramView.mCheckBox.setChecked(paramBoolean);
      paramView.mCheckBox.setClickable(false);
      localObject = (String)getGroup(paramInt);
      paramView.aTO = paramInt;
      paramView.n.setText((CharSequence)localObject);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131559068, paramViewGroup, false);
      paramView = new agdq.b();
      paramView.n = ((SingleLineTextView)paramViewGroup.findViewById(2131368187));
      paramView.mCheckBox = ((CheckBox)paramViewGroup.findViewById(2131369742));
      paramViewGroup.findViewById(2131365243).setVisibility(8);
      paramViewGroup.findViewById(2131369847).setVisibility(8);
      paramViewGroup.setTag(paramView);
    }
  }
  
  public int gj()
  {
    return 2131559068;
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
    agdq.b localb = (agdq.b)paramView.getTag();
    if (localb == null)
    {
      localb = new agdq.b();
      localb.n = ((SingleLineTextView)paramView.findViewById(2131368187));
      paramView.findViewById(2131365243).setVisibility(8);
      paramView.findViewById(2131369847).setVisibility(8);
      localb.mCheckBox = ((CheckBox)paramView.findViewById(2131369742));
      paramView.setTag(localb);
    }
    for (;;)
    {
      paramView.setOnClickListener(new agdt(this, paramInt));
      localb.mCheckBox.setChecked(this.c.isGroupExpanded(paramInt));
      paramView = (String)getGroup(paramInt);
      localb.n.setText(paramView);
      localb.mCheckBox.setVisibility(0);
      return;
    }
  }
  
  public void onGroupCollapsed(int paramInt)
  {
    super.onGroupCollapsed(paramInt);
    if (AppSetting.enableTalkBack)
    {
      String str = (String)getGroup(paramInt);
      QQAppInterface.EI(str + acfp.m(2131711021));
    }
  }
  
  public void onGroupExpanded(int paramInt)
  {
    super.onGroupExpanded(paramInt);
    if (AppSetting.enableTalkBack)
    {
      String str = (String)getGroup(paramInt);
      QQAppInterface.EI(str + acfp.m(2131711041));
    }
  }
  
  public static abstract interface a
  {
    public abstract String a(FileInfo paramFileInfo);
    
    public abstract void a(FileInfo paramFileInfo, boolean paramBoolean);
  }
  
  public static class b
  {
    public int aTO;
    public CheckBox mCheckBox;
    public SingleLineTextView n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agdq
 * JD-Core Version:    0.7.0.1
 */