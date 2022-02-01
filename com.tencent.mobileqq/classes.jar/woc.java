class woc
  implements wnn
{
  private long jdField_a_of_type_Long;
  
  woc(woa paramwoa) {}
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      ykv.b("msgtab", "preload_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     woc
 * JD-Core Version:    0.7.0.1
 */