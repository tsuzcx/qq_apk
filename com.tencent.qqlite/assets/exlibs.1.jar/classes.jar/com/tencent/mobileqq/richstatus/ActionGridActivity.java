package com.tencent.mobileqq.richstatus;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import eay;
import eaz;
import java.util.ArrayList;

public class ActionGridActivity
  extends IphoneTitleBarActivity
  implements IActionListener, IIconListener, AdapterView.OnItemClickListener
{
  private static final int jdField_a_of_type_Int = 80;
  public static final String a;
  private static final int b = 100;
  private ActionInfo jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private GridListView jdField_a_of_type_ComTencentMobileqqWidgetGridListView;
  private eay jdField_a_of_type_Eay;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int c = 0;
  private int d = 0;
  private int e = 3;
  
  static
  {
    jdField_a_of_type_JavaLangString = ActionGridActivity.class.getSimpleName();
  }
  
  private void c()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.c = (localDisplayMetrics.widthPixels / this.e);
    this.d = ((int)(localDisplayMetrics.density * 100.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setNumColumns(this.e);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSpacing(0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSize(this.c, this.d);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 100)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.i, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Eay.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int i;
    if ((paramInt2 == 201) && (paramBitmap != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.a();
      paramInt2 = 0;
    }
    for (;;)
    {
      if (paramInt2 < i)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.a(paramInt2);
        if (localObject != null) {}
      }
      else
      {
        return;
      }
      Object localObject = (eaz)((View)localObject).getTag();
      if (((eaz)localObject).jdField_a_of_type_Int == paramInt1)
      {
        ((eaz)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(getResources(), paramBitmap, false, false));
        return;
      }
      paramInt2 += 1;
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ActionInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramView = new Intent();
    paramView.putExtra("k_action_id", paramAdapterView.i);
    paramView.putExtra("k_action_text", paramAdapterView.d);
    setResult(-1, paramView);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewNoBackground(2130903654);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    int i = getIntent().getIntExtra("k_action_id", 0);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(i);
    if ((i == 0) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo == null))
    {
      finish();
      return false;
    }
    setTitle(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.c);
    this.h.setContentDescription(this.h.getText() + "按钮");
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView = ((GridListView)findViewById(2131298834));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnItemClickListener(this);
    i = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.i, this.jdField_a_of_type_JavaUtilArrayList);
    if (i != 100) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setMode(1);
    this.jdField_a_of_type_Eay = new eay(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setAdapter(this.jdField_a_of_type_Eay);
    c();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this);
    if (ThemeUtil.isInNightMode(this.app))
    {
      paramBundle = new View(this);
      paramBundle.setBackgroundColor(1996488704);
      addContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionGridActivity
 * JD-Core Version:    0.7.0.1
 */