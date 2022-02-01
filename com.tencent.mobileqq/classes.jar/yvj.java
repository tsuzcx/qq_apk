class yvj
  implements zgr<Boolean, zgw>
{
  yvj(yvh paramyvh, long paramLong, int paramInt) {}
  
  public Void a(Boolean paramBoolean, zgw paramzgw)
  {
    if ((!paramBoolean.booleanValue()) || (paramzgw == null) || (paramzgw.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      yuk.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    yuk.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramzgw.jdField_a_of_type_Int));
    if (paramzgw.jdField_a_of_type_Int >= this.jdField_a_of_type_Yvh.a.length)
    {
      yuk.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramzgw.jdField_a_of_type_Int) });
      return null;
    }
    yuk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramzgw.jdField_a_of_type_Int));
    this.jdField_a_of_type_Yvh.a[paramzgw.jdField_a_of_type_Int] = yvk.a(this.jdField_a_of_type_Yvh.a[paramzgw.jdField_a_of_type_Int], paramzgw.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Yvh.a[paramzgw.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = paramzgw.jdField_a_of_type_JavaLangString;
    if (paramzgw.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Yvh.a[paramzgw.jdField_a_of_type_Int].jdField_a_of_type_Int = ((int)paramzgw.jdField_a_of_type_Long / 1000);
      yuk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix start time : %d ", Integer.valueOf(this.jdField_a_of_type_Yvh.a[paramzgw.jdField_a_of_type_Int].jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_Yvh.a[paramzgw.jdField_a_of_type_Int].b <= 0) && (this.jdField_a_of_type_Yvh.a.length == 1))
      {
        this.jdField_a_of_type_Yvh.a[paramzgw.jdField_a_of_type_Int].b = ((int)this.jdField_a_of_type_Long);
        yuk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix end time : %d ", Integer.valueOf(this.jdField_a_of_type_Int));
      }
    }
    this.jdField_a_of_type_Yvh.i();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvj
 * JD-Core Version:    0.7.0.1
 */