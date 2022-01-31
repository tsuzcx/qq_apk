import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class vfo
  extends veb
{
  vfo(vez paramvez, StoryVideoItem paramStoryVideoItem, vgh paramvgh)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    String str = (String)a("result");
    xmh.a(str);
    xmh.a(this.jdField_a_of_type_Vgh.d);
    if (this.jdField_a_of_type_Vgh.d == null)
    {
      this.jdField_a_of_type_Vgh.d = "";
      wsv.c(this.b, "imageLocalPath is null", new Throwable());
    }
    a("DownloadPic2FileJob_iiu", str);
    a("DownloadPic2FileJob_isfp", this.jdField_a_of_type_Vgh.d);
    a("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.jdField_a_of_type_Vgh.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfo
 * JD-Core Version:    0.7.0.1
 */