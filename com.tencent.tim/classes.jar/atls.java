import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar;

class atls
  implements aths.a
{
  atls(atlo paramatlo) {}
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt1, int paramInt2, String paramString)
  {
    if (atlo.a(this.c) == paramFileManagerEntity)
    {
      paramInt1 = audx.fM(paramFileManagerEntity.uploadFile.uploadPath);
      QLog.d("testtest", 1, "onGetThumb is current entity");
      if (!aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {
        break label84;
      }
      QLog.d("testtest", 1, "setThumbPath strMiddleThumPath is " + paramFileManagerEntity.strMiddleThumPath);
      atlo.a(this.c).setThumbPath(paramFileManagerEntity.strMiddleThumPath, paramInt1);
    }
    label84:
    while (!aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) {
      return;
    }
    QLog.d("testtest", 1, "setThumbPath strLargeThumPath is " + paramFileManagerEntity.strLargeThumPath);
    atlo.a(this.c).setThumbPath(paramFileManagerEntity.strLargeThumPath, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atls
 * JD-Core Version:    0.7.0.1
 */