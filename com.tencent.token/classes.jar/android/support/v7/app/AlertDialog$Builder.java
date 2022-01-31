package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.AttrRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;

public class AlertDialog$Builder
{
  private final AlertController.AlertParams P;
  private final int mTheme;
  
  public AlertDialog$Builder(@NonNull Context paramContext)
  {
    this(paramContext, AlertDialog.resolveDialogTheme(paramContext, 0));
  }
  
  public AlertDialog$Builder(@NonNull Context paramContext, @StyleRes int paramInt)
  {
    this.P = new AlertController.AlertParams(new ContextThemeWrapper(paramContext, AlertDialog.resolveDialogTheme(paramContext, paramInt)));
    this.mTheme = paramInt;
  }
  
  public AlertDialog create()
  {
    AlertDialog localAlertDialog = new AlertDialog(this.P.mContext, this.mTheme);
    this.P.apply(localAlertDialog.mAlert);
    localAlertDialog.setCancelable(this.P.mCancelable);
    if (this.P.mCancelable) {
      localAlertDialog.setCanceledOnTouchOutside(true);
    }
    localAlertDialog.setOnCancelListener(this.P.mOnCancelListener);
    localAlertDialog.setOnDismissListener(this.P.mOnDismissListener);
    if (this.P.mOnKeyListener != null) {
      localAlertDialog.setOnKeyListener(this.P.mOnKeyListener);
    }
    return localAlertDialog;
  }
  
  @NonNull
  public Context getContext()
  {
    return this.P.mContext;
  }
  
  public Builder setAdapter(ListAdapter paramListAdapter, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mAdapter = paramListAdapter;
    this.P.mOnClickListener = paramOnClickListener;
    return this;
  }
  
  public Builder setCancelable(boolean paramBoolean)
  {
    this.P.mCancelable = paramBoolean;
    return this;
  }
  
  public Builder setCursor(Cursor paramCursor, DialogInterface.OnClickListener paramOnClickListener, String paramString)
  {
    this.P.mCursor = paramCursor;
    this.P.mLabelColumn = paramString;
    this.P.mOnClickListener = paramOnClickListener;
    return this;
  }
  
  public Builder setCustomTitle(@Nullable View paramView)
  {
    this.P.mCustomTitleView = paramView;
    return this;
  }
  
  public Builder setIcon(@DrawableRes int paramInt)
  {
    this.P.mIconId = paramInt;
    return this;
  }
  
  public Builder setIcon(@Nullable Drawable paramDrawable)
  {
    this.P.mIcon = paramDrawable;
    return this;
  }
  
  public Builder setIconAttribute(@AttrRes int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    this.P.mContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    this.P.mIconId = localTypedValue.resourceId;
    return this;
  }
  
  @Deprecated
  public Builder setInverseBackgroundForced(boolean paramBoolean)
  {
    this.P.mForceInverseBackground = paramBoolean;
    return this;
  }
  
  public Builder setItems(@ArrayRes int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mItems = this.P.mContext.getResources().getTextArray(paramInt);
    this.P.mOnClickListener = paramOnClickListener;
    return this;
  }
  
  public Builder setItems(CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mItems = paramArrayOfCharSequence;
    this.P.mOnClickListener = paramOnClickListener;
    return this;
  }
  
  public Builder setMessage(@StringRes int paramInt)
  {
    this.P.mMessage = this.P.mContext.getText(paramInt);
    return this;
  }
  
  public Builder setMessage(@Nullable CharSequence paramCharSequence)
  {
    this.P.mMessage = paramCharSequence;
    return this;
  }
  
  public Builder setMultiChoiceItems(@ArrayRes int paramInt, boolean[] paramArrayOfBoolean, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    this.P.mItems = this.P.mContext.getResources().getTextArray(paramInt);
    this.P.mOnCheckboxClickListener = paramOnMultiChoiceClickListener;
    this.P.mCheckedItems = paramArrayOfBoolean;
    this.P.mIsMultiChoice = true;
    return this;
  }
  
  public Builder setMultiChoiceItems(Cursor paramCursor, String paramString1, String paramString2, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    this.P.mCursor = paramCursor;
    this.P.mOnCheckboxClickListener = paramOnMultiChoiceClickListener;
    this.P.mIsCheckedColumn = paramString1;
    this.P.mLabelColumn = paramString2;
    this.P.mIsMultiChoice = true;
    return this;
  }
  
  public Builder setMultiChoiceItems(CharSequence[] paramArrayOfCharSequence, boolean[] paramArrayOfBoolean, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    this.P.mItems = paramArrayOfCharSequence;
    this.P.mOnCheckboxClickListener = paramOnMultiChoiceClickListener;
    this.P.mCheckedItems = paramArrayOfBoolean;
    this.P.mIsMultiChoice = true;
    return this;
  }
  
