import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.videostory.capture.AEPlayShowPart.3;
import com.tencent.biz.videostory.capture.AEPlayShowPart.4;
import com.tencent.biz.videostory.capture.AEPlayShowPart.5;
import com.tencent.biz.videostory.capture.AEPlayShowPart.6;
import com.tencent.biz.videostory.capture.AEPlayShowTabView;
import com.tencent.biz.videostory.capture.PlayViewPagerAdapter;
import com.tencent.biz.videostory.capture.widgets.AEPlayShowPageView;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.AECamera.qudong.AETemplateInfoFragment;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class wru
  extends wug
  implements awhd
{
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private bgxx jdField_a_of_type_Bgxx;
  private bgyb jdField_a_of_type_Bgyb;
  private bhcw jdField_a_of_type_Bhcw;
  private AEPlayShowTabView jdField_a_of_type_ComTencentBizVideostoryCaptureAEPlayShowTabView;
  private PlayViewPagerAdapter jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter;
  private String jdField_a_of_type_JavaLangString;
  private wsi jdField_a_of_type_Wsi;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private wus jdField_b_of_type_Wus;
  private View c;
  
  public wru(Activity paramActivity, View paramView, wus paramwus)
  {
    super(paramActivity, paramView, paramwus);
    this.jdField_b_of_type_Wus = paramwus;
    this.jdField_a_of_type_Bhcw = ((bhcw)paramwus.a(65537, new Object[0]));
    this.jdField_a_of_type_Bgyb = ((bgyb)bhfm.a().c(19));
    this.jdField_a_of_type_Bgxx = ((bgxx)bhfm.a().c(18));
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter.a() != null)) {
      return this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter.a().getScrollY();
    }
    return 0;
  }
  
  private bgxt a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter.a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bgxt localbgxt = (bgxt)((Iterator)localObject).next();
        if ((localbgxt != null) && (paramString != null) && (paramString.equals(localbgxt.b))) {
          return localbgxt;
        }
      }
    }
    return null;
  }
  
  private String a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentBizVideostoryCaptureAEPlayShowTabView.a();
    int i = this.jdField_a_of_type_ComTencentBizVideostoryCaptureAEPlayShowTabView.a();
    if ((localArrayList != null) && (i < localArrayList.size())) {
      return ((bhqi)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private String a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter.a();
    if (localObject != null)
    {
      bgxt localbgxt;
      bgya localbgya;
      do
      {
        localObject = ((List)localObject).iterator();
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localbgxt = (bgxt)((Iterator)localObject).next();
          } while ((localbgxt == null) || (localbgxt.jdField_a_of_type_JavaUtilList == null));
          localIterator = localbgxt.jdField_a_of_type_JavaUtilList.iterator();
        }
        localbgya = (bgya)localIterator.next();
      } while ((localbgya == null) || (paramString == null) || (!paramString.equals(localbgya.jdField_a_of_type_JavaLangString)));
      return localbgxt.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private ArrayList<bhqi> a(List<bgxt> paramList)
  {
    if (paramList == null) {
      paramList = null;
    }
    for (;;)
    {
      return paramList;
      try
      {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          bgxt localbgxt = (bgxt)paramList.next();
          bhqi localbhqi = new bhqi();
          localbhqi.jdField_a_of_type_JavaLangString = localbgxt.b;
          localArrayList.add(localbhqi);
        }
        paramList = localArrayList;
      }
      finally {}
    }
  }
  
  @NonNull
  private List<bgxt> a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowPart", 4, "getPlayShowCategories");
    }
    return this.jdField_a_of_type_Bgyb.a();
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureAEPlayShowTabView.a(paramInt);
  }
  
  private void a(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowPart", 4, "preLoadWebView, url=" + paramString);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PreloadWebService.class);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("url", paramString);
    }
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.startService(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AEPlayShowPart", 2, "preLoadWebView, error=", paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEPlayShowPart.6(this, paramString, paramInt));
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.jdField_a_of_type_JavaUtilList;
      if (paramString1 != null) {
        break label20;
      }
    }
    label20:
    label88:
    for (;;)
    {
      return;
      int i = 0;
      for (;;)
      {
        if (i >= paramString1.size()) {
          break label88;
        }
        bgya localbgya = (bgya)paramString1.get(i);
        if ((localbgya != null) && (paramString2 != null) && (paramString2.equals(localbgya.jdField_a_of_type_JavaLangString)))
        {
          paramString1 = this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter.a();
          if (paramString1 == null) {
            break;
          }
          paramString1.a(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(List<bgxt> paramList, List<bhqi> paramList1)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (CollectionUtils.isEmpty(paramList1)))
    {
      if (this.jdField_b_of_type_AndroidViewViewGroup == null)
      {
        this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewStub.inflate());
        this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131312202);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(new wrz(this));
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    while ((this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  private String b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter.a();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          bgxt localbgxt = (bgxt)((Iterator)localObject).next();
          if ((localbgxt != null) && (paramString != null) && (paramString.equals(localbgxt.jdField_a_of_type_JavaLangString))) {
            return localbgxt.b;
          }
        }
      }
    }
    return "";
  }
  
  private String c(String paramString)
  {
    if ((this.jdField_a_of_type_Bhcw != null) && (this.jdField_a_of_type_Bhcw.a() != null) && (this.jdField_a_of_type_Bhcw.a().getIntent() != null)) {
      return this.jdField_a_of_type_Bhcw.a().getIntent().getStringExtra(paramString);
    }
    return "";
  }
  
  private void f()
  {
    this.jdField_a_of_type_Wsi = ((wsi)bhur.a(this.jdField_a_of_type_Bhcw).a(wsi.class));
    this.jdField_a_of_type_Wsi.a().a(this.jdField_a_of_type_Bhcw, new wrx(this));
    avzk.c().a(this.jdField_a_of_type_Bhcw, new wry(this));
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Bhcw != null) && (this.jdField_a_of_type_Bhcw.a() != null) && (this.jdField_a_of_type_Bhcw.a().getIntent() != null))
    {
      this.jdField_a_of_type_Bhcw.a().getIntent().putExtra("KEY_CURRENT_SELECT_ID", "");
      this.jdField_a_of_type_Bhcw.a().getIntent().putExtra("KEY_CURRENT_TYPE", "");
    }
  }
  
  private void j()
  {
    if (this.c == null)
    {
      this.c = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131493818, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.c);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.addRule(13);
      this.c.setLayoutParams(localLayoutParams);
    }
    this.c.setVisibility(0);
  }
  
  private void k()
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  @TargetApi(12)
  private void l()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "alpha", new float[] { 0.0F, 1.0F }));
    localAnimatorSet.setDuration(200L).start();
  }
  
  @Nullable
  private void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowPart", 4, "preLoadUrlIfNeeded");
    }
    String str = this.jdField_a_of_type_Bgyb.a();
    if (TextUtils.isEmpty(str)) {}
    while ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (str.equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = str;
    a(str);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131296636)).inflate());
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureAEPlayShowTabView = ((AEPlayShowTabView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306061));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131313502));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131313507));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureAEPlayShowTabView.setTabCheckListener(new wrv(this));
    this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter = new PlayViewPagerAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_Wus, a());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new wrw(this));
    m();
    j();
    this.jdField_a_of_type_Bgyb.a(this, 1);
    this.jdField_a_of_type_Bgxx.a(this, 116);
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEPlayShowPart.3(this));
    f();
    e();
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (paramInt == 655361) {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof bgya)))
      {
        paramVarArgs = (bgya)paramVarArgs[0];
        if (paramVarArgs.equals(wrn.a))
        {
          localObject1 = bgyb.jdField_a_of_type_JavaLangString + File.separator + paramVarArgs.jdField_a_of_type_JavaLangString;
          localObject2 = a(paramVarArgs.jdField_a_of_type_JavaLangString);
          bhcm.a().c(paramVarArgs.jdField_a_of_type_JavaLangString);
          AETemplateInfoFragment.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject2, (String)localObject1, paramVarArgs.jdField_a_of_type_JavaLangString, paramVarArgs.e);
        }
      }
    }
    for (;;)
    {
      return;
      if (paramInt == 655362)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof bgya)))
        {
          paramVarArgs = (bgya)paramVarArgs[0];
          if (paramVarArgs.equals(wrn.a))
          {
            bhcm.a().c(paramVarArgs.jdField_a_of_type_JavaLangString);
            localObject1 = a(paramVarArgs.jdField_a_of_type_JavaLangString);
            localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", paramVarArgs.k);
            ((Intent)localObject2).putExtra("loc_play_show_tab_name", (String)localObject1);
            ((Intent)localObject2).putExtra("loc_play_show_material_id", paramVarArgs.jdField_a_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.a(this.jdField_a_of_type_AndroidAppActivity));
            this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
          }
        }
      }
      else if (paramInt == 655363)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof bgya)))
        {
          paramVarArgs = (bgya)paramVarArgs[0];
          if (paramVarArgs.equals(wrn.a))
          {
            bhcm.a().c(paramVarArgs.jdField_a_of_type_JavaLangString);
            localObject1 = new LaunchParam();
            ((LaunchParam)localObject1).miniAppId = paramVarArgs.l;
            ((LaunchParam)localObject1).scene = 2083;
            MiniAppController.startAppByAppid(this.jdField_a_of_type_AndroidAppActivity, ((LaunchParam)localObject1).miniAppId, null, null, (LaunchParam)localObject1, null);
          }
        }
      }
      else if ((paramInt == 655364) && (paramVarArgs != null) && (paramVarArgs.length == 2) && ((paramVarArgs[0] instanceof String)) && ((paramVarArgs[1] instanceof String)))
      {
        localObject1 = (String)paramVarArgs[0];
        paramVarArgs = (String)paramVarArgs[1];
        if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureAEPlayShowTabView != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizVideostoryCaptureAEPlayShowTabView.a();
          if (localObject2 != null)
          {
            paramInt = i;
            while (paramInt < ((List)localObject2).size())
            {
              bhqi localbhqi = (bhqi)((List)localObject2).get(paramInt);
              if ((localbhqi != null) && (((String)localObject1).equals(localbhqi.jdField_a_of_type_JavaLangString)))
              {
                a(paramInt);
                this.jdField_a_of_type_AndroidSupportV4ViewViewPager.post(new AEPlayShowPart.4(this, (String)localObject1, paramVarArgs));
                return;
              }
              paramInt += 1;
            }
          }
        }
      }
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1)
    {
      bhcs.a("AEPlayShowPart", 1, "notify, eventId=AEPlayShowMaterialManager.EVENT_MATERIAL_LIST_UPDATED");
      ThreadManager.getUIHandler().post(new AEPlayShowPart.5(this));
    }
    while (paramInt != 116) {
      return;
    }
    bhcs.a("AEPlayShowPart", 1, "notify, eventId=AEMaterialManager.TEMPLATE_INFO_LIST_UPDATE");
    this.jdField_a_of_type_Bgyb.b();
  }
  
  public void c()
  {
    super.c();
    k();
    wrn.a = null;
    wrn.c();
    if (this.jdField_a_of_type_Bgxx != null) {
      this.jdField_a_of_type_Bgxx.a(this);
    }
    if (this.jdField_a_of_type_Bgyb != null)
    {
      this.jdField_a_of_type_Bgyb.a(this);
      this.jdField_a_of_type_Bgyb.c();
    }
  }
  
  public void e()
  {
    Object localObject1 = a();
    m();
    Object localObject2 = a((List)localObject1);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      QLog.d("AEPlayShowPart", 2, "tabDataList size: " + ((ArrayList)localObject2).size());
      if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureAEPlayShowTabView.setVisibility(0);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
      String str = a();
      int i = a();
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureAEPlayShowTabView.a((ArrayList)localObject2);
      this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter.a((List)localObject1);
      this.jdField_a_of_type_ComTencentBizVideostoryCapturePlayViewPagerAdapter.notifyDataSetChanged();
      localObject1 = c("KEY_CURRENT_SELECT_ID");
      localObject2 = b(c("KEY_CURRENT_TYPE"));
      if (a((String)localObject2) != null)
      {
        a(655364, new Object[] { localObject2, localObject1 });
        g();
        return;
      }
      a(str, i);
      return;
    }
    QLog.d("AEPlayShowPart", 2, "no data.");
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureAEPlayShowTabView.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(8);
    a((List)localObject1, (List)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wru
 * JD-Core Version:    0.7.0.1
 */