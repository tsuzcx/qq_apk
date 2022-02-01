package com.tencent.biz.qqcircle.fragments;

import acfp;
import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import ovd;
import ovg;
import pak;
import pec;
import pel;
import rxj;
import rxt;

public class QCirclePersonalDynamicFragment
  extends QCirclePersonalBaseBottomFragment
{
  private void h(pel<List<FeedCloudMeta.StFeed>> parampel)
  {
    if (parampel == null)
    {
      QLog.e(TAG, 1, "handleFeedDataRsp return unexpected data！");
      return;
    }
    boolean bool = parampel.HU();
    int i;
    switch (parampel.getState())
    {
    default: 
      i = 0;
    }
    while ((i != 0) && (this.jdField_a_of_type_Ovg != null))
    {
      this.jdField_a_of_type_Ovg.notifyLoadingComplete(true, bool);
      return;
      QLog.e(TAG, 1, "handleFeedDataRsp() return empty data");
      if ((parampel.HV()) && (this.jdField_a_of_type_Ovg != null) && (this.jdField_a_of_type_Ovg.getItemCount() > 0))
      {
        this.jdField_a_of_type_Ovg.getLoadInfo().setFinish(bool);
        i = 1;
      }
      else
      {
        QLog.i("jiaojiexu", 1, "handleFeedDataRsp");
        if ((this.jdField_a_of_type_Rxj != null) && (this.jdField_a_of_type_Ovg != null))
        {
          if (!this.jdField_a_of_type_Ovg.HC())
          {
            if (ovd.eL(this.mUin)) {}
            for (parampel = getString(2131700094);; parampel = getString(2131700096))
            {
              ((QCircleStatusView)this.jdField_a_of_type_Rxj.a().a()).showEmptyView(parampel);
              this.jdField_a_of_type_Ovg.clearData();
              this.jdField_a_of_type_Ovg.notifyDataSetChanged();
              QLog.i(TAG, 1, "handleFeedDataRsp  StatusView = visible");
              i = 1;
              break;
            }
          }
          this.jdField_a_of_type_Rxj.a().a().setVisibility(8);
          QLog.i(TAG, 1, "handleFeedDataRsp  StatusView = gone");
          i = 1;
          continue;
          if (parampel.getMsg() == null) {}
          for (parampel = acfp.m(2131720624);; parampel = parampel.getMsg())
          {
            QLog.e(TAG, 1, "handleFeedDataRsp() return error！errMsg:" + parampel);
            QQToast.a(BaseApplicationImpl.getContext(), 1, parampel, 1).show();
            if ((this.jdField_a_of_type_Ovg == null) || (this.jdField_a_of_type_Rxj == null)) {
              break label498;
            }
            if (this.jdField_a_of_type_Ovg.getItemCount() > 0) {
              break label367;
            }
            ((QCircleStatusView)this.jdField_a_of_type_Rxj.a().a()).showErrorView(parampel);
            i = 1;
            break;
          }
          label367:
          this.jdField_a_of_type_Rxj.a().a().setVisibility(8);
          i = 1;
          continue;
          i = 0;
          continue;
          ArrayList localArrayList = (ArrayList)parampel.getData();
          if (this.jdField_a_of_type_Ovg != null)
          {
            if (parampel.HV()) {
              this.jdField_a_of_type_Ovg.addAll(localArrayList);
            }
            for (;;)
            {
              if (this.jdField_a_of_type_Rxj != null)
              {
                ((QCircleStatusView)this.jdField_a_of_type_Rxj.a().a()).setVisibility(8);
                this.jdField_a_of_type_Rxj.a().a().setVisibility(0);
              }
              this.jdField_a_of_type_Ovg.getLoadInfo().setFinish(bool);
              i = 1;
              break;
              this.jdField_a_of_type_Ovg.setDatas(localArrayList);
              this.jdField_a_of_type_Ovg.bhS();
            }
          }
        }
        label498:
        i = 1;
      }
    }
  }
  
  public boolean HI()
  {
    return ovd.eL(this.mUin);
  }
  
  protected void initChildView()
  {
    if (this.jdField_a_of_type_Ovg != null)
    {
      localObject = new ExtraTypeInfo();
      ((ExtraTypeInfo)localObject).pageType = 8;
      this.jdField_a_of_type_Ovg.setExtraTypeInfo((ExtraTypeInfo)localObject);
    }
    if (a() != null)
    {
      this.jdField_a_of_type_Pec = ((pec)a(a(), null, pec.class));
      this.jdField_a_of_type_Pec.l().observe(a(), new pak(this));
    }
    if (ovd.eL(this.mUin)) {}
    for (Object localObject = getString(2131700094);; localObject = getString(2131700096))
    {
      ((QCircleStatusView)this.jdField_a_of_type_Rxj.a().a()).showEmptyView((String)localObject);
      ((QCircleStatusView)this.jdField_a_of_type_Rxj.a().a()).setVisibility(8);
      this.jdField_a_of_type_Rxj.a().a().setNestedScrollingEnabled(true);
      return;
    }
  }
  
  protected void loadMore()
  {
    if (this.jdField_a_of_type_Pec != null) {
      this.jdField_a_of_type_Pec.qE(this.mUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalDynamicFragment
 * JD-Core Version:    0.7.0.1
 */