package com.dataline.activities;

import aa;
import ab;
import ac;
import ad;
import ae;
import af;
import ag;
import ah;
import ai;
import aj;
import ak;
import android.app.Activity;
import android.app.Dialog;
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
import android.os.Looper;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import av;
import ax;
import ay;
import bc;
import bd;
import be;
import bf;
import bg;
import bh;
import bi;
import bj;
import bk;
import bl;
import bm;
import bn;
import bw;
import bx;
import bz;
import com.dataline.util.DatalineSessionAdapter;
import com.dataline.util.DatalineSessionAdapter.ItemHolder;
import com.dataline.util.DatalineSessionAdapter.ItemHolder.FileItemHolder;
import com.dataline.util.DatalineSessionAdapter.ItemHolder.ImageItemHolder;
import com.dataline.util.DatalineSessionAdapter.ItemHolder.MutiImageItemHolder;
import com.dataline.util.DatalineSessionAdapter.ItemHolder.TextItemHolder;
import com.dataline.util.file.FileUtil;
import com.dataline.util.file.SendInfo;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
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
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileProvider7Helper;
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
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XListView;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class LiteActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, Observer
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
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 101;
  private static int o = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bm(this);
  private View jdField_a_of_type_AndroidViewView;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new bn(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bx jdField_a_of_type_Bx;
  private LiteActivity.LiteJumpAction jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction;
  private DatalineSessionAdapter jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = null;
  private ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new ak(this);
  private DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = null;
  public ChatBackgroundDrawable a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new bf(this);
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public View.OnClickListener b;
  private View jdField_b_of_type_AndroidViewView;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private boolean jdField_b_of_type_Boolean = false;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private String e = "n/a";
  int m = 55;
  private int n;
  private int p;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.LiteActivity";
  }
  
  public LiteActivity()
  {
    this.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new af(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ag(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new bc(this);
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
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt, -1, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setTranscriptMode(1);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(paramInt);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(paramInt);
      }
    }
  }
  
  private void a(DatalineSessionAdapter.ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.e(a()))
    {
      FMToastUtil.a(2131562488);
      return;
    }
    Object localObject2 = "";
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    Object localObject1;
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 5242880L)) {
      localObject1 = getString(2131558756);
    }
    label80:
    int i1;
    for (;;)
    {
      if (((String)localObject1).equals(""))
      {
        localObject1 = getString(2131558503);
        localObject2 = (ActionSheet)ActionSheetHelper.a(this, null);
        ((ActionSheet)localObject2).a((CharSequence)localObject1);
        ((ActionSheet)localObject2).a(getResources().getString(2131558731), 1);
        ((ActionSheet)localObject2).d(2131561746);
        ((ActionSheet)localObject2).a(new ah(this, localDataLineMsgSet, paramItemHolder, (ActionSheet)localObject2));
        ((ActionSheet)localObject2).show();
        return;
        if (localDataLineMsgSet.getGroupType() == -1000)
        {
          localObject1 = getString(2131558504);
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
              label202:
              if (((Iterator)localObject1).hasNext())
              {
                if (!DataLineMsgSet.isCanReciveOrResend((DataLineMsgRecord)((Iterator)localObject1).next())) {
                  break label261;
                }
                i1 += 1;
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
      localObject1 = String.format(getString(2131558575), new Object[] { Integer.valueOf(i1) });
      break;
      break label80;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    paramContext = FileUtil.c(paramContext, paramString);
    ((DataLineHandler)paramQQAppInterface.a(8)).a(paramString, paramContext, DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE, 0L, 0, 0, 0, false);
  }
  
  private void a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this);
    String str2 = getString(2131560588);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramAbsShareMsg = new bl(this, paramAbsShareMsg, this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  private void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    if ((paramString != null) && (paramString.length() > 3478))
    {
      QQToast.a(this, getString(2131559618), 1).b(d());
      return;
    }
    ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(paramString);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    q();
    m();
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
      localDataLineMsgRecord = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    } while (localDataLineMsgRecord == null);
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    localDataLineMsgRecord.bIsResendOrRecvFile = true;
    switch (paramInt)
    {
    default: 
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
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
    ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(paramString1, paramString2, paramEFILETYPE, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    a(paramBoolean);
  }
  
  private void a(ArrayList paramArrayList, DataLineHandler.EFILETYPE paramEFILETYPE)
  {
    if (paramArrayList == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sendMultipleFile paths is null !!!!!!");
      return;
    }
    bw localbw = new bw(this, paramArrayList);
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
      h();
      return;
    }
    if ((NetworkUtil.f(this)) && (!NetworkUtil.g(this)) && (l1 > 5242880L))
    {
      paramArrayList = new ab(this, localbw, paramEFILETYPE);
      paramEFILETYPE = new ac(this);
      DialogUtil.a(a(), 230, getString(2131558507), getString(2131558508), 2131561746, 2131558509, paramArrayList, paramEFILETYPE).show();
      return;
    }
    localbw.execute(new DataLineHandler.EFILETYPE[] { paramEFILETYPE });
  }
  
  private void a(Observable paramObservable, Object paramObject)
  {
    i();
    if ((paramObject instanceof DataLineMsgRecord))
    {
      paramObservable = (DataLineMsgRecord)paramObject;
      paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramObservable.sessionid);
      if ((DataLineMsgSet.isSingle(paramObservable)) || (paramObject == null) || (paramObject.getComeCount() <= 1)) {
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      }
    }
    label57:
    do
    {
      do
      {
        do
        {
          break label57;
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
        } while ((paramObservable.frienduin == null) || (!paramObservable.frienduin.endsWith(String.valueOf(AppConstants.P))));
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
        return;
      } while (!(paramObject instanceof RecentUser));
      paramObservable = (RecentUser)paramObject;
    } while ((paramObservable.uin == null) || (!paramObservable.uin.endsWith(String.valueOf(AppConstants.P))));
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
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
  
  private boolean a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
      if ("null".equals(this.e)) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837757);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837757);
        this.e = "null";
        return true;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          paramString.printStackTrace();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130840059);
        continue;
      }
      if ("none".equals(paramString))
      {
        if (!"none".equals(this.e))
        {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130839804);
          this.e = "none";
        }
      }
      else if (!paramString.equals(this.e))
      {
        Bitmap localBitmap = BitmapManager.a(paramString);
        if (localBitmap == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqDrawableChatBackgroundDrawable = new ChatBackgroundDrawable(getResources(), localBitmap);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqDrawableChatBackgroundDrawable);
        this.e = paramString;
        k();
      }
    }
    return false;
  }
  
  private void b(DatalineSessionAdapter.ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.e(a()))
    {
      FMToastUtil.a(2131562488);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 5242880L)) {}
    for (paramItemHolder = getString(2131558757);; paramItemHolder = "")
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
        for (paramItemHolder = String.format(getString(2131558577), new Object[] { Integer.valueOf(i1) });; paramItemHolder = String.format(getString(2131558576), new Object[] { Integer.valueOf(i1) }))
        {
          localObject = new ai(this);
          DialogUtil.a(this, 230, getString(2131558507), paramItemHolder, 2131562539, 2131562539, null, (DialogInterface.OnClickListener)localObject).show();
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
            localObject = String.format(getString(2131558574), new Object[] { Integer.valueOf(localArrayList.size()) });
          }
        }
      }
      paramItemHolder = (DatalineSessionAdapter.ItemHolder)localObject;
      if (((String)localObject).equals("")) {
        paramItemHolder = getString(2131558506);
      }
      localObject = (ActionSheet)ActionSheetHelper.a(this, null);
      ((ActionSheet)localObject).a(paramItemHolder);
      ((ActionSheet)localObject).a(getResources().getString(2131558730), 1);
      ((ActionSheet)localObject).d(2131561746);
      ((ActionSheet)localObject).a(new aj(this, localDataLineMsgSet, localArrayList, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
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
      localDataLineHandler = (DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
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
      d();
      new Handler().postDelayed(new bh(this, paramBoolean), l1);
      return;
    }
  }
  
  private String c()
  {
    return getSharedPreferences("dataline_text_cache", 0).getString("key_text", "");
  }
  
  private boolean c()
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
    return (localRegisterProxySvcPackHandler.a() == 0) || (localRegisterProxySvcPackHandler.b() != 0);
  }
  
  private void d()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    if (this.jdField_p_of_type_Int != 0)
    {
      localLayoutParams.height = this.jdField_p_of_type_Int;
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  private void d(Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))) {
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction.a(paramIntent);
    }
  }
  
  private void e()
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
    localSharedPreferences.edit().putString("key_text", ((CharSequence)localObject).toString()).commit();
  }
  
  private void e(Intent paramIntent)
  {
    paramIntent = null;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("camera_photo_path", "");
    if (!((String)localObject).equalsIgnoreCase("")) {
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
        QQToast.a(this, getString(2131562639), 0).b(d());
        return;
      }
      if (!new File(paramIntent).exists()) {
        QQToast.a(this, getString(2131561473), 0).b(d());
      }
    }
    else
    {
      QQToast.a(this, getString(2131561473), 0).b(d());
      return;
    }
    localObject = new Intent();
    ArrayList localArrayList = new ArrayList();
    ((Intent)localObject).setClass(this, CameraPreviewActivity.class);
    localArrayList.add(paramIntent);
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
    ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    ((Intent)localObject).putExtra(AlbumConstants.i, this.m);
    ((Intent)localObject).putExtra("uin", AppConstants.P);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    startActivityForResult((Intent)localObject, 0);
  }
  
  private void f()
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
  
  private void f(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("dataline_forward_type", -1);
    if (i1 == -1) {
      return;
    }
    Object localObject1 = DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE;
    ArrayList localArrayList;
    if (paramIntent.getBooleanExtra("sendMultiple", false))
    {
      localArrayList = paramIntent.getStringArrayListExtra("dataline_forward_pathlist");
      if (i1 != 100) {
        break label556;
      }
      localObject1 = DataLineHandler.EFILETYPE.FILE_TYPE_FILE;
    }
    label556:
    for (;;)
    {
      if (localArrayList == null)
      {
        p();
        return;
      }
      Object localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (TextUtils.isEmpty((String)((Iterator)localObject2).next())) {
          p();
        }
      }
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
      paramIntent = StructMsgFactory.a(paramIntent);
      if ((paramIntent != null) && ((paramIntent instanceof AbsShareMsg))) {}
      for (paramIntent = (AbsShareMsg)paramIntent;; paramIntent = null)
      {
        a(paramIntent, (String)localObject1);
        return;
        localArrayList = new ArrayList();
        switch (i1)
        {
        default: 
          StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_forwardin_other");
          break;
        case 101: 
          StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_forwardin_image");
          localObject1 = DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE;
          localObject2 = paramIntent.getStringExtra("dataline_forward_path");
          localArrayList.clear();
          localArrayList.add(localObject2);
          a(localArrayList, (DataLineHandler.EFILETYPE)localObject1);
          break;
        case 100: 
          StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_forwardin_file");
          localObject2 = paramIntent.getStringExtra("dataline_forward_path");
          if ((localObject2 == null) || (((String)localObject2).equals("")))
          {
            p();
            return;
          }
          switch (FileManagerUtil.a((String)localObject2))
          {
          default: 
            localObject1 = DataLineHandler.EFILETYPE.FILE_TYPE_FILE;
          }
          for (;;)
          {
            localArrayList.clear();
            localArrayList.add(localObject2);
            a(localArrayList, (DataLineHandler.EFILETYPE)localObject1);
            break;
            localObject1 = DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE;
            continue;
            localObject1 = DataLineHandler.EFILETYPE.FILE_TYPE_AUDIO;
            continue;
            localObject1 = DataLineHandler.EFILETYPE.FILE_TYPE_VIDEO;
          }
        case 102: 
          localObject1 = paramIntent.getStringExtra("dataline_forward_text");
          if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
            break;
          }
          if (Patterns.b.matcher((CharSequence)localObject1).find()) {
            StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_forwardin_link");
          }
          for (;;)
          {
            a((String)localObject1);
            break;
            StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_forwardin_text");
          }
        }
      }
    }
  }
  
  private boolean f()
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      o();
      return false;
    }
    if (new StatFs(AppConstants.al).getAvailableBlocks() <= 1)
    {
      n();
      return false;
    }
    return true;
  }
  
  private void g()
  {
    int i1 = 0;
    SharedPreferences localSharedPreferences = getSharedPreferences("chat_background_path_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = AppConstants.P;
    arrayOfString[1] = "chat_uniform_bg";
    if ((localSharedPreferences.getString(arrayOfString[0], null) == null) && (localSharedPreferences.getString(arrayOfString[1], null) == null))
    {
      a("null");
      return;
    }
    int i2 = arrayOfString.length;
    for (;;)
    {
      if (i1 >= i2) {
        break label199;
      }
      String str = localSharedPreferences.getString(arrayOfString[i1], null);
      if (str != null)
      {
        if (("".equals(str)) || ("null".equals(str)) || ("none".equals(str)))
        {
          a(str);
          return;
        }
        if (!new File(str).exists())
        {
          a("null");
          return;
        }
        if (a(str)) {
          break;
        }
      }
      i1 += 1;
    }
    label199:
    a("null");
  }
  
  private void g(Intent paramIntent)
  {
    c(paramIntent);
    String str = this.k.getText().toString();
    if (str.contains(getString(2131561807)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView = this.k;
      StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_op4recent");
      i();
    }
    for (;;)
    {
      if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
      {
        this.jdField_c_of_type_Boolean = true;
        this.k.setText(getString(2131561807));
        this.jdField_a_of_type_AndroidWidgetTextView = this.k;
        i();
      }
      if ((paramIntent != null) && (paramIntent.getIntExtra("dataline_forward_type", -1) != -1))
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          this.k.setText(getString(2131561807));
          this.jdField_a_of_type_AndroidWidgetTextView = this.k;
          i();
        }
      }
      str = this.k.getText().toString();
      paramIntent = str;
      if (!getString(2131560958).equals(str)) {
        paramIntent = getString(2131559619, new Object[] { str });
      }
      this.k.setContentDescription(paramIntent);
      return;
      if (str.contains(getString(2131561870))) {
        StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_op4buddylist");
      } else if (str.contains(getString(2131558673))) {
        StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_op4dongtai");
      }
    }
  }
  
  private void h()
  {
    ad localad = new ad(this);
    DialogUtil.a(this, 233, getString(2131562517), getString(2131558552), 2131558497, 2131558497, localad, null).show();
  }
  
  private void i()
  {
    int i1;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localQQMessageFacade != null)
      {
        i1 = localQQMessageFacade.f();
        if (i1 <= 0) {
          break label112;
        }
        if (i1 <= 99) {
          break label68;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561807) + "(99+)");
      }
    }
    return;
    label68:
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561807) + "(" + i1 + ")");
    return;
    label112:
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561807));
  }
  
  private void j()
  {
    setTitle(2131558496);
    ImageView localImageView = this.jdField_p_of_type_AndroidWidgetImageView;
    localImageView.setContentDescription(getResources().getText(2131558510));
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130838032);
    localImageView.setOnClickListener(new ae(this));
    this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription("进入我的电脑高级设置界面");
    g(getIntent());
  }
  
  private void k()
  {
    if (ThemeUtil.isInNightMode(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void l()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localLong.longValue());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setMsgFailedWhenQuesting: session = " + localLong.longValue());
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter != null)) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComTencentWidgetXListView.a());
    }
  }
  
  private void n()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130837933);
    localQQToast.c(2000);
    localQQToast.b(2131558520);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  private void o()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130837933);
    localQQToast.c(2000);
    localQQToast.b(2131558521);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  private void p()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130837933);
    localQQToast.c(2000);
    localQQToast.b(2131558537);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new ax(this), 200L);
    }
  }
  
  private void r()
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
  
  private void s()
  {
    Object localObject = new ArrayList();
    bd localbd = new bd(this, (List)localObject);
    be localbe = new be(this);
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
        localObject = String.format(getString(2131558565), new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
        ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(115);
        DialogUtil.a(this, 230, getString(2131558507), (String)localObject, 2131561746, 2131558566, localbd, localbe).show();
      }
      return;
    }
  }
  
  private void t()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130838056);
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetFrameLayout.getVisibility() == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130837625);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130837644);
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText(c());
    int i1 = paramIntent.getIntExtra(AlbumConstants.i, -1);
    if (this.m == i1) {
      new bz(this, null).execute(new Intent[] { paramIntent });
    }
    f(paramIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().i();
    if (!paramBoolean)
    {
      q();
      m();
    }
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = false;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    Object localObject1 = (DatalineSessionAdapter.ItemHolder)paramView.getTag();
    DataLineMsgSet localDataLineMsgSet = ((DatalineSessionAdapter.ItemHolder)localObject1).a();
    Object localObject2 = "";
    DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
    String str;
    if (localDataLineMsgSet.getGroupType() == -1000)
    {
      str = localDataLineMsgRecord.msg;
      if (!localDataLineMsgSet.isSingle()) {
        break label612;
      }
      switch (localDataLineMsgSet.getGroupType())
      {
      default: 
        localObject1 = null;
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        return false;
        if (localDataLineMsgSet.getGroupType() == -2000)
        {
          str = paramView.getContext().getResources().getString(2131559158);
          break;
        }
        if (localDataLineMsgSet.getGroupType() == -2333)
        {
          str = paramView.getContext().getResources().getString(2131559164);
          break;
        }
        if (localDataLineMsgSet.getGroupType() == -2005)
        {
          str = paramView.getContext().getResources().getString(2131559154);
          break;
        }
        str = paramView.getContext().getResources().getString(2131559157);
        break;
        localObject1 = ((DatalineSessionAdapter.ItemHolder)localObject1).a().a;
        localQQCustomMenu.a(2131234884, paramView.getContext().getString(2131561879));
        localQQCustomMenu.a(2131231190, paramView.getContext().getString(2131562129));
        localQQCustomMenu.a(2131231192, paramView.getContext().getString(2131560772));
        continue;
        localObject1 = ((DatalineSessionAdapter.ItemHolder)localObject1).a().a;
        localObject2 = localDataLineMsgRecord.path;
        continue;
        if (localDataLineMsgRecord.bIsMoloImage) {}
        for (localObject1 = ((DatalineSessionAdapter.ItemHolder)localObject1).a().a;; localObject1 = ((DatalineSessionAdapter.ItemHolder)localObject1).a().a)
        {
          localObject2 = localDataLineMsgRecord.path;
          break;
        }
      }
    }
    Context localContext = ((RelativeLayout)localObject1).getContext();
    Object localObject3 = localObject1;
    Object localObject4 = localObject2;
    if (FileUtils.b((String)localObject2))
    {
      localObject3 = localObject1;
      localObject4 = localObject2;
      if (localDataLineMsgRecord.strMoloKey == null)
      {
        localQQCustomMenu.a(2131231190, localContext.getString(2131558526));
        if (localDataLineMsgSet.getGroupType() == -2000) {
          localQQCustomMenu.a(2131231192, paramView.getContext().getString(2131560772));
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localDataLineMsgRecord))
        {
          localQQCustomMenu.a(2131234885, localContext.getString(2131558525));
          localObject4 = localObject2;
          localObject3 = localObject1;
        }
      }
    }
    localObject1 = localObject3.getContext();
    localQQCustomMenu.a(2131234878, ((Context)localObject1).getString(2131558524));
    boolean bool1;
    if (localDataLineMsgSet.getGroupType() != -2000)
    {
      bool1 = bool2;
      if (localDataLineMsgSet.getGroupType() == -2335)
      {
        bool1 = bool2;
        if (!localDataLineMsgRecord.bIsMoloImage) {}
      }
    }
    else
    {
      bool1 = true;
    }
    localObject2 = new ay(this, localDataLineMsgRecord, localDataLineMsgSet, (Context)localObject1, localObject4, bool1);
    localObject1 = str;
    if (EmoticonUtils.a(str)) {
      localObject1 = paramView.getContext().getResources().getString(2131559157);
    }
    this.jdField_a_of_type_AndroidAppDialog = BubbleContextMenu.a(paramView, localQQCustomMenu, (View.OnClickListener)localObject2, (CharSequence)localObject1);
    return true;
    label612:
    switch (localDataLineMsgSet.getGroupType())
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      localObject3 = localObject1;
      localObject4 = localObject2;
      if (localObject1 != null) {
        break;
      }
      return false;
      localObject1 = ((DatalineSessionAdapter.ItemHolder)localObject1).a().a;
      continue;
      if (localDataLineMsgRecord.bIsMoloImage) {
        localObject1 = ((DatalineSessionAdapter.ItemHolder)localObject1).a().a;
      } else {
        localObject1 = ((DatalineSessionAdapter.ItemHolder)localObject1).a().a;
      }
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent(this, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    localIntent.putExtra(AlbumConstants.i, this.m);
    localIntent.putExtra("uin", AppConstants.P);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.getExtras().remove("forward_type");
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    startActivityForResult(localIntent, 0);
    AlbumUtil.a(this, false, true);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      long l1 = getIntent().getLongExtra("res_share_id", 0L);
      if (l1 > 0L) {
        ForwardOperations.a(this, true, "shareToQQ", AppShareIDUtil.b(l1));
      }
      return super.b();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", 0);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.b();
  }
  
  public void d_()
  {
    Object localObject = new File(AppConstants.an + "photo/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = AppConstants.an + "photo/" + System.currentTimeMillis() + ".jpg";
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString("camera_photo_path", (String)localObject).commit();
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    FileProvider7Helper.setSystemCapture(this, new File((String)localObject), localIntent);
    startActivityForResult(localIntent, 5);
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
                      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("sendInfo");
                      if ((localArrayList != null) && (localArrayList.size() > 0))
                      {
                        b(localArrayList, DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE);
                        localArrayList.clear();
                        a(false);
                      }
                      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                    } while ((paramIntent == null) || (paramIntent.size() <= 0));
                    a(paramIntent, DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE);
                    return;
                  } while (paramInt2 != -1);
                  e(paramIntent);
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
    getWindow().setBackgroundDrawableResource(2131361810);
    setContentView(2130903175);
    setTitle(2131558496);
    getWindow().setBackgroundDrawable(null);
    j();
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction = new LiteActivity.LiteJumpAction(this, this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131231494));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 != null) {
      ((QQMessageFacade)localObject1).addObserver(this);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131231495));
    this.jdField_b_of_type_AndroidViewView = new View(this);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903186, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView.setPadding(0, (int)TypedValue.applyDimension(1, 12.0F, getResources().getDisplayMetrics()), 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = new DataLineMsgSetList();
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onCreate datalineMsgEntities = new DataLineMsgSetList()");
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = new DatalineSessionAdapter(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter);
      localObject1 = LayoutInflater.from(a()).inflate(2130903136, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(a().getResources().getDrawable(2130838675));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader((View)localObject1);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new aa(this));
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131231107));
      this.jdField_c_of_type_AndroidViewView = findViewById(2131231496);
      localObject1 = getResources().getDrawable(2130840138);
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
          this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable((Drawable)localObject1);
        }
        this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131231108));
        this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
        this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131231206));
        this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
        this.jdField_a_of_type_Bx = new bx(this, null);
        this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Bx);
        this.jdField_a_of_type_AndroidViewView = findViewById(2131231499);
        localObject1 = Build.MODEL;
        if (("SH-02E".equals(localObject1)) || ("SBM200SH".equals(localObject1))) {}
        try
        {
          localObject1 = TextView.class.getDeclaredField("mTextSelectHandleRes");
          ((Field)localObject1).setAccessible(true);
          int i1 = ((Integer)((Field)localObject1).get(new TextView(this))).intValue();
          ((Field)localObject1).set(this.jdField_a_of_type_AndroidWidgetEditText, Integer.valueOf(i1));
          this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new av(this));
          f();
          this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bi(this));
          this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131231498));
          this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          this.jdField_b_of_type_AndroidWidgetImageButton.setOnTouchListener(new bj(this));
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131231497));
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          t();
          a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.getCount());
          s();
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().i();
          localObject1 = (RegisterProxySvcPackHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
          if (paramBundle == null) {
            new Handler().postDelayed(new bk(this), 200L);
          }
          d(getIntent());
          if ((((RegisterProxySvcPackHandler)localObject1).a() == 0) && (!((RegisterProxySvcPackHandler)localObject1).a()))
          {
            ((RegisterProxySvcPackHandler)localObject1).a();
            ((RegisterProxySvcPackHandler)localObject1).a(true);
          }
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
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().i();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().h();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    g(paramIntent);
    e();
    a(paramIntent);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    d(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a();
    if (this.jdField_a_of_type_Boolean)
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
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    g();
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  public void finish()
  {
    super.finish();
    e();
    ((DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).jdField_b_of_type_Boolean = false;
    l();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
    if (i1 == 2131231497) {
      if (this.jdField_b_of_type_AndroidWidgetFrameLayout.getVisibility() == 8)
      {
        bool = true;
        b(bool);
      }
    }
    while (i1 != 2131231498) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((paramView != null) && (paramView.length() > 0))
    {
      StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_cktxt");
      String str = AppConstants.P;
      a(new QQText(paramView, 13, 32, 6000).toString());
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetFrameLayout.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      return;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      a(paramObservable, paramObject);
      return;
    }
    new Handler(localLooper).post(new bg(this, paramObservable, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.activities.LiteActivity
 * JD-Core Version:    0.7.0.1
 */