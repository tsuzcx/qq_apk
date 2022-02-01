package com.tencent.mobileqq.microapp.out.activity;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

final class e
  implements AbsListView.e
{
  e(MapActivity paramMapActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MapActivity", 4, "onScrollStateChanged");
    }
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)) {
      MapActivity.a(this.a, MapActivity.a(this.a), MapActivity.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.e
 * JD-Core Version:    0.7.0.1
 */