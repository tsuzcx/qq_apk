package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;
import java.util.List;

public class QMToggleView
  extends FrameLayout
{
  public static final String ACCOUNT_TOGGLEVIEW_HIDE = "accounttoggleviewhide";
  public static final String ACCOUNT_TOGGLEVIEW_SHOW = "accounttoggleviewshow";
  private static final float MASK_ALPHA = 1.0F;
  private static final String TAG = QMToggleView.class.getSimpleName();
  private QMToggleViewAdapter adapter;
  private boolean animating;
  private FrameLayout contentLL;
  protected int duration_fade;
  protected int duration_slide;
  private boolean hidden;
  private ListView listView;
  private Context mContext;
  private View maskView;
  private QMToggleViewCallback toggleViewCallback;
  
  public QMToggleView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public QMToggleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.duration_fade = getResources().getInteger(17694721);
    this.duration_slide = getResources().getInteger(17694721);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QMToggleView);
    this.duration_fade = paramContext.getInteger(R.styleable.QMToggleView_duration_fade, this.duration_fade);
    this.duration_slide = paramContext.getInteger(R.styleable.QMToggleView_duration_slide, this.duration_slide);
    paramContext.recycle();
  }
  
  private Animation getFadeAnimaiton(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);; localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F))
    {
      localAlphaAnimation.setDuration(this.duration_fade);
      localAlphaAnimation.setFillEnabled(true);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new QMToggleView.4(this, paramBoolean));
      return localAlphaAnimation;
    }
  }
  
  private Animation getSlideAnimAnimaiton(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.contentLL.getHeight(), 0.0F);; localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.contentLL.getHeight()))
    {
      localTranslateAnimation.setDuration(this.duration_slide);
      localTranslateAnimation.setFillEnabled(true);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setAnimationListener(new QMToggleView.3(this));
      return localTranslateAnimation;
    }
  }
  
  private void initEvents()
  {
    setOnClickListener(new QMToggleView.1(this));
    this.listView.setOnItemClickListener(new QMToggleView.2(this));
  }
  
  public int getSelectedRow()
  {
    return this.adapter.getSelectedRow();
  }
  
  public QMToggleViewCallback getToggleViewCallback()
  {
    return this.toggleViewCallback;
  }
  
  public void hide()
  {
    if ((this.hidden) || (this.animating)) {
      return;
    }
    this.contentLL.startAnimation(getSlideAnimAnimaiton(false));
    this.maskView.startAnimation(getFadeAnimaiton(false));
  }
  
  public void init()
  {
    this.maskView = findViewById(2131374721);
    this.contentLL = ((FrameLayout)findViewById(2131374716));
    this.listView = ((ListView)findViewById(2131374720));
    this.adapter = new QMToggleViewAdapter(getContext());
    this.listView.setAdapter(this.adapter);
    this.hidden = true;
    this.animating = false;
    initEvents();
  }
  
  public boolean isAnimating()
  {
    return this.animating;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public void reverseVisibility()
  {
    if (this.hidden)
    {
      show();
      return;
    }
    hide();
  }
  
  public void setData(String... paramVarArgs)
  {
    ValidateHelper.notNull(paramVarArgs);
    this.adapter.setData(paramVarArgs);
    if (paramVarArgs.length > 6)
    {
      paramVarArgs = (FrameLayout.LayoutParams)this.listView.getLayoutParams();
      paramVarArgs.height = getResources().getDimensionPixelSize(2131299655);
      this.listView.setLayoutParams(paramVarArgs);
      return;
    }
    paramVarArgs = (FrameLayout.LayoutParams)this.listView.getLayoutParams();
    paramVarArgs.height = -2;
    this.listView.setLayoutParams(paramVarArgs);
  }
  
  public void setData(String[] paramArrayOfString, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean)
  {
    ValidateHelper.notNull(paramArrayOfString);
    ValidateHelper.notNull(paramArrayOfInt);
    this.adapter.setDataAndRightData(paramArrayOfString, paramArrayOfInt, paramArrayOfBoolean);
    if (paramArrayOfString.length > 6)
    {
      paramArrayOfString = (FrameLayout.LayoutParams)this.listView.getLayoutParams();
      paramArrayOfString.height = getResources().getDimensionPixelSize(2131299655);
      this.listView.setLayoutParams(paramArrayOfString);
      return;
    }
    paramArrayOfString = (FrameLayout.LayoutParams)this.listView.getLayoutParams();
    paramArrayOfString.height = -2;
    this.listView.setLayoutParams(paramArrayOfString);
  }
  
  public void setSelectedRow(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.adapter.getCount())) {}
    do
    {
      return;
      this.adapter.setSelectedRow(paramInt);
    } while (this.adapter.selectedRow < 0);
    this.listView.setSelection(this.adapter.selectedRow);
  }
  
  public void setSelectedRow(String paramString)
  {
    this.adapter.setSelectedRow(paramString);
    if (this.adapter.selectedRow > 0) {
      this.listView.setSelection(this.adapter.selectedRow);
    }
  }
  
  public void setToggleViewCallback(QMToggleViewCallback paramQMToggleViewCallback)
  {
    this.toggleViewCallback = paramQMToggleViewCallback;
  }
  
  public void show()
  {
    if ((!this.hidden) || (this.animating)) {
      return;
    }
    setVisibility(0);
    this.maskView.setVisibility(4);
    this.contentLL.startAnimation(getSlideAnimAnimaiton(true));
    this.maskView.startAnimation(getFadeAnimaiton(true));
  }
  
  static class QMToggleViewAdapter
    extends BaseAdapter
  {
    private Context context;
    private final ArrayList<String> data;
    private int selectedRow;
    private final ArrayList<Integer> unreadCount;
    private final ArrayList<Boolean> unreadCountHighlight;
    
    public QMToggleViewAdapter(Context paramContext)
    {
      this.context = paramContext;
      this.data = new ArrayList();
      this.unreadCount = new ArrayList();
      this.unreadCountHighlight = new ArrayList();
      this.selectedRow = -1;
    }
    
    public int getCount()
    {
      return this.data.size();
    }
    
    public List<String> getData()
    {
      return this.data;
    }
    
    public String getItem(int paramInt)
    {
      return (String)this.data.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getSelectedRow()
    {
      return this.selectedRow;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      boolean bool;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        localView = View.inflate(this.context, 2131561146, null);
        paramView = new ViewHolder(null);
        paramView.selectCB = ((CheckBox)localView.findViewById(2131374717));
        paramView.titleTV = ((TextView)localView.findViewById(2131374719));
        paramView.rightTV = ((TextView)localView.findViewById(2131374718));
        localView.setTag(paramView);
        localObject = getItem(paramInt);
        CheckBox localCheckBox = paramView.selectCB;
        if (this.selectedRow != paramInt) {
          break label297;
        }
        bool = true;
        label104:
        localCheckBox.setChecked(bool);
        paramView.titleTV.setText((CharSequence)localObject);
        if (!((String)localObject).equals(this.context.getString(2131720427))) {
          break label303;
        }
        paramView.titleTV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130840991, 0);
        paramView.titleTV.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 0.0F));
        label168:
        if (this.unreadCount.size() > paramInt)
        {
          int i = ((Integer)this.unreadCount.get(paramInt)).intValue();
          if (i <= 0) {
            break label329;
          }
          paramView.rightTV.setText("" + i);
          if (!((Boolean)this.unreadCountHighlight.get(paramInt)).booleanValue()) {
            break label317;
          }
          paramView.rightTV.setBackgroundResource(2130850576);
          label253:
          paramView.rightTV.setVisibility(0);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (ViewHolder)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label297:
        bool = false;
        break label104;
        label303:
        paramView.titleTV.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label168;
        label317:
        paramView.rightTV.setBackgroundResource(2130850574);
        break label253;
        label329:
        paramView.rightTV.setVisibility(8);
      }
    }
    
    public void setData(String[] paramArrayOfString)
    {
      this.data.clear();
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        this.data.add(str);
        i += 1;
      }
      notifyDataSetChanged();
    }
    
    public void setDataAndRightData(String[] paramArrayOfString, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean)
    {
      int j = 0;
      if ((paramArrayOfString.length != paramArrayOfInt.length) || (paramArrayOfString.length != paramArrayOfBoolean.length)) {
        throw new IllegalArgumentException("setDataAndRightData: " + paramArrayOfString.length + ", " + paramArrayOfInt.length + ", " + paramArrayOfBoolean.length);
      }
      this.data.clear();
      int k = paramArrayOfString.length;
      int i = 0;
      while (i < k)
      {
        String str = paramArrayOfString[i];
        this.data.add(str);
        i += 1;
      }
      this.unreadCount.clear();
      k = paramArrayOfInt.length;
      i = 0;
      while (i < k)
      {
        int m = paramArrayOfInt[i];
        this.unreadCount.add(Integer.valueOf(m));
        i += 1;
      }
      this.unreadCountHighlight.clear();
      k = paramArrayOfBoolean.length;
      i = j;
      while (i < k)
      {
        int n = paramArrayOfBoolean[i];
        this.unreadCountHighlight.add(Boolean.valueOf(n));
        i += 1;
      }
      notifyDataSetChanged();
    }
    
    public void setSelectedRow(int paramInt)
    {
      this.selectedRow = paramInt;
      notifyDataSetChanged();
    }
    
    public void setSelectedRow(String paramString)
    {
      paramString = paramString.replaceAll(this.context.getString(2131721223), "");
      int i = this.data.indexOf(paramString);
      if (i >= 0)
      {
        this.selectedRow = i;
        notifyDataSetChanged();
      }
    }
    
    static class ViewHolder
    {
      TextView rightTV;
      CheckBox selectCB;
      TextView titleTV;
    }
  }
  
  public static abstract interface QMToggleViewCallback
  {
    public abstract void didDismiss(QMToggleView paramQMToggleView);
    
    public abstract void onDismiss(QMToggleView paramQMToggleView);
    
    public abstract void onShow(QMToggleView paramQMToggleView);
    
    public abstract boolean willSelectRow(QMToggleView paramQMToggleView, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMToggleView
 * JD-Core Version:    0.7.0.1
 */