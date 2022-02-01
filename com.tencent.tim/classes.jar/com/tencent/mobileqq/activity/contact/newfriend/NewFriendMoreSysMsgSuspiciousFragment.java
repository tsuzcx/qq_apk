package com.tencent.mobileqq.activity.contact.newfriend;

import abeg;
import abeg.a;
import acfd;
import acff;
import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqiw;
import aqnm;
import auvd;
import auvd.a;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.a;
import com.tencent.widget.SwipListView.c;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import ysf;
import ysn;
import yso;
import ysp;

public class NewFriendMoreSysMsgSuspiciousFragment
  extends PublicBaseFragment
{
  private a a;
  private SwipListView e;
  
  private void u(View paramView)
  {
    View localView = paramView.findViewById(2131372405);
    ((TextView)localView.findViewById(2131379783)).setText(2131701783);
    this.e = ((SwipListView)paramView.findViewById(2131379116));
    this.e.setDragEnable(true);
    this.a = new a(getActivity(), getActivity().app, this.e, localView);
    this.e.setAdapter(this.a);
    paramView.findViewById(2131369579).setOnClickListener(new ysn(this));
    ((TextView)paramView.findViewById(2131369627)).setText(2131701782);
    anot.a(getActivity().app, "dc00898", "", "", "0X800A32B", "0X800A32B", 0, 0, "", "", "", "");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onCreateView");
    }
    paramViewGroup = paramLayoutInflater.inflate(2131561504, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    u(paramViewGroup);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onDestroy");
    }
    if (this.a != null) {
      this.a.destroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null)
    {
      this.a.onResume();
      this.a.refreshData();
    }
  }
  
  public static class a
    extends abeg
    implements View.OnClickListener, AbsListView.e, SwipListView.a, SwipListView.c
  {
    private static final int[] fA = { 2131371284 };
    private static final int[] fy = { 2131692505 };
    private static final int[] fz = { 2130839769 };
    private acfd jdField_a_of_type_Acfd = new yso(this);
    private auvd jdField_a_of_type_Auvd;
    private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    private ysf jdField_a_of_type_Ysf;
    private SparseArray<byte[]> bB = new SparseArray(20);
    private int cba = -1;
    private int cbb = -1;
    private int cbc = -1;
    private QQAppInterface mApp;
    private Context mContext;
    private View mEmptyView;
    private int mLastVisibleIndex;
    private List<SysSuspiciousMsg> tc = new ArrayList(0);
    
    public a(Context paramContext, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView)
    {
      super(paramQQAppInterface, paramSwipListView, 1, true);
      this.mApp = paramQQAppInterface;
      this.mContext = paramContext;
      this.jdField_a_of_type_Auvd = a(this.mContext);
      this.mEmptyView = paramView;
      paramSwipListView.setRightIconMenuListener(this);
      setOnScrollListener(this);
      this.jdField_a_of_type_Ysf = ((ysf)paramQQAppInterface.getManager(34));
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1));
      clA();
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.cIT();
    }
    
    private void L(boolean paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
      {
        ViewGroup localViewGroup = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
        View localView = localViewGroup.getChildAt(0);
        Object localObject = localViewGroup;
        if (localView != null)
        {
          localObject = localViewGroup;
          if ((localView instanceof DragFrameLayout)) {
            localObject = (ViewGroup)localView;
          }
        }
        localObject = ((ViewGroup)localObject).getChildAt(0);
        if ((localObject instanceof TopGestureLayout)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
      }
    }
    
    private auvd a(Context paramContext)
    {
      int i = paramContext.getResources().getDimensionPixelSize(2131299263);
      int j = paramContext.getResources().getDimensionPixelSize(2131299264);
      paramContext = fA;
      int[] arrayOfInt1 = fy;
      int[] arrayOfInt2 = fz;
      return new ysp(this, 1, 1, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
    }
    
    private void a(Context paramContext, View paramView, int paramInt, Object paramObject, auvd.a parama, View.OnClickListener paramOnClickListener)
    {
      if (this.jdField_a_of_type_Auvd != null) {}
      for (int i = this.jdField_a_of_type_Auvd.a(paramContext, paramView, paramInt, paramObject, parama, paramOnClickListener);; i = 0)
      {
        if (this.cbc != -1)
        {
          if (paramInt != this.cbc) {
            paramView.scrollTo(0, 0);
          }
        }
        else {
          return;
        }
        paramView.scrollTo(i, 0);
        return;
      }
    }
    
    private void a(a parama, SysSuspiciousMsg paramSysSuspiciousMsg)
    {
      if (paramSysSuspiciousMsg == null)
      {
        parama.Lx.setVisibility(8);
        parama.LS.setVisibility(8);
        parama.Ly.setVisibility(8);
        parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(8);
        parama.ej.setVisibility(8);
        return;
      }
      parama.b = paramSysSuspiciousMsg;
      parama.uin = (paramSysSuspiciousMsg.uin + "");
      parama.jdField_Lz_of_type_AndroidViewView.setOnClickListener(this);
      parama.pQ.setImageBitmap(a(parama.type, parama.uin));
      parama.Lx.setVisibility(0);
      TextView localTextView = parama.Lx;
      String str;
      if (paramSysSuspiciousMsg.nick == null)
      {
        str = "";
        localTextView.setText(str);
        b(parama, paramSysSuspiciousMsg);
        if (paramSysSuspiciousMsg.msg != null) {
          break label222;
        }
        parama.Ly.setVisibility(8);
        label160:
        if (paramSysSuspiciousMsg.reason != null) {
          break label244;
        }
        parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      for (;;)
      {
        parama.ej.setVisibility(0);
        parama.ej.setText(acfp.m(2131709052));
        parama.ej.setOnClickListener(this);
        parama.ej.setTag(parama);
        return;
        str = paramSysSuspiciousMsg.nick;
        break;
        label222:
        parama.Ly.setVisibility(0);
        parama.Ly.setText(paramSysSuspiciousMsg.msg);
        break label160;
        label244:
        parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(0);
        parama.jdField_Lz_of_type_AndroidWidgetTextView.setText(paramSysSuspiciousMsg.reason);
        paramSysSuspiciousMsg = this.mContext.getResources().getDrawable(2130848673);
        paramSysSuspiciousMsg.setBounds(0, 0, aqnm.dip2px(16.0F), aqnm.dip2px(16.0F));
        parama.jdField_Lz_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aqnm.dip2px(5.0F));
        parama.jdField_Lz_of_type_AndroidWidgetTextView.setCompoundDrawables(paramSysSuspiciousMsg, null, null, null);
      }
    }
    
    private void b(a parama, SysSuspiciousMsg paramSysSuspiciousMsg)
    {
      int j = 1;
      int i;
      switch (paramSysSuspiciousMsg.sex)
      {
      default: 
        parama.LS.setBackgroundResource(2130846773);
        i = 0;
        j = 0;
      }
      for (;;)
      {
        parama.LS.setText(paramSysSuspiciousMsg.age + "");
        parama.LS.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if (j != 0) {}
        parama.LS.setVisibility(8);
        return;
        i = 2130846772;
        parama.LS.setBackgroundResource(2130846773);
        continue;
        i = 2130846770;
        parama.LS.setBackgroundResource(2130846771);
      }
    }
    
    private void clA()
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage " + this.cbb);
      }
      if (!aqiw.isNetworkAvailable(this.mContext)) {}
      byte[] arrayOfByte;
      do
      {
        return;
        arrayOfByte = (byte[])this.bB.get(this.cbb);
        if ((this.cbb < 0) || (arrayOfByte != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage no cookie");
      return;
      this.cbb += 1;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(50, arrayOfByte, Integer.valueOf(this.cbb));
    }
    
    private void gr(long paramLong)
    {
      Object localObject = this.tc.iterator();
      SysSuspiciousMsg localSysSuspiciousMsg;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localSysSuspiciousMsg = (SysSuspiciousMsg)((Iterator)localObject).next();
      } while (localSysSuspiciousMsg.uin != paramLong);
      for (;;)
      {
        if (localSysSuspiciousMsg != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("base_uin", String.valueOf(localSysSuspiciousMsg.uin));
          ((Bundle)localObject).putString("base_nick", localSysSuspiciousMsg.nick);
          ((Bundle)localObject).putInt("verfy_type", 0);
          ((Bundle)localObject).putString("verfy_msg", localSysSuspiciousMsg.msg);
          AutoRemarkActivity.a((Activity)this.mContext, 0, localSysSuspiciousMsg.uin + "", 0L, (Bundle)localObject);
        }
        return;
        localSysSuspiciousMsg = null;
      }
    }
    
    public void al(boolean paramBoolean) {}
    
    public void d(View paramView)
    {
      if (paramView != null)
      {
        paramView = paramView.getTag(-1);
        if (!(paramView instanceof Integer)) {}
      }
      for (int i = ((Integer)paramView).intValue();; i = -1)
      {
        this.cbc = i;
        return;
      }
    }
    
    public void destroy()
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
      super.destroy();
    }
    
    public int getCount()
    {
      if (this.tc != null) {
        return this.tc.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.tc != null) && (paramInt < this.tc.size())) {
        return this.tc.get(paramInt);
      }
      return null;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      a locala;
      if (paramView == null)
      {
        locala = new a();
        localObject = LayoutInflater.from(this.mContext).inflate(2131561720, null);
        paramView = this.jdField_a_of_type_Auvd.a(this.mContext, (View)localObject, locala, -1);
        locala.pQ = ((ImageView)paramView.findViewById(2131361802));
        locala.Lx = ((TextView)paramView.findViewById(2131372384));
        locala.LS = ((TextView)paramView.findViewById(2131362339));
        locala.Ly = ((TextView)paramView.findViewById(2131377214));
        locala.jdField_Lz_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378586));
        locala.ej = ((Button)paramView.findViewById(2131377201));
        locala.LA = ((TextView)paramView.findViewById(2131377211));
        if ((locala.pQ instanceof ThemeImageView)) {
          ((ThemeImageView)locala.pQ).setSupportMaskView(true);
        }
        paramView.setTag(locala);
        if (ThemeUtil.isDefaultTheme())
        {
          ((View)localObject).setBackgroundResource(2130839642);
          a(this.mContext, paramView, paramInt, null, locala, this);
          localObject = getItem(paramInt);
          if (!(localObject instanceof SysSuspiciousMsg)) {
            break label315;
          }
        }
      }
      label315:
      for (Object localObject = (SysSuspiciousMsg)localObject;; localObject = null)
      {
        a(locala, (SysSuspiciousMsg)localObject);
        locala.jdField_Lz_of_type_AndroidViewView.setTag(locala);
        if (paramInt == 0) {
          paramView.setPadding(0, aqnm.dip2px(12.0F), 0, 0);
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          ((View)localObject).setBackgroundResource(2130839639);
          break;
          locala = (a)paramView.getTag();
          break;
          paramView.setPadding(0, 0, 0, 0);
        }
      }
    }
    
    public void hi() {}
    
    public void onClick(View paramView)
    {
      Object localObject = paramView.getTag();
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((localObject instanceof a))
        {
          anot.a(this.mApp, "dc00898", "", "", "0X800A32E", "0X800A32E", 0, 0, "", "", "", "");
          localObject = (a)localObject;
          Intent localIntent = new Intent();
          localIntent.putExtra("msg_extra", ((a)localObject).b);
          PublicFragmentActivity.start(this.mContext, localIntent, AddRequestSuspiciousMsgFragment.class);
          continue;
          if ((localObject instanceof a))
          {
            anot.a(this.mApp, "dc00898", "", "", "0X800A32C", "0X800A32C", 1, 0, "", "", "", "");
            localObject = (a)localObject;
            if (!aqiw.isNetworkAvailable(this.mContext))
            {
              QQToast.a(this.mContext, 2131696284, 0).show();
            }
            else if (((acff)this.mApp.getManager(51)).isFriend(((a)localObject).uin))
            {
              QQToast.a(this.mContext, acfp.m(2131709047), 0).show();
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.ht(((a)localObject).b.uin);
              continue;
              localObject = paramView.getTag(-1);
              if ((localObject instanceof Integer))
              {
                anot.a(this.mApp, "dc00898", "", "", "0X800A32D", "0X800A32D", 0, 0, "", "", "", "");
                int i = ((Integer)localObject).intValue();
                if (!aqiw.isNetworkAvailable(this.mContext))
                {
                  QQToast.a(this.mContext, 2131696284, 0).show();
                }
                else
                {
                  localObject = getItem(i);
                  if ((localObject instanceof SysSuspiciousMsg))
                  {
                    localObject = (SysSuspiciousMsg)localObject;
                    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null) {
                      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.hs(((SysSuspiciousMsg)localObject).uin);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public void onPause()
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "adapter onPause");
      }
      this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
    }
    
    public void onResume()
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "adapter onResume");
      }
      this.mApp.addObserver(this.jdField_a_of_type_Acfd);
    }
    
    public void onRightIconMenuHide(View paramView)
    {
      L(true);
    }
    
    public void onRightIconMenuShow(View paramView)
    {
      L(false);
    }
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      this.mLastVisibleIndex = (paramInt1 + paramInt2 - 1);
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if (paramInt == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onScrollStateChanged " + this.mLastVisibleIndex + " " + this.cba);
        }
        if ((this.mLastVisibleIndex == getCount() - 1) || (this.mLastVisibleIndex >= this.cba)) {
          clA();
        }
      }
    }
    
    public void refreshData()
    {
      ThreadManager.getSubThreadHandler().post(new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2(this));
    }
    
    public static class a
      extends abeg.a
    {
      public TextView LA;
      public TextView LS;
      public TextView Lx;
      public TextView Ly;
      public TextView Lz;
      public SysSuspiciousMsg b;
      public Button ej;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */