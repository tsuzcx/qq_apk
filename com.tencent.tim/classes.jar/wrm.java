import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import java.io.OutputStream;
import msg.aio_doodle.DoodleMsgProto.DoodleData;
import msg.aio_doodle.DoodleMsgProto.DoodleHeader;

public class wrm
  implements wre.a
{
  public wrm(DoodlePanel paramDoodlePanel, OutputStream paramOutputStream) {}
  
  public boolean a(DoodleMsgProto.DoodleData paramDoodleData)
  {
    if (paramDoodleData == null) {
      return false;
    }
    paramDoodleData = paramDoodleData.toByteArray();
    byte[] arrayOfByte = wre.intToBytes(paramDoodleData.length);
    try
    {
      this.val$out.write(arrayOfByte);
      this.val$out.write(paramDoodleData);
      label33:
      return true;
    }
    catch (Exception paramDoodleData)
    {
      break label33;
    }
  }
  
  public boolean a(DoodleMsgProto.DoodleHeader paramDoodleHeader)
  {
    if (paramDoodleHeader == null) {
      return false;
    }
    paramDoodleHeader = paramDoodleHeader.toByteArray();
    byte[] arrayOfByte = wre.intToBytes(paramDoodleHeader.length);
    try
    {
      this.val$out.write(arrayOfByte);
      this.val$out.write(paramDoodleHeader);
      label33:
      return true;
    }
    catch (Exception paramDoodleHeader)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrm
 * JD-Core Version:    0.7.0.1
 */