import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.cloudfile.CloudAIORecentFileExt;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.tim.teamwork.PadInfo;

public class amod
  implements ampx
{
  private QQAppInterface app;
  public String keyword;
  public FileManagerEntity q;
  
  public amod(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private String a(CloudAIORecentFileExt paramCloudAIORecentFileExt)
  {
    if (paramCloudAIORecentFileExt == null) {
      return "我";
    }
    String str1 = String.valueOf(paramCloudAIORecentFileExt.peerUin);
    String str2 = String.valueOf(paramCloudAIORecentFileExt.creatorUin);
    int i = paramCloudAIORecentFileExt.fileSourceType;
    if ((TextUtils.isEmpty(str1)) || (i == 1)) {
      return "我";
    }
    if (i == 2) {
      return aqgv.b(this.app, str1, true);
    }
    if (((i == 3) || (i == 4)) && (!TextUtils.isEmpty(str2))) {
      return aqgv.b(this.app, str2, true);
    }
    return "我";
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public void cR(View paramView)
  {
    amxk.a(this.keyword, 120, 0, paramView);
    if (this.q == null) {}
    do
    {
      return;
      if (this.q.getCloudFileType() == 0)
      {
        if (this.q.nSessionId == 0L) {
          this.q.nSessionId = audx.d().longValue();
        }
        this.app.a().v(this.q);
        localObject1 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject1).Oj(9);
        ((ForwardFileInfo)localObject1).setType(10001);
        ((ForwardFileInfo)localObject1).setFileName(this.q.fileName);
        ((ForwardFileInfo)localObject1).setFileSize(this.q.fileSize);
        ((ForwardFileInfo)localObject1).bg(this.q.cloudFile.pLogicDirKey);
        ((ForwardFileInfo)localObject1).bf(this.q.cloudFile.cloudId);
        ((ForwardFileInfo)localObject1).p(this.q.nSessionId);
        paramView = (BaseActivity)paramView.getContext();
        localObject2 = new Intent(paramView, FileBrowserActivity.class);
        ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject1);
        paramView.startActivityForResult((Intent)localObject2, 102);
        return;
      }
    } while (this.q.getCloudFileType() != 2);
    Object localObject1 = athu.a(this.q);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("url", jpa.r(((PadInfo)localObject1).pad_url, "_bid=2517"));
    ((Bundle)localObject2).putInt("key_team_work_edit_type", ((PadInfo)localObject1).type);
    ((Bundle)localObject2).putString("key_team_work_title", ((PadInfo)localObject1).title);
    ((Bundle)localObject2).putString("key_team_work_rul", ((PadInfo)localObject1).pad_url);
    ((Bundle)localObject2).putInt("key_team_work_pad_list_type", ((PadInfo)localObject1).type_list);
    ((Bundle)localObject2).putString("tdsourcetag", "s_tim_cloud_folder");
    TeamWorkDocEditBrowserActivity.a(paramView.getContext(), (Bundle)localObject2, true);
  }
  
  public void cW(int paramInt1, int paramInt2) {}
  
  public CharSequence f()
  {
    if (this.q == null) {
      return null;
    }
    String str = a(this.q.cloudFile.aioRecentFileExt);
    str = String.format(this.app.getApp().getResources().getString(2131691668), new Object[] { str });
    return auqb.bG(this.q.getSortTime()) + " " + str + " " + athu.c((float)this.q.fileSize);
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    return null;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    if (this.q == null) {
      return null;
    }
    return amxk.a(this.q.fileName.toLowerCase(), this.keyword);
  }
  
  public String getUin()
  {
    return "##addfiles##";
  }
  
  public int pE()
  {
    return 0;
  }
  
  public int pF()
  {
    return 0;
  }
  
  public int pG()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amod
 * JD-Core Version:    0.7.0.1
 */