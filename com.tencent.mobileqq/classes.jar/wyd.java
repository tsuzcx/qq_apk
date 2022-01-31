class wyd
  implements xjl<Boolean, xjq>
{
  wyd(wyb paramwyb, long paramLong, int paramInt) {}
  
  public Void a(Boolean paramBoolean, xjq paramxjq)
  {
    if ((!paramBoolean.booleanValue()) || (paramxjq == null) || (paramxjq.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      wxe.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    wxe.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramxjq.jdField_a_of_type_Int));
    if (paramxjq.jdField_a_of_type_Int >= this.jdField_a_of_type_Wyb.a.length)
    {
      wxe.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramxjq.jdField_a_of_type_Int) });
      return null;
    }
    wxe.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramxjq.jdField_a_of_type_Int));
    this.jdField_a_of_type_Wyb.a[paramxjq.jdField_a_of_type_Int] = wye.a(this.jdField_a_of_type_Wyb.a[paramxjq.jdField_a_of_type_Int], paramxjq.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Wyb.a[paramxjq.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = paramxjq.jdField_a_of_type_JavaLangString;
    if (paramxjq.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Wyb.a[paramxjq.jdField_a_of_type_Int].jdField_a_of_type_Int = ((int)paramxjq.jdField_a_of_type_Long / 1000);
      wxe.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix start time : %d ", Integer.valueOf(this.jdField_a_of_type_Wyb.a[paramxjq.jdField_a_of_type_Int].jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_Wyb.a[paramxjq.jdField_a_of_type_Int].b <= 0) && (this.jdField_a_of_type_Wyb.a.length == 1))
      {
        this.jdField_a_of_type_Wyb.a[paramxjq.jdField_a_of_type_Int].b = ((int)this.jdField_a_of_type_Long);
        wxe.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix end time : %d ", Integer.valueOf(this.jdField_a_of_type_Int));
      }
    }
    this.jdField_a_of_type_Wyb.i();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wyd
 * JD-Core Version:    0.7.0.1
 */