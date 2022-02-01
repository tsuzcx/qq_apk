import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class afqy
{
  public static AbstractGifImage a(File paramFile, int paramInt, boolean paramBoolean)
  {
    try
    {
      if (NativeGifFactory.isUseNewGif()) {
        return new afra(paramFile, paramInt, paramBoolean);
      }
      paramFile = new afqz(paramFile, paramInt, paramBoolean);
      return paramFile;
    }
    catch (IOException paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VoiceGifFactory", 2, "getVoiceGifObject exception. msg:" + paramFile.getMessage());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqy
 * JD-Core Version:    0.7.0.1
 */