import android.os.Bundle;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudOnlineFileExt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

class auhm
  extends atgd
{
  auhm(auhl paramauhl) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, long paramLong, FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte, paramLong, paramFileManagerEntity, paramInt, paramString);
    if ((auhl.a(this.this$0) == paramLong) && (this.this$0.a != null))
    {
      this.this$0.a.ehM();
      if (this.this$0.a.Pp())
      {
        if ((!paramBoolean) || (paramFileManagerEntity == null) || (paramFileManagerEntity.cloudFile == null) || (paramFileManagerEntity.cloudFile.onlineFileExt == null) || (paramFileManagerEntity.cloudFile.onlineFileExt.url == null)) {
          break label207;
        }
        paramArrayOfByte = paramFileManagerEntity.cloudFile.onlineFileExt.url;
        paramFileManagerEntity = new Bundle();
        paramFileManagerEntity.putString("url", paramArrayOfByte);
        paramFileManagerEntity.putString("tdsourcetag", "s_tim_cloud_new");
        this.this$0.bundle.putInt("key_team_work_edit_type", auhl.a(this.this$0));
        paramFileManagerEntity.putAll(this.this$0.bundle);
        TeamWorkDocEditBrowserActivity.a(this.this$0.context, paramFileManagerEntity, true);
        ((aulh)auhl.b(this.this$0).getBusinessHandler(178)).VT(false);
      }
    }
    label207:
    while ((this.this$0.a == null) || (!this.this$0.a.Pp())) {
      return;
    }
    if (paramString != null) {}
    for (;;)
    {
      this.this$0.a.al(false, paramString);
      return;
      paramString = BaseApplicationImpl.getContext().getString(2131691571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhm
 * JD-Core Version:    0.7.0.1
 */