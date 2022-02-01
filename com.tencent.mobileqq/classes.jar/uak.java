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
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Landroid/os/Handler$Callback;", "activity", "Landroid/app/Activity;", "app", "Lcom/tencent/common/app/AppInterface;", "processor", "Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;", "(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;)V", "getActivity", "()Landroid/app/Activity;", "curFontSizeIndex", "", "fontSizeChangeListener", "Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$OnFontSizeChangeListener;", "fontSizePanel", "Lcom/tencent/biz/pubaccount/readinjoy/view/FontSizePanel;", "from", "isShowing", "", "()Z", "openWithQQBrowser", "Lcom/tencent/biz/pubaccount/util/OpenWithQQBrowser;", "getProcessor", "()Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;", "setProcessor", "(Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;)V", "rangeBtnListener", "Lcom/tencent/widget/RangeButtonView$OnChangeListener;", "shareActionSheet", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "getShareActionSheet", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "setShareActionSheet", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet;)V", "shareToComputerHelper", "Lcom/tencent/biz/pubaccount/util/ShareToComputerHelper;", "uiHandler", "Lcom/tencent/util/WeakReferenceHandler;", "closeFontSizePanel", "copyLink", "", "url", "", "dismiss", "doScreenshot", "findActionName", "action", "findItemByAction", "Lcom/tencent/biz/pubaccount/util/ActionItem;", "line1", "", "line2", "getActionSheetItems", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "itemsLines", "([Ljava/util/List;)[Ljava/util/List;", "handleMessage", "msg", "Landroid/os/Message;", "onDestroy", "onItemClick", "item", "openPhotoPlusActivity", "path", "openWithSysBrowser", "sendComputer", "showActionSheet", "itemsLine2", "([Ljava/util/List;I)Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "showFontSizePanel", "listener", "isTxtRatio", "BaseSheetItemClickProcessor", "Companion", "OnFontSizeChangeListener", "ShareReport", "ShareResultCallback", "ShareUnitForOld", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uak
  implements Handler.Callback, ShareActionSheet.OnItemClickListener
{
  private static final Map<String, Integer> jdField_a_of_type_JavaUtilMap = MapsKt.mapOf(new Pair[] { TuplesKt.to("kandian", Integer.valueOf(13)), TuplesKt.to("qq_friend", Integer.valueOf(2)), TuplesKt.to("qzone", Integer.valueOf(3)), TuplesKt.to("we_chat", Integer.valueOf(9)), TuplesKt.to("we_chat_circle", Integer.valueOf(10)), TuplesKt.to("we_bo", Integer.valueOf(12)), TuplesKt.to("qq_browser", Integer.valueOf(5)), TuplesKt.to("sys_browser", Integer.valueOf(4)), TuplesKt.to("screen_shot", Integer.valueOf(21)), TuplesKt.to("set_font", Integer.valueOf(7)), TuplesKt.to("add_favourite", Integer.valueOf(6)), TuplesKt.to("send_pc", Integer.valueOf(26)), TuplesKt.to("copy_link", Integer.valueOf(1)), TuplesKt.to("report", Integer.valueOf(11)), TuplesKt.to("dis_like", Integer.valueOf(44)), TuplesKt.to("not_care", Integer.valueOf(38)), TuplesKt.to("add_friend", Integer.valueOf(35)), TuplesKt.to("open_aio", Integer.valueOf(37)), TuplesKt.to("open_more_info", Integer.valueOf(31)), TuplesKt.to("remove_fans", Integer.valueOf(137)), TuplesKt.to("personal_c2c", Integer.valueOf(138)), TuplesKt.to("unfollow", Integer.valueOf(32)), TuplesKt.to("save_picture", Integer.valueOf(39)), TuplesKt.to("delete_column", Integer.valueOf(135)), TuplesKt.to("add_to_column", Integer.valueOf(134)), TuplesKt.to("remove_from_column", Integer.valueOf(136)), TuplesKt.to("play_feedback", Integer.valueOf(161)), TuplesKt.to("add_floating_ball", Integer.valueOf(70)), TuplesKt.to("cancel_floating_ball", Integer.valueOf(82)) });
  public static final uam a;
  private int jdField_a_of_type_Int;
  @NotNull
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final blhq jdField_a_of_type_Blhq;
  private final blow jdField_a_of_type_Blow;
  @NotNull
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private sdt jdField_a_of_type_Sdt;
  private txm jdField_a_of_type_Txm;
  @Nullable
  private ual jdField_a_of_type_Ual;
  private uan jdField_a_of_type_Uan;
  private final ubt jdField_a_of_type_Ubt;
  private int b;
  
  static
  {
    jdField_a_of_type_Uam = new uam(null);
  }
  
  public uak(@NotNull Activity paramActivity, @NotNull AppInterface paramAppInterface, @Nullable ual paramual)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Ual = paramual;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Blow = ((blow)new uar(this));
    paramActivity = new ShareActionSheetV2.Param();
    paramActivity.context = ((Context)this.jdField_a_of_type_AndroidAppActivity);
    paramActivity = ShareActionSheetFactory.create(paramActivity);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "ShareActionSheetFactory.create(param)");
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = paramActivity;
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    this.jdField_a_of_type_Ubt = new ubt(paramAppInterface);
    this.jdField_a_of_type_Blhq = new blhq((Handler.Callback)this);
  }
  
  @JvmStatic
  @NotNull
  public static final List<Integer> a()
  {
    return jdField_a_of_type_Uam.a();
  }
  
  @JvmStatic
  @NotNull
  public static final List<two> a(@NotNull JSONArray paramJSONArray, @Nullable JSONObject paramJSONObject)
  {
    return jdField_a_of_type_Uam.a(paramJSONArray, paramJSONObject);
  }
  
  @JvmStatic
  @NotNull
  public static final List<two> b()
  {
    return jdField_a_of_type_Uam.b();
  }
  
  @JvmStatic
  @NotNull
  public static final List<two> c()
  {
    return jdField_a_of_type_Uam.c();
  }
  
  private final void e(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      zyx.a(1, 2131694685);
      return;
    }
    paramString = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramString, true, true, true, true, true, 4);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
  }
  
  @NotNull
  public final Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  @NotNull
  public final ShareActionSheet a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  }
  
  @Nullable
  public final ShareActionSheet a(@NotNull List<Integer>[] paramArrayOfList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfList, "itemsLine2");
    this.b = paramInt;
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(a(paramArrayOfList));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2((ShareActionSheet.OnItemClickListener)this);
    paramArrayOfList = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 44);
    paramArrayOfList.setIntentForStartForwardRecentActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
    uao.a.a(paramInt);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  }
  
  @NotNull
  public final String a(int paramInt)
  {
    Object localObject1 = "other";
    Object localObject2 = localObject1;
    if (jdField_a_of_type_JavaUtilMap.containsValue(Integer.valueOf(paramInt)))
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
      localObject2 = localObject1;
      if (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        Object localObject3 = jdField_a_of_type_JavaUtilMap.get(localObject2);
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
  
  @Nullable
  public final two a(@NotNull List<? extends two> paramList1, @NotNull List<? extends two> paramList2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "line1");
    Intrinsics.checkParameterIsNotNull(paramList2, "line2");
    Object localObject = paramList1.iterator();
    while (((Iterator)localObject).hasNext())
    {
      two localtwo = (two)((Iterator)localObject).next();
      if (localtwo.jdField_a_of_type_Int == paramInt) {
        return localtwo;
      }
    }
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      localObject = (two)paramList2.next();
      if (((two)localObject).jdField_a_of_type_Int == paramInt) {
        return localObject;
      }
    }
    if ((paramInt == 72) || (paramInt == 73))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (two)paramList1.next();
        if (paramList2.jdField_a_of_type_Int == 2) {
          return paramList2;
        }
      }
    }
    return null;
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (this.jdField_a_of_type_Txm == null) {
      this.jdField_a_of_type_Txm = new txm(this.jdField_a_of_type_AndroidAppActivity, (txn)new uaq());
    }
    txm localtxm = this.jdField_a_of_type_Txm;
    if (localtxm != null) {
      localtxm.a(paramString);
    }
  }
  
  public final void a(@NotNull uan paramuan)
  {
    Intrinsics.checkParameterIsNotNull(paramuan, "listener");
    a(paramuan, false);
  }
  
  public final void a(@NotNull uan paramuan, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramuan, "listener");
    this.jdField_a_of_type_Uan = paramuan;
    if (this.jdField_a_of_type_Int == -1)
    {
      paramuan = bnrf.a("readinjoy_font_size_index_sp" + ozs.a(), Integer.valueOf(2));
      Intrinsics.checkExpressionValueIsNotNull(paramuan, "ReadInJoyHelper.getReadI…JoyUtils.getAccount(), 2)");
      this.jdField_a_of_type_Int = ((Number)paramuan).intValue();
    }
    paramuan = new sdv(this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater()).a(this.jdField_a_of_type_Blow).a(this.jdField_a_of_type_Int).a(paramBoolean).a();
    Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    Intrinsics.checkExpressionValueIsNotNull(localWindow, "activity.window");
    this.jdField_a_of_type_Sdt = paramuan.a(localWindow.getDecorView());
  }
  
  public final boolean a()
  {
    sdt localsdt = this.jdField_a_of_type_Sdt;
    if ((localsdt != null) && (localsdt.a()))
    {
      localsdt.b();
      return true;
    }
    return false;
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
  
  public final void b()
  {
    Object localObject = this.jdField_a_of_type_Ubt;
    if (localObject != null) {
      ((ubt)localObject).a();
    }
    localObject = this.jdField_a_of_type_Sdt;
    if (localObject != null) {
      ((sdt)localObject).a();
    }
    this.jdField_a_of_type_Blhq.removeCallbacksAndMessages(null);
    a();
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("normal", true);
    paramString.putExtra("big_brother_source_key", ozs.f(0));
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      zyx.a(1, 2131694663);
    }
  }
  
  public final void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    ((View)localObject).buildDrawingCache();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "root");
    Bitmap localBitmap1 = ((View)localObject).getDrawingCache();
    if (localBitmap1 != null)
    {
      Bitmap localBitmap2 = sta.a(this.jdField_a_of_type_AndroidAppActivity.getWindow(), localBitmap1);
      if (localBitmap2 != null)
      {
        QQToast localQQToast = QQToast.a((Context)BaseApplicationImpl.getContext(), 0, 2131694682, 0);
        BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplicationImpl.getContext()");
        localQQToast.b(localBaseApplication.getResources().getDimensionPixelSize(2131299011));
        ThreadManager.executeOnFileThread((Runnable)new ReadInJoyShareHelperV2.doScreenshot.1(this, localBitmap2));
      }
      localBitmap1.recycle();
    }
    ((View)localObject).destroyDrawingCache();
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard");
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.text.ClipboardManager");
    }
    ((ClipboardManager)localObject).setText((CharSequence)paramString);
    zyx.a(2, 2131691142);
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = this.jdField_a_of_type_Ubt;
    if (localObject != null)
    {
      paramString = Long.valueOf(((ubt)localObject).a(paramString));
      localObject = uao.a;
      if (paramString != null) {
        break label46;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      ((uao)localObject).a(bool);
      return;
      paramString = null;
      break;
      label46:
      if (paramString.longValue() != 0L) {
        break label33;
      }
    }
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
        e((String)paramMessage);
      }
    }
  }
  
  public void onItemClick(@NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, @NotNull ShareActionSheet paramShareActionSheet)
  {
    Intrinsics.checkParameterIsNotNull(paramActionSheetItem, "item");
    Intrinsics.checkParameterIsNotNull(paramShareActionSheet, "shareActionSheet");
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    int i = paramActionSheetItem.action;
    paramShareActionSheet = this.jdField_a_of_type_Ual;
    if (paramShareActionSheet != null) {
      paramShareActionSheet.a(i, paramActionSheetItem);
    }
    uao.a.b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uak
 * JD-Core Version:    0.7.0.1
 */