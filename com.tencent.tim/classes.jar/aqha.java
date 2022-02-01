import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.startup.step.CheckPermission.a;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.a;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class aqha
{
  public static final HashMap<String, String> oR = new HashMap();
  
  static
  {
    oR.put("android.permission.READ_EXTERNAL_STORAGE", acfp.m(2131705072));
    oR.put("android.permission.WRITE_EXTERNAL_STORAGE", acfp.m(2131705086));
    oR.put("android.permission.READ_PHONE_STATE", "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n" + acfp.m(2131705058));
    oR.put("android.permission.CAMERA", acfp.m(2131705097));
    oR.put("android.permission.RECORD_AUDIO", acfp.m(2131705070));
    oR.put("android.permission.ACCESS_COARSE_LOCATION", acfp.m(2131705065));
    oR.put("android.permission.ACCESS_FINE_LOCATION", acfp.m(2131705071));
    oR.put("android.permission.READ_CALENDAR", acfp.m(2131705113));
    oR.put("android.permission.SEND_SMS", acfp.m(2131705099));
    oR.put("android.permission.READ_CONTACTS", acfp.m(2131705089));
    oR.put("android.permission.WRITE_CONTACTS", acfp.m(2131705106));
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = aqcw.a(paramActivity, 2131700506, 2131700504, 2131700503, 2131700505, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, aqha.b paramb, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new ReportDialog(paramContext, 2131756467);
    paramContext.setContentView(2131559156);
    Object localObject2 = (TextView)paramContext.findViewById(2131365867);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131365868);
    if (paramInt1 <= 0)
    {
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).topMargin = 0;
      ((TextView)localObject2).setVisibility(8);
      ((TextView)localObject2).requestLayout();
      localObject2 = (ViewGroup.MarginLayoutParams)localFrameLayout.getLayoutParams();
      paramInt1 = (int)((Resources)localObject1).getDisplayMetrics().density;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (paramInt1 * 18);
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = (paramInt1 * 18);
      localFrameLayout.requestLayout();
    }
    for (;;)
    {
      localObject1 = (TextView)paramContext.findViewById(2131365852);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
        }
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131365858);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramOnClickListener1.getPaint().setFakeBoldText(true);
        }
      }
      localFrameLayout.addView(paramb.a(localFrameLayout.getContext(), paramObject));
      return paramContext;
      localObject1 = ((Resources)localObject1).getString(paramInt1);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
      }
    }
  }
  
  public static Dialog a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, paramString, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2, false, false);
  }
  
  public static Dialog a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new ReportDialog(paramContext, 2131756467);
    paramContext.setContentView(2131559127);
    Object localObject2 = (TextView)paramContext.findViewById(2131365867);
    TextView localTextView = (TextView)paramContext.findViewById(2131365863);
    if (paramInt1 <= 0)
    {
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).topMargin = 0;
      ((TextView)localObject2).setVisibility(8);
      ((TextView)localObject2).requestLayout();
      localObject2 = (ViewGroup.MarginLayoutParams)localTextView.getLayoutParams();
      paramInt1 = (int)((Resources)localObject1).getDisplayMetrics().density;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (paramInt1 * 18);
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = (paramInt1 * 18);
      localTextView.requestLayout();
    }
    for (;;)
    {
      if (localTextView != null)
      {
        localTextView.setText(paramString);
        localTextView.setContentDescription(paramString);
      }
      paramString = (TextView)paramContext.findViewById(2131365852);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131365858);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setContentDescription(str1);
        paramString.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      return paramContext;
      localObject1 = ((Resources)localObject1).getString(paramInt1);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
      }
    }
  }
  
  public static Dialog a(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, String paramString4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131756467);
    paramContext.setContentView(2131559162);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131368698);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131379769);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365360);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131364221);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131365219);
    if (paramBitmap == null)
    {
      localImageView.setVisibility(8);
      if (paramString2 != null) {
        break label140;
      }
      localTextView2.setVisibility(8);
      label94:
      localTextView1.setText(paramString1);
      if (paramOnClickListener1 != null) {
        break label149;
      }
      localTextView3.setVisibility(8);
      label112:
      if (paramOnClickListener2 != null) {
        break label166;
      }
      localTextView4.setVisibility(8);
    }
    for (;;)
    {
      paramContext.setCanceledOnTouchOutside(false);
      return paramContext;
      localImageView.setImageBitmap(paramBitmap);
      break;
      label140:
      localTextView2.setText(paramString2);
      break label94;
      label149:
      localTextView3.setOnClickListener(paramOnClickListener1);
      localTextView3.setText(paramString3);
      break label112;
      label166:
      localTextView4.setOnClickListener(paramOnClickListener2);
      localTextView4.setText(paramString4);
    }
  }
  
  public static Dialog a(Context paramContext, Drawable paramDrawable, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131756467);
    paramContext.setContentView(2131559170);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131381252);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365867);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131381253);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131381254);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131381248);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131381249);
    if (paramDrawable == null)
    {
      localImageView.setVisibility(8);
      if (paramString1 != null) {
        break label163;
      }
      localTextView1.setVisibility(8);
      label105:
      if (paramString3 != null) {
        break label172;
      }
      localTextView3.setVisibility(8);
      label117:
      localTextView2.setText(paramString2);
      if (paramOnClickListener1 != null) {
        break label182;
      }
      localTextView4.setVisibility(8);
      label135:
      if (paramOnClickListener2 != null) {
        break label199;
      }
      localTextView5.setVisibility(8);
    }
    for (;;)
    {
      paramContext.setCanceledOnTouchOutside(false);
      return paramContext;
      localImageView.setImageDrawable(paramDrawable);
      break;
      label163:
      localTextView1.setText(paramString1);
      break label105;
      label172:
      localTextView3.setText(paramString3);
      break label117;
      label182:
      localTextView4.setOnClickListener(paramOnClickListener1);
      localTextView4.setText(paramString4);
      break label135;
      label199:
      localTextView5.setOnClickListener(paramOnClickListener2);
      localTextView5.setText(paramString5);
    }
  }
  
  public static Dialog a(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131756467);
    paramContext.getWindow().setWindowAnimations(2131755320);
    paramContext.setContentView(2131561286);
    ((TextView)paramContext.findViewById(2131365903)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365891);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365889);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365895);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    if (paramInt1 == 0) {
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      localTextView3.setText(paramInt2);
      localTextView2.setOnClickListener(paramOnClickListener1);
      localTextView3.setOnClickListener(paramOnClickListener2);
      return paramContext;
      localTextView2.setText(paramInt1);
    }
  }
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, ClickableColorSpanTextView.a parama)
  {
    paramContext = new ReportDialog(paramContext, 2131756467);
    paramContext.setContentView(2131561286);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365903);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131365891);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365889);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365895);
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
      paramString = new aqhb(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(parama);
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
    return a(paramContext, paramContext.getResources().getDrawable(2130850582), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    return a(paramContext, paramDrawable, paramInt, 0);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 2131756467;
    }
    paramContext = new ReportProgressDialog(paramContext, i);
    try
    {
      paramContext.show();
      label26:
      paramContext.getWindow().setContentView(2131558460);
      paramContext.setContentView(2131558460);
      ((TextView)paramContext.findViewById(2131365863)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131367453)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static aqai a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new aqai(paramActivity);
    paramActivity.a(new aofk(pv(paramString1), 3)).b(new aofk(pv(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static aqjn a(Context paramContext, String paramString, Bundle paramBundle)
  {
    aqjn localaqjn = new aqjn(paramContext, 2131756467);
    localaqjn.j(paramContext, paramBundle);
    localaqjn.setTitle(paramString);
    localaqjn.setCanceledOnTouchOutside(false);
    localaqjn.setCancelable(true);
    return localaqjn;
  }
  
  public static aqjn a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    aqjn localaqjn = new aqjn(paramContext, 2131756467);
    localaqjn.j(paramContext, paramBundle);
    localaqjn.setTitle(paramString);
    localaqjn.setCanceledOnTouchOutside(false);
    localaqjn.setCancelable(true);
    if (paramInt > 0) {
      localaqjn.setMaxLength(paramInt);
    }
    return localaqjn;
  }
  
  public static aqjq a(Context paramContext, String paramString, Bundle paramBundle)
  {
    aqjq localaqjq = new aqjq(paramContext, 2131756467);
    localaqjq.j(paramContext, paramBundle);
    localaqjq.setTitle(paramString);
    localaqjq.setCanceledOnTouchOutside(true);
    localaqjq.setCancelable(true);
    return localaqjq;
  }
  
  public static aqjt a(Context paramContext, aqoa paramaqoa, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramaqoa == null) || (paramaqoa.size() <= 0)) {
      return null;
    }
    paramContext = new aqjt(paramContext, 2131756467);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2131559151);
    paramContext.a(paramaqoa, paramOnClickListener);
    paramContext.Xy(2131559141);
    ((LinearLayout)paramContext.findViewById(2131363756)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    paramaqoa = (ListView)paramContext.findViewById(2131370527);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131365867);
    paramaqoa.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static aqju a(Activity paramActivity)
  {
    aqju localaqju = a(paramActivity, 230);
    localaqju.setTitle(acfp.m(2131705060));
    localaqju.setMessage(2131695490);
    localaqju.setNegativeButton(acfp.m(2131705090), new aqhd(localaqju));
    localaqju.setPositiveButton(acfp.m(2131715321), new aqhe(paramActivity));
    localaqju.setOnCancelListener(null);
    localaqju.show();
    return localaqju;
  }
  
  public static aqju a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131721058, 2131721079, null, null);
  }
  
  public static aqju a(Activity paramActivity, CheckPermission.a parama)
  {
    parama = new aqhj(paramActivity, parama);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(acfp.m(2131711619));
    paramActivity.setMessage(acfp.m(2131709450));
    paramActivity.setNegativeButton(acfp.m(2131705090), parama);
    paramActivity.setPositiveButton(acfp.m(2131705075), parama);
    paramActivity.show();
    return paramActivity;
  }
  
  public static aqju a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131721058, 2131721079, null, null);
  }
  
  public static aqju a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365841)).setVisibility(8);
      ((TextView)paramString.findViewById(2131365863)).setMinHeight(aqcx.dip2px(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static aqju a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    aqju localaqju = new aqju(paramActivity, 2131756467);
    localaqju.setContentView(2131559151);
    localaqju.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2131558958, null);
    paramString1 = (TextView)paramActivity.findViewById(2131381153);
    String str = aqai.a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      paramString1.setText(acfp.m(2131705078) + str);
    }
    ((TextView)paramActivity.findViewById(2131365863)).setText(paramString2);
    localaqju.addView(paramActivity);
    localaqju.setNegativeButton(acfp.m(2131705055), paramOnClickListener1);
    localaqju.setPositiveButton(acfp.m(2131705102), paramOnClickListener2);
    localaqju.setCanceledOnTouchOutside(false);
    return localaqju;
  }
  
  public static aqju a(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    aqju localaqju = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = acfp.m(2131705060);
    }
    localaqju.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = acfp.m(2131705096);
    }
    localaqju.setMessage(paramActivity);
    localaqju.setNegativeButton(acfp.m(2131705090), paramOnClickListener1);
    localaqju.setPositiveButton(acfp.m(2131705075), paramOnClickListener2);
    localaqju.setOnCancelListener(paramOnCancelListener);
    localaqju.show();
    return localaqju;
  }
  
  public static aqju a(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramActivity = a(paramActivity, 0, paramString1, paramString2, null, null);
    if (paramActivity.getTitleTextView() != null) {
      paramActivity.getTitleTextView().getPaint().setFakeBoldText(true);
    }
    if (paramActivity.getBtnight() != null) {
      paramActivity.getBtnight().getPaint().setFakeBoldText(true);
    }
    paramActivity.setPositiveButton(paramString3, paramOnClickListener);
    paramActivity.setCancelable(true);
    paramActivity.setCanceledOnTouchOutside(true);
    return paramActivity;
  }
  
  public static aqju a(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    int i;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      try
      {
        if (paramArrayOfString.length != 1) {
          break label114;
        }
        paramArrayOfString = i(new String[] { paramArrayOfString[0] });
        return c(paramActivity, null, paramArrayOfString);
      }
      catch (Exception paramActivity)
      {
        return null;
      }
      if (i < paramArrayOfInt.length)
      {
        localObject1 = localObject2;
        if (paramArrayOfInt[i] == 0) {
          break;
        }
        if (localObject2 == null) {
          break label133;
        }
        localObject1 = (String)localObject2 + "#" + paramArrayOfString[i];
        break;
      }
      if (localObject2 != null)
      {
        paramArrayOfString = i(((String)localObject2).split("#"));
      }
      else
      {
        paramArrayOfString = null;
        continue;
        label114:
        i = 0;
        localObject2 = null;
      }
    }
    for (;;)
    {
      i += 1;
      localObject2 = localObject1;
      break;
      label133:
      localObject1 = paramArrayOfString[i];
    }
  }
  
  public static aqju a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131721058, 2131721079, null, null);
  }
  
  public static aqju a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString);
    paramContext.setMessageWithoutAutoLink(paramCharSequence);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static aqju a(Context paramContext, int paramInt1, String paramString, CharSequence paramCharSequence, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, 2131559151, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static aqju a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(2131559151);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramCharSequence);
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static aqju a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramCharSequence, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public static aqju a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    aqju localaqju = new aqju(paramContext, 2131756467);
    localaqju.setContentView(2131559155);
    if (paramInt != 0) {
      localaqju.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localaqju.setMessage(paramCharSequence);
      localaqju.setNegativeButton(paramString2, paramOnClickListener1);
      localaqju.setPositiveButton(paramString3, paramOnClickListener2);
      localaqju.setCanceledOnTouchOutside(false);
      paramString1 = (TextView)localaqju.findViewById(2131365843);
      paramContext = paramString4;
      if (paramString4 == null) {
        paramContext = acfp.m(2131705093);
      }
      paramString1.setText(paramContext);
      if (paramOnClickListener3 == null) {
        break;
      }
      paramString1.setOnClickListener(new aqhl(paramOnClickListener3, localaqju));
      return localaqju;
      localaqju.setTitle(paramString1);
    }
    paramString1.setOnClickListener(new aqhm(localaqju));
    return localaqju;
  }
  
  public static aqju a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(2131559151);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static aqju a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131721058, 2131721079, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static aqju a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(2131559151);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static aqju a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = a(paramContext, paramInt, paramString1, paramString2, paramString4, paramString5, paramOnClickListener2, paramOnClickListener3);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static aqju a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(2131559148);
    paramContext.setTitle(paramString1);
    paramContext.setNegativeButton(paramString2, paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static aqju a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, 230, paramString1, paramString2, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    paramContext.setEditLint(paramString3);
    return paramContext;
  }
  
  public static aqju a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    aqju localaqju = new aqju(paramContext, 2131756467);
    localaqju.setContentView(2131559957);
    localaqju.setTitle(paramString1);
    localaqju.setMessage(paramString2);
    localaqju.setNegativeButton(paramString3, paramOnClickListener1);
    localaqju.setPositiveButton(paramString4, paramOnClickListener2);
    localaqju.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)localaqju.findViewById(2131365843);
    paramString1.setText(paramContext.getResources().getString(2131721058));
    paramString1.setOnClickListener(new aqhk(localaqju));
    return localaqju;
  }
  
  public static aqju a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener)
  {
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(2131559129);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365867);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365863);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364677);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener1);
    paramContext.setPositiveButton(paramString4, paramOnClickListener2);
    localImageView.setOnClickListener(paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static aqju a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(2131559138);
    paramContext.setTitleWithEmo(new aofk(pv(paramString1), 3));
    paramContext.setMessage(new aofk(pv(paramString2), 3));
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    if ((paramString5 != null) && (!"".equals(paramString5))) {
      paramContext.setCheckBox(paramString5, null);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static aqkf a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static aqkf a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new aqkf(paramContext, 2131756467);
    paramContext.setContentView(2131559154);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static aqkk a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqkk(paramContext, 2131756467);
    paramContext.setContentView(2131559161);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.UO(paramString3);
    paramContext.setNegativeButton(2131721058, paramOnClickListener2);
    paramContext.setPositiveButton(2131691441, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static aqkk a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static aqkk a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new aqkk(paramContext, 2131756467);
    paramContext.Xz(7);
    paramContext.setSingleLine(paramBoolean);
    paramContext.setContentView(2131559161);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.setMaxLength(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.UO(paramString3);
    paramContext.setNegativeButton(2131721058, paramOnClickListener2);
    paramContext.setPositiveButton(2131691441, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static aqky a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqky(paramContext, 2131756467);
    paramContext.setContentView(2131559164);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.UO(paramString);
    paramContext.setNegativeButton(2131721058, paramOnClickListener2);
    paramContext.setPositiveButton(2131721079, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static aqky a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqky(paramContext, 2131756467);
    paramContext.setContentView(2131559164);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramTextWatcher);
    paramContext.UO(paramString);
    paramContext.setNegativeButton(2131721058, paramOnClickListener2);
    paramContext.setPositiveButton(2131721079, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static aqky a(Context paramContext, int paramInt1, String paramString1, String paramString2, TextWatcher paramTextWatcher, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, int paramInt3, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqky(paramContext, 2131756467);
    paramContext.setContentView(2131559164);
    paramContext.setTitle(paramInt1);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramTextWatcher);
    paramContext.UO(paramString1);
    paramContext.UQ(paramString2);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt2, paramOnClickListener1);
    paramContext.show(true);
    return paramContext;
  }
  
  public static aqla a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new aqla(paramContext, 2131756467);
    paramContext.setSingleLine(paramBoolean);
    paramContext.setContentView(2131559166);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.setMaxLength(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setMessageCount(paramString3);
    paramContext.ff(paramArrayList);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.UR(paramString4);
    paramContext.setNegativeButton(2131721058, paramOnClickListener2);
    paramContext.setPositiveButton(2131691441, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static aqlh a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqlh(paramContext, 2131756467);
    paramContext.setContentView(2131559153);
    paramContext.a(paramString1.replace(acfp.m(2131705108), aofy.fx(21)).replace(acfp.m(2131705054), aofy.fx(18)).replace(acfp.m(2131705092), aofy.fx(86)).replace(acfp.m(2131705110), aofy.fx(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace(acfp.m(2131705091), aofy.fx(21)).replace(acfp.m(2131705080), aofy.fx(18)).replace(acfp.m(2131705098), aofy.fx(86)).replace(acfp.m(2131705105), aofy.fx(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130840092, 2131721058, paramOnClickListener2);
    paramContext.a(paramString3.replace(acfp.m(2131705059), aofy.fx(21)).replace(acfp.m(2131705109), aofy.fx(18)).replace(acfp.m(2131705112), aofy.fx(86)).replace(acfp.m(2131705056), aofy.fx(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static aqju b(Activity paramActivity)
  {
    aqhh localaqhh = new aqhh(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(acfp.m(2131711619));
    paramActivity.setMessage(acfp.m(2131709450));
    paramActivity.setNegativeButton(acfp.m(2131705090), localaqhh);
    paramActivity.setPositiveButton(acfp.m(2131705075), localaqhh);
    paramActivity.show();
    return paramActivity;
  }
  
  public static aqju b(Activity paramActivity, int paramInt)
  {
    aqju localaqju = a(paramActivity, 230);
    localaqju.setTitle(paramActivity.getString(2131700566));
    localaqju.setMessage(paramInt);
    localaqju.setNegativeButton(paramActivity.getString(2131721058), new aqhf(localaqju));
    localaqju.setPositiveButton(paramActivity.getString(2131719875), new aqhg(paramActivity));
    localaqju.setOnCancelListener(null);
    localaqju.show();
    return localaqju;
  }
  
  public static aqju b(Activity paramActivity, String paramString)
  {
    aqhi localaqhi = new aqhi(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(acfp.m(2131711619));
    paramActivity.setMessage(paramString);
    paramActivity.setNegativeButton(acfp.m(2131705090), localaqhi);
    paramActivity.setPositiveButton(acfp.m(2131705075), localaqhi);
    paramActivity.show();
    return paramActivity;
  }
  
  public static aqju b(Activity paramActivity, String paramString1, String paramString2)
  {
    aqhn localaqhn = new aqhn(paramActivity);
    aqju localaqju = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = acfp.m(2131705064);
    }
    localaqju.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = acfp.m(2131705114);
    }
    localaqju.setMessage(paramActivity);
    localaqju.setPositiveButton(acfp.m(2131705117), localaqhn);
    localaqju.show();
    return localaqju;
  }
  
  public static aqju b(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    aqju localaqju = a(paramActivity, 230);
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      str = paramActivity.getResources().getString(2131697640);
    }
    localaqju.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131697637);
    }
    localaqju.setMessage(paramString1);
    localaqju.setNegativeButton(paramActivity.getResources().getString(2131721058), paramOnClickListener1);
    localaqju.setPositiveButton(paramActivity.getResources().getString(2131721079), paramOnClickListener2);
    localaqju.setOnCancelListener(paramOnCancelListener);
    localaqju.show();
    return localaqju;
  }
  
  public static aqju b(Context paramContext, int paramInt)
  {
    return d(paramContext, paramInt, null, null, 2131721058, 2131721079, null, null);
  }
  
  public static aqju b(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static aqju b(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(2131559151);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131365841);
    paramString1 = (TextView)paramContext.findViewById(2131365863);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static aqju b(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(2131559135);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString4, paramOnClickListener3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static aqju c(Activity paramActivity, String paramString1, String paramString2)
  {
    aqhc localaqhc = new aqhc(paramActivity);
    return a(paramActivity, paramString1, paramString2, localaqhc, localaqhc, null);
  }
  
  public static aqju d(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(2131559151);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static String i(String... paramVarArgs)
  {
    String str2 = acfp.m(2131705094);
    String str1 = null;
    if (paramVarArgs != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramVarArgs.length;
      str1 = null;
      int i = 0;
      if (i < j)
      {
        String str3 = paramVarArgs[i];
        if ("android.permission.CAMERA".equals(str3)) {
          str1 = acfp.m(2131705063);
        }
        for (;;)
        {
          if ((str1 != null) && (localStringBuilder.indexOf(str1) < 0))
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append("和");
            }
            localStringBuilder.append(str1);
          }
          i += 1;
          break;
          if ("android.permission.RECORD_AUDIO".equals(str3)) {
            str1 = acfp.m(2131705077);
          } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
            str1 = acfp.m(2131705067);
          } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
            str1 = acfp.m(2131705084);
          } else if ("android.permission.READ_CALENDAR".equals(str3)) {
            str1 = acfp.m(2131705095);
          } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
            str1 = acfp.m(2131705101);
          } else if ("android.permission.SEND_SMS".equals(str3)) {
            str1 = acfp.m(2131705061);
          } else if ("android.permission.READ_CONTACTS".equals(str3)) {
            str1 = acfp.m(2131705068);
          } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
            str1 = acfp.m(2131705104);
          } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
            str1 = acfp.m(2131709451);
          } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
            str1 = acfp.m(2131709449);
          }
        }
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  protected static String pv(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.replace(acfp.m(2131705115), aofy.fx(21)).replace(acfp.m(2131705076), aofy.fx(18)).replace(acfp.m(2131705057), aofy.fx(86)).replace(acfp.m(2131705085), aofy.fx(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static class a
    implements DialogInterface.OnClickListener
  {
    public void onClick(DialogInterface paramDialogInterface, int paramInt) {}
  }
  
  public static abstract interface b
  {
    public abstract View a(Context paramContext, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqha
 * JD-Core Version:    0.7.0.1
 */