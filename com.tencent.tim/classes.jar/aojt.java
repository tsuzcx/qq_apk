import com.tencent.qphone.base.util.QLog;

class aojt
  extends achq
{
  aojt(aojs paramaojs) {}
  
  protected void a(boolean paramBoolean, anbd.c paramc)
  {
    if ((paramc != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + paramc.key + " seq:" + paramc.aq + " Layer:" + paramc.layer + " RespCode:" + paramc.dEW);
    }
    if ((this.this$0.b != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.this$0.b.filePath + " isStreamPttSuccess:" + this.this$0.cMi);
    }
    this.this$0.VQ(2);
    if ((paramc == null) || (paramc.key == null) || (!paramc.key.equalsIgnoreCase(this.this$0.b.filePath))) {
      return;
    }
    if (!paramBoolean)
    {
      aojs.a(this.this$0, false, paramc);
      return;
    }
    aojs.a(this.this$0, true, paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojt
 * JD-Core Version:    0.7.0.1
 */