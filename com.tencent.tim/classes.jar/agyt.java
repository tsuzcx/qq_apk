import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class agyt
  implements ahal.a
{
  agyt(agys paramagys, List paramList, aghw paramaghw, agyx paramagyx) {}
  
  public void aD()
  {
    Iterator localIterator = this.val$fileList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.jdField_a_of_type_Aghw.l(localFileManagerEntity);
      }
    }
    if (this.jdField_a_of_type_Agyx != null) {
      this.jdField_a_of_type_Agyx.gg(1, 0);
    }
  }
  
  public void aE()
  {
    if (this.jdField_a_of_type_Agyx != null) {
      this.jdField_a_of_type_Agyx.gg(1, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyt
 * JD-Core Version:    0.7.0.1
 */