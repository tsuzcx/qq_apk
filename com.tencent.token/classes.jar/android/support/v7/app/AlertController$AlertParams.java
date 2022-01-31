package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class AlertController$AlertParams
{
  public ListAdapter mAdapter;
  public boolean mCancelable;
  public int mCheckedItem = -1;
  public boolean[] mCheckedItems;
  public final Context mContext;
  public Cursor mCursor;
  public View mCustomTitleView;
  public boolean mForceInverseBackground;
  public Drawable mIcon;
  public int mIconAttrId = 0;
  public int mIconId = 0;
  public final LayoutInflater mInflater;
  public String mIsCheckedColumn;
  public boolean mIsMultiChoice;
  public boolean mIsSingleChoice;
  public CharSequence[] mItems;
  public String mLabelColumn;
  public CharSequence mMessage;
  public Drawable mNegativeButtonIcon;
  public DialogInterface.OnClickListener mNegativeButtonListener;
  public CharSequence mNegativeButtonText;
  public Drawable mNeutralButtonIcon;
  public DialogInterface.OnClickListener mNeutralButtonListener;
  public CharSequence mNeutralButtonText;
  public DialogInterface.OnCancelListener mOnCancelListener;
  public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
  public DialogInterface.OnClickListener mOnClickListener;
  public DialogInterface.OnDismissListener mOnDismissListener;
  public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
  public DialogInterface.OnKeyListener mOnKeyListener;
  public AlertController.AlertParams.OnPrepareListViewListener mOnPrepareListViewListener;
  public Drawable mPositiveButtonIcon;
  public DialogInterface.OnClickListener mPositiveButtonListener;
  public CharSequence mPositiveButtonText;
  public boolean mRecycleOnMeasure = true;
  public CharSequence mTitle;
  public View mView;
  public int mViewLayoutResId;
  public int mViewSpacingBottom;
  public int mViewSpacingLeft;
  public int mViewSpacingRight;
  public boolean mViewSpacingSpecified = false;
  public int mViewSpacingTop;
  
  public AlertController$AlertParams(Context paramContext)
  {
    this.mContext = paramContext;
    this.mCancelable = true;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private void createListView(AlertController paramAlertController)
  {
    AlertController.RecycleListView localRecycleListView = (AlertController.RecycleListView)this.mInflater.inflate(paramAlertController.mListLayout, null);
    Object localObject;
    if (this.mIsMultiChoice) {
      if (this.mCursor == null)
      {
        localObject = new AlertController.AlertParams.1(this, this.mContext, paramAlertController.mMultiChoiceItemLayout, 16908308, this.mItems, localRecycleListView);
        if (this.mOnPrepareListViewListener != null) {
          this.mOnPrepareListViewListener.onPrepareListView(localRecycleListView);
        }
        paramAlertController.mAdapter = ((ListAdapter)localObject);
        paramAlertController.mCheckedItem = this.mCheckedItem;
        if (this.mOnClickListener == null) {
          break label271;
        }
        localRecycleListView.setOnItemClickListener(new AlertController.AlertParams.3(this, paramAlertController));
        label108:
        if (this.mOnItemSelectedListener != null) {
          localRecycleListView.setOnItemSelectedListener(this.mOnItemSelectedListener);
        }
        if (!this.mIsSingleChoice) {
          break label297;
        }
        localRecycleListView.setChoiceMode(1);
      }
    }
    for (;;)
    {
      paramAlertController.mListView = localRecycleListView;
      return;
      localObject = new AlertController.AlertParams.2(this, this.mContext, this.mCursor, false, localRecycleListView, paramAlertController);
      break;
      if (this.mIsSingleChoice) {}
      for (int i = paramAlertController.mSingleChoiceItemLayout;; i = paramAlertController.mListItemLayout)
      {
        if (this.mCursor == null) {
          break label234;
        }
        localObject = new SimpleCursorAdapter(this.mContext, i, this.mCursor, new String[] { this.mLabelColumn }, new int[] { 16908308 });
        break;
      }
      label234:
      if (this.mAdapter != null)
      {
        localObject = this.mAdapter;
        break;
      }
      localObject = new AlertController.CheckedItemAdapter(this.mContext, i, 16908308, this.mItems);
      break;
      label271:
      if (this.mOnCheckboxClickListener == null) {
        break label108;
      }
      localRecycleListView.setOnItemClickListener(new AlertController.AlertParams.4(this, localRecycleListView, paramAlertController));
      break label108;
      label297:
      if (this.mIsMultiChoice) {
        localRecycleListView.setChoiceMode(2);
      }
    }
  }
  
  public void apply(AlertController paramAlertController)
  {
    if (this.mCustomTitleView != null)
    {
      paramAlertController.setCustomTitle(this.mCustomTitleView);
      if (this.mMessage != null) {
        paramAlertController.setMessage(this.mMessage);
      }
      if ((this.mPositiveButtonText != null) || (this.mPositiveButtonIcon != null)) {
        paramAlertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
      }
      if ((this.mNegativeButtonText != null) || (this.mNegativeButtonIcon != null)) {
        paramAlertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
      }
      if ((this.mNeutralButtonText != null) || (this.mNeutralButtonIcon != null)) {
        paramAlertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
      }
      if ((this.mItems != null) || (this.mCursor != null) || (this.mAdapter != null)) {
        createListView(paramAlertController);
      }
      if (this.mView == null) {
        break label269;
      }
      if (!this.mViewSpacingSpecified) {
        break label260;
      }
      paramAlertController.setView(this.mView, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
    }
    label260:
    label269:
    while (this.mViewLayoutResId == 0)
    {
      return;
      if (this.mTitle != null) {
        paramAlertController.setTitle(this.mTitle);
      }
      if (this.mIcon != null) {
        paramAlertController.setIcon(this.mIcon);
      }
      if (this.mIconId != 0) {
        paramAlertController.setIcon(this.mIconId);
      }
      if (this.mIconAttrId == 0) {
        break;
      }
      paramAlertController.setIcon(paramAlertController.getIconAttributeResId(this.mIconAttrId));
      break;
      paramAlertController.setView(this.mView);
      return;
    }
    paramAlertController.setView(this.mViewLayoutResId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController.AlertParams
 * JD-Core Version:    0.7.0.1
 */