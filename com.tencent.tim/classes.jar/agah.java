import android.os.Message;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class agah
  extends acgs
{
  public agah(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  protected void a(agbc paramagbc, boolean paramBoolean, int paramInt)
  {
    super.a(paramagbc, paramBoolean, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetFaceToFaceNearbyUserPush, pushTime=" + paramInt + "from_type=" + this.this$0.cVN);
    }
    if (paramagbc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetFaceToFaceNearbyUserPush, nearbyUser=null!!");
      }
      if ((this.this$0.cVN == 0) && (paramagbc != null) && (!this.this$0.a(paramagbc, this.this$0.AD)))
      {
        this.this$0.AD.add(paramagbc);
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetFaceToFaceNearbyUserPush, mhasShowList=" + this.this$0.ae.size() + "mNeedShowList.size()" + this.this$0.AG.size());
        }
        if (this.this$0.ae.size() != this.this$0.AG.size()) {
          break label267;
        }
        Face2FaceAddFriendActivity.a(this.this$0, paramagbc);
      }
    }
    for (;;)
    {
      paramagbc = this.this$0;
      paramagbc.cVV += 1;
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetFaceToFaceNearbyUserPush, nearbyUser=" + paramagbc.bGh);
      break;
      label267:
      Message localMessage = Face2FaceAddFriendActivity.a(this.this$0).obtainMessage();
      localMessage.what = 10;
      localMessage.obj = paramagbc;
      Face2FaceAddFriendActivity.a(this.this$0).sendEmptyMessageDelayed(10, this.this$0.DV());
    }
  }
  
  protected void a(boolean paramBoolean, List<agbc> paramList, int paramInt1, int paramInt2)
  {
    super.a(paramBoolean, paramList, paramInt1, paramInt2);
    if (paramBoolean)
    {
      this.this$0.cVQ = 1;
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetFaceToFaceNearbyUserList heartBeatTime=" + paramInt2 + "from_type=" + this.this$0.cVN + "reqInterval=" + paramInt1 + "好友列表返回isSuccess=" + paramBoolean);
      }
      if (paramList == null) {
        break label241;
      }
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetFaceToFaceNearbyUserList size=" + paramList.size());
      }
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 2;
      }
      long l = System.currentTimeMillis() - agas.Yc;
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetFaceToFaceNearbyUserList interval=" + l + "leaveFaceTofaceTime=" + agas.Yc);
      }
      if ((l > i * 1000) || (agas.Yc == 0L)) {
        break label259;
      }
      Face2FaceAddFriendActivity.a(this.this$0, i * 1000 - l);
      return;
      this.this$0.cVQ = 2;
      break;
      label241:
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.TAG, 2, "onGetFaceToFaceNearbyUserList is null");
      }
    }
    label259:
    if (paramInt2 > 0) {
      Face2FaceAddFriendActivity.cVT = paramInt2 * 1000;
    }
    if (!this.this$0.ccb) {
      Face2FaceAddFriendActivity.c(this.this$0);
    }
    this.this$0.ccb = true;
    if ((this.this$0.cVN == 0) && (paramList != null) && (paramList.size() > 0)) {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      agba localagba;
      if (paramList.hasNext())
      {
        localagba = (agba)paramList.next();
        if (!this.this$0.AD.contains(localagba)) {}
      }
      else
      {
        Face2FaceAddFriendActivity.d(this.this$0);
        return;
      }
      this.this$0.AD.add(localagba);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agah
 * JD-Core Version:    0.7.0.1
 */