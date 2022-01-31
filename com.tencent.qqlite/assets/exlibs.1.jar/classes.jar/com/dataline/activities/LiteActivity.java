package com.dataline.activities;

import ab;
import ac;
import ae;
import ai;
import aj;
import ak;
import al;
import am;
import an;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.StatFs;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ao;
import ap;
import aq;
import ar;
import as;
import at;
import au;
import av;
import aw;
import ax;
import ay;
import ba;
import com.dataline.util.DatalineSessionAdapter;
import com.dataline.util.ItemHolder;
import com.dataline.util.ItemHolder.FileItemHolder;
import com.dataline.util.ItemHolder.ImageItemHolder;
import com.dataline.util.ItemHolder.MutiImageItemHolder;
import com.dataline.util.ItemHolder.TextItemHolder;
import com.dataline.util.file.FileUtil;
import com.dataline.util.file.SendInfo;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardOperations.CancelCallback;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.MenuPopupDialog;
import com.tencent.widget.XListView;
import h;
import i;
import j;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k;
import l;
import m;
import mqq.app.MobileQQ;
import n;
import o;
import p;
import q;

public class LiteActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, ForwardOperations.CancelCallback, Observer
{
  public static final int a = 5242880;
  public static String a;
  public static final int b = 0;
  public static final String b = "dataline_text_cache";
  public static final int c = 1;
  public static final String c = "key_text";
  public static final int d = 2;
  public static final String d = "dataline_share_finish";
  public static final int e = 3;
  public static final String e = "dataline_send_file_path";
  public static final int f = 4;
  public static final String f = "dataline_send_file_type";
  public static final int g = 5;
  public static final String g = "dataline_send_file_flag";
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 101;
  static final int m = 55;
  long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new au(this);
  private View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new av(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ay jdField_a_of_type_Ay;
  private LiteActivity.LiteJumpAction jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction;
  private DatalineSessionAdapter jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = null;
  private ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
  private ForwardOperations jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = null;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new q(this);
  private DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = null;
  private FastImagePreviewLayout jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new am(this);
  public ScrollerRunnable a;
  public MenuPopupDialog a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public Runnable a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public View.OnClickListener b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  private boolean d = false;
  private int n;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.LiteActivity";
  }
  
  public LiteActivity()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new l(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new m(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new aj(this);
    this.jdField_a_of_type_JavaLangRunnable = new ao(this);
  }
  
  private DataLineMsgRecord a(DataLineHandler paramDataLineHandler, SendInfo paramSendInfo, DataLineHandler.EFILETYPE paramEFILETYPE, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramSendInfo == null) {
      return null;
    }
    paramDataLineHandler = new DataLineMsgRecord();
    String str1 = paramSendInfo.a();
    String str2 = paramSendInfo.b();
    paramDataLineHandler.sessionid = paramSendInfo.a();
    paramDataLineHandler.path = str1;
    paramDataLineHandler.thumbPath = str2;
    paramDataLineHandler.msgtype = DataLineHandler.a(paramEFILETYPE);
    paramDataLineHandler.groupId = paramInt1;
    paramDataLineHandler.groupSize = paramInt2;
    paramDataLineHandler.groupIndex = paramInt3;
    return paramDataLineHandler;
  }
  
