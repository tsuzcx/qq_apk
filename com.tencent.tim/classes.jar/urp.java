import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.CloudFileActivity;
import com.tencent.mobileqq.activity.CloudFileActivity.9.1;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.AutoSaveCloudStateGetPrg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileDirBrowserActivity;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncActivity;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer.SyncState;
import com.tencent.tim.cloudfile.feeds.CloudFeedListActivity;
import com.tencent.tim.cloudfile.wps.WPSListActivity;
import com.tencent.util.BinderWarpper;
import java.util.List;
import mqq.app.MobileQQ;

public class urp
  implements View.OnClickListener
{
  public urp(CloudFileActivity paramCloudFileActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (atio)paramView.getTag();
    int j = ((atio)localObject1).dirType;
    Object localObject2;
    label153:
    label165:
    int i;
    switch (j)
    {
    case 6: 
    default: 
      localObject1 = aueh.a((atin)localObject1);
      ((FileInfo)localObject1).setPath("/" + ((FileInfo)localObject1).getName());
      localObject2 = new Intent(this.this$0.getActivity(), CloudFileDirBrowserActivity.class);
      ((Intent)localObject2).putExtra("key_file_info", (Parcelable)localObject1);
      ((Intent)localObject2).putExtra("key_parent_dir_name", this.this$0.getString(2131691665));
      this.this$0.startActivity((Intent)localObject2);
    case 0: 
    case 1: 
      for (;;)
      {
        ThreadManager.executeOnSubThread(new CloudFileActivity.9.1(this, j));
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.this$0.getActivity().startActivity(new Intent(this.this$0.getActivity(), CloudFeedListActivity.class));
        continue;
        ault.a(this.this$0.getActivity(), this.this$0.app, "s_tim_cloud_folder");
      }
    case 2: 
      if (((atio)localObject1).GW.size() == 0)
      {
        localObject2 = (CardHandler)this.this$0.app.getBusinessHandler(2);
        if (((CardHandler)localObject2).a() == CardHandler.AutoSaveCloudStateGetPrg.GetSuc) {
          if (aqmj.ac(this.this$0.app, "tim_cloudfile_autosave_flag"))
          {
            localObject2 = CloudFileSendRecvSyncer.a().a();
            if ((localObject2 != CloudFileSendRecvSyncer.SyncState.SyncState_gettingsendrecvfiles) && (localObject2 != CloudFileSendRecvSyncer.SyncState.SyncState_syncing)) {
              break label765;
            }
            i = 0;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = aueh.a((atin)localObject1);
        localObject2 = new Intent(this.this$0.getActivity(), CloudFileSendRecvActivity.class);
        ((Intent)localObject2).putExtra("tab_tab_type", 8);
        ((Intent)localObject2).putExtra("key_file_info", (Parcelable)localObject1);
        ((Intent)localObject2).putExtra("send_recv", true);
        this.this$0.startActivity((Intent)localObject2);
        break label153;
        i = 0;
        continue;
        if (((CardHandler)localObject2).a() == CardHandler.AutoSaveCloudStateGetPrg.GetFail) {
          break label765;
        }
        if ((((CardHandler)localObject2).a() == CardHandler.AutoSaveCloudStateGetPrg.NoGet) && (!aqiw.isNetSupport(this.this$0.app.getApplication().getApplicationContext())))
        {
          QQToast.a(this.this$0.app.getApplication().getApplicationContext(), 2131696272, 1).show();
          break label165;
        }
        i = 0;
        continue;
      }
      localObject2 = new Intent(this.this$0.getActivity(), CloudFileSendRecvSyncActivity.class);
      ((Intent)localObject2).putExtra("key_file_info", aueh.a((atin)localObject1));
      this.this$0.startActivity((Intent)localObject2);
      break label153;
      CloudFileActivity.a(this.this$0);
      break label153;
      localObject1 = new Intent(this.this$0.getActivity(), WPSListActivity.class);
      long l = System.currentTimeMillis();
      ((Intent)localObject1).putExtra("url", "https://drive.wps.cn?from=tim&timestamp=" + l);
      ((Intent)localObject1).putExtra("_nick_name_", aqgv.n(this.this$0.app, this.this$0.app.getCurrentUin()));
      ((Intent)localObject1).putExtra("_uin_", this.this$0.app.getCurrentUin());
      localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelable("file_manager_provider", new BinderWarpper(new atwj(this.this$0.app.getCurrentUin()).asBinder()));
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ((Intent)localObject1).addFlags(603979776);
      this.this$0.startActivity((Intent)localObject1);
      break label153;
      localObject1 = (atgc)this.this$0.app.getManager(373);
      localObject2 = CloudFileActivity.a(this.this$0).a(1);
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("key_parent_dir_key", ((atgc)localObject1).aE());
      ((auhk.a)localObject2).setBundle(localBundle);
      ((auhk.a)localObject2).show();
      break label153;
      this.this$0.a.aal(6);
      auen.euK();
      break;
      label765:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     urp
 * JD-Core Version:    0.7.0.1
 */