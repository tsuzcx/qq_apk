import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout.a;
import com.tencent.qphone.base.util.BaseApplication;

class wxb
  implements EmotionKeywordLayout.a
{
  wxb(wxa paramwxa) {}
  
  public void onVisibilityChanged(int paramInt)
  {
    if (paramInt == 8) {
      wxa.a(this.this$0).aMX();
    }
    while ((paramInt != 0) || (wxa.a(this.this$0) == 0L)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = wxa.a(this.this$0);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "StickerRecShowCost", true, l1 - l2, 0L, null, "");
    wxa.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxb
 * JD-Core Version:    0.7.0.1
 */