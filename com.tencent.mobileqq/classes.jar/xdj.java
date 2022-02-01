import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class xdj
  extends xbw
{
  xdj(xcu paramxcu, StoryVideoItem paramStoryVideoItem, xec paramxec)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    String str = (String)a("result");
    zkb.a(str);
    zkb.a(this.jdField_a_of_type_Xec.d);
    if (this.jdField_a_of_type_Xec.d == null)
    {
      this.jdField_a_of_type_Xec.d = "";
      yqp.c(this.b, "imageLocalPath is null", new Throwable());
    }
    a("DownloadPic2FileJob_iiu", str);
    a("DownloadPic2FileJob_isfp", this.jdField_a_of_type_Xec.d);
    a("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.jdField_a_of_type_Xec.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdj
 * JD-Core Version:    0.7.0.1
 */