import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class nzl
  implements AbsListView.e
{
  public nzl(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      txn.a().startMonitorScene("list_subscript");
    }
    for (;;)
    {
      return;
      txn.a().stopMonitorScene("list_subscript", false);
      paramInt = 0;
      while (paramInt <= paramAbsListView.getChildCount())
      {
        Object localObject = paramAbsListView.getChildAt(paramInt);
        if ((localObject != null) && ((((View)localObject).getTag() instanceof nzo.a)))
        {
          localObject = (nzo.a)((View)localObject).getTag();
          Drawable localDrawable = ((nzo.a)localObject).lk.getDrawable();
          if ((localDrawable != null) && ((localDrawable instanceof URLDrawable)) && (!((URLDrawable)localDrawable).isDownloadStarted()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SubscriptFeedsActivity", 2, "list child view start download pic!  uin : " + ((nzo.a)localObject).uin);
            }
            ((URLDrawable)localDrawable).startDownload();
            ((URLDrawable)localDrawable).setAutoDownload(true);
          }
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzl
 * JD-Core Version:    0.7.0.1
 */