package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import hga;

public class DialogUtil
{
  public static final int a = 230;
  public static final int b = 231;
  public static final int c = 232;
  public static final int d = 233;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Dialog localDialog = new Dialog(paramContext, paramInt1);
    localDialog.setContentView(paramInt2);
    ((TextView)localDialog.findViewById(2131231029)).setText(paramInt3);
    ((ProgressBar)localDialog.findViewById(2131231028)).setIndeterminateDrawable(paramContext.getResources().getDrawable(2130839680));
    localDialog.setCancelable(paramBoolean);
    return localDialog;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    paramContext = new Dialog(paramContext, 2131624377);
    paramContext.setContentView(2130903173);
    TextView localTextView = (TextView)paramContext.findViewById(2131231029);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131230758);
    localTextView.setText(paramInt1);
    localImageView.setImageResource(paramInt2);
    new Handler().postDelayed(new hga(paramContext), paramLong);
    return paramContext;
  }
  
  public static ProgressDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getResources().getDrawable(2130839680), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    paramContext = new ProgressDialog(paramContext, 2131624405);
    paramContext.show();
    paramContext.getWindow().setContentView(2130903073);
    paramContext.setContentView(2130903073);
    ((TextView)paramContext.findViewById(2131231029)).setText(paramInt);
    ((ProgressBar)paramContext.findViewById(2131231028)).setIndeterminateDrawable(paramDrawable);
    return paramContext;
  }
  
  public static QQCustomContextMenuDialog a(Context paramContext, QQCustomMenu paramQQCustomMenu, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramQQCustomMenu == null) || (paramQQCustomMenu.a() <= 0)) {
      return null;
    }
    paramContext = new QQCustomContextMenuDialog(paramContext, 2131624405);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2130903165);
    paramContext.a(paramQQCustomMenu, paramOnClickListener);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131561746, 2131562539, null, null);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624405);
    paramContext.setContentView(2130903165);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setBottomLayoutGone();
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624405);
    paramContext.setContentView(2130903165);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131561746, 2131562539, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624405);
    paramContext.setContentView(2130903165);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialogThreeBtns a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static QQCustomDialogThreeBtns a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new QQCustomDialogThreeBtns(paramContext, 2131624405);
    paramContext.setContentView(2130903167);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131624405);
    paramContext.setContentView(2130903168);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString3);
    paramContext.setNegativeButton(2131561746, paramOnClickListener2);
    paramContext.setPositiveButton(2131562857, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131624405);
    paramContext.setContentView(2130903169);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131561746, paramOnClickListener2);
    paramContext.setPositiveButton(2131562539, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131624405);
    paramContext.setContentView(2130903169);
    paramContext.setTitle(paramInt);
    paramContext.setMessage(paramString1);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString2);
    paramContext.setNegativeButton(2131561746, paramOnClickListener2);
    paramContext.setPositiveButton(2131562539, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomSingleButtonDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomSingleButtonDialog(paramContext, 2131624405);
    paramContext.setContentView(2130903166);
    paramContext.a(paramString1.replace("/得意", TextUtils.b(21)).replace("/可爱", TextUtils.b(18)).replace("/鼓掌", TextUtils.b(86)).replace("/胜利", TextUtils.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace("/得意", TextUtils.b(21)).replace("/可爱", TextUtils.b(18)).replace("/鼓掌", TextUtils.b(86)).replace("/胜利", TextUtils.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130837946, 2131561746, paramOnClickListener2);
    paramContext.a(paramString3.replace("/得意", TextUtils.b(21)).replace("/可爱", TextUtils.b(18)).replace("/鼓掌", TextUtils.b(86)).replace("/胜利", TextUtils.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomSplitDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131561746, 2131562539, null, null);
  }
  
  public static QQCustomSplitDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomSplitDialog(paramContext, 2131624405);
    paramContext.setContentView(2130903165);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.b(paramInt3, paramOnClickListener1);
    paramContext.c(paramInt2, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131561746, 2131562539, null, null);
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624405);
    paramContext.setContentView(2130903165);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput b(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131624405);
    paramContext.a(7);
    paramContext.setContentView(2130903168);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString3);
    paramContext.setNegativeButton(2131561746, paramOnClickListener2);
    paramContext.setPositiveButton(2131562857, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog c(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624405);
    paramContext.setContentView(2130903165);
    paramContext.setTitle(null);
    paramContext.setDividerGone();
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil
 * JD-Core Version:    0.7.0.1
 */