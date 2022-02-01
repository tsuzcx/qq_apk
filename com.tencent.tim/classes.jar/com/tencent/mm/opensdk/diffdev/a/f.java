package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

final class f
  extends AsyncTask<Void, Void, a>
{
  private OAuthListener k;
  private String n;
  private int t;
  private String url;
  
  public f(String paramString, OAuthListener paramOAuthListener)
  {
    this.n = paramString;
    this.k = paramOAuthListener;
    this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[] { paramString });
  }
  
  static final class a
  {
    public OAuthErrCode m;
    public String u;
    public int v;
    
    public static a b(byte[] paramArrayOfByte)
    {
      a locala = new a();
      Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
        locala.m = OAuthErrCode.WechatAuth_Err_NetworkErr;
        return locala;
      }
      for (;;)
      {
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
          try
          {
            paramArrayOfByte = new JSONObject(paramArrayOfByte);
            locala.v = paramArrayOfByte.getInt("wx_errcode");
            Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[] { Integer.valueOf(locala.v) }));
            switch (locala.v)
            {
            case 405: 
              locala.m = OAuthErrCode.WechatAuth_Err_NormalErr;
              return locala;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            Log.e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
            locala.m = OAuthErrCode.WechatAuth_Err_NormalErr;
            return locala;
          }
          locala.m = OAuthErrCode.WechatAuth_Err_OK;
        }
        catch (Exception paramArrayOfByte)
        {
          Log.e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
          locala.m = OAuthErrCode.WechatAuth_Err_NormalErr;
          return locala;
        }
        locala.u = paramArrayOfByte.getString("wx_code");
        return locala;
        locala.m = OAuthErrCode.WechatAuth_Err_OK;
        return locala;
        locala.m = OAuthErrCode.WechatAuth_Err_OK;
        return locala;
        locala.m = OAuthErrCode.WechatAuth_Err_Timeout;
        return locala;
        locala.m = OAuthErrCode.WechatAuth_Err_Cancel;
        return locala;
        locala.m = OAuthErrCode.WechatAuth_Err_NormalErr;
        return locala;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.f
 * JD-Core Version:    0.7.0.1
 */