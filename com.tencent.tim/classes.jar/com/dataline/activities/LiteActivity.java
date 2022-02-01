package com.dataline.activities;

import aa;
import ab;
import ac;
import acbn;
import acde;
import acdl;
import acff;
import acfp;
import ackv;
import acqp;
import acxt;
import aczy;
import ad;
import ae;
import aetp;
import aetq;
import aeub;
import aeuc;
import aeun;
import aeuo;
import aewn;
import af;
import afeh;
import ag;
import aghq;
import aghw;
import agkf;
import agkh;
import agmx;
import agne;
import ah;
import ahal;
import ahao;
import ahav;
import ahgg.a;
import ahgq;
import ahix;
import ahkr;
import ahyj;
import ai;
import aiyx;
import aj;
import ak;
import al;
import alkm;
import am;
import an;
import anaz;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import anpb;
import anre;
import ao;
import aobw;
import aofk;
import aofr;
import aoop;
import ap;
import aqfx;
import aqfy;
import aqgb;
import aqgq;
import aqha;
import aqhq;
import aqhs;
import aqhu;
import aqiw;
import aqjb;
import aqju;
import aqmr;
import aqoa;
import aqul;
import armm;
import as;
import at;
import au;
import aurf;
import ausj;
import auss;
import av;
import avfp;
import avin;
import avio;
import avja;
import aw;
import ax;
import ay;
import az;
import ba;
import bb;
import bc;
import bd;
import bg;
import bh;
import bi;
import bj;
import bk;
import bl;
import bm;
import bn;
import bo;
import bp;
import bq;
import br;
import bs;
import bt;
import bu;
import ci;
import com.dataline.util.file.SendInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.b;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.c;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.a;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.e;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.c;
import cu;
import db;
import dg;
import dl;
import dl.a;
import dl.c;
import dl.d;
import dl.e;
import dl.f;
import ilp;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tat;
import ujs;
import wja;
import wkj;
import wmj;
import wvo;
import xtm;
import y;
import z;

