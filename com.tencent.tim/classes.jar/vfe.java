import com.tencent.mobileqq.activity.Leba;
import com.tencent.qphone.base.util.QLog;

public class vfe
  extends akln
{
  public vfe(Leba paramLeba) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.leba", 2, "on Get QZone Count:" + paramBoolean1 + ",HasNew:" + paramBoolean2);
    }
    if (QLog.isColorLevel())
    {
      if ((paramLong >>> 17 & 1L) != 0L) {
        QLog.d("UndealCount.ZebraAlbum.", 2, "Leba onGetQZoneFeedCountFin Zebra album and then call Leba freshEntryItemUI");
      }
      QLog.d("UndealCount.", 2, "Leba onGetQZoneFeedCountFin type: " + paramLong + " and then call Leba freshEntryItemUI");
    }
    if (paramBoolean1)
    {
      Leba.c(this.this$0);
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "onGetQZoneFeedCountFin. notifyData.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfe
 * JD-Core Version:    0.7.0.1
 */