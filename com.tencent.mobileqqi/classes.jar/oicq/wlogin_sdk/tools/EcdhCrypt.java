package oicq.wlogin_sdk.tools;

import android.content.Context;

public class EcdhCrypt
{
  public static final String DEFAULT_PUB_KEY = "020b03cf3d99541f29ffec281bebbd4ea211292ac1f53d7128";
  public static final String DEFAULT_SHARE_KEY = "4da0f614fc9f29c2054c77048a6566d7";
  private static final String S_PUB_KEY = "04928D8850673088B343264E0C6BACB8496D697799F37211DEB25BB73906CB089FEA9639B4E0260498B51A992D50813DA8";
  public static final String X509_S_PUB_KEY = "3046301006072A8648CE3D020106052B8104001F03320004928D8850673088B343264E0C6BACB8496D697799F37211DEB25BB73906CB089FEA9639B4E0260498B51A992D50813DA8";
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
      try
      {
        int i = GenECDHKey("04928D8850673088B343264E0C6BACB8496D697799F37211DEB25BB73906CB089FEA9639B4E0260498B51A992D50813DA8");
        return i;
      }
      finally {}
      return -1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      util.LOGW("OpenSSL generate key failed, turn another method " + localUnsatisfiedLinkError.getMessage(), "");
      return -1;
    }
    catch (RuntimeException localRuntimeException)
    {
      util.LOGW("OpenSSL generate key failed, turn another method " + localRuntimeException.getMessage(), "");
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.EcdhCrypt
 * JD-Core Version:    0.7.0.1
 */