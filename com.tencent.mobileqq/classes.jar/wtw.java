class wtw
  implements wth
{
  private long jdField_a_of_type_Long;
  
  wtw(wtu paramwtu) {}
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      yqu.b("msgtab", "preload_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtw
 * JD-Core Version:    0.7.0.1
 */