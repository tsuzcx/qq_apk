class wtu
  implements xfc<Boolean, xfh>
{
  wtu(wts paramwts, long paramLong, int paramInt) {}
  
  public Void a(Boolean paramBoolean, xfh paramxfh)
  {
    if ((!paramBoolean.booleanValue()) || (paramxfh == null) || (paramxfh.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      wsv.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    wsv.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramxfh.jdField_a_of_type_Int));
    if (paramxfh.jdField_a_of_type_Int >= this.jdField_a_of_type_Wts.a.length)
    {
      wsv.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramxfh.jdField_a_of_type_Int) });
      return null;
    }
    wsv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramxfh.jdField_a_of_type_Int));
    this.jdField_a_of_type_Wts.a[paramxfh.jdField_a_of_type_Int] = wtv.a(this.jdField_a_of_type_Wts.a[paramxfh.jdField_a_of_type_Int], paramxfh.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Wts.a[paramxfh.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = paramxfh.jdField_a_of_type_JavaLangString;
    if (paramxfh.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Wts.a[paramxfh.jdField_a_of_type_Int].jdField_a_of_type_Int = ((int)paramxfh.jdField_a_of_type_Long / 1000);
      wsv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix start time : %d ", Integer.valueOf(this.jdField_a_of_type_Wts.a[paramxfh.jdField_a_of_type_Int].jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_Wts.a[paramxfh.jdField_a_of_type_Int].b <= 0) && (this.jdField_a_of_type_Wts.a.length == 1))
      {
        this.jdField_a_of_type_Wts.a[paramxfh.jdField_a_of_type_Int].b = ((int)this.jdField_a_of_type_Long);
        wsv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix end time : %d ", Integer.valueOf(this.jdField_a_of_type_Int));
      }
    }
    this.jdField_a_of_type_Wts.i();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wtu
 * JD-Core Version:    0.7.0.1
 */