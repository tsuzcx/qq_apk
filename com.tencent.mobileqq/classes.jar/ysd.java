import android.support.annotation.Nullable;

class ysd
  extends ysm
{
  ysd(ysa paramysa, yrz paramyrz)
  {
    super(paramyrz);
  }
  
  protected void a(@Nullable yrz arg1)
  {
    super.onResult(???);
    ykq.b("DoodleEmojiManager", "startDownload again");
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_Yrz = null;
      this.a.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysd
 * JD-Core Version:    0.7.0.1
 */