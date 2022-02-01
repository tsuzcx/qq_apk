import com.qq.jce.wup.UniAttribute;
import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class okr
  extends UniAttribute
{
  static HashMap<String, HashMap<String, byte[]>> cache__tempdata;
  static HashMap<String, byte[]> newCache__tempdata;
  protected RequestPacket _package = new RequestPacket();
  
  public okr()
  {
    this._package.iVersion = 2;
  }
  
  private void parseBufferV2()
  {
    JceInputStream localJceInputStream = new JceInputStream(this._package.sBuffer);
    localJceInputStream.setServerEncoding(this.encodeName);
    if (cache__tempdata == null)
    {
      cache__tempdata = new HashMap();
      HashMap localHashMap = new HashMap();
      localHashMap.put("", new byte[0]);
      cache__tempdata.put("", localHashMap);
    }
    this._data = localJceInputStream.readMap(cache__tempdata, 0, false);
    this.cachedClassName = new HashMap();
  }
  
  private void parseBufferV3()
  {
    JceInputStream localJceInputStream = new JceInputStream(this._package.sBuffer);
    localJceInputStream.setServerEncoding(this.encodeName);
    if (newCache__tempdata == null)
    {
      newCache__tempdata = new HashMap();
      newCache__tempdata.put("", new byte[0]);
    }
    this._newData = localJceInputStream.readMap(newCache__tempdata, 0, false);
  }
  
  public void decode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      this._package.readFrom(paramArrayOfByte);
      if (this._package.iVersion == 3)
      {
        parseBufferV3();
        return;
      }
      this._newData = null;
      parseBufferV2();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public void decodeVersion2(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      this._package.readFrom(paramArrayOfByte);
      parseBufferV2();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public void decodeVersion3(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      this._package.readFrom(paramArrayOfByte);
      parseBufferV3();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public byte[] encode()
  {
    if (this._package.iVersion == 2)
    {
      if ((this._package.sServantName == null) || (this._package.sServantName.equals(""))) {
        throw new IllegalArgumentException("servantName can not is null");
      }
      if ((this._package.sFuncName == null) || (this._package.sFuncName.equals(""))) {
        throw new IllegalArgumentException("funcName can not is null");
      }
    }
    else
    {
      if (this._package.sServantName == null) {
        this._package.sServantName = "";
      }
      if (this._package.sFuncName == null) {
        this._package.sFuncName = "";
      }
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    if ((this._package.iVersion != 2) && (this._package.iVersion != 1)) {
      ((JceOutputStream)localObject).write(this._newData, 0);
    }
    for (;;)
    {
      this._package.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
      localObject = new JceOutputStream(0);
      ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
      this._package.writeTo((JceOutputStream)localObject);
      localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
      int i = localObject.length;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
      localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
      return localByteBuffer.array();
      ((JceOutputStream)localObject).write(this._data, 0);
    }
  }
  
  public <T> void put(String paramString, T paramT)
  {
    if (paramString.startsWith(".")) {
      throw new IllegalArgumentException("put name can not startwith . , now is " + paramString);
    }
    super.put(paramString, paramT);
  }
  
  public void setFuncName(String paramString)
  {
    this._package.sFuncName = paramString;
  }
  
  public void setRequestId(int paramInt)
  {
    this._package.iRequestId = paramInt;
  }
  
  public void setServantName(String paramString)
  {
    this._package.sServantName = paramString;
  }
  
  public void uK(int paramInt)
  {
    this._package.iTimeout = paramInt;
  }
  
  public void useVersion3()
  {
    super.useVersion3();
    this._package.iVersion = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okr
 * JD-Core Version:    0.7.0.1
 */