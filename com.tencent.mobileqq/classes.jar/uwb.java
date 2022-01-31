class uwb
  implements uvm
{
  private long jdField_a_of_type_Long;
  
  uwb(uvz paramuvz) {}
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      wta.b("msgtab", "preload_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwb
 * JD-Core Version:    0.7.0.1
 */