import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.tim.filemanager.fileviewer.TroopFileDetailBrowserActivity;

public class atxh
{
  public static View.OnClickListener a(agsa paramagsa, FileManagerEntity paramFileManagerEntity, Activity paramActivity, Bundle paramBundle)
  {
    return new atxo(paramagsa, paramFileManagerEntity, paramActivity);
  }
  
  public static View.OnClickListener a(agsa paramagsa, FileManagerEntity paramFileManagerEntity, Activity paramActivity, audx.d paramd)
  {
    return new atxx(paramagsa, paramFileManagerEntity, paramActivity, paramd);
  }
  
  public static View.OnClickListener a(agsa paramagsa, FileManagerEntity paramFileManagerEntity, Activity paramActivity, auhk.e parame)
  {
    return new atxw(parame, paramFileManagerEntity);
  }
  
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    return new atxq(paramFileManagerEntity, paramActivity);
  }
  
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, auhk.e parame)
  {
    return new atxs(parame, paramFileManagerEntity);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString, FileManagerEntity paramFileManagerEntity, audx.d paramd)
  {
    return new atxl(paramActivity, paramString, paramd);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new atxv(paramFileManagerEntity, paramActivity);
  }
  
  private static void a(agsa paramagsa, FileManagerEntity paramFileManagerEntity, Activity paramActivity, audx.d paramd, Class<?> paramClass)
  {
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      FileManagerEntity localFileManagerEntity = new FileManagerEntity();
      localFileManagerEntity.copyFrom(paramFileManagerEntity);
      localFileManagerEntity.nSessionId = audx.d().longValue();
      localFileManagerEntity.status = 2;
      ((QQAppInterface)localObject).a().v(localFileManagerEntity);
      audw.b localb = new audw.b();
      localb.bJE = "file_forward";
      localb.cYX = 71;
      localb.nFileSize = localFileManagerEntity.fileSize;
      localb.bJF = aueh.getExtension(localFileManagerEntity.fileName);
      localb.bJH = audx.H(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
      audw.a(((QQAppInterface)localObject).getCurrentAccountUin(), localb);
      int i = ahhq.e(paramFileManagerEntity);
      localObject = ahhq.a(localFileManagerEntity);
      ((ForwardFileInfo)localObject).setType(i);
      paramFileManagerEntity = new Bundle();
      paramFileManagerEntity.putInt("forward_type", 0);
      paramFileManagerEntity.putParcelable("fileinfo", (Parcelable)localObject);
      paramFileManagerEntity.putBoolean("not_forward", true);
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramFileManagerEntity);
      ((Intent)localObject).putExtra("destroy_last_activity", true);
      ((Intent)localObject).putExtra("forward_type", 0);
      ((Intent)localObject).putExtra("forward_filepath", localFileManagerEntity.getFilePath());
      ((Intent)localObject).putExtra("forward_text", "已选择" + audx.kY(localFileManagerEntity.fileName) + "，大小" + aueh.g(localFileManagerEntity.fileSize) + "。");
      ((Intent)localObject).putExtra("k_favorites", audx.q(localFileManagerEntity));
      if ((!aueh.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) && ((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7)))
      {
        ((Intent)localObject).putExtra("isFromShare", true);
        if (localFileManagerEntity.nFileType == 0) {
          ((Intent)localObject).putExtra("forward_type", 1);
        }
      }
      if ((localFileManagerEntity.getCloudType() == 8) && (localFileManagerEntity.nFileType == 0)) {
        ((Intent)localObject).putExtra("forward_type", 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ActionBarUtil getFileForwardClick forwardType=" + i + "newEntity.nFileType=" + localFileManagerEntity.nFileType);
      }
      if ((((paramActivity instanceof FileBrowserActivity)) || ((paramActivity instanceof TroopFileDetailBrowserActivity))) && (((FileBrowserActivity)paramActivity).bY())) {
        ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
      }
      if (!aqiw.isNetSupport(BaseApplication.getContext())) {
        QQToast.a(paramActivity, 2131696348, 1).show(paramActivity.getResources().getDimensionPixelSize(2131299627));
      }
      for (;;)
      {
        if (paramagsa != null) {
          paramagsa.au(2);
        }
        if (paramd == null) {
          break;
        }
        paramd.euA();
        return;
        if (audk.a(localFileManagerEntity).bd(false)) {
          ahal.a(paramActivity, 2131693826, 2131693832, new atxi(paramActivity, (Intent)localObject, paramClass, paramd));
        } else {
          ahgq.a(paramActivity, (Intent)localObject, paramClass, 103);
        }
      }
      return;
    }
    catch (Exception paramagsa) {}
  }
  
  public static View.OnClickListener b(agsa paramagsa, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new atxm(paramActivity, paramagsa, paramFileManagerEntity);
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, auhk.e parame)
  {
    return new atxt(parame, paramFileManagerEntity);
  }
  
  public static View.OnClickListener b(Activity paramActivity, String paramString, FileManagerEntity paramFileManagerEntity, audx.d paramd)
  {
    return new atxp(paramString, paramActivity);
  }
  
  public static View.OnClickListener c(Activity paramActivity, FileManagerEntity paramFileManagerEntity, auhk.e parame)
  {
    return new atxu(parame, paramFileManagerEntity);
  }
  
  public static View.OnClickListener c(Activity paramActivity, String paramString)
  {
    return new atxk(paramString, paramActivity);
  }
  
  public static View.OnClickListener f(agsa paramagsa, FileManagerEntity paramFileManagerEntity)
  {
    return new atxn(paramFileManagerEntity, paramagsa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxh
 * JD-Core Version:    0.7.0.1
 */