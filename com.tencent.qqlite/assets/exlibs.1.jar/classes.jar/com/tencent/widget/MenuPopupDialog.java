package com.tencent.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class MenuPopupDialog
  extends Dialog
{
  private static MenuPopupDialog a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_ComTencentWidgetMenuPopupDialog = null;
    jdField_a_of_type_Boolean = false;
  }
  
  private MenuPopupDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  private MenuPopupDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private MenuPopupDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  private static View a(MenuPopupDialog paramMenuPopupDialog, Context paramContext, String paramString, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    paramMenuPopupDialog = (RelativeLayout)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903234, null);
    Resources localResources = paramContext.getResources();
    Object localObject1 = (TextView)paramMenuPopupDialog.findViewById(2131296915);
    if ((paramString != null) && (!"".equals(paramString)))
    {
      ((TextView)localObject1).setText(paramString);
      ((TextView)localObject1).setTextSize(0, localResources.getDimension(2131492872));
    }
    for (;;)
    {
      float f = localResources.getDimension(2131493143);
      paramString = (LinearLayout)paramMenuPopupDialog.findViewById(2131297306);
      int j = paramQQCustomMenu.a();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramQQCustomMenu.a(i);
        localObject1 = new TextView(paramContext);
        ((TextView)localObject1).setTextColor(localResources.getColor(2131427516));
        ((TextView)localObject1).setSingleLine(true);
        ((TextView)localObject1).setTextSize(0, localResources.getDimension(2131492871));
        ((TextView)localObject1).setText(((QQCustomMenuItem)localObject2).a());
        ((TextView)localObject1).setContentDescription(((QQCustomMenuItem)localObject2).a() + "操作");
        ((TextView)localObject1).setId(((QQCustomMenuItem)localObject2).a());
        ((TextView)localObject1).setBackgroundResource(2130838136);
        ((TextView)localObject1).setGravity(17);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener);
        localObject2 = new LinearLayout.LayoutParams(-1, (int)f);
        ((TextView)localObject1).setPadding(0, 0, 0, 0);
        paramString.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        if (i != j - 1)
        {
          localObject1 = new View(paramContext);
          ((View)localObject1).setBackgroundResource(2130837995);
          paramString.addView((View)localObject1, -1, 1);
        }
        i += 1;
      }
      ((TextView)localObject1).setText(localResources.getString(2131363512));
    }
    return paramMenuPopupDialog;
  }
  
  public static MenuPopupDialog a(View paramView, String paramString, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    jdField_a_of_type_ComTencentWidgetMenuPopupDialog = new MenuPopupDialog(paramView.getContext(), 2131624119);
    jdField_a_of_type_ComTencentWidgetMenuPopupDialog.setContentView(a(jdField_a_of_type_ComTencentWidgetMenuPopupDialog, paramView.getContext(), paramString, paramQQCustomMenu, paramOnClickListener));
    jdField_a_of_type_ComTencentWidgetMenuPopupDialog.setOnDismissListener(paramOnDismissListener);
    jdField_a_of_type_ComTencentWidgetMenuPopupDialog.setCanceledOnTouchOutside(true);
    jdField_a_of_type_ComTencentWidgetMenuPopupDialog.show();
    return jdField_a_of_type_ComTencentWidgetMenuPopupDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.MenuPopupDialog
 * JD-Core Version:    0.7.0.1
 */