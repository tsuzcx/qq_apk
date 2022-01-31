package oicq.wlogin_sdk.tools;

import android.content.Context;

public class EcdhCrypt
{
  public static final String DEFAULT_PUB_KEY = "020b03cf3d99541f29ffec281bebbd4ea211292ac1f53d7128";
  public static final String DEFAULT_SHARE_KEY = "4da0f614fc9f29c2054c77048a6566d7";
  private static final String S_PUB_KEY = "04928D8850673088B343264E0C6BACB8496D697799F37211DEB25BB73906CB089FEA9639B4E0260498B51A992D50813DA8";
  private byte[] _c_pub_key = new byte[0];
  private byte[] _g_share_key = new byte[0];
  
  public EcdhCrypt(Context paramContext)
  {
    util.loadLibrary("wtecdh", paramContext);
  }
  
  public native int GenECDHKey(String paramString);
  
  public int GenereateKey()
  {
    try
    {
      int i = GenECDHKey("04928D8850673088B343264E0C6BACB8496D697799F37211DEB25BB73906CB089FEA9639B4E0260498B51A992D50813DA8");
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return -1;
  }
  
  public byte[] get_c_pub_key()
  {
    return this._c_pub_key;
  }
  
  public byte[] get_g_share_key()
  {
    return this._g_share_key;
  }
  
  public void set_c_pub_key(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this._c_pub_key = ((byte[])paramArrayOfByte.clone());
      return;
    }
    this._c_pub_key = new byte[0];
  }
  
  public void set_g_share_key(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this._g_share_key = ((byte[])paramArrayOfByte.clone());
      return;
    }
    this._g_share_key = new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.EcdhCrypt
 * JD-Core Version:    0.7.0.1
 */