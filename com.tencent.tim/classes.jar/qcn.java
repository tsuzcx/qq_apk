import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

class qcn
  extends qbk
{
  qcn(qci paramqci, StoryVideoItem paramStoryVideoItem)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean Jq()
  {
    Object localObject = (String)k("result");
    try
    {
      localObject = new URI((String)localObject);
      if ("file".equals(((URI)localObject).getScheme()))
      {
        localObject = new File((URI)localObject);
        if (((File)localObject).exists())
        {
          p("UploadImageJob_in_image_file_path", ((File)localObject).getAbsolutePath());
          return true;
        }
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      ram.e(this.TAG, "Error: 评分投票失败", localURISyntaxException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qcn
 * JD-Core Version:    0.7.0.1
 */