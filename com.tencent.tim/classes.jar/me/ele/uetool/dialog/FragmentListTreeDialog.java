package me.ele.uetool.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.model.TreeNode.BaseNodeViewHolder;
import com.unnamed.b.atv.view.AndroidTreeView;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.Provider;
import me.ele.uetool.UETool;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.view.RegionView;

public class FragmentListTreeDialog
  extends ReportDialog
  implements Provider
{
  private ViewGroup containerView;
  private RegionView regionView;
  
  public FragmentListTreeDialog(Context paramContext)
  {
    super(paramContext);
    requestWindowFeature(1);
  }
  
  private void createTree(boolean paramBoolean)
  {
    Object localObject = TreeNode.root();
    Activity localActivity = UETool.getInstance().getTargetActivity();
    if ((localActivity instanceof FragmentActivity)) {
      createTreeNode((TreeNode)localObject, ((FragmentActivity)localActivity).getSupportFragmentManager(), paramBoolean);
    }
    this.containerView.removeAllViews();
    localObject = new AndroidTreeView(getContext(), (TreeNode)localObject);
    ((AndroidTreeView)localObject).setDefaultAnimation(true);
    ((AndroidTreeView)localObject).setUse2dScroll(true);
    ((AndroidTreeView)localObject).setDefaultContainerStyle(JarResource.getIdByName("style", "qb_uet_TreeNodeStyleCustom"));
    this.containerView.addView(((AndroidTreeView)localObject).getView());
    ((AndroidTreeView)localObject).expandAll();
  }
  
  private TreeNode createTreeNode(TreeNode paramTreeNode, FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    if (paramFragmentManager.getFragments() == null)
    {
      paramFragmentManager = null;
      return paramFragmentManager;
    }
    Iterator localIterator = paramFragmentManager.getFragments().iterator();
    for (;;)
    {
      paramFragmentManager = paramTreeNode;
      if (!localIterator.hasNext()) {
        break;
      }
      paramFragmentManager = (Fragment)localIterator.next();
      paramTreeNode.addChild(createTreeNode(new TreeNode(new TreeItem(paramFragmentManager, paramBoolean)).setViewHolder(new TreeItemVH(getContext(), this)), paramFragmentManager.getChildFragmentManager(), paramBoolean));
    }
  }
  
  public void onClickTreeItem(RectF paramRectF)
  {
    this.regionView.drawRegion(paramRectF);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    getWindow().addFlags(-2147483648);
    super.onCreate(paramBundle);
    setContentView(JarResource.getIdByName("layout", "qb_uet_dialog_fragment_list_tree"));
    this.containerView = ((ViewGroup)findViewById(JarResource.getIdByName("id", "container")));
    this.regionView = ((RegionView)findViewById(JarResource.getIdByName("id", "region")));
    paramBundle = (CheckBox)findViewById(JarResource.getIdByName("id", "checkbox"));
    createTree(paramBundle.isChecked());
    paramBundle.setOnCheckedChangeListener(new FragmentListTreeDialog.1(this));
  }
  
  protected void onStart()
  {
    super.onStart();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().setLayout(-1, -1);
  }
  
  public static class TreeItem
  {
    public String name;
    public RectF rectF;
    
    public TreeItem(Fragment paramFragment, boolean paramBoolean)
    {
      initName(paramFragment, paramBoolean);
      initRect(paramFragment);
    }
    
    private void initName(Fragment paramFragment, boolean paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramBoolean) {}
      for (String str = paramFragment.getClass().getName();; str = paramFragment.getClass().getSimpleName())
      {
        localStringBuilder.append(str);
        localStringBuilder.append("[visible=").append(paramFragment.isVisible()).append(", hashCode=").append(paramFragment.hashCode()).append("]");
        this.name = localStringBuilder.toString();
        if (paramFragment.isVisible()) {
          this.name = ("<u>" + this.name + "</u>");
        }
        return;
      }
    }
    
    private void initRect(Fragment paramFragment)
    {
      if (paramFragment.isVisible())
      {
        paramFragment = paramFragment.getView();
        int[] arrayOfInt = new int[2];
        paramFragment.getLocationOnScreen(arrayOfInt);
        float f1 = arrayOfInt[0];
        float f2 = arrayOfInt[1];
        float f3 = arrayOfInt[0] + paramFragment.getWidth();
        int i = arrayOfInt[1];
        this.rectF = new RectF(f1, f2, f3, paramFragment.getHeight() + i);
      }
    }
  }
  
  public static class TreeItemVH
    extends TreeNode.BaseNodeViewHolder<FragmentListTreeDialog.TreeItem>
  {
    private ImageView arrowView;
    private TextView nameView;
    private Provider provider;
    
    public TreeItemVH(Context paramContext, Provider paramProvider)
    {
      super();
      this.provider = paramProvider;
    }
    
    public View createNodeView(TreeNode paramTreeNode, FragmentListTreeDialog.TreeItem paramTreeItem)
    {
      paramTreeNode = LayoutInflater.from(this.context).inflate(JarResource.getIdByName("layout", "qb_uet_cell_tree"), null, false);
      this.nameView = ((TextView)paramTreeNode.findViewById(JarResource.getIdByName("id", "name")));
      this.arrowView = ((ImageView)paramTreeNode.findViewById(JarResource.getIdByName("id", "arrow")));
      this.nameView.setText(Html.fromHtml(paramTreeItem.name));
      if (paramTreeItem.rectF != null) {
        this.nameView.setOnClickListener(new FragmentListTreeDialog.TreeItemVH.1(this, paramTreeItem));
      }
      return paramTreeNode;
    }
    
    public void toggle(boolean paramBoolean)
    {
      super.toggle(paramBoolean);
      ViewPropertyAnimator localViewPropertyAnimator = this.arrowView.animate().setDuration(200L);
      if (paramBoolean) {}
      for (float f = 90.0F;; f = 0.0F)
      {
        localViewPropertyAnimator.rotation(f).start();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.dialog.FragmentListTreeDialog
 * JD-Core Version:    0.7.0.1
 */