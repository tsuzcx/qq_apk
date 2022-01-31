import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class tqw
  extends tpj
{
  tqw(tqh paramtqh, StoryVideoItem paramStoryVideoItem, trp paramtrp)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    String str = (String)a("result");
    vxp.a(str);
    vxp.a(this.jdField_a_of_type_Trp.d);
    if (this.jdField_a_of_type_Trp.d == null)
    {
      this.jdField_a_of_type_Trp.d = "";
      ved.c(this.b, "imageLocalPath is null", new Throwable());
    }
    a("DownloadPic2FileJob_iiu", str);
    a("DownloadPic2FileJob_isfp", this.jdField_a_of_type_Trp.d);
    a("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.jdField_a_of_type_Trp.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqw
 * JD-Core Version:    0.7.0.1
 */