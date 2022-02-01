import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.view.widget.LeftTabBarView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class qfa
  extends ReportDialog
  implements View.OnClickListener
{
  MyVideoVisiblePersonPageView jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView;
  MyVideoVisibleTroopPageView jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView;
  LeftTabBarView jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView;
  boolean aDc;
  TroopManager b;
  QQAppInterface mAppInterface;
  int mBanType;
  Context mContext;
  String mVid;
  ptz mVideoSpreadGroupList;
  ViewPager mViewPager;
  
  public qfa(@NonNull Context paramContext, String paramString, int paramInt, ptz paramptz, boolean paramBoolean)
  {
    super(paramContext, 16973841);
    super.requestWindowFeature(1);
    super.setContentView(LayoutInflater.from(paramContext).inflate(2131562037, null));
    this.mContext = paramContext;
    this.mAppInterface = qem.getQQAppInterface();
    this.mVid = paramString;
    this.mBanType = paramInt;
    this.mVideoSpreadGroupList = paramptz;
    this.b = ((TroopManager)qem.getQQAppInterface().getManager(52));
    this.aDc = paramBoolean;
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView.onDestroy();
    }
  }
  
  void initView()
  {
    ((ElasticImageView)findViewById(2131364694)).setOnClickListener(this);
    this.mViewPager = ((ViewPager)findViewById(2131381929));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView = ((LeftTabBarView)findViewById(2131379135));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setUnselectColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setSelectColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setBackgroundDrawable(null);
    ArrayList localArrayList1 = new ArrayList();
    int i;
    if ((this.mVideoSpreadGroupList != null) && (this.aDc))
    {
      if ((this.mVideoSpreadGroupList.mA != null) && (!this.mVideoSpreadGroupList.mA.isEmpty()))
      {
        ArrayList localArrayList2 = new ArrayList(this.mVideoSpreadGroupList.mA.size());
        Iterator localIterator = this.mVideoSpreadGroupList.mA.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          localObject = this.b.b((String)localObject);
          if (localObject != null) {
            localArrayList2.add(localObject);
          }
        }
        Collections.sort(localArrayList2, acdb.K);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView = new MyVideoVisibleTroopPageView(this, this.mContext, localArrayList2, this.b);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView = new MyVideoVisiblePersonPageView(this, this.mContext, this.mVid, this.mBanType);
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView.mK());
        localArrayList1.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView.mK());
        localArrayList1.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setSelectedTab(0, false);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setOnTabChangeListener(new qfb(this));
      this.mViewPager.setAdapter(new qfa.a(localArrayList1));
      this.mViewPager.setOnPageChangeListener(new qfc(this));
      if (this.mBanType != 2) {
        break label438;
      }
      i = 1;
    }
    for (;;)
    {
      rar.a("pub_control", "exp_list", 0, 0, new String[] { String.valueOf(i), "", "", this.mVid });
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView = new MyVideoVisiblePersonPageView(this, this.mContext, this.mVid, this.mBanType);
      break;
      label438:
      if (this.mBanType == 3) {
        i = 2;
      } else if (this.mBanType == 1) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.getWindow();
    paramBundle.setGravity(80);
    paramBundle.setWindowAnimations(2131755359);
    initView();
  }
  
  class a
    extends PagerAdapter
  {
    private List<View> viewList;
    
    public a()
    {
      Object localObject;
      this.viewList = localObject;
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)this.viewList.get(paramInt));
    }
    
    public int getCount()
    {
      return this.viewList.size();
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup.addView((View)this.viewList.get(paramInt));
      return this.viewList.get(paramInt);
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfa
 * JD-Core Version:    0.7.0.1
 */