import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.richmedia.capture.data.FilterDesc;>;

public class axpp
  extends axpn
{
  public float Eq = -1.0F;
  axpp.a a = new axpp.a();
  public FilterDesc d;
  
  public axpp(FilterDesc paramFilterDesc)
  {
    super(paramFilterDesc);
    this.d = paramFilterDesc;
  }
  
  public static int a(Context paramContext, List<FilterDesc> paramList, axpw paramaxpw, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt == 0) {
      j(paramContext, paramList);
    }
    do
    {
      return 0;
      if ((paramInt == 2) || (paramInt == 4))
      {
        if (paramInt == 2) {}
        for (;;)
        {
          aJ(paramList, bool1);
          return 0;
          bool1 = false;
        }
      }
    } while ((paramInt != 1) && (paramInt != 3));
    if (paramInt == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      aI(paramList, bool1);
      return 0;
    }
  }
  
  public static boolean a(axqc paramaxqc, int paramInt)
  {
    if (paramaxqc != null)
    {
      axqc localaxqc = ayva.a().a[paramInt];
      if ((paramaxqc != null) && (localaxqc != null) && (paramaxqc.getUniqueId().equals(localaxqc.getUniqueId()))) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, new Object[] { "isApplying :" + paramaxqc + " ", Boolean.valueOf(bool) });
        }
        return bool;
      }
    }
    return false;
  }
  
  public static void aH(List<FilterDesc> paramList, boolean paramBoolean)
  {
    ayva localayva = ayva.a();
    QQFilterRenderManager localQQFilterRenderManager = awte.a(awte.eCR);
    if (localQQFilterRenderManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForCapture QQFilterRenderManager null");
      }
      return;
    }
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    FilterDesc localFilterDesc;
    if (paramList.hasNext())
    {
      localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc.name.equals("EMPTY")) {
        paramList = null;
      }
    }
    for (;;)
    {
      label83:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("applyFiltersForCapture filters:");
        if (paramList != null) {
          break label181;
        }
      }
      label181:
      for (int i = 0;; i = paramList.size())
      {
        QLog.d("QCombo", 2, i);
        localayva.setCurrentId(null);
        localQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList, paramBoolean);
        return;
        if (localFilterDesc.id == 9)
        {
          ((List)localObject).clear();
          ((List)localObject).add(localFilterDesc);
          paramList = (List<FilterDesc>)localObject;
          break label83;
        }
        ((List)localObject).add(localFilterDesc);
        break;
      }
      paramList = (List<FilterDesc>)localObject;
    }
  }
  
  public static void aI(List<FilterDesc> paramList, boolean paramBoolean)
  {
    boolean bool2 = true;
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    FilterDesc localFilterDesc;
    boolean bool1;
    if (paramList.hasNext())
    {
      localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc.name.equals("EMPTY"))
      {
        localArrayList.clear();
        bool1 = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForEditPic filters:" + localArrayList.size());
      }
      new axpq(bool2, bool1, localArrayList, paramBoolean).execute(new Void[0]);
      return;
      if (localFilterDesc.id == 9)
      {
        localArrayList.clear();
        localArrayList.add(localFilterDesc);
        bool1 = true;
        bool2 = false;
      }
      else
      {
        localArrayList.add(localFilterDesc);
        break;
        bool1 = false;
        bool2 = false;
      }
    }
  }
  
  public static void aJ(List<FilterDesc> paramList, boolean paramBoolean)
  {
    ayva localayva = ayva.a();
    QQFilterRenderManager localQQFilterRenderManager = awte.a(awte.eCS);
    if (localQQFilterRenderManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForEditVideo null manager");
      }
      return;
    }
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    FilterDesc localFilterDesc;
    if (paramList.hasNext())
    {
      localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc.name.equals("EMPTY")) {
        paramList = null;
      }
    }
    for (;;)
    {
      label83:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("applyFiltersForEditVideo filters:");
        if (paramList != null) {
          break label180;
        }
      }
      label180:
      for (int i = 0;; i = paramList.size())
      {
        QLog.d("QCombo", 2, i);
        localQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList);
        localayva.setCurrentId(null);
        return;
        if (localFilterDesc.id == 9)
        {
          ((List)localObject).clear();
          ((List)localObject).add(localFilterDesc);
          paramList = (List<FilterDesc>)localObject;
          break label83;
        }
        ((List)localObject).add(localFilterDesc);
        break;
      }
      paramList = (List<FilterDesc>)localObject;
    }
  }
  
  public static void j(Context paramContext, List<FilterDesc> paramList)
  {
    ayva localayva = ayva.a();
    QQFilterRenderManager localQQFilterRenderManager = awte.a(awte.eCR);
    if ((localQQFilterRenderManager == null) && (awwf.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForCapture QQFilterRenderManager null");
      }
      return;
    }
    paramContext = new ArrayList();
    paramList = paramList.iterator();
    label53:
    FilterDesc localFilterDesc;
    if (paramList.hasNext())
    {
      localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc.name.equals("EMPTY"))
      {
        if (awwf.a() == null) {
          break label351;
        }
        awwf.a().setIsAfterUpdateMaterial(false);
        awwf.a().updateLutGL(null);
        paramContext = null;
      }
    }
    for (;;)
    {
      label108:
      int i;
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder().append("applyFiltersForCapture filters:");
        if (paramContext == null)
        {
          i = 0;
          label133:
          QLog.d("QCombo", 2, i);
        }
      }
      else
      {
        localayva.setCurrentId(null);
        if (localQQFilterRenderManager != null) {
          localQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramContext);
        }
        if ((awwf.a() == null) || (paramContext == null) || (paramContext.size() <= 0)) {
          break;
        }
        paramList = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
        paramContext = (FilterDesc)paramContext.get(0);
        if (TextUtils.isEmpty(paramContext.resRootPath)) {
          break label342;
        }
      }
      label342:
      for (paramContext = paramContext.getResFold(paramContext.resRootPath);; paramContext = paramContext.getResFold(paramList))
      {
        paramList = QQPtColorFilter.getColorFilterInfo(paramContext);
        if (paramList == null) {
          break;
        }
        paramContext = paramContext + paramList.getColorPng();
        if (!new File(paramContext).exists()) {
          break;
        }
        awwf.a().setIsAfterUpdateMaterial(false);
        awwf.a().updateLutGL(paramContext);
        return;
        if (localFilterDesc.id == 9)
        {
          paramContext.clear();
          paramContext.add(localFilterDesc);
          break label108;
        }
        paramContext.add(localFilterDesc);
        break label53;
        i = paramContext.size();
        break label133;
      }
      label351:
      paramContext = null;
    }
  }
  
  public void A(Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      paramActivity = new ArrayList();
      paramActivity.add(this.d);
      aH(paramActivity, false);
    }
  }
  
  public int Rq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "download: " + this.d.predownload + ", iconurl: " + this.d.iconurl + ", resurl:" + this.d.resurl);
    }
    ayuz.a().a(this.d, this.a);
    eNI();
    return super.Rq();
  }
  
  public void aeE(int paramInt)
  {
    this.outState = paramInt;
  }
  
  public int b(Activity paramActivity, int paramInt)
  {
    if (this.d == null) {}
    return 0;
  }
  
  public float getProgress()
  {
    return 0.5F;
  }
  
  public int getState()
  {
    if (this.Eq == 1.0F)
    {
      aeE(3);
      return 3;
    }
    if (this.Eq >= 0.0F)
    {
      aeE(1);
      return 1;
    }
    String str = this.d.getResFold(aywt.bej);
    if ((!TextUtils.isEmpty(this.d.resurl)) && (!TextUtils.isEmpty(str)) && (ayuz.b(this.d)))
    {
      aeE(2);
      return 2;
    }
    aeE(3);
    return 3;
  }
  
  public String toString()
  {
    return "Filter@" + this.d.name + "@" + hashCode();
  }
  
  class a
    implements ayuz.c
  {
    a() {}
    
    public void YO(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        axpp.this.eNJ();
        return;
      }
      axpp.this.aeD(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axpp
 * JD-Core Version:    0.7.0.1
 */