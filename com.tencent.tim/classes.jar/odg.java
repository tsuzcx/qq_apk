import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.doScreenshot.1;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RangeButtonView.a;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Landroid/os/Handler$Callback;", "activity", "Landroid/app/Activity;", "app", "Lcom/tencent/common/app/AppInterface;", "processor", "Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;", "(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;)V", "getActivity", "()Landroid/app/Activity;", "curFontSizeIndex", "", "fontSizeChangeListener", "Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$OnFontSizeChangeListener;", "fontSizePanel", "Lcom/tencent/biz/pubaccount/readinjoy/view/FontSizePanel;", "from", "isShowing", "", "()Z", "openWithQQBrowser", "Lcom/tencent/biz/pubaccount/util/OpenWithQQBrowser;", "getProcessor", "()Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;", "setProcessor", "(Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;)V", "rangeBtnListener", "Lcom/tencent/widget/RangeButtonView$OnChangeListener;", "shareActionSheet", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "getShareActionSheet", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "setShareActionSheet", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet;)V", "shareToComputerHelper", "Lcom/tencent/biz/pubaccount/util/ShareToComputerHelper;", "uiHandler", "Lcom/tencent/util/WeakReferenceHandler;", "closeFontSizePanel", "copyLink", "", "url", "", "dismiss", "doScreenshot", "findActionName", "action", "findItemByAction", "Lcom/tencent/biz/pubaccount/util/ActionItem;", "line1", "", "line2", "getActionSheetItems", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "itemsLines", "([Ljava/util/List;)[Ljava/util/List;", "handleMessage", "msg", "Landroid/os/Message;", "onDestroy", "onItemClick", "item", "openPhotoPlusActivity", "path", "openWithSysBrowser", "sendComputer", "showActionSheet", "itemsLine2", "([Ljava/util/List;I)Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "showFontSizePanel", "listener", "BaseSheetItemClickProcessor", "Companion", "OnFontSizeChangeListener", "ShareReport", "ShareResultCallback", "ShareUnitForOld", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class odg
  implements Handler.Callback, ShareActionSheet.OnItemClickListener
{
  public static final odg.b a;
  private static final Map<String, Integer> fa = MapsKt.mapOf(new Pair[] { TuplesKt.to("kandian", Integer.valueOf(13)), TuplesKt.to("qq_friend", Integer.valueOf(2)), TuplesKt.to("qzone", Integer.valueOf(3)), TuplesKt.to("we_chat", Integer.valueOf(9)), TuplesKt.to("we_chat_circle", Integer.valueOf(10)), TuplesKt.to("we_bo", Integer.valueOf(12)), TuplesKt.to("qq_browser", Integer.valueOf(5)), TuplesKt.to("sys_browser", Integer.valueOf(4)), TuplesKt.to("screen_shot", Integer.valueOf(21)), TuplesKt.to("set_font", Integer.valueOf(7)), TuplesKt.to("add_favourite", Integer.valueOf(6)), TuplesKt.to("send_pc", Integer.valueOf(26)), TuplesKt.to("copy_link", Integer.valueOf(1)), TuplesKt.to("report", Integer.valueOf(11)), TuplesKt.to("dis_like", Integer.valueOf(44)), TuplesKt.to("not_care", Integer.valueOf(38)), TuplesKt.to("add_friend", Integer.valueOf(35)), TuplesKt.to("open_aio", Integer.valueOf(37)), TuplesKt.to("open_more_info", Integer.valueOf(31)), TuplesKt.to("remove_fans", Integer.valueOf(137)), TuplesKt.to("personal_c2c", Integer.valueOf(138)), TuplesKt.to("unfollow", Integer.valueOf(32)), TuplesKt.to("save_picture", Integer.valueOf(39)), TuplesKt.to("delete_column", Integer.valueOf(135)), TuplesKt.to("add_to_column", Integer.valueOf(134)), TuplesKt.to("remove_from_column", Integer.valueOf(136)), TuplesKt.to("watch_word_share", Integer.valueOf(133)) });
  private obf jdField_a_of_type_Obf;
  @Nullable
  private odg.a jdField_a_of_type_Odg$a;
  private odg.c jdField_a_of_type_Odg$c;
  private int aXQ;
  @NotNull
  private final Activity activity;
  @NotNull
  private ShareActionSheet jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private ncy jdField_b_of_type_Ncy;
  private final oee jdField_b_of_type_Oee;
  private final auru jdField_c_of_type_Auru;
  private final RangeButtonView.a jdField_c_of_type_ComTencentWidgetRangeButtonView$a;
  private int from;
  
  static
  {
    jdField_a_of_type_Odg$b = new odg.b(null);
  }
  
  public odg(@NotNull Activity paramActivity, @NotNull AppInterface paramAppInterface, @Nullable odg.a parama)
  {
    this.activity = paramActivity;
    this.jdField_a_of_type_Odg$a = parama;
    this.aXQ = -1;
    this.jdField_c_of_type_ComTencentWidgetRangeButtonView$a = ((RangeButtonView.a)new odi(this));
    paramActivity = new ShareActionSheetV2.Param();
    paramActivity.context = ((Context)this.activity);
    paramActivity = ShareActionSheetFactory.create(paramActivity);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "ShareActionSheetFactory.create(param)");
    this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet = paramActivity;
    this.activity.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    this.jdField_b_of_type_Oee = new oee(paramAppInterface);
    this.jdField_c_of_type_Auru = new auru((Handler.Callback)this);
  }
  
  @JvmStatic
  @NotNull
  public static final List<oaq> b(@NotNull JSONArray paramJSONArray, @Nullable JSONObject paramJSONObject)
  {
    return jdField_a_of_type_Odg$b.b(paramJSONArray, paramJSONObject);
  }
  
  @JvmStatic
  @NotNull
  public static final List<Integer> bl()
  {
    return jdField_a_of_type_Odg$b.bl();
  }
  
  @JvmStatic
  @NotNull
  public static final List<oaq> bm()
  {
    return jdField_a_of_type_Odg$b.bm();
  }
  
  @JvmStatic
  @NotNull
  public static final List<oaq> bn()
  {
    return jdField_a_of_type_Odg$b.bn();
  }
  
  private final void pn(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      rwt.ez(1, 2131697457);
      return;
    }
    paramString = EditPicActivity.a(this.activity, paramString, true, true, true, true, true, 4);
    this.activity.startActivity(paramString);
  }
  
  public final boolean GD()
  {
    ncy localncy = this.jdField_b_of_type_Ncy;
    if ((localncy != null) && (localncy.isShowing()))
    {
      localncy.dismiss();
      return true;
    }
    return false;
  }
  
  @NotNull
  public final ShareActionSheet a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  }
  
  @Nullable
  public final ShareActionSheet a(@NotNull List<Integer>[] paramArrayOfList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfList, "itemsLine2");
    this.from = paramInt;
    this.activity.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(a(paramArrayOfList));
    this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2((ShareActionSheet.OnItemClickListener)this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(new Intent());
    this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
    odg.d.a.uw(paramInt);
    return this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  }
  
  @Nullable
  public final oaq a(@NotNull List<? extends oaq> paramList1, @NotNull List<? extends oaq> paramList2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "line1");
    Intrinsics.checkParameterIsNotNull(paramList2, "line2");
    Object localObject = paramList1.iterator();
    while (((Iterator)localObject).hasNext())
    {
      oaq localoaq = (oaq)((Iterator)localObject).next();
      if (localoaq.action == paramInt) {
        return localoaq;
      }
    }
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      localObject = (oaq)paramList2.next();
      if (((oaq)localObject).action == paramInt) {
        return localObject;
      }
    }
    if ((paramInt == 72) || (paramInt == 73))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (oaq)paramList1.next();
        if (paramList2.action == 2) {
          return paramList2;
        }
      }
    }
    return null;
  }
  
  public final void a(@NotNull odg.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "listener");
    this.jdField_a_of_type_Odg$c = paramc;
    if (this.aXQ == -1)
    {
      paramc = awit.f("readinjoy_font_size_index_sp" + kxm.getAccount(), Integer.valueOf(2));
      Intrinsics.checkExpressionValueIsNotNull(paramc, "ReadInJoyHelper.getReadI…JoyUtils.getAccount(), 2)");
      this.aXQ = ((Number)paramc).intValue();
    }
    paramc = new ncy.a(this.activity.getLayoutInflater()).a(this.jdField_c_of_type_ComTencentWidgetRangeButtonView$a).a(this.aXQ).a();
    Window localWindow = this.activity.getWindow();
    Intrinsics.checkExpressionValueIsNotNull(localWindow, "activity.window");
    this.jdField_b_of_type_Ncy = paramc.a(localWindow.getDecorView());
  }
  
  @NotNull
  public final List<ShareActionSheetBuilder.ActionSheetItem>[] a(@NotNull List<Integer>[] paramArrayOfList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfList, "itemsLines");
    ArrayList localArrayList1 = new ArrayList();
    int j = paramArrayOfList.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfList[i];
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(((Number)((Iterator)localObject).next()).intValue()));
      }
      localArrayList1.add(localArrayList2);
      i += 1;
    }
    paramArrayOfList = ((Collection)localArrayList1).toArray(new List[0]);
    if (paramArrayOfList == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return (List[])paramArrayOfList;
  }
  
  @NotNull
  public final String bI(int paramInt)
  {
    Object localObject1 = "other";
    Object localObject2 = localObject1;
    if (fa.containsValue(Integer.valueOf(paramInt)))
    {
      Iterator localIterator = fa.keySet().iterator();
      localObject2 = localObject1;
      if (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        Object localObject3 = fa.get(localObject2);
        if (localObject3 == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        if (paramInt != ((Integer)localObject3).intValue()) {
          break label105;
        }
        localObject1 = localObject2;
      }
    }
    label105:
    for (;;)
    {
      break;
      return localObject2;
    }
  }
  
  public final void bdE()
  {
    Object localObject = this.activity.getWindow();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    ((View)localObject).buildDrawingCache();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "root");
    Bitmap localBitmap1 = ((View)localObject).getDrawingCache();
    if (localBitmap1 != null)
    {
      Bitmap localBitmap2 = nnt.a(this.activity.getWindow(), localBitmap1);
      if (localBitmap2 != null)
      {
        QQToast localQQToast = QQToast.a((Context)BaseApplicationImpl.getContext(), 0, 2131697454, 0);
        BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplicationImpl.getContext()");
        localQQToast.show(localBaseApplication.getResources().getDimensionPixelSize(2131299627));
        ThreadManager.executeOnFileThread((Runnable)new ReadInJoyShareHelperV2.doScreenshot.1(this, localBitmap2));
      }
      localBitmap1.recycle();
    }
    ((View)localObject).destroyDrawingCache();
  }
  
  public final void dismiss()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
  }
  
  @NotNull
  public final Activity getActivity()
  {
    return this.activity;
  }
  
  public boolean handleMessage(@NotNull Message paramMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramMessage, "msg");
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (paramMessage.obj != null)
      {
        paramMessage = paramMessage.obj;
        if (paramMessage == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        pn((String)paramMessage);
      }
    }
  }
  
  public final void onDestroy()
  {
    Object localObject = this.jdField_b_of_type_Oee;
    if (localObject != null) {
      ((oee)localObject).onDestroy();
    }
    localObject = this.jdField_b_of_type_Ncy;
    if (localObject != null) {
      ((ncy)localObject).onDestroy();
    }
    this.jdField_c_of_type_Auru.removeCallbacksAndMessages(null);
    dismiss();
  }
  
  public void onItemClick(@NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, @NotNull ShareActionSheet paramShareActionSheet)
  {
    Intrinsics.checkParameterIsNotNull(paramActionSheetItem, "item");
    Intrinsics.checkParameterIsNotNull(paramShareActionSheet, "shareActionSheet");
    this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    int i = paramActionSheetItem.action;
    paramShareActionSheet = this.jdField_a_of_type_Odg$a;
    if (paramShareActionSheet != null) {
      paramShareActionSheet.b(i, paramActionSheetItem);
    }
    odg.d.a.pm(i);
  }
  
  public final void po(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (this.jdField_a_of_type_Obf == null) {
      this.jdField_a_of_type_Obf = new obf(this.activity, (obf.a)new odh());
    }
    obf localobf = this.jdField_a_of_type_Obf;
    if (localobf != null) {
      localobf.eq(paramString);
    }
  }
  
  public final void pp(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("normal", true);
    paramString.putExtra("big_brother_source_key", kxm.bg(0));
    try
    {
      this.activity.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      rwt.ez(1, 2131697436);
    }
  }
  
  public final void pq(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = this.activity.getSystemService("clipboard");
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.text.ClipboardManager");
    }
    ((ClipboardManager)localObject).setText((CharSequence)paramString);
    rwt.ez(2, 2131692332);
  }
  
  public final void pr(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = this.jdField_b_of_type_Oee;
    if (localObject != null)
    {
      paramString = Long.valueOf(((oee)localObject).M(paramString));
      localObject = odg.d.a;
      if (paramString != null) {
        break label46;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      ((odg.d)localObject).nV(bool);
      return;
      paramString = null;
      break;
      label46:
      if (paramString.longValue() != 0L) {
        break label33;
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;", "", "()V", "processClick", "", "action", "", "item", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static class a
  {
    public boolean b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
    {
      Intrinsics.checkParameterIsNotNull(paramActionSheetItem, "item");
      return false;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$Companion;", "", "()V", "FROM_BIU", "", "FROM_COLUMN_DETAIL", "FROM_COMMENT", "FROM_COMMENT_CARD", "FROM_MY_INFO_CARD", "FROM_NATIVE_ARTICLE", "FROM_OTHER", "FROM_SHORT_CONTENT_CARD", "FROM_SHORT_CONTENT_DETAIL", "FROM_SHORT_CONTENT_FLOAT", "FROM_TOPIC", "FROM_UGC", "FROM_UGC_SOCIAL", "FROM_VIDEO_CARD", "FROM_VIDEO_MULTI", "FROM_VIDEO_ONE_TO_THREE", "FROM_WEB_ARTICLE", "MSG_SCREENSHOT_SAVED", "REQUEST_CODE_SHARE_TO_QZONE", "RIJ_FONT_SIZE_INDEX_SP", "", "RIJ_FONT_SIZE_SP", "RIJ_SHARE_TITLE", "SHARE_UNIT_ADD_COLOR_NOTE", "SHARE_UNIT_ADD_FAVORITE", "SHARE_UNIT_ADD_FRIEND", "SHARE_UNIT_ADD_TO_COLUMN", "SHARE_UNIT_ADJUST_FONT_SIZE", "SHARE_UNIT_COPY_LINK", "SHARE_UNIT_DELETE_COLUMN", "SHARE_UNIT_DIS_LIKE", "SHARE_UNIT_EXPORT_DOCS", "SHARE_UNIT_MORE_INFO", "SHARE_UNIT_OPEN_AIO", "SHARE_UNIT_PERSONAL_C2C", "SHARE_UNIT_QR_CODE", "SHARE_UNIT_REMOVE_COLOR_NOTE", "SHARE_UNIT_REMOVE_FANS", "SHARE_UNIT_REMOVE_FROM_COLUMN", "SHARE_UNIT_REPORT", "SHARE_UNIT_SAVE_PIC", "SHARE_UNIT_SCREEN_SHOT", "SHARE_UNIT_SEND_TO_PC", "SHARE_UNIT_SEND_TO_QQ_BROWSER", "SHARE_UNIT_SEND_TO_QQ_FRIEND", "SHARE_UNIT_SEND_TO_QZONE", "SHARE_UNIT_SEND_TO_READINJOY", "SHARE_UNIT_SEND_TO_RECENT_FRIEND", "SHARE_UNIT_SEND_TO_SYS_BROWSER", "SHARE_UNIT_SEND_TO_WECHAT", "SHARE_UNIT_SEND_TO_WECHAT_CIRCLE", "SHARE_UNIT_SEND_TO_WEIBO", "SHARE_UNIT_SHIELD", "SHARE_UNIT_UNKNOWN", "SHARE_UNIT_WATCH_WORD", "TAG", "nameToAction", "", "actionToShareUnit", "action", "getDefaultActionItemLine1", "", "Lcom/tencent/biz/pubaccount/util/ActionItem;", "getDefaultActionItemLine2", "getWholeLineOneItems", "parseWebLineFromJson", "lineArr", "Lorg/json/JSONArray;", "jsonObject", "Lorg/json/JSONObject;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class b
  {
    @JvmStatic
    @NotNull
    public final List<oaq> b(@NotNull JSONArray paramJSONArray, @Nullable JSONObject paramJSONObject)
    {
      Intrinsics.checkParameterIsNotNull(paramJSONArray, "lineArr");
      ArrayList localArrayList = new ArrayList();
      int i;
      Object localObject1;
      int m;
      int j;
      label192:
      boolean bool;
      for (;;)
      {
        try
        {
          int k = paramJSONArray.length();
          i = 0;
          if (i >= k) {
            break label245;
          }
          localObject2 = paramJSONArray.get(i);
          if ((localObject2 instanceof String))
          {
            localObject1 = (Integer)odg.L().get(localObject2);
            if (localObject1 == null) {
              break label334;
            }
            localArrayList.add(new oaq((String)localObject2, ((Integer)localObject1).intValue(), false));
            break label334;
          }
          if (!(localObject2 instanceof JSONObject)) {
            break label334;
          }
          localObject1 = ((JSONObject)localObject2).optString("name");
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (odg.L().get(localObject1) == null)) {
            break label334;
          }
          m = ((JSONObject)localObject2).optInt("webHandle", 0);
          if ((!Intrinsics.areEqual("save_picture", localObject1)) || (paramJSONObject == null)) {
            break;
          }
          localObject2 = (Integer)odg.L().get(localObject1);
          if (localObject2 == null) {
            break label251;
          }
          j = ((Integer)localObject2).intValue();
        }
        catch (JSONException paramJSONArray)
        {
          QLog.e("ReadInJoyShareHelperV2", 1, QLog.getStackTraceString((Throwable)paramJSONArray));
        }
        localObject2 = paramJSONObject.optString("saveImageUrl");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "jsonObject.optString(\"saveImageUrl\")");
        localArrayList.add(new oaz((String)localObject1, j, bool, (String)localObject2));
        break label334;
        label245:
        return (List)localArrayList;
        label251:
        j = 0;
        break label341;
        label257:
        bool = false;
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "name");
      Object localObject2 = (Integer)odg.L().get(localObject1);
      if (localObject2 != null) {
        j = ((Integer)localObject2).intValue();
      }
      for (;;)
      {
        label300:
        localArrayList.add(new oaq((String)localObject1, j, bool));
        break label334;
        j = 0;
        label334:
        label341:
        while (m != 1)
        {
          bool = false;
          break label300;
          i += 1;
          break;
          if (m != 1) {
            break label257;
          }
          bool = true;
          break label192;
        }
        bool = true;
      }
    }
    
    @JvmStatic
    @NotNull
    public final List<Integer> bl()
    {
      ArrayList localArrayList = new ArrayList(9);
      localArrayList.add(Integer.valueOf(13));
      localArrayList.add(Integer.valueOf(2));
      localArrayList.add(Integer.valueOf(3));
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(10));
      localArrayList.add(Integer.valueOf(12));
      localArrayList.add(Integer.valueOf(26));
      localArrayList.add(Integer.valueOf(5));
      localArrayList.add(Integer.valueOf(4));
      return (List)localArrayList;
    }
    
    @JvmStatic
    @NotNull
    public final List<oaq> bm()
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new oaq("kandian", 13, false));
      localArrayList.add(new oaq("qq_friend", 2, false));
      localArrayList.add(new oaq("qzone", 3, false));
      localArrayList.add(new oaq("we_chat", 9, false));
      localArrayList.add(new oaq("we_chat_circle", 10, false));
      localArrayList.add(new oaq("we_bo", 12, false));
      localArrayList.add(new oaq("send_pc", 26, false));
      localArrayList.add(new oaq("qq_browser", 5, false));
      localArrayList.add(new oaq("sys_browser", 4, false));
      return (List)localArrayList;
    }
    
    @JvmStatic
    @NotNull
    public final List<oaq> bn()
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new oaq("screen_shot", 21, false));
      localArrayList.add(new oaq("set_font", 7, false));
      localArrayList.add(new oaq("add_favourite", 6, false));
      localArrayList.add(new oaq("copy_link", 1, false));
      localArrayList.add(new oaq("report", 11, false));
      return (List)localArrayList;
    }
    
    public final int dI(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 72: 
        return 1;
      case 13: 
        return 2;
      case 2: 
        return 3;
      case 3: 
        return 4;
      case 9: 
        return 5;
      case 10: 
        return 6;
      case 12: 
        return 7;
      case 4: 
        return 8;
      case 5: 
        return 9;
      case 70: 
        return 10;
      case 6: 
        return 11;
      case 68: 
        return 12;
      case 26: 
        return 13;
      case 1: 
        return 14;
      case 11: 
        return 15;
      case 38: 
        return 16;
      case 23: 
        return 17;
      case 133: 
        return 18;
      case 82: 
        return 19;
      case 40: 
        return 20;
      case 134: 
        return 21;
      case 136: 
        return 22;
      case 35: 
        return 23;
      case 37: 
        return 24;
      case 137: 
        return 25;
      case 31: 
        return 26;
      case 138: 
        return 27;
      case 43: 
        return 28;
      case 44: 
        return 29;
      case 21: 
        return 30;
      }
      return 31;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$OnFontSizeChangeListener;", "", "onFontSizeChange", "", "index", "", "textSize", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static abstract interface c
  {
    public abstract void i(int paramInt, float paramFloat);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$ShareReport;", "", "()V", "action", "", "from", "isSharing", "", "reportClick", "", "reportExp", "reportResult", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class d
  {
    public static final d a = new d();
    private static int action;
    private static boolean awx;
    private static int from;
    
    public final void nV(boolean paramBoolean)
    {
      int i = 0;
      kxm.b localb;
      if (awx)
      {
        awx = false;
        localb = new kxm.b();
        kxu.a(localb, "from", Integer.valueOf(from));
        kxu.a(localb, "share_unit", Integer.valueOf(odg.a.dI(action)));
        if (!paramBoolean) {
          break label74;
        }
      }
      for (;;)
      {
        kxu.a(localb, "result", Integer.valueOf(i));
        kbp.bp("0X800AD77", localb.build());
        return;
        label74:
        i = 1;
      }
    }
    
    public final void pm(int paramInt)
    {
      action = paramInt;
      awx = true;
      kxm.b localb = new kxm.b();
      kxu.a(localb, "from", Integer.valueOf(from));
      kxu.a(localb, "share_unit", Integer.valueOf(odg.a.dI(paramInt)));
      kbp.bp("0X800AD76", localb.build());
    }
    
    public final void uw(int paramInt)
    {
      from = paramInt;
      kxm.b localb = new kxm.b();
      kxu.a(localb, "from", Integer.valueOf(paramInt));
      kbp.bp("0X800AD75", localb.build());
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$ShareResultCallback;", "", "onResult", "", "success", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static abstract interface e
  {
    public abstract void onResult(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     odg
 * JD-Core Version:    0.7.0.1
 */