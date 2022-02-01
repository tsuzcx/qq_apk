import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.d;
import java.util.ArrayList;
import java.util.Iterator;

public class aasb
  extends BaseAdapter
  implements aavi.b
{
  private aasb.a jdField_a_of_type_Aasb$a = new aasd(this);
  private aasb.b jdField_a_of_type_Aasb$b;
  private aasb.c jdField_a_of_type_Aasb$c;
  private PtvTemplateManager.b jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$b = new aase(this);
  PtvTemplateManager jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
  public FSurfaceViewLayout b;
  public PtvTemplateManager.PtvTemplateInfo b;
  public String bec = "";
  public PtvTemplateManager.PtvTemplateInfo c;
  int cjt;
  public int cju;
  AppInterface mApp;
  Context mContext;
  float mDensity;
  Handler mHandler = new Handler(new aasc(this));
  int mItemWidth;
  public HorizontalListView mListView;
  HorizontalListView.d mOnScrollStateChangedListener = new aasf(this);
  public ArrayList<PtvTemplateManager.PtvTemplateInfo> mTemplateList = new ArrayList();
  
  public aasb(AppInterface paramAppInterface, Context paramContext, ArrayList<PtvTemplateManager.PtvTemplateInfo> paramArrayList, int paramInt, HorizontalListView paramHorizontalListView, FSurfaceViewLayout paramFSurfaceViewLayout)
  {
    this.mApp = paramAppInterface;
    this.mContext = paramContext;
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    this.mItemWidth = vD();
    this.mListView = paramHorizontalListView;
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout = paramFSurfaceViewLayout;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager = PtvTemplateManager.a(paramAppInterface);
    this.cju = paramInt;
    dn(paramArrayList);
    this.mListView.setOnScrollStateChangedListener(this.mOnScrollStateChangedListener);
    aavi.a(this.mApp).a(this);
  }
  
  public void AN(String paramString)
  {
    if ((this.bec != null) && (this.bec.contains(paramString)))
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(this.bec);
      return;
    }
    aavi.log("lbsUpdateFilter", String.format("currentPath=%s,name=%s", new Object[] { "" + this.bec, "" + paramString }), null);
  }
  
  public PtvTemplateManager.PtvTemplateInfo a()
  {
    int i = getCurrentPosition();
    Object localObject;
    if (i >= this.mTemplateList.size()) {
      localObject = null;
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      return localObject;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(i);
      localObject = localPtvTemplateInfo;
    } while (localPtvTemplateInfo != null);
    return null;
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(int paramInt)
  {
    if (paramInt >= this.mTemplateList.size()) {
      return null;
    }
    return (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(paramInt);
  }
  
  public void a(aasb.b paramb)
  {
    this.jdField_a_of_type_Aasb$b = paramb;
  }
  
  public void a(aasb.c paramc)
  {
    this.jdField_a_of_type_Aasb$c = paramc;
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo != null) {}
    for (;;)
    {
      this.c = this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
      this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
      if (this.jdField_a_of_type_Aasb$c != null) {
        this.jdField_a_of_type_Aasb$c.onItemSelected(this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.type);
      }
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (!this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id.equals("0"))) {
        break;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter("");
        this.bec = "";
        if (QLog.isColorLevel()) {
          QLog.i("PtvTemplateManager", 2, "setVideoFilter null");
        }
      }
      int i;
      do
      {
        return;
        i = this.mListView.getFirstVisiblePosition() + this.cju;
      } while (i >= this.mTemplateList.size());
      paramPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(i);
    }
    aavi.a(this.mApp).b(this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    if (this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable)
    {
      paramPtvTemplateInfo = PtvTemplateManager.bYM + this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PtvTemplateManager", 2, "setVideoFilter " + paramPtvTemplateInfo + " type is " + this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.type);
        }
        if (this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.category == 0)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(paramPtvTemplateInfo);
          label268:
          this.bec = paramPtvTemplateInfo;
        }
      }
      else
      {
        label273:
        if (aaqh.cix != 2) {
          break label471;
        }
      }
    }
    label471:
    for (paramPtvTemplateInfo = "0";; paramPtvTemplateInfo = "1")
    {
      aaqi.h("", "0X80075BA", paramPtvTemplateInfo, this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id, "", "");
      if (!this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.hasGesture()) {
        break;
      }
      aaqi.h("", "0X80083AE", paramPtvTemplateInfo, this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id, "", "");
      return;
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(paramPtvTemplateInfo, this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.category, this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.gestureType, this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.gestureWording);
      if (!QLog.isColorLevel()) {
        break label268;
      }
      QLog.i("PtvTemplateManager", 2, "setVideoFilter gestureWording is " + this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.gestureWording);
      break label268;
      if ((this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager == null)) {
        break label273;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.mApp, this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$b);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading = true;
      aasp.c("shortvideo_download_effects", null);
      break label273;
    }
  }
  
  public void cxO()
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if ((!aqmr.isEmpty(this.bec)) && (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null))
    {
      localPtvTemplateInfo = a();
      if ((localPtvTemplateInfo != null) && ((localPtvTemplateInfo == null) || (localPtvTemplateInfo.category != 0))) {
        break label84;
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(this.bec);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateManager", 2, "setCurrentFilter:" + this.bec);
      }
      return;
      label84:
      if (localPtvTemplateInfo != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(this.bec, localPtvTemplateInfo.category, localPtvTemplateInfo.gestureType, localPtvTemplateInfo.gestureWording);
      }
    }
  }
  
  public void dn(ArrayList<PtvTemplateManager.PtvTemplateInfo> paramArrayList)
  {
    try
    {
      this.mTemplateList.clear();
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
      localPtvTemplateInfo.id = "-1";
      this.mTemplateList.add(localPtvTemplateInfo);
      int i = 0;
      while (i < this.cju)
      {
        localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
        localPtvTemplateInfo.id = "0";
        this.mTemplateList.add(localPtvTemplateInfo);
        i += 1;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramArrayList.next();
        this.mTemplateList.add(localPtvTemplateInfo);
      }
      paramArrayList = new PtvTemplateManager.PtvTemplateInfo();
    }
    finally {}
    paramArrayList.id = "-2";
    this.mTemplateList.add(paramArrayList);
    paramArrayList = new PtvTemplateManager.PtvTemplateInfo();
    paramArrayList.id = "-1";
    this.mTemplateList.add(paramArrayList);
  }
  
  public int getCount()
  {
    if (this.mTemplateList.isEmpty()) {
      return 0;
    }
    return this.mTemplateList.size();
  }
  
  public int getCurrentPosition()
  {
    return this.mListView.getFirstVisiblePosition() + this.cju;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    if ("-1".equals(((PtvTemplateManager.PtvTemplateInfo)localObject).id))
    {
      localObject = new View(this.mContext);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams((int)(this.mItemWidth * 0.75F), this.mItemWidth));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      if (!"-2".equals(((PtvTemplateManager.PtvTemplateInfo)localObject).id)) {
        break;
      }
      localObject = new View(this.mContext);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(this.mItemWidth, this.mItemWidth));
    }
    if ((paramView == null) || (!(paramView instanceof PtvTemplateItemView)))
    {
      localObject = new PtvTemplateItemView(this.mContext);
      ((PtvTemplateItemView)localObject).Gs(this.mItemWidth);
    }
    for (;;)
    {
      ((PtvTemplateItemView)localObject).a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(paramInt), this.jdField_a_of_type_Aasb$a);
      break;
      localObject = (PtvTemplateItemView)paramView;
    }
  }
  
  public String qD()
  {
    int i = getCurrentPosition();
    if (i >= this.mTemplateList.size()) {
      return null;
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(i);
    if (localPtvTemplateInfo == null) {
      return null;
    }
    if ((TextUtils.isEmpty(localPtvTemplateInfo.id)) || (localPtvTemplateInfo.id.equals("0")) || (localPtvTemplateInfo.id.equals("-1")) || (localPtvTemplateInfo.id.equals("-2"))) {
      return null;
    }
    return localPtvTemplateInfo.id;
  }
  
  public String qE()
  {
    int i = getCurrentPosition();
    if (i >= this.mTemplateList.size()) {
      return null;
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(i);
    if (localPtvTemplateInfo == null) {
      return null;
    }
    return localPtvTemplateInfo.name;
  }
  
  public int vD()
  {
    return (int)(this.mContext.getResources().getDisplayMetrics().widthPixels / 4.5F);
  }
  
  public int yW()
  {
    int i = getCurrentPosition();
    if (i >= this.mTemplateList.size()) {
      return 0;
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.mTemplateList.get(i);
    if (localPtvTemplateInfo == null) {
      return 0;
    }
    return localPtvTemplateInfo.type;
  }
  
  public static abstract interface a
  {
    public abstract void Gr(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void cwR();
  }
  
  public static abstract interface c
  {
    public abstract void onItemSelected(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aasb
 * JD-Core Version:    0.7.0.1
 */