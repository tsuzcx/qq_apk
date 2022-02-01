package me.ele.uetool.recyclerview;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.ViewKnife;
import me.ele.uetool.view.TreeNodeLayout;

public class HierarchyItem
  extends BaseItem<View>
  implements View.OnClickListener
{
  private View.OnClickListener childClickListener;
  public boolean isExpand;
  public boolean isTarget;
  private View itemView;
  public int layerCount;
  public int sysLayerCount;
  
  HierarchyItem(View paramView, int paramInt)
  {
    super(paramView);
    this.layerCount = paramInt;
  }
  
  public static HierarchyItem createRoot(View paramView, View.OnClickListener paramOnClickListener)
  {
    paramView = new HierarchyItem(paramView, 0);
    paramView.childClickListener = paramOnClickListener;
    return paramView;
  }
  
  private boolean isVisible()
  {
    return ((View)this.data).getVisibility() == 0;
  }
  
  private String viewToSummaryString(View paramView)
  {
    return "{(" + paramView.getLeft() + ',' + paramView.getTop() + "), (" + paramView.getRight() + ',' + paramView.getBottom() + ")} " + ViewKnife.getIdString(paramView);
  }
  
  private String viewToTitleString(View paramView)
  {
    if (isGroup()) {
      return paramView.getClass().getSimpleName() + " (" + getChildCount() + ")";
    }
    return paramView.getClass().getSimpleName();
  }
  
  public List<HierarchyItem> assembleChildren()
  {
    ViewGroup localViewGroup = (ViewGroup)this.data;
    ArrayList localArrayList = new ArrayList();
    int j = this.layerCount;
    int i = 0;
    while (i < localViewGroup.getChildCount())
    {
      HierarchyItem localHierarchyItem = new HierarchyItem(localViewGroup.getChildAt(i), j + 1);
      localHierarchyItem.sysLayerCount = this.sysLayerCount;
      localHierarchyItem.childClickListener = this.childClickListener;
      localArrayList.add(localHierarchyItem);
      i += 1;
    }
    return localArrayList;
  }
  
  public int getChildCount()
  {
    return ((ViewGroup)this.data).getChildCount();
  }
  
  public int getLayout()
  {
    return JarResource.getIdByName("layout", "qb_uet_item_hierachy");
  }
  
  public boolean isGroup()
  {
    return this.data instanceof ViewGroup;
  }
  
  public void onBinding(int paramInt, UniversalAdapter.ViewPool paramViewPool, View paramView)
  {
    this.itemView = paramViewPool.itemView;
    int i;
    if (isVisible()) {
      if (this.isTarget)
      {
        i = Color.parseColor("#5F80E3");
        paramViewPool.setText(JarResource.getIdByName("id", "view_name_title"), viewToTitleString(paramView)).setTextColor(JarResource.getIdByName("id", "view_name_title"), i).setText(JarResource.getIdByName("id", "view_name_subtitle"), viewToSummaryString(paramView)).setTextColor(JarResource.getIdByName("id", "view_name_subtitle"), i);
        ((TreeNodeLayout)paramViewPool.getView(JarResource.getIdByName("id", "view_name_wrapper"))).setLayerCount(this.layerCount, this.sysLayerCount);
        if ((!isGroup()) || (getChildCount() <= 0)) {
          break label227;
        }
        paramView = (TextView)paramViewPool.getView(JarResource.getIdByName("id", "view_name_title"));
        if (!this.isExpand) {
          break label215;
        }
        i = JarResource.getIdByName("drawable", "qb_uet_down");
        label155:
        paramView.setCompoundDrawablesWithIntrinsicBounds(ViewKnife.getDrawable(i), null, null, null);
      }
    }
    for (;;)
    {
      paramViewPool.getView(JarResource.getIdByName("id", "view_name_more")).setOnClickListener(this);
      paramViewPool.getView(JarResource.getIdByName("id", "view_name_more")).setTag(Integer.valueOf(paramInt));
      return;
      i = -16777216;
      break;
      i = -6974059;
      break;
      label215:
      i = JarResource.getIdByName("drawable", "qb_uet_right");
      break label155;
      label227:
      ((TextView)paramViewPool.getView(JarResource.getIdByName("id", "view_name_title"))).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.childClickListener != null) {
      this.childClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void toggleIcon()
  {
    boolean bool;
    TextView localTextView;
    if (!this.isExpand)
    {
      bool = true;
      this.isExpand = bool;
      if ((this.itemView != null) && (isGroup()) && (getChildCount() > 0))
      {
        localTextView = (TextView)this.itemView.findViewById(JarResource.getIdByName("id", "view_name_title"));
        if (!this.isExpand) {
          break label85;
        }
      }
    }
    label85:
    for (int i = JarResource.getIdByName("drawable", "qb_uet_down");; i = JarResource.getIdByName("drawable", "qb_uet_right"))
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(ViewKnife.getDrawable(i), null, null, null);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.recyclerview.HierarchyItem
 * JD-Core Version:    0.7.0.1
 */