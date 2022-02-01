import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.3;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.6;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axpa
  extends BaseAdapter
  implements anho
{
  public static String bec = "";
  public static String cVC = "0";
  public static boolean dvK;
  public static boolean dvL;
  public static boolean dvM;
  public static int eGs;
  public static int eGt;
  public axpa.a a;
  public ayzs a;
  private ProviderView.a jdField_a_of_type_DovComQqImCaptureViewProviderView$a;
  private PtvTemplateManager.b jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$b = new axpc(this);
  public PtvTemplateManager.PtvTemplateInfo b;
  public PtvTemplateManager.PtvTemplateInfo c;
  public int cju = 1;
  public GridView e;
  public int eCJ;
  private aqju m;
  public Context mContext;
  private int mCurrentPosition;
  float mDensity;
  public ArrayList<PtvTemplateManager.PtvTemplateInfo> mTemplateList = new ArrayList();
  
  public axpa(Context paramContext, GridView paramGridView, ProviderView.a parama, int paramInt)
  {
    this.jdField_a_of_type_Axpa$a = new axpb(this);
    this.mContext = paramContext;
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    this.e = paramGridView;
    this.jdField_a_of_type_Ayzs = ((ayzs)axov.a(3));
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a = parama;
    this.eCJ = paramInt;
  }
  
  public int a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    int i = 0;
    if (i < this.mTemplateList.size()) {
      if (!((PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(i)).id.equals(paramPtvTemplateInfo.id)) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPtvTemplateManager", 2, "PtvTemplateAdapter getTemplatePosFromOut: " + i);
      }
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(int paramInt)
  {
    if (paramInt >= this.mTemplateList.size()) {
      return null;
    }
    return (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(paramInt);
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (!FeatureManager.isBasicFeaturesFunctionReady())
    {
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131711234), 0).show();
      ThreadManager.excute(new QIMPtvTemplateAdapter.3(this), 64, null, true);
      return;
    }
    if (paramPtvTemplateInfo != null) {}
    int i;
    for (;;)
    {
      this.c = this.b;
      this.b = paramPtvTemplateInfo;
      if ((!TextUtils.isEmpty(this.b.id)) && (!this.b.id.equals("0"))) {
        break label262;
      }
      eGs = paramPtvTemplateInfo.categoryId;
      cVC = paramPtvTemplateInfo.id;
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a.a(null, "");
        bec = "";
        if ((aaqh.cix == 2) && (cVC.equals("0")) && (eGs == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, "onDrawBeautyFeature is in back_camera && no template is selected");
          }
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a.aev(0);
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a.aew(-1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "setVideoFilter null");
        }
      }
      this.jdField_a_of_type_Ayzs.F(113, null);
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a.adg(null);
      }
      this.jdField_a_of_type_Ayzs.adM(cVC);
      return;
      i = this.mCurrentPosition;
      if (i >= this.mTemplateList.size()) {
        break;
      }
      paramPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(i);
    }
    label262:
    if (this.b.usable)
    {
      eGs = paramPtvTemplateInfo.categoryId;
      cVC = paramPtvTemplateInfo.id;
      String str = ayzs.bYM + this.b.name;
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "setVideoFilter " + str + " kind " + this.b.kind);
        }
        if (this.b.kind == 3)
        {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a.adg(str);
          str = "";
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a.a(this.b, str);
          bec = str;
          i = AdvancedProviderView.QU();
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a.aev(i);
          i = AdvancedProviderView.QV();
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a.aew(i);
        }
      }
      else
      {
        this.jdField_a_of_type_Ayzs.c(paramPtvTemplateInfo, 111);
        this.jdField_a_of_type_Ayzs.F(113, null);
        this.jdField_a_of_type_Ayzs.adM(cVC);
      }
    }
    for (;;)
    {
      aytq.ao("", "0X80075BA", this.b.id);
      if (this.b.kind == 3) {
        aytq.ao("", "0X80083B9", this.b.id);
      }
      rar.b((Activity)this.mContext, "face_element", String.valueOf(this.b.categoryId), this.b.id);
      return;
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$a.adg(null);
      break;
      if ((!this.b.downloading) && (!TextUtils.isEmpty(this.b.id)) && (this.jdField_a_of_type_Ayzs != null)) {
        if ((this.b.kind == 3) && (aqiw.isMobileNetWork(this.mContext)))
        {
          if (this.m == null) {
            this.m = aqha.a(this.mContext, 230).setTitle(acfp.m(2131711237)).setMessage(this.mContext.getString(2131700433)).setPositiveButton(this.mContext.getString(2131721079), new axpe(this)).setNegativeButton(this.mContext.getString(2131721058), new axpd(this));
          }
          try
          {
            if ((this.m == null) || (this.m.isShowing())) {
              continue;
            }
            this.m.show();
          }
          catch (Throwable paramPtvTemplateInfo) {}
        }
        else
        {
          ThreadManager.excute(new QIMPtvTemplateAdapter.6(this), 128, null, true);
          axxj.a(this.b).start();
          ayuy.c("shortvideo_download_effects", null);
        }
      }
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "PtvTemplateAdapter selectPtvTemplateFromout");
    }
    this.mCurrentPosition = paramInt;
    eGt = paramInt;
    a(paramPtvTemplateInfo);
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 111) {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1))
      {
        oI(((axql)paramVarArgs[0]).Fv);
        notifyDataSetChanged();
      }
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    label209:
    do
    {
      return;
      while (!paramVarArgs.hasNext())
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                if (paramInt == 112) {
                  if ((paramVarArgs != null) && (paramVarArgs.length == 1))
                  {
                    paramObject = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs[0];
                    paramVarArgs = this.mTemplateList.iterator();
                    if (paramVarArgs.hasNext())
                    {
                      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs.next();
                      if (!paramObject.id.equals(localPtvTemplateInfo.id)) {
                        break;
                      }
                      localPtvTemplateInfo.downloading = false;
                      localPtvTemplateInfo.usable = true;
                      notifyDataSetChanged();
                      return;
                    }
                  }
                }
              }
              if (paramInt == 113)
              {
                notifyDataSetInvalidated();
                return;
              }
              if (paramInt != 114) {
                break label209;
              }
            } while ((paramVarArgs == null) || (paramVarArgs.length != 1));
            paramObject = (VideoMaterial)paramVarArgs[0];
            paramVarArgs = this.mTemplateList.iterator();
          } while (!paramVarArgs.hasNext());
          localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs.next();
          if ((paramObject == null) || (!paramObject.getId().equals(localPtvTemplateInfo.id))) {
            break;
          }
          localPtvTemplateInfo.editablewatermark = true;
          notifyDataSetChanged();
          return;
        } while ((paramInt != 115) || (paramVarArgs == null) || (paramVarArgs.length != 1));
        paramObject = (VideoMaterial)paramVarArgs[0];
        paramVarArgs = this.mTemplateList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs.next();
    } while ((paramObject == null) || (paramObject.getId() == null) || (!paramObject.getId().equals(localPtvTemplateInfo.id)));
    localPtvTemplateInfo.editablewatermark = false;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.mTemplateList.isEmpty()) {
      return 0;
    }
    return this.mTemplateList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a(paramInt);
    PtvTemplateItemView localPtvTemplateItemView;
    if ((paramView == null) || (!(paramView instanceof PtvTemplateItemView)))
    {
      localPtvTemplateItemView = new PtvTemplateItemView(this.mContext);
      localPtvTemplateItemView.initViews();
    }
    for (;;)
    {
      localPtvTemplateItemView.a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(paramInt), this.jdField_a_of_type_Axpa$a, eGs, cVC, dvK);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localPtvTemplateItemView;
      localPtvTemplateItemView = (PtvTemplateItemView)paramView;
    }
  }
  
  public void oI(List<PtvTemplateManager.PtvTemplateInfo> paramList)
  {
    int i = 0;
    try
    {
      this.mTemplateList.clear();
      this.mCurrentPosition = 0;
      while (i < this.cju)
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
        localPtvTemplateInfo.id = "0";
        localPtvTemplateInfo.categoryId = 0;
        this.mTemplateList.add(localPtvTemplateInfo);
        i += 1;
      }
      this.mTemplateList.addAll(paramList);
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void Gr(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axpa
 * JD-Core Version:    0.7.0.1
 */