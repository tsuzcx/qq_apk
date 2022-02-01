import org.json.JSONException;
import org.json.JSONObject;

class tkr
  implements tkm
{
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    if (paramtjs != null) {}
    for (paramVarArgs = paramtjs.getActivity(); (paramtjs == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      tkw.e("GdtNetTypeJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("netType", tky.getType(paramVarArgs));
      try
      {
        paramtjs.callJs(paramString, new String[] { localJSONObject.toString() });
        return true;
      }
      catch (Throwable paramtjs)
      {
        tkw.e("GdtNetTypeJsCallHandler", "handleJsCallRequest error", paramtjs);
        return true;
      }
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        tkw.e("GdtNetTypeJsCallHandler", "handleJsCallRequest error", paramVarArgs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkr
 * JD-Core Version:    0.7.0.1
 */