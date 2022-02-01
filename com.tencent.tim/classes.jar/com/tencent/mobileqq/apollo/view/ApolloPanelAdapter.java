package com.tencent.mobileqq.apollo.view;

import acbg;
import afpt;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.Iterator;
import java.util.List;

public class ApolloPanelAdapter
  extends PagerAdapter
{
  afpt a = new afpt();
  afpt b = new afpt();
  afpt c = new afpt();
  afpt d = new afpt();
  public BaseChatPie i;
  Context mContext;
  SessionInfo mSessionInfo;
  private List<acbg> xd;
  
  public ApolloPanelAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject == null) || (paramViewGroup == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            ApolloLinearLayout localApolloLinearLayout;
            do
            {
              do
              {
                return;
                if (((paramObject instanceof View)) && (((View)paramObject).getId() == 2131377552) && (this.d != null))
                {
                  this.d.gx((View)paramObject);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanelAdapter", 2, "add to game pool view position = " + paramInt);
                  }
                }
                if (!paramObject.getClass().equals(ApolloLinearLayout.class)) {
                  break label274;
                }
                localApolloLinearLayout = (ApolloLinearLayout)paramObject;
                localApolloLinearLayout.clear();
                paramViewGroup.removeView(localApolloLinearLayout);
                if (localApolloLinearLayout.mBinderType != 4) {
                  break;
                }
              } while (this.b == null);
              this.b.gx((View)paramObject);
            } while (!QLog.isColorLevel());
            QLog.d("ApolloPanelAdapter", 2, "add to reusePool view position = " + paramInt);
            return;
            if (localApolloLinearLayout.mBinderType != 2) {
              break;
            }
          } while (this.c == null);
          this.c.gx((View)paramObject);
        } while (!QLog.isColorLevel());
        QLog.d("ApolloPanelAdapter", 2, "add to reusePool view position = " + paramInt);
        return;
      } while (this.a == null);
      this.a.gx((View)paramObject);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanelAdapter", 2, "add to reusePool view position = " + paramInt);
    return;
    label274:
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int k;
    if ((this.xd == null) || (this.xd.size() == 0)) {
      k = 0;
    }
    Iterator localIterator;
    int j;
    do
    {
      return k;
      localIterator = this.xd.iterator();
      j = 0;
      k = j;
    } while (!localIterator.hasNext());
    acbg localacbg = (acbg)localIterator.next();
    if ((localacbg != null) && ((localacbg instanceof acbg))) {
      j += localacbg.Ad();
    }
    for (;;)
    {
      break;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public void iA(List<acbg> paramList)
  {
    this.xd = paramList;
    super.notifyDataSetChanged();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = this.xd.iterator();
    int k = 0;
    acbg localacbg;
    int j;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localacbg = (acbg)((Iterator)localObject1).next();
      j = k;
      if (localacbg != null)
      {
        j = k;
        if ((localacbg instanceof acbg))
        {
          int m = localacbg.Ad();
          k += m;
          j = k;
          if (paramInt + 1 <= k)
          {
            j = m - (k - paramInt);
            if ((this.a == null) || (localacbg.awS != 0) || (localacbg.cud >= 100)) {
              break label704;
            }
            localObject2 = this.a.bW();
            localObject1 = localObject2;
            if (!(localObject2 instanceof ApolloLinearLayout)) {
              localObject1 = null;
            }
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloPanelAdapter", 2, "reuse view position =" + paramInt);
              localObject2 = localObject1;
            }
            label176:
            localObject1 = localObject2;
            if (this.b != null)
            {
              localObject1 = localObject2;
              if (localacbg.mBinderType == 4)
              {
                localObject1 = this.b.bW();
                localObject2 = localObject1;
                if (!(localObject1 instanceof ApolloLinearLayout)) {
                  localObject2 = null;
                }
                localObject1 = localObject2;
                if (QLog.isColorLevel())
                {
                  QLog.d("ApolloPanelAdapter", 2, "reuse view position =" + paramInt);
                  localObject1 = localObject2;
                }
              }
            }
            localObject2 = localObject1;
            if (this.c != null)
            {
              localObject2 = localObject1;
              if (localacbg.mBinderType == 2)
              {
                localObject2 = this.c.bW();
                localObject1 = localObject2;
                if (!(localObject2 instanceof ApolloLinearLayout)) {
                  localObject1 = null;
                }
                localObject2 = localObject1;
                if (QLog.isColorLevel())
                {
                  QLog.d("ApolloPanelAdapter", 2, "reuse view position =" + paramInt);
                  localObject2 = localObject1;
                }
              }
            }
            localObject1 = localObject2;
            if (this.d != null)
            {
              localObject1 = localObject2;
              if (localacbg.mBinderType == 100)
              {
                localObject1 = localObject2;
                if (localacbg.awS != 8)
                {
                  localObject2 = this.d.bW();
                  localObject1 = localObject2;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("ApolloPanelAdapter", 2, "reuse game view position =" + paramInt);
                    localObject1 = localObject2;
                  }
                }
              }
            }
            if (localObject1 == null) {
              break label701;
            }
            localObject2 = ((View)localObject1).getTag();
            if ((localObject2 == null) || (!(localObject2 instanceof Integer)) || (((Integer)((View)localObject1).getTag()).intValue() == XPanelContainer.evb)) {
              break label701;
            }
            if (this.a != null) {
              this.a.dbs();
            }
            if (this.b != null) {
              this.b.dbs();
            }
            if (this.c != null) {
              this.c.dbs();
            }
            if (this.d != null) {
              this.d.dbs();
            }
            localObject1 = null;
            label538:
            if (localObject1 == null)
            {
              localObject2 = localacbg.G(j);
              localObject1 = localObject2;
              if ((localObject2 instanceof ApolloLinearLayout))
              {
                ((ApolloLinearLayout)localObject2).setCallback(this.i);
                ((ApolloLinearLayout)localObject2).setSessionInfo(this.mSessionInfo);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanelAdapter", 2, "instantiateItem position = " + paramInt);
      }
      if ((localObject1 != null) && (((View)localObject1).getParent() != paramViewGroup) && (paramInt < getCount()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanelAdapter", 2, "addView position = " + paramInt);
        }
        paramViewGroup.addView((View)localObject1);
      }
      return localObject1;
      localacbg.ac((View)localObject1, j);
      continue;
      k = j;
      break;
      label701:
      break label538;
      label704:
      localObject2 = null;
      break label176;
      localObject1 = null;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.i = paramBaseChatPie;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.mSessionInfo = paramSessionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanelAdapter
 * JD-Core Version:    0.7.0.1
 */