  public Builder setNegativeButton(@StringRes int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mNegativeButtonText = this.P.mContext.getText(paramInt);
    this.P.mNegativeButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setNegativeButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mNegativeButtonText = paramCharSequence;
    this.P.mNegativeButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setNegativeButtonIcon(Drawable paramDrawable)
  {
    this.P.mNegativeButtonIcon = paramDrawable;
    return this;
  }
  
  public Builder setNeutralButton(@StringRes int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mNeutralButtonText = this.P.mContext.getText(paramInt);
    this.P.mNeutralButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setNeutralButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mNeutralButtonText = paramCharSequence;
    this.P.mNeutralButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setNeutralButtonIcon(Drawable paramDrawable)
  {
    this.P.mNeutralButtonIcon = paramDrawable;
    return this;
  }
  
  public Builder setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.P.mOnCancelListener = paramOnCancelListener;
    return this;
  }
  
  public Builder setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.P.mOnDismissListener = paramOnDismissListener;
    return this;
  }
  
  public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.P.mOnItemSelectedListener = paramOnItemSelectedListener;
    return this;
  }
  
  public Builder setOnKeyListener(DialogInterface.OnKeyListener paramOnKeyListener)
  {
    this.P.mOnKeyListener = paramOnKeyListener;
    return this;
  }
  
  public Builder setPositiveButton(@StringRes int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mPositiveButtonText = this.P.mContext.getText(paramInt);
    this.P.mPositiveButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setPositiveButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mPositiveButtonText = paramCharSequence;
    this.P.mPositiveButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setPositiveButtonIcon(Drawable paramDrawable)
  {
    this.P.mPositiveButtonIcon = paramDrawable;
    return this;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public Builder setRecycleOnMeasureEnabled(boolean paramBoolean)
  {
    this.P.mRecycleOnMeasure = paramBoolean;
    return this;
  }
  
  public Builder setSingleChoiceItems(@ArrayRes int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mItems = this.P.mContext.getResources().getTextArray(paramInt1);
    this.P.mOnClickListener = paramOnClickListener;
    this.P.mCheckedItem = paramInt2;
    this.P.mIsSingleChoice = true;
    return this;
  }
  
  public Builder setSingleChoiceItems(Cursor paramCursor, int paramInt, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mCursor = paramCursor;
    this.P.mOnClickListener = paramOnClickListener;
    this.P.mCheckedItem = paramInt;
    this.P.mLabelColumn = paramString;
    this.P.mIsSingleChoice = true;
    return this;
  }
  
  public Builder setSingleChoiceItems(ListAdapter paramListAdapter, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mAdapter = paramListAdapter;
    this.P.mOnClickListener = paramOnClickListener;
    this.P.mCheckedItem = paramInt;
    this.P.mIsSingleChoice = true;
    return this;
  }
  
  public Builder setSingleChoiceItems(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.P.mItems = paramArrayOfCharSequence;
    this.P.mOnClickListener = paramOnClickListener;
    this.P.mCheckedItem = paramInt;
    this.P.mIsSingleChoice = true;
    return this;
  }
  
  public Builder setTitle(@StringRes int paramInt)
  {
    this.P.mTitle = this.P.mContext.getText(paramInt);
    return this;
  }
  
  public Builder setTitle(@Nullable CharSequence paramCharSequence)
  {
    this.P.mTitle = paramCharSequence;
    return this;
  }
  
  public Builder setView(int paramInt)
  {
    this.P.mView = null;
    this.P.mViewLayoutResId = paramInt;
    this.P.mViewSpacingSpecified = false;
    return this;
  }
  
  public Builder setView(View paramView)
  {
    this.P.mView = paramView;
    this.P.mViewLayoutResId = 0;
    this.P.mViewSpacingSpecified = false;
    return this;
  }
  
  @Deprecated
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public Builder setView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.P.mView = paramView;
    this.P.mViewLayoutResId = 0;
    this.P.mViewSpacingSpecified = true;
    this.P.mViewSpacingLeft = paramInt1;
    this.P.mViewSpacingTop = paramInt2;
    this.P.mViewSpacingRight = paramInt3;
    this.P.mViewSpacingBottom = paramInt4;
    return this;
  }
  
  public AlertDialog show()
  {
    AlertDialog localAlertDialog = create();
    localAlertDialog.show();
    return localAlertDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertDialog.Builder
 * JD-Core Version:    0.7.0.1
 */