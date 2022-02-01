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
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.AEPlayShowPageView;
import dov.com.qq.im.ae.play.AEPlayShowPart.1;
import dov.com.qq.im.ae.play.AEPlayShowPart.4;
import dov.com.qq.im.ae.play.AEPlayShowPart.5;
import dov.com.qq.im.ae.play.AEPlayShowPart.6;
import dov.com.qq.im.ae.play.AEPlayShowTabView;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import dov.com.qq.im.ae.play.PlayViewPagerAdapter;
import dov.com.qq.im.capture.view.QIMSlidingTabView.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class axgv
  extends axgh
  implements anho
{
  private View MC;
  private ViewStub P;
  private axgs jdField_a_of_type_Axgs;
  private AEPlayShowTabView jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView;
  private PlayViewPagerAdapter jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter;
  private axgf b;
  private View bL;
  private awtq jdField_c_of_type_Awtq;
  private axbr jdField_c_of_type_Axbr;
  private ViewGroup fc;
  private ViewGroup fd;
  private ViewPager viewPager;
  
  public axgv(Activity paramActivity, ViewStub paramViewStub, axgi paramaxgi)
  {
    super(paramActivity, paramViewStub, paramaxgi);
    this.jdField_c_of_type_Awtq = ((awtq)paramaxgi.a(65537, new Object[0]));
    this.jdField_a_of_type_Axgs = ((axgs)axov.a().c(19));
    this.jdField_c_of_type_Axbr = ((axbr)axov.a().c(18));
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEPlayShowPart.1(this));
    this.jdField_a_of_type_Axgs.b(this, 1);
    this.jdField_c_of_type_Axbr.a(this, 116);
    biN();
    acB(null);
  }
  
  private void BT(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.TX(paramInt);
  }
  
  private ArrayList<QIMSlidingTabView.b> F(List<axbq> paramList)
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
          axbq localaxbq = (axbq)paramList.next();
          QIMSlidingTabView.b localb = new QIMSlidingTabView.b();
          localb.tabName = localaxbq.categoryName;
          localArrayList.add(localb);
        }
        paramList = localArrayList;
      }
      finally {}
    }
  }
  
  private String HL()
  {
    ArrayList localArrayList = this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.getDataList();
    int i = this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.getCurIndex();
    if ((localArrayList != null) && (i < localArrayList.size())) {
      return ((QIMSlidingTabView.b)localArrayList.get(i)).tabName;
    }
    return "";
  }
  
  private int Rc()
  {
    if ((this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter != null) && (this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a() != null)) {
      return this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a().getScrollY();
    }
    return 0;
  }
  
  private void U(List<axbq> paramList, List<QIMSlidingTabView.b> paramList1)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (CollectionUtils.isEmpty(paramList1)))
    {
      if (this.fd == null)
      {
        this.fd = ((ViewGroup)this.P.inflate());
        this.MC = this.fd.findViewById(2131380529);
        this.MC.setOnClickListener(new axha(this));
      }
      this.fd.setVisibility(0);
    }
    while ((this.fd == null) || (this.fd.getVisibility() != 0)) {
      return;
    }
    this.fd.setVisibility(8);
  }
  
  private axbq a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.hQ();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        axbq localaxbq = (axbq)((Iterator)localObject).next();
        if ((localaxbq != null) && (paramString != null) && (paramString.equals(localaxbq.categoryName))) {
          return localaxbq;
        }
      }
    }
    return null;
  }
  
  private void acB(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowPart", 4, "preLoadWebView, url=" + paramString);
    }
    Intent localIntent = new Intent(this.mActivity, PreloadWebService.class);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("url", paramString);
    }
    try
    {
      this.mActivity.startService(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AEPlayShowPart", 2, "preLoadWebView, error=", paramString);
    }
  }
  
  private void biN()
  {
    this.b = ((axgf)awuh.a(this.jdField_c_of_type_Awtq).b(axgf.class));
    this.b.t.a(this.jdField_c_of_type_Awtq, new axgy(this));
    axbk.f().a(this.jdField_c_of_type_Awtq, new axgz(this));
  }
  
  private void dBq()
  {
    Object localObject1 = hP();
    acB(null);
    Object localObject2 = F((List)localObject1);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      QLog.d("AEPlayShowPart", 2, "tabDataList size: " + ((ArrayList)localObject2).size());
      if (this.fd != null) {
        this.fd.setVisibility(8);
      }
      this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.setVisibility(0);
      this.viewPager.setVisibility(0);
      String str1 = HL();
      int i = Rc();
      this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.eL((ArrayList)localObject2);
      this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.oF((List)localObject1);
      this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.notifyDataSetChanged();
      localObject1 = sD("KEY_CURRENT_SELECT_ID");
      Object localObject3 = sD("KEY_CURRENT_TYPE");
      localObject2 = sD("KEY_CURRENT_TAB");
      String str2 = sC((String)localObject1);
      axbq localaxbq = a(str2);
      localObject3 = new StringBuilder().append("chooseId: ").append((String)localObject1).append(" typeId: ").append((String)localObject3).append(" posTabName: ").append(str2).append(" isMaterial null: ");
      if (localaxbq == null) {}
      for (boolean bool = true;; bool = false)
      {
        axiy.d("AEPlayShowPart", bool);
        if ((localaxbq == null) || (!AECaptureMode.PLAY.name.equals(localObject2))) {
          break;
        }
        p(655364, new Object[] { str2, localObject1 });
        return;
      }
      he(str1, i);
      return;
    }
    QLog.d("AEPlayShowPart", 2, "no data.");
    this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.setVisibility(8);
    this.viewPager.setVisibility(8);
    U((List)localObject1, (List)localObject2);
  }
  
  @TargetApi(12)
  private void eJI()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.fc, "alpha", new float[] { 0.0F, 1.0F }));
    localAnimatorSet.setDuration(200L).start();
  }
  
  private void go()
  {
    if (this.bL != null) {
      this.bL.setVisibility(8);
    }
    if (this.fd != null) {
      this.fd.setVisibility(8);
    }
  }
  
  @NonNull
  private List<axbq> hP()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowPart", 4, "getPlayShowCategories");
    }
    return this.jdField_a_of_type_Axgs.hN();
  }
  
  private void he(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEPlayShowPart.6(this, paramString, paramInt));
  }
  
  private void jO(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.Mm;
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
        axbu localaxbu = (axbu)paramString1.get(i);
        if ((localaxbu != null) && (paramString2 != null) && (paramString2.equals(localaxbu.id)))
        {
          paramString1 = this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a();
          if (paramString1 == null) {
            break;
          }
          paramString1.adN(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  private String sB(String paramString)
  {
    Object localObject = this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.hQ();
    if (localObject != null)
    {
      axbq localaxbq;
      axbu localaxbu;
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
            localaxbq = (axbq)((Iterator)localObject).next();
          } while ((localaxbq == null) || (localaxbq.Mm == null));
          localIterator = localaxbq.Mm.iterator();
        }
        localaxbu = (axbu)localIterator.next();
      } while ((localaxbu == null) || (paramString == null) || (!paramString.equals(localaxbu.id)));
      return localaxbq.cTw;
    }
    return "";
  }
  
  private String sC(String paramString)
  {
    if (this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter != null)
    {
      Object localObject1 = this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.hQ();
      if (localObject1 != null)
      {
        axbq localaxbq;
        axbu localaxbu;
        do
        {
          localObject1 = ((List)localObject1).iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localaxbq = (axbq)((Iterator)localObject1).next();
              } while (localaxbq == null);
              localObject2 = localaxbq.Mm;
            } while (localObject2 == null);
            localObject2 = ((List)localObject2).iterator();
          }
          localaxbu = (axbu)((Iterator)localObject2).next();
        } while ((localaxbu == null) || (paramString == null) || (!paramString.equals(localaxbu.id)));
        return localaxbq.categoryName;
      }
    }
    return "";
  }
  
  private String sD(String paramString)
  {
    if ((this.jdField_c_of_type_Awtq != null) && (this.jdField_c_of_type_Awtq.getActivity() != null) && (this.jdField_c_of_type_Awtq.getActivity().getIntent() != null)) {
      return this.jdField_c_of_type_Awtq.getActivity().getIntent().getStringExtra(paramString);
    }
    return "";
  }
  
  private void showProgressDialog()
  {
    if (this.bL == null)
    {
      this.bL = LayoutInflater.from(this.mActivity).inflate(2131559761, this.fc, false);
      this.fc.addView(this.bL);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bL.getLayoutParams();
      localLayoutParams.addRule(13);
      this.bL.setLayoutParams(localLayoutParams);
    }
    this.bL.setVisibility(0);
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1)
    {
      axiy.i("AEPlayShowPart", "notify, eventId=AEPlayShowMaterialManager.EVENT_MATERIAL_LIST_UPDATED");
      if (aOe()) {
        ThreadManager.getUIHandler().post(new AEPlayShowPart.5(this));
      }
    }
    while (paramInt != 116) {
      return;
    }
    axiy.i("AEPlayShowPart", "notify, eventId=AEMaterialManager.TEMPLATE_INFO_LIST_UPDATE");
    this.jdField_a_of_type_Axgs.refresh();
  }
  
  protected void initView() {}
  
  protected void jm(View paramView)
  {
    this.fc = ((ViewGroup)paramView);
    this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView = ((AEPlayShowTabView)this.fc.findViewById(2131373399));
    this.viewPager = ((ViewPager)this.fc.findViewById(2131382091));
    this.P = ((ViewStub)this.fc.findViewById(2131382096));
    this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.setTabCheckListener(new axgw(this));
    this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter = new PlayViewPagerAdapter(this.mActivity, this.jdField_c_of_type_Axgi, hP());
    this.viewPager.setAdapter(this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter);
    this.viewPager.setOnPageChangeListener(new axgx(this));
    dBq();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axgn.h = null;
    axgn.eJz();
    if (this.jdField_c_of_type_Axbr != null) {
      this.jdField_c_of_type_Axbr.d(this);
    }
    if (this.jdField_a_of_type_Axgs != null)
    {
      this.jdField_a_of_type_Axgs.e(this);
      this.jdField_a_of_type_Axgs.eJD();
    }
  }
  
  public void p(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (paramInt == 655361) {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof axbu)))
      {
        paramVarArgs = (axbu)paramVarArgs[0];
        if (paramVarArgs.equals(axgn.h))
        {
          localObject1 = awtn.d.b.cSR + File.separator + paramVarArgs.id;
          localObject2 = sB(paramVarArgs.id);
          axip.a().acT(paramVarArgs.id);
          AETemplateInfoFragment.a(this.mActivity, (String)localObject2, (String)localObject1, paramVarArgs.id, paramVarArgs.name, paramVarArgs.cTC);
        }
      }
    }
    for (;;)
    {
      return;
      if (paramInt == 655362)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof axbu)))
        {
          paramVarArgs = (axbu)paramVarArgs[0];
          if (paramVarArgs.equals(axgn.h))
          {
            axip.a().acT(paramVarArgs.id);
            localObject1 = sB(paramVarArgs.id);
            localObject2 = new Intent(this.mActivity, QQBrowserActivity.class);
            ((Intent)localObject2).addFlags(536870912);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("url", paramVarArgs.webUrl);
            ((Intent)localObject2).putExtra("loc_play_show_tab_name", (String)localObject1);
            ((Intent)localObject2).putExtra("loc_play_show_material_id", paramVarArgs.id);
            ((Intent)localObject2).putExtra("key_camera_material_name", paramVarArgs.cTC);
            ((Intent)localObject2).putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.bI(this.mActivity));
            this.mActivity.startActivity((Intent)localObject2);
          }
        }
      }
      else if (paramInt == 655363)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof axbu)))
        {
          paramVarArgs = (axbu)paramVarArgs[0];
          if (paramVarArgs.equals(axgn.h))
          {
            axip.a().acT(paramVarArgs.id);
            localObject1 = new LaunchParam();
            ((LaunchParam)localObject1).miniAppId = paramVarArgs.miniAppId;
            ((LaunchParam)localObject1).scene = 2083;
            MiniAppController.startAppByAppid(this.mActivity, ((LaunchParam)localObject1).miniAppId, null, null, (LaunchParam)localObject1, null);
          }
        }
      }
      else if ((paramInt == 655364) && (paramVarArgs != null) && (paramVarArgs.length == 2) && ((paramVarArgs[0] instanceof String)) && ((paramVarArgs[1] instanceof String)))
      {
        eHc();
        localObject1 = (String)paramVarArgs[0];
        paramVarArgs = (String)paramVarArgs[1];
        if (this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView != null)
        {
          localObject2 = this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.getDataList();
          if (localObject2 != null)
          {
            paramInt = i;
            while (paramInt < ((List)localObject2).size())
            {
              QIMSlidingTabView.b localb = (QIMSlidingTabView.b)((List)localObject2).get(paramInt);
              if ((localb != null) && (((String)localObject1).equals(localb.tabName)))
              {
                BT(paramInt);
                this.viewPager.post(new AEPlayShowPart.4(this, (String)localObject1, paramVarArgs));
                return;
              }
              paramInt += 1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgv
 * JD-Core Version:    0.7.0.1
 */