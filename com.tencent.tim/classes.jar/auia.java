import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.filemanager.activity.FMActivity;
import java.util.Iterator;
import java.util.List;

public class auia
  extends augy
  implements auhk.c
{
  private byte[] cA;
  private String dirName;
  
  public auia(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, auhk.b paramb)
  {
    super(paramInt, paramQQAppInterface, paramContext, paramb);
  }
  
  public void a(int paramInt, ResolveInfo paramResolveInfo)
  {
    if (paramInt == 0) {
      gg(this.context);
    }
    Intent localIntent;
    Fragment localFragment;
    do
    {
      do
      {
        return;
        while (paramInt == 2) {}
        localIntent = new Intent("android.intent.action.GET_CONTENT");
        localIntent.setFlags(localIntent.getFlags() & 0xFDFFFFFF);
        localIntent.setComponent(new ComponentName(paramResolveInfo.activityInfo.applicationInfo.packageName, paramResolveInfo.activityInfo.name));
        if ("cn.wps.moffice_eng".equals(paramResolveInfo.activityInfo.applicationInfo.packageName)) {
          localIntent.putExtra("pkg_name", BaseApplicationImpl.sApplication.getPackageName());
        }
        paramResolveInfo = ((FragmentActivity)this.context).getSupportFragmentManager().getFragments();
        if ((paramResolveInfo == null) || (paramResolveInfo.size() <= 0)) {
          break;
        }
        paramResolveInfo = paramResolveInfo.iterator();
      } while (!paramResolveInfo.hasNext());
      localFragment = (Fragment)paramResolveInfo.next();
    } while ((localFragment == null) || (!localFragment.isVisible()));
    localFragment.startActivityForResult(localIntent, 5);
    return;
    ((Activity)this.context).startActivityForResult(localIntent, 5);
  }
  
  public void euV() {}
  
  public void gg(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, FMActivity.class);
    localIntent.putExtra("from_aio", false);
    localIntent.putExtra("from_cloud_file", true);
    localIntent.addFlags(536870912);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("only_show_local_tab", true);
    localIntent.putExtra("busiType", 7);
    localIntent.putExtra("tab_tab_type", 1);
    localIntent.putExtra("max_select_count", 20);
    localIntent.putExtra("is_using_cloud_bottom_bar", true);
    localIntent.putExtra("key_bottom_bar_left_action", 0);
    localIntent.putExtra("key_bottom_bar_right_action", 0);
    localIntent.putExtra("qfile_selecter_entrance_type", 0);
    localIntent.putExtra("key_parent_dir_key", this.cA);
    if (this.dirName != null) {
      localIntent.putExtra("key_parent_dir_name", this.dirName);
    }
    localIntent.addFlags(536870912);
    ((Activity)paramContext).overridePendingTransition(2130771991, 2130771992);
    Object localObject = ((FragmentActivity)paramContext).getSupportFragmentManager().getFragments();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramContext = ((List)localObject).iterator();
      while (paramContext.hasNext())
      {
        localObject = (Fragment)paramContext.next();
        if ((localObject != null) && (((Fragment)localObject).isVisible())) {
          ((Fragment)localObject).startActivityForResult(localIntent, 0);
        }
      }
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2130771991, 2130771992);
    ((Activity)paramContext).startActivityForResult(localIntent, 0);
  }
  
  public void setBundle(Bundle paramBundle)
  {
    super.setBundle(paramBundle);
    this.cA = paramBundle.getByteArray("key_parent_dir_key");
    this.dirName = paramBundle.getString("key_parent_dir_name");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auia
 * JD-Core Version:    0.7.0.1
 */