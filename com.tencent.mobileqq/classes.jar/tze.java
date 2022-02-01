import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.10;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.11;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.12;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.13;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.14;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.15;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.16;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.17;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.18;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.19;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.2;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.20;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.21;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.22;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.23;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.24;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.25;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.26;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.27;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.28;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.29;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.3;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.4;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.5;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.6;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.7;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.8;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler.register.9;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/RIJBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "nameSpace", "", "register", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tze
  extends tyg
{
  public static final tzf a = new tzf(null);
  
  public tze(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  @NotNull
  public String a()
  {
    return "readinjoy";
  }
  
  public void a()
  {
    a("openPrivateLetter", (Function2)new RIJBridgeInvokeHandler.register.1(this));
    a("openVideo", (Function2)new RIJBridgeInvokeHandler.register.2(this));
    a("QReport", (Function2)new RIJBridgeInvokeHandler.register.3(this));
    a("showUGCEditPage", (Function2)new RIJBridgeInvokeHandler.register.4(this));
    a("showMultiBiuEditPage", (Function2)new RIJBridgeInvokeHandler.register.5(this));
    a("selectAndInviteFriend", (Function2)new RIJBridgeInvokeHandler.register.6(this));
    a("selectAndUploadAvatar", (Function2)new RIJBridgeInvokeHandler.register.7(this));
    a("uploadTopicPic", (Function2)new RIJBridgeInvokeHandler.register.8(this));
    a("showPicture", (Function2)new RIJBridgeInvokeHandler.register.9(this));
    a("openAccountPageMore", (Function2)new RIJBridgeInvokeHandler.register.10(this));
    a("socialize_feeds_update", (Function2)new RIJBridgeInvokeHandler.register.11(this));
    a("updateAccountCardFollowInfo", (Function2)new RIJBridgeInvokeHandler.register.12(this));
    a("updateTopicCardFollowInfo", (Function2)new RIJBridgeInvokeHandler.register.13(this));
    a("showVisibleUserList", (Function2)new RIJBridgeInvokeHandler.register.14(this));
    a("getBiuTriggerType", (Function2)new RIJBridgeInvokeHandler.register.15(this));
    a("showShareReadInJoyMenu", (Function2)new RIJBridgeInvokeHandler.register.16(this));
    a("showUGCVideoRecordPage", (Function2)new RIJBridgeInvokeHandler.register.17(this));
    a("showCommentEditor", (Function2)new RIJBridgeInvokeHandler.register.18(this));
    a("showCommentEditorNative", (Function2)new RIJBridgeInvokeHandler.register.19(this));
    a("feeds_refresh_message", (Function2)new RIJBridgeInvokeHandler.register.20(this));
    a("isInKanDianTab", (Function2)new RIJBridgeInvokeHandler.register.21(this));
    a("hasRedPacketSharePermission", (Function2)new RIJBridgeInvokeHandler.register.22(this));
    a("updateRedPacketShareTime", (Function2)new RIJBridgeInvokeHandler.register.23(this));
    a("requestRedPacketContentShareToast", (Function2)new RIJBridgeInvokeHandler.register.24(this));
    a("clearMessageBoxData", (Function2)new RIJBridgeInvokeHandler.register.25(this));
    a("showFollowAlertView", (Function2)new RIJBridgeInvokeHandler.register.26(this));
    a("hideFollowAlertView", (Function2)new RIJBridgeInvokeHandler.register.27(this));
    a("getALDConfigParams", (Function2)new RIJBridgeInvokeHandler.register.28(this));
    a("showLevelDialog", (Function2)new RIJBridgeInvokeHandler.register.29(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tze
 * JD-Core Version:    0.7.0.1
 */