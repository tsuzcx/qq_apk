import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.CloudFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.FileShowListActivity;
import com.tencent.tim.cloudfile.wps.WPSListActivity;
import com.tencent.util.BinderWarpper;
import java.util.List;

public class uri
  implements AdapterView.OnItemClickListener
{
  public uri(CloudFileActivity paramCloudFileActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (((atec)this.this$0.a.hm().get(paramInt)).blx)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      Object localObject = new Intent(this.this$0.getActivity(), FileShowListActivity.class);
      this.this$0.startActivityForResult((Intent)localObject, 107);
      anpc.report("tim_mine_tab_file_click_recent_file_click");
      continue;
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("string_from", false);
      ((Bundle)localObject).putBoolean("string_uin", false);
      ((Bundle)localObject).putLong("device_din", 0L);
      ((Bundle)localObject).putInt("sTitleID", 0);
      avio.b(this.this$0.getActivity(), (Bundle)localObject, "com.qqdataline.mpfile.LiteMpFileMainActivity");
      anpc.report("tim_mine_tab_file_click_connect_com_click");
      continue;
      CloudFileActivity.b(this.this$0);
      anpc.report("tim_mine_tab_file_click_local_file_click");
      continue;
      CloudFileActivity.c(this.this$0);
      afdp.p(this.this$0.getAppInterface());
      anpc.report("tim_mine_tab_file_click_tencent_file_click");
      continue;
      CloudFileActivity.a(this.this$0);
      anpc.report("tim_mine_tab_file_click_tencent_cloud_click");
      continue;
      localObject = new Intent(this.this$0.getActivity(), WPSListActivity.class);
      long l = System.currentTimeMillis();
      ((Intent)localObject).putExtra("url", "https://drive.wps.cn?from=tim&timestamp=" + l);
      ((Intent)localObject).putExtra("_nick_name_", aqgv.n(this.this$0.app, this.this$0.app.getCurrentUin()));
      ((Intent)localObject).putExtra("_uin_", this.this$0.app.getCurrentUin());
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("file_manager_provider", new BinderWarpper(new atwj(this.this$0.app.getCurrentUin()).asBinder()));
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).addFlags(603979776);
      this.this$0.startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uri
 * JD-Core Version:    0.7.0.1
 */