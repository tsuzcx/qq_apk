import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class azao
{
  private static String TAG;
  private static azao jdField_a_of_type_Azao = new azao();
  private azao.a jdField_a_of_type_Azao$a;
  
  private azao()
  {
    TAG = getClass().getSimpleName();
  }
  
  public static azao a()
  {
    return jdField_a_of_type_Azao;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Azao$a != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Azao$a.j(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Azao$a.l(paramInt, paramString, paramBoolean2);
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, acfp.m(2131705948) + 2001 + "）", true);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void j(int paramInt, String paramString, boolean paramBoolean);
    
    public abstract void l(int paramInt, String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azao
 * JD-Core Version:    0.7.0.1
 */