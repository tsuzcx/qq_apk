import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.UUID;

final class atxm
  implements View.OnClickListener
{
  atxm(Activity paramActivity, agsa paramagsa, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      Object localObject2 = new audw.b();
      ((audw.b)localObject2).bJE = "file_forward";
      ((audw.b)localObject2).cYX = 9;
      audw.a(((QQAppInterface)localObject1).getCurrentAccountUin(), (audw.b)localObject2);
      if (aqiw.getSystemNetwork(this.val$activity) == 0)
      {
        apsd.ck(this.val$activity, this.c.getActivity().getString(2131699827));
        label69:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      localObject2 = new FileManagerEntity();
      ((FileManagerEntity)localObject2).copyFrom(this.k);
      ((FileManagerEntity)localObject2).nSessionId = audx.d().longValue();
      ((FileManagerEntity)localObject2).status = 2;
      if (localObject1 != null) {
        ((QQAppInterface)localObject1).a().v((FileManagerEntity)localObject2);
      }
      localObject1 = apsv.a((QQAppInterface)localObject1, (FileManagerEntity)localObject2);
      Object localObject3 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject3).p(((FileManagerEntity)localObject2).nSessionId);
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).getFilePath())) {
        ((ForwardFileInfo)localObject3).setLocalPath(((apcy)localObject1).LocalFile);
      }
      ((ForwardFileInfo)localObject3).setFileName(((apcy)localObject1).FileName);
      ((ForwardFileInfo)localObject3).setFileSize(((apcy)localObject1).ProgressTotal);
      ((ForwardFileInfo)localObject3).jA(((FileManagerEntity)localObject2).TroopUin);
      if (((FileManagerEntity)localObject2).isZipInnerFile)
      {
        ((ForwardFileInfo)localObject3).setType(10000);
        ((ForwardFileInfo)localObject3).Oj(3);
      }
      for (;;)
      {
        ((ForwardFileInfo)localObject3).Oh(2);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("forward_type", 0);
        ((Bundle)localObject2).putParcelable("fileinfo", (Parcelable)localObject3);
        ((Bundle)localObject2).putBoolean("not_forward", true);
        localObject3 = new Intent();
        ((Intent)localObject3).putExtras((Bundle)localObject2);
        ((Intent)localObject3).putExtra("forward_text", ((apcy)localObject1).FileName);
        ((Intent)localObject3).putExtra("forward_from_troop_file", true);
        ahgq.f(this.val$activity, (Intent)localObject3, 103);
        break;
        if (((apcy)localObject1).Id != null) {
          ((ForwardFileInfo)localObject3).Ja(((apcy)localObject1).Id.toString());
        }
        ((ForwardFileInfo)localObject3).setType(10006);
        ((ForwardFileInfo)localObject3).Oj(4);
      }
    }
    catch (Exception localException)
    {
      break label69;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxm
 * JD-Core Version:    0.7.0.1
 */