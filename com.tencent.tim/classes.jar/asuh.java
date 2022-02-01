import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.1;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.2;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.3;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

@JsPlugin
public class asuh
  extends BaseJsPlugin
{
  private void a(boolean paramBoolean, RequestEvent paramRequestEvent)
  {
    if (this.mMiniAppInfo.isLimitedAccessApp())
    {
      paramRequestEvent.fail();
      return;
    }
    Object localObject2 = null;
    Object localObject1;
    if (this.mIsMiniGame)
    {
      localObject1 = localObject2;
      if (this.mMiniAppContext.getAttachedActivity() != null)
      {
        localObject1 = localObject2;
        if ((this.mMiniAppContext.getAttachedActivity() instanceof GameActivity1)) {
          localObject1 = ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
        }
      }
    }
    while (localObject1 != null) {
      if (!((aeay)localObject1).isColorNoteExist())
      {
        if (((aeay)localObject1).canAddColorNote())
        {
          if (paramBoolean)
          {
            AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.1(this, (aeay)localObject1, paramRequestEvent));
            return;
            localObject1 = localObject2;
            if (this.mMiniAppContext.getAttachedActivity() != null)
            {
              localObject1 = localObject2;
              if ((this.mMiniAppContext.getAttachedActivity() instanceof AppBrandUI)) {
                localObject1 = ((AppBrandUI)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
              }
            }
          }
          else
          {
            AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.2(this, (aeay)localObject1, paramRequestEvent));
          }
        }
        else {
          AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.3(this, (aeay)localObject1, paramRequestEvent));
        }
      }
      else
      {
        paramRequestEvent.ok();
        return;
      }
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"addColorSign"})
  public void addColorSign(RequestEvent paramRequestEvent)
  {
    a(false, paramRequestEvent);
  }
  
  @JsEvent({"addColorSignDirectly"})
  public void addColorSignDirectly(RequestEvent paramRequestEvent)
  {
    a(true, paramRequestEvent);
  }
  
  @JsEvent({"isColorSignExistSync"})
  public String isColorSignExistSync(RequestEvent paramRequestEvent)
  {
    new JSONObject();
    aeay localaeay;
    if (this.mIsMiniGame)
    {
      if ((this.mMiniAppContext.getAttachedActivity() == null) || (!(this.mMiniAppContext.getAttachedActivity() instanceof GameActivity1))) {
        break label142;
      }
      localaeay = ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
    }
    for (;;)
    {
      if ((localaeay != null) && (localaeay.isColorNoteExist()))
      {
        return ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
        if ((this.mMiniAppContext.getAttachedActivity() != null) && ((this.mMiniAppContext.getAttachedActivity() instanceof AppBrandUI))) {
          localaeay = ((AppBrandUI)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
        }
      }
      else
      {
        return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
      }
      label142:
      localaeay = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onAddColorSign(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asuh
 * JD-Core Version:    0.7.0.1
 */