import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileListFragment;
import com.tencent.tim.cloudfile.CloudFileListFragment.3.1;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;
import com.tencent.tim.cloudfile.feeds.CloudFeedListActivity;
import com.tencent.tim.fragment.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.Arrays;

public class atfv
  implements View.OnClickListener
{
  public atfv(CloudFileListFragment paramCloudFileListFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (atjv.a)paramView.getTag();
    atiu localatiu = ((atjv.a)localObject1).a;
    Object localObject2 = (atgc)CloudFileListFragment.c(this.this$0).getManager(373);
    if (localatiu.getCloudFileType() == 1) {
      if ((((atin)((atjv.a)localObject1).a).Y() != null) && (!Arrays.equals(((atin)((atjv.a)localObject1).a).Y(), ((atgc)localObject2).aF())))
      {
        localObject1 = aueh.a((atin)((atjv.a)localObject1).a);
        localObject2 = this.this$0.getArguments();
        ((Bundle)localObject2).putParcelable("key_file_info", (Parcelable)localObject1);
        ((Bundle)localObject2).putBoolean("key_top_level_dir", false);
        if (CloudFileListFragment.a(this.this$0) != null) {
          ((Bundle)localObject2).putString("key_parent_dir_name", CloudFileListFragment.a(this.this$0).getName());
        }
        ((BaseFragmentActivity)this.this$0.getActivity()).a(CloudFileListFragment.class, (Bundle)localObject2, ((FileInfo)localObject1).getName(), true);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new CloudFileListFragment.3.1(this, localatiu.getCloudFileType()));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((((atin)((atjv.a)localObject1).a).Y() != null) && (Arrays.equals(((atin)((atjv.a)localObject1).a).Y(), ((atgc)localObject2).aF())))
      {
        localObject1 = aueh.a((atin)((atjv.a)localObject1).a);
        localObject2 = new Intent(this.this$0.getActivity(), CloudFileSendRecvActivity.class);
        ((Intent)localObject2).putExtra("tab_tab_type", 8);
        ((Intent)localObject2).putExtra("key_file_info", (Parcelable)localObject1);
        ((Intent)localObject2).putExtra("send_recv", false);
        ((Intent)localObject2).putExtra("key_bottom_bar_left_action", 2);
        ((Intent)localObject2).putExtra("key_bottom_bar_right_action", CloudFileListFragment.a(this.this$0));
        this.this$0.startActivityForResult((Intent)localObject2, 10);
      }
      else if (((atin)((atjv.a)localObject1).a).name.equals("全部文件"))
      {
        localObject1 = new Intent(this.this$0.getActivity(), CloudFeedListActivity.class);
        localObject2 = this.this$0.getArguments();
        ((Bundle)localObject2).putBoolean("key_is_from_aio_cloud_selector", true);
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        this.this$0.startActivityForResult((Intent)localObject1, 6);
      }
      else if (((atin)((atjv.a)localObject1).a).name.equals("腾讯文档"))
      {
        localObject1 = (SessionInfo)this.this$0.getActivity().getIntent().getParcelableExtra("sessioninfo");
        ault.a(CloudFileListFragment.d(this.this$0), this.this$0.getActivity(), ((SessionInfo)localObject1).aTl, ((SessionInfo)localObject1).cZ, ((SessionInfo)localObject1).aTn);
        continue;
        if (localatiu.getCloudFileType() == 2)
        {
          athu.a(CloudFileListFragment.e(this.this$0), this.this$0.getActivity(), localatiu);
        }
        else if (localatiu.getCloudFileType() == 0)
        {
          localObject1 = athu.a(CloudFileListFragment.f(this.this$0), CloudFileListFragment.a(this.this$0));
          athu.a(CloudFileListFragment.g(this.this$0), this.this$0.getActivity(), localatiu, (ArrayList)localObject1);
        }
        else if (localatiu.getCloudFileType() == 8)
        {
          localObject1 = (SessionInfo)this.this$0.getActivity().getIntent().getParcelableExtra("sessioninfo");
          auel.a(CloudFileListFragment.h(this.this$0), this.this$0.getActivity(), (SessionInfo)localObject1, 2);
        }
        else if (localatiu.getCloudFileType() == 11)
        {
          localObject1 = (SessionInfo)this.this$0.getActivity().getIntent().getParcelableExtra("sessioninfo");
          auel.a(CloudFileListFragment.i(this.this$0), this.this$0.getActivity(), (SessionInfo)localObject1, 1);
        }
        else if (localatiu.getCloudFileType() == 12)
        {
          localObject1 = (SessionInfo)this.this$0.getActivity().getIntent().getParcelableExtra("sessioninfo");
          auel.a(CloudFileListFragment.j(this.this$0), this.this$0.getActivity(), (SessionInfo)localObject1, 7);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfv
 * JD-Core Version:    0.7.0.1
 */