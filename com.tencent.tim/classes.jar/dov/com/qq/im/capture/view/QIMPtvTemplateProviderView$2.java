package dov.com.qq.im.capture.view;

import android.widget.ListAdapter;
import axpa;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.HashMap;

class QIMPtvTemplateProviderView$2
  implements Runnable
{
  QIMPtvTemplateProviderView$2(QIMPtvTemplateProviderView paramQIMPtvTemplateProviderView, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    GridView localGridView = (GridView)this.this$0.a.mF.get(Integer.valueOf(this.this$0.b.getCurrentItem()));
    if (localGridView != null)
    {
      localListAdapter = localGridView.getAdapter();
      if ((localListAdapter instanceof axpa))
      {
        i = ((axpa)localListAdapter).a(this.d);
        ((axpa)localListAdapter).a(this.d, i);
        localGridView.requestFocusFromTouch();
        localGridView.setFocusableInTouchMode(true);
        localGridView.setSelection(i);
        localGridView.smoothScrollToPosition(i / localGridView.getNumColumns());
        ((axpa)localListAdapter).notifyDataSetChanged();
      }
    }
    while (!QLog.isColorLevel())
    {
      ListAdapter localListAdapter;
      int i;
      return;
    }
    QLog.d("PtvTemplateProviderView", 2, "gridView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMPtvTemplateProviderView.2
 * JD-Core Version:    0.7.0.1
 */