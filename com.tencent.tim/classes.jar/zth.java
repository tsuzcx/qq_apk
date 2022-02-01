import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class zth
  extends acnd
{
  zth(ztd paramztd) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (this.this$0.a == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!aqft.equalsWithNullCheck(paramString1, this.this$0.mTroopUin)));
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("onGetTroopAvatar result=%d", new Object[] { Integer.valueOf(paramInt1) }));
      }
    } while (paramInt1 != 0);
    this.this$0.BU(true);
  }
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (!aqft.equalsWithNullCheck(paramString1, this.this$0.mTroopUin)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onCmdTroopAvatar result=%d", new Object[] { Integer.valueOf(paramInt1) }));
    }
    this.this$0.BU(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zth
 * JD-Core Version:    0.7.0.1
 */