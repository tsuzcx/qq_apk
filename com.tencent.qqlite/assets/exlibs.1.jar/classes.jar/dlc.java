import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class dlc
  implements Runnable
{
  public dlc(QfileLocalFileOtherTabView paramQfileLocalFileOtherTabView) {}
  
  public void run()
  {
    Object localObject2 = AppConstants.ay;
    Object localObject1 = new HashMap();
    FileCategoryUtil.a((String)localObject2, "", ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|.swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4a|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.apk|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject1, null);
    FileCategoryUtil.a((Map)localObject1);
    localObject2 = new LinkedHashMap();
    ((LinkedHashMap)localObject2).put("压缩文件", new ArrayList());
    ((LinkedHashMap)localObject2).put("电子书", new ArrayList());
    ((LinkedHashMap)localObject2).put("更多", new ArrayList());
    Iterator localIterator = ((HashMap)localObject1).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((List)((LinkedHashMap)localObject2).get(this.a.a(str))).addAll((Collection)((HashMap)localObject1).get(str));
    }
    localObject1 = ((LinkedHashMap)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((List)((LinkedHashMap)localObject2).get((String)((Iterator)localObject1).next())).size() == 0) {
        ((Iterator)localObject1).remove();
      }
    }
    QfileLocalFileOtherTabView.a(this.a, new dld(this, (LinkedHashMap)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dlc
 * JD-Core Version:    0.7.0.1
 */