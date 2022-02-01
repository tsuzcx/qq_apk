import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;

public class achx
  implements acch.a
{
  private List<String> xC = new ArrayList();
  
  public List<String> a(AppInterface paramAppInterface)
  {
    if (this.xC.isEmpty()) {
      this.xC.add("100077");
    }
    if (((paramAppInterface instanceof QQAppInterface)) && (QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameEnable", 1) == 1)) {
      return this.xC;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     achx
 * JD-Core Version:    0.7.0.1
 */