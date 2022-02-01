import com.tencent.tim.filemanager.activity.recentfile.QfileRecentPicFileTabView;

public class atsg
  extends atsn
{
  public atsg(QfileRecentPicFileTabView paramQfileRecentPicFileTabView) {}
  
  protected void a(atwh paramatwh)
  {
    super.a(paramatwh);
    if ((paramatwh.filePath != null) && (paramatwh.filePath.length() > 0)) {
      this.this$0.refreshUI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atsg
 * JD-Core Version:    0.7.0.1
 */