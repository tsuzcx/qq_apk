package com.unnamed.b.atv.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.unnamed.b.atv.view.AndroidTreeView;
import com.unnamed.b.atv.view.TreeNodeWrapperView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.util.JarResource;

public class TreeNode
{
  public static final String NODES_ID_SEPARATOR = ":";
  private final List<TreeNode> children = new ArrayList();
  private TreeNodeClickListener mClickListener;
  private boolean mExpanded;
  private int mId;
  private int mLastId;
  private TreeNodeLongClickListener mLongClickListener;
  private TreeNode mParent;
  private boolean mSelectable = true;
  private boolean mSelected;
  private Object mValue;
  private BaseNodeViewHolder mViewHolder;
  
  public TreeNode(Object paramObject)
  {
    this.mValue = paramObject;
  }
  
  private int generateId()
  {
    int i = this.mLastId + 1;
    this.mLastId = i;
    return i;
  }
  
  public static TreeNode root()
  {
    TreeNode localTreeNode = new TreeNode(null);
    localTreeNode.setSelectable(false);
    return localTreeNode;
  }
  
  public TreeNode addChild(TreeNode paramTreeNode)
  {
    paramTreeNode.mParent = this;
    paramTreeNode.mId = generateId();
    this.children.add(paramTreeNode);
    return this;
  }
  
  public TreeNode addChildren(Collection<TreeNode> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      addChild((TreeNode)paramCollection.next());
    }
    return this;
  }
  
  public TreeNode addChildren(TreeNode... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      addChild(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public int deleteChild(TreeNode paramTreeNode)
  {
    int i = 0;
    while (i < this.children.size())
    {
      if (paramTreeNode.mId == ((TreeNode)this.children.get(i)).mId)
      {
        this.children.remove(i);
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public List<TreeNode> getChildren()
  {
    return Collections.unmodifiableList(this.children);
  }
  
  public TreeNodeClickListener getClickListener()
  {
    return this.mClickListener;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public int getLevel()
  {
    int i = 0;
    TreeNode localTreeNode = this;
    while (localTreeNode.mParent != null)
    {
      localTreeNode = localTreeNode.mParent;
      i += 1;
    }
    return i;
  }
  
  public TreeNodeLongClickListener getLongClickListener()
  {
    return this.mLongClickListener;
  }
  
  public TreeNode getParent()
  {
    return this.mParent;
  }
  
  public String getPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this;
    while (((TreeNode)localObject).mParent != null)
    {
      localStringBuilder.append(((TreeNode)localObject).getId());
      TreeNode localTreeNode = ((TreeNode)localObject).mParent;
      localObject = localTreeNode;
      if (localTreeNode.mParent != null)
      {
        localStringBuilder.append(":");
        localObject = localTreeNode;
      }
    }
    return localStringBuilder.toString();
  }
  
  public TreeNode getRoot()
  {
    for (TreeNode localTreeNode = this; localTreeNode.mParent != null; localTreeNode = localTreeNode.mParent) {}
    return localTreeNode;
  }
  
  public Object getValue()
  {
    return this.mValue;
  }
  
  public BaseNodeViewHolder getViewHolder()
  {
    return this.mViewHolder;
  }
  
  public boolean isExpanded()
  {
    return this.mExpanded;
  }
  
  public boolean isFirstChild()
  {
    if (!isRoot()) {
      return ((TreeNode)this.mParent.children.get(0)).mId == this.mId;
    }
    return false;
  }
  
  public boolean isLastChild()
  {
    if (!isRoot())
    {
      int i = this.mParent.children.size();
      if (i > 0) {
        return ((TreeNode)this.mParent.children.get(i - 1)).mId == this.mId;
      }
    }
    return false;
  }
  
  public boolean isLeaf()
  {
    return size() == 0;
  }
  
  public boolean isRoot()
  {
    return this.mParent == null;
  }
  
  public boolean isSelectable()
  {
    return this.mSelectable;
  }
  
  public boolean isSelected()
  {
    return (this.mSelectable) && (this.mSelected);
  }
  
  public TreeNode setClickListener(TreeNodeClickListener paramTreeNodeClickListener)
  {
    this.mClickListener = paramTreeNodeClickListener;
    return this;
  }
  
  public TreeNode setExpanded(boolean paramBoolean)
  {
    this.mExpanded = paramBoolean;
    return this;
  }
  
  public TreeNode setLongClickListener(TreeNodeLongClickListener paramTreeNodeLongClickListener)
  {
    this.mLongClickListener = paramTreeNodeLongClickListener;
    return this;
  }
  
  public void setSelectable(boolean paramBoolean)
  {
    this.mSelectable = paramBoolean;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.mSelected = paramBoolean;
  }
  
  public TreeNode setViewHolder(BaseNodeViewHolder paramBaseNodeViewHolder)
  {
    this.mViewHolder = paramBaseNodeViewHolder;
    if (paramBaseNodeViewHolder != null) {
      paramBaseNodeViewHolder.mNode = this;
    }
    return this;
  }
  
  public int size()
  {
    return this.children.size();
  }
  
  public static abstract class BaseNodeViewHolder<E>
  {
    protected int containerStyle;
    protected Context context;
    protected TreeNode mNode;
    private View mView;
    protected AndroidTreeView tView;
    
    public BaseNodeViewHolder(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public abstract View createNodeView(TreeNode paramTreeNode, E paramE);
    
    public int getContainerStyle()
    {
      return this.containerStyle;
    }
    
    public ViewGroup getNodeItemsView()
    {
      return (ViewGroup)getView().findViewById(JarResource.getIdByName("id", "node_items"));
    }
    
    public View getNodeView()
    {
      return createNodeView(this.mNode, this.mNode.getValue());
    }
    
    public AndroidTreeView getTreeView()
    {
      return this.tView;
    }
    
    public View getView()
    {
      if (this.mView != null) {
        return this.mView;
      }
      View localView = getNodeView();
      TreeNodeWrapperView localTreeNodeWrapperView = new TreeNodeWrapperView(localView.getContext(), getContainerStyle());
      localTreeNodeWrapperView.insertNodeView(localView);
      this.mView = localTreeNodeWrapperView;
      return this.mView;
    }
    
    public boolean isInitialized()
    {
      return this.mView != null;
    }
    
    public void setContainerStyle(int paramInt)
    {
      this.containerStyle = paramInt;
    }
    
    public void setTreeViev(AndroidTreeView paramAndroidTreeView)
    {
      this.tView = paramAndroidTreeView;
    }
    
    public void toggle(boolean paramBoolean) {}
    
    public void toggleSelectionMode(boolean paramBoolean) {}
  }
  
  public static abstract interface TreeNodeClickListener
  {
    public abstract void onClick(TreeNode paramTreeNode, Object paramObject);
  }
  
  public static abstract interface TreeNodeLongClickListener
  {
    public abstract boolean onLongClick(TreeNode paramTreeNode, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.unnamed.b.atv.model.TreeNode
 * JD-Core Version:    0.7.0.1
 */