package com.tencent.mobileqq.activity.recent;

import aajg;
import aaju;
import aaju.a;
import aajx;
import abxk;
import acfp;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.lang.ref.WeakReference;

public class HotChatCenterItemBuilder
  extends aaju
  implements View.OnClickListener, Runnable
{
  private SparseArray<SparseArray<ApolloGameRedDot>> bQ;
  private final Object cc = new Object();
  private WeakReference<QQAppInterface> mContextRef;
  
  private void cuC()
  {
    try
    {
      ThreadManager.remove(this);
      ThreadManager.post(this, 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("HotChatCenterItemBuilder", 1, "[loadRedDot]", localThrowable);
    }
  }
  
  private boolean e(QQAppInterface paramQQAppInterface, int paramInt)
  {
    cuC();
    if (this.bQ != null)
    {
      paramQQAppInterface = ApolloGameUtil.a((SparseArray)this.bQ.get(paramInt));
      return (paramQQAppInterface != null) && (!paramQQAppInterface.mIsShow);
    }
    return false;
  }
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    if ((this.c != null) && (this.c.app != null) && (this.mContextRef == null))
    {
      this.mContextRef = new WeakReference(this.c.app);
      cuC();
    }
    paramc = null;
    paramViewGroup = paramc;
    if (paramView != null)
    {
      paramViewGroup = paramc;
      if ((paramView.getTag() instanceof aaju.a)) {
        paramViewGroup = (aaju.a)paramView.getTag();
      }
    }
    Object localObject;
    if (paramViewGroup == null)
    {
      paramc = new aaju.a();
      localObject = a(paramContext, 2131558728, paramc);
      paramc.c = ((ThemeImageView)((View)localObject).findViewById(2131368698));
      paramc.d = ((DragTextView)((View)localObject).findViewById(2131381288));
      paramc.NX = ((TextView)((View)localObject).findViewById(2131370129));
      paramc.wf = ((ImageView)((View)localObject).findViewById(2131365434));
      paramc.title = ((TextView)((View)localObject).findViewById(16908308));
      paramc.wg = ((ImageView)((View)localObject).findViewById(2131378717));
      paramc.NY = ((TextView)((View)localObject).findViewById(2131368128));
      paramc.NZ = ((TextView)((View)localObject).findViewById(2131366616));
      paramc.description = ((TextView)((View)localObject).findViewById(16908309));
      paramc.description.setGravity(16);
      a((View)localObject, paramc.NX, paramContext);
      ((View)localObject).setTag(paramc);
      paramView = (View)localObject;
      paramViewGroup = paramc;
      if (this.c != null)
      {
        paramc.d.setOnModeChangeListener(this.c.a());
        paramViewGroup = paramc;
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      paramViewGroup.d.setTag(Integer.valueOf(paramInt));
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(null);
      }
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        localObject = (RecentBaseData)paramObject;
        paramc = null;
        if (paramaajx != null) {
          paramc = paramaajx.a((RecentBaseData)localObject);
        }
        a(paramView, (RecentBaseData)localObject, paramContext, paramc);
        if ((paramObject instanceof RecentItemEcShop))
        {
          paramViewGroup.c.setOnClickListener(paramOnClickListener);
          paramViewGroup.c.setTag(-1, Integer.valueOf(paramInt));
          if (AppSetting.enableTalkBack) {
            paramViewGroup.c.setContentDescription(String.format(acfp.m(2131707199), new Object[] { ((RecentItemEcShop)paramObject).getTitleName() }));
          }
        }
      }
      for (;;)
      {
        localObject = paramView.findViewById(2131377096);
        paramaajx = paramView.findViewById(2131362794);
        View localView = paramView.findViewById(2131362795);
        paramc = paramView.findViewById(2131362797);
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        ((View)localObject).setOnClickListener(paramOnClickListener);
        paramaajx.setOnClickListener(this);
        ((View)localObject).setTag(-1, Integer.valueOf(paramInt));
        paramaajx.setTag(-1, Integer.valueOf(paramInt));
        paramaajx.setTag(-100, paramOnClickListener);
        localView.setLongClickable(true);
        localView.setOnLongClickListener(paramOnLongClickListener);
        localView.setTag(-1, Integer.valueOf(paramInt));
        if (((paramObject instanceof RecentHotchatItem)) && (this.c != null) && (this.c.app != null)) {
          break;
        }
        return paramView;
        if (paramViewGroup != null)
        {
          paramViewGroup.title.setText("");
          paramViewGroup.wg.setVisibility(8);
          paramViewGroup.NY.setVisibility(8);
          paramViewGroup.NY.setText("");
          paramViewGroup.NZ.setText("");
          paramViewGroup.description.setText("");
          paramViewGroup.NX.setText("");
          paramViewGroup.wf.setImageDrawable(null);
        }
      }
      paramViewGroup = (RecentHotchatItem)paramObject;
      paramObject = (TextView)paramView.findViewById(2131362798);
      paramOnClickListener = ApolloGameUtil.a(paramViewGroup.getGameId(), this.c.app);
      label762:
      int i;
      if (paramOnClickListener != null)
      {
        paramObject.setText(paramOnClickListener.mTipsWording);
        paramObject = paramaajx.getTag();
        if ((paramObject != null) && ((paramObject instanceof RedTouch))) {
          break label963;
        }
        paramObject = new RedTouch(paramContext, paramc).a(19).a();
        paramaajx.setTag(paramObject);
        if (!e(this.c.app, paramViewGroup.getGameId())) {
          break label987;
        }
        paramaajx.setTag(-200, Integer.valueOf(paramViewGroup.getGameId()));
        paramaajx.setTag(-300, paramObject);
        paramaajx = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramaajx.red_type.set(0);
        paramObject.c(paramaajx);
        paramObject = ApolloGameUtil.a(paramViewGroup.getGameId(), this.c.app);
        if (paramObject != null) {
          break label971;
        }
        paramInt = 0;
        label847:
        i = paramViewGroup.getGameId();
        if (paramObject != null) {
          break label979;
        }
      }
      label963:
      label971:
      label979:
      for (paramObject = "";; paramObject = paramObject.mActId)
      {
        VipUtils.a(null, "cmshow", "Apollo", "reddot_show", paramInt, 0, new String[] { String.valueOf(i), String.valueOf(0), paramObject });
        return paramView;
        paramInt = paramViewGroup.getGameId();
        paramOnClickListener = ((abxk)this.c.app.getManager(155)).a(paramInt);
        if (paramOnClickListener == null) {
          break;
        }
        paramObject.setText(String.format(acfp.m(2131707198), new Object[] { paramOnClickListener.name }));
        break;
        paramObject = (RedTouch)paramObject;
        break label762;
        paramInt = paramObject.mDotId;
        break label847;
      }
      label987:
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterItemBuilder", 2, "[getView] no red dot");
      }
      paramObject.dGB();
      paramc.setVisibility(0);
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag(-100) != null) && ((paramView.getTag(-100) instanceof View.OnClickListener))) {
      ((View.OnClickListener)paramView.getTag(-100)).onClick(paramView);
    }
    if ((paramView.getTag(-200) != null) && ((paramView.getTag(-200) instanceof Integer)))
    {
      int i = ((Integer)paramView.getTag(-200)).intValue();
      if ((paramView.getTag(-300) != null) && ((paramView.getTag(-300) instanceof RedTouch)))
      {
        ((RedTouch)paramView.getTag(-300)).dGB();
        ViewParent localViewParent = paramView.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof View))) {
          ((View)localViewParent).setVisibility(0);
        }
      }
      paramView.setTag(-300, null);
      paramView.setTag(-200, null);
      ThreadManager.post(new HotChatCenterItemBuilder.1(this, i), 5, null, false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void run()
  {
    if ((this.mContextRef != null) && (this.mContextRef.get() != null))
    {
      EntityManager localEntityManager = ((QQAppInterface)this.mContextRef.get()).a().createEntityManager();
      if (localEntityManager != null) {
        synchronized (this.cc)
        {
          this.bQ = ApolloGameUtil.a(localEntityManager);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.HotChatCenterItemBuilder
 * JD-Core Version:    0.7.0.1
 */