  private void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(getString(2131363384));
    String str2 = getString(2131362486);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramString = new at(this, paramLong, this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  public static void a(Context paramContext)
  {
    j localj = new j();
    DialogUtil.a(paramContext, 233, paramContext.getString(2131363512), paramContext.getString(2131361878), 2131361823, 2131361823, localj, null).show();
  }
  
  private void a(Intent paramIntent, boolean paramBoolean)
  {
    paramIntent = null;
    if (paramBoolean) {
      PreferenceManager.getDefaultSharedPreferences(this).edit().putString("camera_photo_path", PlusPanelUtils.b).commit();
    }
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("camera_photo_path", "");
    if (!((String)localObject).equalsIgnoreCase(""))
    {
      PlusPanelUtils.jdField_a_of_type_JavaLangString = (String)localObject;
      paramIntent = Uri.fromFile(new File((String)localObject));
    }
    PreferenceManager.getDefaultSharedPreferences(this).edit().remove("camera_photo_path").commit();
    if (paramIntent == null) {
      return;
    }
    paramIntent = ImageUtil.c(this, paramIntent);
    ImageUtil.a(this, paramIntent);
    if (paramIntent != null)
    {
      if (!FileUtils.e(paramIntent))
      {
        QQToast.a(this, getString(2131363408), 0).b(getTitleBarHeight());
        return;
      }
      if (!new File(paramIntent).exists()) {
        QQToast.a(this, getString(2131363409), 0).b(getTitleBarHeight());
      }
    }
    else
    {
      QQToast.a(this, getString(2131363409), 0).b(getTitleBarHeight());
      return;
    }
    localObject = new Intent();
    ArrayList localArrayList = new ArrayList();
    ((Intent)localObject).setClass(this, CameraPreviewActivity.class);
    localArrayList.add(paramIntent);
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    ((Intent)localObject).putExtra(AlbumConstants.i, 55);
    ((Intent)localObject).putExtra("uin", AppConstants.T);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    if (paramBoolean)
    {
      ((Intent)localObject).putExtra("uintype", 7);
      ((Intent)localObject).putExtra("callFromFastImage", true);
    }
    startActivity((Intent)localObject);
  }
  
  private void a(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.e(getActivity()))
    {
      FMToastUtil.a(2131363449);
      return;
    }
    Object localObject2 = "";
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    Object localObject1;
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 5242880L)) {
      localObject1 = getString(2131362019);
    }
    label80:
    int i1;
    for (;;)
    {
      if (((String)localObject1).equals(""))
      {
        localObject1 = getString(2131361829);
        localObject2 = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
        ((ActionSheet)localObject2).a((CharSequence)localObject1);
        ((ActionSheet)localObject2).a(getResources().getString(2131361994), 1);
        ((ActionSheet)localObject2).d(2131362790);
        ((ActionSheet)localObject2).a(new n(this, localDataLineMsgSet, paramItemHolder, (ActionSheet)localObject2));
        ((ActionSheet)localObject2).show();
        return;
        if (localDataLineMsgSet.getGroupType() == -1000)
        {
          localObject1 = getString(2131361830);
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
              i1 = 0;
              label205:
              if (((Iterator)localObject1).hasNext())
              {
                if (!DataLineMsgSet.isCanReciveOrResend((DataLineMsgRecord)((Iterator)localObject1).next())) {
                  break label264;
                }
                i1 += 1;
              }
            }
          }
        }
      }
    }
    label264:
    for (;;)
    {
      break label205;
      localObject1 = String.format(getString(2131361902), new Object[] { Integer.valueOf(i1) });
      break;
      break label80;
    }
  }
  
  private static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    View localView = paramIphoneTitleBarActivity.findViewById(2131296947);
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
    int i1 = 0;
    SharedPreferences localSharedPreferences = paramIphoneTitleBarActivity.getSharedPreferences("chat_background_path_" + paramIphoneTitleBarActivity.app.a(), 0);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = AppConstants.T;
    arrayOfString[1] = "chat_uniform_bg";
    if ((localSharedPreferences.getString(arrayOfString[0], null) == null) && (localSharedPreferences.getString(arrayOfString[1], null) == null))
    {
      a(paramIphoneTitleBarActivity, paramViewGroup, "null");
      return;
    }
    int i2 = arrayOfString.length;
    for (;;)
    {
      if (i1 >= i2) {
        break label207;
      }
      String str = localSharedPreferences.getString(arrayOfString[i1], null);
      if (str != null)
      {
        if (("".equals(str)) || ("null".equals(str)) || ("none".equals(str)))
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, str);
          return;
        }
        if (!new File(str).exists())
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, "null");
          return;
        }
        if (a(paramIphoneTitleBarActivity, paramViewGroup, str)) {
          break;
        }
      }
      i1 += 1;
    }
    label207:
    a(paramIphoneTitleBarActivity, paramViewGroup, "null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    paramContext = FileUtil.c(paramContext, paramString);
    ((DataLineHandler)paramQQAppInterface.a(8)).a(paramString, paramContext, DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE, 0L, 0, 0, 0, false);
  }
  
  private void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.app.a(paramMessage))) {
      return;
    }
    runOnUiThread(new an(this, paramMessage, this.app.a(this, paramMessage, false)));
  }
  
  public static void a(ScrollerRunnable paramScrollerRunnable, XListView paramXListView)
  {
    if (paramXListView != null) {
      paramXListView.postDelayed(new ab(paramXListView, paramScrollerRunnable), 200L);
    }
  }
  
  public static void a(XListView paramXListView)
  {
    if (paramXListView != null) {
      paramXListView.setSelection(paramXListView.b());
    }
  }
  
  private void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    if ((paramString != null) && (paramString.length() > 3478))
    {
      QQToast.a(this, "字数超出限制", 1).b(getTitleBarHeight());
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((DataLineHandler)this.app.a(8)).a(paramString);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    if (!c()) {
      b(null);
    }
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      return;
      localDataLineMsgRecord = this.app.a().a().b(paramLong);
    } while (localDataLineMsgRecord == null);
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.a(8);
    localDataLineMsgRecord.bIsResendOrRecvFile = true;
    switch (paramInt)
    {
    default: 
      this.app.a().a().a(paramLong);
      a(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      return;
      localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, DataLineHandler.EFILETYPE.FILE_TYPE_VIDEO, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, DataLineHandler.EFILETYPE.FILE_TYPE_FILE, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
    }
  }
  
  private void a(String paramString1, String paramString2, DataLineHandler.EFILETYPE paramEFILETYPE, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    ((DataLineHandler)this.app.a(8)).a(paramString1, paramString2, paramEFILETYPE, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    a(paramBoolean);
  }
  
  private void a(ArrayList paramArrayList, DataLineHandler.EFILETYPE paramEFILETYPE)
  {
    if (paramArrayList == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sendMultipleFile paths is null !!!!!!");
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
        }
        i1 += 1;
      }
    }
    aw localaw = new aw(this, paramArrayList);
    paramArrayList = paramArrayList.iterator();
    long l1 = 0L;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l1 += new File(str).length();
      }
    }
    if (l1 == 0L)
    {
      a(this);
      return;
    }
    if ((NetworkUtil.f(this)) && (!NetworkUtil.g(this)) && (l1 > 5242880L))
    {
      paramArrayList = new ax(this, localaw, paramEFILETYPE);
      paramEFILETYPE = new i(this);
      DialogUtil.a(getActivity(), 230, getString(2131361833), getString(2131361834), 2131362790, 2131361835, paramArrayList, paramEFILETYPE).show();
      return;
    }
    localaw.execute(new DataLineHandler.EFILETYPE[] { paramEFILETYPE });
  }
  
  private void a(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof DataLineMsgRecord))
    {
      paramObservable = (DataLineMsgRecord)paramObject;
      paramObject = this.app.a().a(paramObservable.sessionid);
      if ((DataLineMsgSet.isSingle(paramObservable)) || (paramObject == null) || (paramObject.getComeCount() <= 1)) {
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      }
    }
    label53:
    do
    {
      do
      {
        do
        {
          break label53;
          do
          {
            return;
          } while (this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(paramObservable.sessionid, this.jdField_a_of_type_ComTencentWidgetXListView));
          this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
          return;
          if (!(paramObject instanceof QQMessageFacade.Message)) {
            break;
          }
          paramObservable = (QQMessageFacade.Message)paramObject;
        } while ((paramObservable.frienduin == null) || (!paramObservable.frienduin.endsWith(String.valueOf(AppConstants.T))));
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
        return;
      } while (!(paramObject instanceof RecentUser));
      paramObservable = (RecentUser)paramObject;
    } while ((paramObservable.uin == null) || (!paramObservable.uin.endsWith(String.valueOf(AppConstants.T))));
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  private static boolean a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup, String paramString)
  {
    Object localObject = (String)paramViewGroup.getTag(2131296393);
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
      if ("null".equals(localObject)) {}
    }
    for (;;)
    {
      try
      {
        paramViewGroup.setBackgroundResource(2130837674);
        paramViewGroup.setTag(2131296393, "null");
        return true;
      }
      catch (Exception paramIphoneTitleBarActivity)
      {
        if (QLog.isColorLevel()) {
          paramIphoneTitleBarActivity.printStackTrace();
        }
        paramViewGroup.setBackgroundResource(2130839253);
        continue;
      }
      if ("none".equals(paramString))
      {
        if (!"none".equals(localObject))
        {
          paramViewGroup.setBackgroundResource(2130839246);
          paramViewGroup.setTag(2131296393, "none");
        }
      }
      else if (!paramString.equals(localObject))
      {
        localObject = BitmapManager.a(paramString);
        if (localObject == null) {
          break;
        }
        localObject = new ChatBackgroundDrawable(paramIphoneTitleBarActivity.getResources(), (Bitmap)localObject);
        paramViewGroup.setBackgroundDrawable((Drawable)localObject);
        paramViewGroup.setTag(2131296393, paramString);
        paramViewGroup.setTag(2131296394, localObject);
        a(paramIphoneTitleBarActivity);
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong == 0L) {}
    do
    {
      do
      {
        return true;
        paramQQAppInterface = paramQQAppInterface.a().a(paramLong);
      } while (paramQQAppInterface == null);
      if ((paramQQAppInterface.cloudType != 2) && (paramQQAppInterface.status == 1)) {
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
  
  private void b(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.e(getActivity()))
    {
      FMToastUtil.a(2131363449);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 5242880L)) {}
    for (paramItemHolder = getString(2131362020);; paramItemHolder = "")
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = localDataLineMsgSet.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord))
        {
          localDataLineMsgRecord.bIsResendOrRecvFile = true;
          localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
        }
      }
      if ((localArrayList.size() == 0) && (!localDataLineMsgSet.isSingle()))
      {
        int i1 = localDataLineMsgSet.getTotalCount() - localDataLineMsgSet.getComeCount();
        if ((localDataLineMsgSet.getGroupType() == -2000) || ((localDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgSet.getFirstItem().bIsMoloImage))) {}
        for (paramItemHolder = String.format(getString(2131361904), new Object[] { Integer.valueOf(i1) });; paramItemHolder = String.format(getString(2131361903), new Object[] { Integer.valueOf(i1) }))
        {
          localObject = new o(this);
          DialogUtil.a(this, 230, getString(2131361833), paramItemHolder, 2131362791, 2131362791, null, (DialogInterface.OnClickListener)localObject).show();
          return;
        }
      }
      localObject = paramItemHolder;
      if (paramItemHolder.equals(""))
      {
        localObject = paramItemHolder;
        if (localDataLineMsgSet.getGroupType() == -2000)
        {
          localObject = paramItemHolder;
          if (!localDataLineMsgSet.isSingle()) {
            localObject = String.format(getString(2131361901), new Object[] { Integer.valueOf(localArrayList.size()) });
          }
        }
      }
      paramItemHolder = (ItemHolder)localObject;
      if (((String)localObject).equals("")) {
        paramItemHolder = getString(2131361832);
      }
      localObject = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
      ((ActionSheet)localObject).a(paramItemHolder);
      ((ActionSheet)localObject).a(getResources().getString(2131361993), 1);
      ((ActionSheet)localObject).d(2131362790);
      ((ActionSheet)localObject).a(new p(this, localDataLineMsgSet, localArrayList, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
    }
  }
  
  private static void b(ScrollerRunnable paramScrollerRunnable, XListView paramXListView, int paramInt)
  {
    if (paramXListView != null) {}
    try
    {
      paramScrollerRunnable.a(paramInt, -1, null);
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
  
  private void b(String paramString)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.msgtype = -2334;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    localDataLineMsgRecord.issend = 255;
    localDataLineMsgRecord.msg = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.appendToList(localDataLineMsgRecord);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  private void b(ArrayList paramArrayList, DataLineHandler.EFILETYPE paramEFILETYPE)
  {
    if (paramArrayList == null) {}
    DataLineHandler localDataLineHandler;
    int i2;
    int i1;
    Object localObject;
    for (;;)
    {
      return;
      localDataLineHandler = (DataLineHandler)this.app.a(8);
      i2 = paramArrayList.size();
      if (i2 > 5) {
        break;
      }
      i1 = 0;
      while (i1 < i2)
      {
        localObject = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramEFILETYPE, 0, 0, 0);
        if (localObject != null) {
          localDataLineHandler.a((DataLineMsgRecord)localObject, false);
        }
        i1 += 1;
      }
    }
    label110:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((i2 > 5) && (i2 < 50))
    {
      localObject = new ArrayList();
      int i3 = localDataLineHandler.a();
      i1 = 0;
      if (i1 < i2)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramEFILETYPE, i3, i2, i1);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramEFILETYPE, i3)) {
          break label385;
        }
        localDataLineMsgRecord.groupId = 0;
        localDataLineMsgRecord.groupIndex = 0;
        localDataLineMsgRecord.groupSize = 0;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
    }
    label385:
    for (;;)
    {
      i1 += 1;
      break label110;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localDataLineHandler.a((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      i2 = localDataLineHandler.a();
      i1 = 0;
      label245:
      if (i1 < 50)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramEFILETYPE, i2, 50, i1);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramEFILETYPE, i2)) {
          break label382;
        }
        localDataLineMsgRecord.groupId = 0;
        localDataLineMsgRecord.groupIndex = 0;
        localDataLineMsgRecord.groupSize = 0;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
      label382:
      for (;;)
      {
        i1 += 1;
        break label245;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        i1 = 0;
        while (i1 < 50)
        {
          paramArrayList.remove(0);
          i1 += 1;
        }
        break;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
    for (long l1 = 200L;; l1 = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "delay is:" + l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aq(this, paramBoolean), l1);
      return;
    }
  }
  
  private String c()
  {
    return getSharedPreferences("dataline_text_cache", 0).getString("key_text", "");
  }
  
  private void c(Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))) {
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction.a(paramIntent);
    }
  }
  
  private boolean c()
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.app.a(9);
    return (localRegisterProxySvcPackHandler.a() == 0) || (localRegisterProxySvcPackHandler.b() != 0);
  }
  
  private void d()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("dataline_text_cache", 0);
    Editable localEditable = null;
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      localEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    }
    Object localObject = localEditable;
    if (localEditable == null) {
      localObject = "";
    }
    localSharedPreferences.edit().putString("key_text", localObject.toString()).commit();
  }
  
  private void d(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("dataline_send_file_path");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    paramIntent.putExtra("dataline_send_file_path", "");
    setLeftViewName(2131362936);
    int i1 = paramIntent.getIntExtra("dataline_send_file_type", -1);
    paramIntent = new ArrayList();
    paramIntent.add(localObject);
    localObject = DataLineHandler.EFILETYPE.values()[i1];
    ReportController.b(this.app, "CliOper", "", "", "0X8004B10", "0X8004B10", 0, 0, "", "", "", "");
    a(paramIntent, (DataLineHandler.EFILETYPE)localObject);
  }
  
  private void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "liteActivity onClick call removeFastImage");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(32);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
    }
  }
  
  private void e()
  {
    int i2 = 3;
    int i3 = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    this.n = ChatTextSizeSettingActivity.a(this);
    int i1 = i2;
    switch (i3)
    {
    default: 
      i1 = i2;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(i1);
      this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, this.n);
      return;
      i1 = 2;
      continue;
      i1 = 2;
    }
  }
  
  private void e(Intent paramIntent)
  {
    if (paramIntent.hasExtra("JumpAction.Text"))
    {
      paramIntent = paramIntent.getStringExtra("JumpAction.Text");
      if ((paramIntent != null) && (paramIntent.length() > 0))
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
          d(false);
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837545);
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramIntent);
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramIntent.length());
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
      }
    }
  }
  
  private void f()
  {
    setTitle(2131361822);
    ImageView localImageView = this.p;
    localImageView.setContentDescription(getResources().getText(2131361836));
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130839307);
    localImageView.setOnClickListener(new k(this));
    this.p.setContentDescription("进入我的电脑高级设置界面");
    g(getIntent());
  }
  
  private void f(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("dataline_forward_type", -1);
    if (i1 == -1) {
      label14:
      return;
    }
    long l1 = paramIntent.getLongExtra("req_share_id", 0L);
    Object localObject1 = DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE;
    ArrayList localArrayList;
    if (paramIntent.getBooleanExtra("sendMultiple", false))
    {
      localArrayList = paramIntent.getStringArrayListExtra("dataline_forward_pathlist");
      if (i1 != 100) {
        break label1233;
      }
      localObject1 = DataLineHandler.EFILETYPE.FILE_TYPE_FILE;
    }
    label160:
    label1225:
    label1228:
    label1233:
    for (;;)
    {
      if (localArrayList == null)
      {
        j();
        return;
      }
      Object localObject4 = localArrayList.iterator();
      int i2;
      for (i1 = 0; ((Iterator)localObject4).hasNext(); i1 = i2)
      {
        String str = (String)((Iterator)localObject4).next();
        if (str != null)
        {
          i2 = i1;
          if (!str.equals("/")) {}
        }
        else
        {
          i2 = i1;
          if (i1 == 0)
          {
            i2 = 1;
            j();
          }
          ((Iterator)localObject4).remove();
        }
      }
      if (!localArrayList.isEmpty())
      {
        a(localArrayList, (DataLineHandler.EFILETYPE)localObject1);
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
        }
        boolean bool = paramIntent.getExtras().getBoolean("refuse_show_share_result_dialog", false);
        if ((!this.jdField_a_of_type_Boolean) || (bool)) {
          break;
        }
        paramIntent = paramIntent.getExtras();
        localObject1 = paramIntent.getString("app_name");
        if (l1 != 0L) {
          break label1225;
        }
        paramIntent = StructMsgFactory.a(paramIntent);
        if ((paramIntent == null) || (!(paramIntent instanceof AbsShareMsg))) {
          break label1228;
        }
      }
      for (paramIntent = (AbsShareMsg)paramIntent;; paramIntent = null)
      {
        if (paramIntent != null) {
          l1 = paramIntent.mSourceAppid;
        }
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              a(l1, (String)localObject1);
              return;
              if (i1 != 0) {
                break label160;
              }
              j();
              break label160;
              localArrayList = new ArrayList();
              switch (i1)
              {
              default: 
                StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_other");
                break;
              case 101: 
                StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_image");
                localObject4 = paramIntent.getStringExtra("dataline_forward_path").split(";");
                localArrayList.clear();
                i1 = 0;
                if (i1 < localObject4.length) {
                  try
                  {
                    localObject1 = URLDecoder.decode(localObject4[i1], "UTF-8");
                    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                      if ((((String)localObject1).startsWith("http://")) || (((String)localObject1).startsWith("https://")))
                      {
                        a((String)localObject1);
                        ReportController.b(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                        if (QLog.isColorLevel()) {
                          QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                        }
                        i1 += 1;
                      }
                    }
                  }
                  catch (UnsupportedEncodingException paramIntent)
                  {
                    if (!QLog.isColorLevel()) {
                      break label14;
                    }
                    QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject4[i1]);
                    return;
                  }
                  catch (IllegalArgumentException localIllegalArgumentException1)
                  {
                    for (;;)
                    {
                      localObject2 = localObject4[i1];
                      continue;
                      localArrayList.add(localObject2);
                      continue;
                      if (QLog.isColorLevel()) {
                        QLog.e("qqdataline", 2, "gotoQfavShareMsg|file path invalid. path=" + (String)localObject2);
                      }
                    }
                  }
                }
                break;
              }
            }
            if (localArrayList.isEmpty()) {
              break label160;
            }
            a(localArrayList, DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE);
            if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
              break label160;
            }
            if (localArrayList.size() > 1)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
              if (!QLog.isColorLevel()) {
                break label160;
              }
              QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
              break label160;
            }
            if (localArrayList.size() != 1) {
              break label160;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break label160;
            }
            QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
            break label160;
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_file");
            Object localObject2 = paramIntent.getStringExtra("dataline_forward_path");
            if ((localObject2 == null) || (((String)localObject2).equals("")))
            {
              j();
              return;
            }
            localObject4 = ((String)localObject2).split(";");
            localArrayList.clear();
            i1 = 0;
            if (i1 < localObject4.length) {
              try
              {
                localObject2 = URLDecoder.decode(localObject4[i1], "UTF-8");
                if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                  if ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://")))
                  {
                    a((String)localObject2);
                    i1 += 1;
                  }
                }
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject4[i1]);
                return;
              }
              catch (IllegalArgumentException localIllegalArgumentException2)
              {
                for (;;)
                {
                  localObject3 = localObject4[i1];
                  continue;
                  localArrayList.add(localObject3);
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.e("qqdataline", 2, "shareFromMigSdk|file path invalid. path=" + (String)localObject3);
                  }
                }
              }
            }
          }
          if (localArrayList.isEmpty()) {
            break label160;
          }
          switch (FileManagerUtil.a((String)localArrayList.get(0)))
          {
          default: 
            localObject3 = DataLineHandler.EFILETYPE.FILE_TYPE_FILE;
          }
          for (;;)
          {
            a(localArrayList, (DataLineHandler.EFILETYPE)localObject3);
            if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
              break;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
            break;
            localObject3 = DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE;
            continue;
            localObject3 = DataLineHandler.EFILETYPE.FILE_TYPE_AUDIO;
            continue;
            localObject3 = DataLineHandler.EFILETYPE.FILE_TYPE_VIDEO;
          }
          Object localObject3 = paramIntent.getStringExtra("dataline_forward_text");
          if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
            break label160;
          }
          if (Patterns.b.matcher((CharSequence)localObject3).find()) {
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_link");
          }
          for (;;)
          {
            a((String)localObject3);
            break;
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_text");
          }
        }
      }
    }
  }
  
  private boolean f()
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      i();
      return false;
    }
    if (new StatFs(AppConstants.aq).getAvailableBlocks() <= 1)
    {
      h();
      return false;
    }
    return true;
  }
  
  private void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      this.app.a().a().b(localLong.longValue());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setMsgFailedWhenQuesting: session = " + localLong.longValue());
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void g(Intent paramIntent)
  {
    setLeftViewName(paramIntent);
    String str = this.h.getText().toString();
    if (str.contains(getString(2131362946)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView = this.h;
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_op4recent");
    }
    for (;;)
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
        this.jdField_c_of_type_Boolean = paramIntent.getExtras().getBoolean("isBack2Root");
      }
      if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))) {
        this.jdField_c_of_type_Boolean = true;
      }
      if ((paramIntent != null) && (paramIntent.getIntExtra("dataline_forward_type", -1) != -1))
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
        }
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_c_of_type_Boolean = true;
        }
      }
      return;
      if (str.contains(getString(2131362937))) {
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_op4buddylist");
      } else if (str.contains(getString(2131361939))) {
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_op4dongtai");
      }
    }
  }
  
  private void h()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130837966);
    localQQToast.c(2000);
    localQQToast.b(2131361847);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  private void i()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130837966);
    localQQToast.c(2000);
    localQQToast.b(2131361848);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  private void j()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130837966);
    localQQToast.c(2000);
    localQQToast.b(2131361863);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  private void k()
  {
    boolean bool = false;
    Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
    int i1 = 0;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
      int i2 = i1;
      for (;;)
      {
        i1 = i2;
        if (!localIterator2.hasNext()) {
          break;
        }
        if (!((DataLineMsgRecord)localIterator2.next()).isread) {
          i2 += 1;
        }
      }
    }
    if (i1 == 0) {
      bool = true;
    }
    b(bool);
  }
  
  private void l()
  {
    Object localObject = new ArrayList();
    ak localak = new ak(this, (List)localObject);
    al localal = new al(this);
    Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
    int i4 = 0;
    int i3 = 0;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
      int i1 = 0;
      int i2 = i3;
      int i5 = i4;
      i4 = i5;
      i3 = i2;
      if (localIterator2.hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
        if ((!DataLineMsgSet.isFileType(localDataLineMsgRecord)) || (localDataLineMsgRecord.isread) || (localDataLineMsgRecord.fileMsgStatus != 1L)) {
          break label258;
        }
        i3 = i2;
        i4 = i1;
        if (i1 == 0)
        {
          i3 = i2 + 1;
          i4 = 1;
        }
        ((List)localObject).add(localDataLineMsgRecord);
        i5 += 1;
        i1 = i4;
        i2 = i3;
      }
    }
    label258:
    for (;;)
    {
      break;
      if (i3 >= 3)
      {
        localObject = String.format(getString(2131361891), new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
        ((DataLineHandler)this.app.a(8)).a(115);
        DialogUtil.a(this, 230, getString(2131361833), (String)localObject, 2131362790, 2131361892, localak, localal).show();
      }
      return;
    }
  }
  
  private void m()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this, this.app, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(String.valueOf(AppConstants.T), -1, "", "我的电脑");
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a = this;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(c());
    if (55 == paramIntent.getIntExtra(AlbumConstants.i, -1)) {
      new ba(this, null).execute(new Intent[] { paramIntent });
    }
    if (paramIntent.getBooleanExtra("isMigSdkShare", false)) {
      getIntent().putExtra("isMigSdkShare", true);
    }
    f(paramIntent);
    e(paramIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    this.app.a().a().d();
    if (!paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
      a(this.jdField_a_of_type_ComTencentWidgetXListView);
    }
  }
  
  public boolean a()
  {
    boolean bool1 = getIntent().getBooleanExtra("isMigSdkShare", false);
    if ((this.jdField_a_of_type_Boolean) && (!bool1))
    {
      long l1 = getIntent().getLongExtra("res_share_id", 0L);
      if (l1 > 0L) {
        ForwardOperations.a(this, true, "shareToQQ", AppShareIDUtil.b(l1));
      }
      return super.a();
    }
    boolean bool2 = getIntent().getBooleanExtra("dataline_send_file_flag", false);
    getIntent().putExtra("dataline_send_file_flag", false);
    if ((this.jdField_c_of_type_Boolean) || (bool1) || (bool2))
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", 0);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.a();
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog != null) && (this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog.isShowing())) {
      return true;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    Object localObject1 = (ItemHolder)paramView.getTag();
    DataLineMsgSet localDataLineMsgSet = ((ItemHolder)localObject1).a();
    String str = "";
    DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
    Object localObject2;
    if (localDataLineMsgSet.isSingle())
    {
      switch (localDataLineMsgSet.getGroupType())
      {
      default: 
        localObject1 = "";
        localObject2 = null;
      }
      while (localObject2 == null)
      {
        return false;
        localObject2 = ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        localQQCustomMenu.a(2131298994, paramView.getContext().getString(2131363570));
        localQQCustomMenu.a(2131296652, paramView.getContext().getString(2131363568));
        localQQCustomMenu.a(2131296656, paramView.getContext().getString(2131362658));
        localObject1 = "消息";
        continue;
        localObject2 = ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        str = localDataLineMsgRecord.path;
        localObject1 = "图片";
        continue;
        if (localDataLineMsgRecord.bIsMoloImage) {}
        for (localObject1 = ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout;; localObject1 = ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout)
        {
          str = localDataLineMsgRecord.path;
          localObject2 = localObject1;
          localObject1 = "文件";
          break;
        }
      }
      Context localContext = ((RelativeLayout)localObject2).getContext();
      if ((FileUtils.b(str)) && (localDataLineMsgRecord.strMoloKey == null))
      {
        localQQCustomMenu.a(2131296652, localContext.getString(2131361852));
        if (localDataLineMsgSet.getGroupType() == -2000) {
          localQQCustomMenu.a(2131296656, paramView.getContext().getString(2131362658));
        }
        if (a(this.app, localDataLineMsgRecord)) {
          localQQCustomMenu.a(2131298995, localContext.getString(2131361851));
        }
      }
    }
    for (;;)
    {
      localObject2 = ((RelativeLayout)localObject2).getContext();
      localQQCustomMenu.a(2131298987, ((Context)localObject2).getString(2131361850));
      if ((localDataLineMsgSet.getGroupType() == -2000) || ((localDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgRecord.bIsMoloImage))) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = MenuPopupDialog.a(paramView, (String)localObject1, localQQCustomMenu, new ae(this, localDataLineMsgRecord, localDataLineMsgSet, (Context)localObject2, str, bool), new ai(this));
        return true;
        switch (localDataLineMsgSet.getGroupType())
        {
        default: 
          localObject1 = "";
          localObject2 = null;
        }
        while (localObject2 == null)
        {
          return false;
          localObject2 = ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout;
          localObject1 = "图片";
          continue;
          if (localDataLineMsgRecord.bIsMoloImage)
          {
            localObject2 = ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout;
            localObject1 = "文件";
          }
          else
          {
            localObject2 = ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout;
            localObject1 = "文件";
          }
        }
      }
    }
  }
  
  public void a_()
  {
    Object localObject1 = new File(AppConstants.as + "photo/");
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    Object localObject2 = AppConstants.as + "photo/" + System.currentTimeMillis() + ".jpg";
    localObject1 = Uri.fromFile(new File((String)localObject2));
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString("camera_photo_path", (String)localObject2).commit();
    localObject2 = new Intent("android.media.action.IMAGE_CAPTURE");
    ((Intent)localObject2).putExtra("output", (Parcelable)localObject1);
    ((Intent)localObject2).putExtra("android.intent.extra.videoQuality", 100);
    startActivityForResult((Intent)localObject2, 5);
  }
  
  public void b()
  {
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null)
    {
      l1 = getIntent().getIntExtra("req_share_id", 0);
      if (l1 != 0L) {
        break label78;
      }
      localObject = StructMsgFactory.a(getIntent().getExtras());
      if ((localObject == null) || (!(localObject instanceof AbsShareMsg))) {
        break label81;
      }
    }
    label78:
    label81:
    for (Object localObject = (AbsShareMsg)localObject;; localObject = null)
    {
      if (localObject != null) {
        l1 = ((AbsShareMsg)localObject).mSourceAppid;
      }
      for (;;)
      {
        if (l1 != 0L) {
          ForwardOperations.a(this, false, "sendToMyComputer", l1);
        }
        return;
      }
    }
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this, SendPhotoActivity.class);
    localIntent.setClass(this, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    localIntent.putExtra(AlbumConstants.i, 55);
    localIntent.putExtra("uin", AppConstants.T);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.getExtras().remove("forward_type");
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    startActivity(localIntent);
    AlbumUtil.a(this, false, true);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (!c()) {
      b(null);
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
                    b(paramIntent, DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE);
                    paramIntent.clear();
                    a(false);
                    return;
                  } while (paramInt2 != -1);
                  a(paramIntent, false);
                  return;
                } while ((paramInt2 != -1) || (paramIntent == null));
                paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
              } while ((paramIntent == null) || (paramIntent.size() <= 0));
              b(paramIntent, DataLineHandler.EFILETYPE.FILE_TYPE_VIDEO);
              paramIntent.clear();
              a(false);
              return;
            } while (paramInt2 != -1);
            a(false);
            return;
          } while ((paramInt2 != -1) || (paramIntent == null));
          paramIntent = paramIntent.getExtras().getString("textMsg");
        } while (paramIntent.length() <= 0);
        a(paramIntent);
        return;
      } while (paramInt2 != -1);
      a(false);
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    return;
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427340);
    setContentView(2130903149);
    setTitle(2131361822);
    getWindow().setBackgroundDrawable(null);
    f();
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction = new LiteActivity.LiteJumpAction(this, this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((FrameLayout)findViewById(2131296941));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296393, "n/a");
    this.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.app.a(ChatActivity.class, this.jdField_a_of_type_AndroidOsHandler);
    Object localObject1 = this.app.a();
    if (localObject1 != null) {
      ((QQMessageFacade)localObject1).addObserver(this);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131296942));
    this.jdField_a_of_type_AndroidViewView = new View(this);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    ((DataLineHandler)this.app.a(8)).jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)TypedValue.applyDimension(1, 12.0F, getResources().getDisplayMetrics()), 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    localObject1 = this.app.a();
    if (localObject1 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = new DataLineMsgSetList();
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onCreate datalineMsgEntities = new DataLineMsgSetList()");
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = new DatalineSessionAdapter(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList, this, this.app);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter);
      localObject1 = LayoutInflater.from(getActivity()).inflate(2130903115, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getActivity().getResources().getDrawable(2130838640));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader((View)localObject1);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new h(this));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131296553));
      localObject1 = getResources().getDrawable(2130839328);
      if (!(localObject1 instanceof BitmapDrawable)) {
        break label828;
      }
      localObject1 = ((BitmapDrawable)localObject1).getBitmap();
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = new BitmapDrawable((Bitmap)localObject1);
        if (localObject1 != null)
        {
          ((BitmapDrawable)localObject1).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
          ((BitmapDrawable)localObject1).setDither(true);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable((Drawable)localObject1);
        }
        this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131296946));
        this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
        this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296667));
        this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
        this.jdField_a_of_type_Ay = new ay(this, null);
        this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Ay);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296672));
        localObject1 = Build.MODEL;
        if (("SH-02E".equals(localObject1)) || ("SBM200SH".equals(localObject1))) {}
        try
        {
          localObject1 = TextView.class.getDeclaredField("mTextSelectHandleRes");
          ((Field)localObject1).setAccessible(true);
          int i1 = ((Integer)((Field)localObject1).get(new TextView(this))).intValue();
          ((Field)localObject1).set(this.jdField_a_of_type_AndroidWidgetEditText, Integer.valueOf(i1));
          this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new ac(this));
          e();
          this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ar(this));
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131296945));
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131296944));
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          m();
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.getCount());
          k();
          l();
          this.app.a().a().d();
          localObject1 = (RegisterProxySvcPackHandler)this.app.a(9);
          if (paramBundle == null) {
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new as(this), 200L);
          }
          c(getIntent());
          if ((((RegisterProxySvcPackHandler)localObject1).a() == 0) && (!((RegisterProxySvcPackHandler)localObject1).a()))
          {
            ((RegisterProxySvcPackHandler)localObject1).a();
            ((RegisterProxySvcPackHandler)localObject1).a(true);
          }
          d(getIntent());
          return true;
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = ((DataLineMsgProxy)localObject1).a(true);
          break;
          label828:
          if ((localObject1 instanceof SkinnableBitmapDrawable)) {
            localObject1 = ((SkinnableBitmapDrawable)localObject1).getBitmap();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    if (this.app.a() != null)
    {
      this.app.a().a().d();
      this.app.a().a().c();
      this.app.a().deleteObserver(this);
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    }
    if (this.app.a() != null) {
      this.app.a().e();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    g(paramIntent);
    d();
    a(paramIntent);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    c(paramIntent);
    d(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ((DataLineHandler)this.app.a(8)).a();
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      d(true);
    }
    if ((this.jdField_a_of_type_Boolean) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "finishing LiteActivity (ask ippan)");
      }
      finish();
      com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_c_of_type_Boolean = false;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(this, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  public void finish()
  {
    super.finish();
    d();
    ((DataLineHandler)this.app.a(8)).jdField_b_of_type_Boolean = false;
    g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      boolean bool1 = false;
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long > 2000L);
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0) {
        d(false);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a();
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 32), 5000L);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
        d(false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      d(false);
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
    label305:
    Object localObject;
    switch (i1)
    {
    default: 
    case 2131296944: 
    case 2131296945: 
      do
      {
        return;
        boolean bool;
        if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 8)
        {
          bool = true;
          if (!bool) {
            break label305;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout = ((FastImagePreviewLayout)LayoutInflater.from(getActivity()).inflate(2130903062, null));
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setBackgroundDrawable(getResources().getDrawable(2130837543));
            i1 = (int)(5.0F * this.jdField_c_of_type_Float);
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setPadding(i1, i1, i1, i1 * 3);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(12);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = ((int)(5.0F * this.jdField_c_of_type_Float + 0.5F));
            this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin = ((int)(246.0F * this.jdField_c_of_type_Float + 0.5F));
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setId(2131296410);
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setHandler(this.jdField_a_of_type_AndroidOsHandler);
          }
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.b();
        }
        for (;;)
        {
          b(bool);
          return;
          bool = false;
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
            d(false);
          }
        }
        paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      } while ((paramView == null) || (paramView.length() <= 0));
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_cktxt");
      localObject = AppConstants.T;
      a(new QQText(paramView, 13, 32, 6000).toString());
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      return;
    case 2131296312: 
      localObject = (Intent)paramView.getTag();
      if (((Intent)localObject).getExtras().getInt("uintype") == 0)
      {
        String str = ((Intent)localObject).getExtras().getString("uin");
        if (!ChatActivityUtils.a(this.app, str))
        {
          ((Intent)localObject).removeExtra("uintype");
          ((Intent)localObject).putExtra("uintype", 1003);
        }
      }
      ((Intent)localObject).putExtra("message_box_click", true);
      MediaPlayerManager.a(this.app).a(false);
      startActivity((Intent)localObject);
      paramView.setVisibility(8);
      finish();
      return;
    }
    a(null, true);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      a(paramObservable, paramObject);
      return;
    }
    new Handler(localLooper).post(new ap(this, paramObservable, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity
 * JD-Core Version:    0.7.0.1
 */