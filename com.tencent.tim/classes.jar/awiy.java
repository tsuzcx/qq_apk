public class awiy
{
  private static awiy jdField_a_of_type_Awiy = new awiy();
  private awiy.a jdField_a_of_type_Awiy$a;
  awiy.b jdField_a_of_type_Awiy$b;
  
  public static awiy a()
  {
    return jdField_a_of_type_Awiy;
  }
  
  public void a(awiy.a parama)
  {
    this.jdField_a_of_type_Awiy$a = parama;
  }
  
  public void a(awiy.b paramb)
  {
    this.jdField_a_of_type_Awiy$b = paramb;
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (this.jdField_a_of_type_Awiy$a == null) {
      return;
    }
    this.jdField_a_of_type_Awiy$a.a(paramString, paramLong1, paramArrayOfLong, paramLong2);
  }
  
  public void bC(String paramString1, String paramString2)
  {
    awiy.b localb = this.jdField_a_of_type_Awiy$b;
    if ((localb != null) && (!"0X8009831".equals(paramString1)) && (!"0X8009830".equals(paramString1)) && (!"0X800982E".equals(paramString1)) && (!"0X800982F".equals(paramString1))) {
      localb.report(paramString2);
    }
  }
  
  public void eDQ()
  {
    this.jdField_a_of_type_Awiy$a = null;
  }
  
  public static class a
  {
    protected void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2) {}
  }
  
  public static class b
  {
    protected void report(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     awiy
 * JD-Core Version:    0.7.0.1
 */