package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.util.InputMethodUtil;
import euo;
import eup;
import euq;
import eur;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;

public class QQCustomDialogWtihEmoticonInput
  extends QQCustomDialog
  implements View.OnClickListener
{
  protected int a;
  protected Handler a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public ImageView a;
  public SystemEmoticonPanel a;
  private SoftReference jdField_a_of_type_JavaLangRefSoftReference;
  
  public QQCustomDialogWtihEmoticonInput(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
    getWindow().setSoftInputMode(19);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(Context paramContext)
  {
    eup localeup = new eup(this);
    if (this.jdField_a_of_type_Int == 7)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = new SystemAndEmojiEmoticonPanel(paramContext, localeup);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = new SystemEmoticonPanel(paramContext, localeup);
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    }
  }
  
  public EditText getEditText()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  public String getInputValue()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296665)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839067);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new euq(this), 200L);
        }
      }
      else {
        return;
      }
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839068);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new eur(this), 200L);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839067);
      return;
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    }
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    Object localObject1 = (RelativeLayout)findViewById(2131296914);
    paramInt = 0;
    while (paramInt < ((RelativeLayout)localObject1).getChildCount())
    {
      ((RelativeLayout)localObject1).getChildAt(paramInt).setOnClickListener(this);
      paramInt += 1;
    }
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296667));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296665));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new euo(this));
    Object localObject2 = Build.MODEL;
    localObject1 = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if (localObject1 == null) {
      return;
    }
    if ((localObject2 != null) && ((((String)localObject2).startsWith("SH-")) || (((String)localObject2).startsWith("SBM")) || (((String)localObject2).startsWith("SHL")))) {}
    try
    {
      localObject2 = TextView.class.getDeclaredField("mTextSelectHandleRes");
      ((Field)localObject2).setAccessible(true);
      paramInt = ((Integer)((Field)localObject2).get(new TextView((Context)localObject1))).intValue();
      ((Field)localObject2).set(this.jdField_a_of_type_AndroidWidgetEditText, Integer.valueOf(paramInt));
      a((Context)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setBackgroundResource(2130837526);
      localObject1 = new RelativeLayout.LayoutParams(-1, (int)(((Context)localObject1).getResources().getDisplayMetrics().density * 150.0F));
      ((FrameLayout)findViewById(2131296933)).addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput
 * JD-Core Version:    0.7.0.1
 */