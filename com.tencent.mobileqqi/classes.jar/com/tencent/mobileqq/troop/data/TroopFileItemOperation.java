package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.troopfile.TroopFileViewerActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.troop.TroopProxyActivity;
import gvx;
import gvy;
import gvz;
import gwa;
import gwb;
import gwc;
import gwd;
import gwe;
import gwf;
import gwg;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class TroopFileItemOperation
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public TroopFileItemOperation(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private int a()
  {
    return a(true);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return TroopFileUtils.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private String a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getString(paramInt);
  }
  
  private String a(int paramInt, Object... paramVarArgs)
  {
    return String.format(a(paramInt), paramVarArgs);
  }
  
  protected TroopFileInfo a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof TroopFileEntry))) {
      return null;
    }
    return ((TroopFileEntry)paramView).a();
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (i == 1)
    {
      paramString1 = new gwa(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
      paramString2 = a(2131560341, new Object[] { TroopFileUtils.a(paramString2), TroopFileUtils.a(paramLong) });
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131560332), paramString2, 2131561746, 2131560307, paramString1, paramString1).show();
      return;
    }
    localTroopFileTransferManager.a(paramString1, paramString2, paramLong, paramInt);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (i == 1)
    {
      localObject = new gvx(this, (TroopFileTransferManager)localObject, paramString, paramBoolean);
      File localFile = new File(paramString);
      paramString = a(2131560338, new Object[] { TroopFileUtils.a(FileManagerUtil.a(paramString)), TroopFileUtils.a(localFile.length()) });
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131560332), paramString, 2131561746, 2131560308, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject).show();
      return;
    }
    ((TroopFileTransferManager)localObject).a(paramString, paramBoolean);
  }
  
  public void a(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (i == 1)
    {
      gvz localgvz = new gvz(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = a(2131560339, new Object[] { TroopFileUtils.a(paramUUID.jdField_e_of_type_JavaLangString), TroopFileUtils.a(paramUUID.b) });; paramUUID = a(2131560340))
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131560332), paramUUID, 2131561746, 2131560309, localgvz, localgvz).show();
        return;
      }
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new gwc(this, paramTroopFileInfo);
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131560333), a(2131560344), 2131561746, 2131562539, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void b(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (i == 1)
    {
      gwb localgwb = new gwb(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = a(2131560342, new Object[] { TroopFileUtils.a(paramUUID.jdField_e_of_type_JavaLangString), TroopFileUtils.a(paramUUID.b) });; paramUUID = a(2131560343))
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131560332), paramUUID, 2131561746, 2131560310, localgwb, localgwb).show();
        return;
      }
    }
    localTroopFileTransferManager.f(paramUUID);
  }
  
  public void c(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new gwd(this, paramTroopFileInfo);
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131560334), a(2131560345), 2131561746, 2131562539, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    int i = a(false);
    gwe localgwe = new gwe(this, paramTroopFileInfo);
    if (i == 1) {}
    for (paramTroopFileInfo = a(2131560339, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c), paramTroopFileInfo.a() });; paramTroopFileInfo = a(2131560346, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c) }))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131560335), paramTroopFileInfo, 2131561746, 2131560309, localgwe, localgwe).show();
      return;
    }
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    int i = a(false);
    gwf localgwf = new gwf(this, paramTroopFileInfo);
    if (i == 1) {}
    for (paramTroopFileInfo = a(2131560342, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c), paramTroopFileInfo.a() });; paramTroopFileInfo = a(2131560347, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c) }))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, a(2131560336), paramTroopFileInfo, 2131561746, 2131560310, localgwf, localgwf).show();
      return;
    }
  }
  
  public void f(TroopFileInfo paramTroopFileInfo)
  {
    boolean bool = true;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2131689520);
    if (paramTroopFileInfo.g == 11) {
      localActionSheet.a(arrayOfString[0], 1);
    }
    for (;;)
    {
      localActionSheet.a(new gwg(this, bool, paramTroopFileInfo, localActionSheet));
      localActionSheet.d(2131561746);
      localActionSheet.show();
      do
      {
        return;
      } while ((!TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramTroopFileInfo.c())));
      localActionSheet.a(arrayOfString[1], 1);
      bool = false;
    }
  }
  
  public void g(TroopFileInfo paramTroopFileInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troopUin", String.valueOf(this.jdField_a_of_type_Long));
    localIntent.putExtra("uuid_key", paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString());
    if (paramTroopFileInfo.b != null) {
      localIntent.putExtra("Url", paramTroopFileInfo.b);
    }
    localIntent.putExtra("fileSize", paramTroopFileInfo.jdField_a_of_type_Long);
    localIntent.putExtra("fileName", paramTroopFileInfo.c);
    localIntent.putExtra("bisID", paramTroopFileInfo.jdField_a_of_type_Int);
    TroopProxyActivity.b(this.jdField_a_of_type_AndroidAppActivity, localIntent, 0);
  }
  
  public void h(TroopFileInfo paramTroopFileInfo)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_viewer", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    FileInfo localFileInfo = new FileInfo();
    if ((paramTroopFileInfo.c == null) || (paramTroopFileInfo.f == null)) {
      return;
    }
    if (!FileUtil.a(paramTroopFileInfo.f))
    {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).b();
      int i = paramTroopFileInfo.c.length();
      if (i > 11) {}
      for (paramTroopFileInfo = paramTroopFileInfo.c.substring(0, 3) + "..." + paramTroopFileInfo.c.substring(i - 4, i);; paramTroopFileInfo = paramTroopFileInfo.c)
      {
        TroopFileError.a(this.jdField_a_of_type_AndroidAppActivity, null, TroopFileUtils.a(paramTroopFileInfo) + a(2131559310), 2131562539);
        return;
      }
    }
    Object localObject1 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramTroopFileInfo.b);
    if ((localObject1 != null) && (!TextUtils.isEmpty(((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString))) {}
    for (localObject1 = ((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString;; localObject1 = paramTroopFileInfo.c)
    {
      TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
      localFileInfo.c((String)localObject1);
      localFileInfo.d(paramTroopFileInfo.f);
      localFileInfo.a(paramTroopFileInfo.jdField_a_of_type_Long);
      Object localObject2 = new TroopFileStatusInfo();
      ((TroopFileStatusInfo)localObject2).jdField_e_of_type_JavaLangString = ((String)localObject1);
      ((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaLangString = paramTroopFileInfo.f;
      ((TroopFileStatusInfo)localObject2).b = paramTroopFileInfo.jdField_a_of_type_Long;
      ((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaUtilUUID = paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID;
      ((TroopFileStatusInfo)localObject2).jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      ((TroopFileStatusInfo)localObject2).jdField_e_of_type_Int = paramTroopFileInfo.jdField_a_of_type_Int;
      ((TroopFileStatusInfo)localObject2).d = paramTroopFileInfo.b;
      localObject2 = FileManagerUtil.a((TroopFileStatusInfo)localObject2);
      localObject1 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject1).b(((FileManagerEntity)localObject2).nSessionId);
      ((ForwardFileInfo)localObject1).c(4);
      ((ForwardFileInfo)localObject1).a(10006);
      ((ForwardFileInfo)localObject1).a(localFileInfo.c());
      ((ForwardFileInfo)localObject1).d(localFileInfo.d());
      ((ForwardFileInfo)localObject1).d(localFileInfo.a());
      ((ForwardFileInfo)localObject1).a(this.jdField_a_of_type_Long);
      paramTroopFileInfo = this.jdField_a_of_type_AndroidAppActivity;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity)) {
        paramTroopFileInfo = ((BasePluginActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      }
      paramTroopFileInfo = new Intent(paramTroopFileInfo, TroopFileViewerActivity.class);
      if (((FileManagerEntity)localObject2).nFileType == 0)
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localFileInfo);
        FMDataCache.a((ArrayList)localObject2);
        paramTroopFileInfo.putExtra("clicked_file_hashcode", localFileInfo.hashCode());
      }
      paramTroopFileInfo.putExtra("fileinfo", (Parcelable)localObject1);
      paramTroopFileInfo.putExtra("removemementity", true);
      paramTroopFileInfo.putExtra("forward_from_troop_file", true);
      paramTroopFileInfo.putExtra("not_forward", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramTroopFileInfo, 102);
      return;
    }
  }
  
  public void i(TroopFileInfo paramTroopFileInfo)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131560353);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131560369), new Object[] { TroopFileUtils.a(paramTroopFileInfo.c) });
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(str1).setMessage(str2);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131562539), new gvy(this, paramTroopFileInfo));
    localQQCustomDialog.show();
  }
  
  public void j(TroopFileInfo paramTroopFileInfo)
  {
    if (a() != 0)
    {
      TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramTroopFileInfo);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation
 * JD-Core Version:    0.7.0.1
 */