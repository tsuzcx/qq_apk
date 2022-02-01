import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.camera.ui.panel.AEGridView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.1;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.3;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.4;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel.a;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class awzj
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, anho, axcc.b
{
  private axbr a;
  private AEGridView jdField_b_of_type_DovComQqImAeCameraUiPanelAEGridView;
  private AEMaterialPanel.a jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$a;
  public axbu d;
  private boolean dtG;
  private final Context mContext;
  private final LayoutInflater mLayoutInflater;
  public ArrayList<axbu> mTemplateList = new ArrayList();
  
  public awzj(Context paramContext, AEGridView paramAEGridView, AEMaterialPanel.a parama, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.a = ((axbr)axov.a(18));
    this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$a = parama;
    this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEGridView = paramAEGridView;
    this.dtG = paramBoolean;
  }
  
  private int a(axbu paramaxbu)
  {
    int i = 0;
    while (i < this.mTemplateList.size())
    {
      if (((axbu)this.mTemplateList.get(i)).id.equals(paramaxbu.id)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void b(axbu paramaxbu, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramaxbu == null) {}
    label399:
    for (;;)
    {
      return;
      axip.a().adX(-1);
      axip.a().acV("none");
      axip.a().acU("1");
      axip.a().LB(0);
      Object localObject;
      if (paramaxbu != null)
      {
        axim.a().acK(paramaxbu.id);
        axiy.i("AEMaterialAdapter", "【Select Material】：" + paramaxbu.id);
        axiy.i("AEMaterialAdapter", "【Select Material】Usable :" + paramaxbu.usable);
        if ((paramaxbu != null) && (!TextUtils.isEmpty(paramaxbu.id)) && (!axbu.e(paramaxbu))) {
          break label216;
        }
        if (this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$a != null) {
          this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$a.eGk();
        }
        paramaxbu = this.a;
        localObject = axbu.i;
        if (this.dtG) {
          break label211;
        }
      }
      for (;;)
      {
        paramaxbu.b((axbu)localObject, bool1);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        ((Activity)this.mContext).getIntent().removeExtra("widgetinfo");
        return;
        axim.a().acK("null");
        axiy.i("AEMaterialAdapter", "【Select Material】：null");
        break;
        label211:
        bool1 = false;
      }
      label216:
      if (paramaxbu.isWsBanner())
      {
        rpw.a(this.mContext, paramaxbu);
        return;
      }
      if (paramaxbu.usable)
      {
        if (!FeatureManager.isBasicFeaturesFunctionReady())
        {
          QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131711234), 0).show();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        if (this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$a != null) {
          this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$a.a(paramaxbu);
        }
        localObject = this.a;
        if (!this.dtG)
        {
          bool1 = bool2;
          ((axbr)localObject).b(paramaxbu, bool1);
          QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + paramaxbu.id);
        }
      }
      for (;;)
      {
        if (this.dtG) {
          break label399;
        }
        if ((!(this.mContext instanceof Activity)) || (!axcg.ay(((Activity)this.mContext).getIntent()))) {
          break label401;
        }
        this.a.w(paramaxbu);
        return;
        bool1 = false;
        break;
        j(paramaxbu);
      }
    }
    label401:
    this.a.v(paramaxbu);
  }
  
  private void bG(boolean paramBoolean, Object paramObject)
  {
    paramObject = (VideoMaterial)paramObject;
    if (paramObject == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mTemplateList.size())
      {
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((axbu)this.mTemplateList.get(i)).id)))
        {
          ((axbu)this.mTemplateList.get(i)).editablewatermark = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void j(axbu paramaxbu)
  {
    if (paramaxbu == null) {}
    while ((paramaxbu.downloading) || (TextUtils.isEmpty(paramaxbu.id)) || (this.a == null)) {
      return;
    }
    if (!aqiw.isMobileNetWork(this.mContext))
    {
      l(paramaxbu);
      return;
    }
    k(paramaxbu);
  }
  
  private void k(axbu paramaxbu)
  {
    paramaxbu = aqha.a(this.mContext, 230).setTitle(acfp.m(2131711237)).setMessage(this.mContext.getString(2131700433)).setPositiveButton(this.mContext.getString(2131721079), new awzl(this, paramaxbu)).setNegativeButton(this.mContext.getString(2131721058), new awzk(this));
    if (paramaxbu != null) {}
    try
    {
      if (!paramaxbu.isShowing()) {
        paramaxbu.show();
      }
      return;
    }
    catch (Throwable paramaxbu) {}
  }
  
  private void l(axbu paramaxbu)
  {
    this.a.a(this.a.a(), paramaxbu, this);
  }
  
  public void a(axbu paramaxbu, int paramInt)
  {
    paramInt = a(paramaxbu);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
  
  public void a(axbu paramaxbu, boolean paramBoolean)
  {
    if (paramaxbu == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = a(paramaxbu);
      } while (i <= 0);
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, i, paramaxbu, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113) {
      if (axbr.b() != null) {
        notifyDataSetChanged();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 111) {
            break;
          }
        } while ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!this.dtG));
        oC(((axbq)paramVarArgs[0]).Mm);
        notifyDataSetChanged();
        return;
        if (paramInt != 114) {
          break;
        }
      } while ((paramVarArgs == null) || (paramVarArgs.length != 1));
      bG(true, paramVarArgs[0]);
      return;
    } while ((paramInt != 115) || (paramVarArgs == null) || (paramVarArgs.length != 1));
    bG(false, paramVarArgs[0]);
  }
  
  public int getItemCount()
  {
    if (this.mTemplateList == null) {
      return 0;
    }
    return this.mTemplateList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public void i(axbu paramaxbu)
  {
    b(paramaxbu, a(paramaxbu));
  }
  
  public void oC(List<axbu> paramList)
  {
    this.mTemplateList.clear();
    this.mTemplateList.add(axbu.i);
    this.mTemplateList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    axbu localaxbu = (axbu)this.mTemplateList.get(paramInt);
    if (localaxbu == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject;
      if ((paramViewHolder instanceof awzx))
      {
        localObject = (awzx)paramViewHolder;
        if (localaxbu.equals(axbr.b())) {
          ((awzx)localObject).eIj();
        } else {
          ((awzx)localObject).eIk();
        }
      }
      else if ((paramViewHolder instanceof awzy))
      {
        localObject = (awzy)paramViewHolder;
        if ((localaxbu.equals(axbr.b())) && (localaxbu.usable))
        {
          ((awzy)localObject).b(2, localaxbu);
        }
        else
        {
          localaxbu.editablewatermark = false;
          ((awzy)localObject).b(1, localaxbu);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEGridView.getChildAdapterPosition(paramView);
    if (i == -1)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    axbu localaxbu = (axbu)this.mTemplateList.get(i);
    if ((this.d != null) && (!this.d.equals(localaxbu)))
    {
      this.d.dtW = false;
      this.d.dtX = false;
    }
    this.d = localaxbu;
    if (localaxbu.dtW) {
      localaxbu.dtX = true;
    }
    for (;;)
    {
      b(localaxbu, i);
      break;
      localaxbu.dtW = true;
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.mLayoutInflater.inflate(2131558566, paramViewGroup, false);
      paramViewGroup = new awzx(localView);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.mLayoutInflater.inflate(2131558565, paramViewGroup, false);
      paramViewGroup = new awzy(localView);
      paramViewGroup.init(this.mContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzj
 * JD-Core Version:    0.7.0.1
 */