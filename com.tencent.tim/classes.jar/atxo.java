import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class atxo
  implements View.OnClickListener
{
  atxo(agsa paramagsa, FileManagerEntity paramFileManagerEntity, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    auen.bl(this.d.getApp(), "0X8008B71");
    if ((this.b == null) || (this.val$activity == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str = this.b.strFilePath;
    Object localObject1 = this.b;
    Object localObject2 = this.b.Uuid;
    localObject1 = new Bundle();
    if ((this.b.cloudFile != null) && (this.b.cloudFile.cloudId != null) && (this.b.cloudFile.cloudId.length > 0) && (this.b.cloudFile.pLogicDirKey != null) && (this.b.cloudFile.pLogicDirKey.length > 0) && (!TextUtils.isEmpty(this.b.cloudFile.showName)) && (TextUtils.isEmpty(this.b.peerUin)))
    {
      i = 6;
      ((Bundle)localObject1).putByteArray("Cloud_FileId", this.b.cloudFile.cloudId);
      ((Bundle)localObject1).putByteArray("Cloud_DirKey", this.b.cloudFile.pLogicDirKey);
      ((Bundle)localObject1).putString("Cloud_FileName", this.b.cloudFile.showName);
    }
    for (;;)
    {
      ((Bundle)localObject1).putInt("busType", i);
      ((Bundle)localObject1).putLong("WpsCloud_Entity_Sessionid", this.b.nSessionId);
      localObject2 = new Bundle();
      auen.a(this.val$activity, str, (Bundle)localObject1, (Bundle)localObject2);
      break;
      if (!TextUtils.isEmpty(this.b.peerUin)) {
        if (this.b.peerType == 0)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((Bundle)localObject1).putString("FileUuid", (String)localObject2);
          }
        }
        else if (this.b.peerType == 3000)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            i = 3;
            ((Bundle)localObject1).putString("DiscFileId", (String)localObject2);
          }
        }
        else if ((this.b.peerType == 1) && (!TextUtils.isEmpty(this.b.strTroopFileID)))
        {
          i = 2;
          ((Bundle)localObject1).putString("GroupFileId", this.b.strTroopFileID);
          continue;
        }
      }
      i = 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxo
 * JD-Core Version:    0.7.0.1
 */