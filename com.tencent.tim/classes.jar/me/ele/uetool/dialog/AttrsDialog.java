package me.ele.uetool.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.ele.uetool.UETool;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.IAttrs;
import me.ele.uetool.base.ItemArrayList;
import me.ele.uetool.base.item.AddMinusEditItem;
import me.ele.uetool.base.item.AddMinusEditItem.CustomAddMin;
import me.ele.uetool.base.item.BitmapItem;
import me.ele.uetool.base.item.BriefDescItem;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.base.item.SwitchItem;
import me.ele.uetool.base.item.TextItem;
import me.ele.uetool.base.item.TitleItem;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.Util;

public class AttrsDialog
  extends ReportDialog
{
  private static Context context;
  private static Refresh refresh;
  private Adapter adapter = new Adapter();
  private RecyclerView.LayoutManager layoutManager = new FoucsLinearLayoutManager(getContext(), 1, false);
  private AttrDialogTouchCallback touchCallback;
  private RecyclerView vList;
  
  public AttrsDialog(Context paramContext)
  {
    super(paramContext, JarResource.getIdByName("style", "qb_uet_Theme.Holo.Dialog.background.Translucent"));
  }
  
  public static void setContext(Context paramContext)
  {
    context = paramContext;
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
  
  public void notifyReasonItemInserted(int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new TextItem("", (String)paramList.get(i)));
      i += 1;
    }
    this.adapter.notifyValidViewItemInserted(paramInt, localArrayList);
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
    this.adapter.setHasStableIds(true);
    this.vList.setItemAnimator(null);
    this.vList.setAdapter(this.adapter);
    this.layoutManager.setAutoMeasureEnabled(false);
    this.vList.setLayoutManager(this.layoutManager);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    cancel();
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.touchCallback.touch(f1, f2);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAttrDialogCallback(AttrDialogCallback paramAttrDialogCallback)
  {
    this.adapter.setAttrDialogCallback(paramAttrDialogCallback);
  }
  
  public void setTouchCallback(AttrDialogTouchCallback paramAttrDialogTouchCallback)
  {
    this.touchCallback = paramAttrDialogTouchCallback;
  }
  
  public void show(Element paramElement)
  {
    show();
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(51);
    localLayoutParams.x = paramElement.getRect().left;
    if (DimenUtil.getScreenHeight() / 2 < paramElement.getRect().centerY()) {}
    for (int i = 0;; i = DimenUtil.getScreenHeight())
    {
      localLayoutParams.y = i;
      localLayoutParams.width = DimenUtil.getScreenWidth();
      localLayoutParams.height = (DimenUtil.getScreenHeight() / 2);
      localWindow.setAttributes(localLayoutParams);
      this.adapter.notifyDataSetChanged(paramElement);
      this.layoutManager.scrollToPosition(0);
      return;
    }
  }
  
  public static class Adapter
    extends RecyclerView.Adapter
  {
    private AttrsDialog.AttrDialogCallback callback;
    private List<Item> items = new ItemArrayList();
    private List<Item> validItems = new ArrayList();
    
    @Nullable
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
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      Item localItem = getItem(paramInt);
      if (localItem.getClass() == TitleItem.class) {
        return 1;
      }
      if (localItem.getClass() == TextItem.class) {
        return 2;
      }
      if (localItem.getClass() == EditTextItem.class) {
        return 3;
      }
      if (localItem.getClass() == SwitchItem.class) {
        return 4;
      }
      if (localItem.getClass() == AddMinusEditItem.class) {
        return 5;
      }
      if (localItem.getClass() == BitmapItem.class) {
        return 6;
      }
      if (localItem.getClass() == BriefDescItem.class) {
        return 7;
      }
      throw new RuntimeException("Unknown item type.");
    }
    
    public void notifyDataSetChanged(Element paramElement)
    {
      this.items.clear();
      Iterator localIterator = UETool.getInstance().getAttrsProvider().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        try
        {
          localObject = (IAttrs)Class.forName((String)localObject).newInstance();
          this.items.addAll(((IAttrs)localObject).getAttrs(paramElement));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      notifyDataSetChanged();
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
      if (paramViewHolder.getClass() == TitleViewHolder.class) {
        ((TitleViewHolder)paramViewHolder).bindView((TitleItem)getItem(paramInt));
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        if (paramViewHolder.getClass() == TextViewHolder.class)
        {
          ((TextViewHolder)paramViewHolder).bindView((TextItem)getItem(paramInt));
        }
        else if (paramViewHolder.getClass() == EditTextViewHolder.class)
        {
          ((EditTextViewHolder)paramViewHolder).bindView((EditTextItem)getItem(paramInt));
        }
        else if (paramViewHolder.getClass() == SwitchViewHolder.class)
        {
          ((SwitchViewHolder)paramViewHolder).bindView((SwitchItem)getItem(paramInt));
        }
        else if (paramViewHolder.getClass() == AddMinusEditViewHolder.class)
        {
          ((AddMinusEditViewHolder)paramViewHolder).bindView((AddMinusEditItem)getItem(paramInt));
          ((AddMinusEditViewHolder)paramViewHolder).setAddMin(((AddMinusEditItem)getItem(paramInt)).getAddMin());
        }
        else if (paramViewHolder.getClass() == BitmapInfoViewHolder.class)
        {
          ((BitmapInfoViewHolder)paramViewHolder).bindView((BitmapItem)getItem(paramInt));
        }
        else if (paramViewHolder.getClass() == BriefDescViewHolder.class)
        {
          ((BriefDescViewHolder)paramViewHolder).bindView((BriefDescItem)getItem(paramInt));
        }
      }
    }
    
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new RuntimeException(paramInt + " is an unknown view type!");
      case 1: 
        paramViewGroup = TitleViewHolder.newInstance(paramViewGroup);
        paramViewGroup.setIsRecyclable(false);
        return paramViewGroup;
      case 2: 
        paramViewGroup = TextViewHolder.newInstance(paramViewGroup);
        paramViewGroup.setIsRecyclable(false);
        return paramViewGroup;
      case 3: 
        paramViewGroup = EditTextViewHolder.newInstance(paramViewGroup);
        paramViewGroup.setIsRecyclable(false);
        return paramViewGroup;
      case 4: 
        paramViewGroup = SwitchViewHolder.newInstance(paramViewGroup, this.callback);
        paramViewGroup.setIsRecyclable(false);
        return paramViewGroup;
      case 5: 
        paramViewGroup = AddMinusEditViewHolder.newInstance(paramViewGroup);
        paramViewGroup.setIsRecyclable(false);
        return paramViewGroup;
      case 6: 
        paramViewGroup = BitmapInfoViewHolder.newInstance(paramViewGroup);
        paramViewGroup.setIsRecyclable(false);
        return paramViewGroup;
      }
      paramViewGroup = BriefDescViewHolder.newInstance(paramViewGroup, this.callback);
      paramViewGroup.setIsRecyclable(false);
      return paramViewGroup;
    }
    
    public void setAttrDialogCallback(AttrsDialog.AttrDialogCallback paramAttrDialogCallback)
    {
      this.callback = paramAttrDialogCallback;
    }
    
    public static class AddMinusEditViewHolder
      extends AttrsDialog.Adapter.EditTextViewHolder<AddMinusEditItem>
    {
      private AddMinusEditItem.CustomAddMin addMin;
      private View vAdd;
      private View vMinus;
      
      public AddMinusEditViewHolder(View paramView)
      {
        super();
        this.vAdd = paramView.findViewById(JarResource.getIdByName("id", "add"));
        this.vMinus = paramView.findViewById(JarResource.getIdByName("id", "minus"));
        this.vAdd.setOnClickListener(new AttrsDialog.Adapter.AddMinusEditViewHolder.1(this));
        this.vMinus.setOnClickListener(new AttrsDialog.Adapter.AddMinusEditViewHolder.2(this));
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
    
    public static class BitmapInfoViewHolder
      extends AttrsDialog.Adapter.BaseViewHolder<BitmapItem>
    {
      private final int imageHeight = DimenUtil.dip2px(58.0F);
      private ImageView vImage;
      private TextView vInfo;
      private TextView vName;
      
      public BitmapInfoViewHolder(View paramView)
      {
        super();
        this.vName = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "name")));
        this.vImage = ((ImageView)paramView.findViewById(JarResource.getIdByName("id", "image")));
        this.vInfo = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "info")));
      }
      
      public static BitmapInfoViewHolder newInstance(ViewGroup paramViewGroup)
      {
        return new BitmapInfoViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_bitmap_info"), paramViewGroup, false));
      }
      
      public void bindView(BitmapItem paramBitmapItem)
      {
        super.bindView(paramBitmapItem);
        this.vName.setText(paramBitmapItem.getName());
        paramBitmapItem = paramBitmapItem.getBitmap();
        int i = Math.min(paramBitmapItem.getHeight(), this.imageHeight);
        int j = (int)(i / paramBitmapItem.getHeight() * paramBitmapItem.getWidth());
        ViewGroup.LayoutParams localLayoutParams = this.vImage.getLayoutParams();
        localLayoutParams.width = j;
        localLayoutParams.height = i;
        this.vImage.setImageBitmap(paramBitmapItem);
        this.vInfo.setText(paramBitmapItem.getWidth() + "px*" + paramBitmapItem.getHeight() + "px");
      }
    }
    
    public static class BriefDescViewHolder
      extends AttrsDialog.Adapter.BaseViewHolder<BriefDescItem>
    {
      private TextView vDesc;
      
      public BriefDescViewHolder(View paramView, AttrsDialog.AttrDialogCallback paramAttrDialogCallback)
      {
        super();
        this.vDesc = ((TextView)paramView);
        this.vDesc.setOnClickListener(new AttrsDialog.Adapter.BriefDescViewHolder.1(this, paramAttrDialogCallback));
      }
      
      public static BriefDescViewHolder newInstance(ViewGroup paramViewGroup, AttrsDialog.AttrDialogCallback paramAttrDialogCallback)
      {
        return new BriefDescViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_brief_view_desc"), paramViewGroup, false), paramAttrDialogCallback);
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
    }
    
    public static class EditTextViewHolder<T extends EditTextItem>
      extends AttrsDialog.Adapter.BaseViewHolder<T>
    {
      protected TextWatcher textWatcher = new AttrsDialog.Adapter.EditTextViewHolder.1(this);
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
          this.vColor.setOnClickListener(new AttrsDialog.Adapter.EditTextViewHolder.2(this, paramView));
        }
        this.vDetail.addTextChangedListener(this.textWatcher);
        paramView.setOnClickListener(new AttrsDialog.Adapter.EditTextViewHolder.3(this));
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
      extends AttrsDialog.Adapter.BaseViewHolder<SwitchItem>
    {
      private TextView vName;
      private Switch vSwitch;
      
      public SwitchViewHolder(View paramView, AttrsDialog.AttrDialogCallback paramAttrDialogCallback)
      {
        super();
        this.vName = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "name")));
        this.vSwitch = ((Switch)paramView.findViewById(JarResource.getIdByName("id", "switch_view")));
        this.vSwitch.setOnCheckedChangeListener(new AttrsDialog.Adapter.SwitchViewHolder.1(this, paramView, paramAttrDialogCallback));
      }
      
      public static SwitchViewHolder newInstance(ViewGroup paramViewGroup, AttrsDialog.AttrDialogCallback paramAttrDialogCallback)
      {
        return new SwitchViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_switch"), paramViewGroup, false), paramAttrDialogCallback);
      }
      
      public void bindView(SwitchItem paramSwitchItem)
      {
        super.bindView(paramSwitchItem);
        this.vName.setText(paramSwitchItem.getName());
        this.vSwitch.setChecked(paramSwitchItem.isChecked());
      }
      
      public static abstract interface AfterColorChange
      {
        public abstract void afterColorChange(int paramInt);
      }
    }
    
    public static class TextViewHolder
      extends AttrsDialog.Adapter.BaseViewHolder<TextItem>
    {
      private TextView vDetail;
      private TextView vName;
      
      public TextViewHolder(View paramView)
      {
        super();
        this.vName = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "name")));
        this.vDetail = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "detail")));
      }
      
      public static TextViewHolder newInstance(ViewGroup paramViewGroup)
      {
        return new TextViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_text"), paramViewGroup, false));
      }
      
      public void bindView(TextItem paramTextItem)
      {
        super.bindView(paramTextItem);
        this.vName.setText(paramTextItem.getName());
        String str = paramTextItem.getDetail();
        if (paramTextItem.getOnClickListener() != null)
        {
          this.vDetail.setText(Html.fromHtml("<u>" + str + "</u>"));
          this.vDetail.setOnClickListener(paramTextItem.getOnClickListener());
        }
        do
        {
          return;
          this.vDetail.setText(str);
        } while (!paramTextItem.isEnableCopy());
        this.vDetail.setOnClickListener(new AttrsDialog.Adapter.TextViewHolder.1(this, str));
      }
    }
    
    public static class TitleViewHolder
      extends AttrsDialog.Adapter.BaseViewHolder<TitleItem>
    {
      private TextView vTitle;
      
      public TitleViewHolder(View paramView)
      {
        super();
        this.vTitle = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "title")));
      }
      
      public static TitleViewHolder newInstance(ViewGroup paramViewGroup)
      {
        return new TitleViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_title"), paramViewGroup, false));
      }
      
      public void bindView(TitleItem paramTitleItem)
      {
        super.bindView(paramTitleItem);
        this.vTitle.setText(paramTitleItem.getName());
      }
    }
  }
  
  public static abstract interface AttrDialogCallback
  {
    public abstract void enableMove();
    
    public abstract void selectMultipleView();
    
    public abstract void selectView(Element paramElement);
    
    public abstract void showReason(int paramInt, boolean paramBoolean);
    
    public abstract void showValidViews(int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface AttrDialogTouchCallback
  {
    public abstract void touch(float paramFloat1, float paramFloat2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog
 * JD-Core Version:    0.7.0.1
 */