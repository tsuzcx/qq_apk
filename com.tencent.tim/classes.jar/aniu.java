import com.tencent.maxvideo.mediadevice.AVCodec;

public class aniu
{
  public static String TAG;
  public static aniu a;
  private anhp a;
  
  static
  {
    jdField_a_of_type_Aniu = new aniu();
  }
  
  private aniu()
  {
    TAG = getClass().getSimpleName();
  }
  
  public static aniu a()
  {
    return jdField_a_of_type_Aniu;
  }
  
  public anhp a()
  {
    if (this.jdField_a_of_type_Anhp == null) {
      this.jdField_a_of_type_Anhp = new anhp(40, aniq.dGY);
    }
    return this.jdField_a_of_type_Anhp;
  }
  
  public AVCodec a()
  {
    return AVCodec.get();
  }
  
  public anhr b()
  {
    return anhr.a();
  }
  
  public void destory()
  {
    this.jdField_a_of_type_Anhp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aniu
 * JD-Core Version:    0.7.0.1
 */