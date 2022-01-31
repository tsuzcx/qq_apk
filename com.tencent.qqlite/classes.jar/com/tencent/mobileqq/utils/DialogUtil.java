package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import eth;
import eti;

public class DialogUtil
{
  public static final int a = 230;
  public static final int b = 231;
  public static final int c = 232;
  public static final int d = 233;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = paramContext.getResources();
    Object localObject1 = ((Resources)localObject2).getString(paramInt2);
    String str2 = ((Resources)localObject2).getString(paramInt3);
    String str1 = ((Resources)localObject2).getString(paramInt4);
    paramContext = new Dialog(paramContext, 2131624119);
    paramContext.setContentView(2130903135);
    Object localObject3 = (TextView)paramContext.findViewById(2131296915);
    TextView localTextView = (TextView)paramContext.findViewById(2131296470);
    if (paramInt1 <= 0)
    {
      ((ViewGroup.MarginLayoutParams)((TextView)localObject3).getLayoutParams()).topMargin = 0;
      ((TextView)localObject3).setVisibility(8);
      ((TextView)localObject3).requestLayout();
      localObject3 = (ViewGroup.MarginLayoutParams)localTextView.getLayoutParams();
      paramInt1 = (int)((Resources)localObject2).getDisplayMetrics().density;
      ((ViewGroup.MarginLayoutParams)localObject3).topMargin = (paramInt1 * 18);
      ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = (paramInt1 * 18);
      localTextView.requestLayout();
    }
    for (;;)
    {
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)localObject1);
        localTextView.setContentDescription((CharSequence)localObject1);
      }
      localObject1 = (TextView)paramContext.findViewById(2131296918);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131296919);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
      }
      return paramContext;
      localObject2 = ((Resources)localObject2).getString(paramInt1);
      if (localObject3 != null)
      {
        ((TextView)localObject3).setText((CharSequence)localObject2);
        ((TextView)localObject3).setContentDescription((CharSequence)localObject2);
      }
    }
  }
  
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new Dialog(paramContext, 2131624119);
    paramContext.setContentView(2130903484);
    ((TextView)paramContext.findViewById(2131298194)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131298195);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131298196);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131298197);
    localTextView1.setText(paramInt1);
    localTextView1.setGravity(3);
    if (paramInt2 == 0) {
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      localTextView3.setText(paramInt3);
      localTextView2.setOnClickListener(paramOnClickListener1);
      localTextView3.setOnClickListener(paramOnClickListener2);
      return paramContext;
      localTextView2.setText(paramInt2);
    }
  }
  
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Dialog localDialog = new Dialog(paramContext, paramInt1);
    localDialog.setContentView(paramInt2);
    ((TextView)localDialog.findViewById(2131296470)).setText(paramInt3);
    ((ProgressBar)localDialog.findViewById(2131296469)).setIndeterminateDrawable(paramContext.getResources().getDrawable(2130839133));
    localDialog.setCancelable(paramBoolean);
    return localDialog;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    paramContext = new Dialog(paramContext, 2131624092);
    paramContext.setContentView(2130903148);
    TextView localTextView = (TextView)paramContext.findViewById(2131296470);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131296283);
    localTextView.setText(paramInt1);
    localImageView.setImageResource(paramInt2);
    new Handler().postDelayed(new eth(paramContext), paramLong);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, ClickableColorSpanTextView.SpanClickListener paramSpanClickListener)
  {
    paramContext = new Dialog(paramContext, 2131624119);
    paramContext.setContentView(2130903484);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131298194);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131298195);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131298196);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131298197);
    if (paramString == null)
    {
      localTextView3.setVisibility(8);
      localClickableColorSpanTextView.setText(paramCharSequence);
      if (paramInt1 != 0) {
        break label144;
      }
      localTextView1.setVisibility(8);
      label89:
      if (paramInt2 != 0) {
        break label153;
      }
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      paramString = new eti(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(paramSpanClickListener);
      return paramContext;
      localTextView3.setText(paramString);
      break;
      label144:
      localTextView1.setText(paramInt1);
      break label89;
      label153:
      localTextView2.setText(paramInt2);
    }
  }
  
  public static ProgressDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getResources().getDrawable(2130839133), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    paramContext = new ProgressDialog(paramContext, 2131624119);
    paramContext.show();
    paramContext.getWindow().setContentView(2130903049);
    paramContext.setContentView(2130903049);
    ((TextView)paramContext.findViewById(2131296470)).setText(paramInt);
    ((ProgressBar)paramContext.findViewById(2131296469)).setIndeterminateDrawable(paramDrawable);
    return paramContext;
  }
  
  public static QQCustomContextMenuDialog a(Context paramContext, QQCustomMenu paramQQCustomMenu, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramQQCustomMenu == null) || (paramQQCustomMenu.a() <= 0)) {
      return null;
    }
    paramContext = new QQCustomContextMenuDialog(paramContext, 2131624119);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2130903139);
    paramContext.a(paramQQCustomMenu, paramOnClickListener);
    paramContext.a(2130903138);
    ((LinearLayout)paramContext.findViewById(2131296917)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    paramQQCustomMenu = (ListView)paramContext.findViewById(2131296922);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131296915);
    paramQQCustomMenu.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131362790, 2131362791, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131296929)).setVisibility(8);
      paramOnClickListener1 = (TextView)paramString.findViewById(2131296470);
      paramOnClickListener2 = new LinearLayout.LayoutParams(-2, -2);
      paramOnClickListener2.gravity = 17;
      paramOnClickListener1.setLayoutParams(paramOnClickListener2);
      paramOnClickListener1.setMinHeight(Utils.a(paramActivity, 35.0F));
      paramOnClickListener1.setGravity(17);
    }
    return paramString;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131362790, 2131362791, null, null);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624119);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624119);
    paramContext.setContentView(2130903139);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131362790, 2131362791, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624119);
    paramContext.setContentView(2130903139);
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
    paramContext = new QQCustomDialogThreeBtns(paramContext, 2131624119);
    paramContext.setContentView(2130903141);
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
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131624119);
    paramContext.setContentView(2130903142);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString3);
    paramContext.setNegativeButton(2131362790, paramOnClickListener2);
    paramContext.setPositiveButton(2131363069, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131624119);
    paramContext.setContentView(2130903143);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131362790, paramOnClickListener2);
    paramContext.setPositiveButton(2131362791, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomSingleButtonDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomSingleButtonDialog(paramContext, 2131624119);
    paramContext.setContentView(2130903140);
    paramContext.a(paramString1.replace("/得意", TextUtils.b(21)).replace("/可爱", TextUtils.b(18)).replace("/鼓掌", TextUtils.b(86)).replace("/胜利", TextUtils.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace("/得意", TextUtils.b(21)).replace("/可爱", TextUtils.b(18)).replace("/鼓掌", TextUtils.b(86)).replace("/胜利", TextUtils.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130837978, 2131362790, paramOnClickListener2);
    paramContext.a(paramString3.replace("/得意", TextUtils.b(21)).replace("/可爱", TextUtils.b(18)).replace("/鼓掌", TextUtils.b(86)).replace("/胜利", TextUtils.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomSplitDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131362790, 2131362791, null, null);
  }
  
  public static QQCustomSplitDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomSplitDialog(paramContext, 2131624119);
    paramContext.setContentView(2130903139);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.b(paramInt3, paramOnClickListener1);
    paramContext.c(paramInt2, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131362790, 2131362791, null, null);
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624119);
    paramContext.setContentView(2130903139);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput b(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131624119);
    paramContext.a(7);
    paramContext.setContentView(2130903142);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString3);
    paramContext.setNegativeButton(2131362790, paramOnClickListener2);
    paramContext.setPositiveButton(2131363069, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil
 * JD-Core Version:    0.7.0.1
 */