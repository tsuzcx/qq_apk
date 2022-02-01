import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.viola.vinstance.VInstanceAction.VInstanceEventListener;
import com.tencent.viola.vinstance.VInstanceManager;
import com.tencent.viola.vinstance.VInstanceManager.Builder;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class nxq
{
  private static volatile boolean isInit;
  private Map<String, Integer> eS = new ArrayMap();
  
  private static boolean Gn()
  {
    return !kzv.Bp();
  }
  
  private void b(ViewGroup paramViewGroup, View paramView)
  {
    VInstanceManager.getInstance().onScroll(paramViewGroup, paramView, 0, 0);
  }
  
  public static void init()
  {
    if (Gn()) {}
    while (isInit) {
      return;
    }
    isInit = true;
    Object localObject = msg.ajR;
    localObject = new VInstanceManager.Builder().application(BaseApplicationImpl.getApplication()).param(new JSONObject()).preconditionAdapter(new nxp((String)localObject)).serviceJsUrl((String)localObject).isBlockingMode(false);
    VInstanceManager.getInstance().init((VInstanceManager.Builder)localObject);
  }
  
  public static void l(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!paramBaseArticleInfo.isWormhole())) {}
    while (Gn()) {
      return;
    }
    init();
    m(paramBaseArticleInfo);
  }
  
  private static void m(BaseArticleInfo paramBaseArticleInfo)
  {
    if (Gn()) {
      return;
    }
    VInstanceManager.getInstance().createVInstance(paramBaseArticleInfo.getWormholeId(), paramBaseArticleInfo.getWormholeData());
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, int paramInt, View paramView)
  {
    if (Gn()) {}
    while (paramBaseArticleInfo == null) {
      return false;
    }
    String str = paramBaseArticleInfo.getWormholeId();
    this.eS.put(str, Integer.valueOf(paramInt));
    return VInstanceManager.getInstance().bindData(str, paramBaseArticleInfo.getWormholeData(), paramView);
  }
  
  public void addVInstanceEventListener(String paramString, VInstanceAction.VInstanceEventListener paramVInstanceEventListener)
  {
    if (Gn()) {
      return;
    }
    VInstanceManager.getInstance().addVInstanceEventListener(paramString, paramVInstanceEventListener);
  }
  
  public void bQ(String paramString1, String paramString2)
  {
    if (Gn()) {
      return;
    }
    VInstanceManager.getInstance().createVInstance(paramString1, paramString2);
  }
  
  public void destroy()
  {
    if (Gn()) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("pageDestroy", 1);
      VInstanceManager.getInstance().release(new ArrayList(this.eS.keySet()), localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void jdMethod_do(View paramView)
  {
    if (Gn()) {
      return;
    }
    VInstanceManager.getInstance().disappear(paramView);
  }
  
  public void i(AbsListView paramAbsListView)
  {
    if (Gn()) {}
    for (;;)
    {
      return;
      if (paramAbsListView != null)
      {
        int j = paramAbsListView.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = paramAbsListView.getChildAt(i);
          if ((localView instanceof WormholeView)) {
            b(paramAbsListView, ((WormholeView)localView).getContainer());
          }
          i += 1;
        }
      }
    }
  }
  
  public void removeVInstanceEventListener(String paramString)
  {
    if (Gn()) {
      return;
    }
    VInstanceManager.getInstance().removeVInstanceEventListener(paramString);
  }
  
  public void willAppear(View paramView, ViewGroup paramViewGroup)
  {
    if (Gn()) {
      return;
    }
    VInstanceManager.getInstance().willAppear(paramView, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxq
 * JD-Core Version:    0.7.0.1
 */