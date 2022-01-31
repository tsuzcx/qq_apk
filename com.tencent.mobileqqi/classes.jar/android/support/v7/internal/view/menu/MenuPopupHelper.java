package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.internal.widget.ListPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

public class MenuPopupHelper
  implements MenuPresenter, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  static final int ITEM_LAYOUT = 2130903059;
  private static final String TAG = "MenuPopupHelper";
  private MenuPopupHelper.MenuAdapter mAdapter;
  private View mAnchorView;
  private Context mContext;
  boolean mForceShowIcon;
  private LayoutInflater mInflater;
  private ViewGroup mMeasureParent;
  private MenuBuilder mMenu;
  private boolean mOverflowOnly;
  private ListPopupWindow mPopup;
  private int mPopupMaxWidth;
  private MenuPresenter.Callback mPresenterCallback;
  private ViewTreeObserver mTreeObserver;
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this(paramContext, paramMenuBuilder, null, false);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView)
  {
    this(paramContext, paramMenuBuilder, paramView, false);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mMenu = paramMenuBuilder;
    this.mOverflowOnly = paramBoolean;
    paramContext = paramContext.getResources();
    this.mPopupMaxWidth = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131427328));
    this.mAnchorView = paramView;
    paramMenuBuilder.addMenuPresenter(this);
  }
  
  private int measureContentWidth(ListAdapter paramListAdapter)
  {
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = paramListAdapter.getCount();
    int j = 0;
    int i = 0;
    View localView = null;
    int k = 0;
    if (j < i2)
    {
      int m = paramListAdapter.getItemViewType(j);
      if (m == i) {
        break label127;
      }
      localView = null;
      i = m;
    }
    label127:
    for (;;)
    {
      if (this.mMeasureParent == null) {
        this.mMeasureParent = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.mMeasureParent);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      return k;
    }
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public void dismiss()
  {
    if (isShowing()) {
      this.mPopup.dismiss();
    }
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return 0;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {}
  
  public boolean isShowing()
  {
    return (this.mPopup != null) && (this.mPopup.isShowing());
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (paramMenuBuilder != this.mMenu) {}
    do
    {
      return;
      dismiss();
    } while (this.mPresenterCallback == null);
    this.mPresenterCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public void onDismiss()
  {
    this.mPopup = null;
    this.mMenu.close();
    if (this.mTreeObserver != null)
    {
      if (!this.mTreeObserver.isAlive()) {
        this.mTreeObserver = this.mAnchorView.getViewTreeObserver();
      }
      this.mTreeObserver.removeGlobalOnLayoutListener(this);
      this.mTreeObserver = null;
    }
  }
  
  public void onGlobalLayout()
  {
    if (isShowing())
    {
      View localView = this.mAnchorView;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      dismiss();
    }
    label28:
    while (!isShowing()) {
      return;
    }
    this.mPopup.show();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.mAdapter;
    MenuPopupHelper.MenuAdapter.access$000(paramAdapterView).performItemAction(paramAdapterView.getItem(paramInt), 0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    MenuPopupHelper localMenuPopupHelper;
    int i;
    if (paramSubMenuBuilder.hasVisibleItems())
    {
      localMenuPopupHelper = new MenuPopupHelper(this.mContext, paramSubMenuBuilder, this.mAnchorView, false);
      localMenuPopupHelper.setCallback(this.mPresenterCallback);
      int j = paramSubMenuBuilder.size();
      i = 0;
      if (i >= j) {
        break label121;
      }
      MenuItem localMenuItem = paramSubMenuBuilder.getItem(i);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    label121:
    for (boolean bool = true;; bool = false)
    {
      localMenuPopupHelper.setForceShowIcon(bool);
      if (localMenuPopupHelper.tryShow())
      {
        if (this.mPresenterCallback != null) {
          this.mPresenterCallback.onOpenSubMenu(paramSubMenuBuilder);
        }
        return true;
        i += 1;
        break;
      }
      return false;
    }
  }
  
  public void setAnchorView(View paramView)
  {
    this.mAnchorView = paramView;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    this.mPresenterCallback = paramCallback;
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
  }
  
  public void show()
  {
    if (!tryShow()) {
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
  }
  
  public boolean tryShow()
  {
    int i = 0;
    this.mPopup = new ListPopupWindow(this.mContext, null, 2130772041);
    this.mPopup.setOnDismissListener(this);
    this.mPopup.setOnItemClickListener(this);
    this.mAdapter = new MenuPopupHelper.MenuAdapter(this, this.mMenu);
    this.mPopup.setAdapter(this.mAdapter);
    this.mPopup.setModal(true);
    View localView = this.mAnchorView;
    if (localView != null)
    {
      if (this.mTreeObserver == null) {
        i = 1;
      }
      this.mTreeObserver = localView.getViewTreeObserver();
      if (i != 0) {
        this.mTreeObserver.addOnGlobalLayoutListener(this);
      }
      this.mPopup.setAnchorView(localView);
      this.mPopup.setContentWidth(Math.min(measureContentWidth(this.mAdapter), this.mPopupMaxWidth));
      this.mPopup.setInputMethodMode(2);
      this.mPopup.show();
      this.mPopup.getListView().setOnKeyListener(this);
      return true;
    }
    return false;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (this.mAdapter != null) {
      this.mAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuPopupHelper
 * JD-Core Version:    0.7.0.1
 */