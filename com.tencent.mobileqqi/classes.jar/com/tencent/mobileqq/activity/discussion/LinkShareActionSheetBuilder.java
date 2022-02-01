package com.tencent.mobileqq.activity.discussion;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import egx;

public class LinkShareActionSheetBuilder
{
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "LinkShareDialogBuilder";
  public static final int b = 3;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 4;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  public LinkShareActionSheetBuilder(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public ActionSheet a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2130904040, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837605));
    localGridView.setAdapter(new egx(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localActionSheet.a(localGridView);
    localActionSheet.d(2131561746);
    return localActionSheet;
  }
  
  public ActionSheet a(ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
    localActionSheet.a(2131562908);
    localActionSheet.c(2131562137);
    localActionSheet.c(2131562715);
    localActionSheet.c(2131561882);
    localActionSheet.a(paramOnButtonClickListener);
    return localActionSheet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */