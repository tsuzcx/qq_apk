package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.controller.BottleThrowController;
import com.tencent.qqmail.permission.RxPermissions;
import rx.Observable;

class BottleThrowFragment$2
  implements View.OnClickListener
{
  BottleThrowFragment$2(BottleThrowFragment paramBottleThrowFragment) {}
  
  public void onClick(View paramView)
  {
    if (BottleThrowFragment.access$100(this.this$0).isOpenedLBS())
    {
      BottleThrowFragment.access$200(this.this$0, null);
      BottleThrowFragment.access$100(this.this$0).setOpenedLBS(false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      RxPermissions.getInstance(this.this$0.getActivity()).request(new String[] { "android.permission.ACCESS_FINE_LOCATION" }).subscribe(new BottleThrowFragment.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleThrowFragment.2
 * JD-Core Version:    0.7.0.1
 */