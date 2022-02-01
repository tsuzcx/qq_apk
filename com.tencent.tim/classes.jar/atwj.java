import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.filemanager.data.provider.FileDelegateActivity;
import java.lang.ref.WeakReference;
import mqq.app.AccountNotMatchException;

public class atwj
  extends atwl.a
{
  Activity M = null;
  atur b;
  private WeakReference<atjq> iV;
  String mUin;
  
  public atwj(String paramString)
  {
    this.jdField_b_of_type_Atur = null;
    this.mUin = paramString;
  }
  
  public void a(atjq paramatjq)
  {
    if (paramatjq != null) {
      this.iV = new WeakReference(paramatjq);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.mUin);
      ((ateh)localQQAppInterface.getBusinessHandler(180)).b(paramString1, paramString2, paramString3, paramString4, paramLong, null);
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      for (;;)
      {
        localAccountNotMatchException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public void an(int paramInt, String paramString1, String paramString2)
  {
    if ((BaseActivity.sTopActivity instanceof SplashActivity)) {
      this.M = BaseActivity.sTopActivity;
    }
    Intent localIntent = new Intent(this.M, FileDelegateActivity.class);
    localIntent.putExtra("_action_", paramInt);
    localIntent.putExtra("sha", paramString1);
    localIntent.putExtra("fileName", paramString2);
    this.M.startActivity(localIntent);
  }
  
  public void c(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    if (this.jdField_b_of_type_Atur == null) {
      this.jdField_b_of_type_Atur = atur.a();
    }
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("sha", paramString4);
    localBundle2.putString("fileId", paramString3);
    localBundle2.putString("fileName", paramString5);
    localBundle2.putString("preViewUrl", paramString2);
    localBundle1.putString("_filename_from_dlg", paramString5);
    localBundle1.putBoolean("_filename_disable_urldecode_", true);
    localBundle1.putLong("_filesize_from_dlg", paramLong);
    localBundle1.putBundle("_user_data", localBundle2);
    this.jdField_b_of_type_Atur.a(paramString1, localBundle1, new atwk(this, paramString1));
    try
    {
      paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.mUin);
      return;
    }
    catch (AccountNotMatchException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void j(Bitmap paramBitmap, int paramInt)
  {
    boolean bool = true;
    atjq localatjq;
    if ((this.iV != null) && (this.iV.get() != null))
    {
      localatjq = (atjq)this.iV.get();
      if (paramInt != 1) {
        break label51;
      }
    }
    for (;;)
    {
      localatjq.g(paramBitmap, bool);
      this.iV = null;
      return;
      label51:
      bool = false;
    }
  }
  
  public void jk(String paramString1, String paramString2)
  {
    long l2 = 0L;
    for (;;)
    {
      try
      {
        FileManagerEntity localFileManagerEntity = ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.mUin)).a().c(paramString1, paramString2);
        paramString1 = "";
        paramString2 = "";
        if (localFileManagerEntity != null)
        {
          l1 = localFileManagerEntity.nSessionId;
          paramString1 = localFileManagerEntity.getFilePath();
          paramString2 = localFileManagerEntity.fileName;
          l2 = localFileManagerEntity.fileSize;
          this.jdField_b_of_type_Atwm.a(l1, paramString1, paramString2, l2);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      long l1 = 0L;
    }
  }
  
  public void pauseDownload(String paramString)
  {
    atur.a locala = this.jdField_b_of_type_Atur.a(paramString);
    if (locala != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("_notify_param_Id", locala.cXL);
      this.jdField_b_of_type_Atur.A(paramString, localBundle);
    }
  }
  
  public void unregisterCallback()
  {
    this.jdField_b_of_type_Atwm = null;
    this.M = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwj
 * JD-Core Version:    0.7.0.1
 */