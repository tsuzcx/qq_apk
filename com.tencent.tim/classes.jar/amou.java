import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.cloudfile.CloudFileDirBrowserActivity;

public class amou
  implements ampx
{
  public atin a;
  private QQAppInterface app;
  public String keyword;
  
  public amou(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public void cR(View paramView)
  {
    amxk.a(this.keyword, 120, 0, paramView);
    if (this.a == null) {
      return;
    }
    paramView = (BaseActivity)paramView.getContext();
    FileInfo localFileInfo = aueh.a(this.a);
    localFileInfo.setPath("/" + localFileInfo.getName());
    Intent localIntent = new Intent(paramView, CloudFileDirBrowserActivity.class);
    localIntent.putExtra("key_file_info", localFileInfo);
    paramView.startActivity(localIntent);
  }
  
  public void cW(int paramInt1, int paramInt2) {}
  
  public CharSequence f()
  {
    if (this.a == null) {
      return null;
    }
    return auqb.bG(this.a.getSortTime());
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    return null;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    if (this.a == null) {
      return null;
    }
    return amxk.a(this.a.name.toLowerCase(), this.keyword);
  }
  
  public String getUin()
  {
    return "##foler##";
  }
  
  public int pE()
  {
    return 0;
  }
  
  public int pF()
  {
    return 0;
  }
  
  public int pG()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amou
 * JD-Core Version:    0.7.0.1
 */