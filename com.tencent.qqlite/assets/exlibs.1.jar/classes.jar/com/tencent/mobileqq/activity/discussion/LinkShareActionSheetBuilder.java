package com.tencent.mobileqq.activity.discussion;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import cek;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class LinkShareActionSheetBuilder
{
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "LinkShareDialogBuilder";
  public static final int b = 2;
  public static final int c = 1;
  public static final int d = 0;
  public static final int e = 3;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  public LinkShareActionSheetBuilder(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public ActionSheet a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null, 2131624119);
    GridView localGridView = (GridView)View.inflate(this.a, 2130903684, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837508));
    localGridView.setAdapter(new cek(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localActionSheet.a(localGridView);
    localActionSheet.d(2131362794);
    return localActionSheet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */