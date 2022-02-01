import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class agyv
  implements armm.a
{
  agyv(agys paramagys, List paramList, aghw paramaghw, agyx paramagyx) {}
  
  public void callback(int paramInt)
  {
    if (paramInt == 2)
    {
      ahao.JG(agys.a(this.this$0).getString(2131694101));
      localIterator = this.val$fileList.iterator();
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          if (aqhq.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
            this.jdField_a_of_type_Aghw.a(localFileManagerEntity.getFilePath(), "", agys.a(this.this$0).getCurrentAccountUin(), 0, false);
          } else {
            this.jdField_a_of_type_Aghw.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
          }
        }
      }
      if (this.jdField_a_of_type_Agyx != null) {
        this.jdField_a_of_type_Agyx.gg(4, 0);
      }
    }
    while (this.jdField_a_of_type_Agyx == null)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      return;
    }
    this.jdField_a_of_type_Agyx.gg(4, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyv
 * JD-Core Version:    0.7.0.1
 */