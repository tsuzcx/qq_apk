package com.tencent.TMG.ptt;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

class TokenFetcher$1
  implements TokenFetcher.HttpRequestListener
{
  TokenFetcher$1(TokenFetcher paramTokenFetcher) {}
  
  public void onCompleted(int paramInt, String paramString, Object paramObject)
  {
    if (!(paramObject instanceof TokenFetcher.GetUploadTokenListener)) {
      return;
    }
    TokenFetcher.GetUploadTokenListener localGetUploadTokenListener = (TokenFetcher.GetUploadTokenListener)paramObject;
    paramObject = "";
    Object localObject;
    if ((paramInt != 0) || (TextUtils.isEmpty(paramString)))
    {
      Log.e("TokenFetcher", String.format("mUploadTokenListener|http error code=%d", new Object[] { Integer.valueOf(0) }));
      paramInt = 8196;
      paramString = null;
      if (paramString != null) {
        break label267;
      }
      localObject = "";
      label64:
      if (paramString != null) {
        break label276;
      }
    }
    label267:
    label276:
    for (String str2 = "";; str2 = paramString.upload_url)
    {
      for (;;)
      {
        Log.d("TokenFetcher", String.format("mUploadTokenListener|errCode=%d, errInfo=%s, token=%s, url=%s", new Object[] { Integer.valueOf(paramInt), paramObject, localObject, str2 }));
        localGetUploadTokenListener.onCompleted(paramInt, paramObject, paramString);
        return;
        try
        {
          localObject = new JSONObject(paramString);
          paramInt = ((JSONObject)localObject).getInt("ErrorCode");
          if (paramInt != 0)
          {
            paramObject = ((JSONObject)localObject).getString("ErrorInfo");
            Log.e("TokenFetcher", String.format("mUploadTokenListener|errCode=%d, errInfo=%s", new Object[] { Integer.valueOf(paramInt), paramObject }));
            if (paramInt == 70001) {
              break label285;
            }
            if (paramInt != 70347) {
              break label294;
            }
            break label285;
          }
          str2 = ((JSONObject)localObject).getString("upload_token");
          localObject = new TokenFetcher.UploadInfo(((JSONObject)localObject).getString("upload_url"), str2);
          paramString = (String)localObject;
        }
        catch (JSONException localJSONException)
        {
          paramInt = 8198;
          paramObject = "decode resp json fail.";
          Log.e("TokenFetcher", "mUploadTokenListener|decode resp json fail. resp=" + paramString);
          localJSONException.printStackTrace();
          paramString = null;
        }
      }
      break;
      String str1 = paramString.token;
      break label64;
    }
    label285:
    label294:
    for (paramInt = 8199;; paramInt = 8194)
    {
      paramString = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.TokenFetcher.1
 * JD-Core Version:    0.7.0.1
 */