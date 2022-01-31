import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tribe.async.async.JobSegment;

class zsl
  extends armu<JobSegment>
{
  zsl(zsk paramzsk, JobSegment paramJobSegment)
  {
    super(paramJobSegment);
  }
  
  public void a(JobSegment paramJobSegment, boolean paramBoolean, armr paramarmr)
  {
    if (paramBoolean)
    {
      zsk.a(this.a, paramarmr);
      return;
    }
    zsk.a(this.a, new AppInfoError(5, "appInfo error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zsl
 * JD-Core Version:    0.7.0.1
 */