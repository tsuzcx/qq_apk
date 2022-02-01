package com.tencent.mobileqq.activity.chathistory;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anre;
import aofe;
import aofk;
import aqdj;
import aqgv;
import aqmu;
import aqnm;
import aqpm;
import aurf;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;
import top;
import ymr;
import yms;
import ymt;
import ymu;

public class TroopMemberHistoryFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public static final String TAG = TroopMemberHistoryFragment.class.getSimpleName();
  XListView A;
  private long FI = 9223372036854775807L;
  public TextView KP;
  LoadMsgThread a;
  public c a;
  MqqHandler b = new aurf(this.mCallback);
  View.OnClickListener bJ = new ymu(this);
  boolean bnA;
  public boolean bnB = false;
  public QQAppInterface mApp;
  Handler.Callback mCallback = new ymt(this);
  public View mEmptyView;
  public boolean mIsLoading = false;
  String mMemberName;
  String mMemberUin;
  public String mTroopUin;
  ArrayList<String> rc;
  
  public TroopMemberHistoryFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment$LoadMsgThread = new LoadMsgThread(null);
  }
  
  private void initData(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      finish();
      return;
    }
    Object localObject = getActivity();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FragmentActivity)localObject).getAppInterface())
    {
      if (!(localObject instanceof QQAppInterface)) {
        break label123;
      }
      this.mApp = ((QQAppInterface)localObject);
      this.mTroopUin = paramBundle.getString("troop_uin", "0");
      this.mMemberUin = paramBundle.getString("member_uin", "0");
      this.rc = paramBundle.getStringArrayList("members_uin");
      this.bnA = paramBundle.getBoolean("member_is_shield", false);
      if ((!TextUtils.isEmpty(this.mTroopUin)) && (!TextUtils.isEmpty(this.mMemberUin)) && (!TextUtils.isEmpty(((AppInterface)localObject).getCurrentAccountUin()))) {
        break;
      }
      finish();
      return;
    }
    label123:
    QLog.e(TAG, 1, "app is null");
    finish();
  }
  
  public void Ei(int paramInt)
  {
    if (this.mIsLoading) {
      return;
    }
    this.mIsLoading = true;
    switch (paramInt)
    {
    }
    do
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment$LoadMsgThread.Ej(paramInt);
      ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment$LoadMsgThread, 8, null, true);
      return;
    } while (!this.bnA);
    this.KP.setText(2131699806);
    this.mEmptyView.setVisibility(0);
  }
  
  public List<b> cP()
  {
    boolean bool = false;
    if (this.bnB) {
      return null;
    }
    Object localObject3 = this.mApp.a().createEntityManager();
    Object localObject4 = MessageRecord.getTableName(this.mTroopUin, 1);
    Object localObject1 = top.ox();
    if ((this.mMemberUin.equals("0")) && (this.rc != null) && (this.rc.size() > 0))
    {
      localObject2 = new StringBuilder();
      int i = 0;
      while (i < this.rc.size())
      {
        ((StringBuilder)localObject2).append("senderuin = ? ");
        if (i < this.rc.size() - 1) {
          ((StringBuilder)localObject2).append("or ");
        }
        i += 1;
      }
      localObject1 = String.format("%s and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { ((StringBuilder)localObject2).toString(), localObject1 });
      localObject2 = (String[])this.rc.toArray(new String[0]);
    }
    for (;;)
    {
      localObject1 = ((EntityManager)localObject3).query(MessageRecord.class, (String)localObject4, false, (String)localObject1, (String[])localObject2, null, null, "shmsgseq DESC", String.valueOf(50));
      ((EntityManager)localObject3).close();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break label267;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG, 2, "load msg null");
      return null;
      localObject1 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(this.FI), localObject1 });
      localObject2 = new String[1];
      localObject2[0] = this.mMemberUin;
    }
    label267:
    if (((List)localObject1).size() < 50) {
      bool = true;
    }
    this.bnB = bool;
    Object localObject2 = new LinkedList();
    localObject3 = ((List)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (MessageRecord)((Iterator)localObject3).next();
      switch (((MessageRecord)localObject4).msgtype)
      {
      default: 
        localObject1 = acfp.m(2131715973);
      }
    }
    for (;;)
    {
      if (this.FI > ((MessageRecord)localObject4).shmsgseq) {
        this.FI = ((MessageRecord)localObject4).shmsgseq;
      }
      ((List)localObject2).add(new b(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).time, (CharSequence)localObject1, ((MessageRecord)localObject4).shmsgseq, (MessageRecord)localObject4));
      break;
      localObject1 = aqpm.a(((MessageRecord)localObject4).msg, (MessageRecord)localObject4, 32, 13);
      continue;
      if ((localObject4 instanceof MessageForPic))
      {
        localObject1 = ((MessageForPic)localObject4).getSummaryMsg();
      }
      else
      {
        localObject1 = BaseApplicationImpl.getApplication().getString(2131694739);
        continue;
        localObject1 = BaseApplicationImpl.getApplication().getString(2131692316);
        continue;
        localObject1 = BaseApplicationImpl.getApplication().getString(2131692318);
        continue;
        localObject1 = new MessageForMixedMsg();
        ((MessageForMixedMsg)localObject1).msgData = ((MessageRecord)localObject4).msgData;
        ((MessageForMixedMsg)localObject1).parse();
        if (((MessageForMixedMsg)localObject1).msg == null) {}
        for (localObject1 = acfp.m(2131715944);; localObject1 = new aofk(((MessageForMixedMsg)localObject1).msg, 13, 32, 1)) {
          break;
        }
        if ((localObject4 instanceof MessageForMarketFace))
        {
          localObject1 = ((MessageForMarketFace)localObject4).mMarkFaceMessage;
          if ((localObject1 != null) && (!TextUtils.isEmpty(((MarkFaceMessage)localObject1).faceName))) {}
          for (localObject1 = "[" + ((MarkFaceMessage)localObject1).faceName + "]";; localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131693094)) {
            break;
          }
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131693094);
        continue;
        localObject1 = BaseApplicationImpl.getApplication().getString(2131721065);
        continue;
        try
        {
          localObject1 = anre.a(((MessageRecord)localObject4).msgData);
          if (localObject1 == null) {
            localObject1 = acfp.m(2131715915);
          } else {
            localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
          }
        }
        catch (Exception localException)
        {
          String str = acfp.m(2131715907);
        }
        continue;
        return localObject2;
      }
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    initData(getArguments());
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "data inited");
    }
    initUI();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ui inited");
    }
    Ei(20);
  }
  
  protected void finish()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560775;
  }
  
  protected void initUI()
  {
    this.A = ((XListView)this.mContentView.findViewById(2131371096));
    this.mEmptyView = this.mContentView.findViewById(2131366408);
    this.KP = ((TextView)this.mContentView.findViewById(2131379419));
    this.mEmptyView.findViewById(2131379638).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment$c = new c(getActivity());
    this.mMemberName = aqgv.h(this.mApp, this.mTroopUin, this.mMemberUin);
    this.A.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment$c);
    this.A.setOnTouchListener(new ymr(this));
    this.A.setOnScrollListener(new yms(this));
    if ((this.mMemberUin.equals("0")) && (this.rc != null)) {
      setTitle(acfp.m(2131715925));
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "res_exp", 0, 0, this.mTroopUin, "", "", "");
      return;
      if (this.mMemberName != null)
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(new aofe(this.mMemberName, 32).k()).append("的发言");
        setTitle(localSpannableStringBuilder);
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  public void onDetach()
  {
    super.onDetach();
    if (this.b != null) {
      this.b.removeCallbacksAndMessages(null);
    }
  }
  
  class LoadMsgThread
    implements Runnable
  {
    private int bZZ;
    
    private LoadMsgThread() {}
    
    public void Ej(int paramInt)
    {
      this.bZZ = paramInt;
    }
    
    public void run()
    {
      long l1;
      Message localMessage;
      if (!TroopMemberHistoryFragment.this.isDetached())
      {
        l1 = System.currentTimeMillis();
        List localList = TroopMemberHistoryFragment.this.cP();
        localMessage = TroopMemberHistoryFragment.this.b.obtainMessage(0, localList);
        localMessage.arg1 = this.bZZ;
        if ((localList != null) && (!localList.isEmpty())) {
          break label83;
        }
        localMessage.arg2 = 11;
      }
      for (;;)
      {
        TroopMemberHistoryFragment.this.b.sendMessage(localMessage);
        return;
        label83:
        localMessage.arg2 = 10;
        if (QLog.isColorLevel())
        {
          long l2 = System.currentTimeMillis();
          QLog.d(TroopMemberHistoryFragment.TAG, 2, "More messages loaded. Costs " + (l2 - l1) + " ms.");
        }
      }
    }
  }
  
  static class a
  {
    public TextView KQ;
    public ColorNickTextView c;
    public View ev;
    public ImageView icon;
    public RelativeLayout ij;
    public TextView time;
  }
  
  public class b
  {
    CharSequence N;
    CharSequence O;
    boolean bnC;
    long mTime;
    public MessageRecord messageRecord;
    String senderuin;
    long shmsgseq;
    
    public b(String paramString, long paramLong1, CharSequence paramCharSequence, long paramLong2, MessageRecord paramMessageRecord)
    {
      this.senderuin = paramString;
      this.mTime = paramLong1;
      this.N = paramCharSequence;
      this.shmsgseq = paramLong2;
      this.messageRecord = paramMessageRecord;
      this.bnC = false;
    }
    
    public CharSequence m()
    {
      if (this.O == null)
      {
        Calendar.getInstance().setTimeInMillis(this.mTime * 1000L);
        this.O = aqmu.a(BaseApplicationImpl.getApplication().getApplicationContext(), 3, this.mTime * 1000L);
      }
      return this.O;
    }
  }
  
  public class c
    extends BaseAdapter
  {
    private Context mContext;
    private List<TroopMemberHistoryFragment.b> mItemList = new LinkedList();
    
    c(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public boolean aa(List<TroopMemberHistoryFragment.b> paramList)
    {
      int j = paramList.size();
      int i = 0;
      long l2;
      for (long l1 = 0L; i < j; l1 = l2)
      {
        TroopMemberHistoryFragment.b localb = (TroopMemberHistoryFragment.b)paramList.get(i);
        l2 = localb.mTime;
        if ((l1 == 0L) || (!g(l1, l2))) {
          localb.bnC = true;
        }
        this.mItemList.add(localb);
        i += 1;
      }
      return true;
    }
    
    boolean g(long paramLong1, long paramLong2)
    {
      CalendarDay localCalendarDay1 = new CalendarDay(paramLong1 * 1000L);
      CalendarDay localCalendarDay2 = new CalendarDay(paramLong2 * 1000L);
      return (localCalendarDay1.year == localCalendarDay2.year) && (localCalendarDay1.month == localCalendarDay2.month) && (localCalendarDay1.day == localCalendarDay2.day);
    }
    
    public int getCount()
    {
      return this.mItemList.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.mItemList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      TroopMemberHistoryFragment.a locala;
      TroopMemberHistoryFragment.b localb;
      Object localObject;
      RelativeLayout.LayoutParams localLayoutParams;
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, 2131559542, null);
        locala = new TroopMemberHistoryFragment.a();
        locala.c = ((ColorNickTextView)paramView.findViewById(2131379402));
        locala.KQ = ((TextView)paramView.findViewById(2131379404));
        locala.icon = ((ImageView)paramView.findViewById(2131368698));
        locala.time = ((TextView)paramView.findViewById(2131370129));
        locala.ev = paramView.findViewById(2131370542);
        locala.ij = ((RelativeLayout)paramView.findViewById(2131380334));
        paramView.setTag(locala);
        localb = (TroopMemberHistoryFragment.b)getItem(paramInt);
        locala.KQ.setText(localb.N);
        locala.time.setText(localb.m());
        localObject = new aofe(aqgv.h(TroopMemberHistoryFragment.this.mApp, TroopMemberHistoryFragment.this.mTroopUin, localb.senderuin), 16).k();
        locala.c.setText((CharSequence)localObject);
        aqpm.a(TroopMemberHistoryFragment.this.mApp, locala.c, (Spannable)localObject);
        localObject = aqdj.a(TroopMemberHistoryFragment.this.mApp, 1, localb.senderuin);
        locala.icon.setImageDrawable((Drawable)localObject);
        localObject = (RelativeLayout.LayoutParams)locala.icon.getLayoutParams();
        localLayoutParams = (RelativeLayout.LayoutParams)locala.time.getLayoutParams();
        if (!localb.bnC) {
          break label458;
        }
        locala.icon.setVisibility(0);
        locala.ev.setVisibility(0);
        if (paramInt != 0) {
          break label436;
        }
        i = aqnm.dip2px(3.0F);
        label301:
        ((RelativeLayout.LayoutParams)localObject).topMargin = i;
        if (paramInt != 0) {
          break label447;
        }
        i = aqnm.dip2px(3.0F);
      }
      label319:
      for (localLayoutParams.topMargin = i;; localLayoutParams.topMargin = 0)
      {
        locala.icon.setLayoutParams((ViewGroup.LayoutParams)localObject);
        locala.time.setLayoutParams(localLayoutParams);
        locala.ij.setTag(Integer.valueOf(paramInt));
        locala.ij.setOnClickListener(TroopMemberHistoryFragment.this.bJ);
        paramView.setContentDescription(localb.N + " " + localb.m());
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        locala = (TroopMemberHistoryFragment.a)paramView.getTag();
        break;
        i = aqnm.dip2px(9.0F);
        break label301;
        i = aqnm.dip2px(9.0F);
        break label319;
        label458:
        locala.icon.setVisibility(4);
        locala.ev.setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment
 * JD-Core Version:    0.7.0.1
 */