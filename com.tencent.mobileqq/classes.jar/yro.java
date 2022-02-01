class yro
  implements zcw<Boolean, zdb>
{
  yro(yrm paramyrm, long paramLong, int paramInt) {}
  
  public Void a(Boolean paramBoolean, zdb paramzdb)
  {
    if ((!paramBoolean.booleanValue()) || (paramzdb == null) || (paramzdb.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      yqp.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    yqp.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramzdb.jdField_a_of_type_Int));
    if (paramzdb.jdField_a_of_type_Int >= this.jdField_a_of_type_Yrm.a.length)
    {
      yqp.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramzdb.jdField_a_of_type_Int) });
      return null;
    }
    yqp.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramzdb.jdField_a_of_type_Int));
    this.jdField_a_of_type_Yrm.a[paramzdb.jdField_a_of_type_Int] = yrp.a(this.jdField_a_of_type_Yrm.a[paramzdb.jdField_a_of_type_Int], paramzdb.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Yrm.a[paramzdb.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = paramzdb.jdField_a_of_type_JavaLangString;
    if (paramzdb.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Yrm.a[paramzdb.jdField_a_of_type_Int].jdField_a_of_type_Int = ((int)paramzdb.jdField_a_of_type_Long / 1000);
      yqp.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix start time : %d ", Integer.valueOf(this.jdField_a_of_type_Yrm.a[paramzdb.jdField_a_of_type_Int].jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_Yrm.a[paramzdb.jdField_a_of_type_Int].b <= 0) && (this.jdField_a_of_type_Yrm.a.length == 1))
      {
        this.jdField_a_of_type_Yrm.a[paramzdb.jdField_a_of_type_Int].b = ((int)this.jdField_a_of_type_Long);
        yqp.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix end time : %d ", Integer.valueOf(this.jdField_a_of_type_Int));
      }
    }
    this.jdField_a_of_type_Yrm.i();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yro
 * JD-Core Version:    0.7.0.1
 */