import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.cloudfile.CloudAIORecentFileExt;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.tim.teamwork.PadInfo;

public class amoc
  implements ampx
{
  private QQAppInterface app;
  public String keyword;
  public FileManagerEntity q;
  
  public amoc(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private String ne(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject1;
    if (TextUtils.isEmpty(this.keyword)) {
      localObject1 = aqgv.b(this.app, paramString, false);
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = aqgv.b(this.app, paramString, false);
      }
      return localObject2;
      localObject1 = ((acff)this.app.getManager(51)).e(paramString);
      if (localObject1 != null)
      {
        if ((!TextUtils.isEmpty(((Friends)localObject1).remark)) && (((Friends)localObject1).remark.toLowerCase().contains(this.keyword.toLowerCase())))
        {
          localObject1 = ((Friends)localObject1).remark;
          continue;
        }
        if ((!TextUtils.isEmpty(((Friends)localObject1).name)) && (((Friends)localObject1).name.toLowerCase().contains(this.keyword.toLowerCase())))
        {
          localObject1 = ((Friends)localObject1).name;
          continue;
        }
        if ((!TextUtils.isEmpty(((Friends)localObject1).alias)) && (((Friends)localObject1).alias.toLowerCase().contains(this.keyword.toLowerCase())))
        {
          localObject1 = ((Friends)localObject1).alias;
          continue;
        }
      }
      localObject1 = "";
    }
  }
  
  private String nf(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "群聊";
    }
    paramString = ((acdu)this.app.getManager(53)).a(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.discussionName))) {}
    for (paramString = paramString.discussionName;; paramString = "群聊") {
      return paramString;
    }
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
    ((Bundle)localObject2).putString("tdsourcetag", "s_tim_aiomsg");
    TeamWorkDocEditBrowserActivity.a(paramView.getContext(), (Bundle)localObject2, true);
  }
  
  public void cW(int paramInt1, int paramInt2) {}
  
  public CharSequence f()
  {
    if (this.q == null) {
      return null;
    }
    return auqb.bG(this.q.getSortTime());
  }
  
  public CharSequence g()
  {
    return athu.c((float)this.q.fileSize);
  }
  
  public CharSequence getDescription()
  {
    Object localObject = "";
    if ((this.q == null) || (this.q.cloudFile == null) || (this.q.cloudFile.aioRecentFileExt == null)) {
      return "";
    }
    String str = String.valueOf(this.q.cloudFile.aioRecentFileExt.peerUin);
    int i = this.q.cloudFile.aioRecentFileExt.fileSourceType;
    if (i == 2) {
      localObject = ne(str);
    }
    CharSequence localCharSequence;
    for (;;)
    {
      str = "来自于";
      if (this.q.cloudFile.aioRecentFileExt.fileTransferType == 1) {
        str = "发送给";
      }
      localCharSequence = amxk.a((String)localObject, this.keyword, 20);
      if (!(localCharSequence instanceof SpannableStringBuilder)) {
        break;
      }
      localObject = (SpannableStringBuilder)amxk.a((String)localObject, this.keyword);
      ((SpannableStringBuilder)localObject).insert(0, str);
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#888888")), 0, 3, 33);
      return localObject;
      if (i == 3) {
        localObject = nf(str);
      }
    }
    if ((localCharSequence instanceof String)) {
      return str + localCharSequence;
    }
    return str + (String)localObject;
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
    return amxk.a(this.q.fileName, this.keyword);
  }
  
  public String getUin()
  {
    return "##aiotransfer##";
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
 * Qualified Name:     amoc
 * JD-Core Version:    0.7.0.1
 */