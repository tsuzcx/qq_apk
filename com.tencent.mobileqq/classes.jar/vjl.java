import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

class vjl
  extends vim
{
  vjl(vji paramvji, StoryVideoItem paramStoryVideoItem)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    Object localObject = (String)a("result");
    try
    {
      localObject = new URI((String)localObject);
      if ("file".equals(((URI)localObject).getScheme()))
      {
        localObject = new File((URI)localObject);
        if (((File)localObject).exists())
        {
          a("UploadImageJob_in_image_file_path", ((File)localObject).getAbsolutePath());
          return true;
        }
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      wxe.c(this.b, "Error: 保存投票失败", localURISyntaxException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vjl
 * JD-Core Version:    0.7.0.1
 */