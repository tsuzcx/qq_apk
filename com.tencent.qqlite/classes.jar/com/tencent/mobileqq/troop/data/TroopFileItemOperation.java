package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
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
import eop;
import eoq;
import eor;
import eos;
import eot;
import eou;
import eov;
import eow;
import eox;
import eoy;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class TroopFileItemOperation
{
  public static long a;
  public static Activity a;
  public static QQAppInterface a;
  
  public TroopFileItemOperation(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    jdField_a_of_type_Long = paramLong;
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private int a()
  {
    return a(true);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TroopFileUtils.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_AndroidAppActivity, jdField_a_of_type_Long);
    }
    return TroopFileUtils.a(jdField_a_of_type_AndroidAppActivity);
  }
  
  private String a(int paramInt)
  {
    return jdField_a_of_type_AndroidAppActivity.getResources().getString(paramInt);
  }
  
  private String a(int paramInt, Object... paramVarArgs)
  {
    return String.format(a(paramInt), paramVarArgs);
  }
  
  public static void h(TroopFileInfo paramTroopFileInfo)
  {
    ReportController.b(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_viewer", 0, 0, "", jdField_a_of_type_Long + "", "", "");
    FileInfo localFileInfo = new FileInfo();
    if ((paramTroopFileInfo.c == null) || (paramTroopFileInfo.f == null)) {
      return;
    }
    if (!FileUtil.a(paramTroopFileInfo.f))
    {
      TroopFileTransferManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_Long).b();
      int i = paramTroopFileInfo.c.length();
      if (i > 11) {}
      for (paramTroopFileInfo = paramTroopFileInfo.c.substring(0, 3) + "..." + paramTroopFileInfo.c.substring(i - 4, i);; paramTroopFileInfo = paramTroopFileInfo.c)
      {
        TroopFileError.a(jdField_a_of_type_AndroidAppActivity, null, TroopFileUtils.a(paramTroopFileInfo) + "不存在，无法打开", 2131362802);
        return;
      }
    }
    Object localObject1 = TroopFileTransferManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_Long).a(paramTroopFileInfo.jdField_b_of_type_JavaLangString);
    if ((localObject1 != null) && (!TextUtils.isEmpty(((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString))) {}
    for (localObject1 = ((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString;; localObject1 = paramTroopFileInfo.c)
    {
      TroopFileManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_Long).a(paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
      localFileInfo.d((String)localObject1);
      localFileInfo.e(paramTroopFileInfo.f);
      localFileInfo.a(paramTroopFileInfo.jdField_a_of_type_Long);
      Object localObject2 = new TroopFileStatusInfo();
      ((TroopFileStatusInfo)localObject2).jdField_e_of_type_JavaLangString = ((String)localObject1);
      ((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaLangString = paramTroopFileInfo.f;
      ((TroopFileStatusInfo)localObject2).jdField_b_of_type_Long = paramTroopFileInfo.jdField_a_of_type_Long;
      ((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaUtilUUID = paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID;
      ((TroopFileStatusInfo)localObject2).jdField_a_of_type_Long = jdField_a_of_type_Long;
      ((TroopFileStatusInfo)localObject2).jdField_e_of_type_Int = paramTroopFileInfo.jdField_a_of_type_Int;
      ((TroopFileStatusInfo)localObject2).d = paramTroopFileInfo.jdField_b_of_type_JavaLangString;
      ((TroopFileStatusInfo)localObject2).jdField_b_of_type_Int = paramTroopFileInfo.g;
      localObject2 = FileManagerUtil.a((TroopFileStatusInfo)localObject2);
      localObject1 = new ForwardFileInfo();
      ((FileManagerEntity)localObject2).selfUin = String.valueOf(paramTroopFileInfo.jdField_b_of_type_Int);
      ((FileManagerEntity)localObject2).lastTime = paramTroopFileInfo.d;
      ((ForwardFileInfo)localObject1).b(((FileManagerEntity)localObject2).nSessionId);
      ((ForwardFileInfo)localObject1).c(4);
      ((ForwardFileInfo)localObject1).a(10006);
      ((ForwardFileInfo)localObject1).a(localFileInfo.d());
      ((ForwardFileInfo)localObject1).d(localFileInfo.e());
      ((ForwardFileInfo)localObject1).d(localFileInfo.a());
      ((ForwardFileInfo)localObject1).a(jdField_a_of_type_Long);
      paramTroopFileInfo = jdField_a_of_type_AndroidAppActivity;
      if ((jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity)) {
        paramTroopFileInfo = ((BasePluginActivity)jdField_a_of_type_AndroidAppActivity).getOutActivity();
      }
      paramTroopFileInfo = new Intent(paramTroopFileInfo, FileBrowserActivity.class);
      if ((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 1))
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
      jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramTroopFileInfo, 102);
      return;
    }
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
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_Long);
    if (i == 1)
    {
      paramString1 = new eos(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
      paramString2 = a(2131362248, new Object[] { TroopFileUtils.a(paramString2), TroopFileUtils.a(paramLong) });
      DialogUtil.a(jdField_a_of_type_AndroidAppActivity, 230, a(2131362239), paramString2, 2131362801, 2131362204, paramString1, paramString1).show();
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
    Object localObject = TroopFileTransferManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_Long);
    if (i == 1)
    {
      localObject = new eop(this, (TroopFileTransferManager)localObject, paramString, paramBoolean);
      File localFile = new File(paramString);
      paramString = a(2131362245, new Object[] { TroopFileUtils.a(FileManagerUtil.a(paramString)), TroopFileUtils.a(localFile.length()) });
      DialogUtil.a(jdField_a_of_type_AndroidAppActivity, 230, a(2131362239), paramString, 2131362801, 2131362205, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject).show();
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
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_Long);
    if (i == 1)
    {
      eor localeor = new eor(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = a(2131362246, new Object[] { TroopFileUtils.a(paramUUID.jdField_e_of_type_JavaLangString), TroopFileUtils.a(paramUUID.jdField_b_of_type_Long) });; paramUUID = a(2131362247))
      {
        DialogUtil.a(jdField_a_of_type_AndroidAppActivity, 230, a(2131362239), paramUUID, 2131362801, 2131362206, localeor, localeor).show();
        return;
      }
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new eou(this, paramTroopFileInfo);
    DialogUtil.a(jdField_a_of_type_AndroidAppActivity, 230, a(2131362240), a(2131362251), 2131362801, 2131362802, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void b(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_Long);
    if (i == 1)
    {
      eot localeot = new eot(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = a(2131362249, new Object[] { TroopFileUtils.a(paramUUID.jdField_e_of_type_JavaLangString), TroopFileUtils.a(paramUUID.jdField_b_of_type_Long) });; paramUUID = a(2131362250))
      {
        DialogUtil.a(jdField_a_of_type_AndroidAppActivity, 230, a(2131362239), paramUUID, 2131362801, 2131362207, localeot, localeot).show();
        return;
      }
    }
    localTroopFileTransferManager.f(paramUUID);
  }
  
  public void c(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new eov(this, paramTroopFileInfo);
    DialogUtil.a(jdField_a_of_type_AndroidAppActivity, 230, a(2131362241), a(2131362252), 2131362801, 2131362802, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    int i = a(false);
    eow localeow = new eow(this, paramTroopFileInfo);
    if (i == 1) {}
    for (paramTroopFileInfo = a(2131362246, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c), paramTroopFileInfo.a() });; paramTroopFileInfo = a(2131362253, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c) }))
    {
      DialogUtil.a(jdField_a_of_type_AndroidAppActivity, 230, a(2131362242), paramTroopFileInfo, 2131362801, 2131362206, localeow, localeow).show();
      return;
    }
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    int i = a(false);
    eox localeox = new eox(this, paramTroopFileInfo);
    if (i == 1) {}
    for (paramTroopFileInfo = a(2131362249, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c), paramTroopFileInfo.a() });; paramTroopFileInfo = a(2131362254, new Object[] { TroopFileUtils.a(paramTroopFileInfo.c) }))
    {
      DialogUtil.a(jdField_a_of_type_AndroidAppActivity, 230, a(2131362243), paramTroopFileInfo, 2131362801, 2131362207, localeox, localeox).show();
      return;
    }
  }
  
  public void f(TroopFileInfo paramTroopFileInfo)
  {
    boolean bool = false;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(jdField_a_of_type_AndroidAppActivity, null, 2131624120);
    String[] arrayOfString = jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2131230752);
    if (paramTroopFileInfo.g == 11)
    {
      localActionSheet.a(arrayOfString[0], 1);
      bool = true;
    }
    if ((TroopFileUtils.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_Long)) || (jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramTroopFileInfo.c()))) {
      localActionSheet.a(arrayOfString[1], 1);
    }
    localActionSheet.a(new eoy(this, bool, paramTroopFileInfo, localActionSheet));
    localActionSheet.d(2131362801);
    localActionSheet.show();
  }
  
  public void g(TroopFileInfo paramTroopFileInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troopUin", String.valueOf(jdField_a_of_type_Long));
    localIntent.putExtra("uuid_key", paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString());
    if (paramTroopFileInfo.jdField_b_of_type_JavaLangString != null) {
      localIntent.putExtra("Url", paramTroopFileInfo.jdField_b_of_type_JavaLangString);
    }
    localIntent.putExtra("fileSize", paramTroopFileInfo.jdField_a_of_type_Long);
    localIntent.putExtra("fileName", paramTroopFileInfo.c);
    localIntent.putExtra("bisID", paramTroopFileInfo.jdField_a_of_type_Int);
    localIntent.putExtra("uploadUin", String.valueOf(paramTroopFileInfo.jdField_b_of_type_Int));
    localIntent.putExtra("deadTime", paramTroopFileInfo.d);
    TroopProxyActivity.b(jdField_a_of_type_AndroidAppActivity, localIntent, 0);
  }
  
  public void i(TroopFileInfo paramTroopFileInfo)
  {
    String str1 = jdField_a_of_type_AndroidAppActivity.getString(2131362260);
    String str2 = String.format(jdField_a_of_type_AndroidAppActivity.getString(2131362276), new Object[] { TroopFileUtils.a(paramTroopFileInfo.c) });
    QQCustomDialog localQQCustomDialog = DialogUtil.b(jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(str1).setMessage(str2);
    localQQCustomDialog.setPositiveButton(jdField_a_of_type_AndroidAppActivity.getString(2131362802), new eoq(this, paramTroopFileInfo));
    localQQCustomDialog.show();
  }
  
  public void j(TroopFileInfo paramTroopFileInfo)
  {
    if (a() != 0)
    {
      TroopFileManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_Long).a(paramTroopFileInfo);
      ReportController.b(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation
 * JD-Core Version:    0.7.0.1
 */