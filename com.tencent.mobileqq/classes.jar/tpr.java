import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleUtil;", "", "()V", "SP_KEY_WEBVIEW_REUSE", "", "SP_KEY_WEBVIEW_TRANS_ANIMATION", "SP_KEY_WEBVIEW_VAS_SONIC", "SP_KEY_WEB_ARTICLE_SWITCH", "TAG", "init", "", "isSupportWebArticle", "", "isSupportWebViewAnimation", "isSupportWebViewReuse", "isSupportWebViewVasSonic", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tpr
{
  public static final tpr a = new tpr();
  
  public final void a()
  {
    boolean bool4 = false;
    bkwm.f();
    AladdinConfig localAladdinConfig = Aladdin.getConfig(378);
    boolean bool1;
    label35:
    label49:
    boolean bool2;
    label56:
    label70:
    boolean bool3;
    if (localAladdinConfig != null)
    {
      i = localAladdinConfig.getIntegerFromString("web_article_switch", 0);
      if (i != 1) {
        break label223;
      }
      bool1 = true;
      if (localAladdinConfig == null) {
        break label228;
      }
      i = localAladdinConfig.getIntegerFromString("webview_reuse", 0);
      if (i != 1) {
        break label233;
      }
      bool2 = true;
      if (localAladdinConfig == null) {
        break label238;
      }
      i = localAladdinConfig.getIntegerFromString("webview_vas_sonic", 0);
      if (i != 1) {
        break label243;
      }
      bool3 = true;
      label78:
      if (localAladdinConfig == null) {
        break label249;
      }
    }
    label223:
    label228:
    label233:
    label238:
    label243:
    label249:
    for (int i = localAladdinConfig.getIntegerFromString("webview_transition_animation", 0);; i = 0)
    {
      if (i == 1) {
        bool4 = true;
      }
      QLog.i("RIJWebArticleUtil", 1, "[init] webArticleConfig = { " + "webArticleSwitch = " + bool1 + ", " + "webViewReuse = " + bool2 + ", " + "webViewVasSonic = " + bool3 + ", " + "webViewTransitionAnimation = " + bool4 + " }");
      bkwm.a("sp_key_web_article_switch", Boolean.valueOf(bool1));
      bkwm.a("sp_key_webview_reuse", Boolean.valueOf(bool2));
      bkwm.a("sp_key_webview_sonic", Boolean.valueOf(bool3));
      bkwm.a("sp_key_webview_trans_animation", Boolean.valueOf(bool4));
      return;
      i = 0;
      break;
      bool1 = false;
      break label35;
      i = 0;
      break label49;
      bool2 = false;
      break label56;
      i = 0;
      break label70;
      bool3 = false;
      break label78;
    }
  }
  
  public final boolean a()
  {
    Object localObject = bkwm.a("sp_key_web_article_switch", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…EB_ARTICLE_SWITCH, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean b()
  {
    Object localObject = bkwm.a("sp_key_webview_reuse", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…KEY_WEBVIEW_REUSE, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean c()
  {
    Object localObject = bkwm.a("sp_key_webview_sonic", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…WEBVIEW_VAS_SONIC, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean d()
  {
    Object localObject = bkwm.a("sp_key_webview_trans_animation", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…W_TRANS_ANIMATION, false)");
    return ((Boolean)localObject).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpr
 * JD-Core Version:    0.7.0.1
 */