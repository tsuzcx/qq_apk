import android.os.Handler;
import android.os.Looper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.DeviceFileModel.1.1;

public class agud
  extends szg
{
  agud(aguc paramaguc) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    FileManagerEntity localFileManagerEntity = this.a.c.b();
    if (localFileManagerEntity == null) {}
    while ((this.a.jdField_a_of_type_Aguk$d == null) || (paramSession.uSessionID != aguc.a(this.a))) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    this.a.jdField_a_of_type_Aguk$d.aO(paramFloat);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.a.c.b();
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      if ((this.a.jdField_a_of_type_Aguk$c != null) && (paramSession.uSessionID == aguc.b(this.a)) && (paramBoolean))
      {
        localFileManagerEntity.strThumbPath = paramSession.strFilePathSrc;
        this.a.jdField_a_of_type_Aguk$c.fP(String.valueOf(localFileManagerEntity.nSessionId), paramSession.strFilePathSrc);
      }
    } while ((this.a.jdField_a_of_type_Aguk$d == null) || (paramSession.uSessionID != aguc.a(this.a)));
    if (paramBoolean)
    {
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
      this.a.jdField_a_of_type_Aguk$d.djG();
      if (this.a.getFileType() == 2)
      {
        new Handler(Looper.getMainLooper()).postDelayed(new DeviceFileModel.1.1(this), 1000L);
        return;
      }
      this.a.jdField_a_of_type_Aguk$d.djG();
      return;
    }
    this.a.jdField_a_of_type_Aguk$d.djH();
  }
  
  public void c(Session paramSession)
  {
    if ((this.a.jdField_a_of_type_Aguk$d != null) && (paramSession.uSessionID == aguc.a(this.a))) {
      this.a.jdField_a_of_type_Aguk$d.djE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agud
 * JD-Core Version:    0.7.0.1
 */