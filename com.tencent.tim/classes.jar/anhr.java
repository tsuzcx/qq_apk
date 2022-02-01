import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class anhr
{
  private static String TAG;
  private static anhr jdField_a_of_type_Anhr = new anhr();
  private anhr.a jdField_a_of_type_Anhr$a;
  
  private anhr()
  {
    TAG = getClass().getSimpleName();
  }
  
  public static anhr a()
  {
    return jdField_a_of_type_Anhr;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Anhr$a != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_Anhr$a.j(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Anhr$a.l(paramInt, paramString, paramBoolean2);
  }
  
  public void a(anhr.a parama)
  {
    this.jdField_a_of_type_Anhr$a = parama;
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, acfp.m(2131705951) + 2001 + "）", true);
    return false;
  }
  
  public void recycle()
  {
    this.jdField_a_of_type_Anhr$a = null;
  }
  
  public static abstract interface a
  {
    public abstract void j(int paramInt, String paramString, boolean paramBoolean);
    
    public abstract void l(int paramInt, String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhr
 * JD-Core Version:    0.7.0.1
 */