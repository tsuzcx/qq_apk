package com.tencent.mobileqq.ark.API;

import android.graphics.Rect;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.ark.ark;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import rpq;
import wki;

class ArkAppNotifyCenter$GdtNotify$1
  implements Runnable
{
  ArkAppNotifyCenter$GdtNotify$1(ArkAppNotifyCenter.a parama, JSONObject paramJSONObject, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      JSONObject localJSONObject1;
      try
      {
        Object localObject1 = (FragmentActivity)BaseActivity.sTopActivity;
        if (((FragmentActivity)localObject1).getChatFragment() == null) {
          break label575;
        }
        Object localObject2 = ((FragmentActivity)localObject1).getChatFragment();
        if (((ChatFragment)localObject2).b == null) {
          break label474;
        }
        localObject1 = ((ChatFragment)localObject2).b.b;
        JSONArray localJSONArray1 = new JSONArray();
        this.br.put("results", localJSONArray1);
        localObject2 = ((ChatFragment)localObject2).b.a.getList();
        JSONArray localJSONArray2 = new JSONObject(this.val$params).optJSONArray("traceids");
        if (i >= localJSONArray2.length()) {
          break label524;
        }
        Object localObject3 = localJSONArray2.optString(i);
        Object localObject4 = ArkAppNotifyCenter.access$200((List)localObject2, (String)localObject3);
        if (localObject4 == null) {
          break label628;
        }
        JSONObject localJSONObject2 = new JSONObject();
        localJSONArray1.put(localJSONObject2);
        localJSONObject1 = new JSONObject();
        localJSONObject2.put("traceid", localObject3);
        localJSONObject2.put("rect", localJSONObject1);
        localObject3 = ArkAppNotifyCenter.access$300((ChatMessage)localObject4, (ChatXListView)localObject1);
        if (localObject3 == null) {
          break label435;
        }
        localObject3 = (ArkAppView)((View)localObject3).findViewById(2131362952);
        if (localObject3 == null) {
          break label396;
        }
        localObject4 = ArkAppNotifyCenter.access$400((View)localObject3);
        if (localObject4 != null)
        {
          localJSONObject1.put("left", rpq.b(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).left));
          localJSONObject1.put("top", rpq.b(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).top));
          localJSONObject1.put("right", rpq.b(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).right));
          localJSONObject1.put("bottom", rpq.b(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).bottom));
        }
      }
      catch (Exception localException)
      {
        QLog.d("ark.ArkAppNotifyCenter", 2, "resultJson 3: " + this.br.toString());
        ark.arkNotify(this.val$appName, "ad_query_cell_rect_callback", this.br.toString(), "json");
        return;
      }
      localJSONObject1.put("left", 0);
      localJSONObject1.put("top", 0);
      localJSONObject1.put("right", 0);
      localJSONObject1.put("bottom", 0);
      break label628;
      label396:
      localJSONObject1.put("left", 0);
      localJSONObject1.put("top", 0);
      localJSONObject1.put("right", 0);
      localJSONObject1.put("bottom", 0);
      break label628;
      label435:
      localJSONObject1.put("left", 0);
      localJSONObject1.put("top", 0);
      localJSONObject1.put("right", 0);
      localJSONObject1.put("bottom", 0);
      break label628;
      label474:
      QLog.d("ark.ArkAppNotifyCenter", 2, "resultJson 0: " + this.br.toString());
      ark.arkNotify(this.val$appName, "ad_query_cell_rect_callback", this.br.toString(), "json");
      for (;;)
      {
        label524:
        QLog.d("ark.ArkAppNotifyCenter", 2, "resultJson 2: " + this.br.toString());
        ark.arkNotify(this.val$appName, "ad_query_cell_rect_callback", this.br.toString(), "json");
        return;
        label575:
        QLog.d("ark.ArkAppNotifyCenter", 2, "resultJson 1: " + this.br.toString());
        ark.arkNotify(this.val$appName, "ad_query_cell_rect_callback", this.br.toString(), "json");
      }
      label628:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.1
 * JD-Core Version:    0.7.0.1
 */