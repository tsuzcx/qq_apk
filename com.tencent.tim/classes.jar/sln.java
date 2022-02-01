import com.tencent.qphone.base.util.QLog;

class sln
  extends sli.f
{
  sln(sli paramsli, sli.a parama, String paramString)
  {
    super(paramsli);
  }
  
  public void aB(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "splitVideoUnit end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "splitVideoTime: " + (System.currentTimeMillis() - this.this$0.gx));
      this.this$0.gx = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.a.e(this.val$videoPath, false, "splitVideo done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sln
 * JD-Core Version:    0.7.0.1
 */