class yln
  implements ywk<Boolean, ywp>
{
  yln(yll paramyll, long paramLong, int paramInt) {}
  
  public Void a(Boolean paramBoolean, ywp paramywp)
  {
    if ((!paramBoolean.booleanValue()) || (paramywp == null) || (paramywp.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      ykq.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    ykq.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramywp.jdField_a_of_type_Int));
    if (paramywp.jdField_a_of_type_Int >= this.jdField_a_of_type_Yll.a.length)
    {
      ykq.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramywp.jdField_a_of_type_Int) });
      return null;
    }
    ykq.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramywp.jdField_a_of_type_Int));
    this.jdField_a_of_type_Yll.a[paramywp.jdField_a_of_type_Int] = ylo.a(this.jdField_a_of_type_Yll.a[paramywp.jdField_a_of_type_Int], paramywp.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Yll.a[paramywp.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = paramywp.jdField_a_of_type_JavaLangString;
    if (paramywp.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Yll.a[paramywp.jdField_a_of_type_Int].jdField_a_of_type_Int = ((int)paramywp.jdField_a_of_type_Long / 1000);
      ykq.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix start time : %d ", Integer.valueOf(this.jdField_a_of_type_Yll.a[paramywp.jdField_a_of_type_Int].jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_Yll.a[paramywp.jdField_a_of_type_Int].b <= 0) && (this.jdField_a_of_type_Yll.a.length == 1))
      {
        this.jdField_a_of_type_Yll.a[paramywp.jdField_a_of_type_Int].b = ((int)this.jdField_a_of_type_Long);
        ykq.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix end time : %d ", Integer.valueOf(this.jdField_a_of_type_Int));
      }
    }
    this.jdField_a_of_type_Yll.g();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yln
 * JD-Core Version:    0.7.0.1
 */