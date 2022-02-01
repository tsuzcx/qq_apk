import com.tencent.mobileqq.activity.tim.timme.TimLeba;
import com.tencent.qphone.base.util.QLog;

public class abcl
  extends akln
{
  public abcl(TimLeba paramTimLeba) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.UndealCount.QZoneObserver", 2, "on Get QZone Count:" + paramBoolean1 + ",HasNew:" + paramBoolean2);
    }
    if (QLog.isColorLevel())
    {
      if ((paramLong >>> 17 & 1L) != 0L) {
        QLog.d("UndealCount.ZebraAlbum.", 2, "Leba onGetQZoneFeedCountFin Zebra album and then call Leba freshEntryItemUI");
      }
      QLog.d("UndealCount.", 2, "Leba onGetQZoneFeedCountFin type: " + paramLong + " and then call Leba freshEntryItemUI");
    }
    if (paramBoolean1) {
      this.this$0.cBa();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcl
 * JD-Core Version:    0.7.0.1
 */