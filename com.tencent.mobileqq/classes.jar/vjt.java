import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class vjt
  extends vim
{
  vjt(vji paramvji, StoryVideoItem paramStoryVideoItem, vkq paramvkq)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    String str = (String)a("result");
    xqq.a(str);
    xqq.a(this.jdField_a_of_type_Vkq.d);
    if (this.jdField_a_of_type_Vkq.d == null)
    {
      this.jdField_a_of_type_Vkq.d = "";
      wxe.c(this.b, "imageLocalPath is null", new Throwable());
    }
    a("DownloadPic2FileJob_iiu", str);
    a("DownloadPic2FileJob_isfp", this.jdField_a_of_type_Vkq.d);
    a("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.jdField_a_of_type_Vkq.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vjt
 * JD-Core Version:    0.7.0.1
 */