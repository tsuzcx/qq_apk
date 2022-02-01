package com.tencent.mobileqq.receipt;

import acnd;
import alsw;
import alsx;
import alsy;
import alsz;
import alta;
import altf;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aqgv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import jnm;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListReq;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListRsp;
import tencent.im.oidb.cmd0x985.oidb_0x985.ReqBody;
import tencent.im.oidb.cmd0x985.oidb_0x985.RspBody;
import tencent.im.oidb.cmd0x985.oidb_0x985.UinInfo;
import tencent.im.oidb.cmd0x986.oidb_0x986.ReqBody;
import tencent.im.oidb.cmd0x986.oidb_0x986.RspBody;
import tencent.im.oidb.cmd0x986.oidb_0x986.UinInfo;

public class ReceiptMessageReadMemberListContainerFragment
  extends IphoneTitleBarFragment
{
  private long Bz;
  private long IT;
  private Comparator<ReceiptMessageReadMemberListFragment.MemberInfo> Q = new alsx(this);
  private Comparator<ReceiptMessageReadMemberListFragment.MemberInfo> R = new alsy(this);
  private boolean Sf;
  private b jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageReadMemberListContainerFragment$b;
  private c jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageReadMemberListContainerFragment$c;
  private long ahG;
  private acnd jdField_b_of_type_Acnd = new alsw(this);
  private QQViewPager jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager;
  private TabBarView.a jdField_b_of_type_ComTencentMobileqqWidgetTabBarView$a = new alsz(this);
  private TabBarView c;
  private QQAppInterface mApp;
  private long mMsgTime;
  private ViewPager.OnPageChangeListener mOnPageChangeListener = new alta(this);
  private SessionInfo mSessionInfo;
  private long mTroopCode;
  private boolean rB;
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> yR;
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> yS;
  
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> A(List<oidb_0x985.UinInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0x985.UinInfo localUinInfo = (oidb_0x985.UinInfo)paramList.next();
      String str = Long.toString(localUinInfo.uint64_uin.get());
      if (!Long.toString(this.Bz).equals(str)) {
        localArrayList.add(new ReceiptMessageReadMemberListFragment.MemberInfo(str, localUinInfo.bytes_name.get().toStringUtf8(), localUinInfo.uint32_time.get()));
      }
    }
    return localArrayList;
  }
  
  private void dJp()
  {
    oidb_0x985.ReqBody localReqBody = new oidb_0x985.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x985.GetReadListReq localGetReadListReq = new oidb_0x985.GetReadListReq();
    localGetReadListReq.uint32_msg_seq.set((int)this.ahG);
    localGetReadListReq.uint64_conf_uin.set(parseLong(this.mSessionInfo.aTl));
    localGetReadListReq.uint64_from_uin.set(this.Bz);
    localReqBody.msg_get_read_list_req.set(localGetReadListReq);
    jnm.a(this.mApp, new a(this), localReqBody.toByteArray(), "OidbSvc.0x985", 2437, 0);
  }
  
  private void dJt()
  {
    ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.1(this), 10, null, true);
  }
  
  private void dJu()
  {
    ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.2(this), 8, null, true);
  }
  
  private void dJv()
  {
    Iterator localIterator = this.yR.iterator();
    ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo;
    while (localIterator.hasNext())
    {
      localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)localIterator.next();
      localMemberInfo.name = aqgv.h(this.mApp, Long.toString(this.mTroopCode), localMemberInfo.uin);
    }
    localIterator = this.yS.iterator();
    while (localIterator.hasNext())
    {
      localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)localIterator.next();
      localMemberInfo.name = aqgv.h(this.mApp, Long.toString(this.mTroopCode), localMemberInfo.uin);
    }
    this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageReadMemberListContainerFragment$b.sendEmptyMessage(5);
  }
  
  private void dJw()
  {
    if (!isAdded()) {
      return;
    }
    QQToast.a(this.mApp.getApp(), 1, 2131700659, 0).show();
  }
  
  private void dJx()
  {
    if (!this.Sf) {
      return;
    }
    ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.6(this), 8, null, false);
  }
  
  private void initViewPager()
  {
    this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageReadMemberListContainerFragment$c = new c(getChildFragmentManager(), null);
    Object localObject = getString(2131700671);
    String str = getString(2131700679);
    this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageReadMemberListContainerFragment$c.a(this.yR, this.yS, new String[] { localObject, str });
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageReadMemberListContainerFragment$c);
    this.c.setUnselectColor(getResources().getColor(2131167393));
    this.c.a(String.format(getString(2131700660), new Object[] { Integer.valueOf(this.yR.size()) }));
    this.c.a(String.format(getString(2131700661), new Object[] { Integer.valueOf(this.yS.size()) }));
    this.c.setSelectedTab(0, false);
    this.c.setOnTabChangeListener(this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView$a);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.TN(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(0);
    this.c.setVisibility(0);
    stopTitleProgress();
    localObject = new Intent();
    ((Intent)localObject).putExtra("ReceiptMessageReadMemberListContainerFragment.RESULT_KEY_READ_NUMBER", this.yR.size());
    getActivity().setResult(-1, (Intent)localObject);
  }
  
  private void kO(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "packAndSendTroopFetchReadMemberRequest with troopCode: " + this.mTroopCode + " startUin: " + paramLong);
    }
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.mMsgTime);
    localReqBody.uint64_group_code.set(this.mTroopCode);
    localReqBody.uint32_msg_seq.set((int)this.ahG);
    localReqBody.uint64_start_uin.set(paramLong);
    localReqBody.uint64_from_uin.set(this.Bz);
    jnm.a(this.mApp, new d(this), localReqBody.toByteArray(), "OidbSvc.0x986_1", 2438, 1);
  }
  
  private long parseLong(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, QLog.getStackTraceString(paramString));
      }
    }
    return -1L;
  }
  
  private void sortList()
  {
    Collections.sort(this.yR, this.Q);
    Collections.sort(this.yS, this.R);
  }
  
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> z(List<oidb_0x986.UinInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0x986.UinInfo localUinInfo = (oidb_0x986.UinInfo)paramList.next();
      localArrayList.add(new ReceiptMessageReadMemberListFragment.MemberInfo(Long.toString(localUinInfo.uint64_uin.get()), "", localUinInfo.uint32_msg_read_time.get()));
    }
    return localArrayList;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.mContentView.findViewById(2131381985));
    this.c = ((TabBarView)this.mContentView.findViewById(2131379139));
    setTitle(getString(2131700662));
    startTitleProgress();
  }
  
  public int getContentLayoutId()
  {
    return 2131558709;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)getActivity().getAppInterface());
      paramActivity = getArguments();
      this.mTroopCode = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_TROOP_CODE");
      this.mMsgTime = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_TIME");
      this.Bz = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SENDER_UIN");
      this.Sf = paramActivity.getBoolean("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_IS_SENDER");
      this.IT = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_UNISEQ");
      this.mSessionInfo = ((SessionInfo)paramActivity.getParcelable("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SESSION_INFO"));
      this.ahG = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.extra_shmsgseq", -1L);
      if (this.mSessionInfo.cZ != 1) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      this.rB = bool;
      return;
      throw new IllegalStateException("Only allowed in main progress");
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMessageReadMemberListContainerFragment$b = new b(this, null);
    dJt();
  }
  
  static class a
    extends altf<ReceiptMessageReadMemberListContainerFragment>
  {
    a(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment)
    {
      super();
    }
    
    public void c(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if ((paramInt != 0) || (paramArrayOfByte == null)) {
        if (QLog.isColorLevel()) {
          QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "mGetMemberList request error on code: " + paramInt);
        }
      }
      do
      {
        return;
        try
        {
          paramBundle = new oidb_0x985.RspBody();
          paramBundle.mergeFrom(paramArrayOfByte);
          paramInt = paramBundle.uint32_code.get();
          if (paramInt == 0)
          {
            paramBundle = (oidb_0x985.GetReadListRsp)paramBundle.msg_get_read_list_rsp.get();
            paramArrayOfByte = paramBundle.rpt_msg_read_list.get();
            paramBundle = paramBundle.rpt_msg_unread_list.get();
            ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex, ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex, paramArrayOfByte));
            ReceiptMessageReadMemberListContainerFragment.b((ReceiptMessageReadMemberListContainerFragment)this.ex, ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex, paramBundle));
            ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex).sendEmptyMessage(2);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "fetch read member fail on invalid data");
          return;
        }
        QLog.d("ReceiptMessageReadMemberListContainerFragment", 1, "mGetMemberList fail on code: " + paramInt);
        if (paramInt == 5)
        {
          ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex).sendEmptyMessage(-1);
          return;
        }
      } while (paramInt != 20);
      ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex).sendEmptyMessage(-1);
    }
  }
  
  public static class b
    extends Handler
  {
    private WeakReference<ReceiptMessageReadMemberListContainerFragment> mOuter;
    
    private b(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment)
    {
      this.mOuter = new WeakReference(paramReceiptMessageReadMemberListContainerFragment);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ReceiptMessageReadMemberListContainerFragment localReceiptMessageReadMemberListContainerFragment = (ReceiptMessageReadMemberListContainerFragment)this.mOuter.get();
      if ((localReceiptMessageReadMemberListContainerFragment == null) || (!localReceiptMessageReadMemberListContainerFragment.isAdded())) {}
      do
      {
        return;
        switch (paramMessage.what)
        {
        case 0: 
        default: 
          return;
        case -1: 
          localReceiptMessageReadMemberListContainerFragment.stopTitleProgress();
          ReceiptMessageReadMemberListContainerFragment.g(localReceiptMessageReadMemberListContainerFragment);
          return;
        case 1: 
          ReceiptMessageReadMemberListContainerFragment.b(localReceiptMessageReadMemberListContainerFragment);
          return;
        }
      } while (this.mOuter.get() == null);
      if (ReceiptMessageReadMemberListContainerFragment.a(localReceiptMessageReadMemberListContainerFragment)) {
        ReceiptMessageReadMemberListContainerFragment.c(localReceiptMessageReadMemberListContainerFragment);
      }
      for (;;)
      {
        ReceiptMessageReadMemberListContainerFragment.d(localReceiptMessageReadMemberListContainerFragment);
        return;
        sendEmptyMessage(5);
      }
      ReceiptMessageReadMemberListContainerFragment.a(localReceiptMessageReadMemberListContainerFragment, ((Long)paramMessage.obj).longValue());
      return;
      ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.ListProcessHandler.1(this, localReceiptMessageReadMemberListContainerFragment), 8, null, true);
      return;
      ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.ListProcessHandler.2(this, localReceiptMessageReadMemberListContainerFragment), 8, null, true);
    }
  }
  
  static class c
    extends FragmentPagerAdapter
  {
    private String[] gn;
    private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> yR;
    private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> yS;
    
    private c(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public void a(@Nonnull ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> paramArrayList1, @Nonnull ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> paramArrayList2, @Nonnull String[] paramArrayOfString)
    {
      this.yR = paramArrayList1;
      this.yS = paramArrayList2;
      this.gn = paramArrayOfString;
    }
    
    public int getCount()
    {
      return 2;
    }
    
    public Fragment getItem(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return ReceiptMessageReadMemberListFragment.a(this.yR, this.gn[1]);
      case 0: 
        return ReceiptMessageReadMemberListFragment.a(this.yR, this.gn[0]);
      }
      return ReceiptMessageReadMemberListFragment.a(this.yS, this.gn[1]);
    }
  }
  
  static class d
    extends altf<ReceiptMessageReadMemberListContainerFragment>
  {
    d(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment)
    {
      super();
    }
    
    public void c(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageReadMemberListContainerFragment", 4, "mTroopFetchReadMemberListCallback onRes: " + paramInt);
      }
      if ((paramInt == 0) && (paramArrayOfByte != null))
      {
        for (;;)
        {
          try
          {
            paramBundle = new oidb_0x986.RspBody();
            paramBundle.mergeFrom(paramArrayOfByte);
            paramArrayOfByte = paramBundle.rpt_msg_uin_info.get();
            paramArrayOfByte = ReceiptMessageReadMemberListContainerFragment.b((ReceiptMessageReadMemberListContainerFragment)this.ex, paramArrayOfByte).iterator();
            if (!paramArrayOfByte.hasNext()) {
              break;
            }
            ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)paramArrayOfByte.next();
            if (!Long.toString(ReceiptMessageReadMemberListContainerFragment.d((ReceiptMessageReadMemberListContainerFragment)this.ex)).equals(localMemberInfo.uin)) {
              if (localMemberInfo.readTime > 0L) {
                ReceiptMessageReadMemberListContainerFragment.b((ReceiptMessageReadMemberListContainerFragment)this.ex).add(localMemberInfo);
              } else {
                ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex).add(localMemberInfo);
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte)
          {
            QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "fetch read member fail on invalid data");
            ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex).sendEmptyMessage(-1);
            return;
          }
        }
        if (paramBundle.uint64_next_uin.get() == 0L)
        {
          ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex).sendEmptyMessage(2);
          return;
        }
        paramArrayOfByte = ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex).obtainMessage(3, Long.valueOf(paramBundle.uint64_next_uin.get()));
        ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex).sendMessage(paramArrayOfByte);
        return;
      }
      ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.ex).sendEmptyMessage(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment
 * JD-Core Version:    0.7.0.1
 */