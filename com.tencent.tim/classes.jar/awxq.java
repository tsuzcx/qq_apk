import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.2;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.5;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class awxq
  extends RecyclerView.Adapter<awxq.b>
{
  private static List<String> Mc = new ArrayList();
  public static int bSZ;
  private static boolean dtx;
  public static int mSelectedPos;
  private List<axbu> Mb;
  private awxq.a jdField_a_of_type_Awxq$a;
  private axbr jdField_a_of_type_Axbr;
  private axbu jdField_a_of_type_Axbu;
  private axcc.b jdField_a_of_type_Axcc$b = new awxu(this);
  private axgf jdField_a_of_type_Axgf;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  public awtq c;
  private awwk c;
  private INetEventHandler d = new awxr(this);
  private Map<String, awxq.b> qz;
  
  static
  {
    Mc.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/yellow2x2019083001.png");
    Mc.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/green2x2019083001.png");
    Mc.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/purple2x2019083001.png");
    Mc.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/blue2x2019083001.png");
    Mc.add("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/android/video_story_ptv_pendant_enter.png");
    Mc.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none1.png");
    Mc.add("https://qd.myapp.com/myapp/qqteam/youqingzhiyuan/more.png");
  }
  
  awxq(awtq paramawtq, AEBottomListScrollView paramAEBottomListScrollView, awwk paramawwk)
  {
    this.jdField_c_of_type_Awtq = paramawtq;
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_c_of_type_Awwk = paramawwk;
    this.Mb = new ArrayList();
    this.jdField_a_of_type_Axbr = ((axbr)axov.a(18));
    this.qz = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), this.d);
    this.jdField_a_of_type_Axgf = ((axgf)awuh.a(this.jdField_c_of_type_Awtq).b(axgf.class));
  }
  
  private void b(axbz paramaxbz)
  {
    if ((paramaxbz != null) && (!paramaxbz.isUsable())) {
      this.jdField_a_of_type_Axbr.a(this.jdField_a_of_type_Axbr.a(), paramaxbz.cTH, paramaxbz, this.jdField_a_of_type_Axcc$b);
    }
  }
  
  private void e(axbu paramaxbu)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.5(this, paramaxbu));
    if (this.jdField_a_of_type_Axgf.bz())
    {
      this.jdField_c_of_type_Awwk.b(this.jdField_a_of_type_Axbu);
      return;
    }
    axiy.e("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
  }
  
  public awxq.b a(ViewGroup paramViewGroup, int paramInt)
  {
    return new awxq.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563313, paramViewGroup, false), this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView);
  }
  
  public axbu a(int paramInt)
  {
    if ((this.Mb != null) && (this.Mb.size() > paramInt)) {
      return (axbu)this.Mb.get(paramInt);
    }
    return null;
  }
  
  public void a(awxq.a parama)
  {
    this.jdField_a_of_type_Awxq$a = parama;
  }
  
  public void a(awxq.b paramb)
  {
    super.onViewAttachedToWindow(paramb);
    if ((paramb.c != null) && (!TextUtils.isEmpty(paramb.c.id))) {
      this.qz.put(paramb.c.id, paramb);
    }
  }
  
  public void a(awxq.b paramb, int paramInt)
  {
    paramb.f((axbu)this.Mb.get(paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
  }
  
  public void b(awxq.b paramb)
  {
    super.onViewDetachedFromWindow(paramb);
    if ((paramb.c != null) && (!TextUtils.isEmpty(paramb.c.id))) {
      this.qz.remove(paramb.c.id);
    }
  }
  
  public void c(axbu paramaxbu)
  {
    if ((paramaxbu != null) && (this.Mb.size() >= 1))
    {
      if (dtx)
      {
        this.Mb.remove(1);
        this.Mb.add(1, paramaxbu);
        this.jdField_a_of_type_Axbr.oD(new LinkedList(this.Mb));
        notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.Mb.add(1, paramaxbu);
    this.jdField_a_of_type_Axbr.oD(new LinkedList(this.Mb));
    notifyDataSetChanged();
    dtx = true;
  }
  
  public void d(axbu paramaxbu)
  {
    if (!FeatureManager.isBasicFeaturesFunctionReady())
    {
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131716462), 0).show();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
    }
    for (;;)
    {
      return;
      if (paramaxbu != null) {}
      int i;
      for (;;)
      {
        this.jdField_a_of_type_Axbu = paramaxbu;
        if ((this.jdField_a_of_type_Axbu == null) || ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Axbu.id))) {
          break;
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_Axbu.id)) && (!this.jdField_a_of_type_Axbu.isWsBanner()) && (!this.jdField_a_of_type_Axbu.equals(axbu.i))) {
          break label185;
        }
        this.jdField_a_of_type_Axbr.b(this.jdField_a_of_type_Axbu, false);
        QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
        if (this.jdField_c_of_type_Awwk != null) {
          this.jdField_c_of_type_Awwk.b(null);
        }
        this.jdField_c_of_type_Awtq.getActivity().getIntent().removeExtra("widgetinfo");
        return;
        i = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getCurrentItem();
        if (i >= getItemCount()) {
          break;
        }
        paramaxbu = a(i);
      }
      label185:
      if (this.jdField_a_of_type_Axbu.id.equals("call_material_id"))
      {
        if (this.jdField_a_of_type_Awxq$a != null) {
          this.jdField_a_of_type_Awxq$a.eHw();
        }
      }
      else
      {
        if (this.jdField_a_of_type_Axbu.usable)
        {
          e(this.jdField_a_of_type_Axbu);
          i = AEBeautyProviderView.QU();
          this.jdField_c_of_type_Awwk.setBeautyLevel(i);
          i = AEBeautyProviderView.QV();
          this.jdField_c_of_type_Awwk.setSharpFaceLevel(i);
          return;
        }
        if ((!this.jdField_a_of_type_Axbu.downloading) && (!this.jdField_a_of_type_Axbu.usable) && (!TextUtils.isEmpty(this.jdField_a_of_type_Axbu.id)) && (this.jdField_a_of_type_Axbr != null))
        {
          if (!aqiw.isNetworkAvailable(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
          {
            arxa.a().showToast(acfp.m(2131716460));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.videostory.capture", 2, "start download template runnable");
          }
          if (!aqiw.isWifiConnected(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
          {
            paramaxbu = aqha.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), 230).setTitle(acfp.m(2131711237)).setMessage(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131700433)).setPositiveButton(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131721079), new awxt(this)).setNegativeButton(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131721058), new awxs(this));
            if (paramaxbu == null) {
              continue;
            }
            try
            {
              if (!paramaxbu.isShowing())
              {
                paramaxbu.show();
                return;
              }
            }
            catch (Throwable paramaxbu)
            {
              paramaxbu.printStackTrace();
              return;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Axbr.a(this.jdField_a_of_type_Axbr.a(), this.jdField_a_of_type_Axbu, this.jdField_a_of_type_Axcc$b);
  }
  
  public void eHu()
  {
    this.Mb.clear();
    this.Mb.add(axbu.i);
    axbu localaxbu = new axbu();
    localaxbu.id = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.Mb.add(localaxbu);
      i += 1;
    }
    this.jdField_a_of_type_Axbr.oD(new LinkedList(this.Mb));
    dtx = false;
    notifyDataSetChanged();
  }
  
  public void eHv()
  {
    QLog.d("AEBottomListAdapter", 4, "###  preDownLoadResources");
    b(awxe.c());
    b(awxe.b());
    b(awxe.a());
  }
  
  public int getItemCount()
  {
    if (this.Mb != null) {
      return this.Mb.size();
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
  
  public void oA(List<axbu> paramList)
  {
    this.Mb.clear();
    this.Mb.add(axbu.i);
    this.Mb.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new axbu();
      paramList.id = "call_material_id";
      this.Mb.add(paramList);
    }
    this.jdField_a_of_type_Axbr.oD(new LinkedList(this.Mb));
    dtx = false;
    notifyDataSetChanged();
    eHv();
  }
  
  public void onDestroy()
  {
    AppNetConnInfo.unregisterNetEventHandler(this.d);
  }
  
  public static abstract interface a
  {
    public abstract void eHw();
  }
  
  public static class b
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private ImageView HS;
    private ImageView HT;
    private ImageView HU;
    private AEBottomListScrollView b;
    public axbu c;
    private ImageView mIcon;
    private ProgressBar mProgressBar;
    private RelativeLayout nR;
    
    public b(View paramView, AEBottomListScrollView paramAEBottomListScrollView)
    {
      super();
      this.HS = ((ImageView)paramView.findViewById(2131381812));
      this.mIcon = ((ImageView)paramView.findViewById(2131381819));
      this.mProgressBar = ((ProgressBar)paramView.findViewById(2131381825));
      this.HT = ((ImageView)paramView.findViewById(2131381826));
      this.HU = ((ImageView)paramView.findViewById(2131381821));
      this.nR = ((RelativeLayout)paramView.findViewById(2131381877));
      this.b = paramAEBottomListScrollView;
    }
    
    public void adx(int paramInt)
    {
      switch (paramInt)
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
        do
        {
          do
          {
            do
            {
              return;
            } while (this.mProgressBar == null);
            this.mProgressBar.setVisibility(8);
            return;
          } while (this.mProgressBar == null);
          this.mProgressBar.setVisibility(0);
          return;
        } while (this.mProgressBar == null);
        this.mProgressBar.setVisibility(8);
        return;
      case 3: 
        if (this.HU != null) {
          this.HU.setVisibility(0);
        }
        if (this.c.editablewatermark)
        {
          this.nR.setVisibility(0);
          return;
        }
        this.nR.setVisibility(4);
        return;
      }
      if (this.HU != null) {
        this.HU.setVisibility(4);
      }
      this.nR.setVisibility(4);
    }
    
    public void f(axbu paramaxbu)
    {
      this.c = paramaxbu;
      if (this.c != null)
      {
        this.nR.setVisibility(4);
        if ((!"0".equals(this.c.id)) && (!"call_material_id".equals(this.c.id))) {
          break label206;
        }
        this.HS.setVisibility(0);
        this.mProgressBar.setVisibility(8);
        this.HT.setVisibility(8);
        this.mIcon.setVisibility(8);
        if (!this.c.needDisplayType()) {
          break label566;
        }
        this.HT.setVisibility(0);
        this.HT.setImageResource(this.c.getDisplayIconByType());
      }
      for (;;)
      {
        this.itemView.setOnClickListener(this);
        paramaxbu = gP(getAdapterPosition());
        this.HS.setTag(2131379238, paramaxbu);
        this.HS.setTag(2131379203, Boolean.valueOf(false));
        rpq.a(this.HS, paramaxbu, rpq.dip2px(this.itemView.getContext(), 54.0F), rpq.dip2px(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130851882), null);
        return;
        label206:
        if ("stub_placeholder_material_id".equals(this.c.id))
        {
          this.HS.setVisibility(0);
          this.mProgressBar.setVisibility(8);
          this.HT.setVisibility(8);
          this.mIcon.setVisibility(0);
          this.mIcon.setImageResource(2130845452);
          break;
        }
        if (this.c.isWsBanner())
        {
          this.HS.setVisibility(8);
          this.mIcon.setVisibility(0);
          this.mIcon.setTag(2131379238, this.c.iconurl);
          this.mIcon.setTag(2131379203, Boolean.valueOf(false));
          rpq.a(this.mIcon, this.c.iconurl, rpq.dip2px(this.itemView.getContext(), 54.0F), rpq.dip2px(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130851882), null);
          this.mIcon.setVisibility(0);
          this.mProgressBar.setVisibility(8);
          this.HT.setVisibility(0);
          this.HT.setImageResource(2130846856);
          break;
        }
        this.HS.setVisibility(0);
        this.mIcon.setVisibility(0);
        this.mIcon.setTag(2131379238, this.c.iconurl);
        this.mIcon.setTag(2131379203, Boolean.valueOf(false));
        rpq.a(this.mIcon, this.c.iconurl, rpq.dip2px(this.itemView.getContext(), 54.0F), rpq.dip2px(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130851882), null);
        if (this.c.usable) {
          adx(2);
        }
        for (;;)
        {
          this.HT.setVisibility(8);
          break;
          if (this.c.downloading) {
            adx(1);
          } else {
            adx(0);
          }
        }
        label566:
        if (this.c.isWsBanner())
        {
          this.HT.setVisibility(0);
          this.HT.setImageResource(2130846856);
        }
        else
        {
          this.HT.setVisibility(8);
        }
      }
    }
    
    public void g(axbu paramaxbu)
    {
      this.c = paramaxbu;
    }
    
    protected String gP(int paramInt)
    {
      if (this.c.id.equals("0")) {
        return (String)awxq.hF().get(5);
      }
      if (this.c.id.equals("call_material_id")) {
        return (String)awxq.hF().get(6);
      }
      if (awxq.dtx) {
        if (paramInt == 1) {
          paramInt = 3;
        }
      }
      for (;;)
      {
        return (String)awxq.hF().get(paramInt);
        paramInt = (paramInt - 1 - 1) % 4;
        continue;
        paramInt = (paramInt - 1) % 4;
      }
    }
    
    public void onClick(View paramView)
    {
      int i = getAdapterPosition();
      if ((this.b != null) && (i >= 0))
      {
        awxq.bSZ = awxq.mSelectedPos;
        awxq.mSelectedPos = i;
        this.b.smoothScrollToPosition(i);
      }
      if ((this.c != null) && ("call_material_id".equals(this.c.id)))
      {
        axim.a().eLd();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      axip.a().acV("none");
      axip.a().acU("2");
      axip.a().LB(0);
      label104:
      Object localObject2;
      if (i == 0)
      {
        axip.a().adX(-1);
        localObject2 = axim.a();
        if (this.c != null) {
          break label217;
        }
        localObject1 = "";
        label119:
        ((axim)localObject2).acK((String)localObject1);
        localObject2 = new StringBuilder().append("【Click】Item :");
        if (this.c != null) {
          break label228;
        }
        localObject1 = "";
        label149:
        axiy.i("AEBottomListAdapter", (String)localObject1);
        localObject2 = new StringBuilder().append("【Click】Usable :");
        if (this.c != null) {
          break label239;
        }
      }
      label217:
      label228:
      label239:
      for (Object localObject1 = "";; localObject1 = Boolean.valueOf(this.c.usable))
      {
        axiy.i("AEBottomListAdapter", localObject1);
        break;
        axip.a().adX(i);
        break label104;
        localObject1 = this.c.id;
        break label119;
        localObject1 = this.c.id;
        break label149;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxq
 * JD-Core Version:    0.7.0.1
 */