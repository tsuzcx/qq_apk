import com.tencent.qphone.base.util.QLog;

class aqxk
  implements jox
{
  aqxk(aqxh paramaqxh, long paramLong1, String paramString1, long paramLong2, String paramString2) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipGiftManager", 2, "checkUpAndNotifyByBid loaded,code:" + paramInt + ",cost:" + (System.currentTimeMillis() - this.val$startTime));
    }
    if (this.val$bid.equalsIgnoreCase("280")) {
      this.c.VN("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
    }
    if ((paramInt == 0) || (8 == paramInt) || (5 == paramInt)) {
      if (this.c.E(2L, this.rJ)) {
        this.c.bs(this.val$bid, this.rJ);
      }
    }
    while ((!this.c.E(5L, this.rJ)) || (this.cyx == null)) {
      return;
    }
    this.c.bs(this.cyx, this.rJ);
  }
  
  public void progress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipGiftManager", 2, "checkUpAndNotifyByBid progress:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxk
 * JD-Core Version:    0.7.0.1
 */