import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class smt
  implements View.OnClickListener
{
  smt(sms paramsms) {}
  
  public void onClick(View paramView)
  {
    Object localObject4 = (sms.a)paramView.getTag();
    Object localObject1;
    if (((sms.a)localObject4).a.isDir)
    {
      localObject1 = new Intent(this.a.context, TroopFileZipPreviewActivity.class);
      ((Intent)localObject1).putExtra("str_download_dns", this.a.str_download_dns);
      ((Intent)localObject1).putExtra("int32_server_port", this.a.aEI);
      ((Intent)localObject1).putExtra("string_download_url", this.a.aEJ);
      ((Intent)localObject1).putExtra("str_cookie_val", this.a.aEK);
      ((Intent)localObject1).putExtra("filepath", this.a.filePath + ((sms.a)localObject4).a.name);
      ((Intent)localObject1).putExtra("filename", "" + ((sms.a)localObject4).a.name);
      ((Intent)localObject1).putExtra("nSessionId", this.a.nSessionId);
      ((Intent)localObject1).putExtra("isHttps", sms.a(this.a));
      if (!TextUtils.isEmpty(sms.a(this.a))) {
        ((Intent)localObject1).putExtra("httpsDomain", sms.a(this.a));
      }
      ((Intent)localObject1).putExtra("httpsPort", sms.a(this.a));
      ((Intent)localObject1).putExtra("troop_uin", this.a.troopUin);
      this.a.context.startActivityForResult((Intent)localObject1, 10099);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.p(((sms.a)localObject4).a.sessionId);
      localForwardFileInfo.setFileName(((sms.a)localObject4).a.name);
      localForwardFileInfo.setFileSize(((sms.a)localObject4).a.size);
      localForwardFileInfo.setUuid("");
      Object localObject3;
      Object localObject2;
      if (this.a.troopUin == 0L)
      {
        localObject3 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        Object localObject5 = ((QQAppInterface)localObject3).a().c(((sms.a)localObject4).a.sessionId);
        localObject2 = ((QQAppInterface)localObject3).a().e(((FileManagerEntity)localObject5).zipInnerPath);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((QQAppInterface)localObject3).a().a((String)((FileManagerEntity)localObject5).mContext, ((FileManagerEntity)localObject5).zipInnerPath);
        }
        if (localObject1 != null)
        {
          ((sms.a)localObject4).a.sessionId = ((FileManagerEntity)localObject1).nSessionId;
          ((FileManagerEntity)localObject1).isZipInnerFile = true;
        }
        localForwardFileInfo.p(((sms.a)localObject4).a.sessionId);
        if (localForwardFileInfo.getFileSize() == 0L)
        {
          ahao.JD(acfp.m(2131717005));
        }
        else
        {
          localObject4 = new ArrayList();
          localObject5 = this.a.pw.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            agxi.a locala = (agxi.a)((Iterator)localObject5).next();
            if ((ahav.getFileType(locala.name) == 0) && (locala.size != 0L))
            {
              FileManagerEntity localFileManagerEntity = ((QQAppInterface)localObject3).a().c(locala.sessionId);
              localObject2 = ((QQAppInterface)localObject3).a().e(localFileManagerEntity.zipInnerPath);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = ((QQAppInterface)localObject3).a().a((String)localFileManagerEntity.mContext, localFileManagerEntity.zipInnerPath);
              }
              if (localObject1 != null)
              {
                ((FileManagerEntity)localObject1).mContext = localFileManagerEntity.mContext;
                locala.sessionId = ((FileManagerEntity)localObject1).nSessionId;
              }
              ((ArrayList)localObject4).add(Long.valueOf(locala.sessionId));
            }
          }
          localForwardFileInfo.eo((ArrayList)localObject4);
          localForwardFileInfo.Oj(1);
          localForwardFileInfo.setType(10001);
          localObject1 = new Intent(this.a.context, FileBrowserActivity.class);
          ((Intent)localObject1).putExtra("fileinfo", localForwardFileInfo);
          ((Intent)localObject1).putExtra("last_time", 0);
          ((Intent)localObject1).putExtra("is_in_zip", true);
          this.a.context.startActivity((Intent)localObject1);
        }
      }
      else
      {
        localObject1 = new ArrayList();
        localObject2 = this.a.pw.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (agxi.a)((Iterator)localObject2).next();
          if (ahav.getFileType(((agxi.a)localObject3).name) == 0) {
            ((ArrayList)localObject1).add(Long.valueOf(((agxi.a)localObject3).sessionId));
          }
        }
        localForwardFileInfo.eo((ArrayList)localObject1);
        localForwardFileInfo.Oj(4);
        localForwardFileInfo.setType(10000);
        localObject1 = new Intent(this.a.context, TroopFileDetailBrowserActivity.class);
        ((Intent)localObject1).putExtra("fileinfo", localForwardFileInfo);
        ((Intent)localObject1).putExtra("forward_from_troop_file", true);
        ((Intent)localObject1).putExtra("not_forward", true);
        ((Intent)localObject1).putExtra("last_time", 0);
        ((Intent)localObject1).putExtra("is_in_zip", true);
        this.a.context.startActivity((Intent)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smt
 * JD-Core Version:    0.7.0.1
 */