import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class qcx
  extends qbk
{
  qcx(qci paramqci, StoryVideoItem paramStoryVideoItem, qdn paramqdn)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean Jq()
  {
    String str = (String)k("result");
    rom.sF(str);
    rom.sF(this.a.awU);
    if (this.a.awU == null)
    {
      this.a.awU = "";
      ram.e(this.TAG, "imageLocalPath is null", new Throwable());
    }
    p("DownloadPic2FileJob_iiu", str);
    p("DownloadPic2FileJob_isfp", this.a.awU);
    p("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.a.aCS));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qcx
 * JD-Core Version:    0.7.0.1
 */