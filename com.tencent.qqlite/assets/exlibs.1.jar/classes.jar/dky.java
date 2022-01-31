import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.HashMap;

public class dky
  implements Runnable
{
  public dky(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView) {}
  
  public void run()
  {
    HashMap localHashMap1 = new HashMap();
    FileCategoryUtil.a(AppConstants.ay, ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap1, null);
    FileCategoryUtil.a(localHashMap1);
    HashMap localHashMap2 = new HashMap();
    FileCategoryUtil.a(AppConstants.ay, ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4a|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap2, null);
    FileCategoryUtil.a(localHashMap2);
    QfileLocalFileMediaTabView.a(this.a, new dkz(this, localHashMap1, localHashMap2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dky
 * JD-Core Version:    0.7.0.1
 */