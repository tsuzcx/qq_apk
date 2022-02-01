package me.ele.uetool.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.base.Application;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.ItemArrayList;
import me.ele.uetool.base.item.AddMinusEditItem;
import me.ele.uetool.base.item.AddMinusEditItem.CustomAddMin;
import me.ele.uetool.base.item.BriefDescItem;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.base.item.SwitchItem;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.Util;
import me.ele.uetool.util.ViewKnife;

public class MultipleAttrsDialog
  extends ReportDialog
{
  private static final String TAG = "MultipleAttrsDialog";
  private static int clickItemNum = -1;
  private static Refresh refresh;
  private Adapter adapter = new Adapter();
  private RecyclerView.LayoutManager layoutManager = new FoucsLinearLayoutManager(getContext());
  private RecyclerView vList;
  
  public MultipleAttrsDialog(Context paramContext)
  {
    super(paramContext, JarResource.getIdByName("style", "qb_uet_Theme.Holo.Dialog.background.Translucent"));
  }
  
  public static List<Item> getAttrs(Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    View localView = paramElement.getView();
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject1 = new SwitchItem("背景色板", paramElement, 0);
      ((SwitchItem)localObject1).setCallBack(new MultipleAttrsDialog.1(localView));
      localArrayList.add(localObject1);
    }
    if ((localView instanceof TextView))
    {
      localObject1 = (TextView)localView;
      if (((TextView)localObject1).getTypeface() == null) {
        break label523;
      }
    }
    label523:
    for (boolean bool = ((TextView)localObject1).getTypeface().isBold();; bool = false)
    {
      localArrayList.add(new SwitchItem("文字加粗", paramElement, 1, bool));
      Object localObject2 = new AddMinusEditItem("字号（px）", paramElement, 2, ((TextView)localObject1).getTextSize() + "");
      ((AddMinusEditItem)localObject2).setAddMin(new MultipleAttrsDialog.2());
      localArrayList.add(localObject2);
      localArrayList.add(new EditTextItem("文字颜色", paramElement, 3, Util.intToHexColor(((TextView)localObject1).getCurrentTextColor())));
      localObject1 = ViewKnife.getMargin(paramElement);
      localArrayList.add(new AddMinusEditItem("上外边距（dp）", paramElement, 10, DimenUtil.px2dip(localObject1[1])));
      localArrayList.add(new AddMinusEditItem("左外边距（dp）", paramElement, 11, DimenUtil.px2dip(localObject1[0])));
      localArrayList.add(new AddMinusEditItem("宽（dp）", paramElement, 4, DimenUtil.px2dip(localView.getWidth())));
      localArrayList.add(new AddMinusEditItem("高（dp）", paramElement, 5, DimenUtil.px2dip(localView.getHeight())));
      localObject1 = new EditTextItem("透明度", paramElement, -1, String.valueOf(localView.getAlpha()));
      ((EditTextItem)localObject1).setCallBack(new MultipleAttrsDialog.3());
      localArrayList.add(localObject1);
      localObject2 = Util.getBackground(localView);
      if (((localObject2 instanceof String)) || (localObject2 == null))
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
        localObject1 = new EditTextItem("背景颜色", paramElement, -1, (String)localObject1);
        ((EditTextItem)localObject1).setCallBack(new MultipleAttrsDialog.4());
        localArrayList.add(localObject1);
      }
      localArrayList.add(new AddMinusEditItem("左内边距（dp）", paramElement, 6, DimenUtil.px2dip(localView.getPaddingLeft())));
      localArrayList.add(new AddMinusEditItem("右内边距（dp）", paramElement, 7, DimenUtil.px2dip(localView.getPaddingRight())));
      localArrayList.add(new AddMinusEditItem("上内边距（dp）", paramElement, 8, DimenUtil.px2dip(localView.getPaddingTop())));
      localArrayList.add(new AddMinusEditItem("下内边距（dp）", paramElement, 9, DimenUtil.px2dip(localView.getPaddingBottom())));
      return localArrayList;
    }
  }
  
  public static void setRefresh(Refresh paramRefresh)
  {
    refresh = paramRefresh;
  }
  
  public void dismiss()
  {
    super.dismiss();
    refresh = null;
  }
  
  public final void notifyItemRangeRemoved(int paramInt)
  {
    this.adapter.notifyValidViewItemRemoved(paramInt);
  }
  
  public void notifyValidViewItemInserted(int paramInt, List<Element> paramList, Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Element localElement = (Element)paramList.get(i);
      localArrayList.add(new BriefDescItem(localElement, paramElement.equals(localElement)));
      i += 1;
    }
    this.adapter.notifyValidViewItemInserted(paramInt, localArrayList);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(JarResource.getIdByName("layout", "qb_uet_dialog_attrs"));
    this.vList = ((RecyclerView)findViewById(JarResource.getIdByName("id", "list")));
    this.vList.setAdapter(this.adapter);
    this.layoutManager.setAutoMeasureEnabled(false);
    this.vList.setLayoutManager(this.layoutManager);
  }
  
  public void setCallBack(ValidCallBack paramValidCallBack)
  {
    this.adapter.setCallBack(paramValidCallBack);
  }
  
  public void show(Element paramElement, List<Element> paramList)
  {
    show();
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(51);
    localLayoutParams.width = DimenUtil.getScreenWidth();
    localLayoutParams.height = (DimenUtil.getScreenHeight() / 2);
    localWindow.setAttributes(localLayoutParams);
    this.layoutManager.scrollToPosition(0);
    this.adapter.notifyDataSetChanged(paramElement);
    this.adapter.setElementList(paramList);
  }
  
  public static class Adapter
    extends RecyclerView.Adapter
  {
    private static List<Element> elementList;
    private MultipleAttrsDialog.ValidCallBack callBack;
    private List<Item> items = new ItemArrayList();
    private List<Item> validItems = new ArrayList();
    
    protected <T extends Item> T getItem(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= this.items.size())) {
        return null;
      }
      return (Item)this.items.get(paramInt);
    }
    
    public int getItemCount()
    {
      return this.items.size();
    }
    
    public int getItemViewType(int paramInt)
    {
      Item localItem = getItem(paramInt);
      if (localItem.getClass() == EditTextItem.class) {
        return 3;
      }
      if (localItem.getClass() == SwitchItem.class) {
        return 4;
      }
      if (localItem.getClass() == AddMinusEditItem.class) {
        return 5;
      }
      if (localItem.getClass() == BriefDescItem.class) {
        return 7;
      }
      throw new RuntimeException("Unknown item type.");
    }
    
    public void notifyDataSetChanged(Element paramElement)
    {
      this.items.clear();
      try
      {
        this.items.addAll(MultipleAttrsDialog.getAttrs(paramElement));
        notifyDataSetChanged();
        return;
      }
      catch (Exception paramElement)
      {
        for (;;)
        {
          paramElement.printStackTrace();
        }
      }
    }
    
    public void notifyValidViewItemInserted(int paramInt, List<Item> paramList)
    {
      this.validItems.addAll(paramList);
      this.items.addAll(paramInt, paramList);
      notifyItemRangeInserted(paramInt, paramList.size());
    }
    
    public void notifyValidViewItemRemoved(int paramInt)
    {
      this.items.removeAll(this.validItems);
      notifyItemRangeRemoved(paramInt, this.validItems.size());
    }
    
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if (paramViewHolder.getClass() == EditTextViewHolder.class) {
        ((EditTextViewHolder)paramViewHolder).bindView((EditTextItem)getItem(paramInt));
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        if (paramViewHolder.getClass() == SwitchViewHolder.class)
        {
          ((SwitchViewHolder)paramViewHolder).bindView((SwitchItem)getItem(paramInt));
        }
        else if (paramViewHolder.getClass() == AddMinusEditViewHolder.class)
        {
          ((AddMinusEditViewHolder)paramViewHolder).bindView((AddMinusEditItem)getItem(paramInt));
          ((AddMinusEditViewHolder)paramViewHolder).setAddMin(((AddMinusEditItem)getItem(paramInt)).getAddMin());
        }
        else if (paramViewHolder.getClass() == MultipleAttrsDialog.BriefDescViewHolder.class)
        {
          ((MultipleAttrsDialog.BriefDescViewHolder)paramViewHolder).bindView((BriefDescItem)getItem(paramInt));
        }
      }
    }
    
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
      switch (paramInt)
      {
      case 6: 
      default: 
        throw new RuntimeException(paramInt + " is an unknown view type!");
      case 3: 
        return EditTextViewHolder.newInstance(paramViewGroup);
      case 4: 
        paramViewGroup = SwitchViewHolder.newInstance(paramViewGroup);
        paramViewGroup.setCallBack(this.callBack);
        return paramViewGroup;
      case 5: 
        return AddMinusEditViewHolder.newInstance(paramViewGroup);
      }
      paramViewGroup = MultipleAttrsDialog.BriefDescViewHolder.newInstance(paramViewGroup);
      paramViewGroup.setCallBack(this.callBack);
      return paramViewGroup;
    }
    
    public void setCallBack(MultipleAttrsDialog.ValidCallBack paramValidCallBack)
    {
      this.callBack = paramValidCallBack;
    }
    
    public void setElementList(List<Element> paramList)
    {
      elementList = paramList;
    }
    
    public static class AddMinusEditViewHolder
      extends MultipleAttrsDialog.Adapter.EditTextViewHolder<AddMinusEditItem>
    {
      private AddMinusEditItem.CustomAddMin addMin;
      private View vAdd;
      private View vMinus;
      
      public AddMinusEditViewHolder(View paramView)
      {
        super();
        this.vAdd = paramView.findViewById(JarResource.getIdByName("id", "add"));
        this.vMinus = paramView.findViewById(JarResource.getIdByName("id", "minus"));
        this.vAdd.setOnClickListener(new MultipleAttrsDialog.Adapter.AddMinusEditViewHolder.1(this));
        this.vMinus.setOnClickListener(new MultipleAttrsDialog.Adapter.AddMinusEditViewHolder.2(this));
      }
      
      private void allItemChange(int paramInt)
      {
        Toast.makeText(Application.getApplicationContext(), "修改值为： " + paramInt, 0).show();
        Iterator localIterator;
        Object localObject;
        if (((AddMinusEditItem)this.item).getType() == 2)
        {
          localIterator = MultipleAttrsDialog.Adapter.elementList.iterator();
          while (localIterator.hasNext())
          {
            localObject = (TextView)((Element)localIterator.next()).getView();
            float f = Float.valueOf(((TextView)localObject).getTextSize() + paramInt).floatValue();
            if (((TextView)localObject).getTextSize() != f) {
              ((TextView)localObject).setTextSize(Float.valueOf(DimenUtil.px2sp(f)).floatValue());
            }
          }
        }
        int i;
        if (((AddMinusEditItem)this.item).getType() == 4)
        {
          localIterator = MultipleAttrsDialog.Adapter.elementList.iterator();
          while (localIterator.hasNext())
          {
            localObject = ((Element)localIterator.next()).getView();
            i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getWidth()) + paramInt);
            if (Math.abs(i - ((View)localObject).getWidth()) >= ViewKnife.dip2px(1.0F))
            {
              ((View)localObject).getLayoutParams().width = i;
              ((View)localObject).requestLayout();
            }
          }
        }
        if (((AddMinusEditItem)this.item).getType() == 5)
        {
          localIterator = MultipleAttrsDialog.Adapter.elementList.iterator();
          while (localIterator.hasNext())
          {
            localObject = ((Element)localIterator.next()).getView();
            i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getHeight()) + paramInt);
            if (Math.abs(i - ((View)localObject).getHeight()) >= ViewKnife.dip2px(1.0F))
            {
              ((View)localObject).getLayoutParams().height = i;
              ((View)localObject).requestLayout();
            }
          }
        }
        if (((AddMinusEditItem)this.item).getType() == 6)
        {
          localIterator = MultipleAttrsDialog.Adapter.elementList.iterator();
          while (localIterator.hasNext())
          {
            localObject = ((Element)localIterator.next()).getView();
            i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getPaddingLeft()) + paramInt);
            if (Math.abs(i - ((View)localObject).getPaddingLeft()) >= ViewKnife.dip2px(1.0F)) {
              ((View)localObject).setPadding(i, ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
            }
          }
        }
        if (((AddMinusEditItem)this.item).getType() == 7)
        {
          localIterator = MultipleAttrsDialog.Adapter.elementList.iterator();
          while (localIterator.hasNext())
          {
            localObject = ((Element)localIterator.next()).getView();
            i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getPaddingRight()) + paramInt);
            if (Math.abs(i - ((View)localObject).getPaddingRight()) >= ViewKnife.dip2px(1.0F)) {
              ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), i, ((View)localObject).getPaddingBottom());
            }
          }
        }
        if (((AddMinusEditItem)this.item).getType() == 8)
        {
          localIterator = MultipleAttrsDialog.Adapter.elementList.iterator();
          while (localIterator.hasNext())
          {
            localObject = ((Element)localIterator.next()).getView();
            i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getPaddingTop()) + paramInt);
            if (Math.abs(i - ((View)localObject).getPaddingTop()) >= ViewKnife.dip2px(1.0F)) {
              ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), i, ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
            }
          }
        }
        if (((AddMinusEditItem)this.item).getType() == 9)
        {
          localIterator = MultipleAttrsDialog.Adapter.elementList.iterator();
          while (localIterator.hasNext())
          {
            localObject = ((Element)localIterator.next()).getView();
            i = ViewKnife.dip2px(ViewKnife.px2dip(((View)localObject).getPaddingBottom()) + paramInt);
            if (Math.abs(i - ((View)localObject).getPaddingBottom()) >= ViewKnife.dip2px(1.0F)) {
              ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), i);
            }
          }
        }
        if (((AddMinusEditItem)this.item).getType() == 10)
        {
          localIterator = MultipleAttrsDialog.Adapter.elementList.iterator();
          if (localIterator.hasNext())
          {
            localObject = ((Element)localIterator.next()).getView();
            if (((View)localObject).getTranslationY() < 0.0F) {}
            for (i = -ViewKnife.px2dip(-((View)localObject).getTranslationY());; i = ViewKnife.px2dip(((View)localObject).getTranslationY()))
            {
              i = ViewKnife.dip2px(i + paramInt);
              Log.i("MultipleAttrsDialog", "allItemChange: " + i);
              ((View)localObject).setTranslationY(i);
              break;
            }
          }
        }
        else if (((AddMinusEditItem)this.item).getType() == 11)
        {
          localIterator = MultipleAttrsDialog.Adapter.elementList.iterator();
          if (localIterator.hasNext())
          {
            localObject = ((Element)localIterator.next()).getView();
            if (((View)localObject).getTranslationX() < 0.0F) {}
            for (i = -ViewKnife.px2dip(-((View)localObject).getTranslationX());; i = ViewKnife.px2dip(((View)localObject).getTranslationX()))
            {
              i = ViewKnife.dip2px(i + paramInt);
              Log.i("MultipleAttrsDialog", "allItemChange: " + i);
              ((View)localObject).setTranslationX(i);
              break;
            }
          }
        }
      }
      
      public static AddMinusEditViewHolder newInstance(ViewGroup paramViewGroup)
      {
        return new AddMinusEditViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_add_minus_edit"), paramViewGroup, false));
      }
      
      public void bindView(AddMinusEditItem paramAddMinusEditItem)
      {
        super.bindView(paramAddMinusEditItem);
      }
      
      public void setAddMin(AddMinusEditItem.CustomAddMin paramCustomAddMin)
      {
        this.addMin = paramCustomAddMin;
      }
    }
    
    public static abstract class BaseViewHolder<T extends Item>
      extends RecyclerView.ViewHolder
    {
      protected T item;
      
      public BaseViewHolder(View paramView)
      {
        super();
      }
      
      public void bindView(T paramT)
      {
        this.item = paramT;
      }
    }
    
    public static class EditTextViewHolder<T extends EditTextItem>
      extends MultipleAttrsDialog.Adapter.BaseViewHolder<T>
    {
      protected TextWatcher textWatcher = new MultipleAttrsDialog.Adapter.EditTextViewHolder.1(this);
      @Nullable
      private View vColor;
      protected EditText vDetail;
      protected TextView vName;
      
      public EditTextViewHolder(View paramView)
      {
        super();
        this.vName = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "name")));
        this.vDetail = ((EditText)paramView.findViewById(JarResource.getIdByName("id", "detail")));
        this.vColor = paramView.findViewById(JarResource.getIdByName("id", "color"));
        if (this.vColor != null) {
          this.vColor.setOnClickListener(new MultipleAttrsDialog.Adapter.EditTextViewHolder.2(this, paramView));
        }
        this.vDetail.addTextChangedListener(this.textWatcher);
        paramView.setOnClickListener(new MultipleAttrsDialog.Adapter.EditTextViewHolder.3(this));
        this.vDetail.setOnFocusChangeListener(new MultipleAttrsDialog.Adapter.EditTextViewHolder.4(this));
        paramView.setOnClickListener(new MultipleAttrsDialog.Adapter.EditTextViewHolder.5(this));
      }
      
      public static EditTextViewHolder newInstance(ViewGroup paramViewGroup)
      {
        return new EditTextViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_edit_text"), paramViewGroup, false));
      }
      
      public void bindView(T paramT)
      {
        super.bindView(paramT);
        this.vName.setText(paramT.getName());
        this.vDetail.setText(paramT.getDetail());
        if (this.vColor != null) {}
        try
        {
          this.vColor.setBackgroundColor(Color.parseColor(paramT.getDetail()));
          this.vColor.setVisibility(0);
          return;
        }
        catch (Exception paramT)
        {
          this.vColor.setVisibility(8);
        }
      }
    }
    
    public static class SwitchViewHolder
      extends MultipleAttrsDialog.Adapter.BaseViewHolder<SwitchItem>
    {
      private MultipleAttrsDialog.ValidCallBack callBack;
      private TextView vName;
      private Switch vSwitch;
      
      public SwitchViewHolder(View paramView)
      {
        super();
        this.vName = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "name")));
        this.vSwitch = ((Switch)paramView.findViewById(JarResource.getIdByName("id", "switch_view")));
        this.vSwitch.setOnCheckedChangeListener(new MultipleAttrsDialog.Adapter.SwitchViewHolder.1(this, paramView));
      }
      
      public static SwitchViewHolder newInstance(ViewGroup paramViewGroup)
      {
        return new SwitchViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_switch"), paramViewGroup, false));
      }
      
      public void bindView(SwitchItem paramSwitchItem)
      {
        super.bindView(paramSwitchItem);
        this.vName.setText(paramSwitchItem.getName());
        this.vSwitch.setChecked(paramSwitchItem.isChecked());
      }
      
      public void setCallBack(MultipleAttrsDialog.ValidCallBack paramValidCallBack)
      {
        this.callBack = paramValidCallBack;
      }
    }
  }
  
  public static class BriefDescViewHolder
    extends MultipleAttrsDialog.Adapter.BaseViewHolder<BriefDescItem>
  {
    private MultipleAttrsDialog.ValidCallBack callBack;
    private TextView vDesc;
    
    public BriefDescViewHolder(View paramView)
    {
      super();
      this.vDesc = ((TextView)paramView);
      this.vDesc.setOnClickListener(new MultipleAttrsDialog.BriefDescViewHolder.1(this));
    }
    
    public static BriefDescViewHolder newInstance(ViewGroup paramViewGroup)
    {
      return new BriefDescViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_brief_view_desc"), paramViewGroup, false));
    }
    
    public void bindView(BriefDescItem paramBriefDescItem)
    {
      super.bindView(paramBriefDescItem);
      Object localObject = paramBriefDescItem.getElement().getView();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject.getClass().getName());
      localObject = Util.getResourceName(((View)localObject).getId());
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localStringBuilder.append("@").append((String)localObject);
      }
      this.vDesc.setText(localStringBuilder.toString());
      this.vDesc.setSelected(paramBriefDescItem.isSelected());
    }
    
    public void setCallBack(MultipleAttrsDialog.ValidCallBack paramValidCallBack)
    {
      this.callBack = paramValidCallBack;
    }
  }
  
  class FoucsLinearLayoutManager
    extends LinearLayoutManager
  {
    public FoucsLinearLayoutManager(Context paramContext)
    {
      super();
    }
    
    public FoucsLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
    {
      super(paramInt, paramBoolean);
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
    {
      return false;
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
    {
      return false;
    }
  }
  
  public static abstract interface Refresh
  {
    public abstract void refresh();
  }
  
  public static abstract interface ValidCallBack
  {
    public abstract void selectView(Element paramElement);
    
    public abstract void validView(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog
 * JD-Core Version:    0.7.0.1
 */