import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiAppPanel;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class vqs
  implements Runnable
{
  vqs(vqn paramvqn, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_JavaLangString.equals("input")) {
      if ((BaseActivity.sTopActivity instanceof FragmentActivity))
      {
        localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
        if (localObject1 != null)
        {
          localObject1 = ((ChatFragment)localObject1).a();
          if (localObject1 != null)
          {
            localObject2 = ((ArkAppCenter)this.jdField_a_of_type_Vqn.a.a.a.getManager(120)).a().a(ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a), null);
            ArrayList localArrayList = new ArrayList();
            ArkAiInfo localArkAiInfo = new ArkAiInfo();
            localArkAiInfo.jdField_a_of_type_JavaLangString = ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a);
            localArkAiInfo.d = ((String)localObject2);
            localArkAiInfo.f = this.b;
            localArkAiInfo.b = this.c;
            localArrayList.add(localArkAiInfo);
            ((BaseChatPie)localObject1).a.a(localArrayList, 0);
          }
        }
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaLangString.equals("popup"))
      {
        localObject1 = BaseActivity.sTopActivity;
        if (!(localObject1 instanceof FragmentActivity)) {
          continue;
        }
        localObject2 = QQCustomArkDialog.AppInfo.a(ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a), this.c, "0.0.0.1", this.b, ((BaseActivity)localObject1).getResources().getDisplayMetrics().scaledDensity, null, null);
        ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a, DialogUtil.a((Context)localObject1, null, (Bundle)localObject2));
        ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a).setNegativeButton(2131433015, null);
        ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a).setPositiveButton(2131433016, null);
        ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a).show();
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.equals("input"))
      {
        localObject1 = new ArrayList();
        localObject2 = new ArkAiInfo();
        ((ArkAiInfo)localObject2).jdField_a_of_type_JavaLangString = ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a);
        ((ArkAiInfo)localObject2).b = this.c;
        ((ArkAiInfo)localObject2).f = this.b;
        ((ArkAiInfo)localObject2).d = ArkDebugChatPie.b(this.jdField_a_of_type_Vqn.a.a);
        ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a, new ArkAiAppPanel(this.jdField_a_of_type_Vqn.a.a));
        ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a).a((List)localObject1, 0, null);
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.equals("card"))
      {
        localObject1 = new ArkAppMessage();
        ((ArkAppMessage)localObject1).appMinVersion = "0.0.0.1";
        ((ArkAppMessage)localObject1).appName = ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a);
        ((ArkAppMessage)localObject1).appView = this.c;
        localObject2 = ArkAppCenter.a(((ArkAppMessage)localObject1).appName, ((ArkAppMessage)localObject1).appMinVersion);
        if (localObject2 != null)
        {
          ((ArkAppMessage)localObject1).appDesc = ((String)((Map)localObject2).get("desc"));
          ((ArkAppMessage)localObject1).appMinVersion = ((String)((Map)localObject2).get("version"));
        }
        if (TextUtils.isEmpty(((ArkAppMessage)localObject1).appDesc)) {
          ((ArkAppMessage)localObject1).appDesc = ((ArkAppMessage)localObject1).appName;
        }
        ((ArkAppMessage)localObject1).promptText = String.format("[应用]%s", new Object[] { ((ArkAppMessage)localObject1).appDesc });
        ((ArkAppMessage)localObject1).metaList = this.b;
        localObject2 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject2).put("forward", 1);
        ((JSONObject)localObject2).put("autosize", 1);
        ((JSONObject)localObject2).put("type", "card");
        label622:
        ((ArkAppMessage)localObject1).config = ((JSONObject)localObject2).toString();
        localObject2 = this.jdField_a_of_type_Vqn.a.a.a();
        if (localObject2 == null) {
          continue;
        }
        ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a, (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject2, (ArkAppMessage)localObject1);
        return;
        if (!(BaseActivity.sTopActivity instanceof FragmentActivity)) {
          continue;
        }
        localObject1 = (FragmentActivity)BaseActivity.sTopActivity;
        ArkAppDataReport.k(null, ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a));
        ArkFullScreenAppActivity.a((Context)localObject1, ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a), this.c, "0.0.0.1", this.b, ((FragmentActivity)localObject1).getResources().getDisplayMetrics().scaledDensity, null, 0);
        return;
      }
      catch (Exception localException)
      {
        break label622;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqs
 * JD-Core Version:    0.7.0.1
 */