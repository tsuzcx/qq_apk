package dov.com.qq.im.ae.album.logic;

import awur;
import awur.a;
import awvc;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$5
  implements Runnable
{
  public AEPhotoListLogicBase$5(awvc paramawvc) {}
  
  public void run()
  {
    ((awur)this.this$0.bu.get()).a.notifyDataSetChanged();
    this.this$0.updateButton();
    QQToast.a(((awur)this.this$0.bu.get()).getActivity(), "暂无媒体文件", 1000).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.5
 * JD-Core Version:    0.7.0.1
 */