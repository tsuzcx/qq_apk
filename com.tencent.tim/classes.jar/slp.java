import com.tencent.qphone.base.util.QLog;

class slp
  extends sli.f
{
  slp(sli paramsli, sli.a parama, String paramString1, String paramString2)
  {
    super(paramsli);
  }
  
  public void aB(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineUnit end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "combineAudioAndVideoTime: " + (System.currentTimeMillis() - this.this$0.gx));
      this.this$0.gx = System.currentTimeMillis();
    }
    if (paramBoolean)
    {
      this.a.e(this.aEB, true, "cmobine auido video done.");
      return;
    }
    this.a.e(this.val$videoPath, false, "cmobine auido video done.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slp
 * JD-Core Version:    0.7.0.1
 */