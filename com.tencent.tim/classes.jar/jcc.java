import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.av.ui.QAVPtvTemplateAdapter.5;
import com.tencent.av.ui.QAVPtvTemplateAdapter.6;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavListItemBase.a;
import com.tencent.av.ui.QavListItemBase.b;
import com.tencent.av.ui.QavListItemBase.c;
import com.tencent.av.ui.QavPtvTemplateItemView;
import com.tencent.av.ui.VoiceChangeItemView2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class jcc
  extends BaseAdapter
{
  public static int awO;
  public static int awP;
  public static int mListViewHeight;
  public boolean SW;
  boolean Xs = false;
  boolean Xt = true;
  private QavListItemBase.a jdField_a_of_type_ComTencentAvUiQavListItemBase$a = new jcf(this);
  private QavListItemBase.b jdField_a_of_type_ComTencentAvUiQavListItemBase$b = new jcg(this);
  jcc.a jdField_a_of_type_Jcc$a;
  jcc.b jdField_a_of_type_Jcc$b;
  public int awQ = -1;
  float hM = 6.25F;
  private View hW;
  AppInterface mApp;
  public Context mContext;
  public HorizontalListView mListView;
  private Resources mResources;
  public ArrayList<QavListItemBase.c> mTemplateList = new ArrayList();
  long oI = 0L;
  
  public jcc(AppInterface paramAppInterface, Context paramContext, ArrayList<QavListItemBase.c> paramArrayList, HorizontalListView paramHorizontalListView)
  {
    this(paramAppInterface, paramContext, paramArrayList, paramHorizontalListView, 6.25F);
  }
  
  public jcc(AppInterface paramAppInterface, Context paramContext, ArrayList<QavListItemBase.c> paramArrayList, HorizontalListView paramHorizontalListView, float paramFloat)
  {
    this.mApp = paramAppInterface;
    this.mContext = paramContext;
    this.mResources = this.mContext.getResources();
    this.mListView = paramHorizontalListView;
    this.hM = paramFloat;
    bE(paramArrayList);
    awO = a(this.mResources, ad());
    awP = a(this.mResources, ad(), 0.1666667F);
    mListViewHeight = awO + wja.dp2px(30.0F, this.mResources);
    if (this.hM < 6.0F) {
      mListViewHeight = this.mResources.getDimensionPixelSize(2131298023);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("QAVPtvTemplateAdapter", 4, "init, w[" + awO + "], h[" + mListViewHeight + "], half[" + awP + "]");
    }
    this.mListView.addOnLayoutChangeListener(new jcd(this));
    this.mListView.setOnScrollStateChangedListener(new jce(this));
    paramAppInterface = this.mListView.getLayoutParams();
    paramAppInterface.width = -1;
    paramAppInterface.height = mListViewHeight;
    this.mListView.setLayoutParams(paramAppInterface);
  }
  
  public static int a(Resources paramResources, float paramFloat)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / paramFloat + 0.5F);
  }
  
  public static int a(Resources paramResources, float paramFloat1, float paramFloat2)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / paramFloat1 * paramFloat2 + 0.5F);
  }
  
  protected void K(long paramLong, int paramInt)
  {
    if ((paramInt < 0) || (this.mTemplateList.size() <= paramInt)) {}
    QavListItemBase.c localc;
    do
    {
      return;
      localc = (QavListItemBase.c)this.mTemplateList.get(paramInt);
      if ((TextUtils.isEmpty(localc.id)) || (localc.id.equals("0")))
      {
        b(paramLong, localc);
        return;
      }
      if (localc.usable)
      {
        b(paramLong, localc);
        return;
      }
    } while ((localc.downloading) || (TextUtils.isEmpty(localc.id)));
    if (this.jdField_a_of_type_Jcc$b != null)
    {
      this.jdField_a_of_type_Jcc$b.startDownloadTemplate(this.mApp, paramLong, localc, this.jdField_a_of_type_ComTencentAvUiQavListItemBase$b);
      localc.downloading = true;
      return;
    }
    throw new IllegalArgumentException("mIItemDownloadMgr is null, pealse call setItemDownloadMgr");
  }
  
  public QavListItemBase.c a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mTemplateList.size())) {
      return null;
    }
    return (QavListItemBase.c)this.mTemplateList.get(paramInt);
  }
  
  void a(View paramView, QavListItemBase.c paramc)
  {
    if (paramView == null) {}
    View localView;
    do
    {
      return;
      localView = paramView.findViewById(2131373984);
      if (paramc == null) {
        paramView.setContentDescription(null);
      }
    } while (localView == null);
    localView.setContentDescription(null);
  }
  
  public void a(jcc.a parama)
  {
    this.jdField_a_of_type_Jcc$a = parama;
  }
  
  public void a(jcc.b paramb)
  {
    this.jdField_a_of_type_Jcc$b = paramb;
  }
  
  public float ad()
  {
    return this.hM;
  }
  
  public void ao(String paramString, int paramInt)
  {
    aq(paramString, paramInt);
  }
  
  public void ap(String paramString, int paramInt)
  {
    QavListItemBase.c localc2 = null;
    int k = this.mListView.getFirstVisiblePosition();
    int n = this.mListView.getLastVisiblePosition();
    int i = k;
    Object localObject;
    QavListItemBase.c localc1;
    for (;;)
    {
      if (i <= n) {
        if (i < 0)
        {
          i += 1;
        }
        else if (i >= this.mTemplateList.size())
        {
          localObject = null;
          localc1 = localc2;
        }
      }
    }
    for (;;)
    {
      label59:
      int j;
      label134:
      label145:
      if ((localc1 == null) && (paramInt == 101))
      {
        int m = this.mTemplateList.size();
        j = 0;
        label82:
        if ((j < k) && (j < m))
        {
          localc2 = (QavListItemBase.c)this.mTemplateList.get(j);
          if ((localc2 != null) && (localc2.id.equals(paramString)))
          {
            i = j;
            localc1 = localc2;
            if (localc1 != null) {
              break label407;
            }
            j = n + 1;
            if (j >= m) {
              break label407;
            }
            localc2 = (QavListItemBase.c)this.mTemplateList.get(j);
            if ((localc2 == null) || (!localc2.id.equals(paramString))) {
              break label355;
            }
            localc1 = localc2;
            i = j;
          }
        }
      }
      for (;;)
      {
        if (localc1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PtvTemplateManager", 2, String.format("onProgressUpdate, index[%s], [%s][%s], progress[%s]", new Object[] { Integer.valueOf(i), localc1.id, localc1.name, Integer.valueOf(paramInt) }));
          }
          if (paramInt != -1) {
            break label364;
          }
          localc1.downloading = false;
        }
        for (;;)
        {
          if (localObject != null) {
            ((QavListItemBase)localObject).mE(paramInt);
          }
          return;
          localc1 = (QavListItemBase.c)this.mTemplateList.get(i);
          if ((localc1 == null) || (!localc1.id.equals(paramString))) {
            break;
          }
          localObject = this.mListView.getChildAt(i - k);
          if ((!(localObject instanceof QavListItemBase)) || (!this.mListView.getAdapter().equals(this))) {
            break label416;
          }
          localObject = (QavListItemBase)localObject;
          break label59;
          j += 1;
          break label82;
          label355:
          j += 1;
          break label145;
          label364:
          if (paramInt == 101)
          {
            localc1.downloading = false;
            localc1.usable = true;
          }
          else
          {
            i = paramInt;
            if (paramInt == 100) {
              i = 99;
            }
            localc1.downloading = true;
            paramInt = i;
          }
        }
        label407:
        continue;
        break label134;
      }
      label416:
      localObject = null;
      continue;
      localObject = null;
      localc1 = localc2;
    }
  }
  
  public void aq(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new QAVPtvTemplateAdapter.6(this, paramString, paramInt));
  }
  
  public void b(long paramLong, QavListItemBase.c paramc)
  {
    if (this.jdField_a_of_type_Jcc$a == null) {}
    while ((!TextUtils.isEmpty(paramc.id)) && (!paramc.id.equals("0")) && (!paramc.usable)) {
      return;
    }
    this.jdField_a_of_type_Jcc$a.a(paramLong, paramc);
  }
  
  public void bE(ArrayList<QavListItemBase.c> paramArrayList)
  {
    this.mTemplateList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.mTemplateList.addAll(paramArrayList);
    }
  }
  
  void bW(int paramInt1, int paramInt2)
  {
    if (this.Xs)
    {
      View localView1 = this.mListView.getChild(paramInt1);
      View localView2 = this.mListView.getChild(paramInt2);
      if ((paramInt2 != paramInt1) && (localView1 != null) && ((localView1 instanceof QavListItemBase))) {
        ((QavListItemBase)localView1).setHighlight(false);
      }
      if ((localView2 != null) && ((localView2 instanceof QavListItemBase))) {
        ((QavListItemBase)localView2).setHighlight(true);
      }
    }
  }
  
  public boolean cz(int paramInt)
  {
    boolean bool2 = false;
    int i = this.awQ;
    int j = this.mTemplateList.size();
    boolean bool1 = bool2;
    if (this.awQ != paramInt)
    {
      bool1 = bool2;
      if (paramInt >= 0)
      {
        bool1 = bool2;
        if (paramInt < j)
        {
          this.awQ = paramInt;
          notifyDataSetChanged();
          bool1 = true;
        }
      }
    }
    QLog.w("QAVPtvTemplateAdapter", 1, "setSelectedIndex, ret[" + bool1 + "], index[" + paramInt + "], mCurSelectedPosition[" + i + "->" + this.awQ + "], size[" + j + "]");
    return bool1;
  }
  
  public void g(long paramLong, String paramString, boolean paramBoolean)
  {
    this.mListView.post(new QAVPtvTemplateAdapter.5(this, paramString, paramBoolean, paramLong));
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
    Object localObject2 = null;
    boolean bool = true;
    QavListItemBase.c localc = a(paramInt);
    Object localObject1;
    if (localc == null)
    {
      a(paramView, null);
      localObject1 = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      if (!"-1".equals(localc.id)) {
        break;
      }
      localObject1 = localObject2;
      if (paramView != null)
      {
        localObject1 = localObject2;
        if (paramView.getId() == Integer.valueOf(localc.id).intValue()) {
          localObject1 = paramView;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (this.hW != null) {
          localObject2 = this.hW;
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new View(this.mContext);
        ((View)localObject1).setId(Integer.valueOf(localc.id).intValue());
        ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(awP, -1));
        this.hW = ((View)localObject1);
      }
      if (AudioHelper.jY(0) == 1) {
        ((View)localObject1).setBackgroundColor(-256);
      }
    }
    label225:
    label236:
    int i;
    if (!(paramView instanceof QavListItemBase)) {
      if (localc.type == 2)
      {
        localObject1 = new VoiceChangeItemView2(this.mContext);
        ((QavListItemBase)localObject1).bX(awO, mListViewHeight);
        if (AudioHelper.jY(0) == 1)
        {
          ((QavListItemBase)localObject1).a(localc, paramInt);
          this.mListView.setBackgroundColor(-1);
          QLog.w("QAVPtvTemplateAdapter", 1, "getView, itemView[" + localObject1.hashCode() + "], mListView[" + this.mListView.hashCode() + "], position[" + paramInt + "], getPosition[" + ((QavListItemBase)localObject1).getPosition() + "], mFullItemWidth[" + awO + "], mListViewHeight[" + mListViewHeight + "], mListView.Height[" + this.mListView.getMeasuredHeight() + "|" + this.mListView.getHeight() + "], itemView.Height[" + ((QavListItemBase)localObject1).getMeasuredHeight() + "|" + ((QavListItemBase)localObject1).getHeight() + "], info[" + localc + "]");
        }
        ((QavListItemBase)localObject1).updateSize(awO, mListViewHeight);
        if (paramInt != this.awQ) {
          break label565;
        }
        i = 1;
        label452:
        if ((!this.Xs) || (i == 0)) {
          break label571;
        }
      }
    }
    for (;;)
    {
      ((QavListItemBase)localObject1).a(paramInt, bool, this.Xt, localc, this.jdField_a_of_type_ComTencentAvUiQavListItemBase$a);
      a((View)localObject1, localc);
      break;
      localObject1 = new QavPtvTemplateItemView(this.mContext);
      ((QavPtvTemplateItemView)localObject1).SW = this.SW;
      if (this.hM < 6.0F)
      {
        localObject2 = ((QavPtvTemplateItemView)localObject1).findViewById(2131374148);
        if ((localObject2 instanceof LinearLayout)) {
          ((LinearLayout)localObject2).setGravity(49);
        }
      }
      break label225;
      localObject1 = (QavListItemBase)paramView;
      break label236;
      label565:
      i = 0;
      break label452;
      label571:
      bool = false;
    }
  }
  
  public void jU(boolean paramBoolean)
  {
    this.Xt = paramBoolean;
  }
  
  public void jV(boolean paramBoolean)
  {
    this.Xs = paramBoolean;
  }
  
  void mD(int paramInt)
  {
    if (this.mListView.getFirstVisiblePosition() >= paramInt) {
      this.mListView.smoothScrollToPositionFromLeftOrRight(paramInt, 0, 200);
    }
    View localView;
    do
    {
      do
      {
        return;
      } while (this.mListView.getLastVisiblePosition() > paramInt);
      localView = this.mListView.getChild(paramInt);
    } while ((localView != null) && (localView.getRight() <= this.mListView.getRight()));
    if (paramInt == getCount() - 1) {}
    for (int i = this.mResources.getDisplayMetrics().widthPixels - awO;; i = awO * 5)
    {
      this.mListView.smoothScrollToPositionFromLeftOrRight(paramInt, -i, 200);
      return;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.hW = null;
    super.notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, QavListItemBase.c paramc);
    
    public abstract void dk(long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.c paramc, QavListItemBase.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcc
 * JD-Core Version:    0.7.0.1
 */