import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;

public class adrd<T extends adpg>
  extends BaseAdapter
  implements wyw.b
{
  private LinkedList<T> Q = new LinkedList();
  public int aWT;
  private ArkHorizontalListView b;
  public int cJw;
  public wlz f;
  public Context mContext;
  public SessionInfo mSessionInfo;
  
  public adrd(Context paramContext, SessionInfo paramSessionInfo, ArkHorizontalListView paramArkHorizontalListView, wlz paramwlz)
  {
    this.mContext = paramContext;
    this.mSessionInfo = paramSessionInfo;
    this.b = paramArkHorizontalListView;
    this.f = paramwlz;
  }
  
  private void cTV()
  {
    if (this.Q.size() > 1)
    {
      this.b.setOverScrollMode(0);
      return;
    }
    this.b.setOverScrollMode(2);
  }
  
  public void Ls(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    int j = this.Q.size();
    int i = 0;
    while ((i < paramInt) && (i < j))
    {
      adpg localadpg = (adpg)this.Q.removeLast();
      if (localadpg != null) {
        localadpg.destroyContainerByRemove();
      }
      i += 1;
    }
    notifyDataSetChanged();
    cTV();
  }
  
  public T a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt >= getCount() - 1)) {
      return null;
    }
    return (adpg)this.Q.get(paramInt - 1);
  }
  
  public void a(int paramInt, T paramT)
  {
    this.Q.add(paramInt, paramT);
    notifyDataSetChanged();
    cTV();
  }
  
  public void a(T paramT)
  {
    this.Q.addLast(paramT);
    notifyDataSetChanged();
    cTV();
  }
  
  public void a(adrd.a parama, T paramT)
  {
    Object localObject2 = paramT.getArkAppNameAndPath();
    String str = localObject2[0];
    Object localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    paramT.clickTail(parama, null, this.mContext);
    if (localObject1 != null)
    {
      ArkAppCacheMgr.getAppIcon(str, new adre(this, parama));
      paramT = ArkAppCacheMgr.getApplicationDesc(str);
      if (paramT != null)
      {
        parama.he.setVisibility(0);
        parama.xj.setText(paramT);
      }
    }
    while ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return;
    }
    ArkAppMgr.getInstance().getAppPathByName(str, (String)localObject2, "0.0.0.1", null, new adrf(this, str, parama));
  }
  
  public void a(wyv paramwyv, int paramInt)
  {
    int i;
    if ((paramInt == 1) || (paramInt == this.Q.size()))
    {
      Resources localResources = this.mContext.getResources();
      i = BaseChatItemLayout.bOc;
      int j = MessageForArkApp.dp2px(40.0F);
      int k = localResources.getDimensionPixelSize(2131296407);
      int m = localResources.getDimensionPixelSize(2131296399);
      int n = MessageForArkApp.dp2px(paramwyv.getWidth());
      i = adqr.cJg - (i * 2 + j + k) - n - m;
      if ((!this.b.afx()) || (paramInt != 1)) {
        break label185;
      }
      if (this.aWT != i)
      {
        this.aWT = i;
        paramwyv = this.b.getChild(0);
        if ((paramwyv != null) && (!(paramwyv instanceof LinearLayout)))
        {
          paramwyv.setLayoutParams(new ViewGroup.LayoutParams(this.aWT, -1));
          paramwyv.requestLayout();
        }
      }
    }
    for (;;)
    {
      if (this.b.getVisibility() != 0)
      {
        this.b.setVisibility(0);
        if (QLog.isColorLevel()) {
          QLog.d("ArkHorizontalListViewAdapter", 2, "refreshHeaderFooter set ark list visible as load success");
        }
      }
      return;
      label185:
      if ((!this.b.afx()) && (paramInt == this.Q.size()) && (this.cJw != i))
      {
        this.cJw = i;
        paramwyv = this.b.getChild(paramInt + 1);
        if ((paramwyv != null) && (!(paramwyv instanceof LinearLayout)))
        {
          paramwyv.setLayoutParams(new ViewGroup.LayoutParams(this.cJw, -1));
          paramwyv.requestLayout();
        }
      }
    }
  }
  
  public boolean a(wyw paramwyw)
  {
    return false;
  }
  
  public boolean a(wyw paramwyw, String paramString1, String paramString2)
  {
    QLog.d("ArkOpenView", 1, "ArkHorizontalListViewAdapter OpenCardView containerWrapper=" + paramwyw + ", view=" + paramString1 + ", meta=" + paramString2);
    int i = 0;
    for (;;)
    {
      if (i < this.Q.size())
      {
        adpg localadpg = ((adpg)this.Q.get(i)).extendArkCardByOpen(paramwyw, paramString1, paramString2);
        if (localadpg != null) {
          a(i + 1, localadpg);
        }
      }
      else
      {
        return false;
      }
      i += 1;
    }
  }
  
  public T b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.Q.size())) {
      return null;
    }
    return (adpg)this.Q.get(paramInt);
  }
  
  public void b(int paramInt, T paramT)
  {
    if ((paramInt < 0) || (paramInt >= this.Q.size()) || (paramT == null)) {}
    Object localObject;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          this.Q.set(paramInt, paramT);
          paramInt += 1;
          i = this.b.getFirstVisiblePosition();
        } while ((paramInt < i) || (paramInt > this.b.getLastVisiblePosition()));
        localObject = this.b.getChildAt(paramInt - i);
      } while (localObject == null);
      localObject = (adrd.a)((View)localObject).getTag();
    } while (localObject == null);
    paramT.attachArkView(this, (adrd.a)localObject, paramInt);
  }
  
  public int getCount()
  {
    return this.Q.size() + 2;
  }
  
  public int getDataCount()
  {
    return this.Q.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == getCount() - 1)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    if (getItemViewType(paramInt) == 1)
    {
      adpg localadpg = a(paramInt);
      if (paramView == null)
      {
        localObject1 = new adrd.a();
        paramView = LayoutInflater.from(this.mContext).inflate(2131558749, paramViewGroup, false);
        ((adrd.a)localObject1).dX = ((LinearLayout)paramView.findViewById(2131362961));
        ((adrd.a)localObject1).jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)paramView.findViewById(2131362963));
        ((adrd.a)localObject1).jJ = ((RelativeLayout)paramView.findViewById(2131362975));
        ((adrd.a)localObject1).jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131370776));
        ((adrd.a)localObject1).f = ((ArkAppView)paramView.findViewById(2131362952));
        ((adrd.a)localObject1).Bf = paramView.findViewById(2131362967);
        ((adrd.a)localObject1).o = ((Button)paramView.findViewById(2131362962));
        ((adrd.a)localObject1).he = ((LinearLayout)paramView.findViewById(2131362959));
        ((adrd.a)localObject1).sN = ((ImageView)paramView.findViewById(2131362958));
        ((adrd.a)localObject1).xj = ((TextView)paramView.findViewById(2131362960));
        localObject2 = this.b.getParent();
        if ((localObject2 instanceof BaseChatItemLayout)) {
          ((adrd.a)localObject1).g = ((BaseChatItemLayout)localObject2);
        }
        paramView.setTag(localObject1);
      }
      for (;;)
      {
        localObject2 = paramView;
        if (localadpg != null)
        {
          localadpg.attachArkView(this, (adrd.a)localObject1, paramInt);
          localObject2 = paramView;
        }
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
        return localObject2;
        localObject1 = (adrd.a)paramView.getTag();
      }
    }
    Object localObject1 = paramView;
    if (paramView == null) {
      localObject1 = new View(paramViewGroup.getContext());
    }
    if (paramInt == 0) {}
    for (int i = this.aWT;; i = this.cJw)
    {
      ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(i, -1));
      ((View)localObject1).setVisibility(0);
      localObject2 = localObject1;
      break;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void hB(int paramInt1, int paramInt2)
  {
    View localView;
    if (this.aWT != paramInt1)
    {
      localView = this.b.getChild(0);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, -1));
        localView.requestLayout();
      }
      this.aWT = paramInt1;
    }
    if (this.cJw != paramInt2)
    {
      localView = this.b.getChild(getCount() - 1);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, -1));
        localView.requestLayout();
      }
      this.cJw = paramInt2;
    }
  }
  
  public static class a
  {
    public View Bf;
    public ArkAppLoadLayout c;
    public ArkAppRootLayout c;
    public LinearLayout dX;
    public ArkAppView f;
    public BaseChatItemLayout g;
    public LinearLayout he;
    public RelativeLayout jJ;
    public Button o;
    public ImageView sN;
    public TextView xj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrd
 * JD-Core Version:    0.7.0.1
 */