class vfc
  implements vqk<Boolean, vqp>
{
  vfc(vfa paramvfa, long paramLong, int paramInt) {}
  
  public Void a(Boolean paramBoolean, vqp paramvqp)
  {
    if ((!paramBoolean.booleanValue()) || (paramvqp == null) || (paramvqp.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      ved.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    ved.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramvqp.jdField_a_of_type_Int));
    if (paramvqp.jdField_a_of_type_Int >= this.jdField_a_of_type_Vfa.a.length)
    {
      ved.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramvqp.jdField_a_of_type_Int) });
      return null;
    }
    ved.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramvqp.jdField_a_of_type_Int));
    this.jdField_a_of_type_Vfa.a[paramvqp.jdField_a_of_type_Int] = vfd.a(this.jdField_a_of_type_Vfa.a[paramvqp.jdField_a_of_type_Int], paramvqp.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Vfa.a[paramvqp.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = paramvqp.jdField_a_of_type_JavaLangString;
    if (paramvqp.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Vfa.a[paramvqp.jdField_a_of_type_Int].jdField_a_of_type_Int = ((int)paramvqp.jdField_a_of_type_Long / 1000);
      ved.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix start time : %d ", Integer.valueOf(this.jdField_a_of_type_Vfa.a[paramvqp.jdField_a_of_type_Int].jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_Vfa.a[paramvqp.jdField_a_of_type_Int].b <= 0) && (this.jdField_a_of_type_Vfa.a.length == 1))
      {
        this.jdField_a_of_type_Vfa.a[paramvqp.jdField_a_of_type_Int].b = ((int)this.jdField_a_of_type_Long);
        ved.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix end time : %d ", Integer.valueOf(this.jdField_a_of_type_Int));
      }
    }
    this.jdField_a_of_type_Vfa.i();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfc
 * JD-Core Version:    0.7.0.1
 */