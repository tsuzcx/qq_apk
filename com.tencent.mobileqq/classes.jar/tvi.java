import android.app.Activity;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.impl.SuperMaskUIMgr.checkResValid.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.widget.ListView;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/impl/SuperMaskUIMgr;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/ISuperMaskUI;", "()V", "activity", "Ljava/lang/ref/SoftReference;", "Landroid/app/Activity;", "getActivity", "()Ljava/lang/ref/SoftReference;", "setActivity", "(Ljava/lang/ref/SoftReference;)V", "channelID", "", "getChannelID", "()I", "setChannelID", "(I)V", "hasVolume", "", "getHasVolume", "()Z", "setHasVolume", "(Z)V", "isShowing", "setShowing", "listView", "Lcom/tencent/widget/ListView;", "getListView", "setListView", "showStatus", "getShowStatus", "setShowStatus", "superMaskUI", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/KandianAdPandentMask;", "checkChannelID", "checkResValid", "", "callback", "Landroid/webkit/ValueCallback;", "close", "onPause", "onResume", "resetUIMgr", "shouldShowSuperMask", "showSuperMask", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tvi
  implements tuz
{
  private static int jdField_a_of_type_Int = tuz.a.a();
  @Nullable
  private static SoftReference<Activity> jdField_a_of_type_JavaLangRefSoftReference;
  public static final tvi a;
  private static volatile boolean jdField_a_of_type_Boolean = true;
  private static int jdField_b_of_type_Int = -1;
  @Nullable
  private static SoftReference<ListView> jdField_b_of_type_JavaLangRefSoftReference;
  private static volatile boolean jdField_b_of_type_Boolean;
  private static SoftReference<tyl> c;
  
  static
  {
    jdField_a_of_type_Tvi = new tvi();
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public void a()
  {
    c = new SoftReference(new tyl());
    twp.a("ReadInJoySuperMaskAd", "UI showSuperMask");
    Object localObject1 = c;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = (tyl)((SoftReference)localObject1).get();
      localObject2 = jdField_a_of_type_JavaLangRefSoftReference;
      if (localObject2 == null) {
        break label98;
      }
      localObject2 = (Activity)((SoftReference)localObject2).get();
      label56:
      localObject3 = jdField_b_of_type_JavaLangRefSoftReference;
      if (localObject3 == null) {
        break label103;
      }
    }
    JSONObject localJSONObject;
    label98:
    label103:
    for (Object localObject3 = (ListView)((SoftReference)localObject3).get();; localObject3 = null)
    {
      localJSONObject = tve.a.a();
      if (localObject1 != null) {
        break label108;
      }
      tvg.a.a("uiIsNull");
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label56;
    }
    label108:
    if (localObject2 == null)
    {
      tvg.a.a("actIsNull");
      return;
    }
    if (localObject3 == null)
    {
      tvg.a.a("listIsNull");
      return;
    }
    if (localJSONObject == null)
    {
      tvg.a.a("dataIsNull");
      return;
    }
    ((tyl)localObject1).a((Activity)localObject2, (ListView)localObject3, localJSONObject);
  }
  
  public void a(int paramInt)
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
      twp.a("ReadInJoySuperMaskAd", "UI onResume  : checkChannelID fail");
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
  
  public boolean b()
  {
    tvj localtvj = new tvj();
    if (tvd.a.a() == 1) {
      return tvs.a.a("[SHOW]", new tvc[] { (tvc)localtvj });
    }
    tvr localtvr = new tvr(jdField_b_of_type_Int);
    return tvs.a.a("[SHOW]", new tvc[] { (tvc)localtvj, (tvc)localtvr });
  }
  
  public final void c()
  {
    if ((jdField_b_of_type_Boolean) && (!twx.jdField_a_of_type_Boolean))
    {
      String str = "enterBackgroundNoExpose";
      if (tvg.a.a()) {
        str = "enterBackground";
      }
      tvg.a.a(str);
    }
    d();
  }
  
  public boolean c()
  {
    return (jdField_b_of_type_Int == 0) || (pcl.c(jdField_b_of_type_Int));
  }
  
  public void d()
  {
    twp.a("ReadInJoySuperMaskAd", "UI close");
    if (jdField_b_of_type_Boolean)
    {
      Object localObject = c;
      if (localObject != null)
      {
        localObject = (tyl)((SoftReference)localObject).get();
        if (localObject != null) {
          ((tyl)localObject).b();
        }
      }
      localObject = c;
      if (localObject != null)
      {
        localObject = (tyl)((SoftReference)localObject).get();
        if (localObject != null) {
          ((tyl)localObject).a();
        }
      }
      twp.a("ReadInJoySuperMaskAd", "UI close with isShowing");
    }
  }
  
  public final void e()
  {
    twp.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : resetUIMgr");
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_JavaLangRefSoftReference = (SoftReference)null;
    c = (SoftReference)null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvi
 * JD-Core Version:    0.7.0.1
 */