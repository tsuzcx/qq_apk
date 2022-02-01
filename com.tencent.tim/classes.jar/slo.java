import com.tencent.qphone.base.util.QLog;

class slo
  extends sli.f
{
  slo(sli paramsli, sli.a parama, String paramString)
  {
    super(paramsli);
  }
  
  public void aB(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "mixAudio end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "mixAudioTime: " + (System.currentTimeMillis() - this.this$0.gx));
      this.this$0.gx = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.a.e(this.val$videoPath, false, "mixAudio done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slo
 * JD-Core Version:    0.7.0.1
 */