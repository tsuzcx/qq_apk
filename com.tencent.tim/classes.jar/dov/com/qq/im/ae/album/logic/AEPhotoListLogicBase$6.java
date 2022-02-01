package dov.com.qq.im.ae.album.logic;

import awur;
import awur.a;
import awva;
import awvc;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$6
  implements Runnable
{
  public AEPhotoListLogicBase$6(awvc paramawvc, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.dsL) {
      QQToast.a(((awur)this.this$0.bu.get()).getActivity(), "暂无媒体文件", 1000).show();
    }
    ((awur)this.this$0.bu.get()).jdField_a_of_type_Awur$a.notifyDataSetChanged();
    ((awur)this.this$0.bu.get()).jdField_a_of_type_Awva.updateButton();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.6
 * JD-Core Version:    0.7.0.1
 */