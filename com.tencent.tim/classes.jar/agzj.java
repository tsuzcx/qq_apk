import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class agzj
{
  private agzk jdField_a_of_type_Agzk;
  private agzl jdField_a_of_type_Agzl;
  private QQAppInterface mApp;
  public ChatMessage v;
  
  public agzj(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.mApp = paramQQAppInterface;
    this.v = paramChatMessage;
    this.jdField_a_of_type_Agzk = agzk.a(paramQQAppInterface, paramChatMessage);
  }
  
  public agzi a()
  {
    if (this.jdField_a_of_type_Agzk != null) {
      return this.jdField_a_of_type_Agzk.a();
    }
    return null;
  }
  
  public void a(agzl paramagzl)
  {
    this.jdField_a_of_type_Agzl = paramagzl;
    if (this.jdField_a_of_type_Agzk != null) {
      this.jdField_a_of_type_Agzk.b(this.jdField_a_of_type_Agzl);
    }
  }
  
  public void a(String paramString, agzj.a parama)
  {
    if (!aqhq.fileExistsAndNotEmpty(paramString))
    {
      if (parama != null) {
        parama.onError(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, parama));
  }
  
  public boolean amI()
  {
    if (this.jdField_a_of_type_Agzk != null) {
      this.jdField_a_of_type_Agzk.amH();
    }
    return false;
  }
  
  public boolean checkFileExist()
  {
    return aqhq.fileExistsAndNotEmpty(vX());
  }
  
  public void dkP()
  {
    if (this.jdField_a_of_type_Agzk != null) {}
    for (boolean bool = this.jdField_a_of_type_Agzk.cu();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
        if (this.jdField_a_of_type_Agzl != null) {
          this.jdField_a_of_type_Agzl.Ke(false);
        }
      }
      return;
    }
  }
  
  public void dkQ()
  {
    if (this.jdField_a_of_type_Agzk != null) {}
    for (boolean bool = this.jdField_a_of_type_Agzk.amG();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
        if (this.jdField_a_of_type_Agzl != null) {
          this.jdField_a_of_type_Agzl.Kf(false);
        }
      }
      return;
    }
  }
  
  public long gb()
  {
    if (this.jdField_a_of_type_Agzk != null) {
      return this.jdField_a_of_type_Agzk.getFileSize();
    }
    return 0L;
  }
  
  public String vW()
  {
    if (this.jdField_a_of_type_Agzk != null) {
      return this.jdField_a_of_type_Agzk.vV();
    }
    return "";
  }
  
  public String vX()
  {
    String str = "";
    if (this.jdField_a_of_type_Agzk != null) {
      str = this.jdField_a_of_type_Agzk.getLocalFilePath();
    }
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void onError(int paramInt, String paramString);
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agzj
 * JD-Core Version:    0.7.0.1
 */