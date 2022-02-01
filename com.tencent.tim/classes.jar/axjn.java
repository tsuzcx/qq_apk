import com.tencent.weseevideo.model.MediaModel;
import dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable;

public class axjn
{
  public MediaModel a;
  public AEEditorGenerateRunnable a;
  public long aCh;
  public long aCi;
  public int errorCode;
  public String missionID;
  public String outputPath;
  public String path;
  public float progress;
  public String sourcePath;
  public String status;
  public String thumbPath;
  
  public axjn(String paramString1, String paramString2, String paramString3, String paramString4, MediaModel paramMediaModel)
  {
    this.sourcePath = paramString2;
    this.outputPath = paramString3;
    this.missionID = paramString1;
    this.thumbPath = paramString4;
    this.a = paramMediaModel;
    this.status = "AEEDITOR_GENERATE_STATUS_WAIT";
    this.errorCode = 0;
    this.aCh = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjn
 * JD-Core Version:    0.7.0.1
 */