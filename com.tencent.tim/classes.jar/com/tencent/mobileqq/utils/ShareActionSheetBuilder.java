package com.tencent.mobileqq.utils;

import acha;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqme;
import ausj;
import auss;
import auvj;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheet.a;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import shb;

public class ShareActionSheetBuilder
  implements ShareActionSheet
{
  protected View Gt;
  protected int OC;
  protected Context V;
  protected c a;
  public TextView abA;
  protected CharSequence ac;
  public ausj an;
  public ImageView bG;
  public int bgc;
  public int bgd;
  protected boolean bpu;
  public ElasticHorScrView c;
  private boolean cUD;
  private String cuk;
  public ElasticHorScrView d;
  protected int dAc;
  protected int dAd;
  protected int dAe;
  protected int dAf;
  protected int dAg;
  protected List<ActionSheetItem>[] e;
  private ShareActionSheet g;
  protected AdapterView.OnItemClickListener j;
  public LinearLayout lg;
  protected TextView mTitleTv;
  protected GridView n;
  protected GridView o;
  protected boolean zO = true;
  
  public ShareActionSheetBuilder(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public ShareActionSheetBuilder(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, 1);
  }
  
  public ShareActionSheetBuilder(Context paramContext, boolean paramBoolean, int paramInt)
  {
    if (paramInt == 2)
    {
      ShareActionSheetV2.Param localParam = new ShareActionSheetV2.Param();
      localParam.context = paramContext;
      localParam.fullScreen = paramBoolean;
      this.g = ShareActionSheetFactory.create(localParam);
      return;
    }
    this.V = paramContext;
    if (paramBoolean)
    {
      this.an = ((ausj)auss.b(this.V, null));
      paramContext = this.V.getResources();
      this.OC = paramContext.getDimensionPixelSize(2131296957);
      this.dAd = this.OC;
      this.dAe = paramContext.getDimensionPixelOffset(2131296959);
      this.dAf = paramContext.getDimensionPixelOffset(2131296960);
      this.a = new c();
      paramInt = paramContext.getDisplayMetrics().widthPixels;
      int i = paramContext.getDisplayMetrics().heightPixels;
      if (paramInt <= i) {
        break label209;
      }
      paramInt = i;
    }
    label209:
    for (;;)
    {
      paramInt = (paramInt - (int)(getIconWidth() * 5.2F)) / (((int)5.2F + 1) * 2);
      setIconMarginLeftRight(paramInt);
      setRowMarginLeftRight((int)(paramInt * 6 / 5.5F));
      return;
      this.an = ((ausj)auss.a(this.V, null));
      break;
    }
  }
  
  protected static String G(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt) + "\n" + paramString.substring(paramInt);
      }
    }
    return str;
  }
  
  private static int a(TextPaint paramTextPaint, String paramString, float paramFloat)
  {
    int k;
    if (paramTextPaint.measureText(paramString) < paramFloat)
    {
      k = paramString.length();
      return k;
    }
    int i = 1;
    for (;;)
    {
      if (i > paramString.length()) {
        break label54;
      }
      k = i;
      if (paramTextPaint.measureText(paramString.substring(0, i)) > paramFloat) {
        break;
      }
      i += 1;
    }
    label54:
    return paramString.length();
  }
  
  protected static String a(TextPaint paramTextPaint, float paramFloat, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    String str;
    do
    {
      do
      {
        return paramString;
        i = a(paramTextPaint, paramString, paramFloat);
        if (!acha.isLocaleCN()) {
          break;
        }
        paramInt = Math.min(paramInt, i);
      } while (paramString.length() <= paramInt);
      str = paramString.substring(0, paramInt);
      paramString = paramString.substring(paramInt);
      paramInt = a(paramTextPaint, paramString, paramFloat);
      paramTextPaint = paramString;
      if (paramString.length() > paramInt) {
        paramTextPaint = paramString.substring(0, paramInt) + "..";
      }
      return str + "\n" + paramTextPaint;
    } while (paramString.length() <= i);
    paramTextPaint = new StringBuilder();
    paramString = paramString.split(" ");
    int k = paramString.length;
    paramInt = 0;
    for (;;)
    {
      int m;
      if (paramInt < k)
      {
        str = paramString[paramInt];
        m = paramTextPaint.toString().length() + str.length();
        if (m <= i * 2) {}
      }
      else
      {
        paramString = paramTextPaint.toString().trim();
        paramTextPaint = paramString;
        if (paramString.length() > i * 2) {
          paramTextPaint = paramString.substring(0, i) + "..";
        }
        return paramTextPaint;
      }
      if ((!paramTextPaint.toString().contains("\n")) && (m > i)) {
        paramTextPaint.append("\n");
      }
      paramTextPaint.append(str).append(" ");
      paramInt += 1;
    }
  }
  
  private void a(GridView paramGridView, List<ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    paramGridView.setOverScrollMode(2);
    Object localObject = paramList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (((ActionSheetItem)((Iterator)localObject).next()).visibility != 0) {
        break label187;
      }
      i += 1;
    }
    label187:
    for (;;)
    {
      break;
      int k = this.dAc + getIconWidth() + this.dAc;
      paramGridView.setColumnWidth(k);
      paramGridView.setNumColumns(i);
      localObject = paramGridView.getLayoutParams();
      paramGridView.setPadding(this.dAg, paramGridView.getPaddingTop(), this.dAg, paramGridView.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject).width = (k * i + this.dAg + this.dAg);
      ((ViewGroup.LayoutParams)localObject).height = (this.OC + this.dAe + paramStaticLayout.getHeight() + paramInt);
      paramGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramGridView.setAdapter(a(this.V, paramList));
      paramGridView.setSelector(new ColorDrawable(0));
      paramGridView.setOnItemClickListener(this.j);
      return;
    }
  }
  
  private void b(View paramView, List<ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    this.o = ((GridView)paramView.findViewById(2131368141));
    this.o.setSmoothScrollbarEnabled(false);
    a(this.o, paramList, paramStaticLayout, paramInt);
    this.bgc = this.o.getLayoutParams().width;
  }
  
  @TargetApi(9)
  protected View L()
  {
    View localView = View.inflate(this.V, Mc(), null);
    this.a.B((RelativeLayout)localView.findViewById(2131362258));
    this.lg = ((LinearLayout)localView.findViewById(2131362012));
    this.mTitleTv = ((TextView)localView.findViewById(2131362010));
    Object localObject2;
    Object localObject1;
    if (this.zO)
    {
      this.mTitleTv.setVisibility(0);
      if (this.ac != null) {
        this.mTitleTv.setText(this.ac);
      }
      this.c = ((ElasticHorScrView)localView.findViewById(2131377768));
      this.d = ((ElasticHorScrView)localView.findViewById(2131377769));
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label429;
      }
      localObject1 = localObject2[0];
      label143:
      if (!((List)localObject1).isEmpty()) {
        break label467;
      }
    }
    label168:
    label429:
    label462:
    label467:
    for (int i = 0;; i = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label462;
        }
      }
      for (int k = 0;; k = 1)
      {
        Object localObject4 = new TextPaint();
        ((TextPaint)localObject4).setTextSize(this.V.getResources().getDimensionPixelSize(2131299551));
        Object localObject3 = new StaticLayout(a((TextPaint)localObject4, this.dAd, q((List)localObject1), 5), (TextPaint)localObject4, this.dAd, Layout.Alignment.ALIGN_CENTER, 1.0F, this.dAf, true);
        localObject4 = new StaticLayout(a((TextPaint)localObject4, this.dAd, q((List)localObject2), 5), (TextPaint)localObject4, this.dAd, Layout.Alignment.ALIGN_CENTER, 1.0F, this.dAf, true);
        if (((StaticLayout)localObject3).getHeight() >= ((StaticLayout)localObject4).getHeight()) {}
        for (;;)
        {
          int m = this.V.getResources().getDimensionPixelOffset(2131296956);
          if (i != 0) {
            a(localView, (List)localObject1, (StaticLayout)localObject3, m);
          }
          if (k != 0) {
            b(localView, (List)localObject2, (StaticLayout)localObject3, m);
          }
          this.bG = ((ImageView)localView.findViewById(2131362002));
          this.bG.setOnClickListener(new aqme(this));
          if (i == 0) {
            this.c.setVisibility(8);
          }
          if (k == 0) {
            this.d.setVisibility(8);
          }
          localView.post(new ShareActionSheetBuilder.2(this));
          return localView;
          hideTitle();
          break;
          localObject1 = new ArrayList(0);
          break label143;
          localObject2 = new ArrayList(0);
          break label168;
          localObject3 = localObject4;
        }
      }
    }
  }
  
  protected int Mc()
  {
    return 2131559037;
  }
  
  protected a a(Context paramContext, List<ActionSheetItem> paramList)
  {
    return new a(paramContext, paramList);
  }
  
  protected void a(View paramView, List<ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    this.n = ((GridView)paramView.findViewById(2131368140));
    a(this.n, paramList, paramStaticLayout, paramInt);
    this.bgd = this.n.getLayoutParams().width;
  }
  
  protected void a(ElasticHorScrView paramElasticHorScrView, int paramInt)
  {
    boolean bool = true;
    int i = paramElasticHorScrView.getWidth();
    if (i < paramInt)
    {
      paramElasticHorScrView.setMove(true);
      if (QLog.isColorLevel())
      {
        paramElasticHorScrView = new StringBuilder().append("setMove, scrollViewLength = ").append(i).append("; gridViewLength = ").append(paramInt).append("; move = ");
        if (i >= paramInt) {
          break label88;
        }
      }
    }
    for (;;)
    {
      QLog.d("ShareActionSheetBuilder", 2, bool);
      return;
      paramElasticHorScrView.setMove(false);
      break;
      label88:
      bool = false;
    }
  }
  
  protected List<ActionSheetItem>[] a()
  {
    if (this.e != null) {
      return this.e;
    }
    return (List[])new ArrayList[0];
  }
  
  public void dismiss()
  {
    if (this.g != null) {
      this.g.dismiss();
    }
    do
    {
      return;
      setOpenSource(null);
    } while (!isShowing());
    try
    {
      this.an.dismiss();
      this.Gt = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.w("ShareActionSheetBuilder", 2, "Exception while dismiss", localRuntimeException);
    }
  }
  
  public void dismissImmediately()
  {
    if (this.g != null) {
      this.g.dismissImmediately();
    }
  }
  
  public View findViewById(int paramInt)
  {
    if (this.g != null) {
      return this.g.findViewById(paramInt);
    }
    Window localWindow = this.an.getWindow();
    if (localWindow != null) {
      return localWindow.findViewById(paramInt);
    }
    return null;
  }
  
  public ausj getActionSheet()
  {
    if (this.g != null) {
      return this.g.getActionSheet();
    }
    return this.an;
  }
  
  public int getIconMarginLeftRight()
  {
    return this.dAc;
  }
  
  public int getIconWidth()
  {
    if (this.g != null) {
      return this.g.getIconWidth();
    }
    return this.OC;
  }
  
  public String getOpenSource()
  {
    if (this.g != null) {
      return this.g.getOpenSource();
    }
    return this.cuk;
  }
  
  public Window getWindow()
  {
    if (this.g != null) {
      return this.g.getWindow();
    }
    return this.an.getWindow();
  }
  
  public void hideTitle()
  {
    if (this.g != null) {
      this.g.hideTitle();
    }
    do
    {
      return;
      this.zO = false;
    } while ((this.mTitleTv == null) || (this.mTitleTv.getVisibility() == 8));
    this.mTitleTv.setVisibility(8);
  }
  
  public boolean isShowing()
  {
    if (this.g != null) {
      return this.g.isShowing();
    }
    return this.an.isShowing();
  }
  
  public void onConfigurationChanged()
  {
    if (this.g != null) {
      this.g.onConfigurationChanged();
    }
    int i;
    do
    {
      do
      {
        return;
      } while (this.V == null);
      i = this.V.getResources().getDisplayMetrics().widthPixels - this.dAg;
    } while ((this.c == null) || (this.d == null));
    if (i < this.bgd) {
      this.c.setMove(true);
    }
    while (i < this.bgc)
    {
      this.d.setMove(true);
      return;
      this.c.setMove(false);
    }
    this.d.setMove(false);
  }
  
  protected String q(List<ActionSheetItem> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((ActionSheetItem)paramList.get(i)).label;
      if (str.length() <= ((String)localObject).length()) {
        break label55;
      }
      localObject = str;
    }
    label55:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public void refresh()
  {
    if (this.g != null) {
      this.g.refresh();
    }
  }
  
  public void setActionSheetItems(List<ActionSheetItem> paramList1, List<ActionSheetItem> paramList2) {}
  
  public void setActionSheetItems(List<ActionSheetItem>[] paramArrayOfList)
  {
    if (this.g != null)
    {
      this.g.setActionSheetItems(paramArrayOfList);
      return;
    }
    this.e = paramArrayOfList;
    this.bpu = true;
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    if (this.g != null) {
      this.g.setActionSheetTitle(paramCharSequence);
    }
    do
    {
      return;
      this.ac = paramCharSequence;
    } while (this.mTitleTv == null);
    this.mTitleTv.setText(this.ac);
  }
  
  public void setAdvBgColor(int paramInt)
  {
    if (this.g != null)
    {
      this.g.setAdvBgColor(paramInt);
      return;
    }
    this.a.setBgColor(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (this.g != null)
    {
      this.g.setAdvView(paramView, paramLayoutParams);
      return;
    }
    this.a.b(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.a parama)
  {
    if (this.g != null) {
      this.g.setBottomBarInterface(parama);
    }
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (this.g != null)
    {
      this.g.setCancelListener(paramOnCancelListener);
      return;
    }
    this.an.setOnCancelListener(paramOnCancelListener);
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    if (this.g != null)
    {
      this.g.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
      return;
    }
    this.cUD = paramBoolean;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    if (this.g != null) {
      this.g.setExtras(paramBundle);
    }
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    if (this.g != null)
    {
      this.g.setIconMarginLeftRight(paramInt);
      return;
    }
    this.dAc = paramInt;
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    if (this.g != null) {
      this.g.setIntentForStartForwardRecentActivity(paramIntent);
    }
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (this.g != null) {
      this.g.setItemClickListener(paramOnItemClickListener);
    }
    do
    {
      do
      {
        return;
        this.j = paramOnItemClickListener;
        this.bpu = true;
      } while (paramOnItemClickListener != null);
      if (this.n != null) {
        this.n.setOnItemClickListener(null);
      }
    } while (this.o == null);
    this.o.setOnItemClickListener(null);
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    if (this.g != null) {
      this.g.setItemClickListenerV2(paramOnItemClickListener);
    }
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.g != null) {
      this.g.setOnDismissListener(paramOnDismissListener);
    }
    while (this.an == null) {
      return;
    }
    this.an.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    if (this.g != null)
    {
      this.g.setOnShowListener(paramOnShowListener);
      return;
    }
    this.an.setOnShowListener(paramOnShowListener);
  }
  
  public void setOpenSource(String paramString)
  {
    if (this.g != null)
    {
      this.g.setOpenSource(paramString);
      return;
    }
    this.cuk = paramString;
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    if (this.g != null)
    {
      this.g.setRowMarginLeftRight(paramInt);
      return;
    }
    this.dAg = paramInt;
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.g != null) {
      this.g.setRowVisibility(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void setTitlePadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mTitleTv != null) {
      this.mTitleTv.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void show()
  {
    if (this.g != null) {
      this.g.show();
    }
    do
    {
      for (;;)
      {
        return;
        if ((this.Gt == null) || (this.bpu)) {
          this.Gt = L();
        }
        this.an.setActionContentView(this.Gt, null);
        try
        {
          if (!isShowing())
          {
            if (this.cUD) {
              shb.f(getWindow());
            }
            this.an.show();
            if (this.cUD)
            {
              shb.e(getWindow());
              shb.g(getWindow());
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareActionSheetBuilder", 2, "actionSheet.show exception=" + localException);
  }
  
  public void updateUI()
  {
    if (this.g != null) {
      this.g.updateUI();
    }
    while (!this.an.isShowing()) {
      return;
    }
    this.Gt = L();
    this.an.setActionContentView(this.Gt, null);
  }
  
  public void updateUIIfShowing()
  {
    if (this.g != null) {
      this.g.updateUIIfShowing();
    }
    while (!this.an.isShowing()) {
      return;
    }
    this.Gt = L();
    this.an.setActionContentView(this.Gt, null);
  }
  
  public static class ActionSheetItem
  {
    public static final int ACTION_ADBLOCK = 90;
    public static final int ACTION_ADD_COLOR_NOTE = 70;
    public static final int ACTION_ADD_FAVORITER = 6;
    public static final int ACTION_ADD_FRIEND = 35;
    public static final int ACTION_ADD_MINIAPP_TO_CURRENT_TROOP = 159;
    public static final int ACTION_ADD_SHORTCUT = 14;
    public static final int ACTION_ADD_TROOP_APP = 15;
    public static final int ACTION_ADD_VIDEO_TO_TOPIC = 134;
    public static final int ACTION_ADJUST_FONT_SIZE = 7;
    public static final int ACTION_CANCEL_ONLY_SEE_FRIEND = 103;
    public static final int ACTION_CARTON_DETAIL = 125;
    public static final int ACTION_CHANNEL_FACE2FACE_SHARE_TROOP = 24;
    public static final int ACTION_CHANNEL_QR_CODE = 23;
    public static final int ACTION_CHOOSE_FACE = 106;
    public static final int ACTION_COLORNOTE_UPCOMING = 139;
    public static final int ACTION_COMIC_SWITCH_SECRET_MODE_ = 33;
    public static final int ACTION_COPYLINK = 1;
    public static final int ACTION_COPY_SELF = 140;
    public static final int ACTION_DELETE = 40;
    public static final int ACTION_DELETE_FANS = 137;
    public static final int ACTION_DIRECT_SEND_TO_FRIEND = 41;
    public static final int ACTION_DIRECT_SEND_TO_STORY = 42;
    public static final int ACTION_DOWNLOAD = 124;
    public static final int ACTION_EDIT = 94;
    public static final int ACTION_EXPORT_TENCENT_DOCS = 68;
    public static final int ACTION_FAV_DETAIL = 130;
    public static final int ACTION_FAV_GROUP = 129;
    public static final int ACTION_FILE_CREATE_LINK = 122;
    public static final int ACTION_FILE_CREATE_QR = 123;
    public static final int ACTION_FILE_IMPORT_READER = 118;
    public static final int ACTION_FILE_IMPORT_TXDOC = 119;
    public static final int ACTION_FILE_PRINT = 121;
    public static final int ACTION_FILE_SAFE_FORWARD = 120;
    public static final int ACTION_FOLLOW = 87;
    public static final int ACTION_GALLERY_EMOTION_LIST = 65;
    public static final int ACTION_GALLERY_FILE_FORWARD_TO_PC = 67;
    public static final int ACTION_GALLERY_PIC_ADD_TO_EMO = 48;
    public static final int ACTION_GALLERY_PIC_FAVORITE = 57;
    public static final int ACTION_GALLERY_PIC_FORWARD_TO_FRIEND = 49;
    public static final int ACTION_GALLERY_PIC_FORWARD_TO_GROUP_ALBUM = 51;
    public static final int ACTION_GALLERY_PIC_FORWARD_TO_QZONE_ALBUM = 50;
    public static final int ACTION_GALLERY_PIC_LOCATE_TO_CHAT_POS = 54;
    public static final int ACTION_GALLERY_PIC_OCR = 52;
    public static final int ACTION_GALLERY_PIC_RECO_MINI = 56;
    public static final int ACTION_GALLERY_PIC_RECO_QR = 55;
    public static final int ACTION_GALLERY_PIC_REPORT = 66;
    public static final int ACTION_GALLERY_PIC_SAVE = 53;
    public static final int ACTION_GALLERY_PIC_SHARE_WEIYUN = 58;
    public static final int ACTION_GALLERY_SHARE_TO_WX = 69;
    public static final int ACTION_GALLERY_SHORTVIDEO_FAVORITE = 63;
    public static final int ACTION_GALLERY_SHORTVIDEO_FORWARD_TO_FRIEND = 59;
    public static final int ACTION_GALLERY_SHORTVIDEO_FORWARD_TO_QZONE = 60;
    public static final int ACTION_GALLERY_SHORTVIDEO_LOCATE_TO_CHAT_POS = 62;
    public static final int ACTION_GALLERY_SHORTVIDEO_OPEN_BY_OTHER_APP = 64;
    public static final int ACTION_GALLERY_SHORTVIDEO_SAVE = 61;
    public static final int ACTION_GALLERY_VIDEO_MINICODE = 127;
    public static final int ACTION_GALLERY_VIDEO_QRCODE = 126;
    public static final int ACTION_GO_FRIEND_AIO = 37;
    public static final int ACTION_GO_SUBSCRIPT_AIO = 30;
    public static final int ACTION_HIDE_FEED = 85;
    public static final int ACTION_HIDE_HIM = 86;
    public static final int ACTION_LAUNCH_CHAT = 92;
    public static final int ACTION_LOCALFILE_OPEN = 142;
    public static final int ACTION_LOCALFILE_PRINT = 141;
    public static final int ACTION_MINIAPP_ABOUT = 78;
    public static final int ACTION_MINIAPP_ADD_TO_MINE = 76;
    public static final int ACTION_MINIAPP_BACK_HOMEPAGE = 81;
    public static final int ACTION_MINIAPP_DEBUG_OFF = 75;
    public static final int ACTION_MINIAPP_DEBUG_ON = 74;
    public static final int ACTION_MINIAPP_PERFORMANCE_OFF = 80;
    public static final int ACTION_MINIAPP_PERFORMANCE_ON = 79;
    public static final int ACTION_MINIAPP_REMOVE_FROM_MINE = 77;
    public static final int ACTION_MINIAPP_RESTART_MINIAPP = 128;
    public static final int ACTION_NOT_CARE = 38;
    public static final int ACTION_ONLINE_EDIT = 143;
    public static final int ACTION_ONLY_SEE_FRIEND = 102;
    public static final int ACTION_OPEN_APP_DETAIL = 16;
    public static final int ACTION_OPEN_FILE_WITHOUT_DEFAULT_APP = 132;
    public static final int ACTION_OPEN_IN_QQ_BROWSER = 5;
    public static final int ACTION_OPEN_IN_SYS_BROWSER = 4;
    public static final int ACTION_OPEN_WEISHI_ACCOUNT = 45;
    public static final int ACTION_PA_REPORT = 36;
    public static final int ACTION_PITU = 105;
    public static final int ACTION_PRIVATE_MESSAGE = 138;
    public static final int ACTION_PROMOTION = 89;
    public static final int ACTION_PUPU_ADD_SHELF = 109;
    public static final int ACTION_PUPU_BOOKMARK = 110;
    public static final int ACTION_PUPU_BOOKMARK_CANCEL = 111;
    public static final int ACTION_PUPU_BOOK_DETAIL = 108;
    public static final int ACTION_PUPU_CONTINUE_PURCHASE = 114;
    public static final int ACTION_PUPU_CONTINUE_PURCHASE_CANCEL = 115;
    public static final int ACTION_PUPU_HIDE_OPINION = 112;
    public static final int ACTION_PUPU_PRIVACY = 116;
    public static final int ACTION_PUPU_PRIVACY_CANCEL = 117;
    public static final int ACTION_PUPU_SHOW_OPINION = 113;
    public static final int ACTION_REFRESH_TROOP_APP_VIEW = 18;
    public static final int ACTION_REMOVE_COLOR_NOTE = 82;
    public static final int ACTION_REMOVE_FAVORITE = 84;
    public static final int ACTION_REMOVE_VIDEO_FROM_TOPIC = 136;
    public static final int ACTION_REPORT = 11;
    public static final int ACTION_REPORT_DIS_LIKE = 44;
    public static final int ACTION_REPORT_VIDEO_NOT_LIKE = 22;
    public static final int ACTION_REPRINT_BLOG = 101;
    public static final int ACTION_REPRINT_PHOTO = 100;
    public static final int ACTION_RIJ_DELETE_TOPIC = 135;
    public static final int ACTION_RIJ_WATCH_WORD = 133;
    public static final int ACTION_SAVE = 39;
    public static final int ACTION_SAVE_CLOUD_FILE = 144;
    public static final int ACTION_SAVE_PIC = 43;
    public static final int ACTION_SAVE_TO_PICTURE = 47;
    public static final int ACTION_SCREEN_LONG_SHOT = 71;
    public static final int ACTION_SEND_TO_CLIPBOARD = 28;
    public static final int ACTION_SEND_TO_DIANDIAN = 34;
    public static final int ACTION_SEND_TO_EVERNOTE = 91;
    public static final int ACTION_SEND_TO_FRIEND = 2;
    public static final int ACTION_SEND_TO_MAIL = 25;
    public static final int ACTION_SEND_TO_MORE_FRIEND = 73;
    public static final int ACTION_SEND_TO_PC = 26;
    public static final int ACTION_SEND_TO_QIDIAN = 19;
    public static final int ACTION_SEND_TO_QIYEQQ = 20;
    public static final int ACTION_SEND_TO_QZONE = 3;
    public static final int ACTION_SEND_TO_READINJOY = 13;
    public static final int ACTION_SEND_TO_SINA = 12;
    public static final int ACTION_SEND_TO_SPECIFIED_FRIEND = 72;
    public static final int ACTION_SEND_TO_STORY_DISCOVER = 29;
    public static final int ACTION_SEND_TO_WECHAT = 9;
    public static final int ACTION_SEND_TO_WECHAT_CIRCLE = 10;
    public static final int ACTION_SEND_TO_WEIYUN = 27;
    public static final int ACTION_SETTING = 83;
    public static final int ACTION_SET_BACKGROUND = 107;
    public static final int ACTION_SET_DRESS = 98;
    public static final int ACTION_SET_MINIAPP_TO_TROOP = 158;
    public static final int ACTION_SET_PRIVATE = 95;
    public static final int ACTION_SET_TOP = 96;
    public static final int ACTION_SHARE_TROOP_APP = 17;
    public static final int ACTION_SHOW_MORE_INFO = 31;
    public static final int ACTION_SHOW_ORIGINALURL = 131;
    public static final int ACTION_TAKE_SCREEN_SHOT = 21;
    public static final int ACTION_UNFOLLOW = 32;
    public static final int ACTION_UN_SET_TOP = 97;
    public static final int ACTION_VIEW_DRESS = 99;
    public static final int ACTION_VIEW_PUB_ACCOUNT = 8;
    public static final int ACTION_WATCH_ON_TV = 104;
    public static final int ACTION_WATCH_ORIGINAL_VIDEO = 88;
    private static final int[] pa;
    private static final int[] pb;
    private IllegalStateException a;
    public int action;
    public String argus;
    public boolean enable = true;
    public int firstLineCount;
    public int icon;
    public Drawable iconDrawable;
    public boolean iconNeedBg = true;
    public int id;
    public String label;
    public View.OnClickListener listener;
    public String reportID;
    public String uin;
    public int uinType;
    public int visibility = 0;
    
    static
    {
      int j = 0;
      pa = new int[] { 2130847172, 2130847173, 2130847134, 2130847135, 2130847140, 2130847141, 2130847128, 2130847129, 2130847125, 2130847126, 2130847178, 2130847179, 2130847163, 2130847164, 2130847170, 2130847171, 2130847144, 2130847145, 2130847146, 2130847147, 2130847202, 2130847203, 2130847153, 2130847154, 2130847138, 2130847139, 2130844473, 2130844475, 2130844478, 2130844477, 2130845291, 2130845292, 2130843494, 2130847204, 2130847205, 2130839247, 2130839544, 2130839582, 2130847148, 2130847149, 2130847132, 2130847133, 2130843495, 2130843505, 2130843490, 2130843496, 2130843492, 2130847174, 2130847175, 2130847540, 2130847784, 2130839254, 2130843478, 2130847221, 2130843991, 2130847159, 2130847160, 2130847142, 2130847143, 2130847136, 2130847137, 2130847218, 2130847219, 2130847121, 2130847186, 2130847187, 2130847190, 2130847122, 2130847123, 2130847192, 2130847193, 2130847168, 2130847169, 2130845179, 2130851586, 2130851587, 2130847157, 2130847158, 2130847166, 2130847167, 2130847188, 2130847189, 2130850350, 2130847222, 2130850349, 2130847165, 2130840645, 2130850708, 2130850709, 2130840531, 2130842085, 2130842086, 2130842097, 2130847162, 2130842098, 2130842099, 2130842100, 2130842101, 2130847224, 2130847203, 2130842087, 2130842088, 2130842092, 2130842093, 2130842089, 2130842090, 2130842095, 2130842096, 2130843487, 2130848739, 2130848736, 2130848734, 2130848733, 2130848732, 2130848725, 2130848726, 2130848723, 2130848724, 2130848737, 2130848727, 2130848735, 2130848738, 2130849298, 2130848722, 2130848729, 2130849301, 2130849297, 2130847194, 2130847195, 2130843487, 2130842677, 2130842675, 2130842679, 2130842680, 2130842687, 2130842693, 2130842683, 2130842684, 2130842689, 2130842690, 2130840532, 2130845087, 2130837657, 2130837658, 2130840523, 2130845083, 2130845096, 2130845097, 2130845085, 2130845086, 2130845088, 2130845089, 2130845059, 2130845060, 2130845055, 2130845056, 2130845061, 2130845062, 2130845081, 2130845082, 2130840573, 2130840574, 2130840570, 2130840571, 2130850336, 2130850335, 2130850346, 2130850345, 2130850334, 2130850333, 2130850348, 2130850347, 2130850340, 2130850339, 2130850344, 2130850343, 2130850338, 2130850337, 2130850342, 2130850341, 2130841750, 2130841751 };
      HashSet localHashSet = new HashSet();
      int i = 0;
      if (i < pa.length)
      {
        if (localHashSet.contains(Integer.valueOf(pa[i]))) {
          QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated icon " + i + ", " + BaseApplicationImpl.getApplication().getResources().getResourceEntryName(pa[i]));
        }
        for (;;)
        {
          i += 1;
          break;
          localHashSet.add(Integer.valueOf(pa[i]));
        }
      }
      Arrays.sort(pa);
      pb = new int[] { 2131720099, 2131720119, 2131720120, 2131720090, 2131720052, 2131720053, 2131720091, 2131720124, 2131720149, 2131720074, 2131720096, 2131720146, 2131720147, 2131720148, 2131720137, 2131720050, 2131720103, 2131720118, 2131720098, 2131720100, 2131720142, 2131720059, 2131720102, 2131720130, 2131720128, 2131720129, 2131720060, 2131720121, 2131720070, 2131720125, 2131720062, 2131720061, 2131720067, 2131720065, 2131720068, 2131720066, 2131720069, 2131720081, 2131720076, 2131720077, 2131720049, 2131720064, 2131720104, 2131720127, 2131720063, 2131720131, 2131720078, 2131720054, 2131720058, 2131720057, 2131720055, 2131720141, 2131720122, 2131720075, 2131720094, 2131720095, 2131720126, 2131720106, 2131720079, 2131720080, 2131699455, 2131699458, 2131699461, 2131699460, 2131698635, 2131697470, 2131720139, 2131720092, 2131720093, 2131720089, 2131720140, 2131720145, 2131720107, 2131720056, 2131720085, 2131720097, 2131720084, 2131720134, 2131720135, 2131720138, 2131720133, 2131720143, 2131720123, 2131720101, 2131720071, 2131720082, 2131720144, 2131720105, 2131720073, 2131720132, 2131697470, 2131720109, 2131720108, 2131720110, 2131720111, 2131720114, 2131720117, 2131720112, 2131720113, 2131720115, 2131720116, 2131720087, 2131720086, 2131720088, 2131700295, 2131720116, 2131720107, 2131720056, 2131720116, 2131720042, 2131720048, 2131720044, 2131720046, 2131720047, 2131720043, 2131720045 };
      localHashSet = new HashSet();
      i = j;
      if (i < pb.length)
      {
        if (localHashSet.contains(Integer.valueOf(pb[i]))) {
          QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated label " + i + ", " + BaseApplicationImpl.getApplication().getResources().getResourceEntryName(pb[i]));
        }
        for (;;)
        {
          i += 1;
          break;
          localHashSet.add(Integer.valueOf(pb[i]));
        }
      }
      Arrays.sort(pb);
    }
    
    public ActionSheetItem()
    {
      if (!new java.lang.Throwable().getStackTrace()[1].getClassName().equals(ActionSheetItem.class.getName()))
      {
        this.a = new IllegalStateException("Must use method com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem.build(int) to create me !");
        QLog.e("ShareActionSheetBuilder", 1, "ActionSheetItem: ", this.a);
      }
    }
    
    private static ActionSheetItem A()
    {
      return a(2130848732, 2131720097, "open_aio");
    }
    
    private static ActionSheetItem B()
    {
      return a(2130848724, 2131720085, "Evernote");
    }
    
    private static ActionSheetItem C()
    {
      return a(2130849298, 2131720082, "delete");
    }
    
    private static ActionSheetItem D()
    {
      int i = 2130847170;
      if (auvj.isNightMode()) {
        i = 2130847171;
      }
      return a(i, 2131698657, "check_profile");
    }
    
    private static ActionSheetItem E()
    {
      int i = 2130850132;
      if (auvj.isNightMode()) {
        i = 2130850133;
      }
      return a(i, 2131720145, "orignal");
    }
    
    private static ActionSheetItem F()
    {
      return a(2130848738, 2131720140, "unfollow");
    }
    
    private static ActionSheetItem G()
    {
      return a(2130848735, 2131720089, "follow");
    }
    
    private static ActionSheetItem H()
    {
      return a(2130848727, 2131720093, "hide_him");
    }
    
    private static ActionSheetItem I()
    {
      int i = 2130847184;
      if (auvj.isNightMode()) {
        i = 2130847185;
      }
      return a(i, 2131720092, "hide_this_feed");
    }
    
    private static ActionSheetItem J()
    {
      return a(2130848737, 2131720139, "collect_cancel");
    }
    
    private static ActionSheetItem K()
    {
      int i = 2130847166;
      if (auvj.isNightMode()) {
        i = 2130847167;
      }
      return a(i, 2131720077, "colornote_cancel");
    }
    
    private static ActionSheetItem L()
    {
      int i = 2130845059;
      if (auvj.isNightMode()) {
        i = 2130845060;
      }
      return a(i, 2131720087, "fav_group");
    }
    
    private static ActionSheetItem M()
    {
      int i = 2130845055;
      if (auvj.isNightMode()) {
        i = 2130845056;
      }
      return a(i, 2131720086, "fav_detail");
    }
    
    private static ActionSheetItem N()
    {
      int i = 2130845061;
      if (auvj.isNightMode()) {
        i = 2130845062;
      }
      return a(i, 2131720088, "fav_show_originalurl");
    }
    
    private static ActionSheetItem O()
    {
      int i = 2130842087;
      if (auvj.isNightMode()) {
        i = 2130842088;
      }
      return a(i, 2131720070, "backtohome");
    }
    
    private static ActionSheetItem P()
    {
      int i = 2130842092;
      if (auvj.isNightMode()) {
        i = 2130842093;
      }
      return a(i, 2131720125, "restart_applet");
    }
    
    private static ActionSheetItem Q()
    {
      int i = 2130842100;
      if (auvj.isNightMode()) {
        i = 2130842101;
      }
      return a(i, 2131720121, "remove_my");
    }
    
    private static ActionSheetItem R()
    {
      int i = 2130842098;
      if (auvj.isNightMode()) {
        i = 2130842099;
      }
      return a(i, 2131720060, "add_my");
    }
    
    private static ActionSheetItem S()
    {
      int i = 2130842085;
      if (auvj.isNightMode()) {
        i = 2130842086;
      }
      return a(i, 2131720055, "about");
    }
    
    private static ActionSheetItem T()
    {
      int i = 2130842089;
      if (auvj.isNightMode()) {
        i = 2130842090;
      }
      return a(i, 2131720066, "applet_closeperformance");
    }
    
    private static ActionSheetItem U()
    {
      int i = 2130842089;
      if (auvj.isNightMode()) {
        i = 2130842090;
      }
      return a(i, 2131720068, "applet_openperformance");
    }
    
    private static ActionSheetItem V()
    {
      int i = 2130842089;
      if (auvj.isNightMode()) {
        i = 2130842090;
      }
      return a(i, 2131720065, "applet_closedebug");
    }
    
    private static ActionSheetItem W()
    {
      int i = 2130842089;
      if (auvj.isNightMode()) {
        i = 2130842090;
      }
      return a(i, 2131720067, "applet_opendebug");
    }
    
    private static ActionSheetItem X()
    {
      int i = 2130847188;
      if (auvj.isNightMode()) {
        i = 2130847189;
      }
      return a(i, 2131720098, "long_screenshot");
    }
    
    private static ActionSheetItem Y()
    {
      int i = 2130847157;
      if (auvj.isNightMode()) {
        i = 2130847158;
      }
      return a(i, 2131720076, "colornote");
    }
    
    private static ActionSheetItem Z()
    {
      int i = 2130851586;
      if (auvj.isNightMode()) {
        i = 2130851587;
      }
      return a(i, 2131720142, "url_to_txdoc");
    }
    
    private static ActionSheetItem a()
    {
      int i = 2130851896;
      if (auvj.isNightMode()) {
        i = 2130851897;
      }
      return a(i, 2131720083, "download");
    }
    
    private static ActionSheetItem a(int paramInt1, int paramInt2, String paramString)
    {
      return a(paramInt1, paramInt2, paramString, BaseApplicationImpl.getApplication().getResources());
    }
    
    private static ActionSheetItem a(int paramInt1, int paramInt2, String paramString, Resources paramResources)
    {
      ActionSheetItem localActionSheetItem = new ActionSheetItem();
      localActionSheetItem.icon = paramInt1;
      localActionSheetItem.label = paramResources.getString(paramInt2);
      localActionSheetItem.reportID = paramString;
      return localActionSheetItem;
    }
    
    private static ActionSheetItem aA()
    {
      int i = 2130847202;
      if (auvj.isNightMode()) {
        i = 2130847203;
      }
      return a(i, 2131720122, "report");
    }
    
    private static ActionSheetItem aB()
    {
      int i = 2130847146;
      if (auvj.isNightMode()) {
        i = 2130847147;
      }
      return a(i, 2131720147, "wechat_");
    }
    
    private static ActionSheetItem aC()
    {
      int i = 2130847144;
      if (auvj.isNightMode()) {
        i = 2130847145;
      }
      return a(i, 2131720146, "wechat");
    }
    
    private static ActionSheetItem aD()
    {
      int i = 2130847163;
      if (auvj.isNightMode()) {
        i = 2130847164;
      }
      return a(i, 2131720063, "adjust_font");
    }
    
    private static ActionSheetItem aE()
    {
      int i = 2130847178;
      if (auvj.isNightMode()) {
        i = 2130847179;
      }
      return a(i, 2131720075, "collect");
    }
    
    private static ActionSheetItem aF()
    {
      int i = 2130847125;
      if (auvj.isNightMode()) {
        i = 2130847126;
      }
      return a(i, 2131720050, "Qbrowser");
    }
    
    private static ActionSheetItem aG()
    {
      int i = 2130847128;
      if (auvj.isNightMode()) {
        i = 2130847129;
      }
      return a(i, 2131720137, "browser");
    }
    
    private static ActionSheetItem aH()
    {
      int i = 2130847140;
      if (auvj.isNightMode()) {
        i = 2130847141;
      }
      return a(i, 2131720052, "Qzone");
    }
    
    private static ActionSheetItem aI()
    {
      int i = 2130847134;
      if (auvj.isNightMode()) {
        i = 2130847135;
      }
      return a(i, 2131720090, "Qfriend");
    }
    
    private static ActionSheetItem aJ()
    {
      int i = 2130847172;
      if (auvj.isNightMode()) {
        i = 2130847173;
      }
      return a(i, 2131720078, "copy_link");
    }
    
    private static ActionSheetItem aK()
    {
      int i = 2130840532;
      if (auvj.isNightMode()) {
        i = 2130845087;
      }
      return a(i, 2131720094, "Import_reader");
    }
    
    private static ActionSheetItem aL()
    {
      int i = 2130837657;
      if (auvj.isNightMode()) {
        i = 2130837658;
      }
      return a(i, 2131720095, "edit_online");
    }
    
    private static ActionSheetItem aM()
    {
      int i = 2130840523;
      if (auvj.isNightMode()) {
        i = 2130845083;
      }
      return a(i, 2131720126, "safe_share");
    }
    
    private static ActionSheetItem aN()
    {
      int i = 2130845096;
      if (auvj.isNightMode()) {
        i = 2130845097;
      }
      return a(i, 2131720106, "print");
    }
    
    private static ActionSheetItem aO()
    {
      int i = 2130845085;
      if (auvj.isNightMode()) {
        i = 2130845086;
      }
      return a(i, 2131720079, "generate_link");
    }
    
    private static ActionSheetItem aP()
    {
      int i = 2130845081;
      if (auvj.isNightMode()) {
        i = 2130845082;
      }
      return a(i, 2131700295, "other_app");
    }
    
    private static ActionSheetItem aQ()
    {
      int i = 2130845088;
      if (auvj.isNightMode()) {
        i = 2130845089;
      }
      return a(i, 2131720080, "generate_QRcode");
    }
    
    private static ActionSheetItem aR()
    {
      int i = 2130840570;
      if (auvj.isNightMode()) {
        i = 2130840571;
      }
      return a(i, 2131720107, "ad_promotion");
    }
    
    private static ActionSheetItem aS()
    {
      int i = 2130840573;
      if (auvj.isNightMode()) {
        i = 2130840574;
      }
      return a(i, 2131720056, "ad_block");
    }
    
    private static ActionSheetItem aT()
    {
      if (auvj.isNightMode()) {}
      for (int i = 2130850333;; i = 2130850334) {
        return a(i, 2131720042, "addto_section");
      }
    }
    
    private static ActionSheetItem aU()
    {
      if (auvj.isNightMode()) {}
      for (int i = 2130850345;; i = 2130850346) {
        return a(i, 2131720046, "delete_section");
      }
    }
    
    private static ActionSheetItem aV()
    {
      if (auvj.isNightMode()) {}
      for (int i = 2130850335;; i = 2130850336) {
        return a(i, 2131720044, "delete_from_section");
      }
    }
    
    private static ActionSheetItem aW()
    {
      if (auvj.isNightMode()) {}
      for (int i = 2130850347;; i = 2130850348) {
        return a(i, 2131720048, "kouling_share");
      }
    }
    
    private static ActionSheetItem aX()
    {
      if (auvj.isNightMode()) {}
      for (int i = 2130850339;; i = 2130850340) {
        return a(i, 2131720047, "play_feedback");
      }
    }
    
    private static ActionSheetItem aY()
    {
      if (auvj.isNightMode()) {}
      for (int i = 2130850343;; i = 2130850344) {
        return a(i, 2131720043, "delete_fans");
      }
    }
    
    private static ActionSheetItem aZ()
    {
      if (auvj.isNightMode()) {}
      for (int i = 2130850337;; i = 2130850338) {
        return a(i, 2131697470, "share_more");
      }
    }
    
    private static ActionSheetItem aa()
    {
      int i = 2130847168;
      if (auvj.isNightMode()) {
        i = 2130847169;
      }
      return a(i, 2131720130, "search_emotion");
    }
    
    private static ActionSheetItem ab()
    {
      int i = 2130847192;
      if (auvj.isNightMode()) {
        i = 2130847193;
      }
      return a(i, 2131720103, "other_app");
    }
    
    private static ActionSheetItem ac()
    {
      int i = 2130847190;
      if (auvj.isNightMode()) {
        i = 2130847191;
      }
      return a(i, 2131720128, "scan_appletcode");
    }
    
    private static ActionSheetItem ad()
    {
      int i = 2130847204;
      if (auvj.isNightMode()) {
        i = 2130847205;
      }
      return a(i, 2131720129, "scan_qrcode");
    }
    
    private static ActionSheetItem ae()
    {
      int i = 2130847186;
      if (auvj.isNightMode()) {
        i = 2130847187;
      }
      return a(i, 2131720064, "aio_position");
    }
    
    private static ActionSheetItem af()
    {
      int i = 2130847218;
      if (auvj.isNightMode()) {
        i = 2130847219;
      }
      return a(i, 2131720104, "pick_words");
    }
    
    private static ActionSheetItem ag()
    {
      int i = 2130847136;
      if (auvj.isNightMode()) {
        i = 2130847137;
      }
      return a(i, 2131720091, "group_album");
    }
    
    private static ActionSheetItem ah()
    {
      int i = 2130847142;
      if (auvj.isNightMode()) {
        i = 2130847143;
      }
      return a(i, 2131720053, "Qzone_album");
    }
    
    private static ActionSheetItem ai()
    {
      int i = 2130847159;
      if (auvj.isNightMode()) {
        i = 2130847160;
      }
      return a(i, 2131720058, "add_emotion");
    }
    
    private static ActionSheetItem aj()
    {
      int i = 2130842095;
      if (auvj.isNightMode()) {
        i = 2130842096;
      }
      return a(i, 2131720118, "push_setup");
    }
    
    private static ActionSheetItem ak()
    {
      int i = 2130847221;
      if (auvj.isNightMode()) {
        i = 2130847222;
      }
      return a(i, 2131720141, "uninterested");
    }
    
    private static ActionSheetItem al()
    {
      int i = 2130847174;
      if (auvj.isNightMode()) {
        i = 2130847175;
      }
      return a(i, 2131720127, "save");
    }
    
    private static ActionSheetItem am()
    {
      int i = 2130850349;
      if (auvj.isNightMode()) {
        i = 2130847165;
      }
      return a(i, 2131720100, "not_care");
    }
    
    private static ActionSheetItem an()
    {
      if (auvj.isNightMode()) {}
      return a(2130843495, 2131697409, "open_aio");
    }
    
    private static ActionSheetItem ao()
    {
      if (auvj.isNightMode()) {}
      return a(2130843496, 2131720059, "add_friend");
    }
    
    private static ActionSheetItem ap()
    {
      if (auvj.isNightMode()) {}
      return a(2130843495, 2131720102, "open_aio");
    }
    
    private static ActionSheetItem aq()
    {
      int i = 2130847148;
      if (auvj.isNightMode()) {
        i = 2130847149;
      }
      return a(i, 2131720149, "weiyun");
    }
    
    private static ActionSheetItem ar()
    {
      int i = 2130847148;
      if (auvj.isNightMode()) {
        i = 2130847149;
      }
      return a(i, 2131720074, "cloudfile");
    }
    
    private static ActionSheetItem as()
    {
      int i = 2130847132;
      if (auvj.isNightMode()) {
        i = 2130847133;
      }
      return a(i, 2131720131, "sent_pc");
    }
    
    private static ActionSheetItem at()
    {
      int i = 2130847204;
      if (auvj.isNightMode()) {
        i = 2130847205;
      }
      return a(i, 2131720049, "QRcode");
    }
    
    private static ActionSheetItem au()
    {
      if (auvj.isNightMode()) {}
      return a(2130843494, 2131720054, "Screenshot_share");
    }
    
    private static ActionSheetItem av()
    {
      if (auvj.isNightMode()) {}
      return a(2130845292, 2131720120, "qiyeqq");
    }
    
    private static ActionSheetItem aw()
    {
      if (auvj.isNightMode()) {}
      return a(2130845291, 2131720119, "qidian");
    }
    
    private static ActionSheetItem ax()
    {
      int i = 2130842097;
      if (auvj.isNightMode()) {
        i = 2130847162;
      }
      return a(i, 2131720057, "add_desktop");
    }
    
    private static ActionSheetItem ay()
    {
      int i = 2130847138;
      if (auvj.isNightMode()) {
        i = 2130847139;
      }
      return a(i, 2131720096, "kandian");
    }
    
    private static ActionSheetItem az()
    {
      int i = 2130847153;
      if (auvj.isNightMode()) {
        i = 2130847154;
      }
      return a(i, 2131720148, "weibo");
    }
    
    private static ActionSheetItem b()
    {
      int i = 2130851894;
      if (auvj.isNightMode()) {
        i = 2130851895;
      }
      return a(i, 2131720072, "carton_detail");
    }
    
    private static ActionSheetItem ba()
    {
      if (auvj.isNightMode()) {}
      for (int i = 2130850341;; i = 2130850342) {
        return a(i, 2131720045, "private_chat");
      }
    }
    
    private static ActionSheetItem bb()
    {
      if (auvj.isNightMode()) {}
      for (int i = 2130841751;; i = 2130841750) {
        return a(i, 2131720062, "group_app");
      }
    }
    
    private static ActionSheetItem bc()
    {
      if (auvj.isNightMode()) {}
      for (int i = 2130841751;; i = 2130841750) {
        return a(i, 2131720061, "add_to_group");
      }
    }
    
    public static ActionSheetItem build(int paramInt)
    {
      ActionSheetItem localActionSheetItem1;
      switch (paramInt)
      {
      case 24: 
      case 25: 
      case 28: 
      case 29: 
      case 33: 
      case 36: 
      case 41: 
      case 42: 
      case 43: 
      case 46: 
      case 47: 
      case 49: 
      case 53: 
      case 57: 
      case 58: 
      case 59: 
      case 60: 
      case 61: 
      case 62: 
      case 63: 
      case 67: 
      case 69: 
      case 93: 
      case 139: 
      case 140: 
      case 141: 
      case 142: 
      case 143: 
      case 145: 
      case 146: 
      case 147: 
      case 148: 
      case 149: 
      case 150: 
      case 151: 
      case 152: 
      case 153: 
      case 154: 
      case 155: 
      case 156: 
      case 157: 
      default: 
        localActionSheetItem1 = new ActionSheetItem();
        QLog.e("ShareActionSheetBuilder", 1, "build: notSupportAction = [" + paramInt + "]", new IllegalArgumentException());
      }
      for (;;)
      {
        ActionSheetItem localActionSheetItem2 = localActionSheetItem1;
        if (localActionSheetItem1 == null)
        {
          localActionSheetItem2 = new ActionSheetItem();
          QLog.e("ShareActionSheetBuilder", 1, "build: notSupportAction = [" + paramInt + "]", new IllegalArgumentException());
        }
        localActionSheetItem2.action = paramInt;
        return localActionSheetItem2;
        localActionSheetItem1 = aJ();
        continue;
        localActionSheetItem1 = aI();
        continue;
        localActionSheetItem1 = aH();
        continue;
        localActionSheetItem1 = aG();
        continue;
        localActionSheetItem1 = aF();
        continue;
        localActionSheetItem1 = aE();
        continue;
        localActionSheetItem1 = aD();
        continue;
        localActionSheetItem1 = D();
        continue;
        localActionSheetItem1 = aC();
        continue;
        localActionSheetItem1 = aB();
        continue;
        localActionSheetItem1 = aA();
        continue;
        localActionSheetItem1 = az();
        continue;
        localActionSheetItem1 = ay();
        continue;
        localActionSheetItem1 = ax();
        continue;
        localActionSheetItem1 = aw();
        continue;
        localActionSheetItem1 = av();
        continue;
        localActionSheetItem1 = au();
        continue;
        localActionSheetItem1 = at();
        continue;
        localActionSheetItem1 = as();
        continue;
        localActionSheetItem1 = aq();
        continue;
        localActionSheetItem1 = ar();
        continue;
        localActionSheetItem1 = ap();
        continue;
        localActionSheetItem1 = ao();
        continue;
        localActionSheetItem1 = an();
        continue;
        localActionSheetItem1 = am();
        continue;
        localActionSheetItem1 = al();
        continue;
        localActionSheetItem1 = ak();
        continue;
        localActionSheetItem1 = aj();
        continue;
        localActionSheetItem1 = ai();
        continue;
        localActionSheetItem1 = ah();
        continue;
        localActionSheetItem1 = ag();
        continue;
        localActionSheetItem1 = af();
        continue;
        localActionSheetItem1 = ae();
        continue;
        localActionSheetItem1 = ad();
        continue;
        localActionSheetItem1 = ac();
        continue;
        localActionSheetItem1 = ab();
        continue;
        localActionSheetItem1 = aa();
        continue;
        localActionSheetItem1 = aA();
        continue;
        localActionSheetItem1 = Z();
        continue;
        localActionSheetItem1 = Y();
        continue;
        localActionSheetItem1 = X();
        continue;
        localActionSheetItem1 = a(2130840645, 2131720090, "");
        continue;
        localActionSheetItem1 = a(2130850708, 2131720099, "");
        continue;
        localActionSheetItem1 = W();
        continue;
        localActionSheetItem1 = V();
        continue;
        localActionSheetItem1 = U();
        continue;
        localActionSheetItem1 = T();
        continue;
        localActionSheetItem1 = S();
        continue;
        localActionSheetItem1 = R();
        continue;
        localActionSheetItem1 = Q();
        continue;
        localActionSheetItem1 = O();
        continue;
        localActionSheetItem1 = K();
        continue;
        localActionSheetItem1 = L();
        continue;
        localActionSheetItem1 = M();
        continue;
        localActionSheetItem1 = N();
        continue;
        localActionSheetItem1 = aK();
        continue;
        localActionSheetItem1 = aL();
        continue;
        localActionSheetItem1 = aM();
        continue;
        localActionSheetItem1 = aN();
        continue;
        localActionSheetItem1 = aO();
        continue;
        localActionSheetItem1 = aQ();
        continue;
        localActionSheetItem1 = a(2130844473, 2131699455, "add_troop_app");
        continue;
        localActionSheetItem1 = a(2130844475, 2131699458, "open_app_detail");
        continue;
        localActionSheetItem1 = a(2130844478, 2131699461, "share_troop_app");
        continue;
        localActionSheetItem1 = a(2130844477, 2131699460, "refresh_troop_app_view");
        continue;
        localActionSheetItem1 = a(2130843490, 2131698635, "share_diandian");
        continue;
        localActionSheetItem1 = aZ();
        continue;
        localActionSheetItem1 = J();
        continue;
        localActionSheetItem1 = I();
        continue;
        localActionSheetItem1 = H();
        continue;
        localActionSheetItem1 = G();
        continue;
        localActionSheetItem1 = F();
        continue;
        localActionSheetItem1 = E();
        continue;
        localActionSheetItem1 = C();
        continue;
        localActionSheetItem1 = B();
        continue;
        localActionSheetItem1 = A();
        continue;
        localActionSheetItem1 = z();
        continue;
        localActionSheetItem1 = y();
        continue;
        localActionSheetItem1 = x();
        continue;
        localActionSheetItem1 = w();
        continue;
        localActionSheetItem1 = v();
        continue;
        localActionSheetItem1 = u();
        continue;
        localActionSheetItem1 = t();
        continue;
        localActionSheetItem1 = s();
        continue;
        localActionSheetItem1 = r();
        continue;
        localActionSheetItem1 = q();
        continue;
        localActionSheetItem1 = p();
        continue;
        localActionSheetItem1 = o();
        continue;
        localActionSheetItem1 = n();
        continue;
        localActionSheetItem1 = m();
        continue;
        localActionSheetItem1 = a();
        continue;
        localActionSheetItem1 = b();
        continue;
        localActionSheetItem1 = c();
        continue;
        localActionSheetItem1 = d();
        continue;
        localActionSheetItem1 = e();
        continue;
        localActionSheetItem1 = f();
        continue;
        localActionSheetItem1 = g();
        continue;
        localActionSheetItem1 = h();
        continue;
        localActionSheetItem1 = i();
        continue;
        localActionSheetItem1 = j();
        continue;
        localActionSheetItem1 = k();
        continue;
        localActionSheetItem1 = l();
        continue;
        localActionSheetItem1 = P();
        continue;
        localActionSheetItem1 = aP();
        continue;
        localActionSheetItem1 = aS();
        continue;
        localActionSheetItem1 = aR();
        continue;
        localActionSheetItem1 = aT();
        continue;
        localActionSheetItem1 = aU();
        continue;
        localActionSheetItem1 = aV();
        continue;
        localActionSheetItem1 = aW();
        continue;
        localActionSheetItem1 = aX();
        continue;
        localActionSheetItem1 = aY();
        continue;
        localActionSheetItem1 = ba();
        continue;
        localActionSheetItem1 = bb();
        continue;
        localActionSheetItem1 = bc();
      }
    }
    
    private static ActionSheetItem c()
    {
      int i = 2130842677;
      if (auvj.isNightMode()) {
        i = 2130842678;
      }
      return a(i, 2131720109, "book_detail");
    }
    
    private static ActionSheetItem d()
    {
      int i = 2130842675;
      if (auvj.isNightMode()) {
        i = 2130842676;
      }
      return a(i, 2131720108, "add_shelf");
    }
    
    private static ActionSheetItem e()
    {
      int i = 2130842679;
      if (auvj.isNightMode()) {
        i = 2130842682;
      }
      return a(i, 2131720110, "bookmark");
    }
    
    private static ActionSheetItem f()
    {
      int i = 2130842680;
      if (auvj.isNightMode()) {
        i = 2130842681;
      }
      return a(i, 2131720111, "bookmark_cancel");
    }
    
    private static ActionSheetItem g()
    {
      int i = 2130842687;
      if (auvj.isNightMode()) {
        i = 2130842688;
      }
      return a(i, 2131720114, "hide_opinion");
    }
    
    private static ActionSheetItem h()
    {
      int i = 2130842693;
      if (auvj.isNightMode()) {
        i = 2130842694;
      }
      return a(i, 2131720117, "show_opinion");
    }
    
    private static ActionSheetItem i()
    {
      int i = 2130842683;
      if (auvj.isNightMode()) {
        i = 2130842686;
      }
      return a(i, 2131720112, "continue_purchase");
    }
    
    private static ActionSheetItem j()
    {
      int i = 2130842684;
      if (auvj.isNightMode()) {
        i = 2130842685;
      }
      return a(i, 2131720113, "continue_purchase_cancel");
    }
    
    private static ActionSheetItem k()
    {
      int i = 2130842689;
      if (auvj.isNightMode()) {
        i = 2130842692;
      }
      return a(i, 2131720115, "privacy");
    }
    
    private static ActionSheetItem l()
    {
      int i = 2130842690;
      if (auvj.isNightMode()) {
        i = 2130842691;
      }
      return a(i, 2131720116, "privacy_cancel");
    }
    
    private static ActionSheetItem m()
    {
      return a(2130849297, 2131720132, "set_background");
    }
    
    private static ActionSheetItem n()
    {
      return a(2130849301, 2131720073, "rec_face");
    }
    
    private static ActionSheetItem o()
    {
      return a(2130848729, 2131720105, "psapp");
    }
    
    private static ActionSheetItem p()
    {
      return a(2130848722, 2131720144, "watch_on_tv");
    }
    
    private static ActionSheetItem q()
    {
      return a(2130848725, 2131720071, "no_only_friend");
    }
    
    private static ActionSheetItem r()
    {
      int i = 2130847194;
      if (auvj.isNightMode()) {
        i = 2130847195;
      }
      return a(i, 2131720101, "only_friend");
    }
    
    private static ActionSheetItem s()
    {
      return a(2130848726, 2131720123, "reprint_diary");
    }
    
    private static ActionSheetItem t()
    {
      return a(2130848726, 2131720124, "reprint_photo");
    }
    
    private static ActionSheetItem u()
    {
      return a(2130848733, 2131720143, "look_dress");
    }
    
    private static ActionSheetItem v()
    {
      return a(2130848733, 2131720133, "set_card");
    }
    
    private static ActionSheetItem w()
    {
      return a(2130848739, 2131720138, "unstick");
    }
    
    private static ActionSheetItem x()
    {
      return a(2130848736, 2131720135, "stick");
    }
    
    private static ActionSheetItem y()
    {
      return a(2130848734, 2131720134, "privacy");
    }
    
    private static ActionSheetItem z()
    {
      return a(2130848723, 2131720084, "edit");
    }
    
    public boolean isValidCreate()
    {
      return this.a == null;
    }
    
    public boolean isValidIcon()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.iconNeedBg)
      {
        if (Arrays.binarySearch(pa, this.icon) < 0) {
          break label28;
        }
        bool1 = true;
      }
      label28:
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("ShareActionSheetBuilder", 2, this.label + " is in invalid icon " + this);
      return false;
    }
    
    public boolean isValidLabel()
    {
      boolean bool2 = false;
      Resources localResources = BaseApplicationImpl.getApplication().getResources();
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < pb.length)
        {
          if (TextUtils.equals(this.label, localResources.getString(pb[i]))) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
  }
  
  public static class a
    extends BaseAdapter
  {
    private int OE;
    private a a;
    private LayoutInflater inflater;
    private List<ShareActionSheetBuilder.ActionSheetItem> items;
    private Resources mRes;
    
    public a(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
    {
      this.items = paramList;
      this.inflater = LayoutInflater.from(paramContext);
    }
    
    protected a a(Context paramContext)
    {
      return new a(paramContext);
    }
    
    public ShareActionSheetBuilder.ActionSheetItem c(int paramInt)
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
      if ((this.items == null) || (paramInt < 0))
      {
        localActionSheetItem = null;
        return localActionSheetItem;
      }
      int j = -1;
      int i = 0;
      for (;;)
      {
        if (i >= this.items.size()) {
          break label89;
        }
        localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.items.get(i);
        int k = j;
        if (localActionSheetItem != null)
        {
          k = j;
          if (localActionSheetItem.visibility == 0) {
            k = j + 1;
          }
        }
        if (k == paramInt) {
          break;
        }
        i += 1;
        j = k;
      }
      label89:
      return null;
    }
    
    public int getCount()
    {
      if (this.items == null) {
        return 0;
      }
      Iterator localIterator = this.items.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
        if ((localActionSheetItem == null) || (localActionSheetItem.visibility != 0)) {
          break label60;
        }
        i += 1;
      }
      label60:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    protected int getLayoutId()
    {
      return 2131559035;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int j = 0;
      if (this.mRes == null) {
        this.mRes = paramViewGroup.getContext().getResources();
      }
      if (this.OE == 0) {
        this.OE = ((int)this.mRes.getDimension(2131296957));
      }
      if (this.a == null) {
        this.a = a(paramViewGroup.getContext());
      }
      View localView;
      if (paramView == null)
      {
        localView = this.inflater.inflate(getLayoutId(), paramViewGroup, false);
        paramView = new ShareActionSheetBuilder.b();
        paramView.vIcon = ((ImageView)localView.findViewById(2131378172));
        paramView.vLabel = ((TextView)localView.findViewById(2131378173));
        localView.setTag(paramView);
      }
      for (;;)
      {
        paramView.b = c(paramInt);
        if (paramView.b != null) {
          break;
        }
        QLog.e("ShareActionSheetBuilder", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject1 = (ShareActionSheetBuilder.b)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject1;
      }
      localView.setId(paramView.b.id);
      float f = this.mRes.getDimension(2131296957);
      Object localObject1 = paramView.vLabel.getPaint();
      ((TextPaint)localObject1).setTextSize(this.mRes.getDimensionPixelSize(2131299552));
      Object localObject2 = paramView.vLabel;
      String str = paramView.b.label;
      int i;
      if (paramView.b.firstLineCount > 0)
      {
        i = paramView.b.firstLineCount;
        label285:
        ((TextView)localObject2).setText(ShareActionSheetBuilder.a((TextPaint)localObject1, f, str, i));
        i = -8947849;
        localObject1 = paramView.vLabel;
        if (!paramView.b.enable) {
          break label498;
        }
        label321:
        ((TextView)localObject1).setTextColor(i);
        if (!paramView.b.iconNeedBg) {
          break label565;
        }
        if (paramView.b.iconDrawable == null) {
          break label506;
        }
        localObject1 = paramView.b.iconDrawable;
        label357:
        i = ((Drawable)localObject1).getIntrinsicWidth();
        int k = ((Drawable)localObject1).getIntrinsicHeight();
        if (this.OE <= i) {
          break label525;
        }
        i = (int)((this.OE - i) / 2.0F);
        label393:
        if (this.OE > k) {
          j = (int)((this.OE - k) / 2.0F);
        }
        localObject1 = this.a.a((Drawable)localObject1, i, j);
        if (!paramView.b.enable) {
          break label531;
        }
        localObject2 = a.a(this.a, (Drawable)localObject1);
        localObject1 = this.a.a((Drawable)localObject1, (Drawable)localObject2);
        paramView.vIcon.setImageDrawable((Drawable)localObject1);
        label473:
        if (Build.VERSION.SDK_INT < 16) {
          break label554;
        }
        paramView.vIcon.setBackground(null);
      }
      for (;;)
      {
        break;
        i = 5;
        break label285;
        label498:
        i = 2138535799;
        break label321;
        label506:
        localObject1 = this.mRes.getDrawable(paramView.b.icon);
        break label357;
        label525:
        i = 0;
        break label393;
        label531:
        localObject1 = a.b(this.a, (Drawable)localObject1);
        paramView.vIcon.setImageDrawable((Drawable)localObject1);
        break label473;
        label554:
        paramView.vIcon.setBackgroundDrawable(null);
        continue;
        label565:
        paramView.vIcon.setImageResource(2130837636);
        if (paramView.b.iconDrawable != null)
        {
          if (Build.VERSION.SDK_INT >= 16) {
            paramView.vIcon.setBackground(paramView.b.iconDrawable);
          } else {
            paramView.vIcon.setBackgroundDrawable(paramView.b.iconDrawable);
          }
        }
        else {
          paramView.vIcon.setBackgroundResource(paramView.b.icon);
        }
      }
    }
    
    public static class a
    {
      protected Drawable cy;
      protected Drawable cz;
      
      protected a(Context paramContext)
      {
        paramContext = paramContext.getResources();
        this.cy = paramContext.getDrawable(2130837635);
        this.cz = paramContext.getDrawable(2130837639);
      }
      
      private Drawable A(Drawable paramDrawable)
      {
        return new LayerDrawable(new Drawable[] { paramDrawable, this.cz });
      }
      
      private Drawable B(Drawable paramDrawable)
      {
        paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
        paramDrawable.setColorFilter(2147483647, PorterDuff.Mode.MULTIPLY);
        return paramDrawable;
      }
      
      Drawable a(Drawable paramDrawable, int paramInt1, int paramInt2)
      {
        paramDrawable = new LayerDrawable(new Drawable[] { this.cy, paramDrawable });
        paramDrawable.setLayerInset(1, paramInt1, paramInt2, paramInt1, paramInt2);
        return paramDrawable;
      }
      
      StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
      {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
        localStateListDrawable.addState(new int[0], paramDrawable1);
        return localStateListDrawable;
      }
    }
  }
  
  public static class b
  {
    public ShareActionSheetBuilder.ActionSheetItem b;
    public ImageView vIcon;
    public TextView vLabel;
  }
  
  public static class c
  {
    private View Gu;
    private ViewGroup ew;
    
    private void R(ViewGroup paramViewGroup)
    {
      if (paramViewGroup != null) {
        paramViewGroup.removeAllViews();
      }
    }
    
    private void bind()
    {
      if ((this.ew != null) && (this.Gu != null)) {
        this.ew.addView(this.Gu);
      }
    }
    
    private void is(View paramView)
    {
      if (paramView != null)
      {
        paramView = paramView.getParent();
        if ((paramView != null) && ((paramView instanceof ViewGroup))) {
          R((ViewGroup)paramView);
        }
      }
    }
    
    public void B(RelativeLayout paramRelativeLayout)
    {
      R(this.ew);
      R(paramRelativeLayout);
      this.ew = paramRelativeLayout;
      bind();
    }
    
    void b(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
    {
      is(this.Gu);
      is(paramView);
      if (paramView != null) {
        paramView.setLayoutParams(paramLayoutParams);
      }
      this.Gu = paramView;
      bind();
    }
    
    void setBgColor(int paramInt)
    {
      if (this.ew != null) {
        this.ew.setBackgroundColor(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */