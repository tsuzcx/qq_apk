import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aypw
  implements View.OnClickListener
{
  public aypw(PermissionSettingActivity paramPermissionSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    Object localObject = PermissionSettingActivity.a(this.a).a();
    int i = 10000;
    if (localObject != null)
    {
      i = ((aypv)localObject).tC();
      ram.b("Q.qqstory.QQStoryBaseActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
      localIntent.putExtra("PERMISSION_TYPE_KEY", i);
      localIntent.putExtra("PERMISSION_CURRENT_UIN_KEY", PermissionSettingActivity.a(this.a));
      switch (i)
      {
      }
    }
    for (;;)
    {
      PermissionSettingActivity.a(this.a, i);
      this.a.setResult(1, localIntent);
      this.a.finish();
      ArrayList localArrayList;
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localArrayList = new ArrayList();
        localObject = ((aypr)localObject).cf();
        if (!((List)localObject).isEmpty()) {
          break;
        }
        ram.w("Q.qqstory.QQStoryBaseActivity", "onCompleteBtnClick, empty friend list.");
        QQToast.a(this.a, acfp.m(2131709448), 0).show();
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((aypr.a)((Iterator)localObject).next()).getUin());
      }
      localIntent.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      ram.b("Q.qqstory.QQStoryBaseActivity", "select uin list:%s", localArrayList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypw
 * JD-Core Version:    0.7.0.1
 */