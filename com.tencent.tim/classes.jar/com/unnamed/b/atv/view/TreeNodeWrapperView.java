package com.unnamed.b.atv.view;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import me.ele.uetool.util.JarResource;

public class TreeNodeWrapperView
  extends LinearLayout
{
  private final int containerStyle;
  private ViewGroup nodeContainer;
  private LinearLayout nodeItemsContainer;
  
  public TreeNodeWrapperView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.containerStyle = paramInt;
    init();
  }
  
  private void init()
  {
    setOrientation(1);
    this.nodeContainer = new RelativeLayout(getContext());
    this.nodeContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.nodeContainer.setId(JarResource.getIdByName("id", "node_header"));
    this.nodeItemsContainer = new LinearLayout(new ContextThemeWrapper(getContext(), this.containerStyle), null, this.containerStyle);
    this.nodeItemsContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.nodeItemsContainer.setId(JarResource.getIdByName("id", "node_items"));
    this.nodeItemsContainer.setOrientation(1);
    this.nodeItemsContainer.setVisibility(8);
    addView(this.nodeContainer);
    addView(this.nodeItemsContainer);
  }
  
  public ViewGroup getNodeContainer()
  {
    return this.nodeContainer;
  }
  
  public void insertNodeView(View paramView)
  {
    this.nodeContainer.addView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.unnamed.b.atv.view.TreeNodeWrapperView
 * JD-Core Version:    0.7.0.1
 */