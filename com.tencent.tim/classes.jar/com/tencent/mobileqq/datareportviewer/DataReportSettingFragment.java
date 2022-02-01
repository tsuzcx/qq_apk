package com.tencent.mobileqq.datareportviewer;

import acfp;
import afbe;
import afbf;
import afbg;
import afbh;
import afbk;
import afbl;
import afbm;
import afbx;
import afbz;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import aqha;
import aqju;
import aquz;
import aqva;
import aqvc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;

public class DataReportSettingFragment
  extends IphoneTitleBarFragment
{
  public a a;
  protected FormSwitchItem aU;
  protected FormSwitchItem aV;
  protected ArrayList<afbe> mList;
  protected ListView mListView;
  
  protected void cYl()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
    aquz localaquz = new aquz("https://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
    localaquz.atW = 60L;
    ((aqva)getActivity().app.getManager(47)).a(1).a(localaquz, new afbk(this, str), new Bundle());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.aU = ((FormSwitchItem)this.mContentView.findViewById(2131366449));
    this.aV = ((FormSwitchItem)this.mContentView.findViewById(2131363137));
    this.mListView = ((ListView)this.mContentView.findViewById(2131378136));
    this.aU.setChecked(afbx.a().isEnable());
    this.aU.setOnCheckedChangeListener(new afbf(this));
    this.aV.setOnCheckedChangeListener(new afbg(this));
    setRightButton(2131721053, new afbh(this));
    this.mList = afbx.a().cU();
    this.a = new a();
    this.mListView.setAdapter(this.a);
    cYl();
  }
  
  public int getContentLayoutId()
  {
    return 2131559807;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(acfp.m(2131704644));
    return localView;
  }
  
  public class a
    extends BaseAdapter
  {
    protected a() {}
    
    public afbe a(int paramInt)
    {
      return (afbe)DataReportSettingFragment.this.mList.get(paramInt);
    }
    
    public int getCount()
    {
      return DataReportSettingFragment.this.mList.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      DataReportSettingFragment.c localc;
      afbe localafbe;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(DataReportSettingFragment.this.getActivity()).inflate(2131559806, paramViewGroup, false);
        localc = new DataReportSettingFragment.c(DataReportSettingFragment.this);
        localc.aW = ((FormSwitchItem)paramView.findViewById(2131369529));
        localc.b = new DataReportSettingFragment.b(DataReportSettingFragment.this);
        localc.aW.setOnCheckedChangeListener(localc.b);
        localc.aW.setOnLongClickListener(localc.b);
        paramView.setTag(localc);
        localafbe = a(paramInt);
        localc.aW.setChecked(localafbe.isChecked);
        if (!(localafbe instanceof afbz)) {
          break label205;
        }
        localc.aW.setText(localafbe.name + " - " + ((afbz)localafbe).action);
      }
      for (;;)
      {
        localc.b.a = localafbe;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localc = (DataReportSettingFragment.c)paramView.getTag();
        break;
        label205:
        localc.aW.setText(localafbe.name);
      }
    }
  }
  
  public class b
    implements View.OnLongClickListener, CompoundButton.OnCheckedChangeListener
  {
    public afbe a;
    
    protected b() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (this.jdField_a_of_type_Afbe != null)
      {
        this.jdField_a_of_type_Afbe.isChecked = paramBoolean;
        afbx.a().cYr();
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
    }
    
    public boolean onLongClick(View paramView)
    {
      aqha.a(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment.getActivity(), 230, null, acfp.m(2131704650), new afbl(this), new afbm(this)).show();
      return true;
    }
  }
  
  public class c
  {
    FormSwitchItem aW;
    DataReportSettingFragment.b b;
    
    protected c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */