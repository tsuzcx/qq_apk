import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;

class aqei
  extends acpq
{
  aqei(aqeh paramaqeh) {}
  
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onUpdateStrangerHead.faceInfo=" + paramFaceInfo + ", isSuccess=" + paramBoolean);
    }
    if ((this.a.mCancelled) || (this.a.c == null) || (paramFaceInfo == null)) {}
    while ((paramFaceInfo.idType != this.a.c.idType) || (!this.a.c.uin.equals(paramFaceInfo.uin))) {
      return;
    }
    if ((this.a.a != null) && (this.a.d != null)) {
      this.a.d.removeObserver(this.a.a);
    }
    if (paramBoolean)
    {
      paramFaceInfo = this.a.aG();
      if (paramFaceInfo != null)
      {
        this.a.a(this.a.c, paramFaceInfo);
        return;
      }
      this.a.aBV();
      return;
    }
    this.a.a(this.a.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqei
 * JD-Core Version:    0.7.0.1
 */