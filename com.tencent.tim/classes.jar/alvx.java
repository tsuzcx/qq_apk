import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView.a;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateItemView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class alvx
  extends BaseAdapter
  implements anho
{
  private alvx.a jdField_a_of_type_Alvx$a = new alvy(this);
  alwd jdField_a_of_type_Alwd;
  private alwl jdField_a_of_type_Alwl;
  private ProviderView.a jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a;
  private PtvTemplateManager.b jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$b = new alvz(this);
  public PtvTemplateManager.PtvTemplateInfo b;
  public String bec = "";
  public int cju = 1;
  boolean czH = true;
  public GridView e;
  AppInterface mApp;
  Context mContext;
  private int mCurrentPosition;
  float mDensity;
  boolean mIsShow = false;
  public ArrayList<PtvTemplateManager.PtvTemplateInfo> mTemplateList = new ArrayList();
  
  public alvx(AppInterface paramAppInterface, Context paramContext, GridView paramGridView, ProviderView.a parama, alwl paramalwl, boolean paramBoolean)
  {
    this.mApp = paramAppInterface;
    this.mContext = paramContext;
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    this.e = paramGridView;
    this.jdField_a_of_type_Alwd = alwd.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a = parama;
    this.jdField_a_of_type_Alwl = paramalwl;
    this.czH = paramBoolean;
  }
  
  private void Tu(int paramInt)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo1 = alwd.a().b();
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo2 = (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(paramInt);
    if ((localPtvTemplateInfo2 != null) && (localPtvTemplateInfo1 != null) && (localPtvTemplateInfo1.id.equals(localPtvTemplateInfo2.id)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "checkChooseFilter  name=" + localPtvTemplateInfo1.name);
      }
      if ((localPtvTemplateInfo1.usable) || (!localPtvTemplateInfo1.downloading)) {
        Tv(paramInt);
      }
      this.mIsShow = true;
    }
  }
  
  public void Tv(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mTemplateList.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      return;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(paramInt);
    } while (localPtvTemplateInfo == null);
    this.mCurrentPosition = paramInt;
    alwd.a().c(localPtvTemplateInfo);
    if (!localPtvTemplateInfo.id.equals("0"))
    {
      alwd localalwd = alwd.a();
      localalwd.b(localPtvTemplateInfo, 111);
      localalwd.I(3, localPtvTemplateInfo.categoryId, localPtvTemplateInfo.id);
    }
    this.b = localPtvTemplateInfo;
    alwd.a().F(114, this.jdField_a_of_type_Alwl);
    if ((TextUtils.isEmpty(this.b.id)) || (this.b.id.equals("0")))
    {
      dJX();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a.a(localPtvTemplateInfo, this.bec);
      }
      alwd.a().c(null);
      alwd.a().F(113, null);
      return;
    }
    if (this.b.usable)
    {
      this.bec = alwd.bt(this.b.name, this.b.md5);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a.a(localPtvTemplateInfo, this.bec);
      }
      alwd.a().F(113, null);
    }
    for (;;)
    {
      aqmj.eeo();
      return;
      if ((!this.b.downloading) && (!TextUtils.isEmpty(this.b.id)) && (this.jdField_a_of_type_Alwd != null))
      {
        this.jdField_a_of_type_Alwd.a(this.mApp, this.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$b);
        this.b.downloading = true;
        aasp.c("shortvideo_download_effects", null);
      }
    }
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(int paramInt)
  {
    if (paramInt >= this.mTemplateList.size()) {
      return null;
    }
    return (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(paramInt);
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 111)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1))
      {
        aa(((alwl)paramVarArgs[0]).Fv, 1);
        notifyDataSetChanged();
      }
      return;
      break label66;
    }
    label66:
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
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs.next();
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
    } while (paramInt != 113);
    notifyDataSetChanged();
  }
  
  public void aa(List<PtvTemplateManager.PtvTemplateInfo> paramList, int paramInt)
  {
    int i = 0;
    try
    {
      this.mTemplateList.clear();
      this.mCurrentPosition = paramInt;
      paramInt = i;
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
      while (paramInt < this.cju)
      {
        localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
        localPtvTemplateInfo.id = "0";
        localPtvTemplateInfo.categoryId = 0;
        this.mTemplateList.add(localPtvTemplateInfo);
        paramInt += 1;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramList.next();
        if ((this.czH) || (!localPtvTemplateInfo.advertisement)) {
          this.mTemplateList.add(localPtvTemplateInfo);
        }
      }
      notifyDataSetChanged();
    }
    finally {}
  }
  
  public void dJX()
  {
    this.bec = "";
    this.b = null;
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
    PtvTemplateItemView localPtvTemplateItemView;
    if ((paramView == null) || (!(paramView instanceof PtvTemplateItemView)))
    {
      localPtvTemplateItemView = new PtvTemplateItemView(this.mContext);
      localPtvTemplateItemView.initViews();
    }
    for (;;)
    {
      localPtvTemplateItemView.a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(paramInt), this.jdField_a_of_type_Alvx$a);
      if (!this.mIsShow) {
        Tu(paramInt);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localPtvTemplateItemView;
      localPtvTemplateItemView = (PtvTemplateItemView)paramView;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Gr(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvx
 * JD-Core Version:    0.7.0.1
 */