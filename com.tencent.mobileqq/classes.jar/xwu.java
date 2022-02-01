class xwu
  implements yhr<Boolean, yhw>
{
  xwu(xws paramxws, long paramLong, int paramInt) {}
  
  public Void a(Boolean paramBoolean, yhw paramyhw)
  {
    if ((!paramBoolean.booleanValue()) || (paramyhw == null) || (paramyhw.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      xvv.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    xvv.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramyhw.jdField_a_of_type_Int));
    if (paramyhw.jdField_a_of_type_Int >= this.jdField_a_of_type_Xws.a.length)
    {
      xvv.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramyhw.jdField_a_of_type_Int) });
      return null;
    }
    xvv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramyhw.jdField_a_of_type_Int));
    this.jdField_a_of_type_Xws.a[paramyhw.jdField_a_of_type_Int] = xwv.a(this.jdField_a_of_type_Xws.a[paramyhw.jdField_a_of_type_Int], paramyhw.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Xws.a[paramyhw.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = paramyhw.jdField_a_of_type_JavaLangString;
    if (paramyhw.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Xws.a[paramyhw.jdField_a_of_type_Int].jdField_a_of_type_Int = ((int)paramyhw.jdField_a_of_type_Long / 1000);
      xvv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix start time : %d ", Integer.valueOf(this.jdField_a_of_type_Xws.a[paramyhw.jdField_a_of_type_Int].jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_Xws.a[paramyhw.jdField_a_of_type_Int].b <= 0) && (this.jdField_a_of_type_Xws.a.length == 1))
      {
        this.jdField_a_of_type_Xws.a[paramyhw.jdField_a_of_type_Int].b = ((int)this.jdField_a_of_type_Long);
        xvv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix end time : %d ", Integer.valueOf(this.jdField_a_of_type_Int));
      }
    }
    this.jdField_a_of_type_Xws.g();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwu
 * JD-Core Version:    0.7.0.1
 */