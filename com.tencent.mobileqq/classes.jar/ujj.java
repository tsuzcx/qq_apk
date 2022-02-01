import android.app.Activity;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr.checkResValid.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.widget.ListView;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskUIMgr;", "", "()V", "ERROR", "", "FINISH", "NONE", "PAUSE", "PREPARE", "SHOW", "activity", "Ljava/lang/ref/SoftReference;", "Landroid/app/Activity;", "getActivity", "()Ljava/lang/ref/SoftReference;", "setActivity", "(Ljava/lang/ref/SoftReference;)V", "channelID", "getChannelID", "()I", "setChannelID", "(I)V", "hasVolume", "", "getHasVolume", "()Z", "setHasVolume", "(Z)V", "isShowing", "setShowing", "listView", "Lcom/tencent/widget/ListView;", "getListView", "setListView", "showStatus", "getShowStatus", "setShowStatus", "superMaskUI", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/KandianAdPandentMask;", "checkChannelID", "checkResValid", "", "callback", "Landroid/webkit/ValueCallback;", "close", "onPause", "onResume", "resetUIMgr", "shouldShowSuperMask", "showSuperMask", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ujj
{
  private static int jdField_a_of_type_Int;
  @Nullable
  private static SoftReference<Activity> jdField_a_of_type_JavaLangRefSoftReference;
  public static final ujj a;
  private static volatile boolean jdField_a_of_type_Boolean = true;
  private static int jdField_b_of_type_Int = -1;
  @Nullable
  private static SoftReference<ListView> jdField_b_of_type_JavaLangRefSoftReference;
  private static volatile boolean jdField_b_of_type_Boolean;
  private static SoftReference<umj> c;
  
  static
  {
    jdField_a_of_type_Ujj = new ujj();
  }
  
  public final int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public final void a()
  {
    c = new SoftReference(new umj());
    ukq.a("ReadInJoySuperMaskAd", "UI showSuperMask");
    Object localObject1 = c;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = (umj)((SoftReference)localObject1).get();
      localObject2 = jdField_a_of_type_JavaLangRefSoftReference;
      if (localObject2 == null) {
        break label101;
      }
      localObject2 = (Activity)((SoftReference)localObject2).get();
      label56:
      localObject3 = jdField_b_of_type_JavaLangRefSoftReference;
      if (localObject3 == null) {
        break label106;
      }
    }
    JSONObject localJSONObject;
    label101:
    label106:
    for (Object localObject3 = (ListView)((SoftReference)localObject3).get();; localObject3 = null)
    {
      localJSONObject = uje.a.a();
      if (localObject1 != null) {
        break label111;
      }
      ujg.a(ujg.a, "uiIsNull", null, 2, null);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label56;
    }
    label111:
    if (localObject2 == null)
    {
      ujg.a(ujg.a, "actIsNull", null, 2, null);
      return;
    }
    if (localObject3 == null)
    {
      ujg.a(ujg.a, "listIsNull", null, 2, null);
      return;
    }
    if (localJSONObject == null)
    {
      ujg.a(ujg.a, "dataIsNull", null, 2, null);
      return;
    }
    ((umj)localObject1).a((Activity)localObject2, (ListView)localObject3, localJSONObject);
  }
  
  public final void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@NotNull ValueCallback<Boolean> paramValueCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramValueCallback, "callback");
    ThreadManagerV2.post((Runnable)new SuperMaskUIMgr.checkResValid.1(paramValueCallback), 10, null, true);
  }
  
  public final void a(@Nullable SoftReference<Activity> paramSoftReference)
  {
    jdField_a_of_type_JavaLangRefSoftReference = paramSoftReference;
  }
  
  public final void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public final void b()
  {
    if (!c())
    {
      ukq.a("ReadInJoySuperMaskAd", "UI onResume  : checkChannelID fail");
      d();
    }
  }
  
  public final void b(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
  }
  
  public final void b(@Nullable SoftReference<ListView> paramSoftReference)
  {
    jdField_b_of_type_JavaLangRefSoftReference = paramSoftReference;
  }
  
  public final void b(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final boolean b()
  {
    ujk localujk = new ujk();
    if (ujd.a.a() == 1) {
      return ujt.a.a("[SHOW]", new ujc[] { (ujc)localujk });
    }
    ujs localujs = new ujs(jdField_b_of_type_Int);
    return ujt.a.a("[SHOW]", new ujc[] { (ujc)localujk, (ujc)localujs });
  }
  
  public final void c()
  {
    if ((jdField_b_of_type_Boolean) && (!uky.jdField_a_of_type_Boolean))
    {
      String str = "enterBackgroundNoExpose";
      if (ujg.a.a()) {
        str = "enterBackground";
      }
      ujg.a(ujg.a, str, null, 2, null);
    }
    d();
  }
  
  public final boolean c()
  {
    return (jdField_b_of_type_Int == 0) || (plm.c(jdField_b_of_type_Int));
  }
  
  public final void d()
  {
    ukq.a("ReadInJoySuperMaskAd", "UI close");
    if (jdField_b_of_type_Boolean)
    {
      Object localObject = c;
      if (localObject != null)
      {
        localObject = (umj)((SoftReference)localObject).get();
        if (localObject != null) {
          ((umj)localObject).b();
        }
      }
      localObject = c;
      if (localObject != null)
      {
        localObject = (umj)((SoftReference)localObject).get();
        if (localObject != null) {
          ((umj)localObject).a();
        }
      }
      ukq.a("ReadInJoySuperMaskAd", "UI close with isShowing");
    }
  }
  
  public final void e()
  {
    ukq.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : resetUIMgr");
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_JavaLangRefSoftReference = (SoftReference)null;
    c = (SoftReference)null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujj
 * JD-Core Version:    0.7.0.1
 */