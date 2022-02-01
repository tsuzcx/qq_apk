import android.support.annotation.Nullable;

class ydk
  extends ydt
{
  ydk(ydh paramydh, ydg paramydg)
  {
    super(paramydg);
  }
  
  protected void a(@Nullable ydg arg1)
  {
    super.onResult(???);
    xvv.b("DoodleEmojiManager", "startDownload again");
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_Ydg = null;
      this.a.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydk
 * JD-Core Version:    0.7.0.1
 */