import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.a;
import com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.a;
import com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class afzz
  implements Face2FaceDetailBaseView.a
{
  public afzz(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public boolean a(agay paramagay, int paramInt)
  {
    if (!aqiw.isNetSupport(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.bFZ, 2, "joinTroop, NetworkUtil.isNetSupport==false");
      }
      QQToast.a(this.this$0.app.getApplication(), 2131696272, 0).show(this.this$0.getTitleBarHeight());
    }
    do
    {
      acia localacia;
      do
      {
        return false;
        localacia = (acia)this.this$0.app.getBusinessHandler(57);
      } while (localacia == null);
      this.this$0.O = new arhz(this.this$0);
      this.this$0.O.setMessage(acfp.m(2131706025));
      this.this$0.O.setCancelable(false);
      this.this$0.O.show();
      try
      {
        long l1 = Long.valueOf(paramagay.bGh).longValue();
        long l2 = Long.valueOf(paramagay.bGg).longValue();
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.bFZ, 2, "joinTroop, troopCode=" + l1 + ", ownerUin=" + l2 + ", distance=" + paramagay.distance);
        }
        localacia.d(l1, l2, paramagay.distance, paramInt);
        return true;
      }
      catch (Exception paramagay) {}
    } while (!QLog.isColorLevel());
    QLog.d(Face2FaceAddFriendActivity.bFZ, 2, "joinTroop:" + paramagay.toString());
    return false;
  }
  
  public void c(agay paramagay)
  {
    if (this.this$0.ae.size() == this.this$0.AG.size())
    {
      this.this$0.b(paramagay);
      return;
    }
    Face2FaceAddFriendActivity.a(this.this$0).obtainMessage().obj = paramagay;
    Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(12, 5000L);
  }
  
  public void deA() {}
  
  public void deB()
  {
    if (this.this$0.cVN == 1) {
      this.this$0.a(this.this$0.a.d);
    }
  }
  
  public void deC()
  {
    this.this$0.des();
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "afterDetailViewHide 详情页返回");
    }
    this.this$0.bGd = "";
    Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(13, this.this$0.DV());
  }
  
  public void dez()
  {
    this.this$0.det();
  }
  
  public QQAppInterface getApp()
  {
    return this.this$0.app;
  }
  
  public boolean mi(String paramString)
  {
    return this.this$0.mi(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzz
 * JD-Core Version:    0.7.0.1
 */