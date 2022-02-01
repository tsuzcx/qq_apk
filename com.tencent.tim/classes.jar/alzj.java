public class alzj
  extends alza
{
  public android.opengl.EGLContext a;
  public javax.microedition.khronos.egl.EGLContext a;
  public int decodeType = 0;
  
  public alzj(alza paramalza)
  {
    super(paramalza.inputFilePath, paramalza.speedType, paramalza.repeat, paramalza.noSleep, paramalza.startTimeMillSecond, paramalza.endTimeMillSecond);
  }
  
  public alzj(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramString, paramInt, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
  }
  
  public boolean a(alza paramalza)
  {
    boolean bool = super.a(paramalza);
    if ((paramalza instanceof alzj))
    {
      paramalza = (alzj)paramalza;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != paramalza.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramalza.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        bool = true;
      }
      if (this.jdField_a_of_type_AndroidOpenglEGLContext != paramalza.jdField_a_of_type_AndroidOpenglEGLContext)
      {
        this.jdField_a_of_type_AndroidOpenglEGLContext = paramalza.jdField_a_of_type_AndroidOpenglEGLContext;
        bool = true;
      }
      if (this.decodeType != paramalza.decodeType)
      {
        this.decodeType = paramalza.decodeType;
        return true;
      }
    }
    else
    {
      throw new IllegalArgumentException("should be FlowDecodeConfig's instance");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzj
 * JD-Core Version:    0.7.0.1
 */