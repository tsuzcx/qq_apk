package me.ele.uetool.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.ele.uetool.UETool;
import me.ele.uetool.recyclerview.BaseItem;
import me.ele.uetool.recyclerview.HierarchyItem;
import me.ele.uetool.recyclerview.MenuRecyclerView;
import me.ele.uetool.recyclerview.UniversalAdapter;
import me.ele.uetool.util.ViewKnife;

public class HierarchyView
  extends LinearLayout
{
  private UniversalAdapter adapter;
  private EditAttrLayout editAttrLayout;
  private WindowManager.LayoutParams layoutParams;
  private MenuRecyclerView recyclerView;
  private IRemoveView removeView;
  private View rootView;
  private int sysLayerCount;
  private int targetIndex = -1;
  
  public HierarchyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HierarchyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HierarchyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
    paramAttributeSet = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localLayoutParams.height = ViewKnife.dip2px(15.0F);
    addView(paramAttributeSet, localLayoutParams);
    this.adapter = new UniversalAdapter();
    this.recyclerView = new MenuRecyclerView(paramContext);
    this.recyclerView.setBackgroundColor(Color.parseColor("#EFEFF3"));
    this.recyclerView.setLayoutManager(onCreateLayoutManager(paramContext));
    this.recyclerView.setAdapter(this.adapter);
    this.rootView = ViewKnife.tryGetTheFrontView(UETool.getInstance().getTargetActivity());
    addView(this.recyclerView);
    setAdapterListener();
    expandAllViews();
  }
  
  private void assembleItems(List<BaseItem> paramList, HierarchyItem paramHierarchyItem)
  {
    if ((paramHierarchyItem.isGroup()) && (paramHierarchyItem.getChildCount() > 0))
    {
      paramHierarchyItem.isExpand = true;
      paramHierarchyItem = paramHierarchyItem.assembleChildren();
      int i = 0;
      while (i < paramHierarchyItem.size())
      {
        HierarchyItem localHierarchyItem = (HierarchyItem)paramHierarchyItem.get(i);
        paramList.add(localHierarchyItem);
        assembleItems(paramList, localHierarchyItem);
        i += 1;
      }
    }
  }
  
  private void expandAllViews()
  {
    ArrayList localArrayList = new ArrayList();
    HierarchyItem localHierarchyItem = HierarchyItem.createRoot(this.rootView, new HierarchyView.3(this));
    localHierarchyItem.sysLayerCount = this.sysLayerCount;
    localArrayList.add(localHierarchyItem);
    assembleItems(localArrayList, localHierarchyItem);
    this.adapter.setItems(localArrayList);
  }
  
  private List<HierarchyItem> getAllExpandItems(HierarchyItem paramHierarchyItem, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramHierarchyItem.isExpand) && (paramHierarchyItem.getChildCount() > 0)) {}
    for (;;)
    {
      Object localObject;
      if (paramInt < this.adapter.getItemCount())
      {
        localObject = (HierarchyItem)this.adapter.getItem(paramInt);
        if (paramHierarchyItem.layerCount < ((HierarchyItem)localObject).layerCount) {}
      }
      else
      {
        return localArrayList;
      }
      localArrayList.add(localObject);
      int i = paramInt;
      if (((HierarchyItem)localObject).isGroup())
      {
        localObject = getAllExpandItems((HierarchyItem)localObject, paramInt + 1);
        localArrayList.addAll((Collection)localObject);
        i = paramInt + ((List)localObject).size();
      }
      paramInt = i + 1;
    }
  }
  
  private void insertItems(List<HierarchyItem> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.adapter.getItemCount())
    {
      localArrayList.add(this.adapter.getItem(i));
      i += 1;
    }
    this.adapter.getItems().addAll(paramInt, paramList);
    this.adapter.notifyDataSetChanged();
  }
  
  private void removeItems(List<HierarchyItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.adapter.getItemCount())
    {
      localArrayList.add(this.adapter.getItem(i));
      i += 1;
    }
    this.adapter.getItems().removeAll(paramList);
    this.adapter.notifyDataSetChanged();
  }
  
  private void removeView()
  {
    if (this.removeView != null) {
      this.removeView.removeView(this);
    }
  }
  
  private void setAdapterListener()
  {
    this.adapter.setListener(new HierarchyView.2(this));
  }
  
  public void clearTarget()
  {
    ((HierarchyItem)this.adapter.getItem(this.targetIndex)).isTarget = false;
    this.targetIndex = -1;
  }
  
  protected RecyclerView.LayoutManager onCreateLayoutManager(Context paramContext)
  {
    return new HierarchyView.1(this, paramContext);
  }
  
  public void onViewEnterAnimEnd(View paramView)
  {
    int i;
    if (paramView != null)
    {
      i = 0;
      if (i >= this.adapter.getItems().size()) {
        break label80;
      }
      HierarchyItem localHierarchyItem = (HierarchyItem)this.adapter.getItem(i);
      if (localHierarchyItem.data != paramView) {
        break label73;
      }
      this.targetIndex = i;
      localHierarchyItem.isTarget = true;
      this.adapter.notifyDataSetChanged();
    }
    for (;;)
    {
      if (i != -1) {
        this.recyclerView.scrollToPosition(i);
      }
      return;
      label73:
      i += 1;
      break;
      label80:
      i = -1;
    }
  }
  
  public void setEditAttrLayout(EditAttrLayout paramEditAttrLayout)
  {
    this.editAttrLayout = paramEditAttrLayout;
  }
  
  public void setLayoutParams(WindowManager.LayoutParams paramLayoutParams)
  {
    this.layoutParams = paramLayoutParams;
  }
  
  public void setRemoveView(IRemoveView paramIRemoveView)
  {
    this.removeView = paramIRemoveView;
  }
  
  public static abstract interface IRemoveView
  {
    public abstract void removeView(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.view.HierarchyView
 * JD-Core Version:    0.7.0.1
 */