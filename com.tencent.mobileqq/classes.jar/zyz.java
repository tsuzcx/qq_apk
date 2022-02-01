import android.text.TextUtils;

public class zyz
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private zzy jdField_a_of_type_Zzy;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  private zyz(zzb paramzzb)
  {
    if (!TextUtils.isEmpty(zzb.a(paramzzb))) {
      this.jdField_a_of_type_JavaLangString = zzb.a(paramzzb);
    }
    this.jdField_a_of_type_Boolean = zzb.a(paramzzb);
    long l;
    int i;
    if (zzb.a(paramzzb) > 0L)
    {
      l = zzb.a(paramzzb);
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = zzb.a(paramzzb);
      if (zzb.b(paramzzb) <= 0) {
        break label107;
      }
      i = zzb.b(paramzzb);
      label69:
      this.jdField_b_of_type_Int = i;
      this.jdField_b_of_type_Boolean = zzb.b(paramzzb);
      if (zzb.a(paramzzb) == null) {
        break label113;
      }
    }
    label107:
    label113:
    for (paramzzb = zzb.a(paramzzb);; paramzzb = new zzw())
    {
      this.jdField_a_of_type_Zzy = paramzzb;
      return;
      l = 1000L;
      break;
      i = 50;
      break label69;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public zzy a()
  {
    return this.jdField_a_of_type_Zzy;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyz
 * JD-Core Version:    0.7.0.1
 */