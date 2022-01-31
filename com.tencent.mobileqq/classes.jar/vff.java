class vff
  implements vqn<Boolean, vqs>
{
  vff(vfd paramvfd, long paramLong, int paramInt) {}
  
  public Void a(Boolean paramBoolean, vqs paramvqs)
  {
    if ((!paramBoolean.booleanValue()) || (paramvqs == null) || (paramvqs.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      veg.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    veg.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramvqs.jdField_a_of_type_Int));
    if (paramvqs.jdField_a_of_type_Int >= this.jdField_a_of_type_Vfd.a.length)
    {
      veg.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramvqs.jdField_a_of_type_Int) });
      return null;
    }
    veg.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramvqs.jdField_a_of_type_Int));
    this.jdField_a_of_type_Vfd.a[paramvqs.jdField_a_of_type_Int] = vfg.a(this.jdField_a_of_type_Vfd.a[paramvqs.jdField_a_of_type_Int], paramvqs.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Vfd.a[paramvqs.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = paramvqs.jdField_a_of_type_JavaLangString;
    if (paramvqs.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Vfd.a[paramvqs.jdField_a_of_type_Int].jdField_a_of_type_Int = ((int)paramvqs.jdField_a_of_type_Long / 1000);
      veg.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix start time : %d ", Integer.valueOf(this.jdField_a_of_type_Vfd.a[paramvqs.jdField_a_of_type_Int].jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_Vfd.a[paramvqs.jdField_a_of_type_Int].b <= 0) && (this.jdField_a_of_type_Vfd.a.length == 1))
      {
        this.jdField_a_of_type_Vfd.a[paramvqs.jdField_a_of_type_Int].b = ((int)this.jdField_a_of_type_Long);
        veg.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix end time : %d ", Integer.valueOf(this.jdField_a_of_type_Int));
      }
    }
    this.jdField_a_of_type_Vfd.i();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vff
 * JD-Core Version:    0.7.0.1
 */