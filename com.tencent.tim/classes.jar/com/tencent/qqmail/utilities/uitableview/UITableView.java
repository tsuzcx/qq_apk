package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UITableView
  extends LinearLayout
{
  private final LinearLayout.LayoutParams itemLayoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297616));
  private View mAccessorialView;
  private TextView mCaptionView;
  private ClickListener mClickListener;
  private TextView mDescriptionView;
  private List<UITableItemView> mItemList = new ArrayList();
  private LongClickListener mLongClickListener;
  
  public UITableView(Context paramContext)
  {
    this(paramContext, null);
    setOrientation(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(0, getResources().getDimensionPixelSize(2131299376), 0, getResources().getDimensionPixelSize(2131299375));
    setLayoutParams(paramContext);
  }
  
  public UITableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
  }
  
  private void addEventListener(UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView.isEnabled())
    {
      if (paramUITableItemView.hasCheckBox) {
        break label53;
      }
      if (this.mClickListener != null) {
        paramUITableItemView.setOnClickListener(new UITableView.1(this));
      }
      if (this.mLongClickListener != null) {
        paramUITableItemView.setOnLongClickListener(new UITableView.2(this));
      }
    }
    label53:
    while (this.mClickListener == null) {
      return;
    }
    paramUITableItemView.getChildAt(1).setOnClickListener(new UITableView.3(this));
    QMUIKit.expendTouchArea(paramUITableItemView.getChildAt(1));
  }
  
  private void commitTableItem(UITableItemView paramUITableItemView)
  {
    paramUITableItemView.setPadding(getResources().getDimensionPixelSize(2131299391), 0, getResources().getDimensionPixelSize(2131299392), 0);
    paramUITableItemView.drawViews();
    ViewGroup.LayoutParams localLayoutParams = paramUITableItemView.getLayoutParams();
    if (localLayoutParams != null) {
      addView(paramUITableItemView, localLayoutParams);
    }
    for (;;)
    {
      addEventListener(paramUITableItemView);
      return;
      addView(paramUITableItemView, this.itemLayoutParams);
    }
  }
  
  private int getIndex(View paramView)
  {
    return indexOfChild(paramView);
  }
  
  public UITableFormItemView addFormItem(int paramInt)
  {
    return addFormItem(new UITableFormItemView(getContext(), getContext().getString(paramInt)));
  }
  
  public UITableFormItemView addFormItem(UITableFormItemView paramUITableFormItemView)
  {
    this.mItemList.add(paramUITableFormItemView);
    return paramUITableFormItemView;
  }
  
  public UITableItemView addItem(int paramInt)
  {
    return addItem(getResources().getString(paramInt));
  }
  
  public UITableItemView addItem(UITableItemView paramUITableItemView)
  {
    this.mItemList.add(paramUITableItemView);
    return paramUITableItemView;
  }
  
  public UITableItemView addItem(String paramString)
  {
    paramString = new UITableItemView(getContext(), paramString);
    this.mItemList.add(paramString);
    return paramString;
  }
  
  public UITableItemView addItem(String paramString1, String paramString2)
  {
    paramString1 = addItem(paramString1);
    paramString1.setDetail(paramString2);
    return paramString1;
  }
  
  public void clear()
  {
    this.mItemList.clear();
    removeAllViews();
    this.mDescriptionView = null;
  }
  
  public void commit()
  {
    removeAllViews();
    if (this.mCaptionView != null) {
      addView(this.mCaptionView);
    }
    Object localObject;
    if (this.mItemList.size() > 1)
    {
      localObject = this.mItemList.iterator();
      int i = 0;
      if (((Iterator)localObject).hasNext())
      {
        UITableItemView localUITableItemView = (UITableItemView)((Iterator)localObject).next();
        if (localUITableItemView.getResponedWithBgState())
        {
          localUITableItemView.setBackgroundResource(2130845612);
          if (i == 0) {
            localUITableItemView.setTableItemPosition(UITableItemView.TableItemPosition.TOP);
          }
        }
        for (;;)
        {
          commitTableItem(localUITableItemView);
          i += 1;
          break;
          if (i == this.mItemList.size() - 1)
          {
            localUITableItemView.setTableItemPosition(UITableItemView.TableItemPosition.BOTTOM);
          }
          else
          {
            localUITableItemView.setTableItemPosition(UITableItemView.TableItemPosition.MIDDLE);
            continue;
            localUITableItemView.setBackgroundColor(-1);
            if (i == 0) {
              localUITableItemView.setTableItemPosition(UITableItemView.TableItemPosition.TOP);
            } else if (i == this.mItemList.size() - 1) {
              localUITableItemView.setTableItemPosition(UITableItemView.TableItemPosition.BOTTOM);
            } else {
              localUITableItemView.setTableItemPosition(UITableItemView.TableItemPosition.MIDDLE);
            }
          }
        }
      }
    }
    else if (this.mItemList.size() == 1)
    {
      localObject = (UITableItemView)this.mItemList.get(0);
      if (!((UITableItemView)localObject).getResponedWithBgState()) {
        break label271;
      }
      ((UITableItemView)localObject).setBackgroundResource(2130845612);
    }
    for (;;)
    {
      ((UITableItemView)localObject).setTableItemPosition(UITableItemView.TableItemPosition.SINGLE);
      commitTableItem((UITableItemView)localObject);
      if (this.mAccessorialView != null) {
        addView(this.mAccessorialView);
      }
      if (this.mDescriptionView != null) {
        addView(this.mDescriptionView);
      }
      return;
      label271:
      ((UITableItemView)localObject).setBackgroundColor(-1);
    }
  }
  
  public View getAccessorialView()
  {
    return this.mAccessorialView;
  }
  
  public TextView getCaptionView()
  {
    return this.mCaptionView;
  }
  
  public UITableItemView getItem(int paramInt)
  {
    if (getChildCount() > paramInt) {
      return (UITableItemView)getChildAt(paramInt);
    }
    return null;
  }
  
  public List<UITableItemView> getItemList()
  {
    return this.mItemList;
  }
  
  public void setAccessorialView(View paramView)
  {
    this.mAccessorialView = paramView;
  }
  
  public void setCaption(int paramInt)
  {
    setCaption(getResources().getString(paramInt));
  }
  
  public void setCaption(String paramString)
  {
    Context localContext = getContext();
    this.mCaptionView = new TextView(localContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(2131299394));
    this.mCaptionView.setLayoutParams(localLayoutParams);
    this.mCaptionView.setPadding(getResources().getDimensionPixelSize(2131299391), 0, 0, 0);
    this.mCaptionView.setTextColor(ContextCompat.getColor(localContext, 2131166576));
    this.mCaptionView.setTextSize(0, getResources().getDimensionPixelSize(2131297597));
    this.mCaptionView.setText(paramString);
  }
  
  public void setClickListener(ClickListener paramClickListener)
  {
    this.mClickListener = paramClickListener;
  }
  
  public void setDescription(int paramInt)
  {
    setDescription(getResources().getString(paramInt));
  }
  
  public void setDescription(String paramString)
  {
    if (this.mDescriptionView == null)
    {
      Context localContext = getContext();
      this.mDescriptionView = new TextView(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      this.mDescriptionView.setLayoutParams(localLayoutParams);
      int i = getResources().getDimensionPixelSize(2131299394);
      int j = getResources().getDimensionPixelSize(2131299395);
      this.mDescriptionView.setPadding(j, i, j, 0);
      this.mDescriptionView.setTextColor(ContextCompat.getColor(localContext, 2131166574));
      this.mDescriptionView.setTextSize(0, getResources().getDimensionPixelSize(2131297597));
      this.mDescriptionView.setGravity(3);
      this.mDescriptionView.setLineSpacing(0.0F, 1.1F);
    }
    this.mDescriptionView.setText(paramString);
  }
  
  public void setItemList(List<UITableItemView> paramList)
  {
    this.mItemList = paramList;
  }
  
  public static abstract interface ClickListener
  {
    public abstract void onClick(int paramInt, UITableItemView paramUITableItemView);
  }
  
  public static abstract interface LongClickListener
  {
    public abstract void onLongClick(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableView
 * JD-Core Version:    0.7.0.1
 */