class usj
  implements vdr<Boolean, vdw>
{
  usj(ush paramush, long paramLong, int paramInt) {}
  
  public Void a(Boolean paramBoolean, vdw paramvdw)
  {
    if ((!paramBoolean.booleanValue()) || (paramvdw == null) || (paramvdw.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      urk.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    urk.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramvdw.jdField_a_of_type_Int));
    if (paramvdw.jdField_a_of_type_Int >= this.jdField_a_of_type_Ush.a.length)
    {
      urk.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramvdw.jdField_a_of_type_Int) });
      return null;
    }
    urk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramvdw.jdField_a_of_type_Int));
    this.jdField_a_of_type_Ush.a[paramvdw.jdField_a_of_type_Int] = usk.a(this.jdField_a_of_type_Ush.a[paramvdw.jdField_a_of_type_Int], paramvdw.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Ush.a[paramvdw.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = paramvdw.jdField_a_of_type_JavaLangString;
    if (paramvdw.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Ush.a[paramvdw.jdField_a_of_type_Int].jdField_a_of_type_Int = ((int)paramvdw.jdField_a_of_type_Long / 1000);
      urk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix start time : %d ", Integer.valueOf(this.jdField_a_of_type_Ush.a[paramvdw.jdField_a_of_type_Int].jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_Ush.a[paramvdw.jdField_a_of_type_Int].b <= 0) && (this.jdField_a_of_type_Ush.a.length == 1))
      {
        this.jdField_a_of_type_Ush.a[paramvdw.jdField_a_of_type_Int].b = ((int)this.jdField_a_of_type_Long);
        urk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix end time : %d ", Integer.valueOf(this.jdField_a_of_type_Int));
      }
    }
    this.jdField_a_of_type_Ush.i();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usj
 * JD-Core Version:    0.7.0.1
 */