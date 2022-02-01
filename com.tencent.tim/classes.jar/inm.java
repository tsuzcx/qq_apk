import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class inm
  extends iid
{
  public inm(GaInviteActivity paramGaInviteActivity) {}
  
  protected void b(long paramLong, ArrayList<VideoController.b> paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (String.valueOf(((VideoController.b)paramArrayList.next()).uin).equalsIgnoreCase(this.a.mApp.getAccount())) {
        this.a.finish();
      }
    }
  }
  
  protected void bJ(long paramLong)
  {
    if (this.a.mGroupId != paramLong) {
      this.a.cm(-1035L);
    }
    this.a.finish();
  }
  
  protected void bK(long paramLong)
  {
    if (this.a.mGroupId == paramLong) {
      this.a.finish();
    }
  }
  
  protected void d(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.TAG + ".troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.a.mf + ", mGroupId:" + this.a.mGroupId);
    }
    if ((paramLong2 == this.a.mf) && (paramLong1 == this.a.mGroupId)) {
      this.a.finish();
    }
  }
  
  protected void l(long paramLong, String paramString)
  {
    if ((this.a.mGroupId == paramLong) && (this.a.OG.equals(paramString))) {
      this.a.finish();
    }
  }
  
  protected void n(long paramLong, int paramInt)
  {
    if ((this.a.mGroupId == paramLong) || (0L == paramLong)) {
      this.a.aox();
    }
  }
  
  protected void onServiceConnected()
  {
    super.onServiceConnected();
    if (this.a.Tg) {
      this.a.jn("onServiceConnected");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     inm
 * JD-Core Version:    0.7.0.1
 */