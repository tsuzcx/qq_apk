package com.tencent.mobileqq.mini.out.activity;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class MapActivity$5
  implements AbsListView.e
{
  MapActivity$5(MapActivity paramMapActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MapActivity", 4, "onScrollStateChanged");
    }
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)) {
      MapActivity.access$200(this.this$0, MapActivity.access$000(this.this$0), MapActivity.access$100(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.MapActivity.5
 * JD-Core Version:    0.7.0.1
 */