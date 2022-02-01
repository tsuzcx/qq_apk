import android.view.View;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GestureSelectGridView;

class xtu
  implements AdapterView.c
{
  xtu(xtp paramxtp) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    Object localObject1 = this.this$0.c.j(paramInt);
    if (!xuf.class.isInstance(localObject1)) {}
    label646:
    for (;;)
    {
      return;
      localObject1 = (xuf)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + xtp.a(this.this$0).getFirstVisiblePosition() + " LastVisiblePosition " + xtp.b(this.this$0).getLastVisiblePosition());
      }
      Object localObject2;
      int i;
      if (xtp.a(this.this$0))
      {
        localObject2 = ((xuf)localObject1).e;
        if (AIOFilePicData.class.isInstance(localObject2))
        {
          if ((((AIOFilePicData)localObject2).c(20) == null) && (((AIOFilePicData)localObject2).c(18) == null) && (((AIOFilePicData)localObject2).c(16) == null))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("AIOImageListScene", 2, "AIOFilePicData has null path,onItemClick: " + paramInt);
          }
        }
        else if (AIOLightVideoData.class.isInstance(((xuf)localObject1).e))
        {
          QQToast.a(xtp.l(this.this$0), acfp.m(2131702249), 0).show();
          return;
        }
        i = this.this$0.ww();
        if (i == 1)
        {
          if (AIOShortVideoData.class.isInstance(localObject2)) {
            QQToast.a(xtp.m(this.this$0), acfp.m(2131702256), 0).show();
          }
        }
        else if (i == 2)
        {
          if (AIOImageData.class.isInstance(localObject2)) {
            QQToast.a(xtp.n(this.this$0), acfp.m(2131702254), 0).show();
          }
        }
        else {
          if ((i == 0) && (!AIOImageData.class.isInstance(localObject2))) {
            break label481;
          }
        }
        if (((xuf)localObject1).uG() == 1)
        {
          i = 1;
          label343:
          localObject2 = this.this$0;
          if (i != 0) {
            break label510;
          }
          label354:
          ((xtp)localObject2).a((xuf)localObject1, bool, false);
          if (!this.this$0.a(paramView, (sxy)localObject1)) {
            ((AbstractImageAdapter)paramAdapterView.getAdapter()).notifyDataSetChanged();
          }
          this.this$0.ceQ();
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label646;
        }
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + xtp.e(this.this$0).getFirstVisiblePosition() + " LastVisiblePosition " + xtp.f(this.this$0).getLastVisiblePosition() + " SelectedIndex = " + this.this$0.c.getSelectedIndex());
        return;
        label481:
        if ((AIOFilePicData.class.isInstance(localObject2)) || (!AIOShortVideoData.class.isInstance(localObject2))) {
          break;
        }
        break;
        i = 0;
        break label343;
        label510:
        bool = false;
        break label354;
        if (AIOLightVideoData.class.isInstance(((xuf)localObject1).e))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageListScene", 2, "lightvideo could not be opened");
          }
          QQToast.a(xtp.o(this.this$0), acfp.m(2131702259), 0).show();
          return;
        }
        if (AIOShortVideoData.class.isInstance(((xuf)localObject1).e)) {}
        this.this$0.c.Dx(paramInt);
        this.this$0.c.Du(xtp.c(this.this$0).getFirstVisiblePosition());
        this.this$0.c.Dv(xtp.d(this.this$0).getLastVisiblePosition());
        this.this$0.bBV();
        this.this$0.reportData("Multi_Pic_big", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtu
 * JD-Core Version:    0.7.0.1
 */