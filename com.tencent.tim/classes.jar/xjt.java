import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.qphone.base.util.QLog;

class xjt
  implements aixk.a
{
  xjt(xjs paramxjs) {}
  
  public void e(MarketFaceItemBuilder.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "func downloadVideoDetails, 【callback】 try to download video details.");
    }
    MarketFaceItemBuilder.a(this.a.this$0, paramb);
  }
  
  public void zt(boolean paramBoolean)
  {
    if (paramBoolean) {
      MarketFaceItemBuilder.a(this.a.this$0, this.a.b, this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjt
 * JD-Core Version:    0.7.0.1
 */