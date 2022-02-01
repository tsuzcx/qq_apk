import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.a;

public class ausd
  implements Handler.Callback
{
  public ausd(ARMapHongBaoListView paramARMapHongBaoListView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int j;
    int k;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      this.b.setIsShowingPreguide(true);
      boolean bool1 = paramMessage.getData().getBoolean("isFirstCall", false);
      boolean bool2 = paramMessage.getData().getBoolean("isListViewSpring", false);
      boolean bool3 = paramMessage.getData().getBoolean("isPendantBounce", false);
      j = paramMessage.getData().getInt("pendantBountCnt", 0);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapHongBaoListView", 2, "ARMapHongBaoListView handleMessage MSG_WHAT_GUIDE_SHOW, " + bool1 + "," + bool2 + "," + bool3 + "," + j);
      }
      if ((bool1) && (bool2))
      {
        this.b.jdField_b_of_type_Adue.Lx(-this.b.etx);
        if ((ARMapHongBaoListView.a(this.b) != null) && (this.b.djM)) {
          ARMapHongBaoListView.a(this.b).Nx(false);
        }
      }
      if ((bool3) && (j > 0))
      {
        float f = j * 1.0F / 6.0F;
        if (this.b.jdField_b_of_type_Adud != null) {
          this.b.jdField_b_of_type_Adud.ad((int)(f * this.b.etx), j * 300L);
        }
        k = j - 1;
        i = k;
        if (k > 0)
        {
          paramMessage = Message.obtain(ARMapHongBaoListView.a(this.b), 1);
          paramMessage.getData().putBoolean("isFirstCall", false);
          paramMessage.getData().putBoolean("isListViewSpring", false);
          paramMessage.getData().putBoolean("isPendantBounce", bool3);
          paramMessage.getData().putInt("pendantBountCnt", k);
          ARMapHongBaoListView.a(this.b).sendMessageDelayed(paramMessage, j * 300L + 200L);
        }
      }
      break;
    }
    for (int i = k;; i = j)
    {
      if (i == 0)
      {
        paramMessage = Message.obtain(ARMapHongBaoListView.a(this.b), 2);
        ARMapHongBaoListView.a(this.b).sendMessageDelayed(paramMessage, 1200L);
      }
      this.b.invalidate();
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ARMapHongBaoListView", 2, "ARMapHongBaoListView handleMessage MSG_WHAT_GUIDE_HIDE");
      }
      if (ARMapHongBaoListView.a(this.b) != null) {
        ARMapHongBaoListView.a(this.b).GJ(false);
      }
      ARMapHongBaoListView.a(this.b, paramMessage.what);
      ARMapHongBaoListView.a(this.b).sendEmptyMessageDelayed(5, 300L);
      return false;
      this.b.setIsShowingPreguide(true);
      i = this.b.etx;
      if (paramMessage.arg1 != 0) {
        i = paramMessage.arg1;
      }
      this.b.jdField_b_of_type_Adue.Lx(-i);
      if (this.b.jdField_b_of_type_Adud != null) {
        this.b.jdField_b_of_type_Adud.ad(this.b.etx / 3, 300L);
      }
      Message localMessage = Message.obtain(ARMapHongBaoListView.a(this.b), 4);
      localMessage.obj = paramMessage.obj;
      ARMapHongBaoListView.a(this.b).sendMessageDelayed(localMessage, 2000L);
      if ((ARMapHongBaoListView.a(this.b) == null) || (!this.b.djM)) {
        break;
      }
      ARMapHongBaoListView.a(this.b).Nx(false);
      return false;
      if (((Bundle)paramMessage.obj).getBoolean("isSpringBack")) {
        ARMapHongBaoListView.a(this.b, paramMessage.what);
      }
      ARMapHongBaoListView.a(this.b).sendEmptyMessageDelayed(5, 300L);
      if (ARMapHongBaoListView.a(this.b) == null) {
        break;
      }
      ARMapHongBaoListView.a(this.b).GJ(false);
      return false;
      this.b.setIsShowingPreguide(false);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausd
 * JD-Core Version:    0.7.0.1
 */