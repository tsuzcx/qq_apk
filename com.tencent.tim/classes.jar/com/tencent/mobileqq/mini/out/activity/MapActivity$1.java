package com.tencent.mobileqq.mini.out.activity;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

class MapActivity$1
  implements AdapterView.c
{
  MapActivity$1(MapActivity paramMapActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MapActivity", 2, "setOnItemClickListener" + paramInt);
    }
    if (this.this$0.poiAdapter.getItem(paramInt) != null) {
      this.this$0.poiAdapter.select(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.MapActivity.1
 * JD-Core Version:    0.7.0.1
 */