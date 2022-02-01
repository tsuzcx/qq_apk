package com.tencent.mobileqq.filemanager.link;

import agkf;
import agyi;
import agyi.a;
import agyj;
import agyk;
import agym;
import agyn;
import ahav;
import ahbj;
import ahhq;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import aqju;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class LinkByWeiyunFragment
  extends IphoneTitleBarFragment
  implements agyi, DialogInterface.OnClickListener, View.OnClickListener, ShareActionSheet.OnItemClickListener, WXShareHelper.a
{
  private static final int COLOR_TRANSPARENT = Color.parseColor("#00000000");
  private View Df;
  private String Qt;
  private agyk jdField_a_of_type_Agyk;
  private agym jdField_a_of_type_Agym;
  private agyn jdField_a_of_type_Agyn;
  private aqju an;
  private boolean cfT;
  private AsyncImageView d;
  private ShareActionSheet e;
  private FileInfo jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
  private FileManagerEntity jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || ((paramFileManagerEntity == null) && (TextUtils.isEmpty(paramString)))) {
      return;
    }
    Intent localIntent = new Intent();
    if (paramFileManagerEntity != null) {
      localIntent.putExtra("fileinfo", ahhq.a(paramFileManagerEntity));
    }
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("key_local_file_path", paramString);
    }
    localIntent.putExtra("key_by_qr_code", paramBoolean);
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicFragmentActivity.class, LinkByWeiyunFragment.class);
    if (paramBoolean) {}
    for (paramContext = "0X800A9D5";; paramContext = "0X800A9D4")
    {
      agyj.report(paramContext, agyj.a(paramFileManagerEntity, paramString), null);
      return;
    }
  }
  
  private void dkH()
  {
    this.jdField_a_of_type_Agyn = new agyn(this, this.mContentView.findViewById(2131378122), this.cfT);
    this.jdField_a_of_type_Agyk = new agyk(this, this.mContentView.findViewById(2131373622), this.cfT);
    this.jdField_a_of_type_Agym = new agym(this, (ViewGroup)this.mContentView.findViewById(2131377546));
  }
  
  private void dkI()
  {
    aqju localaqju;
    if (this.an == null)
    {
      this.an = new aqju(getActivity(), 2131756467);
      this.an.setContentView(2131559151);
      localaqju = this.an;
      if (!this.cfT) {
        break label118;
      }
    }
    label118:
    for (int i = 2131700319;; i = 2131700320)
    {
      localaqju.setTitle(i);
      this.an.setMessage(null);
      this.an.setNegativeButton(2131721058, this);
      this.an.setPositiveButton(2131694366, this);
      this.an.setCancelable(true);
      this.an.setCanceledOnTouchOutside(false);
      if (!this.an.isShowing()) {
        this.an.show();
      }
      return;
    }
  }
  
  private void initView()
  {
    int i;
    label31:
    Object localObject;
    TextView localTextView;
    AsyncImageView localAsyncImageView;
    String str;
    if (this.cfT)
    {
      i = 2131700328;
      setTitle(getString(i));
      if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
        break label191;
      }
      i = 2131165400;
      this.mContentView.findViewById(2131373617).setBackgroundResource(i);
      this.mContentView.findViewById(2131370509).setBackgroundResource(i);
      localObject = (TextView)this.mContentView.findViewById(2131378130);
      localTextView = (TextView)this.mContentView.findViewById(2131378128);
      localAsyncImageView = (AsyncImageView)this.mContentView.findViewById(2131378129);
      str = getFileName();
      if (((TextView)localObject).getMeasuredWidth() > 0) {
        break label198;
      }
      ((TextView)localObject).post(new LinkByWeiyunFragment.1(this, (TextView)localObject, str));
    }
    for (;;)
    {
      localTextView.setText(ahbj.g(getFileSize()));
      localAsyncImageView.setImageResource(ahav.r(str));
      i = getFileType();
      if ((i == 5) || (i == 0))
      {
        localObject = getFilePath();
        if (ahbj.fileExistsAndNotEmpty((String)localObject))
        {
          if (i != 5) {
            break label220;
          }
          localAsyncImageView.setApkIconAsyncImage((String)localObject);
        }
      }
      return;
      i = 2131700340;
      break;
      label191:
      i = 2131167673;
      break label31;
      label198:
      ((TextView)localObject).setText(ahav.a(str, true, ((TextView)localObject).getMeasuredWidth(), ((TextView)localObject).getPaint(), 1));
    }
    label220:
    localAsyncImageView.setAsyncImage((String)localObject);
  }
  
  private boolean vz()
  {
    Bundle localBundle = getArguments();
    Object localObject = (ForwardFileInfo)localBundle.getParcelable("fileinfo");
    if (localObject != null)
    {
      AppInterface localAppInterface = getActivity().getAppInterface();
      if ((localAppInterface instanceof QQAppInterface)) {
        this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = ((QQAppInterface)localAppInterface).a().b(((ForwardFileInfo)localObject).fR());
      }
    }
    localObject = localBundle.getString("key_local_file_path");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo = new FileInfo((String)localObject);
      this.cfT = localBundle.getBoolean("key_by_qr_code", false);
      if ((this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo != null) && (this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo.getSize() > 0L))
      {
        bool = true;
        return agyj.c(this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, bool);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("LinkByWeiyunFragment<FileAssistant>", 2, "initData : local file not fount for " + (String)localObject);
        continue;
        boolean bool = false;
      }
    }
  }
  
  public void N(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Agyk == null) || (this.jdField_a_of_type_Agym == null)) {
      return;
    }
    Object localObject = e();
    int i;
    label84:
    label126:
    ShareActionSheet localShareActionSheet;
    if (this.e == null)
    {
      ((BaseActivity)localObject).getIntent().putExtra("big_brother_source_key", "biz_src_xl_weiyun");
      paramBitmap = new ShareActionSheetV2.Param();
      paramBitmap.context = ((Context)localObject);
      paramBitmap.fullScreen = false;
      this.e = ShareActionSheetFactory.create(paramBitmap);
      paramBitmap = new Intent();
      if (!this.cfT) {
        break label214;
      }
      i = 1;
      paramBitmap.putExtra("forward_type", i);
      paramBitmap.putExtra("key_share_data_line_support_type", 1);
      this.e.setIntentForStartForwardRecentActivity(paramBitmap);
      paramBitmap = this.e;
      if (!this.cfT) {
        break label219;
      }
      i = 0;
      paramBitmap.setRowVisibility(0, 0, i);
      localShareActionSheet = this.e;
      if (!this.cfT) {
        break label225;
      }
      paramBitmap = this.jdField_a_of_type_Agym.m((Context)localObject);
      label157:
      if (!this.cfT) {
        break label237;
      }
    }
    label214:
    label219:
    label225:
    label237:
    for (localObject = this.jdField_a_of_type_Agym.n((Context)localObject);; localObject = this.jdField_a_of_type_Agyk.n((Context)localObject))
    {
      localShareActionSheet.setActionSheetItems(paramBitmap, (List)localObject);
      this.e.setItemClickListenerV2(this);
      if (this.e.isShowing()) {
        break;
      }
      this.e.show();
      return;
      i = -1;
      break label84;
      i = 8;
      break label126;
      paramBitmap = this.jdField_a_of_type_Agyk.m((Context)localObject);
      break label157;
    }
  }
  
  public agyi.a a()
  {
    if (this.jdField_a_of_type_Agyn == null) {
      return new agyi.a();
    }
    return this.jdField_a_of_type_Agyn.a();
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.Qt == null) || (!this.Qt.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      agyj.B(1, 2131720152, true);
      return;
    }
    agyj.B(2, 2131720175, true);
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    if ((!isAdded()) || (isDetached()) || (isRemoving())) {}
    while ((this.jdField_a_of_type_Agym == null) || (!this.jdField_a_of_type_Agym.b(paramBitmap, paramInt, paramString))) {
      return false;
    }
    return true;
  }
  
  public boolean amF()
  {
    return super.onBackEvent();
  }
  
  public void dkF()
  {
    if (this.jdField_a_of_type_Agyk != null) {
      this.jdField_a_of_type_Agyk.reset();
    }
  }
  
  public void dkG()
  {
    agyn localagyn;
    if (this.jdField_a_of_type_Agyn != null)
    {
      localagyn = this.jdField_a_of_type_Agyn;
      if ((this.jdField_a_of_type_Agyk != null) && (this.jdField_a_of_type_Agyk.isProcessing())) {
        break label37;
      }
    }
    label37:
    for (boolean bool = true;; bool = false)
    {
      localagyn.setEnabled(bool);
      return;
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    initView();
    dkH();
  }
  
  public BaseActivity e()
  {
    return getActivity();
  }
  
  public int getContentLayoutId()
  {
    return 2131561041;
  }
  
  public String getFileName()
  {
    if (this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    }
    if (this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo != null) {
      return this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo.getName();
    }
    return "";
  }
  
  public String getFilePath()
  {
    if (this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    }
    if (this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo != null) {
      return this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo.getPath();
    }
    return "";
  }
  
  public long getFileSize()
  {
    if (this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    }
    if (this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo != null) {
      return this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo.getSize();
    }
    return 0L;
  }
  
  public int getFileType()
  {
    int i = 5;
    if (this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      i = this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType;
    }
    do
    {
      return i;
      if (this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo == null) {
        break;
      }
    } while (this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo.getType() == 5);
    return ahav.getFileType(this.jdField_f_of_type_ComTencentMobileqqFilemanagerDataFileInfo.getName());
    return -1;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Agyk != null) && (this.jdField_a_of_type_Agyk.isUploading()))
    {
      dkI();
      return true;
    }
    return amF();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.an)) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    if (this.jdField_a_of_type_Agyk != null) {
      this.jdField_a_of_type_Agyk.dkJ();
    }
    amF();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.Df) && (this.e != null)) {
      this.e.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!vz()) {
      amF();
    }
  }
  
  public void onDestroy()
  {
    this.Df = null;
    if (this.d != null)
    {
      this.d.setImageDrawable(null);
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.dismiss();
      this.e = null;
    }
    this.Qt = null;
    WXShareHelper.a().b(this);
    if (this.jdField_a_of_type_Agyn != null)
    {
      this.jdField_a_of_type_Agyn.onDestroy();
      this.jdField_a_of_type_Agyn = null;
    }
    if (this.jdField_a_of_type_Agyk != null)
    {
      this.jdField_a_of_type_Agyk.onDestroy();
      this.jdField_a_of_type_Agyk = null;
    }
    if (this.jdField_a_of_type_Agym != null)
    {
      this.jdField_a_of_type_Agym.onDestroy();
      this.jdField_a_of_type_Agym = null;
    }
    if (this.an != null)
    {
      this.an.dismiss();
      this.an = null;
    }
    super.onDestroy();
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if ((!this.cfT) && (this.e != null)) {
      this.e.dismiss();
    }
    int j = paramActionSheetItem.action;
    int i;
    if ((j == 9) || (j == 10)) {
      if (!WXShareHelper.a().isWXinstalled()) {
        i = 2131721935;
      }
    }
    for (;;)
    {
      if (i != -1) {
        agyj.B(0, i, false);
      }
      do
      {
        return;
        if (WXShareHelper.a().isWXsupportApi()) {
          break label187;
        }
        i = 2131721936;
        break;
        if (QLog.isColorLevel()) {
          QLog.i("LinkByWeiyunFragment<FileAssistant>", 2, "onItemClick.chooseChannel: " + j);
        }
      } while ((this.jdField_a_of_type_Agyk == null) || (this.jdField_a_of_type_Agym == null));
      if (this.cfT)
      {
        this.jdField_a_of_type_Agym.g(paramActionSheetItem);
        if (!this.cfT) {
          break label180;
        }
      }
      label180:
      for (paramActionSheetItem = "0X800A9DB";; paramActionSheetItem = "0X800A9DA")
      {
        agyj.report(paramActionSheetItem, agyj.ej(j), null);
        return;
        this.jdField_a_of_type_Agyk.g(paramActionSheetItem);
        break;
      }
      label187:
      i = -1;
    }
  }
  
  public String vS()
  {
    this.Qt = Long.toString(System.currentTimeMillis());
    WXShareHelper.a().a(this);
    return this.Qt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.link.LinkByWeiyunFragment
 * JD-Core Version:    0.7.0.1
 */