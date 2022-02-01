import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tim.mvp.cloudfile.CloudFileTeamWorkCreatePresenter.1;

public class auhl
  extends auip
{
  atgd a;
  private byte[] cA;
  private int docType;
  private long taskId;
  private String type;
  
  public auhl(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, auhk.b paramb)
  {
    super(paramInt, paramQQAppInterface, paramContext, paramb);
    this.jdField_a_of_type_Atgd = new auhm(this);
    aaI(paramInt);
  }
  
  private void aaI(int paramInt)
  {
    if (paramInt == 4)
    {
      this.type = "doc";
      this.docType = 1;
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        this.type = "sheet";
        this.docType = 2;
        return;
      }
      if (paramInt == 6)
      {
        this.type = "form";
        this.docType = 3;
        return;
      }
    } while (paramInt != 7);
    this.type = "slides";
    this.docType = 4;
  }
  
  public void euV()
  {
    this.taskId = 0L;
    String str = this.jdField_a_of_type_Auhk$b.getInputValue();
    this.jdField_a_of_type_Auhk$b.dismiss();
    this.jdField_a_of_type_Auhk$b.showLoading();
    ThreadManager.executeOnNetWorkThread(new CloudFileTeamWorkCreatePresenter.1(this, str));
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.app.addObserver(this.jdField_a_of_type_Atgd);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Atgd);
  }
  
  public void setBundle(Bundle paramBundle)
  {
    super.setBundle(paramBundle);
    this.cA = paramBundle.getByteArray("key_parent_dir_key");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhl
 * JD-Core Version:    0.7.0.1
 */