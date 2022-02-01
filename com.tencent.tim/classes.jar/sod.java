import android.app.Activity;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.biz.troopplugin.PluginJumpManager.a;
import com.tencent.biz.troopplugin.PluginJumpManager.b;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;

public class sod
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public sod(PluginJumpManager paramPluginJumpManager, PluginJumpManager.a parama, Activity paramActivity, String paramString1, String paramString2, String paramString3, long paramLong, PluginJumpManager.b paramb, String paramString4) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager = paramPluginManagerClient;
    paramPluginManagerClient = this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager.queryPlugin(this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$a.aFn);
    int i;
    if (paramPluginManagerClient != null) {
      if (paramPluginManagerClient.mState == 4)
      {
        i = 1;
        this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.launchPlugin(this.val$activity, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$a.aFn, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$a.pluginName, this.val$uin, this.val$url, this.val$skey, this.val$beginTime, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$b.activity, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$b.aMn);
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.openLinkInNewWebView(this.val$activity, this.val$url, this.aFm);
      }
      return;
      PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 0, this.val$url, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$b.activity, null, null);
      this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager.installPlugin(this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$a.aFn);
      i = 0;
      continue;
      PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 1, this.val$url, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$b.activity, null, null);
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sod
 * JD-Core Version:    0.7.0.1
 */