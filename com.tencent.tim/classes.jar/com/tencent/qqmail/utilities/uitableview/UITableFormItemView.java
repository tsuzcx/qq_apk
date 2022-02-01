package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.method.PasswordTransformationMethod;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import androidx.core.content.ContextCompat;
import com.tencent.qqmail.account.helper.Helper;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class UITableFormItemView
  extends UITableItemView
{
  private EditText editText;
  View.OnClickListener onClearTextView = new UITableFormItemView.1(this);
  public ImageView verifyButton;
  private ImageView verifyImg;
  
  public UITableFormItemView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public UITableFormItemView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    initView();
  }
  
  private void initClearView()
  {
    ImageView localImageView = new ImageView(this.context);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    localImageView.setVisibility(4);
    localImageView.setImageResource(2130841401);
    localImageView.setOnTouchListener(QMUIKit.onIconButtonTouchListener);
    addView(localImageView, localLayoutParams);
    QMUIKit.expendTouchArea(localImageView);
    Helper.initEditTextAndClearButton(this.editText, localImageView);
  }
  
  private EditText initEditText(String paramString, int paramInt1, int paramInt2)
  {
    this.editText = new EditText(this.context);
    if (paramString != null) {
      this.editText.setText(paramString);
    }
    if (paramInt1 != 0) {
      this.editText.setHint(paramInt1);
    }
    if (paramInt2 != 0) {
      this.editText.setInputType(paramInt2);
    }
    paramString = new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(2131299396), 1.0F);
    paramString.gravity = 16;
    this.editText.setLayoutParams(paramString);
    this.editText.setPadding(0, 0, 0, 0);
    this.editText.setBackgroundColor(ContextCompat.getColor(this.context, 2131166586));
    this.editText.setSingleLine(true);
    this.editText.setTextSize(2, 16.0F);
    this.editText.setHintTextColor(ContextCompat.getColor(this.context, 2131167534));
    this.editText.setTextColor(ContextCompat.getColor(this.context, 2131166572));
    return null;
  }
  
  private void initView()
  {
    hideArrow();
    this.titlePanelLayout.width = getResources().getDimensionPixelSize(2131299397);
    this.titlePanelLayout.weight = 0.0F;
  }
  
  public EditText addEditText(int paramInt)
  {
    return addEditText(paramInt, 0);
  }
  
  public EditText addEditText(int paramInt1, int paramInt2)
  {
    initEditText(null, paramInt1, paramInt2);
    return this.editText;
  }
  
  public void drawViews()
  {
    super.drawViews();
    if (this.editText != null)
    {
      addView(this.editText);
      if ((this.editText.getInputType() & 0x80) != 0) {
        this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      initClearView();
    }
    if (this.verifyImg != null)
    {
      addView(this.verifyImg);
      addView(this.verifyButton);
    }
  }
  
  public void setAsVerifyItem()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(2131299721), -1);
    this.verifyImg = new ImageView(this.context);
    this.verifyImg.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.setMargins(10, 0, 0, 0);
    this.verifyButton = new ImageView(this.context);
    this.verifyButton.setLayoutParams(localLayoutParams);
    this.verifyButton.setImageDrawable(getResources().getDrawable(2130841044));
  }
  
  public void setVerifyImg(Bitmap paramBitmap)
  {
    if (this.verifyImg != null) {
      this.verifyImg.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableFormItemView
 * JD-Core Version:    0.7.0.1
 */