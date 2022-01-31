package com.tencent.mobileqq.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import eyt;
import eyu;

public class QFavDownloadProgressDialog
  extends Dialog
{
  private static final int d = 1001;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton = null;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private QFavDownloadProgressDialog.Callback jdField_a_of_type_ComTencentMobileqqWidgetQFavDownloadProgressDialog$Callback;
  private eyu jdField_a_of_type_Eyu = new eyu(this, null);
  private int b = 0;
  private int c = 0;
  
  public QFavDownloadProgressDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public QFavDownloadProgressDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131624119);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903400, null);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131297954));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131297955));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new eyt(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297953));
    paramContext = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364513), new Object[] { Integer.valueOf(this.b), Integer.valueOf(266474) });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(paramOnClickListener);
  }
  
  public void a(QFavDownloadProgressDialog.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFavDownloadProgressDialog$Callback = paramCallback;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    this.jdField_a_of_type_Eyu.sendEmptyMessage(1001);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(paramInt);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQFavDownloadProgressDialog$Callback != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQFavDownloadProgressDialog$Callback.a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.jdField_a_of_type_AndroidViewView);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 17;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QFavDownloadProgressDialog
 * JD-Core Version:    0.7.0.1
 */