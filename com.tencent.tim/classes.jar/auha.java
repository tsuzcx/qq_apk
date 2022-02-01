import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.cloudfile.CloudBase;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.tim.cloudfile.CloudFileDirBrowserActivity;
import com.tencent.tim.mvp.cloudfile.CloudFileAndFolderOperationController.7;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class auha
  implements auhk.d
{
  private augx jdField_a_of_type_Augx;
  private auhk.e jdField_a_of_type_Auhk$e;
  private aqky b;
  private aqju be;
  
  public auha(augx paramaugx)
  {
    this.jdField_a_of_type_Augx = paramaugx;
  }
  
  public String Fc()
  {
    if (this.b != null) {
      return this.b.getInputValue();
    }
    return "";
  }
  
  public boolean Pp()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Augx != null) {
      bool = this.jdField_a_of_type_Augx.Pp();
    }
    return bool;
  }
  
  public void a(Context paramContext, Object... paramVarArgs)
  {
    auhb localauhb = new auhb(this, paramVarArgs);
    auhc localauhc = new auhc(this);
    if (paramVarArgs.length == 1)
    {
      paramVarArgs = (atiu)paramVarArgs[0];
      i = paramVarArgs.getCloudFileType();
      if (i == 2) {
        paramVarArgs = paramContext.getString(2131691612);
      }
      for (;;)
      {
        this.be = aqha.a(paramContext, 230, null, paramVarArgs, localauhb, localauhc);
        this.be.show();
        return;
        if (i == 1)
        {
          paramVarArgs = (atin)paramVarArgs;
          if (paramVarArgs.totalCount == 0) {}
          for (i = paramVarArgs.subDirCount + paramVarArgs.subFileCount;; i = paramVarArgs.totalCount)
          {
            if (i <= 0) {
              break label145;
            }
            paramVarArgs = paramContext.getString(2131691609, new Object[] { paramVarArgs.name, Integer.valueOf(i) });
            break;
          }
          label145:
          paramVarArgs = paramContext.getString(2131691610, new Object[] { paramVarArgs.name });
        }
        else
        {
          paramVarArgs = paramContext.getString(2131691611);
        }
      }
    }
    int n = paramVarArgs.length;
    int k = 0;
    int j = 0;
    int i = 0;
    label188:
    if (k < n)
    {
      Object localObject = paramVarArgs[k];
      if (!(localObject instanceof atin)) {
        break label310;
      }
      localObject = (atin)localObject;
      j = ((atin)localObject).subDirCount;
      j = ((atin)localObject).subFileCount + j + i;
      i = 1;
    }
    for (;;)
    {
      int m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break label188;
      if (i > 0)
      {
        paramVarArgs = paramContext.getString(2131691607, new Object[] { Integer.valueOf(i) });
        break;
      }
      if (j != 0)
      {
        paramVarArgs = paramContext.getString(2131691608);
        break;
      }
      paramVarArgs = paramContext.getString(2131691611);
      break;
      label310:
      m = i;
      i = j;
      j = m;
    }
  }
  
  public void a(auhk.e parame)
  {
    this.jdField_a_of_type_Auhk$e = parame;
  }
  
  public void d(Context paramContext, Object paramObject)
  {
    Object localObject1 = null;
    auhd localauhd = new auhd(this);
    auhe localauhe = new auhe(this, paramObject);
    auhf localauhf = new auhf(this);
    if ((paramObject instanceof FileManagerEntity))
    {
      paramObject = ((FileManagerEntity)paramObject).cloudFile;
      localObject1 = paramContext.getString(2131691629);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        this.b = aqha.a(paramContext, 2131691654, paramObject.showName, (String)localObject1, localauhd, 2131721079, localauhe, 2131721058, localauhf);
        this.b.setOnDismissListener(new auhg(this));
      }
      return;
      if ((paramObject instanceof atin))
      {
        paramObject = ((atin)paramObject).a;
        localObject1 = paramContext.getString(2131691614);
      }
      else
      {
        Object localObject2 = null;
        paramObject = localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  public void e(Context paramContext, Object paramObject)
  {
    Intent localIntent = new Intent(paramContext, CloudFileDirBrowserActivity.class);
    if ((paramObject instanceof atin)) {
      paramObject = aueh.a((atin)paramObject);
    }
    for (;;)
    {
      anpc.report("tim_mine_tab_file_click_copy_file");
      Object localObject = new FileInfo();
      ((FileInfo)localObject).bf(((atgc)((QQAppInterface)((BaseActivity)paramContext).getAppInterface()).getManager(373)).aE());
      ((FileInfo)localObject).setName(paramContext.getString(2131691603));
      localIntent.putExtra("key_file_info", (Parcelable)localObject);
      localIntent.putExtra("key_top_level_dir", true);
      localIntent.putExtra("key_file_browser_mode", 1);
      localIntent.putExtra("key_bottom_bar_left_action", 1);
      localIntent.putExtra("key_bottom_bar_right_action", 3);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramObject);
      localIntent.putExtra("key_file_to_be_dealt_with", (Serializable)localObject);
      athu.h(paramContext, localIntent, 4);
      return;
      if ((paramObject instanceof FileManagerEntity)) {
        paramObject = aueh.a((FileManagerEntity)paramObject);
      } else {
        paramObject = null;
      }
    }
  }
  
  public void euU()
  {
    if ((this.be != null) && (this.be.isShowing())) {
      this.be.dismiss();
    }
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
  }
  
  public void h(Context paramContext, List<Object> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, CloudFileDirBrowserActivity.class);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof atin))
      {
        localArrayList.add(aueh.a((atin)localObject));
        anpc.report("tim_mine_tab_file_click_move_folder");
      }
      else if ((localObject instanceof FileManagerEntity))
      {
        localArrayList.add(aueh.a((FileManagerEntity)localObject));
        anpc.report("tim_mine_tab_file_click_move_file");
      }
    }
    paramList = new FileInfo();
    paramList.bf(((atgc)((QQAppInterface)((BaseActivity)paramContext).getAppInterface()).getManager(373)).aE());
    paramList.setName(paramContext.getString(2131691641));
    localIntent.putExtra("key_file_info", paramList);
    localIntent.putExtra("key_top_level_dir", true);
    localIntent.putExtra("key_file_browser_mode", 1);
    localIntent.putExtra("key_bottom_bar_left_action", 1);
    localIntent.putExtra("key_bottom_bar_right_action", 1);
    localIntent.putExtra("key_file_to_be_dealt_with", localArrayList);
    athu.h(paramContext, localIntent, 3);
  }
  
  public void i(Context paramContext, List<Object> paramList)
  {
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    long l1 = 0L;
    new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      int i = 1;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        int j = i;
        long l2 = l1;
        if ((localObject instanceof FileManagerEntity))
        {
          localObject = audx.c((FileManagerEntity)localObject);
          if (!aueh.fileExistsAndNotEmpty(((FileManagerEntity)localObject).getFilePath())) {
            i = 0;
          }
          ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
          localForwardFileInfo.setType(10014);
          localForwardFileInfo.Oj(((FileManagerEntity)localObject).getCloudType());
          localForwardFileInfo.p(((FileManagerEntity)localObject).nSessionId);
          localForwardFileInfo.setFileName(((FileManagerEntity)localObject).fileName);
          localForwardFileInfo.jB(((FileManagerEntity)localObject).uniseq);
          localForwardFileInfo.bf(((FileManagerEntity)localObject).cloudId);
          localForwardFileInfo.bg(((FileManagerEntity)localObject).pDirKey);
          localForwardFileInfo.setFileSize(((FileManagerEntity)localObject).fileSize);
          localForwardFileInfo.setLocalPath(((FileManagerEntity)localObject).getFilePath());
          localForwardFileInfo.setUuid(((FileManagerEntity)localObject).Uuid);
          l2 = l1 + localForwardFileInfo.getFileSize();
          localArrayList.add(localForwardFileInfo);
          j = i;
        }
        i = j;
        l1 = l2;
      }
      localBundle.putInt("forward_type", 0);
      localBundle.putParcelableArrayList("fileinfo_array", localArrayList);
      localBundle.putBoolean("not_forward", true);
      localIntent.putExtra("foward_editbar", true);
      if (i == 0) {
        localIntent.putExtra("k_dataline", false);
      }
      localIntent.putExtra("sendMultiple", true);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("forward_type", 0);
      paramList = "转发文件";
      if (localArrayList.size() != 1) {
        break label450;
      }
      paramList = "已选择" + audx.kY(((ForwardFileInfo)localArrayList.get(0)).getFileName()) + "，大小" + aueh.g(((ForwardFileInfo)localArrayList.get(0)).getFileSize()) + "。";
    }
    for (;;)
    {
      localIntent.putExtra("forward_text", paramList);
      localIntent.putExtra("k_favorites", false);
      localIntent.setClass(paramContext, ForwardRecentActivity.class);
      athu.h(paramContext, localIntent, 103);
      return;
      label450:
      if (localArrayList.size() > 1) {
        paramList = "已选择" + audx.kY(((ForwardFileInfo)localArrayList.get(0)).getFileName()) + "等" + localArrayList.size() + "个文件，大小" + aueh.g(l1) + "。";
      }
    }
  }
  
  public void qw(String paramString)
  {
    ThreadManager.getUIHandler().post(new CloudFileAndFolderOperationController.7(this, paramString));
  }
  
  public void showSuccessToast(String paramString)
  {
    auds.D(2, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auha
 * JD-Core Version:    0.7.0.1
 */