public class LiteActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, PanelIconLinearLayout.b, PanelIconLinearLayout.c, PhotoListPanel.a, XPanelContainer.c, Observer
{
  public static String TAG = "dataline.LiteActivity";
  protected static String msg;
  TextView A;
  TextView B;
  List<Long> H = new ArrayList();
  acdl jdField_a_of_type_Acdl = new ao(this);
  private aewn jdField_a_of_type_Aewn;
  aghq jdField_a_of_type_Aghq = new ax(this);
  ahgq jdField_a_of_type_Ahgq = null;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  public ImageButton a;
  aqju jdField_a_of_type_Aqju = null;
  c jdField_a_of_type_ComDatalineActivitiesLiteActivity$c;
  private InputLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
  PanelIconLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  PhotoListPanel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  protected TopGestureLayout a;
  public DataLineMsgSetList a;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public BubblePopupWindow a;
  public PatchedButton a;
  public XEditTextEx a;
  public XPanelContainer a;
  public db a;
  boolean aL = false;
  boolean aM = false;
  protected boolean aN;
  protected boolean aO;
  boolean aP = false;
  boolean aQ = true;
  public String aR = acbn.bkw;
  private boolean aS;
  private boolean aT;
  public View.OnClickListener b;
  public View.OnTouchListener b;
  private aqju c;
  public int cM = -1;
  int cN;
  private PointF downPoint = new PointF();
  protected RelativeLayout f;
  public ImageButton g;
  RelativeLayout jdField_g_of_type_AndroidWidgetRelativeLayout;
  Runnable jdField_g_of_type_JavaLangRunnable = new LiteActivity.37(this);
  ImageView h;
  public LinearLayout j;
  public View l;
  private boolean mIsFullScreenMode;
  public XListView mListView;
  Button o;
  public SessionInfo sessionInfo = new SessionInfo();
  public MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this);
  private boolean waiting;
  TextView y;
  
  public LiteActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = null;
    this.jdField_a_of_type_Db = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aj(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ak(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new at(this);
    this.jdField_b_of_type_AndroidViewView$OnTouchListener = new au(this);
  }
  
  private void F(String paramString)
  {
    aqju localaqju = new aqju(this, 2131756467);
    localaqju.setContentView(2131559151);
    localaqju.setTitle(getString(2131721103));
    localaqju.setMessage(paramString);
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.setCancelable(false);
    localaqju.setNegativeButton(getString(2131691039), new bi(this));
    localaqju.show();
  }
  
  private static void G(String paramString)
  {
    paramString = new VFSFile(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      return;
      paramString = paramString.listFiles();
      int k = paramString.length;
      int i = 0;
      while (i < k)
      {
        Object localObject = paramString[i];
        if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
          localObject.delete();
        }
        i += 1;
      }
    }
  }
  
  private void I(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.cM == 1)
      {
        this.B.setText(2131692406);
        this.h.setImageResource(2130840064);
      }
      return;
    }
    this.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  /* Error */
  private boolean J()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: iconst_1
    //   5: istore 4
    //   7: getstatic 307	android/os/Build$VERSION:SDK_INT	I
    //   10: bipush 23
    //   12: if_icmplt +93 -> 105
    //   15: iload_2
    //   16: istore_3
    //   17: aload_0
    //   18: ldc_w 309
    //   21: invokevirtual 313	com/dataline/activities/LiteActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   24: istore_1
    //   25: iload_1
    //   26: ifne +81 -> 107
    //   29: iconst_1
    //   30: istore_2
    //   31: iload_2
    //   32: ifeq +80 -> 112
    //   35: aload_0
    //   36: ldc_w 315
    //   39: invokevirtual 313	com/dataline/activities/LiteActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   42: ifne +70 -> 112
    //   45: iconst_1
    //   46: istore_2
    //   47: iload_2
    //   48: ifeq +69 -> 117
    //   51: aload_0
    //   52: ldc_w 317
    //   55: invokevirtual 313	com/dataline/activities/LiteActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   58: istore_1
    //   59: iload_1
    //   60: ifne +57 -> 117
    //   63: iload 4
    //   65: istore_2
    //   66: iload_2
    //   67: istore_3
    //   68: iload_2
    //   69: ifne +36 -> 105
    //   72: iload_2
    //   73: istore_3
    //   74: aload_0
    //   75: aload_0
    //   76: bipush 100
    //   78: iconst_3
    //   79: anewarray 319	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: ldc_w 309
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: ldc_w 315
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: ldc_w 317
    //   99: aastore
    //   100: invokevirtual 323	com/dataline/activities/LiteActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   103: iload_2
    //   104: istore_3
    //   105: iload_3
    //   106: ireturn
    //   107: iconst_0
    //   108: istore_2
    //   109: goto -78 -> 31
    //   112: iconst_0
    //   113: istore_2
    //   114: goto -67 -> 47
    //   117: iconst_0
    //   118: istore_2
    //   119: goto -53 -> 66
    //   122: astore 5
    //   124: aload 5
    //   126: invokevirtual 326	java/lang/Exception:printStackTrace	()V
    //   129: getstatic 111	com/dataline/activities/LiteActivity:TAG	Ljava/lang/String;
    //   132: iconst_2
    //   133: new 328	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 329	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 331
    //   143: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 5
    //   148: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 347	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: iload_3
    //   158: ireturn
    //   159: astore 5
    //   161: iload_2
    //   162: istore_3
    //   163: goto -39 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	LiteActivity
    //   24	36	1	i	int
    //   3	159	2	bool1	boolean
    //   1	162	3	bool2	boolean
    //   5	59	4	bool3	boolean
    //   122	25	5	localException1	Exception
    //   159	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   17	25	122	java/lang/Exception
    //   74	103	122	java/lang/Exception
    //   35	45	159	java/lang/Exception
    //   51	59	159	java/lang/Exception
  }
  
  private int a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt)
  {
    if (paramInt == -1000) {}
    do
    {
      return 1;
      if (paramInt == -2000) {
        return 2;
      }
      if (paramInt == -2009) {
        return 4;
      }
    } while (paramInt != -2005);
    paramInt = ahav.getFileType(paramDataLineMsgRecord.filename);
    if (paramInt == 0) {
      return 3;
    }
    if (paramInt == 2) {
      return 6;
    }
    return 7;
  }
  
  /* Error */
  private String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 379	com/dataline/activities/LiteActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aload 8
    //   8: aload_1
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokestatic 385	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +35 -> 55
    //   23: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +13 -> 39
    //   29: getstatic 111	com/dataline/activities/LiteActivity:TAG	Ljava/lang/String;
    //   32: iconst_2
    //   33: ldc_w 390
    //   36: invokestatic 393	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload 6
    //   41: ifnull +10 -> 51
    //   44: aload 6
    //   46: invokeinterface 398 1 0
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: areturn
    //   55: aload 6
    //   57: ldc_w 400
    //   60: invokeinterface 403 2 0
    //   65: istore_2
    //   66: aload 6
    //   68: ldc_w 405
    //   71: invokeinterface 408 2 0
    //   76: istore_3
    //   77: aload 6
    //   79: invokeinterface 411 1 0
    //   84: pop
    //   85: aload 6
    //   87: iload_3
    //   88: invokeinterface 415 2 0
    //   93: lstore 4
    //   95: lload 4
    //   97: l2f
    //   98: invokestatic 421	aqhq:bB	()F
    //   101: fcmpl
    //   102: ifle +27 -> 129
    //   105: aload_0
    //   106: ldc_w 422
    //   109: invokevirtual 223	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   112: putstatic 424	com/dataline/activities/LiteActivity:msg	Ljava/lang/String;
    //   115: aload 6
    //   117: ifnull +10 -> 127
    //   120: aload 6
    //   122: invokeinterface 398 1 0
    //   127: aconst_null
    //   128: areturn
    //   129: aload 6
    //   131: iload_2
    //   132: invokeinterface 425 2 0
    //   137: astore 7
    //   139: new 328	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 329	java/lang/StringBuilder:<init>	()V
    //   146: aload_0
    //   147: invokevirtual 429	com/dataline/activities/LiteActivity:getExternalCacheDir	()Ljava/io/File;
    //   150: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: ldc_w 431
    //   156: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 433
    //   162: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 431
    //   168: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore 9
    //   176: aload 9
    //   178: invokestatic 435	com/dataline/activities/LiteActivity:G	(Ljava/lang/String;)V
    //   181: new 328	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 329	java/lang/StringBuilder:<init>	()V
    //   188: aload 9
    //   190: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 9
    //   195: iconst_1
    //   196: anewarray 319	java/lang/String
    //   199: dup
    //   200: iconst_0
    //   201: aload 7
    //   203: aastore
    //   204: iconst_0
    //   205: aaload
    //   206: invokestatic 439	aqhq:bY	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   209: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: astore 7
    //   217: new 252	com/tencent/mm/vfs/VFSFile
    //   220: dup
    //   221: aload 9
    //   223: invokespecial 254	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   226: astore 9
    //   228: aload 9
    //   230: invokevirtual 258	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   233: ifne +35 -> 268
    //   236: aload 9
    //   238: invokevirtual 442	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   241: ifne +27 -> 268
    //   244: aload_0
    //   245: ldc_w 443
    //   248: invokestatic 448	acfp:m	(I)Ljava/lang/String;
    //   251: invokespecial 450	com/dataline/activities/LiteActivity:F	(Ljava/lang/String;)V
    //   254: aload 6
    //   256: ifnull +10 -> 266
    //   259: aload 6
    //   261: invokeinterface 398 1 0
    //   266: aconst_null
    //   267: areturn
    //   268: aload 8
    //   270: aload_1
    //   271: invokevirtual 456	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   274: astore_1
    //   275: aload_1
    //   276: ifnonnull +33 -> 309
    //   279: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +13 -> 295
    //   285: getstatic 111	com/dataline/activities/LiteActivity:TAG	Ljava/lang/String;
    //   288: iconst_2
    //   289: ldc_w 458
    //   292: invokestatic 393	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload 6
    //   297: ifnull +10 -> 307
    //   300: aload 6
    //   302: invokeinterface 398 1 0
    //   307: aconst_null
    //   308: areturn
    //   309: lload 4
    //   311: ldc2_w 459
    //   314: lcmp
    //   315: ifle +135 -> 450
    //   318: aload_0
    //   319: iconst_1
    //   320: putfield 462	com/dataline/activities/LiteActivity:waiting	Z
    //   323: new 209	aqju
    //   326: dup
    //   327: aload_0
    //   328: ldc 210
    //   330: invokespecial 213	aqju:<init>	(Landroid/content/Context;I)V
    //   333: astore 8
    //   335: aload 8
    //   337: ldc 214
    //   339: invokevirtual 218	aqju:setContentView	(I)V
    //   342: aload 8
    //   344: aload_0
    //   345: ldc 219
    //   347: invokevirtual 223	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   350: invokevirtual 227	aqju:setTitle	(Ljava/lang/String;)Laqju;
    //   353: pop
    //   354: aload 8
    //   356: aload_0
    //   357: ldc_w 463
    //   360: invokevirtual 223	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   363: invokevirtual 231	aqju:setMessage	(Ljava/lang/CharSequence;)Laqju;
    //   366: pop
    //   367: aload 8
    //   369: iconst_0
    //   370: invokevirtual 235	aqju:setCanceledOnTouchOutside	(Z)V
    //   373: aload 8
    //   375: iconst_0
    //   376: invokevirtual 238	aqju:setCancelable	(Z)V
    //   379: aload 8
    //   381: aload_0
    //   382: ldc_w 464
    //   385: invokevirtual 223	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   388: new 466	be
    //   391: dup
    //   392: aload_0
    //   393: aload_1
    //   394: invokespecial 469	be:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/io/InputStream;)V
    //   397: invokevirtual 246	aqju:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Laqju;
    //   400: pop
    //   401: aload 8
    //   403: aload_0
    //   404: ldc_w 470
    //   407: invokevirtual 223	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   410: new 472	bf
    //   413: dup
    //   414: aload_0
    //   415: aload 7
    //   417: aload_1
    //   418: lload 4
    //   420: invokespecial 475	bf:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   423: invokevirtual 478	aqju:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Laqju;
    //   426: pop
    //   427: aload 8
    //   429: invokevirtual 249	aqju:show	()V
    //   432: aload 7
    //   434: astore_1
    //   435: aload 6
    //   437: ifnull -384 -> 53
    //   440: aload 6
    //   442: invokeinterface 398 1 0
    //   447: aload 7
    //   449: areturn
    //   450: aload_0
    //   451: aload 7
    //   453: aload_1
    //   454: lload 4
    //   456: invokespecial 481	com/dataline/activities/LiteActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   459: goto -27 -> 432
    //   462: astore 7
    //   464: aload 6
    //   466: astore_1
    //   467: aload 7
    //   469: astore 6
    //   471: aload_0
    //   472: iconst_0
    //   473: putfield 483	com/dataline/activities/LiteActivity:aS	Z
    //   476: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +15 -> 494
    //   482: getstatic 111	com/dataline/activities/LiteActivity:TAG	Ljava/lang/String;
    //   485: iconst_2
    //   486: ldc_w 485
    //   489: aload 6
    //   491: invokestatic 488	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   494: aload_1
    //   495: ifnull +9 -> 504
    //   498: aload_1
    //   499: invokeinterface 398 1 0
    //   504: aconst_null
    //   505: areturn
    //   506: astore_1
    //   507: aconst_null
    //   508: astore 6
    //   510: aload 6
    //   512: ifnull +10 -> 522
    //   515: aload 6
    //   517: invokeinterface 398 1 0
    //   522: aload_1
    //   523: athrow
    //   524: astore_1
    //   525: goto -15 -> 510
    //   528: astore 7
    //   530: aload_1
    //   531: astore 6
    //   533: aload 7
    //   535: astore_1
    //   536: goto -26 -> 510
    //   539: astore 6
    //   541: aconst_null
    //   542: astore_1
    //   543: goto -72 -> 471
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	546	0	this	LiteActivity
    //   0	546	1	paramUri	Uri
    //   65	67	2	i	int
    //   76	12	3	k	int
    //   93	362	4	l1	long
    //   16	516	6	localObject1	Object
    //   539	1	6	localException1	Exception
    //   137	315	7	str	String
    //   462	6	7	localException2	Exception
    //   528	6	7	localObject2	Object
    //   4	424	8	localObject3	Object
    //   174	63	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   23	39	462	java/lang/Exception
    //   55	115	462	java/lang/Exception
    //   129	254	462	java/lang/Exception
    //   268	275	462	java/lang/Exception
    //   279	295	462	java/lang/Exception
    //   318	432	462	java/lang/Exception
    //   450	459	462	java/lang/Exception
    //   6	18	506	finally
    //   23	39	524	finally
    //   55	115	524	finally
    //   129	254	524	finally
    //   268	275	524	finally
    //   279	295	524	finally
    //   318	432	524	finally
    //   450	459	524	finally
    //   471	494	528	finally
    //   6	18	539	java/lang/Exception
  }
  
  static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    View localView = paramIphoneTitleBarActivity.findViewById(2131370600);
    if (ThemeUtil.isInNightMode(paramIphoneTitleBarActivity.app)) {
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    while (localView == null) {
      return;
    }
    localView.setVisibility(8);
  }
  
  public static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = wkj.getSharedPreferences(paramIphoneTitleBarActivity, paramIphoneTitleBarActivity.app.getCurrentAccountUin(), 0);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = acbn.bkw;
    arrayOfString[1] = "chat_uniform_bg";
    if ((localSharedPreferences.getString(arrayOfString[0], null) == null) && (localSharedPreferences.getString(arrayOfString[1], null) == null))
    {
      a(paramIphoneTitleBarActivity, paramViewGroup, "null");
      return;
    }
    int k = arrayOfString.length;
    for (;;)
    {
      if (i >= k) {
        break label188;
      }
      String str = localSharedPreferences.getString(arrayOfString[i], null);
      if (str != null)
      {
        if (("".equals(str)) || ("null".equals(str)) || ("none".equals(str)))
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, str);
          return;
        }
        if (!new VFSFile(str).exists())
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, "null");
          return;
        }
        if (a(paramIphoneTitleBarActivity, paramViewGroup, str)) {
          break;
        }
      }
      i += 1;
    }
    label188:
    a(paramIphoneTitleBarActivity, paramViewGroup, "null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    a(paramString, paramContext, new af(paramQQAppInterface, paramString));
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt, String paramString)
  {
    anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_save2weiyun");
    long l1 = aqhq.getFileSizes(paramString);
    String str = ahav.getFileName(paramString);
    FileManagerEntity localFileManagerEntity = null;
    if (paramDataLineMsgRecord.nWeiyunSessionId != 0L) {
      localFileManagerEntity = this.app.a().b(paramDataLineMsgRecord.nWeiyunSessionId);
    }
    if ((ahav.amK()) && (l1 > agmx.fJ()))
    {
      if (armm.a(getActivity(), 5, new bp(this, paramDataLineMsgRecord, localFileManagerEntity, str, paramString))) {
        ahal.a(getActivity(), 2131693826, 2131693830, new bq(this, paramDataLineMsgRecord, localFileManagerEntity, str, paramString));
      }
      if (paramInt != -2000) {
        break label343;
      }
      paramInt = 1;
    }
    for (;;)
    {
      int i = ae();
      anot.a(this.app, "dc00898", "", "", "0X800AD60", "0X800AD60", paramInt, 0, "" + i, "", "", "");
      return;
      if (localFileManagerEntity == null)
      {
        i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
        ahao.JE(ahav.kY(str) + getString(2131694099));
        paramDataLineMsgRecord.nWeiyunSessionId = this.app.a().a(paramString, null, this.app.getAccount(), 0, false).nSessionId;
        this.app.b().a(i).ig(paramDataLineMsgRecord.msgId);
        break;
      }
      ahao.JE(ahav.kY(str) + getString(2131694099));
      this.app.a().jk(paramDataLineMsgRecord.nWeiyunSessionId);
      break;
      label343:
      if (paramInt == -2005)
      {
        paramInt = ahav.getFileType(paramDataLineMsgRecord.filename);
        if (paramInt == 0) {
          paramInt = 2;
        }
        for (;;)
        {
          break;
          if (paramInt == 2) {
            paramInt = 3;
          } else {
            paramInt = 4;
          }
        }
      }
      paramInt = 4;
    }
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet)
  {
    MessageForPic localMessageForPic = null;
    int i;
    if (paramDataLineMsgSet == null)
    {
      i = 1;
      paramDataLineMsgSet = localMessageForPic;
    }
    for (;;)
    {
      if (i != 0)
      {
        QQToast.a(getApplicationContext(), getString(2131696978), 0).show(getResources().getDimensionPixelSize(2131299627));
        return;
        ArrayList localArrayList = paramDataLineMsgSet.values();
        if ((localArrayList == null) || (localArrayList.size() == 0))
        {
          i = 1;
          paramDataLineMsgSet = localMessageForPic;
          continue;
        }
        paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
        if (paramDataLineMsgSet == null) {
          i = 1;
        }
      }
      else
      {
        localMessageForPic = new MessageForPic();
        localMessageForPic.size = paramDataLineMsgSet.filesize;
        localMessageForPic.senderuin = paramDataLineMsgSet.senderuin;
        localMessageForPic.selfuin = this.app.getAccount();
        localMessageForPic.frienduin = paramDataLineMsgSet.frienduin;
        localMessageForPic.time = paramDataLineMsgSet.time;
        localMessageForPic.issend = paramDataLineMsgSet.issend;
        localMessageForPic.uuid = paramDataLineMsgSet.serverPath;
        localMessageForPic.busiType = paramDataLineMsgSet.busId;
        localMessageForPic.istroop = 7;
        localMessageForPic.subVersion = 5;
        localMessageForPic.path = paramDataLineMsgSet.path;
        QLog.i(TAG, 1, "savePicsAsCustomFace, path:" + localMessageForPic.path + " uuid:" + localMessageForPic.uuid + " size:" + localMessageForPic.size);
        if ((aqhq.fileExists(localMessageForPic.path)) && (paramDataLineMsgSet.md5 == null))
        {
          QLog.i(TAG, 1, "savePicsAsCustomFace, calc md5!");
          ThreadManager.executeOnSubThread(new LiteActivity.30(this, localMessageForPic));
          return;
        }
        localMessageForPic.md5 = aqhs.bytes2HexStr(paramDataLineMsgSet.md5);
        a(localMessageForPic);
        return;
      }
      i = 0;
    }
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet, DataLineMsgRecord paramDataLineMsgRecord, int paramInt)
  {
    int i = 1;
    a(paramDataLineMsgSet);
    if (paramInt == -2000) {}
    for (;;)
    {
      paramInt = ae();
      anot.a(this.app, "dc00898", "", "", "0X800AD61", "0X800AD61", i, 0, "" + paramInt, "", "", "");
      return;
      if (paramInt == -2005) {
        if (ahav.getFileType(paramDataLineMsgRecord.filename) == 0) {
          i = 3;
        } else {
          i = 2;
        }
      }
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null)
    {
      QQToast.a(getApplicationContext(), getString(2131696978), 0).show(getResources().getDimensionPixelSize(2131299627));
      return;
    }
    QLog.i(TAG, 1, "savePicsAsCustomFace, md5:" + paramMessageForPic.md5);
    URLDrawable localURLDrawable = aoop.getDrawable(aoop.a(paramMessageForPic, 1, "datalineface"), -1, -1, null, null, false);
    localURLDrawable.setTag(paramMessageForPic);
    xtm.a(this, this.app, localURLDrawable, paramMessageForPic.frienduin, getResources().getDimensionPixelSize(2131299627), null, paramMessageForPic.picExtraData);
  }
  
  public static void a(ScrollerRunnable paramScrollerRunnable, XListView paramXListView)
  {
    if (paramXListView != null) {
      paramXListView.postDelayed(new LiteActivity.28(paramXListView, paramScrollerRunnable), 200L);
    }
  }
  
  static void a(ScrollerRunnable paramScrollerRunnable, XListView paramXListView, int paramInt)
  {
    if (paramXListView != null) {}
    try
    {
      paramScrollerRunnable.a(paramInt, -1, null, 3);
      paramXListView.setTranscriptMode(1);
      return;
    }
    catch (SecurityException paramScrollerRunnable)
    {
      for (;;)
      {
        paramXListView.setSelection(paramInt);
      }
    }
    catch (IllegalArgumentException paramScrollerRunnable)
    {
      for (;;)
      {
        paramXListView.setSelection(paramInt);
      }
    }
  }
  
  public static void a(XListView paramXListView)
  {
    if (paramXListView != null) {
      paramXListView.setSelection(paramXListView.getCount());
    }
  }
  
  static void a(String paramString, Context paramContext, a parama)
  {
    ThreadManager.executeOnSubThread(new LiteActivity.20(paramContext, paramString, parama));
  }
  
  static void a(String paramString, b paramb)
  {
    ThreadManager.executeOnSubThread(new LiteActivity.15(paramString, paramb));
  }
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.aS = true;
    ThreadManager.post(new LiteActivity.46(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.c == null)
    {
      this.c = aqha.a(this, getString(2131692335), acfp.m(2131707822), new bg(this));
      this.c.setOnDismissListener(new bh(this));
    }
    this.c.show();
  }
  
  static boolean a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup, String paramString)
  {
    String str = (String)paramViewGroup.getTag(2131361821);
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
      if (!"null".equals(str))
      {
        paramViewGroup.setBackgroundDrawable(b(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131361821, "null");
      }
    }
    for (;;)
    {
      return true;
      if ("none".equals(paramString))
      {
        paramViewGroup.setBackgroundDrawable(b(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131361821, "null");
      }
      else if (!paramString.equals(str))
      {
        a(paramString, new ab(paramIphoneTitleBarActivity, paramString, paramViewGroup));
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong == 0L) {}
    do
    {
      do
      {
        return true;
        paramQQAppInterface = paramQQAppInterface.a().b(paramLong);
      } while (paramQQAppInterface == null);
      if ((paramQQAppInterface.getCloudType() != 2) && (paramQQAppInterface.status == 1)) {
        return false;
      }
      if (paramQQAppInterface.nOpType != 6) {
        return false;
      }
    } while (paramQQAppInterface.status != 1);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    return a(paramQQAppInterface, paramDataLineMsgRecord.nWeiyunSessionId);
  }
  
  @TargetApi(19)
  private void aH()
  {
    this.aT = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131381443));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    if (!this.aT) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.iD(this.mContentView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.iE(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.ae(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.bg(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.YK(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDirtyListener(new ah(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onCreate();
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new as(this);
    this.mListView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private void aK()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.setToastIcon(QQToast.getIconRes(1));
    localQQToast.setType(1);
    localQQToast.setDuration(2000);
    localQQToast.setToastMsg(2131695722);
    localQQToast.show();
  }
  
  private int ae()
  {
    if (this.cM == 0) {
      return 1;
    }
    if (this.cM == 1) {
      return 2;
    }
    return 0;
  }
  
  static Drawable b(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = Shader.TileMode.REPEAT;
        Drawable localDrawable = paramContext.getResources().getDrawable(2130839260);
        if ((localDrawable instanceof BitmapDrawable))
        {
          localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
          paramString = ((BitmapDrawable)localDrawable).getTileModeX();
          i = ((BitmapDrawable)localDrawable).getGravity();
          if ((localBitmap == null) || (paramString == Shader.TileMode.REPEAT) || (i != 48)) {
            return paramContext.getResources().getDrawable(2130839260);
          }
        }
        else
        {
          if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
            break label195;
          }
          localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
          paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
          i = ((SkinnableBitmapDrawable)localDrawable).getGravity();
          continue;
        }
        paramString = new afeh(paramContext.getResources(), localBitmap);
        paramString.setGravity(i);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiteActivity setAIOBackgroundBmp 1", 2, paramString.getMessage());
        }
        return paramContext.getResources().getDrawable(2130851037);
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiteActivity setAIOBackgroundBmp 2", 2, paramString.getMessage());
        }
        return paramContext.getResources().getDrawable(2130851037);
      }
      label195:
      int i = 119;
      Bitmap localBitmap = null;
    }
  }
  
  private void bF()
  {
    if (this.c != null) {
      this.c.dismiss();
    }
  }
  
  private void bG()
  {
    if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$c == null) {
      return;
    }
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$c.bO();
  }
  
  private void bl()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", acbn.bkw);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qfile_entrance_type_key", 11);
    localIntent.putExtra("select_file_support_send_docs_file", aeuo.a().aib());
    startActivityForResult(localIntent, 2);
    overridePendingTransition(2130771991, 2130771992);
    anot.a(this.app, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
  }
  
  private void bs()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
    }
    while (i == 0) {
      if (!this.aP)
      {
        I(true);
        return;
        i = 0;
      }
      else
      {
        I(false);
        return;
      }
    }
    I(false);
  }
  
  private View c()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = ((PhotoListPanel)View.inflate(this, 2131561200, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setCustomOnClickListener(this);
    Intent localIntent = new Intent();
    String str1 = this.app.getAccount();
    Object localObject = ((acff)this.app.getManager(51)).e(str1);
    if (localObject != null) {}
    for (localObject = ((Friends)localObject).name;; localObject = null)
    {
      String str2 = this.app.getCustomFaceFilePath(1, str1, 0);
      localIntent.putExtra("key_my_uin", str1);
      localIntent.putExtra("key_my_nick", (String)localObject);
      localIntent.putExtra("key_my_head_dir", str2);
      localIntent.putExtra("key_disable_presend", true);
      localIntent.putExtra("key_disable_quality_cb", true);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 50);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 100000002432L);
      localIntent.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005F28");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(this.app, this, this.sessionInfo, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(new bc(this));
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenPhotolistPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    }
  }
  
  public static void s(Context paramContext)
  {
    ae localae = new ae();
    aqha.a(paramContext, 233, paramContext.getString(2131721103), paramContext.getString(2131695398), 2131695387, 2131695387, localae, null).show();
  }
  
  private void send()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktxt");
      u(new aofk(str, 13, 32, 6000).toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    }
  }
  
  public static void t(Context paramContext)
  {
    bk localbk = new bk();
    aqha.a(paramContext, 233, paramContext.getString(2131721103), paramContext.getString(2131695404), 2131695387, 2131695387, localbk, null).show();
  }
  
  public String B()
  {
    if (msg == null) {
      return getString(2131720159);
    }
    return msg;
  }
  
  void E(String paramString)
  {
    if (paramString == null) {
      return;
    }
    acde localacde = (acde)this.app.getBusinessHandler(8);
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.path = paramString;
    localDataLineMsgRecord.msgtype = -2009;
    localacde.a(localDataLineMsgRecord, false);
  }
  
  protected boolean H()
  {
    return this.aQ;
  }
  
  boolean I()
  {
    ackv localackv = (ackv)this.app.getBusinessHandler(10);
    return (localackv.bi() == 0) || (localackv.AO() != 0);
  }
  
  public void K(boolean paramBoolean)
  {
    this.mIsFullScreenMode = false;
    L(true);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.j.setVisibility(0);
    this.o.setEnabled(this.jdField_a_of_type_ComTencentWidgetPatchedButton.isEnabled());
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height = -2;
    this.l.getLayoutParams().height = -2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, wja.dp2px(8.0F, this.app.getApplication().getResources()), 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(wja.dp2px(14.0F, this.app.getApplication().getResources()), 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130850843);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(wja.dp2px(11.0F, this.app.getApplication().getResources()), wja.dp2px(6.0F, this.app.getApplication().getResources()), wja.dp2px(11.0F, this.app.getApplication().getResources()), wja.dp2px(6.0F, this.app.getApplication().getResources()));
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getHeight(), wja.dp2px(100.0F, this.app.getApplication().getResources()) });
    localValueAnimator.addUpdateListener(new bl(this));
    localValueAnimator.addListener(new bm(this));
    localValueAnimator.setDuration(100L).setRepeatCount(0);
    localValueAnimator.start();
  }
  
  public void L(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 4) {
      if (Build.VERSION.SDK_INT < 23) {
        break label58;
      }
    }
    label58:
    for (boolean bool = aczy.bd(this);; bool = true)
    {
      if (!bool)
      {
        requestPermissions(new bb(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return null;
      }
      return c();
    }
  }
  
  DataLineMsgRecord a(acde paramacde, SendInfo paramSendInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSendInfo == null) {
      return null;
    }
    paramacde = new DataLineMsgRecord();
    String str1 = paramSendInfo.getPath();
    String str2 = paramSendInfo.L();
    paramacde.sessionid = paramSendInfo.getMsgId();
    paramacde.path = str1;
    paramacde.thumbPath = str2;
    paramacde.msgtype = acde.gu(paramInt1);
    paramacde.groupId = paramInt2;
    paramacde.groupSize = paramInt3;
    paramacde.groupIndex = paramInt4;
    return paramacde;
  }
  
  DataLineMsgRecord a(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().b(paramForwardFileInfo.fR());
    if (localFileManagerEntity == null) {}
    int m;
    do
    {
      return null;
      m = acde.a(localFileManagerEntity);
    } while (!acde.ir(m));
    int k = acde.i(paramForwardFileInfo.getFileName(), paramBoolean);
    int i = k;
    if (!paramBoolean)
    {
      i = k;
      if (k == 1) {
        i = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = acde.gu(i);
    localDataLineMsgRecord.sessionid = ((acde)this.app.getBusinessHandler(8)).a(0, paramInt).longValue();
    localDataLineMsgRecord.filename = paramForwardFileInfo.getFileName();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.getFileSize();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.getUuid();
    localDataLineMsgRecord.fileFrom = m;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.getThumbPath();
    if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
      localDataLineMsgRecord.md5 = aqhs.hexStr2Bytes(localFileManagerEntity.strFileMd5);
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin)) {
      localDataLineMsgRecord.uOwnerUin = Long.parseLong(localFileManagerEntity.peerUin.replace("+", ""));
    }
    if (TextUtils.isEmpty(paramForwardFileInfo.getLocalPath())) {}
    for (localDataLineMsgRecord.path = paramForwardFileInfo.getFileName();; localDataLineMsgRecord.path = paramForwardFileInfo.getLocalPath()) {
      return localDataLineMsgRecord;
    }
  }
  
  void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.app.e(paramMessage)) || (this.mIsFullScreenMode) || (wvo.a(paramMessage.frienduin, paramMessage.istroop, this.app))) {
      return;
    }
    Intent localIntent = this.app.a(this, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    runOnUiThread(new LiteActivity.36(this, paramMessage, localIntent));
  }
  
  public void a(dl paramdl)
  {
    if (!aqiw.isNetSupport(getActivity()))
    {
      ahao.OS(2131696348);
      return;
    }
    Object localObject2 = "";
    DataLineMsgSet localDataLineMsgSet = paramdl.a();
    Object localObject1;
    if ((ahav.amK()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > agmx.fJ())) {
      localObject1 = getString(2131693832);
    }
    label80:
    int i;
    for (;;)
    {
      if (((String)localObject1).equals(""))
      {
        localObject1 = getString(2131695439);
        localObject2 = (ausj)auss.a(this, null);
        ((ausj)localObject2).setMainTitle((CharSequence)localObject1);
        ((ausj)localObject2).addButton(getResources().getString(2131694144), 1);
        ((ausj)localObject2).addCancelButton(2131721058);
        ((ausj)localObject2).a(new al(this, localDataLineMsgSet, paramdl, (ausj)localObject2));
        ((ausj)localObject2).show();
        return;
        if (localDataLineMsgSet.getGroupType() == -1000)
        {
          localObject1 = getString(2131695440);
        }
        else
        {
          localObject1 = localObject2;
          if (localDataLineMsgSet.getGroupType() == -2000)
          {
            localObject1 = localObject2;
            if (!localDataLineMsgSet.isSingle())
            {
              localObject1 = localDataLineMsgSet.values().iterator();
              i = 0;
              label202:
              if (((Iterator)localObject1).hasNext())
              {
                if (!DataLineMsgSet.isCanReciveOrResend((DataLineMsgRecord)((Iterator)localObject1).next())) {
                  break label261;
                }
                i += 1;
              }
            }
          }
        }
      }
    }
    label261:
    for (;;)
    {
      break label202;
      localObject1 = String.format(getString(2131695418), new Object[] { Integer.valueOf(i) });
      break;
      break label80;
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (!I()) {
      z(null);
    }
    int i;
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      return;
      i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
      localDataLineMsgRecord = this.app.b().a(i).a(paramLong);
    } while (localDataLineMsgRecord == null);
    acde localacde = (acde)this.app.getBusinessHandler(8);
    localDataLineMsgRecord.bIsResendOrRecvFile = true;
    switch (paramInt)
    {
    default: 
      this.app.b().a(i).S(paramLong);
      u(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Db.notifyDataSetChanged();
      return;
      localacde.a(paramString, localDataLineMsgRecord.thumbPath, 1, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      localacde.a(paramString, localDataLineMsgRecord.thumbPath, 2, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      if (aqhq.fileExists(paramString)) {
        localacde.a(paramString, localDataLineMsgRecord.thumbPath, 0, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      }
      if (localDataLineMsgRecord.nOpType == 35) {
        localacde.h(localDataLineMsgRecord);
      } else {
        localacde.a().a(localDataLineMsgRecord, i, 2);
      }
    }
  }
  
  void a(Observable paramObservable, Object paramObject)
  {
    aQ();
    if ((paramObject instanceof DataLineMsgRecord))
    {
      paramObservable = (DataLineMsgRecord)paramObject;
      int i = DataLineMsgRecord.getDevTypeBySeId(paramObservable.sessionid);
      DataLineMsgSet localDataLineMsgSet = this.app.a(i).b(paramObservable.sessionid);
      if (QLog.isDevelopLevel()) {
        QLog.d("AutoTest_Xandy", 4, "SessionID:" + paramObservable.sessionid + ", Show:" + System.currentTimeMillis());
      }
      if ((DataLineMsgSet.isSingle(paramObservable)) || (localDataLineMsgSet == null) || (localDataLineMsgSet.getComeCount() <= 1)) {
        this.jdField_a_of_type_Db.notifyDataSetChanged();
      }
    }
    label146:
    do
    {
      break label146;
      for (;;)
      {
        if ((paramObject instanceof ChatMessage))
        {
          paramObservable = (MessageRecord)paramObject;
          if ((!paramObservable.isSendFromLocal()) && (paramObservable.msgtype != -1004)) {
            break label265;
          }
        }
        return;
        if (!this.jdField_a_of_type_Db.a(paramObservable.sessionid, this.mListView))
        {
          this.jdField_a_of_type_Db.notifyDataSetChanged();
          continue;
          if ((paramObject instanceof QQMessageFacade.Message))
          {
            paramObservable = (QQMessageFacade.Message)paramObject;
            if (paramObservable.frienduin == null) {
              break;
            }
            if (!paramObservable.frienduin.endsWith(String.valueOf(acbn.bkw))) {
              continue;
            }
            this.jdField_a_of_type_Db.notifyDataSetChanged();
            continue;
          }
          if ((paramObject instanceof RecentUser))
          {
            paramObservable = (RecentUser)paramObject;
            if (paramObservable.uin == null) {
              break;
            }
            if (paramObservable.uin.endsWith(String.valueOf(acbn.bkw))) {
              this.jdField_a_of_type_Db.notifyDataSetChanged();
            }
          }
        }
      }
      paramObject = (HotChatManager)this.app.getManager(60);
    } while ((paramObservable.isread) || (paramObject.kj(paramObservable.frienduin)));
    label265:
    a(this.app.b().a());
  }
  
  boolean a(Intent paramIntent, int paramInt)
  {
    paramIntent = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (paramIntent == null) {}
    boolean bool;
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return false;
        localFileManagerEntity = this.app.a().b(paramIntent.fR());
      } while (localFileManagerEntity == null);
      int i = acde.a(localFileManagerEntity);
      switch (i)
      {
      case 0: 
      default: 
        QLog.w(TAG, 1, "forwardFile fileFrom " + i + " is not handled");
        return false;
      case 3: 
        if (paramInt != 101) {
          break label155;
        }
        bool = true;
        paramIntent = a(paramIntent, bool, this.cM);
      }
    } while (paramIntent == null);
    ((acde)this.app.getBusinessHandler(8)).a(paramIntent, false);
    for (;;)
    {
      return true;
      label155:
      bool = false;
      break;
      this.app.a().n(3, paramIntent.fR(), this.cM);
      continue;
      if (this.cM == 0) {
        this.app.a().a(paramIntent.fR(), paramIntent.vj(), paramIntent.getFriendUin(), Long.parseLong(this.app.getCurrentAccountUin()), 7, paramIntent.Et());
      } else {
        this.app.a().a(paramIntent.fR(), paramIntent.vj(), paramIntent.getFriendUin(), Long.parseLong(this.app.getCurrentAccountUin()), 6003, paramIntent.Et());
      }
    }
  }
  
  public boolean a(PhotoListPanel paramPhotoListPanel)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onAlbumBtnClicked");
    }
    if (!paramPhotoListPanel.C.isEmpty()) {}
    for (ArrayList localArrayList = new ArrayList(paramPhotoListPanel.C);; localArrayList = null)
    {
      f(localArrayList);
      paramPhotoListPanel.resetStatus();
      anot.a(null, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
      return true;
    }
  }
  
  void aC()
  {
    Object localObject = this.rightViewImg;
    ((ImageView)localObject).setContentDescription(getResources().getText(2131695380));
    ((ImageView)localObject).setVisibility(0);
    ((ImageView)localObject).setImageResource(2130851145);
    ((ImageView)localObject).setOnClickListener(new ai(this));
    if (ujs.aTl) {
      this.rightViewImg.setContentDescription(acfp.m(2131707824));
    }
    p(getIntent());
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.mLeftBackIcon.setVisibility(0);
      this.leftView.setBackgroundDrawable(null);
    }
    for (localObject = getResources().getColorStateList(2131167302);; localObject = getResources().getColorStateList(2131167301))
    {
      this.centerView.setTextColor((ColorStateList)localObject);
      this.leftView.setTextColor((ColorStateList)localObject);
      return;
      this.mLeftBackIcon.setVisibility(8);
    }
  }
  
  public void aG()
  {
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378466);
      ((View)localObject).setBackgroundResource(2130839270);
      ((View)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setVisible(true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378466).setVisibility(8);
  }
  
  public void aI()
  {
    this.app.b().a(this.cM).a(15, new br(this));
  }
  
  void aJ()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)findViewById(2131369276));
    if (this.jdField_a_of_type_AndroidTextTextWatcher != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(aofr.a);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[] { new bt(this) });
        tat.b(this, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        aO();
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new bu(this));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(new y(this));
        return;
        this.jdField_a_of_type_AndroidTextTextWatcher = new bs(this);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "input set error", localException);
      }
    }
  }
  
  void aL()
  {
    if (this.cM == 1)
    {
      this.sessionInfo.aTl = acbn.bkx;
      this.sessionInfo.cZ = 6003;
      return;
    }
    this.sessionInfo.aTl = acbn.bkw;
    this.sessionInfo.cZ = 6000;
  }
  
  protected void aM()
  {
    this.aQ = false;
    new Handler().postDelayed(new LiteActivity.11(this), 1500L);
  }
  
  void aN()
  {
    String str;
    int i;
    Object localObject1;
    if (this.cM == 1)
    {
      str = acbn.bkx;
      i = 6003;
      localObject1 = null;
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
      }
      localObject2 = getTextDraft();
      if ((!aqmr.isEmpty((String)localObject2)) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (!aqmr.isEmpty(String.valueOf(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText())))) {
        break label82;
      }
    }
    label82:
    while ((!aqmr.isEmpty((String)localObject2)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (((String)localObject2).equals(String.valueOf(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))))
    {
      return;
      str = acbn.bkw;
      i = 6000;
      break;
    }
    Object localObject2 = aiyx.a(this.app);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      DraftTextInfo localDraftTextInfo = new DraftTextInfo();
      localDraftTextInfo.uin = str;
      localDraftTextInfo.type = i;
      localDraftTextInfo.text = ((CharSequence)localObject1).toString();
      localDraftTextInfo.time = NetConnInfoCenter.getServerTimeMillis();
      ((aiyx)localObject2).a(this.app, localDraftTextInfo);
    }
    for (;;)
    {
      localObject1 = this.app.b();
      localObject2 = ((aiyx)localObject2).a(this.app, str, i);
      if (localObject2 == null) {
        break;
      }
      ((QQMessageFacade)localObject1).b(str, i, "", ((DraftSummaryInfo)localObject2).getSummary(), ((DraftSummaryInfo)localObject2).getTime());
      return;
      ((aiyx)localObject2).o(this.app, str, i);
    }
    ((QQMessageFacade)localObject1).b(str, i, "", "", 0L);
  }
  
  void aO()
  {
    int k = 8;
    int m = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    this.cN = ChatTextSizeSettingActivity.ag(this);
    int i = k;
    switch (m)
    {
    default: 
      i = k;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(i);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.cN);
      return;
      i = 6;
      continue;
      i = 6;
    }
  }
  
  void aP()
  {
    if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext())) {}
    do
    {
      return;
      str = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "photo/");
      localObject = new File(str);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        QQToast.a(this, 2131719242, 0).show();
        return;
      }
    } while (!J());
    String str = str + System.currentTimeMillis() + ".jpg";
    Object localObject = new Intent();
    FileProvider7Helper.setSystemCapture(this, new File(str), (Intent)localObject);
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString("camera_photo_path", str).commit();
    startActivityForResult((Intent)localObject, 5);
  }
  
  void aQ()
  {
    if (this.y != null)
    {
      localObject = this.y.getText().toString();
      if ((localObject == null) || (((String)localObject).startsWith(getString(2131720735)))) {}
    }
    else
    {
      return;
    }
    int i = 0;
    int k = alkm.X(this.app);
    Object localObject = this.app.b();
    if (localObject != null) {
      i = ((QQMessageFacade)localObject).bl();
    }
    i += k;
    if (i > 0)
    {
      if (i > 99)
      {
        this.y.setText(getString(2131720735) + "(99+)");
        return;
      }
      this.y.setText(getString(2131720735) + "(" + i + ")");
      return;
    }
    this.y.setText(getString(2131720735));
  }
  
  void aR()
  {
    Iterator localIterator = this.H.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      this.app.b().a(this.cM).jdMethod_if(localLong.longValue());
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "setMsgFailedWhenQuesting: session = " + localLong.longValue());
      }
    }
    this.H.clear();
  }
  
  void aS()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.setToastIcon(2130840061);
    localQQToast.setDuration(2000);
    localQQToast.setToastMsg(2131695441);
    localQQToast.show(this.mListView.getHeight() / 2);
  }
  
  void aT()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.setToastIcon(2130840061);
    localQQToast.setDuration(2000);
    localQQToast.setToastMsg(2131695442);
    localQQToast.show(this.mListView.getHeight() / 2);
  }
  
  void aU()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.setToastIcon(2130840061);
    localQQToast.setDuration(2000);
    localQQToast.setToastMsg(2131695437);
    localQQToast.show(this.mListView.getHeight() / 2);
  }
  
  void aV()
  {
    Object localObject1 = new ArrayList();
    av localav = new av(this, (List)localObject1);
    aw localaw = new aw(this);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
    int m = 0;
    int n = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (DataLineMsgSet)localIterator.next();
      int i = 0;
      localObject2 = ((DataLineMsgSet)localObject2).values().iterator();
      int k = m;
      int i1 = n;
      n = i1;
      m = k;
      if (((Iterator)localObject2).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject2).next();
        if ((!DataLineMsgSet.isFileType(localDataLineMsgRecord)) || (localDataLineMsgRecord.isread) || (localDataLineMsgRecord.fileMsgStatus != 1L)) {
          break label262;
        }
        m = k;
        n = i;
        if (i == 0)
        {
          n = 1;
          m = k + 1;
        }
        ((List)localObject1).add(localDataLineMsgRecord);
        i1 += 1;
        i = n;
        k = m;
      }
    }
    label262:
    for (;;)
    {
      break;
      if (m >= 3)
      {
        localObject1 = String.format(getString(2131695448), new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
        ((acde)this.app.getBusinessHandler(8)).report(115);
        aqha.a(this, 230, getString(2131695407), (String)localObject1, 2131721058, 2131695381, localav, localaw).show();
      }
      return;
    }
  }
  
  public void aX()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      if (this.mIsFullScreenMode)
      {
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
        return;
      }
      this.o.setEnabled(true);
      return;
    }
    if (this.mIsFullScreenMode)
    {
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
      return;
    }
    this.o.setEnabled(false);
  }
  
  void b(long paramLong, String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_Aqju != null)
    {
      this.jdField_a_of_type_Aqju.show();
      return;
    }
    Object localObject2 = getString(2131720024);
    Object localObject1 = localObject2;
    if (paramString != null) {
      localObject1 = (String)localObject2 + paramString;
    }
    paramString = new z(this, paramLong);
    localObject2 = new aa(this, paramLong, this);
    this.jdField_a_of_type_Aqju = aqha.a(this, 232, null, this.app.getApplication().getString(2131720030), (String)localObject1, this.app.getApplication().getString(2131720025), paramString, (DialogInterface.OnClickListener)localObject2);
    this.jdField_a_of_type_Aqju.show();
  }
  
  public void b(dl paramdl)
  {
    if (!aqiw.isNetSupport(getActivity()))
    {
      ahao.OS(2131696348);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramdl.a();
    if ((ahav.amK()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 3145728L)) {}
    for (paramdl = getString(2131693828);; paramdl = "")
    {
      ArrayList localArrayList = new ArrayList();
      long l1 = 0L;
      Object localObject = localDataLineMsgSet.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord))
        {
          l1 += localDataLineMsgRecord.filesize;
          localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
        }
      }
      if ((localArrayList.size() == 0) && (!localDataLineMsgSet.isSingle()))
      {
        int i = localDataLineMsgSet.getTotalCount() - localDataLineMsgSet.getComeCount();
        if ((localDataLineMsgSet.getGroupType() == -2000) || ((localDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgSet.getFirstItem().bIsMoloImage))) {}
        for (paramdl = String.format(getString(2131695415), new Object[] { Integer.valueOf(i) });; paramdl = String.format(getString(2131695424), new Object[] { Integer.valueOf(i) }))
        {
          localObject = new am(this);
          aqha.a(this, 230, getString(2131695407), paramdl, 2131721079, 2131721079, null, (DialogInterface.OnClickListener)localObject).show();
          return;
        }
      }
      localObject = paramdl;
      if (paramdl.equals(""))
      {
        localObject = paramdl;
        if (localDataLineMsgSet.getGroupType() == -2000)
        {
          localObject = paramdl;
          if (!localDataLineMsgSet.isSingle()) {
            localObject = String.format(getString(2131695417), new Object[] { Integer.valueOf(localArrayList.size()) });
          }
        }
      }
      paramdl = (dl)localObject;
      if (((String)localObject).equals("")) {
        paramdl = getString(2131695438);
      }
      localObject = (ausj)auss.a(this, null);
      ((ausj)localObject).setMainTitle(paramdl);
      ((ausj)localObject).addButton(getResources().getString(2131694143), 1);
      ((ausj)localObject).addCancelButton(2131721058);
      ((ausj)localObject).a(new an(this, l1, localDataLineMsgSet, localArrayList, (ausj)localObject));
      ((ausj)localObject).show();
      return;
    }
  }
  
  void b(ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "sendMultipleFile paths is null !!!!!!");
      }
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        anot.a(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
        }
        i += 1;
      }
    }
    ac localac = new ac(this, paramArrayList);
    paramArrayList = paramArrayList.iterator();
    long l1 = 0L;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l1 = new VFSFile(str).length() + l1;
      }
    }
    if (l1 == 0L)
    {
      s(this);
      return;
    }
    if ((aqiw.isNetworkAvailable(this)) && (!aqiw.isWifiConnected(this)) && (l1 > agmx.fJ()))
    {
      ahal.a(this, 2131693826, 2131693832, new ad(this, localac, paramInt));
      return;
    }
    localac.execute(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  public boolean b(PhotoListPanel paramPhotoListPanel)
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramPhotoListPanel.C.iterator();
    long l1 = 0L;
    if (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      int i = paramPhotoListPanel.a.getFileType(str);
      if (1 == i) {
        localArrayList.add(str);
      }
      for (;;)
      {
        l1 = new VFSFile(str).length() + l1;
        break;
        if (i == 0) {
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    if (l1 == 0L)
    {
      s(this);
      return true;
    }
    if ((aqiw.isNetworkAvailable(this)) && (!aqiw.isWifiConnected(this)) && (l1 > agmx.fJ())) {
      ahal.a(this, 2131693826, 2131693832, new bd(this, (ArrayList)localObject1, localArrayList));
    }
    for (;;)
    {
      paramPhotoListPanel.resetStatus();
      anot.a(null, "CliOper", "", "", "0X8005A2F", "0X8005A2F", 0, 0, paramPhotoListPanel.C.size() + "", "", "", "");
      return true;
      if (!((ArrayList)localObject1).isEmpty())
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
        new d().execute(new Bundle[] { localObject2 });
      }
      if (!localArrayList.isEmpty())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
        new e().execute(new Bundle[] { localObject1 });
      }
    }
  }
  
  public void bI()
  {
    this.mIsFullScreenMode = true;
    L(false);
    if (this.A != null) {
      this.A.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.j.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(this.o.isEnabled());
    this.l.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().width = -1;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(100);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(48);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBottom() });
    localValueAnimator.addUpdateListener(new bn(this));
    localValueAnimator.addListener(new bo(this));
    localValueAnimator.setDuration(100L).setRepeatCount(0);
    localValueAnimator.start();
  }
  
  public void bk()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
      anot.a(this.app, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 2, 0, "", "", "", "");
      return;
    }
    f(new ArrayList());
    anot.a(this.app, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 1, 0, "", "", "", "");
  }
  
  public void bo()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
  }
  
  protected void bp()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.vm();
    if (i == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(i);
  }
  
  public void br()
  {
    this.uiHandler.obtainMessage(15, 0, 0).sendToTarget();
  }
  
  void c(ArrayList<SendInfo> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {}
    acde localacde;
    int k;
    int i;
    Object localObject;
    for (;;)
    {
      return;
      localacde = (acde)this.app.getBusinessHandler(8);
      k = paramArrayList.size();
      if (k > 3) {
        break;
      }
      i = 0;
      while (i < k)
      {
        localObject = a(localacde, (SendInfo)paramArrayList.get(i), paramInt, 0, 0, 0);
        if (localObject != null) {
          localacde.a((DataLineMsgRecord)localObject, false);
        }
        i += 1;
      }
    }
    label110:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((k > 3) && (k < 50))
    {
      localObject = new ArrayList();
      int m = localacde.An();
      i = 0;
      if (i < k)
      {
        localDataLineMsgRecord = a(localacde, (SendInfo)paramArrayList.get(i), paramInt, m, k, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, m)) {
          break label395;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localacde.z((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
    }
    label392:
    label395:
    for (;;)
    {
      i += 1;
      break label110;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localacde.z((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      k = localacde.An();
      i = 0;
      label250:
      if (i < 50)
      {
        localDataLineMsgRecord = a(localacde, (SendInfo)paramArrayList.get(i), paramInt, k, 50, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, k)) {
          break label392;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localacde.z((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
      for (;;)
      {
        i += 1;
        break label250;
        if (((ArrayList)localObject).size() > 0) {
          localacde.z((ArrayList)localObject, false);
        }
        i = 0;
        while (i < 50)
        {
          paramArrayList.remove(0);
          i += 1;
        }
        break;
      }
    }
  }
  
  @TargetApi(18)
  public boolean d(long paramLong)
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      aT();
      return false;
    }
    if (Build.VERSION.SDK_INT >= 18) {}
    for (long l1 = new StatFs(acbn.SDCARD_ROOT).getAvailableBytes(); l1 < paramLong; l1 = new StatFs(acbn.SDCARD_ROOT).getAvailableBlocks() * new StatFs(acbn.SDCARD_ROOT).getBlockSize())
    {
      aS();
      return false;
    }
    return true;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (!I()) {
      z(null);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          switch (paramInt1)
                          {
                          case 4: 
                          default: 
                            return;
                          }
                        } while ((paramInt2 != -1) || (paramIntent == null));
                        paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
                      } while ((paramIntent == null) || (paramIntent.size() <= 0));
                      c(paramIntent, 1);
                      paramIntent.clear();
                      v(false);
                      return;
                    } while (paramInt2 != -1);
                    k(paramIntent);
                    return;
                  } while ((paramInt2 != -1) || (paramIntent == null));
                  paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
                } while ((paramIntent == null) || (paramIntent.size() <= 0));
                c(paramIntent, 2);
                paramIntent.clear();
                v(false);
                return;
              } while (paramInt2 != -1);
              v(false);
              return;
            } while ((paramInt2 != -1) || (paramIntent == null));
            paramIntent = paramIntent.getExtras().getString("textMsg");
          } while (paramIntent.length() <= 0);
          u(paramIntent);
          return;
        } while (paramInt2 != -1);
        v(false);
        return;
        bs();
      } while ((paramInt2 != -1) || (paramIntent == null));
      return;
      this.jdField_a_of_type_Db.notifyDataSetChanged();
      return;
    } while ((paramInt2 != -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.o(paramInt1, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131165572);
    setContentView(2131559175);
    setStatusBarBlue();
    boolean bool = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377361));
    if (bool) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130851106);
    }
    int n;
    int i1;
    int i2;
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)findViewById(2131369277));
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369967);
      if (localObject1 != null) {
        ViewCompat.setImportantForAccessibility((View)localObject1, 2);
      }
      setTitle(2131695446);
      getWindow().setBackgroundDrawable(null);
      i(getIntent());
      j(getIntent());
      aC();
      this.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131382231));
      this.B = ((TextView)findViewById(2131370599));
      this.h = ((ImageView)findViewById(2131370598));
      if (this.cM == 1)
      {
        anot.a(this.app, "CliOper", "", "", "0X8005D19", "0X8005D19", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "=== dataline report event into ipad 0X8005D19 ");
        }
      }
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$c = new c(this);
      this.app.a().addObserver(this.jdField_a_of_type_Aghq);
      localObject1 = this.app.b();
      if (localObject1 != null) {
        ((QQMessageFacade)localObject1).addObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = this.app.a(this.cM).a(true);
      this.jdField_a_of_type_Db = new dg(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList, this, this.app);
      initListView();
      aJ();
      localObject1 = (acde)this.app.getBusinessHandler(8);
      ((acde)localObject1).bHf = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.mListView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.eiP();
      this.f = ((RelativeLayout)findViewById(2131364564));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131377546));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
      aL();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = ((PanelIconLinearLayout)findViewById(2131372847));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconLongListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.b(this.app, this.sessionInfo, null);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.ja(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.o = ((Button)findViewById(2131377979));
      this.o.setOnClickListener(this);
      aX();
      addObserver(this.jdField_a_of_type_Acdl);
      aV();
      this.app.b().a(this.cM).cNX();
      if (paramBundle == null) {
        this.uiHandler.postDelayed(new LiteActivity.1(this), 200L);
      }
      h(getIntent());
      paramBundle = (ackv)this.app.getBusinessHandler(10);
      if ((paramBundle.bi() == 0) && (!paramBundle.abD()))
      {
        paramBundle.cMe();
        paramBundle.FB(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.isEmpty()) {
        break label981;
      }
      paramBundle = getSharedPreferences("first_enter_dataline", 0);
      int i = paramBundle.getInt("year", -1);
      int k = paramBundle.getInt("month", -1);
      int m = paramBundle.getInt("day", -1);
      localObject2 = Calendar.getInstance();
      n = ((Calendar)localObject2).get(1);
      i1 = ((Calendar)localObject2).get(2);
      i2 = ((Calendar)localObject2).get(5);
      if ((n == i) && (i1 == k) && (i2 == m)) {
        break label981;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() - 1);
      if (localObject2 == null) {
        break label981;
      }
      localObject2 = ((DataLineMsgSet)localObject2).getFirstItem();
      if ((localObject2 == null) || (((DataLineMsgRecord)localObject2).msgtype == -5000)) {
        break label981;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DataLineMsgSet localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject2).next();
        if (localDataLineMsgSet != null)
        {
          DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
          if ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.msgtype == -5000)) {
            try
            {
              ((Iterator)localObject2).remove();
              this.app.a(this.cM).e(localDataLineMsgSet);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130851105);
    }
    Object localObject1 = ((acde)localObject1).a(0, this.cM);
    Object localObject2 = new DataLineMsgRecord();
    ((DataLineMsgRecord)localObject2).msgId = ((Long)localObject1).longValue();
    ((DataLineMsgRecord)localObject2).sessionid = ((Long)localObject1).longValue();
    ((DataLineMsgRecord)localObject2).msgtype = -5000;
    ((DataLineMsgRecord)localObject2).time = anaz.gQ();
    ((DataLineMsgRecord)localObject2).isread = true;
    this.app.a(this.cM).b((DataLineMsgRecord)localObject2);
    paramBundle = paramBundle.edit();
    paramBundle.putInt("year", n);
    paramBundle.putInt("month", i1);
    paramBundle.putInt("day", i2);
    paramBundle.commit();
    label981:
    aH();
    this.l = findViewById(2131367805);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131367801));
    this.jdField_g_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368521));
    this.j = ((LinearLayout)findViewById(2131367818));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)findViewById(2131367802));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    if (AppSetting.enableTalkBack)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(acfp.m(2131707817));
      this.jdField_g_of_type_AndroidWidgetImageButton.setContentDescription(acfp.m(2131707816));
    }
    this.jdField_a_of_type_Aewn = new aewn(this, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.app, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_Aewn.onCreate();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.stop();
    }
    if (this.app.b() != null)
    {
      this.app.b().a(this.cM).cNX();
      this.app.b().a(this.cM).cNW();
      this.app.b().deleteObserver(this);
      this.jdField_a_of_type_Db.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_Acdl != null) {
      removeObserver(this.jdField_a_of_type_Acdl);
    }
    if (this.jdField_a_of_type_Aghq != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aghq);
    }
    if (this.jdField_a_of_type_Aqju != null)
    {
      this.jdField_a_of_type_Aqju.dismiss();
      this.jdField_a_of_type_Aqju = null;
    }
    this.cM = -1;
    if (this.app.a() != null) {
      this.app.a().diq();
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(null);
    }
    ahav.eo(this);
    if (this.aT)
    {
      this.mListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onDestroy();
    }
    this.jdField_a_of_type_Aewn.onDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    p(paramIntent);
    aN();
    o(paramIntent);
    l(paramIntent);
    this.jdField_a_of_type_Db.notifyDataSetChanged();
    h(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ((acde)this.app.getBusinessHandler(8)).cIe();
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if ((this.aM) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "finishing LiteActivity (ask ippan)");
      }
      finish();
      com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = false;
    }
    if (this.aT) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a(this, this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    this.jdField_a_of_type_Db.notifyDataSetChanged();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.ceT();
    }
    ApngImage.playByTag(0);
    aG();
    if (this.aT) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
    }
  }
  
  public boolean e(Object paramObject)
  {
    int i = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("XPanel", 2, "onPanelIconLongClick panelID=" + i);
    }
    switch (i)
    {
    default: 
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      if ((checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        requestPermissions(new ay(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return true;
        i = 0;
      }
      else
      {
        bk();
        return true;
        i = 1;
      }
    }
  }
  
  public void f(ArrayList<String> paramArrayList)
  {
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent2.putExtra("peakconstant.request_code", 55);
    localIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localIntent2.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localIntent2.putExtra("PhotoConst.is_troop_send_mixed_msg", false);
    localIntent2.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
    localIntent2.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", true);
    localIntent2.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false);
    localIntent2.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
    localIntent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    Intent localIntent1 = new Intent(this, NewPhotoListActivity.class);
    localIntent1.putExtra("enter_from", 40);
    int i = wmj.a(this.app, this, this.sessionInfo, paramArrayList, localIntent2, localIntent1);
    localIntent1.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "");
    localIntent1.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "");
    localIntent1.putExtra(aqfx.REQUEST_CODE, 55);
    localIntent1.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent1.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent1.putExtra("PhotoConst.original_button", true);
    if (i == -1) {
      startActivity(localIntent1);
    }
    for (;;)
    {
      aqfy.anim(this, false, true);
      if (avfp.h != null) {
        avfp.h.dqV();
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)
      {
        paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.z();
        if (paramArrayList != null) {
          localIntent1.putExtra("PhotoConst.editPathMap", paramArrayList);
        }
      }
      startActivityForResult(localIntent1, i);
    }
  }
  
  public void finish()
  {
    super.finish();
    aN();
    ((acde)this.app.getBusinessHandler(8)).bHf = false;
    aR();
    if ((this.aN) && (wja.bcO) && (!this.aO))
    {
      super.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
      this.aO = true;
    }
  }
  
  public float getDensity()
  {
    return this.mDensity;
  }
  
  String getTextDraft()
  {
    String str;
    if (this.cM == 1) {
      str = acbn.bkx;
    }
    for (int i = 6003;; i = 6000)
    {
      return aiyx.a(this.app).b(this.app, str, i);
      str = acbn.bkw;
    }
  }
  
  void h(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.getAction()))) {}
    do
    {
      return;
      if ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))
      {
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$c.q(paramIntent);
        return;
      }
    } while ((!paramIntent.getAction().equals("android.intent.action.MAIN")) || (!paramIntent.getBooleanExtra("system_share_multi_send", false)));
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$c.q(paramIntent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      o(paramMessage.arg1, paramMessage.arg2);
      continue;
      bs();
      continue;
      bF();
      F(B());
      continue;
      bF();
      bG();
      continue;
      QLog.i(TAG, 2, "progress: " + paramMessage.arg1);
      this.c.setProgress(paramMessage.arg1);
    }
  }
  
  protected void i(Intent paramIntent)
  {
    int i = this.cM;
    String str = this.aR;
    this.aR = paramIntent.getStringExtra("targetUin");
    if ((this.aR != null) && (this.aR.length() != 0)) {
      if (this.aR.equals(acbn.bkx))
      {
        setTitle(2131695447);
        this.cM = 1;
      }
    }
    for (;;)
    {
      paramIntent = (acde)this.app.getBusinessHandler(8);
      paramIntent.aR = this.aR;
      paramIntent.cuM = this.cM;
      return;
      setTitle(2131695446);
      this.cM = 0;
      continue;
      if (this.cM == -1)
      {
        this.cM = paramIntent.getIntExtra("device_type", -1);
        if (this.cM == 1)
        {
          setTitle(2131695447);
          this.aR = acbn.bkx;
        }
        else
        {
          setTitle(2131695446);
          this.aR = acbn.bkw;
          this.cM = 0;
        }
      }
      else
      {
        this.cM = i;
        this.aR = str;
      }
    }
  }
  
  void i(List<String> paramList)
  {
    if (paramList == null) {}
    ArrayList localArrayList1;
    do
    {
      return;
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        int i = ahav.getFileType(str);
        if (2 == i) {
          localArrayList1.add(str);
        } else if (i == 0) {
          localArrayList2.add(str);
        }
      }
      if (!localArrayList2.isEmpty())
      {
        paramList = new Bundle();
        paramList.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList2);
        new d().execute(new Bundle[] { paramList });
      }
    } while (localArrayList1.isEmpty());
    paramList = new Bundle();
    paramList.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList1);
    new e().execute(new Bundle[] { paramList });
  }
  
  public boolean i(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.isShowing())) {
      return true;
    }
    aqoa localaqoa = new aqoa();
    dl localdl = (dl)paramView.getTag();
    DataLineMsgSet localDataLineMsgSet = localdl.a();
    Object localObject1 = "";
    DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
    int i = localDataLineMsgSet.getGroupType();
    Object localObject2;
    if (localDataLineMsgSet.isSingle()) {
      switch (localDataLineMsgSet.getGroupType())
      {
      default: 
        localObject1 = "";
        localObject2 = null;
      }
    }
    for (;;)
    {
      Object localObject3;
      if (localObject2 == null)
      {
        return false;
        localObject2 = localdl.a().t;
        localaqoa.Z(2131365456, paramView.getContext().getString(2131692330), 2130839077);
        localaqoa.Z(2131367523, paramView.getContext().getString(2131721067), 2130839086);
        localaqoa.Z(2131366733, paramView.getContext().getString(2131693407), 2130839085);
        localObject1 = "";
        continue;
        localObject2 = localdl.a().p;
        localObject1 = localDataLineMsgRecord.path;
        if ((wja.eU(1) == 1) && (aqhq.fileExistsAndNotEmpty(localDataLineMsgRecord.path)) && (Float.compare(localDataLineMsgRecord.progress, 1.0F) == 0))
        {
          localaqoa.Z(2131362240, getString(2131694742), 2130839084);
          continue;
          if (localDataLineMsgRecord.bIsMoloImage) {
            localObject1 = localdl.a().p;
          }
          for (;;)
          {
            localObject3 = localDataLineMsgRecord.path;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break;
            localObject2 = localdl.a().n;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = (RelativeLayout)localdl.a().E;
            }
          }
        }
      }
      else
      {
        Context localContext = ((RelativeLayout)localObject2).getContext();
        if (localDataLineMsgRecord.canForward()) {
          localaqoa.Z(2131367523, localContext.getString(2131695405), 2130839086);
        }
        if ((aqhq.fileExistsAndNotEmpty((String)localObject1)) && (localDataLineMsgRecord.strMoloKey == null))
        {
          if (localDataLineMsgSet.getGroupType() == -2005)
          {
            bool = aetq.a().ahT();
            long l1 = ahav.d(this.app, localDataLineMsgRecord.filename);
            String str = aeuc.a().ud();
            localObject3 = str;
            if (TextUtils.isEmpty(str)) {
              localObject3 = aobw.cjR;
            }
            if ((bool) && (aobw.v((String)localObject1, localDataLineMsgRecord.filename, (String)localObject3)) && (localDataLineMsgRecord.filesize <= l1))
            {
              anot.a(this.app, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
              localaqoa.Z(2131379277, paramView.getContext().getString(2131720920), 2130839097);
            }
          }
          if (localDataLineMsgSet.getGroupType() != -2000) {
            break label739;
          }
          localaqoa.Z(2131366733, paramView.getContext().getString(2131693407), 2130839085);
          if (a(this.app, localDataLineMsgRecord)) {
            localaqoa.Z(2131381353, localContext.getString(2131693585), 2130839100);
          }
        }
        paramView = ((RelativeLayout)localObject2).getContext();
        localaqoa.Z(2131365692, paramView.getString(2131695393), 2130839081);
        if ((localDataLineMsgSet.getGroupType() == -2000) || ((localDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgRecord.bIsMoloImage))) {}
        for (boolean bool = true;; bool = false)
        {
          paramView = new ap(this, localDataLineMsgRecord, localDataLineMsgSet, paramView, i, (String)localObject1, bool);
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = aqgq.a(localdl.o, (int)this.downPoint.x, (int)this.downPoint.y, localaqoa, paramView);
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ag(this));
          return true;
          label739:
          if ((localDataLineMsgSet.getGroupType() == -2009) && (aqhq.fileExistsAndNotEmpty((String)localObject1)))
          {
            localaqoa.Z(2131366733, paramView.getContext().getString(2131693407), 2130839085);
            break;
          }
          if ((localDataLineMsgSet.getGroupType() != -2005) || (!aqhq.fileExistsAndNotEmpty((String)localObject1))) {
            break;
          }
          localaqoa.Z(2131366733, paramView.getContext().getString(2131693407), 2130839085);
          break;
          switch (localDataLineMsgSet.getGroupType())
          {
          default: 
            paramView = null;
          }
          for (;;)
          {
            localObject2 = paramView;
            if (paramView != null) {
              break;
            }
            return false;
            paramView = localdl.a().q;
            continue;
            if (localDataLineMsgRecord.bIsMoloImage) {
              paramView = localdl.a().q;
            } else {
              paramView = localdl.a().n;
            }
          }
        }
      }
    }
  }
  
  void initListView()
  {
    this.mListView = ((XListView)findViewById(2131370596));
    this.mListView.setStackFromBottom(true);
    this.mListView.setAdapter(this.jdField_a_of_type_Db);
    View localView = LayoutInflater.from(this).inflate(2131559032, null);
    this.mListView.setOverScrollHeader(localView);
    this.mListView.setSelection(this.jdField_a_of_type_Db.getCount());
    this.mListView.setOnTouchListener(new az(this));
    this.mListView.setOverScrollListener(new bj(this));
  }
  
  void j(Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent.getIntExtra("aio_msg_source", 999) == 1) {}
    for (;;)
    {
      this.aN = bool;
      if (this.aN)
      {
        wja.bcO = false;
        this.aO = false;
      }
      return;
      bool = false;
    }
  }
  
  void k(Intent paramIntent)
  {
    paramIntent = null;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("camera_photo_path", "");
    if (!((String)localObject).equalsIgnoreCase(""))
    {
      wmj.aTe = (String)localObject;
      paramIntent = Uri.fromFile(new File((String)localObject));
    }
    PreferenceManager.getDefaultSharedPreferences(this).edit().remove("camera_photo_path").commit();
    if (paramIntent == null) {
      return;
    }
    paramIntent = aqhu.getRealPathFromContentURI(this, paramIntent);
    if (paramIntent != null)
    {
      aqhu.cn(this, paramIntent);
      if (!aqhq.rr(paramIntent))
      {
        QQToast.a(this, getString(2131693663), 0).show(getTitleBarHeight());
        return;
      }
      if (!new VFSFile(paramIntent).exists()) {
        QQToast.a(this, getString(2131696981), 0).show(getTitleBarHeight());
      }
    }
    else
    {
      QQToast.a(this, getString(2131696981), 0).show(getTitleBarHeight());
      return;
    }
    localObject = new Intent();
    ArrayList localArrayList = new ArrayList();
    ((Intent)localObject).setClass(this, CameraPreviewActivity.class);
    localArrayList.add(paramIntent);
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    ((Intent)localObject).putExtra(aqfx.REQUEST_CODE, 55);
    ((Intent)localObject).putExtra("uin", acbn.bkw);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    ((Intent)localObject).putExtra("LASTFROM", this.leftView.getText().toString());
    startActivity((Intent)localObject);
  }
  
  public void k(Object paramObject)
  {
    if (this.mIsFullScreenMode) {
      K(true);
    }
    wja.bcO = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int i = ((Integer)paramObject).intValue();
    if (i == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.vm())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.aJS();
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.abp(4);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.ceT();
      }
      anot.a(this.app, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
      anot.a(this.app, "dc00898", "", "", "0X800AD64", "0X800AD64", 0, 0, "", "", "", "");
      getIntent().putExtra("qq_sub_business_id", 107);
      return;
    case 5: 
      anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktkphoto");
      aP();
      anot.a(this.app, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
      anot.a(this.app, "dc00898", "", "", "0X800AD65", "0X800AD65", 0, 0, "", "", "", "");
      return;
    case 16: 
      anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckfile");
      if (!CheckPermission.isHasStoragePermission(this))
      {
        CheckPermission.requestSDCardPermission(this, new ba(this));
        return;
      }
      bl();
      anot.a(this.app, "dc00898", "", "", "0X800AD66", "0X800AD66", 0, 0, "", "", "", "");
      return;
    }
    if (!H()) {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "click too fast , wait a minute.");
      }
    }
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", "0X800AD67", "0X800AD67", 0, 0, "", "", "", "");
      return;
      aM();
      anot.a(null, "CliOper", "", "", avin.cLb, avin.cLb, 0, 0, "", "", "", "");
      paramObject = new Bundle();
      paramObject.putBoolean("string_from", false);
      paramObject.putBoolean("string_uin", false);
      paramObject.putLong("device_din", 0L);
      paramObject.putInt("sTitleID", 0);
      avio.b(this, paramObject, "com.qqdataline.mpfile.LiteMpFileMainActivity");
    }
  }
  
  public void l(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.jdField_a_of_type_Ahgq = ahix.a(paramIntent, this.app, this);
      paramIntent = new Bundle();
      paramIntent.putString("uin", String.valueOf(acbn.bkw));
      paramIntent.putInt("uintype", -1);
      this.jdField_a_of_type_Ahgq.H(ahgg.a.W.intValue(), paramIntent);
    }
    int i;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(getTextDraft());
      i = paramIntent.getIntExtra(aqfx.REQUEST_CODE, -1);
      if (55 != i) {
        break label329;
      }
      if (!paramIntent.getExtras().containsKey("PhotoConst.PHOTO_PATHS")) {
        break;
      }
      ArrayList localArrayList = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      if (localArrayList.size() <= 0) {
        break;
      }
      i(localArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.resetStatus();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.aJS();
    return;
    if (paramIntent.getExtras().containsKey("file_send_path"))
    {
      E(paramIntent.getExtras().getString("file_send_path"));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.resetStatus();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.aJS();
      }
    }
    for (;;)
    {
      if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
      {
        getIntent().removeExtra("PhotoConst.SEND_FLAG");
        i(paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS"));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.resetStatus();
        }
      }
      if (paramIntent.getBooleanExtra("isMigSdkShare", false)) {
        getIntent().putExtra("isMigSdkShare", true);
      }
      n(paramIntent);
      m(paramIntent);
      return;
      label329:
      if (56 == i)
      {
        E(paramIntent.getExtras().getString("file_send_path"));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.resetStatus();
        }
      }
    }
  }
  
  void m(Intent paramIntent)
  {
    if (paramIntent.hasExtra("JumpAction.Text"))
    {
      paramIntent = paramIntent.getStringExtra("JumpAction.Text");
      if ((paramIntent != null) && (paramIntent.length() > 0))
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramIntent);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramIntent.length());
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 0);
      }
    }
  }
  
  public void n(int paramInt1, int paramInt2)
  {
    this.uiHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
  }
  
  void n(Intent paramIntent)
  {
    int k = paramIntent.getIntExtra("dataline_forward_type", -1);
    int i = 0;
    if (k == -1) {
      label16:
      return;
    }
    paramIntent.getIntExtra("dataline_forward_type", -1);
    long l1 = paramIntent.getLongExtra("req_share_id", 0L);
    if (paramIntent.getBooleanExtra("sendMultiple", false)) {
      if (k != 100) {
        break label1503;
      }
    }
    label263:
    label1490:
    label1493:
    label1498:
    label1503:
    for (int m = 0;; m = 1)
    {
      Object localObject1 = paramIntent.getStringArrayListExtra("dataline_forward_pathlist");
      Object localObject6;
      Object localObject5;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject6 = paramIntent.getExtras();
        localObject5 = null;
        localObject1 = localObject5;
        if (localObject6 != null)
        {
          localObject6 = ((Bundle)localObject6).getParcelableArrayList("fileinfo_array");
          localObject1 = localObject5;
          if (localObject6 == null) {}
        }
        try
        {
          localObject1 = (ArrayList)localObject6;
          if (localObject1 == null)
          {
            aU();
            return;
          }
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            localObject2 = null;
          }
          localObject5 = new ArrayList();
          localObject6 = (acde)this.app.getBusinessHandler(8);
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = a((ForwardFileInfo)((Iterator)localObject2).next(), false, this.cM);
            if (localDataLineMsgRecord != null) {
              if (DataLineMsgSet.isSingle(localDataLineMsgRecord))
              {
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(localDataLineMsgRecord);
                ((acde)localObject6).z(localArrayList, false);
                i = 1;
              }
            }
            for (;;)
            {
              break;
              ((ArrayList)localObject5).add(localDataLineMsgRecord);
            }
          }
          if (((ArrayList)localObject5).size() <= 0) {
            break label370;
          }
        }
        ((acde)localObject6).z((ArrayList)localObject5, false);
      }
      for (;;)
      {
        for (;;)
        {
          if (!this.aM) {
            this.aM = paramIntent.getExtras().getBoolean("is_share_flag");
          }
          boolean bool = paramIntent.getExtras().getBoolean("refuse_show_share_result_dialog", false);
          if ((!this.aM) || (bool)) {
            break;
          }
          paramIntent = paramIntent.getExtras();
          localObject2 = paramIntent.getString("app_name");
          if (l1 != 0L) {
            break label1490;
          }
          paramIntent = anre.a(paramIntent);
          if ((paramIntent == null) || (!(paramIntent instanceof AbsShareMsg))) {
            break label1493;
          }
          paramIntent = (AbsShareMsg)paramIntent;
          label351:
          if (paramIntent == null) {
            break label1490;
          }
          l1 = paramIntent.mSourceAppid;
          label361:
          b(l1, (String)localObject2);
          return;
          label370:
          if (i == 0)
          {
            aU();
            continue;
            localObject5 = ((ArrayList)localObject2).iterator();
            for (i = 0; ((Iterator)localObject5).hasNext(); i = k)
            {
              localObject6 = (String)((Iterator)localObject5).next();
              if (localObject6 != null)
              {
                k = i;
                if (!((String)localObject6).equals("/")) {}
              }
              else
              {
                k = i;
                if (i == 0)
                {
                  k = 1;
                  aU();
                }
                ((Iterator)localObject5).remove();
              }
            }
            if (!((ArrayList)localObject2).isEmpty())
            {
              b((ArrayList)localObject2, m);
            }
            else if (i == 0)
            {
              aU();
              continue;
              localObject5 = new ArrayList();
              if (a(paramIntent, k)) {
                break;
              }
              switch (k)
              {
              default: 
                anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_other");
                break;
              case 101: 
                anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_image");
                localObject2 = paramIntent.getStringExtra("dataline_forward_path");
                if (localObject2 == null)
                {
                  QLog.e(TAG, 1, "handleForwardRequest forward image, extras: " + paramIntent.getExtras().toString());
                }
                else
                {
                  localObject6 = ((String)localObject2).split(";");
                  ((ArrayList)localObject5).clear();
                  i = 0;
                  if (i < localObject6.length) {
                    try
                    {
                      localObject2 = URLDecoder.decode(localObject6[i], "UTF-8");
                      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                        if ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://")))
                        {
                          u((String)localObject2);
                          anot.a(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                          if (QLog.isColorLevel()) {
                            QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                          }
                          i += 1;
                        }
                      }
                    }
                    catch (UnsupportedEncodingException paramIntent)
                    {
                      if (!QLog.isColorLevel()) {
                        break label16;
                      }
                      QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[i]);
                      return;
                    }
                    catch (IllegalArgumentException localIllegalArgumentException1)
                    {
                      for (;;)
                      {
                        localObject3 = localObject6[i];
                        continue;
                        ((ArrayList)localObject5).add(localObject3);
                        continue;
                        if (QLog.isColorLevel()) {
                          QLog.e("qqdataline", 2, "gotoQfavShareMsg|file path invalid. path=" + (String)localObject3);
                        }
                      }
                    }
                  }
                }
                break;
              }
            }
          }
        }
        if (!((ArrayList)localObject5).isEmpty())
        {
          b((ArrayList)localObject5, 1);
          if (paramIntent.getBooleanExtra("isMigSdkShare", false)) {
            if (((ArrayList)localObject5).size() > 1)
            {
              anot.a(this.app, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
              if (QLog.isColorLevel()) {
                QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
              }
            }
            else if (((ArrayList)localObject5).size() == 1)
            {
              anot.a(this.app, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
              if (QLog.isColorLevel()) {
                QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
              }
            }
          }
        }
      }
      anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_file");
      Object localObject3 = avja.a(paramIntent.getExtras(), this.sessionInfo.aTl, this.sessionInfo.cZ);
      if (localObject3 != null)
      {
        paramIntent = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
        if (paramIntent == null) {
          break label1498;
        }
      }
      for (i = paramIntent.forwardID;; i = 0)
      {
        for (;;)
        {
          this.app.a().a((FileManagerEntity)localObject3, this.sessionInfo.aTl, this.sessionInfo.cZ, i);
          return;
          localObject3 = paramIntent.getStringExtra("dataline_forward_path");
          if ((localObject3 == null) || (((String)localObject3).equals("")))
          {
            aU();
            return;
          }
          localObject6 = ((String)localObject3).split(";");
          ((ArrayList)localObject5).clear();
          i = 0;
          if (i < localObject6.length) {
            try
            {
              localObject3 = URLDecoder.decode(localObject6[i], "UTF-8");
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
                {
                  u((String)localObject3);
                  i += 1;
                }
              }
            }
            catch (UnsupportedEncodingException paramIntent)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[i]);
              return;
            }
            catch (IllegalArgumentException localIllegalArgumentException2)
            {
              for (;;)
              {
                localObject4 = localObject6[i];
                continue;
                ((ArrayList)localObject5).add(localObject4);
                continue;
                if (QLog.isColorLevel()) {
                  QLog.e("qqdataline", 2, "shareFromMigSdk|file path invalid. path=" + (String)localObject4);
                }
              }
            }
          }
        }
        if (((ArrayList)localObject5).isEmpty()) {
          break label263;
        }
        b((ArrayList)localObject5, 0);
        if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
          break label263;
        }
        anot.a(this.app, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
        if (!QLog.isColorLevel()) {
          break label263;
        }
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
        break label263;
        Object localObject4 = paramIntent.getStringExtra("dataline_forward_text");
        if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
          break label263;
        }
        if (aqjb.WEB_URL.matcher((CharSequence)localObject4).find()) {
          anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_link");
        }
        for (;;)
        {
          u((String)localObject4);
          break;
          anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_text");
        }
        break label361;
        paramIntent = null;
        break label351;
      }
    }
  }
  
  protected void o(int paramInt1, int paramInt2)
  {
    bp();
    if (paramInt2 == 0) {
      this.aP = false;
    }
    for (;;)
    {
      bs();
      return;
      if (1 == paramInt2) {
        this.aP = true;
      }
    }
  }
  
  protected void o(Intent paramIntent)
  {
    j(paramIntent);
    int i = this.cM;
    i(paramIntent);
    if (i != this.cM)
    {
      paramIntent = this.app.a(this.cM);
      if (paramIntent != null) {
        break label85;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = new DataLineMsgSetList();
      this.jdField_a_of_type_Db.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onCreate datalineMsgEntities = new DataLineMsgSetList()");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Db.notifyDataSetChanged();
      return;
      label85:
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramIntent.a(true);
      this.jdField_a_of_type_Db.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList);
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if (this.aM)
    {
      if (bool)
      {
        l1 = getIntent().getLongExtra("req_share_id", 0L);
        if (l1 > 0L) {
          ahkr.a(this, true, "sendToMyComputer", l1);
        }
        return super.onBackEvent();
      }
      long l1 = getIntent().getLongExtra("res_share_id", 0L);
      if (l1 > 0L) {
        ahkr.a(this, true, "shareToQQ", aqgb.X(l1));
      }
      return super.onBackEvent();
    }
    ApngImage.pauseAll();
    if ((this.aL) || (bool))
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.putExtra("fragment_id", 1);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    int i = paramView.getId();
    anot.a(this.app, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      send();
      continue;
      Intent localIntent = (Intent)paramView.getTag();
      if (localIntent.getExtras().getInt("uintype") == 0)
      {
        String str = localIntent.getExtras().getString("uin");
        if (!ChatActivityUtils.q(this.app, str))
        {
          localIntent.removeExtra("uintype");
          localIntent.putExtra("uintype", 1003);
        }
      }
      localIntent.putExtra("message_box_click", true);
      MediaPlayerManager.a(this.app).stop(false);
      startActivity(localIntent);
      paramView.setVisibility(8);
      finish();
      continue;
      anot.a(this.app, "dc00898", "", "", "0X8009F36", "0X8009F36", 4, 0, "", "", "", "");
      K(false);
      continue;
      anot.a(this.app, "dc00898", "", "", "0X8009F27", "0X8009F27", 4, 0, "", "", "", "");
      bI();
      continue;
      if (this.mIsFullScreenMode) {
        K(false);
      }
      send();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    int i = 0;
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt != 100) {
      QLog.e(TAG, 2, "onRequestPermissionsResult error, requestcode:" + paramInt + " grantresult:" + paramArrayOfInt);
    }
    label97:
    for (;;)
    {
      return;
      paramInt = 0;
      if (paramInt < paramArrayOfInt.length) {
        if (paramArrayOfInt[paramInt] != 0) {
          aqha.a(this, paramArrayOfString, paramArrayOfInt);
        }
      }
      for (paramInt = i;; paramInt = 1)
      {
        if (paramInt == 0) {
          break label97;
        }
        aP();
        return;
        paramInt += 1;
        break;
      }
    }
  }
  
  void p(Intent paramIntent)
  {
    setLeftViewName(paramIntent);
    String str = this.leftView.getText().toString();
    if (str.contains(getString(2131720735)))
    {
      this.y = this.leftView;
      anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4recent");
      aQ();
    }
    for (;;)
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        this.aL = paramIntent.getExtras().getBoolean("isBack2Root");
        paramIntent.getExtras().putBoolean("isBack2Root", false);
      }
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("LASTFROM");
        if (str != null)
        {
          this.leftView.setText(str);
          this.y = this.leftView;
        }
      }
      if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
      {
        this.aL = true;
        this.leftView.setText(getString(2131720735));
        this.y = this.leftView;
        aQ();
      }
      if ((paramIntent != null) && (paramIntent.getIntExtra("dataline_forward_type", -1) != -1))
      {
        if (!this.aM) {
          this.aM = paramIntent.getExtras().getBoolean("is_share_flag");
        }
        if (!this.aM)
        {
          this.aL = true;
          this.leftView.setText(getString(2131720735));
          this.y = this.leftView;
          aQ();
        }
      }
      if (ujs.aTl)
      {
        str = this.leftView.getText().toString();
        paramIntent = str;
        if (!getString(2131690700).equals(str)) {
          paramIntent = acfp.m(2131707818) + str + acfp.m(2131707821);
        }
        this.leftView.setContentDescription(paramIntent);
      }
      return;
      if (str.contains(getString(2131695648))) {
        anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4buddylist");
      } else if (str.contains(getString(2131693604))) {
        anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4dongtai");
      }
    }
  }
  
  public boolean r(int paramInt)
  {
    return false;
  }
  
  void u(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.length() > 4500)
    {
      QQToast.a(this, acfp.m(2131707819), 1).show(getTitleBarHeight());
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      anot.a(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((acde)this.app.getBusinessHandler(8)).a(paramString, this.cM);
    anot.a(this.app, "dc00898", "", "", "0X800AD68", "0X800AD68", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Db.notifyDataSetChanged();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.mListView);
    a(this.mListView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      a(paramObservable, paramObject);
      return;
    }
    new Handler(localLooper).post(new LiteActivity.38(this, paramObservable, paramObject));
  }
  
  public void v(boolean paramBoolean)
  {
    this.jdField_a_of_type_Db.notifyDataSetChanged();
    this.app.b().a(this.cM).cNX();
    if (!paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.mListView);
      a(this.mListView);
    }
  }
  
  void z(String paramString)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.time = anaz.gQ();
    localDataLineMsgRecord.msgtype = -2334;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    localDataLineMsgRecord.issend = 255;
    localDataLineMsgRecord.msg = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.appendToList(localDataLineMsgRecord);
    this.jdField_a_of_type_Db.notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract void onResult(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void a(Bitmap paramBitmap, boolean paramBoolean);
  }
  
  public class c
  {
    ArrayList<String> G;
    LiteActivity a;
    int cZ;
    
    public c(LiteActivity paramLiteActivity)
    {
      this.a = paramLiteActivity;
    }
    
    String b(Uri paramUri)
    {
      return FileProvider7Helper.getRealPathFromContentURI(LiteActivity.this.getApplicationContext(), paramUri);
    }
    
    void b(ArrayList<Uri> paramArrayList, boolean paramBoolean)
    {
      int i = 1;
      if (paramArrayList == null)
      {
        LiteActivity.s(LiteActivity.this);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      String str;
      if (paramArrayList.size() == 1)
      {
        str = b((Uri)paramArrayList.get(0));
        if ((TextUtils.isEmpty(str)) || (!new VFSFile(str).canRead()))
        {
          localArrayList.add(LiteActivity.a(LiteActivity.this, (Uri)paramArrayList.get(0)));
          this.G = localArrayList;
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            this.cZ = i;
            return;
          }
        }
        localArrayList.add(str);
        if (!paramBoolean) {
          break label183;
        }
      }
      for (;;)
      {
        LiteActivity.this.b(localArrayList, i);
        return;
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          str = b((Uri)paramArrayList.next());
          if (!TextUtils.isEmpty(str)) {
            localArrayList.add(str);
          }
        }
        break;
        label183:
        i = 0;
      }
    }
    
    public void bO()
    {
      if (this.G == null) {}
      while (this.cZ == -1) {
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.i(LiteActivity.TAG, 1, "sendMultipleFileWithFileProvider. [fileType] = " + this.cZ);
        Iterator localIterator = this.G.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          QLog.i(LiteActivity.TAG, 1, "[filePath] = " + str);
        }
      }
      LiteActivity.this.b(this.G, this.cZ);
      this.G = null;
      this.cZ = -1;
    }
    
    public void q(Intent paramIntent)
    {
      Bundle localBundle;
      Object localObject;
      try
      {
        localBundle = paramIntent.getExtras();
        if (paramIntent.getBooleanExtra("dataline_share_finish", false)) {
          return;
        }
        paramIntent.putExtra("dataline_share_finish", true);
        localObject = paramIntent.getType();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        if (localBundle == null)
        {
          QLog.e(LiteActivity.TAG, 1, "LiteJumpAction:doShare type is [" + (String)localObject + "], action is [" + paramIntent.getAction() + "]");
          return;
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
      if ((((String)localObject).startsWith("text")) && (!localBundle.containsKey("android.intent.extra.STREAM")))
      {
        paramIntent = localBundle.getString("android.intent.extra.TEXT");
        this.a.u(paramIntent);
        return;
      }
      if (((String)localObject).startsWith("message"))
      {
        paramIntent = (SpannableString)localBundle.get("android.intent.extra.TEXT");
        this.a.u(paramIntent.toString());
        return;
      }
      if (((String)localObject).startsWith("image"))
      {
        if (paramIntent.getAction().equals("android.intent.action.SEND"))
        {
          paramIntent = (Uri)localBundle.get("android.intent.extra.STREAM");
          if (paramIntent == null)
          {
            LiteActivity.s(LiteActivity.this);
            return;
          }
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramIntent);
          b((ArrayList)localObject, true);
          return;
        }
        paramIntent = (ArrayList)localBundle.get("android.intent.extra.STREAM");
        if (paramIntent.size() > 50)
        {
          LiteActivity.t(LiteActivity.this);
          return;
        }
        b(paramIntent, true);
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.SEND"))
      {
        paramIntent = (Uri)localBundle.get("android.intent.extra.STREAM");
        if (paramIntent == null)
        {
          LiteActivity.s(LiteActivity.this);
          return;
        }
        if (((paramIntent instanceof Uri)) && ("text/x-vcard".equals(localObject)) && ("content".equals(paramIntent.getScheme())))
        {
          new LiteActivity.f(LiteActivity.this).execute(new Object[] { LiteActivity.this.getApplicationContext(), paramIntent });
          return;
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramIntent);
        b((ArrayList)localObject, false);
        return;
      }
      b((ArrayList)localBundle.get("android.intent.extra.STREAM"), false);
    }
  }
  
  public class d
    extends AsyncTask<Bundle, Integer, Void>
  {
    public d() {}
    
    DataLineMsgRecord a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.path = paramString;
      localDataLineMsgRecord.msgtype = -2000;
      localDataLineMsgRecord.groupId = paramInt1;
      localDataLineMsgRecord.groupSize = paramInt2;
      localDataLineMsgRecord.groupIndex = paramInt3;
      return localDataLineMsgRecord;
    }
    
    protected Void a(Bundle... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0].getStringArrayList("PhotoConst.PHOTO_PATHS");
      if (paramVarArgs == null) {
        return null;
      }
      j(paramVarArgs);
      return null;
    }
    
    void j(List<String> paramList)
    {
      acde localacde = (acde)LiteActivity.this.app.getBusinessHandler(8);
      for (;;)
      {
        int j = paramList.size();
        if (j <= 3)
        {
          i = 0;
          while (i < j)
          {
            localacde.a(a((String)paramList.get(i), 0, 0, 0), false);
            i += 1;
          }
        }
        if ((j > 3) && (j < 50))
        {
          localArrayList = new ArrayList();
          int k = localacde.An();
          i = 0;
          while (i < j)
          {
            localArrayList.add(a((String)paramList.get(i), k, j, i));
            i += 1;
          }
          cu.n(LiteActivity.this.app);
          localacde.z(localArrayList, false);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        j = localacde.An();
        int i = 0;
        while (i < 50)
        {
          localArrayList.add(a((String)paramList.get(i), j, 50, i));
          i += 1;
        }
        cu.n(LiteActivity.this.app);
        localacde.z(localArrayList, false);
        i = 0;
        while (i < 50)
        {
          paramList.remove(0);
          i += 1;
        }
      }
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      LiteActivity.this.v(false);
    }
  }
  
  public class e
    extends AsyncTask<Bundle, Integer, Void>
  {
    public e() {}
    
    protected Void a(Bundle... paramVarArgs)
    {
      Object localObject = paramVarArgs[0].getStringArrayList("PhotoConst.PHOTO_PATHS");
      if (localObject == null) {}
      for (;;)
      {
        return null;
        paramVarArgs = (acde)LiteActivity.this.app.getBusinessHandler(8);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
          localDataLineMsgRecord.path = str;
          localDataLineMsgRecord.msgtype = -2009;
          paramVarArgs.a(localDataLineMsgRecord, false);
        }
      }
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      LiteActivity.this.v(false);
    }
  }
  
  class f
    extends AsyncTask<Object, Void, Uri>
  {
    f() {}
    
    /* Error */
    protected Uri a(Object... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 4
      //   5: aconst_null
      //   6: astore 9
      //   8: aconst_null
      //   9: astore 8
      //   11: aconst_null
      //   12: astore 7
      //   14: aload_1
      //   15: iconst_0
      //   16: aaload
      //   17: checkcast 26	android/content/Context
      //   20: astore 11
      //   22: aload_1
      //   23: iconst_1
      //   24: aaload
      //   25: checkcast 28	android/net/Uri
      //   28: astore 12
      //   30: getstatic 34	acbn:bml	Ljava/lang/String;
      //   33: astore 10
      //   35: aload 11
      //   37: invokevirtual 38	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   40: aload 12
      //   42: iconst_1
      //   43: anewarray 40	java/lang/String
      //   46: dup
      //   47: iconst_0
      //   48: ldc 42
      //   50: aastore
      //   51: aconst_null
      //   52: aconst_null
      //   53: aconst_null
      //   54: invokestatic 48	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   57: astore_1
      //   58: aload_1
      //   59: ifnull +227 -> 286
      //   62: aload_1
      //   63: invokeinterface 54 1 0
      //   68: ifeq +218 -> 286
      //   71: aload_1
      //   72: iconst_0
      //   73: invokeinterface 58 2 0
      //   78: astore 6
      //   80: aload_1
      //   81: invokeinterface 61 1 0
      //   86: aload 10
      //   88: invokestatic 67	aqhq:fileExists	(Ljava/lang/String;)Z
      //   91: ifne +16 -> 107
      //   94: new 69	com/tencent/mm/vfs/VFSFile
      //   97: dup
      //   98: aload 10
      //   100: invokespecial 72	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
      //   103: invokevirtual 75	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
      //   106: pop
      //   107: new 77	com/tencent/mm/vfs/VFSFileOutputStream
      //   110: dup
      //   111: new 69	com/tencent/mm/vfs/VFSFile
      //   114: dup
      //   115: new 79	java/lang/StringBuilder
      //   118: dup
      //   119: invokespecial 80	java/lang/StringBuilder:<init>	()V
      //   122: aload 10
      //   124: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   127: aload 6
      //   129: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   132: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   135: invokespecial 72	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
      //   138: invokespecial 91	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
      //   141: astore 5
      //   143: aload 7
      //   145: astore_3
      //   146: aload 8
      //   148: astore_1
      //   149: aload 11
      //   151: invokevirtual 38	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   154: aload 12
      //   156: ldc 93
      //   158: invokevirtual 99	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
      //   161: astore 9
      //   163: aload 9
      //   165: ifnull +149 -> 314
      //   168: aload 7
      //   170: astore_3
      //   171: aload 8
      //   173: astore_1
      //   174: aload 9
      //   176: invokevirtual 105	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
      //   179: astore 4
      //   181: aload 4
      //   183: astore_3
      //   184: aload 4
      //   186: astore_1
      //   187: sipush 1024
      //   190: newarray byte
      //   192: astore 7
      //   194: aload 4
      //   196: astore_3
      //   197: aload 4
      //   199: astore_1
      //   200: aload 4
      //   202: aload 7
      //   204: invokevirtual 111	java/io/InputStream:read	([B)I
      //   207: istore_2
      //   208: iload_2
      //   209: iconst_m1
      //   210: if_icmpeq +93 -> 303
      //   213: aload 4
      //   215: astore_3
      //   216: aload 4
      //   218: astore_1
      //   219: aload 5
      //   221: aload 7
      //   223: iconst_0
      //   224: iload_2
      //   225: invokevirtual 115	com/tencent/mm/vfs/VFSFileOutputStream:write	([BII)V
      //   228: goto -34 -> 194
      //   231: astore 4
      //   233: aload 5
      //   235: astore_1
      //   236: aload 4
      //   238: invokevirtual 118	java/lang/Exception:printStackTrace	()V
      //   241: aload_3
      //   242: ifnull +7 -> 249
      //   245: aload_3
      //   246: invokevirtual 119	java/io/InputStream:close	()V
      //   249: aload_1
      //   250: ifnull +7 -> 257
      //   253: aload_1
      //   254: invokevirtual 120	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
      //   257: new 79	java/lang/StringBuilder
      //   260: dup
      //   261: invokespecial 80	java/lang/StringBuilder:<init>	()V
      //   264: ldc 122
      //   266: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   269: aload 10
      //   271: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   274: aload 6
      //   276: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   279: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   282: invokestatic 126	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   285: areturn
      //   286: aload_1
      //   287: ifnull +9 -> 296
      //   290: aload_1
      //   291: invokeinterface 61 1 0
      //   296: ldc 128
      //   298: astore 6
      //   300: goto -214 -> 86
      //   303: aload 4
      //   305: astore_3
      //   306: aload 4
      //   308: astore_1
      //   309: aload 5
      //   311: invokevirtual 131	com/tencent/mm/vfs/VFSFileOutputStream:flush	()V
      //   314: aload 4
      //   316: ifnull +8 -> 324
      //   319: aload 4
      //   321: invokevirtual 119	java/io/InputStream:close	()V
      //   324: aload 5
      //   326: ifnull +8 -> 334
      //   329: aload 5
      //   331: invokevirtual 120	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
      //   334: new 79	java/lang/StringBuilder
      //   337: dup
      //   338: invokespecial 80	java/lang/StringBuilder:<init>	()V
      //   341: ldc 122
      //   343: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   346: aload 10
      //   348: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   351: aload 6
      //   353: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   356: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   359: invokestatic 126	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   362: areturn
      //   363: astore_1
      //   364: aload_1
      //   365: invokevirtual 132	java/io/IOException:printStackTrace	()V
      //   368: goto -44 -> 324
      //   371: astore_1
      //   372: aload_1
      //   373: invokevirtual 132	java/io/IOException:printStackTrace	()V
      //   376: goto -42 -> 334
      //   379: astore_3
      //   380: aload_3
      //   381: invokevirtual 132	java/io/IOException:printStackTrace	()V
      //   384: goto -135 -> 249
      //   387: astore_1
      //   388: aload_1
      //   389: invokevirtual 132	java/io/IOException:printStackTrace	()V
      //   392: goto -135 -> 257
      //   395: astore 4
      //   397: aconst_null
      //   398: astore 5
      //   400: aload 9
      //   402: astore_1
      //   403: aload_1
      //   404: ifnull +7 -> 411
      //   407: aload_1
      //   408: invokevirtual 119	java/io/InputStream:close	()V
      //   411: aload 5
      //   413: ifnull +8 -> 421
      //   416: aload 5
      //   418: invokevirtual 120	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
      //   421: new 79	java/lang/StringBuilder
      //   424: dup
      //   425: invokespecial 80	java/lang/StringBuilder:<init>	()V
      //   428: ldc 122
      //   430: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   433: aload 10
      //   435: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   438: aload 6
      //   440: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   443: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   446: invokestatic 126	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   449: pop
      //   450: aload 4
      //   452: athrow
      //   453: astore_1
      //   454: aload_1
      //   455: invokevirtual 132	java/io/IOException:printStackTrace	()V
      //   458: goto -47 -> 411
      //   461: astore_1
      //   462: aload_1
      //   463: invokevirtual 132	java/io/IOException:printStackTrace	()V
      //   466: goto -45 -> 421
      //   469: astore 4
      //   471: goto -68 -> 403
      //   474: astore 4
      //   476: aload_1
      //   477: astore 5
      //   479: aload_3
      //   480: astore_1
      //   481: goto -78 -> 403
      //   484: astore 4
      //   486: aconst_null
      //   487: astore_1
      //   488: goto -252 -> 236
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	491	0	this	f
      //   0	491	1	paramVarArgs	Object[]
      //   207	18	2	i	int
      //   1	305	3	localObject1	Object
      //   379	101	3	localIOException	java.io.IOException
      //   3	214	4	localFileInputStream	java.io.FileInputStream
      //   231	89	4	localException1	Exception
      //   395	56	4	localObject2	Object
      //   469	1	4	localObject3	Object
      //   474	1	4	localObject4	Object
      //   484	1	4	localException2	Exception
      //   141	337	5	localObject5	Object
      //   78	361	6	str1	String
      //   12	210	7	arrayOfByte	byte[]
      //   9	163	8	localObject6	Object
      //   6	395	9	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
      //   33	401	10	str2	String
      //   20	130	11	localContext	Context
      //   28	127	12	localUri	Uri
      // Exception table:
      //   from	to	target	type
      //   149	163	231	java/lang/Exception
      //   174	181	231	java/lang/Exception
      //   187	194	231	java/lang/Exception
      //   200	208	231	java/lang/Exception
      //   219	228	231	java/lang/Exception
      //   309	314	231	java/lang/Exception
      //   319	324	363	java/io/IOException
      //   329	334	371	java/io/IOException
      //   245	249	379	java/io/IOException
      //   253	257	387	java/io/IOException
      //   86	107	395	finally
      //   107	143	395	finally
      //   407	411	453	java/io/IOException
      //   416	421	461	java/io/IOException
      //   149	163	469	finally
      //   174	181	469	finally
      //   187	194	469	finally
      //   200	208	469	finally
      //   219	228	469	finally
      //   309	314	469	finally
      //   236	241	474	finally
      //   86	107	484	java/lang/Exception
      //   107	143	484	java/lang/Exception
    }
    
    @TargetApi(17)
    protected void b(Uri paramUri)
    {
      paramUri = paramUri.getPath();
      if (!TextUtils.isEmpty(paramUri))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramUri);
        LiteActivity.this.b(localArrayList, 0);
      }
      do
      {
        do
        {
          return;
        } while (LiteActivity.this.isFinishing());
        if (Build.VERSION.SDK_INT < 17) {
          break;
        }
      } while (LiteActivity.this.isDestroyed());
      LiteActivity.s(LiteActivity.this);
      return;
      LiteActivity.s(LiteActivity.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity
 * JD-Core Version:    0.7.0.1
 */