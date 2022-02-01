package com.tencent.qqmail.view.dialog;

import android.content.Context;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.EditTextDialogBuilder;

public class PasswordDialogBuilder
  extends QMUIDialog.EditTextDialogBuilder
{
  private boolean mNeedEye = false;
  
  public PasswordDialogBuilder(Context paramContext)
  {
    super(paramContext);
    this.mEditText.setId(2131365884);
    this.mRightImageView.setImageResource(2130841042);
    this.mRightImageView.setPadding(0, 0, 0, CONTENT_DISTANCE_SEPERATOR);
  }
  
  public void setNeedEye(boolean paramBoolean)
  {
    this.mNeedEye = paramBoolean;
    if (this.mNeedEye)
    {
      this.mEditText.setOnFocusChangeListener(new PasswordDialogBuilder.1(this));
      this.mRightImageView.setOnClickListener(new PasswordDialogBuilder.2(this));
      return;
    }
    this.mEditText.setOnFocusChangeListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.dialog.PasswordDialogBuilder
 * JD-Core Version:    0.7.0.1
 */