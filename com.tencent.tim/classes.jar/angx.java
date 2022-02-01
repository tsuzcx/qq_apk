import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class angx
  implements angw.b
{
  angx(angw.a parama) {}
  
  public void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat)
  {
    if (angw.a.a(this.this$0) != null) {
      angw.a.a(this.this$0).a(this.this$0.p, paramFloat);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    QLog.d("VideoCompressProcessor", 1, "hardware compress finish code: " + paramInt);
    if (angw.a.a(this.this$0) != null)
    {
      angw.a.a(this.this$0).a(this.this$0.p, 1.0F);
      angw.a.a(this.this$0).a(this.this$0.p, 3);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angx
 * JD-Core Version:    0.7.0.1
 */