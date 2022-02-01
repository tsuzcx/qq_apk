import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.cloudfile.BatchRequest;
import com.tencent.cloudfile.BatchResult;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class auak
  extends atgd
{
  auak(auaj paramauaj) {}
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<BatchResult> paramList, int paramInt2, String paramString, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramArrayOfByte, paramInt1, paramList, paramInt2, paramString, paramBoolean2);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder().append("CloudFileObservercloud file onDeleteFolderOrFile : errorCode:").append(paramInt2).append("errorMsg:");
      if (paramString == null)
      {
        paramArrayOfByte = "";
        QLog.d("TIMCloudFileModel", 2, paramArrayOfByte);
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label89;
      }
      this.this$0.mContext.finish();
    }
    label89:
    do
    {
      return;
      paramArrayOfByte = paramString;
      break;
      if ((TextUtils.isEmpty(paramString)) && (this.this$0.Pp()))
      {
        auaj.a(this.this$0, false);
        auds.D(1, BaseApplicationImpl.getContext().getString(2131691575), 0);
        return;
      }
    } while (!this.this$0.Pp());
    auaj.a(this.this$0, false);
    auds.D(1, paramString, 0);
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, List<BatchRequest> paramList, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte1, paramList, paramArrayOfByte2, paramInt, paramString);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder().append("CloudFileObservercloud file onMoveFolderOrFile : errorCode:").append(paramInt).append("errorMsg:");
      if (paramString == null)
      {
        paramArrayOfByte1 = "";
        QLog.d("TIMCloudFileModel", 2, paramArrayOfByte1);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label101;
      }
      auds.D(2, BaseApplicationImpl.getApplication().getResources().getString(2131691562), 0);
      this.this$0.mContext.finish();
    }
    label101:
    do
    {
      return;
      paramArrayOfByte1 = paramString;
      break;
      if ((TextUtils.isEmpty(paramString)) && (this.this$0.Pp()))
      {
        auaj.a(this.this$0, false);
        auds.D(1, BaseApplicationImpl.getContext().getString(2131691686), 0);
        return;
      }
    } while (!this.this$0.Pp());
    auaj.a(this.this$0, false);
    auds.D(1, paramString, 0);
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt1, paramInt2, paramString);
    if (QLog.isColorLevel())
    {
      paramArrayOfByte2 = new StringBuilder().append("CloudFileObservercloud file onCopyFile : errorCode:").append(paramInt2).append("errorMsg:");
      if (paramString == null)
      {
        paramArrayOfByte1 = "";
        QLog.d("TIMCloudFileModel", 2, paramArrayOfByte1);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label93;
      }
      auds.D(2, BaseApplicationImpl.getApplication().getResources().getString(2131691569), 0);
    }
    label93:
    do
    {
      return;
      paramArrayOfByte1 = paramString;
      break;
      if (athu.v(paramInt2, paramBoolean))
      {
        athu.b(this.this$0.mAppInterface, this.this$0.mContext, 1);
        return;
      }
      if ((TextUtils.isEmpty(paramString)) && (this.this$0.Pp()))
      {
        auds.D(1, BaseApplicationImpl.getContext().getString(2131691686), 0);
        return;
      }
    } while (!this.this$0.Pp());
    auds.D(1, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auak
 * JD-Core Version:    0.7.0.1
 */