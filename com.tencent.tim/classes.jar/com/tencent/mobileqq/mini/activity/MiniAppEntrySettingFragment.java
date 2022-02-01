package com.tencent.mobileqq.mini.activity;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiniAppEntrySettingFragment
  extends IphoneTitleBarFragment
{
  private static final String TAG = "MiniAppEntrySettingFragment";
  private FragmentActivity activity;
  private BounceScrollView mSettingLayout;
  private ListView mSettingListView;
  private SettingListViewAdapter mSettingListViewAdapter;
  private ArrayList<MiniAppSettingSwitchInfoEntity> switchInfoList = new ArrayList();
  
  private void initData()
  {
    if (this.activity != null)
    {
      Object localObject = this.activity.getAppInterface().getEntityManagerFactory().createEntityManager().query(MiniAppSettingSwitchInfoEntity.class, MiniAppSettingSwitchInfoEntity.class.getSimpleName(), false, null, null, null, null, null, null);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MiniAppSettingSwitchInfoEntity localMiniAppSettingSwitchInfoEntity = (MiniAppSettingSwitchInfoEntity)((Iterator)localObject).next();
          if ((localMiniAppSettingSwitchInfoEntity != null) && (!TextUtils.isEmpty(localMiniAppSettingSwitchInfoEntity.key))) {
            this.switchInfoList.add(localMiniAppSettingSwitchInfoEntity);
          }
        }
      }
    }
    MiniAppCmdUtil.getInstance().getSwitchList(null, new MiniAppEntrySettingFragment.2(this));
  }
  
  private void initUI(View paramView)
  {
    this.mSettingLayout = ((BounceScrollView)paramView.findViewById(2131371582));
    if (MiniAppUtils.isNightMode()) {
      this.mSettingLayout.setBackgroundColor(-16777216);
    }
    this.mSettingListView = ((ListView)paramView.findViewById(2131371820));
    this.mSettingListViewAdapter = new SettingListViewAdapter(paramView.getContext());
    this.mSettingListView.setAdapter(this.mSettingListViewAdapter);
    if (this.activity != null) {
      this.activity.runOnUiThread(new MiniAppEntrySettingFragment.1(this));
    }
  }
  
  /* Error */
  private void saveLocalSwitchDataList(List<MiniAppSettingSwitchInfoEntity> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/tencent/mobileqq/mini/activity/MiniAppEntrySettingFragment:activity	Landroid/support/v4/app/FragmentActivity;
    //   4: ifnull +53 -> 57
    //   7: aload_0
    //   8: getfield 47	com/tencent/mobileqq/mini/activity/MiniAppEntrySettingFragment:activity	Landroid/support/v4/app/FragmentActivity;
    //   11: getfield 202	android/support/v4/app/FragmentActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: astore_2
    //   15: aload_1
    //   16: ifnull +16 -> 32
    //   19: aload_1
    //   20: invokeinterface 108 1 0
    //   25: ifeq +7 -> 32
    //   28: aload_2
    //   29: ifnonnull +29 -> 58
    //   32: ldc 14
    //   34: iconst_2
    //   35: new 204	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   42: ldc 207
    //   44: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: return
    //   58: aload_2
    //   59: invokevirtual 82	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   62: invokevirtual 88	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull -10 -> 57
    //   70: aload_3
    //   71: invokevirtual 227	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 232	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   79: aload_1
    //   80: invokeinterface 112 1 0
    //   85: astore_1
    //   86: aload_1
    //   87: invokeinterface 118 1 0
    //   92: ifeq +42 -> 134
    //   95: aload_0
    //   96: aload_3
    //   97: aload_1
    //   98: invokeinterface 122 1 0
    //   103: checkcast 90	com/tencent/mobileqq/mini/entry/MiniAppSettingSwitchInfoEntity
    //   106: invokespecial 63	com/tencent/mobileqq/mini/activity/MiniAppEntrySettingFragment:updateSwitchData	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   109: pop
    //   110: goto -24 -> 86
    //   113: astore_1
    //   114: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +12 -> 129
    //   120: ldc 14
    //   122: iconst_2
    //   123: ldc 237
    //   125: aload_1
    //   126: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: invokevirtual 244	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   133: return
    //   134: aload_2
    //   135: invokevirtual 247	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   138: aload_2
    //   139: invokevirtual 244	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   142: return
    //   143: astore_1
    //   144: aload_2
    //   145: invokevirtual 244	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	MiniAppEntrySettingFragment
    //   0	150	1	paramList	List<MiniAppSettingSwitchInfoEntity>
    //   14	131	2	localObject	Object
    //   65	32	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   79	86	113	java/lang/Exception
    //   86	110	113	java/lang/Exception
    //   134	138	113	java/lang/Exception
    //   79	86	143	finally
    //   86	110	143	finally
    //   114	129	143	finally
    //   134	138	143	finally
  }
  
  private void updateDataToDB(MiniAppSettingSwitchInfoEntity paramMiniAppSettingSwitchInfoEntity)
  {
    if ((paramMiniAppSettingSwitchInfoEntity == null) || (TextUtils.isEmpty(paramMiniAppSettingSwitchInfoEntity.key))) {
      return;
    }
    QLog.e("MiniAppEntrySettingFragment", 2, "updateDataToDB entity.key:" + paramMiniAppSettingSwitchInfoEntity.key);
    ThreadManager.excute(new MiniAppEntrySettingFragment.4(this, paramMiniAppSettingSwitchInfoEntity), 32, null, true);
  }
  
  private void updateLocalSwitchDataList(List<MiniAppSettingSwitchInfoEntity> paramList)
  {
    ThreadManager.excute(new MiniAppEntrySettingFragment.3(this, paramList), 32, null, true);
  }
  
  private boolean updateSwitchData(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        paramEntityManager.close();
      }
    }
    do
    {
      return bool1;
      if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
        break;
      }
      bool1 = paramEntityManager.update(paramEntity);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("MiniAppEntrySettingFragment", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public int getContentLayoutId()
  {
    return 2131562574;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.activity = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.activity = getActivity();
    setTitle(acfp.m(2131708381));
    initData();
    initUI(paramView);
  }
  
  class SettingListViewAdapter
    extends BaseAdapter
  {
    private final int TYPE_ERROR = -1;
    private final int TYPE_MUULTI_LINE = 1;
    private final int TYPE_SINGLE_LINE = 0;
    private Context mContext;
    private ArrayList<MiniAppSettingSwitchInfoEntity> mData;
    
    public SettingListViewAdapter(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private CompoundButton.OnCheckedChangeListener getOnCheckedChangeListener(MiniAppSettingSwitchInfoEntity paramMiniAppSettingSwitchInfoEntity)
    {
      return new MiniAppEntrySettingFragment.SettingListViewAdapter.1(this, paramMiniAppSettingSwitchInfoEntity);
    }
    
    public int getCount()
    {
      if (this.mData != null) {
        return this.mData.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((this.mData != null) && (paramInt < this.mData.size()))
      {
        MiniAppSettingSwitchInfoEntity localMiniAppSettingSwitchInfoEntity = (MiniAppSettingSwitchInfoEntity)this.mData.get(paramInt);
        if (localMiniAppSettingSwitchInfoEntity != null)
        {
          if (TextUtils.isEmpty(localMiniAppSettingSwitchInfoEntity.subTitle)) {
            return 0;
          }
          return 1;
        }
      }
      return -1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      MiniAppSettingSwitchInfoEntity localMiniAppSettingSwitchInfoEntity = (MiniAppSettingSwitchInfoEntity)this.mData.get(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.mContext).inflate(2131562573, null);
        paramView = new Holder();
        paramView.singleLineSwitchItem = ((FormSwitchItem)localView.findViewById(2131371841));
        paramView.multiLineSwitchItem = ((FormMultiLineSwitchItem)localView.findViewById(2131371840));
        localView.setTag(paramView);
      }
      for (;;)
      {
        switch (getItemViewType(paramInt))
        {
        default: 
          EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
          return localView;
          localObject = (Holder)paramView.getTag();
          localView = paramView;
          paramView = (View)localObject;
        }
      }
      paramView.singleLineSwitchItem.setVisibility(0);
      paramView.singleLineSwitchItem.setText(localMiniAppSettingSwitchInfoEntity.title);
      Object localObject = paramView.singleLineSwitchItem;
      if (localMiniAppSettingSwitchInfoEntity.value == 1) {}
      for (;;)
      {
        ((FormSwitchItem)localObject).setChecked(bool1);
        paramView.singleLineSwitchItem.setOnCheckedChangeListener(getOnCheckedChangeListener(localMiniAppSettingSwitchInfoEntity));
        paramView.multiLineSwitchItem.setVisibility(8);
        break;
        bool1 = false;
      }
      paramView.singleLineSwitchItem.setVisibility(8);
      paramView.multiLineSwitchItem.setText(localMiniAppSettingSwitchInfoEntity.title);
      paramView.multiLineSwitchItem.setSecendLineText(localMiniAppSettingSwitchInfoEntity.subTitle);
      localObject = paramView.multiLineSwitchItem;
      if (localMiniAppSettingSwitchInfoEntity.value == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ((FormMultiLineSwitchItem)localObject).setChecked(bool1);
        paramView.multiLineSwitchItem.setOnCheckedChangeListener(getOnCheckedChangeListener(localMiniAppSettingSwitchInfoEntity));
        paramView.multiLineSwitchItem.setVisibility(0);
        break;
      }
    }
    
    public void setData(ArrayList<MiniAppSettingSwitchInfoEntity> paramArrayList)
    {
      if (paramArrayList == null) {
        return;
      }
      this.mData = paramArrayList;
      notifyDataSetChanged();
    }
    
    class Holder
    {
      FormMultiLineSwitchItem multiLineSwitchItem;
      FormSwitchItem singleLineSwitchItem;
      
      Holder() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment
 * JD-Core Version:    0.7.0.1
 */