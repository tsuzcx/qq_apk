import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.videostory.capture.AEBottomListAdapter.2;
import com.tencent.biz.videostory.capture.AEBottomListAdapter.3;
import com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import dov.com.qq.im.AECamera.View.AEBeautyProviderView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class wql
  extends RecyclerView.Adapter<wqp>
{
  private static final String jdField_a_of_type_JavaLangString = wql.class.getSimpleName();
  private static boolean jdField_a_of_type_Boolean;
  private static List<String> b = new ArrayList();
  private bgxh jdField_a_of_type_Bgxh;
  private bgxw jdField_a_of_type_Bgxw = new wqn(this);
  private bgxx jdField_a_of_type_Bgxx;
  private bgya jdField_a_of_type_Bgya;
  public bhcw a;
  private AEBottomListScrollView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new wqm(this);
  private List<bgya> jdField_a_of_type_JavaUtilList;
  private Map<String, wqp> jdField_a_of_type_JavaUtilMap;
  private wqo jdField_a_of_type_Wqo;
  
  static
  {
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/yellow2x2019083001.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/green2x2019083001.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/purple2x2019083001.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/blue2x2019083001.png");
    b.add("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/android/video_story_ptv_pendant_enter.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none1.png");
    b.add("https://qd.myapp.com/myapp/qqteam/youqingzhiyuan/more.png");
  }
  
  wql(bhcw parambhcw, AEBottomListScrollView paramAEBottomListScrollView, bgxh parambgxh)
  {
    this.jdField_a_of_type_Bhcw = parambhcw;
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Bgxh = parambgxh;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bgxx = ((bgxx)bhfm.a(18));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  private void a(String paramString, bgya parambgya)
  {
    if (!new File(paramString).exists())
    {
      this.jdField_a_of_type_Bgxx.g();
      this.jdField_a_of_type_Bgxx.a(this.jdField_a_of_type_Bgxx.a(), parambgya, this.jdField_a_of_type_Bgxw);
    }
  }
  
  private void c()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "###  preDownLoadResources");
    a(wqf.b, wtq.c());
    a("/storage/emulated/0/Tencent/MobileQQ/dov_ptv_template_dov/ptv_template_usable/AISceneLoading/", wtq.b());
    a("/storage/emulated/0/Tencent/MobileQQ/dov_ptv_template_dov/ptv_template_usable/AutoAISceneAni/", wtq.a());
    a(wqf.c, wtq.d());
  }
  
  private void c(bgya parambgya)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.3(this, parambgya));
    this.jdField_a_of_type_Bhcw.a().getIntent().putExtra("widgetinfo", "camera^" + parambgya.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bgxh.a(this.jdField_a_of_type_Bgya);
  }
  
  public bgya a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (bgya)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public wqp a(ViewGroup paramViewGroup, int paramInt)
  {
    return new wqp(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131497000, paramViewGroup, false), this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(bgya.jdField_a_of_type_Bgya);
    bgya localbgya = new bgya();
    localbgya.jdField_a_of_type_JavaLangString = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(localbgya);
      i += 1;
    }
    this.jdField_a_of_type_Bgxx.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(bgya parambgya)
  {
    if ((parambgya != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
    {
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.remove(1);
        this.jdField_a_of_type_JavaUtilList.add(1, parambgya);
        this.jdField_a_of_type_Bgxx.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
        notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(1, parambgya);
    this.jdField_a_of_type_Bgxx.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    notifyDataSetChanged();
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(List<bgya> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(bgya.jdField_a_of_type_Bgya);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new bgya();
      paramList.jdField_a_of_type_JavaLangString = "call_material_id";
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    this.jdField_a_of_type_Bgxx.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
    c();
  }
  
  public void a(wqo paramwqo)
  {
    this.jdField_a_of_type_Wqo = paramwqo;
  }
  
  public void a(wqp paramwqp)
  {
    super.onViewAttachedToWindow(paramwqp);
    if ((paramwqp.jdField_a_of_type_Bgya != null) && (!TextUtils.isEmpty(paramwqp.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.put(paramwqp.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString, paramwqp);
    }
  }
  
  public void a(wqp paramwqp, int paramInt)
  {
    paramwqp.a((bgya)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public void b()
  {
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public void b(bgya parambgya)
  {
    if (!FeatureManager.isBasicFeaturesFunctionReady())
    {
      bbmy.a(BaseApplicationImpl.getContext(), ajjy.a(2131650612), 0).a();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
    }
    label185:
    do
    {
      int i;
      do
      {
        return;
        if (parambgya != null) {}
        for (;;)
        {
          this.jdField_a_of_type_Bgya = parambgya;
          if ((this.jdField_a_of_type_Bgya == null) || ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString))) {
            break;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Bgya.a()) && (!this.jdField_a_of_type_Bgya.equals(bgya.jdField_a_of_type_Bgya))) {
            break label185;
          }
          this.jdField_a_of_type_Bgxx.a(this.jdField_a_of_type_Bgya, false);
          QLog.d(jdField_a_of_type_JavaLangString, 4, "### [bottom list] select material none");
          if (this.jdField_a_of_type_Bgxh != null) {
            this.jdField_a_of_type_Bgxh.a(null);
          }
          this.jdField_a_of_type_Bhcw.a().getIntent().removeExtra("widgetinfo");
          return;
          i = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.a();
          if (i >= getItemCount()) {
            break;
          }
          parambgya = a(i);
        }
        if (!this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
          break;
        }
      } while (this.jdField_a_of_type_Wqo == null);
      this.jdField_a_of_type_Wqo.a();
      return;
      if (this.jdField_a_of_type_Bgya.d)
      {
        c(this.jdField_a_of_type_Bgya);
        i = AEBeautyProviderView.a();
        this.jdField_a_of_type_Bgxh.a(i);
        i = AEBeautyProviderView.b();
        this.jdField_a_of_type_Bgxh.b(i);
        return;
      }
    } while ((this.jdField_a_of_type_Bgya.e) || (this.jdField_a_of_type_Bgya.d) || (TextUtils.isEmpty(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bgxx == null));
    if (!badq.g(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.getContext()))
    {
      bcec.a().a(ajjy.a(2131650607));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "start download template runnable");
    }
    this.jdField_a_of_type_Bgxx.a(this.jdField_a_of_type_Bgxx.a(), this.jdField_a_of_type_Bgya, this.jdField_a_of_type_Bgxw);
  }
  
  public void b(wqp paramwqp)
  {
    super.onViewDetachedFromWindow(paramwqp);
    if ((paramwqp.jdField_a_of_type_Bgya != null) && (!TextUtils.isEmpty(paramwqp.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramwqp.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return super.getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wql
 * JD-Core Version:    0.7.0.1
 */